"""Phase F: assemble, validate and write the app's seed files (assets/seed/dataset.json + manifest.json).

The output mirrors `data/seed/SeedModels.kt` exactly. Derived tags (allergens, diets, proteins) are NOT
written: the app derives them on import from the ingredient table (safety rule). Provenance stays in
out/. `imageUrl` is TheMealDB's thumbnail URL (no size suffix); the app downloads photos only when the
user opts in, and never needs them to work.

Output is deterministic: keys sorted, ingredients and recipes sorted by id, set-like lists sorted,
no timestamps. Re-running with unchanged inputs gives a byte-identical file.
"""
from __future__ import annotations

import hashlib
import json

from .tags import FIELDS, FLAVORS, validate_value

DATASET_VERSION = 3
DATASET_FILE = "dataset.json"
MANIFEST_FILE = "manifest.json"
SOURCE_NAME = "TheMealDB"


# ---- assembly -----------------------------------------------------------------------------------
def ingredient_seed(ing: dict, nutrition: dict | None) -> dict:
    return {
        "id": ing["id"], "name": ing["name"], "synonyms": sorted(ing.get("synonyms", [])),
        "aisle": ing.get("aisle"), "allergens": sorted(ing.get("allergens", [])),
        "contains": sorted(ing.get("contains", [])), "protein": ing.get("protein"),
        "isPantryStaple": ing.get("isPantryStaple"),
        "nutrition": dict(nutrition) if nutrition else None,
    }


def recipe_seed(r, values: dict, grams: dict) -> dict:
    """One SeedRecipe. `values` are merged tags (a missing field becomes None and fails validation)."""
    lines = []
    for pos, l in enumerate(r.lines):
        line = l.to_seed()
        line["grams"] = grams.get((r.id, pos))
        lines.append(line)
    return {
        "id": r.id, "title": r.title, "cuisine": values.get("cuisine"),
        "mealTypes": _sorted(values.get("mealTypes")),
        "flavor": {f: values.get(f"flavor.{f}") for f in FLAVORS},
        "textures": _sorted(values.get("textures", [])), "moods": _sorted(values.get("moods", [])),
        "servings": values.get("servings"), "prepMinutes": values.get("prepMinutes"),
        "cookMinutes": values.get("cookMinutes"), "difficulty": values.get("difficulty"),
        "ingredients": lines, "steps": list(r.steps),
        "imageUrl": getattr(r, "thumb_url", None),  # opt-in photo download in the app
        "source": {"name": SOURCE_NAME, "sourceId": r.meal_id, "url": r.source_url, "originalUrl": r.original_url},
    }


def _sorted(v):
    return sorted(v) if isinstance(v, list) else v


def assemble(items: list[dict], recipes, merged: dict, per100: dict, grams: dict) -> dict:
    """The dataset dict. Ships every ingredient a recipe uses (unknown ids stay on the lines so the
    validator reports them). Lists, not dicts, so duplicate ids survive to validation."""
    out_recipes = [recipe_seed(r, merged[r.id][0], grams) for r in recipes]
    used = {l["ingredientId"] for r in out_recipes for l in r["ingredients"]}
    out_ings = [ingredient_seed(i, per100.get(i["id"])) for i in items if i["id"] in used]
    return {"version": DATASET_VERSION,
            "ingredients": sorted(out_ings, key=lambda i: i["id"]),
            "recipes": sorted(out_recipes, key=lambda r: r["id"])}


# ---- schema (mirror of SeedModels.kt) -------------------------------------------------------------
STR, INT, NUM, BOOL = "str", "int", "num", "bool"


def _is(kind: str, v) -> bool:
    if kind == STR:
        return isinstance(v, str)
    if kind == BOOL:
        return isinstance(v, bool)
    if kind == INT:
        return isinstance(v, int) and not isinstance(v, bool)
    if kind == NUM:
        return isinstance(v, (int, float)) and not isinstance(v, bool)
    raise ValueError(kind)


# field -> (type, required, nullable). type is a primitive, ("list", primitive) or ("obj", SCHEMA).
NUTRITION_SCHEMA = {"fdcId": (INT, True, False), **{k: (NUM, True, False) for k in
                    ("kcal", "protein", "carbs", "fat", "fiber", "sugar", "sodium")}}
INGREDIENT_SCHEMA = {
    "id": (STR, True, False), "name": (STR, True, False), "synonyms": (("list", STR), False, False),
    "aisle": (STR, True, False), "allergens": (("list", STR), False, False),
    "contains": (("list", STR), False, False), "protein": (STR, False, True),
    "isPantryStaple": (BOOL, True, False), "nutrition": (("obj", NUTRITION_SCHEMA), False, True),
}
FLAVOR_SCHEMA = {f: (INT, True, False) for f in FLAVORS}
LINE_SCHEMA = {
    "ingredientId": (STR, True, False), "rawName": (STR, True, False), "rawMeasure": (STR, True, False),
    "amount": (NUM, False, True), "amountMax": (NUM, False, True), "unit": (STR, False, True),
    "note": (STR, False, True), "grams": (NUM, False, True),
}
SOURCE_SCHEMA = {"name": (STR, True, False), "sourceId": (STR, True, False), "url": (STR, True, False),
                 "originalUrl": (STR, False, True)}
RECIPE_SCHEMA = {
    "id": (STR, True, False), "title": (STR, True, False), "cuisine": (STR, True, False),
    "mealTypes": (("list", STR), True, False), "flavor": (("obj", FLAVOR_SCHEMA), True, False),
    "textures": (("list", STR), False, False), "moods": (("list", STR), False, False),
    "servings": (INT, True, False), "prepMinutes": (INT, True, False), "cookMinutes": (INT, True, False),
    "difficulty": (STR, True, False), "ingredients": (("list", ("obj", LINE_SCHEMA)), True, False),
    "steps": (("list", STR), True, False), "imageUrl": (STR, False, True),
    "source": (("obj", SOURCE_SCHEMA), True, False),
}
DATASET_SCHEMA = {
    "version": (INT, True, False),
    "ingredients": (("list", ("obj", INGREDIENT_SCHEMA)), True, False),
    "recipes": (("list", ("obj", RECIPE_SCHEMA)), True, False),
}


def _check(value, kind, where: str, errors: list[str]) -> None:
    if isinstance(kind, tuple) and kind[0] == "list":
        if not isinstance(value, list):
            errors.append(f"schema {where}: expected a list, got {type(value).__name__}")
            return
        for i, v in enumerate(value):
            _check(v, kind[1], f"{where}[{i}]", errors)
    elif isinstance(kind, tuple) and kind[0] == "obj":
        check_object(value, kind[1], where, errors)
    elif not _is(kind, value):
        errors.append(f"schema {where}: expected {kind}, got {value!r}")


def check_object(obj, schema: dict, where: str, errors: list[str]) -> None:
    if not isinstance(obj, dict):
        errors.append(f"schema {where}: expected an object, got {type(obj).__name__}")
        return
    for key in sorted(set(obj) - set(schema)):
        errors.append(f"schema {where}: unknown key {key!r} (not in SeedModels.kt)")
    for key, (kind, required, nullable) in schema.items():
        if key not in obj:
            if required:
                errors.append(f"schema {where}: missing {key}")
            continue
        if obj[key] is None:
            if not nullable:
                errors.append(f"schema {where}.{key}: null not allowed")
            continue
        _check(obj[key], kind, f"{where}.{key}", errors)


def check_schema(dataset: dict) -> list[str]:
    errors: list[str] = []
    check_object(dataset, DATASET_SCHEMA, "dataset", errors)
    return errors


# ---- validation ---------------------------------------------------------------------------------
def _dupes(ids: list[str]) -> list[str]:
    seen, dup = set(), []
    for i in ids:
        if i in seen and i not in dup:
            dup.append(i)
        seen.add(i)
    return dup


def validate(dataset: dict, *, vocab, cuisines: set[str], reviewed: dict[str, bool],
             tag_errors: list[str] = (), allow_unreviewed: bool = False) -> list[str]:
    """Every problem in the dataset (empty = shippable). Never stops at the first one.

    `reviewed` is ingredient id -> the `reviewed` flag from curation/ingredients.json (the allergen
    sign-off). `tag_errors` are tag_all's errors (bad remapLines / extraIngredients / AI answers).
    """
    errors = [f"tags: {e}" for e in tag_errors]
    errors += check_schema(dataset)
    ings = [i for i in dataset.get("ingredients", []) if isinstance(i, dict)]
    recipes = [r for r in dataset.get("recipes", []) if isinstance(r, dict)]
    if dataset.get("version") != DATASET_VERSION:
        errors.append(f"dataset version {dataset.get('version')!r}, expected {DATASET_VERSION}")

    errors += [f"duplicate ingredient id {i!r}" for i in _dupes([i.get("id") for i in ings])]
    errors += [f"duplicate recipe id {i!r}" for i in _dupes([r.get("id") for r in recipes])]

    known = {i.get("id") for i in ings}
    synonyms: dict[str, str] = {}
    for ing in ings:
        iid = ing.get("id")
        if ing.get("aisle") not in vocab.aisles:
            errors.append(f"ingredient {iid}: aisle {ing.get('aisle')!r} not in vocabulary")
        for a in ing.get("allergens") or []:
            if a not in vocab.allergens:
                errors.append(f"ingredient {iid}: allergen {a!r} not in vocabulary")
        for c in ing.get("contains") or []:
            if c not in vocab.contains:
                errors.append(f"ingredient {iid}: contains {c!r} not in vocabulary")
        if ing.get("protein") is not None and ing.get("protein") not in vocab.proteins:
            errors.append(f"ingredient {iid}: protein {ing.get('protein')!r} not in vocabulary")
        for name in {_norm(n) for n in [ing.get("name") or "", *(ing.get("synonyms") or [])]}:
            if name in synonyms and synonyms[name] != iid:
                errors.append(f"ingredient {iid}: synonym {name!r} also belongs to {synonyms[name]}")
            synonyms.setdefault(name, iid)
        if not reviewed.get(iid) and not allow_unreviewed:
            errors.append(f"ingredient {iid}: allergens not reviewed (reviewed: false in ingredients.json); "
                          f"review it or pass --allow-unreviewed for a local test build")

    for r in recipes:
        rid = r.get("id")
        for f in FIELDS:
            value = _field(r, f)
            if value is None:
                errors.append(f"recipe {rid}: {f} missing")
            elif (e := validate_value(f, value, vocab, cuisines)):
                errors.append(f"recipe {rid}: {e}")
        if not r.get("ingredients"):
            errors.append(f"recipe {rid}: no ingredients")
        if not r.get("steps") or any(not isinstance(s, str) or not s.strip() for s in r.get("steps") or []):
            errors.append(f"recipe {rid}: empty steps")
        for pos, l in enumerate(r.get("ingredients") or []):
            if not isinstance(l, dict):
                continue
            iid = l.get("ingredientId")
            if iid is None:
                errors.append(f"recipe {rid} line {pos} ({l.get('rawName')!r}): unmapped ingredient")
            elif iid not in known:
                errors.append(f"recipe {rid} line {pos}: unknown ingredient id {iid!r}")
            if l.get("unit") is not None and l.get("unit") not in vocab.units:
                errors.append(f"recipe {rid} line {pos}: unit {l.get('unit')!r} not in vocabulary")
            if isinstance(l.get("grams"), (int, float)) and l["grams"] < 0:
                errors.append(f"recipe {rid} line {pos}: negative grams {l['grams']}")
    return errors


def _field(recipe: dict, f: str):
    if f.startswith("flavor."):
        flavor = recipe.get("flavor")
        return flavor.get(f.split(".", 1)[1]) if isinstance(flavor, dict) else None
    return recipe.get(f)


def _norm(s: str) -> str:
    return " ".join(s.lower().split())


# ---- output -------------------------------------------------------------------------------------
def dumps(dataset: dict) -> str:
    """Compact, sorted, UTF-8 JSON plus a trailing newline: byte-stable across runs."""
    return json.dumps(dataset, sort_keys=True, separators=(",", ":"), ensure_ascii=False) + "\n"


def manifest(dataset: dict, text: str, unreviewed: bool) -> dict:
    """SeedManifest (version + file) plus counts and a content hash. The app ignores the extra keys."""
    recipes = dataset["recipes"]
    lines = [l for r in recipes for l in r["ingredients"]]
    m = {
        "version": dataset["version"], "file": DATASET_FILE,
        "sha256": hashlib.sha256(text.encode("utf-8")).hexdigest(),
        "counts": {"recipes": len(recipes), "ingredients": len(dataset["ingredients"]), "lines": len(lines),
                   "linesWeighed": sum(1 for l in lines if l["grams"] is not None),
                   "ingredientsWithNutrition": sum(1 for i in dataset["ingredients"] if i["nutrition"])},
    }
    if unreviewed:
        m["unreviewed"] = True  # built with --allow-unreviewed: never ship this
    return m


def manifest_dumps(m: dict) -> str:
    return json.dumps(m, sort_keys=True, indent=1, ensure_ascii=False) + "\n"
