"""CraveWise dataset pipeline (offline; Python 3.10+, stdlib only).

    python tools/dataset.py report   # list raw ingredient strings in the selection, flag unmapped ones
    python tools/dataset.py tags     # create/refresh tools/data/recipe_tags.csv (keeps your edits)
    python tools/dataset.py build    # validate everything and write app/src/main/assets/seed/
    python tools/dataset.py build --ids 52772,53069   # build only these meals (pilot / debugging)
    python tools/dataset.py show 52772 53069          # print meals' ingredients + instructions

Sources of truth (all committed):
    tools/raw/mealdb_raw.json     TheMealDB snapshot (fetch_mealdb.py)
    tools/data/selection.csv      which meals ship (select_recipes.py, hand-editable)
    tools/data/ingredients.csv    canonical ingredient table (ids, synonyms, aisle, allergens, flags):
                                  spreadsheet-editable; YOU review its allergens (safety rule)
    tools/data/recipe_tags.csv    per-recipe tags: the file you review/edit in a spreadsheet

Allergens / diets / proteins are NOT stored per recipe. The app derives them from the canonical
ingredient table at import time (safety rule). The CSV's `derived_*` columns are a read-only preview
using the same rules; editing them has no effect.

Bump DATASET_VERSION whenever the shipped data changes; the app re-seeds its catalog on a bump.
"""
from __future__ import annotations

import csv
import json
import re
import sys
from fractions import Fraction
from pathlib import Path

DATASET_VERSION = 1

ROOT = Path(__file__).parent
REPO = ROOT.parent
RAW = ROOT / "raw" / "mealdb_raw.json"
SELECTION = ROOT / "data" / "selection.csv"
INGREDIENTS = ROOT / "data" / "ingredients.csv"
INGREDIENT_FIELDS = ["id", "name", "synonyms", "aisle", "allergens", "contains", "protein",
                     "pantry_staple", "reviewed", "notes"]
TAGS = ROOT / "data" / "recipe_tags.csv"
ASSET_DIR = REPO / "app" / "src" / "main" / "assets" / "seed"

# ---- Vocabularies (must match the Kotlin enums in domain/model, which use these serial names) ----
ALLERGENS = {"gluten", "crustaceans", "eggs", "fish", "peanuts", "soy", "milk", "tree_nuts",
             "celery", "mustard", "sesame", "sulphites", "lupin", "molluscs"}  # EU 14
CONTAINS = {"meat", "pork", "poultry", "fish", "shellfish", "dairy", "egg", "honey", "alcohol", "gelatin"}
PROTEINS = {"chicken", "beef", "pork", "lamb", "goat", "duck", "turkey", "fish", "shellfish",
            "egg", "tofu", "legumes", "cheese"}
AISLES = {"produce", "meat_seafood", "dairy_eggs", "bakery", "pantry", "spices", "condiments",
          "frozen", "beverages", "international", "other"}
MEAL_TYPES = {"breakfast", "main", "side", "starter", "dessert", "snack"}
TEXTURES = {"crispy", "crunchy", "creamy", "chewy", "saucy", "brothy", "tender", "fluffy", "flaky", "smooth"}
MOODS = {"comfort", "light", "hearty", "fresh", "indulgent", "festive"}
DIFFICULTIES = {"easy", "medium", "hard"}
FLAVORS = ["salty", "sweet", "sour", "bitter", "umami", "spicy"]
# Words in the instructions that imply an allergen. TheMealDB ingredient lists sometimes omit
# things the steps use (e.g. butter), so `tags` cross-checks and flags gaps for review.
STEP_ALLERGEN_WORDS = {
    "gluten": r"flour|bread|breadcrumb|pasta|noodle|spaghetti|couscous|pastry|tortilla|pitta|pita|wheat|barley|semolina|beer",
    "milk": r"butter|milk|cream|cheese|parmesan|yogh?urt|ghee|cr[eè]me|mozzarella|feta",
    "eggs": r"\beggs?\b|yolk|mayonnaise|meringue",
    "fish": r"\bfish\b|anchov|salmon|tuna|\bcod\b|fish sauce|worcestershire",
    "crustaceans": r"prawn|shrimp|crab|lobster|crayfish",
    "molluscs": r"mussel|clam|oyster|squid|octopus|scallop",
    "peanuts": r"peanut|groundnut",
    "tree_nuts": r"almond|walnut|cashew|pecan|pistachio|hazelnut|macadamia|pine nut",
    "soy": r"\bsoy|soya|tofu|miso|edamame",
    "sesame": r"sesame|tahini",
    "mustard": r"mustard",
    "celery": r"celery|celeriac",
    "sulphites": r"\bwine\b|vinegar|sherry|dried apricot",
}
# TheMealDB mixes countries and adjectives; normalize to adjectives.
CUISINE_NAMES = {
    "Argentina": "Argentinian", "France": "French", "India": "Indian", "Netherlands": "Dutch",
    "Norway": "Norwegian", "Slovakia": "Slovak", "United States": "American", "Venezuela": "Venezuelan",
    "Saudi Arabian": "Saudi",
}

# ---- Measure parsing --------------------------------------------------------------------------
UNIT_ALIASES = {
    "g": "g", "gr": "g", "gram": "g", "grams": "g", "gms": "g",
    "kg": "kg", "kilo": "kg", "kilos": "kg", "kilogram": "kg", "kilograms": "kg",
    "ml": "ml", "millilitre": "ml", "millilitres": "ml", "milliliter": "ml", "milliliters": "ml",
    "l": "l", "litre": "l", "litres": "l", "liter": "l", "liters": "l", "ltr": "l",
    "tsp": "tsp", "tsps": "tsp", "teaspoon": "tsp", "teaspoons": "tsp", "tspn": "tsp",
    "tbsp": "tbsp", "tbsps": "tbsp", "tbs": "tbsp", "tbls": "tbsp", "tblsp": "tbsp", "tbl": "tbsp",
    "tablespoon": "tbsp", "tablespoons": "tbsp",
    "cup": "cup", "cups": "cup",
    "oz": "oz", "ounce": "oz", "ounces": "oz",
    "fl oz": "fl_oz", "floz": "fl_oz",
    "lb": "lb", "lbs": "lb", "pound": "lb", "pounds": "lb",
    "cm": "cm",
    "pinch": "pinch", "pinches": "pinch", "dash": "dash", "dashes": "dash",
    "splash": "splash", "clove": "clove", "cloves": "clove", "slice": "slice", "slices": "slice",
    "can": "can", "cans": "can", "tin": "can", "tins": "can",
    "bunch": "bunch", "bunches": "bunch", "sprig": "sprig", "sprigs": "sprig",
    "handful": "handful", "handfuls": "handful", "stick": "stick", "sticks": "stick",
    "packet": "packet", "packets": "packet", "pack": "packet", "packs": "packet", "package": "packet",
    "jar": "jar", "jars": "jar", "sheet": "sheet", "sheets": "sheet",
    "leaf": "leaf", "leaves": "leaf", "head": "head", "heads": "head", "stalk": "stalk", "stalks": "stalk",
    "piece": "piece", "pieces": "piece", "knob": "knob", "fillet": "fillet", "fillets": "fillet",
    "bottle": "bottle", "bottles": "bottle",
}
UNITS = set(UNIT_ALIASES.values())
UNICODE_FRACTIONS = {"½": "1/2", "⅓": "1/3", "⅔": "2/3", "¼": "1/4", "¾": "3/4", "⅛": "1/8"}
NUM = r"(?:\d+\s+\d+/\d+|\d+/\d+|\d+(?:[.,]\d+)?)"
MEASURE_RE = re.compile(rf"^(?P<a>{NUM})\s*(?:(?:-|–|to)\s*(?P<b>{NUM}))?\s*(?P<rest>.*)$")


def _num(text: str) -> float:
    text = text.replace(",", ".").strip()
    if " " in text:
        whole, frac = text.split()
        return float(int(whole) + Fraction(frac))
    return float(Fraction(text)) if "/" in text else float(text)


def parse_measure(raw: str) -> dict:
    """'1 1/2 cups chopped' -> {amount: 1.5, unit: 'cup', note: 'chopped'}. Never loses `raw`."""
    s = raw.strip().lower()
    for k, v in UNICODE_FRACTIONS.items():
        s = re.sub(rf"(\d){k}", rf"\1 {v}", s).replace(k, v)
    out: dict = {"amount": None, "amountMax": None, "unit": None, "note": None}
    m = MEASURE_RE.match(s)
    rest = s
    if m:
        try:
            out["amount"] = round(_num(m["a"]), 3)
            out["amountMax"] = round(_num(m["b"]), 3) if m["b"] else None
        except (ValueError, ZeroDivisionError):
            return out | {"amount": None, "amountMax": None, "note": raw.strip() or None}
        rest = m["rest"].strip()
    words = rest.replace(".", " ").split()
    for n in (2, 1):
        key = " ".join(words[:n])
        if len(words) >= n and key in UNIT_ALIASES:
            out["unit"] = UNIT_ALIASES[key]
            rest = " ".join(words[n:])
            if out["amount"] is None:  # "pinch", "dash" with no number
                out["amount"] = 1.0
            break
    if out["amount"] is None:
        out["note"] = raw.strip() or None  # "to taste", "garnish", ...
    else:
        out["note"] = rest.strip(" ,()") or None
    return out


# ---- Loading ----------------------------------------------------------------------------------
def norm(text: str) -> str:
    return re.sub(r"\s+", " ", text.strip().lower())


def load_raw() -> dict[str, dict]:
    return {m["idMeal"]: m for m in json.loads(RAW.read_text(encoding="utf-8"))}


def load_selection() -> list[str]:
    with SELECTION.open(encoding="utf-8", newline="") as f:
        return [r["idMeal"] for r in csv.DictReader(f) if r["include"] == "1"]


def _pipe(value: str | None) -> list[str]:
    return [v.strip() for v in (value or "").split("|") if v.strip()]


def load_ingredients() -> tuple[list[dict], dict[str, str]]:
    """Reads ingredients.csv into the JSON shape the app expects."""
    if not INGREDIENTS.exists():
        return [], {}
    items = []
    with INGREDIENTS.open(encoding="utf-8-sig", newline="") as f:
        for r in csv.DictReader(f):
            items.append({
                "id": (r["id"] or "").strip(),
                "name": (r["name"] or "").strip(),
                "synonyms": _pipe(r["synonyms"]),
                "aisle": (r["aisle"] or "").strip(),
                "allergens": sorted(set(_pipe(r["allergens"]))),
                "contains": sorted(set(_pipe(r["contains"]))),
                "protein": (r["protein"] or "").strip() or None,
                "isPantryStaple": {"1": True, "0": False}.get((r["pantry_staple"] or "").strip(), "invalid"),
            })
    lookup: dict[str, str] = {}
    for ing in items:
        for name in [ing["name"], *ing.get("synonyms", [])]:
            key = norm(name)
            if key in lookup and lookup[key] != ing["id"]:
                raise SystemExit(f"synonym '{key}' maps to both {lookup[key]} and {ing['id']}")
            lookup[key] = ing["id"]
    return items, lookup


def raw_lines(meal: dict) -> list[tuple[str, str]]:
    lines = []
    for i in range(1, 21):
        name = (meal.get(f"strIngredient{i}") or "").strip()
        if name:
            lines.append((name, (meal.get(f"strMeasure{i}") or "").strip()))
    return lines


INLINE_NUMBER = re.compile(r"\s+\d{1,2}[.)]\s+(?=[A-Z])|(?<=[.!?])\s+\d{1,2}\s+(?=[A-Z])")


def split_steps(text: str) -> list[str]:
    """Best-effort split of TheMealDB's free-form instructions into steps.

    Handles 'STEP 1' markers, one-step-per-line, lines broken mid-sentence, and steps numbered
    inline ('...set aside 2. Drain the...'). `report` flags recipes that still look wrong.
    """
    t = (text or "").replace("\r", "")
    if re.search(r"\bstep\s*\d+", t, re.I):
        parts = re.split(r"\bstep\s*\d+\s*[:.)-]?", t, flags=re.I)
    else:
        parts, buf = [], ""
        for line in (ln.strip() for ln in t.split("\n")):
            if not line:
                if buf:
                    parts.append(buf)
                    buf = ""
                continue
            buf = f"{buf} {line}".strip()
            if re.search(r"[.!?:)]$", buf):  # sentence ended -> line break is a real step break
                parts.append(buf)
                buf = ""
        if buf:
            parts.append(buf)
    steps = []
    for part in parts:
        for piece in INLINE_NUMBER.split(part):
            piece = re.sub(r"^\s*\d{1,2}[.)]?\s+", "", piece.strip())
            piece = re.sub(r"\s+\d{1,2}\.?$", "", piece)  # dangling number of the next step
            piece = re.sub(r"\s{2,}", " ", piece).strip(" -")
            if piece and not re.fullmatch(r"[\d.\s]*", piece):
                steps.append(piece if re.search(r"[.!?)]$", piece) else piece + ".")
    return steps


def derive(ingredient_ids: list[str], by_id: dict[str, dict]) -> tuple[set, set, set]:
    """Preview of the app's rules (authoritative copy: domain/DietRules.kt)."""
    allergens, contains, proteins = set(), set(), set()
    for iid in ingredient_ids:
        ing = by_id[iid]
        allergens |= set(ing.get("allergens", []))
        contains |= set(ing.get("contains", []))
        if ing.get("protein"):
            proteins.add(ing["protein"])
    animal = {"meat", "pork", "poultry", "fish", "shellfish", "gelatin"}
    diets = set()
    if not contains & animal:
        diets.add("vegetarian")
        if not contains & {"dairy", "egg", "honey"}:
            diets.add("vegan")
    if not contains & {"meat", "pork", "poultry", "gelatin"}:
        diets.add("pescatarian")
    if "gluten" not in allergens:
        diets.add("gluten_free")
    if "milk" not in allergens and "dairy" not in contains:
        diets.add("dairy_free")
    if not contains & {"pork", "alcohol", "gelatin"}:
        diets.add("no_pork_no_alcohol")
    return allergens, diets, proteins


# ---- Commands ---------------------------------------------------------------------------------
def cmd_report() -> int:
    raw, ids = load_raw(), load_selection()
    _, lookup = load_ingredients()
    counts: dict[str, int] = {}
    for mid in ids:
        for name, _ in raw_lines(raw[mid]):
            counts[norm(name)] = counts.get(norm(name), 0) + 1
    unmapped = sorted((n for n in counts if n not in lookup), key=lambda n: (-counts[n], n))
    print(f"{len(ids)} recipes, {len(counts)} distinct ingredient strings, {len(unmapped)} unmapped")
    for n in unmapped:
        print(f"{counts[n]:4d}  {n}")
    odd = [mid for mid in ids if (s := split_steps(raw[mid].get("strInstructions") or ""))
           and (len(s) == 1 and len(s[0]) > 400 or len(s) > 25)]
    print(f"\n{len(odd)} recipes whose steps may need a manual look: {odd}")
    return 0 if not unmapped else 1


TAG_FIELDS = ["idMeal", "title", "category", "source_area", "cuisine", "cuisine_inferred", "meal_types",
              *FLAVORS, "textures", "moods", "servings", "prep_minutes", "cook_minutes", "difficulty",
              "times_estimated", "extra_ingredients", "reviewed", "notes",
              "derived_allergens", "derived_diets", "derived_proteins", "allergen_check"]


def parse_extras(value: str) -> list[tuple[str, str]]:
    """'butter:50g|garlic:2 cloves' -> [('butter', '50g'), ('garlic', '2 cloves')]. Ids, not names."""
    out = []
    for item in _pipe(value):
        iid, _, measure = item.partition(":")
        out.append((iid.strip(), measure.strip()))
    return out


def allergen_gaps(steps_text: str, allergens: set[str]) -> list[str]:
    text = steps_text.lower()
    gaps = []
    for allergen, pattern in STEP_ALLERGEN_WORDS.items():
        if allergen not in allergens and (m := re.search(pattern, text)):
            gaps.append(f"{allergen}? ('{m.group(0)}')")
    return gaps


def read_tags() -> dict[str, dict]:
    if not TAGS.exists():
        return {}
    with TAGS.open(encoding="utf-8-sig", newline="") as f:
        return {r["idMeal"]: r for r in csv.DictReader(f)}


def cmd_tags() -> int:
    """Create rows for newly selected meals and refresh read-only columns. Never overwrites edits."""
    raw, ids = load_raw(), load_selection()
    items, lookup = load_ingredients()
    by_id = {i["id"]: i for i in items}
    existing = read_tags()
    rows = []
    for mid in ids:
        meal = raw[mid]
        row = existing.get(mid) or {f: "" for f in TAG_FIELDS} | {
            "idMeal": mid, "cuisine": meal.get("strArea") or "",
            "cuisine_inferred": "0" if meal.get("strArea") else "1", "reviewed": "0",
        }
        row = {f: row.get(f, "") for f in TAG_FIELDS}
        if row["cuisine"] in CUISINE_NAMES:
            row["cuisine"] = CUISINE_NAMES[row["cuisine"]]
        row["title"], row["category"], row["source_area"] = meal["strMeal"].strip(), meal["strCategory"], meal.get("strArea") or ""
        iids = [lookup.get(norm(n)) for n, _ in raw_lines(meal)]
        iids += [iid if iid in by_id else None for iid, _ in parse_extras(row["extra_ingredients"])]
        if all(iids):
            a, d, p = derive(iids, by_id)
            row["derived_allergens"], row["derived_diets"], row["derived_proteins"] = ("|".join(sorted(x)) for x in (a, d, p))
            gaps = allergen_gaps(meal.get("strInstructions") or "", a)
            row["allergen_check"] = "; ".join(gaps) if gaps else "ok"
        else:
            row["derived_allergens"] = row["derived_diets"] = row["derived_proteins"] = "UNMAPPED INGREDIENTS"
            row["allergen_check"] = ""
        rows.append(row)
    TAGS.parent.mkdir(parents=True, exist_ok=True)
    with TAGS.open("w", encoding="utf-8-sig", newline="") as f:  # BOM so Excel reads UTF-8
        w = csv.DictWriter(f, fieldnames=TAG_FIELDS)
        w.writeheader()
        w.writerows(rows)
    dropped = set(existing) - set(ids)
    print(f"wrote {len(rows)} rows -> {TAGS}" + (f" (dropped {len(dropped)} deselected)" if dropped else ""))
    return 0


def _int(row: dict, field: str, lo: int, hi: int, errors: list[str], required: bool = True) -> int | None:
    value = (row.get(field) or "").strip()
    if not value:
        if required:
            errors.append(f"{row['idMeal']} {row['title']}: missing {field}")
        return None
    try:
        n = int(value)
    except ValueError:
        errors.append(f"{row['idMeal']}: {field}='{value}' is not a number")
        return None
    if not lo <= n <= hi:
        errors.append(f"{row['idMeal']}: {field}={n} outside {lo}..{hi}")
    return n


def _set(row: dict, field: str, vocab: set[str], errors: list[str], required: bool = True) -> list[str]:
    values = [v.strip().lower() for v in (row.get(field) or "").split("|") if v.strip()]
    for v in values:
        if v not in vocab:
            errors.append(f"{row['idMeal']}: {field} '{v}' not in {sorted(vocab)}")
    if required and not values:
        errors.append(f"{row['idMeal']} {row['title']}: missing {field}")
    return sorted(set(values))


def validate_ingredients(items: list[dict], errors: list[str]) -> None:
    seen = set()
    for ing in items:
        iid = ing.get("id", "")
        if not re.fullmatch(r"[a-z0-9_]+", iid):
            errors.append(f"ingredient id '{iid}' must be snake_case")
        if iid in seen:
            errors.append(f"duplicate ingredient id {iid}")
        seen.add(iid)
        if ing.get("aisle") not in AISLES:
            errors.append(f"{iid}: aisle '{ing.get('aisle')}' not in {sorted(AISLES)}")
        for a in ing.get("allergens", []):
            if a not in ALLERGENS:
                errors.append(f"{iid}: allergen '{a}' not in EU14 list")
        for c in ing.get("contains", []):
            if c not in CONTAINS:
                errors.append(f"{iid}: contains '{c}' not in {sorted(CONTAINS)}")
        if ing.get("protein") and ing["protein"] not in PROTEINS:
            errors.append(f"{iid}: protein '{ing['protein']}' not in {sorted(PROTEINS)}")
        if not isinstance(ing.get("isPantryStaple"), bool):
            errors.append(f"{iid}: isPantryStaple must be true/false")


def cmd_show(meal_ids: list[str]) -> int:
    raw = load_raw()
    _, lookup = load_ingredients()
    for mid in meal_ids:
        m = raw[mid]
        print(f"=== {mid} {m['strMeal']} [{m['strCategory']} / {m.get('strArea') or '?'}]")
        for name, measure in raw_lines(m):
            p = parse_measure(measure)
            parsed = f"{p['amount']}{'-' + str(p['amountMax']) if p['amountMax'] else ''} {p['unit'] or ''} [{p['note'] or ''}]"
            print(f"  {measure:>18} => {parsed:<28} | {name}  -> {lookup.get(norm(name), '??')}")
        for n, step in enumerate(split_steps(m.get("strInstructions") or ""), 1):
            print(f"  {n:2d}. {step[:160]}")
    return 0


def cmd_build(only: list[str] | None = None) -> int:
    raw, ids = load_raw(), load_selection()
    if only:
        missing = set(only) - set(ids)
        if missing:
            print(f"not in selection: {sorted(missing)}")
            return 1
        ids = [i for i in ids if i in set(only)]
    items, lookup = load_ingredients()
    tags = read_tags()
    errors: list[str] = []
    validate_ingredients(items, errors)
    used: set[str] = set()
    recipes = []
    for mid in ids:
        meal, row = raw[mid], tags.get(mid)
        if row is None:
            errors.append(f"{mid}: no row in recipe_tags.csv (run `tags`)")
            continue
        lines = []
        for pos, (name, measure) in enumerate(raw_lines(meal)):
            iid = lookup.get(norm(name))
            if iid is None:
                errors.append(f"{mid}: unmapped ingredient '{name}'")
                continue
            used.add(iid)
            parsed = parse_measure(measure)
            lines.append({"ingredientId": iid, "rawName": name, "rawMeasure": measure, **parsed})
        by_id = {i["id"]: i for i in items}
        for iid, measure in parse_extras(row.get("extra_ingredients") or ""):
            if iid not in by_id:
                errors.append(f"{mid}: extra_ingredients id '{iid}' not in ingredients.csv")
                continue
            used.add(iid)
            lines.append({"ingredientId": iid, "rawName": by_id[iid]["name"], "rawMeasure": measure, **parse_measure(measure)})
        flavor = {f: _int(row, f, 0, 5, errors) for f in FLAVORS}
        cuisine = (row.get("cuisine") or "").strip()
        if not cuisine:
            errors.append(f"{mid} {row['title']}: missing cuisine")
        difficulty = (row.get("difficulty") or "").strip().lower()
        if difficulty not in DIFFICULTIES:
            errors.append(f"{mid}: difficulty '{difficulty}' not in {sorted(DIFFICULTIES)}")
        recipes.append({
            "id": f"mdb-{mid}",
            "title": meal["strMeal"].strip(),
            "cuisine": cuisine,
            "mealTypes": _set(row, "meal_types", MEAL_TYPES, errors),
            "flavor": flavor,
            "textures": _set(row, "textures", TEXTURES, errors, required=False),
            "moods": _set(row, "moods", MOODS, errors, required=False),
            "servings": _int(row, "servings", 1, 24, errors),
            "prepMinutes": _int(row, "prep_minutes", 0, 600, errors),
            "cookMinutes": _int(row, "cook_minutes", 0, 1440, errors),
            "difficulty": difficulty,
            "ingredients": lines,
            "steps": split_steps(meal.get("strInstructions") or ""),
            "imageUrl": None,
            "source": {
                "name": "TheMealDB",
                "sourceId": mid,
                "url": f"https://www.themealdb.com/meal/{mid}",
                "originalUrl": (meal.get("strSource") or "").strip() or None,
            },
        })
        if not recipes[-1]["steps"]:
            errors.append(f"{mid}: no steps")
    if errors:
        print(f"{len(errors)} problem(s):")
        for e in errors[:200]:
            print("  " + e)
        return 1
    shipped = [i for i in items if i["id"] in used]
    dataset = {"version": DATASET_VERSION, "ingredients": shipped, "recipes": recipes}
    ASSET_DIR.mkdir(parents=True, exist_ok=True)
    (ASSET_DIR / "dataset.json").write_text(json.dumps(dataset, ensure_ascii=False, separators=(",", ":")), encoding="utf-8")
    (ASSET_DIR / "manifest.json").write_text(json.dumps({"version": DATASET_VERSION, "file": "dataset.json"}), encoding="utf-8")
    print(f"dataset v{DATASET_VERSION}: {len(recipes)} recipes, {len(shipped)} ingredients -> {ASSET_DIR}")
    return 0


if __name__ == "__main__":
    args = sys.argv[1:]
    if args[:1] == ["show"] and len(args) > 1:
        sys.exit(cmd_show(args[1:]))
    if args[:1] == ["build"] and len(args) == 3 and args[1] == "--ids":
        sys.exit(cmd_build([i.strip() for i in args[2].split(",") if i.strip()]))
    commands = {"report": cmd_report, "tags": cmd_tags, "build": cmd_build}
    if len(args) != 1 or args[0] not in commands:
        print(__doc__)
        sys.exit(2)
    sys.exit(commands[args[0]]())
