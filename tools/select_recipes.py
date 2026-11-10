"""Pick a balanced ~300-meal subset of the TheMealDB snapshot.

Usage: python tools/select_recipes.py
Writes tools/data/selection.csv (one row per raw meal, `include` = 1/0).
Edit `include` by hand to override; re-running KEEPS manual edits (rows marked
`manual=1`). Add more meals later by flipping include=1 and bumping the dataset version.

Rule: per-category quota; within a category, round-robin across cuisines (so small
cuisines get represented), preferring meals with a known cuisine and fewer ingredients.
"""
import csv
import json
import re
from collections import defaultdict
from pathlib import Path

ROOT = Path(__file__).parent
RAW = ROOT / "raw" / "mealdb_raw.json"
OUT = ROOT / "data" / "selection.csv"

QUOTA = {
    "Dessert": 40, "Vegetarian": 45, "Beef": 35, "Seafood": 35, "Chicken": 35,
    "Side": 25, "Pork": 25, "Lamb": 15, "Miscellaneous": 12, "Breakfast": 12,
    "Starter": 8, "Pasta": 8, "Vegan": 7, "Goat": 2,
}
FIELDS = ["idMeal", "include", "manual", "title", "category", "area", "ingredientCount"]


def ingredient_count(meal: dict) -> int:
    return sum(1 for i in range(1, 21) if (meal.get(f"strIngredient{i}") or "").strip())


def title_key(title: str) -> str:
    """Fuzzy key so 'Fettuccine Alfredo' == 'Fettucine alfredo'."""
    letters = re.sub(r"[^a-z]", "", title.lower())
    return re.sub(r"(.)\1+", r"\1", letters)


def pick(meals: list[dict], quota: int, seen: set[str]) -> set[str]:
    by_area: dict[str, list[dict]] = defaultdict(list)
    for m in meals:
        by_area[m.get("strArea") or ""].append(m)
    for lst in by_area.values():
        lst.sort(key=lambda m: (ingredient_count(m), int(m["idMeal"])))
    # Known cuisines first (alphabetical for determinism), unknown cuisine last.
    areas = sorted(a for a in by_area if a) + ([""] if "" in by_area else [])
    chosen: list[str] = []
    while len(chosen) < quota and any(by_area[a] for a in areas):
        for a in areas:
            if by_area[a] and len(chosen) < quota:
                m = by_area[a].pop(0)
                key = title_key(m["strMeal"])
                if key not in seen:
                    seen.add(key)
                    chosen.append(m["idMeal"])
    return set(chosen)


def main() -> None:
    meals = json.loads(RAW.read_text(encoding="utf-8"))
    manual: dict[str, str] = {}
    if OUT.exists():
        with OUT.open(encoding="utf-8", newline="") as f:
            for row in csv.DictReader(f):
                if row.get("manual") == "1":
                    manual[row["idMeal"]] = row["include"]

    by_cat: dict[str, list[dict]] = defaultdict(list)
    for m in meals:
        by_cat[m["strCategory"]].append(m)
    selected: set[str] = set()
    seen: set[str] = set()
    for cat in sorted(by_cat):
        selected |= pick(by_cat[cat], QUOTA.get(cat, 0), seen)

    OUT.parent.mkdir(parents=True, exist_ok=True)
    with OUT.open("w", encoding="utf-8", newline="") as f:
        w = csv.DictWriter(f, fieldnames=FIELDS)
        w.writeheader()
        for m in sorted(meals, key=lambda m: (m["strCategory"], m.get("strArea") or "~", m["strMeal"])):
            mid = m["idMeal"]
            include = manual.get(mid, "1" if mid in selected else "0")
            w.writerow({
                "idMeal": mid, "include": include, "manual": "1" if mid in manual else "0",
                "title": m["strMeal"].strip(), "category": m["strCategory"],
                "area": m.get("strArea") or "", "ingredientCount": ingredient_count(m),
            })
    total = sum(1 for m in meals if manual.get(m["idMeal"], "1" if m["idMeal"] in selected else "0") == "1")
    print(f"selected {total} of {len(meals)} -> {OUT}")


if __name__ == "__main__":
    main()
