"""Deterministic tag rules. `propose(recipe)` → {field: Proposal(value, confidence, reason)}.

Pure functions of the normalized recipe; no I/O. Confidence >= tags.CONFIDENT beats AI.
"""
from __future__ import annotations

from ..normalize import Recipe
from ..tags import Proposal
from . import character, difficulty, flavor, times


def propose(recipe: Recipe, allowed_cuisines: set[str]) -> dict[str, Proposal]:
    ids = [l.ingredient_id for l in recipe.lines if l.ingredient_id]
    out: dict[str, Proposal] = {}
    c = character.cuisine(recipe.cuisine, recipe.title, allowed_cuisines)
    if c:
        out["cuisine"] = c
    out["mealTypes"] = Proposal(recipe.meal_types, 0.9, f"TheMealDB category {recipe.category}")
    out |= flavor.propose(ids, recipe.category)
    out |= character.textures_moods(recipe.title, recipe.category, recipe.steps, ids)
    out["servings"] = character.servings(recipe.instructions + " " + recipe.title)
    out |= times.propose(recipe.steps, len(recipe.lines), recipe.category)
    total = out["prepMinutes"].value + out["cookMinutes"].value
    out["difficulty"] = difficulty.propose(recipe.steps, len(recipe.lines), total)
    return out
