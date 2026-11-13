import re
import unittest

from _path import seedgen  # noqa: F401
from seedgen.steps import split_steps

# Same shape as the app's StepTimers pattern (domain/cook/StepTimers.kt), digits only.
TIMER = re.compile(r"\d+(?:\.\d+)?(?:\s*(?:-|–|to|or)\s*\d+)?\s*(?:hours?|hrs?|minutes?|mins?|seconds?|secs?)\b", re.I)


class StepSplitterTest(unittest.TestCase):

    def test_step_headings_are_dropped(self):
        text = "STEP 1\r\nHeat the oil.\r\n\r\nSTEP 2\r\nFry the onion for 5 mins."
        self.assertEqual(split_steps(text), ["Heat the oil.", "Fry the onion for 5 mins."])

    def test_lines_broken_mid_sentence_are_joined(self):
        text = "Heat the oil in a\r\nlarge pan.\r\nAdd the onion."
        self.assertEqual(split_steps(text), ["Heat the oil in a large pan.", "Add the onion."])

    def test_inline_numbering(self):
        text = "1. Boil the pasta. 2. Drain the pasta. 3. Serve."
        self.assertEqual(split_steps(text), ["Boil the pasta.", "Drain the pasta.", "Serve."])

    def test_leading_durations_and_amounts_are_not_step_numbers(self):
        self.assertEqual(split_steps("10 minutes before serving, warm the plates."),
                         ["10 minutes before serving, warm the plates."])
        self.assertEqual(split_steps("2 eggs go in next."), ["2 eggs go in next."])
        self.assertEqual(split_steps("1.5 kg of potatoes, peeled."), ["1.5 kg of potatoes, peeled."])

    def test_timing_phrases_survive_verbatim(self):
        text = ("STEP 1 Simmer for 10-15 minutes until thick. STEP 2 Bake for 1 hour 30 minutes. "
                "STEP 3 Rest for 5 mins, then serve.")
        before = TIMER.findall(text)
        after = [t for s in split_steps(text) for t in TIMER.findall(s)]
        self.assertEqual(before, after)

    def test_a_wall_of_text_is_split_into_sentence_groups(self):
        sentence = "Stir the sauce gently over a low heat and keep an eye on it so that it does not catch. "
        steps = split_steps(sentence * 8)
        self.assertGreater(len(steps), 1)
        self.assertTrue(all(len(s) <= 400 for s in steps))
        self.assertEqual(" ".join(steps), (sentence * 8).strip())

    def test_empty(self):
        self.assertEqual(split_steps(""), [])
        self.assertEqual(split_steps("\r\n\r\n"), [])


if __name__ == "__main__":
    unittest.main()
