# AI tagging batch 024

Write `tools/seedgen/tags/ai/batch-024.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53254
**Ezme** · Vegetarian · area: Turkish
- ingredients: 3 Large Tomato, 1 medium Red Pepper, 1 medium Green Chilli, 1 small Onion, 2 cloves minced Garlic, 25g Parsley, 2 tablespoons Red Pepper Paste, 1 tablespoon Tomato Puree, 2 tablespoons Pomegranate Molasses, 1 tablespoon Pul Biber, 2 tsp Sumac, 1 tablespoon Dried Mint, 60 ml Olive Oil
- method (2 steps): Put the tomatoes and all of the peppers in a food processor and blitz until finely chopped. Tip out into a sieve, set over a bowl and leave to strain. Add the onions, garlic and parsley to the food processor and blitz until finely chopped, then set aside. Add red pepper paste, tomato purée, pomegranate molasses, pul biber, sumac, dried mint and most of the extra virgin olive oil to a serving bowl and whisk well so everything comes together as a sauce. Tip in the blitzed onion mixture and the strained pepper mixture along with 1 tsp flaky sea salt . Stir well, then drizzle with the remaining ex…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky', 'saucy', 'smooth'] (0.50, keywords: flaky, saucy, smooth)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 13 ingredients, 60 min)

### mdb-53255
**Grilled aubergines with spicy chickpeas & walnut sauce** · Vegetarian · area: Turkish
- ingredients: 4 tablespoons Olive Oil, 1 chopped Onion, 1 chopped Red Chilli, 2cm piece Ginger, 1/2 teaspoon Ground Cumin, 400g Chickpea, 200g Tomato, Juice of 1/2 Lemon, 2 Aubergine, 200g Greek Yogurt, 1 Garlic, 25g Walnut, Handful Coriander
- method (3 steps): Heat 2 tbsp oil in a pan, add the onion and fry until soft and lightly browned, about 10 mins. Add the chilli, ginger and spices and mix well. Stir in the chickpeas, tomatoes and 5 tbsp water, bring to the boil, then simmer for 10 mins. Add a little salt and pepper and the lemon juice. Arrange the aubergines over a grill pan. Brush lightly with oil, sprinkle with salt and pepper, then grill until golden. Flip them over, brush again with oil, season and grill again until tender and golden. Mix the yogurt with the garlic, most of the walnuts and coriander and a little salt and pepper. Arrange th…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 13 ingredients, 45 min)

### mdb-53256
**Cacik** · Side · area: Turkish
- ingredients: 500g Yogurt, 2 tsp Lemon Juice, 1 tablespoon Olive Oil, 1 tablespoon Dried Mint, 1 Cucumber, 2 cloves minced Garlic
- method (4 steps): Put a sieve over a large bowl, line it with a thick sheet of non-dyed kitchen paper or a clean muslin cloth, and spoon in the yogurt. Cover with another sheet of kitchen paper and leave to strain in the fridge for a minimum of 12 hrs. Add the lemon juice, most of the olive oil and the dried mint to a bowl and stir well for the dried mint to soften and soak up the juices. Mix in the strained yogurt, then pour away the strained yogurt liquid and leave that bowl to one side. Halve the cucumber(s) lengthways and remove the seeds by running a teaspoon from the top to the bottom of the flesh, halve …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 760 min)

### mdb-53257
**kofta burgers** · Lamb · area: Turkish
- ingredients: 1kg Lamb, 2 Onion, 1 Garlic, 6 tablespoons Garam Masala, Bunch Coriander, 1 tablespoon Chilli Sauce, 8 Pita Bread, 4 sliced Tomato, 1/2 Red Cabbage, 1 sliced Red Onion, Small pack Yogurt
- method (2 steps): Tip the mince into a large bowl (use a clean washing-up bowl if you don’t have anything big enough) with all the other burger ingredients and a good pinch of salt. Roll up your sleeves, get your hands into the mix and squelch everything together through your fingers until completely mixed. Pat the mix into 16 small burgers. These may now be frozen for up to 1 month or chilled up to a day ahead. To cook, heat grill to its highest setting and lay the burgers in a single layer on a baking tray (you may need to do this in batches, depending on how big your tray is). Grill on the highest shelf for …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 11 ingredients, 30 min)

### mdb-53258
**Hot cumin lamb wrap with crunchy slaw & spicy mayo** · Lamb · area: Turkish
- ingredients: 4 small Lamb Leg, 2 tsp Olive Oil, 1 tsp Ground Cumin, 1 tablespoon Sugar, 3 tablespoons White Wine Vinegar, 2 Carrot, 2 sliced Spring Onion, 400g Cabbage, 5 Sweet Peppadew Pepper, 3 tablespoons Mayonnaise, 4 large Pita Bread
- method (3 steps): Heat a griddle pan. Rub the lamb steaks with the oil, cumin and some seasoning. Griddle for about 3-4 mins on each side or until cooked to your liking. Place to one side on a plate to rest. In a large bowl, stir the sugar into the vinegar until dissolved. Add the carrots, spring onions, cabbage and some seasoning, and toss together. Blitz the whole peppers and the mayo in a food processor. Add a heap of the salad to each flatbread. Slice the lamb, trimming off any excess fat and lay on top of the salad, drizzling with the resting juices. Spoon over the mayo and scatter with a few of the sliced…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 35 min)

### mdb-53259
**Smoked aubergine purée** · Side · area: Turkish
- ingredients: 2 medium Aubergine, Juice of 1 Lemon, 3 Cloves Crushed Garlic, 150ml Yogurt, Bunch Dill
- method (2 steps): Heat grill to very hot. Slice the aubergines in half lengthways, then grill for 25 mins, turning occasionally, until soft – the skin will remain firm, but the flesh will soften. Lift the aubergines off the grill and leave until cool enough to handle. Using a sharp knife, score the grilled flesh and scoop out the flesh with a spoon. Tip into a bowl and mash with a fork until you get a thick pulp. Beat in the lemon juice and garlic. Add the yogurt and dill, and season. Serve while still warm.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 5 ingredients, 40 min)

### mdb-53260
**Slow-roast lamb with cinnamon, fennel & citrus** · Lamb · area: Turkish
- ingredients: 1 Lamb Leg, Zest and juice of 1 Lemon, 4 tablespoons Olive Oil, 2 tablespoons Honey, 1 tablespoon Cinnamon, 1 tablespoon Fennel Seed, 1 tablespoon Ground Cumin, 3 Cloves Crushed Garlic
- method (5 steps): Put the lamb into a large food bag with all the juice and marinate overnight. The next day, take the lamb out of the fridge 1 hr before you want to cook it. Heat oven to 220C/200C fan/gas. Take the lamb out of the marinade (reserve remaining marinade) and pat dry. Rub with half the oil and roast for 15-20 mins until browned. Remove lamb and reduce oven to 160C/140C fan/gas 3. Mix the zests, remaining oil, honey, spices and garlic with plenty of seasoning. Lay a large sheet of baking parchment on a large sheet of foil. Sit the lamb leg on top, rub all over with the paste and pull up the sides o…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 8 ingredients, 845 min)

### mdb-53261
**Chicken wings with cumin, lemon & garlic** · Chicken · area: Turkish
- ingredients: 12 Chicken Wing, 2 cloves minced Garlic, Zest and juice of 1 Lemon, 1 tsp Cumin Seed, 2 tablespoons Olive Oil, 1 tablespoon Honey
- method (3 steps): Using a pair of sharp kitchen scissors, cut each wing at the knuckle into two pieces. Mix the garlic, lemon zest and juice, cumin and oil with plenty of seasoning, then tip into a dish with the chicken wings and toss to coat. Cover and put in the fridge to marinate for at least 1 hr, or overnight if you have time. Heat oven to 200C/180C fan/gas 6, or heat an outdoor barbecue. Bake the chicken wings on an oven tray for 45-50 mins until crisp, or barbecue for 20 mins, drizzling over the honey for the final 10 mins of each method. Serve on a platter with plenty of paper napkins. Fill small bowls …
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy'] (0.50, keywords: crispy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 6 ingredients, 120 min)

### mdb-53262
**Adana kebab** · Lamb · area: Turkish
- ingredients: 2 large Red Pepper, 800g Lamb Mince, 3 tablespoons Red Pepper Paste, 1 tablespoon Pul Biber, 3 tablespoons Vegetable Oil
- method (8 steps): Finely chop the peppers in a food processor, then tip them in a sieve and press into the sieve so that the peppers release all of their juices. Tip into a bowl along with the mince, red pepper paste, pul biber, 1½ tsp flaky sea salt, and 2 tbsp of the oil. Mix together, kneading well for at least 2-3 mins. If you need to, wet your hands with cold water to prevent the mixture from sticking. The mixture should be sticky when ready. Cover and chill for at least 2 hrs, or up to 12 hrs. When ready to cook, heat the grill to high or an oven to 220C/200C fan/gas. Divide the mixture into 12 equal port…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'flaky'] (0.50, keywords: crispy, flaky)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 5 ingredients, 760 min, technique: knead)

### mdb-53263
**Turkish lamb pilau** · Lamb · area: Turkish
- ingredients: Handful Pine Nut, 1 tablespoon Olive Oil, 1 Large Chopped Onion, 2 Cinnamon, 500g Lamb, 250g Basmati Rice, 1 Lamb Stock, 12 Dried Apricot, Handful Mint
- method (2 steps): Dry-fry the pine nuts or almonds in a large pan until lightly toasted, then tip onto a plate. Add the oil to the pan, then fry the onion and cinnamon together until starting to turn golden. Turn up the heat, stir in the lamb, fry until the meat changes colour, then tip in the rice and cook for 1 min, stirring all the time. Pour in 500ml boiling water, crumble in the stock cube, add the apricots, then season to taste. Turn the heat down, cover and simmer for 12 mins until the rice is tender and the stock has been absorbed. Toss in the pine nuts and mint and serve.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 35 min)

### mdb-53264
**Smoky chicken skewers** · Chicken · area: Turkish
- ingredients: 6 Chicken Thigh, 2 tablespoons Olive Oil, 1 tsp Fennel Seed, 1 tsp Ground Cumin, 1 tsp Smoked Paprika, 1 clove peeled crushed Garlic, 1 tsp Red Wine Vinegar, To serve Smoky Aioli
- method (2 steps): You need 15 skewers: if wooden, soak in water for 10 mins. Cut chicken into 3cm pieces and place in a bowl. Add 1 tbsp olive oil, the spices, garlic and vinegar, toss well and season. You can do this up to a day before and refrigerate. Thread 2-3 pieces on each skewer. Pour remaining oil in a frying pan or rub onto a griddle pan. Get the pan hot and sear the chicken for 3-4 mins on each side – you may have to do this in batches, keeping the cooked skewers warm in a low oven. Serve with smoky aïoli if you like.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 30 min)

### mdb-53265
**Chilli ginger lamb chops** · Lamb · area: Turkish
- ingredients: 4 Cloves Crushed Garlic, 1 tblsp Ginger, 1 tblsp Lemon Juice, 1 tblsp Olive Oil, 1/2 tsp Chilli Powder, 1 tsp Ground Cumin, 8 Lamb Loin Chop
- method (2 steps): Put the garlic in a bowl with the ginger, lemon juice, oil, spices and seasoning. Blitz with a hand blender until smooth, then use to coat the lamb chops on both sides. Leave to marinate in the fridge for a couple of hours or overnight. Heat a barbecue until hot. Barbecue the chops over the coals for 3 mins on each side until cooked but still pink and juicy in the centre.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 145 min)

### mdb-53267
**Aubergine couscous salad** · Vegetarian · area: Turkish
- ingredients: 1 sliced Aubergine, 3 tablespoons Olive Oil, 140g Couscous, 225g Vegetable Stock, 200g Cherry Tomato, Handful Mint, 100g Goats Cheese, Juice of 1/2 Lemon
- method (2 steps): Heat grill to high. Put the aubergine on a baking sheet, brush with oil and season. Grill for about 15 mins, turning and brushing with more oil halfway, until browned and softened. Meanwhile, tip the couscous into a large bowl, pour over the stock, then cover and leave for 10 mins. Mix the tomatoes, mint, goat’s cheese and remaining oil together. Fluff the couscous up with a fork, then stir in the aubergines, tomato mixture and lemon juice.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['fluffy'] (0.50, keywords: fluffy)
- `moods` rule: ['fresh', 'indulgent', 'light'] (0.50, keywords/category: fresh, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 40 min)

### mdb-53268
**Roasted chicken with creamy walnut sauce** · Chicken · area: Turkish
- ingredients: 8 Chicken Thigh, 1 tsp Ground Cumin, 1/2 tsp Paprika, 2 tablespoons Olive Oil, 6 Pita Bread, 150ml Chicken Stock, 175g Walnut, 1 chopped Onion, 2 cloves chopped Garlic, 50 ml Single Cream, Juice of 1 Lemon, Handful Coriander
- method (6 steps): Heat oven to 200C/180C fan/gas. In a roasting tin, toss together the chicken, cumin, paprika, 1 tbsp olive oil and seasoning. Cook for 40 mins until the chicken is crisp and cooked through. Meanwhile, tear up 1 pitta bread and place in a small bowl. Pour over a couple of tbsp chicken stock and leave to soak. Dry-fry the walnuts in a frying pan for about 3 mins until golden and toasted. Set aside. Heat the remaining oil in the pan and cook the onion and garlic until softened. Place the softened pitta bread, onion mixture and most of the nuts into a blender. Pour over the rest of the chicken sto…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 12 ingredients, 75 min)

### mdb-53270
**Turkish-style lamb** · Lamb · area: Turkish
- ingredients: 4 Lamb Leg, 2 tsp Seasoning, 1 tsp Dried Oregano, Bunch Mint, 300g Yogurt, 4 Pita Bread, 1/2 Lettuce, 1 sliced Red Onion, 1 Lemon
- method (2 steps): Heat grill to high. Season the lamb, then grill for 2 mins on each side until browned, but still very rare. Meanwhile, mix the seasoning, oregano and half of the mint into one of the tubs of yogurt, smother this over the lamb, then return to the grill for another 2-3 mins or until the yogurt is blistered and the meat is cooked to your liking. Leave the meat to rest on a board for a few mins while you toast the pittas, shred the lettuce and thinly slice the red onion. Stir the rest of the mint into the second tub of yogurt. Thickly slice the meat and stuff into the pitta bread with the salad an…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 35 min)

### mdb-53271
**Walnut, date & honey cake** · Dessert · area: Turkish
- ingredients: 225g Self Raising Flour, 1/2 teaspoon Cinnamon, 175g Butter, 100g Muscovado Sugar, 3 tablespoons Honey, 2 Beaten Egg, 2 medium Banana, 100g Date, 50g Walnut
- method (4 steps): Preheat the oven to 160C/Gas 3/fan oven 140C. Line the base and long sides of a 900g/2lb loaf tin with greaseproof paper, buttering the tin and paper. Tip the flour, cinnamon, butter, sugar, 2 tablespoons of the honey and the eggs into a large mixing bowl. Mash the bananas and chop the dates (kitchen scissors are easiest for this) and add to the bowl. Beat the mixture for 2-3 minutes, using a wooden spoon or hand-held mixer, until well blended. Spoon into the prepared tin and level the top. Scatter the walnut pieces over. Bake for 1 hour, then lightly press the top – it will feel firm if cooke…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 115 min)

### mdb-53272
**Griddled flatbreads** · Side · area: Turkish
- ingredients: 250g Strong Wholemeal Flour, 250g Strong White Flour, 15g Yeast, 1 tsp Sugar, 2 tablespoons Olive Oil
- method (4 steps): Tip the flours into a food processor. Add the yeast, sugar and 1tsp salt, then mix well. Pour in 350ml warm water and the oil, then process to a soft dough. Mix for 1 min, then leave until doubled in size, about 1 hour. Pulse the dough a couple of times just to knock out the air, then tip onto a floured surface. Cut the dough in half and roll out one half to a rectangle about 20 x 40cm. Trim the edges using a large sharp knife, then cut into eight 10cm squares. Line a large tray or two baking sheets with non-stick paper and arrange the bread rectangles over the tray in one layer. Repeat with t…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 5 ingredients, 110 min)

### mdb-53273
**Roast aubergine with goat's cheese & toasted flatbread** · Vegetarian · area: Turkish
- ingredients: 2 sliced Aubergine, 3 tablespoons Olive Oil, 12 Cherry Tomato, 1 Pita Bread, 3 tablespoons Balsamic Vinegar, Handful Mint, 1 chopped Shallot, 1 sliced Shallot, 1 chopped Red Chilli, 50g Goats Cheese, Handful Rocket
- method (4 steps): Heat oven to 200C/180C fan/gas. Brush the aubergine slices with 1 tbsp of the oil, then season. Arrange on a baking tray or sheet and roast for 20 mins until browned, popping the tomatoes on the tray for the final 5 mins. Tear the flatbread into pieces and place on a separate baking sheet. Brown in the oven for 8 mins, or until crisp, then remove. For the dressing, in a small bowl, mix the vinegar, mint, chopped shallots, chilli, remaining oil and some salt and pepper. Scatter the aubergine slices, tomatoes, sliced shallot and crisp flatbread into a serving bowl. Pour over the dressing, sprink…
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 60 min)

### mdb-53274
**Griddled aubergines with sesame dressing** · Vegetarian · area: Turkish
- ingredients: 2 large Aubergine, 2 tablespoons Olive Oil, 250g Greek Yogurt, 3 tablespoons Tahini, 1 clove peeled crushed Garlic, Juice of 1 Lemon, Handful Coriander, Handful Parsley, Handful Mint
- method (2 steps): Brush each aubergine slice with some oil, then season. Heat a griddle pan or barbecue. When hot, griddle the aubergine slices for 2-3 mins on each side until golden brown and tender. Mix the yogurt with the tahini, garlic, lemon juice and herbs, then season. Top the aubergines with the dressing and scatter over extra herb leaves.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 25 min)

### mdb-53275
**Sweet potato salad** · Vegetarian · area: Turkish
- ingredients: 1200g Sweet Potato, 1 tablespoon Olive Oil, 2 Shallot, 4 sliced Spring Onion, Bunch Chive, 5 tablespoons Sherry Vinegar, 2 tablespoons Olive Oil, 2 tablespoons Honey
- method (3 steps): Heat oven to 200C/180C fan/gas. Toss the sweet potato chunks with the olive oil and some seasoning, and spread on a baking parchment-lined baking sheet. Roast for 30 - 35 mins until tender and golden. Cool at room temperature. When just about cool whisk together all the dressing ingredients with a little more seasoning and gently toss through the potato chunks – use your hands to avoid breaking them up.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 8 ingredients, 45 min)
