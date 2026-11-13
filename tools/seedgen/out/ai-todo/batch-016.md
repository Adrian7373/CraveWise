# AI tagging batch 016

Write `tools/seedgen/tags/ai/batch-016.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53081
**Potato Salad (Olivier Salad)** · Vegetarian · area: Russian
- ingredients: 4 Potato, 3 Carrot, 1 tbs Salt, 1/2 tbs White Wine Vinegar, 4 Egg, 7 oz Sausage, 4 oz Dill, 1 can Pea, 4 Onion, 1 cup Mayonnaise
- method (9 steps): Cut the potatoes and carrots into small uniform cubes. Place them in a large pot and fill with water. Add salt and vinegar. Bring it to a boil over medium high heat, and then reduce the heat to medium and continue to cook until the potatoes are cooked through, about 15 minutes. Drain the potatoes and let it cool to room temperature. Meanwhile, cut the sausage and pickles into small cubes, and chop the green onions. Cut the hard-boiled eggs into small cubes as well. If using fresh dill, chop them as well. In a large bowl, combine potatoes, carrots, sausage, pickles, peas and green onions. Add m…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 10 ingredients, 105 min)

### mdb-53082
**Strawberries Romanoff** · Dessert · area: Russian
- ingredients: 2 pint Strawberries, 4 tbs Sugar, 4 tbs Grand Marnier, 1 cup Cream, 1/4 cup Sour Cream
- method (4 steps): In a medium bowl, combine hulled and quartered strawberries, 4 Tbsp sugar and 4 Tbsp liqueur, stir to combine then cover and refrigerate at least 1 hour and up to 2 hours, stirring once or twice. Two photos of cut strawberries in a bowl with one having sugar being added to the bowl Two photos of cut up strawberries for Strawberry Romanoff. Just before serving, in a large mixing bowl, combine 1 cup cold heavy cream and 1/4 cup powdered sugar, and beat with an electric mixer until stiff peaks form. Using a spatula, fold in 1/4 cup sour cream just until well blended. To serve, stir strawberries t…
- `textures` rule: ['brothy', 'creamy'] (0.50, keywords: brothy, creamy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'medium' (0.55, 4 steps, 5 ingredients, 285 min, technique: stiff peaks)

### mdb-53083
**Lamb Pilaf (Plov)** · Lamb · area: Russian
- ingredients: 50g Lamb, 120g Prune, 1 tbs Lemon Juice, 2 tbs Butter, 1 chopped Onion, 450g Lamb, 2 cloves Garlic, 600ml Vegetable Stock, 2 cups Rice, Pinch Saffron, Garnish Parsley
- method (5 steps): Place the raisins and prunes into a small bowl and pour over enough water to cover. Add lemon juice and let soak for at least 1 hour. Drain. Roughly chop the prunes. Meanwhile, heat the butter in a large pan, add the onion, and cook for 5 minutes. Add cubed lamb, ground lamb, and crushed garlic cloves. Fry for 5 minutes, stirring constantly until browned. Pour 2/3 cup (150 milliliters) of stock into the pan. Bring to a boil, then lower the heat, cover, and simmer for 1 hour, or until the lamb is tender. Add the remaining stock and bring to a boil. Add rinsed long-grain white rice and a large p…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 175 min)

### mdb-53085
**15-minute chicken & halloumi burgers** · Chicken · area: United States
- ingredients: 2 Chicken Breast, 1 tbsp Vegetable Oil, 4 tbsp Hot Sauce, ½ Lemon Juice, 2 Burger Bun, 250g Cheese, ¼ Cabbage, 2 tbsp Mayonnaise, 4 tbsp Sour Cream, 4 leaves Lettuce, 2 Red Pepper
- method (6 steps): Put the chicken breasts between two pieces of baking parchment and use a rolling pin to gently bash them until they are approximately 1cm thick. Cut each chicken breast into two even pieces. If you're using a frying pan, heat two frying pans over medium-high heat, with one of them containing oil. Fry the chicken in the oiled pan for 3-4 mins on each side until they are cooked through. Season the chicken, reduce the heat, drizzle in the chilli sauce and half of the lemon juice, and cook for an additional 1-2 mins until the sauce is reduced. Remove the chicken from the heat. If you're using an a…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 11 ingredients, 55 min)

### mdb-53086
**Migas** · Miscellaneous · area: Spanish
- ingredients: 1 large Bread, 1 1/2 L Olive Oil, Half Garlic, 1 Handfull Pork
- method (4 steps): Crumble the bread into small pieces. Sprinkle with cold water, cover with a damp cloth and leave for 30 minutes. Heat 2 tsp of olive oil in a deep pan. Add the garlic cloves separated, skins on; just make a small cut with a knife to open them and keep frying for 5 minutes. Set the garlic aside. In the same oil, where we fried everything, simmer the bread, stirring constantly for 15 minutes and add a grinding of black pepper. Add the garlic, continue stirring for about 20 minutes. It will be ready when the bread is soft and golden.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy'] (0.50, keywords: crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 4 ingredients, 80 min)

### mdb-53089
**Syrian Bread** · Miscellaneous · area: Syrian
- ingredients: 1 and 1/8 cup Water, 2 tblsp Vegetable Oil, 1/2 teaspoon Sugar, 1 1/2 tsp Salt, 3 Cups Plain Flour, 1 1/2 tsp Yeast
- method (4 steps): Place ingredients in the pan of the bread machine in the order recommended by the manufacturer. Select Dough cycle; press Start. When the Dough cycle is almost complete, preheat the oven to 475 degrees F (245 degrees C). Turn dough out onto a lightly floured surface. Divide into eight equal pieces and form into rounds. Cover the rounds with a damp cloth and let rest. Roll dough into thin flat circles, about 8 inches in diameter. Cook two at a time on preheated baking sheets or a baking stone until puffed up and golden brown, about 5 minutes. Repeat for remaining loaves.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 20 min)

### mdb-53091
**Falafel Pita Sandwich with Tahini Sauce** · Vegetarian · area: Syrian
- ingredients: 12 Falafel, 1/4 cup Tahini, 1/4 cup Water, 2 tablespoons Lemon Juice, 2 cloves Garlic, 1/4 tsp Paprika, 6 Pita Bread, 1 Lettuce, 1 Tomato, 1/2 Cucumber, 1 Dill Pickle, 1/4 Red Onion, 3 tsp Harissa Spice
- method (4 steps): Preheat the oven to 450 degrees F (230 degrees C). Place falafel on a baking sheet. Bake in the preheated oven until heated through, 8 to 10 minutes. While falafel bake, whisk tahini, water, lemon juice, garlic, and paprika together in a bowl. Cut about 1 inch from the top of each pita to form a pocket. Add 2 falafel to each pita with equal amounts lettuce, tomato, cucumber, pickle, and red onion. Drizzle each with about 1 tablespoon tahini sauce and some harissa.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh'] (0.50, keywords/category: comfort, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 13 ingredients, 40 min)

### mdb-53092
**Fasoliyyeh Bi Z-Zayt (Syrian Green Beans with Olive Oil)** · Vegan · area: Syrian
- ingredients: 16 ounces Green Bean, 1/4 cup Olive Oil, Dash Salt, 1 clove Garlic, 1/4 cup Coriander
- method (2 steps): Place the green beans into a large pot, and drizzle with olive oil. Season with salt to taste, and put the lid on the pot. Cook over medium-high heat, stirring occasionally, until beans are cooked to your desired doneness. Syrians like it cooked until the green beans are turning brownish in color. The idea is not to saute them, but to let them steam in the moisture released by the ice crystals. Add cilantro and garlic to the beans, and continue to cook just until the cilantro has started to wilt. Eat as a main course by scooping up with warm pita bread or serve as a side dish.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegan guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 5 ingredients, 45 min)

### mdb-53093
**Syrian Spaghetti** · Pasta · area: Syrian
- ingredients: 16 ounces Spaghetti, 8 ounces Tomato Sauce, 6 oz Tomato Puree, 1 teaspoon Cinnamon, 1/4 cup Vegetable Oil, Dash Salt, Dash Black Pepper
- method (3 steps): Preheat oven to 350 degrees F (175 degrees C). Grease a 9x13 inch baking dish. Bring a large pot of lightly salted water to a boil. Add spaghetti and cook for 8 to 10 minutes or until al dente; drain and stir in tomato sauce, tomato paste, cinnamon, oil, salt and pepper. Transfer to prepared dish. Bake in preheated oven for 1 hour, or until top is crunchy.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy', 'smooth'] (0.50, keywords: crunchy, saucy, smooth)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 85 min)

### mdb-53094
**Baba Ghanoush** · Side · area: Syrian
- ingredients: 4 large Aubergine, 2 cloves Garlic, 2 teaspoons Salt, 1 Lemon, 3 tablespoons Tahini, 3 tablespoons Olive Oil, 2 tablespoons Greek Yogurt, 1 pinch Cayenne Pepper, 1 Leaf Mint, 2 tablespoons Parsley
- method (5 steps): Preheat an outdoor grill for medium-high heat and lightly oil the grate. Prick the surface of the skin of eggplants several times with the tip of a knife. Place eggplants directly on grill. Turn frequently with tongs while skin chars. Cook until eggplants have collapsed and are very soft, 25 to 30 minutes. Transfer to a bowl and cover tightly with aluminum foil and allow to cool, about 15 minutes. When eggplants are cool enough to handle, split them in half and scrape flesh into a colander placed over a bowl. Drain 5 or 10 minutes. Transfer eggplant to mixing bowl. Add crushed garlic and salt;…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 75 min)

### mdb-53095
**Syrian Rice with Meat** · Miscellaneous · area: Syrian
- ingredients: 1/4 cup Butter, 2 Pounds Beef Mince, 2 teaspoons Salt, 1/2 teaspoon Ground Allspice, 1/2 teaspoon Cinnamon, 1/2 teaspoon Black Pepper, 5 Cups Chicken Stock, 2 cups Rice, 2 tablespoons Butter, 1/2 cup Pine Nut
- method (4 steps): Heat 1/4 cup butter in a large saucepan over medium-high heat. Add ground beef and season with salt, allspice, cinnamon, and black pepper. Cook and stir until beef is browned and crumbly, 7 to 10 minutes. Stir chicken broth and rice into beef in the saucepan; bring to a boil. Reduce heat to low, cover, and cook until liquid is absorbed, about 20 minutes. Meanwhile, melt 2 tablespoons butter in a small skillet over medium heat. Cook and stir pine nuts in hot butter until lightly browned, 3 to 5 minutes. Mix pine nuts into beef-rice mixture before serving.
- `textures` rule: ['brothy', 'crunchy'] (0.50, keywords: brothy, crunchy)
- `moods` rule: ['indulgent', 'light'] (0.50, keywords/category: indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 10 ingredients, 50 min)

### mdb-53096
**Corned Beef Hash** · Beef · area: British
- ingredients: 3 tablespoons Butter, 1 medium chopped Onion, 3 Cups Corned Beef, 3 chopped Potato, Dash Salt, Dash Black Pepper, Chopped Parsley
- method (10 steps): Sauté the onions:. Heat butter in a large skillet (preferably cast iron) on medium heat. Add the onion and cook a few minutes, until translucent. Add the potatoes and corned beef:. Mix in the chopped corned beef and potatoes. Spread out evenly over the pan. Increase the heat to high or medium high and press down on the mixture with a metal spatula. Cook until browned and then flip:. Do not stir the potatoes and corned beef, but let them brown. If you hear them sizzling, this is good. Use a metal spatula to peek underneath and see if they are browning. If nicely browned, use the spatula to flip…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'easy' (0.55, 10 steps, 7 ingredients, 50 min)

### mdb-53097
**Yorkshire Puddings** · Miscellaneous · area: British
- ingredients: 140g Plain Flour, 4 Egg, 200ml Milk, Drizzle Vegetable Oil
- method (7 steps): Heat oven to 230C/fan 210C/gas 8. Drizzle a little sunflower oil evenly into two 4-hole Yorkshire pudding tins or two 12-hole non-stick muffin tins and place in the oven to heat through. To make the batter, tip 140g plain flour into a bowl and beat in 4 eggs until smooth. Gradually add 200ml milk and carry on beating until the mix is completely lump-free. Season with salt and pepper. Pour the batter into a jug, then remove the hot tins from the oven. Carefully and evenly pour the batter into the holes. Place the tins back in the oven and leave undisturbed for 20-25 mins until the puddings have…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'smooth'] (0.50, keywords: crispy, smooth)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 4 ingredients, 30 min)

### mdb-53098
**Cumberland Pie** · Beef · area: British
- ingredients: 2 Celery, 1 chopped Onion, 2 large Carrot, 5 Bay Leaf, 3 Thyme, 2 tblsp Vegetable Oil, 1 tablespoon Butter, 2 tablespoons Plain Flour, 2 tblsp Tomato Puree, 2 tablespoons Worcestershire Sauce, 2 Beef Stock, 800g Feather Blade Beef, 800g Potato, 25g Cheddar, 25g Parmesan
- method (6 steps): Heat oven to 160C/140C fan/gas. Soften the celery, onion, carrots, bay and 1 thyme sprig in a casserole with 1 tbsp oil and the butter for 10 mins. Stir in the flour, followed by the purée, Worcestershire sauce and stock cubes. Gradually stir in 600ml hot water, then tip in the beef and bring to a gentle simmer. Cover and cook in the oven for 2 hrs 30 mins, then uncover and cook for 30 mins -1 hr more until the meat is really tender and sauce thickened. Meanwhile, cook potatoes in a pan of boiling water until they’re not done but about ¾ of the way there. Transfer meat to a baking dish. Slice …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 15 ingredients, 280 min)

### mdb-53099
**Aussie Burgers** · Beef · area: Australian
- ingredients: 500g Beef Mince, 100g Beetroot, 2 small Naan Bread, 50g Rocket, 4 tablespoons Soured Cream and Chive Dip
- method (4 steps): Make the burgers: Tip the meat into a bowl and sprinkle over 1 tsp salt and a good grinding of black pepper.Work with wet hands to mix in the seasoning. Divide into four with your hands and shape into burgers. (It can be frozen at this stage.) Sort out your ingredients: Slice the beetroot and split the naan breads. Toast the naans: Heat a griddle pan or barbecue. Griddle the naans on both sides until lightly toasted and set aside. Add the burgers to the grill or barbecue and cook for 2-3 minutes, then turn and cook the other side for a further 2-3 minutes. Assemble the dish: Set half a toasted…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 5 ingredients, 20 min)

### mdb-53100
**Blueberry & lemon friands** · Dessert · area: Australian
- ingredients: 100g Butter, 125g Icing Sugar, 25g Plain Flour, 85g Almond, 3 Egg White, 1 Lemon, 85g Blackberry
- method (6 steps): Preheat the oven to fan 180C/conventional 200C/gas. Generously butter six non-stick friand or muffin tins. Melt the butter and set aside to cool. Sift the icing sugar and flour into a bowl. Add the almonds and mix everything between your fingers. Whisk the egg whites in another bowl until they form a light, floppy foam. Make a well in the centre of the dry ingredients, tip in the egg whites and lemon rind, then lightly stir in the butter to form a soft batter. Divide the batter among the tins, a large serving spoon is perfect for this job. Sprinkle a handful of blueberries over each cake and b…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy'] (0.50, keywords: crispy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 7 ingredients, 35 min)

### mdb-53101
**Chocolate Coconut Squares** · Dessert · area: Australian
- ingredients: 100g Butter, 100g Sugar, 2 Egg, 140g Self Raising Flour, 1 teaspoon Baking Powder, 2 tablespoons Cocoa Powder, 2 tablespoons Milk, 100g Plain Chocolate, 25g Butter, 100g Icing Sugar, 100g Desiccated Coconut
- method (5 steps): Heat oven to 180C/fan 160C/gas. Butter and line the base of a 20cm square baking tin. Beat together the butter and sugar until pale and creamy, then beat in the eggs. Add 1 tbsp of the flour if the mix starts to curdle. Sieve in the flour, baking powder and cocoa and fold in with a metal spoon. Stir in the milk. Scrape mix into the tin and level the top. Bake for 18-20 mins or until the cake springs back when pressed. Allow to cool in the tin. To make the icing, put the chocolate, butter and 4 tbsp water in a pan and gently heat until melted. Allow to cool slightly, then beat in the icing suga…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 45 min)

### mdb-53102
**Squid, chickpea & chorizo salad** · Seafood · area: Australian
- ingredients: 4 Red Pepper, 2 400g Cans Chickpea, Bunch Parsley, 1 Red Chilli, 2 Garlic, 100 ml Olive Oil, 600g Squid, 200g Chorizo, Juice/zest of one Lemon
- method (3 steps): Cook the peppers whole under a grill, on a barbecue or griddle, until completely charred. Place the peppers in a bowl, cover with a plate until cool enough to handle, then peel, deseed and finely slice. In a large bowl mix the peppers and any juices with the chickpeas, parsley, chilli and garlic. Set aside. Heat a large frying pan until smoking. Working quickly and carefully, add a splash of oil to the pan, then the squid. Stir-fry for about 30 secs. Scatter the chorizo over the squid, continue to cook for 30 secs more, then tip into the bowl with the peppers. Season everything with salt and p…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 30 min)

### mdb-53103
**Barramundi with Moroccan spices** · Seafood · area: Australian
- ingredients: 2 x 400g Barramundi, 1/2 teaspoon Ground Cumin, 1/2 tsp Coriander, Pinch Paprika, Pinch Chilli Powder, 2 Garlic, Juice of 1 Lemon, 5 tablespoons Olive Oil, Bunch Coriander
- method (8 steps): Tip all the dressing ingredients into a food processor with a pinch of salt and blitz to a dressing. Slash the fish three times on each side, coat with half of the dressing, then set aside to marinate for about 30 mins. Heat oven to 220C/fan 200C/gas. Place the fish on a roasting tray, then cook in the oven for 20 mins until the flesh is firm and the eyes have turned white. Serve the fish with the rest of the dressing and steamed couscous or rice. KNOW HOW: HOW TO COOK IT: Cooking barramundi on the bone, as we have done here, has its advantages – it will stay more moist during cooking, and som…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy'] (0.50, keywords: crispy, fluffy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 9 ingredients, 70 min)

### mdb-53104
**Lamingtons** · Dessert · area: Australian
- ingredients: 125g Butter, 250g Sugar, 3 Large Egg, 250g Self Raising Flour, 3 tablespoons Milk, 1/2 teaspoon Salt, 250ml Double Cream, 2 tblsp Icing Sugar, 200g Raspberry Jam, 350g Desiccated Coconut, 80g Butter, 250ml Milk, 50g Cocoa Powder, 400g Icing Sugar
- method (7 steps): Heat the oven to 200C/180C fan/gas. Butter and line a 20 x 30cm rectangle tin. Beat the butter and sugar in a free-standing mixer until pale and fluffy. Add the eggs one at a time and beat well. Beat through the flour, milk and salt until fully combined, then spoon into the tin. Bake in the oven for 25 mins or until golden and firm to the touch. Set aside to cool completely. Slice the sponge horizontally to create two halves. Trim the edges to make perfect corners. Cut the sponge into 18 squares. Lightly whip the cream with the icing sugar until it reaches soft peaks. Spread a little of the ja…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'fluffy'] (0.50, keywords: creamy, crunchy, fluffy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 14 ingredients, 115 min, technique: pipe)
