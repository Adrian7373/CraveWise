"""Tag fields and the (value, confidence, reason) shape every tag source produces."""
from __future__ import annotations

from dataclasses import dataclass
from typing import Any

FLAVORS = ("salty", "sweet", "sour", "bitter", "umami", "spicy")
FLAVOR_FIELDS = tuple(f"flavor.{f}" for f in FLAVORS)
# Every field a shipped recipe needs. `flavor.spicy` doubles as the app's spice level.
FIELDS = ("cuisine", "mealTypes", *FLAVOR_FIELDS, "textures", "moods", "servings",
          "prepMinutes", "cookMinutes", "difficulty")
LIST_FIELDS = {"mealTypes", "textures", "moods"}
# Fields AI may fill. mealTypes comes from TheMealDB's category (overrides can still change it).
AI_FIELDS = tuple(f for f in FIELDS if f != "mealTypes")

CONFIDENT = 0.7  # a rule at or above this beats AI


@dataclass(frozen=True)
class Proposal:
    value: Any
    confidence: float
    reason: str


def validate_value(field: str, value: Any, vocab, cuisines: set[str]) -> str | None:
    """Error message if `value` is not allowed for `field`, else None."""
    if field.startswith("flavor."):
        ok = isinstance(value, int) and not isinstance(value, bool) and 0 <= value <= 5
        return None if ok else f"{field} must be an int 0..5, got {value!r}"
    if field == "cuisine":
        return None if value in cuisines else f"cuisine {value!r} not in the allowed list"
    allowed = {"mealTypes": vocab.meal_types, "textures": vocab.textures, "moods": vocab.moods}.get(field)
    if allowed is not None:
        if not isinstance(value, list) or any(v not in allowed for v in value):
            return f"{field} {value!r} not all in {sorted(allowed)}"
        if field == "mealTypes" and not value:
            return "mealTypes must not be empty"
        return None
    if field == "difficulty":
        return None if value in vocab.difficulties else f"difficulty {value!r} not in {sorted(vocab.difficulties)}"
    if field == "servings":
        ok = isinstance(value, int) and not isinstance(value, bool) and 1 <= value <= 24
        return None if ok else f"servings must be 1..24, got {value!r}"
    if field in ("prepMinutes", "cookMinutes"):
        ok = isinstance(value, int) and not isinstance(value, bool) and 0 <= value <= 1440
        return None if ok else f"{field} must be 0..1440, got {value!r}"
    return f"unknown field {field}"
