import unittest

from _path import seedgen  # noqa: F401
from seedgen.rules import character, difficulty, flavor, times
from seedgen.tags import CONFIDENT
from seedgen.timers import find_seconds


class TimersTest(unittest.TestCase):
    """Mirrors app/src/test/.../StepTimersTest.kt cases."""

    def test_durations(self):
        self.assertEqual(find_seconds("Simmer for 10-15 minutes"), [600])
        self.assertEqual(find_seconds("Bake for 1 hour 30 minutes"), [5400])
        self.assertEqual(find_seconds("rest for half an hour"), [1800])
        self.assertEqual(find_seconds("cook for ½ hour then 5 mins"), [1800, 300])
        self.assertEqual(find_seconds("no time here"), [])


class TimesRuleTest(unittest.TestCase):

    def test_passive_goes_to_prep_and_heat_to_cook(self):
        steps = ["Marinate the beef for 1 hour.", "Fry for 5 minutes, then simmer for 20 minutes."]
        p = times.propose(steps, ingredient_count=6, category="Beef")
        self.assertEqual(p["cookMinutes"].value, 25)  # fry 5 + simmer 20, clause by clause
        self.assertGreaterEqual(p["prepMinutes"].value, 60)
        self.assertGreaterEqual(p["cookMinutes"].confidence, CONFIDENT)

    def test_mixed_step_is_split_by_clause(self):
        p = times.propose(["Leave to marinate for 2 hours, then grill for 10 minutes."], 4, "Chicken")
        self.assertEqual(p["cookMinutes"].value, 10)
        self.assertGreaterEqual(p["prepMinutes"].value, 120)

    def test_overnight_only_without_explicit_duration(self):
        explicit = times.propose(["Marinate for at least 1 hour or overnight."], 4, "Beef")
        self.assertLess(explicit["prepMinutes"].value, 120)
        implicit = times.propose(["Soak the beans overnight."], 4, "Vegetarian")
        self.assertGreaterEqual(implicit["prepMinutes"].value, 480)

    def test_a_second_time_is_not_a_timer(self):
        p = times.propose(["Fry the chicken a second time until dark."], 4, "Chicken")
        self.assertLess(p["cookMinutes"].confidence, CONFIDENT)

    def test_no_durations_is_a_low_confidence_guess(self):
        p = times.propose(["Mix everything.", "Serve."], 3, "Dessert")
        self.assertLess(p["cookMinutes"].confidence, CONFIDENT)


class FlavorRuleTest(unittest.TestCase):

    def test_spice_needs_a_real_chilli(self):
        mild = flavor.propose(["black_pepper", "ginger", "onion"], "Chicken")
        self.assertEqual(mild["flavor.spicy"].value, 0)
        hot = flavor.propose(["scotch_bonnet", "red_chilli", "onion"], "Goat")
        self.assertGreaterEqual(hot["flavor.spicy"].value, 3)

    def test_umami_and_salty_stack(self):
        p = flavor.propose(["spaghetti", "pecorino", "parmesan", "bacon", "egg", "salt"], "Pasta")
        self.assertGreaterEqual(p["flavor.umami"].value, 3)
        self.assertGreaterEqual(p["flavor.salty"].value, 3)

    def test_dessert_floor_and_cap(self):
        p = flavor.propose(["double_cream", "strawberries", "meringue_nests"], "Dessert")
        self.assertGreaterEqual(p["flavor.sweet"].value, 4)
        self.assertLessEqual(p["flavor.umami"].value, 1)

    def test_values_in_range(self):
        p = flavor.propose(["sugar"] * 30, "Dessert")
        self.assertTrue(all(0 <= v.value <= 5 for v in p.values()))


class DifficultyRuleTest(unittest.TestCase):

    def test_simple_is_easy_and_only_clear_hard_is_confident(self):
        easy = difficulty.propose(["Mix.", "Serve."], 4, 15)
        self.assertEqual(easy.value, "easy")
        self.assertLess(easy.confidence, CONFIDENT)
        steps = [f"Step {i}: knead and prove the dough, then deep-fry." for i in range(16)]
        hard = difficulty.propose(steps, 15, 240)
        self.assertEqual(hard.value, "hard")
        self.assertGreaterEqual(hard.confidence, CONFIDENT)


class CharacterRuleTest(unittest.TestCase):

    def test_servings(self):
        self.assertEqual(character.servings("Serves 6. Heat the oven.").value, 6)
        self.assertEqual(character.servings("Cook for 10 minutes.").value, 4)  # "for 10" isn't servings
        self.assertLess(character.servings("Cook for 10 minutes.").confidence, CONFIDENT)

    def test_cuisine_from_title_is_low_confidence(self):
        p = character.cuisine(None, "Thai pumpkin soup", {"Thai", "International"})
        self.assertEqual(p.value, "Thai")
        self.assertLess(p.confidence, CONFIDENT)
        self.assertIsNone(character.cuisine(None, "Cheese Sticks", {"Thai", "International"}))
        self.assertEqual(character.cuisine("Greek", "Moussaka", set()).confidence, 1.0)

    def test_soup_is_brothy(self):
        p = character.textures_moods("Chicken Soup", "Chicken", ["Simmer."], ["chicken"])
        self.assertIn("brothy", p["textures"].value)


if __name__ == "__main__":
    unittest.main()
