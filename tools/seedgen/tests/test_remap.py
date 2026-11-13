import unittest
from types import SimpleNamespace

from _path import seedgen  # noqa: F401
from seedgen.ai import flat_override
from seedgen.normalize import Line
from seedgen.pipeline import remap_lines

TABLE = SimpleNamespace(by_id={"black_pepper": {}, "red_pepper": {}, "beef_mince": {}})


def recipe(*lines):
    return SimpleNamespace(id="mdb-1", lines=[Line(name, measure, "black_pepper") for name, measure in lines])


class RemapLinesTest(unittest.TestCase):

    def test_remaps_only_the_line_with_matching_name_and_measure(self):
        r = recipe(("Pepper", "1 red"), ("Pepper", "pinch"))
        errors = remap_lines([r], {"mdb-1": {"remapLines": [
            {"rawName": "pepper", "rawMeasure": "1  Red", "ingredientId": "red_pepper"}]}}, TABLE)
        self.assertEqual(errors, [])
        self.assertEqual([l.ingredient_id for l in r.lines], ["red_pepper", "black_pepper"])

    def test_ambiguous_or_missing_match_is_an_error_and_changes_nothing(self):
        r = recipe(("Pepper", "1"), ("Pepper", "1"))
        errors = remap_lines([r], {"mdb-1": {"remapLines": [
            {"rawName": "Pepper", "rawMeasure": "1", "ingredientId": "red_pepper"},
            {"rawName": "Salt", "rawMeasure": "1", "ingredientId": "red_pepper"}]}}, TABLE)
        self.assertEqual(len(errors), 2)
        self.assertEqual({l.ingredient_id for l in r.lines}, {"black_pepper"})

    def test_unknown_ingredient_id_is_an_error(self):
        r = recipe(("Pepper", "1"))
        errors = remap_lines([r], {"mdb-1": {"remapLines": [
            {"rawName": "Pepper", "rawMeasure": "1", "ingredientId": "bell_pepper"}]}}, TABLE)
        self.assertEqual(len(errors), 1)
        self.assertEqual(r.lines[0].ingredient_id, "black_pepper")

    def test_remap_lines_is_not_a_tag_field(self):
        self.assertNotIn("remapLines", flat_override({"remapLines": [], "cuisine": "Saudi"}))


if __name__ == "__main__":
    unittest.main()
