# AI tagging batch 003

Write `tools/seedgen/tags/ai/batch-003.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53019
**Pierogi (Polish Dumplings)** · Side · area: Polish
- ingredients: 2 tbs Butter, 1/3 cup Onion, 1 1/2 cups Sauerkraut, 3 tbs Butter, 1/2 cup Onion, 2 cups Potato, 3 Egg, 1 pot Sour Cream, 3 cups Plain Flour, 1/4 tsp Salt, 1 tbs Baking Powder
- method (5 steps): To prepare the sauerkraut filling, melt the butter in a skillet over medium heat. Stir in the onion, and cook until translucent, about 5 minutes. Add the drained sauerkraut and cook for an additional 5 minutes. Season to taste with salt and pepper, then remove to a plate to cool. For the mashed potato filling, melt the butter in a skillet over medium heat. Stir in the onion, and cook until translucent, about 5 minutes. Stir into the mashed potatoes, and season with salt and white pepper. To make the dough, beat together the eggs and sour cream until smooth. Sift together the flour, salt, and b…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy', 'smooth'] (0.50, keywords: creamy, fluffy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 45 min, technique: knead)

### mdb-52804
**Poutine** · Miscellaneous · area: Canadian
- ingredients: Dash Vegetable Oil, 1 Can Beef Gravy, 5 thin cut Potato, 2 cups Cheese Curd
- method (6 steps): Heat oil in a deep fryer or deep heavy skillet to 365°F (185°C). Warm gravy in saucepan or microwave. Place the fries into the hot oil, and cook until light brown, about 5 minutes. Remove to a paper towel lined plate to drain. Place the fries on a serving platter, and sprinkle the cheese over them. Ladle gravy over the fries and cheese, and serve immediately.
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 4 ingredients, 15 min, technique: deep fr)

### mdb-53046
**Portuguese custard tarts** · Dessert · area: Portuguese
- ingredients: 2 tbs Plain Flour, 2 tbs Icing Sugar, 375g Puff Pastry, 250g Sugar, 2 strips Lemon Zest, 1 Stick Cinnamon, 2 Egg, 4 Egg Yolk, 50g Cornflour, 500ml Milk, Pod of Vanilla Extract, To serve Cinnamon
- method (10 steps): Roll the pastry Mix the flour and icing sugar, and use this to dust the work surface. Roll the pastry out to make a 45 x 30cm rectangle. Roll up lengthways to create a long sausage shape. Cutting pastry into rounds Cut the pastry into 24 wheels, about 1-2cm thick. Roll out each pastry portion Roll each wheel lightly with the rolling pin to fit 2 x 12-hole non-stick fairy cake tins. Press pastry into the tin Press the pastry circles into the tins and mould into the tins to make thin cases. Chill until needed. Make the infused syrup Heat the oven to 220C/fan 200C/gas. Make a sugar syrup by bring…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky', 'smooth'] (0.50, keywords: creamy, flaky, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 12 ingredients, 40 min)

### mdb-53027
**Koshari** · Vegetarian · area: Egyptian
- ingredients: 1 1/2 cups Brown Lentil, 1 1/2 cups Rice, 1/2 tsp Coriander, 2 cups Macaroni, Can Chickpea, 1 large Onion, Sprinking Salt, 1/2 cup Vegetable Oil
- method (10 steps): Cook the lentils. Bring lentils and 4 cups of water to a boil in a medium pot or saucepan over high heat. Reduce the heat to low and cook until lentils are just tender (15-17 minutes). Drain from water and season with a little salt. (Note: when the lentils are ready, they should not be fully cooked. They should be only par-cooked and still have a bite to them as they need to finish cooking with the rice). Now, for the rice. Drain the rice from its soaking water. Combine the par-cooked lentils and the rice in the saucepan over medium-high heat with 1 tbsp cooking oil, salt, pepper, and coriande…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 8 ingredients, 75 min, technique: caramelize)

### mdb-53134
**Empanadas** · Beef · area: Argentina
- ingredients: 500g Plain Flour, 200g Butter, 120ml Water, 1 tsp Salt, 500g Beef Mince, 2 chopped Onion, 4 Chopped Egg, 100g Green Olive, 1 teaspoon Ground Cumin, 1 teaspoon Paprika, To taste Salt, To taste Black Pepper
- method (7 steps): Make the Dough: Mix flour and salt in a large bowl. Add butter, using your fingers to blend into a crumbly texture. Gradually add water, mixing until a dough forms. Wrap and chill for 30 minutes. Prepare the Filling: Cook onions in a pan until translucent. Add ground beef, cooking until browned. Stir in spices, then remove from heat. Once cooled, mix in eggs and olives. Assemble: Roll out the dough and cut into circles. Place a spoonful of filling in each, fold over, and seal the edges. Cook: Bake at 200°C (400°F) for 20-25 minutes, or until golden. Pro Tips:. For a flakier crust, incorporate …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 12 ingredients, 75 min)

### mdb-52764
**Garides Saganaki** · Seafood · area: Greek
- ingredients: 500g Prawn, 3 tablespoons Olive Oil, 1 Onion, pinch Parsley, 250ml White Wine, 1 (400g) tin Chopped Tomatoes, 1/2 teaspoon Garlic, 1 (200g) pack Feta
- method (5 steps): Place the prawns in a pot and add enough water to cover. Boil for 5 minutes. Drain, reserving the liquid, and set aside. Heat 2 tablespoons of oil in a saucepan. Add the onion; cook and stir until soft. Mix in the parsley, wine, tomatoes, garlic and remaining olive oil. Simmer, stirring occasionally, for about 30 minutes, or until the sauce is thickened. While the sauce is simmering, the prawns should become cool enough to handle. First remove the legs by pinching them, and then pull off the shells, leaving the head and tail on. When the sauce has thickened, stir in the prawns. Bring to a simm…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 8 ingredients, 60 min)

### mdb-52765
**Chicken Enchilada Casserole** · Chicken · area: Mexican
- ingredients: 14 oz jar Enchilada Sauce, 3 Cups Shredded Monterey Jack Cheese, 6 Corn Tortilla, 2 Chicken Breast
- method (8 steps): Cut each chicken breast in about 3 pieces, so that it cooks faster and put it in a small pot. Pour Enchilada sauce over it and cook covered on low to medium heat until chicken is cooked through, about 20 minutes. No water is needed, the chicken will cook in the Enchilada sauce. Make sure you stir occasionally so that it doesn't stick to the bottom. Remove chicken from the pot and shred with two forks. Preheat oven to 375 F degrees. Start layering the casserole. Start with about ¼ cup of the leftover Enchilada sauce over the bottom of a baking dish. I used a longer baking dish, so that I can pu…
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 4 ingredients, 55 min)

### mdb-52767
**Bakewell tart** · Dessert · area: British
- ingredients: 175g/6oz Plain Flour, 75g/2½oz Butter, 2-3 tbsp Water, 1 tbsp Raspberry Jam, 125g/4½oz Butter, 125g/4½oz Sugar, 125g/4½oz Ground Almond, 1 Egg, ½ tsp Almond Extract, 50g/1¾oz Flaked Almond
- method (7 steps): To make the pastry, measure the flour into a bowl and rub in the butter with your fingertips until the mixture resembles fine breadcrumbs. Add the water, mixing to form a soft dough. Roll out the dough on a lightly floured work surface and use to line a 20cm/8in flan tin. Leave in the fridge to chill for 30 minutes. Preheat the oven to 200C/400F/Gas 6 (180C fan). Line the pastry case with foil and fill with baking beans. Bake blind for about 15 minutes, then remove the beans and foil and cook for a further five minutes to dry out the base. For the filing, spread the base of the flan generously…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'flaky'] (0.50, keywords: crunchy, flaky)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 10 ingredients, 105 min, technique: make the pastry, rub in)

### mdb-52768
**Apple Frangipan Tart** · Dessert · area: British
- ingredients: 175g/6oz Digestive Biscuit, 75g/3oz Butter, 200g/7oz Cooking Apple, 75g/3oz Butter, 75g/3oz Sugar, 2 Egg, 75g/3oz Ground Almond, 1 tsp Almond Extract, 50g/1¾oz Flaked Almond
- method (7 steps): Preheat the oven to 200C/180C Fan/Gas 6. Put the biscuits in a large re-sealable freezer bag and bash with a rolling pin into fine crumbs. Melt the butter in a small pan, then add the biscuit crumbs and stir until coated with butter. Tip into the tart tin and, using the back of a spoon, press over the base and sides of the tin to give an even layer. Chill in the fridge while you make the filling. Cream together the butter and sugar until light and fluffy. You can do this in a food processor if you have one. Process for 2-3 minutes. Mix in the eggs, then add the ground almonds and almond extrac…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'fluffy'] (0.50, keywords: creamy, crunchy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 9 ingredients, 65 min)

### mdb-52769
**Kapsalon** · Lamb · area: Netherlands
- ingredients: 250 Grams Fries, 500 Grams Doner Meat, Topping Garlic Sauce, Topping Hot Sauce, 1 Bulb Lettuce, 1 Tomato, 3rd Cucumber, 100 Grams Gouda Cheese
- method (6 steps): Cut the meat into strips. Heat oil in a pan and fry the strips for 6 minutes until it's ready. Bake the fries until golden brown in a deep fryrer. When ready transfer to a backing dish. Make sure the fries are spread over the whole dish. Cover the fries with a new layer of meat and spread evenly. Add a layer of cheese over the meat. You can also use grated cheese. When done put in the oven for a few minutes until the cheese is melted. Chop the lettuce, tomato and cucumber in small pieces and mix together. for a basic salad. As extra you can add olives jalapenos and a red union. Dived the salad…
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 30 min, technique: deep fr)

### mdb-52771
**Spicy Arrabiata Penne** · Vegetarian · area: Italian
- ingredients: 1 pound Penne Rigate, 1/4 cup Olive Oil, 3 cloves Garlic, 1 tin Chopped Tomatoes, 1/2 teaspoon Chilli Flakes, 1/2 teaspoon Italian Seasoning, 6 leaves Basil, sprinkling Parmesan
- method (3 steps): Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes. In a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil. Drain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basi…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 8 ingredients, 35 min)

### mdb-52772
**Teriyaki Chicken Casserole** · Chicken · area: Japanese
- ingredients: 3/4 cup Soy Sauce, 1/2 cup Water, 1/4 cup Brown Sugar, 1/2 teaspoon Ground Ginger, 1/2 teaspoon Garlic, 4 Tablespoons Cornflour, 2 Chicken Breast, 1 (12 oz.) Stir Fry Vegetable, 3 cups Brown Rice
- method (6 steps): Preheat oven to 350° F. Spray a 9x13-inch baking pan with non-stick spray. Combine soy sauce, ½ cup water, brown sugar, ginger and garlic in a small saucepan and cover. Bring to a boil over medium heat. Remove lid and cook for one minute once boiling. Meanwhile, stir together the corn starch and 2 tablespoons of water in a separate dish until smooth. Once sauce is boiling, add mixture to the saucepan and stir to combine. Cook until the sauce starts to thicken then remove from heat. Place the chicken breasts in the prepared pan. Pour one cup of the sauce over top of chicken. Place chicken in ov…
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 9 ingredients, 80 min)

### mdb-52773
**Honey Teriyaki Salmon** · Seafood · area: Japanese
- ingredients: 1 lb Salmon, 1 tablespoon Olive Oil, 2 tablespoons Soy Sauce, 2 tablespoons Sake, 4 tablespoons Sesame Seed
- method (3 steps): Mix all the ingredients in the Honey Teriyaki Glaze together. Whisk to blend well. Combine the salmon and the Glaze together. Heat up a skillet on medium-low heat. Add the oil, Pan-fry the salmon on both sides until it’s completely cooked inside and the glaze thickens. Garnish with sesame and serve immediately.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 5 ingredients, 40 min)

### mdb-52774
**Pad See Ew** · Chicken · area: Thai
- ingredients: 6oz/180g Rice Noodle, 2 tbsp Dark Soy Sauce, 2 tbsp Oyster Sauce, 2 tsp Soy Sauce, 2 tsp White Vinegar, 2 tsp Sugar, 2 tbsp Water, 2 tbsp Groundnut Oil, 2 cloves Garlic, 1 cup Chicken, 1 Egg, 4 cups Chinese Broccoli
- method (4 steps): Mix Sauce in small bowl. Mince garlic into wok with oil. Place over high heat, when hot, add chicken and Chinese broccoli stems, cook until chicken is light golden. Push to the side of the wok, crack egg in and scramble. Don't worry if it sticks to the bottom of the wok - it will char and which adds authentic flavour. Add noodles, Chinese broccoli leaves and sauce. Gently mix together until the noodles are stained dark and leaves are wilted. Serve immediately!
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crunchy', 'saucy'] (0.50, keywords: chewy, crunchy, saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Chicken guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 55 min)

### mdb-52775
**Vegan Lasagna** · Vegan · area: Italian
- ingredients: 1 cups Green Red Lentil, 1 Carrot, 1 Onion, 1 small Courgette, sprinking Coriander, 150g Spinach, 10 Lasagne Sheet, 35g Vegan Butter, 4 tablespoons Plain Flour, 300ml Soya Milk, 1.5 teaspoons Mustard, 1 teaspoon White Vinegar
- method (6 steps): Preheat oven to 180 degrees celcius. Boil vegetables for 5-7 minutes, until soft. Add lentils and bring to a gentle simmer, adding a stock cube if desired. Continue cooking and stirring until the lentils are soft, which should take about 20 minutes. Blanch spinach leaves for a few minutes in a pan, before removing and setting aside. Top up the pan with water and cook the lasagne sheets. When cooked, drain and set aside. To make the sauce, melt the butter and add the flour, then gradually add the soya milk along with the mustard and the vinegar. Cook and stir until smooth and then assemble the …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 12 ingredients, 75 min)

### mdb-52776
**Chocolate Gateau** · Dessert · area: France
- ingredients: 250g Plain Chocolate, 175g Butter, 2 tablespoons Milk, 5 Egg, 175g Sugar, 125g Plain Flour
- method (4 steps): Preheat the oven to 180°C/350°F/Gas Mark. Grease and line the base of an 8 in round spring form cake tin with baking parchment Break the chocolate into a heatproof bowl and place over a saucepan of gently simmering water and stir until it melts. (or melt in the microwave for 2-3 mins stirring occasionally) Place the butter and sugar in a mixing bowl and cream together with a wooden spoon until light and fluffy. Gradually beat in the eggs, adding a little flour if the mixture begins to curdle. Fold in the remaining flour with the cooled, melted chocolate and milk. Mix until smooth. Spread the m…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy', 'smooth'] (0.50, keywords: creamy, fluffy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 80 min)

### mdb-52777
**Mediterranean Pasta Salad** · Seafood · area: Italian
- ingredients: 200 g Mozzarella, 250 g Cherry Tomato, 1 bunch Basil, 350 g Farfalle, 3 tablespoons Olive Oil, 40 g Green Olive, 200 g Tuna, to taste Salt, to taste Black Pepper
- method (7 steps): Bring a large saucepan of salted water to the boil Add the pasta, stir once and cook for about 10 minutes or as directed on the packet. Meanwhile, wash the tomatoes and cut into quarters. Slice the olives. Wash the basil. Put the tomatoes into a salad bowl and tear the basil leaves over them. Add a tablespoon of olive oil and mix. When the pasta is ready, drain into a colander and run cold water over it to cool it quickly. Toss the pasta into the salad bowl with the tomatoes and basil. Add the sliced olives, drained mozzarella balls, and chunks of tuna. Mix well and let the salad rest for at l…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 9 ingredients, 65 min)

### mdb-52779
**Cream Cheese Tart** · Starter · area: United States
- ingredients: 250g Plain Flour, 125g Butter, 1 Egg, Pinch Salt, 300g Cheese, 100ml milk Milk, 3 Egg, 100g Parmesan, 350g Tomato, 3tbsp White Vinegar, 1 tbsp Honey, Topping Basil
- method (5 steps): Crust: make a dough from 250g flour (I like mixing different flours like plain and wholegrain spelt flour), 125g butter, 1 egg and a pinch of salt, press it into a tart form and place it in the fridge. Filling: stir 300g cream cheese and 100ml milk until smooth, add in 3 eggs, 100g grated parmesan cheese and season with salt, pepper and nutmeg. Take the crust out of the fridge and prick the bottom with a fork. Pour in the filling and bake at 175 degrees C for about 25 minutes. Cover the tart with some aluminium foil after half the time. In the mean time, slice about 350g mini tomatoes. In a sm…
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 55 min)

### mdb-52780
**Potato Gratin with Chicken** · Chicken · area: Italian
- ingredients: 800g Potato, 3 Onion, 2 tblsp Olive Oil, 100ml Chicken Stock, 1 pot Creme Fraiche, Topping Parmesan, 4 Chicken Breast, 4 Bacon, Topping Spinach, Topping Pea
- method (3 steps): 15 minute potato gratin with chicken and bacon greens: a gratin always seems more effort and more indulgent than ordinary boiled or roasts, but it doesn't have to take 45mins, it's nice for a change and you can control the calorie content by going with full fat to low fat creme fraiche. (It's always tastes better full fat though obviously!) to serve 4: use 800g of potatoes, finely slice and boil in a pan for about 5-8 mins till firmish, not soft. Finely slice 3 onions and place in an oven dish with 2 tblsp of olive oil and 100ml of chicken stock. Cook till the onions are soft then drain the po…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 75 min)

### mdb-52781
**Irish stew** · Beef · area: Irish
- ingredients: 300g soaked overnight in water Whole Wheat, 2kg cut into 3cm cubes Lamb Loin Chop, 120ml Olive Oil, 24 Skinned Shallot, 4 large Carrot, 2 Turnip, 1 Celeriac, 350g New Potato, 150ml White Wine, 1 tsp Sugar, 4 sprigs Thyme, 4 sprigs Oregano, 450ml Chicken Stock
- method (7 steps): Heat the oven to 180C/350F/gas mark. Drain and rinse the soaked wheat, put it in a medium pan with lots of water, bring to a boil and simmer for an hour, until cooked. Drain and set aside. Season the lamb with a teaspoon of salt and some black pepper. Put one tablespoon of oil in a large, deep sauté pan for which you have a lid; place on a medium-high heat. Add some of the lamb – don't overcrowd the pan – and sear for four minutes on all sides. Transfer to a bowl, and repeat with the remaining lamb, adding oil as needed. Lower the heat to medium and add a tablespoon of oil to the pan. Add the …
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 13 ingredients, 165 min, technique: caramelis)
