"""Prep / cook minutes from the method text and ingredient count.

Durations come from the StepTimers port. A step's durations count as:
  - passive prep when the step is about marinating, soaking, chilling, resting, proving or cooling
    (matches the pilot rule "prep includes the marinade");
  - cook time otherwise (simmer, bake, roast, fry, boil, ...).
Only the longest duration per step counts, so "fry 2 mins, then 3 mins more" isn't double-counted
as two steps' worth but "bake 20 mins" + "rest 10 mins" in different steps both count.
Active prep is estimated: 5 min + 1.5 min per ingredient + 2 min per chopping verb.
"""
from __future__ import annotations

import math
import re

from ..tags import Proposal
from ..timers import find_seconds

PASSIVE = re.compile(r"marinat|soak|chill|refrigerat|fridge|freez|\brest(?:ing)?\b|\bprove\b|(?<![-\w])proof(?:ing)?\b|"
                     r"\bleave to rise|\b(?:let|allow)(?: it)? (?:to )?rise|"
                     r"leave (?:it |them )?to (?:stand|cool|set|infuse)|set aside for|cool (?:completely|for)|"
                     r"stand for|overnight|infuse|steep", re.I)
HEAT = re.compile(r"simmer|bake|roast|fry|boil|grill|cook|braise|stew|steam|saut|sear|toast|heat|"
                  r"microwave|poach|broil|barbecue|bbq|smoke|reduce|brown", re.I)
CHOP = re.compile(r"\b(chop|dice|slice|mince|grate|peel|julienne|shred|crush|trim|deseed|zest|"
                  r"cube|halve|quarter|core|pit|score|butterfly|fillet|debone|knead|roll out)\w*", re.I)
OVERNIGHT = re.compile(r"overnight", re.I)


MIN_SECONDS = 30
MAX_PASSIVE = 12 * 60  # longer "waits" are storage notes, not part of making the dish
_OPTIONAL = re.compile(r"\b(?:or |for |and )?up to (?:a |an |\d)[^,.;)]*|\b(?:will )?keeps? (?:well )?(?:in [^,.;]* )?for [^,.;]*|"
                       r"\bfreeze[^,.;]* for [^,.;]*|\bmake[^,.;]* (?:a day|\d+ (?:days?|hours?|hrs?)) ahead[^,.;]*", re.I)


def _round5(minutes: float) -> int:
    return int(5 * round(minutes / 5))


def _ceil5(minutes: float) -> int:
    return int(5 * math.ceil(minutes / 5))


_CLAUSE = re.compile(r"(?<=[.;!?])\s+|,\s*(?:then|and then)\s+|\bthen\b", re.I)


def split_time(steps: list[str]) -> tuple[float, float, int]:
    """(passive minutes, cook minutes, timed steps). Each clause's longest duration is classified
    by its own verbs, so "marinate for 1 hour, then fry for 5 minutes" is 60 passive + 5 cook."""
    passive = cook = 0.0
    timed_steps = 0
    for step in steps:
        step = _OPTIONAL.sub("", step)  # "chill for 2 hrs, or up to 24 hrs": the 24 is optional
        step_timed = False
        step_has_duration = any(s >= MIN_SECONDS for s in find_seconds(step))
        for clause in _CLAUSE.split(step):
            if not clause:
                continue
            secs = [s for s in find_seconds(clause) if s >= MIN_SECONDS]  # "a second time" isn't 1 s
            longest = max(secs) / 60 if secs else 0.0
            if not longest and not step_has_duration and OVERNIGHT.search(clause):
                longest = 8 * 60  # "overnight" only counts when the step gives no explicit duration
            if not longest:
                continue
            step_timed = True
            if PASSIVE.search(clause) and not HEAT.search(clause):
                passive += longest
            else:
                cook += longest
        timed_steps += step_timed
    return min(passive, MAX_PASSIVE), cook, timed_steps


def propose(steps: list[str], ingredient_count: int, category: str) -> dict[str, Proposal]:
    passive, cook, timed_steps = split_time(steps)
    chops = sum(len(CHOP.findall(s)) for s in steps)
    active = 5 + 1.5 * ingredient_count + 2 * min(chops, 10)
    prep = _round5(active + passive)
    if cook > 0:
        cook_p = Proposal(_ceil5(cook), 0.75, f"durations in {timed_steps} step(s)")
    else:
        guess = {"Dessert": 30, "Side": 20, "Starter": 15, "Breakfast": 15}.get(category, 30)
        cook_p = Proposal(guess, 0.3, f"no durations in the method; {category or 'default'} guess")
    prep_reason = f"{ingredient_count} ingredients, {chops} prep verbs" + (f", {round(passive)} min passive" if passive else "")
    return {"prepMinutes": Proposal(prep, 0.7, prep_reason), "cookMinutes": cook_p}
