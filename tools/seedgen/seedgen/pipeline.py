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


def cmd_build(allow_unreviewed: bool = False) -> int:
    print("build: tagging (Phase C), nutrition (Phase E) and dataset output (Phase F) are not wired yet.")
    return 1
