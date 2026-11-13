import unittest

from _path import seedgen  # noqa: F401
from seedgen.nutrition import (FRY_ABSORBED, classify_portion, frying_oil, line_grams, score)

ONION = {"each": 110.0, "cup": 160.0, "ml": 0.676}


class LineGramsTest(unittest.TestCase):
    def grams(self, amount, unit=None, portions=ONION, amount_max=None, note=None, raw="x"):
        return line_grams(amount, amount_max, unit, note, raw, portions)[0]

    def test_mass_units_convert(self):
        self.assertAlmostEqual(self.grams(200, "g"), 200)
        self.assertAlmostEqual(self.grams(1, "lb"), 453.592)
        self.assertAlmostEqual(self.grams(2, "oz"), 56.699)

    def test_range_uses_midpoint(self):
        self.assertAlmostEqual(self.grams(1, "kg", amount_max=2), 1500)

    def test_volume_prefers_fdc_portion_then_density(self):
        self.assertAlmostEqual(self.grams(2, "cup"), 320)
        self.assertAlmostEqual(self.grams(1, "tbsp"), 14.7868 * 0.676, places=3)
        self.assertIsNone(self.grams(1, "tbsp", portions={"each": 3}))

    def test_bare_count_uses_each(self):
        self.assertAlmostEqual(self.grams(2), 220)
        self.assertIsNone(self.grams(2, portions={}))

    def test_whole_only_for_one_or_when_said(self):
        chicken = {"each": 200, "whole": 1500}
        self.assertEqual(self.grams(1, portions=chicken), 1500)
        self.assertEqual(self.grams(5, portions=chicken), 1000)
        self.assertEqual(self.grams(2, portions=chicken, note="whole"), 3000)

    def test_pack_size_in_note(self):
        self.assertAlmostEqual(self.grams(2, "can", note="x 400g"), 800)
        self.assertAlmostEqual(self.grams(2, None, note="x 400g"), 800)
        self.assertAlmostEqual(self.grams(1, "can", portions={}), 400)  # generic default

    def test_negligible_and_unparsed(self):
        self.assertEqual(line_grams(None, None, None, None, "to taste", ONION), (0.0, "negligible"))
        self.assertEqual(line_grams(None, None, None, None, "a good glug", ONION)[0], None)

    def test_tiny_units(self):
        self.assertAlmostEqual(self.grams(1, "pinch", portions={}), 0.3)


class PortionTest(unittest.TestCase):
    def test_classify(self):
        toks = {"potato", "flesh", "skin", "raw"}
        self.assertEqual(classify_portion("cup, diced", toks), "cup")
        self.assertEqual(classify_portion("Potato medium (2-1/4\" dia)", toks), "each")
        self.assertEqual(classify_portion("medium", toks), "each")
        self.assertEqual(classify_portion("fl oz", toks), "fl_oz")
        self.assertEqual(classify_portion("stalk, large", toks), "stalk")
        self.assertIsNone(classify_portion("NLEA serving", toks))


class FryingTest(unittest.TestCase):
    oil = {"fat": 100.0, "kcal": 884.0}

    def test_big_oil_in_frying_recipe(self):
        self.assertTrue(frying_oil(600, self.oil, "Heat the oil and deep-fry the balls."))
        self.assertTrue(frying_oil(600, self.oil, "Place in hot oil until golden."))
        self.assertLess(FRY_ABSORBED, 0.5)

    def test_small_oil_or_no_frying_or_not_fat(self):
        self.assertFalse(frying_oil(30, self.oil, "Fry the onions."))
        self.assertFalse(frying_oil(220, self.oil, "Whisk the oil into the cake batter."))
        self.assertFalse(frying_oil(600, {"fat": 81.0}, "Fry in butter."))


class MatchTest(unittest.TestCase):
    def test_prefers_plain_raw_over_processed(self):
        raw = {"desc": "Onions, raw", "cat": "Vegetables", "n": {"kcal": 40}}
        rings = {"desc": "Onion rings, breaded, par fried, frozen, prepared", "cat": "Vegetables", "n": {"kcal": 300}}
        self.assertGreater(score("Onion", raw), score("Onion", rings))

    def test_head_noun_required(self):
        self.assertLess(score("Rice Vinegar", {"desc": "Rice, white, raw", "cat": "", "n": {"kcal": 1}}), 0)


if __name__ == "__main__":
    unittest.main()
