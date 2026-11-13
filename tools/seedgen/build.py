"""CraveWise seed generator (offline, Python 3.10+, stdlib only).

    python tools/seedgen/build.py                 # full build: fetch (cached) → … → assets/seed/
    python tools/seedgen/build.py fetch [--refresh]
    python tools/seedgen/build.py ingredients     # propose new canonical ingredients + review sheet
    python tools/seedgen/build.py report          # Phase A+B stats (dedupe, measures, cuisines)
    python tools/seedgen/build.py tags            # rules + AI + overrides; queues out/ai-todo/batch-NNN.md
    python tools/seedgen/build.py review          # out/review-top50.md, out/audit.md, out/provenance.json
    python tools/seedgen/build.py show 52772 …    # print meals as the pipeline sees them

See CLAUDE.md "Seed pipeline" for the layout and review workflow.
"""
from __future__ import annotations

import argparse
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))

from seedgen import fetch  # noqa: E402


def main(argv: list[str]) -> int:
    p = argparse.ArgumentParser(prog="build.py", description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    p.add_argument("command", nargs="?", default="build", choices=["build", "fetch", "ingredients", "report", "show", "tags", "review"])
    p.add_argument("ids", nargs="*")
    p.add_argument("--refresh", action="store_true", help="re-download cached TheMealDB responses")
    p.add_argument("--allow-unreviewed", action="store_true",
                   help="LOCAL TESTING ONLY: ship ingredients whose allergens aren't reviewed (flags the manifest)")
    a = p.parse_args(argv)

    if a.command in ("fetch", "build"):
        n = fetch.fetch_all(refresh=a.refresh)
        print(f"fetch: {n} request(s) downloaded, rest cached")
        if a.command == "fetch":
            return 0
    from seedgen import pipeline  # imported late so `fetch` works on a bare checkout
    if a.command == "ingredients":
        return pipeline.cmd_ingredients()
    if a.command == "report":
        return pipeline.cmd_report()
    if a.command == "tags":
        return pipeline.cmd_tags()
    if a.command == "review":
        return pipeline.cmd_review()
    if a.command == "show":
        return pipeline.cmd_show(a.ids)
    return pipeline.cmd_build(allow_unreviewed=a.allow_unreviewed)


if __name__ == "__main__":
    sys.exit(main(sys.argv[1:]))
