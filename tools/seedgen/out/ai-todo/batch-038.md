# AI tagging batch 038

Write `tools/seedgen/tags/ai/batch-038.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53540
**Pollo en Salsa** · Chicken · area: none
- ingredients: 4 Chicken Thigh, 1 tsp Oregano, 1 tsp Ground Cumin, 1 tsp Salt, 1 tsp Black Pepper, 1 1/2 tsp Achiote Paste, 4 Cloves Crushed Garlic, 1 medium Onion, 1 large Tomato, 1/2 Red Pepper, 2 cups Chicken Stock
- method (2 steps): Chopped pepper, onion and tomato and set aside. Turn on Instant Pot in sauteed setting for 8 minutes. Add a little bit of olive oil and add, onion, garlic, tomato, bell pepper, cumin, oregano salt and pepper and sauteed for 4 minutes. ​ Add the chicken and cook for 2 minutes on each side often, mixing often. Add the chicken stock , cover and set the pressure cooker on high for 20 minutes. When done release the pressure and if need it, add a little bit more salt. I like to serve it with some of the juice over rice and beans.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 11 ingredients, 60 min)

### mdb-53541
**Gallo pinto** · Vegetarian · area: none
- ingredients: 2/3 Cup Black Bean, 1 1/4 cup Rice, 2 tablespoons Onion, 2 tablespoons Black Pepper, 2 tablespoons Coriander, 1/2 tsp Salsa Lizano, 1/2 tsp Salt, 1/2 tsp Ground Cumin, 1/4 tsp Black Pepper
- method (4 steps): Heat up a pan over medium high heat, add olive oil and let it get hot. Add onions, peppers, cilantro, garlic, cumin, salt and pepper, cook for 3 to 5 min until onion is translucent. Mix in the beans, stir and reduce heat to medium, add the Lizano sauce, stir and cook for 5 more minutes. Add the rice, stir and cooked for a few more minutes, to incorporate all the flavors in the rice. The time to cook it I will depend of how you like your gallo pinto, some people like it a little wet and some other like it a little toasted or dry. I prefer it not too dry, so I cook it for about 5 to 7 min.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 30 min)

### mdb-53542
**Chorreadas** · Dessert · area: none
- ingredients: 2 cups Sweetcorn, 1/3 cup Plain Flour, 1/4 cup Sugar, 1/3 cup Milk, 2 Egg, 2 tablespoons Butter, 1 tsp Vanilla Extract, 1/4 tsp Cinnamon, Pinch Salt
- method (3 steps): Using a food processor or a blender, combine all the ingredients, don't overdo it, the mixture should be crumby. ​ Heat a lightly oiled pan over medium-high heat. Pour 1/4 cup of the batter onto the pan. Cook until lightly brown on each side, just like making pancakes ;) Traditionally you serve it with a spoon of sour cream on top. I just prefer to eat it plain.
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'fluffy'] (0.50, keywords: creamy, crispy, fluffy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 50 min)

### mdb-53543
**Dulce de Leche Cheesecake with a Maria Cookie Crust.** · Dessert · area: none
- ingredients: 7 oz Maria Cooky, 1/2 cup Butter, 16 oz Cream Cheese, 16 oz Cream Cheese, 1 Can Condensed Milk, 4 Egg, 1 ½ tbsp Vanilla Extract, Garnish Dulce de Leche
- method (15 steps): Heat oven to 325ºF. Place cookies in bowl of food processor. Pulse 30 seconds, or until finely ground. (Or, crush them by hand by placing cookies in zip-top bag and using the bottom of a heavy skillet, pound cookies until finely crushed); transfer cookie crumbs to bowl. Add softened butter, stirring until combined. Transfer cookie mixture to 9” spring form pan. Using your fingers, press cookie crumbs evenly onto bottom and sides of pan. Bake until firm and fragrant, about 10 minutes. Allow to cool. Set electric mixer on medium speed, beat cream cheese until fluffy, about 3 minutes. Add condens…
- `cuisine` rule: none
- `textures` rule: ['chewy', 'creamy', 'flaky'] (0.50, keywords: chewy, creamy, flaky)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 15 steps, 8 ingredients, 385 min)

### mdb-53544
**CAFE LA LLAVE ESPRESSO ICE CREAM** · Dessert · area: none
- ingredients: 2 cups Double Cream, 1 cup Milk, 1/4 tsp Salt, 1/2 cup Sugar, 5 Egg Yolk, 1/2 tsp Vanilla Extract, 3 shots Cafe la Llave
- method (10 steps): A note about the espresso: I like using the fine ground espresso brick and making the coffee in a regular moka pot, but you can certainly also use the Nespresso style capsules if you have that type of espresso maker. FULL DISCLOSURE: I personally prefer the decaf espresso, which the Cafe La Llave brand makes to perfection. The ice cream flavor holds either way. In a medium saucepan, heat the cream, milk, sugar and salt over medium heat; whisking to dissolve the sugar (this should take about 4 to 5 minutes). In a separate bowl, whisk the egg yolks. Gradually pour about 1 cup of the hot milk mix…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 7 ingredients, 20 min, technique: temper)

### mdb-53545
**Ropa Veija** · Beef · area: none
- ingredients: 2 Lbs Flank Steak, 3 tsp Salt, 4 tablespoons Vegetable Oil, 1 Red Pepper, 1 Yellow Pepper, 1 Onion, 6 cloves Garlic, 2 tablespoons Tomato Puree, 1 tablespoon Smoked Paprika, 2 tsp Ground Cumin, 2 tsp Dried Oregano, 1/2 cup White Wine, 1 Can Chopped Tomatoes, 2 Bay Leaf, 1 cup Pimento Stuffed Olive, To serve Rice, To serve Black Bean, 1/4 cup Coriander
- method (7 steps): Cut steak into 4 rectangular pieces. Pat dry with paper towels; season all over with 1 1/2 teaspoons salt. In a large pot over medium-high heat, heat 2 tablespoons oil. Working in batches, cook steak until browned on both sides, 5 to 6 minutes. Transfer to a plate. In same pot over medium heat, heat remaining 2 tablespoons oil. Cook bell peppers, onion, and 1 1/2 teaspoons salt, stirring occasionally, until slightly softened, 4 to 5 minutes. Add garlic, tomato paste, paprika, cumin, and oregano and cook, stirring occasionally, until vegetables are softened and spices are aromatic, 1 to 2 minut…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 18 ingredients, 180 min)

### mdb-53546
**Black Bean soup** · Starter · area: none
- ingredients: 2 tablespoons Olive Oil, 1 medium Red Onion, 1 Jalapeno, 2 cloves minced Garlic, 1 tablespoon Tomato Puree, Pinch Salt, Pinch Black Pepper, 1/2 tsp Ground Cumin, 1 tsp Chilli Powder, 3 cans Black Bean, 3 Cups Chicken Stock, 1 Bay Leaf, Garnish Sour Cream, Garnish Avocado, Garnish Coriander, To serve Lime
- method (4 steps): In a large pot over medium heat, heat oil. Add onion and cook until soft and translucent, about 5 minutes. Add jalapeños and garlic and cook until fragrant, about 2 minutes. Add tomato paste, stir to coat vegetables, and cook about a minute more. Season with salt, pepper, cumin, and chili powder and stir to coat. Add black beans and broth. Stir soup, add bay leaf, and bring to a boil. Immediately reduce to a simmer and let simmer until slightly reduced and thickened, 15 to 20 minutes. (If a thinner soup is desired, add more broth as needed.) Remove bay leaf and let cool slightly. Using an imme…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 16 ingredients, 55 min)

### mdb-53547
**Cuban Sandwich** · Pork · area: none
- ingredients: 1 lb Pork Chop, Pinch Salt, 2 tablespoons Vegetable Oil, Juice/zest of one Orange, Juice/zest of one Lime, 2 tsp Dried Oregano, 1 tsp Black Pepper, 1 tsp Garlic Powder, 2 tablespoons Dijon Mustard, 2 tablespoons Mayonnaise, 8 oz Cuban Bread, 1 tablespoon Butter, 4 oz Swiss Cheese, 8 oz Ham, 2 Dill Pickle
- method (8 steps): Place pork chops in a 3-qt. glass baking dish. Using a fork, poke holes into pork all over; season all over with 1 tsp. salt. Drizzle with oil and toss to coat. In a small bowl, combine orange zest and juice, lime zest and juice, oregano, pepper, garlic powder, cumin, and onion powder. Add half of marinade to pork and let rest 10 to 15 minutes. Meanwhile, arrange a rack in center of oven; preheat to 425°. Add mustard and mayonnaise to remaining marinade and stir until smooth. Transfer pork to oven and roast until an instant-read thermometer inserted into thickest part registers 140°, 15 to 20 …
- `cuisine` rule: 'Cuban' (0.60, title mentions 'Cuban')
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 15 ingredients, 65 min, technique: wrap each)

### mdb-53548
**Baked Yuca Fries** · Side · area: none
- ingredients: 2 large Yuca, 2 tablespoons Olive Oil, 1 tsp Chilli Powder, Pinch Salt, Pinch Black Pepper, 1 large Avocado, 1/4 cup Sour Cream, Juice of 1 Lime, 1/4 cup Coriander
- method (6 steps): Preheat oven to 450°. Bring a large pot of water to a boil. Trim ends of yuca and cut each one in half, widthwise. Stand them on their ends and use a sharp knife to cut the waxy peel off. Cut each piece in half lengthwise and then cut in half lengthwise one more time to create 16 pieces total. Trim the fibrous center out of each piece. Place cut yuca into boiling water and let boil until fork tender, 8 to 10 minutes. Using a slotted spoon, remove from pot and place on a paper towel lined cutting board. Pat dry with another paper towel. Place dried yuca into a large bowl and toss with oil. Seas…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 9 ingredients, 60 min)

### mdb-53549
**Chicken Salad With Mushrooms and Bacon** · Chicken · area: none
- ingredients: 300g Chicken Breast, 1 Shallot, 3 tablespoons Mayonnaise, 4 tablespoons Creme Fraiche, 3 tsp Dijon Mustard, 1 tablespoon Cider Vinegar, 100g Bacon, 250g Mushroom, Sprigs of fresh Parsley, To taste Salt, To taste Black Pepper
- method (6 steps): Place chicken breast in a saucepan and cover with water. Bring to a boil, add 1 tsp salt and simmer for approximately 15 minutes. Allow chicken to cool and then shred meat with two forks. Finely chop shallot/red onion. Stir mayonnaise, crème fraîche, Dijon mustard and apple cider vinegar to combine. Season with salt, pepper and extra Dijon mustard to taste. Combine with onion and chicken. Fry bacon until crisp and transfer to plate lined with paper towels. Rinse mushrooms, slice and fry in the same pan as bacon until golden (approximately 5 minutes). Season with a bit of salt and pepper. Arran…
- `cuisine` rule: none
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh', 'indulgent', 'light'] (0.50, keywords/category: fresh, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 11 ingredients, 50 min)

### mdb-53550
**Strawberry tart** · Dessert · area: none
- ingredients: 250g Marzipan, 80g Sugar, 7 oz Butter, 4 Egg, 50g Plain Flour, 100g Dark Chocolate, 3 tsp Vanilla Sugar, 3 Egg Yolk, 50g Sugar, 2 tablespoons Cornflour, 3/4 cup Milk, 1/2 cup Double Cream, 500g Strawberries, Handful Mint
- method (9 steps): Tart shell. Heat oven to 175°C / 347 °F Grate the marzipan and mix thoroughly with the sugar. Whip the mixture with butter until fluffy. Whip the eggs into the mixture and then folk the flour into the dough. Line an approximately 24 cm springform pan with baking paper and grease with butter. Then roll out the dough and transfer to the pan. Bake in the middle of the oven for approximately 25 minutes. Prepare the vanilla custard while the dough bakes. Finely chop the chocolate and sprinkle over the shell after baking. Spread out the chocolate with a spatula as it melts. Allow the shell to cool t…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy'] (0.50, keywords: creamy, fluffy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 14 ingredients, 60 min)

### mdb-53551
**Old-fashioned Danish Apple Trifle** · Dessert · area: none
- ingredients: 800g Cooking Apple, 1/4 cup Water, 1 tsp Vanilla Powder, 1 tablespoon Lemon Juice, 4 tablespoons Sugar, 50g Butter, 100g Breadcrumb, 50g Sugar, 3/4 cup Double Cream
- method (12 steps): Peel and cut the apples into cubes. Discard the cores. Transfer apple cubes to a saucepan with water, vanilla and lemon juice. Bring apples to a boil, cover and reduce heat to medium-low. Add the sugar to taste after the apples release their juices. The amount of sugar depends on the tartness of the apples and your preferred level of sweetness. Remember that the breadcrumb mixture and whipped cream are also sweet, so it is okay if the apple sauce is still a bit tart. Cook the apples for about 15 minutes until you have a coarse apple sauce. If you prefer, cook the apples longer for a finer cons…
- `cuisine` rule: 'Danish' (0.60, title mentions 'Danish')
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 12 steps, 9 ingredients, 40 min)

### mdb-53552
**Hveder - Danish Wheat Buns** · Side · area: none
- ingredients: 1 cup Milk, 25g Yeast, 2 Egg, 40g Sugar, 1 tsp Salt, 2 tsp Cardamom, 500g Plain Flour, 100g Butter, For brushing Egg
- method (7 steps): Heat milk in a saucepan until warm to the touch (25°C / 77℉). Transfer milk to a mixing bowl and dissolve the yeast in the milk. Add the remaining ingredients except for the butter and knead thoroughly. Use a kitchen mixer to knead the dough if you have one. Cut the butter into cubes and add to the dough. Knead for 5 to 10 minutes until the dough is elastic and smooth. Cover the dough and let rise in a warm place for 45 minutes. Transfer the dough to a counter sprinkled with flour and divide into 10-12 pieces of equal size. Roll each piece into a round bun and arrange the buns close to each ot…
- `cuisine` rule: 'Danish' (0.60, title mentions 'Danish')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 9 ingredients, 150 min, technique: knead, proof)

### mdb-53553
**Frikadeller - Danish Meatballs** · Pork · area: none
- ingredients: 1 large Onion, 1 clove Garlic, 500g Pork Mince, 1 tablespoon Plain Flour, 1 tablespoon Oats, 1/2 cup Milk, 1 Egg, 1 tablespoon Salt, 1 tsp Black Pepper, 2 tablespoons Butter
- method (5 steps): Finely chop onion and garlic. Stir salt into minced meat. Add the dry ingredients, then onion and garlic, then the egg. and lastly the milk. Stir the meat mixture until it is firm. Refrigerate for at least 30 minutes. You can also make the mixture one day in advance and refrigerate. Heat a pan over medium heat. Add butter to the pan and use a spoon to form frikadeller (meatballs) in your preferred size. We recommend using about 2 tablespoons of mixture per frikadelle. Fry until they develop a nice browned crust on both sides and are cooked all the way through. Serve hot with a classic potato s…
- `cuisine` rule: 'Danish' (0.60, title mentions 'Danish')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Pork guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 85 min)

### mdb-53554
**Open-faced Sandwich With Potato** · Pork · area: none
- ingredients: 500g New Potato, 4 slices Bacon, 4 tablespoons Mayonnaise, Handful Chive, 8 slices Rye Bread, 2 Red Onion, 1/2 cup Plain Flour, 1 1/4 cup Vegetable Oil, Pinch Salt
- method (9 steps): Scrub the potatoes clean and place in a small saucepan with water and 1 tablespoon of salt. Bring to a boil and simmer the potatoes for about 10 minutes. Turn off the heat and let the potatoes stand in the water for 5 minutes. Drain the potatoes and allow to cool slightly. Remember that potatoes come in various sizes, so the cooking time may vary – if they do not easily glide off of a fork when speared and lifted out of the water, they are not done yet. Fry bacon slices and transfer to a dish lined with paper towels. Peel the red onion and slice in thin rings. Transfer the flour to a bowl and …
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 9 steps, 9 ingredients, 50 min)

### mdb-53555
**Classic Potato Salad** · Side · area: none
- ingredients: 600g New Potato, 150g Asparagus, Bunch Chive, 1 Red Onion, 8 Radish, 1/2 cup Creme Fraiche, 1/2 cup Mayonnaise, 2 tsp Dijon Mustard, 1 tsp Sugar, 1 tablespoon Cider Vinegar, Pinch Salt, Pinch Black Pepper
- method (7 steps): Boil potatoes in lightly salted water for 10 to 12 minutes. Drain water when a potato speared with a fork and lifted out of the water easily glides off the fork and falls back into the pot. Let potatoes stand and cool. Break off and discard the stringy ends of the asparagus spears, then chop into small pieces. You can pour boiling water over the chopped asparagus and let it soak for 2 minutes if you prefer a less raw taste. Finely chop chives, red onion and radish. Stir the dressing ingredients together and season with salt and pepper. Reserve some of the chives for garnish and combine the res…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 12 ingredients, 45 min)

### mdb-53556
**Danish Rye Bread** · Side · area: none
- ingredients: 200g Rye Grain, 3/4 cup Water, 3/4 cup Dark Beer, 3/4 cup Buttermilk, 10g Yeast, 1 tsp Salt, 130g Seed, 3/4 cup Plain Flour, 2 1/2 cups Rye Flour
- method (8 steps): Combine rye grain and water in a saucepan and bring to a boil. Cover and simmer for 2 to 3 minutes. Transfer the boiled rye grain to a mixing bowl and combine with beer, buttermilk and salt. Dissolve the fresh yeast in this mixture and then add the seeds. Add all-purpose flour and rye flour, and knead for about 10 minutes. You can also use a kitchen mixer to knead the dough. Transfer the dough to an oiled loaf pan (2.5 l) and smooth out with a spatula. Poke holes in the surface with a fork and cover loaf pan with plastic wrap. Let the dough rise for 1½ hours at room temperature, or for 24 hour…
- `cuisine` rule: 'Danish' (0.60, title mentions 'Danish')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 9 ingredients, 1610 min, technique: knead)

### mdb-53557
**Extra crispy chicken wings** · Chicken · area: none
- ingredients: 2 Lbs Chicken Wing, To taste Salt, 1 tablespoon Black Pepper, 1 tablespoon Garlic Powder, 1 tsp Turmeric, For frying Vegetable Oil, 1 1/2 cup Cassava
- method (6 steps): Wash chicken and pat dry Place in a large bowl Season with garlic, salt, pepper and turmeric (you can expand your seasoning options if you'd like. Marinate for at least an hour Pour some tapioca flour on a plate Coat the wings with the cassava flour and place them on a rack or plater to set. Leave them for at least 30minutes to an hour. Heat the oil in the saucepan until it’s hot. Place wings in pan on medium heat, until light brown. Drain on a paper towel, and let the wings rest for at least 10 minutes, then return the wings to the hot pan on high heat and fry until golden brown. Enjoy!
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crispy'] (0.50, keywords: chewy, crispy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 7 ingredients, 145 min)

### mdb-53558
**Stuffed plantain cups** · Side · area: none
- ingredients: 3 Plantain, 3 Cups Vegetable Oil
- method (2 steps): Peel and wash plantains Pat them dry Cut them into one and a half inch slices Heat oil to deep fry plantains Toss in plantains into hot oil so they are submerged Fry them for about 7 minutes Place them on paper towel for about five minutes. You don't want them to be too dry Using your citrus squeezer, press the plantain slices into cups Place on paper towel or tray Then place cups in the deep fryer or sauce pan with enough oil to submerge them Remove when golden brown Stuff with your favorite filling Enjoy!
- `cuisine` rule: none
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 2 ingredients, 25 min, technique: deep fr)

### mdb-53559
**Baked brie with sorrel jam** · Starter · area: none
- ingredients: 1 cup Dried Sorrel, 2 cups Brown Sugar, 1 tsp Ground Ginger, 1/4 cup Cinnamon, 1 Vanilla Pod, Zest of 1 Orange, Boiled Water, 1 beaten Egg, 1 Slice Puff Pastry, 2 Lbs Brie, To serve Sorrel Jam, 1 tsp Water
- method (15 steps): Sorrel jam instructions Combine sugar, sorrel, lemon zest, water in a medium sized pot. Bring to a boil as petal becomes soft Reduce heat, and cook until thickened. Let it rest before using on brie Baked brie instructions You can slice the brie in half to create a sandwich-like effect. Or you can leave the brie wheel intact and just trim the top rind of the wheel. Add a generous portion of jam to the top of the wheel, or one side of the sandwich Roll dough out with a rolling pin on a floured surface Trim excess dough. You can also use it to decorate . Wrap the pastry up around the sides and ov…
- `cuisine` rule: none
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Starter guess)
- `difficulty` rule: 'medium' (0.55, 15 steps, 12 ingredients, 45 min)
