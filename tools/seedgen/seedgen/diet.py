"""Preview copy of the app's domain/DietRules.kt, for review sheets only (the app derives its own).

Keep in step with DietRules: allergens/diets/proteins come ONLY from canonical ingredient facts.
"""
from __future__ import annotations

ANIMAL_FLESH = {"meat", "pork", "poultry", "fish", "shellfish", "gelatin"}
ANIMAL_PRODUCTS = {"dairy", "egg", "honey"}
LAND_MEAT = {"meat", "pork", "poultry", "gelatin"}
PORK_OR_ALCOHOL = {"pork", "alcohol", "gelatin"}


def derive(ingredients: list[dict]) -> tuple[set[str], set[str], set[str]]:
    """(allergens, diets, proteins) for a recipe's canonical ingredients."""
    allergens = {a for i in ingredients for a in i.get("allergens", [])}
    contains = {c for i in ingredients for c in i.get("contains", [])}
    proteins = {i["protein"] for i in ingredients if i.get("protein")}
    diets = set()
    if not contains & ANIMAL_FLESH:
        diets.add("vegetarian")
        if not contains & ANIMAL_PRODUCTS:
            diets.add("vegan")
    if not contains & LAND_MEAT:
        diets.add("pescatarian")
    if "gluten" not in allergens:
        diets.add("gluten_free")
    if "milk" not in allergens and "dairy" not in contains:
        diets.add("dairy_free")
    if not contains & PORK_OR_ALCOHOL:
        diets.add("no_pork_no_alcohol")
    return allergens, diets, proteins
