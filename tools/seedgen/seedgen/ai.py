"""AI gap-fill. The AI is Claude Code working in the repo (no paid API at build time).

`build.py ai-todo` writes out/ai-todo/batch-NNN.md: ~20 recipes, each with the fields the rules
couldn't fill confidently. Claude reads one and writes tags/ai/batch-NNN.json:

    {"batch": 7, "recipes": {"mdb-52772": {"textures": {"value": ["saucy"], "reason": "..."}, ...}}}

Answer files are committed and cached: a recipe that appears in any answer (or pending todo) is
never queued again, so reruns don't redo finished batches. Values outside the vocabulary fail the
build. AI never touches allergens, diets, proteins or ingredient mapping (safety rule).
"""
from __future__ import annotations

import json
import re
from pathlib import Path

from .normalize import Recipe
from .paths import OUT, TAGS_AI
from .tags import AI_FIELDS, CONFIDENT, Proposal, validate_value

BATCH_SIZE = 20
TODO_DIR = OUT / "ai-todo"
_BATCH_RE = re.compile(r"batch-(\d{3})\.(json|md)$")


def _batch_files(directory: Path, ext: str) -> dict[int, Path]:
    out = {}
    if directory.exists():
        for f in directory.iterdir():
            m = _BATCH_RE.search(f.name)
            if m and m.group(2) == ext:
                out[int(m.group(1))] = f
    return out


def load_answers(vocab, cuisines: set[str], directory: Path = TAGS_AI) -> tuple[dict[str, dict], list[str]]:
    """({recipe id: {field: {value, reason, batch}}}, errors)."""
    answers: dict[str, dict] = {}
    errors: list[str] = []
    for n, f in sorted(_batch_files(directory, "json").items()):
        data = json.loads(f.read_text(encoding="utf-8"))
        for rid, fields in data.get("recipes", {}).items():
            for field, entry in fields.items():
                if field not in AI_FIELDS:
                    errors.append(f"{f.name} {rid}: AI may not set '{field}'")
                    continue
                if not isinstance(entry, dict) or "value" not in entry or not entry.get("reason"):
                    errors.append(f"{f.name} {rid}.{field}: needs {{value, reason}}")
                    continue
                err = validate_value(field, entry["value"], vocab, cuisines)
                if err:
                    errors.append(f"{f.name} {rid}: {err}")
                    continue
                answers.setdefault(rid, {})[field] = {"value": entry["value"], "reason": entry["reason"], "batch": n}
    return answers, errors


def gaps(rules: dict[str, Proposal], override: dict[str, object]) -> list[str]:
    return [f for f in AI_FIELDS if f not in override and (f not in rules or rules[f].confidence < CONFIDENT)]


def _todo_ids(directory: Path = TODO_DIR) -> dict[int, list[str]]:
    out = {}
    for n, f in _batch_files(directory, "md").items():
        out[n] = re.findall(r"^### (mdb-\d+)", f.read_text(encoding="utf-8"), re.M)
    return out


def write_todos(recipes: list[Recipe], rules: dict[str, dict[str, Proposal]], overrides: dict[str, dict],
                answers: dict[str, dict], names: dict[str, str],
                priority: list[str] = ()) -> tuple[list[int], int]:
    """Queues recipes with gaps that no answer/todo covers, `priority` ids first (the top-50 review set).
    Returns (pending batch numbers, newly queued)."""
    todos = _todo_ids()
    answered = set(_batch_files(TAGS_AI, "json"))
    covered = set(answers) | {rid for ids in todos.values() for rid in ids}
    queue = [r for r in recipes if r.id not in covered and gaps(rules[r.id], flat_override(overrides.get(r.id, {})))]
    rank = {rid: i for i, rid in enumerate(priority)}
    queue.sort(key=lambda r: (rank.get(r.id, len(rank)), int(r.meal_id)))
    next_n = max([0, *todos, *answered]) + 1
    TODO_DIR.mkdir(parents=True, exist_ok=True)
    for i in range(0, len(queue), BATCH_SIZE):
        chunk = queue[i:i + BATCH_SIZE]
        (TODO_DIR / f"batch-{next_n:03d}.md").write_text(
            _todo_markdown(next_n, chunk, rules, overrides, names), encoding="utf-8")
        todos[next_n] = [r.id for r in chunk]
        next_n += 1
    pending = sorted(n for n in todos if n not in answered)
    return pending, len(queue)


def flat_override(o: dict) -> dict[str, object]:
    """overrides.json entry → {field: value} with flavor split per axis."""
    flat = {k: v for k, v in o.items() if k not in ("flavor", "reviewed", "notes", "extraIngredients", "remapLines")}
    for axis, v in (o.get("flavor") or {}).items():
        flat[f"flavor.{axis}"] = v
    return flat


def _todo_markdown(n: int, chunk: list[Recipe], rules, overrides, names: dict[str, str]) -> str:
    out = [f"# AI tagging batch {n:03d}", "",
           f"Write `tools/seedgen/tags/ai/batch-{n:03d}.json`. For each recipe, give EVERY listed field a",
           "`{\"value\": ..., \"reason\": \"one short line\"}` using only the vocabulary below.", "",
           "- cuisine: an allowed cuisine (TheMealDB area adjective) or \"International\"",
           "- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)",
           "- difficulty: easy | medium | hard",
           "- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth",
           "- moods (1-3): comfort light hearty fresh indulgent festive", ""]
    for r in chunk:
        g = gaps(rules[r.id], flat_override(overrides.get(r.id, {})))
        ings = ", ".join(f"{l.raw_measure} {names.get(l.ingredient_id or '', l.raw_name)}".strip() for l in r.lines)
        method = " ".join(r.steps)
        method = method if len(method) <= 600 else method[:600] + "…"
        out += [f"### {r.id}", f"**{r.title}** · {r.category} · area: {r.area or 'none'}", f"- ingredients: {ings}",
                f"- method ({len(r.steps)} steps): {method}"]
        for f in g:
            p = rules[r.id].get(f)
            out.append(f"- `{f}` rule: {p.value!r} ({p.confidence:.2f}, {p.reason})" if p else f"- `{f}` rule: none")
        out.append("")
    return "\n".join(out)
