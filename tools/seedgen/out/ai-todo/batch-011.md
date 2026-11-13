# AI tagging batch 011

Write `tools/seedgen/tags/ai/batch-011.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52960
**Salmon Avocado Salad** · Seafood · area: British
- ingredients: 400g Salmon, 3 Avocado, 1 Cucumber, 400g Spinach, 4 tbs Mint, zest and juice of 1 Lime, 2 tsp Honey, 3 tbs Olive Oil
- method (2 steps): Season the salmon, then rub with oil. Mix the dressing ingredients together. Halve, stone, peel and slice the avocados. Halve and quarter the cucumber lengthways, then cut into slices. Divide salad, avocado and cucumber between four plates, then drizzle with half the dressing. Heat a non-stick pan. Add the salmon and fry for 3-4 mins on each side until crisp but still moist inside. Put a salmon fillet on top of each salad and drizzle over the remaining dressing. Serve warm.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 35 min)

### mdb-52961
**Budino Di Ricotta** · Dessert · area: Italian
- ingredients: 500g Ricotta, 4 large Egg, 3 tbs Plain Flour, 250g Sugar, 1 tsp Cinnamon, Grated Zest of 2 Lemon, 5 tbs Dark Rum, sprinking Icing Sugar
- method (2 steps): Mash the ricotta and beat well with the egg yolks, stir in the flour, sugar, cinnamon, grated lemon rind and the rum and mix well. You can do this in a food processor. Beat the egg whites until stiff, fold in and pour into a buttered and floured 25cm cake tin. Bake in the oven at 180ºC/160ºC fan/gas 4 for about 40 minutes, or until it is firm. Serve hot or cold dusted with icing sugar.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 60 min)

### mdb-52962
**Salmon Eggs Eggs Benedict** · Breakfast · area: United States
- ingredients: 4 Egg, 2 tbs White Wine Vinegar, 2 English Muffin, To serve Butter, 8 slices Smoked Salmon, 2 tsp Lemon Juice, 2 tsp White Wine Vinegar, 3 Yolkes Egg, 125g Butter
- method (3 steps): First make the Hollandaise sauce. Put the lemon juice and vinegar in a small bowl, add the egg yolks and whisk with a balloon whisk until light and frothy. Place the bowl over a pan of simmering water and whisk until mixture thickens. Gradually add the butter, whisking constantly until thick – if it looks like it might be splitting, then whisk off the heat for a few mins. Season and keep warm. To poach the eggs, bring a large pan of water to the boil and add the vinegar. Lower the heat so that the water is simmering gently. Stir the water so you have a slight whirlpool, then slide in the eggs …
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 25 min)

### mdb-52963
**Shakshuka** · Vegetarian · area: Egyptian
- ingredients: 1 tbs Olive Oil, 2 chopped Red Onion, 1 finely chopped Red Chilli, 1 clove Garlic, Chopped Coriander, 800g Cherry Tomato, 1 tbs Sugar, 4 Egg, Spinkling Feta
- method (2 steps): Heat the oil in a frying pan that has a lid, then soften the onions, chilli, garlic and coriander stalks for 5 mins until soft. Stir in the tomatoes and sugar, then bubble for 8-10 mins until thick. Can be frozen for 1 month. Using the back of a large spoon, make 4 dips in the sauce, then crack an egg into each one. Put a lid on the pan, then cook over a low heat for 6-8 mins, until the eggs are done to your liking. Scatter with the coriander leaves and serve with crusty bread.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 40 min)

### mdb-52964
**Smoked Haddock Kedgeree** · Breakfast · area: India
- ingredients: 50g Butter, 1 chopped Onion, 3 Pods Cardamom, 1/4 tsp Turmeric, 1 small Cinnamon Stick, Sprigs of fresh Bay Leaf, 450g Basmati Rice, 1 Litre Chicken Stock, 750g Smoked Haddock, 3 Egg, 3 tblsp chopped Parsley, 1 chopped Lemon
- method (9 steps): Melt 50g butter in a large saucepan (about 20cm across), add 1 finely chopped medium onion and cook gently over a medium heat for 5 minutes, until softened but not browned. Stir in 3 split cardamom pods, ¼ tsp turmeric, 1 small cinnamon stick and 2 bay leaves, then cook for 1 minute. Tip in 450g basmati rice and stir until it is all well coated in the spicy butter. Pour in 1 litre chicken or fish stock, add ½ teaspoon salt and bring to the boil, stir once to release any rice from the bottom of the pan. Cover with a close-fitting lid, reduce the heat to low and leave to cook very gently for 12 …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 12 ingredients, 70 min)

### mdb-52965
**Breakfast Potatoes** · Breakfast · area: Canadian
- ingredients: 3 Medium Potato, 1 tbs Olive Oil, 2 strips Bacon, Minced Garlic, 1 tbs Maple Syrup, Garnish Parsley, Pinch Salt, Pinch Black Pepper, To taste Ground Allspice
- method (10 steps): Before you do anything, freeze your bacon slices that way when you're ready to prep, it'll be so much easier to chop! Wash the potatoes and cut medium dice into square pieces. To prevent any browning, place the already cut potatoes in a bowl filled with water. In the meantime, heat 1-2 tablespoons of oil in a large skillet over medium-high heat. Tilt the skillet so the oil spreads evenly. Once the oil is hot, drain the potatoes and add to the skillet. Season with salt, pepper, and Old Bay as needed. Cook for 10 minutes, stirring the potatoes often, until brown. If needed, add a tablespoon more…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 9 ingredients, 50 min, technique: caramelize)

### mdb-52966
**Chocolate Caramel Crispy** · Dessert · area: British
- ingredients: 6 chopped Mars Bar, 150g Butter, 120g Rice Krispies, 150g Milk Chocolate
- method (5 steps): Grease and line a 20 x 20cm/8" x 8" baking tin with parchment paper. Put the mars bars and butter in a heat proof bowl and place over a pan of barely simmering water. Mixing with a whisk, melt until the mixture is smooth. Pour over the rice krispies in a mixing bowl and mix until all the ingredients are evenly combined. Press evenly into the prepare baking tin and set aside. Melt the milk chocolate in the microwave or over a pan of barely simmering water. Spread the melted chocolate over the rice krispie mixture and leave to set in a cool place. Once set slice into squares and serve!
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'smooth'] (0.50, keywords: crispy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 4 ingredients, 45 min, technique: proof)

### mdb-52967
**Home-made Mandazi** · Breakfast · area: Kenyan
- ingredients: 750g Self Raising Flour, 6 tablespoons Sugar, 2 Egg, 1 cup Milk
- method (12 steps): This is one recipe a lot of people have requested and I have tried to make it as simple as possible and I hope it will work for you. Make sure you use the right flour which is basically one with raising agents. Adjust the amount of sugar to your taste and try using different flavours to have variety whenever you have them. You can use Coconut milk instead of regular milk, you can also add desiccated coconut to the dry flour or other spices like powdered cloves or cinnamon. For “healthy looking” mandazis do not roll the dough too thin before frying and use the procedure I have indicated above. …
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 4 ingredients, 35 min, technique: deep fr, knead)

### mdb-52968
**Mbuzi Choma (Roasted Goat)** · Goat · area: Kenyan
- ingredients: 1 kg Goat Meat, 1 kg Cornflour, 2 Tomato, Pinch Salt, 1 Onion, 1 Green Chilli, 1 bunch Coriander
- method (9 steps): Steps for the Meat:. Roast meat over medium heat for 50 minutes and salt it as you turn it. Steps for Ugali:. Bring the water and salt to a boil in a heavy-bottomed saucepan. Stir in the cornmeal slowly, letting it fall through the fingers of your hand. Reduce heat to medium-low and continue stirring regularly, smashing any lumps with a spoon, until the mush pulls away from the sides of the pot and becomes very thick, about 10 minutes. Remove from heat and allow to cool. Place the ugali into a large serving bowl. Wet your hands with water, form a ball and serve. Steps for Kachumbari: Mix the t…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 7 ingredients, 75 min)

### mdb-52969
**Chakchouka** · Miscellaneous · area: Tunisian
- ingredients: 4 Tomato, 2 tbs Olive Oil, 1 Diced Onion, 1 sliced Red Pepper, 1 sliced Green Pepper, 3 Cloves Crushed Garlic, 1 tsp Ground Cumin, 1 tsp Paprika, 3/4 teaspoon Salt, 1/2 teaspoon Chilli Powder, 4 Egg
- method (4 steps): In a large cast iron skillet or sauté pan with a lid, heat oil over medium high heat. Add the onion and sauté for 2-3 minutes, until softened. Add the peppers and garlic, and sauté for an additional 3-5 minutes. Add the tomatoes, cumin, paprika, salt, and chili powder. Mix well and bring the mixture to a simmer. Reduce the heat to medium low and continue to simmer, uncovered, 10-15 minutes until the mixture has thickened to your desired consistency. (Taste the sauce at this point and adjust for salt and spice, as desired.) Using the back of a spoon, make four craters in the mixture, large enou…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 45 min)

### mdb-52970
**Tunisian Orange Cake** · Dessert · area: Tunisian
- ingredients: 1 large Orange, 300g Sugar, 75 ml Olive Oil, 280g Plain Flour, 1 tbs Baking Powder, 4 large Egg, 2 tsp Vanilla Extract
- method (6 steps): Preheat oven to 190 C / Gas. Grease a 23cm round springform tin. Cut off the hard bits from the top and bottom of the orange. Slice the orange and remove all seeds. Puree the orange with its peel in a food processor. Add one third of the sugar and the olive oil and continue to mix until well combined. Sieve together flour and baking powder. Beat the eggs and the remaining sugar with an electric hand mixer for at least five minutes until very fluffy. Fold in half of the flour mixture, then the orange and the vanilla, then fold in the remaining flour. Mix well but not for too long. Pour cake mix…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['fluffy', 'smooth'] (0.50, keywords: fluffy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 7 ingredients, 75 min)

### mdb-52971
**Kafteji** · Vegetarian · area: Tunisian
- ingredients: 5 Large Potato, 2 tbs Olive Oil, 1 Green Pepper, 5 Onion, 1 tbs Ras El Hanout, 500g Pumpkin, 24 Skinned Egg, Pinch Salt, Pinch Black Pepper
- method (6 steps): Peel potatoes and cut into 5cm cubes. Pour 1-2 cm of olive oil into a large pan and heat up very hot. Fry potatoes until golden brown for 20 minutes, turning from time to time. Place on kitchen paper to drain. Cut the peppers in half and remove seeds. Rub a little olive oil on them and place the cut side down on a baking tray. Place them under the grill. Grill until the skin is dark and bubbly. While the peppers are still hot, put them into a plastic sandwich bag and seal it. Take them out after 15 minutes and remove skins. In the meantime, heat more olive oil another pan. Peel the onions and …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 9 ingredients, 90 min)

### mdb-52972
**Tunisian Lamb Soup** · Lamb · area: Tunisian
- ingredients: 500g Lamb Mince, 2 cloves minced Garlic, 1 Onion, 300g Spinach, 3 tbs Tomato Puree, 1 tbs Ground Cumin, 1 Litre Chicken Stock, 3 tsp Harissa Spice, 400g Chickpea, 1/2 Lemon Juice, 150g Macaroni, Pinch Salt, Pinch Black Pepper
- method (4 steps): Add the lamb to a casserole and cook over high heat. When browned, remove from the heat and set aside. Keep a tablespoon of fat in the casserole and discard the rest. Reduce to medium heat then add the garlic, onion and spinach and cook until the onion is translucent and the spinach wilted or about 5 minutes. Return the lamb to the casserole with the onion-spinach mixture, add the tomato puree, cumin, harissa, chicken, chickpeas, lemon juice, salt and pepper in the pan. Simmer over low heat for about 20 minutes. Add the pasta and cook for 15 minutes or until pasta is cooked.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 13 ingredients, 65 min)

### mdb-52973
**Leblebi Soup** · Vegetarian · area: Tunisian
- ingredients: 2 tbs Olive Oil, 1 medium finely diced Onion, 250g Chickpea, 1.5L Vegetable Stock, 1 tsp Ground Cumin, 5 cloves Garlic, 1/2 tsp Salt, 1 tsp Harissa Spice, Pinch Black Pepper, 1/2 Lime
- method (5 steps): Heat the oil in a large pot. Add the onion and cook until translucent. Drain the soaked chickpeas and add them to the pot together with the vegetable stock. Bring to the boil, then reduce the heat and cover. Simmer for 30 minutes. In the meantime toast the cumin in a small ungreased frying pan, then grind them in a mortar. Add the garlic and salt and pound to a fine paste. Add the paste and the harissa to the soup and simmer until the chickpeas are tender, about 30 minutes. Season to taste with salt, pepper and lemon juice and serve hot.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 80 min)

### mdb-52974
**Keleya Zaara** · Lamb · area: Tunisian
- ingredients: 4 tbs Olive Oil, 750g Lamb, 1 1/2 tsp Saffron, 1 Large Chopped Onion, 25 ml Water, 30g Parsley, 1 tbs Butter, 1 Lemon
- method (2 steps): Heat the vegetable oil in a large frying pan over medium-high heat. Add the lamb and cook until browned on all sides, about 5 minutes. Season with saffron, salt and pepper to taste; stir in all but 4 tablespoons of the onion, and pour in the water. Bring to the boil, then cover, reduce heat to medium-low, and simmer until the lamb is tender, about 15 minutes. Uncover the pan, stir in the butter and allow the sauce reduce 5 to 10 minutes to desired consistency. Season to taste with salt and pepper, then pour into a serving dish. Sprinkle with the remaining chopped onions and parsley. Garnish wi…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 45 min)

### mdb-52975
**Tuna and Egg Briks** · Seafood · area: Tunisian
- ingredients: 2 tbs Olive Oil, 8 Spring Onion, 200g Spinach, 4 Filo Pastry, 1 can Tuna, 2 Egg, Dash Hot Sauce, 4 Chopped Tomato, 1/4 Cucumber, 1 tbs Lemon Juice, 4 tbs Apricot Jam
- method (7 steps): Heat 2 tsp of the oil in a large saucepan and cook the spring onions over a low heat for 3 minutes or until beginning to soften. Add the spinach, cover with a tight-fitting lid and cook for a further 2–3 minutes or until tender and wilted, stirring once or twice. Tip the mixture into a sieve or colander and leave to drain and cool. Using a saucer as a guide, cut out 24 rounds about 12.5 cm (5 in) in diameter from the filo pastry, cutting 6 rounds from each sheet. Stack the filo rounds in a pile, then cover with cling film to prevent them from drying out. When the spinach mixture is cool, squee…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'flaky', 'saucy'] (0.50, keywords: crispy, flaky, saucy)
- `moods` rule: ['comfort', 'fresh', 'light'] (0.50, keywords/category: comfort, fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 11 ingredients, 40 min)

### mdb-52976
**Cashew Ghoriba Biscuits** · Dessert · area: Tunisian
- ingredients: 250g Cashew, 100g Icing Sugar, 2 Egg Yolk, 2 tbs Orange Blossom Water, To Glaze Icing Sugar, 100g Almond
- method (5 steps): Preheat the oven at 180 C / Gas. Line a baking tray with greaseproof paper. In a bowl, mix the cashews and icing sugar. Add the egg yolks and orange blossom water and mix to a smooth homogeneous paste. Take lumps of the cashew paste and shape into small balls. Roll the balls in icing sugar and transfer to the baking tray. Push an almond in the centre of each ghribia. Bake until the biscuits are lightly golden, about 20 minutes. Keep an eye on them, they burn quickly.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 6 ingredients, 35 min)

### mdb-52977
**Corba** · Side · area: Turkish
- ingredients: 1 cup Lentil, 1 large Onion, 1 large Carrot, 1 tbs Tomato Puree, 2 tsp Ground Cumin, 1 tsp Paprika, 1/2 tsp Mint, 1/2 tsp Thyme, 1/4 tsp Black Pepper, 1/4 tsp Chilli Flakes, 4 cups Vegetable Stock, 1 cup Water, Pinch Salt
- method (6 steps): Pick through your lentils for any foreign debris, rinse them 2 or 3 times, drain, and set aside. Fair warning, this will probably turn your lentils into a solid block that you’ll have to break up later In a large pot over medium-high heat, sauté the olive oil and the onion with a pinch of salt for about 3 minutes, then add the carrots and cook for another 3 minutes. Add the tomato paste and stir it around for around 1 minute. Now add the cumin, paprika, mint, thyme, black pepper, and red pepper as quickly as you can and stir for 10 seconds to bloom the spices. Congratulate yourself on how amaz…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'smooth'] (0.50, keywords: brothy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 13 ingredients, 50 min)

### mdb-52978
**Kumpir** · Side · area: Turkish
- ingredients: 2 large Potato, 2 tbs Butter, 150g Cheese, 1 large Onion, 1 large Red Pepper, Pinch Chilli Flakes
- method (4 steps): If you order kumpir in Turkey, the standard filling is first, lots of butter mashed into the potato, followed by cheese. There’s then a row of other toppings that you can just point at to your heart’s content – sweetcorn, olives, salami, coleslaw, Russian salad, allsorts – and you walk away with an over-stuffed potato because you got ever-excited by the choices on offer. Grate (roughly – you can use as much as you like) 150g of cheese. Finely chop one onion and one sweet red pepper. Put these ingredients into a large bowl with a good sprinkling of salt and pepper, chilli flakes (optional).
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 40 min)

### mdb-52979
**Bitterballen (Dutch meatballs)** · Beef · area: Netherlands
- ingredients: 100g Butter, 150g Plain Flour, 700ml Beef Stock, 30g Onion, 1 tbs Parsley, 400g Beef, Pinch Salt, Pinch Black Pepper, Pinch Ground Nutmeg, 50g Plain Flour, 2 Beaten Egg, 50g Breadcrumb
- method (4 steps): Melt the butter in a skillet or pan. When melted, add the flour little by little and stir into a thick paste. Slowly stir in the stock, making sure the roux absorbs the liquid. Simmer for a couple of minutes on a low heat while you stir in the onion, parsley and the shredded meat. The mixture should thicken and turn into a heavy, thick sauce. Pour the mixture into a shallow container, cover and refrigerate for several hours, or until the sauce has solidified. Take a heaping tablespoon of the cold, thick sauce and quickly roll it into a small ball. Roll lightly through the flour, then the egg a…
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 12 ingredients, 30 min)
