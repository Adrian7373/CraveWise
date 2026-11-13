import unittest

from _path import seedgen  # noqa: F401
from seedgen import vocab
from seedgen.measures import UNIT_ALIASES, is_negligible, parse_measure


def p(raw):
    r = parse_measure(raw)
    return r["amount"], r["amountMax"], r["unit"], r["note"]


class MeasureParserTest(unittest.TestCase):

    def test_units_are_the_apps_measure_units(self):
        self.assertLessEqual(set(UNIT_ALIASES.values()), vocab.load().units)

    def test_plain_numbers_and_units(self):
        self.assertEqual(p("200g"), (200, None, "g", None))
        self.assertEqual(p("200 grams"), (200, None, "g", None))
        self.assertEqual(p("1.5kg"), (1.5, None, "kg", None))
        self.assertEqual(p("1,5 kg"), (1.5, None, "kg", None))
        self.assertEqual(p("3tbsp"), (3, None, "tbsp", None))
        self.assertEqual(p("2 cloves"), (2, None, "clove", None))
        self.assertEqual(p("12 fl oz"), (12, None, "fl_oz", None))
        self.assertEqual(p("2"), (2, None, None, None))

    def test_fractions(self):
        self.assertEqual(p("1/2 tsp"), (0.5, None, "tsp", None))
        self.assertEqual(p("1 1/2 cups"), (1.5, None, "cup", None))
        self.assertEqual(p("½ cup"), (0.5, None, "cup", None))
        self.assertEqual(p("1½ cups"), (1.5, None, "cup", None))
        self.assertEqual(p("2-1/2 cups"), (2.5, None, "cup", None))
        self.assertEqual(p("1-½ cups"), (1.5, None, "cup", None))

    def test_ranges(self):
        self.assertEqual(p("2-3 tbsp"), (2, 3, "tbsp", None))
        self.assertEqual(p("½-1 tsp"), (0.5, 1, "tsp", None))
        self.assertEqual(p("4 to 6"), (4, 6, None, None))

    def test_words(self):
        self.assertEqual(p("Pinch"), (1, None, "pinch", None))
        self.assertEqual(p("a pinch"), (1, None, "pinch", None))
        self.assertEqual(p("Dash"), (1, None, "dash", None))
        self.assertEqual(p("Large handful"), (1, None, "handful", None))
        self.assertEqual(p("1 heaped tbsp"), (1, None, "tbsp", None))
        self.assertEqual(p("one"), (1, None, None, None))
        self.assertEqual(p("half"), (0.5, None, None, None))

    def test_unparsed_keeps_the_text(self):
        self.assertEqual(p("To taste"), (None, None, None, "To taste"))
        self.assertEqual(p("chopped"), (None, None, None, "chopped"))
        self.assertEqual(p(""), (None, None, None, None))
        self.assertEqual(p("a little"), (None, None, None, "a little"))

    def test_mixed_metric_imperial_keeps_the_first(self):
        self.assertEqual(p("200g/7oz"), (200, None, "g", "7oz"))
        self.assertEqual(p("1 lb / 450g"), (1, None, "lb", "450g"))
        self.assertEqual(p("1 can (400g)"), (1, None, "can", "(400g)"))

    def test_multiplied_packs_keep_the_leading_count(self):
        # RecipeScaling swaps the leading number, so amount must be the 2, not 800 g.
        self.assertEqual(p("2 x 400g tins"), (2, None, "can", "x 400g"))
        self.assertEqual(p("2 x 400g"), (2, None, None, "x 400g"))

    def test_juice_of_fruit_is_a_count(self):
        self.assertEqual(p("Juice of 1"), (1, None, None, "juice"))
        self.assertEqual(p("zest and juice of 2"), (2, None, None, "zest and juice"))
        self.assertEqual(p("juice of half"), (0.5, None, None, "juice"))
        self.assertEqual(p("the juice and zest of one"), (1, None, None, "juice and zest"))

    def test_negligible_lines(self):
        for raw in ["To taste", "pinch", "Garnish", "to serve", "Topping", "for brushing"]:
            self.assertTrue(is_negligible(raw), raw)
        for raw in ["chopped", "200g", ""]:
            self.assertFalse(is_negligible(raw), raw)


if __name__ == "__main__":
    unittest.main()
