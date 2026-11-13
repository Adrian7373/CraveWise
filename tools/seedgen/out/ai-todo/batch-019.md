# AI tagging batch 019

Write `tools/seedgen/tags/ai/batch-019.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53148
**Crema Catalana** · Dessert · area: Spanish
- ingredients: 400ml Milk, 150ml Double Cream, 1 Cinnamon Stick, 1 Orange Zest, 1 Lemon Zest, 7 Egg Yolk, 100g Sugar, 6 tablespoons Sugar, 45g Cornflour
- method (5 steps): Put the milk, cream, cinnamon stick and all the citrus zest in a saucepan set over a medium heat. Cook, stirring often, until the milk is just steaming but not boiling, about 3-5 mins. Remove from the heat, cover with a plate and leave to infuse for at least 30 mins. When the cream mixture has infused, whisk the egg yolks, sugar and cornflour together in a separate bowl for 3-5 mins, or until light and pale in colour. Pour the infused milk through a sieve into the egg mixture, whisking continuously. Return the mixture to the saucepan. Put the saucepan over a medium-high heat and whisk for arou…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 9 ingredients, 130 min, technique: caramelis)

### mdb-53149
**Ensaimada** · Dessert · area: Spanish
- ingredients: 5g Yeast, 200g Sugar, 2 medium Egg, 600g Strong White Flour, Drizzle Vegetable Oil, 100g Lard
- method (11 steps): Pour 230ml lukewarm water into a bowl and add the yeast. Leave to stand for 3 mins, then add the caster sugar, eggs, flour and 1 tsp sea salt flakes. Mix together to form a dough, then knead for 10 mins in stand mixer using a dough hook (or 15 mins by hand) until the dough is elastic enough to be almost see-through when stretched. Cover and set aside to rest for 30 mins, then cut into four equal pieces. Transfer to a baking tray lined with baking parchment. Leave to rest for another 30 mins. Oil the work surface and a rolling pin with vegetable oil. Working with one portion of dough at a time,…
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky'] (0.50, keywords: creamy, flaky)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 6 ingredients, 1560 min, technique: knead)

### mdb-53150
**Padron peppers** · Vegan · area: Spanish
- ingredients: 1 tablespoon Olive Oil, 500g Padron Pepper
- method (2 steps): Heat the olive oil in a large frying pan over a high heat, or if using an air-fryer, heat to 205C for 3 mins. Fry the peppers, stirring frequently, for 5 mins until blistered and wilted. The peppers should be soft and slightly charred. Transfer the peppers to a serving plate and season with some sea salt. Serve with dips or as part of a tapas spread, if you like.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 2 ingredients, 20 min)

### mdb-53152
**Pan-fried hake, white bean & chorizo broth** · Seafood · area: Spanish
- ingredients: 450g Dried White Bean, 4 cloves Garlic, 2 Bay Leaf, 1 teaspoon Thyme, 6 tablespoons Olive Oil, 100g Bread, 100g Chorizo, 1 Onion, 3 tsp Paprika, 1 L Chicken Stock, Handful Parsley, 6 Hake
- method (4 steps): Drain the beans, then tip into a large pan with 2 litres of water. Simmer with the whole garlic cloves, bay leaves and thyme for 30 mins or until cooked and tender. Remove from the heat and set aside. Meanwhile, heat 2 tbsp oil in a frying pan. Fry the bread with the remaining garlic clove. When golden and crisp, scoop out and drain on kitchen paper. Add the chorizo to the pan, fry until crisp, tip out and keep warm with the bread. Add another 2 tbsp oil and the onion to the pan, and cook for 5 mins until softened. Stir in the paprika. Drain the beans and add to the onions with the chicken sto…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `moods` rule: ['hearty', 'indulgent', 'light'] (0.50, keywords/category: hearty, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 75 min)

### mdb-53153
**Churros** · Dessert · area: Spanish
- ingredients: 50g Butter, 1/2 teaspoon Vanilla Extract, 250g Plain Flour, 1 teaspoon Baking Powder, 1 L Vegetable Oil, 2 chopped Bread, 200g Dark Chocolate, 100 ml Double Cream, 100 ml Milk, 3 tablespoons Golden Syrup, 1/2 teaspoon Vanilla Extract, 100g Sugar, 2 teaspoon Cinnamon
- method (8 steps): Boil the kettle, then measure 300ml boiling water into a jug and add the melted butter and vanilla extract. Sift the flour and baking powder into a big mixing bowl with a big pinch of salt. Make a well in the centre, then pour in the contents of the jug and very quickly beat into the flour with a wooden spoon until lump-free. Rest for 10-15 mins while you make the sauce. Put all the sauce ingredients into a pan and gently melt together, stirring occasionally until you have a smooth shiny sauce. Keep warm on a low heat. Fill a large deep saucepan one-third full of oil. Cooking with hot oil can …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 13 ingredients, 40 min, technique: deep-fr, pipe, piping)

### mdb-53154
**Clam, chorizo & white bean stew** · Seafood · area: Spanish
- ingredients: 50g Chorizo, 1 chopped Onion, 1 Garlic, Bunch Parsley, 200ml Vegetable Stock, 400g Chopped Tomatoes, 400g Butter Bean, 1 teaspoon Sherry Vinegar, 600g Clam, To serve Bread
- method (3 steps): Fry the chorizo in a large frying pan with a lid, over a medium heat until it is starting to crisp up and release its oil. Add the onion and cook for 5 mins until starting to soften. Then add the garlic and finely chopped parsley, and fry for 1 min more. Pour on the stock and tomatoes. Bring to the boil, reduce the heat, then add the beans and sherry vinegar. Simmer for 10 mins until the liquid is slightly reduced. Scatter over the clams, cover with the lid and steam for 2-4 mins, shaking the pan occasionally until the clams are open. Have a little taste before seasoning, as the clams can be q…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'tender'] (0.50, keywords: crispy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 45 min)

### mdb-53155
**Spanish chicken pie** · Chicken · area: Spanish
- ingredients: 1 kg Potato, 3 tsp Paprika, 2 teaspoons Olive Oil, 2 sliced Onion, 2 cloves minced Garlic, 800g Chopped Tomatoes, 300g Chicken, 140g Roasted Pepper, Handful Green Olive
- method (4 steps): Heat oven to 200C/fan 180C/gas. Boil the potatoes for 15-20 mins until tender. Drain, return to the pan, then mash with some seasoning and 2 tsp of the paprika. Meanwhile, heat the oil in a large pan, then fry the onions and garlic for a few mins until softened. Stir in the remaining paprika for 1 min, add the tomatoes , then, bring to a simmer. Tip into a large ovenproof dish, then stir in the chicken, peppers, olives and some seasoning. Spoon over the mash, then bake for 15 mins until the mash is golden on top and the sauce is bubbling.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 55 min)

### mdb-53156
**Arroz al horno (baked rice)** · Pork · area: Spanish
- ingredients: 2 tbsp Olive Oil, 800g Pork Belly, 150g Morcilla, 100g Bacon, 1 chopped Onion, 2 Red Pepper, 1 chopped Tomato, 8 Garlic, 4 teaspoons Paprika, 1/2 teaspoon Chilli Flakes, 200g Dried White Bean, 1 1/2 L Chicken Stock, 6 parts Thyme, 375g Paella Rice, 1 Lemon Juice
- method (7 steps): Heat oven to 200C/180C/gas. Heat half the oil in a deep frying or sauté pan (or shallow casserole dish) measuring around 30cm in diameter. Over a high heat, colour the pork belly slices on each side in several batches, then transfer to a bowl. Add the remaining oil to the pan and lower the heat to medium, then add the black pudding and bacon and fry all over for several mins. Remove with a slotted spoon. Fry the onion and peppers for around 10 mins until soft and pale gold, then add the tomato and cook until soft. Add the garlic, smoked paprika and chilli flakes and cook for another 2 mins, th…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 15 ingredients, 70 min, technique: deep fr)

### mdb-53157
**Chorizo & soft-boiled egg salad** · Pork · area: Spanish
- ingredients: 500g New Potato, 4 Egg, 225g Green Bean, 225g Chorizo, 1 sliced Garlic, 2 tbsp Sherry Vinegar, 2 tbsp chopped Parsley
- method (3 steps): Cook the potatoes in a large pan of boiling salted water for 12 mins, adding the eggs after 6 mins, and the beans for the final 2 mins. Drain everything and cool the eggs under cold running water. Meanwhile fry chorizo slices for 1-2 mins, until beginning to crisp. Remove from the pan with a slotted spoon and set aside, leaving the oil from the chorizo in the pan. Add the garlic to the pan and cook gently for 1 min. Remove the pan from the heat, stir in the vinegar and parsley, then toss with the potatoes, beans, chorizo and seasoning. Shell the eggs, cut into quarters and add to the salad.
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 35 min)

### mdb-53158
**Air fryer patatas bravas** · Vegetarian · area: Spanish
- ingredients: 900g Potato, 3 tablespoons Olive Oil, 1 chopped Onion, 1 clove peeled crushed Garlic, 1 tblsp Paprika, 1 tblsp Tomato Puree, 225g Chopped Tomatoes, To serve Basil
- method (3 steps): Soak the potatoes in just-boiled water for 30 mins, then drain and leave to air-dry for 5 mins. Heat the air fryer to 200C. Tip the potatoes into a bowl and drizzle over 1 tbsp of the oil and add 1/2 tsp each of salt and freshly ground black pepper. Mix to coat the potatoes all over, then tip into the air fryer basket and cook for 20-30 mins until crisp and golden. Meanwhile, heat the remaining oil in a small pan over a medium-low heat and fry the onion for 8-10 mins until softened but not golden. Stir in the garlic and cook for a minute before adding the paprika and cooking for 30 seconds mor…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 8 ingredients, 90 min)

### mdb-53159
**Chorizo, potato & cheese omelette** · Pork · area: Spanish
- ingredients: 1 small Potato, 1 teaspoon Olive Oil, 50g Chorizo, 3 Egg, Chopped Parsley, 25g Cheddar
- method (2 steps): Cook the potato in boiling water for 8-10 mins or until tender. Drain and allow to steam-dry. Heat oil in an omelette pan, add chorizo and cook for 2 mins. Add the potato and cook for a further 5 mins until the potato starts to crisp. Spoon pan contents out, wipe pan and cook a 2 or 3-egg omelette in the same pan. When almost cooked, scatter with the chorizo and potato, parsley and cheese. Fold the omelette in the pan and cook for 1 min more to melt the cheese.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 35 min)

### mdb-53160
**Pisto con huevos** · Vegetarian · area: Spanish
- ingredients: 2 tblsp Olive Oil, 2 Onion, 4 Chopped Garlic, 5 Mixed Pepper, 1 teaspoon Oregano, Sprigs of fresh Thyme, 4 leaves Bay Leaf, 2 chopped Courgette, 1 chopped Aubergine, 4 large Tomato, 4 large Egg, Handful Parsley
- method (4 steps): Heat the oil in a large flameproof casserole dish or a cast-iron skillet over a low heat. Add the onions and a sprinkle of salt, cover and cook gently for 15 mins, stirring occasionally. Add the garlic and cook for another 2 mins. Next, throw in the peppers and cook over a medium heat, covered, for about 5 mins, stirring every so often, until the peppers are just tender. Mix in the oregano, thyme, bay leaves, some black pepper and a little salt, if needed. Tip in the courgettes and aubergine, combine thoroughly, and cook over a medium heat, covered, for 10 mins. Stir in the tomatoes, cover and…
- `flavor.bitter` rule: 3 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 85 min)

### mdb-53161
**Chicken & chorizo rice pot** · Chicken · area: Spanish
- ingredients: 1 tblsp Vegetable Oil, 1 whole Chicken, 1 Large Chopped Onion, 1 chopped Red Pepper, 3 Cloves Crushed Garlic, 225g Chorizo, 1 tblsp Tomato Puree, 1 tablespoon chopped Thyme, 150ml White Wine, 800ml Chicken Stock, 400g Rice, 2 tbs chopped Parsley
- method (4 steps): Heat the oil in a large flameproof casserole dish and brown the chicken pieces on all sides – you may have to do this in batches. Remove from the dish and put to one side. Lower the heat, add the onion and pepper, and gently cook for 10 mins until softened. Add the garlic and chorizo, and cook for a further 2 mins until the chorizo has released some of its oils into the dish. Stir in the tomato purée and cook for 1 min more. Return the chicken pieces to the dish along with the thyme, white wine and stock. Bring the liquid to a boil, cover the dish with a tight-fitting lid and lower the heat. C…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 95 min)

### mdb-53162
**Pollo en pepitoria** · Chicken · area: Spanish
- ingredients: Pinch Saffron, 4 tbsp Olive Oil, 6 Garlic, 35g Almond, 30g Bread, 2 tbs chopped Parsley, 8 Chicken Thigh, 1 chopped Onion, 1 chopped Carrot, 1 chopped Celery, 250ml Sherry, 350ml Chicken Stock, 1 Cinnamon Stick, Pinch Clove, 2 Bay Leaf, 2 Egg, 2 tblsp Almond
- method (9 steps): Put the saffron in a small bowl with 75ml of just-boiled water. Stir and set aside. Heat 2 tbsp of the oil in a broad, shallow casserole dish. Cook the garlic until pale gold in colour, then add the blanched almonds and bread, and continue to fry until everything is golden. Tip into a food processor with some salt and pepper and the parsley, and whizz together. Heat 2 more tbsp of the oil in the pan and brown the chicken all over, seasoning as you cook. Put in a bowl and set aside. Remove all but about 2 tbsp of chicken fat from the pan and cook the onion, carrot and celery until golden. Add t…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 17 ingredients, 80 min)

### mdb-53163
**Spanish fig & almond balls** · Dessert · area: Spanish
- ingredients: 100g Almond, 500g Fig, 85g Dried Apricot, 50g Dried Cranberry, 1 tablespoon Brandy, 1 tblsp Honey, 1 teaspoon Clove, 100g Sesame Seed
- method (2 steps): Whizz the almonds in a food processor until most are finely chopped, then tip into a large bowl. Roughly chop the figs, then whizz to a smooth sticky paste. Scrape onto the almonds then, using your hands, mix together well with the dried fruit, brandy, honey and cloves. Divide the mixture into 6 and roll into balls. Tip the sesame seeds onto a tray, then roll the balls in them until covered. Cover the tray loosely with a clean tea towel, then leave the fig balls to dry for a week before packaging. Will keep in a cool place for 2 months.
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 50 min)

### mdb-53164
**Spanish Chicken** · Chicken · area: Spanish
- ingredients: 8 Chicken Thigh, 3 sliced thinly Onion, 2 teaspoons Paprika, Zest and juice of 1 Lemon, Handful Parsley, 150ml Chicken Stock, 1 tablespoon Olive Oil
- method (3 steps): Heat oven to 190C/170C fan/gas. Put all the ingredients into a large, wide ovenproof dish. Mix everything together with your hands and season. Bake for 45 mins, stirring the onions after 20 mins, until the chicken is golden and the onions tender. Serve with rice.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 60 min)

### mdb-53165
**Torrijas with sherry** · Breakfast · area: Spanish
- ingredients: 2 medium Egg, 2 tbsp Double Cream, 2 tblsp Milk, 3 tsp Sugar, 3 tablespoons Sherry, 4 thick slices Bread, For frying Olive Oil, To serve Icing Sugar, To serve Creme Fraiche
- method (3 steps): In a wide, shallow bowl, beat the eggs with the cream, milk, golden caster sugar and sherry. Cut each slice of bread in two and dip them into the egg mix, turning to make sure they get a good coating on either side. Soak bread in egg mixture for 10 mins to absorb the liquid (carefully turn them over from time to time and make sure they don’t get too soggy). Heat 1½ tbsp olive oil in a large frying pan and cook the bread for about 3 mins on each side until dark golden and crisp on the edge. Keep the slices warm in a low oven as you cook the rest. Divide the torrijas between plates and dust with…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy'] (0.50, keywords: creamy, crispy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 35 min)

### mdb-53166
**Chickpea, chorizo & spinach stew** · Pork · area: Spanish
- ingredients: 4 tablespoons Olive Oil, 1 chopped Onion, 1 Diced Carrot, 1 Diced Celery, 3 Thyme, 2 Bay Leaf, 2 cloves chopped Garlic, 200g Chorizo, 1/4 tsp Cinnamon, 1 teaspoon Paprika, 800g Chickpea, 2 tblsp Sherry Vinegar, 400g Spinach
- method (2 steps): Heat the oil in a large pan, then gently fry the onion for 3-4 mins until it begins to soften. Stir in the carrot, celery, thyme and bay leaves. Season, then cook for 2-3 mins, stirring occasionally. Add the garlic, chorizo, cinnamon and smoked paprika. Gently fry until the vegetables soften and the chorizo starts to release its oils and crisp up. Stir in the chickpeas, vinegar and 150ml water, then bring to a simmer for 1-2 mins until the chickpeas have heated up. Add the spinach, then stir through the chickpeas until it wilts a little. Remove from the heat, season to taste, then serve warm w…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'tender'] (0.50, keywords: crispy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 13 ingredients, 35 min)

### mdb-53167
**Seafood rice** · Seafood · area: Spanish
- ingredients: 1 tbsp Olive Oil, 1 sliced Leek, 110g Chorizo, 1 teaspoon Turmeric, 300g Rice, 1 L Fish Stock, 200g Pea, 400g Seafood Mix
- method (2 steps): Heat the oil in a deep frying pan, then soften the leek for 5 mins without browning. Add the chorizo and fry until it releases its oils. Stir in the turmeric and rice until coated by the oils, then pour in the stock. Bring to the boil, then simmer for 15 mins, stirring occasionally. Tip in the peas and cook for 5 mins, then stir in the seafood to heat through for a final 1-2 mins cooking or until rice is cooked. Check for seasoning and serve immediately with lemon wedges.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 45 min, technique: deep fr)

### mdb-53168
**Chorizo & chickpea soup** · Pork · area: Spanish
- ingredients: 400g Chopped Tomatoes, 110g Chorizo, 140g Savoy Cabbage, Sprinkling Chilli Flakes, 400g can Chickpea, 1 Chicken Stock, To serve Bread
- method (2 steps): Put a medium pan on the heat and tip in the tomatoes, followed by a can of water. While the tomatoes are heating, quickly chop the chorizo into chunky pieces (removing any skin) and shred the cabbage. Pile the chorizo and cabbage into the pan with the chilli flakes and chickpeas, then crumble in the stock cube. Stir well, cover and leave to bubble over a high heat for 6 mins or until the cabbage is just tender. Ladle into bowls and eat with crusty or garlic bread.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 30 min)
