"""Per-field precedence: override > confident rule > AI > low-confidence rule.

Returns the chosen values plus provenance (source + reason per field), which goes to
out/provenance.json and the review sheets, never into the app's dataset.
"""
from __future__ import annotations

from .ai import flat_override
from .tags import CONFIDENT, FIELDS, Proposal

OVERRIDE, RULE, AI, RULE_LOW = "override", "rule", "ai", "rule-low"


def merge(rules: dict[str, Proposal], ai: dict[str, dict], override: dict) -> tuple[dict, dict, list[str]]:
    """(values {field: value}, provenance {field: {source, reason}}, missing fields)."""
    flat = flat_override(override)
    values: dict = {}
    prov: dict = {}
    missing: list[str] = []
    for f in FIELDS:
        rule = rules.get(f)
        if f in flat:
            values[f], prov[f] = flat[f], {"source": OVERRIDE, "reason": override.get("notes") or "hand override"}
        elif rule is not None and rule.confidence >= CONFIDENT:
            values[f], prov[f] = rule.value, {"source": RULE, "reason": rule.reason, "confidence": rule.confidence}
        elif f in ai:
            values[f], prov[f] = ai[f]["value"], {"source": AI, "reason": ai[f]["reason"], "batch": ai[f]["batch"]}
        elif rule is not None:
            values[f], prov[f] = rule.value, {"source": RULE_LOW, "reason": rule.reason, "confidence": rule.confidence}
        else:
            missing.append(f)
    return values, prov, missing
