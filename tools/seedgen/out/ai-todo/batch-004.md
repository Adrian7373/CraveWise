# AI tagging batch 004

Write `tools/seedgen/tags/ai/batch-004.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52782
**Lamb tomato and sweet spices** · Lamb · area: Moroccan
- ingredients: 2 tbsp Olive Oil, 4cm piece finely chopped Ginger, 2 cloves peeled and chopped Garlic, 800g peeled and chopped Tomato, 2 tbsp Lemon Juice, 1 tsp Sugar, 50 Vine Leaf, 1 large Fennel Bulb, 400g Lamb Mince, 1 medium Onion, 1 small peeled and coarsely grated Potato, 2 tbsp Basmati Rice, 2 tbsp Parsley, 2 tbsp chopped Coriander, 1 tbsp Lemon Juice, 2 cloves Garlic, ½ tsp ground Clove, ½ tsp ground Cinnamon, 2 medium Tomato
- method (10 steps): Use pickled vine leaves here, preserved in brine. Small delicate leaves are better than the large bristly ones but, if only large leaves are to hand, then trim them to roughly 12 by 12 cms so that you don't get too many layers of leaves around the filling. And remove any stalks. Drain the preserved leaves, immerse them in boiling water for 10 minutes and then leave to dry on a tea towel before use. Basmati rice with butter and pine nuts is an ideal accompaniment. Couscous is great, too. Serves four. First make the filling. Put all the ingredients, apart from the tomatoes, in a bowl. Cut the to…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'fluffy', 'saucy'] (0.50, keywords: crunchy, fluffy, saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 19 ingredients, 150 min)

### mdb-52783
**Rigatoni with fennel sausage sauce** · Lamb · area: Italian
- ingredients: 2½ tbsp Olive Oil, 6 cut into 1.5cm-thick slices Italian Fennel Sausage, 1 large peeled and chopped Onion, 1 trimmed and roughly chopped; reserve any fronds to garnish Fennel Bulb, ½ tsp Smoked Paprika, 1 clove, peeled and sliced Garlic, 2 tsp lightly toasted and then gently crushed Fennel Seed, 100ml Red Wine, 400g tinned Chopped Tomatoes, ½ tsp Sugar, 50g cut in half lengthways Black Olive, 500g Rigatoni, 30g roughly crumbled into 0.5cm pieces Pecorino, 1 rinsed and patted dry Anchovy Fillet, 1 clove, peeled and crushed Garlic, 60ml Olive Oil, 50g torn Basil
- method (8 steps): Heat a tablespoon of oil in a large saute pan for which you have a lid. Add the sausage pieces and fry on a medium-high heat for 10 minutes, stirring regularly, until golden-brown all over. Transfer the sausages to a plate, then add the onion and fennel to the hot pan and fry for 15 minutes, stirring once in a while, until soft and caramelised; if the pan goes a bit dry, add a teaspoon or so of extra oil. Stir in the paprika, garlic and half the fennel seeds, fry for two minutes more, then pour on the wine and boil for 30 seconds, to reduce by half. Add the tomatoes, sugar, 100ml water, the se…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 17 ingredients, 110 min, technique: caramelis)

### mdb-52784
**Smoky Lentil Chili with Squash** · Vegetarian · area: British
- ingredients: 1 tbls Olive Oil, 1 Onion, 1 chopped Leek, 3 cloves Garlic, 4 tsp ground Ground Cumin, 2 tsp ground Coriander, 1 tsp Smoked Paprika, 1/2 tsp Cinnamon, 1 tsp Chilli Powder, 1 tsp Cocoa Powder, 1/2 tsp Dried Oregano, 1 can Chopped Tomatoes, 3 cups Water, 3 chopped Carrot, 1 1/2 cups Brown Lentil, 1 tsp Salt, 1 Small Squash, 1 Cup Cashew, 1 tsp Cider Vinegar
- method (12 steps): Begin by roasting the squash. Slice it into thin crescents and drizzle with a little oil and sprinkle with sea salt. I added a fresh little sage I had in the fridge, but it’s unnecessary. Roast the squash a 205 C (400 F) for 20-30 minutes, flipping halfway through, until soft and golden. Let cool and chop into cubes. Meanwhile, rinse the lentils and cover them with water. Bring them to the boil then turn down to a simmer and let cook (uncovered) for 20-30 minutes, or until tender. Drain and set aside. While the lentils are cooking heat the 1 Tbsp. of oil on low in a medium pot. Add the onions …
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 19 ingredients, 345 min)

### mdb-52785
**Dal fry** · Vegetarian · area: India
- ingredients: 1 cup Toor Dal, 2-1/2 cups Water, 1 tsp Salt, 1/4 tsp Turmeric, 3 tbs Ghee, 1 cup Chopped Tomatoes, 1/2 tsp Cumin Seed, 1/2 tsp Mustard Seed, 2 Bay Leaf, 1 tbs chopped Green Chilli, 2 tsp shredded Ginger, 2 tbs Coriander, 1/2 tsp Red Pepper, 1/2 tsp Salt, 1 tsp Sugar, 1/4 tsp Garam Masala
- method (7 steps): Wash and soak toor dal in approx. 3 cups of water, for at least one hours. Dal will be double in volume after soaking. Drain the water. Cook dal with 2-1/2 cups water and add salt, turmeric, on medium high heat, until soft in texture (approximately 30 mins) it should be like thick soup. In a frying pan, heat the ghee. Add cumin seeds, and mustard seeds. After the seeds crack, add bay leaves, green chili, ginger and chili powder. Stir for a few seconds. Add tomatoes, salt and sugar stir and cook until tomatoes are tender and mushy. Add cilantro and garam masala cook for about one minute. Pour t…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy'] (0.50, keywords: brothy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 16 ingredients, 125 min)

### mdb-52786
**Rocky Road Fudge** · Dessert · area: United States
- ingredients: 2 cups Miniature Marshmallow, 3 cups Chocolate Chip, ½ cup Peanut Butter, 1 tsp Vanilla Extract, 1 ¼ cups Peanut
- method (10 steps): Line an 8-inch-square baking pan with wax paper or foil, and coat with non-stick spray. Pour ½ cup of the miniature marshmallows into the bottom of the lined baking dish. In a microwave-safe bowl, combine the chocolate chips and peanut butter. Microwave the chocolate mixture in 20-second intervals, stirring in between each interval, until the chocolate is melted. Add the vanilla extract and stir well, until smooth. Reserve 2 tablespoons of the chopped almonds or peanuts, and set aside. Fold 1 ½ cups of the miniature marshmallows and the remaining chopped nuts into the chocolate mixture. Transf…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'medium' (0.55, 10 steps, 5 ingredients, 290 min)

### mdb-52787
**Hot Chocolate Fudge** · Dessert · area: United States
- ingredients: 2 cups Chocolate Chip, 2 tbs Double Cream, 1 – 14-ounce can Condensed Milk, 1 tsp Vanilla Extract, 1-⅓ cups White Chocolate Chip, 1-½ cups Miniature Marshmallow
- method (10 steps): Line an 8-inch-square baking pan with wax paper or foil, and coat with non-stick spray. In a microwave-safe bowl, combine the dark chocolate chips, heavy cream and half of the sweetened condensed milk. Microwave the dark chocolate mixture in 20-second intervals, stirring in between each interval, until the chocolate is melted. Add the vanilla extract to the dark chocolate mixture and stir well until smooth. Transfer the dark chocolate mixture into the prepared pan and spread into an even layer. In a separate bowl, combine the white chocolate chips with the remaining half of the sweetened conde…
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'medium' (0.55, 10 steps, 6 ingredients, 285 min)

### mdb-52788
**Christmas Pudding Flapjack** · Dessert · area: British
- ingredients: 250g Butter, 225g Brown Sugar, 150g Golden Syrup, Zest of 1 Orange, 500g Oats, 250g Christmas Pudding
- method (3 steps): Preheat the oven to 180°C/fan 160°C/gas mark 4 and grease and line a 25cm x 20cm tin. Melt the butter, sugar, syrup and orange zest in a large saucepan over a medium heat. The aim is to dissolve all the ingredients so that they are smooth, but to not lose any volume through boiling so be careful not to overheat. Add the oats and stir well until evenly coated. Stir through the leftover Christmas pudding and tip into the prepared tin. Use a spoon to flatten the top and bake for 40 minutes until the edges start to brown. Whilst still warm in the tin, score into 12 squares. Allow to cool completel…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'festive', 'indulgent'] (0.50, keywords/category: comfort, festive, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 6 ingredients, 60 min)

### mdb-52792
**Bread and Butter Pudding** · Dessert · area: British
- ingredients: 25g/1oz Butter, 8 thin slices Bread, 50g/2oz Sultana, 2 tsp Cinnamon, 350ml/12fl Milk, 50ml/2fl oz Double Cream, 2 free-range Egg, 25g/1oz Sugar, grated, to taste Ground Nutmeg
- method (9 steps): Grease a 1 litre/2 pint pie dish with butter. Cut the crusts off the bread. Spread each slice with on one side with butter, then cut into triangles. Arrange a layer of bread, buttered-side up, in the bottom of the dish, then add a layer of sultanas. Sprinkle with a little cinnamon, then repeat the layers of bread and sultanas, sprinkling with cinnamon, until you have used up all of the bread. Finish with a layer of bread, then set aside. Gently warm the milk and cream in a pan over a low heat to scalding point. Don't let it boil. Crack the eggs into a bowl, add three quarters of the sugar and …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 9 ingredients, 80 min)

### mdb-52793
**Sticky Toffee Pudding Ultimate** · Dessert · area: British
- ingredients: 225g Date, 175ml Boiling Water, 1 tsp Vanilla Extract, 175g Self Raising Flour, 1 tsp Bicarbonate of Soda, 2 Egg, 85g Butter, 140g Demerara Sugar, 2 tbsp Black Treacle, 100ml Milk, 1 scoop Ice Cream, 175g Muscovado Sugar, 50g Butter, 225ml Double Cream, 1 tbsp Black Treacle
- method (12 steps): Stone and chop the dates quite small, put them in a bowl, then pour the boiling water over. Leave for about 30 mins until cool and well-soaked, then mash a bit with a fork. Stir in the vanilla extract. Butter and flour seven mini pudding tins (each about 200ml/7fl oz) and sit them on a baking sheet. Heat oven to 180C/fan 160C/gas 4. While the dates are soaking, make the puddings. Mix the flour and bicarbonate of soda together and beat the eggs in a separate bowl. Beat the butter and sugar together in a large bowl for a few mins until slightly creamy (the mixture will be grainy from the sugar).…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 15 ingredients, 100 min)

### mdb-52794
**Vegan Chocolate Cake** · Vegan · area: United States
- ingredients: 1 1/4 cup Self Raising Flour, 1/2 cup Coco Sugar, 1/3 cup raw Cocoa Powder, 1 tsp Baking Powder, 2 Flax Egg, 1/2 cup Almond Milk, 1 tsp Vanilla Extract, 1/2 cup boiling Water
- method (1 steps): Simply mix all dry ingredients with wet ingredients and blend altogether. Bake for 45 min on 180 degrees. Decorate with some melted vegan chocolate.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 8 ingredients, 60 min)

### mdb-52795
**Chicken Handi** · Chicken · area: India
- ingredients: 1.2 kg Chicken, 5 thinly sliced Onion, 2 finely chopped Tomato, 8 cloves chopped Garlic, 1 tbsp Ginger Paste, ¼ cup Vegetable Oil, 2 tsp Cumin Seed, 3 tsp Coriander Seed, 1 tsp Turmeric, 1 tsp Chilli Powder, 2 Green Chilli, 1 cup Yogurt, ¾ cup Cream, 3 tsp Dried Fenugreek, 1 tsp Garam Masala, To taste Salt
- method (9 steps): Take a large pot or wok, big enough to cook all the chicken, and heat the oil in it. Once the oil is hot, add sliced onion and fry them until deep golden brown. Then take them out on a plate and set aside. To the same pot, add the chopped garlic and sauté for a minute. Then add the chopped tomatoes and cook until tomatoes turn soft. This would take about 5 minutes. Then return the fried onion to the pot and stir. Add ginger paste and sauté well. Now add the cumin seeds, half of the coriander seeds and chopped green chillies. Give them a quick stir. Next goes in the spices – turmeric powder and…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 16 ingredients, 60 min)

### mdb-52796
**Chicken Alfredo Primavera** · Chicken · area: Italian
- ingredients: 2 tablespoons Butter, 3 tablespoons Olive Oil, 5 boneless Chicken, 1 teaspoon Salt, 1 cut into 1/2-inch cubes Squash, 1 Head chopped Broccoli, 8-ounce sliced Mushroom, 1 red Black Pepper, 1 chopped Onion, 3 cloves Garlic, 1/2 teaspoon Chilli Flakes, 1/2 cup White Wine, 1/2 cup Milk, 1/2 cup Double Cream, 1 cup grated Parmesan, 16 ounces Bowtie Pasta, pinch Salt, pinch Black Pepper, chopped Parsley
- method (7 steps): Heat 1 tablespoon of butter and 2 tablespoons of olive oil in a large skillet over medium-high heat. Season both sides of each chicken breast with seasoned salt and a pinch of pepper. Add the chicken to the skillet and cook for 5-7 minutes on each side, or until cooked through. While the chicken is cooking, bring a large pot of water to a boil. Season the boiling water with a few generous pinches of kosher salt. Add the pasta and give it a stir. Cook, stirring occasionally, until al dente, about 12 minutes. Reserve 1/2 cup of pasta water before draining the pasta. Remove the chicken from the p…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 19 ingredients, 65 min)

### mdb-52797
**Spicy North African Potato Salad** · Vegetarian · area: Moroccan
- ingredients: 650g/1lb 8 oz New Potato, 1 tsp Harissa Spice, 2 tsp Olive Oil, juice of half Lemon, 4 Spring Onion, 150g/6oz Rocket, 80g/3oz Feta, 20 chopped Mint, 2 tablespoons Pine Nut, Pinch Salt, Pinch Black Pepper
- method (8 steps): Cook potatoes - place potatoes in a pot of cold water, and bring to the boil. Boil 20 minutes, or until potatoes are tender. You know they are cooked when you can stick a knife in them and the knife goes straight through. Combine harissa spice, olive oil, salt and pepper and lemon juice in a small bowl and whisk until combined. Once potatoes are cooked, drain water and roughly chop potatoes in half. Add harissa mix and spring onions/green onions to potatoes and stir. In a large salad bowl, lay out arugula/rocket. Top with potato mix and toss. Add fetta, mint and sprinkle over pine nuts. Adjust…
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 11 ingredients, 45 min)

### mdb-52807
**Baingan Bharta** · Vegetarian · area: India
- ingredients: 1 large Aubergine, ½ cup Onion, 1 cup Tomato, 6 cloves Garlic, 1 Green Chilli, ¼ teaspoon Chilli Powder, 1.5 tablespoon Vegetable Oil, 1 tablespoon chopped Coriander, as required Salt
- method (19 steps): Rinse the baingan (eggplant or aubergine) in water. Pat dry with a kitchen napkin. Apply some oil all over and keep it for roasting on an open flame. You can also grill the baingan or roast in the oven. But then you won't get the smoky flavor of the baingan. Keep the eggplant turning after a 2 to 3 minutes on the flame, so that its evenly cooked. You could also embed some garlic cloves in the baingan and then roast it. Roast the aubergine till its completely cooked and tender. With a knife check the doneness. The knife should slid easily in aubergines without any resistance. Remove the baingan…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 19 steps, 9 ingredients, 40 min, technique: bain)

### mdb-52809
**Recheado Masala Fish** · Seafood · area: India
- ingredients: 4 Mackerel, 18 dried Red Chilli, 1 inch Ginger, 8 cloves Garlic, 1.5 tsp Black Pepper, 1 tsp Ground Cumin, ½ tsp Turmeric, Cinnamon Stick, 4 Clove, 2 Cardamom, 1 tbsp Sugar, 2 marble sized Tamarind Paste, 2.5 tbsp White Vinegar, for frying Vegetable Oil
- method (15 steps): Soak all the spices, ginger, garlic, tamarind pulp and kashmiri chilies except oil in vinegar. Add sugar and salt. Also add turmeric powder. Combine all nicely and marinate for 35-40 mins. Grind the mixture until soft and smooth. Add more vinegar if required but ensure the paste has to be thick so add vinegar accordingly. If the masala paste is thin then it would not stick to the fish. Rinse the fish slit from the center and give some incision from the top. You could see the fish below for clarity. Now stuff the paste into the center and into the incision. Coat the entire fish with this paste.…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy', 'smooth'] (0.50, keywords: crunchy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'hard' (0.55, 15 steps, 14 ingredients, 120 min)

### mdb-52810
**Osso Buco alla Milanese** · Miscellaneous · area: Italian
- ingredients: 4 meaty shanks Veal, ½ cup Plain Flour, 2 tablespoons Olive Oil, 3 tablespoons Butter, 1 medium chopped into ½-inch pieces Onion, 1 chopped into ½-inch pieces Carrot, 1 chopped into ½-inch pieces Celery, 1 bulb chopped into ½-inch pieces Fennel, 3 cloves Garlic, 2 strips Orange Zest, 1 ½ teaspoons Marjoram, 1 Bay Leaf, 1 cup White Wine, ½ cup Chicken Stock, 1 cup chopped with juice Tomato, 2 tablespoons chopped Parsley, 1 teaspoon minced Garlic, 1 teaspoon grated Lemon Zest
- method (22 steps): Heat the oven to 300 degrees. Dredging the shanks: pour the flour into a shallow dish (a pie plate works nicely). Season the veal shanks on all sides with salt and pepper. One at a time, roll the shanks around in the flour coat, and shake and pat the shank to remove any excuses flour. Discard the remaining flour. Browning the shanks: put the oil and 1 tablespoon of the butter in a wide Dutch oven or heavy braising pot (6 to 7 quart) and heat over medium-high heat. When the butter has melted and the oil is shimmering, lower the shanks into the pot, flat side down; if the shanks won’t fit withou…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'tender'] (0.50, keywords: creamy, saucy, tender)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-52811
**Ribollita** · Vegetarian · area: Italian
- ingredients: 5 tablespoons Olive Oil, 1 chopped Onion, 1 chopped Carrot, 1 stalk chopped Celery, 1 tablespoon minced Garlic, 2 cups Cannellini Bean, 1 Chopped Tomatoes, 4 cups Water, 1 fresh sprig Rosemary, 1 fresh sprig Thyme, 1 pound chopped Kale, 4 thick slices Wholegrain Bread, 1 thinly sliced Red Onion, ½ cup freshly grated Parmesan
- method (4 steps): Put 2 tablespoons of the oil in a large pot over medium heat. When it’s hot, add onion, carrot, celery and garlic; sprinkle with salt and pepper and cook, stirring occasionally, until vegetables are soft, 5 to 10 minutes. Heat the oven to 500 degrees. Drain the beans; if they’re canned, rinse them as well. Add them to the pot along with tomatoes and their juices and stock, rosemary and thyme. Bring to a boil, then reduce heat so the soup bubbles steadily; cover and cook, stirring once or twice to break up the tomatoes, until the flavors meld, 15 to 20 minutes. Fish out and discard rosemary and…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'crispy', 'saucy'] (0.50, keywords: brothy, crispy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 14 ingredients, 60 min)

### mdb-52812
**Beef Brisket Pot Roast** · Beef · area: United States
- ingredients: 4-5 pound Beef Brisket, Dash Salt, 3 Onion, 5 cloves Garlic, 1 Sprig Thyme, 1 sprig Rosemary, 4 Bay Leaf, 2 cups Beef Stock, 3 Large Carrot, 1 Tbsp Mustard, 4 Mashed Potato
- method (17 steps): Prepare the brisket for cooking: On one side of the brisket there should be a layer of fat, which you want. If there are any large chunks of fat, cut them off and discard them. Large pieces of fat will not be able to render out completely. Using a sharp knife, score the fat in parallel lines, about 3/4-inch apart. Slice through the fat, not the beef. Repeat in the opposite direction to make a cross-hatch pattern. Salt the brisket well and let it sit at room temperature for 30 minutes. Sear the brisket: You'll need an oven-proof, thick-bottomed pot with a cover, or Dutch oven, that is just wide…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'saucy'] (0.50, keywords: chewy, creamy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 17 steps, 11 ingredients, 495 min, technique: proof)

### mdb-52815
**French Lentils With Garlic and Thyme** · Miscellaneous · area: France
- ingredients: 3 tablespoons Olive Oil, 1 Onion, 2 cloves Garlic, 1 Carrot, 2 1/4 cups French Lentil, 1 teaspoon Thyme, 3 Bay Leaf, 1 tablespoon Salt, 2 sticks Celery
- method (4 steps): Place a large saucepan over medium heat and add oil. When hot, add chopped vegetables and sauté until softened, 5 to 10 minutes. Add 6 cups water, lentils, thyme, bay leaves and salt. Bring to a boil, then reduce to a fast simmer. Simmer lentils until they are tender and have absorbed most of the water, 20 to 25 minutes. If necessary, drain any excess water after lentils have cooked. Serve immediately, or allow them to cool and reheat later. For a fuller taste, use some chicken stock and reduce the water by the same amount.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 45 min)

### mdb-52816
**Roasted Eggplant With Tahini, Pine Nuts, and Lentils** · Vegetarian · area: United States
- ingredients: 2 tablespoons Olive Oil, 2 small cut into chunks Carrot, 2 small stalks Celery, 1 medium finely diced Onion, 6 medium cloves sliced Garlic, 12 ounces (340g) Brown Lentil, 2 Bay Leaf, 4 cups Water, Pinch Salt, 2 teaspoons (10ml) Cider Vinegar, Pinch Black Pepper, 2 large Aubergine, 4 sprigs Rosemary, 1/4 cup Pine Nut, 2 tablespoons Parsley
- method (10 steps): For the Lentils: Adjust oven rack to center position and preheat oven to 450°F to prepare for roasting eggplant. Meanwhile, heat 2 tablespoons olive oil in a medium saucepan over medium heat until shimmering. Add carrots, celery, and onion and cook, stirring, until softened but not browned, about 4 minutes. Add garlic and cook, stirring, until fragrant, about 30 seconds. Add lentils, bay leaves, stock or water, and a pinch of salt. Bring to a simmer, cover with the lid partially ajar, and cook until lentils are tender, about 30 minutes. (Top up with water if lentils are at any point not fully …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 15 ingredients, 95 min)
