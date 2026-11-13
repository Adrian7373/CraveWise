"""Commands behind build.py. Each phase lives in its own module; this file only wires them."""
from __future__ import annotations

import re
from collections import Counter

from . import normalize as N
from . import reports
from .ingredients import IngredientTable, norm, propose
from .measures import is_negligible
from .paths import INGREDIENTS_REVIEW


def _raw_counts() -> Counter:
    from . import fetch
    exclude = N.load_exclude()
    counts: Counter = Counter()
    for m in fetch.load_meals():
        if m["idMeal"] in exclude:
            continue
        for name, _ in N.raw_lines(m):
            counts[name] += 1
    return counts


def cmd_ingredients() -> int:
    """Drafts canonical entries for every unmapped raw ingredient and rewrites the review sheet."""
    from . import fetch
    N.write_exclude(N.find_duplicates(fetch.load_meals()))
    N.write_cuisines_if_missing()
    table = IngredientTable.load()
    counts = _raw_counts()
    added = propose(table, dict(counts))
    table.save()
    uses = Counter()
    for raw, n in counts.items():
        if (iid := table.resolve(raw)):
            uses[iid] += n
    INGREDIENTS_REVIEW.write_text(reports.ingredients_review(table, uses), encoding="utf-8")
    pending = sum(1 for i in table.items if not i.get("reviewed"))
    print(f"ingredients: {len(added)} proposed, {len(table.items)} total, {pending} awaiting review "
          f"-> {INGREDIENTS_REVIEW.name}")
    return 0


def cmd_report() -> int:
    """Phase A+B checkpoint stats."""
    table = IngredientTable.load()
    recipes, exclude = N.load_recipes(table)
    lines = [l for r in recipes for l in r.lines]
    unmapped = Counter(l.raw_name for l in lines if l.ingredient_id is None)
    parsed = sum(1 for l in lines if l.amount is not None)
    negligible = sum(1 for l in lines if l.amount is None and is_negligible(l.raw_measure))
    unparsed = Counter(norm(l.raw_measure) for l in lines if l.amount is None and not is_negligible(l.raw_measure))
    no_cuisine = [r for r in recipes if r.cuisine is None]
    unknown_area = Counter(r.area for r in recipes if r.area and r.cuisine is None)
    odd_steps = [r for r in recipes if not r.steps or (len(r.steps) == 1 and len(r.steps[0]) > 400) or len(r.steps) > 25]
    print(f"recipes: {len(recipes)} ship, {len(exclude)} excluded")
    print(f"lines: {len(lines)}; parsed amount {parsed} ({parsed / len(lines):.0%}), negligible {negligible}, "
          f"unparsed {sum(unparsed.values())}; unmapped ingredient strings {len(unmapped)}")
    print(f"zero parsed amounts: {sum(1 for r in recipes if not any(l.amount for l in r.lines))} recipe(s)")
    print(f"no cuisine: {len(no_cuisine)} (unrecognized areas: {dict(unknown_area)})")
    print(f"step split needs a look: {len(odd_steps)} {[r.meal_id for r in odd_steps]}")
    print("meal types:", dict(Counter(t for r in recipes for t in r.meal_types)))
    print("top unparsed measures:", unparsed.most_common(40))
    if unmapped:
        print("unmapped:", unmapped.most_common(30))
    return 0


def cmd_show(meal_ids: list[str]) -> int:
    table = IngredientTable.load()
    recipes, _ = N.load_recipes(table)
    wanted = {re.sub(r"^mdb-", "", i) for i in meal_ids}
    for r in recipes:
        if r.meal_id not in wanted:
            continue
        print(f"=== {r.id} {r.title} [{r.category} / {r.area or '?'} -> {r.cuisine or '?'}] {r.meal_types}")
        for l in r.lines:
            rng = f"-{l.amount_max:g}" if l.amount_max else ""
            amt = f"{l.amount:g}{rng}" if l.amount is not None else "-"
            print(f"  {l.raw_measure:>22} => {amt:>6} {l.unit or '':<6} [{l.note or ''}] | {l.raw_name} -> {l.ingredient_id or '??'}")
        for n, s in enumerate(r.steps, 1):
            print(f"  {n:2d}. {s[:150]}")
    return 0


def top50_ids() -> list[str]:
    import json
    from .paths import CURATION
    f = CURATION / "top50.json"
    return json.loads(f.read_text(encoding="utf-8"))["ids"] if f.exists() else []


def add_extra_ingredients(recipes, overrides: dict, table: IngredientTable) -> list[str]:
    """Appends `extraIngredients` from overrides.json as real lines, e.g. the egg TheMealDB forgot to
    list for Egg Drop Soup. They count for allergens/diets like any other line (safety rule)."""
    from .measures import parse_measure
    by_id = table.by_id
    errors = []
    for r in recipes:
        for extra in overrides.get(r.id, {}).get("extraIngredients", []):
            iid = extra.get("ingredientId")
            if iid not in by_id:
                errors.append(f"overrides {r.id}: extraIngredients id {iid!r} not in ingredients.json")
                continue
            raw = extra.get("rawMeasure", "")
            p = parse_measure(raw)
            r.lines.append(N.Line(by_id[iid]["name"], raw, iid, p["amount"], p["amountMax"], p["unit"], p["note"]))
    return errors


def tag_all(table: IngredientTable):
    """Normalize, run rules, load AI answers and overrides, merge. Shared by tags/review/build."""
    import json
    from . import ai, rules, vocab
    from .merge import merge
    from .paths import OVERRIDES
    recipes, exclude = N.load_recipes(table)
    allowed = N.allowed_cuisines()
    v = vocab.load()
    overrides = json.loads(OVERRIDES.read_text(encoding="utf-8")) if OVERRIDES.exists() else {}
    errors = add_extra_ingredients(recipes, overrides, table)
    proposals = {r.id: rules.propose(r, allowed) for r in recipes}
    answers, ai_errors = ai.load_answers(v, allowed)
    errors += ai_errors
    merged = {}
    for r in recipes:
        merged[r.id] = merge(proposals[r.id], answers.get(r.id, {}), overrides.get(r.id, {}))
    return recipes, proposals, answers, overrides, merged, errors


def cmd_tags() -> int:
    """Queues AI batches for rule gaps and prints where each field's value comes from."""
    from . import ai
    table = IngredientTable.load()
    recipes, proposals, answers, overrides, merged, errors = tag_all(table)
    names = {i["id"]: i["name"] for i in table.items}
    pending, queued = ai.write_todos(recipes, proposals, overrides, answers, names, top50_ids())
    sources: dict[str, Counter] = {}
    for _, prov, missing in merged.values():
        for f, p in prov.items():
            sources.setdefault(f, Counter())[p["source"]] += 1
        for f in missing:
            sources.setdefault(f, Counter())["MISSING"] += 1
    for f, c in sources.items():
        print(f"  {f:<14} {dict(c)}")
    print(f"AI: {len(answers)} recipes answered, {queued} newly queued, pending batches: {pending}")
    for e in errors:
        print("  ERROR " + e)
    return 1 if errors else 0


def cmd_review() -> int:
    """Writes out/review-top50.md, out/audit.md and out/provenance.json."""
    from . import review, vocab
    from .paths import OUT
    table = IngredientTable.load()
    recipes, proposals, answers, overrides, merged, errors = tag_all(table)
    by_id = table.by_id
    ids = [i for i in top50_ids() if i in merged]
    rmap = {r.id: r for r in recipes}
    OUT.mkdir(parents=True, exist_ok=True)
    (OUT / "review-top50.md").write_text(review.review_sheet(ids, rmap, merged, overrides, by_id), encoding="utf-8")
    (OUT / "audit.md").write_text(
        review.audit(recipes, merged, by_id, vocab.load(), N.allowed_cuisines(), errors), encoding="utf-8")
    review.write_json(OUT / "provenance.json", review.provenance(merged))
    print(f"review: {len(ids)} recipes -> out/review-top50.md, audit -> out/audit.md, provenance -> out/provenance.json")
    return 0


def cmd_build(allow_unreviewed: bool = False) -> int:
    print("build: tagging (Phase C), nutrition (Phase E) and dataset output (Phase F) are not wired yet.")
    return 1
