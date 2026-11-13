"""Phase B.1: TheMealDB ingredient strings → canonical ingredient ids.

`curation/ingredients.json` is the source of truth (hand-editable). Each entry:
    {id, name, synonyms[], aisle, allergens[], contains[], protein, isPantryStaple,
     reviewed, notes, proposal?}
A raw string maps to an id when its normalized form equals the entry's name or a synonym.

For strings nothing maps yet, `propose()` groups them by `canonical_key()` (accents folded, prep
words like "chopped"/"fresh" dropped, singular, plus the MERGES table) and drafts new entries with
RULE-PROPOSED aisle / allergens / contains / protein / staple, all `reviewed: false`. Proposals are
never trusted: the build refuses any used ingredient that isn't reviewed (safety rule).
"""
from __future__ import annotations

import json
import re
import unicodedata
from dataclasses import dataclass, field
from pathlib import Path

from .paths import INGREDIENTS


def norm(text: str) -> str:
    """The app's SeedMapper.normalize: trim, lower-case, collapse whitespace."""
    return re.sub(r"\s+", " ", text.strip().lower())


def fold(text: str) -> str:
    """norm() plus accents folded ('gruyère' -> 'gruyere') and hyphens as spaces."""
    t = unicodedata.normalize("NFKD", norm(text))
    t = "".join(c for c in t if not unicodedata.combining(c))
    return re.sub(r"\s+", " ", t.replace("-", " ")).strip()


# ---- canonical key -----------------------------------------------------------------------------
# Leading words that describe preparation/size/state, not identity.
_PREP = {"chopped", "freshly", "fresh", "minced", "diced", "sliced", "cubed", "melted", "chilled",
         "large", "small", "medium", "raw", "unwaxed", "shelled", "pitted", "stoned", "boiling", "cold",
         "warm", "clear", "lean", "free range", "full fat", "beaten", "crushed", "grated", "frozen"}
# Words never singularized ("molasses" is not a plural of "molass").
_NO_SINGULAR = {"molasses", "couscous", "hummus", "asparagus", "swiss", "grits", "lemongrass", "glass",
                "tapioca", "quinoa", "khus", "brussels", "jus", "harissa", "sevaiiya", "pois", "oats",
                "peas", "greens", "chips", "fries", "pretzels", "krispies", "noodles", "flakes", "leaves",
                "cloves", "bitters", "dates", "mixed"}
_SINGULAR_FORMS = {"leaves": "leaf", "tomatoes": "tomato", "potatoes": "potato", "tomatos": "tomato",
                   "chillies": "chilli", "anchovies": "anchovy", "berries": "berry", "cherries": "cherry",
                   "loaves": "loaf", "knives": "knife", "noodles": "noodle", "dates": "date",
                   "peas": "pea", "chips": "chip", "flakes": "flake", "cloves": "clove", "oats": "oats"}

# Explicit merges of near-duplicates (after prep-stripping and singularizing), key -> canonical key.
# Rule-proposed: each one is listed in ingredients.review.md for confirmation.
MERGES: dict[str, str] = {
    # alliums & aromatics
    "garlic clove": "garlic", "garlic bulb": "garlic", "challot": "shallot", "scallion": "spring onion",
    "onion": "onion", "ginger root": "ginger",
    # herbs
    "cilantro": "coriander", "cilantro leaf": "coriander", "coriander leaf": "coriander",
    "basil leaf": "basil", "chive": "chive", "chopped chive": "chive", "tarragon leaf": "tarragon",
    "dried leaves of summer savoury": "summer savoury", "lemongrass stalk": "lemongrass",
    "kaffir lime leaf": "makrut lime leaf", "lime leaf": "makrut lime leaf", "bay leave": "bay leaf",
    # spices
    "pepper": "black pepper", "ground black pepper": "black pepper", "whole black peppercorn": "peppercorn",
    "kosher salt": "salt", "sea salt": "salt", "coarse salt": "salt",
    "chili powder": "chilli powder", "hot chilli powder": "chilli powder", "red chilli powder": "chilli powder",
    "red chilli flake": "chilli flakes", "red pepper flake": "chilli flakes", "chilli flake": "chilli flakes",
    "chilli": "red chilli", "smoky paprika": "smoked paprika", "sweet smoked paprika": "smoked paprika",
    "hot smoked paprika": "smoked paprika", "ground cinnamon": "cinnamon", "cumin": "ground cumin",
    "nutmeg": "ground nutmeg", "allspice": "ground allspice", "ground cardomom": "cardamom",
    "ground clove": "clove", "turmeric powder": "turmeric", "ground turmeric": "turmeric",
    "garlic granule": "garlic powder", "chinese five spice powder": "five spice powder",
    "szechuan peppercorn": "sichuan pepper", "jamaican curry powder": "curry powder",
    "ground mustard": "mustard powder",
    # flours, starches, sugars
    "all purpose flour": "plain flour", "flour": "plain flour", "white flour": "plain flour",
    "wheat flour": "plain flour", "bread flour": "strong white flour",
    "strong white bread flour": "strong white flour", "corn flour": "cornflour", "cornstarch": "cornflour",
    "starch": "cornflour", "caster sugar": "sugar", "granulated sugar": "sugar", "golden caster sugar": "sugar",
    "ground sugar": "icing sugar", "powdered sugar": "icing sugar", "light brown soft sugar": "brown sugar",
    "dark brown soft sugar": "brown sugar", "dark brown sugar": "brown sugar", "dark soft brown sugar": "brown sugar",
    "fast action yeast": "yeast", "instant yeast": "yeast", "semolina flour": "semolina",
    "fine yellow cornmeal": "cornmeal", "white cornmeal": "cornmeal", "almond flour": "ground almond",
    "unsweetened cocoa": "cocoa powder", "cocoa": "cocoa powder", "cacao": "cocoa powder",
    # dairy & eggs
    "heavy cream": "double cream", "whipping cream": "double cream", "unsalted butter": "butter",
    "salted butter": "butter", "free range egg, beaten": "egg", "free range eggs, beaten": "egg",
    "egg, beaten": "egg", "egg wash": "egg", "whole milk": "milk", "semi skimmed milk": "milk",
    "natural yoghurt": "yogurt", "strained yoghurt": "greek yogurt", "parmesan cheese": "parmesan",
    "parmigiano reggiano": "parmesan", "gruyere cheese": "gruyere", "cheddar cheese": "cheddar",
    "mature cheddar": "cheddar", "mozzarella ball": "mozzarella", "cubed feta cheese": "feta",
    "sweetened condensed milk": "condensed milk",
    # oils & vinegars
    "extra virgin olive oil": "olive oil", "oil": "vegetable oil", "sunflower oil": "vegetable oil",
    "canola oil": "vegetable oil", "rapeseed oil": "vegetable oil", "high heat cooking oil": "vegetable oil",
    "ground nut oil": "groundnut oil", "peanut oil": "groundnut oil", "sesame seed oil": "sesame oil",
    "apple cider vinegar": "cider vinegar", "vinegar": "white vinegar", "seasoned rice vinegar": "rice vinegar",
    # produce
    "egg plant": "aubergine", "baby aubergine": "aubergine", "zucchini": "courgette",
    "plum tomato": "tomato", "vine tomato": "tomato", "beef tomato": "tomato", "grape tomato": "cherry tomato",
    "baby plum tomato": "cherry tomato", "tinned tomato": "chopped tomatoes", "canned tomato": "chopped tomatoes",
    "diced tomato": "chopped tomatoes", "chopped tomato": "chopped tomatoes", "tomato puree": "tomato puree",
    "floury potato": "potato", "russet potato": "potato", "red potato": "potato",
    "baby new potato": "new potato", "jersey royal potato": "new potato", "charlotte potato": "new potato",
    "small potato": "new potato", "sweet red pepper": "red pepper", "romano pepper": "red pepper",
    "baby pak koi": "pak choi", "bok choi": "pak choi", "napa cabbage": "chinese cabbage",
    "chinese leaf": "chinese cabbage", "white cabbage": "cabbage", "hispi (sweetheart) cabbage": "cabbage",
    "beet": "beetroot", "cooked beetroot": "beetroot", "chestnut mushroom": "mushroom",
    "wild mushroom": "mushroom", "iceberg lettuce": "lettuce", "little gem lettuce": "lettuce",
    "baby lettuce leaf": "lettuce", "petit pois": "pea", "frozen pea": "pea",
    "braeburn apple": "apple", "bramley apple": "cooking apple", "lemon": "lemon",
    "medjool date": "date", "pitted date": "date", "light raisin": "raisin",
    "coconut flake": "desiccated coconut", "coconut flakes": "desiccated coconut",
    "shredded coconut": "desiccated coconut", "coconut": "desiccated coconut",
    "unsweetened coconut milk": "coconut milk", "can of chickpea": "chickpea",
    # nuts
    "hazlenut": "hazelnut", "cashew nut": "cashew", "unsalted pistachio": "pistachio",
    "ground pistachio": "pistachio", "roasted peanut": "peanut", "unsalted peanut": "peanut",
    "ground walnut": "walnut",
    # meat & fish
    "ground beef": "beef mince", "minced beef": "beef mince", "lean minced beef": "beef mince",
    "lean minced steak": "beef mince", "minced pork": "pork mince", "ground pork": "pork mince",
    "lamb mince": "lamb mince", "turkey mince": "turkey mince", "sirloin steak tip": "sirloin steak",
    "beef flank steak": "flank steak", "skirty steak": "skirt steak", "fillet of steak": "beef fillet",
    "beef tenderloin": "beef fillet", "pork belly slice": "pork belly", "pork shoulder steak": "pork shoulder",
    "chicken breast": "chicken breast", "king prawn": "prawn", "raw king prawn": "prawn",
    "raw tiger prawn": "prawn", "tiger prawn": "prawn", "raw frozen prawn": "prawn", "jumbo shrimp": "prawn",
    "shrimp": "prawn", "baby squid": "squid", "hot smoked flaked salmon": "smoked salmon",
    "white fish fillet": "white fish", "fish fillet": "white fish", "codfish bulljaw": "salt cod",
    "streaky bacon": "bacon", "bacon lardon": "bacon", "smoked ham": "ham", "deli ham": "ham",
    "german sausage": "sausage", "crab meay": "crab meat",
    # stocks & sauces
    "hot beef stock": "beef stock", "unsalted beef stock": "beef stock", "beef stock concentrate": "beef stock",
    "beef stock cube": "beef stock", "chicken stock cube": "chicken stock",
    "chicken bouillon powder": "chicken stock", "vegetable stock cube": "vegetable stock",
    "bouillon cube": "vegetable stock", "thai red curry paste": "red curry paste",
    "thai fish sauce": "fish sauce", "tabasco sauce": "hot sauce", "tobasco sauce": "hot sauce",
    "hotsauce": "hot sauce", "tahini paste": "tahini", "tamarind pulp": "tamarind paste",
    "tamarind ball": "tamarind paste", "dry sherry": "sherry", "sweet sherry": "sherry",
    "dry white wine": "white wine", "gelatine leaf": "gelatine", "gelatine leafs": "gelatine",
    "unflavoured gelatin": "gelatine", "clear honey": "honey", "vanilla": "vanilla extract",
    "vanilla bean paste": "vanilla extract", "almond essence": "almond extract",
    # bakery & grains
    "phyllo dough": "filo pastry", "ready rolled shortcrust pastry": "shortcrust pastry",
    "stale bread": "bread", "crusty bread": "bread", "white bread": "bread",
    "sesame seed burger bun": "burger bun", "bun": "burger bun", "bread roll": "burger bun",
    "tortilla": "flour tortilla", "rolled oat": "oats", "rolled oats": "oats", "porridge oat": "oats",
    "porridge oats": "oats", "oatmeal": "oats", "ground oat": "oats", "ground oats": "oats",
    "rice stick noodle": "rice noodle", "flat rice noodle": "rice noodle",
    "vermicelli rice noodle": "rice noodle", "rice vermicelli": "rice noodle", "brown rice noodle": "rice noodle",
    "water": "water", "ice cube": "ice",
}


def _singular(word: str) -> str:
    if word in _SINGULAR_FORMS:
        return _SINGULAR_FORMS[word]
    if word in _NO_SINGULAR or len(word) <= 3:
        return word
    for suffix, repl in (("ies", "y"), ("oes", "o"), ("ches", "ch"), ("shes", "sh"), ("sses", "ss"), ("xes", "x")):
        if word.endswith(suffix):
            return word[: -len(suffix)] + repl
    if word.endswith("s") and not word.endswith(("ss", "us", "is")):
        return word[:-1]
    return word


def _singular_phrase(t: str) -> str:
    words = t.split()
    if words:
        words[-1] = _singular(words[-1])
    return " ".join(words)


def _follow(key: str) -> str:
    seen = set()
    while key in MERGES and key not in seen and MERGES[key] != key:
        seen.add(key)
        key = MERGES[key]
    return key


def canonical_key(raw: str) -> str:
    """Explicit MERGES win over prep-stripping ("chopped tomatoes" is canned, not "tomato")."""
    t = fold(raw)
    whole = _singular_phrase(t)
    if whole in MERGES or t in MERGES:
        return _follow(whole if whole in MERGES else t)
    changed = True
    while changed:
        changed = False
        for p in sorted(_PREP, key=len, reverse=True):
            if t.startswith(p + " ") and len(t) > len(p) + 1:
                t, changed = t[len(p) + 1:], True
    return _follow(_singular_phrase(t))


def to_id(key: str) -> str:
    return re.sub(r"[^a-z0-9]+", "_", key).strip("_")


# ---- rule proposals (NEVER trusted: reviewed=false) --------------------------------------------
def _rx(pattern: str) -> re.Pattern[str]:
    return re.compile(pattern)


_NOT_DAIRY = r"(?<!coconut )(?<!almond )(?<!soya )(?<!soy )(?<!oat )(?<!vegetable )(?<!vegan )(?<!peanut )(?<!cocoa )"
ALLERGEN_RULES: dict[str, re.Pattern[str]] = {
    "gluten": _rx(r"\bflour\b(?<!rice flour)(?<!corn flour)(?<!chickpea flour)(?<!almond flour)(?<!cassava flour)"
                  r"(?<!sticky rice flour)(?<!buckwheat flour)|plain flour|self raising|strong (white|wholemeal)|"
                  r"\bbread(?!fruit)|breadcrumb|baguette|ciabatta|brioche|\bbuns?\b|burger bun|muffin|naan|pitt?a|"
                  r"\bpasta|spaghetti|macaroni|penne|rigatoni|farfalle|fettuccine|linguine|lasagne|paccheri|"
                  r"vermicelli pasta|\bnoodle(?<!rice noodle)|egg noodle|udon|couscous|khus khus|bulgur|freekeh|"
                  r"semolina|\brye\b|rye |barley|\bbeer|stout|malt|biscuit|cookie|cracker|pastry|filo|phyllo|"
                  r"wonton|egg roll|tortilla(?<!corn tortilla)|soy sauce|hoisin|oyster sauce|seitan|"
                  r"wheat|spelt|christmas pudding|mincemeat|suet|grape nut|pretzel|toast|stuffing|"
                  r"tempura|gingerbread|speculaas|stroop|sirop|digestive|oreo|maria cookie|mars bar|knafeh|"
                  r"sevaiiya|black pudding|morcilla|doner|falafel|white bread mix|graham"),
    "milk": _rx(rf"{_NOT_DAIRY}\bbutter\b(?! beans?)(?<!peanut butter)|{_NOT_DAIRY}\bmilk\b|buttermilk|"
                rf"{_NOT_DAIRY}\bcream\b(?! of tartar)|creme|cheese|parmesan|parmigiano|pecorino|mozzarella|"
                r"cheddar|feta|gruyere|brie|ricotta|mascarpone|paneer|halloumi|manchego|stilton|gouda|"
                r"emmental|bryndza|quark|fromage|yog(h)?urt|ghee|custard|ice cream|condensed|evaporated|"
                r"dulce de leche|caramel|milk chocolate|white chocolate|malai|curd|toffee|fudge|"
                r"butterscotch|mars bar|liquid cheese|queso|v.sterbottensost|creamed corn"),
    "eggs": _rx(r"\beggs?\b(?! ?plants?)|yolk|egg white|mayonnaise|aioli|a.oli|meringue|egg noodle|"
                r"custard(?! powder)|egg roll|brioche|nougatine"),
    "fish": _rx(r"\bfish\b|anchov|salmon|tuna|\bcod\b|codfish|haddock|hake|mackerel|herring|sardine|"
                r"pilchard|trout|sea bass|barramundi|snapper|monkfish|worcestershire|prahok|bonito|dashi|"
                r"caesar|salt cod"),
    "crustaceans": _rx(r"prawn|shrimp|crab|lobster|crayfish|langoustine|seafood"),
    "molluscs": _rx(r"mussel|clam|oyster(?! mushroom)|squid|octopus|scallop|conch|calamari|seafood"),
    "peanuts": _rx(r"peanut|groundnut|ground nut|satay"),
    "tree_nuts": _rx(r"almond|cashew|walnut|pecan|pistachio|hazel|hazlenut|macadamia|brazil nut|"
                     r"pine nut|marzipan|praline|nougat|frangipane|chestnut(?! mushroom)|nutella"),
    "soy": _rx(r"\bsoy|soya|tofu|tempeh|miso|edamame|hoisin|doubanjiang|bean paste|fermented black bean|"
               r"oyster sauce|teriyaki|milk chocolate|white chocolate"),
    "celery": _rx(r"celery|celeriac|bouillon|stock cube|stock concentrate|all purpose seasoning"),
    "mustard": _rx(r"mustard|piccalilli"),
    "sesame": _rx(r"sesame|tahini|hummus|halva|za.atar"),
    "sulphites": _rx(r"\bwine\b|vinegar|sherry|\bcider\b|beer|stout|brandy|dried (apricot|fruit|cherr|cranberr)|"
                     r"raisin|sultana|currant(?!s jam)|prune|candied peel|mixed peel|glace cherr|mincemeat|"
                     r"grand marnier|mirin|sake|shaoxing|pickle|sauerkraut|dijon|worcestershire|"
                     r"red wine jelly|rice wine|cooking wine|pomegranate molasses|date molasses"),
    "lupin": _rx(r"lupin"),
}

CONTAINS_RULES: dict[str, re.Pattern[str]] = {
    "meat": _rx(r"\bbeef|steak|brisket|veal|lamb|mutton|goat|oxtail|\bmince\b|kidney(?! beans?)|liver|"
                r"suet|doner|corned|chuck|shank|sirloin|shredded meat|beef gravy|chorizo|sausage|bacon|ham\b|"
                r"jamon|serrano|prosciutto|kabanos|kielbasa|morcilla|black pudding|pork|lard|trotter|pancetta|"
                r"salami|mortadella|frog"),
    "pork": _rx(r"pork|pig|bacon|\bham\b|jamon|serrano|prosciutto|parma ham|chorizo|kabanos|kielbasa|"
                r"morcilla|black pudding|lard|pancetta|salami|sausage(?!.*(chicken|turkey))|deli ham"),
    "poultry": _rx(r"chicken|turkey|duck(?! sauce)|goose|quail"),
    "fish": ALLERGEN_RULES["fish"],
    "shellfish": _rx(r"prawn|shrimp|crab|lobster|crayfish|mussel|clam|oyster(?! mushroom)|squid|octopus|"
                     r"scallop|conch|seafood|calamari"),
    "dairy": ALLERGEN_RULES["milk"],
    "egg": ALLERGEN_RULES["eggs"],
    "honey": _rx(r"honey"),
    "alcohol": _rx(r"\bwine\b(?! vinegar)|beer|stout|brandy|\brum\b|vodka|whisk|gin\b|sherry(?! vinegar)|"
                   r"\bcider\b(?! vinegar)|grand marnier|liqueur|mirin|sake|shaoxing|kirsch|cognac|"
                   r"vanilla extract|almond extract|cooking wine|rice wine"),
    "gelatin": _rx(r"gelatin|marshmallow|jelly(?! bean)(?<!wine jelly)"),
}

PROTEIN_RULES: list[tuple[str, re.Pattern[str]]] = [
    ("chicken", _rx(r"^chicken(?! stock| bouillon| liver)")),
    ("duck", _rx(r"^duck(?! sauce)")),
    ("turkey", _rx(r"^turkey(?! ham)|turkey mince")),
    ("beef", _rx(r"^beef(?! stock| gravy| tomato)|steak|brisket|mince(?<!pork mince)(?<!lamb mince)(?<!turkey mince)|"
                 r"oxtail|chuck roast|corned beef|veal|hind shank|feather blade")),
    ("pork", _rx(r"^pork(?! stock)|pork mince|bacon|\bham\b|chorizo|sausage|kielbasa|kabanos|pig")),
    ("lamb", _rx(r"^lamb(?! stock| fat)")),
    ("goat", _rx(r"^goat meat")),
    ("fish", _rx(r"salmon|tuna|\bcod\b|haddock|hake|mackerel|herring|sardine|pilchard|trout|sea bass|"
                 r"barramundi|snapper|monkfish|white fish|salt cod")),
    ("shellfish", _rx(r"^(prawn|shrimp|crab|lobster|mussel|clam|oyster|squid|scallop|conch|frozen seafood)")),
    ("egg", _rx(r"^eggs?$|^egg yolk|^egg white")),
    ("tofu", _rx(r"tofu|tempeh")),
    ("legumes", _rx(r"bean(?! sprout| paste)|lentil|chickpea(?! flour)|split pea|\bdal\b|black eyed pea")),
    ("cheese", _rx(r"^(paneer|halloumi|cottage cheese|queso fresco)")),
]

AISLE_RULES: list[tuple[str, re.Pattern[str]]] = [
    ("beverages", _rx(r"\bwine\b(?! vinegar)|beer|stout|brandy|\brum\b|sherry(?! vinegar)|sake|cider$|soda water|"
                      r"juice|cordial|grand marnier|coffee|cafe")),
    ("frozen", _rx(r"frozen|ice cream|^ice$|fries")),
    ("condiments", _rx(r"stock|bouillon|gravy|fish sauce|oyster sauce|shrimp paste")),
    ("meat_seafood", CONTAINS_RULES["meat"]),
    ("meat_seafood", _rx(r"chicken(?! stock| bouillon)|turkey(?! ham)|duck(?! sauce)|goose fat|"
                         r"prawn|shrimp(?! paste)|crab|lobster|mussel|clam|oyster(?! mushroom| sauce)|squid|"
                         r"conch|salmon|tuna|\bcod\b|haddock|hake|mackerel|herring|sardine|pilchard|trout|"
                         r"sea bass|barramundi|snapper|monkfish|white fish|anchovy fillet|frog")),
    ("dairy_eggs", ALLERGEN_RULES["milk"]),
    ("dairy_eggs", _rx(r"^eggs?$|^egg (yolk|white)")),
    ("bakery", _rx(r"bread|baguette|ciabatta|brioche|\bbuns?\b|muffin|naan|pitt?a|tortilla|roll$|toast|"
                   r"pastry|filo|phyllo|wonton|wrapper|taco shell")),
    ("spices", _rx(r"salt$|pepper$(?<!red pepper)(?<!green pepper)(?<!yellow pepper)(?<!banana pepper)"
                   r"(?<!habanero pepper)(?<!roasted pepper)|peppercorn|paprika|cumin|coriander seed|"
                   r"ground (?!almond|pistachio|walnut|oat|nut oil)|"
                   r"cinnamon|nutmeg|allspice|cardamom|clove$|turmeric|masala|curry powder|chilli powder|"
                   r"chilli flake|cayenne|saffron|star anise|fennel seed|caraway|mustard seed|seasoning|"
                   r"five spice|sumac|ras el hanout|baharat|za.atar|spice|dried (oregano|mint|dill|thyme)|"
                   r"bay leaf|vanilla pod|poppy|sesame seed|fenugreek|juniper|pul biber|sazon|annatto|achiote|"
                   r"jerk|cajun|harissa spice|kabse|mahleb|sichuan pepper|kampot|garlic powder|onion salt|celery salt")),
    ("condiments", _rx(r"sauce|ketchup|mayonnaise|mustard(?! seed| powder)|vinegar|paste|chutney|relish|"
                       r"dressing|salsa|hummus|tahini|pickle|jam|honey|syrup|treacle|molasses|aioli|a.oli|"
                       r"sriracha|gochujang|doubanjiang|miso|stock|bouillon|gravy|chimichurri|pico de gallo|"
                       r"spread|peanut butter|lizano")),
    ("international", _rx(r"tofu|tempeh|mirin|rice paper|nori|kimchi|masarepa|casabe|farine|ackee|callaloo|"
                          r"breadfruit|yautia|cassava|yuca|taro|plantain|longan|mulukhiyah|prahok|sazon|knafeh|"
                          r"pandan|lemongrass|galangal|makrut|kaffir|udon|glutinous|sushi rice|rice flour pancake")),
    ("produce", _rx(r"onion|shallot|garlic|ginger|chilli|jalapeno|scotch bonnet|habanero|pepper|tomato|potato|"
                    r"carrot|celery|celeriac|leek|cabbage|lettuce|spinach|kale|rocket|cucumber|courgette|aubergine|"
                    r"squash|pumpkin|mushroom|broccoli|cauliflower|asparagus|bean sprout|green bean|runner bean|"
                    r"sugar snap|snow pea|pak choi|fennel|beetroot|radish|turnip|swede|parsnip|corn on the cob|"
                    r"sweetcorn|lemon|lime|orange|grapefruit|apple|pear|peach|banana|mango|avocado|berr|cherr|"
                    r"strawberr|raspberr|blueberr|blackberr|currant|rhubarb|fig|pomegranate|grape|pineapple|"
                    r"papaya|melon|kiwi|basil|parsley|coriander$|mint|dill|thyme|rosemary|sage|chive|tarragon|"
                    r"marjoram|oregano|savoury|sorrel|herb|vegetable|lettuce|okra|yam|artichoke|chestnut|"
                    r"water chestnut|bamboo|palm heart|vine leaves|grape leaves|morning glory|daikon")),
    ("pantry", _rx(r".")),  # fallback
]

STAPLE_KEYS = {"salt", "black pepper", "vegetable oil", "olive oil", "sugar", "plain flour", "water", "butter",
               "garlic", "onion", "egg", "soy sauce", "baking powder", "bicarbonate of soda", "brown sugar",
               "icing sugar", "cornflour", "vanilla extract", "white vinegar", "honey", "dried oregano",
               "ground cumin", "paprika", "chilli flakes", "ground cinnamon", "bay leaf", "milk", "tomato puree",
               "vegetable stock", "chicken stock", "cinnamon", "peppercorn", "boiling water"}

BRAND_DEPENDENT = _rx(r"stock|bouillon|sausage|chorizo|sauce|paste|seasoning|chocolate|biscuit|cookie|bread|"
                      r"pastry|curry powder|spice mix|ketchup|mayonnaise|mustard|ice cream|custard|caramel|"
                      r"marshmallow|sweet|cereal|krispies|ham\b|mars bar|turkish delight|dressing|salsa|"
                      r"pudding|mincemeat|tortilla|wrapper|noodle|pretzel|popcorn|brittle|jam|cordial")


def propose_facts(key: str) -> dict:
    """Rule proposal for a new ingredient. Every value here MUST be reviewed by hand."""
    allergens = sorted(a for a, rx in ALLERGEN_RULES.items() if rx.search(key))
    contains = sorted(c for c, rx in CONTAINS_RULES.items() if rx.search(key))
    protein = next((p for p, rx in PROTEIN_RULES if rx.search(key)), None)
    aisle = next(a for a, rx in AISLE_RULES if rx.search(key))
    notes = []
    if BRAND_DEPENDENT.search(key):
        notes.append("BRAND-DEPENDENT: check a typical label for hidden allergens")
    return {"aisle": aisle, "allergens": allergens, "contains": contains, "protein": protein,
            "isPantryStaple": key in STAPLE_KEYS, "notes": "; ".join(notes)}


# ---- the curated table ------------------------------------------------------------------------
@dataclass
class IngredientTable:
    items: list[dict]
    lookup: dict[str, str] = field(default_factory=dict)  # norm(name|synonym) -> id

    @classmethod
    def load(cls, path: Path = INGREDIENTS) -> "IngredientTable":
        items = json.loads(path.read_text(encoding="utf-8")) if path.exists() else []
        t = cls(items)
        t.reindex()
        return t

    def reindex(self) -> None:
        self.lookup = {}
        for ing in self.items:
            for name in [ing["name"], *ing.get("synonyms", [])]:
                k = norm(name)
                if k in self.lookup and self.lookup[k] != ing["id"]:
                    raise SystemExit(f"ingredients.json: '{k}' maps to both {self.lookup[k]} and {ing['id']}")
                self.lookup[k] = ing["id"]

    @property
    def by_id(self) -> dict[str, dict]:
        return {i["id"]: i for i in self.items}

    def resolve(self, raw: str) -> str | None:
        """Exact (normalized) name/synonym match, else the canonical key's id if it exists."""
        hit = self.lookup.get(norm(raw))
        if hit:
            return hit
        key = canonical_key(raw)
        if key in self.lookup:
            return self.lookup[key]
        iid = to_id(key)
        return iid if iid in self.by_id else None

    def save(self, path: Path = INGREDIENTS) -> None:
        path.parent.mkdir(parents=True, exist_ok=True)
        ordered = sorted(self.items, key=lambda i: i["id"])
        path.write_text(json.dumps(ordered, indent=1, ensure_ascii=False) + "\n", encoding="utf-8")


def propose(table: IngredientTable, raw_counts: dict[str, int]) -> list[dict]:
    """Adds rule-proposed entries for raw strings that don't resolve. Returns the new entries.

    Existing entries are never modified, except that a new raw spelling which canonicalizes onto an
    existing id is appended to its synonyms (recorded in `proposal.addedSynonyms` for review).
    """
    groups: dict[str, list[str]] = {}
    for raw in raw_counts:
        if table.lookup.get(norm(raw)):
            continue
        groups.setdefault(canonical_key(raw), []).append(raw)
    by_id = table.by_id
    added: list[dict] = []
    for key, raws in sorted(groups.items()):
        existing = table.lookup.get(key) or (to_id(key) if to_id(key) in by_id else None)
        spellings = sorted({norm(r) for r in raws})
        if existing:
            ing = by_id[existing]
            new = [s for s in spellings if s not in {norm(x) for x in [ing["name"], *ing["synonyms"]]}]
            ing["synonyms"] = ing["synonyms"] + [_title(s) for s in new]
            ing.setdefault("proposal", {}).setdefault("addedSynonyms", []).extend(_title(s) for s in new)
            continue
        main = max(raws, key=lambda r: (raw_counts[r], -len(r)))
        name = _title(canonical_key(main) if canonical_key(main) == key else key)
        facts = propose_facts(key)
        entry = {
            "id": to_id(key), "name": name,
            "synonyms": [_title(s) for s in spellings if s != norm(name)],
            "aisle": facts["aisle"], "allergens": facts["allergens"], "contains": facts["contains"],
            "protein": facts["protein"], "isPantryStaple": facts["isPantryStaple"],
            "reviewed": False, "notes": facts["notes"],
            "proposal": {"by": "rules", "uses": sum(raw_counts[r] for r in raws),
                         "merged": len(spellings) > 1 or norm(name) != spellings[0]},
        }
        table.items.append(entry)
        by_id[entry["id"]] = entry
        added.append(entry)
    table.reindex()
    return added


def _title(s: str) -> str:
    small = {"of", "and", "de", "la", "with", "the", "a"}
    return " ".join(w if (i and w in small) else w[:1].upper() + w[1:] for i, w in enumerate(s.split()))
