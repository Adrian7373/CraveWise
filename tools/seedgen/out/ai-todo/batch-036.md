# AI tagging batch 036

Write `tools/seedgen/tags/ai/batch-036.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53500
**Num Ansom – Sticky Rice Cake** · Side · area: none
- ingredients: 2 cups Glutinous Rice, 1 cup Coconut Milk, 1/2 cup Brown Sugar, 1/2 tsp Salt, 8 Banana Leaf, 1 cup Mung Bean Paste
- method (13 steps): Drain the soaked glutinous rice thoroughly in a fine-mesh strainer. In a medium bowl, combine the coconut milk, palm sugar, and salt, stirring until the sugar dissolves completely. Add the drained rice to the coconut milk mixture, mixing gently to coat every grain evenly. Let it sit for 15 minutes to absorb the liquid. Prepare a steamer by filling the bottom pot with 2 inches of water and bringing it to a boil over high heat. Lay a banana leaf square flat on your work surface, shiny side up. Spoon ¼ cup of the rice mixture into the center, spreading it into a 4-inch rectangle. Place 2 tablespo…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'crunchy'] (0.50, keywords: chewy, creamy, crunchy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 13 steps, 6 ingredients, 140 min, technique: steamer basket)

### mdb-53501
**Num Pang – Cambodian Baguette Sandwich** · Chicken · area: none
- ingredients: 4 Baguette, 1 lb Chicken Thigh, 1/4 cup Soy Sauce, 2 tablespoons Honey, 2 tablespoons Vegetable Oil, 1/2 cup Carrot, 1/2 cup Daikon Radish, 1/4 cup Rice Vinegar, 1 tablespoon Sugar, 1/4 cup Mayonnaise, 1 tablespoon Sriracha, 1/2 cup Coriander, 1/4 cup Cucumber
- method (12 steps): In a medium bowl, whisk together the soy sauce and honey to create a marinade. Add the chicken thigh strips to the marinade, ensuring each piece is fully coated, and let it sit for 20 minutes at room temperature. While the chicken marinates, combine the julienned carrots, daikon radish, rice vinegar, and granulated sugar in a separate bowl, stirring until the sugar dissolves to pickle the vegetables. In a small bowl, mix the mayonnaise and sriracha sauce thoroughly to make a spicy aioli. Heat the vegetable oil in a large skillet or wok over medium-high heat until it shimmers, about 2 minutes. …
- `cuisine` rule: 'Cambodian' (0.60, title mentions 'Cambodian')
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 13 ingredients, 60 min)

### mdb-53502
**Khmer Banh Xeo – Cambodian Savory Pancake** · Pork · area: none
- ingredients: 1 cup Rice Flour, 1/4 cup Cornflour, 1 1/4 cup Coconut Milk, 3/4 cup Water, 1/2 tsp Turmeric, 1/2 lb Pork Belly, 1 cup Bean Sprout, 1/2 Onion, 2 tablespoons Vegetable Oil, Splash Fish Sauce
- method (10 steps): Whisk together rice flour, cornstarch, coconut milk, water, and turmeric in a bowl until smooth, then let rest for 15 minutes—this hydrates the flour for better texture. Heat a 10-inch non-stick skillet over medium-high heat (375°F) and add 1/2 tablespoon of vegetable oil. Sauté pork belly slices for 3–4 minutes until lightly browned, then push to one side of the skillet. Add onion slices and cook for 1 minute until slightly softened. Stir the batter briefly and pour about 1/2 cup into the skillet, immediately swirling to coat the bottom thinly. Scatter bean sprouts over half of the pancake an…
- `cuisine` rule: 'Cambodian' (0.60, title mentions 'Cambodian')
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 10 ingredients, 50 min)

### mdb-53503
**Samlar Machu Kreung – Cambodian Sour Stew** · Chicken · area: none
- ingredients: 1 lb Chicken Thigh, 1 tablespoon Vegetable Oil, 4 cups Water, 2 tablespoons Tamarind Paste, 1 tablespoon Fish Sauce, 1 tsp Sugar, 1 cup Pineapple Chunk, 1 cup Cherry Tomato, 1 cup Green Bean, 1 Stalk Lemongrass, 2 Makrut Lime Leaf, 1 sliced Red Chilli
- method (13 steps): Heat 1 tbsp vegetable oil in a large pot over medium-high heat until it shimmers, about 1 minute. Add 1 lb boneless, skinless chicken thighs to the pot and cook until browned on all sides, approximately 5-7 minutes, stirring occasionally to prevent sticking. Pour 4 cups water into the pot and bring to a boil, then reduce heat to a simmer. Stir in 2 tbsp tamarind paste, 1 tbsp fish sauce, and 1 tsp sugar until fully dissolved, about 1 minute. Add 1 stalk lemongrass and 2 kaffir lime leaves to the pot, then cover and simmer for 10 minutes to infuse the broth with flavor. Tip: Bruising the lemong…
- `cuisine` rule: 'Cambodian' (0.60, title mentions 'Cambodian')
- `textures` rule: ['brothy', 'crispy', 'saucy'] (0.50, keywords: brothy, crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 13 steps, 12 ingredients, 55 min)

### mdb-53504
**Macaroni Pudding** · Pasta · area: none
- ingredients: 4 cups Macaroni, 4 cups Evaporated Milk, 1 cup Water, 3 Cups Sugar, 2 tsp Salt, 4 Egg, 1/4 cup Butter, 1 cup Raisin, 2 1/2 Tsp Ground Nutmeg, 2 tablespoons Vanilla Extract
- method (4 steps): Add macaroni to large pan with sufficient water to cover (approximately 4 cups). Add salt and bring to boil until tender (approximately 25 -30 minutes). Meanwhile, beat eggs and sugar together, then add vanilla and nutmeg. Mix well and set aside. In a separate medium sauce pan, heat evaporated milk plus 1 cup of water and butter to almost a boiling point. Remove from heat and add to sugar mixture. Drain cooked macaroni. Add macaroni and raisins to the milk mixture and stir well. (This mixture will have quite a bit of liquid, but this will form a nice custard textured pudding once baked.) Greas…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 10 ingredients, 105 min)

### mdb-53505
**Conch Fritters** · Seafood · area: none
- ingredients: Can Conch, 1/2 Green Pepper, 1/2 Red Pepper, 2 large Onion, 2 Red Chilli, Juice of 2 Lime, 2 tbsp chopped Garlic, 1 tablespoon Black Pepper, 1 tablespoon Salt, 1 tsp Basil, 1 tsp Chilli Flakes, 1 Egg, 10 tblsp Plain Flour, For frying Vegetable Oil
- method (5 steps): Note: Make the conch mix the day before and store in the refrigerator to allow time for flavours to meld together. Tartar sauce can also be prepared beforehand. Just combine all the ingredients and mix well. Cover and refrigerate. Use your food grinder to grind together the conch pieces, red and green peppers, onions and hot peppers. Once done, add in your lime juice, minced garlic, black pepper, salt, dried basil, and red pepper flakes; make sure to mix it thoroughly. Then add your egg and mix again. Lastly, add your flour one tablespoon at a time and mix until combined. You can either plasti…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 14 ingredients, 95 min, technique: deep-fr)

### mdb-53506
**Rice and Beans** · Vegetarian · area: none
- ingredients: 1/2 bag Kidney Bean, 1 Can Coconut Milk, 1 Diced Onion, 3 Scotch Bonnet, 1 tablespoon Black Pepper, 1/2 tbs Salt
- method (1 steps): Cook beans until tender, add rice, coconut milk, onion, black pepper and salt, and add enough water to just cover the ingredients. Place Scotch Bonnet peppers on top, careful not to burst them. Simmer until rice is tender. Remove pepper before serving.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 6 ingredients, 45 min)

### mdb-53507
**Cayman Style Potato Salad** · Side · area: none
- ingredients: 10 Potato, 1/2 Green Pepper, 1/4 Red Pepper, 1/2 Onion, 1 cup Mayonnaise, 1/4 cup Mustard, 1 tablespoon Sugar, 1/4 tsp Black Pepper, 1 Can Beetroot, 1 Can Pea, 3 Egg
- method (1 steps): Peel and cut potatoes in cubes, boil in salted water until tender. Chop peppers and onion and set aside. Mix together mayonnaise, mustard, sugar and black pepper and set aside. Drain potatoes once tender and place in large mixing bowl. Add remaining ingredients and mix well. The salad may be served warm, but is normally served after it has been refrigerated for 2 to 3 hours.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 11 ingredients, 170 min)

### mdb-53508
**Cassava Cake** · Dessert · area: none
- ingredients: 2 Lbs Cassava, 1 lb Brown Sugar, 1 can Coconut Milk, 1/4 Ground Nutmeg, 1/2 tsp Ground Allspice, 1/2 tsp Cinnamon
- method (4 steps): Bring coconut milk to a boil. Add sugar, stirring until completely dissolved and continue to boil for about 45 minutes. Reserve ½ cup of the coconut milk/sugar mixture for later. Combine remaining ingredients in a large mixing bowl, stir until well blended. Add hot coconut milk mixture and stir well. Mixture should be of a thick liquid texture. Use 1 tablespoons of coconut milk mixture to grease baking pan. Pour batter into prepared baking pan and bake at 350°F (basting occasionally with reserved coconut milk mixture) for 2 to 3 hours or until knife inserted in centre comes out clean. Spread a…
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 180 min)

### mdb-53509
**Fried Crab** · Seafood · area: none
- ingredients: 1 lb Crab Meat, 2 medium Onion, 1 Scotch Bonnet, 1/2 tsp Black Pepper, To taste Salt, 1/4 cup Vegetable Oil
- method (4 steps): Wash crabs and boil in large pot of water for 15 minutes, remove from boiling water and cool. Crack legs and open backs to remove all meat, set aside. Remove seeds from scotch bonnet pepper and dice pepper and onions. Sauté onions and scotch bonnet peppers in oil over medium heat until onions begin to get transparent. Add crab meat, black pepper and salt, stirring occasionally. Cook over medium heat for an additional 5 to 10 minutes. Serve with “bread kind”, a local dish that consists of a variety of starchy vegetables including pumpkin, squash, plantain, potato, cassava and breadfruit. Option…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 65 min)

### mdb-53510
**Cayman-Style Lobster** · Seafood · area: none
- ingredients: 6 Lobster, 1/2 cup Chicken Stock, 1/2 cup Red Pepper, 1/2 cup Green Pepper, 1/2 cup Onion, 2 cloves minced Garlic, 1/2 Scotch Bonnet, To taste Salt, To taste Black Pepper, To taste Thyme, 2 tsp Cornflour, 2 tablespoons Olive Oil
- method (4 steps): Rinse lobster under cold running water. Bring water and salt to boil in a 12 quart pot. Quickly plunge lobsters, headfirst, into boiling water. Cover and boil for 20 minutes or until lobsters turn red. Remove lobster and allow it to cool. Remove lobster tails and cut shell down to middle to remove the meat. Cut the tail meat down the middle to remove the vein inside. Remove large claws and smaller legs by twisting them away from the body. A nut cracker can be used to crush the claw and legs to remove the meat inside. Chop lobster meat. Heat butter or olive oil in large pan over low heat. Sauté…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['fresh', 'indulgent', 'light'] (0.50, keywords/category: fresh, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 55 min)

### mdb-53511
**Salt Beef and Beans** · Beef · area: none
- ingredients: 1 lb Corned Beef, 1 1/2 cup Kidney Bean, 1 Scotch Bonnet, 2 Spring Onion, 1/4 tsp Thyme, 1 clove finely chopped Garlic, 2 cups Water, 3 Cups Coconut Milk, 2 Bay Leaf, 6 Ground Allspice, 2 cloves Garlic
- method (4 steps): Cover the diced salt beef with water and bring to a boil. Repeat as necessary, draining and replacing water to eliminate some of the brine. In a separate pan, place beans in water, add coconut milk, bay leaves, pimento seeds, whole garlic, whole scotch bonnet pepper and scallions. Slowly bring to a boil and simmer for about 2 hours, or until beans are tender. Add salt beef, onions, thyme and crushed garlic and simmer for another 20 minutes. Adjust seasonings if necessary. Remove the bay leaves and scotch bonnet pepper, being careful not to burst the pepper. Serve with white rice and your choic…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 165 min)

### mdb-53512
**Conch Stew** · Seafood · area: none
- ingredients: 2 Lbs Conch, 1 Onion, 1/2 Green Pepper, 1/2 Red Pepper, 2 Spring Onion, 1 tsp Salt, 1/4 tsp Black Pepper, 1/4 tsp Seasoning, 1 Desiccated Coconut, 1 tablespoon Plain Flour, To taste Red Chilli, 1 cup Plain Flour, 1/2 tbs Vegetable Oil, Dash Salt, Splash Water
- method (5 steps): Conch Stew Cooking Directions. Clean conch meat and pound to tenderize. Boil conch for 2 - 3 hours or until tender. Make Sea Pie while conch cooks (instructions below). Once cool, cut conch in bite size pieces and season. Add all ingredients, except flour, to pan and simmer for 10 to 20 minutes. Mix flour with 1 cup water and pour into pan to thicken. Add Sea Pie pieces and continue to cook for an additional 10 minutes. Sea Pie Cooking Directions. Make dough with flour, pinch of salt and water so that you can roll out as thin as possible, then cut into 2 ½” x 2 ½” squares. Let set for 30 minut…
- `cuisine` rule: none
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy', 'tender'] (0.50, keywords: crunchy, saucy, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 15 ingredients, 200 min)

### mdb-53513
**Chilean-Style Sopaipillas** · Side · area: none
- ingredients: 9 oz Zapallo Squash, 5 Cups Plain Flour, 1 tsp Baking Powder, 1 tsp Salt, 10 tblsp Butter, 2 cups Vegetable Oil
- method (4 steps): Peel, seed, and cut zapallo into chunks. Place in a saucepan, cover with water, and bring to a boil over medium-high heat. Cook until zapallo is soft and easily pierced with a fork, 15 to 20 minutes. Drain and allow to cool slightly. Mix flour, baking soda, and salt together in a mixing bowl, and set aside. Stir together squash and melted butter. Stir the flour mixture into the butter mixture until blended. Turn the dough out onto a lightly floured surface and knead until soft and satiny, adding a little more flour if necessary. Cover dough with a towel and allow to rest 15 minutes. Roll out t…
- `cuisine` rule: 'Chilean' (0.60, title mentions 'Chilean')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 55 min, technique: knead)

### mdb-53514
**Chilean Empanada** · Pork · area: none
- ingredients: 1 tablespoon Butter, 1 large Onion, 1 tsp minced Garlic, 1 tsp Dried Oregano, 1 tsp Ground Cumin, 1/2 tsp Salt, 1/2 tsp Black Pepper, 1 lb Pork Mince, 1 cup Raisin, 1 cup Black Olive, 3 Large Egg, 1 cup Water, 1 cup Shortening, 5 Cups Plain Flour, 2 tsp Salt, 2 Beaten Egg
- method (6 steps): Make the filling: Melt butter in a large skillet over medium heat. Add onion, garlic, oregano, cumin, salt, and pepper; cook and stir until onion is golden brown, 5 to 7 minutes. Add pork and cook until completely browned and crumbly, 7 to 10 minutes more. Drain fat from the skillet. Stir in raisins, olives, and hard-cooked eggs. Whisk water and cornstarch together in a small bowl; pour into the skillet and stir until liquid thickens. Remove from the heat and set aside. Make the dough: Whisk milk and melted shortening together in a bowl until evenly blended. Stir flour and salt together in a s…
- `cuisine` rule: 'Chilean' (0.60, title mentions 'Chilean')
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 16 ingredients, 80 min, technique: fold each)

### mdb-53515
**Manjar (Dulce de Leche)** · Dessert · area: none
- ingredients: 1 quart Milk, 1 cup Sugar, 1/2 tsp Vanilla Extract, 1/4 tsp Baking Powder
- method (2 steps): Bring milk, sugar, and vanilla extract to a boil in a saucepan over high heat. Reduce heat to medium-low, continue cooking, and continuously stirring until milk has thickened and turned a caramel color, about 1 hour or more. Stir in baking soda. Continue cooking until caramelized milk has reached a pudding consistency. Pour manjar into a bowl and cool completely in the refrigerator.
- `cuisine` rule: none
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 4 ingredients, 70 min, technique: caramelize)

### mdb-53516
**Chilean Dobladitas** · Side · area: none
- ingredients: 4 cups Plain Flour, 1 cup Butter, 1/2 cup Milk, 2 tsp Baking Powder, 1 tsp Salt, 3 tablespoons Butter
- method (4 steps): Preheat the oven to 450 degrees F (230 degrees C). Grease a baking sheet. Whisk flour, 1 cup melted butter, milk, baking powder, and salt together in a bowl until begins to pull together. Turn dough out onto a lightly floured surface; knead until smooth and elastic. Roll dough out to ⅛-inch thickness; cut into 8-inch circles. Brush circles with remaining 3 tablespoons melted butter. Fold each circle in half, then fold in half again to form triangles. Press firmly to seal the layers; place on the prepared baking sheet. Bake in the preheated oven until golden brown, about 15 minutes. Serve warm.
- `cuisine` rule: 'Chilean' (0.60, title mentions 'Chilean')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 6 ingredients, 30 min, technique: fold each, knead)

### mdb-53517
**Pastel de Papas (Chilean Potato Pie)** · Beef · area: none
- ingredients: 5 Cups Potato, 2 tablespoons Butter, To taste Salt, 2 Beaten Egg, 1/2 cup Vegetable Oil, 1 Diced Onion, 1 clove peeled crushed Garlic, 2 diced Tomato, 1 tablespoon Tomato Puree, 1 lb Beef Mince, 2 tablespoons Panquehue Cheese, 1/2 tsp Parsley, 1 pinch Cayenne Pepper, To taste Salt, To taste Black Pepper
- method (7 steps): Place potatoes into a large pot and cover with salted water; bring to a boil. Reduce the heat to medium-low and simmer until tender, about 20 minutes. While the potatoes are cooking, heat oil in a large skillet over medium heat. Add onion; cook and stir until translucent, about 5 minutes, adding garlic for the last minute. Stir in diced tomatoes and tomato paste; cook until tomatoes soften and begin to lose their shape, 3 to 5 minutes. Add ground beef to the skillet; cook and stir until browned and crumbly, about 10 minutes. Stir in Panquehue cheese, parsley, and cayenne pepper; season with sa…
- `cuisine` rule: 'Chilean' (0.60, title mentions 'Chilean')
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 15 ingredients, 115 min)

### mdb-53518
**Empanadas Fritas de Queso** · Vegetarian · area: none
- ingredients: 3 Cups Plain Flour, 1 tsp Baking Powder, 1/2 tsp Salt, 2 tablespoons Lard, 1 cup Milk, 1 beaten Egg, 1 cup Swiss Cheese
- method (5 steps): Sift the flour, baking powder, and salt into a large mixing bowl. Combine the lard and milk in a saucepan, and heat until the milk is hot. Pour the hot milk into the flour mixture, and stir until a dough forms. Turn out onto a floured surface, and knead until smooth and elastic. Cover, and allow to rest for 15 minutes. Preheat oven to 375 degrees F (190 degrees C). Roll the dough out on a floured surface 1/4-inch thick. Cut into 4-inch rounds. Brush the outer edges of each circle with beaten egg, and fill with a small mound of cheese. Fold each circle in half to form a half-moon; press the edg…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'smooth'] (0.50, keywords: crispy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 7 ingredients, 50 min, technique: deep fr, fold each, knead)

### mdb-53519
**Leche Asada** · Dessert · area: none
- ingredients: 1 quart Milk, Zest of 1 Lemon, 2 Cinnamon Stick, 4 Egg, 1/2 cup Sugar
- method (4 steps): Preheat oven to 350 degrees F (175 degrees C). Pour the milk into a saucepan along with the lemon zest and cinnamon sticks. Bring to a simmer over medium-high heat, then reduce heat to low, and cook for 5 minutes. Turn heat off, and allow to steep for 15 minutes. Gently beat the eggs and sugar together until the sugar has dissolved. Slowly beat in 1 cup of the hot milk, a little at a time, until it has been incorporated. Stir the egg mixture back into the hot milk, pour in the pisco, and mix until well combined. Pour the custard through a fine mesh sieve into a 2-quart ceramic casserole dish t…
- `cuisine` rule: none
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 5 ingredients, 65 min)
