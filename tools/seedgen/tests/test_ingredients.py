import unittest

from _path import seedgen  # noqa: F401
from seedgen import vocab
from seedgen.ingredients import IngredientTable, canonical_key, propose, propose_facts, to_id
from seedgen.paths import INGREDIENTS

ORIGINAL_34 = {
    "basil", "bacon", "beef", "black_pepper", "butter", "bread", "chicken", "chorizo", "double_cream", "egg",
    "egg_yolk", "garlic", "ginger", "ginger_cordial", "lemon", "meringue_nests", "mint", "morcilla", "olive_oil",
    "onion", "oyster_sauce", "parmesan", "pecorino", "potato_starch", "red_chilli", "sake", "salt", "spaghetti",
    "soy_sauce", "strawberries", "sugar", "tomato", "vegetable_oil", "water",
}


class CanonicalKeyTest(unittest.TestCase):

    def test_near_duplicates_merge(self):
        for raw in ["Garlic", "Garlic Clove", "minced garlic", "Garlic Bulb"]:
            self.assertEqual(canonical_key(raw), "garlic", raw)
        self.assertEqual(canonical_key("Gruyère"), canonical_key("Gruyere Cheese"))
        self.assertEqual(canonical_key("Chopped Parsley"), "parsley")
        self.assertEqual(canonical_key("Potatoes"), "potato")

    def test_explicit_merges_beat_prep_stripping(self):
        # "chopped tomatoes" is the canned product, not fresh tomatoes.
        self.assertEqual(canonical_key("Chopped Tomatoes"), "chopped tomatoes")
        self.assertEqual(canonical_key("Tinned Tomatos"), "chopped tomatoes")
        self.assertEqual(canonical_key("Plum Tomatoes"), "tomato")

    def test_not_over_singularized(self):
        self.assertEqual(canonical_key("Molasses"), "molasses")
        self.assertEqual(canonical_key("Couscous"), "couscous")
        self.assertEqual(to_id("chilli flakes"), "chilli_flakes")


class ProposalTest(unittest.TestCase):
    """Rule proposals are drafts for review; these pin the obvious cases."""

    def test_allergens_and_flags(self):
        self.assertEqual(propose_facts("peanut butter")["allergens"], ["peanuts"])
        self.assertEqual(propose_facts("coconut milk")["allergens"], [])
        self.assertEqual(propose_facts("butter bean")["allergens"], [])
        self.assertIn("milk", propose_facts("cream cheese")["allergens"])
        self.assertEqual(propose_facts("rice flour")["allergens"], [])
        self.assertIn("gluten", propose_facts("plain flour")["allergens"])
        self.assertEqual(propose_facts("breadfruit")["allergens"], [])
        self.assertIn("pork", propose_facts("chorizo")["contains"])
        self.assertNotIn("poultry", propose_facts("duck sauce")["contains"])
        self.assertEqual(propose_facts("chicken thigh")["protein"], "chicken")
        self.assertIsNone(propose_facts("chicken stock")["protein"])
        self.assertEqual(propose_facts("beef stock")["aisle"], "condiments")

    def test_proposals_use_the_vocabulary(self):
        v = vocab.load()
        for key in ["prawn", "sesame oil", "worcestershire sauce", "lamb shoulder", "tofu", "red lentil"]:
            f = propose_facts(key)
            self.assertIn(f["aisle"], v.aisles)
            self.assertLessEqual(set(f["allergens"]), v.allergens)
            self.assertLessEqual(set(f["contains"]), v.contains)
            self.assertIn(f["protein"], v.proteins | {None})

    def test_new_entries_are_unreviewed_and_existing_are_kept(self):
        table = IngredientTable([{"id": "garlic", "name": "Garlic", "synonyms": [], "aisle": "produce",
                                  "allergens": [], "contains": [], "protein": None, "isPantryStaple": True,
                                  "reviewed": True, "notes": ""}])
        table.reindex()
        added = propose(table, {"Garlic Clove": 3, "Minced Garlic": 1, "Smoked Haddock": 2})
        self.assertEqual([a["id"] for a in added], ["smoked_haddock"])
        self.assertFalse(added[0]["reviewed"])
        self.assertEqual(added[0]["allergens"], ["fish"])
        garlic = table.by_id["garlic"]
        self.assertTrue(garlic["reviewed"])
        self.assertEqual(table.resolve("garlic clove"), "garlic")


class CuratedTableTest(unittest.TestCase):

    def test_original_ids_are_kept(self):
        ids = {i["id"] for i in IngredientTable.load(INGREDIENTS).items}
        self.assertLessEqual(ORIGINAL_34, ids)

    def test_curated_values_are_in_the_vocabulary(self):
        v = vocab.load()
        for i in IngredientTable.load(INGREDIENTS).items:
            self.assertIn(i["aisle"], v.aisles, i["id"])
            self.assertLessEqual(set(i["allergens"]), v.allergens, i["id"])
            self.assertLessEqual(set(i["contains"]), v.contains, i["id"])
            self.assertIn(i["protein"], v.proteins | {None}, i["id"])
            self.assertIsInstance(i["reviewed"], bool, i["id"])


if __name__ == "__main__":
    unittest.main()
