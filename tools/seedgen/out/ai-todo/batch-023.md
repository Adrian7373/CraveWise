# AI tagging batch 023

Write `tools/seedgen/tags/ai/batch-023.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53233
**Salt & pepper squid** · Seafood · area: Vietnamese
- ingredients: 85g Cornflour, 85g Plain Flour, 2 tsp Black Pepper, 2 tsp Sichuan Pepper, For frying Vegetable Oil, 400g Squid, Sliced Spring Onion, Sliced Green Chilli, 1 chopped Red Chilli, 1/2 Cucumber, 1 chopped Red Onion, 100 ml Rice Vinegar, 1 tablespoon Sugar, 2 tsp Fish Sauce
- method (3 steps): To make the dipping sauce, mix all the ingredients in a small bowl until the sugar has dissolved, then set aside. Mix the cornflour and plain flour with both peppers and 2 tsp sea salt in a large bowl, then set aside. Line a tray with kitchen paper and make sure you have more salt to sprinkle with. Heat about 7cm of oil to 180C in a deep fryer, wok or deep pan. If you don’t have a thermometer, you can test it with a cube of bread – it should brown in 20 secs. Coat the squid well with the flour mix and fry in batches for about 2 mins each or until crisp. Use a slotted spoon to lift out the squi…
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 14 ingredients, 35 min, technique: deep fr)

### mdb-53234
**Salmon noodle soup** · Seafood · area: Vietnamese
- ingredients: 1 L Chicken Stock, 2 tsp Red Curry Paste, 100g Rice Noodle, 150g Shiitake Mushroom, 125g Sweetcorn, 2 Salmon, Juice of 2 Lime, 1 tablespoon Soy Sauce, Pinch Brown Sugar, Bunch Coriander
- method (2 steps): Pour the stock into a large pan, bring to the boil, then stir in the curry paste. Add the noodles and cook for 8 mins. Tip in the mushrooms and corn and cook for 2 mins more. Add the salmon to the pan and cook for 3 mins or until cooked through. Remove from the heat and stir in the lime juice, soy sauce and a pinch of sugar. Ladle into 4 bowls and sprinkle over the coriander just before you serve.
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 35 min)

### mdb-53235
**Vietnamese-style caramel pork** · Pork · area: Vietnamese
- ingredients: 1 ½ tbsp Groundnut Oil, 500g Pork Shoulder, 2 chopped Shallot, 1 tablespoon Ground Ginger, 1 chopped Red Chilli, 75g Brown Sugar, 1 tablespoon Fish Sauce, 2 tsp Chilli Sauce, 4 Spring Onion, Steamed Rice, To serve Pak Choi
- method (4 steps): Heat 1 tbsp of the oil in a wok over a high heat and stir-fry the pork in batches until browned all over. Remove with a slotted spoon and set aside. Turn the heat right down and add the remaining oil, then stir in the shallots, ginger and chilli. Cook over a low heat for a couple of mins until just starting to soften. Add the sugar, fish sauce and 200ml water to the pan and stir everything together. Bring to the boil, stirring, so that the sugar dissolves, then return the pork to the pan. Bubble vigorously for 8-10 mins until the sauce thickens to coat the meat and become glossy. Taste and sti…
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['hearty', 'indulgent', 'light'] (0.50, keywords/category: hearty, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 30 min)

### mdb-53236
**Vietnamese-style veggie hotpot** · Vegetarian · area: Vietnamese
- ingredients: 2 tsp Vegetable Oil, 4cm finely chopped Ginger, 2 chopped Garlic, 1/2 Butternut Squash, 2 tsp Soy Sauce, 2 tsp Brown Sugar, 200ml Vegetable Stock, 100g shredded Green Bean, 4 sliced Spring Onion, To serve Coriander, To serve Jasmine Rice
- method (1 steps): Heat the oil in a medium-size, lidded saucepan. Add the ginger and garlic, then stir-fry for about 5 mins. Add the squash, soy sauce, sugar and stock. Cover, then simmer for 10 mins. Remove the lid, add the green beans, then cook for 3 mins more until the squash and beans are tender. Stir the spring onions through at the last minute, then sprinkle with coriander and serve with rice.
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 11 ingredients, 40 min)

### mdb-53237
**Vietnamese pork salad** · Pork · area: Vietnamese
- ingredients: 1 tsp Sugar, Juice of 2 Lime, 1 chopped Red Chilli, Handful Coriander, 1 tablespoon Sesame Oil, 1 tablespoon Fish Sauce, 1 tablespoon Soy Sauce, 500g Pork Tenderloin, For brushing Vegetable Oil, 1/4 Cabbage, 1 chopped Cucumber, 5 chopped Celery, 3 sliced thinly Spring Onion, 1 chopped Red Chilli, 2 chopped Lemongrass, Zest of 1 Lime, Handful Coriander, Handful Mint
- method (3 steps): The day before: make the dressing. Put the sugar and lime juice in a pan with 1 tbsp water and bring to the boil to dissolve the sugar. Add the chilli and coriander and stir well, then pulse in a blender until smooth. Tip into a bowl, then stir in the sesame oil, fish sauce, soy sauce and sesame seeds to make a dressing. Cover and chill until needed. Two hours before serving: heat a griddle pan. Preheat the oven to 200C/gas 6/fan 180C. Brush the pork with oil and griddle on all sides for a few minutes until seared. Transfer to a baking tray and put in the oven for about 10-12 minutes until coo…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 18 ingredients, 165 min)

### mdb-53239
**Bang bang prawn salad** · Seafood · area: Vietnamese
- ingredients: 140g Rice Noodle, 3 tablespoons Peanut Butter, 4 tablespoons Coconut Milk, 3 tablespoons Sweet Chilli Sauce, 3 sliced thinly Spring Onion, 1 sliced Cucumber, 300g Bean Sprout, 200g Prawn
- method (2 steps): Cook the noodles following pack instructions, then rinse under cold water and drain thoroughly. In a small saucepan melt together the peanut butter, coconut milk, sweet chilli sauce and half the spring onions, adding 1-2 tbsp of water to loosen the mixture to a drizzling consistency. Mix the noodles, cucumber and beansprouts in a serving dish. Top with the prawns, drizzle over the peanut sauce and scatter over the remaining spring onions.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'crunchy'] (0.50, keywords: chewy, creamy, crunchy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 45 min)

### mdb-53240
**Tofu, greens & cashew stir-fry** · Vegetarian · area: Vietnamese
- ingredients: 1 tablespoon Vegetable Oil, 1 head Broccoli, 4 sliced Garlic, 1 sliced Red Chilli, 1 bunch Spring Onion, 140g Soya Bean, 2 heads Pak Choi, 300g Marinated Tofu, 1 ½ tbsp Hoisin Sauce, 1 tablespoon Soy Sauce, 25g Cashew
- method (1 steps): Heat the oil in a non-stick wok. Add the broccoli, then fry on a high heat for 5 mins or until just tender, adding a little water if it begins to catch. Add the garlic and chilli, fry for 1 min, then toss through the spring onions, soya beans, pak choi and tofu. Stir-fry for 2-3 mins. Add the hoisin, soy and nuts to warm through.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 11 ingredients, 30 min)

### mdb-53241
**Vietnamese veg parcels** · Vegetarian · area: Vietnamese
- ingredients: 100g Rice Flour Pancake, 50g Rice Noodle, 1 Chicken Breast, 1 sliced Carrot, 1 sliced Cucumber, 1 sliced Red Pepper, To serve Lettuce, To serve Coriander, To serve Mint, 4 tablespoons Fish Sauce, 2 tablespoons Rice Vinegar, Juice of 1/2 Lime, 1 sliced Red Chilli
- method (3 steps): Soak the rice fl our pancakes according to pack instructions or in boiling water for 30 secs. Remove and cool on kitchen paper. Soak the rice noodles according to pack instructions, then drain and cut them into 2cm strips. Lay a rice pancake on a board and arrange some rice noodles, chicken, vegetables and herb leaves about a third of the way up, leaving a 1cm edge at the side. Fold the sides over the vegetables and then roll up lengthways to make a cigar. Store in the fridge, covered with moist kitchen paper for up to 1 day. Mix together the ingredients for the dipping sauce and put into a bo…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'fluffy', 'saucy'] (0.50, keywords: chewy, fluffy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 13 ingredients, 30 min, technique: wrap each)

### mdb-53242
**Barbecue pork buns** · Pork · area: Vietnamese
- ingredients: 85g Sugar, 500g White Bread Mix, 1 tablespoon Vegetable Oil, 12 Bacon, Knob Ginger, 2 cloves chopped Garlic, 2 tablespoons Soy Sauce, 3 tablespoons Honey, 3 tablespoons Tomato Puree, 1 beaten Egg
- method (5 steps): Heat the oven to 200C/fan 180C/gas. Mix the sugar into the bread mix in a large bowl, then add water as instructed on the pack. Bring the dough together with a wooden spoon, then knead on a lightly floured surface for 5 mins until smooth. Put into a large bowl, cover with oiled cling film then leave in a warm place until doubled in size. Meanwhile, heat the oil in a pan, then fry the bacon until crisp, about 5 mins. Add the ginger and garlic and fry for 1 min until soft, then tip in the soy, honey and tomato purée and stir well. Can be made up to 3 days ahead. Turn out the dough and knead brie…
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 90 min, technique: knead)

### mdb-53243
**Vietnamese prawn spiralized rolls** · Seafood · area: Vietnamese
- ingredients: Juice of 1/2 Lime, 2 tablespoons Rice Vinegar, 1 tablespoon Palm Sugar, 3 tablespoons Fish Sauce, 1 chopped Birds Eye Chilli, 6 Rice Paper Sheet, Small bunch Mint, Small bunch Coriander, 12 Prawn, 1 large Carrot, 1 Courgette
- method (4 steps): Mix all the ingredients for the dipping sauce along with 50ml water in a bowl and set aside to allow the sugar to dissolve and flavour to infuse. To assemble the rolls, fill a wide bowl with warm water and grab a clean damp tea towel to work on. Dip a rice paper wrapper into the water for a few seconds until it softens then carefully place onto the tea towel. Put a few mint and coriander leaves in the centre of the wrapper then top with two prawns and a small handful of the spiralized veg, which may need to be cut up if the spirals are too long. Fold the sides of the wrapper into the centre, o…
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 55 min)

### mdb-53244
**Prawn & noodle salad with crispy shallots** · Seafood · area: Vietnamese
- ingredients: 200g Rice Noodle, 200g Prawn, 1 sliced Red Onion, 1 sliced Red Chilli, 1 sliced Cucumber, Handful Coriander, Handful Mint, 2 tablespoons Peanut, Juice of 3 Lime, 1 tablespoon Brown Sugar, 2 tsp Fish Sauce, 1 clove peeled crushed Garlic, 5 Slices Shallot, For frying Vegetable Oil, Sprinkling Plain Flour
- method (3 steps): For the crispy shallots, heat 5cm of oil until hot in a wok. You will know the oil is hot enough when one piece of shallot sizzles as soon as it’s dropped in. Toss the shallot slices with flour, shake off excess and fry in the oil until golden. They fry quickly, about 1 min. Drain on kitchen paper, sprinkle with salt and set aside. To make the dressing, mix the lime juice, sugar, fish sauce and garlic and set aside. In a large mixing bowl, pour boiling water over the noodles. Leave them for 2 mins or until they are just cooked, then rinse under cold water. Drain well, shaking the sieve numerou…
- `textures` rule: ['chewy', 'crispy', 'crunchy'] (0.50, keywords: chewy, crispy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 15 ingredients, 35 min)

### mdb-53245
**Noodle bowl salad** · Seafood · area: Vietnamese
- ingredients: 125g Rice Noodle, 200g Sugar Snap Pea, 2 tsp Sesame Oil, 4 sliced Spring Onion, Handful Coriander, 150g Smoked Salmon, To serve Pretzels, 3 tablespoons Soy Sauce, 1 tablespoon Honey, 1 tablespoon Lemon Juice, 1 tablespoon Groundnut Oil, 1 clove finely chopped Garlic, Knob Ginger
- method (2 steps): Drop the noodles into a large bowl, then pour over enough boiling water to cover. Tip in the sliced sugar snaps and leave for 4 minutes. Drain in a colander, put under cold running water to cool off, then drain again. Tip into a bowl and toss in the sesame oil. Mix the dressing ingredients. Pile spring onions, coriander and salmon onto the noodles, pour over the dressing and toss everything together. Serve with a pretzel or bread roll.
- `textures` rule: ['chewy', 'crunchy', 'fluffy'] (0.50, keywords: chewy, crunchy, fluffy)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 13 ingredients, 30 min)

### mdb-53246
**Tangy carrot, cabbage & onion salad** · Vegetarian · area: Vietnamese
- ingredients: 4 sliced Carrot, 1/2 Red Cabbage, 2 sliced Red Onion, Handful Mint, Handful Coriander, Handful Peanut, Juice of 2 Lime, 1 tablespoon Groundnut Oil, 1 chopped Red Chilli, 1 tablespoon Brown Sugar
- method (1 steps): Tip the carrots, cabbage and onions into a bowl. Make the dressing by stirring the ingredients together until the sugar has dissolved. Pour over salad, tossing the vegetables in the dressing. Add the herbs, toss again, then scatter over the peanuts.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 10 ingredients, 50 min)

### mdb-53247
**Sea bass with sizzled ginger, chilli & spring onions** · Seafood · area: Vietnamese
- ingredients: 6 Sea Bass Fillet, 3 tablespoons Vegetable Oil, Knob Ginger, 3 sliced thinly Garlic, 3 Large Red Chilli, Bunch Spring Onion, 1 tablespoon Soy Sauce
- method (6 steps): Season 6 sea bass fillets with salt and pepper, then slash the skin 3 times. Heat a heavy-based frying pan and add 1 tbsp sunflower oil. Once hot, fry the sea bass fillets, skin-side down, for 5 mins or until the skin is very crisp and golden. The fish will be almost cooked through. Turn over, cook for another 30 seconds - 1 minute, then transfer to a serving plate and keep warm. You’ll need to fry the sea bass fillets in 2 batches. Heat 2 tbsp sunflower oil, then fry the large knob of peeled ginger, cut into matchsticks, 3 thinly sliced garlic cloves and 3 thinly shredded red chillies for abo…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 7 ingredients, 40 min)

### mdb-53248
**Salmon noodle wraps** · Seafood · area: Vietnamese
- ingredients: 100g Rice Noodle, 3 sliced thinly Spring Onion, 50g Pea, 85g Red Chilli, 85g Coriander, 85g Lime, 300g Salmon
- method (4 steps): Heat oven to 200C/fan 180C/gas. Put the noodles in a bowl and pour over enough boiling water to just cover them. Leave for 2 mins, until they are bendable, but not too soft, then drain well. Return to the bowl with the spring onions, petit pois, salt and pepper and a third of the butter. Mix well until the butter has melted. Pile the noodles and vegetables onto two large squares of baking parchment, then sit the salmon on top. Slice the remaining butter and arrange over the top of the salmon. Bring the ends of the paper over the fish, fold them together to seal, then tuck the ends of the paper…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 40 min)

### mdb-53249
**Turkey Bánh mì** · Miscellaneous · area: Vietnamese
- ingredients: 2 small Baguette, 50g Chicken Liver, 1/4 Cucumber, 140g Turkey, 1 tablespoon Mayonnaise, 1 sliced Red Chilli, Handful Mint, 2 small Carrot, 75g Red Cabbage, 1/4 tsp Ground Ginger, ½ tablespoon Rice Vinegar, 1/2 teaspoon Sugar
- method (2 steps): To make the pickled slaw, tip the carrots and cabbage into a large bowl. In a small bowl, combine the ginger, rice vinegar, sugar and a few pinches of salt. Pour over the vegetables and toss together. Set aside for at least 15 mins. Halve the baguettes lengthways and spread the pâté over the bottom half. Top with the pickled slaw, cucumber and turkey. Mix the mayonnaise with the chopped chilli and dollop over the top. Scatter over the mint leaves and sliced chilli. Sandwich together and dig in.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Miscellaneous guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 12 ingredients, 75 min)

### mdb-53250
**Vegan banh mi** · Vegan · area: Vietnamese
- ingredients: 150g Vegetable, 3 tablespoons Vegan White Wine Vinegar, 1 tsp Sugar, 1 large Baguette, 100g Hummus, 175g Tempeh, Handful Coriander, Handful Mint, To serve Hot Sauce
- method (3 steps): Put the shredded veg in a bowl and add the vinegar, sugar and 1 tsp salt. Toss everything together, then set aside to pickle quickly while you prepare the rest of the sandwich. Heat oven to 180C/160C fan/gas. Cut the baguette into four, then slice each piece horizontally in half. Put the baguette pieces in the oven for 5 mins until lightly toasted and warm. Spread each piece with a layer of hummus, then top four pieces with the tempeh slices and pile the pickled veg on top. To serve, sprinkle over the herbs and squeeze over some hot sauce, then top with the other baguette pieces to make sandwi…
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 30 min)

### mdb-53251
**Turkish lahmacun** · Beef · area: Vietnamese
- ingredients: 500g Strong White Flour, 10g Yeast, Sprinkling Cornflour, 2 Tomato, 2 Green Chilli, 4 Chopped Spring Onion, Bunch Parsley, 250g Beef Mince, 2 tsp Chilli Flakes, Pinch Ground Cumin, 1 tsp Ground Allspice, 2 tablespoons Olive Oil, 1/2 Lemon, 1 Red Onion
- method (8 steps): Sift the flour into a large bowl, make a well in the middle and sprinkle in the yeast. Pour 125ml water over the yeast, then flick flour over the liquid to create a layer. Cover and leave to rise in a warm place for 15 mins until cracks appear on the surface of that layer. Use your hands to mix in 250ml more water along with 1 tsp salt and knead the dough for about 10 mins until elastic and no longer sticky. Add a little more flour if you need to. Cover and leave to rise again in a warm place for 30 mins until doubled in size. Heat the oven to as high as it will go (about 240C/220C fan/gas 9) …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 14 ingredients, 110 min, technique: knead)

### mdb-53252
**Turkish rice (vermicelli rice)** · Miscellaneous · area: Turkish
- ingredients: 300g Rice, 3 tablespoons Vegetable Oil, 70g Vermicelli Pasta, 30g Butter, 600ml Chicken Stock
- method (5 steps): Pour the rice into a very large bowl under cold running water and carefully drain the water out of the bowl through a sieve. Repeat a few times until the water in the bowl is clear, then fill the bowl up with cold water and leave rice to soak for 10 mins while you cook the vermicelli. Put the oil into a medium pan over medium heat. Add the vermicelli and stir continuously until the strands turn a rich golden brown, 2-3 mins. Remove from the heat, stir through the butter until it melts and allow the vermicelli to cool for 1-2 mins. Drain the rice thoroughly through a sieve. Add the rice to the …
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 5 ingredients, 40 min)

### mdb-53253
**Imam bayildi with BBQ lamb & tzatziki** · Lamb · area: Turkish
- ingredients: 3 Aubergine, 2 tablespoons Olive Oil, 1 chopped Onion, 2 cloves chopped Garlic, 1 tsp Cinnamon, 8 Tomato, Bunch Parsley, 12 Lamb Loin Chop, Pinch Paprika, 1 Lemon, 150g Greek Yogurt, 1/2 Cucumber, 2 tbs chopped Mint
- method (8 steps): Heat oven to 190C/170C fan/gas. Halve the aubergines lengthways and score the flesh side deeply, brush with a good layer of olive oil and put on a baking sheet. Roast for 20 mins or until the flesh is soft enough to scoop out. Fry the onion in a little oil until soft, add the garlic and cinnamon and fry for 1 min. Once the aubergines are cool enough to handle, scoop out the centres. Roughly chop the flesh and add it to the onions. Halve the tomatoes, scoop the seeds and juice into a sieve set over a bowl, then chop the flesh. Add the chopped tomatoes to the pan and cook everything for 10 mins …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 13 ingredients, 105 min)
