# AI tagging batch 029

Write `tools/seedgen/tags/ai/batch-029.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53358
**Chicken Mandi** · Chicken · area: India
- ingredients: 1 Chicken, 2 cups Basmati Rice, 4 cups Water, 1 large Onion, 4 cloves Garlic, 2 Green Chilli, 1 ½ tsp Salt, 3 tablespoons Vegetable Oil, 1 tablespoon Turmeric, 1 teaspoon Coriander, ½ tbsp Cardamom, ¼ teaspoon Clove, 1/2 tsp Cinnamon, 1 tsp Black Pepper, 2 Bay Leaf
- method (9 steps): Clean and cut the chicken; marinate briefly with salt, turmeric and a little oil. Rinse and soak basmati rice 20–30 minutes. In a large pot, heat ghee/oil. Fry chopped onion until golden. Add minced garlic and green chillies and fry 1–2 min. Add whole spices (cardamom, cloves, cinnamon, bay leaves) and ground spices (coriander, cumin). Stir until fragrant. Add chicken pieces, brown lightly and add enough water/chicken stock to cover. Simmer until chicken is nearly cooked. Remove chicken; measure remaining liquid and add soaked rice. Bring to a boil, then reduce heat, cover and cook rice until …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 15 ingredients, 75 min)

### mdb-53359
**Beef Mandi** · Beef · area: India
- ingredients: 1 kg Basmati Rice, 5 Cups Beef Stock, 2 medium Onion, 5 chopped cloves Garlic, 2 Green Chilli, 1 small Tomato, 2 1/2 Tsp Salt, 3 tablespoons Vegetable Oil, 1 ½ tsp Turmeric, 1/2 tsp Cardamom, 1/2 tsp Clove, 1/2 tsp Bay Leaf
- method (12 steps): Wash the beef and cut into large pieces. Season lightly with salt and turmeric. Heat ghee/oil in a large pot. Add sliced onions and sauté until light golden. Add garlic, green chilies, and tomato; cook until softened. Add the mandi spice mix: coriander, cumin, black pepper, cinnamon, cardamom, cloves, and bay leaves. Add beef pieces and stir on medium heat until the meat is well coated with spices. Pour in water or beef stock. Cover and simmer until beef is tender (about 1.5–2 hours depending on cut). Remove beef carefully and set aside. Strain and measure the broth. Add washed, soaked basmati…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'fluffy'] (0.50, keywords: brothy, fluffy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 12 ingredients, 130 min)

### mdb-53360
**Caribbean Tamarind balls** · Dessert · area: Jamaican
- ingredients: 16 ounces Tamarind Paste, 1 1/2 cups Sugar
- method (3 steps): Add tamarind pulp and 1 cup granulated sugar to a bowl and mash together with a spoon or fork. Take small amounts of the tamarind and sugar mix and shape them into small balls by rolling them in your hands. Make them the size of a marble or slightly bigger, as you like. Add the remaining sugar to a flat surface, like a plate or a sheet pan. Roll the tamarind balls in granulated sugar until they're well-coated. You can eat the tamarind balls immediately, or you can let them set for a few hours or overnight. Allowing them to set will give them a firmer texture and more crystallized sugar coating…
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 2 ingredients, 520 min)

### mdb-53361
**Callaloo and SaltFish** · Side · area: Jamaican
- ingredients: 1/2 lb Salt Cod, 4 Bacon, 525g Callaloo, 1 chopped Onion, 2 chopped Spring Onion, 2 cloves minced Garlic, 1 chopped Scotch Bonnet, 2 chopped Tomato, 2 sprigs Thyme, 1/4 tsp Black Pepper
- method (5 steps): Soak salted fish in water overnight. Next, heat salted fish in water on stove until water boils. You should see a foam on top. Remove from heat and drain. Set aside and shred salted fish once it cools. Cook bacon in skillet over medium heat until crispy. Remove bacon from heat and drain the majority of the bacon grease, leaving about 1 tablespoon in the skillet. Add yellow onion, green onion, scotch bonnet pepper, and garlic to the skillet and stir. Cook for about 2 minutes or until onions soften. Add salted fish to skillet and stir. Cook for about a minute. Next, add callaloo, roma tomatoes, …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 505 min)

### mdb-53362
**Jamaican Curry Shrimp Recipe** · Seafood · area: Jamaican
- ingredients: 1 lb Prawn, 2.5 tbsp Curry Powder, 1 tsp All Purpose Seasoning, 2 tablespoons Olive Oil, 1 sliced Onion, 1 sliced Red Pepper, 1 sliced Green Pepper, 1 sliced Scotch Bonnet, 3 cloves Chopped Garlic, 380g Coconut Milk, 1/2 tbs Tomato Ketchup, 4 sprigs Thyme, To taste Salt, To taste Black Pepper
- method (5 steps): Season shrimp with 1 Tablespoon of curry powder and all-purpose seasoning and set aside for about 10 minutes while you prepare the other ingredients like chopping your onions, peppers, and garlic. Heat 2 Tablespoons of olive oil in a large skillet over medium heat. Add sliced yellow onion, red bell pepper, green bell pepper, scotch bonnet pepper, if using, and chopped garlic and stir for 5 minutes, until peppers are slightly softened. Add 1.5 Tablespoons of curry powder to the skillet and stir for an additional minute. Then add coconut milk, seasoned shrimp, ketchup, and thyme, making sure the…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 14 ingredients, 50 min)

### mdb-53363
**Jamaican Cornmeal Porridge** · Breakfast · area: Jamaican
- ingredients: 4 cups Water, 380g Coconut Milk, 1 cup Cornmeal, 1 1/2 tsp Vanilla Extract, 1/2 tsp Cinnamon, 1/2 tsp Ground Nutmeg, 1/4 tsp Ground Allspice, 1/2 cup Condensed Milk
- method (5 steps): Add 2 ½ cups water, 1 can coconut milk to a 4 QT heavy bottomed pot. Bring to a boil over medium-high heat. Meanwhile, add 1 cup cornmeal and 1 ½ cup water to a large mixing cup and whisk until smooth. Once the pot begins to boil, whisk in cornmeal mixture and continue to whisk for about 1 minute, ensuring there are no lumps. Reduce heat to low and cover with a tight fitting lid. Cook over low heat for 15-20 minutes, stirring occasionally. When there is about 5 minutes left, stir in vanilla extract, cinnamon, nutmeg, and all-spice. Remove from heat and sweeten with condensed milk. Serve and en…
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 8 ingredients, 40 min)

### mdb-53364
**Jamaican Steamed Cabbage** · Side · area: Jamaican
- ingredients: 1/2 Cabbage, 2 sliced Carrot, 1 chopped Tomato, 1 chopped Onion, 4 Cloves Chopped Garlic, 4 Chopped Spring Onion, 4 sprigs Thyme, 1/2 Scotch Bonnet, 2 tablespoons Water, 2 tablespoons Olive Oil, 4 tablespoons Butter, 2 tsp Salt, 1 tsp Black Pepper
- method (3 steps): Add all the ingredients to a large pan over medium heat and cover with a lid. Cook on medium heat for 10 minutes, stirring occasionally. After 10 minutes, reduce the heat to low and continue to cook for an additional 5 minutes, until the cabbage is soft and tender. Remove from the heat and remove the stalks of thyme before serving.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent', 'light'] (0.50, keywords/category: indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 13 ingredients, 45 min)

### mdb-53365
**Chinese Orange Chicken** · Chicken · area: Chinese
- ingredients: Zest of 1 Orange, 1/4 cup Orange Juice, 1/4 cup Soy Sauce, 1/4 cup Water, 1/3 cup Rice Vinegar, 1 tablespoon Cornflour, 1 tablespoon Sesame Oil, 1/2 cup Sugar, 650g Chicken Thigh, 2 large Egg, 1 tsp Salt, 1/4 tsp Black Pepper, 1/2 cup Cornflour, 1/2 cup Plain Flour, 2 cups Vegetable Oil, 2 cloves chopped Garlic, 1 chopped Shallot, Sliced Spring Onion, Garnish Sesame Seed, To serve Rice
- method (14 steps): Make the orange sauce:. Whisk together sauce ingredients in a medium bowl. Set aside. Prep the chicken:. Cut chicken into about 1-inch cubes. Whisk eggs with salt and black pepper in a bowl and add chicken. Stir together. In a separate bowl, whisk together flour and cornstarch. Remove chicken from eggs with a slotted spoon or tongs, letting excess egg drain off, then transfer to cornstarch mixture and coat well. Fry the chicken:. Add oil to a large 10- to 12-inch skillet. Heat over medium-high heat until it reaches 350°F. If you don’t have a thermometer, you can also test the temperature by sp…
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 14 steps, 20 ingredients, 55 min)

### mdb-53366
**Beef and Broccoli Stir-Fry** · Beef · area: Chinese
- ingredients: 1 tsp Soy Sauce, 1 tsp Sherry, 1/2 tsp Cornflour, 1/8 teaspoon Black Pepper, 1 lb Sirloin Steak, 2 tablespoons Oyster Sauce, 1 tsp Sherry, 1 tablespoon Soy Sauce, 1/4 cup Chicken Stock, 1 lb Broccoli, 2 tablespoons Vegetable Oil, 2 cloves minced Garlic, 1 tsp Cornflour, 1 tablespoon Water
- method (14 steps): Marinate the beef:. Stir together the beef marinade ingredients (1 teaspoon soy sauce, 1 teaspoon Chinese rice wine, 1/2 teaspoon cornstarch, 1/8 teaspoon black pepper) in a medium bowl. Add the beef slices and stir until coated. Let stand for 10 minutes. Prepare the sauce:. Stir together the sauce ingredients (2 tablespoons oyster sauce, 1 teaspoon Chinese rice wine, 1 teaspoon soy sauce, 1/4 cup chicken broth) in a small bowl. Set aside. Blanch or steam the broccoli:. Bring a pot of water to a boil. Add the broccoli and cook until crisp-tender, about 2 minutes. Drain thoroughly. Stir-fry the…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'crispy', 'saucy'] (0.50, keywords: brothy, crispy, saucy)
- `moods` rule: ['hearty', 'light'] (0.50, keywords/category: hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 14 steps, 14 ingredients, 45 min)

### mdb-53367
**Chicken Fried Rice** · Chicken · area: Chinese
- ingredients: 1 lb Chicken Thigh, 1 tsp Salt, 3 tablespoons Vegetable Oil, 3 Large Egg, 2/3 Cup Onion, 2 cloves minced Garlic, 2 tsp Ground Ginger, 1 large Carrot, 2/3 Cup Pea, 4 cups Jasmine Rice, 2 sliced Spring Onion, 1/2 tsp Five Spice Powder, 2.5 tbsp Soy Sauce, 1 tsp Sesame Oil
- method (17 steps): Fried rice is best made with leftover rice that's at least a day old. Otherwise it becomes gummy in the skillet. If you don’t have any leftover rice from the night before, cook a batch of rice and spread it on a large baking sheet or several large plates. Let the rice dry out for about 1 to 2 hours before using it for fried rice. Rice sticks to the pan very easily, so make sure to use a wok or pan that doesn’t have a sticky surface. I usually cook stir-fries in my seasoned carbon steel wok, but cast iron or nonstick pans work well, too. You might need to add a little more oil if things aren’t …
- `flavor.sweet` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 17 steps, 14 ingredients, 120 min)

### mdb-53368
**Singapore Noodles with Shrimp** · Seafood · area: Chinese
- ingredients: 2 tsp Sesame Oil, 2 tablespoons Soy Sauce, 2 tablespoons Rice Vinegar, 6 oz Rice Noodle, 2 large Egg, 2 tblsp Ground Ginger, 1 clove finely chopped Garlic, 2 Carrot, 1 sliced Jalapeno, 1/2 Onion, 1/2 tsp Salt, 4 oz Ham, 1/2 Chinese Cabbage, 4 Spring Onion, 1/2 Red Pepper, 2 tsp Curry Powder, 1/2 lb Prawn, 2 tablespoons Coriander
- method (18 steps): For the sweet onion, look for Vidalia, OSO Sweet, or Walla Walla. The super-sweet varieties are more suited to this stir-fry because at the end of cooking, the onion still has a slight crunch. Make the sauce:. In a bowl, combine the sesame oil, soy sauce, and rice vinegar. Cook the rice noodles:. Bring a large saucepan of water to a boil, add the noodles, and use tongs to turn them so they are submerged. Cook for 2 minutes, or until they are tender but still have some bite (they will cook a little more once you add them to the skillet). Drain, rinse with cold water, and use scissors to snip th…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crunchy', 'saucy'] (0.50, keywords: chewy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 18 steps, 18 ingredients, 40 min)

### mdb-53369
**Silken Tofu with Sesame Soy Sauce** · Vegetarian · area: Chinese
- ingredients: 16 ounces Silken Tofu, 3 tablespoons Soy Sauce, 2 tablespoons Chinese Sesame Sauce, 1 sliced Spring Onion, 2 tsp Sesame Seed
- method (5 steps): Prepare the tofu:. Drain the tofu and gently remove it from its packaging onto a large plate. Carefully slice the tofu into 1/2-inch slabs widthwise. With the palm of your hands, gently push the sliced tofu sidewise so that they fan out over the plate. Garnish with toppings and serve:. Drizzle the soy sauce and sesame sauce on top. Then garnish it with scallions and sesame seeds, and serve. Tightly cover leftovers and refrigerate for up to 2 days. You can enjoy it cold straight out of the fridge or you can reheat it by microwaving in 30-second increments until warmed through.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 5 ingredients, 45 min)

### mdb-53370
**Egg Foo Young** · Seafood · area: Chinese
- ingredients: 1 cup Beef Stock, 1 tablespoon Soy Sauce, 1 tablespoon Shaoxing Wine, 1 tablespoon Oyster Sauce, 1/2 tsp Black Pepper, 1 tablespoon Cornflour, 1 tablespoon Water, 1 tablespoon Cornflour, 1 tablespoon Water, 8 large Egg, 1/2 tsp Salt, 1/4 tsp Sugar, 1 Spring Onion, 1 cup Mung Bean Sprout, 20 Prawn, 3 Cups Vegetable Oil, 2 cups Jasmine Rice
- method (13 steps): Make the gravy:. In a small saucepan, add the beef stock, soy sauce, Shaoxing wine, oyster sauce, and white pepper powder over medium heat. Whisk together and bring to a simmer. Combine the cornstarch and water in a small bowl and whisk to dissolve. Add to the saucepan and whisk until the gravy thickens and coats the back of the spoon, 2 to 3 minutes. Cover the saucepan with a lid and keep it warm on the lowest possible heat. Make the egg foo young batter:. In a medium bowl, whisk together the cornstarch and water until dissolved. Add the eggs, salt, and sugar. Whisk until well combined and th…
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 13 steps, 17 ingredients, 45 min)

### mdb-53371
**Sichuan Style Stir-Fried Chinese Long Beans** · Vegetarian · area: Chinese
- ingredients: 1/2 lb Chinese Long Bean, 1 tablespoon Groundnut Oil, 6 Dried Chilli, 1 tsp Sichuan Pepper, 1/4 tsp Salt, 1/2 tsp Sugar, 1 tablespoon Sesame Oil, Splash Soy Sauce
- method (2 steps): Chinese long beans can be found in both green and purple varieties. Both have similar flavors and textures, and either kind can be used for this recipe. If you don't have a wok, use a sturdy, large sauté pan that has at least a two-inch lip.
- `textures` rule: ['crispy', 'crunchy', 'saucy'] (0.50, keywords: crispy, crunchy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 45 min)

### mdb-53372
**Chinese Tomato Egg Stir Fry** · Vegetarian · area: Chinese
- ingredients: 1 lb Tomato, 1 tablespoon Vegetable Oil, 5 Large Egg, 1 tsp Sesame Oil, 2 tsp Chicken Stock, 2 tsp Sugar, 1/2 tsp Black Pepper, 1/4 tsp Salt, 1 Spring Onion, 2 cups Jasmine Rice
- method (9 steps): You can use chicken broth in place of the chicken bouillon powder. Add 1/4 cup of broth followed by 2 teaspoons of cornstarch dissolved in 1 tablespoPrepare the tomatoes:. Slice the tomatoes in half. Remove the tough stem from each half that connects to the vine. Cut each half into equal thirds (you’ll get 6 slices from each tomato). Make the soft scrambled eggs:. In a cold, 8 to 10-inch nonstick skillet, add the vegetable oil and beaten eggs. Turn the heat to medium. Once a thin layer of eggs is just beginning to cook on the bottom, push the eggs in one direction to create layers of scrambled…
- `textures` rule: ['brothy'] (0.50, keywords: brothy)
- `moods` rule: ['light'] (0.50, keywords/category: light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 10 ingredients, 35 min)

### mdb-53373
**Air Fryer Egg Rolls** · Side · area: Chinese
- ingredients: 1 tablespoon Olive Oil, 1 lb Pork Mince, 1 clove peeled crushed Garlic, 1 tablespoon Ginger, 1 medium Carrot, 3 chopped Spring Onion, 3 Cups Cabbage, 1 tablespoon Soy Sauce, 1 tablespoon Rice Vinegar, 12 Egg Roll Wrapper, For brushing Vegetable Oil, To serve Duck Sauce, To serve Plum Sauce, To serve Soy Sauce
- method (12 steps): Alternative Pan Fry Method: If you don’t have access to an air fryer, you can make these egg rolls using a traditional pan fry method. Add enough oil to a medium skillet with high walls so the oil is about 1/2 inch up the side of the skillet. Heat oil on medium high heat until it reaches 350°F. Add egg rolls and fry for 3 to 4 minutes, flip, and fry for another 3 to 4 minutes until golden brown. Remove and let them drain and cool on a few paper towels. Cook the filling:. In a large skillet over medium heat, add the olive oil along with the ground pork or chicken. Break apart the meat with a sp…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 14 ingredients, 50 min)

### mdb-53374
**Sichuan Eggplant** · Vegetarian · area: Chinese
- ingredients: 1.5 pounds sliced Aubergine, 2 tablespoons Groundnut Oil, 1/4 cup Chicken Stock, 2 tsp Sugar, 1/2 tsp Soy Sauce, 1 ½ tbsp Chilli Bean Paste, 2 tsp Sichuan Pepper, 2 tsp Ginger, 5 cloves Garlic, 1 tsp Cornflour, 2 tsp Cider Vinegar, 4 Chopped Spring Onion, Garnish Coriander
- method (20 steps): This recipe calls for asian eggplants, or Japanese eggplants. They are long and thin compared to a European or globe eggplant, and much more tender and delicate. If you can't find them you can substitute globe eggplant, but the dish is really best with the asian eggplant. *A lot of grocery stores have Asian ingredient aisles now. You should be able to find chili-bean paste, a mixture of preserved chilies mixed with mashed soybeans, there or at any Asian market. (Do not confuse with black bean paste or chili-garlic paste.) **Sichuan peppercorns are available at some stores and online for quite …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 20 steps, 13 ingredients, 35 min)

### mdb-53375
**Shrimp With Snow Peas** · Seafood · area: Chinese
- ingredients: 2 tsp Cornflour, 1 tablespoon Sherry, 1/2 tsp Salt, 1 lb Prawn, 2 tablespoons Groundnut Oil, 1 tablespoon Ground Ginger, 3 cloves Chopped Garlic, 1/2 lb Snow Pea, 2 tsp Soy Sauce, 1/4 cup Chicken Stock, 4 Spring Onion, 2 tsp Sesame Oil
- method (9 steps): You can also use sugar snap peas for this recipe. Save prep time by prepping the peas, ginger, and garlic while the shrimp is marinating. Marinate the shrimp:. Mix all marinade ingredients in a large bowl, then add the shrimp. Toss to coat. Let sit for 15 to 20 minutes while you prep the peas, ginger, and garlic. Stir-fry the ginger and garlic:. Heat a wok or large sauté pan over high heat for 1 minute. Add the peanut oil and let it get hot, about 30 seconds. Add the ginger and garlic and toss to combine. Stir-fry for about 30 seconds. Add the shrimp, snow peas, soy sauce, stock:. Add the shri…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 12 ingredients, 45 min)

### mdb-53376
**Sweet and Sour Chicken** · Chicken · area: Chinese
- ingredients: 1 lb Chicken Thigh, 1 large Egg White, 1 tsp Salt, 2 tsp Cornflour, 10 oz Pineapple Chunk, 1/4 cup Pineapple Juice, 1/4 cup White Vinegar, 1/4 cup Tomato Ketchup, 3 tablespoons Brown Sugar, 4 tsp Vegetable Oil, 1 chopped Red Pepper, 1 chopped Yellow Pepper, 1 tsp Ginger
- method (16 steps): Coat the chicken with egg white:. In a bowl, combine the chicken with the egg white, 1/2 teaspoon kosher salt, and cornstarch. Stir to coat the chicken evenly. Let sit for 15 minutes at room temperature or up to overnight in the refrigerator. Make the sweet and sour sauce:. Whisk together the pineapple juice, vinegar, ketchup, 1/2 teaspoon kosher salt, and brown sugar. Stir-fry the chicken over high heat:. Heat a large frying pan or wok over high heat until a bead of water instantly sizzles and evaporates. Pour in 1 tablespoon of cooking oil and swirl to coat. It's important that the pan is ve…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'light'] (0.50, keywords/category: comfort, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 16 steps, 13 ingredients, 45 min)

### mdb-53377
**Napa Cabbage with Dried Shrimp** · Seafood · area: Chinese
- ingredients: 2 tablespoons Dried Shrimp, 3/4 cup Water, 1 head Chinese Cabbage, 2 tablespoons Groundnut Oil, 4 Chopped Spring Onion, 1 tablespoon Ginger, 1 tablespoon Soy Sauce, 1 tablespoon Water, 2 tsp Cornflour, 1 tsp Salt, 1/2 tsp Black Pepper
- method (19 steps): Dried shrimp gives this Chinese dish a punch of salty umami flavor. You can find it at an Asian grocery store in the frozen or refrigerated section. Look for small-sized dried shrimp, about a 1/4-inch in size. If you use medium or large dried shrimp, hydrate the shrimp with more water (1 cup for medium-sized shrimp, 1 1/4 cup for large) and for longer time (45 to 60 minutes), then chop it up into smaller 1/4-inch chunks. To make this recipe vegetarian, omit the dried shrimp and use four or five dried shiitake mushrooms, rehydrated, and sliced thin. Rehydrate the dried shrimp:. Place the dried …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 19 steps, 11 ingredients, 115 min)
