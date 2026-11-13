# AI tagging batch 010

Write `tools/seedgen/tags/ai/batch-010.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52936
**Saltfish and Ackee** · Seafood · area: Jamaican
- ingredients: 450g Salt Cod, 400g Ackee, 1 chopped Onion, 1 tsp Paprika, 2 tsp Curry Powder, 2 tsp Jerusalem Artichoke, 1 tsp Hot Sauce, 1 sliced Red Pepper, 1 sliced Yellow Pepper, 200g Tomato, to taste Salt, to taste Black Pepper, 250g Self Raising Flour, 30g Suet, pinch Salt, for frying Olive Oil
- method (12 steps): For the saltfish, soak the salt cod overnight, changing the water a couple of times. Drain, then put the cod in a large pan of fresh water and bring to the boil. Drain again, add fresh water and bring to the boil again. Simmer for about five minutes, or until cooked through, then drain and flake the fish into large pieces. Discard any skin or bones. For the dumplings, mix the flour and suet with a pinch of salt and 250ml/9fl oz water to make a dough. Wrap the mixture in clingfilm and leave in the fridge to rest. Open the can of ackee, drain and rinse, then set aside. Heat a tablespoon of olive…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['fluffy', 'saucy'] (0.50, keywords: fluffy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 16 ingredients, 520 min)

### mdb-52938
**Jamaican Beef Patties** · Beef · area: Jamaican
- ingredients: 4 cups Plain Flour, 1 tsp Salt, 1 tsp Curry Powder, 250g Butter, 1 cup Water, 900g Beef Mince, 1 tsp Ground Allspice, 1/2 tsp Black Pepper, 2 tbs Vegetable Oil, 1 cup Onion, Ground Red Pepper, 2 tsp ground Garlic, 1 tbs Thyme, 1/4 tsp Salt, 2 tbs Tomato Ketchup, 2 cups Water, 1/2 cup Onion, 1 beaten Egg, 1 tbs Water, 1/4 cup Water
- method (29 steps): Make the Pastry Dough. To a large bowl, add flour, 1 teaspoon salt, and turmeric and mix thoroughly. Rub shortening into flour until there are small pieces of shortening completely covered with flour. Pour in 1/2 cup of the ice water and mix with your hands to bring the dough together. Keep adding ice water 2 to 3 tablespoons at a time until the mixture forms a dough. At this stage, you can cut the dough into 2 large pieces, wrap in plastic and refrigerate for 30 minutes before using it. Alternatively, cut the dough into 10 to 12 equal pieces, place on a platter or baking sheet, cover securely…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky', 'saucy'] (0.50, keywords: flaky, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-52939
**Callaloo Jamaican Style** · Miscellaneous · area: Jamaican
- ingredients: 1 bunch Kale, 2 strips Bacon, 3 cloves Chopped Garlic, 1 medium Onion, 1/2 tsp Paprika, 1 Sprig Thyme, 1 Tomato, 1 Red Pepper, 4 Banana, Splash Vegetable Oil
- method (10 steps): Cut leaves and soft stems from the kale branches, them soak in a bowl of cold water for about 5-10 minutes or until finish with prep. Proceed to slicing the onions, mincing the garlic and dicing the tomatoes. Set aside Remove kale from water cut in chunks. Place bacon on saucepan and cook until crispy. Then add onions, garlic, thyme, stir for about a minute or more Add tomatoes; scotch bonnet pepper, smoked paprika. Sauté for about 2-3 more minutes. Finally add vegetable, salt, mix well, and steamed for about 6-8 minutes or until leaves are tender. Add a tiny bit of water as needed. Adjust sea…
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['indulgent', 'light'] (0.50, keywords/category: indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 10 ingredients, 45 min)

### mdb-52940
**Brown Stew Chicken** · Chicken · area: Jamaican
- ingredients: 1 whole Chicken, 1 chopped Tomato, 2 chopped Onion, 2 chopped Garlic, 1 chopped Red Pepper, 1 chopped Carrot, 1 Lime, 2 tsp Thyme, 1 tsp Ground Allspice, 2 tbs Soy Sauce, 2 tsp Cornflour, 2 cups Coconut Milk, 1 tbs Vegetable Oil
- method (6 steps): Squeeze lime over chicken and rub well. Drain off excess lime juice. Combine tomato, scallion, onion, garlic, pepper, thyme, pimento and soy sauce in a large bowl with the chicken pieces. Cover and marinate at least one hour. Heat oil in a dutch pot or large saucepan. Shake off the seasonings as you remove each piece of chicken from the marinade. Reserve the marinade for sauce. Lightly brown the chicken a few pieces at a time in very hot oil. Place browned chicken pieces on a plate to rest while you brown the remaining pieces. Drain off excess oil and return the chicken to the pan. Pour the ma…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 13 ingredients, 115 min)

### mdb-52941
**Red Peas Soup** · Beef · area: Jamaican
- ingredients: 2 cups Kidney Bean, 1 large Carrot, 2 chopped Spring Onion, 4 sprigs Thyme, 1 Diced Onion, 1/2 tsp Black Pepper, 2 chopped Red Pepper, 4 Mashed Garlic, 1 tbs Ground Allspice, 2 Lbs Beef, 2L Water, 4 Potato, 1 cup Plain Flour, 1/4 cup Water, 1 cup Coconut Milk
- method (9 steps): Wash and rinse the dried kidney beans.. then cover with water in a deep bowl. Remember as they soak they will expand to at least triple the size they were originally so add a lot of water to the bowl. Soak them overnight or for at least 2 hrs to make the cooking step go quicker. I tossed out the water they were soaked in after it did the job. Have your butcher cut the salted pigtail into 2 inch pieces as it will be very difficult to cut with an ordinary kitchen knife. Wash, then place a deep pot with water and bring to a boil. Cook for 20 minutes, then drain + rinse and repeat (boil again in w…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 9 steps, 15 ingredients, 380 min, technique: cure)

### mdb-52942
**Roast fennel and aubergine paella** · Vegan · area: Spanish
- ingredients: 6 small Aubergine, 4 small Fennel, 1 thinly sliced Red Pepper, 1 medium Courgette, 1 finely chopped Onion, 300g Paella Rice, 1 tsp Paprika, pinch Saffron, 200ml White Wine, 700ml Vegetable Stock, 100g Pea, 1 chopped Lemon, Handful Parsley, pinch Salt, pinch Black Pepper
- method (5 steps): Put the fennel, aubergine, pepper and courgette in a roasting tray. Add a glug of olive oil, season with salt and pepper and toss around to coat the veggies in the oil. Roast in the oven for 20 minutes, turning a couple of times until the veg are pretty much cooked through and turning golden. Meanwhile, heat a paella pan or large frying pan over a low– medium heat and add a glug of olive oil. Sauté the onion for 8–10 minutes until softened. Increase the heat to medium and stir in the rice, paprika and saffron. Cook for around 1 minute to start toasting the rice, then add the white wine. Reduce…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 15 ingredients, 85 min)

### mdb-52943
**Oxtail with broad beans** · Beef · area: Jamaican
- ingredients: 450g Oxtail, 1 chopped Onion, 1 Spring Onion, 2 cloves minced Garlic, 1 tsp Ginger, 1 chopped Scotch Bonnet, 2 tbs Soy Sauce, 1 chopped Thyme, 2 tbs Vegetable Oil, 350ml Water, 200g Broad Bean, 1 tbs Cornflour, 2 tbs Water
- method (3 steps): Toss the oxtail with the onion, spring onion, garlic, ginger, chilli, soy sauce, thyme, salt and pepper. Heat the vegetable oil in a large frying pan over medium-high heat. Brown the oxtail in the pan until browned all over, about 10 minutes. Place into a pressure cooker, and pour in 375ml water. Cook at pressure for 25 minutes, then remove from heat, and remove the lid according to manufacturer's directions. Add the broad beans and pimento berries, and bring to a simmer over medium-high heat. Dissolve the cornflour in 2 tablespoons water, and stir into the simmering oxtail. Cook and stir a fe…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 13 ingredients, 60 min)

### mdb-52944
**Escovitch Fish** · Seafood · area: Jamaican
- ingredients: 2 Pounds Red Snapper, 1/2 cup Vegetable Oil, 1 clove peeled crushed Garlic, 1/2 tsp Ginger, 2 sprigs Thyme, 1 Bay Leaf, 0.5 Red Pepper, 0.5 Yellow Pepper, 1 sliced Onion, 1 chopped Carrot, 1 tbs Sugar, 1/2 tsp Ground Allspice, 1 tsp Worcestershire Sauce, 1 Scotch Bonnet, 1 Lime, 3/4 cup Malt Vinegar, pinch Black Pepper
- method (5 steps): Rinse fish; rub with lemon or lime, seasoned with salt and pepper or use your favorite seasoning. I used creole seasoning. Set aside or place in the oven to keep it warm until sauce is ready. In large skillet heat oil over medium heat, until hot, add the fish, cook each side- for about 5-7 minutes until cooked through and crispy on both sides. Remove fish and set aside. Drain oil and leave about 2-3 tablespoons of oil Add, bay leave, garlic and ginger, stir-fry for about a minute making sure the garlic does not burn Then add onion, bell peppers, thyme, scotch bonnet, sugar, all spice-continue …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 17 ingredients, 40 min)

### mdb-52946
**Kung Po Prawns** · Seafood · area: Chinese
- ingredients: 400g Prawn, 2 tbs Soy Sauce, 1 tsp Tomato Puree, 1 tsp Cornflour, 1 tsp Sugar, 1 tsp Vegetable Oil, 85g Peanut, 3 Large Red Chilli, 1 tbs Brown Sugar, 6 cloves Garlic, 450g Water Chestnut, to taste Ginger
- method (3 steps): Mix the cornflour and 1 tbsp soy sauce, toss in the prawns and set aside for 10 mins. Stir the vinegar, remaining soy sauce, tomato purée, sugar and 2 tbsp water together to make a sauce. When you’re ready to cook, heat a large frying pan or wok until very hot, then add 1 tbsp oil. Fry the prawns until they are golden in places and have opened out– then tip them out of the pan. Heat the remaining oil and add the peanuts, chillies and water chestnuts. Stir-fry for 2 mins or until the peanuts start to colour, then add the ginger and garlic and fry for 1 more min. Tip in the prawns and sauce and …
- `textures` rule: ['crunchy', 'saucy', 'smooth'] (0.50, keywords: crunchy, saucy, smooth)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 40 min)

### mdb-52949
**Sweet and Sour Pork** · Pork · area: Chinese
- ingredients: 200g Pork, 1 Egg, Dash Water, 1/2 tsp Salt, 1 tsp Sugar, 10g Soy Sauce, 10g Cornflour, 30g Tomato Puree, 10g White Vinegar, Dash Coriander
- method (12 steps): Crack the egg into a bowl. Separate the egg white and yolk. Sweet and Sour Pork. Slice the pork tenderloin into strips. Prepare the marinade using a pinch of salt, one teaspoon of starch, two teaspoons of light soy sauce, and an egg white. Marinade the pork strips for about 20 minutes. Put the remaining starch in a bowl. Add some water and vinegar to make a starchy sauce. Sweet and Sour Pork Cooking Instructions. Pour the cooking oil into a wok and heat to 190°C (375°F). Add the marinated pork strips and fry them until they turn brown. Remove the cooked pork from the wok and place on a plate. …
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 12 steps, 10 ingredients, 40 min)

### mdb-52950
**Szechuan Beef** · Beef · area: Chinese
- ingredients: 1/2 lb Beef, 1/2 tsp Salt, 1 tsp Sesame Oil, 1 pinch Black Pepper, 1 Egg White, 3 tbs Cornflour, 4 tbs Vegetable Oil, 1 tsp Ginger, 1 tsp Garlic, 3/4 cup Onion, 1/2 cup Carrot, 3/4 cup Green Pepper, 1 cup Celery, 1 cup Mushroom, 1 tbs Cooking Wine, 1 cup Water, 1 tbs Oyster Sauce, 1/2 tsp Hot Sauce, 1 tsp Sugar, 1 tbs Soy Sauce
- method (4 steps): MARINATING THE BEEF In a bowl, add the beef, salt, sesame seed oil, white pepper, egg white, 2 Tablespoon of corn starch and 1 Tablespoon of oil. STIR FRY First Cook the beef by adding 2 Tablespoon of oil until the beef is golden brown. Set the beef aside In a wok add 1 Tablespoon of oil, minced ginger, minced garlic and stir-fry for few seconds. Next add all of the vegetables and then add sherry cooking wine and 1 cup of water. To make the sauce add oyster sauce, hot pepper sauce, and sugar. add the cooked beef and 1 spoon of soy sauce To thicken the sauce, whisk together 1 Tablespoon of corn…
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 20 ingredients, 70 min)

### mdb-52951
**General Tsos Chicken** · Chicken · area: Chinese
- ingredients: 1 1/2 Chicken Breast, 3/4 cup Plain Flour, 1 Egg, 2 tbs Cornflour, 1 tbs Baking Powder, 1 tsp Salt, 1/2 tsp Onion Salt, 1/4 tsp Garlic Powder, 3/4 cup Water, 1/2 cup Chicken Stock, 1/4 cup Duck Sauce, 3 tbs Soy Sauce, 2 tbs Honey, 1 tbs Rice Vinegar, 2 tbs Sesame Oil, 1/2 tbs Gochujang, 2 tbs Cornflour, 1 clove Garlic, 2 chopped Spring Onion, 1 tsp Ginger
- method (4 steps): SAUCE In a bowl, add 2 Cups of water, 2 Tablespoon soy sauce, 2 Tablespoon white vinegar, sherry cooking wine, 1/4 Teaspoon white pepper, minced ginger, minced garlic, hot pepper, ketchup, hoisin sauce, and sugar. Mix together well and set aside. MARINATING THE CHICKEN In a bowl, add the chicken, 1 pinch of salt, 1 pinch of white pepper, 2 egg whites, and 3 Tablespoon of corn starch. DEEP FRY THE CHICKEN Deep fry the chicken at 350 degrees for 3-4 minutes or until it is golden brown and loosen up the chicken so that they don't stick together. Set the chicken aside. STIR FRY Add the sauce to th…
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 20 ingredients, 45 min, technique: deep fr)

### mdb-52952
**Beef Lo Mein** · Beef · area: Chinese
- ingredients: 1/2 lb Beef, pinch Salt, pinch Black Pepper, 2 tsp Sesame Oil, 1/2 Egg, 3 tbs Cornflour, 5 tbs Vegetable Oil, 1/4 lb Noodle, 1/2 cup Onion, 1 tsp Garlic, 1 tsp Ginger, 1 cup Bean Sprout, 1 cup Mushroom, 1 cup Water, 1 tbs Oyster Sauce, 1 tsp Sugar, 1 tsp Soy Sauce
- method (5 steps): MARINATING THE BEEF In a bowl, add the beef, salt, 1 pinch white pepper, 1 Teaspoon sesame seed oil, 1/2 egg, corn starch,1 Tablespoon of oil and mix together. BOILING THE THE NOODLES In a 6 qt pot add your noodles to boiling water until the noodles are submerged and boil on high heat for 10 seconds. After your noodles is done boiling strain and cool with cold water. STIR FRY Add 2 Tablespoons of oil, beef and cook on high heat untill beef is medium cooked. Set the cooked beef aside In a wok add 2 Tablespoon of oil, onions, minced garlic, minced ginger, bean sprouts, mushrooms, peapods and 1.5…
- `textures` rule: ['chewy', 'saucy'] (0.50, keywords: chewy, saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 17 ingredients, 65 min)

### mdb-52953
**Shrimp Chow Fun** · Seafood · area: Chinese
- ingredients: 1/2 bag Rice Noodle, 8 oz Prawn, 1/2 Egg, pinch Black Pepper, 2 tsp Sesame Oil, 2 tbs Cornflour, 4 tbs Vegetable Oil, 1 tsp Garlic, 1 tsp Ginger, 1/2 cup Onion, 1 cup Bean Sprout, 1/2 cup Spring Onion, 1 tbs Cooking Wine, 1 tbs Oyster Sauce, 1/2 tbs Sugar, 1/2 tbs White Vinegar, 1 tbs Soy Sauce
- method (5 steps): SOAK THE RICE NOODLES Soak the rice noodles overnight untill they are soft. BOIL THE RICE NOODLES Boil the noodles for 10-15 minutes and then rinse with cold water to stop the cooking process of the noodles. MARINATING THE SHRIMP In a bowl add the shrimp, egg, 1 pinch of white pepper, 1 Teaspoon of sesame seed oil, 1 Tablespoon corn starch and 1 tablespoon of oil Mix together well. STIR FRY In a wok add 2 Tablespoons of oil, shrimp and stir fry them until it is golden brown Set the shrimp aside Add 1 Tablespoon of oil to the work and then add minced garlic, ginger and all of the vegetables. Ad…
- `textures` rule: ['chewy', 'saucy'] (0.50, keywords: chewy, saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 17 ingredients, 520 min)

### mdb-52954
**Hot and Sour Soup** · Pork · area: Chinese
- ingredients: 1/3 cup Mushroom, 1/3 cup Wood Ear Mushroom, 2/3 Cup Tofu, 1/2 cup Pork, 2-1/2 cups Chicken Stock, 1/2 tsp Salt, 1/4 tsp Sugar, 1 tsp Sesame Oil, 1/4 tsp Black Pepper, 1/2 tsp Hot Sauce, 1-½ cups White Vinegar, 1 tsp Soy Sauce, 1 tbs Cornflour, 2 tbs Water, 1/4 cup Spring Onion
- method (3 steps): MAKING THE SOUP In a wok add chicken broth and wait for it to boil. Next add salt, sugar, sesame seed oil, white pepper, hot pepper sauce, vinegar and soy sauce and stir for few seconds. Add Tofu, mushrooms, black wood ear mushrooms to the wok. To thicken the sauce, whisk together 1 Tablespoon of cornstarch and 2 Tablespoon of water in a bowl and slowly add to your soup until it's the right thickness. Next add 1 egg slightly beaten with a knife or fork and add it to the soup and stir for 8 seconds Serve the soup in a bowl and add the bbq pork and sliced green onions on top.
- `moods` rule: ['comfort', 'light'] (0.50, keywords/category: comfort, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Pork guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 15 ingredients, 60 min)

### mdb-52955
**Egg Drop Soup** · Vegetarian · area: Chinese
- ingredients: 3 cups Chicken Stock, 1/4 tsp Salt, 1/4 tsp Sugar, pinch Black Pepper, 1 tsp Sesame Oil, 1/3 cup Pea, 1/3 cup Mushroom, 1 tbs Cornflour, 2 tbs Water, 1/4 cup Spring Onion
- method (5 steps): In a wok add chicken broth and wait for it to boil. Next add salt, sugar, white pepper, sesame seed oil. When the chicken broth is boiling add the vegetables to the wok. To thicken the sauce, whisk together 1 Tablespoon of cornstarch and 2 Tablespoon of water in a bowl and slowly add to your soup until it's the right thickness. Next add 1 egg slightly beaten with a knife or fork and add it to the soup slowly and stir for 8 seconds Serve the soup in a bowl and add the green onions on top.
- `moods` rule: ['comfort', 'light'] (0.50, keywords/category: comfort, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 50 min)

### mdb-52956
**Chicken Congee** · Chicken · area: Chinese
- ingredients: 8 oz Chicken, pinch Salt, pinch Black Pepper, 1 tsp Ginger Cordial, 1 tsp Ginger, 1 tbs Spring Onion, 1/2 cup Rice, 8 cups Water, 2 oz Coriander
- method (5 steps): MARINATING THE CHICKEN In a bowl, add chicken, salt, white pepper, ginger juice and then mix it together well. Set the chicken aside. RINSE THE WHITE RICE Rinse the rice in a metal bowl or pot a couple times and then drain the water. BOILING THE WHITE RICE Next add 8 cups of water and then set the stove on high heat until it is boiling. Once rice porridge starts to boil, set the stove on low heat and then stir it once every 8-10 minutes for around 20-25 minutes. After 25 minutes, this is optional but you can add a little bit more water to make rice porridge to make it less thick or to your pre…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 85 min)

### mdb-52957
**Fruit and Cream Cheese Breakfast Pastries** · Breakfast · area: United States
- ingredients: 1 1/4 oz Cream Cheese, 1 1/4 cup Sugar, 1 teaspoon Vanilla Extract, Plain Flour, 2 Puff Pastry, Strawberries, Raspberry, Blackberry
- method (7 steps): Preheat oven to 400ºF (200ºC), and prepare two cookie sheets with parchment paper. In a bowl, mix cream cheese, sugar, and vanilla until fully combined. Lightly flour the surface and roll out puff pastry on top to flatten. Cut each sheet of puff pastry into 9 equal squares. On the top right and bottom left of the pastry, cut an L shape approximately ½ inch (1 cm) from the edge. NOTE: This L shape should reach all the way down and across the square, however both L shapes should not meet at the ends. Your pastry should look like a picture frame with two corners still intact. Take the upper right…
- `textures` rule: ['chewy', 'creamy', 'flaky'] (0.50, keywords: chewy, creamy, flaky)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 8 ingredients, 35 min)

### mdb-52958
**Peanut Butter Cookies** · Dessert · area: United States
- ingredients: 1 cup Peanut Butter, 1/2 cup Sugar, 1 Egg
- method (7 steps): Preheat oven to 350ºF (180ºC). In a large bowl, mix together the peanut butter, sugar, and egg. Scoop out a spoonful of dough and roll it into a ball. Place the cookie balls onto a nonstick baking sheet. For extra decoration and to make them cook more evenly, flatten the cookie balls by pressing a fork down on top of them, then press it down again at a 90º angle to make a criss-cross pattern. Bake for 8-10 minutes or until the bottom of the cookies are golden brown. Remove from baking sheet and cool. Enjoy!
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crunchy'] (0.50, keywords: chewy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 3 ingredients, 20 min)

### mdb-52959
**Baked salmon with fennel & tomatoes** · Seafood · area: British
- ingredients: 2 medium Fennel, 2 tbs chopped Parsley, Juice of 1 Lemon, 175g Cherry Tomato, 1 tbs Olive Oil, 350g Salmon, to serve Black Olive
- method (3 steps): Heat oven to 180C/fan 160C/gas. Trim the fronds from the fennel and set aside. Cut the fennel bulbs in half, then cut each half into 3 wedges. Cook in boiling salted water for 10 mins, then drain well. Chop the fennel fronds roughly, then mix with the parsley and lemon zest. Spread the drained fennel over a shallow ovenproof dish, then add the tomatoes. Drizzle with olive oil, then bake for 10 mins. Nestle the salmon among the veg, sprinkle with lemon juice, then bake 15 mins more until the fish is just cooked. Scatter over the parsley and serve.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 55 min, technique: proof)
