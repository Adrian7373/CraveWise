# AI tagging batch 002

Write `tools/seedgen/tags/ai/batch-002.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53065
**Sushi** · Seafood · area: Japanese
- ingredients: 300ml Sushi Rice, 100ml Rice Wine, 2 tbs Sugar, 3 tbs Mayonnaise, 1 tbs Rice Wine, 1 tbs Soy Sauce, 1 Cucumber
- method (11 steps): TO MAKE SUSHI ROLLS: Pat out some rice. Lay a nori sheet on the mat, shiny-side down. Dip your hands in the vinegared water, then pat handfuls of rice on top in a 1cm thick layer, leaving the furthest edge from you clear. Spread over some Japanese mayonnaise. Use a spoon to spread out a thin layer of mayonnaise down the middle of the rice. Add the filling. Get your child to top the mayonnaise with a line of their favourite fillings – here we’ve used tuna and cucumber. Roll it up. Lift the edge of the mat over the rice, applying a little pressure to keep everything in a tight roll. Stick down t…
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 11 steps, 7 ingredients, 50 min)

### mdb-53191
**Pad Thai** · Seafood · area: Thai
- ingredients: 125g Rice Noodle, Juice of 3 Lime, 1/2 teaspoon Cayenne Pepper, 2 teaspoons Muscovado Sugar, 2 tablespoons Fish Sauce, 2 tablespoons Vegetable Oil, 200g Prawn, 4 finely sliced Spring Onion, 140g Bean Sprout, 25g Peanut, Handful Coriander, 2 Lime, To serve Sweet Chilli Sauce
- method (4 steps): Put the noodles in a large heatproof bowl, pour boiling water over them and leave for 4 minutes, then drain and refresh under cold running water. Put the lime juice, cayenne, sugar and fish sauce in a bowl and mix well. Have all the other ingredients ready by the cooker. Heat the oil and fry the prawns until warmed through. Add the spring onions and noodles and toss around. Tip in the lime juice mixture, then stir in the beansprouts and half the peanuts and coriander. Cook for 1 minute until everything is heated through. Pile into a large dish, scatter with the rest of the peanuts and coriande…
- `textures` rule: ['chewy', 'crunchy', 'saucy'] (0.50, keywords: chewy, crunchy, saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 13 ingredients, 30 min, technique: proof)

### mdb-52814
**Thai Green Curry** · Chicken · area: Thai
- ingredients: 225g new Potato, 100g Green Bean, 1 tbsp Vegetable Oil, 1 clove Garlic, 4 tsp Thai Green Curry Paste, 400ml Coconut Milk, 2 tsp Fish Sauce, 1 tsp Sugar, 450g boneless Chicken, 2 fresh kaffir leaves Lime, handfull Basil, Boiled Rice
- method (4 steps): Put the potatoes in a pan of boiling water and cook for 5 minutes. Throw in the beans and cook for a further 3 minutes, by which time both should be just tender but not too soft. Drain and put to one side. In a wok or large frying pan, heat the oil until very hot, then drop in the garlic and cook until golden, this should take only a few seconds. Don’t let it go very dark or it will spoil the taste. Spoon in the curry paste and stir it around for a few seconds to begin to cook the spices and release all the flavours. Next, pour in the coconut milk and let it come to a bubble. Stir in the fish …
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 45 min, technique: truss)

### mdb-53194
**Tom yum soup with prawns** · Seafood · area: Thai
- ingredients: 200g Onion, 150g Tomato, 20g Red Chilli, 15g Galangal, 2 Lemongrass, 250g Prawn, 1 Chicken Stock, 120g Oyster Mushroom, 8 Makrut Lime Leaf, 25 ml Fish Sauce, 25 ml Lime Juice, 70 ml Coconut Milk, 1 tblsp Thai Chilli Jam, Handful Coriander
- method (3 steps): Pour 1.3 litres water into a large saucepan over a high heat. Add the onion, tomato, chilli, galangal, lemongrass, prawn heads and chicken stock cube. Stir and bring to a boil, then reduce the heat to medium and simmer for 20 mins until the liquid has reduced. Carefully strain the hot broth into a large heatproof bowl or jug, then discard the prawn heads. Return the strained veg and herb mixture to the saucepan and pour over the broth. Stir through the mushrooms and lime leaves, then cook for 3 mins until the mushrooms are tender. Add 1 tbsp sugar, the fish sauce, lime juice, coconut milk and …
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 14 ingredients, 55 min, technique: proof)

### mdb-53238
**Beef pho** · Beef · area: Vietnamese
- ingredients: 1 L Beef Stock, 1 large Onion, 1 Large Chopped Ginger, 1 Cinnamon Stick, 2 Star Anise, 1 tsp Coriander Seed, 1/2 teaspoon Clove, 225g Sirloin Steak, 1 tsp Palm Sugar, 1 tablespoon Fish Sauce, 1 ½ tbsp Soy Sauce, 200g Rice Noodle, 2 sliced Spring Onion, 1 small Birds Eye Chilli, Handful Basil, Handful Coriander, 1 Lime
- method (4 steps): Tip the beef stock along with 500ml of water into a large saucepan. Sit the onion and ginger in a frying pan over a high heat and char on all sides, around 3-5 mins (you can also do this under your grill). Once charred, add to the beef stock. In the same pan, toast the spices for 2-3 mins and once they begin to smell fragrant, add them to the beef stock as well. Bring the stock to the boil, then turn to a simmer and cook for 30mins before straining. Meanwhile, cut the fat from the steak and wrap in cling film, then put into the freezer for 15 mins – this will make your steak really easy to sli…
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 17 ingredients, 90 min)

### mdb-53053
**Beef Rendang** · Beef · area: Malaysian
- ingredients: 1lb Beef, 5 tbs Vegetable Oil, 1 Cinnamon Stick, 3 Clove, 3 Star Anise, 3 Cardamom, 1 cup Coconut Cream, 1 cup Water, 2 tbs Tamarind Paste, 6 Lime, 1 tbs Sugar, 5 Shallot
- method (4 steps): Chop the spice paste ingredients and then blend it in a food processor until fine. Heat the oil in a stew pot, add the spice paste, cinnamon, cloves, star anise, and cardamom and stir-fry until aromatic. Add the beef and the pounded lemongrass and stir for 1 minute. Add the coconut milk, tamarind juice, water, and simmer on medium heat, stirring frequently until the meat is almost cooked. Add the kaffir lime leaves, kerisik (toasted coconut), sugar or palm sugar, stirring to blend well with the meat. Lower the heat to low, cover the lid, and simmer for 1 to 1 1/2 hours or until the meat is rea…
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 150 min)

### mdb-52819
**Cajun spiced fish tacos** · Seafood · area: Mexican
- ingredients: 2 tbsp Cajun, 1 tsp Cayenne Pepper, 4 fillets White Fish, 1 tsp Vegetable Oil, 8 Flour Tortilla, 1 sliced Avocado, 2 shredded Lettuce, 4 shredded Spring Onion, 1 x 300ml Salsa, 1 pot Sour Cream, 1 Lemon, 1 clove finely chopped Garlic
- method (5 steps): Cooking in a cajun spice and cayenne pepper marinade makes this fish super succulent and flavoursome. Top with a zesty dressing and serve in a tortilla for a quick, fuss-free main that's delightfully summery. On a large plate, mix the cajun spice and cayenne pepper with a little seasoning and use to coat the fish all over. Heat a little oil in a frying pan, add in the fish and cook over a medium heat until golden. Reduce the heat and continue frying until the fish is cooked through, about 10 minutes. Cook in batches if you don’t have enough room in the pan. Meanwhile, prepare the dressing by c…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky'] (0.50, keywords: creamy, flaky)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 35 min)

### mdb-52813
**Kentucky Fried Chicken** · Chicken · area: United States
- ingredients: 1 whole Chicken, 2 quarts neutral frying Vegetable Oil, 1 Egg White, 1 1/2 cups Plain Flour, 1 tablespoon Brown Sugar, 1 tablespoon Salt, 1 tablespoon Paprika, 2 teaspoons Onion Salt, 1 teaspoon Chilli Powder, 1 teaspoon Black Pepper, 1/2 teaspoon Celery Salt, 1/2 teaspoon Sage, 1/2 teaspoon Garlic Powder, 1/2 teaspoon Ground Allspice, 1/2 teaspoon Oregano, 1/2 teaspoon Basil, 1/2 teaspoon Marjoram
- method (6 steps): Preheat fryer to 350°F. Thoroughly mix together all the spice mix ingredients. Combine spice mix with flour, brown sugar and salt. Dip chicken pieces in egg white to lightly coat them, then transfer to flour mixture. Turn a few times and make sure the flour mix is really stuck to the chicken. Repeat with all the chicken pieces. Let chicken pieces rest for 5 minutes so crust has a chance to dry a bit. Fry chicken in batches. Breasts and wings should take 12-14 minutes, and legs and thighs will need a few more minutes. Chicken pieces are done when a meat thermometer inserted into the thickest pa…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 17 ingredients, 50 min)

### mdb-52858
**New York cheesecake** · Dessert · area: United States
- ingredients: 85g Butter, 140g Sour Cream, 1tbsp Sugar, 900g Cream Cheese, 250g Sugar, 3 tbs Plain Flour, 1 ½ teaspoons Lemon Juice, 3 Large Egg, 250ml Sour Cream, 150ml Sour Cream, 1 tbsp Sugar, 2 tsp Lemon Juice
- method (12 steps): Position an oven shelf in the middle of the oven. Preheat the oven to fan 160C/conventional 180C/gas. Line the base of a 23cm springform cake tin with parchment paper. For the crust, melt the butter in a medium pan. Stir in the biscuit crumbs and sugar so the mixture is evenly moistened. Press the mixture into the bottom of the pan and bake for 10 minutes. Cool on a wire rack while preparing the filling. For the filling, increase the oven temperature to fan 200C/conventional 240C/gas. In a table top mixer fitted with the paddle attachment, beat the soft cheese at medium-low speed until creamy,…
- `textures` rule: ['creamy', 'crispy', 'smooth'] (0.50, keywords: creamy, crispy, smooth)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 12 ingredients, 675 min, technique: temper)

### mdb-52854
**Pancakes** · Dessert · area: United States
- ingredients: 100g Plain Flour, 2 large Egg, 300ml Milk, 1 tbls Vegetable Oil, to serve Sugar, to serve Raspberry, to serve Blueberry
- method (3 steps): Put the flour, eggs, milk, 1 tbsp oil and a pinch of salt into a bowl or large jug, then whisk to a smooth batter. Set aside for 30 mins to rest if you have time, or start cooking straight away. Set a medium frying pan or crêpe pan over a medium heat and carefully wipe it with some oiled kitchen paper. When hot, cook your pancakes for 1 min on each side until golden, keeping them warm in a low oven as you go. Serve with lemon wedges and sugar, or your favourite filling. Once cold, you can layer the pancakes between baking parchment, then wrap in cling film and freeze for up to 2 months.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy', 'smooth'] (0.50, keywords: crispy, fluffy, smooth)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 50 min)

### mdb-53151
**Paella** · Seafood · area: Spanish
- ingredients: 3 tablespoons Olive Oil, 10 Prawn, Bunch Parsley, 100 ml Sherry, 500g Mussel, Pinch Saffron, 150g Chorizo, 1 chopped Onion, 3 cloves Garlic, 1 medium Squid, 2 Tomato, 250g Paella Rice, 100g Broad Bean, 1 Lemon Zest
- method (9 steps): Heat 1 tbsp of the oil in a wide, shallow pan. Add the prawn heads and parsley stalks and sizzle until the heads turn pink, then mash with a potato masher. Pour over the sherry or wine and 300ml water, season with salt and simmer for 10 mins to make a stock, mashing the prawn heads as they cook. Scatter the mussels into the pan, cover the pan loosely with a lid or tea towel, then put over a high heat for 3-4 mins until the mussels just open. Stir to release the mussel juices, then pour the contents of the pan into a colander set over a large bowl containing the saffron. Let the saffron steep i…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 14 ingredients, 65 min)

### mdb-52872
**Spanish Tortilla** · Vegetarian · area: Spanish
- ingredients: 1 sliced Onion, 4 tbsp Olive Oil, 25g Butter, 400g Potato, 6 cloves Garlic, 8 Egg, Handful Parsley, 1 Baguette, 4 Tomato, drizzle Olive Oil
- method (5 steps): Put a large non-stick frying pan on a low heat. Cook the onion slowly in the oil and butter until soft but not brown – this should take about 15 mins. Add the potatoes, cover the pan and cook for a further 15-20 mins, stirring occasionally to make sure they fry evenly. When the potatoes are soft and the onion is shiny, crush 2 garlic cloves and stir in, followed by the beaten eggs. Put the lid back on the pan and leave the tortilla to cook gently. After 20 mins, the edges and base should be golden, the top set but the middle still a little wobbly. To turn it over, slide it onto a plate and put…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 80 min)

### mdb-53006
**Moussaka** · Beef · area: Greek
- ingredients: 500g Beef, 1 large Aubergine, 150g Greek Yogurt, 1 beaten Egg, 3 tbs Parmesan, 400g Tomato, 4 tbs Tomato Puree, 350g Potato
- method (2 steps): Heat the grill to high. Brown the beef in a deep ovenproof frying pan over a high heat for 5 mins. Meanwhile, prick the aubergine with a fork, then microwave on High for 3-5 mins until soft. Mix the yogurt, egg and parmesan together, then add a little seasoning. Stir the tomatoes, purée and potatoes in with the beef with some seasoning and heat through. Smooth the surface of the beef mixture with the back of a spoon, then slice the cooked aubergine and arrange on top. Pour the yogurt mixture over the aubergines, smooth out evenly, then grill until the topping has set and turned golden.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 30 min, technique: proof)

### mdb-53266
**Falafel** · Vegetarian · area: Turkish
- ingredients: 2 tablespoons Vegetable Oil, 1 chopped Onion, 1 clove peeled crushed Garlic, 400g Chickpea, 1 tsp Ground Cumin, 1 tsp Ground Coriander, Handful Parsley, 1 beaten Egg
- method (2 steps): Heat 1 tbsp oil in a large pan, then fry the onion and garlic over a low heat for 5 mins until softened. Tip into a large mixing bowl with the chickpeas and spices, then mash together with a fork or potato masher until the chickpeas are totally broken down. Stir in the parsley or dried herbs, with seasoning to taste. Add the egg, then squish the mixture together with your hands. Mould the mix into 6 balls, then flatten into patties. Heat the remaining oil in the pan, then fry the falafels on a medium heat for 3 mins on each side, until golden brown and firm. Serve hot or cold with couscous, pi…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy'] (0.50, keywords: creamy, fluffy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 30 min)

### mdb-53269
**Hummus** · Side · area: Turkish
- ingredients: 400g Chickpea, 1 tablespoon Tahini, 1 large Garlic, 3 tablespoons Greek Yogurt, Juice of half Lemon
- method (3 steps): Drain the chickpeas into a sieve set over a bowl or jug to catch the liquid. Tip the chickpeas, tahini, garlic and yogurt into a food processor or blender and whizz to smooth. Whizz in a tbsp of the chickpea liquid at a time until you have a nice consistency, then scrape into a bowl. Stir in a squeeze of lemon juice and season to taste.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 5 ingredients, 30 min)

### mdb-52843
**Lamb Tagine** · Lamb · area: Moroccan
- ingredients: 2 tblsp Olive Oil, 1 finely sliced Onion, 2 chopped Carrot, 500g Lamb Leg, 2 cloves minced Garlic, ½ tsp Ground Cumin, ½ tsp Ginger, ¼ tsp Saffron, 1 tsp Cinnamon, 1 tblsp Honey, 100g Apricot, 1 Vegetable Stock, 1 medium chopped Butternut Squash, Steamed Couscous, Chopped Parsley
- method (4 steps): Heat the olive oil in a heavy-based pan and add the onion and carrot. Cook for 3- 4 mins until softened. Add the diced lamb and brown all over. Stir in the garlic and all the spices and cook for a few mins more or until the aromas are released. Add the honey and apricots, crumble in the stock cube and pour over roughly 500ml boiling water or enough to cover the meat. Give it a good stir and bring to the boil. Turn down to a simmer, put the lid on and cook for 1 hour. Remove the lid and cook for a further 30 mins, then stir in the squash. Cook for 20 – 30 mins more until the squash is soft and …
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'fluffy', 'saucy'] (0.50, keywords: crunchy, fluffy, saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 15 ingredients, 145 min)

### mdb-52937
**Jerk chicken with rice & peas** · Chicken · area: Jamaican
- ingredients: 12 Chicken Thigh, 1/2 Lime, 1 bunch Spring Onion, 1 tbs chopped Ginger, 3 cloves Garlic, 1/2 Onion, 3 chopped Red Chilli, 1/2 teaspoon Thyme, Juice of 1 Lime, 2 tbs Soy Sauce, 2 tbs Vegetable Oil, 3 tbs Brown Sugar, 1 tbs Ground Allspice, 200g Basmati Rice, 400g Coconut Milk, 1 bunch Spring Onion, 2 sprigs Thyme, 2 cloves chopped Garlic, 1 tbs Ground Allspice, 800g Kidney Bean
- method (7 steps): To make the jerk marinade, combine all the ingredients in a food processor along with 1 tsp salt, and blend to a purée. If you’re having trouble getting it to blend, just keep turning off the blender, stirring the mixture, and trying again. Eventually it will start to blend up – don’t be tempted to add water, as you want a thick paste. Taste the jerk mixture for seasoning – it should taste pretty salty, but not unpleasantly, puckering salty. You can now throw in more chillies if it’s not spicy enough for you. If it tastes too salty and sour, try adding in a bit more brown sugar until the mixtu…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 20 ingredients, 665 min)

### mdb-53354
**Jamaican Curry Goat** · Goat · area: Jamaican
- ingredients: 3 Lbs Goat Meat, 2.5 tbsp Curry Powder, 1/2 tsp Ground Ginger, 1/2 tsp All Purpose Seasoning, 1/4 tsp Ground Allspice, 1 chopped Onion, 6 cloves sliced Garlic, 3 sprigs Thyme, 2 tablespoons Vegetable Oil, 1 1/4 cup Water, 1 Scotch Bonnet, 1 large Potato, To taste Salt, To taste Black Pepper
- method (8 steps): Equipment. 6QT Pressure cooker. Rinse goat meat with vinegar and water. Season goat meat with 1 ½ tablespoon curry powder, all-purpose seasoning, ground ginger, allspice, onion, garlic cloves, and thyme. Marinate for at least 4 hours or up to overnight. Remove onion and garlic from goat and set aside. Set an electric pressure cooker, like an Instant Pot, on high sauté and add oil. Add goat meat and brown, about 2-3 minutes per side. Remove goat from insert and add 1 tablespoon oil and remaining curry powder and sauté for about 10 seconds. Then add onions and garlic and sauté until softened. Ab…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 14 ingredients, 335 min)

### mdb-52834
**Beef stroganoff** · Beef · area: Russian
- ingredients: 1 tbls Olive Oil, 1 Onion, 1 clove Garlic, 1 tbsp Butter, 250g Mushroom, 500g Beef Fillet, 1tbsp Plain Flour, 150g Creme Fraiche, 1 tbsp English Mustard, 100ml Beef Stock, Topping Parsley
- method (4 steps): Heat the olive oil in a non-stick frying pan then add the sliced onion and cook on a medium heat until completely softened, so around 15 mins, adding a little splash of water if they start to stick at all. Crush in the garlic and cook for a 2-3 mins further, then add the butter. Once the butter is foaming a little, add the mushrooms and cook for around 5 mins until completely softened. Season everything well, then tip onto a plate. Tip the flour into a bowl with a big pinch of salt and pepper, then toss the steak in the seasoned flour. Add the steak pieces to the pan, splashing in a little oil…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 55 min)

### mdb-53078
**Beetroot Soup (Borscht)** · Vegetarian · area: Ukrainian
- ingredients: 3 Beetroot, 4 tbs Olive Oil, 1 Chicken Stock, 6 cups Water, 3 Potato, 1 can Cannellini Bean, Garnish Dill
- method (1 steps): Chop the beetroot, add water and stock cube and cook for 15mins. Add the other ingredients and boil until soft. Finally add the beans and cook for 5mins. Serve in the soup pot.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 7 ingredients, 40 min)
