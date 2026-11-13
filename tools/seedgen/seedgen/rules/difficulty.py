"""Difficulty from step count, ingredient count, total time and technique keywords."""
from __future__ import annotations

import re

from ..tags import Proposal

TECHNIQUES = re.compile(
    r"deep[- ]?fr|temper|emulsif|prove|proof|knead|laminat|blind bake|souffl|flamb|caramelis|caramelize|"
    r"sugar thermometer|soft ball|candy|pipe |piping|choux|puff pastry from|make the pastry|roll out the pastry|"
    r"rub in|fold in the (egg|flour)|whisk.*stiff peaks|clarif|debone|butterfly|truss|cure|ferment|"
    r"stuff(ed|ing) (the )?(leaves|cabbage|peppers)|wrap each|fold each|crimp|steam(er)? basket|water bath|bain",
    re.I,
)


def propose(steps: list[str], ingredient_count: int, total_minutes: int) -> Proposal:
    text = " ".join(steps)
    techniques = sorted({m.group(0).lower().strip() for m in TECHNIQUES.finditer(text)})
    score = 0
    score += 1 if len(steps) > 8 else 0
    score += 1 if len(steps) > 14 else 0
    score += 1 if ingredient_count > 12 else 0
    score += 1 if total_minutes > 90 else 0
    score += min(2, len(techniques))
    value = "easy" if score <= 1 else "medium" if score <= 3 else "hard"
    reason = f"{len(steps)} steps, {ingredient_count} ingredients, {total_minutes} min" + (
        f", technique: {', '.join(techniques[:3])}" if techniques else "")
    # Counting steps can't tell sushi from a sandwich, so only a clear "hard" is trusted; AI judges the rest.
    return Proposal(value, 0.75 if score >= 5 else 0.55, reason)
