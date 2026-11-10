"""Snapshot every TheMealDB meal into tools/raw/mealdb_raw.json.

Run once (network needed):  python tools/fetch_mealdb.py
The snapshot is committed, so later pipeline steps work offline.
Uses the public test key "1" (development/testing use only).
"""
import json
import string
import sys
import time
import urllib.request
from pathlib import Path

API = "https://www.themealdb.com/api/json/v1/1/search.php?f={}"
OUT = Path(__file__).parent / "raw" / "mealdb_raw.json"


def fetch(letter: str) -> list[dict]:
    req = urllib.request.Request(API.format(letter), headers={"User-Agent": "recipe-dataset-builder"})
    with urllib.request.urlopen(req, timeout=30) as resp:
        data = json.load(resp)
    return data.get("meals") or []


def main() -> int:
    meals: dict[str, dict] = {}
    for letter in string.ascii_lowercase + string.digits:
        for attempt in range(3):
            try:
                for meal in fetch(letter):
                    meals[meal["idMeal"]] = meal
                break
            except Exception as e:  # noqa: BLE001
                print(f"{letter}: attempt {attempt + 1} failed: {e}", file=sys.stderr)
                time.sleep(2)
        else:
            print(f"giving up on '{letter}'", file=sys.stderr)
            return 1
        time.sleep(0.3)
    OUT.parent.mkdir(parents=True, exist_ok=True)
    ordered = sorted(meals.values(), key=lambda m: int(m["idMeal"]))
    OUT.write_text(json.dumps(ordered, indent=1, ensure_ascii=False), encoding="utf-8")
    print(f"saved {len(ordered)} meals -> {OUT}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
