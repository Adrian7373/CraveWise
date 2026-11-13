# AI tagging batch 032

Write `tools/seedgen/tags/ai/batch-032.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53420
**Cambodian Waffles (Num Poum)** · Dessert · area: none
- ingredients: 1/2 cup Rice Flour, 1/2 cup Plain Flour, 1/2 cup Coconut Milk, 3/4 cup Palm Sugar, 2 Egg, 1/2 tsp Salt
- method (1 steps): In a bowl, mix the flour, coconut milk, palm sugar and eggs and salt. Brush a waffle iron with oil pour in the batter and cook over an open fire until light brown and crispy.
- `cuisine` rule: 'Cambodian' (0.60, title mentions 'Cambodian')
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 6 ingredients, 45 min)

### mdb-53421
**BEEF LOK LAK (Lok Lak Sach Ko)** · Beef · area: none
- ingredients: 1 kg Beef Fillet, 5 cloves Garlic, 2 tablespoons Vegetable Oil, 1.5 tablespoon Palm Sugar, 1 tsp Salt, 2 tablespoons White Wine, 2 tablespoons Oyster Sauce, 2 tablespoons Soy Sauce, 1.5 tablespoon Sesame Oil, 500g Lettuce, 400g Tomato, 200g Onion, 4 Egg, 1.5 tablespoon Salt, 1 tablespoon Kampot Pepper, 1 tablespoon Lime Juice
- method (6 steps): Fry the eggs sunny-side up and set aside. Finely chop the garlic. Wash the lettuce leaves and drain well. Thinly slice the onion and tomatoes. Cut the beef tenderloin into 2–3 cm cubes. Marinate with sea salt, palm sugar, Chinese cooking wine, oyster sauce, soy sauce, and sesame oil. Mix well. Heat a frying pan on high heat with cooking oil. Add chopped garlic and stir until the garlic browns lightly. Add the marinated beef (with all the marinade) and cook for 5–7 minutes, depending on how rare you want the beef. Dry roast the black Kampot peppercorns in a frying pan over medium-low heat for 2…
- `cuisine` rule: none
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 16 ingredients, 45 min)

### mdb-53422
**Num E (Sticky Rice Balls in Sugar Syrup and Coconut Cream)** · Side · area: none
- ingredients: 700g Sticky Rice Flour, 7 Pandan Leaf, 1/4 Beetroot, 100g Pumpkin, 100g Taro, 100g Longan, 200g Desiccated Coconut, 2L Water, 1 L Water, 1/2 tsp Salt, 5 Slices Ginger, 3 Cups Coconut Cream
- method (6 steps): Place coconut cream in a small pot over low heat. Cut 3 pandan leaves into large strips and add to the pot with brown sugar, salt, and ginger. Bring to a boil, then cook 2 more minutes. Turn off the heat, remove the pandan leaves, and let cool. Chop the remaining 4 pandan leaves, blend with ¼ cup water until very green, then strain well. In a bowl, place 200 g sticky rice flour, add a little pandan liquid, and knead until smooth. Peel and chop beetroot, blend with ¼ cup water until red, then strain well. In a bowl, place 200 g sticky rice flour, add a little beetroot liquid, and knead until sm…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 6 steps, 12 ingredients, 55 min, technique: knead)

### mdb-53423
**Meang Nem** · Seafood · area: none
- ingredients: 50g Dried Shrimp, 40g Rice, 100g Desiccated Coconut, 20g Orange Zest, 3 Red Chilli, 50g Peanut, 100g Pickled Scallion Head, 30 ml Pickled Scallion Head Brine, 25g Galangal, 30g Shallot, 20 ml Orange Juice, 50 ml Lime Juice, 50 ml Fish Sauce, 50g Palm Sugar
- method (6 steps): Rinse the rice, soak in water for about 10 minutes, then drain well. Heat a wok or large skillet over medium heat. Add the rice and stir constantly until evenly dark golden brown and very fragrant, about 5 minutes. Transfer to a bowl to cool. Grind finely using a spice grinder or mortar and pestle, then sift through a fine mesh strainer to remove any large pieces. Set aside. Thinly slice the shallots lengthwise. Finely chop the galangal, pickled scallion heads, chili peppers, and bitter orange zest. Coarsely grind the roasted peanuts. Heat a frying pan over low heat, add shredded coconut, and …
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 14 ingredients, 55 min)

### mdb-53424
**Laos Plantain Coconut Bake (Flourless Muffin)** · Dessert · area: none
- ingredients: 450ml Coconut Cream, 4 large Plantain, 4 tablespoons Sugar
- method (6 steps): Preheat oven to 350 degrees. Mash the plantains until it has a paste consistency. Mix togher the coconut cream and granulated sugar. Mix well. Add muffin liners to muffin pan. Fill the mixture into muffin pan. Bake for 45 minutes until baked all the way through.
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 3 ingredients, 55 min)

### mdb-53425
**Authentic Laos Tapioca Pudding with Bananas** · Dessert · area: none
- ingredients: 1 cup Water, 4 cups Water, 3 tablespoons Tapioca, 14 oz jar Coconut Milk, 2 tablespoons Sugar, 3 Cups Banana, 4 cups Water, To taste Salt
- method (6 steps): In a bowl of warm water, add tapioca pearls and allow them to soak for 20 minutes. Prepare bananas by peeling them and cutting them into ½ inch slices. Set the slices aside On a stove, pour in 4 cups of water and bring it to a boil. Add in the banana slices. After 20 minutes, drain the tapioca pearls in cold water to allow the pearls to separate from each other. Add the tapioca pearls into the the pot. Allow to simmer for 3 minutes or until the tapioca pearls turn clear. Next, add in sugar and pour in the coconut cream. Stir the ingredients gently for 3 minutes to incorporate the flavors. Add …
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'crunchy'] (0.50, keywords: chewy, creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 75 min)

### mdb-53426
**Lao Som Pak Pickled Cabbage** · Side · area: none
- ingredients: 1 large Cabbage, 10 Spring Onion, 16 oz Water, 2 tablespoons Salt
- method (6 steps): Cut the cabbage and chop it into 1 inch pieces. Put the cabbage in a large bowl and add cold water to rinse. Wash the cabbage. Rinse and drain three times. In a large clean bowl, pour in the bottle of water. Put the cabbage and green onion into the salt water mixture. Add in the salt.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 6 steps, 4 ingredients, 35 min)

### mdb-53427
**Lao Naem Khao** · Pork · area: none
- ingredients: 3 Cups Jasmine Rice, 1 Desiccated Coconut, Splash Vegetable Oil, 2 cups Sour Pork Sausage, 2 diced Pickled Garlic, Juice of 1 Lime, 2 tablespoons Fish Sauce, 1 tablespoon Sugar, 1 sliced Onion, 1 sliced Shallot, 3 finely chopped Spring Onion, 1 cup Coriander, 1/2 cup Hot Mint, 1/2 cup Mint, 1/4 cup Peanut, To serve Vegetable, To serve Lettuce
- method (15 steps): Slice the onion and shallots thinly. Let them soak in a ice water bath while preparing the rest of the meal. Grate the coconut. Put in a large bowl. Add the coconut in a large bowl. Add the rice. Using your hands, mix the coconut and rice together. Roll the mixture to form 2-inch rice ball croquettes. Heat up the cooking oil in a pot or pan. Beat two eggs and a large bowl. Dip the balls into the egg mixture. Then, drop the balls into the cooking oil. Allow the balls to turn a dark amber brown color. Deep fry until crispy, crunchy, and golden. Remove and set on paper towel to drain excess oil. …
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy', 'saucy'] (0.50, keywords: crispy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Pork guess)

### mdb-53428
**Camaro Grelhado Com Molho Cru (Grilled Prawns with Green Onion Sauce)** · Seafood · area: none
- ingredients: 1 lb Prawn, 2 cloves minced Garlic, 1/2 cup Spring Onion, 1 tsp Ground Cumin, 1/4 tsp Salt, 4 tablespoons White Vinegar, 4 tablespoons Water
- method (4 steps): Make the sauce by combining all the ingredients and grinding them into a paste. Put the prawns on the skewers and brush with sauce. Grill until done (they should lose their translucent color), about 3-4 minutes on each side. Serve with extra sauce on the side.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 20 min)

### mdb-53429
**Paracuca (Roasted Peanuts)** · Starter · area: none
- ingredients: 5 Cups Peanut, 1 cup Sugar, 1 cup Water, 1/4 tsp Salt
- method (3 steps): In a large heavy saucepan, combine the peanuts, sugar and water. Bring to a boil; cook until syrup has evaporated, about 10 minutes. Spread peanuts in a single layer in a greased 15x10x1-in. baking pan; sprinkle with salt. Bake at 300° for 30-35 minutes or until dry and lightly browned. Cool completely. Store in an airtight container.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 4 ingredients, 50 min)

### mdb-53430
**Antiguan Breakfast (Chop Up and ‘Saltfish’)** · Breakfast · area: none
- ingredients: 4 Aubergine, 8 oz Callaloo, 1 lb Pumpkin, 3 cloves Chopped Garlic, 1 Diced Onion, 2 oz Butter, 1/2 tsp Salt, 1/4 tsp Black Pepper
- method (8 steps): Peel and chop eggplant and pumpkin into medium-sized pieces. Heat butter and add onions and garlic in a medium sized pot set to medium to high heat. Sauté for 2 minutes until softened but not browned. Add pumpkin and eggplant. Sauté for an additional two to three minutes. Add water just to cover the vegetables. Bring to a boil, reduce heat to a simmer and cook until the vegetables are soft. Add the chopped spinach, stir and cook for an additional 3 minutes. Pour the vegetable mixture into a colander and let drain. After vegetable mixture has been drained return it to the pot and mash vigorousl…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 8 ingredients, 35 min)

### mdb-53431
**Corn on the cob with lime, green chilli and coconut butter** · Side · area: none
- ingredients: 1 L Vegetable Stock, 6 Corn On the Cob, 400ml Coconut Milk, Zest and juice of 2 Lime, 1 Green Chilli, Pinch Salt, Pinch Black Pepper, 25g Butter, 100g Desiccated Coconut, 100g Shallot, 10g Coriander, 10g Parsley
- method (5 steps): Bring the stock to a rolling boil in a big, deep pan. Slip in the cobs, leave to cook for about five minutes, then turn off the heat and leave the corn to sit in the stock as it cools. Put a heavy-based dry frying pan on a high heat and, once hot, lay the drained corn in the pan and char for a couple of minutes on each side – you’ll probably need to cook them two or three at a time, so you don’t overcrowd the pan. Put the coconut milk, lime juice and chillies in a small saucepan, season lightly, then bring up to a gentle simmer. Stir in the butter, turn off the heat and set aside. For the topp…
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 35 min)

### mdb-53432
**Slow-cooked, Wadadli-spiced Cubano pork belly** · Pork · area: none
- ingredients: 175ml Olive Oil, 4 tablespoons Coriander, 4 tablespoons Parsley, 6 tablespoons Oregano, 6 tablespoons Mint, 2 Red Chilli, 1 Green Chilli, Zest and juice of 2 Orange, Zest and juice of 2 Lime, Juice of 1 Grapefruit, 40g Garlic, 3 tsp Ground Cumin, 2 tablespoons Ground Allspice, To taste Salt, To taste Black Pepper
- method (11 steps): Blitz all the marinade ingredients in a food processor or with a hand blender. Lay the pork in a large dish, pour over the marinade, then turn the meat in the mixture, rubbing in the marinade all over and making sure every bit of the belly is coated. Cover the dish and leave overnight in the fridge. The next day, heat the oven to 140C (120C fan)/275F/gas. Lift the meat out of its marinade (don’t wipe off any that sticks to the joint, though; just leave most of the marinade behind in the dish) and transfer to a large roasting dish. Cover with foil, slip into the oven and roast for four and a ha…
- `cuisine` rule: none
- `textures` rule: ['crispy', 'tender'] (0.50, keywords: crispy, tender)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 15 ingredients, 615 min)

### mdb-53433
**Mango chow** · Side · area: none
- ingredients: 1/2 Mango, 1 chopped Spring Onion, 1 Scotch Bonnet, 2 tablespoons Coriander, Zest and juice of 1 Lime, To taste Salt, To taste Black Pepper
- method (1 steps): Simply combine everything in a bowl and serve alongside just about anything.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 7 ingredients, 35 min)

### mdb-53434
**Koulenje** · Side · area: none
- ingredients: 6 cups Plain Flour, 6 large Egg, 2 1/2 Tbs Baking Powder, 1 cup Butter, 1 tablespoon Salt, 1 cup Milk, 1 cup Sugar, 1 tablespoon Ground Mahleb, 1 Egg
- method (5 steps): Sift flour, baking powder, salt, and sugar together. In a separate bowl, beat 6 eggs, then blend in the butter and milk. Sprinkle one tablespoon of sev dzandig (black seeds) and all the mahleb on top of the dry ingredients. Make a hole in the center of the dry ingredients and pour the wet ingredients in all at once, mixing with a few strokes until the dough can be turned out onto a floured board. Add more flour if necessary; it shouldn't be too sticky. Knead the mixture gently, just a few times, and then roll it out until it is ½" thick. Cut it into diamond shapes, circles, or long strips whic…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 35 min, technique: knead)

### mdb-53435
**Stuffed Grape Leaves** · Side · area: none
- ingredients: 1 cup Rice, 2 cups Chicken Stock, 1 cup Tomato Sauce, 1/4 cup Olive Oil, 1/4 tsp Ground Allspice, 1/2 tsp Cinnamon, 1 chopped Onion, 1/2 cup Raisin, 1/2 cup Dill, 1/2 cup Pine Nut, Juice of 1 Lemon, To taste Salt, To taste Black Pepper
- method (6 steps): Wash rice in cold water until water runs clear. Sauté onions in olive oil until tender. Add spices and stir until fragrant. Add remaining ingredients. Bring to a gentle boil, then simmer for 30 minutes until all stock is absorbed and rice is tender. Serve as a side dish or filling for dolmas.
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 13 ingredients, 55 min)

### mdb-53436
**Jajek** · Side · area: none
- ingredients: 2 cups Yogurt, 1 cup Water, 1 clove peeled crushed Garlic, 1/2 tsp Salt, 1 tsp Dried Mint, 1 Cucumber
- method (2 steps): Place yogurt, water, garlic and salt in food processor and process for a few seconds. Transfer to a bowl and mix with mint and cucumber. Best served chilled for a few hours. When serving, add a few ice cubes to add additional refreshment! Makes about four servings.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 35 min)

### mdb-53437
**Leg of Lamb Armenian-Style** · Lamb · area: none
- ingredients: 1 Lamb Leg, 1 Bulb Garlic, 1 Bulb Garlic, 1 1/2 cup Parsley, 1 cup Onion, 1 tablespoon Black Pepper, 1 cup Balsamic Vinegar, 1/2 cup Olive Oil, 1/4 cup Mint, To taste Salt
- method (2 steps): Place all of the above ingredients into your roaster pan at least two days before you want to eat. Stir occasionally throughout the days to distribute marinade evenly. Bake at a 350-degree oven for 1 hour to 1 1/2 hours or until meat is not red when sliced. You can also make these on skewers if you wish to go through the process of spearing the meat with other veggies to grill. Freezes well.
- `cuisine` rule: 'Armenian' (0.60, title mentions 'Armenian')
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 140 min)

### mdb-53438
**Bolita di Keshi** · Miscellaneous · area: none
- ingredients: 1 lb Cheddar, 1 lb Feta, 1 beaten Egg, 5 tablespoons Cornflour
- method (6 steps): Grate finely and toss together. 1 lb. sharp yellow cheese (cheddar or oude boerenkaas) 1 lb. keshi di buriko (or any white cheese such as fromage blanc, queso blanco, ricotto, feta etc.) Stir in:. 6 eggs, beaten 5 Tbs. Cornstarch. Shape the mixture into small balls. These may be kept indefinitely in the freezer. Drop the balls into deep, hot fat and fry until golden. Serve piping hot on toothpicks.
- `cuisine` rule: none
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Miscellaneous guess)
- `difficulty` rule: 'easy' (0.55, 6 steps, 4 ingredients, 45 min, technique: piping)

### mdb-53439
**Arepa** · Side · area: none
- ingredients: 1 tsp Salt, 1 cup Cornflour, 1 1/4 cup Water
- method (4 steps): Put the corn flour in a bowl and add the salted water little by little, mixing with the flour until all the water has been used and the flour has become a dough. Let it rest for five minutes. Now, shape the dough into round rolls about 3 inches in diameter and 1/2 inch thick. In a lightly greased skillet, slowly cook the arepas until a crust forms on each side. Now place them into a casserole and bake in the oven at 350 degrees for approximately 20 minutes, until the arepas sound hollow when tapped. To enhance taste: instead of using just water, use chicken or beef broth.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy'] (0.50, keywords: brothy, saucy)
- `moods` rule: ['comfort', 'hearty', 'light'] (0.50, keywords/category: comfort, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 3 ingredients, 35 min)
