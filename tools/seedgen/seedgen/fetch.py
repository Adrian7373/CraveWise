"""Phase A: TheMealDB V1 (public test key "1") → raw/mealdb/*.json, one file per request.

Cached files are never re-fetched unless `refresh=True`. Requests run one at a time with a delay.
"""
from __future__ import annotations

import json
import string
import sys
import time
import urllib.request
from pathlib import Path

from .paths import RAW_MEALDB

API = "https://www.themealdb.com/api/json/v1/1/"
USER_AGENT = "recipe-dataset-builder"
DELAY_S = 0.5
LETTERS = string.ascii_lowercase + string.digits

# cache file name -> API path
LISTS = {"list_i.json": "list.php?i=list", "list_a.json": "list.php?a=list", "list_c.json": "list.php?c=list"}


def search_file(letter: str) -> str:
    return f"search_f_{letter}.json"


def requests() -> dict[str, str]:
    return {search_file(c): f"search.php?f={c}" for c in LETTERS} | LISTS


def _get(path: str) -> dict:
    req = urllib.request.Request(API + path, headers={"User-Agent": USER_AGENT})
    with urllib.request.urlopen(req, timeout=30) as resp:
        return json.load(resp)


def fetch_all(refresh: bool = False, cache: Path = RAW_MEALDB) -> int:
    """Fetches every missing (or, with refresh, every) request. Returns how many were fetched."""
    cache.mkdir(parents=True, exist_ok=True)
    fetched = 0
    for name, path in requests().items():
        f = cache / name
        if f.exists() and not refresh:
            continue
        for attempt in range(3):
            try:
                _write(f, _get(path))
                fetched += 1
                break
            except Exception as e:  # noqa: BLE001
                print(f"  {path}: attempt {attempt + 1} failed: {e}", file=sys.stderr)
                time.sleep(2)
        else:
            raise SystemExit(f"giving up on {path}")
        time.sleep(DELAY_S)
    return fetched


def load_meals(cache: Path = RAW_MEALDB) -> list[dict]:
    """Every cached meal, deduplicated by idMeal, ordered by id."""
    meals: dict[str, dict] = {}
    for c in LETTERS:
        f = cache / search_file(c)
        if not f.exists():
            raise SystemExit(f"missing {f}; run build.py fetch")
        for m in json.loads(f.read_text(encoding="utf-8")).get("meals") or []:
            meals[m["idMeal"]] = m
    return sorted(meals.values(), key=lambda m: int(m["idMeal"]))


def load_list(name: str, cache: Path = RAW_MEALDB) -> list[dict]:
    f = cache / name
    return json.loads(f.read_text(encoding="utf-8")).get("meals") or [] if f.exists() else []


def _write(f: Path, data: dict) -> None:
    f.write_text(json.dumps(data, indent=1, ensure_ascii=False) + "\n", encoding="utf-8")
