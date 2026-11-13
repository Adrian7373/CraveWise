"""Flavor 0–5 per axis from ingredient ids (weights), scaled by how many lines the recipe has."""
from __future__ import annotations

import math
import re

from ..tags import FLAVORS, Proposal

# (pattern on the ingredient id with "_" as spaces, weight). First match per axis wins per line.
WEIGHTS: dict[str, list[tuple[re.Pattern[str], float]]] = {
    "spicy": [
        (re.compile(r"scotch bonnet|habanero|bird.?s? eye|birds eye|ghost|carolina"), 3.0),
        (re.compile(r"chilli|chili|chile|cayenne|jalapeno|gochujang|sriracha|hot sauce|harissa|pul biber|"
                    r"curry paste|chilli bean|doubanjiang|piri|peri|jerk|wasabi|kimchi|tabasco|ancho"), 2.0),
        (re.compile(r"curry powder|garam masala|madras|sichuan|szechuan|horseradish|cajun|ras el hanout|"
                    r"red pepper paste|hot "), 1.0),
        (re.compile(r"black pepper|peppercorn|ginger|mustard|white pepper|kampot"), 0.3),
    ],
    "umami": [
        (re.compile(r"soy sauce|fish sauce|miso|anchov|oyster sauce|parmesan|pecorino|worcestershire|"
                    r"shrimp paste|dried shrimp|doubanjiang|shiitake|bonito|dashi|marmite|prahok|msg"), 2.0),
        (re.compile(r"mushroom|tomato puree|tomato paste|stock|gravy|bacon|ham|chorizo|cheese|cheddar|"
                    r"gruyere|beef|lamb|pork|chicken|duck|turkey|goat|sausage|prosciutto|salami|tomato ketchup|"
                    r"seaweed|nori|black bean|salt cod|sardine|tuna|mackerel|prawn|clam|mussel|squid|crab"), 1.0),
        (re.compile(r"tomato|onion|garlic|egg|fish|salmon|cod|haddock"), 0.3),
    ],
    "sweet": [
        (re.compile(r"sugar|honey|syrup|treacle|molasses|condensed|caramel|dulce de leche|marzipan|"
                    r"chocolate|jam|marshmallow|custard|ice cream|nutella|sweet chilli|mincemeat|meringue|"
                    r"turkish delight|nougat|toffee|mars bar|oreo|digestive|biscuit|cookie|glace|candied"), 2.0),
        (re.compile(r"date|raisin|sultana|currant|apricot|fig|prune|banana|mango|pineapple|apple|pear|peach|"
                    r"berr|cherr|plum|orange|coconut milk|coconut cream|desiccated coconut|sweet potato|"
                    r"hoisin|mirin|plum sauce|duck sauce|tomato ketchup|barbeque|vanilla|cinnamon|cocoa"), 1.0),
        (re.compile(r"carrot|onion|red pepper|sweetcorn|pumpkin|squash|pea|beetroot|parsnip|milk|cream"), 0.3),
    ],
    "sour": [
        (re.compile(r"lemon|lime|vinegar|tamarind|sumac|pomegranate molasses|sauerkraut|pickle|kimchi|"
                    r"rhubarb|cranberr|sour|grapefruit|capers|green mango|unripe|sorrel"), 2.0),
        (re.compile(r"yog(h)?urt|creme fraiche|buttermilk|wine|tomato|passata|orange|raspberr|blackberr|"
                    r"redcurrant|blackcurrant|kefir|quark|cider|chopped tomatoes"), 1.0),
        (re.compile(r"feta|goats cheese|mustard|worcestershire|apple"), 0.3),
    ],
    "bitter": [
        (re.compile(r"coffee|cocoa|cacao|dark chocolate|plain chocolate|endive|radicchio|chicory|bitter|"
                    r"grapefruit|fenugreek|dandelion|bitter melon|kale|rocket|mustard green|beer|stout"), 2.0),
        (re.compile(r"turmeric|olive|walnut|saffron|broccoli|cabbage|aubergine|orange zest|lemon zest|"
                    r"dill|sage|rosemary|thyme|bay leaf|oregano|caraway|cumin|charred|spinach|tahini"), 0.5),
    ],
    "salty": [
        (re.compile(r"soy sauce|fish sauce|anchov|salt cod|miso|shrimp paste|dried shrimp|prahok|"
                    r"capers|olive|bacon|ham|prosciutto|chorizo|salami|pancetta|feta|halloumi|parmesan|"
                    r"pecorino|stock|gravy|sauerkraut|pickle|smoked salmon|smoked haddock|corned beef|"
                    r"kabanos|kielbasa|sausage|oyster sauce|worcestershire|bouillon|seasoning|cheese|cheddar|"
                    r"gruyere|soya bean"), 1.5),
        (re.compile(r"^salt$|sea salt|kosher|celery salt|onion salt|butter|tomato ketchup|hoisin|"
                    r"mustard|crisps|pretzel|tortilla chip"), 0.6),
    ],
}

# Recipe-level nudges from TheMealDB category.
CATEGORY_FLOOR = {"Dessert": {"sweet": 4}}
CATEGORY_CAP = {"Dessert": {"umami": 1, "salty": 2}}


def score(weight_sum: float, lines: int) -> int:
    """Saturating curve: one strong ingredient ≈ 2–3, several ≈ 4–5. Longer lists dilute a little."""
    dilution = 1.0 + max(0, lines - 8) * 0.04
    return max(0, min(5, round(5 * (1 - math.exp(-weight_sum / (2.6 * dilution))))))


def propose(ingredient_ids: list[str], category: str) -> dict[str, Proposal]:
    names = [iid.replace("_", " ") for iid in ingredient_ids]
    out: dict[str, Proposal] = {}
    for axis in FLAVORS:
        total, hits = 0.0, []
        for name in names:
            for rx, w in WEIGHTS.get(axis, []):
                if rx.search(name):
                    total += w
                    if w >= 1:
                        hits.append(name)
                    break
        value = score(total, len(names))
        if axis == "spicy" and not hits:
            value = 0  # black pepper / ginger alone don't make a dish hot (spice is a hard filter)
        value = max(value, CATEGORY_FLOOR.get(category, {}).get(axis, 0))
        value = min(value, CATEGORY_CAP.get(category, {}).get(axis, 5))
        conf = 0.8 if hits or value == 0 else 0.55  # only weak signals: let AI judge
        reason = f"from {', '.join(sorted(set(hits))[:4])}" if hits else ("no strong ingredient" if value == 0 else "weak signals only")
        out[f"flavor.{axis}"] = Proposal(value, conf, reason)
    return out
