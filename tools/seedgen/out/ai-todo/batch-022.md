# AI tagging batch 022

Write `tools/seedgen/tags/ai/batch-022.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53212
**Thai drumsticks** · Chicken · area: Thai
- ingredients: 2 tablespoons Sweet Chilli Sauce, Zest of 1 Orange, 2 tblsp Orange, 1 clove peeled crushed Garlic, 1 tblsp Red Curry Paste, 8 Chicken Drumstick
- method (2 steps): Heat oven to 200C/180C fan/gas 6 and line a baking tray with foil. Mix the chilli sauce with the orange zest and juice, garlic, curry paste and ¼ tsp salt. Add the chicken and coat really well. Arrange the drumsticks on the foil, spaced apart. Coat the chicken with any marinade left in the bowl, then roast for 35-40 mins until tender. Wrap in foil or pack into a food container.
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 50 min)

### mdb-53213
**Thai-style fish broth with greens** · Seafood · area: Thai
- ingredients: 100g Rice Noodle, 500ml Chicken Stock, 1 tblsp Red Curry Paste, 4 Makrut Lime Leaf, 1 tblsp Fish Sauce, 200g White Fish, 100g Prawn, 2 Pak Choi, Handful Coriander
- method (4 steps): Cook the noodles following pack instructions. Refresh in cold water and drain well. Put the stock in a large saucepan and stir in the curry paste, lime leaves, fish sauce and 250ml cold water. Bring to a simmer and cook for 5 mins. Cut the fish into roughly 3cm cubes and add to the pan. Return to a simmer, then cook for 2 mins uncovered. Stir in the noodles, prawns and pak choi, and simmer for 2-3 mins or until the fish and prawns are just cooked. Serve in bowls scattered with coriander.
- `moods` rule: ['comfort', 'fresh', 'light'] (0.50, keywords/category: comfort, fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 30 min)

### mdb-53214
**Thai green chicken soup** · Chicken · area: Thai
- ingredients: 2 tblsp Vegetable Oil, 1 chopped Onion, 500g Chicken Thigh, 4 sliced Garlic, 280g Thai Green Curry Paste, 400ml Coconut Milk, 2 Litres Chicken Stock, 5 Makrut Lime Leaf, 2 tblsp Fish Sauce, 1 bunch Spring Onion, 280g Green Bean, 150g Bamboo Shoot, Juice of 2 Lime, Bunch Basil
- method (3 steps): Heat the oil in your largest pan, add the onion and fry for 3 mins to soften. Add the chicken and garlic, and cook until the chicken changes colour. Add the curry paste, coconut milk, stock, lime leaves and fish sauce, then simmer for 12 mins. Add the chopped onion tops, green beans and bamboo shoots and cook for 4-6 mins, until the beans are just tender. Meanwhile, put the lime juice and basil in a narrow jug and blitz with a hand blender to make a smooth green paste. Pour into the soup with the sliced spring onion and heat through. Serve with lime wedges for a light lunch or supper or as a m…
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 14 ingredients, 50 min)

### mdb-53216
**Knafeh** · Dessert · area: Saudi Arabian
- ingredients: 400g Knafeh, 6 tablespoons Butter, 1 pinch Yellow Food Colouring, 1 cup Mozzarella, 1/4 cup Cream Cheese, 1 1/2 cup Milk, 4 tablespoons Sugar, 2 tablespoons Cornflour, 1 cup Sugar, 1 cup Water, 1 tsp Rose Water, 1/2 teaspoon Lemon Juice
- method (12 steps): Take kanfhe in a bowl and roughly cut them. Pour melted butter, yellow food color and mix well with your hands. In a separate bowl mix milk, cream cheese, sugar, cornstarch well. Turn on the flame and boil the liquid, when it gets thick turn off the flame let it cool down a little bit. Add mozzarella in it and mix it well. Now make a base with half of the kanfhe in a dish, gently press it to level the dough well. Pour the cheese mixture on the top and level it with a spoon. Cover it with the other half of the kanfhe. Put the dish in a preheated oven at 200 degree for about 20-25 minutes. It's …
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 12 steps, 12 ingredients, 50 min)

### mdb-53217
**Shawarma chuck roast wrap** · Beef · area: Saudi Arabian
- ingredients: 1kg Chuck Roast, 1 cup Beef Stock, 3 tablespoons Lemon Juice, 1 tablespoon Ground Cumin, 2 tsp Paprika, 1 tsp Salt, 1 tsp Ground Ginger, 1 tsp Turmeric, 1/2 teaspoon Cayenne Pepper, 1/2 teaspoon Cinnamon, 1/2 teaspoon Ground Coriander, 1/4 tsp Clove
- method (9 steps): In a dutch oven or slow cooker, add all the spices, beef broth and lemon juice. Stir to combine.. Add the beef and turn to coat, spoon some sauce over the top. Cover and cook on low for 8-10 hours. After cooking, remove beef and use two forks to shred. Discard any excess fat. Skim fat off of the top of the liquid remaining. Mix shredded beef into sauce. Keep warm until you are ready to serve. Build wrap by spreading garlic sauce on the pita. Top with beef and add garnishes to your liking. Fold it burrito style. Heat a grill pan and grill the wrap.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy', 'tender'] (0.50, keywords: brothy, saucy, tender)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 12 ingredients, 510 min)

### mdb-53218
**Chicken Shawarma with homemade garlic herb yoghurt sauce** · Chicken · area: Saudi Arabian
- ingredients: 1kg Chicken Breast, 2 cloves minced Garlic, 1 tblsp Ground Coriander, 1 tblsp Ground Cumin, 1 tblsp Cardamom, 1 tsp Cayenne Pepper, 2 tsp Smoked Paprika, 2 tsp Salt, 2 tblsp Lemon Juice, 3 tablespoons Olive Oil, 1 cup Greek Yogurt, 1 clove peeled crushed Garlic, 1 tsp Ground Cumin, Splash Lemon Juice
- method (6 steps): Start by cutting your chicken up into reasonably small slices. Grab your ziplock bag and dump the freshly sliced chicken inside. Add garlic, coriander, cumin, cardomom, cayenne pepper, paprika, salt, pepper, lemon juice and olive oil to the bag. Close the bag and mix thoroughly. Place in fridge for 10-12 hours (shorter is fine but longer is better). Once ready to cook, heat your fry pan to medium-high and add a tiny bit of olive oil. Fry one side of all of your flatbreads until slightly toasty. Remove from pan, add enough oil to coat the fry pan. Put crumble fries into air fryer on 180 for 15 …
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 14 ingredients, 650 min)

### mdb-53219
**Shakshuka Feta Cheese** · Miscellaneous · area: Saudi Arabian
- ingredients: 4 large Egg, 3 tablespoons Tomato Sauce, 1 tablespoon Olive Oil, 1 chopped Shallot, 1 Celery, 1 clove peeled crushed Garlic, 1 cup Spinach, 1/2 cup Feta, 1/2 Red Pepper, 1 tsp Ground Cumin, 1/2 teaspoon Salt, 1/2 teaspoon Black Pepper
- method (4 steps): In a pan heat the oil medium to high heat, with a tablespoon of olive oil 2 Add the chopped vegetables as onions, garlic, celery and red pepper. Stir all together for 5 mins. Add the cumin powder and salt and pepper and the tomato sauce and let it cook for another 7 mins. Add the eggs, cover and leave to coo for 8 mins. Add the fresh spinach and feta cheese at the end. Serve with fresh bread.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 45 min)

### mdb-53220
**kabse** · Chicken · area: Saudi Arabian
- ingredients: 400g Chicken, 1 cup Rice, 1 Green Pepper, 1 Red Pepper, 2 Mushroom, 1 Sweetcorn, 2 Carrot, Handful Raisin, 1 tsp Turmeric, 1 tsp Kabse Spice, Pinch Salt, Pinch Black Pepper
- method (4 steps): Caramelize the chicken with olive oil then add a maggi cube and boil it for around 30 minutes. In another pot, add all the veggies and caramelize them till they are soft. Once everything is done, add the rice, raisins & spices to the veggies and add 2 and a half cups of water for the rice to cook. Once the rice is done put everything in the oven.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 55 min, technique: caramelize)

### mdb-53221
**Mamoul (Eid biscuits)** · Dessert · area: Saudi Arabian
- ingredients: 300g Plain Flour, 200g Semolina, 25g Vegetable Oil, 250g Butter, 50 ml Milk, 60g Icing Sugar
- method (9 steps): Mix butter with sugar until creamy. Add oil flour and semolina and mix. Add warm milk and don't knead too much 4 Cover and leave aside for an hour or less until you prepare the filling 5 For the dates filling, fry some sesame in a pan then add butter. Add the dates paste and mixed well with sesame and butter. Then add a little bit of water until it's mushy. Be careful don't make it too mushy. Take it of the pan, put in a plate until it's cool. Then start to shape balls that weigh 15 gm. Refrigerate for 1/2 an hour. Get back to the dough and shape it as balls that weigh 30 gm. Take the date fil…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['festive', 'indulgent'] (0.50, keywords/category: festive, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 6 ingredients, 155 min, technique: knead)

### mdb-53222
**Vegetarian Shakshuka** · Vegetarian · area: Saudi Arabian
- ingredients: 1/2 Red Onion, 1/2 Red Pepper, 400g Tomato, 1/2 teaspoon Ground Cumin, 1/2 tsp Garlic Powder, 1/2 teaspoon Cayenne Pepper, 1 tsp Paprika, 2 Egg, Garnish Parsley, Garnish Chilli Flakes, 2 sliced Toast
- method (1 steps): Fry onion and pepper together on medium heat until onion is soft 2 Add garlic granules, cook for a minute 3 Add chopped tomatoes and remaining spices, stir well 4 Simmer for about 20 minutes 5 Make indents for in the sauce and crack an egg into each one 6 Once egg whites are cooked through, garnish and serve with toast.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 11 ingredients, 45 min)

### mdb-53223
**Mutabbaq** · Miscellaneous · area: Saudi Arabian
- ingredients: 500g Mincemeat, 1.5 tbs minced Garlic, 1.5 tbs minced Ginger, 1 Egg, 1 large Tomato, 4 Spring Onion, 12 Filo Pastry, 1 1/2 cups Butter, 1 tsp Salt, 1 tsp Paprika, 1 tsp Ground Cumin, 1 tsp Ground Allspice, 1 tsp Turmeric, 1 tsp Black Pepper, 1 tsp Sugar
- method (5 steps): Heat the frying pan and add in some oil. Fry the mashed garlic and ginger first and then add in the minced meat and all seasoning. When the meat is cooked, set aside to cool down. Get another big bowl. Add in egg, chopped tomato, chopped spring onion and minced meat. Get one 2 sheets of filo pastry or 1 sheet spring roll wrap. Brush it with some butter and then put some filling in the middle. Fold the pastry and brush more butter on the seal part. Heat a frying pan and add in some oil to cook the parcel until its both sides and 4 edges all turn into golden brown. (Or brush melted butter all ov…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky'] (0.50, keywords: creamy, flaky)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 15 ingredients, 45 min)

### mdb-53224
**Pistachio Kunafa Chocolate Cake and Cupcakes** · Dessert · area: Saudi Arabian
- ingredients: 6 tablespoons White Chocolate, 1 cup Pistachio, 3 tablespoons Condensed Milk, 5 tablespoons Milk, 25 Oreo Cream Biscuit, 1/2 cup Milk, 1/2 teaspoon Baking Powder, 1/2 teaspoon White Vinegar, 1 pinch Salt, 150g Sevaiiya, 1 tablespoon Ghee, 120ml Dark Chocolate, 4 tablespoons Malai
- method (11 steps): For Chocolate Cake:Ready all the ingredients. Powder the oreo biscuits, pinch salt and mix warm milk as needed and make a cake batter. Add in baking powder and vinegar and mix. Grease a loose bottomed tin. Pour a 1cm thick layer of the batter. Bake in a preheated oven @160°C for 7-8 minutes or until the knife comes out clean. Cool on wire rack. For Homemade Pistachio Paste:Ready all the pistachio paste ingredients. Slightly melt white chocolate on a double boiler.(else the mixer blade may break) Coarsely powder the pistachio in mixer. Add in condensed milk. Add in slightly warmed and slightly …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'smooth'] (0.50, keywords: creamy, crispy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 13 ingredients, 160 min)

### mdb-53225
**Yemeni Lahsa (Elite Shakshuka)** · Breakfast · area: Saudi Arabian
- ingredients: 5 Egg, 1 Diced Onion, 1 Diced Tomato, 2 tablespoons Olive Oil, 1/4 tsp Ground Allspice, 1/4 tsp Black Pepper, 3 tablespoons Liquid Cheese
- method (3 steps): First, On medium heat, heat the olive oil and add the diced onion until it wethers. Next, add the tomatoes and cook for another 4-5 min. Lastly, add the all spice, salt, and cracked pepper. Add the eggs and mix throughly for 2 minutes and cover to cook 5-6 minutes until top is solidified. Lastly, spread the liquid cheese and have it covered for a minute. I served mine Mediterranean style with hash-browns, Egyptian fava beans, Turkish salami and olives, cheese wedges, and greek feta.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 30 min)

### mdb-53226
**Shawarma bread** · Side · area: Saudi Arabian
- ingredients: 1 cup Plain Flour, 1 tsp Salt, 1/2 tsp Sugar, 1/2 tsp Baking Powder, 1 tablespoon Vegetable Oil, Splash Water
- method (2 steps): Sieve flour and add baking powder,salt,sugar,oil nd mix together 2 Add water nd knead the dough for like 10mins 3 Cover the mixture and allow it to rise 4 After it rised transfer it to a work surface and form a round (you can use a plate or pot's lid) Heat ur pan and put it 6 It'll start puffing then you turn it 7 And lastly put it in in a warm place, then you'll see it has pocket.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 45 min, technique: knead)

### mdb-53227
**Rice paper dumplings** · Pork · area: Vietnamese
- ingredients: 1/4 Cabbage, 1 Carrot, 100g Shiitake Mushroom, 400g Pork Mince, 2 cloves minced Garlic, 20g Ginger, 2 tsp Soy Sauce, 2 tsp Sesame Oil, 3 sliced thinly Spring Onion, 20 Rice Paper Sheet, 75 ml Vegetable Oil, 2 tablespoons Soy Sauce, 2 tablespoons Rice Vinegar, 1/2 tbs Sesame Seed, 2 sliced Spring Onion
- method (7 steps): Tip the cabbage into a food processor and blitz until finely chopped. Season with ½ tsp salt, toss well and set aside for 15 mins. Tip into a clean tea towel and squeeze out as much water as you can. Tip into a bowl with the carrot, mushrooms, pork mince, garlic, ginger, soy sauce, sesame oil and spring onions. Season with black pepper. Scrunch everything together using your hands, mixing well until everything is combined. Soak the spring roll sheets for a couple of seconds in a shallow dish of warm water, then transfer to an oiled chopping board. Working with one sheet at a time, spoon 1 heap…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'fluffy', 'saucy'] (0.50, keywords: crunchy, fluffy, saucy)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 15 ingredients, 60 min)

### mdb-53228
**Vietnamese caramel trout** · Seafood · area: Vietnamese
- ingredients: 50g Sugar, 1 tablespoon Fish Sauce, 1 sliced Red Chilli, large piece Ginger, 2 Rainbow Trout, 2 heads Pak Choi, Juice of 1/2 Lemon, Sprigs of fresh Coriander, Steamed Rice
- method (3 steps): Put the sugar in a large shallow pan, along with a small splash of water. Heat gently, swirling the pan, until the sugar has dissolved. Increase the heat and bubble the syrup until it turns a dark amber colour. Add the fish sauce, most of the chilli and ginger, then splash in 1 tbsp water to dilute. Boil again until syrupy, then add the fish fillets, skin-side down, and the bok choi, cut-side down. Cover the pan with a lid and simmer for 4-5 mins until the fish is cooked and the bok choi has wilted. Turn off the heat, squeeze over the lemon and scatter with the remaining chilli, ginger and the…
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 25 min)

### mdb-53229
**Steak & Vietnamese noodle salad** · Beef · area: Vietnamese
- ingredients: 85g Rice Noodle, 1 tsp Vegetable Oil, 250g Beef Fillet, 2 Carrot, 1/2 Chinese Cabbage, 4 finely sliced Spring Onion, Handful Coriander, 1 sliced Red Chilli, Juice of 1 Lime, 2 tsp Brown Sugar, 1 tsp Rice Vinegar, 1 chopped Garlic, 1/2 tbs Fish Sauce
- method (3 steps): Mix all the ingredients for the dressing together in a bowl with 1 tbsp water until the sugar has dissolved. Cook the noodles following pack instructions, then plunge into a bowl of cold water to cool completely. Drain the noodles, then add the carrot, cabbage, spring onion and dressing, and toss to combine. Heat the oil in a frying pan over a high heat. Season the steak, then cook to your liking; 2-3 mins on each side for medium rare. Leave to rest for 5 mins, then slice. Divide the salad and steak slices between bowls and scatter over some coriander to serve.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'saucy'] (0.50, keywords: chewy, saucy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 13 ingredients, 40 min)

### mdb-53230
**Purple sprouting broccoli tempura with nuoc cham** · Miscellaneous · area: Vietnamese
- ingredients: 50g Cornflour, 100g Plain Flour, 1 tablespoon Sesame Seed, For frying Vegetable Oil, 250ml Soda Water, 200g Purple Sprouting Broccoli, 2 tablespoons Fish Sauce, Juice of 2 Lime, 1 chopped Birds Eye Chilli, 2 tablespoons Sugar
- method (3 steps): For the nuoc cham, whisk together all of the ingredients with 5 tbsp hot water in a small bowl. Set aside while you make the tempura. Whisk the cornflour, plain flour, sesame seeds (if using) and a large pinch of salt together. Fill a large, deep pan no more than a third full with the vegetable oil and heat until it reaches 180C or a cube of bread dropped in browns in 20 seconds. Quickly whisk the soda water into the flour mixture, being careful not to overmix, then dunk in the broccoli using tongs. Carefully lower into the hot oil and cook for 2-3 mins until crisp. Drain on kitchen paper, the…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 25 min)

### mdb-53231
**Vietnamese lamb shanks with sweet potatoes** · Lamb · area: Vietnamese
- ingredients: 2 tablespoons Groundnut Oil, 4 Lamb Shank, 2 Onion, 2 tbs chopped Ginger, 3 sliced thinly Garlic, 1 chopped Red Chilli, 1 sliced Red Chilli, 1 tablespoon Brown Sugar, 1 tsp Brown Sugar, 3 Star Anise, 2 Lemongrass, 1L Lamb Stock, 1 ½ tbsp Tomato Puree, 4 Sweet Potato, 2 tablespoons Fish Sauce, Juice of 2 Lime, Handful Mint, Handful Basil
- method (4 steps): Heat oven to 160C/140C fan/gas. Heat 1 tbsp oil in a heavy-bottomed casserole, season the shanks, then brown them 2 at a time on all sides, adding the remaining oil for the second batch. Remove the lamb and add the onions. Fry them quite briskly, about 30 secs, add the ginger, garlic and chopped chilli, then turn the heat down and cook for 1 min. Add 1 tbsp sugar, stir, then add the star anise, lemongrass, stock, purée and seasoning. Bring to the boil. Cover and cook in the oven for 1½ hrs, then add the sweet potatoes and cook for 1 hr more. The lamb should be completely tender and almost fall…
- `textures` rule: ['crunchy', 'saucy', 'smooth'] (0.50, keywords: crunchy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 18 ingredients, 190 min)

### mdb-53232
**Vietnamese chicken salad** · Chicken · area: Vietnamese
- ingredients: 140g Rice Noodle, 1 Carrot, 1/2 Cucumber, 2 Chicken Breast, 50g Radish, 1/2 Red Onion, Bunch Mint, 25g Peanut, 1 chopped Red Chilli, Zest and juice of 1 Lime, 1 ½ tbsp Fish Sauce, 1 ½ tbsp Soy Sauce, 1 ½ tbsp Sesame Oil
- method (2 steps): To make the dressing, whisk all the ingredients together in a large serving bowl. Cook the noodles following pack instructions, then drain and add to the bowl with the dressing. Peel the carrot into long strips using a vegetable peeler. Do the same for the cucumber, until you reach the seeds (discard them). Add the carrot and cucumber to the noodle mixture along with the shredded chicken, radishes, red onion and mint. Toss well to coat in the dressing, scatter over the peanuts and serve.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crunchy', 'saucy'] (0.50, keywords: chewy, crunchy, saucy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Chicken guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 13 ingredients, 60 min)
