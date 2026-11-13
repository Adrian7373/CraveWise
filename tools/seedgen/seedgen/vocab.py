"""Controlled vocabularies, read from the app's Kotlin source so the two can never drift.

`domain/model/Vocabulary.kt` is the single source of truth: every `@Serializable enum class X`
contributes the set of its `@SerialName("...")` values.
"""
from __future__ import annotations

import re
from dataclasses import dataclass
from functools import lru_cache
from pathlib import Path

from .paths import VOCABULARY_KT

_ENUM_RE = re.compile(r"enum\s+class\s+(\w+)[^{]*\{(.*?)\n\s*\}", re.S)
_SERIAL_RE = re.compile(r'@SerialName\("([^"]+)"\)')


def parse_enums(source: str) -> dict[str, list[str]]:
    """{EnumName: [serial names in declaration order]} for every enum with @SerialName entries."""
    out: dict[str, list[str]] = {}
    for name, body in _ENUM_RE.findall(source):
        values = _SERIAL_RE.findall(body)
        if values:
            out[name] = values
    return out


@dataclass(frozen=True)
class Vocabulary:
    allergens: frozenset[str]
    contains: frozenset[str]
    diets: frozenset[str]
    proteins: frozenset[str]
    aisles: frozenset[str]
    meal_types: frozenset[str]
    textures: frozenset[str]
    moods: frozenset[str]
    difficulties: frozenset[str]
    units: frozenset[str]

    FLAVORS = ("salty", "sweet", "sour", "bitter", "umami", "spicy")


@lru_cache(maxsize=None)
def load(path: Path = VOCABULARY_KT) -> Vocabulary:
    enums = parse_enums(path.read_text(encoding="utf-8"))
    expected = {"Allergen", "ContainsFlag", "Diet", "Protein", "Aisle", "MealType", "Texture",
                "Mood", "Difficulty", "MeasureUnit"}
    missing = expected - enums.keys()
    if missing:
        raise SystemExit(f"Vocabulary.kt: could not find enums {sorted(missing)}")
    f = lambda n: frozenset(enums[n])  # noqa: E731
    return Vocabulary(
        allergens=f("Allergen"), contains=f("ContainsFlag"), diets=f("Diet"), proteins=f("Protein"),
        aisles=f("Aisle"), meal_types=f("MealType"), textures=f("Texture"), moods=f("Mood"),
        difficulties=f("Difficulty"), units=f("MeasureUnit"),
    )
