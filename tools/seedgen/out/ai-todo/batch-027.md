# AI tagging batch 027

Write `tools/seedgen/tags/ai/batch-027.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53317
**Beef Empanadas** · Beef · area: Uruguayan
- ingredients: 60g Lard, 340g Water, 1 tsp Salt, 600g Plain Flour, 3 Tomato, 1 clove Garlic, 1 large Red Onion, Bunch Spring Onion, 750g Sirloin Steak, 1 tablespoon Dried Oregano, 1 tsp Paprika, 1 tsp Chilli Flakes, 1 tsp Parsley, To taste Salt, To taste Black Pepper, 3 Egg, Splash Egg, Drizzle Chimichurri Sauce
- method (6 steps): For the dough place lard, warm water and salt in a large kneading bowl and stir. Add flour and oregano and either knead five miutes by hand or with the kneading function of your machine. Let rest covered for at least half an hour or overnight in the fridge. For the filling place tomatoes for about 30 seconds in boiling water, then cool with cold water and peel of skin and cut into cubes. Press garlic through garlic press, cut onions into cubes. Simmer garlic and onions in some olive oil until translucent. Take out onions and garlic and brown the meat at high heat from all sides. Season with al…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 18 ingredients, 110 min, technique: knead)

### mdb-53318
**Torta de fiambre** · Pork · area: Uruguayan
- ingredients: 150g Cheddar, 200g Ham, 3 Egg, 100g Vegetable Oil, 240g Milk, 120g Plain Flour, 2 tsp Baking Powder, 1 tsp Salt, To taste Dried Oregano
- method (5 steps): Line the bottom of a springform of 20-2cm (8-9inches) with parchment paper, I usually leave some overhang as the batter is very liquid and may spill a bit. Preheat oven to 220 degrees Celsius. Grate the cheese and take out the ham. Mix all remaining ingredients in a large bowl for about one to two minutes. Pour half the batter into the prepared pan, it is going to be very liquid. Then place ham and cheese on top and pour the remaining batter on top. Bake for about 20-25 minutes or until top is golden. Wait for a few minutes before releasing from the pan and enjoy either hot or cold with some f…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 45 min)

### mdb-53319
**Chivito sandwich** · Beef · area: Uruguayan
- ingredients: 80g Milk, 60g Butter, 1 tablespoon Molasses, 220g Water, 9 Egg, 500g Strong White Flour, 10g Salt, 10g Yeast, Splash Egg, Sprinkling Sesame Seed, 4 Onion, 8 Sirloin Steak, To serve Garlic, 8 Bacon, 8 slices Ham, 8 slices Mozzarella, 4 Tomato, 1/4 Lettuce, To serve Mustard, To serve Chimichurri Sauce
- method (7 steps): For the brioche buns heat the milk with the butter and molasses until the butter has melted. Add the cold water and egg to this mix. In a large bowl place flour, salt and yeast and mix. Then add the milk and water mix and stir with a wooden spoon until combined. You don't have to knead the dough, it is perfectly fine to do this by hand with a wooden spoon, this doesn't need to be very thorough. Cover with a damp towel and stick in the fridge overnight. The next morning knead dough on a generously floured surface for a little and cut into eight equal pieces. Shape these into balls and place on …
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 7 steps, 20 ingredients, 610 min, technique: caramelize, knead)

### mdb-53320
**Chocolate alfajores** · Dessert · area: Uruguayan
- ingredients: 150g Butter, 70g Sugar, 1 Egg, 25g Honey, 175g Plain Flour, 80g Cornflour, 30g Cocoa Powder, 1 tsp Baking Powder, 1 tsp Baking Powder, 400g Dulce de Leche, 500g Milk Chocolate, 100g Butter, Zest of 1 Orange
- method (6 steps): For the cookies cream the butter with the sugar for a few minutes. Then add the egg and honey and mix well. Add flour, cornstarch, cocoa, baking soda and baking powder and mix until you get a dough. Wrap in plastic wrap and chill for at least half an hour or overnight. Line two baking sheets with parchment paper, preheat oven to 200 degrees Celsius. Divide dough into two parts, put one part back in the fridge before using. Roll out second part to about 2 millimeters and cut out round cookies with 5-6 centimeters in diameter. This can be done with a cookie cutter or glass. You should get 30 coo…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy'] (0.50, keywords: chewy, creamy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 13 ingredients, 70 min)

### mdb-53321
**Vanilla alfajores** · Dessert · area: Uruguayan
- ingredients: 150g Dulce de Leche, 50g Desiccated Coconut, 100g Butter, 100g Sugar, 1 Egg, 1 Egg Yolk, 200g Cornflour, 100g Plain Flour, 1 tsp Baking Powder, 1 tsp Vanilla Extract, 150g Dulce de Leche, 50g Desiccated Coconut
- method (4 steps): For the sandwich cookie cream the soft butter for about a minute, then add the sugar and cream for another two minutes. Incorporate the egg fully before mixing in the egg yolk. Once everything is nicely combined, add all remaining ingredients and mix one more time. Form dough into a ball and wrap in plastic wrap. Chill for at least half an hour or overnight. Preheat oven to 180 degrees Celsius and line two baking sheets with parchment paper. Divide dough in half, put one back in the fridge and roll out the other thickly on a lightly floured surface. Cut out cookies with either the bottom of a …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'crunchy'] (0.50, keywords: chewy, creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 70 min)

### mdb-53322
**Flan** · Dessert · area: Uruguayan
- ingredients: 100g Sugar, 350g Milk, 45g Sugar, 1 Vanilla Pod, 4 Egg Yolk, 2 Egg, To taste Dulce de Leche
- method (6 steps): For the caramel place 100 grams of sugar in a frying pan without any fat and melt on medium heat. Try not to stir with a spoon, but swirl the pan itself. Let melt until you have an amber color and sugar is fully melted. Fill the bottom of four flan containers with it. Caramel will harden immediately, so you need to be fast. My containers yield about 120 milliliters each. Preheat oven to 150 degrees Celsius and look for a casserole or container all your four flan containers fit into. Heat milk with 45 grams of sugar and the cut and scraped out vanilla pod. The milk does not need to boil, just n…
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 7 ingredients, 110 min)

### mdb-53323
**Postre Chajá** · Dessert · area: Uruguayan
- ingredients: 5 Egg, 100g Sugar, Pinch Salt, 75g Plain Flour, 30g Cornflour, 1 Egg White, 50g Sugar, 200g Dulce de Leche, 400g Double Cream, 1 tsp Vanilla Extract, 40g Sugar, 500g Peach, 50 ml Peach Juice, 1 tsp Cornflour
- method (13 steps): For the sponge cake preheat oven to 180 degrees Celsius and prepare either one or two 20cm/8 inch cake pan(s). Line bottom with parchment paper. Then divide the eggs into egg white and egg yolks. Use a bigger bowl for the egg yolks. If you have a glass or metal bowl, use that one for the egg whites. Be sure that bowl is free of fat/grease and that your mixer was properly cleaned. First beat the egg whites on medium speed with a pinch of salt until soft peaks form. Set aside. Without cleaning our mixer, beat the egg yolks with the sugar. Beat until the color becomes much paler and you have a cr…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'fluffy'] (0.50, keywords: creamy, crispy, fluffy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-53324
**Chocolate empanadas** · Dessert · area: Uruguayan
- ingredients: 400g Condensed Milk, 250g Plain Flour, 25g Cocoa Powder, Pinch Salt, 125g Butter, 1 Egg, 3 tablespoons Milk, 30g Butter, 30g Sugar, 1 tsp Cinnamon
- method (7 steps): For the filling place the can in a large pot and cover completely with water. Boil for two and a half hours, occassionally adding water. Let cool before opening. For further tips, please check here. For the dough combine the flour, cocoa powder, and salt in a large bowl. Add the cold butter in small pieces and rub into crumbs with your fingers Add the egg and work into a dough. You may have to add milk, a tablespoon at a time if it still is to dry. Wrap and chill for at least half an hour or overnight. Line a baking sheeet with parchment paper and preheat the oven to 180 degrees Celsius. Roll …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 10 ingredients, 100 min, technique: fold each, rub in)

### mdb-53325
**Venezuelan Arepas** · Side · area: Venezuela
- ingredients: 2 cups Cornmeal, 2 1/2 cups Water, 1 tsp Salt, 1 tablespoon Vegetable Oil
- method (14 steps): Preheat oven to 410° F. Pour the water into a large bowl. Make sure it is room temperature. Add the salt. Blend well with a mixer, fork or spatula to make sure it dissolves well. While you continue to beat the mixture, slowly add the corn meal—a little bit at a time. Once all the flour is added, keep mixing until the corn meal, water and salt are thoroughly blended and dissolved. Set aside the masa in its bowl. Let it rest for 5 minutes so that the flour is thoroughly hydrated. This type of corn flour does not have any gluten, so it doesn’t need to be kneaded. The masa should be smooth, firm y…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth', 'tender'] (0.50, keywords: saucy, smooth, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 14 steps, 4 ingredients, 40 min, technique: knead)

### mdb-53326
**Venezuelan Sancocho** · Beef · area: Venezuela
- ingredients: 2 Lbs Hind Shank, 2 small Onion, 1/2 Black Pepper, 4 Cloves Chopped Garlic, 4 Cloves Crushed Garlic, 1 Leek, 8 cups Beef Stock, 1/2 cup Red Pepper, 1/2 cup Spring Onion, 2 Sweetcorn, 1/2 lb Cassaba, 1/2 lb Yautia, 1/2 lb White Yam, 1/2 lb Butternut Squash, To taste Salt, To taste Black Pepper, Chopped Coriander
- method (6 steps): Add hind shank, 1 halved small onion, halved bell pepper, 4 whole garlic cloves, the dark green leaves of the leek, and stock to a large stockpot. Cook for 45-60 minutes until the meat is fork-tender. NOTE: the meat can take a bit longer to be fork-tender; that is okay, just add more cooking time if necessary. When the meat is tender, remove the big pieces of vegetables and bones. Discard. Add diced onion, 2 minced garlic, mini sweet peppers, sliced leeks (light green part), scallions, yucca, and corn; Mix and simmer covered over medium heat for 5- 8 minutes, until the yucca is starting to sof…
- `flavor.sweet` rule: 2 (0.55, weak signals only)
- `textures` rule: ['brothy', 'crunchy', 'saucy'] (0.50, keywords: brothy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 17 ingredients, 95 min)

### mdb-53327
**Venezuelan Coconut Chicken** · Chicken · area: Venezuela
- ingredients: 2 Chicken Breast, 2 chopped Onion, 1 clove peeled crushed Garlic, 4 Bay Leaf, Pinch Black Pepper, Pinch Turmeric, Pinch Ground Cumin, Pinch Salt, 1 tablespoon Sugar, 3 Tomato, 1 tablespoon Ginger Paste, 1/3 cup Olive Oil, 1 Can Coconut Milk, 1/2 cup Water
- method (7 steps): Cut the chicken up into bite size pieces. Peel and cut the onions, mince the garlic. Assemble the rest of the ingredients and you are ready to start cooking. Make the Dish Heat up a fry pan over medium heat. Add the oil and when hot, sauté the onion until translucent. Remove from pan and transfer to a blender or food processor. Add tomatoes, garlic, turmeric, cumin, sugar, ginger paste, coconut milk, water and blend smooth. In the same pan you cooked the onion, add the chicken and brown all sides. This should take about 3 minutes. Add the blender ingredients and bay leaves to the pan, bring to…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 14 ingredients, 50 min)

### mdb-53328
**Venezuelan Shredded Beef** · Beef · area: Venezuela
- ingredients: 2 Lbs Skirt Steak, 2 cloves minced Garlic, 1 chopped Onion, 1 sliced Onion, 1 sliced Red Pepper, 3 sliced thinly Tomato, 4 cups Beef Stock, 2 tsp Worcestershire Sauce, 1 tablespoon Tomato Puree, 1 tsp Ground Cumin, 1/4 cup Tomato Ketchup, To taste Salt, To taste Black Pepper, 1 tablespoon Olive Oil
- method (3 steps): Season beef with salt, pepper and minced garlic Chop 1 onion in 4 big wedges Place in the beef pressure cooker with the 4 wedges of onion and the stock Pressure cook for 20 minutes Release the pressure and open the lid Remove the beef and SAVE 2 cups of stock in another container With 2 forks, shred the beef. Beef should be tender enough to so easily. If not, cook for another 10 minutes Press the saute button of the Instant pot. Add the olive oil When the machine beeps, add the sliced onion, pepper and tomatoes. Cook until tender Add the shredded beef back in the pot and mix Pour in 1 1/2 cups…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 14 ingredients, 65 min)

### mdb-53329
**Arepa pelua** · Beef · area: Venezuela
- ingredients: 500g Beef, 1 Onion, 1 Red Pepper, 2 cloves Garlic, 1 tsp Ground Cumin, 1 tsp Oregano, 1 tsp Paprika, 1 L Beef Stock, 2 1/2 cups Water, Pinch Salt, 200g Cheese, Pinch Olive Oil
- method (7 steps): Cook the meat: Place the flank steak in a pot with broth or water and salt. Cook over low heat for about 2 hours, until tender and easy to shred. Shred the meat: Once cooked, drain and shred the meat using two forks. Prepare the vegetables: Sauté chopped onion, bell pepper, and garlic in a little oil. Add cumin, oregano, paprika, and salt. Stir in the meat and cook for a few minutes until the flavors are well combined. Make the dough: In a bowl, mix the cornmeal with warm water and salt until a soft dough forms. Let it rest for 5 minutes. Form the arepas: Divide the dough into 6 portions, shap…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['brothy', 'crispy'] (0.50, keywords: brothy, crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 12 ingredients, 165 min)

### mdb-53330
**Cassava pizza** · Pork · area: Venezuela
- ingredients: 6 cut thick slices Casabe, 450g Tomato Sauce, 225g Chorizo, 225g Turkey Ham, 75g Sweetcorn, 40g Green Olive, 55g Paprika, 50g Mozzarella
- method (6 steps): Preheat the oven to 200ºC. Cut the bacon or chorizo into medium pieces and the paprika into strips. Spread a little tomato sauce and mozzarella cheese on each portion of cassava. Add the bacon or chorizo, corn, turkey ham, some olives and paprika. Bake for 7 to 10 minutes. Remove from the oven and enjoy.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 25 min)

### mdb-53331
**Oatmeal pancakes** · Breakfast · area: Venezuela
- ingredients: 1 medium Egg, 80 ml Milk, 1 tablespoon Sugar, 1 tsp Baking Powder, Pinch Salt, 1 dash Vanilla Extract, 150g Oats, 150g Butter, 1 tablespoon Sugar Syrup, 3 Strawberries
- method (5 steps): Place all the ingredients in the glass and beat. Let the mixture stand for 10 minutes. Grease a hot frying pan with a little butter and pour a little of the mixture. When it starts to bubble on the surface, turn over with a spatula. Cook over medium-low heat so that they do not burn. Finally, add the caramel and strawberries.
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['fluffy'] (0.50, keywords: fluffy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Breakfast guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 45 min)

### mdb-53332
**Venezuelan turnovers** · Side · area: Venezuela
- ingredients: 450g Beef Mince, Pinch Black Pepper, Pinch Ground Cumin, 1 tablespoon Vegetable Oil, 1 cup Onion, 1/2 cup Green Pepper, 1/2 cup Red Pepper, 1 tsp Garlic Powder, 1/4 cup Caper, 1 Can Tomato Sauce, 1 Can Sazon, 2 Yellow Masarepa, For frying Vegetable Oil
- method (5 steps): Season meat with Adobo. In skillet, heat oil on medium high. Cook meat until pink is gone. Stir in onion, pepper, garlic, alcaparras, tomato sauce and Sazón. Cook, stirring often until most of the liquid has evaporated (about 20 minutes). Cool. Prepared dough should be moist and should hold together, but it should not stick to your fingers. Start with about ½ cup of dough and roll into a ball between palms of your hands. Working on a sheet of non-stick parchment paper, form the ball into a 5-inch circle about ⅛ inch thick. Place a generous tbsp. of filling on one half of circle and using parch…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 13 ingredients, 45 min)

### mdb-53333
**Passion fruit mousse** · Dessert · area: Venezuela
- ingredients: 1 ½ tbsp Gelatine, 1 Passion Fruit Pulp, 1 cup Sugar, 1 Can Condensed Milk, 6 Egg White, 1 Sprig Mint
- method (4 steps): Add gelatin and ¼ cup room-temperature water to small bowl; let sit until gelatin softens, about 5 minutes. In medium saucepan over medium-high heat, stir together passion fruit pulp, sugar and gelatin mixture. Cook, stirring occasionally, until mixture is thoroughly combined and smooth (mixture should not come to a boil). Remove from heat; cool completely. Stir in condensed milk. Meanwhile, in clean mixing bowl, using electric mixer, beat egg whites until stiff (peaks of egg whites will not droop, and egg whites will not move when bowl is tilted). Stir 1/3 egg whites into cooled passion fruit…
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 140 min)

### mdb-53334
**Arepa Pabellón** · Beef · area: Venezuela
- ingredients: 2 Corn Arepa Filled with Mozarella Cheese, 1 Fried Ripe Banana, 1 Can Black Bean, 1 Pico de Gallo Sauce, 2kg Shredded Meat, 1 chopped Tomato, Pinch Salt, Pinch Black Pepper
- method (4 steps): Prepare the meat in a skillet and add salt and pepper to taste, heat the beans over medium heat in a pan, fry or grill the ripe plantains as indicated on its package and cut the tomato into small cubes. Reserve these ingredients until filling. Preheat the grill or pan and grill the arepa, putting it once on each side until they are golden brown. With the help of a knife, open it by the edge through the middle, creating a space to fill it with the ripe plantain, the beans, meat and chopped tomato. Serve with a little pico de gallo or guacamole dip sauce.
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 50 min)

### mdb-53335
**Jiggs Dinner** · Beef · area: Canadian
- ingredients: 2 Lbs Beef, 1 cup Yellow Split Pea, 1 head Cabbage, 6 Carrot, 1 large Turnip, 8 Potato, 3 tablespoons Butter, To taste Black Pepper
- method (7 steps): The night before, break salt beef into big chunks and soak in water overnight, at least 8-10 hours. Put split peas into a bowl and cover with water to soak overnight. Drain the salt beef and place it into a large stockpot. Cover with fresh water, at least 6-7 litres. Place the split peas into a pease pudding canvas bag or triple layer of cheesecloth and tie, making sure to leave room for peas to expand inside the bag. Put the bag inside the pot, tying the strings to the outside handle so it doesn't stick to the bottom of the pot with the salt beef. Bring to a boil, then lower the heat and simm…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 8 ingredients, 615 min)

### mdb-53336
**Molasses Baked Beans** · Vegetarian · area: Canadian
- ingredients: 2 cups Dried White Navy Bean, 1/2 lb Bacon, 1 medium Onion, 1/2 cup Molasses, 1/4 cup Brown Sugar, 2 tablespoons Cider Vinegar, Ground Mustard, To taste Salt, To taste Black Pepper
- method (6 steps): Place the dried beans into a Dutch oven with 6 cups (1.5 L) of water. Soak overnight. Drain and pour beans back into the pot with enough water to cover the beans by a couple of inches, cook for 30 minutes until they are tender but still firm. Drain beans, making sure to reserve cooking liquid, set aside. Preheat the oven to 325 °F (160 °C). While the oven is preheating, cook pork over medium-high heat in the Dutch Oven until fat is rendered and pork is beginning to brown, then add the onion cooking until tender. Add the beans back to the pot, along with molasses, brown sugar, apple cider vineg…
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 9 ingredients, 710 min)
