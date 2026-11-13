"""Phase B: raw TheMealDB meals → normalized recipes (no tags yet).

A normalized recipe holds facts straight from the source: title, cuisine (or None), meal types,
ingredient lines (id or None when unmapped + parsed measure), steps and source info.
"""
from __future__ import annotations

import json
import re
import unicodedata
from dataclasses import dataclass, field

from . import fetch
from .ingredients import IngredientTable
from .measures import parse_measure
from .paths import CUISINES, EXCLUDE
from .steps import split_steps

# Category -> meal types. Everything not listed is a main.
CATEGORY_MEAL_TYPES = {
    "Dessert": ["dessert"], "Breakfast": ["breakfast"], "Starter": ["starter"], "Side": ["side"],
}
# Title words that add a meal type on top of the category (rules; tags phase may add more).
TITLE_MEAL_TYPES = [
    (re.compile(r"\b(soup|salad|dip|bruschetta|spring rolls?|samosa|pakora|fritters?)\b", re.I), "starter"),
    (re.compile(r"\b(cookies?|brownies?|muffins?|flapjacks?|biscuits?|scones?|bars?|balls?|nuts?)\b", re.I), "snack"),
    (re.compile(r"\b(pancakes?|omelette|porridge|granola|waffles?|french toast|shakshuka|breakfast)\b", re.I), "breakfast"),
]


@dataclass
class Line:
    raw_name: str
    raw_measure: str
    ingredient_id: str | None
    amount: float | None = None
    amount_max: float | None = None
    unit: str | None = None
    note: str | None = None

    def to_seed(self) -> dict:
        return {"ingredientId": self.ingredient_id, "rawName": self.raw_name, "rawMeasure": self.raw_measure,
                "amount": self.amount, "amountMax": self.amount_max, "unit": self.unit, "note": self.note}


@dataclass
class Recipe:
    id: str
    meal_id: str
    title: str
    category: str
    area: str | None
    cuisine: str | None
    meal_types: list[str]
    lines: list[Line]
    steps: list[str]
    instructions: str
    source_url: str
    original_url: str | None
    thumb_url: str | None
    tags: list[str] = field(default_factory=list)


def title_key(title: str) -> str:
    """Fuzzy key so 'Fettuccine Alfredo' == 'Fettucine alfredo'."""
    t = unicodedata.normalize("NFKD", title.lower())
    letters = re.sub(r"[^a-z]", "", "".join(c for c in t if not unicodedata.combining(c)))
    return re.sub(r"(.)\1+", r"\1", letters)


def raw_lines(meal: dict) -> list[tuple[str, str]]:
    out = []
    for i in range(1, 21):
        name = re.sub(r"\s+", " ", (meal.get(f"strIngredient{i}") or "").strip())
        if name:
            out.append((name, re.sub(r"\s+", " ", (meal.get(f"strMeasure{i}") or "").strip())))
    return out


def load_exclude() -> dict[str, str]:
    """{idMeal: reason}. Hand-editable; `duplicates` are recomputed every run."""
    if not EXCLUDE.exists():
        return {}
    data = json.loads(EXCLUDE.read_text(encoding="utf-8"))
    return {**data.get("manual", {}), **data.get("duplicates", {})}


def find_duplicates(meals: list[dict]) -> dict[str, str]:
    """Near-duplicate titles: keep the lowest idMeal, exclude the rest."""
    first: dict[str, dict] = {}
    dupes: dict[str, str] = {}
    for m in sorted(meals, key=lambda m: int(m["idMeal"])):
        k = title_key(m["strMeal"])
        if k in first:
            dupes[m["idMeal"]] = f"duplicate of {first[k]['idMeal']} {first[k]['strMeal'].strip()}"
        else:
            first[k] = m
    return dupes


def write_exclude(dupes: dict[str, str]) -> None:
    data = json.loads(EXCLUDE.read_text(encoding="utf-8")) if EXCLUDE.exists() else {}
    data = {"_comment": "manual: {idMeal: reason} you add by hand. duplicates: recomputed by build.py.",
            "manual": data.get("manual", {}), "duplicates": dict(sorted(dupes.items(), key=lambda kv: int(kv[0])))}
    EXCLUDE.parent.mkdir(parents=True, exist_ok=True)
    EXCLUDE.write_text(json.dumps(data, indent=1, ensure_ascii=False) + "\n", encoding="utf-8")


# ---- cuisine ----------------------------------------------------------------------------------
def cuisine_table() -> dict[str, str]:
    """Raw strArea (adjective OR country) -> cuisine adjective, from list.php?a=list + hand fixes."""
    table: dict[str, str] = {}
    for row in fetch.load_list("list_a.json"):
        area, country = (row.get("strArea") or "").strip(), (row.get("strCountry") or "").strip()
        if area:
            table[area] = area
            if country:
                table[country] = area
    if CUISINES.exists():
        table.update(json.loads(CUISINES.read_text(encoding="utf-8")).get("aliases", {}))
    return table


def allowed_cuisines() -> set[str]:
    allowed = set(cuisine_table().values())
    if CUISINES.exists():
        allowed |= set(json.loads(CUISINES.read_text(encoding="utf-8")).get("extra", []))
    return allowed


def write_cuisines_if_missing() -> None:
    if CUISINES.exists():
        return
    data = {"_comment": "Allowed cuisines = every strArea from TheMealDB list.php?a=list, plus `extra`. "
                        "`aliases` maps a raw strArea (or another spelling) to the cuisine shown in the app.",
            "aliases": {}, "extra": []}
    CUISINES.write_text(json.dumps(data, indent=1) + "\n", encoding="utf-8")


# ---- recipes ----------------------------------------------------------------------------------
def meal_types(category: str, title: str) -> list[str]:
    types = list(CATEGORY_MEAL_TYPES.get(category, ["main"]))
    for rx, t in TITLE_MEAL_TYPES:
        if rx.search(title) and t not in types and not (t == "breakfast" and "dessert" in types):
            if t == "snack" and "dessert" not in types and category != "Side":
                continue  # only sweet bakes / sides become snacks
            types.append(t)
    return sorted(types)


def normalize(meal: dict, table: IngredientTable, cuisines: dict[str, str]) -> Recipe:
    lines = []
    for name, measure in raw_lines(meal):
        p = parse_measure(measure)
        lines.append(Line(name, measure, table.resolve(name), p["amount"], p["amountMax"], p["unit"], p["note"]))
    area = (meal.get("strArea") or "").strip() or None
    if area and area.lower() == "unknown":
        area = None
    mid = meal["idMeal"]
    title = meal["strMeal"].strip()
    return Recipe(
        id=f"mdb-{mid}", meal_id=mid, title=title, category=meal.get("strCategory") or "",
        area=area, cuisine=cuisines.get(area) if area else None,
        meal_types=meal_types(meal.get("strCategory") or "", title),
        lines=lines, steps=split_steps(meal.get("strInstructions") or ""),
        instructions=meal.get("strInstructions") or "",
        source_url=f"https://www.themealdb.com/meal/{mid}",
        original_url=(meal.get("strSource") or "").strip() or None,
        thumb_url=(meal.get("strMealThumb") or "").strip() or None,
        tags=[t.strip() for t in (meal.get("strTags") or "").split(",") if t.strip()],
    )


def load_recipes(table: IngredientTable) -> tuple[list[Recipe], dict[str, str]]:
    """(normalized recipes that ship, {excluded idMeal: reason})."""
    meals = fetch.load_meals()
    dupes = find_duplicates(meals)
    write_exclude(dupes)
    exclude = load_exclude()
    cuisines = cuisine_table()
    recipes = [normalize(m, table, cuisines) for m in meals if m["idMeal"] not in exclude]
    return recipes, exclude
