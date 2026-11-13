# AI tagging batch 005

Write `tools/seedgen/tags/ai/batch-005.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52817
**Stovetop Eggplant With Harissa, Chickpeas, and Cumin Yogurt** · Vegetarian · area: United States
- ingredients: 4 tablespoons Olive Oil, 6 small Aubergine, ½ tablespoon Harissa Spice, 1 can Chickpea, 2 cups halved Cherry Tomato, 1 1/2 cups Greek Yogurt, 1 tablespoon Ground Cumin, ½ cup Parsley
- method (4 steps): Heat the oil in a 12-inch skillet over high heat until shimmering. Add the eggplants and lower the heat to medium. Season with salt and pepper as you rotate the eggplants, browning them on all sides. Continue to cook, turning regularly, until a fork inserted into the eggplant meets no resistance (you may have to stand them up on their fat end to finish cooking the thickest parts), about 20 minutes, lowering the heat and sprinkling water into the pan as necessary if the eggplants threaten to burn or smoke excessively. Mix the harissa, chickpeas and tomatoes together, then add to the eggplants. …
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 40 min)

### mdb-52818
**Chicken Fajita Mac and Cheese** · Chicken · area: United States
- ingredients: 500g Macaroni, 2 cups Chicken Stock, 1/2 cup Double Cream, 1 packet Fajita Seasoning, 1 tsp Salt, 3 diced Chicken Breast, 2 tbsp Olive Oil, 1 small finely diced Onion, 2 finely diced Red Pepper, 2 cloves minced Garlic, 1 cup Cheddar, garnish chopped Parsley
- method (4 steps): Fry your onion, peppers and garlic in olive oil until nicely translucent. Make a well in your veg and add your chicken. Add your seasoning and salt. Allow to colour slightly. Add your cream, stock and macaroni. Cook on low for 20 minutes. Add your cheeses, stir to combine. Top with roasted peppers and parsley.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 45 min)

### mdb-52820
**Katsu Chicken curry** · Chicken · area: Japanese
- ingredients: 4 pounded to 1cm thickness Chicken Breast, 2 tablespoons Plain Flour, 1 beaten Egg, 100g fine Breadcrumb, 230ml frying Vegetable Oil, 2 tablespoons Vegetable Oil, 2 sliced Onion, 5 chopped cloves Garlic, 2 sliced Carrot, 2 tablespoons Plain Flour, 4 teaspoons Curry Powder, 600ml Chicken Stock, 2 teaspoons Honey, 4 teaspoons Soy Sauce, 1 Bay Leaf, 1 teaspoon Garam Masala
- method (7 steps): Prep:15min › Cook:30min › Ready in:45min. For the curry sauce: Heat oil in medium non-stick saucepan, add onion and garlic and cook until softened. Stir in carrots and cook over low heat for 10 to 12 minutes. Add flour and curry powder; cook for 1 minute. Gradually stir in stock until combined; add honey, soy sauce and bay leaf. Slowly bring to the boil. Turn down heat and simmer for 20 minutes or until sauce thickens but is still of pouring consistency. Stir in garam masala. Pour the curry sauce through a sieve; return to saucepan and keep on low heat until ready to serve. For the chicken: Se…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 16 ingredients, 110 min)

### mdb-52821
**Laksa King Prawn Noodles** · Seafood · area: Malaysian
- ingredients: 1 tbsp Olive Oil, 1 finely sliced Red Chilli, 2 ½ tbsp Red Curry Paste, 1 Vegetable Stock, 400ml can Coconut Milk, 2 tsp Fish Sauce, 100g Rice Noodle, 2 juice of 1, the other halved Lime, 150g Prawn, ½ small pack Coriander
- method (3 steps): Heat the oil in a medium saucepan and add the chilli. Cook for 1 min, then add the curry paste, stir and cook for 1 min more. Dissolve the stock cube in a large jug in 700ml boiling water, then pour into the pan and stir to combine. Tip in the coconut milk and bring to the boil. Add the fish sauce and a little seasoning. Toss in the noodles and cook for a further 3-4 mins until softening. Squeeze in the lime juice, add the prawns and cook through until warm, about 2-3 mins. Scatter over some of the coriander. Serve in bowls with the remaining coriander and lime wedges on top for squeezing over…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 30 min)

### mdb-52822
**Toad In The Hole** · Pork · area: British
- ingredients: 8 Sausage, 3 tbsp Vegetable Oil, 100g Plain Flour, 2 medium Egg, 1 tbsp grated Horseradish, 225ml Milk, 200g Cherry Tomato
- method (4 steps): Preheat the oven to 200°C/fan180°C/gas 6. fry sausages in a non-stick pan until browned. Drizzle vegetable oil in a 30cm x 25cm x 6cm deep roasting tray and heat in the oven for 5 minutes. Put the plain flour in a bowl, crack in the medium free-range eggs, then stir in the grated horseradish. Gradually beat in the semi-skimmed milk. Season. Put the sausages into the hot roasting tray and pour over the batter. Top with cherry tomatoes on the vine and cook for 30 minutes until puffed and golden.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 55 min)

### mdb-52823
**Salmon Prawn Risotto** · Seafood · area: Italian
- ingredients: 50g/2oz Butter, 1 finely chopped Onion, 150g Rice, 125ml White Wine, 1 litre hot Vegetable Stock, The juice and zest of one Lemon, 240g large Prawn, 150g Salmon, 100g tips blanched briefly in boiling water Asparagus, ground Black Pepper, 50g shavings Parmesan
- method (4 steps): Melt the butter in a thick-based pan and gently cook the onion without colour until it is soft. Add the rice and stir to coat all the grains in the butter Add the wine and cook gently stirring until it is absorbed Gradually add the hot stock, stirring until each addition is absorbed. Keep stirring until the rice is tender Season with the lemon juice and zest, and pepper to taste. (there will probably be sufficient saltiness from the salmon to not need to add salt) Stir gently to heat through Serve scattered with the Parmesan and seasonal vegetables. Grill the salmon and gently place onto the r…
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 55 min)

### mdb-52824
**Beef Sunday Roast** · Beef · area: British
- ingredients: 8 slices Beef, 12 florets Broccoli, 1 Packet Potato, 1 Packet Carrot, 140g Plain Flour, 4 Egg, 200ml Milk, drizzle (for cooking) Vegetable Oil
- method (8 steps): Cook the Broccoli and Carrots in a pan of boiling water until tender. Roast the Beef and Potatoes in the oven for 45mins, the potatoes may need to be checked regularly to not overcook. To make the Yorkshire puddings:. Heat oven to 230C/fan 210C/gas. Drizzle a little sunflower oil evenly into 2 x 4-hole Yorkshire pudding tins or a 12-hole non-stick muffin tin and place in the oven to heat through To make the batter, tip 140g plain flour into a bowl and beat in four eggs until smooth. Gradually add 200ml milk and carry on beating until the mix is completely lump-free. Season with salt and pepper…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 8 ingredients, 80 min)

### mdb-52826
**Braised Beef Chilli** · Beef · area: Mexican
- ingredients: 1kg Beef, 3 Onion, 4 cloves Garlic, Dash Olive Oil, 300g Chorizo, 2 tsp Ground Cumin, 2 tsp Ground Allspice, 1 tsp Clove, 1 large Cinnamon Stick, 3 Bay Leaf, 2 tsp dried Oregano, 2 ancho Ancho Chilli, 3 tbsp Balsamic Vinegar, 2 x 400g Tomato, 2 tbsp Tomato Ketchup, 2 tbsp Brown Sugar, 2 x 400g tins Borlotti Bean
- method (5 steps): Preheat the oven to 120C/225F/gas mark 1. Take the meat out of the fridge to de-chill. Pulse the onions and garlic in a food processor until finely chopped. Heat 2 tbsp olive oil in a large casserole and sear the meat on all sides until golden. Set to one side and add another small slug of oil to brown the chorizo. Remove and add the onion and garlic, spices, herbs and chillies then cook until soft in the chorizo oil. Season with salt and pepper and add the vinegar, tomatoes, ketchup and sugar. Put all the meat back into the pot with 400ml water (or red wine if you prefer), bring up to a simme…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 17 ingredients, 150 min)

### mdb-52827
**Massaman Beef curry** · Beef · area: Thai
- ingredients: 85g Peanut, 400ml can Coconut Cream, 4 tbsp Massaman Curry Paste, 600g stewing cut into strips Beef, 450g waxy Potato, 1 cut thin wedges Onion, 4 leaves Lime, 1 Cinnamon Stick, 1 tbsp Tamarind Paste, 1 tbsp palm or soft light Brown Sugar, 1 tbsp Fish Sauce, 1 red deseeded and finely sliced, to serve Red Chilli, to serve Jasmine Rice
- method (4 steps): Heat oven to 200C/180C fan/gas 6, then roast the peanuts on a baking tray for 5 mins until golden brown. When cool enough to handle, roughly chop. Reduce oven to 180C/160C fan/gas 4. Heat 2 tbsp coconut cream in a large casserole dish with a lid. Add the curry paste and fry for 1 min, then stir in the beef and fry until well coated and sealed. Stir in the rest of the coconut with half a can of water, the potatoes, onion, lime leaves, cinnamon, tamarind, sugar, fish sauce and most of the peanuts. Bring to a simmer, then cover and cook for 2 hrs in the oven until the beef is tender. Sprinkle wit…
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 13 ingredients, 160 min)

### mdb-52828
**Vietnamese Grilled Pork (bun-thit-nuong)** · Pork · area: Vietnamese
- ingredients: 1.5 pounds sliced Pork, 1 package thin Rice Noodle, 4-6 Egg Roll, 3 tablespoons minced Shallot, 1.5 tablespoons minced garlic Garlic, ¼ cup Sugar, 1 tablespoon Fish Sauce, ½ tablespoon thick Soy Sauce, ½ tablespoon Black Pepper, 3 tablespoons Olive Oil, Sliced Cucumber, Leaves Mint, Crushed Peanut
- method (5 steps): Slice the uncooked pork thinly, about ⅛". It helps to slightly freeze it (optional). Mince garlic and shallots. Mix in a bowl with sugar, fish sauce, thick soy sauce, pepper, and oil until sugar dissolves. Marinate the meat for 1 hour, or overnight for better results. Bake the pork at 375F for 10-15 minutes or until about 80% cooked. Finish cooking by broiling in the oven until a nice golden brown color develops, flipping the pieces midway. Assemble your bowl with veggies, noodles, and garnish. Many like to mix the whole bowl up and pour the fish sauce on top, but I like to make individual bit…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crunchy', 'saucy'] (0.50, keywords: chewy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 13 ingredients, 100 min)

### mdb-52829
**Grilled Mac and Cheese Sandwich** · Pasta · area: United States
- ingredients: 8 ounces (230 grams) Macaroni, 1/3 cup Plain Flour, 3/4 teaspoon Mustard Powder, 1/2 teaspoon Garlic Powder, 1/2 teaspoon Salt, 1/2 teaspoon Black Pepper, 1/8 teaspoon Cayenne Pepper, 6 tablespoons (85 grams) Butter, 1 1/2 cups (360 milliliters) Milk, 1 cup (240 milliliters) Double Cream, 1 pound (455 grams) Monterey Jack Cheese, 4 tablespoons (55 grams) Butter, 1 teaspoon Garlic Powder, 16 slices square Bread, 8 slices mild Cheddar, 8 slices Colby Jack Cheese, 4 tablespoons (55 grams) Butter
- method (18 steps): Make the mac and cheese. Bring a medium saucepan of generously salted water (you want it to taste like seawater) to a boil. Add the pasta and cook, stirring occasionally, until al dente, 8 to 10 minutes, or according to the package directions. The pasta should be tender but still chewy. While the pasta is cooking, in a small bowl, whisk together the flour, mustard powder, garlic powder, salt, black pepper, and cayenne pepper. Drain the pasta in a colander. Place the empty pasta pan (no need to wash it) over low heat and add the butter. When the butter has melted, whisk in the flour mixture and…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'saucy'] (0.50, keywords: chewy, creamy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 18 steps, 17 ingredients, 120 min)

### mdb-52830
**Crock Pot Chicken Baked Tacos** · Chicken · area: Mexican
- ingredients: 4 - 6 Chicken Breast, 1 bottle Vinaigrette Dressing, 1½ tablespoon Ground Cumin, 1 tablespoon Smoked Paprika, 1 teaspoon Garlic, 1 can Refried Bean, 12 Hard Taco Shell, 2 cups Shredded Mexican Cheese, Halved Cherry Tomato, Sliced and Seeded Jalapeno, Peeled and Sliced Avocado, 2 tablespoons Green Salsa, 3 tablespoons Sour Cream, 1 tablespoon Milk
- method (12 steps): Put the uncooked chicken breasts in the crock pot. Pour the full bottle of salad dressing over the chicken. Sprinkle the rest of the ingredients over the top and mix them in a bit with a spoon. Cover your crock pot with the lid and cook on high for 4 hours. Remove all the chicken breasts from the crock pot and let cool. Shred the chicken breasts and move to a glass bowl. Pour most of the liquid over the shredded chicken. Make the guacamole sauce by mixing the avocado and green salsa together. Pour the guacamole mixture through a strainer until smooth and transfer to a squeeze bottle. Cut the t…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 14 ingredients, 285 min)

### mdb-52833
**Salted Caramel Cheescake** · Dessert · area: United States
- ingredients: 250g Digestive Biscuit, 75g Pretzels, 135g Butter, 450g Cream Cheese, 1tsp Vanilla Extract, 100g Icing Sugar, 150g Caramel, 1tsp Salt, 300ml Double Cream, drizzle Caramel Sauce, Top Toffee Popcorn, Top Pretzels
- method (5 steps): Blitz the biscuits and the pretzels in a food processor and mix the biscuits with the melted butter. Spread on the bottom of an 8″/20cm Deep Springform Tin and press down firmly. Leave to set in the fridge whilst you make the rest! Using an electric mixer, I use my KitchenAid with the whisk attachment, whisk together the cream cheese, vanilla, and icing sugar until smooth and then add the caramel and whisk again until smooth and lump free – this could take a couple of minutes, I whisk it at half speed so not too quick or slow! Pour in the double cream & Salt flakes and continue to whisk for a …
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 515 min)

### mdb-52835
**Fettucine alfredo** · Pasta · area: Italian
- ingredients: 227g Clotted Cream, 25g Butter, 1 tsp Cornflour, 100g Parmesan, Grated Ground Nutmeg, 250g Fettuccine, Chopped Parsley
- method (5 steps): In a medium saucepan, stir the clotted cream, butter and cornflour over a low-ish heat and bring to a low simmer. Turn off the heat and keep warm. Meanwhile, put the cheese and nutmeg in a small bowl and add a good grinding of black pepper, then stir everything together (don’t add any salt at this stage). Put the pasta in another pan with 2 tsp salt, pour over some boiling water and cook following pack instructions (usually 3-4 mins). When cooked, scoop some of the cooking water into a heatproof jug or mug and drain the pasta, but not too thoroughly. Add the pasta to the pan with the clotted c…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 7 ingredients, 20 min, technique: proof)

### mdb-52836
**Seafood fideuà** · Seafood · area: Spanish
- ingredients: 400g Mussel, 8 Prawn, 2 pinches Saffron, 350g Vermicelli Pasta, 5 tblsp Olive Oil, 1 large Onion, 3 cloves Garlic, 2 tbs Paprika, 1 tail Monkfish, 4 Squid, 650ml Fish Stock, 2 large Tomato, Juice of 1 Lemon, Topping Parsley
- method (11 steps): Boil the kettle. Empty the mussels into a colander and run under cold water. Throw away any with broken shells. Pick through the shells, tapping each one on the side of the sink – they should be closed or should slowly close when tapped – if they stay open, throw them away. If any of the shells still have barnacles or stringy beards attached, pull them off with a cutlery knife and rinse the shells well. Keep in the colander, covered with a cold, damp cloth, until you’re ready to cook. Peel the prawn shells on the body section only – leave the heads and tails intact. Score down the backs and pu…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 14 ingredients, 70 min)

### mdb-52837
**Pilchard puttanesca** · Pasta · area: Italian
- ingredients: 300g Spaghetti, 1 tbls Olive Oil, 1 finely chopped Onion, 2 cloves minced Garlic, 1 Red Chilli, 1 tbls Tomato Puree, 425g Pilchard, 70g Black Olive, Shaved Parmesan
- method (2 steps): Cook the pasta following pack instructions. Heat the oil in a non-stick frying pan and cook the onion, garlic and chilli for 3-4 mins to soften. Stir in the tomato purée and cook for 1 min, then add the pilchards with their sauce. Cook, breaking up the fish with a wooden spoon, then add the olives and continue to cook for a few more mins. Drain the pasta and add to the pan with 2-3 tbsp of the cooking water. Toss everything together well, then divide between plates and serve, scattered with Parmesan.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 25 min)

### mdb-52838
**Venetian Duck Ragu** · Pasta · area: Italian
- ingredients: 1 tbls Olive Oil, 4 Duck Leg, 2 finely chopped Onion, 2 cloves minced Garlic, 2 tsp ground Cinnamon, 2 tsp Plain Flour, 250ml Red Wine, 800g Chopped Tomatoes, 1 Chicken Stock, 3 sprigs Rosemary, 2 Bay Leaf, 1 tsp Sugar, 2 tbs Milk, 600g Paccheri Pasta, Grated Parmesan
- method (5 steps): Heat the oil in a large pan. Add the duck legs and brown on all sides for about 10 mins. Remove to a plate and set aside. Add the onions to the pan and cook for 5 mins until softened. Add the garlic and cook for a further 1 min, then stir in the cinnamon and flour and cook for a further min. Return the duck to the pan, add the wine, tomatoes, stock, herbs, sugar and seasoning. Bring to a simmer, then lower the heat, cover with a lid and cook for 2 hrs, stirring every now and then. Carefully lift the duck legs out of the sauce and place on a plate – they will be very tender so try not to lose a…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 15 ingredients, 180 min)

### mdb-52839
**Chilli prawn linguine** · Pasta · area: Italian
- ingredients: 280g Linguine Pasta, 200g Sugar Snap Pea, 2 tblsp Olive Oil, 2 cloves chopped Garlic, 1 large Red Chilli, 24 Skinned Prawn, 12 Cherry Tomato, Handful Basil, Leaves Lettuce, to serve Bread, 2 tbsp Fromage Frais, Grated Zest of 2 Lime, 2 tsp Sugar
- method (5 steps): Mix the dressing ingredients in a small bowl and season with salt and pepper. Set aside. Cook the pasta according to the packet instructions. Add the sugar snap peas for the last minute or so of cooking time. Meanwhile, heat the oil in a wok or large frying pan, toss in the garlic and chilli and cook over a fairly gentle heat for about 30 seconds without letting the garlic brown. Tip in the prawns and cook over a high heat, stirring frequently, for about 3 minutes until they turn pink. Add the tomatoes and cook, stirring occasionally, for 3 minutes until they just start to soften. Drain the pa…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 13 ingredients, 35 min)

### mdb-52840
**Clam chowder** · Starter · area: United States
- ingredients: 1½ kg Clam, 50g Butter, 150g Bacon, 1 finely chopped Onion, sprigs of fresh Thyme, 1 Bay Leaf, 1 tbls Plain Flour, 150ml Milk, 150ml Double Cream, 2 medium Potato, Chopped Parsley
- method (7 steps): Rinse the clams in several changes of cold water and drain well. Tip the clams into a large pan with 500ml of water. Cover, bring to the boil and simmer for 2 mins until the clams have just opened. Tip the contents of the pan into a colander over a bowl to catch the clam stock. When cool enough to handle, remove the clams from their shells – reserving a handful of empty shells for presentation if you want. Strain the clam stock into a jug, leaving any grit in the bottom of the bowl. You should have around 800ml stock. Heat the butter in the same pan and sizzle the bacon for 3-4 mins until it s…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy'] (0.50, keywords: brothy, creamy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 11 ingredients, 55 min)

### mdb-52841
**Creamy Tomato Soup** · Starter · area: British
- ingredients: 3 tbsp Olive Oil, 2 chopped Onion, 2 sticks Celery, 300g Carrot, 500g Potato, 4 Bay Leaf, 5 tblsp Tomato Puree, 2 tblsp Sugar, 2 tblsp White Vinegar, 1½ kg Chopped Tomatoes, 500g Passata, 3 Vegetable Stock, 400ml Milk
- method (4 steps): Put the oil, onions, celery, carrots, potatoes and bay leaves in a big casserole dish, or two saucepans. Fry gently until the onions are softened – about 10-15 mins. Fill the kettle and boil it. Stir in the tomato purée, sugar, vinegar, chopped tomatoes and passata, then crumble in the stock cubes. Add 1 litre boiling water and bring to a simmer. Cover and simmer for 15 mins until the potato is tender, then remove the bay leaves. Purée with a stick blender (or ladle into a blender in batches) until very smooth. Season to taste and add a pinch more sugar if it needs it. The soup can now be cool…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 13 ingredients, 55 min)
