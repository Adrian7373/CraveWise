# AI tagging batch 012

Write `tools/seedgen/tags/ai/batch-012.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52980
**Stamppot** · Pork · area: Netherlands
- ingredients: 1.5kg Potato, 2 leaves Bay Leaf, 2 Shallot, 3 tbs Butter, 750g Kale, 2 Sausage, 500ml Milk, Grated Ground Nutmeg, Pinch Salt, Pinch Black Pepper
- method (10 steps): Wash and peel the potatoes and cut into similarly sized pieces for even cooking. In a large soup pot, boil the potatoes and the bay leaves in salted water for 20 minutes. Discard the bay leaves. If you're not using a bag of ready-cut curly kale, wash the bunches thoroughly under cool running water to get rid of all soil—you wouldn't want that gritty texture in your finished dish. Trim any coarse stems and discard any brown leaves. With a sharp knife, cut the curly kale into thin strips. Peel and chop the shallots. In a frying pan or skillet, melt 1 tbsp. of butter and saute the shallots for a …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy', 'saucy'] (0.50, keywords: brothy, creamy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 10 ingredients, 60 min)

### mdb-52981
**Snert (Dutch Split Pea Soup)** · Side · area: Netherlands
- ingredients: 2L Water, 300g Pea, 100g Pork, 1 Vegetable Stock, 2 Celery, 2 Carrot, 1 large Potato, 1 small Onion, 1 small Leek, 1 cup Celeriac, 1 pound Sausage
- method (8 steps): Gather the ingredients. In a large soup pot, bring water, split peas, pork belly or bacon, pork chop, and bouillon cube to a boil. Reduce the heat to a simmer, cover and let cook for 45 minutes, stirring occasionally and skimming off any foam that rises to the top. Remove the pork chop, debone, and thinly slice the meat. Set aside. Add the celery, carrots, potato, onion, leek, and celeriac to the soup. Return to the boil, reduce the heat to a simmer and let cook, uncovered, for another 30 minutes, adding a little extra water if the ingredients start to stick to the bottom of the pot. Add the s…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 11 ingredients, 130 min, technique: debone)

### mdb-52987
**Lasagna Sandwiches** · Pasta · area: United States
- ingredients: 1/4 cup Sour Cream, 2 tbs Onion, 1/2 tbs Dried Oregano, 1/4 tsp Salt, 8 slices Bread, 8 slices Bacon, 8 slices Tomato, 4 slices Mozzarella, 2 1/2 Tbs Butter
- method (3 steps): In a small bowl, combine the first four ingredients; spread on four slices of bread. Layer with bacon, tomato and cheese; top with remaining bread. In a large skillet or griddle, melt 2 tablespoons butter. Toast sandwiches until lightly browned on both sides and cheese is melted, adding butter if necessary. Nutrition Facts 1 sandwich: 445 calories, 24g fat (12g saturated fat), 66mg cholesterol, 1094mg sodium, 35g carbohydrate (3g sugars, 2g fiber), 21g protein.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Pasta guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 50 min)

### mdb-52988
**Classic Christmas pudding** · Dessert · area: British
- ingredients: 50g Almond, 2 large Cooking Apple, 200g Candied Peel, 1 whole Ground Nutmeg, 1kg Raisin, 140g Plain Flour, 100g Breadcrumb, 100g Muscovado Sugar, 3 Large Egg, 2 tbs Brandy, 250g Butter
- method (8 steps): Get everything for the pudding prepared. Chop the almonds coarsely. Peel, core and chop the cooking apples. Sharpen your knife and chop the candied peel. (You can chop the almonds and apples in a food processor, but the peel must be done by hand.) Grate three quarters of the nutmeg (sounds a lot but it's correct). Mix the almonds, apples, candied peel, nutmeg, raisins, flour, breadcrumbs, light muscovado sugar, eggs and 2 tbsp brandy or cognac in a large bowl. Holding the butter in its wrapper, grate a quarter of it into the bowl, then stir everything together. Repeat until all the butter is g…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'festive', 'indulgent'] (0.50, keywords/category: comfort, festive, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 11 ingredients, 585 min)

### mdb-52989
**Christmas Pudding Trifle** · Dessert · area: British
- ingredients: 3 Orange, 1 tbs Demerara Sugar, 2 tbs Grand Marnier, 300g Christmas Pudding, 500g Custard, 250g Mascarpone, 284ml Double Cream, Handful Flaked Almond, Grated Dark Chocolate
- method (4 steps): Peel the oranges using a sharp knife, ensuring all the pith is removed. Slice as thinly as possible and arrange over a dinner plate. Sprinkle with the demerara sugar followed by the Grand Marnier and set aside. Crumble the Christmas pudding into large pieces and scatter over the bottom of a trifle bowl. Lift the oranges onto the pudding in a layer and pour over any juices. Beat the mascarpone until smooth, then stir in the custard. Spoon the mixture over the top of the oranges. Lightly whip the cream and spoon over the custard. Sprinkle with the flaked almonds and grated chocolate. You can mak…
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['comfort', 'festive', 'hearty'] (0.50, keywords/category: comfort, festive, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 55 min)

### mdb-52990
**Christmas cake** · Dessert · area: British
- ingredients: 200g Butter, 200g Muscovado Sugar, 200g Plain Flour, 4 Beaten Egg, 50g Ground Almond, 100ml Sherry, 85g Candied Peel, 85g Glace Cherry, 250g Raisin, 250g Currant, 100g Pecan Nut, Grated zest of 1 Lemon, 1 ½ tbsp Mixed Spice, 1 ½ tbsp Rose Water, 1/2 tsp Vanilla Extract, 1/2 tsp Baking Powder
- method (6 steps): Heat oven to 160C/fan 140C/gas. Line the base and sides of a 20 cm round, 7.5 cm deep cake tin. Beat the butter and sugar with an electric hand mixer for 1-2 mins until very creamy and pale in colour, scraping down the sides of the bowl half way through. Stir in a spoonful of the flour, then stir in the beaten egg and the rest of the flour alternately, a quarter at a time, beating well each time with a wooden spoon. Stir in the almonds. Mix in the sherry (the mix will look curdled), then add the peel, cherries, raisins, cherries, nuts, lemon zest, spice, rosewater and vanilla. Beat together to…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['comfort', 'festive', 'fresh'] (0.50, keywords/category: comfort, festive, fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 16 ingredients, 190 min, technique: temper)

### mdb-52991
**Mince Pies** · Dessert · area: British
- ingredients: 225g Butter, 350g Plain Flour, 100g Sugar, 280g Mincemeat, 1 small Egg, Topping Icing Sugar
- method (8 steps): To make the pastry, rub 225g cold, diced butter into 350g plain flour, then mix in 100g golden caster sugar and a pinch of salt. Combine the pastry into a ball – don’t add liquid – and knead it briefly. The dough will be fairly firm, like shortbread dough. You can use the dough immediately, or chill for later. Preheat the oven to 200C/gas 6/fan 180C. Line 18 holes of two 12-hole patty tins, by pressing small walnut-sized balls of pastry into each hole. Spoon 280g mincemeat into the pies. Take slightly smaller balls of pastry than before and pat them out between your hands to make round lids, b…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'flaky'] (0.50, keywords: crunchy, flaky)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 6 ingredients, 45 min, technique: knead, make the pastry)

### mdb-52992
**Soy-Glazed Meatloaves with Wasabi Mashed Potatoes & Roasted Carrots** · Beef · area: United States
- ingredients: 5 Potato, 12 ounces Carrot, 1 Spring Onion, 2 cloves Garlic, 1 Slice Bread, 1 Garlic Powder, 2 Soy Sauce, 1 Beef Mince, 1 tsp Vegetable Oil, 2 tsp Sugar, 2 tbsp Butter
- method (8 steps): Preheat oven to 425 degrees. Wash and dry all produce. Dice potatoes into 1/2-inch pieces. Trim, peel, and cut carrots on a diagonal into 1/2-inch-thick pieces. Trim and thinly slice scallions, separating whites from greens; finely chop whites. Peel and finely chop garlic. In a medium bowl, soak bread with 2 TBSP water (4 TBSP for 4 servings); break up with your hands until pasty. Stir in beef, sriracha, scallion whites, half the garlic, salt (we used 3/4 tsp kosher salt; 11/2 tsp for 4), and pepper. Form into two 1-inch-tall loaves (four loaves for 4). Place on one side of a baking sheet. Tos…
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `difficulty` rule: 'easy' (0.55, 8 steps, 11 ingredients, 100 min)

### mdb-52993
**Honey Balsamic Chicken with Crispy Broccoli & Potatoes** · Chicken · area: United States
- ingredients: 5 Potato, 1 Broccoli, 2 cloves Garlic, 2 Chicken Breast, Balsamic Vinegar, Honey, Chicken Stock, 1 tbsp Butter, 1 tbsp Vegetable Oil, 1 tbsp Olive Oil
- method (7 steps): Servings. Preheat oven to 425 degrees. Wash and dry all produce. Cut potatoes into 1/2-inch-thick wedges. Toss on one side of a baking sheet with a drizzle of oil, salt, and pepper. (For 4 servings, spread potatoes out across entire sheet.) Roast on top rack for 5 minutes (we'll add the broccoli then). Meanwhile, cut broccoli florets into bite-size pieces, if necessary. Peel and finely chop garlic. In a small microwave-safe bowl, combine 1 TBSP olive oil (2 TBSP for 4 servings) and half the garlic. Microwave until garlic sizzles, 30 seconds. Once potatoes have roasted 5 minutes, remove sheet f…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `difficulty` rule: 'easy' (0.55, 7 steps, 10 ingredients, 60 min)

### mdb-52994
**Skillet Apple Pork Chops with Roasted Sweet Potatoes & Zucchini** · Pork · area: United States
- ingredients: 2 Potato, 1 Apple, 2 cloves Garlic, 1 Lemon, 2 Pork, 1 Courgette, 1 Chicken Stock, 1 tbsp Vegetable Oil, 1 1/2 tsp Sugar, 2 tbsp Butter
- method (8 steps): Serves 2. Adjust racks to top and middle positions and preheat oven to 450 degrees. Wash and dry all produce. Dice sweet potatoes into 1/2-inch pieces. Toss on a baking sheet with a drizzle of oil, salt, and pepper. Roast on top rack for 12 minutes (we'll roast the zucchini then). Meanwhile, halve and core apple; thinly slice into half-moons. Peel and finely chop garlic. Quarter lemon. Trim and halve zucchini lengthwise; cut crosswise into 1/2-inch-thick half-moons. Toss on a second baking sheet with a drizzle of oil and a pinch of salt and pepper. Set aside. Pat pork dry with paper towels and…
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `difficulty` rule: 'easy' (0.55, 8 steps, 10 ingredients, 75 min)

### mdb-52995
**BBQ Pork Sloppy Joes** · Pork · area: United States
- ingredients: 2 Potato, 1 Red Onion, 2 cloves Garlic, 1 Lime, 2 Bread, 1 lb Pork, Barbeque Sauce, Hot Sauce, Tomato Ketchup, Sugar, Vegetable Oil, Salt, Black Pepper
- method (6 steps): Preheat oven to 450 degrees. Wash and dry all produce. Cut sweet potatoes into ½-inch-thick wedges. Toss on a baking sheet with a drizzle of oil, salt, and pepper. Roast until browned and tender, 20-25 minutes. Meanwhile, halve and peel onion. Slice as thinly as possible until you have ¼ cup (½ cup for 4 servings); finely chop remaining onion. Peel and finely chop garlic. Halve lime; squeeze juice into a small bowl. Halve buns. Add 1 TBSP butter (2 TBSP for 4) to a separate small microwave-safe bowl; microwave until melted, 30 seconds. Brush onto cut sides of buns. To bowl with lime juice, add…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `difficulty` rule: 'easy' (0.55, 6 steps, 13 ingredients, 80 min)

### mdb-52996
**French Onion Chicken with Roasted Carrots & Mashed Potatoes** · Chicken · area: United States
- ingredients: 2 Chicken Breast, 12 ounces Carrot, 5 Potato, 1 Onion, 1 Beef Stock, 1 1/2 cup Mozzarella, 2 tbsp Sour Cream, Butter, Sugar, Vegetable Oil, Salt, Black Pepper
- method (7 steps): Preheat oven to 425 degrees. Wash and dry all produce. Trim, peel, and cut carrots on a diagonal into ¼-inch-thick pieces. Dice potatoes into ½-inch pieces. Halve, peel, and thinly slice onion. Toss carrots on a baking sheet with a drizzle of oil, salt, and pepper. Roast until browned and tender, 15-20 minutes. Meanwhile, place potatoes in a medium pot with enough salted water to cover by 2 inches. Bring to a boil and cook until tender, 12-15 minutes. Drain and return potatoes to pot; cover to keep warm. While potatoes cook, heat a drizzle of oil in a large pan over medium-high heat. Add onion…
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `difficulty` rule: 'easy' (0.55, 7 steps, 12 ingredients, 80 min, technique: caramelize)

### mdb-52997
**Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber** · Beef · area: Vietnamese
- ingredients: White Rice, 1 Onion, 1 Lime, 3 Garlic, 1 Cucumber, 3 oz Carrot, 1 lb Beef Mince, 2 oz Soy Sauce
- method (6 steps): Add'l ingredients: mayonnaise, siracha. Place rice in a fine-mesh sieve and rinse until water runs clear. Add to a small pot with 1 cup water (2 cups for 4 servings) and a pinch of salt. Bring to a boil, then cover and reduce heat to low. Cook until rice is tender, 15 minutes. Keep covered off heat for at least 10 minutes or until ready to serve. Meanwhile, wash and dry all produce. Peel and finely chop garlic. Zest and quarter lime (for 4 servings, zest 1 lime and quarter both). Trim and halve cucumber lengthwise; thinly slice crosswise into half-moons. Halve, peel, and medium dice onion. Tri…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 70 min)

### mdb-52998
**Corned Beef and Cabbage** · Beef · area: Irish
- ingredients: 3 Lbs Beef Brisket, 10 New Potato, 5 Carrot, 1 head Cabbage
- method (3 steps): Place corned beef in large pot or Dutch oven and cover with water. Add the spice packet that came with the corned beef. Cover pot and bring to a boil, then reduce to a simmer. Simmer approximately 50 minutes per pound or until tender. Add whole potatoes and peeled and cut carrots, and cook until the vegetables are almost tender. Add cabbage and cook for 15 more minutes. Remove meat and let rest 15 minutes. Place vegetables in a bowl and cover. Add as much broth (cooking liquid reserved in the Dutch oven or large pot) as you want. Slice meat across the grain.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'tender'] (0.50, keywords: brothy, tender)
- `moods` rule: ['hearty', 'light'] (0.50, keywords/category: hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 4 ingredients, 80 min)

### mdb-52999
**Crispy Sausages and Greens** · Pork · area: Irish
- ingredients: 1 bunch Kale, 8 Italian Fennel Sausage, 1 Head chopped Cabbage, 8 Garlic, Sliced Onion, Sliced Shiitake Mushroom, 1 cup Chicken Stock, Salt, Black Pepper
- method (6 steps): Preheat the oven to 350°. Remove the stems from one bunch of Tuscan kale and tear the leaves into 1" pieces (mustard greens, collards, spinach, and chard are great, too). Coarsely chop half a head of green cabbage. Combine the greens in a large baking dish and add 4 cloves of thinly sliced garlic. Adding some sliced onions and shiitake mushrooms at this point is optional, but highly recommended (I'll sauté the onions and mushrooms in a cast iron baking dish right on the stove before adding to the greens). Coat the greens with some olive oil and pour ½ cup chicken stock or broth over everything…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'crispy'] (0.50, keywords: brothy, crispy)
- `moods` rule: ['comfort', 'hearty', 'light'] (0.50, keywords/category: comfort, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 9 ingredients, 70 min)

### mdb-53000
**Vegetable Shepherds Pie** · Beef · area: Irish
- ingredients: 3 Lbs Potato, 3 Lbs New Potato, 1/2 cup Butter, 1 oz Mushroom, 3/4 cup Brown Lentil, 6 cloves Garlic, 1 tsp Salt, 3 cups Onion, 2 tbsp Tomato Puree, Bay Leaf, Olive Oil, 2 cups White Wine, 8 cups Vegetable Stock, 2 tbsp Cornflour, 2 tsp Soy Sauce, 2 sprigs Rosemary, Parsley, Sage, Chive
- method (13 steps): Add Ingredients:. 12 cups chopped mixed vegetables 1 cup chopped fresh mushrooms 1 cup pearl onions. TOPPING:. Preheat oven to 450°. Bake potatoes on a foil-lined baking sheet until tender, about 45 minutes. Let cool slightly, then peel. Press potatoes through a ricer, food mill, or colander into a large bowl. Add butter; stir until well blended. Stir in milk. Season to taste with salt. FILLING:. Soak dried porcini in 3 cups hot water; set aside. Combine lentils, 1 garlic clove, 1 tsp. salt, and 4 cups water in a medium saucepan. Bring to a boil; reduce heat and simmer, stirring occasionally, …
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy', 'saucy'] (0.50, keywords: brothy, creamy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 13 steps, 19 ingredients, 245 min, technique: caramelize)

### mdb-53005
**Strawberry Rhubarb Pie** · Dessert · area: British
- ingredients: 350g Plain Flour, 1 tsp Salt, 2 tbs Sugar, 1 cup Butter, 1/2 cup Water, 450g Rhubarb, 450g Strawberries, 3 tbs Cornflour, 150g Sugar, 1/4 tsp Cinnamon, 1 tsp Lemon Juice, 2 tbs Butter, 2 tbs Milk, Spinkling Sugar
- method (17 steps): Pie Crust: In a food processor, place the flour, salt, and sugar and process until combined. Add the butter and process until the mixture resembles coarse. meal (about 15 seconds). Pour 1/4 cup (60 ml) water in a slow, steady stream, through the feed tube until the dough just holds together when pinched. If necessary, add more water. Do not process more than 30 seconds. Turn the dough onto your work surface and gather into a ball. Divide the dough in half, flattening each half into a disk, cover with plastic wrap, and refrigerate for about one hour before using. This will chill the butter and …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky'] (0.50, keywords: creamy, flaky)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-53007
**Honey Yogurt Cheesecake** · Dessert · area: Greek
- ingredients: 100g Digestive Biscuit, 85g Almond, 85g Butter, 250ml Greek Yogurt, 750g Mascarpone, 2 Egg, Zest of 1 Lemon, Zest of 1 Orange, 250ml Honey, To serve Fruit Mix
- method (5 steps): Heat oven to 160C/140C fan/gas. Crush the biscuits and most of the almonds inside a plastic food bag using a rolling pin. Mix with the butter, then press into the bottom of a deep, oval, 23cm dish (or something similar in size – a roasting tin, baking dish or cake tin will work). Bake for 10 mins until crisp. Stir or mash together the yogurt and mascarpone, then whisk in the eggs, one at a time. Stir in the lemon and orange zests, then stir in most of the honey, reserving about 3 tbsp. Spread over the biscuit base, cover loosely with foil and cook for 1 hr. Remove the foil and cook for 15 mins…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 110 min)

### mdb-53008
**Stuffed Lamb Tomatoes** · Lamb · area: Greek
- ingredients: 4 large Tomato, Pinch Sugar, 4 tbs Olive Oil, 1 chopped Onion, 2 finely chopped Garlic, 200g Lamb, 1 tbs Cinnamon, 2 tbs chopped Tomato Puree, 50g Rice, 100ml Chicken Stock, 4 tbs Dill, 2 tbs Parsley, 1 tbs Mint
- method (5 steps): Heat oven to 180C/160C fan/gas. Slice the tops off the tomatoes and reserve. Scoop out most of the pulp with a teaspoon, being careful not to break the skin. Finely chop the pulp, and keep any juices. Sprinkle the insides of the tomatoes with a little sugar to take away the acidity, then place them on a baking tray. Heat 2 tbsp olive oil in a large frying pan, add the onion and garlic, then gently cook for about 10 mins until soft but not coloured. Add the lamb, cinnamon and tomato purée, turn up the heat, then fry until the meat is browned. Add the tomato pulp and juice, the rice and the stoc…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'fresh', 'light'] (0.50, keywords/category: comfort, fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 13 ingredients, 90 min)

### mdb-53009
**Lamb and Lemon Souvlaki** · Lamb · area: Greek
- ingredients: 2 cloves Garlic, 2 tsp Salt, 4 tbs Olive Oil, Zest and juice of 1 Lemon, 1 tbs Dill, 750g Lamb Leg, To serve Pita Bread
- method (3 steps): Pound the garlic with sea salt in a pestle and mortar (or use a small food processor), until the garlic forms a paste. Whisk together the oil, lemon juice, zest, dill and garlic. Mix in the lamb and combine well. Cover and marinate for at least 2 hrs or overnight in the fridge. If you’re going to use bamboo skewers, soak them in cold water. If you’ve prepared the lamb the previous day, take it out of the fridge 30 mins before cooking. Thread the meat onto the soaked or metal skewers. Heat the grill to high or have a hot griddle pan or barbecue ready. Cook the skewers for 2-3 mins on each side,…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 175 min)
