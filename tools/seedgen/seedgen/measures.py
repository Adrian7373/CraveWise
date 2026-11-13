"""Phase B.2: TheMealDB `strMeasureN` text → {amount, amountMax, unit, note}.

Units are the `MeasureUnit` serial names from Vocabulary.kt (checked in tests and at build time),
the same ones `ShoppingQuantities` / `RecipeScaling` work with. The app never re-parses: it shows
`rawMeasure` and uses the parsed fields for scaling, shopping merges and nutrition.

Contract that keeps `RecipeScaling` correct: `amount` is always the number the raw text STARTS
with (it swaps that leading number). So "2 x 400g tins" is amount 2 (unit can), not 800 g.
"""
from __future__ import annotations

import re
from fractions import Fraction

UNIT_ALIASES: dict[str, str] = {
    "g": "g", "gr": "g", "grs": "g", "gram": "g", "grams": "g", "gms": "g", "gm": "g",
    "kg": "kg", "kgs": "kg", "kilo": "kg", "kilos": "kg", "kilogram": "kg", "kilograms": "kg",
    "ml": "ml", "mls": "ml", "millilitre": "ml", "millilitres": "ml", "milliliter": "ml", "milliliters": "ml",
    "l": "l", "litre": "l", "litres": "l", "liter": "l", "liters": "l", "ltr": "l", "ltrs": "l",
    "tsp": "tsp", "tsps": "tsp", "teaspoon": "tsp", "teaspoons": "tsp", "tspn": "tsp", "t": "tsp",
    "tbsp": "tbsp", "tbsps": "tbsp", "tbs": "tbsp", "tbls": "tbsp", "tblsp": "tbsp", "tbl": "tbsp",
    "tablespoon": "tbsp", "tablespoons": "tbsp", "tbspn": "tbsp", "tbsb": "tbsp",
    "cup": "cup", "cups": "cup", "c": "cup",
    "oz": "oz", "ounce": "oz", "ounces": "oz", "onz": "oz",
    "fl oz": "fl_oz", "floz": "fl_oz", "fluid ounce": "fl_oz", "fluid ounces": "fl_oz",
    "lb": "lb", "lbs": "lb", "pound": "lb", "pounds": "lb",
    "cm": "cm",
    "pinch": "pinch", "pinches": "pinch", "dash": "dash", "dashes": "dash",
    "splash": "splash", "splashes": "splash",
    "clove": "clove", "cloves": "clove", "slice": "slice", "slices": "slice",
    "can": "can", "cans": "can", "tin": "can", "tins": "can",
    "bunch": "bunch", "bunches": "bunch", "sprig": "sprig", "sprigs": "sprig",
    "handful": "handful", "handfuls": "handful", "handfull": "handful", "stick": "stick", "sticks": "stick",
    "packet": "packet", "packets": "packet", "pack": "packet", "packs": "packet",
    "package": "packet", "packages": "packet", "sachet": "packet", "sachets": "packet",
    "jar": "jar", "jars": "jar", "sheet": "sheet", "sheets": "sheet",
    "leaf": "leaf", "leaves": "leaf", "head": "head", "heads": "head", "stalk": "stalk", "stalks": "stalk",
    "piece": "piece", "pieces": "piece", "knob": "knob", "knobs": "knob",
    "fillet": "fillet", "fillets": "fillet", "bottle": "bottle", "bottles": "bottle",
}

UNICODE_FRACTIONS = {"½": "1/2", "⅓": "1/3", "⅔": "2/3", "¼": "1/4", "¾": "3/4", "⅛": "1/8"}
NUMBER_WORDS = {"a": "1", "an": "1", "one": "1", "two": "2", "three": "3", "four": "4", "five": "5",
                "six": "6", "seven": "7", "eight": "8", "nine": "9", "ten": "10", "twelve": "12",
                "half": "1/2", "a half": "1/2", "half a": "1/2", "a quarter": "1/4", "quarter": "1/4"}
# Lines that are deliberately unmeasured. Nutrition treats them as negligible (0 g).
NEGLIGIBLE_RE = re.compile(r"^(to taste|to serve|garnish|to garnish|for garnish|as needed|as required|"
                           r"optional|for frying|for greasing|for dusting|to season|season|sprinkle|"
                           r"sprinkling|sprinking|spinkling|dusting|drizzle|a drizzle|a little|little|some|"
                           r"few drops|pinch|dash|splash|topping|top|to glaze|for brushing|for the top)\b", re.I)
# "Juice of 1", "zest and juice of 2", "the juice and zest of one": a count of the fruit.
_OF_FRUIT = re.compile(r"^(?:the\s+)?(?:grated\s+)?(zest|juice)(?:\s*(?:and|/|&)\s*(zest|juice))?\s+of\s+(.+)$", re.I)

NUM = r"(?:\d+\s+\d+/\d+|\d+/\d+|\d+(?:[.,]\d+)?)"
LEADING = re.compile(rf"^(?P<a>{NUM})\s*(?:(?:-|–|to|or)\s*(?P<b>{NUM}))?\s*(?P<rest>.*)$")
MULTIPLY = re.compile(r"^x\s*(?=\d)")
_PREFIX = re.compile(r"^(?:about|approx\.?|approximately|around|roughly|c\.)\s+", re.I)
_TOKEN = re.compile(r"[a-z]+|[^\sa-z]+")


def _num(text: str) -> float:
    text = text.replace(",", ".").strip()
    if " " in text:
        whole, frac = text.split()
        return float(int(whole) + Fraction(frac))
    return float(Fraction(text)) if "/" in text else float(text)


def _normalize(raw: str) -> str:
    s = raw.strip().lower()
    for k, v in UNICODE_FRACTIONS.items():
        s = re.sub(rf"(\d){k}", rf"\1 {v}", s).replace(k, v)
    s = _PREFIX.sub("", s)
    for word in sorted(NUMBER_WORDS, key=len, reverse=True):
        if re.match(rf"^{word}\b", s) and not re.match(rf"^{word}\s+(?:little|few|bit)\b", s):
            # "a pinch" -> "1 pinch"; but "a little" stays text.
            s = NUMBER_WORDS[word] + s[len(word):]
            break
    return s


_SIZE_WORDS = {"small", "large", "medium", "big", "generous", "heaped", "heaping", "level", "rounded",
               "good", "thumb", "thumb-sized"}


def _unit_at(words: list[str]) -> tuple[str | None, int]:
    """(unit, words consumed) for the unit word(s) at the start of `words`; "heaped tbsp" counts."""
    skip = 1 if words and words[0] in _SIZE_WORDS else 0
    for n in (2, 1):
        if len(words) >= skip + n:
            key = " ".join(words[skip:skip + n]).rstrip(".")
            if key in UNIT_ALIASES:
                return UNIT_ALIASES[key], skip + n
    return None, 0


def parse_measure(raw: str) -> dict:
    """'1 1/2 cups chopped' -> {amount: 1.5, amountMax: None, unit: 'cup', note: 'chopped'}."""
    out: dict = {"amount": None, "amountMax": None, "unit": None, "note": None}
    text = (raw or "").strip()
    if not text:
        return out
    s = _normalize(text)
    fruit = _OF_FRUIT.match(s)
    if fruit:
        inner = parse_measure(fruit.group(3))
        if inner["amount"] is not None and inner["unit"] is None:
            parts = " and ".join(p for p in fruit.group(1, 2) if p)
            return out | {"amount": inner["amount"], "amountMax": inner["amountMax"], "note": parts}
    m = LEADING.match(s)
    rest = s
    if m:
        try:
            a = _num(m["a"])
            b = _num(m["b"]) if m["b"] else None
        except (ValueError, ZeroDivisionError):
            return out | {"note": text}
        if a <= 0:
            return out | {"note": text}
        # "2-1/2 cups" / "1-½" is a mixed number written with a hyphen, not a range.
        if b is not None and b < 1 and "/" in (m["b"] or "") and a == int(a):
            a, b = a + b, None
        out["amount"] = round(a, 3)
        out["amountMax"] = round(b, 3) if b is not None and b > a else None
        rest = m["rest"].strip()
        # "2 x 400g tins": the count leads; the pack size goes to the note, the container is the unit.
        if MULTIPLY.match(rest):
            inner = parse_measure(MULTIPLY.sub("", rest))
            container = inner["note"] and _unit_at(inner["note"].split())[0]
            out["unit"] = container if container in {"can", "jar", "packet", "bottle"} else None
            size = f"{inner['amount']:g}{inner['unit'] or ''}" if inner["amount"] else ""
            out["note"] = f"x {size}".strip()
            return out
    # Split "g/7oz" and "g(7oz)" so alternatives don't glue onto the unit word.
    rest = re.sub(r"([/()])", r" \1 ", rest)
    words = rest.replace(",", " , ").split()
    unit, used = _unit_at(words)
    if unit:
        out["unit"] = unit
        words = words[used:]
        if out["amount"] is None:
            out["amount"] = 1.0  # "Pinch", "Dash" with no number
    note = " ".join(words)
    note = re.sub(r"\s+([,)])", r"\1", note).replace("( ", "(")
    note = note.strip(" ,/").strip() or None
    if out["amount"] is None:
        out["note"] = text  # "to taste", "garnish", ...
    else:
        out["note"] = note
    return out


def is_negligible(raw: str) -> bool:
    """True for deliberately unmeasured lines ("to taste", "pinch", "garnish")."""
    return bool(NEGLIGIBLE_RE.match((raw or "").strip()))
