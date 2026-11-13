# Top-50 tag review: notes

Reviewed by Claude on 2026-11-13 against `out/review-top50.md`. Every fix below is an `overrides.json` entry with
`"reviewed": false` and a `top50:`/`audit:` note. No AI batch file was edited.

## Tag fixes (27 recipes)

| id | recipe | change | why |
|---|---|---|---|
| `mdb-52844` | Lasagne | sweet 3→1, sour 3→2 | 1 tbsp honey in a savoury bake |
| `mdb-53014` | Pizza Express Margherita | umami 0→3, sweet 2→1 | tomato + mozzarella |
| `mdb-52802` | Fish pie | sour 3→1 | just a squeeze of lemon |
| `mdb-52908` | Ratatouille | mealTypes main → main, side; sour 3→2 | usually a side; 1 tsp vinegar |
| `mdb-52909` | Tarte Tatin | prep 25→85, cook 135→80 | the 1 hr cool is passive (prep) |
| `mdb-52905` | Chocolate Souffle | bitter 4→2 | a sweet souffle |
| `mdb-52806` | Tandoori chicken | salty 0→2, **spicy 3→2** | ½ tsp chilli powder for 16 thighs |
| `mdb-52808` | Lamb Rogan josh | salty 0→2 | salted curry paste |
| `mdb-52865` | Matar Paneer | salty 0→2, umami 0→2, **spicy 3→2** | 1 green chilli for 2 servings |
| `mdb-52805` | Lamb Biryani | salty 0→2 | seasoned dish |
| `mdb-52945` | Kung Pao Chicken | **spicy 2→3** | 1 tbsp chilli powder |
| `mdb-52947` | Ma Po Tofu | prep 45→15, cook 10→20 | no passive step; wok work + 6-8 min simmer |
| `mdb-52948` | Wontons | mealTypes main → starter, snack | fried wontons |
| `mdb-53191` | Pad Thai | **spicy 4→2**, sweet 4→3 | ½ tsp cayenne for 2 |
| `mdb-53238` | Beef pho | **spicy 3→1** | only a garnish chilli |
| `mdb-53053` | Beef Rendang | salty 0→2, sweet 4→2, sour 4→2, umami 1→3, **spicy 0→3** | the method blends a spice paste missing from the source list (rendang paste is chilli-based); "6 Lime" are probably lime leaves |
| `mdb-52819` | Cajun spiced fish tacos | salty 0→2, sour 4→2 | Cajun seasoning is salted |
| `mdb-52858` | New York cheesecake | sour 5→2, salty 2→1; prep 505→630, cook 170→45 | tangy, not sour; the 2 hr oven-cool is passive |
| `mdb-52854` | Pancakes | mealTypes dessert → breakfast, dessert; sour 2→0 | |
| `mdb-53151` | Paella | sour 3→1 | lemon zest only |
| `mdb-53006` | Moussaka | prep 20→15, cook 10→20, sour 3→2 | quick grill version |
| `mdb-53269` | Hummus | salty 0→2 | |
| `mdb-53266` | Falafel | salty 0→2 | |
| `mdb-52937` | Jerk chicken with rice & peas | **spicy 2→3** | jerk marinade with 3 chillies |
| `mdb-53019` | Pierogi | mealTypes side → main, side | |
| `mdb-52804` | Poutine | mealTypes main → main, snack | |
| `mdb-53046` | Portuguese custard tarts | sour 2→0 | lemon zest only |

**Bold** marks a change to `flavor.spicy`, the heat filter. Five went down and three went up. Rendang (0→3) matters most:
a spice-averse user would have been shown it.

Pattern worth knowing: the flavor rules give **salty 0** whenever the source lists no salt (Tandoori, Matar Paneer,
Hummus…). That's likely true outside the top 50 too.

## Checked and left alone

Cuisines, servings and difficulty all look right. Values that are arguable but not wrong were left alone:
Bolognese sour 3, Full English sour 2, KFC spicy 2, Poutine cook 5 (the method fries for 5 min), and Kung Pao prep 55
(30 min marinade). Falafel and Hummus are filed as Turkish by TheMealDB; "Middle Eastern" isn't in the cuisine list, so
they stay.

The pilot overrides (Eton Mess, Karaage, Carbonara, Bistek, Saudi Shakshouka) still look right. Sushi now has the
`tuna` line from the allergen-gap pass.

## Smaller audit items

### Step splits
| id | verdict | action |
|---|---|---|
| `mdb-52938` Jamaican Beef Patties (29) | The split itself was fine. Four sub-headings ("Make the Filling") became their own steps. | **Fixed in `seedgen/steps.py`**: a short Title Case line at the start of a paragraph now labels the next step ("Make the Filling: Add ground beef…") instead of standing alone. Tests are in `tests/test_steps.py`. It now has 25 steps, no longer flagged. The other 19 recipes with headings like this also benefit (e.g. Blini "Pan-Fry the Blini: …", Tavë Kosi "Making a Roux: …"). The remaining 25 steps are real: the source gives two alternative shaping methods. |
| `mdb-53449` Kelem dolmasi (27) | Not a splitter bug. The source is a blog post with photo captions ("Blanched cabbage leaves.", "Ew.") and commentary. | Needs hand-written steps (about 8). Steps can't be overridden yet (see below). Alternatively, add it to `exclude.json`. **Your call.** |
| `mdb-53020` Rosol (1 step) | The source has no sentence punctuation, so no safe automatic split exists. | Needs hand-written steps. |
| `mdb-53563` Dominica mastiff bread (3) | Same: no punctuation, and it also includes a second "when using active yeast" method. | Needs hand-written steps; drop the duplicate method. |

`merge.py` only overrides tag `FIELDS`, so there's currently no way to override `steps`. Adding a `steps` override
(a list of strings that replaces the split result) is a small pipeline change, but `cmd_build` isn't wired yet, so I
didn't add one I couldn't test end to end.

Also: `mdb-52987` has a "Nutrition Facts: 1 sandwich: 445 calories…" step from its source text. It's harmless, but a
`steps` override should drop it too.

### mdb-53543 cuisine
**Cuban, not Costa Rican.** The Costa Rican block ends at mdb-53542 (Chorreadas). From mdb-53544 onwards the set is
Cuban: Café La Llave espresso ice cream, Ropa Vieja and Cuban Sandwich. A cheesecake with a Maria-cookie crust and dulce
de leche fits the Miami-Cuban dessert style. The override also moves its 1 hr oven-cool and 4 hr chill into prep
(prep 315, cook 65).

### Total time over 6 hours (43 → 36)
Overrides fixed these clearly wrong ones:
- `mdb-52812` brisket: cook 460→260
- `mdb-53139` Fainá: cook 265→30, with the 4 hr rest moved to prep
- `mdb-53482` feijoada: cook 550→135, because the slow-cooker and oven alternatives had been summed
- `mdb-52941` Red Peas Soup: cook 350→130
- `mdb-53470` Seswaa: cook 480→300, because "4 hours" was counted twice
- `mdb-53452` Handesh: prep 615→135, because "overnight" was only a storage tip
- `mdb-53360` tamarind balls: prep 490→30, because the overnight set is optional
- New York cheesecake and mdb-53543: passive cooling moved into prep

The rest are real overnight marinades, soaks, rises, cures or chills. One borderline case: Montreal Smoked Meat
(`mdb-52927`) says "cure for 4 days" but has only 155 prep. Decide whether multi-day cures should count.
