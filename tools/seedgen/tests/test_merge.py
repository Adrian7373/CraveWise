import json
import tempfile
import unittest
from pathlib import Path

from _path import seedgen  # noqa: F401
from seedgen import ai, vocab
from seedgen.merge import AI, OVERRIDE, RULE, RULE_LOW, merge
from seedgen.tags import FIELDS, Proposal


def full_rules(conf: float) -> dict:
    values = {"cuisine": "Thai", "mealTypes": ["main"], "textures": ["saucy"], "moods": ["comfort"],
              "servings": 4, "prepMinutes": 10, "cookMinutes": 20, "difficulty": "easy"}
    values |= {f: 2 for f in FIELDS if f.startswith("flavor.")}
    return {f: Proposal(values[f], conf, "rule") for f in FIELDS}


class MergePrecedenceTest(unittest.TestCase):

    def test_override_beats_everything(self):
        values, prov, _ = merge(full_rules(0.9), {"servings": {"value": 6, "reason": "ai", "batch": 1}},
                                {"servings": 2, "flavor": {"spicy": 5}})
        self.assertEqual(values["servings"], 2)
        self.assertEqual(prov["servings"]["source"], OVERRIDE)
        self.assertEqual(values["flavor.spicy"], 5)
        self.assertEqual(values["flavor.sweet"], 2)  # partial flavor override

    def test_confident_rule_beats_ai(self):
        values, prov, _ = merge(full_rules(0.8), {"servings": {"value": 6, "reason": "ai", "batch": 1}}, {})
        self.assertEqual((values["servings"], prov["servings"]["source"]), (4, RULE))

    def test_ai_beats_low_confidence_rule(self):
        values, prov, _ = merge(full_rules(0.3), {"servings": {"value": 6, "reason": "ai", "batch": 1}}, {})
        self.assertEqual((values["servings"], prov["servings"]["source"]), (6, AI))
        self.assertEqual(prov["moods"]["source"], RULE_LOW)

    def test_missing_fields_are_reported(self):
        rules = full_rules(0.9)
        del rules["cuisine"]
        _, _, missing = merge(rules, {}, {})
        self.assertEqual(missing, ["cuisine"])


class AiAnswersTest(unittest.TestCase):

    def test_vocabulary_violations_are_rejected(self):
        with tempfile.TemporaryDirectory() as d:
            Path(d, "batch-001.json").write_text(json.dumps({"batch": 1, "recipes": {"mdb-1": {
                "moods": {"value": ["cozy"], "reason": "x"},
                "textures": {"value": ["saucy"], "reason": "sauce"},
                "flavor.spicy": {"value": 7, "reason": "x"},
                "cuisine": {"value": "Atlantean", "reason": "x"},
                "mealTypes": {"value": ["main"], "reason": "x"},
                "servings": {"value": 4},
            }}}), encoding="utf-8")
            answers, errors = ai.load_answers(vocab.load(), {"Thai", "International"}, Path(d))
        self.assertEqual(answers["mdb-1"]["textures"]["value"], ["saucy"])
        self.assertEqual(set(answers["mdb-1"]), {"textures"})
        self.assertEqual(len(errors), 5)

    def test_gaps_skip_confident_rules_and_overrides(self):
        rules = full_rules(0.9) | {"moods": Proposal(["comfort"], 0.5, "weak")}
        self.assertEqual(ai.gaps(rules, {}), ["moods"])
        self.assertEqual(ai.gaps(rules, {"moods": ["light"]}), [])


if __name__ == "__main__":
    unittest.main()
