"""Print category / area / ingredient stats for the raw TheMealDB snapshot.

Usage: python tools/stats_mealdb.py
"""
import json
from collections import Counter
from pathlib import Path

RAW = Path(__file__).parent / "raw" / "mealdb_raw.json"


def main() -> None:
    meals = json.loads(RAW.read_text(encoding="utf-8"))
    print(f"meals: {len(meals)}")
    print("\ncategories:", Counter(m.get("strCategory") for m in meals).most_common())
    print("\nareas:", Counter(m.get("strArea") for m in meals).most_common())
    ingredients = Counter()
    for m in meals:
        for i in range(1, 21):
            name = (m.get(f"strIngredient{i}") or "").strip().lower()
            if name:
                ingredients[name] += 1
    print(f"\ndistinct ingredient strings: {len(ingredients)}")
    names = Counter(m["strMeal"].strip().lower() for m in meals)
    dupes = [n for n, c in names.items() if c > 1]
    print(f"exact duplicate titles: {len(dupes)} {dupes[:20]}")


if __name__ == "__main__":
    main()
