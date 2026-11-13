# AI tagging batch 026

Write `tools/seedgen/tags/ai/batch-026.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53296
**Sauerkraut pierogi** · Vegetarian · area: Polish
- ingredients: 1 tablespoon Vegetable Oil, 2 Shallot, 150g Sauerkraut, 150g Cabbage, 1 large Egg, 1/2 tbs Vegetable Oil, 350g Plain Flour, For frying Vegetable Oil, 2 Shallot, Dusting Plain Flour, 45g Butter, 60 ml Sour Cream
- method (9 steps): First, make the crispy shallots. Heat the oil in a saucepan to 180C (a cube of bread will turn golden in 15 secs). Toss the shallots in a little flour and deep-fry for 1 min or until light golden and crispy. Drain on kitchen paper. Can be made up to two days before and kept in an airtight container. To make the filling, heat the oil in a medium non-stick frying pan and gently fry the shallots for 10 mins until starting to turn golden. Add the sauerkraut and cabbage, and cook for 5-10 mins until the cabbage has softened. Taste and add a little salt if under-seasoned, or sugar if stringent. Scra…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'crispy'] (0.50, keywords: chewy, creamy, crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 12 ingredients, 80 min, technique: deep-fr, knead)

### mdb-53297
**Pomegranate salad** · Vegetarian · area: Polish
- ingredients: 60 ml Olive Oil, 2 tablespoons Lemon Juice, 1 tablespoon Honey, 2 sprigs Thyme, 100g Lettuce, 250g Cherry Tomato, 3 chopped Spring Onion, 1 chopped Red Chilli, 1 Pomegranate, 50g Feta
- method (2 steps): Combine the olive oil, lemon juice, honey and thyme leaves in a large bowl. Season well, then tip in the lettuce, tomatoes, spring onions and chilli, and toss to combine. Scoop out the pomegranate seeds over a bowl and remove any white membrane. Arrange the dressed salad on a platter, then scatter over the pomegranate seeds and feta.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 50 min)

### mdb-53298
**Polish doughnuts (Pączki)** · Dessert · area: Polish
- ingredients: 10g Yeast, 1 tsp Sugar, 1 tablespoon Plain Flour, 125ml Milk, 7 Egg Yolk, 15g Sugar, 10g Sugar, 1 tsp Vanilla Extract, 500g Plain Flour, 200ml Double Cream, 15g Butter, 125ml Jam, 10g Ground Almond, For frying Vegetable Oil, 75g Icing Sugar, Juice of 1/2 Lemon, Dash Almond Extract, 50g Almond
- method (7 steps): To make the leaven, mix the yeast with the sugar and flour, and stir in the warm milk. Set aside in a warm place for 30 minutes. For the dough, put egg yolks into a heatproof bowl and add the sugar and vanilla sugar. Set the bowl over a pan of simmering water and whisk until smooth and thick. Sift the flour into the bowl of a stand mixer, add the beaten yolks and the warm cream, mix thoroughly, then add a pinch of salt and the leaven. Bring together to make a dough and knead for 10 minutes (or 15-20 if doing this by hand). When the dough stops sticking to your hands, pour in the cooled melted …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 7 steps, 18 ingredients, 200 min, technique: knead, piping, proof)

### mdb-53299
**Polish patties (kotlety)** · Side · area: Polish
- ingredients: 1 Burger Bun, 120ml Milk, 1 chopped Onion, 100 ml Vegetable Oil, 500g Beef Mince, 1 Egg, 1 Garlic, Pinch Marjoram, 75g Breadcrumb
- method (2 steps): Soak the bread roll in the milk so it softens completely. Meanwhile, fry the onion in the oil for around 8 mins or until soft and golden. Add the fried onion to the beef mince along with the egg, garlic, marjoram and some seasoning. Squeeze the excess milk from the bread roll and add it to the mince mixture. Mix everything together and season well. Divide the meat into 8 patties. Tip the dried breadcrumbs into a shallow bowl and coat the patties in it, all over. Heat some oil in a deep frying pan and fry the patties in batches on both sides until browned and cooked through, about 6-7 mins on e…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy'] (0.50, keywords: crispy, fluffy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 35 min, technique: deep fr)

### mdb-53300
**Bigos (Polish hunter's stew)** · Beef · area: Polish
- ingredients: 1 sliced Cabbage, 250ml Beef Stock, 100g Mushroom, 2 tablespoons Lard, 400g Sausage, 250g Bacon, 2 chopped Onion, 750g Beef, 200g Prune, 1 Bay Leaf, 2 Clove, 12 Peppercorn, 4 Juniper Berry, 4 Allspice Berry, 90 ml Red Wine, 2 tablespoons Tomato Puree
- method (4 steps): Put the cabbage in a heavy casserole dish, add the stock and cook over a low heat for about 50 mins, until tender. Cut the soaked mushrooms into strips and save the soaking water. Heat the lard and fry the sausages and bacon, then scoop out, leaving the fat in the pan. Fry the onion in the same pan for 5-8 mins until lightly browned. Add the mushrooms and their liquid along with all the cooked meat, onions and prunes, then cover and cook for 20 mins. Add the spices, red wine and tomato purée and bring to a simmer, then cover and cook for 1 hr. Season well and leave to cool. Will keep covered a…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth', 'tender'] (0.50, keywords: saucy, smooth, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 4 steps, 16 ingredients, 165 min, technique: piping, prove)

### mdb-53301
**Pork & sauerkraut goulash** · Pork · area: Polish
- ingredients: 3 tablespoons Lard, 4 Chopped Onion, 1 tablespoon Cumin Seed, 800g Pork Shoulder, 4 Cloves Crushed Garlic, 2 tablespoons Plain Flour, 2 tablespoons Paprika, 1 1/2 L Beef Stock, 4 Bay Leaf, 400g White Sauerkraut, 200ml Double Cream, 4 tablespoons Sour Cream
- method (3 steps): Heat the lard in a saucepan over a medium heat and fry the finely chopped onion until golden, around 5-8 mins. Tip in the cumin and pork, and fry for 10 mins all over until browned. Add the garlic, season well and scatter over the flour. Cook for about a minute, then add the paprika and cook for 1 min more. Pour in half of the stock, add the bay leaves, and simmer with the lid on over a low heat for 30 mins. Add the sauerkraut, remaining stock and a drizzle of the sauerkraut pickling juices. Simmer with the lid for 30 mins, stirring occasionally, until the meat is tender. Stir in the cream and…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 110 min)

### mdb-53302
**Slow-roasted ham with lemon, garlic & sage** · Pork · area: Polish
- ingredients: 5 chopped cloves Garlic, Zest of 1 Lemon, 15g Salt, 10g Black Pepper, 50 ml Vegetable Oil, 2kg Pork Shoulder, 500ml White Wine
- method (7 steps): Heat the oven to 200C/180C fan/gas. Bash the garlic, sage, lemon zest, salt and pepper together using a pestle and mortar until the mixture becomes a paste. Stir in the oil, then spread the mixture over the pork shoulder, avoiding the skin on top. Score the skin using a sharp knife, then rub a large pinch of salt into the skin. Tie the pork together using kitchen string. Line a large baking tray with a double layer of foil and put the pork on top, skin-side up. Bring the sides of the foil up around the pork to create a parcel, then pour the wine into the tray around the sides. Transfer to the …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 7 ingredients, 300 min, technique: temper)

### mdb-53303
**Raspberry mousse** · Dessert · area: Polish
- ingredients: 2 Gelatine, 350g Raspberry, 60g Sugar, Juice of 1 Lemon, 500ml Double Cream
- method (4 steps): Put the gelatine leaves in a bowl, cover with warm water and leave to soak for 5 mins. Drain and squeeze out any excess water. Tip the raspberries into a pan over a medium-low heat along with the sugar and lemon juice. Cook for 5-6 mins until the berries have completely broken down. Push the mixture through a sieve set over a bowl, discarding the seeds. Stir in the gelatine leaves until dissolved (if they don’t dissolve, pour the mixture into a clean saucepan and heat gently until dissolved). Set aside to cool for 15 mins. Whip the cream to soft peaks using an electric whisk, then gently fold …
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 5 ingredients, 395 min)

### mdb-53304
**Mini bundt cakes** · Dessert · area: Polish
- ingredients: 150g Butter, 175g Plain Flour, 125g Sugar, 3 Egg, 1 tsp Baking Powder, 2 tsp Cocoa Powder, 3 tablespoons Milk, 1 tablespoon Icing Sugar
- method (6 steps): Heat the oven to 180C/160C fan/gas. Melt 25g butter and generously brush into the holes of a mini bundt tins. Tip a little flour into each hole and shake to coat, then tip out the excess. Beat the butter, caster sugar and a pinch of salt together using an electric whisk. Add the eggs, one at a time, beating well after each addition. Combine the flour and baking powder in a separate bowl, then sift this into the wet ingredients and stir until smooth. Combine the cocoa powder and milk in a small bowl until smooth. Spoon 1 tbsp of the plain batter into each hole of the bundt tin. Mix the remainin…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'smooth'] (0.50, keywords: crispy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 65 min)

### mdb-53305
**Braised stuffed cabbage** · Vegetarian · area: Polish
- ingredients: 6 large Cabbage Leaf, 2 tablespoons Olive Oil, 1 chopped Onion, 2 tsp Rosemary, 1 chopped Celery, 140g Basmati Rice, 140g Cooked Chestnut, 50g Cranberry, 300ml Vegetable Stock, 1 tablespoon Balsamic Vinegar, 1 tsp Honey
- method (4 steps): Heat oven to 180C/fan 160C/gas. Remove the tough central stalk from the cabbage leaves. Bring a large pan of salted water to the boil, add the cabbage, then cook for just 1-2 mins until the leaves are starting to wilt. Drain and refresh under cold running water. Drain well, then pat dry with a tea towel. Heat the oil in a pan, add the onion, then fry for 5 mins until slightly browned. Add the rosemary and celery, then cook for 8 mins more. Stir in the rice, then cook for a min or so until the grains are glistening. Remove from the heat, stir in the chestnuts and cranberries, then season. Spoon…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy', 'tender'] (0.50, keywords: crunchy, saucy, tender)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 11 ingredients, 110 min, technique: proof)

### mdb-53306
**Pork rib bortsch** · Pork · area: Polish
- ingredients: 1kg Pork Back Rib, 2 Bay Leaf, 1 tablespoon Dried White Bean, 1 large Carrot, 1 sliced Onion, 3 sliced thinly Garlic, 1 chopped Red Pepper, 2 chopped Red Chilli, 2 Beetroot, 3 chopped Potato, 3 tablespoons Tomato Puree, 1/2 Cabbage, Handful Parsley, Handful Dill, 300g Sour Cream
- method (3 steps): Cut the meat into large pieces, put in your largest saucepan and cover with 5 litres water. Bring to the boil over a high heat, skimming away any foam that rises to the surface. Add the bay leaves. Season. Turn the heat down to a simmer and cook for 1 hr, or until the meat is soft and falls off the bone. Add the beans if using dried. Turn the heat up. Bring back to the boil, then reduce the heat and simmer for another 20 mins – the beans should still be slightly raw. Add the carrots, onions, garlic and pepper. Stir well, then add the chillies, if using. Cook for 15 mins more. Stir in the beetr…
- `flavor.sweet` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 15 ingredients, 160 min)

### mdb-53307
**Beetroot & red cabbage sauerkraut** · Vegetarian · area: Polish
- ingredients: 320g Beetroot, 450g Red Cabbage, 1 small Onion, 2 tsp Caraway Seed, 1 tsp Salt
- method (4 steps): Tip all the ingredients into a large bowl, add 1-1½ tsp freshly ground black pepper, then scrunch it all together with your hands for 5 mins. You might want to wear gloves to avoid staining your skin with the beetroot juices. Press the veg down in the bowl with your hands, then cover the surface and up the side of the bowl with a large sheet of compostable cling film or something reusable like a beeswax wrap. Now place another similar-sized bowl on top. Press down hard and add anything heavy (packs of rice or cans work well) to weigh it down so the juices rise to cover the surface. Cover again…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 5 ingredients, 15 min, technique: ferment, temper)

### mdb-53308
**Rye bread** · Side · area: Polish
- ingredients: 200g Rye, 200g Strong White Flour, 10g Yeast, 1/2 tsp Salt, 1 tablespoon Honey, 1 tsp Caraway Seed
- method (7 steps): Tip the flours, yeast and salt into a bowl. In a jug, mix the honey with 250ml warm water, pour the liquid into the bowl and mix to form a dough. Rye flour can be quite dry and absorbs lots of water, if the dough looks too dry add more warm water until you have a soft dough Tip out onto your work surface and knead for 10 mins until smooth. Rye contains less gluten than white flour so the dough will not feel as springy as a conventional white loaf. Place the dough in a well oiled bowl, cover with cling film and leave to rise in a warm place for 1-2 hrs, or until roughly doubled in size. Dust a …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 6 ingredients, 200 min, technique: knead)

### mdb-53309
**Cucumber & fennel salad** · Vegetarian · area: Polish
- ingredients: 1 large Cucumber, 1 tsp Sugar, 1 sliced Fennel Bulb, 150ml Sour Cream, Juice of 1 Lemon, 1 tablespoon White Wine Vinegar, Bunch Dill
- method (2 steps): Put cucumber in a sieve. Sprinkle with 1 tsp salt and the sugar, then leave for 10 mins. Add fennel. Mix soured cream, lemon juice, vinegar and dill, then season with black pepper and add to fennel mix.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['fresh', 'indulgent', 'light'] (0.50, keywords/category: fresh, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 25 min)

### mdb-53310
**Challah** · Side · area: Polish
- ingredients: 500g Strong White Flour, 70g Sugar, 10g Yeast, 2 Beaten Egg, 70 ml Vegetable Oil, 1 tablespoon Poppy Seed
- method (14 steps): Combine the yeast, a pinch of the sugar and a couple tablespoons of lukewarm water in a small bowl. Stir to dissolve the yeast, then leave for 10 mins until foamy. Meanwhile, combine the flour, the remaining sugar and 2 tsp fine salt in a large bowl. Make a well in the centre, then add half the beaten egg, the yeast mixture and the oil. Pour in 200ml lukewarm water (it should feel slightly warm to the touch) and stir with a spoon, then mix using one hand, keeping the other clean while you bring the dough together. If there are a lot of very dry bits, gradually add a little water to just bring …
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 14 steps, 6 ingredients, 175 min, technique: knead)

### mdb-53311
**Borsch** · Beef · area: Ukrainian
- ingredients: 1kg Beef Shin, 1 Onion, 1 Bay Leaf, 2.5kg Potato, 2 tablespoons Vegetable Oil, 1 Diced Onion, 1 Carrot, 200g Beetroot, 1 chopped Red Pepper, 200g Chopped Tomatoes, 6 Prune, 1/2 Cabbage, 400g Kidney Bean, 100 ml Creme Fraiche, Bunch Dill, To serve Bread
- method (4 steps): To make the stock, put the meat, whole onion, bay leaf and 2 litres of lightly salted cold water in a large saucepan. Cook over a very low heat for 1 hr 30 mins or until the beef shin is soft and falls apart easily – this can take up to 3 hrs. Skim off the scum with a spoon from time to time. Break up any larger pieces of beef into the broth, remove the whole onion and discard. Add the potatoes to the borscht, season well with salt and pepper and cook for 10-15 mins until tender. Meanwhile, heat the sunflower oil in a large, deep frying pan. Add the diced onion and carrot, and cook over a medi…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy', 'crispy'] (0.50, keywords: brothy, creamy, crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 4 steps, 16 ingredients, 240 min, technique: caramelis, deep fr)

### mdb-53312
**Tangy cabbage slaw** · Vegetarian · area: Ukrainian
- ingredients: 250ml Mayonnaise, Zest and juice of 1 Lemon, 2 tablespoons Cider Vinegar, 2 tablespoons Wholegrain Mustard, 1 tsp Celery Salt, 1/4 Cabbage, 1/4 Red Cabbage, 2 Carrot, 1 Diced Onion, 2 sliced Celery
- method (2 steps): Whisk together mayonnaise, lemon zest and juice, vinegar, mustard and celery salt in a small bowl, then season generously. Add cabbage, carrots, onion and celery. Mix well and refrigerate. Can be made up to 1 day ahead.
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 50 min)

### mdb-53313
**Beetroot latkes** · Vegetarian · area: Ukrainian
- ingredients: 1 tablespoon Vegetable Oil, 4 tablespoons Greek Yogurt, 1/2 bag Mint, 150g Rocket, 130g Cherry Tomato, 400g Beetroot, 1 beaten Egg, 1 tablespoon Plain Flour, 1 clove finely chopped Garlic, 1 tsp Caraway Seed, 1/2 teaspoon Ground Cumin, Zest of 1 Lemon
- method (4 steps): Heat the oven to 180C/160C fan/gas. Make the latkes by combining all of the ingredients. Heat the oil in a large non-stick pan. Spoon in the mixture to make six round latkes. Fry for 4-5 mins on each side, then transfer to a baking sheet and bake for 10 mins. Combine the yogurt and mint in a small bowl. Toss the salad leaves and tomatoes together, then serve the latkes with the mint yogurt and salad.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'light'] (0.50, keywords/category: comfort, fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 40 min)

### mdb-53315
**Rosemary braised red cabbage with kabanos** · Pork · area: Ukrainian
- ingredients: 1/2 Red Cabbage, 1 tablespoon Olive Oil, Knob Butter, 1 sliced Red Onion, 125ml Red Wine Vinegar, 140g Brown Sugar, 1 chopped Red Chilli, 2 sprigs Rosemary, 1 chopped Cooking Apple, 8 Kabanos Sausage
- method (3 steps): Halve the cabbage, remove the tough stem and thinly slice. Place in a large pan with all the other ingredients apart from the sausages, then mix in 300ml water and some salt and pepper. Bring to a simmer, then reduce the heat, cover with a well-fitting lid and gently cook for 1½ hrs, stirring frequently. If too dry, you can add a little more water. Add the kabanos to the cabbage mixture, place a lid on the pan and gently simmer for 20 mins. Remove the lid and cook for a further 10 mins. Serve alongside some simple mash or boiled potatoes.
- `flavor.bitter` rule: 3 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'tender'] (0.50, keywords: creamy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 145 min)

### mdb-53316
**Beetroot pancakes** · Dessert · area: Ukrainian
- ingredients: 3 Beetroot, 50 ml Milk, 200g Self Raising Flour, 1 tsp Baking Powder, 2 tablespoons Maple Syrup, 1/2 teaspoon Vanilla Extract, 3 Egg, 25g Butter, 200g Mixed Berry, 2 tablespoons Blackcurrant Jam, 100g Greek Yogurt
- method (3 steps): Put the beetroot in a jug with the milk and blend with a stick blender until smooth. Pour into a bowl with the rest of the pancake ingredients and whisk until smooth and vibrant purple. Put a small knob of butter in a large non-stick frying pan and heat over a medium-low heat until melted and foamy. Now create 3 or 4 pancakes each made from 2 tbsp of the batter. Cook for 2-3 mins then flip over and cook for a further minute until cooked through. Repeat with any remaining batter. Heat oven to lowest setting and keep the pancakes warm in there until needed. Serve with your favourite pancake topp…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy', 'smooth'] (0.50, keywords: crispy, fluffy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 30 min)
