"""Python port of the app's domain/cook/StepTimers.kt (keep the two in step).

Finds durations in a method step: digits, decimals, ½-style glyphs, number words, ranges (lower
bound) and "1 hour 30 minutes". Durations over a day are ignored.
"""
from __future__ import annotations

import re

MINUTE = 60.0
HOUR = 3600.0
MAX_SECONDS = 24 * 3600

WORDS = {
    "a": 1.0, "an": 1.0, "one": 1.0, "two": 2.0, "three": 3.0, "four": 4.0, "five": 5.0, "six": 6.0,
    "seven": 7.0, "eight": 8.0, "nine": 9.0, "ten": 10.0, "eleven": 11.0, "twelve": 12.0, "fifteen": 15.0,
    "twenty": 20.0, "thirty": 30.0, "forty": 40.0, "forty-five": 45.0, "fifty": 50.0, "sixty": 60.0,
    "half a": 0.5, "half an": 0.5, "a half": 0.5, "a couple of": 2.0, "a couple": 2.0,
}
GLYPHS = {"¼": 0.25, "½": 0.5, "¾": 0.75, "⅓": 1 / 3, "⅔": 2 / 3}
_WORD_ALT = "|".join(re.escape(w) for w in sorted(WORDS, key=len, reverse=True))
_NUM = rf"(?:\d+(?:\.\d+)?(?:\s*[¼½¾⅓⅔])?|[¼½¾⅓⅔]|{_WORD_ALT})"
PATTERN = re.compile(
    rf"(?<![\w.])({_NUM})(?:\s*(?:-|–|to|or)\s*({_NUM}))?\s*"
    r"(hours?|hrs?|minutes?|mins?|seconds?|secs?)\b"
    r"(?:\s*(?:and\s*)?(\d+)\s*(?:minutes?|mins?)\b)?",
    re.I,
)


def _unit(u: str) -> float | None:
    return {"hour": HOUR, "hr": HOUR, "minute": MINUTE, "min": MINUTE, "second": 1.0, "sec": 1.0}.get(u.lower().rstrip("s"))


def _parse(text: str) -> float | None:
    t = text.strip().lower()
    if t in WORDS:
        return WORDS[t]
    glyph = GLYPHS.get(t[-1:]) if t else None
    digits = t[:-1].strip() if glyph is not None else t
    try:
        whole = float(digits) if digits else 0.0
    except ValueError:
        return None
    return whole + (glyph or 0.0)


def find_seconds(text: str) -> list[int]:
    """Distinct durations in `text`, in seconds, in order of appearance."""
    found: list[int] = []
    for m in PATTERN.finditer(text):
        unit = _unit(m.group(3))
        if unit == 1.0 and m.group(1).strip().lower() in ("a", "an"):
            continue  # "a second time" is an ordinal, not a 1-second timer (same as StepTimers.kt)
        low = _parse(m.group(1))
        if unit is None or low is None:
            continue
        seconds = low * unit
        if m.group(4) and unit == HOUR:
            seconds += float(m.group(4)) * MINUTE
        total = int(seconds)
        if 0 < total <= MAX_SECONDS and total not in found:
            found.append(total)
    return found
