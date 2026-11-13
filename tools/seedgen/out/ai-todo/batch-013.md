# AI tagging batch 013

Write `tools/seedgen/tags/ai/batch-013.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53010
**Lamb Tzatziki Burgers** · Lamb · area: Greek
- ingredients: 25g Bulgur Wheat, 500g Lamb Mince, 1 tsp Ground Cumin, 1 tsp Coriander, 1 tsp Paprika, 1 clove finely chopped Garlic, For frying Olive Oil, 4 Burger Bun, Grated Cucumber, 200g Greek Yogurt, 2 tbs Mint
- method (3 steps): Tip the bulghar into a pan, cover with water and boil for 10 mins. Drain really well in a sieve, pressing out any excess water. To make the tzatziki, squeeze and discard the juice from the cucumber, then mix into the yogurt with the chopped mint and a little salt. Work the bulghar into the lamb with the spices, garlic (if using) and seasoning, then shape into 4 burgers. Brush with a little oil and fry or barbecue for about 5 mins each side until cooked all the way through. Serve in the buns (toasted if you like) with the tzatziki, tomatoes, onion and a few mint leaves.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 40 min)

### mdb-53011
**Chicken Quinoa Greek Salad** · Chicken · area: Greek
- ingredients: 225g Quinoa, 25g Butter, 1 chopped Red Chilli, 1 clove finely chopped Garlic, 400g Chicken Breast, 2 tbs Olive Oil, Handful Black Olive, 1 chopped Red Onion, 100g Feta, Chopped Mint, Juice of 1/2 Lemon
- method (3 steps): Cook the quinoa following the pack instructions, then rinse in cold water and drain thoroughly. Meanwhile, mix the butter, chilli and garlic into a paste. Toss the chicken fillets in 2 tsp of the olive oil with some seasoning. Lay in a hot griddle pan and cook for 3-4 mins each side or until cooked through. Transfer to a plate, dot with the spicy butter and set aside to melt. Next, tip the tomatoes, olives, onion, feta and mint into a bowl. Toss in the cooked quinoa. Stir through the remaining olive oil, lemon juice and zest, and season well. Serve with the chicken fillets on top, drizzled wit…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 35 min)

### mdb-53012
**Gigantes Plaki** · Vegetarian · area: Greek
- ingredients: 400g Butter Bean, 3 tbs Olive Oil, 1 chopped Onion, 2 chopped Garlic, 2 tbs Tomato Puree, 800g Tomato, 1 tbs Sugar, 1 tbs Dried Oregano, Pinch Cinnamon, 2 tbs Parsley
- method (5 steps): Soak the beans overnight in plenty of water. Drain, rinse, then place in a pan covered with water. Bring to the boil, reduce the heat, then simmer for approx 50 mins until slightly tender but not soft. Drain, then set aside. Heat oven to 180C/160C fan/gas. Heat the olive oil in a large frying pan, tip in the onion and garlic, then cook over a medium heat for 10 mins until softened but not browned. Add the tomato purée, cook for a further min, add remaining ingredients, then simmer for 2-3 mins. Season generously, then stir in the beans. Tip into a large ovenproof dish, then bake for approximat…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 10 ingredients, 145 min, technique: proof)

### mdb-53013
**Big Mac** · Beef · area: United States
- ingredients: 400g Beef Mince, 2 tbs Olive Oil, 2 Burger Bun, Chopped Onion, 1/4 Lettuce, 2 sliced Cheese, 2 large Dill Pickle, 1 cup Mayonnaise, 2 tsp White Wine Vinegar, Pinch Black Pepper, 2 tsp Mustard, 1 1/2 tsp Onion Salt, 1 1/2 tsp Garlic Powder, 1/2 tsp Paprika
- method (6 steps): For the Big Mac sauce, combine all the ingredients in a bowl, season with salt and chill until ready to use. To make the patties, season the mince with salt and pepper and form into 4 balls using about 1/3 cup mince each. Place each onto a square of baking paper and flatten to form into four x 15cm circles. Heat oil in a large frypan over high heat. In 2 batches, cook beef patties for 1-2 minutes each side until lightly charred and cooked through. Remove from heat and keep warm. Repeat with remaining two patties. Carefully slice each burger bun into three acrossways, then lightly toast. To ass…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 14 ingredients, 75 min)

### mdb-53015
**Krispy Kreme Donut** · Dessert · area: United States
- ingredients: 1/4 ounce Yeast, 1/4 cup Water, 1 1/2 cups Water, 1/2 cup Sugar, 1 tsp Salt, 2 Egg, 1/3 cup Shortening, 5 drops Plain Flour, Sprinking Vegetable Oil, 1/2 cup Milk, 2 cups Sugar, 1 1/2 cups Vanilla Extract, 6 tablespoons Water, 1/3 cup Butter
- method (6 steps): Dissolve yeast in warm water in 2 1/2-quart bowl. Add milk, sugar, salt, eggs, shortening and 2 cups flour. Beat on low for 30 seconds, scraping bowl constantly. Beat on medium speed for 2 minutes, scraping bowl occasionally. Stir in remaining flour until smooth. Cover and let rise until double, 50-60 minutes. (Dough is ready when indentation remains when touched.) Turn dough onto floured surface; roll around lightly to coat with flour. Gently roll dough 1/2-inch thick with floured rolling pin. Cut with floured doughnut cutter. Cover and let rise until double, 30-40 minutes. Heat vegetable oil…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 14 ingredients, 110 min, technique: deep fr)

### mdb-53016
**Chick-Fil-A Sandwich** · Chicken · area: United States
- ingredients: 1 Chicken Breast, 1/4 cup Pickle Juice, 1 Egg, 1/4 cup Milk, 1/2 cup Plain Flour, 1 tbs Icing Sugar, 1/2 tsp Paprika, 1/2 tsp Salt, 1/4 tsp Black Pepper, 1/4 tsp Garlic Powder, 1/4 tsp Celery Salt, 1/2 tsp Cayenne Pepper, 1 cup Olive Oil, 1 Burger Bun
- method (9 steps): Wrap the chicken loosely between plastic wrap and pound gently with the flat side of a meat tenderizer until about 1/2 inch thick all around. Cut into two pieces, as even as possible. Marinate in the pickle juice for 30 minutes to one hour (add a teaspoon of Tabasco sauce now for a spicy sandwich). Beat the egg with the milk in a bowl. Combine the flour, sugar, and spices in another bowl. Dip the chicken pieces each into the egg on both sides, then coat in flour on both sides. Heat the oil in a skillet (1/2 inch deep) to about 345-350. Fry each cutlet for 2 minutes on each side, or until golde…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 14 ingredients, 95 min)

### mdb-53017
**Paszteciki (Polish Pasties)** · Beef · area: Polish
- ingredients: 1 cup Plain Flour, 1/4 tsp Salt, 1 Yolk Egg, 1 Egg, 5 tbs Butter, 6 tblsp Butter, 1/3 cup Onion, 1/2 cup Swede, 1/2 lb Beef Brisket, 2 Beaten Egg, 1 tsp Salt, 1/4 tsp Black Pepper
- method (18 steps): Sift flour and salt into a large mixing bowl. Use a spoon to push the egg yolk through a fine sieve into the flour. Add the raw egg and mix well. Beat in butter 1 tablespoon at a time. Place dough on a floured surface and knead until smooth and elastic, then wrap in waxed paper and refrigerate until firm (at least 30 minutes). In a heavy skillet, melt 2 tablespoons butter over medium heat; saute the onion and rutabaga until the onion is soft and transparent (5 minutes). Put the onions, rutabaga, and beef through a meat grinder twice if you have one, if not just chop them up as fine as possible…
- `flavor.salty` rule: 3 (0.55, weak signals only)
- `textures` rule: ['brothy', 'flaky', 'smooth'] (0.50, keywords: brothy, flaky, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 18 steps, 12 ingredients, 95 min, technique: knead)

### mdb-53018
**Bigos (Hunters Stew)** · Pork · area: Polish
- ingredients: 2 sliced Bacon, 1 lb Kielbasa, 1 lb Pork, 1/4 cup Plain Flour, 3 chopped Garlic, 1 Diced Onion, 1 1/2 cup Mushroom, 4 cups Cabbage, 1 Jar Sauerkraut, 1/4 cup Red Wine, 1 Bay Leaf, 1 tsp Basil, 1 tsp Marjoram, 1 tbs Paprika, 1/8 teaspoon Caraway Seed, 1 dash Hot Sauce, 5 Cups Beef Stock, 2 tbs Tomato Puree, 1 cup Chopped Tomatoes, 1 dash Worcestershire Sauce
- method (6 steps): Preheat the oven to 350 degrees F (175 degrees C). Heat a large pot over medium heat. Add the bacon and kielbasa; cook and stir until the bacon has rendered its fat and sausage is lightly browned. Use a slotted spoon to remove the meat and transfer to a large casserole or Dutch oven. Coat the cubes of pork lightly with flour and fry them in the bacon drippings over medium-high heat until golden brown. Use a slotted spoon to transfer the pork to the casserole. Add the garlic, onion, carrots, fresh mushrooms, cabbage and sauerkraut. Reduce heat to medium; cook and stir until the carrots are soft…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth', 'tender'] (0.50, keywords: saucy, smooth, tender)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 20 ingredients, 170 min)

### mdb-53020
**Rosol (Polish Chicken Soup)** · Chicken · area: Polish
- ingredients: 4 Chopped Chicken Leg, 2 large Onion, 5 chopped Carrot, 1 chopped Leek, 1 small Celery, 1/4 Cabbage, 1 whole Clove, 1tsp Ground Allspice, 2 Bay Leaf, 4 sprigs Parsley, 4 sprigs Dill, 1 tsp Black Pepper, 1 tbs Salt
- method (1 steps): Add chicken to a large Dutch oven or stock pot Cover with water Bring to a boil and simmer for 2 to 2 1/2 hours, skimming any impurities off the top to insure a clear broth If your pot is big enough, add the vegetables and spices for the last hour of the cooking time My Dutch oven wasn’t big enough to hold everything, just the chicken and other bones filled the pot, so I cooked the meat/bones for the full cooking time, then removed them, and cooked the vegetables and spices separately Strain everything out of the broth Bone the chicken, pulling the meat into large chunks Slice the carrots Retu…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `moods` rule: ['comfort', 'light'] (0.50, keywords/category: comfort, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 1 steps, 13 ingredients, 145 min)

### mdb-53021
**Golabki (cabbage roll)** · Beef · area: Polish
- ingredients: 1 Cabbage, 2 tbs Butter, 1 chopped Onion, 1 lb Beef Mince, 1/2 lb Pork Mince, 1 1/2 cups Rice, 1 tsp Garlic, 1 tsp Salt, 1/4 tsp Black Pepper, 3 cans Tomato Puree
- method (8 steps): Bring a large pot of lightly salted water to a boil. Place cabbage head into water, cover pot, and cook until cabbage leaves are slightly softened enough to remove from head, 3 minutes. Remove cabbage from pot and let cabbage sit until leaves are cool enough to handle, about 10 minutes. Remove 18 whole leaves from the cabbage head, cutting out any thick tough center ribs. Set whole leaves aside. Chop the remainder of the cabbage head and spread it in the bottom of a casserole dish. Melt butter in a large skillet over medium-high heat. Cook and stir onion in hot butter until tender, 5 to 10 min…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy', 'smooth'] (0.50, keywords: brothy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 10 ingredients, 105 min)

### mdb-53022
**Polskie Nalesniki (Polish Pancakes)** · Dessert · area: Polish
- ingredients: 1 cup Plain Flour, 2 Egg, 1 cup Milk, 3/4 cup Water, Pinch Salt, 1 tsp Sugar, 3 tbs Butter
- method (6 steps): Add flour, eggs, milk, water, and salt in a large bowl then mix with a hand mixer until you have a smooth, lump-free batter. At this point, mix in the butter or the vegetable oil. Alternatively, you can use them to grease the pan before frying each pancake. Heat a non-stick pan over medium heat, then pour in the batter, swirling the pan to help it spread. When the pancake starts pulling away a bit from the sides, and the top is no longer wet, flip it and cook shortly on the other side as well. Transfer to a plate. Cook the remaining batter until all used up. Serve warm, with the filling of you…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy', 'smooth'] (0.50, keywords: crispy, fluffy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 6 steps, 7 ingredients, 45 min)

### mdb-53023
**Sledz w Oleju (Polish Herrings)** · Seafood · area: Polish
- ingredients: 8 Herring, 1 sliced Onion, 1/2 cup Olive Oil, 1 tsp Ground Allspice, 1 tsp Black Pepper, 1 Bay Leaf
- method (5 steps): Soak herring in cold water for at least 1 hour. If very salty, repeat, changing the water each time. Drain thoroughly and slice herring into bite-size pieces. Place in a jar large enough to accommodate the pieces and cover with oil, allspice, peppercorns, and bay leaf. Close the jar. Refrigerate for 2 to 3 days before eating. This will keep refrigerated up to 2 weeks. Serve with finely chopped onion or onion slices, lemon, and parsley or dill.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 6 ingredients, 110 min)

### mdb-53024
**Rogaliki (Polish Croissant Cookies)** · Dessert · area: Polish
- ingredients: 1 cup Butter, 3 Egg Yolk, 8 oz Cream Cheese, 1 tsp Baking Powder, 3 cups Plain Flour, 1 Jar Jam
- method (9 steps): In a medium bowl mix egg yolks, philly cheese and baking powder using a hand held mixer. Carefully start adding the flour. When the mixture will not be mixing well, and will look like wood chips, put away the blending mixer and using your hands knead the dough. Create a roll and cover in foil and freeze for 15 minutes. At this time preheat the oven to 375. Take the dough out and separate into two. Roll and cut out 3 inch trangles. Make as many as you can and on centre of each put a small spoon of jam. Roll them into a croissant shape. Place the croissants onto a greased cookie sheet, and bake …
- `textures` rule: ['chewy', 'creamy', 'flaky'] (0.50, keywords: chewy, creamy, flaky)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 6 ingredients, 40 min, technique: knead)

### mdb-53025
**Ful Medames** · Vegetarian · area: Egyptian
- ingredients: 2 cups Broad Bean, 1/3 cup Parsley, Dash Olive Oil, 3 Lemon, 4 Garlic, Sprinking Ground Cumin
- method (13 steps): As the cooking time varies depending on the quality and age of the beans, it is good to cook them in advance and to reheat them when you are ready to serve. Cook the drained beans in a fresh portion of unsalted water in a large saucepan with the lid on until tender, adding water to keep them covered, and salt when the beans have softened. They take 2–2 1/2 hours of gentle simmering. When the beans are soft, let the liquid reduce. It is usual to take out a ladle or two of the beans and to mash them with some of the cooking liquid, then stir this back into the beans. This is to thicken the sauce…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy', 'saucy'] (0.50, keywords: brothy, creamy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 13 steps, 6 ingredients, 180 min)

### mdb-53026
**Tamiya** · Vegetarian · area: Egyptian
- ingredients: 3 cups Broad Bean, 6 Spring Onion, 4 Garlic, 1/4 cup Parsley, 2 tsp Ground Cumin, 1 tsp Baking Powder, 1/2 tsp Cayenne Pepper, Spinkling Plain Flour, As required Vegetable Oil
- method (5 steps): oak the beans in water to cover overnight.Drain. If skinless beans are unavailable, rub to loosen the skins, then discard the skins. Pat the beans dry with a towel. Grind the beans in a food mill or meat grinder.If neither appliance is available, process them in a food processor but only until the beans form a paste. (If blended too smoothly, the batter tends to fall apart during cooking.) Add the scallions, garlic, cilantro, cumin, baking powder, cayenne, salt, pepper, and coriander, if using. Refrigerate for at least 30 minutes. Shape the bean mixture into 1-inch balls.Flatten slightly and c…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 535 min)

### mdb-53028
**Shawarma** · Chicken · area: Egyptian
- ingredients: 1 kg Chicken Thigh, 1 tbs Coriander, 1 tbs Ground Cumin, 1 tbs Cardamom, 1 tsp Cayenne Pepper, 2 tsp Paprika, 2 tbs Lemon Juice, 3 tbs Olive Oil, 1 cup Greek Yogurt, 1 Garlic, 1 tsp Ground Cumin, Splash Lemon Juice, Sliced Lettuce, Sliced Tomato, 6 Pita Bread
- method (9 steps): Combine the marinade ingredients in a large ziplock bag (or bowl). Add the chicken and use your hands to make sure each piece is coated. If using a ziplock bag, I find it convenient to close the bag then massage the bag to disperse the rub all over each chicken piece. Marinate overnight or up to 24 hours. Combine the Yoghurt Sauce ingredients in a bowl and mix. Cover and put in the fridge until required (it will last for 3 days in the fridge). Heat grill/BBQ (or large heavy based pan on stove) on medium high. You should not need to oil it because the marinade has oil in it and also thigh fille…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 15 ingredients, 1485 min)

### mdb-53029
**Mulukhiyah** · Beef · area: Egyptian
- ingredients: 800g Mulukhiyah, 1 chopped Onion, 300g Beef, 1 tsp Salt, 1 Litre Water, 1 Garlic, 1/2 cup Olive Oil
- method (6 steps): Saute the onions in the 3-4 tablespoons olive oil Add the beef cubes or the chicken cutlets, sear for 3-4 min on each side Add 1 liter of water or just enough to cover the meat Cook over medium heat until the meat is done (I usually do this in the pressure cooker and press them for 5 min) Add the frozen mulukhyia and stir until it thaws completely and then comes to a boil. In another pan add the 1/4 to 1/2 cup of olive oil and the cloves of garlic and cook over medium low heat until you can smell the garlic (don’t brown it, it will become bitter) Add the oil and garlic to the mulukhyia and low…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 7 ingredients, 30 min)

### mdb-53030
**Feteer Meshaltet** · Side · area: Egyptian
- ingredients: 4 cups Plain Flour, 1 1/2 cups Water, 1/4 tsp Salt, 1 cup Butter, 1/4 cup Olive Oil
- method (15 steps): Mix the flour and salt then pour one cup of water and start kneading. If you feel the dough is still not coming together or too dry, gradually add the remaining water until you get a dough that is very elastic so that when you pull it and it won’t be torn. Let the dough rest for just 10 minutes then divide the dough into 6-8 balls depending on the size you want for your feteer. Warm up the butter/ghee or oil you are using and pour into a deep bowl. Immerse the dough balls into the warm butter. Let it rest for 15 to 20 minutes. Preheat oven to 550F. Stretch the first ball with your hands on a c…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 15 steps, 5 ingredients, 50 min, technique: knead)

### mdb-53031
**Egyptian Fatteh** · Beef · area: Egyptian
- ingredients: 1lb Beef, 1 Onion, 1 Chicken Stock, 2 Tomato, 4 Garlic, 1 tbs Tomato Puree, 2 cups Rice, 1/4 cup Noodle, 1/4 cup Butter, 2 cups Olive Oil, 1 Pita Bread, 1 tbs Ground Cumin, 3 tbs White Wine Vinegar, To taste Salt, To taste Black Pepper
- method (10 steps): To prepare bread for bottom of dish: Take pita bread and rip into bite size pieces. In a frying pan, add about a 1/4 stick of butter, add bread pieces and fry until golden brown and crisp. Put these pieces in a glass baking dish, preferably a square sized dish. Set aside. Then add to same pan, a little more butter, salt, approximately 2 cloves of crushed fresh garlic, and a teaspoon or so of cumin stir around a bit until you can smell aroma, then add fried bread pieces to this mixture, stir to coat bread and put back into glass baking dish. Set aside. To prepare meat: put some butter in a pot,…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'chewy', 'crispy'] (0.50, keywords: brothy, chewy, crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 15 ingredients, 195 min)

### mdb-53032
**Tonkatsu pork** · Pork · area: Japanese
- ingredients: 4 Pork Chop, 100g Plain Flour, 2 Beaten Egg, 100g Breadcrumb, Fry Vegetable Oil, 2 tbs Tomato Ketchup, 2 tbs Worcestershire Sauce, 1 tbs Oyster Sauce, 2 tblsp Sugar
- method (4 steps): Remove the large piece of fat on the edge of each pork loin, then bash each of the loins between two pieces of baking parchment until around 1cm in thickness – you can do this using a meat tenderiser or a rolling pin. Once bashed, use your hands to reshape the meat to its original shape and thickness – this step will ensure the meat is as succulent as possible. Put the flour, eggs and panko breadcrumbs into three separate wide-rimmed bowls. Season the meat, then dip first in the flour, followed by the eggs, then the breadcrumbs. In a large frying or sauté pan, add enough oil to come 2cm up th…
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 35 min)
