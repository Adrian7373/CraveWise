"""Textures and moods from keyword and category hints, plus servings and cuisine from the text.

These are weak signals, so confidence stays below CONFIDENT unless the hint is unambiguous; AI
fills the gaps and hand overrides win.
"""
from __future__ import annotations

import re

from ..tags import Proposal

TEXTURE_HINTS: dict[str, re.Pattern[str]] = {
    "crispy": re.compile(r"deep[- ]?fr|fried|crisp|breaded|tempura|batter|crackling|pakora|fritter|karaage|schnitzel|katsu", re.I),
    "crunchy": re.compile(r"crunch|crumble|slaw|nuts? |peanut|almond|walnut|toasted seeds|granola|brittle|biscuit base", re.I),
    "creamy": re.compile(r"cream|creamy|coconut milk|risotto|mash|custard|yog(h)?urt sauce|carbonara|alfredo|korma|cheese sauce|bechamel|mousse", re.I),
    "saucy": re.compile(r"\bsauce\b|curry|stew|gravy|braise|ragu|bolognese|masala|tagine|casserole|chilli con", re.I),
    "brothy": re.compile(r"\bsoup\b|broth|ramen|pho|consomm|chowder|bouillabaisse|laksa", re.I),
    "tender": re.compile(r"slow[- ]?cook|braise|stew|pot roast|shank|brisket|pulled|confit|low heat for \d+ hours?", re.I),
    "fluffy": re.compile(r"pancake|sponge|souffl|fluffy|light and airy|scone|bread roll|dumpling|couscous", re.I),
    "flaky": re.compile(r"puff pastry|filo|phyllo|croissant|flaky|shortcrust|pie crust|pastry|baklava|flakes? (of )?fish", re.I),
    "chewy": re.compile(r"noodle|mochi|chewy|bagel|brownie|cookie|gnocchi|udon|glutinous|tapioca", re.I),
    "smooth": re.compile(r"blend until smooth|puree|purée|hummus|smooth|pate|pâté|panna cotta|velvety", re.I),
}
MOOD_HINTS: dict[str, re.Pattern[str]] = {
    "comfort": re.compile(r"soup|stew|pie|bake|casserole|curry|mac(aroni)? (and|&) cheese|mash|pudding|lasagne|hotpot|gratin|crumble|risotto|dumpling", re.I),
    "hearty": re.compile(r"stew|pie|roast|casserole|hotpot|chilli|brisket|shank|sausage|bean|lentil|potato|steak|burger|ragu|goulash", re.I),
    "light": re.compile(r"salad|steamed|poached|grilled fish|ceviche|broth|summer rolls|spring rolls|sorbet|crudo|tartare", re.I),
    "fresh": re.compile(r"salad|herb|mint|lime|lemon|ceviche|salsa|raw|slaw|cucumber|tabbouleh|summer", re.I),
    "indulgent": re.compile(r"chocolate|cream|cheese|fried|caramel|bacon|butter|brownie|cheesecake|doughnut|donut|fudge|tart|gateau", re.I),
    "festive": re.compile(r"christmas|xmas|easter|thanksgiving|wellington|roast turkey|celebrat|party|festive|yule|stollen|panettone|eid|diwali", re.I),
}
STRONG_TEXTURE = {"brothy": re.compile(r"\bsoup\b|broth|ramen|pho|laksa", re.I),
                  "crispy": re.compile(r"deep[- ]?fr|tempura|karaage|schnitzel|katsu|pakora|fritter", re.I)}
SERVES = re.compile(r"\b(?:serves|feeds)\s+(\d{1,2})\b"
                    r"|\bfor\s+(\d{1,2})\s+(?:people|persons|portions|servings)\b"
                    r"|\bmakes\s+(\d{1,2})\s+(?:portions|servings)\b", re.I)


def textures_moods(title: str, category: str, steps: list[str], ingredient_ids: list[str]) -> dict[str, Proposal]:
    text = " ".join([title, " ".join(steps), " ".join(i.replace("_", " ") for i in ingredient_ids)])
    title_text = title
    textures = sorted(t for t, rx in TEXTURE_HINTS.items() if rx.search(text))[:3]
    moods = sorted(m for m, rx in MOOD_HINTS.items() if rx.search(title_text) or (m != "festive" and rx.search(text)))
    if category == "Dessert" and "indulgent" not in moods:
        moods.append("indulgent")
    moods = sorted(set(moods))[:3]
    strong = [t for t, rx in STRONG_TEXTURE.items() if rx.search(title)]
    tex_conf = 0.75 if strong else 0.5
    return {
        "textures": Proposal(sorted(set(textures) | set(strong))[:3], tex_conf,
                             f"keywords: {', '.join(textures) or 'none'}"),
        "moods": Proposal(moods, 0.5, f"keywords/category: {', '.join(moods) or 'none'}"),
    }


def servings(text: str) -> Proposal:
    for m in SERVES.finditer(text):
        n = int(next(g for g in m.groups() if g))
        if 1 <= n <= 24:
            return Proposal(n, 0.9, f"method says '{m.group(0).strip()}'")
    return Proposal(4, 0.3, "not stated; default 4")


def cuisine(area_cuisine: str | None, title: str, allowed: set[str]) -> Proposal | None:
    if area_cuisine:
        return Proposal(area_cuisine, 1.0, "TheMealDB area")
    for c in sorted(allowed, key=len, reverse=True):
        if c != "International" and re.search(rf"\b{re.escape(c)}\b", title, re.I):
            return Proposal(c, 0.6, f"title mentions '{c}'")
    return None
