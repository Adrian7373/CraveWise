import unittest

from _path import seedgen  # noqa: F401
from seedgen import vocab


class VocabularyTest(unittest.TestCase):

    def test_parses_enum_serial_names(self):
        src = '''
        @Serializable
        enum class Mood(val label: String) {
            @SerialName("comfort") Comfort("Comfort"),
            @SerialName("light") Light("Light"),
        }
        '''
        self.assertEqual(vocab.parse_enums(src), {"Mood": ["comfort", "light"]})

    def test_reads_the_apps_vocabulary(self):
        v = vocab.load()
        self.assertIn("tree_nuts", v.allergens)
        self.assertEqual(len(v.allergens), 14)
        self.assertIn("fl_oz", v.units)
        self.assertEqual(v.difficulties, {"easy", "medium", "hard"})
        self.assertIn("no_pork_no_alcohol", v.diets)


if __name__ == "__main__":
    unittest.main()
