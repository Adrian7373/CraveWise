# AI tagging batch 028

Write `tools/seedgen/tags/ai/batch-028.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53337
**Saskatoon Pie** · Dessert · area: Canadian
- ingredients: 6 cups Plain Flour, 2 tsp Salt, 1 cup Butter, 1 cup Vegetable Shortening, 1 large Egg, 1 tablespoon White Vinegar, Splash Water, 5 Cups Saskatoon Berry, 1/2 cup Sugar, 1 tablespoon Sugar, 3 tablespoons Cornflour, 2 tablespoons Butter, 1 beaten Egg, 1 tablespoon Water
- method (13 steps): To make the pastry, place the flour and salt in a large bowl. Mix well. Add the cubes of butter and shortening and mix them in (I like to use my hands to mix the fat into the flour, but you can use a pastry blender) just until it looks like coarse oatmeal with some pea-sized bits remaining. Place the egg in a 2-cup measure and beat it with a fork. Beat in the vinegar and just enough ice-cold water to bring it to the 1-cup mark. Stir this into the flour mixture, just until the dough clings together. I like to use my hands for this part as well, but a wooden spoon would also work. Try not to ove…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky'] (0.50, keywords: creamy, flaky)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)

### mdb-53338
**Date squares** · Dessert · area: Canadian
- ingredients: 2 1/2 cups Date, 1 cup Water, 1 1/2 cup Vanilla Extract, 2 cups Oats, 1 cup Plain Flour, 1 cup Brown Sugar, 1/2 tsp Baking Powder, 1/4 tsp Salt, 1 cup Butter
- method (5 steps): Preheat oven to 350°F (180°C). Grease an 8-inch (20 cm) square baking pan. To make the date filing: Combine the dates and water in a medium saucepan over high heat and bring to a boil. Reduce heat to low and simmer gently, stirring occasionally until the mixture thickens, around 6 to 8 minutes. Remove from heat, stir in vanilla and let cool. Set aside. Combine rolled oats, flour, sugar, baking soda and salt in a food processor. Pulse 3 times (careful not to overmix, you don’t want the mixture to be powdery, just combined). Add butter and pulse again until the mixture is crumbly in pea-sized cl…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 60 min)

### mdb-53339
**Jam jam cookies** · Dessert · area: Canadian
- ingredients: 1 Egg, 1 cup Butter, 1 cup Sugar, 1/2 cup Molasses, 1 tsp Vanilla Extract, 2 tsp Baking Powder, 3 tablespoons Water, 2 tablespoons Baking Powder, 1 tsp Cinnamon, 2 tsp Salt, 4 cups Plain Flour, 2 cups Jam
- method (7 steps): Preheat the oven to 350 °F (180 °C) and line a large baking sheet with parchment paper. In a stand mixer with the paddle attachment, cream the butter, white sugar and egg until combined, then add the molasses and vanilla and mix until smooth. Once combined, add the baking soda water mixture and mix for another minute to combine. Combine dry ingredients; mix baking powder, cinnamon, flour and salt in a separate bowl then add to the wet ingredients a little at a time, mixing on low until fully combined and scraping down the sides to ensure everything is incorporated. The dough should be easily s…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'smooth'] (0.50, keywords: chewy, creamy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 12 ingredients, 45 min)

### mdb-53340
**Hodge Podge** · Vegetarian · area: Canadian
- ingredients: 1 lb New Potato, 1 lb Carrot, 1 cup Green Bean, 1/2 cup Pea, 1 tablespoon Dill, 1 tablespoon Chive, 3 Cups Milk, 1/2 cup Double Cream, 1/2 cup Butter, 1/2 tsp Salt, 1/4 tsp Black Pepper
- method (4 steps): First, cook your vegetables. Bring a large pot of salted water to boil. Par-cook carrots and potatoes for five minutes until carrots and potatoes are fork tender, then blanch the peas and beans for about a minute in the same pot. Strain vegetables and set aside. In a heavy-bottomed pot or Dutch oven, melt butter over medium heat, add vegetables, and cook to warm through. Add milk and cream and bring the soup to a boil. Turn the heat down to low and season with salt and pepper. Add dill and chives and let simmer for at least 10 minutes. Serve warm.
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy'] (0.50, keywords: brothy, creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 40 min)

### mdb-53341
**Flapper Pie** · Dessert · area: Canadian
- ingredients: 1 1/2 cups Graham Cracker Crumb, 6 tablespoons Butter, 1/2 cup Sugar, 1/2 tsp Cinnamon, 2 1/2 cups Milk, 1/2 cup Sugar, 1/4 cup Cornflour, 3 Egg Yolk, 1 tsp Vanilla Extract, 1/4 tsp Salt, 3 Egg White, 1/4 cup Sugar, 1/4 tsp Cream of Tartar
- method (7 steps): Preheat the oven to 350˚F. Mix all the crust ingredients (graham cracker crumbs, melted butter, granulated sugar and ground cinnamon) in a medium bowl. Set aside about 2 Tbsp (30 mL) for later and press the mixture into a 9-inch deep-dish pie plate in the bottom and up the sides. Bake crust for 10 minutes, it will only brown slightly. Combine the vanilla custard filling ingredients (milk, granulated sugar, cornstarch, egg yolks, vanilla extract and salt together) and cook on medium heat, stirring constantly, until it bubbles and thickens to the texture of pudding. Set aside to cool while you m…
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 13 ingredients, 45 min)

### mdb-53342
**Figgy Duff** · Dessert · area: Canadian
- ingredients: 2 cups Plain Flour, 1/2 cup Brown Sugar, 2 tsp Baking Powder, 1 tsp Ginger, 1 tsp Ground Allspice, 1 tsp Cinnamon, 1 cup Raisin, 1/3 cup Butter, 1/2 cup Molasses, 1 tablespoon Water
- method (6 steps): In a medium bowl, whisk together flour, brown sugar, baking powder, and spices. Add raisins and stir well, making sure to coat the raisins in the flour mixture. Add melted butter, molasses and water and mix with a wooden spoon. Form a ball with the spoon or your hands and put the dough ball in a cotton pudding bag. Tie the bag, leaving at least 1 inch of room to allow the pudding to expand while cooking. Boil pudding for 1.5 hours. (In NL, this is typically done in the pot along with Jiggs Dinner, but it can be done independently.) When the duff is firm, remove it from the boiling water and le…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 110 min)

### mdb-53343
**Classic Tourtière** · Beef · area: Canadian
- ingredients: 2 tablespoons Vegetable Oil, 1 chopped Onion, 2 cloves minced Garlic, 1 lb Beef Mince, 1 lb Pork Mince, 1 tsp Summer Savoury, To taste Salt, To taste Black Pepper, 1/2 tsp Clove, 1/2 tsp Ground Nutmeg, 1 Bay Leaf, 1 cup Beef Stock, 1 small Potato, 4 Shortcrust Pastry, 1 beaten Egg
- method (7 steps): Heat oil on medium-high heat in a large sauté pan or skillet, then sauté the onion and garlic until softened, about 5 minutes. Add the ground beef, pork, and spices and cook until the meat is browned. Add the beef broth and bring it up to a simmer then reduce heat to medium low. Add the grated potato and stir it in. Cook until liquid is almost absorbed, about 15 min. Remove the bay leaves and add salt to taste. Remove the pan from the heat and let the mixture cool completely — it bakes best if the filling is chilled. Preheat the oven to 375 °F (190 °C). On a lightly floured surface, roll out o…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'flaky'] (0.50, keywords: brothy, flaky)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 15 ingredients, 115 min)

### mdb-53344
**Jamaican Sweet Potato Pudding** · Dessert · area: Jamaican
- ingredients: 2 Lbs Sweet Potato, 1 1/2 cup Coconut Milk, 1 1/2 cup Brown Sugar, 1/2 cup Plain Flour, 1 tablespoon Vanilla Extract, 1 teaspoon Ground Allspice, 1 tsp Cinnamon, 1 tsp Ground Nutmeg, 1/2 tsp Ground Ginger, 1/4 tsp Salt, 1/2 cup Raisin, 3/4 cup Coconut Milk, 1 tablespoon Brown Sugar, 1/8 teaspoon Cinnamon, 1/8 teaspoon Ground Nutmeg
- method (4 steps): Preheat oven to 350°F (175°C). Grease and line a 9-inch round pan or loaf pan with parchment paper. Place your cut sweet potatoes in the bowl of a food processor and process until finely grated. In a small bowl, toss raisins in 2 teaspoons flour from the ½ cup. Set aside. In a large bowl, combine grated sweet potatoes, light brown sugar, all-purpose flour, vanilla extract, allspice, cinnamon, nutmeg, ginger, and salt. Stir in 1½ cups of coconut milk until a batter forms. Fold in the raisins that were tossed in the flour. Pour the batter into the prepared pan and smooth the top. Bake uncovered …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 15 ingredients, 120 min)

### mdb-53345
**Jamaican Curry Chicken Recipe** · Chicken · area: Jamaican
- ingredients: 2 Lbs Chicken Thigh, 2 1/2 Tbs Curry Powder, 1 tsp All Purpose Seasoning, 1 chopped Onion, 3 chopped Spring Onion, 1/2 Green Pepper, 4 Cloves Chopped Garlic, 1 chopped Scotch Bonnet, 3 sprigs Thyme, 3 tablespoons Olive Oil, 1/4 cup Water, 1 large Potato, To taste Salt, To taste Black Pepper
- method (8 steps): Equipment. Dutch Oven. Add chicken thighs, all-purpose seasoning, 1 tablespoon of curry powder, onion, green onions, green pepper, garlic cloves, scotch bonnet pepper (if using), and thyme to a large bowl and combine, making sure all chicken pieces are covered with the seasoning. Cover and refrigerate for at least 1 hour or up to overnight. One the chicken is done marinating, remove onions, peppers, and garlic cloves from chicken and set aside. Heat olive oil in a large heavy bottom pot over medium heat. Add remaining curry powder and stir, cooking for about 20-30 seconds. Add onions, green pe…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 14 ingredients, 135 min)

### mdb-53346
**Grape Nut Ice Cream** · Dessert · area: Jamaican
- ingredients: 2 cups Double Cream, 1 1/4 oz Condensed Milk, 1 tsp Vanilla Extract, 1 cup Grape Nut Cereal
- method (4 steps): In a large bowl, use an electric mixer to whip the cold heavy cream until stiff peaks form. Gently fold in the sweetened condensed milk and vanilla extract until well combined. Fold in the cereal and stir until evenly distributed throughout the mixture. Pour the mixture into a freezer-safe container (such as a loaf pan). Lay plastic wrap on top of the ice cream to avoid freezer burn. Cover the container and freeze for at least 6 hours or until solid. Once frozen, let the ice cream sit at room temperature for a few minutes to soften slightly before scooping and serving.
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'medium' (0.55, 4 steps, 4 ingredients, 400 min, technique: stiff peaks)

### mdb-53347
**No-Churn Rum Raisin Ice Cream** · Dessert · area: Jamaican
- ingredients: 1/2 cup Dark Rum, 1 cup Raisin, 1 tsp Vanilla Extract, 14 oz jar Condensed Milk, 2 tablespoons Brown Sugar, 1/4 tsp Cinnamon, 1/8 teaspoon Ground Allspice, 2 cups Double Cream, Pinch Salt
- method (6 steps): Heat the rum in a small saucepan over medium heat until warm (do not boil). Remove from heat and stir in the raisins and vanilla extract. Let the mixture sit for at least 30 minutes. After soaking, drain off the extra rum, but keep ¼ cup of the rum and reserve it to mix into your ice cream base. In a large bowl, whisk together the sweetened condensed milk, dark brown sugar, cinnamon, allspice, salt, and reserved rum (¼ cup). Stir until the brown sugar is fully dissolved. In a separate bowl, whip the cold heavy cream with an electric mixer until stiff peaks form. Gently fold the whipped cream i…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 9 ingredients, 415 min, technique: stiff peaks)

### mdb-53348
**Jamaican Spice Bun Recipe** · Dessert · area: Jamaican
- ingredients: 380g Plain Flour, 2 tsp Baking Powder, 2 tsp Cinnamon, 1/2 tsp Salt, 1 large Egg, 150g Brown Sugar, 250g Beer, 1/3 cup Milk, 1/4 cup Honey, 4 tablespoons Butter, 1 tablespoon Molasses, 1 tsp Caramelized Sugar Sauce, 1 tsp Vanilla Extract, 1/2 cup Dried Cranberry, 1/2 cup Raisin, 1/2 cup Dried Cherry
- method (8 steps): Soak the craisins, raisins, and cherries in the 1 cup of beer. Set aside and allow to soak for 30 minutes. Preheat the oven to 325 degrees Fahrenheit. Grease an 8x4 loaf pan. Set aside. Combine all-purpose flour, baking powder, ground cinnamon, salt, in a large bowl and set aside. In another bowl, combine brown sugar, egg, milk, honey, melted butter, molasses, browning, vanilla extract, and the beer that’s soaking the fruit. Do not pour the fruit in at this time, just the beer. Mix to combine. Remove 2 tablespoon of flour from the flour mixture and toss the fruit in it. Set aside. Make a well …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 16 ingredients, 115 min)

### mdb-53349
**Jamaican Pepper Shrimp** · Seafood · area: Jamaican
- ingredients: 1 lb Prawn, 2 chopped Scotch Bonnet, 1 tablespoon All Purpose Seasoning, 2 tsp Ground Annatto, 2 tsp Ground Allspice, 3/4 cup Shrimp Stock, 1/4 cup Onion, 2 cloves minced Garlic, 2 tablespoons White Vinegar, 3 sprigs Thyme, To taste Salt
- method (4 steps): In a medium bowl, combine shrimp with minced Scotch Bonnet peppers, all-purpose seasoning, ground annatto, and grounf allspice. Toss well to coat evenly and let marinate for 10 minutes. Heat a large pan over medium heat. Add the shrimp stock and bring to a gentle simmer. Stir in the diced onion and garlic, cooking until softened and fragrant, about 2 minutes. Add the seasoned shrimp and thyme sprigs, spreading the shrimp in the pan. Cover and cook for about 5–7 minutes, stirring occasionally, until the shrimp turn bright orange and are cooked through. Add the white vinegar, stir, and cook for …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 45 min)

### mdb-53350
**Corned Beef and Cabbage – Jamaican Style** · Beef · area: Jamaican
- ingredients: 1 tablespoon Olive Oil, 1/2 Cabbage, 1 chopped Green Pepper, 1 chopped Onion, 2 cloves minced Garlic, 12 ounces Corned Beef, 2 chopped Tomato, 2 sprigs Thyme, 1 tablespoon Tomato Ketchup, To taste Salt, To taste Black Pepper
- method (5 steps): Heat olive oil in a skillet or Dutch pot over medium-high heat. Add onion and green pepper and sauté for about 3-5 minutes. Add garlic and stir for about 1 minute. Add shredded cabbage and stir. Cook for about about 3-5 minutes, stirring often until softened. Add corned beef, Roma tomatoes, and thyme and stir. Add ketchup and scotch bonnet pepper sauce and stir. Reduce heat and cook on medium for about 3-5 minutes, until the corned beef is heated through. Remove from heat. Serve with white rice, bread, or on its own.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 35 min)

### mdb-53351
**Jamaican Banana Fritters** · Dessert · area: Jamaican
- ingredients: 3 Medium Banana, 1 tsp Vanilla Extract, 1/2 tsp Cinnamon, 1/4 tsp Ground Nutmeg, 3 tablespoons Brown Sugar, Pinch Salt, 1 cup Plain Flour, For frying Vegetable Oil
- method (4 steps): Mash bananas with fork in bowl. Add brown sugar, vanilla, extract, cinnamon, nutmeg and a pinch of salt. Sift in flour and stir with spoon until fully combined. Add oil to a 10 inch skillet over medium-high heat. Once oil is hot, drop banana fritter batter in oil by the spoonful. Once one side is golden and bubbles appear on the top, flip fritter and cook until the other side is browned as well. Remove fritters and drain on paper towels. Enjoy.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 45 min)

### mdb-53352
**Jamaican Instant Pot Rice and Beans** · Vegetarian · area: Jamaican
- ingredients: 1 tablespoon Olive Oil, 1 chopped Onion, 1 clove finely chopped Garlic, 2 chopped Spring Onion, 2 cups Rice, 3/4 cup Coconut Milk, 3/4 cup Water, 1 1/2 tsp Salt, 1/2 tsp Ground Allspice, 1/4 tsp Black Pepper, 450g Kidney Bean, 2 sprigs Thyme
- method (8 steps): Set Instant Pot to "Sauté." Once Hot, add olive oil. Then add yellow onion and stir until softened, about 3 minutes. Add garlic and green onions and stir for about 30 more seconds. Press “Cancel” on the Instant Pot. Add rice, coconut milk, water, salt, allspice, and black pepper and stir. Pour undrained kidney beans on top of the rice mixture. Do not stir. Lay sprigs of thyme on top. Cover the Instant Pot, ensuring the valve is set to “Sealing.” Press “Manual” or “Pressure Cook” on the Instant Pot and set for High pressure for 6 minutes. Once the pressure cooking time is done, allow it to natu…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 12 ingredients, 70 min)

### mdb-53353
**Jamaican Boiled Dumplings** · Side · area: Jamaican
- ingredients: 8 cups Water, 1/2 tbs Salt, 2 cups Plain Flour, 1 tsp Salt, 1/2 cup Water
- method (7 steps): In a large pot, bring water and salt to a boil to boil the dumplings. In a large mixing bowl, combine the all-purpose flour and salt, stirring to distribute the salt evenly throughout the flour. Gradually add water to the flour mixture, mixing with your hands until a dough forms. Divide the dough into equal-sized pieces, rolling each into a smooth ball. Flatten each ball slightly with the palm of your hand to form a round, circular dumpling. It should look like a thick disk. Carefully drop the dumplings into the boiling water, one at a time, ensuring that they don't stick together. You can use…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['fluffy', 'smooth'] (0.50, keywords: fluffy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 5 ingredients, 25 min)

### mdb-53355
**Jamaican Festival (Sweet Dumpling)** · Side · area: Jamaican
- ingredients: 1 1/2 cups Plain Flour, 1/2 cup Cornmeal, 6 tablespoons Sugar, 2 tsp Baking Powder, 1 tsp Vanilla Extract, 1/2 tsp Salt, 3/4 cup Milk, For frying Vegetable Oil
- method (6 steps): Heat a heavy bottom pot of oil that has at least 3 inches of oil in it or use a deep fryer if you have one. Turn the heat over medium heat until the temperature reaches 350 degrees Fahrenheit. Add the all-purpose flour, cornmeal, granulated sugar, baking powder, and salt to a large bowl and stir to combine. Add the vanilla extract and milk and stir until the dough comes together. Then use your hands to lightly form the mixture into a ball. Pinch off pieces of dough and roll them into long oval shapes. Make about 12 dumplings. Once the oil has reached the temperature of 350 degrees Fahrenheit, …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy'] (0.50, keywords: crispy, fluffy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 20 min, technique: deep fr)

### mdb-53356
**Jamaican Fried Dumplings** · Side · area: Jamaican
- ingredients: 2 cups Plain Flour, 2 tsp Baking Powder, 1 tsp Salt, 3/4 cup Milk, 1 1/2 cup Vegetable Oil
- method (6 steps): Add flour, baking powder, and salt in a large bowl and stir to combine. Pour in the milk and stir until combined. Then roll the mixture into a ball and lightly knead until it comes together. Break off about 10 pieces of dough and form them into balls. Set them aside. In a 10-inch skillet, heat enough oil over medium heat to fry the dumplings, until the oil is about 350 degrees. Once the dumplings are browned on one side, flip them and cook until both sides are browned, about 2-3 minutes each. Once done, remove the dumplings from the oil and place them on paper towels or a cooling rack to drain…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy'] (0.50, keywords: crispy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 5 ingredients, 20 min, technique: knead)

### mdb-53357
**Jamaican Rice and Peas** · Vegetarian · area: Jamaican
- ingredients: 2 cups Rice, 380g Coconut Milk, 450g Kidney Bean, 1 cup Water, 2 tsp Salt, 1/2 tsp Ground Allspice, 1/4 tsp Black Pepper, 3 Spring Onion, 2 sprigs Thyme, 1 Scotch Bonnet
- method (4 steps): Equipment Dutch oven. Add rice, coconut milk, kidney beans, water, kosher salt, allspice, and black pepper to a large pot and stir until combined. Lay green onions, thyme and Scotch bonnet pepper on top. Bring mixture to a boil. Once boiling, reduce heat to low and cover with a lid. Allow to cook covered for 18 minutes over low heat, then remove from heat. Leave the lid on for an additional 5 minutes. Open the lid and remove the green onion, Scotch bonnet pepper, and thyme. Fluff the rice and peas with a fork. Serve and enjoy.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 10 ingredients, 45 min)
