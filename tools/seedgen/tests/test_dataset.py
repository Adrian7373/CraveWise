import copy
import json
import random
import unittest

from _path import seedgen  # noqa: F401
from seedgen import dataset as D, vocab
from seedgen.normalize import Line, Recipe

CUISINES = {"Thai", "Italian"}
VALUES = {"cuisine": "Thai", "mealTypes": ["main"], "textures": ["saucy"], "moods": ["comfort"],
          "servings": 2, "prepMinutes": 10, "cookMinutes": 5, "difficulty": "easy",
          **{f"flavor.{f}": 1 for f in D.FLAVORS}}
ITEMS = [
    {"id": "beef", "name": "Beef", "synonyms": ["Beef Strips"], "aisle": "meat_seafood", "allergens": [],
     "contains": ["meat"], "protein": "beef", "isPantryStaple": False, "reviewed": True},
    {"id": "soy_sauce", "name": "Soy Sauce", "synonyms": [], "aisle": "condiments", "allergens": ["soy", "gluten"],
     "contains": [], "protein": None, "isPantryStaple": True, "reviewed": True},
    {"id": "unused", "name": "Unused", "synonyms": [], "aisle": "other", "allergens": [], "contains": [],
     "protein": None, "isPantryStaple": False, "reviewed": False},
]
PER100 = {"beef": {"fdcId": 1, "kcal": 250.0, "protein": 26.0, "carbs": 0.0, "fat": 15.0, "fiber": 0.0,
                   "sugar": 0.0, "sodium": 72.0}, "soy_sauce": None}


def recipe(mid: str, title: str = "Stir-fry") -> Recipe:
    return Recipe(id=f"mdb-{mid}", meal_id=mid, title=title, category="Beef", area="Thai", cuisine="Thai",
                  meal_types=["main"],
                  lines=[Line("Beef", "400g", "beef", 400.0, None, "g", None),
                         Line("Soy Sauce", "To taste", "soy_sauce", None, None, None, "To taste")],
                  steps=["Fry the beef for 3 minutes.", "Add soy sauce."], instructions="Fry.",
                  source_url=f"https://www.themealdb.com/meal/{mid}", original_url=None, thumb_url="https://x/t.jpg")


def build(recipes=None, items=None, values=None):
    recipes = recipes or [recipe("2"), recipe("1", "Noodles")]
    merged = {r.id: (dict(values or VALUES), {}, []) for r in recipes}
    grams = {(r.id, 0): 400.0 for r in recipes} | {(r.id, 1): 0.0 for r in recipes}
    return D.assemble(items or ITEMS, recipes, merged, PER100, grams)


REVIEWED = {i["id"]: i["reviewed"] for i in ITEMS}


def problems(data, **kw):
    kw.setdefault("reviewed", REVIEWED)
    return D.validate(data, vocab=vocab.load(), cuisines=CUISINES, **kw)


class ValidatorTest(unittest.TestCase):

    def assertOneProblem(self, data, needle, **kw):
        errs = problems(data, **kw)
        self.assertTrue(any(needle in e for e in errs), f"{needle!r} not in {errs}")

    def test_valid_dataset_passes_and_ships_only_used_ingredients(self):
        data = build()
        self.assertEqual(problems(data), [])
        self.assertEqual([i["id"] for i in data["ingredients"]], ["beef", "soy_sauce"])
        # The thumbnail URL ships so the app can offer an opt-in photo download.
        self.assertEqual(data["recipes"][0]["imageUrl"], "https://x/t.jpg")

    def test_unknown_ingredient_id(self):
        r = recipe("1")
        r.lines[0].ingredient_id = "unicorn"
        self.assertOneProblem(build([r]), "unknown ingredient id 'unicorn'")

    def test_unmapped_line(self):
        r = recipe("1")
        r.lines[0].ingredient_id = None
        self.assertOneProblem(build([r]), "unmapped ingredient")

    def test_vocabulary_violation_in_tags(self):
        self.assertOneProblem(build(values=VALUES | {"moods": ["cozy"]}), "moods")
        self.assertOneProblem(build(values=VALUES | {"difficulty": "brutal"}), "difficulty")
        self.assertOneProblem(build(values=VALUES | {"cuisine": "Atlantean"}), "cuisine")

    def test_vocabulary_violation_in_ingredients_and_units(self):
        items = copy.deepcopy(ITEMS)
        items[0]["aisle"] = "garage"
        self.assertOneProblem(build(items=items), "aisle 'garage'")
        r = recipe("1")
        r.lines[0].unit = "bucket"
        self.assertOneProblem(build([r]), "unit 'bucket'")

    def test_flavor_out_of_range(self):
        self.assertOneProblem(build(values=VALUES | {"flavor.spicy": 6}), "flavor.spicy")
        self.assertOneProblem(build(values=VALUES | {"flavor.sweet": -1}), "flavor.sweet")

    def test_negative_or_missing_time(self):
        self.assertOneProblem(build(values=VALUES | {"cookMinutes": -5}), "cookMinutes")
        missing = dict(VALUES)
        del missing["prepMinutes"]
        self.assertOneProblem(build(values=missing), "prepMinutes missing")

    def test_duplicate_recipe_id(self):
        self.assertOneProblem(build([recipe("1"), recipe("1")]), "duplicate recipe id 'mdb-1'")

    def test_duplicate_ingredient_id(self):
        items = ITEMS + [dict(ITEMS[0], synonyms=[])]
        self.assertOneProblem(build(items=items), "duplicate ingredient id 'beef'")

    def test_unreviewed_ingredient_blocks_unless_allowed(self):
        reviewed = REVIEWED | {"soy_sauce": False}
        self.assertOneProblem(build(), "soy_sauce: allergens not reviewed", reviewed=reviewed)
        self.assertEqual(problems(build(), reviewed=reviewed, allow_unreviewed=True), [])

    def test_tag_all_errors_fail_the_build(self):
        self.assertOneProblem(build(), "remapLines", tag_errors=["overrides mdb-1: remapLines matched 0 lines"])

    def test_schema_mismatch(self):
        data = build()
        data["recipes"][0]["servings"] = 2.5          # Int in SeedModels
        data["recipes"][0]["source"]["url"] = None    # non-null String
        data["ingredients"][0]["colour"] = "red"      # not a SeedIngredient field
        del data["recipes"][1]["steps"]
        errs = problems(data)
        for needle in ("recipes[0].servings", "source.url: null", "unknown key 'colour'", "missing steps"):
            self.assertTrue(any(needle in e for e in errs), f"{needle!r} not in {errs}")

    def test_reports_every_problem_not_just_the_first(self):
        r1, r2 = recipe("1"), recipe("2")
        r1.lines[0].ingredient_id = "unicorn"
        r2.lines[0].unit = "bucket"
        errs = problems(build([r1, r2], values=VALUES | {"flavor.spicy": 9}))
        self.assertGreaterEqual(len(errs), 4)


class DeterminismTest(unittest.TestCase):

    def test_input_order_does_not_change_output(self):
        recipes = [recipe(str(i), f"Dish {i}") for i in range(10)]
        items = copy.deepcopy(ITEMS)
        a = D.dumps(build(recipes, items))
        random.Random(7).shuffle(recipes)
        items.reverse()
        items[0]["synonyms"] = list(reversed(items[0]["synonyms"]))
        b = D.dumps(build(recipes, items, values=VALUES | {"moods": ["comfort"], "mealTypes": ["main"]}))
        self.assertEqual(a, b)

    def test_repeat_dumps_are_byte_identical_and_sorted(self):
        data = build()
        text = D.dumps(data)
        self.assertEqual(text, D.dumps(json.loads(text)))
        self.assertTrue(text.endswith("\n"))
        self.assertEqual(D.manifest(data, text, False), D.manifest(json.loads(text), D.dumps(json.loads(text)), False))

    def test_manifest_counts_hash_and_unreviewed_flag(self):
        data = build()
        text = D.dumps(data)
        m = D.manifest(data, text, unreviewed=False)
        self.assertEqual((m["version"], m["file"]), (D.DATASET_VERSION, "dataset.json"))
        self.assertEqual(m["counts"]["recipes"], 2)
        self.assertEqual(m["counts"]["lines"], 4)
        self.assertEqual(len(m["sha256"]), 64)
        self.assertNotIn("unreviewed", m)
        self.assertTrue(D.manifest(data, text, unreviewed=True)["unreviewed"])


if __name__ == "__main__":
    unittest.main()
