# AI tagging batch 020

Write `tools/seedgen/tags/ai/batch-020.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53169
**Ajo blanco** · Starter · area: Spanish
- ingredients: 150g Bread, 200g Almond, 50 ml Olive Oil, 1 Garlic, 1 ½ tbsp Red Wine Vinegar
- method (3 steps): Tip the bread into a bowl and pour over 350ml water. Leave to soak for 10 mins. Blend the ingredients together with 350ml water and 1 tsp salt. Let the soup cool in the fridge for 1 hr or so, then serve with a drizzle of oil and some black pepper.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'crunchy'] (0.50, keywords: brothy, crunchy)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Starter guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 5 ingredients, 95 min)

### mdb-53170
**Chocolate churros with chocolate & salted caramel sauce** · Dessert · area: Spanish
- ingredients: For frying Vegetable Oil, To serve Ice Cream, 120g Muscovado Sugar, 60g Butter, 250ml Double Cream, 100g Dark Chocolate, 100g Sugar, 2 teaspoon Cinnamon, 200g Plain Flour, 50g Cocoa Powder, 1 teaspoon Baking Powder, 1 teaspoon Vanilla Extract, 50g Butter
- method (8 steps): To make the sauce, tip the sugar and butter into a saucepan and bring to a simmer until the sugar has melted, then stir in the cream and simmer until you have a smooth sauce, about 2-3 mins. Remove from the heat, stir through a pinch of sea salt and the chocolate, and continue to stir for 2-3 mins, or until it has completely melted. Keep warm or leave to cool for reheating later. For the coating, mix the sugar with the cinnamon and a small pinch of fine sea salt and set aside. For the churros, tip the flour, cocoa, baking powder and a large pinch of salt into a bowl. Add the vanilla extract an…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 13 ingredients, 40 min, technique: pipe, piping)

### mdb-53171
**Salt cod tortilla** · Seafood · area: Spanish
- ingredients: 4 tbsp Olive Oil, 1 Large Chopped Onion, 300g New Potato, 2 cloves chopped Garlic, 8 Egg, 2 1/2 Tbs Parsley, 300g Salt Cod
- method (7 steps): Heat half the oil in a frying pan, and sauté the onion over a medium heat until soft and pale gold – this will take about 8 mins. Remove from the pan, set aside, and add the potatoes to the pan. Cook until they are tender but not falling apart, carefully turning every so often. Cover the pan some of the time to help the slices cook through. Add the onions back to the pan along with the garlic and cook for another 4 mins. Tip into a bowl with the eggs, parsley and some seasoning and mix together. Leave to sit for half an hour. Meanwhile, put the cod in a saucepan and cover with water. Bring up …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 7 ingredients, 75 min)

### mdb-53172
**Patatas bravas** · Vegetarian · area: Spanish
- ingredients: 3 tablespoons Olive Oil, 1 small finely diced Onion, 2 cloves chopped Garlic, 225g Chopped Tomatoes, 1 tablespoon Tomato Puree, 2 teaspoon Paprika, Pinch Chilli Powder, Pinch Sugar, Chopped Parsley, 900g Potato, 2 tbsp Olive Oil
- method (3 steps): Heat the oil in a pan and fry the onion for about 5 mins until softened. Add the garlic, chopped tomatoes, tomato purée, sweet paprika, chilli powder, sugar and a pinch of salt, then bring to the boil, stirring occasionally. Lower to a simmer and cook for 10 mins until pulpy. Can be kept chilled for up to 24 hrs. Heat oven to 200C/180C fan/gas. Pat the potatoes dry with kitchen paper, then tip into a roasting tin and toss in the olive oil and some seasoning. Roast for 40-50 mins until crisp and golden. Tip the potatoes into serving dishes and spoon over the tomato sauce. Sprinkle with some fre…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 1520 min)

### mdb-53173
**Quick gazpacho** · Starter · area: Spanish
- ingredients: 250g Passata, 1 chopped Red Pepper, 1 chopped Red Chilli, 1 clove peeled crushed Garlic, 1 teaspoon Sherry Vinegar, Juice of 1/2 Lime
- method (1 steps): In a blender (or with a stick blender), whizz together the passata, red pepper, chilli, garlic, sherry vinegar and lime juice until smooth. Season to taste, then serve with ice cubes.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Starter guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 6 ingredients, 30 min)

### mdb-53174
**Prawns with Romesco sauce** · Seafood · area: Spanish
- ingredients: 1 Red Pepper, 3 Large Garlic, 1 large Red Chilli, 1 large Tomato, 10 Hazelnut, 10 Almond, 3 sprigs Parsley, 1 sliced Bread, 120ml Olive Oil, 2 tblsp Red Wine Vinegar, 400g Prawn
- method (5 steps): Prepare ahead - halve the pepper lengthways and remove the seeds and stalk. Line a grill pan with foil and put the pepper halves, skin side up, on the grill pan with the whole garlic cloves, chilli and tomato. Grill for 2 minutes, turn the tomato, then grill for a further 2 minutes. Remove the tomato with a large spoon, then peel, quarter and remove the seeds. Then chop the tomato roughly. Continue grilling the pepper, chilli and garlic for 4-5 minutes, until the pepper and chilli skins have blackened and the garlic is starting to soften (the garlic skin will start to split when it is ready). …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 55 min)

### mdb-53175
**Spanish-style slow-cooked lamb shoulder & beans** · Lamb · area: Spanish
- ingredients: 2.5kg Lamb Shoulder, 1 tblsp Olive Oil, 2 chopped Onion, 4 Chopped Carrot, 1 Garlic, 500ml Chicken Stock, 1200g Butter Bean, 450g Roasted Pepper, 300g Black Olive, 4 tablespoons Parsley, 4 Cloves Crushed Garlic, 1 tablespoon Smoked Paprika, 4 tablespoons Olive Oil, 1/2 teaspoon Rosemary
- method (4 steps): To make the spice mix, combine all of the ingredients together with a large pinch of salt. Slash the lamb shoulder all over with a sharp knife and rub in. If you have the time, marinate for up to 24 hrs, but this is not essential. Heat the oven to 150C/130C fan/gas. Heat the oil in a large flameproof casserole dish or roasting tin over a medium-high heat, add the onions, carrots and garlic and sizzle for 5 mins until the onions and carrots are softened. Pour over the stock, then bring to the boil. Nestle the lamb in the pan and cover, then transfer to the oven and roast for 2 hrs. Uncover and …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 14 ingredients, 1685 min, technique: rub in)

### mdb-53176
**Spanish tomato bread with jamón Serrano** · Pork · area: Spanish
- ingredients: 4 Chopped Tomato, 1 clove finely chopped Garlic, 3 tablespoons Olive Oil, Pinch Salt, Pinch Black Pepper, 20 slices Baguette, 5 Slices Serrano Ham
- method (2 steps): Mix together the chopped tomatoes, garlic clove, olive oil, salt and pepper. Keep in the fridge until needed. To serve, toast 20 slices of baguette. Spoon a little tomato topping on to each piece of toast. Tear 5-6 slices of jamón Serrano into pieces and put one piece on each slice of bread.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Pork guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 55 min)

### mdb-53177
**Spaghetti with Spanish flavours** · Pork · area: Spanish
- ingredients: 80g Chorizo, 300g Spaghetti, 20g Parsley, 2 Red Pepper, 2 tbsp Olive Oil, 50g Parmesan
- method (4 steps): Put a pan of water on over a high heat to boil. Meanwhile, snip the chorizo into strips with scissors, and chop the parsley and peppers (check for stray seeds first). When the water is boiling briskly, add the spaghetti with a good measure of salt, stir and return to the boil. Cook for 3 minutes. In a large frying pan, heat the oil, add the chorizo and peppers and plenty of black pepper. Cook for a minute or so, until heated through and the juices are stained red from the paprika in the chorizo. Scoop half a mugful of pasta water from the pan, drain the remainder and tip the spaghetti into the…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 20 min)

### mdb-53178
**Fried calamari** · Seafood · area: Spanish
- ingredients: 300g Squid, 200g Plain Flour, 2 tblsp Caper, 1 clove peeled crushed Garlic, 5 tblsp Mayonnaise, For frying Vegetable Oil, To serve Lemon
- method (3 steps): Cut the squid into rings about ½cm thick. Tip the flour into a freezer bag and season well. Add the capers, then give everything a good shake to mix together. Tip the squid into the bag, then shake again until all the rings are well coated. Mix together the garlic and mayonnaise, then place in a serving bowl. Pour some oil into a large pan until it comes about 7cm up the sides, but the pan is no more than a third full. Place over a medium heat and let the oil warm up. To test that the oil is ready, place a small piece of bread in the pan – it should sizzle when it touches the oil. Remove a han…
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 20 min)

### mdb-53179
**Ham croquetas** · Pork · area: Spanish
- ingredients: 75g Plain Flour, 2 large Egg, 75g Breadcrumb, For frying Vegetable Oil, 4 tbsp Olive Oil, 1/2 Leek, 70g Jamon Iberico, 60g Plain Flour, 75 ml Vegetable Stock, 330ml Milk, Grated Ground Nutmeg
- method (9 steps): To make the filling, heat the olive oil in a pan until it starts to shimmer. Add the leek and sauté until soft but not coloured. Stir in the ham with a wooden spoon, fry for 1 min, then stir in the flour and fry over a medium heat, stirring occasionally, until the mixture is golden but not burnt – this will take about 5 mins. Meanwhile, combine the stock and milk in a small pan and heat until steaming but not boiling. Season with a few scrapes of nutmeg. Gradually add the liquid, a few tbsp at a time, stirring constantly. Once you’ve incorporated all the milk stock, continue to cook the fillin…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'fluffy', 'smooth'] (0.50, keywords: crunchy, fluffy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 11 ingredients, 130 min)

### mdb-53180
**Garlicky prawns with sherry** · Seafood · area: Spanish
- ingredients: 3 tablespoons Olive Oil, 3 cloves Chopped Garlic, 400g Prawn, 2 tbsp Sherry, Handful Parsley
- method (2 steps): Heat the olive oil in a large frying pan. Tip in the garlic slices and cook for a few secs. Then stir through the prawns and cook for a couple of mins until they start to turn pink. Pour over the sherry and cook for a few mins more, just until the prawns are cooked through. Sprinkle with parsley before serving.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 5 ingredients, 20 min)

### mdb-53181
**Spanish beans with chicken & chorizo** · Chicken · area: Spanish
- ingredients: 300g Pinto Bean, 1 chopped Onion, 1 tablespoon Paprika, Sprigs of fresh Thyme, Pinch Bay Leaf, Bunch Parsley, 4 Chicken Thigh, 250g New Potato, 250g Chorizo, 100g Spinach
- method (3 steps): Soak the beans for at least 4 hrs or overnight in a large bowl with plenty of water to cover. Next day, rinse and drain, then put in a large heavy based pan with the onion, paprika, herb bundle and chicken. Pour over enough water or stock to cover, bring to the boil, then reduce the heat, cover and simmer for 45 mins. Remove the chicken to a plate, then add the potatoes and chorizo to the pan. Continue cooking for 30 mins until the beans and potatoes are tender. Discard the skin and bones from the chicken and tear into large chunks. Return the chicken to the pan with the spinach and simmer for…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 340 min)

### mdb-53182
**Spanish seafood rice** · Seafood · area: Spanish
- ingredients: 1 tblsp Olive Oil, 1 chopped Onion, 1 Red Pepper, 1 Yellow Pepper, 2 sliced Garlic, 250g Paella Rice, 800ml Vegetable Stock, Pinch Saffron, 400g Seafood Mix, Juice of 1/2 Lemon, Handful Parsley
- method (3 steps): Heat the oil in a large saucepan and soften the onion for 6-7 mins. Add the pepper and garlic, cook for 2 mins more, then stir in the paella rice and cook for 1 min, stirring to coat. Pour in the stock, add the saffron and bring to the boil. Cook, uncovered, at a gentle bubble, for 20 mins, stirring occasionally until the rice is tender. Stir in the seafood and lemon juice and cook for 2 mins or until piping hot and completely cooked through. Serve in warm bowls scattered with the parsley.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 55 min, technique: piping)

### mdb-53183
**Spanish meatballs with clams, chorizo & squid** · Miscellaneous · area: Spanish
- ingredients: 25g Butter, 3 diced Shallot, 1 teaspoon Smoked Paprika, 2 cloves minced Garlic, 1 clove finely chopped Garlic, 2 tblsp Sherry, 50g Breadcrumb, 300g Pork, 1 Egg Yolk, 50 ml Olive Oil, 300g Chorizo, 300g Squid, 100 ml White Wine, 300g Tomato, 400g Clam, Handful Parsley, Drizzle Olive Oil
- method (4 steps): Melt the butter in a heavy-based casserole, then soften the shallots for 5 mins. Add the paprika and crushed garlic and cook for 1 min until the paprika becomes fragrant. Splash in the sherry, then pour the whole lot into a bowl with the breadcrumbs. Season and cool. Add the pork mince and the egg yolk to the bowl, then beat well. Shape into 18 small meatballs. Wipe the pan, put on a medium-high heat, then add the oil. Fry the meatballs for 5 mins, just to colour, then lift onto a plate, but keep the oil in the pan. Sizzle the chorizo with the sliced garlic. Add the squid and fry to give a lit…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 17 ingredients, 60 min)

### mdb-53184
**Spanish rice & prawn one-pot** · Seafood · area: Spanish
- ingredients: 1 sliced Onion, 1 sliced Red Pepper, 1 sliced Green Pepper, 50g Chorizo, 2 cloves minced Garlic, 1 tblsp Olive Oil, 250g Basmati Rice, 400g Chopped Tomatoes, 200g Prawn
- method (2 steps): Boil the kettle. In a non-stick frying or shallow pan with a lid, fry the onion, peppers, chorizo and garlic in the oil over a high heat for 3 mins. Stir in the rice and chopped tomatoes with 500ml boiling water, cover, then cook over a high heat for 12 mins. Uncover, then stir – the rice should be almost tender. Stir in the prawns, with a splash more water if the rice is looking dry, then cook for another min until the prawns are just pink and rice tender.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 35 min)

### mdb-53185
**Chorizo & tomato salad** · Pork · area: Spanish
- ingredients: 3 Tomato, 1/2 Red Onion, Sprigs of fresh Thyme, 1 tablespoon Sherry Vinegar, 2 tblsp Olive Oil, 100g Chorizo
- method (2 steps): Put the tomatoes in a bowl with the onion and thyme. Season, then drizzle with the vinegar and oil. Let the flavours mingle while you cook the chorizo. In a hot, dry pan, fry the chorizo slices until browned on both sides. Serve the tomatoes with the fried chorizo, drizzled with a little oil from the pan.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh', 'indulgent', 'light'] (0.50, keywords/category: fresh, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Pork guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 45 min)

### mdb-53186
**Chicken with saffron, raisins & pine nuts** · Chicken · area: Spanish
- ingredients: 1.25kg Chicken, 2 tblsp Olive Oil, 3 cloves Chopped Garlic, Pinch Saffron, 125ml Sherry, 200ml Chicken Stock, 1 tbsp Thyme, 50g Raisin, 2 tbsp Pine Nut, Handful Parsley
- method (5 steps): Heat a large frying pan on a high heat and season the chicken. Add the olive oil to the pan, then the chicken. Brown for about 5 mins on each side, remove onto a plate, then set aside. Lower the heat to medium. In the remaining fat, fry the onions for 3 mins, then add the garlic and saffron. Cook for 3-4 mins more. Add the sherry, then simmer for 3-5 mins until syrupy. Put the chicken leg pieces back into the pan, tip in the stock, thyme and raisins, cover, then gently cook on a low heat for 20 mins. Add the breast meat and any juices left on the plate. Simmer for 10 mins more until cooked thr…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 75 min)

### mdb-53187
**Šúĺlance s Makom** · Dessert · area: Slovakia
- ingredients: 700g Potato, 300g Plain Flour, 100g Semolina, Pinch Salt, 150g Ground Poppy Seed, 100g Icing Sugar, 100g Butter
- method (21 steps): Prepare the Potatoes. Boil the potatoes with their skins on until tender. Let them cool completely (preferably overnight), then peel and mash them finely. Make the Dough. In a bowl, combine mashed potatoes, flour, semolina, and salt. Knead the mixture until you get a smooth, non-sticky dough. Shape the Šúĺlance. Divide the dough into portions and roll each into a thin rope (about 1.5 cm in diameter). Cut into 3 cm-long pieces and roll between your palms to shape small dumplings. Cook the Dumplings. Bring a pot of salted water to a boil. Drop in the dumplings in batches and cook until they floa…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy', 'smooth'] (0.50, keywords: creamy, fluffy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 21 steps, 7 ingredients, 505 min, technique: knead)

### mdb-53188
**Fašírky** · Pork · area: Slovakia
- ingredients: 500g Pork Mince, 1 medium chopped Onion, 2 cloves minced Garlic, 2 sliced Bread, 1 shot Milk, 1 Egg, 1 teaspoon Salt, 1/2 teaspoon Black Pepper, 1 teaspoon Marjoram, 1 tsp Mustard, 1 tablespoon chopped Parsley, 1/2 cup Plain Flour, 1 beaten Egg, 1 cup Breadcrumb, For frying Vegetable Oil
- method (13 steps): Prepare the Bread Mixture Soak the bread slices in milk or water until soft. Squeeze out excess liquid and mash into small crumbs. Mix the Ingredients In a large bowl, combine ground meat, chopped onions, garlic, soaked bread, egg, and seasonings. Mix well until evenly combined. Shape the Meat Patties Take portions of the mixture and shape them into palm-sized patties. Flatten slightly to help with even cooking. Coat the Patties Lightly dust each patty with flour. Dip into beaten egg, then coat with breadcrumbs for a crispy finish. Fry the Fašírky Heat vegetable oil in a pan over medium heat. …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 13 steps, 15 ingredients, 35 min)
