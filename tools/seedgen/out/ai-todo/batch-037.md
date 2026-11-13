# AI tagging batch 037

Write `tools/seedgen/tags/ai/batch-037.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53520
**Pastel de Choclo** · Chicken · area: none
- ingredients: 2 Egg, 2 chopped Onion, 2 cloves minced Garlic, 1 tsp Salt, 1/2 tsp Paprika, To taste Black Pepper, 1 lb Beef Mince, 1/2 Chicken, 2 tablespoons Raisin, 2 tablespoons Green Olive, 3 cans Sweetcorn, 2 tsp Basil, 1 tablespoon Butter, 1 cup Milk, 2 tsp Sugar, To taste Salt
- method (7 steps): Place eggs in a saucepan and cover with water. Bring to a boil, remove from heat, and let eggs stand in hot water for 15 minutes. Meanwhile, heat oil in a skillet over medium heat. Add onions, garlic, 1 pinch salt, ¼ teaspoon paprika, and black pepper; cook until fragrant, about 2 minutes. Add beef, remaining 1 teaspoon salt, remaining ¼ teaspoon paprika, and black pepper; cook and stir until beef mostly browned, about 5 minutes. Add chicken, raisins, and olives. Remove eggs from hot water, cool under cold running water, and peel. Roughly chop; add to beef mixture. Keep pino warm. Combine corn…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 16 ingredients, 100 min)

### mdb-53521
**Porotos Granados (Chilean Bean Stew)** · Miscellaneous · area: none
- ingredients: 1 tablespoon Olive Oil, 1 Onion, 2 cups Butternut Squash, 1 Can Great Northern Bean, 1 cup Lima Bean, 3 Cups Chicken Stock, 2 cups Sweetcorn, 2 tbs chopped Basil, 1 Banana Pepper
- method (2 steps): Heat the olive oil in a stock pot over medium heat; add the onion and cover. Cook the onions until soft and translucent, about 5 minutes. Stir the squash, great Northern beans, and lima beans into the pot; pour the chicken stock over the mixture. Cover and cook until the squash is tender and beginning to break apart, 30 to 45 minutes. Stir the corn and basil into the stew; cook until the stew reaches the consistency of pancake batter, about 10 minutes more. Sprinkle the chopped banana pepper over individual portions to serve.
- `cuisine` rule: 'Chilean' (0.60, title mentions 'Chilean')
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy', 'fluffy'] (0.50, keywords: crispy, crunchy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 65 min)

### mdb-53522
**Arroz con Leche Recipe** · Dessert · area: none
- ingredients: 1 cup Rice, 4 Cinnamon Stick, 2 cups Water, 4 cups Milk, Pinch Salt, 2 tablespoons Butter, 2 tablespoons Vanilla Extract, 1 cup Sugar, 12 ounces Condensed Milk
- method (5 steps): In a small pot, add water and cinnamon sticks, bring to a boil and cook for 10 minutes. Set aside and discard cinnamon sticks. Place the rice and the cinnamon water in a large saucepan, over medium heat and cook for 5 minutes. Add salt, butter, vanilla extract, 2 cups of milk, and sugar. Stir well to mix and cook uncovered for approximately 15 minutes. Reduce heat to medium low. Add the remaining milk and condensed milk. Stir with a wooden spoon. Cook for 1 hour and 15 minutes, or until the rice pudding thickens to desire consistency. Stir well and remove from heat, and let it cool at room tem…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 9 ingredients, 185 min, technique: temper)

### mdb-53523
**Colombian Buñuelos Recipe** · Side · area: none
- ingredients: For frying Vegetable Oil, 1 1/2 cup Cornflour, 1/4 cup Tapioca, 1 cup Feta, 1 cup Farmers Cheese, 1 Egg, 1/2 tsp Baking Powder, 2 tablespoons Sugar, Pinch Salt, 5 tablespoons Milk
- method (5 steps): Place all the ingredients, except the oil in a medium bowl and mix well using your hands until soft and smooth dough is obtained. Form small balls using your hands. In a deep pot, heat the vegetable oil to 300°F (Warm, not very hot). Carefully drop the balls in the warm oil and fry for about 3 to 4 minutes or until gilden brown. Remove from the oil and drain on a plate lined with paper towels. Serve. Frying Colombian buñuelos using the right temperature is very important. The oil can't be very hot or very cold. Be sure the oil is heated to 300 to 320 grades F.
- `cuisine` rule: 'Colombian' (0.60, title mentions 'Colombian')
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'smooth'] (0.50, keywords: chewy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 25 min, technique: temper)

### mdb-53524
**Coconut Natilla Recipe** · Dessert · area: none
- ingredients: 3 Cups Milk, 1 cup Cornflour, 2 tablespoons Cornflour, 1 cup Coconut Milk, 1/2 cup Desiccated Coconut, 2 Cinnamon Stick, 1 Can Condensed Milk, 1/2 tsp Vanilla Extract, 1/3 cup Sugar, Pinch Salt, 1 tablespoon Butter, To taste Cinnamon
- method (5 steps): Place 1 cup of milk in a small bowl, add the cornstarch and stir to dissolve it, then set aside. Place the coconut milk and grated coconut in the blender and blend until smooth and set aside. Place the rest of the milk and cinnamon sticks in a medium pot and bring the mixture to boil over medium-low heat. When the milk is a little warm, but not boiling, add the coconut mixture. When the milk starts boiling, add the condensed milk, sugar and salt. Stir well with a wooden spoon. Add the milk and cornstarch mixture and continue stirring constantly. Add the vanilla extract. Reduce the heat to low …
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 12 ingredients, 155 min, technique: temper)

### mdb-53525
**Ají de Aguacate Recipe (Colombian Spicy Avocado Sauce)** · Miscellaneous · area: none
- ingredients: 2 Avocado, 1 Habanero Pepper, 1 Egg, Juice of 2 Lime, To taste Salt, 2 tablespoons White Vinegar, 1 chopped Onion, 2 chopped Spring Onion, 4 tablespoons Coriander
- method (2 steps): Place all the ingredients in a food processor. Process until the mixture is well combined. If the mixture is too thick, add more lime juice until you reach the desired consistency.
- `cuisine` rule: 'Colombian' (0.60, title mentions 'Colombian')
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Miscellaneous guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 50 min)

### mdb-53526
**Colombian Style Stuffed Potatoes** · Starter · area: none
- ingredients: For frying Vegetable Oil, 5 Potato, 1/4 tsp Salt, 1 tablespoon Olive Oil, 1 cup Tomato, 1/3 cup Onion, 1/3 cup Spring Onion, 1 clove peeled crushed Garlic, 1/2 tsp Ground Cumin, 1/2 tsp Sazon Goya with Azafran, 1/4 tsp Salt, 1/4 tsp Black Pepper, 1/2 lb Beef Mince, 1 Egg, 1/4 cup Plain Flour, Pinch Salt, 1/2 tbs Sazon Goya with Azafran, 1/4 cup Milk
- method (11 steps): Peel the potatoes and cut them into chunks, put them in a medium pot and cover with water and ¼ teaspoon of salt. Bring the potatoes to a boil over medium high heat, then reduce the heat to medium and cook until fork tender about 20 minutes. Drain the potatoes and mash with a fork or masher and set aside. Filling:. In a large sauce pan, heat 1 tablespoon olive oil over medium heat and add the onion, tomato, scallions, garlic, cumin, azafran, pepper and salt. Cook for 5 minutes or until the onions are translucent, add the beef and cook stirring occasionally about 10 – 15 minutes. Set aside to c…
- `cuisine` rule: 'Colombian' (0.60, title mentions 'Colombian')
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 18 ingredients, 70 min)

### mdb-53527
**Achiote Oil (Aceite Achiotado) Recipe** · Miscellaneous · area: none
- ingredients: 2 cups Vegetable Oil, 4 tablespoons Achiote Seed
- method (2 steps): Heat the vegetable or olive oil and Achiote seeds in a small skillet over medium heat for about 2 to 3 minutes. Don't let the seeds turn black. Remove the skillet from the heat and let stand for 5 minutes more. Strain the oil and store for up to 15 days at room temperature in a jar with a tight lid.
- `cuisine` rule: none
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 2 ingredients, 20 min, technique: temper)

### mdb-53528
**Chuletas de Cerdo a la Criolla (Pork Chops in Creole Sauce)** · Pork · area: none
- ingredients: 4 Pork Chop, 2 tablespoons Vegetable Oil, 3 Cloves Crushed Garlic, Melted Mustard, 1 tablespoon Ground Cumin, 3 diced Tomato, 2 sliced Onion, 1/4 cup Coriander, To taste Salt, To taste Black Pepper
- method (6 steps): Place the pork chops in a zip lock plastic bag. Add the mustard, cumin, garlic, salt and pepper. Refrigerate for 1 hour or overnight. Be sure the pork chops are evenly covered. In a large skillet, heat the oil over medium heat. Place the pork chops into the skillet and cook for 3 minutes per side. Remove the pork from the pan and keep aside on a warm plate. Add the onions and tomatoes to the same skillet where the pork was browned, adding an additional tablespoon of oil if needed. Cook over high heat for about 5-7 minutes or until browned and softened, stirring frequently to avoid burning. Add…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 115 min)

### mdb-53529
**Almojábanas (Colombian Cheese Bread)** · Side · area: none
- ingredients: 1 1/4 cup Cornmeal, 3 Cups Queso Fresco, 1 cup Mozzarella, 2 tablespoons Butter, 1 tsp Baking Powder, 1/4 tsp Salt, 2 Egg, 4 tablespoons Milk
- method (5 steps): Preheat the oven to 400° F. Mix the masarepa and cheese in a food processor. Add the remaining ingredients and mix well. Divide into 8 equal-size portions and shape into a ball. Place on a greased baking sheet and bake for about 25 to 30 minutes, or until they are golden. Serve warm.
- `cuisine` rule: 'Colombian' (0.60, title mentions 'Colombian')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 8 ingredients, 40 min)

### mdb-53530
**Creamy Mustard Chicken** · Chicken · area: none
- ingredients: 8 Chicken Leg, 1 tsp Paprika, 1 tsp Salt, 1 tsp Black Pepper, 4 tablespoons Olive Oil, 3 Cloves Crushed Garlic, 1/2 cup Onion, 2 cups Chicken Stock, 2 tablespoons Mustard, 1 cup Double Cream, 1 tablespoon Honey, Garnish Parsley
- method (5 steps): Pat the chicken dry and season the pieces with salt, pepper and paprika. Heat a saucepan over medium high heat and add the oil. Let the oil heat for a few seconds. Add the chicken and cook to sear all the sides turning the pieces a couple of times until they are golden browned about 10 minutes. Transfer the browned chicken to a plate and set a side. Add the onions and garlic to the skillet and cook for about 2 minutes or until soft. Add the chicken broth, mustard, honey and cream. Season with salt and black pepper. Stir well and return the chicken pieces to the pan. Cover the pan and cook over…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy'] (0.50, keywords: brothy, creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 85 min, technique: temper)

### mdb-53531
**Chicken in Orange Sauce Recipe (Pollo a la Naranja)** · Chicken · area: none
- ingredients: 4 Chicken Leg, 2 tablespoons Olive Oil, 2 tablespoons Butter, 1/2 cup Onion, 1 Red Pepper, 3 cloves Chopped Garlic, 1 tsp Salt, 1/2 tsp Black Pepper, 1 cup Chicken Stock, 1/2 cup Orange Juice, 3 tablespoons Brown Sugar, 1/4 cup Coriander
- method (4 steps): Place the olive oil and butter in a large sauce pan over medium heat. Add the chopped onions, red bell pepper and garlic. Cook for about 3 minutes, stirring often until the vegetables are soft. Add the chicken legs and season with salt and pepper. Cook for about 1 minute on each side. Add the chicken broth, orange juice and cook for about 2 minutes scraping the bottom of the pan with a wooden spoon. Add the brown sugar and cover the pot. Reduce the heat to medium and cook for about 45 minutes or until chicken is cooked. Spoon the sauce over the chicken and serve over white rice. Garnish with f…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy'] (0.50, keywords: brothy, saucy)
- `moods` rule: ['indulgent', 'light'] (0.50, keywords/category: indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 80 min)

### mdb-53532
**Creamy Corn Soup Recipe** · Vegetarian · area: none
- ingredients: 4 Corn On the Cob, 6 cups Water, 2 Chicken Stock, 2 cloves chopped Garlic, 1/2 tsp Salt, 1/2 tsp Black Pepper, 2 tablespoons Coriander, 1/2 cup Potato, 1/2 cup Spring Onion, 1 cup Double Cream
- method (6 steps): Place the corn, water, chicken or vegetable bouillon, garlic, salt, pepper, cilantro, potatoes and scallions in a large pot and bring to a boil. Reduce heat to medium low and simmer for approximately 4 minutes or until the corn is tender. Remove from the heat. Puruée the soup in a blender and return to the pot, add the cream and heat over medium heat for 15 minutes, stirring occasionally. Pour into bowls, garnish with cilantro and potato sticks. Notes. *Fresh corn or frozen corn will work for this soup recipe. I usually use fresh corn, but I use organic corn kernels in the winter to make this …
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 40 min)

### mdb-53533
**Breaded Steak Recipe (Lomo de Res Apanado)** · Beef · area: none
- ingredients: 2 Lbs Beef, 1 cup Alinos Sauce, 1 cup Plain Flour, 2 cups Breadcrumb, 1 tsp Ground Cumin, 3 Egg, To taste Salt, To taste Black Pepper, 2 tablespoons Parsley, For frying Vegetable Oil
- method (5 steps): Place each piece of steak in between two large pieces of plastic and using a mallet, pound it until it is about ¼″ to ½″ thick. Place the pounded steak in a glass container, add the aliños sauce and let it rest for about 3 hours or overnight in the fridge. Add the flour, bread crumbs, spices and parsley to a plate or bowl. Cover the steak on all sides with the flour mixture, then the eggs, and finally the flour mixture again. Once the pieces of steak are coated, you can either add them right to a pan with oil for cooking or layer them on parchment paper until ready to fry. Add the oil to a lar…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 205 min)

### mdb-53534
**Papas Chorreadas Recipe (Potatoes with Cream and Cheese Sauce)** · Miscellaneous · area: none
- ingredients: 8 Potato, 1 Chicken Stock, Splash Water, 1 tablespoon Butter, 1 tablespoon Vegetable Oil, 1 1/2 cup Tomato, 3 Spring Onion, 1/4 tsp Garlic Powder, 1/4 tsp Ground Cumin, 1/4 tsp Salt, To taste Black Pepper, 1 cup Double Cream, 1 tablespoon chopped Coriander, 1 cup Mozzarella
- method (4 steps): Place the potatoes and chicken bouillon in a medium saucepan. Cover with water and bring to a boil and cook about 30 minutes until tender. Drain and set a side. While the potatoes are cooking, heat the oil and butter in a frying pan over medium heat. Add onion and tomatoes, stir and cook about 7 minutes. Add garlic powder, cumin, salt and pepper. Stir and cook 2 minutes more. Add cream, cilantro and cheese. Mix well and turn down the heat and cook for 3 minutes or until cheese has melted. In a serving dish place the potatoes and pour the sauce on top. Serve them hot.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 14 ingredients, 70 min)

### mdb-53535
**Tamal De Maicena** · Dessert · area: none
- ingredients: 4 cups Milk, 1 knob Butter, 2 1/2 cups Sugar, 2 tsp Vanilla Extract, 2 cups Cornflour, 2 Beaten Egg
- method (7 steps): Preheat the oven at 350F. In a non-stick medium pot, add the milk, butter, sugar, and vanilla; bring to a boil, and reduce heat to low. In a large bowl, add the eggs and the cornstarch and mix well. Slowly add 1 cup of the milk mixture, mixing constantly to temper the eggs. Keep adding more milk until the mixture is soft and has no lumps. ​ Add the mixture to the pot SLOWLY and mix constantly using a wooden spoon. Keep cooking and mixing for a few more minutes until the mixture gets thick, you will know when it is ready when passing a spoon at the bottom of the pot creates a line that separate…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 6 ingredients, 95 min, technique: temper)

### mdb-53536
**Black Beans Hotpot** · Vegetarian · area: none
- ingredients: 400g Black Bean, 1 large Onion, 1 Green Pepper, 1 Red Pepper, 1/3 cup Celery, 4 Cloves Crushed Garlic, 1 1/2 tsp Ground Cumin, 1 tablespoon Oregano, 1 1/2 tsp Salt, 2 tsp Black Pepper, 5 Cups Water
- method (2 steps): Add all the ingredients in the Instant pot, Lock the lid on and set the Instant Pot to High Pressure for 35 minutes. Once the beans are done cooking, let the pressure release naturally for 20 minutes before releasing the remaining pressure. Open and serve! Let the beans get cool completely before saving them in the fridge or freezer.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 11 ingredients, 75 min)

### mdb-53537
**Pan De Yucca** · Dessert · area: none
- ingredients: 3 Cups Yucca, 1 knob Butter, 3/4 cup Sugar, 3 Egg, 1 tsp Vanilla Extract, 1 cup Cream Cheese, 1 cup Plain Flour, 2 tsp Baking Powder, 1/2 tsp Salt
- method (7 steps): Preheat oven to 350 degrees F (175 degrees C). ​ Grease and flour a 12 x 8' pyrex (you can use a smaller pyrex if you prefer the bread to be thicker). Peel and shred the yucca and set aside. In a medium bowl, combine flour, baking powder and salt and set aside. ​ In a large bowl cream the butter with the sugar. Beat in the eggs, one at a time, then stir in the vanilla. Add half of the dry ingredients and mix well, add cream cheese, mix well and, add the other half of the dry ingredients and mix well. With a wooden spoon incorporate the shredded yucca, until well incorporated. Pour or spoon bat…
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crispy'] (0.50, keywords: creamy, crispy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 9 ingredients, 70 min)

### mdb-53538
**Mango Tropical Salsa** · Side · area: none
- ingredients: 1/4 cup Red Onion, 1/4 cup Red Pepper, 2 1/2 cups Tomato, 1 1/2 cups Mango, 1 cup Avocado, 1/4 cup Coriander, 1/3 cup Lime Juice, 1 tsp Salt, 1 tsp Black Pepper
- method (2 steps): In a large bowl, combine all the ingredients together, mix well! Cover and refrigerate for at least 15 min before serving. Serve with chips. I recommend to make this salsa just 15 to 20 minutes before serving, it you make it to early it will get a little to soupy. Have everything chopped and ready and just put it together when your guest arrive.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 50 min)

### mdb-53539
**Picadillo de Vainicas (Green Beans Picadillo)** · Beef · area: none
- ingredients: 1 lb Green Bean, 2 cups Flank Steak, 1/2 cup Onion, 1/2 cup Black Pepper, 3 cloves Garlic, 1 tsp Thyme, 1 tsp Salt, 1/2 tsp Black Pepper, 1/2 cup Water
- method (3 steps): In a medium-size pot over medium heat add some olive oil, onions, pepper, and garlic and cook until onion is translucent. In the meantime, finely chopped the green beans. Add to the pot, the shredded meat, green beans, thyme, salt and pepper, and mix well. Add the water, cover and cook for 15 minutes, uncover and cook for 5 more minutes or until the green beans are soft.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 35 min)
