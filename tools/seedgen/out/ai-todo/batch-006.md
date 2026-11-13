# AI tagging batch 006

Write `tools/seedgen/tags/ai/batch-006.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52842
**Broccoli & Stilton soup** · Starter · area: British
- ingredients: 2 tblsp Vegetable Oil, 1 finely chopped Onion, 1 Celery, 1 sliced Leek, 1 medium Potato, 1 knob Butter, 1 litre hot Vegetable Stock, 1 Head chopped Broccoli, 140g Stilton Cheese
- method (4 steps): Heat the rapeseed oil in a large saucepan and then add the onions. Cook on a medium heat until soft. Add a splash of water if the onions start to catch. Add the celery, leek, potato and a knob of butter. Stir until melted, then cover with a lid. Allow to sweat for 5 minutes. Remove the lid. Pour in the stock and add any chunky bits of broccoli stalk. Cook for 10 – 15 minutes until all the vegetables are soft. Add the rest of the broccoli and cook for a further 5 minutes. Carefully transfer to a blender and blitz until smooth. Stir in the stilton, allowing a few lumps to remain. Season with bla…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 40 min)

### mdb-52845
**Turkey Meatloaf** · Miscellaneous · area: British
- ingredients: 1 tblsp Olive Oil, 1 large Onion, 1 clove peeled crushed Garlic, 2 tblsp Worcestershire Sauce, 3 tsp Tomato Puree, 500g Turkey Mince, 1 large Egg, 85g Breadcrumb, 2 tblsp Barbeque Sauce, 800g Cannellini Bean, 2 tblsp Parsley
- method (5 steps): Heat oven to 180C/160C fan/gas. Heat the oil in a large frying pan and cook the onion for 8-10 mins until softened. Add the garlic, Worcestershire sauce and 2 tsp tomato purée, and stir until combined. Set aside to cool. Put the turkey mince, egg, breadcrumbs and cooled onion mix in a large bowl and season well. Mix everything to combine, then shape into a rectangular loaf and place in a large roasting tin. Spread 2 tbsp barbecue sauce over the meatloaf and bake for 30 mins. Meanwhile, drain 1 can of beans only, then pour both cans into a large bowl. Add the remaining barbecue sauce and tomato…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 80 min, technique: piping)

### mdb-52846
**Chicken & mushroom Hotpot** · Chicken · area: British
- ingredients: 50g Butter, 1 chopped Onion, 100g Mushroom, 40g Plain Flour, 1 Chicken Stock, pinch Ground Nutmeg, pinch Mustard Powder, 250g Chicken, 2 Handfuls Sweetcorn, 2 large Potato, 1 knob Butter
- method (8 steps): Heat oven to 200C/180C fan/gas. Put the butter in a medium-size saucepan and place over a medium heat. Add the onion and leave to cook for 5 mins, stirring occasionally. Add the mushrooms to the saucepan with the onions. Once the onion and mushrooms are almost cooked, stir in the flour – this will make a thick paste called a roux. If you are using a stock cube, crumble the cube into the roux now and stir well. Put the roux over a low heat and stir continuously for 2 mins – this will cook the flour and stop the sauce from having a floury taste. Take the roux off the heat. Slowly add the fresh s…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 11 ingredients, 75 min)

### mdb-52847
**Pork Cassoulet** · Pork · area: France
- ingredients: 4 tbsp Goose Fat, 350g Pork, 1 large Onion, 10 Garlic, 1 thinly sliced Carrot, 1 tsp Fennel Seed, 2 tblsp Red Wine Vinegar, 600ml Vegetable Stock, 1 tblsp Tomato Puree, 2 sticks Rosemary, Handful Parsley, 400g Haricot Bean, 2 tblsp Breadcrumb, drizzle Vegetable Oil, to serve Bread, to serve Broccoli
- method (4 steps): Heat oven to 140C/120C fan/gas. Put a large ovenproof pan (with a tight-fitting lid) on a high heat. Add your fat and diced meat, cook for a few mins to seal the edges, giving it a quick stir to cook evenly. Reduce the heat to low, add the sliced onion, whole garlic cloves, carrot and fennel seeds, and cook gently to soften the veg for a few mins. Pour over the red wine vinegar, scraping any meaty bits off the bottom of the pan. Add the stock, tomato purée, and half the rosemary and parsley. Bring to the boil and simmer for 10 mins, then season, cover with a lid and put into the oven for 2 hrs…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 16 ingredients, 200 min)

### mdb-52848
**Bean & Sausage Hotpot** · Miscellaneous · area: British
- ingredients: 8 large Sausage, 1 Jar Tomato Sauce, 1200g Butter Bean, 1 tbls Black Treacle, 1 tsp English Mustard
- method (2 steps): In a large casserole, fry the sausages until brown all over – about 10 mins. Add the tomato sauce, stirring well, then stir in the beans, treacle or sugar and mustard. Bring to the simmer, cover and cook for 30 mins. Great served with crusty bread or rice.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 5 ingredients, 50 min)

### mdb-52849
**Spinach & Ricotta Cannelloni** · Vegetarian · area: Italian
- ingredients: 3 tbsp Olive Oil, 8 cloves chopped Garlic, 3 tbsp Sugar, 2 tblsp Red Wine Vinegar, 3 400g Cans Chopped Tomatoes, Bunch Basil, 2 tubs Mascarpone, 3 tbsp Milk, 85g Parmesan, 2 sliced Mozzarella, 1kg Spinach, 100g Parmesan, 3 tubs Ricotta, pinch Ground Nutmeg, 400g Cannellini Bean
- method (6 steps): First make the tomato sauce. Heat the oil in a large pan and fry the garlic for 1 min. Add the sugar, vinegar, tomatoes and some seasoning and simmer for 20 mins, stirring occasionally, until thick. Add the basil and divide the sauce between 2 or more shallow ovenproof dishes (see Tips for freezing, below). Set aside. Make a sauce by beating the mascarpone with the milk until smooth, season, then set aside. Put the spinach in a large colander and pour over a kettle of boiling water to wilt it (you may need to do this in batches). When cool enough to handle squeeze out the excess water. Roughly…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 15 ingredients, 90 min, technique: piping)

### mdb-52850
**Chicken Couscous** · Chicken · area: Moroccan
- ingredients: 1 tbsp Olive Oil, 1 chopped Onion, 200g Chicken Breast, pinch Ginger, 2 tblsp Harissa Spice, 10 Dried Apricot, 220g Chickpea, 200g Couscous, 200ml Chicken Stock, Handful Coriander
- method (2 steps): Heat the olive oil in a large frying pan and cook the onion for 1-2 mins just until softened. Add the chicken and fry for 7-10 mins until cooked through and the onions have turned golden. Grate over the ginger, stir through the harissa to coat everything and cook for 1 min more. Tip in the apricots, chickpeas and couscous, then pour over the stock and stir once. Cover with a lid or tightly cover the pan with foil and leave for about 5 mins until the couscous has soaked up all the stock and is soft. Fluff up the couscous with a fork and scatter over the coriander to serve. Serve with extra hari…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['fluffy'] (0.50, keywords: fluffy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 35 min)

### mdb-52851
**Nutty Chicken Curry** · Chicken · area: India
- ingredients: 1 large Red Chilli, 0.5 Ginger, 1 large Garlic, Bunch Coriander, 1 tbsp Vegetable Oil, 4 Chicken Breast, 5 tblsp Peanut Butter, 150ml Chicken Stock, 200g Greek Yogurt
- method (3 steps): Finely slice a quarter of the chilli, then put the rest in a food processor with the ginger, garlic, coriander stalks and one-third of the leaves. Whizz to a rough paste with a splash of water if needed. Heat the oil in a frying pan, then quickly brown the chicken chunks for 1 min. Stir in the paste for another min, then add the peanut butter, stock and yogurt. When the sauce is gently bubbling, cook for 10 mins until the chicken is just cooked through and sauce thickened. Stir in most of the remaining coriander, then scatter the rest on top with the chilli, if using. Eat with rice or mashed s…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 35 min)

### mdb-52852
**Tuna Nicoise** · Seafood · area: France
- ingredients: 450g Potato, 2 tblsp Olive Oil, 4 Egg, 1 tbls Red Wine Vinegar, 2 tblsp Caper, 50g Vegetable Oil, ½ Red Onion, 100g Spinach, 400g Tuna
- method (4 steps): Heat oven to 200C/fan 180C/gas. Toss the potatoes with 2 tsp oil and some seasoning. Tip onto a large baking tray, then roast for 20 mins, stirring halfway, until crisp, golden and cooked through. Meanwhile, put eggs in a small pan of water, bring to the boil, then simmer for 8-10 mins, depending on how you like them cooked. Plunge into a bowl of cold water to cool for a few mins. Peel away the shells, then cut into halves. In a large salad bowl, whisk together the remaining oil, red wine vinegar, capers and chopped tomatoes. Season, tip in the onion, spinach, tuna and potatoes, then gently to…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 55 min)

### mdb-52853
**Chocolate Avocado Mousse** · Dessert · area: British
- ingredients: 1 Banana, 3 tbsp Cocoa Powder, 1 Avocado, 2 tblsp Honey, 1 tsp Lemon Juice, 1 tsp Vanilla Extract, 2 tbsp Water, pinch Salt
- method (4 steps): Blend all the mousse ingredients together in your food processor until smooth. Add the cacao powder first and, as you blend, have all the ingredients to hand in order to adjust the ratios slightly as the size of avocados and bananas varies so much. The perfect ratio in order to avoid the dish tasting too much of either is to use equal amounts of both. Taste and add a few drops of stevia if you feel you need more sweetness. Fill little cups or shot glasses with the mousse, sprinkle with the cacao powder or nibs and serve. Tip If you don’t have a frozen banana to hand you can just use a normal o…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 45 min)

### mdb-52855
**Banana Pancakes** · Dessert · area: United States
- ingredients: 1 large Banana, 2 medium Egg, pinch Baking Powder, spinkling Vanilla Extract, 1 tsp Vegetable Oil, 25g Pecan Nut, 125g Raspberry
- method (2 steps): In a bowl, mash the banana with a fork until it resembles a thick purée. Stir in the eggs, baking powder and vanilla. Heat a large non-stick frying pan or pancake pan over a medium heat and brush with half the oil. Using half the batter, spoon two pancakes into the pan, cook for 1-2 mins each side, then tip onto a plate. Repeat the process with the remaining oil and batter. Top the pancakes with the pecans and raspberries.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 20 min)

### mdb-52856
**Choc Chip Pecan Pie** · Dessert · area: United States
- ingredients: 300g Plain Flour, 75g Butter, 100g Cream Cheese, 1 tbls Icing Sugar, 150g Butter, 200ml Maple Syrup, 250g Brown Sugar, 100g Brown Sugar, 4 Egg, 1 tsp Vanilla Extract, 400g Pecan Nut, 200g Dark Chocolate Chip
- method (8 steps): First, make the pastry. Tip the ingredients into a food processor with 1 /4 tsp salt. Blend until the mixture resembles breadcrumbs. Drizzle 2-3 tsp cold water into the funnel while the blade is running – the mixture should start to clump together. Tip onto a work surface and bring together, kneading briefly into a ball. Pat into a disc, wrap in cling film, and chill for at least 20 mins. Heat oven to 200C/180C fan/gas 6. Remove the pastry from the fridge and leave at room temperature for 5 mins to soften. Flour the work surface, then unwrap the pastry and roll to a circle the thickness of a £…
- `textures` rule: ['creamy', 'crunchy', 'flaky'] (0.50, keywords: creamy, crunchy, flaky)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 12 ingredients, 250 min, technique: knead, make the pastry)

### mdb-52857
**Pumpkin Pie** · Dessert · area: United States
- ingredients: 750g Pumpkin, 350g Shortcrust Pastry, Dusting Plain Flour, 140g Sugar, ½ tsp Salt, ½ tsp Ground Nutmeg, 1 tsp Cinnamon, 2 Beaten Egg, 25g Butter, 175g Milk, 1 tblsp Icing Sugar
- method (7 steps): Place the pumpkin in a large saucepan, cover with water and bring to the boil. Cover with a lid and simmer for 15 mins or until tender. Drain pumpkin; let cool. Heat oven to 180C/160C fan/gas. Roll out the pastry on a lightly floured surface and use it to line a 22cm loose-bottomed tart tin. Chill for 15 mins. Line the pastry with baking parchment and baking beans, then bake for 15 mins. Remove the beans and paper, and cook for a further 10 mins until the base is pale golden and biscuity. Remove from the oven and allow to cool slightly. Increase oven to 220C/200C fan/gas. Push the cooled pumpk…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['flaky', 'smooth'] (0.50, keywords: flaky, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 11 ingredients, 125 min, technique: roll out the pastry)

### mdb-52859
**Key Lime Pie** · Dessert · area: United States
- ingredients: 300g Digestive Biscuit, 150g Butter, 400g Condensed Milk, 3 Egg Yolk, 4 Lime, 300ml Double Cream, 1 tbls Icing Sugar, to serve Lime
- method (4 steps): Heat the oven to 160C/fan 140C/gas. Whizz the biscuits to crumbs in a food processor (or put in a strong plastic bag and bash with a rolling pin). Mix with the melted butter and press into the base and up the sides of a 22cm loose-based tart tin. Bake in the oven for 10 minutes. Remove and cool. Put the egg yolks in a large bowl and whisk for a minute with electric beaters. Add the condensed milk and whisk for 3 minutes then add the zest and juice and whisk again for 3 minutes. Pour the filling into the cooled base then put back in the oven for 15 minutes. Cool then chill for at least 3 hours …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 8 ingredients, 235 min, technique: pipe)

### mdb-52860
**Chocolate Raspberry Brownies** · Dessert · area: United States
- ingredients: 200g Dark Chocolate, 100g Milk Chocolate, 250g Butter, 400g Brown Sugar, 4 large Egg, 140g Plain Flour, 50g Cocoa Powder, 200g Raspberry
- method (3 steps): Heat oven to 180C/160C fan/gas. Line a 20 x 30cm baking tray tin with baking parchment. Put the chocolate, butter and sugar in a pan and gently melt, stirring occasionally with a wooden spoon. Remove from the heat. Stir the eggs, one by one, into the melted chocolate mixture. Sieve over the flour and cocoa, and stir in. Stir in half the raspberries, scrape into the tray, then scatter over the remaining raspberries. Bake on the middle shelf for 30 mins or, if you prefer a firmer texture, for 5 mins more. Cool before slicing into squares. Store in an airtight container for up to 3 days.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 8 ingredients, 45 min)

### mdb-52861
**Peanut Butter Cheesecake** · Dessert · area: United States
- ingredients: 50g Butter, 175g Peanut Cooky, 5 Gelatine, 500g Ricotta, 175g Peanut Butter, 175g Golden Syrup, 150ml Milk, 275ml Double Cream, 2 tblsp Brown Sugar, Crushed Peanut Brittle
- method (6 steps): Oil and line a 20cm round loose- bottomed cake tin with cling film, making it as smooth as possible. Melt the butter in a pan. Crush the biscuits by bashing them in a bag with a rolling pin, then stir them into the butter until very well coated. Press the mixture firmly into the base of the tin and chill. Soak the gelatine in water while you make the filling. Tip the ricotta into a bowl, then beat in the peanut butter and syrup. Ricotta has a slightly grainy texture so blitz until smooth with a stick blender for a smoother texture if you prefer. Take the soaked gelatine from the water and sque…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 530 min)

### mdb-52862
**Peach & Blueberry Grunt** · Dessert · area: United States
- ingredients: 1 tsp Cornflour, Juice of 2 Orange, Zest of 1 Orange, 2 tbs Sugar, 6 Peach, 250g Blueberry, 200g Self Raising Flour, 50g Butter, 100g Muscovado Sugar, 1 tsp Cinnamon, 6 tblsp Milk
- method (5 steps): Heat oven to 190C/170C fan/gas. Butter a wide shallow ovenproof dish. Blend the cornflour with the orange zest and juice, and put in a large pan with the sugar. Halve, stone and slice the peaches and add to the pan. Bring slowly to the boil, stirring gently until the sauce is shiny and thickened, about 3-4 mins. Remove from the heat, stir in the blueberries and tip into the prepared dish. Tip the flour into a mixing bowl and add the 50g butter. Rub the butter into the flour until it resembles fine breadcrumbs, then stir in half the sugar. Mix the remaining sugar with the cinnamon and set aside…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 60 min, technique: knead)

### mdb-52863
**Vegetarian Casserole** · Vegetarian · area: British
- ingredients: 1 Vegetable Oil, 1 Onion, 3 cloves Garlic, 1 tsp Paprika, ½ tsp Ground Cumin, 1 tblsp Thyme, 3 Medium Carrot, 2 small stalks Celery, 1 Red Pepper, 1 Yellow Pepper, 2 x 400g tins Tomato, 250ml Vegetable Stock, 2 sliced Courgette, 2 sprigs Thyme, 250g Lentil
- method (4 steps): Heat the oil in a large, heavy-based pan. Add the onions and cook gently for 5 – 10 mins until softened. Add the garlic, spices, dried thyme, carrots, celery and peppers and cook for 5 minutes. Add the tomatoes, stock, courgettes and fresh thyme and cook for 20 - 25 minutes. Take out the thyme sprigs. Stir in the lentils and bring back to a simmer. Serve with wild and white basmati rice, mash or quinoa.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 15 ingredients, 60 min)

### mdb-52864
**Mushroom & Chestnut Rotolo** · Vegetarian · area: British
- ingredients: 30g Mushroom, 240g Chestnut, 3 Shallot, 3 cloves Garlic, 3 sprigs Rosemary, 500g Mushroom, 2 tblsp Soy Sauce, 125ml White Wine, 350g Lasagne Sheet, 4 tbsp Breadcrumb, 1/2 handful Sage, to serve Truffle Oil
- method (13 steps): Soak the dried mushrooms in 350ml boiling water and set aside until needed. Blitz ¾ of the chestnuts with 150ml water until creamy. Roughly chop the remaining chestnuts. Heat 2 tbsp olive oil in a large non-stick frying pan. Fry the shallots with a pinch of salt until softened, then add the garlic, chopped chestnuts and rosemary, and fry for 2 mins more. Add the wild mushrooms, 2 tbsp oil and some seasoning. Cook for 3 mins until they begin to soften. Drain and roughly chop the dried mushrooms (reserve the soaking liquid), then add those too, along with the soy sauce, and fry for 2 mins more. …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 13 steps, 12 ingredients, 70 min)

### mdb-52866
**Squash linguine** · Vegetarian · area: Italian
- ingredients: 350g Butternut Squash, 3 parts Garlic, 3 tbs Olive Oil, 350g Linguine Pasta, Small bunch Sage
- method (3 steps): Heat oven to 200C/180C fan/gas. Put the squash and garlic on a baking tray and drizzle with the olive oil. Roast for 35-40 mins until soft. Season. Cook the pasta according to pack instructions. Drain, reserving the water. Use a stick blender to whizz the squash with 400ml cooking water. Heat some oil in a frying pan, fry the sage until crisp, then drain on kitchen paper. Tip the pasta and sauce into the pan and warm through. Scatter with sage.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy', 'saucy'] (0.50, keywords: crispy, crunchy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 5 ingredients, 45 min)
