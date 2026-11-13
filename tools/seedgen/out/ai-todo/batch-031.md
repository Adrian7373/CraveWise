# AI tagging batch 031

Write `tools/seedgen/tags/ai/batch-031.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53400
**Mastawa Lamb and Rice** · Lamb · area: none
- ingredients: 700g Lamb, 3 Medium Onion, 1 tsp Turmeric, 1 large Orange, 150g Rice, 500g Yogurt, 4 Cloves Crushed Garlic, 1 tblsp Vegetable Oil, 1 tablespoon Dried Dill, 1 tablespoon Black Pepper, 1 Can Chickpea, To taste Salt
- method (7 steps): Place the meat cut into pieces, in a large pan with the onions. Add the turmeric and enough water to cover. Bring to the boil then cook gently until the meat is very tender and can easily be removed from the bones. While the meat is cooking, cut the orange peel into thin match style pieces, removing as much pith as possible. Leave to soak in a bowl of water. When the meat is tender, remove from the pan and when cool enough, remove the meat from the bones and shred the meat into strips with your hands. Return the meat to the pan. Wash the short grain rice and then add to the pan with salt accor…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 12 ingredients, 60 min)

### mdb-53401
**Bolani with Potato Filling** · Side · area: none
- ingredients: 450g Plain Flour, 225ml Water, 3 tsp Salt, 900g Potato, 50g Spring Onion, 1 tsp Black Pepper, For frying Vegetable Oil
- method (7 steps): Put the flour and teaspoon of salt in a mixing bowl. Slowly adding as much water as is required. Mix to form a stiff dough. Place the dough on a clean work surface and knead for about 5-10 minutes until the dough is elastic, smooth and shiny. Form the dough into a ball, cover with a damp cloth and set aside for at least half an hour. Peel and wash the potatoes and boil them in salted water until soft. Drain off the water and mash thoroughly. Add the spring onions, salt and black pepper. Divide the dough into 3 or 4 balls. Roll out each ball as thinly as possible on a lightly floured surface (t…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'smooth'] (0.50, keywords: creamy, crispy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 7 ingredients, 55 min, technique: knead)

### mdb-53402
**Mantu Afghan Dumpling** · Starter · area: none
- ingredients: 450g Plain Flour, 225ml Water, 450g Lamb, 1 Green Chilli, 450g Onion, 2 tblsp Black Pepper, 1 tablespoon Vegetable Oil, 1 tablespoon Tomato Puree, 425ml Greek Yogurt, Pinch Coriander
- method (7 steps): To prepare the dough, sift the flour with 1tsp of salt into a mixing bowl. Slowly mix in as much of the water is required, until a stiff dough is formed. Knead on a clean work surface for 5-10 minutes, until the dough is elastic and shiny. Cover with a damp cloth and set aside for about an hour. Put the chopped lamb, onions, chilli, 1 tsp salt, ground pepper and spices in a bowl and mix thoroughly. Divide the dough into 4 small balls, and roll out to a thickness of 1.5mm, cutting into 10cm squares. Into each square, place 1 heaped teaspoon of the lamb mixture. Take two opposite corners and bri…
- `cuisine` rule: 'Afghan' (0.60, title mentions 'Afghan')
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['fluffy', 'saucy', 'smooth'] (0.50, keywords: fluffy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 10 ingredients, 125 min, technique: knead)

### mdb-53403
**Muraba-E-Kadu (Pumpkin Jam)** · Miscellaneous · area: none
- ingredients: 1 kg Pumpkin, 1 kg Orange, 750g Sugar, 60g Cardamom
- method (7 steps): Remove the skin of the pumpkin. Also remove the inner seeds. Cut the flesh into 2cm cubes. Take the zest off the oranges, with as little pith as possible, and cut into matchstick-sized strips. Extract the juice from the oranges. Remove the seeds from the cardamom pods and reserve. Place the pumpkin, orange juice, orange strips, sugar and whole cardamom pod seeds in a large pan, mix well and leave to marinate for about 10 hours or overnight. Stir occasionally. Bring the mixture to the boil, then reduce the heat and simmer until the liquid has thickened and become syrupy. This can take about an …
- `cuisine` rule: none
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 4 ingredients, 675 min)

### mdb-53404
**Tavë Kosi Baked Lamb and Yogurt** · Lamb · area: none
- ingredients: 600g Lamb, 20g Butter, 2 tablespoons Olive Oil, 70g Rice, 2 tsp Oregano, 450ml Water, 2 cloves chopped Garlic, Pinch Salt, Pinch Black Pepper, 50g Butter, 2 tablespoons Plain Flour, 750g Greek Yogurt, 6 Egg, Pinch Salt, Pinch Black Pepper
- method (9 steps): Baking the Lamb In a large pan (with a lid) melt the butter and olive oil together then add the diced lamb. Brown the lamb on a medium heat, this will take around 5 minutes. Add the garlic, oregano, 300ml of water and season with salt and pepper. Mix well before covering with the lid. Leave to simmer for 50 minutes mixing a couple of times ensuring the lamb doesn’t start to burn. The juices should have nearly all boiled away so another 150ml of water should be added along with the rice. Mix altogether, bring to the boil, place the lid on and leave for just 10 minutes. It’s advised to check at …
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 15 ingredients, 160 min)

### mdb-53405
**Tavë me Presh ska Mish Meatless Leek Bake** · Vegetarian · area: none
- ingredients: 500g Leek, 3 diced Red Pepper, 200g Rice, 1 clove finely chopped Garlic, 1 L Vegetable Stock, 1 tsp Paprika, 1 tsp Oregano, 1 tsp Parsley, 1 tsp Basil, Pinch Salt, Pinch Black Pepper, Splash Olive Oil
- method (6 steps): Prepare the dish Fry the leeks in a small dash of olive oil for a few minutes until they start to brown. Prepare the Dish Add the roasted red peppers, garlic, stock, herbs, salt, pepper and paprika. Give it a good stir, add the rice and stir again. Leave it to come to the boil. Leave to simmer for 2 minutes. Pour the mixture into a baking tray with a depth of 2 inches or more. Mix thoroughly and ensure equally levelled out. Cooking Place on the bottom self of a preheated oven at 180 degrees. Leave to bake for 1 hour. Serving Once cooked turn off the oven and keeping the door open leave the lee…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 12 ingredients, 100 min)

### mdb-53406
**Arra të Mbushura me Fik Walnut Stuffed Figs (with Fig Syrup)** · Dessert · area: none
- ingredients: 4 Fig, 4 Walnut, 150ml Water, 60g Sugar
- method (6 steps): Prepare the Figs Cut off the hard bits of stalk and then cut the figs in half length ways. Place the figs in a small frying pan / saute pan with the cut side face up and add the water around them. Cooking Leave the figs on a medium heat to cook through, once they become soft remove them from the pan and place onto a serving dish. This will take around 10 - 15 minutes. Prepare the Syrup In the pan there will be a red water juice left from the figs. Add the sugar while remaining on a medium heat. Stir continuously for a couple of minutes until the juice has turned to a thick syrup. Remove from t…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 4 ingredients, 25 min)

### mdb-53407
**Lakror me Kungull Summer Squash Pie** · Vegetarian · area: none
- ingredients: 2 Squash, 2 Egg, 300g Plain Flour, 1/4 tsp Baking Powder, Splash Olive Oil
- method (5 steps): Preparation In a mixing bowl mix together the summer squash, sugar, eggs and baking soda. Add the flour and continue to mix, you are looking for a thick sticky mixture. Add a bit more flour if the mixture is still thin and slightly runny. In a large round baking tray (about 2 inches deep) rub some olive oil over the base and edges. Scoop the mixture onto the tray and spread out evenly, then pour a small amount of olive oil onto you hand and rub it in circles gently over the top of the mixture. This should flatten it and leave it with a slightly shiny glossing. Cooking Bake in the oven for 40 m…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 5 ingredients, 50 min)

### mdb-53408
**Kulaç Soda Bread** · Side · area: none
- ingredients: 450g Plain Flour, 500g Greek Yogurt, 1/2 tsp Salt, 1 tsp Baking Powder, Splash Olive Oil
- method (9 steps): Prepare On a large baking tray or a clean work surface, mix together the dry ingredients - flour, baking soda and salt. Make a well in the middle and add the yogurt. Using your hands slowly combined the ingredients together to start to form a dough. Kneed the dough on a floured surface, adding extra flour if you find the texture too sticky. The dough is ready when it is of a pizza dough texture and still very slightly sticky, this should only take a few minutes. On a baking tray add a little oil and put the dough on top. Shape and flatten the dough into a circle shape ensuring the height of th…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 5 ingredients, 55 min)

### mdb-53409
**Shendetlie Honey and Nut Cake** · Dessert · area: none
- ingredients: 300g Sugar, 3 Egg, 180g Butter, 700g Plain Flour, 100g Walnut, 4 tablespoons Honey, 1 tsp Baking Powder, 220g Sugar, 450ml Water
- method (8 steps): Prepare In a mixing bowl cream together the eggs, sugar and cooled melted butter then add the honey and soda. Add half the flour and the walnuts (you can add the walnuts whole or ground them) and mix well. Add the rest of the flour and using your hands kneed the mixture together until a firm dough is formed. Coat a large baking tray (traditionally a circle tray is used about 30cm is best with a 2 - 3 inch height) with olive oil. Add the dough and press it down so that it fits the whole tray. Try and get the dough flat and equal in height all over. Baking Place on the bottom shelf of a cold ove…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 9 ingredients, 125 min, technique: temper)

### mdb-53410
**Presh me Oriz Leek and Rice Bake** · Lamb · area: none
- ingredients: 500g Leek, 400g Lamb Mince, 1 Diced Onion, 200g Rice, 1 L Lamb Stock, Pinch Salt, Pinch Black Pepper, Splash Olive Oil
- method (6 steps): Cooking Fry the leeks in a small dash of olive oil for a few minutes until they start to brown. Add the onions and mince and fry until everything is browned. Ensure you keep stirring to prevent the leeks catching and burning. Add the rice and stir together for a few minutes ensuring the rice is well blended and coated in any juices. Add the lamb stock, salt and pepper. Give it a good stir and leave it to come to the boil. Leave to boil for 2 minutes. Baking Pour the mixture into a large baking tray, place on the bottom self of a preheated oven at 180 degrees. Leave to bake for up to 1 hour. Th…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 95 min)

### mdb-53411
**Dolma Japrak Stuffed Vine Leaves** · Side · area: none
- ingredients: 600g Pickled Grape Leaf, 400g Lamb Mince, 5 chopped Onion, 75g Rice, 1 tsp Black Pepper, 1 tsp Paprika, 1 tsp Vegetable Stock, 25g Parsley, 1 tsp Basil, Splash Olive Oil, To taste Salt, 2 Litres Water
- method (8 steps): Preperation Add the onions to a saute pan and fry for 5 minutes in olive oil until the onions start to brown. Turn off the heat and add the meat, rice, pepper, paprika, dried vegetable stock, parsley and basil. Mix all the ingredients together. Carefully unwrap the vine leaves. Place one vine leaf on your hand with the base on the bottom of your palm and the point pointing towards the top. Add a second vine leaf with the point pointing downwards and base of the leaf at the top of your fingers. there should be a good overlap. You can do this on a flat surface if preferred. Place a spoonful of t…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 12 ingredients, 130 min)

### mdb-53412
**Lakra me Mish Cabbage and Meat Stew** · Beef · area: none
- ingredients: 500g Beef, 1 Diced Cabbage, 2 tsp Paprika, 3 tsp Tomato Puree, 2 diced Red Pepper, 1 Diced Onion, 1/4 tsp Chilli Flakes, Pinch Salt, Pinch Black Pepper, Splash Olive Oil, 1 L Water
- method (6 steps): Cooking Add some olive oil to a saute pan or saucepan (one with a lid). One heated add in the onions, diced beef, red peppers and fry for 5 minutes stirring occasionally. The meat should be fully browned. Add the paprika, tomato puree, chilli flakes and season with salt and pepper. Mix together and continue to fry for 2 minutes. Add the cabbage and stir the mixture together. Fry the mixture while stirring occasionally for 3-5 minutes. Most of the oil should have burned away. Pour the boiling water into the pan, ensuring that the water level completely covers the cabbage, plus about 1 inch abov…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth', 'tender'] (0.50, keywords: saucy, smooth, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 11 ingredients, 190 min)

### mdb-53413
**Flija Layered Pancake / Crepe** · Breakfast · area: none
- ingredients: 1 kg Plain Flour, 1 L Water, 1 tsp Salt, 220g Butter, 200ml Vegetable Oil, 5 tablespoons Greek Yogurt, 220g Butter, 200ml Vegetable Oil, 3 tablespoons Clotted Cream, 220g Butter, 500ml Sour Cream, 3 tablespoons Olive Oil
- method (11 steps): Prepare the Flour Batter Mix together the flour, water and salt ensuring all the lumps are dissolved. The mixture should be thick but still of a pouring consistency, add a little extra water if required. Put to one side. Prepare the Batter Filling Mix together the butter, oil and chosen yogurt / cream ensuring all the lumps are dissolved. The mixture should be runny, leave to rest for 10 minutes before given it another good mix. The consistency should be similar to custard. Put to one side. Baking Preheat the gill to a medium setting (I use mark 4 of 6). Take a large deep baking tray or pie pa…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'fluffy'] (0.50, keywords: creamy, crispy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 12 ingredients, 165 min)

### mdb-53414
**Kurabie Butter Cookies** · Dessert · area: none
- ingredients: 650g Plain Flour, 275ml Greek Yogurt, 3 Egg, 200g Sugar, 120g Butter, 1 tsp Baking Powder, 1 drop Vanilla Extract, 1 Egg, 10g Butter
- method (4 steps): Prepare the Dough In a large mixing bowl add all the ingredients and mix together until a dough is formed. The dough should be stick - add extra flour if you find the mixture too sticky to work with. Using the extra melted butter, rub some over your hands before breaking the dough into 20 equal sized pieces and roll each piece into a ball. Before rolling each ball rub melted butter over your hands each time. Place the balls of dough onto a greased / lined baking tray 5cm apart - you will need to split the balls into two batches cooking one batch at a time. Cooking Brush eat ball with beaten eg…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 40 min)

### mdb-53415
**Torrijas** · Breakfast · area: none
- ingredients: 1 medium Orange, 1 medium Lemon, 4 cups Milk, 1/2 cup Sugar, 1 Cinnamon Stick, 1/3 cup Sherry, 1 Baguette, 1 cup Olive Oil, 4 large Egg, To serve Honey
- method (6 steps): Finely grate the zest of 1 medium orange (about 2 teaspoons) and 1 medium lemon (about 1 teaspoon) into a medium saucepan. Add 1 quart whole milk, 1/2 cup granulated sugar, and 1 (3-inch) cinnamon stick. Bring to a boil over medium heat. Remove the pan from the heat and add 1/3 cup dry sherry. Let sit until cool enough to handle. Meanwhile, cut 1 (12-ounce) day-old baguette crosswise into 1-inch-thick slices (about 16). Arrange in a single layer on a rimmed baking sheet. Pour the milk mixture over the bread and let it soak for 5 minutes. Flip each slice of bread. Let the bread sit until it abs…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 55 min)

### mdb-53416
**Trinxat (Potato, Cabbage and Bacon Hash)** · Pork · area: none
- ingredients: 1/2 Cabbage, 2 medium Potato, 4 Chopped Bacon, 2 cloves minced Garlic, 1 tablespoon Parsley, To taste Salt, To taste Black Pepper
- method (10 steps): Bring salted water to boil in a large pot. Add in the cabbage and potatoes, cook until tender about 30-40 minutes When tender, drain, very well. Return the vegetables to the pot and turn on the burner to low. Let steam Meanwhile cook up the bacon, reserving the fat for frying the hash. Chop up the bacon, into small pieces. Mash the potatoes and cabbage with a potato masher and add in the minced garlic. Add in salt and pepper to taste. Using a form for individual servings, press the hash mixture into the form with bacon on top, fry in the reserved bacon fat until golden brown, flip over and rep…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 7 ingredients, 55 min)

### mdb-53417
**Pa Amb Tomaquet (Bread with Tomato)** · Vegetarian · area: none
- ingredients: 2 sliced Bread, 2 cloves Garlic, 3 chopped Tomato, Splash Olive Oil, To taste Salt
- method (5 steps): Toast the bread slices -- either in a toaster, or by baking them in the oven at 400°F -- until crispy and golden. (Toasting/baking time will totally depend on the type and thickness of your bread.) Take a clove of garlic and rub it cut-side-down all over the top of a slice of bread. Take a tomato half and rub it cut-side-down all over the top of the bread. Drizzle the bread evenly with a hint of olive oil. Sprinkle with a pinch of salt. Repeat with the remaining slices of bread. Then serve immediately while they're nice and warm!
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 5 ingredients, 50 min)

### mdb-53418
**Cambodian Stir-fried Morning Glory with Pork, Fermented Soybeans, and Garlic** · Pork · area: none
- ingredients: 1 bunch Morning Glory, 150g Pork Mince, 2 tablespoons Soya Bean, 4 Cloves Chopped Garlic, For frying Vegetable Oil, Dash Fish Sauce, Dash Sugar, Sprinkling Red Chilli
- method (5 steps): In a wok or large pan, heat 1 tablespoon of vegetable oil over medium heat. Once the oil is hot, add the garlic and stir-fry for about 30 seconds, until fragrant but not burnt. Add the minced pork to the pan and break it up with a spatula. Stir-fry until the pork is fully cooked and browned, about 2-3 minutes. Stir in the fermented soy beans and cook for another minute, mixing it thoroughly with the pork. Toss in the cut morning glory and stir-fry for 2-3 minutes to retain its bright green colour and crisp texture. Check the seasoning and adjust with fish sauce or sugar if needed. Transfer to …
- `cuisine` rule: 'Cambodian' (0.60, title mentions 'Cambodian')
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['hearty', 'indulgent', 'light'] (0.50, keywords/category: hearty, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 8 ingredients, 25 min)

### mdb-53419
**Crispy fried fish with ginger and fermented soybeans (trey chien chuon)** · Seafood · area: none
- ingredients: 2 cups Ginger, 1 lb White Fish, 2 tablespoons Tempura Flour, 2 cups Vegetable Oil, 4 cloves Garlic, 800g Soya Bean, 1/2 tbs Sugar, 1/2 cup Water, 3 Spring Onion
- method (9 steps): Fry the ginger in plenty of oil until golden and slightly crispy. Set aside for later. Cut the fish into strips. Dredge the fish in a very thin layer of tempura flour. Fry the fish in plenty of oil until golden brown and crispy. You can use the same oil as you were using to fry the ginger. Crush the garlic and chop it into small pieces. Chop the spring onion. Drain the fermented soybeans using a colander. If you are using salted beans (soybeans in a very salty brine), you need to wash the beans in water before you add them to the dish. Add a tablespoon of oil to a deep pan or a large pot, and …
- `cuisine` rule: none
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 9 ingredients, 30 min)
