# Allergen-gap review (audit: "Method mentions allergens missing from the ingredients")

Reviewed by Claude on 2026-11-13. The source list is the committed `out/audit.md` (123 recipes). Every override is drafted with `reviewed: false`.

- **Real gap**: the dish uses the item but the source list leaves it out. An `extraIngredients` override is drafted in `curation/overrides.json`.
- **Serving suggestion** / **Optional / alternative**: no override.
- **False positive**: the word isn't the allergen ('fish slice', 'walnut-sized', peanut butter, rice noodles). No override.

**Result:** 123 → 94 still flagged.

- 24 real gaps were fixed. 18 of those recipes no longer flag; 6 still flag, but only for a leftover false positive or optional mention (see the notes column).
- 11 more no longer flag because the ingredient safe-side fixes now cover the flagged allergen, for example stock now lists gluten and Mince Pies' mincemeat now lists tree nuts.
- The other 83 still flag, but all of them are serving suggestions, optional mentions or false positives.

| id | title | flag | verdict | action |
|---|---|---|---|---|
| `mdb-52764` | Garides Saganaki | gluten? (method says 'bread') | Serving suggestion | none (crusty bread on the side) |
| `mdb-52765` | Chicken Enchilada Casserole | gluten? (method says 'tortilla') | False positive | none (corn tortillas already listed) |
| `mdb-52775` | Vegan Lasagna | milk? (method says 'butter') | False positive | none ('butter' is the listed vegan butter) |
| `mdb-52782` | Lamb tomato and sweet spices | gluten? (method says 'couscous'); milk? (method says 'butter'); tree_nuts? (method says 'pine nut') | Serving suggestion | none (rice with butter and pine nuts, or couscous, on the side) |
| `mdb-52784` | Smoky Lentil Chili with Squash | milk? (method says 'cream'); fish? (method says 'worcestershire') | **Real gap** | override: add `worcestershire_sauce`. method adds Worcestershire sauce with the spices. NB: 'cream' is the cashew sour cream (false positive, still flags) |
| `mdb-52786` | Rocky Road Fudge | milk? (method says 'butter'); tree_nuts? (method says 'almond') | False positive | none (butter = peanut butter; almonds are an alternative to the listed peanuts) |
| `mdb-52807` | Baingan Bharta | gluten? (method says 'bread') | Serving suggestion | none (bread/roti on the side) |
| `mdb-52811` | Ribollita | fish? (method says 'fish') | False positive | none ('fish out' the herb stems) |
| `mdb-52812` | Beef Brisket Pot Roast | gluten? (method says 'noodle'); eggs? (method says 'egg') | Serving suggestion | none (egg noodles as a side) |
| `mdb-52816` | Roasted Eggplant With Tahini, Pine Nuts, and Lentils | sesame? (method says 'tahini') | **Real gap** | override: add `tahini` (a few tablespoons). method spreads tahini sauce over each eggplant half · *no longer flagged* |
| `mdb-52821` | Laksa King Prawn Noodles | gluten? (method says 'noodle') | False positive | none (rice noodles are listed) · *no longer flagged* |
| `mdb-52833` | Salted Caramel Cheescake | eggs? (method says 'meringue') | False positive | none ('like a meringue does' (simile)) |
| `mdb-52843` | Lamb Tagine | tree_nuts? (method says 'pine nut') | Optional / alternative | none (pine nuts 'if using') |
| `mdb-52848` | Bean & Sausage Hotpot | gluten? (method says 'bread') | Serving suggestion | none (crusty bread) · *no longer flagged* |
| `mdb-52864` | Mushroom & Chestnut Rotolo | milk? (method says 'cream') | False positive | none (chestnut 'cream' (blitzed chestnuts)) |
| `mdb-52870` | Chickpea Fajitas | gluten? (method says 'tortilla') | False positive | none (corn tortillas already listed) |
| `mdb-52873` | Beef Dumpling Stew | fish? (method says 'worcestershire') | **Real gap** | override: add `worcestershire_sauce` (to taste). method adds Worcestershire sauce to the stew · *no longer flagged* |
| `mdb-52889` | Summer Pudding | milk? (method says 'cream') | Serving suggestion | none (cream to serve) |
| `mdb-52891` | Blackberry Fool | molluscs? (method says 'squid') | False positive | none ('squidgy') |
| `mdb-52895` | English Breakfast | milk? (method says 'butter'); fish? (method says 'fish') | **Real gap** | override: add `butter` (knob). method bastes the fried eggs with a knob of butter. NB: 'fish slice' still flags (false positive) |
| `mdb-52896` | Full English Breakfast | milk? (method says 'butter'); fish? (method says 'fish') | **Real gap** | override: add `butter` (knob). method bastes the fried eggs with a knob of butter. NB: 'fish slice' still flags (false positive) |
| `mdb-52918` | Fish Stew with Rouille | eggs? (method says 'mayonnaise') | **Real gap** | override: add `mayonnaise`. rouille is harissa stirred through mayonnaise · *no longer flagged* |
| `mdb-52920` | Chicken Marengo | gluten? (method says 'pasta') | Serving suggestion | none (pasta or mash) · *no longer flagged* |
| `mdb-52925` | Split Pea Soup | milk? (method says 'butter') | Serving suggestion | none (bread and butter) |
| `mdb-52928` | BeaverTails | tree_nuts? (method says 'almond') | Optional / alternative | none (Nutella and almonds as one topping option) |
| `mdb-52946` | Kung Po Prawns | sulphites? (method says 'vinegar') | **Real gap** | override: add `white_vinegar` (1 tbsp). sauce uses vinegar (type unstated) · *no longer flagged* |
| `mdb-52954` | Hot and Sour Soup | eggs? (method says 'egg') | **Real gap** | override: add `egg` (1). method stirs in 1 beaten egg · *no longer flagged* |
| `mdb-52955` | Egg Drop Soup | eggs? (method says 'egg') | **Real gap** | override: add `egg` (1). Egg Drop Soup with no egg listed; method adds 1 beaten egg · *no longer flagged* |
| `mdb-52958` | Peanut Butter Cookies | milk? (method says 'butter') | False positive | none (butter = peanut butter) |
| `mdb-52963` | Shakshuka | gluten? (method says 'bread') | Serving suggestion | none (crusty bread) |
| `mdb-52965` | Breakfast Potatoes | eggs? (method says 'egg') | Optional / alternative | none (fried egg on top as a serving suggestion) |
| `mdb-52969` | Chakchouka | gluten? (method says 'bread') | Serving suggestion | none (bread or pita) |
| `mdb-52977` | Corba | gluten? (method says 'bread') | Serving suggestion | none (crackers or bread) · *no longer flagged* |
| `mdb-52979` | Bitterballen (Dutch meatballs) | mustard? (method says 'mustard') | Serving suggestion | none (mustard for dipping) |
| `mdb-52980` | Stamppot | mustard? (method says 'mustard') | Serving suggestion | none ('your favorite mustard or gravy') |
| `mdb-52991` | Mince Pies | tree_nuts? (method says 'walnut') | False positive | none ('walnut-sized' balls) · *no longer flagged* |
| `mdb-52995` | BBQ Pork Sloppy Joes | milk? (method says 'butter') | **Real gap** | override: add `butter` (1 tbsp). method melts 1 tbsp butter for the buns · *no longer flagged* |
| `mdb-52997` | Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber | milk? (method says 'butter'); eggs? (method says 'mayonnaise') | **Real gap** | override: add `butter` (1 tbsp), `mayonnaise`, `sriracha` (to taste). method lists 'Add'l ingredients: mayonnaise, sriracha' and stirs 1 tbsp butter into the rice · *no longer flagged* |
| `mdb-52999` | Crispy Sausages and Greens | mustard? (method says 'mustard'); sulphites? (method says 'vinegar') | **Real gap** | override: add `red_wine_vinegar` (splash). greens are tossed with a splash of vinegar (sherry or red wine). NB: 'mustard greens' still flags (false positive) |
| `mdb-53008` | Stuffed Lamb Tomatoes | gluten? (method says 'bread') | Serving suggestion | none (crusty bread) · *no longer flagged* |
| `mdb-53020` | Rosol (Polish Chicken Soup) | gluten? (method says 'noodle') | Optional / alternative | none (noodles 'if you're using them') |
| `mdb-53025` | Ful Medames | gluten? (method says 'bread'); milk? (method says 'cream'); eggs? (method says 'eggs'); sulphites? (method says 'vinegar') | Optional / alternative | none (Arab bread, tahina cream, eggs and pickles are optional garnishes) |
| `mdb-53029` | Mulukhiyah | gluten? (method says 'pita') | Serving suggestion | none (pita on the side) |
| `mdb-53038` | Mustard champ | fish? (method says 'fish') | Serving suggestion | none ('great with... a fish pie') |
| `mdb-53056` | Croatian lamb peka | gluten? (method says 'bread') | Serving suggestion | none (bread to dip) |
| `mdb-53057` | Traditional Croatian Goulash | gluten? (method says 'bread') | Serving suggestion | none (fresh bread) |
| `mdb-53065` | Sushi | fish? (method says 'tuna'); crustaceans? (method says 'prawn'); tree_nuts? (method says 'walnut') | **Real gap** | override: add `tuna`. rolls are filled with tuna and cucumber; prawn/smoked salmon toppings are optional. NB: prawn/smoked salmon toppings are optional and 'walnut-sized' is a false positive; both still flag |
| `mdb-53068` | Beef Mechado | sesame? (method says 'sesame'); sulphites? (method says 'vinegar') | **Real gap** | override: add `sesame_oil`, `white_vinegar`. marinade uses sesame oil and vinegar · *no longer flagged* |
| `mdb-53070` | Beef Caldereta | milk? (method says 'butter') | False positive | none (butter = peanut butter) |
| `mdb-53074` | Grilled eggplant with coconut milk | milk? (method says 'cream') | False positive | none (coconut milk 'or cream') |
| `mdb-53092` | Fasoliyyeh Bi Z-Zayt (Syrian Green Beans with Olive Oil) | gluten? (method says 'pita') | Serving suggestion | none (warm pita) |
| `mdb-53099` | Aussie Burgers | sulphites? (method says 'wine') | False positive | none ('a glass of red wine') |
| `mdb-53103` | Barramundi with Moroccan spices | gluten? (method says 'couscous') | Serving suggestion | none (couscous or rice) |
| `mdb-53125` | Karbonader (Lean Beef Patties) with Caramelized Onions | gluten? (method says 'bread') | Serving suggestion | none (on a slice of bread) |
| `mdb-53127` | Authentic Norwegian Kransekake | gluten? (method says 'semolina') | **Real gap** | override: add `semolina` (for the tins). tins are coated with semolina, flour or breadcrumbs (all gluten), otherwise the cake is gluten-free · *no longer flagged* |
| `mdb-53133` | Asado | sulphites? (method says 'wine') | Serving suggestion | none (Malbec to drink) |
| `mdb-53134` | Empanadas | sulphites? (method says 'vinegar') | Optional / alternative | none ('pro tip' vinegar in the dough) |
| `mdb-53135` | Milanesa | milk? (method says 'parmesan') | Optional / alternative | none ('pro tip' Parmesan in the crumb) |
| `mdb-53139` | Fainá | gluten? (method says 'flour') | False positive | none (chickpea flour) |
| `mdb-53141` | Carbonada Criolla | gluten? (method says 'bread') | Serving suggestion | none (crusty bread) · *no longer flagged* |
| `mdb-53142` | Spiced tortilla | gluten? (method says 'tortilla') | False positive | none (Spanish (egg) tortilla) |
| `mdb-53143` | Easy Spanish chicken | eggs? (method says 'egg') | False positive | none (ad text: 'Budget Egg Ideas') |
| `mdb-53145` | Jamon & wild garlic croquetas | sulphites? (method says 'sherry') | Serving suggestion | none (a glass of sherry) |
| `mdb-53146` | Locro | gluten? (method says 'bread') | Serving suggestion | none (bread on the side) |
| `mdb-53149` | Ensaimada | milk? (method says 'cream') | Optional / alternative | none (whipped-cream filling is an option) |
| `mdb-53166` | Chickpea, chorizo & spinach stew | gluten? (method says 'bread') | Serving suggestion | none (crusty bread) |
| `mdb-53171` | Salt cod tortilla | gluten? (method says 'tortilla') | False positive | none (Spanish (egg) tortilla) |
| `mdb-53179` | Ham croquetas | tree_nuts? (method says 'walnut') | False positive | none ('walnut-sized' balls) |
| `mdb-53189` | Zemiakové Placky | milk? (method says 'cream') | Serving suggestion | none (sour cream to serve) |
| `mdb-53191` | Pad Thai | gluten? (method says 'noodle') | False positive | none (rice noodles are listed) |
| `mdb-53197` | Thai pork & peanut curry | milk? (method says 'butter') | False positive | none (butter = peanut butter) |
| `mdb-53203` | Thai rice noodle salad | gluten? (method says 'noodle'); soy? (method says 'soy') | False positive | none (rice noodles; 'fish or soy sauce' (fish sauce listed)) |
| `mdb-53210` | Thai pumpkin soup | fish? (method says 'fish') | False positive | none ('fish out' the lemongrass) |
| `mdb-53213` | Thai-style fish broth with greens | gluten? (method says 'noodle') | False positive | none (rice noodles are listed) · *no longer flagged* |
| `mdb-53217` | Shawarma chuck roast wrap | gluten? (method says 'pita') | **Real gap** | override: add `pita_bread`, `garlic_sauce`. the wrap is built on pita spread with garlic sauce · *no longer flagged* |
| `mdb-53218` | Chicken Shawarma with homemade garlic herb yoghurt sauce | gluten? (method says 'bread') | **Real gap** | override: add `pita_bread` (flatbreads). served in toasted flatbreads (closest id: pita_bread) · *no longer flagged* |
| `mdb-53219` | Shakshuka Feta Cheese | gluten? (method says 'bread') | Serving suggestion | none (fresh bread) |
| `mdb-53221` | Mamoul (Eid biscuits) | sesame? (method says 'sesame') | **Real gap** | override: add `sesame_seed`. date filling is fried with sesame · *no longer flagged* |
| `mdb-53229` | Steak & Vietnamese noodle salad | gluten? (method says 'noodle') | False positive | none (rice noodles are listed) |
| `mdb-53239` | Bang bang prawn salad | gluten? (method says 'noodle'); milk? (method says 'butter') | False positive | none (rice noodles; butter = peanut butter) |
| `mdb-53241` | Vietnamese veg parcels | gluten? (method says 'noodle') | False positive | none (rice noodles are listed) |
| `mdb-53248` | Salmon noodle wraps | gluten? (method says 'noodle'); milk? (method says 'butter') | **Real gap** | override: add `butter`. method mixes butter into the noodles. NB: the rice noodles still flag 'noodle' (false positive) |
| `mdb-53261` | Chicken wings with cumin, lemon & garlic | tree_nuts? (method says 'pistachio') | Serving suggestion | none (bowls of pistachios/almonds alongside) |
| `mdb-53266` | Falafel | gluten? (method says 'couscous') | Serving suggestion | none (couscous or pitta) |
| `mdb-53292` | Piernik (Polish gingerbread) | fish? (method says 'fish') | False positive | none ('fish slice' (utensil)) |
| `mdb-53310` | Challah | sesame? (method says 'sesame') | Optional / alternative | none (poppy 'or sesame seeds, if using' (poppy listed)) |
| `mdb-53325` | Venezuelan Arepas | gluten? (method says 'flour') | False positive | none (corn flour, method says gluten-free) |
| `mdb-53326` | Venezuelan Sancocho | gluten? (method says 'bread') | Serving suggestion | none (arepas or casabe (cassava bread)) · *no longer flagged* |
| `mdb-53350` | Corned Beef and Cabbage – Jamaican Style | gluten? (method says 'bread') | Serving suggestion | none (rice or bread) |
| `mdb-53354` | Jamaican Curry Goat | sulphites? (method says 'vinegar') | **Real gap** | override: add `white_vinegar` (for rinsing). goat meat is rinsed with vinegar and water · *no longer flagged* |
| `mdb-53358` | Chicken Mandi | milk? (method says 'ghee') | Optional / alternative | none ('ghee/oil' (oil listed)) |
| `mdb-53359` | Beef Mandi | milk? (method says 'ghee') | Optional / alternative | none ('ghee/oil' (oil listed)) |
| `mdb-53368` | Singapore Noodles with Shrimp | peanuts? (method says 'peanut') | Optional / alternative | none ('peanut or canola oil') |
| `mdb-53369` | Silken Tofu with Sesame Soy Sauce | milk? (method says 'creme') | False positive | none ('increments') |
| `mdb-53377` | Napa Cabbage with Dried Shrimp | milk? (method says 'milk') | False positive | none ('consistency of whole milk') |
| `mdb-53380` | Apple cake | tree_nuts? (method says 'almond') | Optional / alternative | none ('optionally' almond shavings) |
| `mdb-53391` | Traditional Dutch rice tart (rijstevlaai) | milk? (method says 'milk'); sulphites? (method says 'vinegar') | False positive | none (milk = the listed plant milk; vinegar is an alternative to lemon juice) |
| `mdb-53400` | Mastawa Lamb and Rice | gluten? (method says 'bread') | Serving suggestion | none (warm naan) |
| `mdb-53422` | Num E (Sticky Rice Balls in Sugar Syrup and Coconut Cream) | gluten? (method says 'flour') | False positive | none (sticky rice flour) |
| `mdb-53423` | Meang Nem | soy? (method says 'soy') | Optional / alternative | none (soy sauce only in the vegetarian variant) |
| `mdb-53427` | Lao Naem Khao | eggs? (method says 'eggs') | **Real gap** | override: add `egg` (2). rice balls are dipped in 2 beaten eggs before frying · *no longer flagged* |
| `mdb-53439` | Arepa | gluten? (method says 'flour') | False positive | none (corn flour) |
| `mdb-53441` | Banana den Forno | milk? (method says 'cream') | Serving suggestion | none (ice cream to serve) |
| `mdb-53447` | Tafelspitz | gluten? (method says 'semolina') | Serving suggestion | none (semolina dumplings as a garnish) |
| `mdb-53454` | Breadfruit in Butter Sauce Recipe | gluten? (method says 'bread') | False positive | none ('breadfruit') |
| `mdb-53458` | Breadfruit in Butter Sauce | gluten? (method says 'bread') | False positive | none ('breadfruit') |
| `mdb-53459` | Chicken and Potato Roti | milk? (method says 'butter') | False positive | none ('butter knife') |
| `mdb-53465` | Frog Legs Recipe in Garlic Butter | gluten? (method says 'bread') | Serving suggestion | none (grilled bread) |
| `mdb-53476` | Brazilian cheese bread (pão de queijo) | gluten? (method says 'flour') | False positive | none (tapioca flour) |
| `mdb-53482` | Black bean & meat stew - feijoada | sulphites? (method says 'wine') | **Real gap** | override: add `white_wine_vinegar`. method adds white wine vinegar with the meat · *no longer flagged* |
| `mdb-53492` | Bulgarian Green Salad | eggs? (method says 'eggs') | **Real gap** | override: add `egg` (hard-boiled, to top). salad is topped with sliced hard-boiled eggs (traditional; 'if using' reads as herbs only) · *no longer flagged* |
| `mdb-53493` | Bulgarian Honey Cookies | milk? (method says 'creme') | False positive | none ('increments') · *no longer flagged* |
| `mdb-53497` | Nom Banh Chok – Cambodian Noodle Soup | gluten? (method says 'noodle') | False positive | none (rice noodles are listed) |
| `mdb-53502` | Khmer Banh Xeo – Cambodian Savory Pancake | gluten? (method says 'flour') | False positive | none (rice flour) |
| `mdb-53509` | Fried Crab | gluten? (method says 'bread') | False positive | none ('bread kind' = starchy veg) |
| `mdb-53510` | Cayman-Style Lobster | milk? (method says 'butter') | Optional / alternative | none ('butter or olive oil' (oil listed)) |
| `mdb-53543` | Dulce de Leche Cheesecake with a Maria Cookie Crust. | gluten? (method says 'pastry') | False positive | none ('pastry bag') · *no longer flagged* |
| `mdb-53549` | Chicken Salad With Mushrooms and Bacon | gluten? (method says 'bread') | Serving suggestion | none (on a slice of bread) |
| `mdb-53554` | Open-faced Sandwich With Potato | milk? (method says 'butter') | **Real gap** | override: add `butter` (for spreading). rye bread is buttered · *no longer flagged* |
| `mdb-53557` | Extra crispy chicken wings | gluten? (method says 'flour') | False positive | none (tapioca/cassava flour) |
| `mdb-53562` | Breadfruit Tacos | gluten? (method says 'bread') | False positive | none ('breadfruit') |
| `mdb-53571` | Dominica’s coconut rough cake | milk? (method says 'cream') | False positive | none ('ice cream scoop') |
| `mdb-53577` | Sauerkraut and Fish Salad | milk? (method says 'cream') | Optional / alternative | none (sour cream dressing as a variation) |

**Totals:** Serving suggestion 37 · False positive 46 · Real gap 24 · Optional / alternative 16

## Related gap not in this list

- `mdb-53223` Mutabbaq: the ingredient line says 'Mincemeat' but the method says 'minced meat', so it picks up sweet-mincemeat allergens and loses the beef/lamb protein. `extraIngredients` can't replace a line, so this is left for a human. See list (c) of `ingredient-review-summary.md`.
