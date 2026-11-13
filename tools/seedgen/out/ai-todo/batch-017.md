# AI tagging batch 017

Write `tools/seedgen/tags/ai/batch-017.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53105
**Spiced smoky barbecued chicken** · Chicken · area: Australian
- ingredients: 2 cloves Garlic, Juice/zest of one Lemon, 2 tblsp Curry Powder, Pinch Chilli Flakes, 3 tablespoons Olive Oil, 12 Chicken Thigh, Bunch Rosemary, Bunch Rosemary, Bunch Thyme, Bunch Thyme, 2 Bay Leaf
- method (4 steps): Make the marinade. Smash the garlic with a little salt using a pestle and mortar. Add the lemon zest and juice, the spice mix, chilli, oil and a good grinding of black pepper. Mix to a paste. This can be done in a mini food processor. Toss the chicken in the marinade and set aside while you light the barbecue. When the barbecue’s hot, lay the bunches of herbs on the grid and put the chicken, skin side up, on top. Close the lid, if your barbecue has one, and cook the chicken on the smouldering herbs for about 10 minutes until the meat starts to colour. Turn the chicken and continue to cook for …
- `flavor.bitter` rule: 3 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 55 min)

### mdb-53106
**Warm roast asparagus salad** · Pork · area: Australian
- ingredients: 500g Asparagus, 2 tbsp Red Wine Vinegar, 4 Tomato, 1 tbsp Olive Oil, 12 Bacon, 1 teaspoon Honey, 16 New Potato, 2 tblsp Olive Oil, 1 teaspoon Dijon Mustard, 100g Rocket
- method (5 steps): Preheat the oven to 200C/Gas 6/fan 180C. Snap off the woody ends of the asparagus and discard. Arrange the asparagus in a single layer in a baking tray with sides. Cut the tomatoes in half widthways, nestle them in with the asparagus, season with sea salt and pepper and drizzle with olive oil. Roll each bacon rasher into a tight roll (if large, first cut in half crosswise), and arrange in the tray. Drizzle the bacon rolls with the honey and bake for 20 minutes until the tomatoes are soft and the bacon is crisp. In the meantime, boil the potatoes until tender. Whisk the vinegar, olive oil, must…
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 40 min)

### mdb-53107
**Avocado dip with new potatoes** · Vegetarian · area: Australian
- ingredients: 3 Large Avocado, 200g Yogurt, Zest and juice of 1 Lime, Juice of 1/2 Lemon, 1.25kg New Potato, 2 tablespoons Olive Oil, 1 teaspoon Chilli Powder, 1 teaspoon Cumin Seed, 200g Flour Tortilla
- method (3 steps): Whizz half the avocado flesh with the yogurt, lime and lemon juice and seasoning. Dice the remaining avocado, then gently stir into the whizzed mix with most of the lime zest. Cover, then chill until ready to serve. Boil potatoes for 6 mins, then drain well and toss with olive oil, chilli powder and cumin seeds. Now set aside until half an hour before your guests arrive. Heat oven to 200C/180C fan/gas 6, then roast potatoes for about 30 mins, shaking the tray halfway, until golden and tender. Transfer the dip to one or two bowls, scatter with the remaining lime zest and serve with the hot pota…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 95 min)

### mdb-53108
**Quick salt & pepper squid** · Seafood · area: Australian
- ingredients: 400g Squid, 3 tablespoons Vegetable Oil, 1/2 teaspoon Five Spice Powder, Dash Sesame Oil, Sprigs of fresh Coriander, Drizzle Sweet Chilli Sauce
- method (5 steps): Ask the fishmonger to clean the squid; little ones often come ready-cleaned. Using kitchen scissors, cut open the body and open out. Wash well, then pat dry. If you have a large squid, cut the body into four portions, roughly square. Small squid can just be opened up. Using the tip of a very sharp knife, score the top in a neat criss-cross. Brush with oil and set aside while you heat the barbecue or griddle until ready to cook. Mix together 2 tsp sea salt, Chinese five-spice and 1 tsp freshly ground black pepper. Sprinkle on both sides of the squid just before cooking, according to taste. You …
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 6 ingredients, 20 min)

### mdb-53109
**Mini chilli beef pies** · Beef · area: Australian
- ingredients: 450g Shortcrust Pastry, 1 tablespoon Vegetable Oil, 1 small Onion, 2 tsp Chilli Powder, 2 tsp Ground Cumin, 250g Beef Mince, 85g Tomato Puree, 150ml Beef Stock, Pinch Cinnamon, 200g Kidney Bean, 1 large Potato, 3 tablespoons Sour Cream, 2 tablespoons Chive
- method (4 steps): To make chilli, heat oil in a pan and fry onion for 5 mins until soft. Add spices; fry for 1 min. Stir in beef and cook for a few mins. Add tomato purée, stock and cinnamon. Give it a stir, bring to the boil, then simmer for 15-20 mins until very little liquid is left. Add beans 5 mins before the end of cooking. Check seasoning and cool. Heat oven to 200C/fan 180C/gas. Using a 7cm pastry cutter, stamp out 12 circles from the pastry. Use to line a 12-hole mini muffin tray, prick the base of the pastry with a fork, and bake for 10 mins. Remove from oven and cool on a wire tray. Repeat with remai…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky', 'smooth'] (0.50, keywords: creamy, flaky, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 13 ingredients, 80 min)

### mdb-53110
**Sticky Chicken** · Chicken · area: Australian
- ingredients: 8 Chicken Drumstick, 2 tblsp Soy Sauce, 1 tablespoon Honey, 1 tblsp Olive Oil, 1 teaspoon Tomato Puree, 1 tbsp Dijon Mustard
- method (2 steps): Make 3 slashes on each of the drumsticks. Mix together the soy, honey, oil, tomato purée and mustard. Pour this mixture over the chicken and coat thoroughly. Leave to marinate for 30 mins at room temperature or overnight in the fridge. Heat oven to 200C/fan 180C/gas 6. Tip the chicken into a shallow roasting tray and cook for 35 mins, turning occasionally, until the chicken is tender and glistening with the marinade.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 80 min, technique: temper)

### mdb-53111
**Anzac biscuits** · Dessert · area: Australian
- ingredients: 85g Oats, 85g Desiccated Coconut, 100g Plain Flour, 100g Sugar, 100g Butter, 1 tblsp Golden Syrup, 1 teaspoon Bicarbonate of Soda
- method (4 steps): Heat oven to 180C/fan 160C/gas. Put the oats, coconut, flour and sugar in a bowl. Melt the butter in a small pan and stir in the golden syrup. Add the bicarbonate of soda to 2 tbsp boiling water, then stir into the golden syrup and butter mixture. Make a well in the middle of the dry ingredients and pour in the butter and golden syrup mixture. Stir gently to incorporate the dry ingredients. Put dessertspoonfuls of the mixture on to buttered baking sheets, about 2.5cm/1in apart to allow room for spreading. Bake in batches for 8-10 mins until golden. Transfer to a wire rack to cool.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 25 min)

### mdb-53112
**Kenyan Beef Curry** · Beef · area: Kenyan
- ingredients: 4 cups Water, 2 Lbs Sirloin Steak, 4 Garlic, 2 teaspoons Ground Ginger, 2 tblsp Vegetable Oil, 2 medium Red Onion, 4 Tomato, 2 tblsp Paprika, 1/2 teaspoon Black Pepper, 2 teaspoons Curry Powder, 4 tablespoons Tomato Puree, Dash Salt, 1 Red Chilli, Leaves Coriander
- method (8 steps): Bring the 4 cups of water to a boil in a Dutch oven or soup pot. Add the beef, garlic, and ginger, and stir well. Bring to a gentle simmer, cover, and cook, stirring occasionally, for 20 minutes. If you get any foamy scum on the top, not to worry, simply spoon it away or stir it back in. Remove from the heat, and drain, but reserve the excess water for later. Return the pot or Dutch oven to medium heat with the 2 tablespoons of cooking oil. Once the oil is shimmering, add the onions and cook, stirring occasionally, until softened, 5 to 7 minutes. Add the tomatoes to the onions, and continue co…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy', 'smooth'] (0.50, keywords: brothy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 14 ingredients, 120 min)

### mdb-53113
**Sukuma Wiki** · Vegetarian · area: Kenyan
- ingredients: 2 tablespoons Vegetable Oil, 2 medium Red Onion, 1 lb Kale, Dash Salt, 1 cup Double Cream
- method (4 steps): Heat the 2 tablespoons of oil in a large skillet or pot over medium heat until shimmering. Add the onions and cook, stirring occasionally, until softened, 5 to 7 minutes. Add the shredded kale to the onions and mix well. Turn the heat to medium-low, cover and cook for 5 minutes. After 5 minutes, remove the lid, add salt to taste, and stir in the cream. Continue cooking for another 5 minutes, uncovered, stirring occasionally. The cream will thicken slightly, making for a deliciously rich creamed kale and onions. Yumm! Serve it up with your favorite Kenyan stew, and a side of ugali!
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'tender'] (0.50, keywords: creamy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 5 ingredients, 35 min)

### mdb-53114
**Ugali – Kenyan cornmeal** · Breakfast · area: Kenyan
- ingredients: 2 cups Water, 1 1/2 cups Cornmeal
- method (4 steps): Bring the water to a boil in a medium saucepan. Reduce the heat to low, and stirring constantly with a whisk, slowly add the cornmeal to the boiling water. The ugali will begin to thicken quite quickly. Continue cooking on low heat, stirring constantly with a sturdy wooden spoon, until the ugali begins to pull away from the sides of the pan, hold together, and takes on the aroma of roasted corn. Turn it out immediately onto a serving plate. If you would like, using a spoon or spatula, quickly shape it into a thick disk or round. The ugali will continue to firm as it cools and will be thick eno…
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Breakfast guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 2 ingredients, 25 min)

### mdb-53115
**Red onion pickle** · Vegan · area: Norway
- ingredients: 3 Large Red Onion, 2 tsp Salt, 200ml Cider Vinegar, 50g Sugar, 1 tsp Black Pepper, 4 Bay Leaf
- method (3 steps): Peel the onions, cut them in half from top to bottom and finely slice into half-moon pieces. Put in a colander placed over a bowl and sprinkle with salt, lightly turning over the onion pieces with your hands so the surfaces are all covered. Set aside for an hour or so to brine. Meanwhile put the vinegar, 50ml/2fl oz water and the sugar in a saucepan. Bring to a simmer, stirring to help the sugar dissolve, and cook for a couple of minutes. Set aside. Pack the onions into the sterilised jars, sprinkling in a little pepper as you go. Cover with the warm vinegar and finish by tucking a couple of b…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 6 ingredients, 85 min)

### mdb-53116
**Cinnamon buns** · Dessert · area: Norway
- ingredients: 100g Butter, 200ml Milk, 1 teaspoon Salt, 250g Plain Flour, 250g Strong White Flour, 1 1/2 tsp Yeast, 1 teaspoon Cardamom, 1 tblsp Sugar, 2 Egg, Dash Olive Oil, 75g Butter, 100g Sugar, 2 tbsp Cinnamon, 1 Egg
- method (13 steps): In a small saucepan heat the butter, milk and salt until the butter is melted. Allow the mixture to cool until it is lukewarm. In a large bowl, stir together the flours, yeast, cardamom and sugar until combined. Make a well in the centre and crack in the eggs. Pour in the lukewarm milk mixture and stir everything together to form a sticky dough. You may have to use your hands as the dough becomes stiffer. Oil the work surface with a teaspoon of olive oil. Turn the dough out onto the oiled surface and knead vigorously for 5–8 minutes, using a plastic scraper as needed to prise the dough from th…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-53117
**Nordic smørrebrød with asparagus and horseradish cream** · Vegetarian · area: Norway
- ingredients: 150ml Creme Fraiche, 2 tblsp Horseradish, 1 teaspoon Lemon Juice, Pinch Salt, Pinch Black Pepper, Dash Vegetable Oil, 2 Shallot, Pinch Salt, 8 White Asparagus, 8 Asparagus, 4 slices Rye Bread, 1 tblsp Butter, 100g Vasterbottensost Cheese, Sprinking Dill, Pinch Salt, Pinch Black Pepper
- method (7 steps): To make the horseradish cream, mix the crème fraîche, grated horseradish, lemon juice, salt and white pepper in a bowl. Refrigerate until serving. To make the crispy shallots, heat some vegetable oil in a frying pan over a medium heat. Add the sliced shallots and fry until golden brown and crispy. Remove with a slotted spoon and drain on a plate lined with kitchen paper. Season with a pinch of salt. To make the open sandwich, bring a large saucepan of salted water to the boil, then blanch half of the asparagus (four white and four green) until tender-crisp, about 2–3 minutes. Add ice to a bowl…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 16 ingredients, 45 min)

### mdb-53118
**Rømmegrøt – Norwegian Sour Cream Porridge** · Breakfast · area: Norway
- ingredients: 2 cups Sour Cream, 3/4 cup Plain Flour, 2 cups Milk, 1 tsp Salt, Sprinkling Sugar, Sprinkling Cinnamon, To taste Butter
- method (4 steps): ▢ Cook the sour cream in a covered saucepan on medium heat for about 5 minutes. ▢ Turn down the heat and add half of the flour and stir well with a whisk. Once the flour is fully incorporated, let the mixture continue to cook, stirring occasionally, until fat starts to release. Use a spoon to gather as much of the fat as you can in a small bowl, saving for later. (Don't worry if you can't get any fat – in that case you can add butter later.) ▢ Whisk in the rest of the flour and then slowly add the milk, whisking constantly to avoid lumps. Let the porridge continue to cook on low heat for 5 min…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 25 min)

### mdb-53119
**Tall Skoleboller** · Dessert · area: Norway
- ingredients: 1 cup Milk, 3 tsp Yeast, 1-⅓ cups Sugar, 1 tsp Cardamom, 1 teaspoon Vanilla Extract, 2 1/4 cups Plain Flour, 5 tblsp Butter, 1 1/4 cup Milk, 1-⅓ cups Sugar, 3 Egg Yolk, 2 tblsp Cornflour, 1 Vanilla Pod, 2 cups Icing Sugar, 3 tablespoons Water, 1 cup Desiccated Coconut
- method (4 steps): ▢ Heat the milk until it's lukewarm. Add the yeast and dissolve. ▢ Add the sugar, cardamom, vanilla, and about 2/3 of the flour. ▢ Mix the dough together either by hand or in a mixer with a dough hook, slowly adding the rest of the flour. You might need a bit more or less flour to form dough that isn't too sticky to knead. When the dough forms a nice ball, add the softened butter and continue to knead the dough for about ten minutes. ▢ Roll the dough into a cylinder and cut into six equal parts. Roll each piece into a round bun and set them in a greased muffin/cake tin. Cover and let rise unti…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 15 ingredients, 100 min, technique: knead)

### mdb-53121
**Norwegian Potato Lefse** · Side · area: Norway
- ingredients: 3 Lbs Potato, 1 teaspoon Salt, 1 teaspoon Sugar, 1/4 cup Butter, 1/4 cup Double Cream, 1 1/2 cups Plain Flour, 1/2 cup Plain Flour, 14 tablespoons Butter, 3/4 cup Sugar, 1 tablespoon Double Cream
- method (9 steps): Boil the potatoes. Peel the potatoes while still warm and run them through a potato ricer twice. ▢ Let the potatoes cool in an uncovered bowl in the fridge. ▢ Stir the salt, sugar, melted butter, and cream into the riced potatoes. ▢ Slowly add the flour and knead by hand until you get a good consistency. Don't add more flour than necessary! Roll the dough into a long sausage and divide into about 7 or 8 pieces if using an 18 inch griddle. If using a smaller griddle or frying pan, divide the dough into 10 – 12 pieces. ▢ Roll each piece into a ball and then press into a flat circle, using the ed…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 10 ingredients, 30 min, technique: knead)

### mdb-53122
**Fiskesuppe (Creamy Norwegian Fish Soup)** · Seafood · area: Norway
- ingredients: 1 lb White Fish, 1 clove Garlic, 2 medium Potato, 2 Carrot, 1 Leek, 3 tablespoons Butter, 5 tablespoons Plain Flour, 4 cups Fish Stock, 1 cup Milk, 1 1/4 cup Creme Fraiche, 1 cup Prawn, 1 tablespoon Chive
- method (6 steps): ▢ Cut the fish fillets in cubes or strips. Crush or chop the garlic. Rinse the vegetables and cut into thin strips. ▢ Heat the butter in a pot and add the garlic. Once the garlic starts to turn golden add the flour, whisking well. ▢ Add the fish stock and continue to whisk until there are no lumps. ▢ Add the vegetables and milk and bring to a boil. Cook for about 10 minutes. ▢ Add the crème fraîche (or sour cream). Bring the soup back to a simmer and once the soup begins to bubble again turn off the heat. Keep the soup on the burner and add the fish. Let the fish cook in the hot soup for 5 min…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 12 ingredients, 45 min)

### mdb-53123
**Fårikål (Norwegian National Dish)** · Lamb · area: Norway
- ingredients: 3 Lbs Lamb, 1 head Cabbage, 3 tablespoons Peppercorn, 3 tsp Salt, 1 1/2 cups Water, 5 tablespoons Plain Flour
- method (6 steps): ▢ Cut the lamb into large pieces. ▢ Slice the cabbage into large wedges, keeping the core attached. ▢ Add a layer of lamb pieces to the bottom of a large pot, fatty side down. Sprinkle with peppercorns and salt. Add a layer of cabbage wedges on top. Repeat with more layers of lamb, peppercorns, and cabbage, ending with cabbage on top. ▢ Optional: Sprinkle a couple of tablespoons on top of the lamb for a thicker stew. ▢ Add water to the pot and bring to a boil. Cover and reduce heat. Cook on low heat for 2 – 3 hours, until the lamb gently falls away from the bone. ▢ Serve with boiled potatoes a…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy', 'tender'] (0.50, keywords: brothy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'light'] (0.50, keywords/category: comfort, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 6 ingredients, 140 min)

### mdb-53124
**Raspeballer (Norwegian Potato Dumplings)** · Pork · area: Norway
- ingredients: 1 Pork Knuckle, 1 Sausage, 1 lb Potato, 2 Lbs Potato, 1 1/4 cup Plain Flour, 2 tblsp Plain Flour, 1 teaspoon Salt, 4 Vegetable Stock, Pinch Parsley, 1 Swede, 2 Carrot, 1/4 cup Cream, 1 tblsp Butter, 1 teaspoon Ground Nutmeg
- method (8 steps): Raspeballer & (Optional) Salted Meat ▢ If you're making pork knuckle, cook it in simmering water for about 3 hours, until the meat falls from the bone. Remove the pork and save the broth to cook the raspeballer. ▢ Boil the boiled potatoes and peel once cooled. Also peel the raw potatoes, and then grate them or run them through a food processor. Use a paper towel to remove some of the moisture from the grated potatoes. ▢ Mash the boiled potatoes in a potato ricer or with a masher. Make sure there are no lumps. Add the grated raw potatoes to the mashed potatoes in a large mixing bowl and stir to…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy', 'fluffy'] (0.50, keywords: brothy, creamy, fluffy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 14 ingredients, 280 min)

### mdb-53125
**Karbonader (Lean Beef Patties) with Caramelized Onions** · Beef · area: Norway
- ingredients: 2 Onion, 1 tablespoon Butter, 1 lb Beef Mince, 1/2 teaspoon Salt, 1/2 teaspoon Black Pepper, 1/2 teaspoon Ground Nutmeg, 1/2 tbs Cornflour, 50 ml Water, 2 tblsp Butter
- method (5 steps): Grate half an onion and set aside. Slice the rest of the onions and fry in butter on low/medium heat until caramelized. ▢ In a bowl, mix together ground beef, grated onion, salt, pepper, nutmeg, potato/corn starch, and water. ▢ Form into a sausage and cut 6 patties. Using a knife make a light grid pattern in each patty. ▢ Brown both sides of the karbonader in butter on high heat, then turn down to low heat and fry for another 2 – 3 minutes. ▢ Serve the karbonader and onions with potatoes, stewed peas, and brown sauce for dinner, or on a slice of bread for lunch or a snack.
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 30 min, technique: caramelize)
