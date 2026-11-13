# AI tagging batch 018

Write `tools/seedgen/tags/ai/batch-018.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53126
**Brun Lapskaus (Norwegian Beef Vegetable Stew)** · Beef · area: Norway
- ingredients: 2 tblsp Olive Oil, 2 Lbs Beef, 1 Onion, 3 Cups Beef Stock, 1 small Swede, 1 Celery, 4 Carrot, 4 Parsley, 1 lb Potato, 1/2 Leek, Garnish Parsley
- method (5 steps): ▢ Heat olive oil in a large pot. Cut beef into 1 inch (2.5 cm) cubes and brown in oil. ▢ Dice the onion and add to browning beef. Add the stock and bring to a boil, then lower the heat, cover, and let simmer for about 30 minutes. ▢ Peel and cut the rutabaga and celery root into 1 inch (2.5 cm) cubes. Add to the pot, cover, and continue simmering for another 30 minutes. ▢ Peel and chop the rest of the vegetables into 1 inch (2.5 cm) cubes and add to the pot. Slice the leek into rings. Cover and continue simmering for about 20 minutes. Stir as little as possible. ▢ Top with fresh parsley.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 120 min)

### mdb-53127
**Authentic Norwegian Kransekake** · Dessert · area: Norway
- ingredients: 3 Cups Almond, 4 Egg White, 4 cups Icing Sugar, 2 cups Icing Sugar, 1 Egg White, 1/2 teaspoon Lemon Juice
- method (6 steps): Grind almonds in an almond grinder or food processor. ▢ Mix almonds and powdered sugar together in a large mixing bowl. Add three of the egg whites and knead the dough together with your hands until it comes together in a ball. Wrap in cling film and leave in the fridge for at least an hour, preferably until the next day. ▢ Grease the kransekake forms thoroughly and coat with semolina, flour, or bread crumbs. ▢ Preheat oven to 210°C (410°F) top and bottom heat. Divide the dough into six sections. ▢ Slowly add the remaining egg white to the dough and knead it until you can roll it into long sau…
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 6 ingredients, 90 min, technique: knead)

### mdb-53128
**Kvæfjord Cake “Verdens Beste” (World’s Best Cake)** · Dessert · area: Norway
- ingredients: 2 large Egg Yolk, 2 tblsp Cornflour, 1/4 cup Sugar, 2/3 Cup Double Cream, 3/4 cup Milk, 1 Vanilla Pod, 2/3 Cup Butter, 3/4 cup Sugar, 5 Large Egg Yolk, 1 1/4 cup Plain Flour, 1.5 tsp Baking Powder, 1/2 cup Milk, 7 Egg White, 1 1/2 cups Sugar, Sliced Almond, 1 1/4 cup Double Cream
- method (14 steps): Vanilla custard ▢ Separate the egg yolks and set aside the whites to use in the meringue. ▢ Whisk together the egg yolks, cornstarch and sugar in a bowl. ▢ Heat the cream and milk in a saucepan. Split open the vanilla pod and add the beans to the saucepan. Once the milk begins to bubble pour about half of it into the bowl with the egg mixture, whisking constantly. Then return the saucepan to the heat and pour the egg mixture back into the saucepan with remaining milk, whisking constantly. Once the mixture thickens lower the heat and continue whisking for about 30 seconds. ▢ Pour the custard in…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 14 steps, 16 ingredients, 65 min, technique: whisk together the egg yolks, cornstarch and sugar in a bowl. ▢ heat the cream and milk in a saucepan. split open the vanilla pod and add the beans to the saucepan. once the milk begins to bubble pour about half of it into the bowl with the egg mixture, whisking constantly. then return the saucepan to the heat and pour the egg mixture back into the saucepan with remaining milk, whisking constantly. once the mixture thickens lower the heat and continue whisking for about 30 seconds. ▢ pour the custard into a clean bowl and cover with plastic wrap, placing the plastic directly on the top layer of the custard. chill in the fridge. cake ▢ mix together butter and sugar until light and fluffy. add egg yolks one at a time, setting aside the egg whites for the meringue. add the flour mixed with baking powder. stir in the milk, beating until smooth (you can use an electric mixer if you prefer). ▢ preheat oven to 320°f (160°c). cover a baking sheet with baking paper and spread out the batter into a large, even rectangle. meringue topping ▢ whisk together the egg whites and sugar until you get glossy, stiff peaks. the meringue should hold its form – if it still melts continue whisking. ▢ spread out the meringue on top of the cake batter. use a spatula to form light waves with the meringue. sprinkle almonds on top of the meringue. bake for about 30 minutes, until the meringue and almonds are golden. cream filling ▢ whisk the cream into stiff peaks)

### mdb-53129
**Norwegian Krumkake** · Dessert · area: Norway
- ingredients: 3 Large Egg, 3/4 cup Sugar, 2/3 Cup Butter, 1 teaspoon Cardamom, 1 pinch Ground Nutmeg, 1/2 teaspoon Salt, 1 1/4 cup Plain Flour, Splash Water
- method (7 steps): ▢ Whisk the egg and sugar until the mixture thickens. ▢ Melt the butter and let it cool slightly, then add the butter to the egg mixture. ▢ Mix in spices and then slowly add the flour while stirring to avoid lumps. ▢ Let the batter rest for at least 30 minutes. This improves the texture of the krumkaker. ▢ Spoon about one heaping tablespoon of batter onto iron and bake. If the batter is too thick, add some water to it. ▢ While still hot, shape the krumkake with a wooden krumkake roller or over a cup (if using a cup, make them a bit thicker). The krumkaker harden quickly, so you can just let th…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 7 steps, 8 ingredients, 75 min, technique: prove)

### mdb-53130
**Suksessterte (Norwegian almond “success cake”)** · Dessert · area: Norway
- ingredients: 2 cups Almond, 3 Egg, 1 1/4 cup Sugar, 2 tblsp Plain Flour, 1 teaspoon Baking Powder, 5 Egg Yolk, 1/2 cup Double Cream, 1/3 cup Sugar, 1 teaspoon Vanilla Extract, 100g Butter
- method (7 steps): Almond base ▢ Preheat oven to 345°F (175°C) and grease cake form (I use a 27 cm spring form) – you can line the bottom with baking paper if you like. ▢ Grind almonds in an almond grinder or food processor. I like to keep them a bit coarse. ▢ Gently whisk the eggs and sugar together until combined (no longer). Stir in the ground almonds, flour, and baking powder. ▢ Pour batter into cake form and bake for about 45 – 50 minutes, monitoring to make sure the top doesn't burn. Yellow egg cream ▢ Add egg yolks, heavy cream, sugar, and vanilla to a saucepan. Heat over low/medium heat while stirring co…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 10 ingredients, 80 min, technique: temper)

### mdb-53131
**Fyrstekake – Norwegian Prince Cake** · Dessert · area: Norway
- ingredients: 3/4 cup Sugar, 1 teaspoon Vanilla Extract, 2/3 Cup Butter, 4 Egg Yolk, 2 cups Plain Flour, 1 teaspoon Baking Powder, 1 1/2 cups Almond, 3/4 cup Brown Sugar, 2 tbsp Butter, 2 medium Egg, 2 tablespoons Brandy, 5 drops Almond Extract, 1 Egg
- method (11 steps): Crust ▢ Mix together sugar, vanilla and butter until light and fluffy. Mix in the egg yolks. Add in the flour and baking powder and knead with hands until the dough is smooth. ▢ Pack the dough in plastic wrap and chill in refrigerator for at least 30 minutes. Almond filling ▢ Run the almonds and sugar together in a food processor until the almonds are finely ground (you can decide for yourself how coarse or fine you want them). ▢ Stir in the butter, egg, cognac and/or almond extract (if using). Assembly ▢ Line the bottom of your cake form with baking paper and grease the sides of the form. ▢ P…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'fluffy', 'smooth'] (0.50, keywords: crunchy, fluffy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 11 steps, 13 ingredients, 105 min, technique: knead)

### mdb-53132
**Mazariner – Scandinavian Almond Tartlets** · Dessert · area: Norway
- ingredients: 3 Cups Plain Flour, 1 1/4 cup Icing Sugar, 200g Butter, 1 Egg, 3 Egg, 1 1/4 cup Icing Sugar, 100g Butter, 2 teaspoons Vanilla Extract, 2 tblsp Plain Flour, 2 cups Ground Almond, 1 teaspoon Almond Extract, 2 cups Icing Sugar, 3 tablespoons Double Cream, 1/4 tsp Almond Extract
- method (7 steps): Shells ▢ Combine the flour and powdered sugar in a food processor. Add the butter and pulse until it's evenly distributed. Add the egg and pulse until the dough comes together. ▢ Roll out the dough on a floured surface. Cut the dough in circles with a large mug. Press the circles down into a greased muffin pan. Put the pan of shells in the fridge while you prepare the almond filling. Almond filling ▢ Preheat oven to 355°F (180°C). ▢ Whisk the egg and powdered sugar together until thick and airy. Melt the butter and stir it into the egg mixture. Stir in the vanilla, flour, and almond extract. S…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 14 ingredients, 50 min, technique: pipe)

### mdb-53135
**Milanesa** · Beef · area: Argentina
- ingredients: 4 Beef Cutlet, 2 Beaten Egg, 200g Breadcrumb, 2 tbs chopped Parsley, 2 cloves minced Garlic, To taste Salt, To taste Black Pepper
- method (7 steps): Season the Cutlets: Salt and pepper the cutlets. Bread the Cutlets: Dip each cutlet in egg, then coat with a mixture of breadcrumbs, parsley, and garlic. Fry: Heat oil in a large pan over medium heat. Fry the cutlets until golden and cooked through, about 3-4 minutes per side. Serve: Serve hot with lemon wedges or a side salad. Pro Tips:. For an extra crispy crust, use panko breadcrumbs mixed with finely grated Parmesan cheese. Gently pound the cutlets to an even thickness for uniform cooking.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh', 'indulgent', 'light'] (0.50, keywords/category: fresh, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 7 ingredients, 25 min)

### mdb-53136
**Choripán** · Pork · area: Argentina
- ingredients: 4 Chorizo, 4 Bread, Drizzle Chimichurri Sauce
- method (7 steps): Grill the Chorizos: Cook the chorizos on a grill or pan until fully cooked, about 10-15 minutes. Prepare the Rolls: Slice the rolls and toast them lightly on the grill or in a pan. Assemble: Slice each chorizo lengthwise and place in a roll. Top with a generous amount of chimichurri sauce. Serve: Enjoy immediately while hot. Pro Tips:. Grill the chorizo slowly on medium heat to prevent the skin from bursting and to ensure it cooks evenly throughout. Toast the bread on the grill to absorb some of the chorizo's flavors.
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 3 ingredients, 25 min)

### mdb-53137
**Dulce de Leche** · Dessert · area: Argentina
- ingredients: 1 Litre Milk, 300g Sugar, 1/4 tsp Baking Powder, 1 teaspoon Vanilla Extract
- method (7 steps): Combine Ingredients: In a large, heavy-bottomed pot, mix the milk, sugar, and baking soda. Cook over low heat, stirring constantly to prevent burning. Thicken: Continue to cook, stirring frequently, until the mixture becomes thick and caramel-colored, about 1-2 hours. Flavor: Stir in the vanilla extract. Cool: Let the dulce de leche cool, then transfer to a jar. It will thicken further as it cools. Pro Tips:. Stir continuously and keep the heat low to prevent the milk from burning and sticking to the bottom of the pan. A drop of vanilla extract added at the end of cooking enhances the flavor.
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 4 ingredients, 70 min)

### mdb-53138
**Alfajores** · Dessert · area: Argentina
- ingredients: 300g Plain Flour, 200g Cornflour, 200g Butter, 100g Sugar, 2 Egg Yolk, 1 teaspoon Lemon Zest, Dulce de Leche, Sprinkling Desiccated Coconut
- method (6 steps): Make the Dough: Cream butter and sugar. Add egg yolks and lemon zest. Gradually mix in flour and cornstarch to form a dough. Chill for 1 hour. Bake the Cookies: Roll out the dough, cut into circles, and bake at 180°C (350°F) for 12-15 minutes. Let cool. Assemble: Spread dulce de leche on one cookie, then sandwich with another. Roll the edges in coconut flakes. Pro Tips:. Chill the dough before rolling it out to make it easier to handle and to prevent the cookies from spreading too much while baking. Dip the alfajores in melted chocolate and let them set on a wire rack for an extra decadent tre…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'crunchy'] (0.50, keywords: chewy, creamy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 95 min)

### mdb-53139
**Fainá** · Side · area: Argentina
- ingredients: 200g Chickpea Flour, 600ml Water, 4 tablespoons Olive Oil, To taste Salt, To taste Black Pepper
- method (6 steps): Prepare the Batter: Whisk together chickpea flour, water, salt, and pepper. Let sit for at least 4 hours. Bake: Preheat the oven to 220°C (430°F). Pour olive oil into a round baking dish and heat in the oven. Pour in the batter and bake for 25-30 minutes, until golden. Serve: Slice and serve hot, optionally with black pepper on top. Pro Tips:. Let the batter rest for at least 2 hours, or overnight in the refrigerator, to ensure the chickpea flour fully hydrates and the flavors meld. For a crispy edge, preheat the baking pan with oil in the oven before adding the batter.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 5 ingredients, 400 min)

### mdb-53140
**Matambre a la Pizza** · Beef · area: Argentina
- ingredients: 1 kg Flank Steak, 200g Tomato Sauce, 200g Mozzarella, 1 tbsp Oregano, 100g Green Olive, To taste Salt, To taste Black Pepper
- method (7 steps): Prepare the Steak: Season the steak with salt and pepper. Grill one side until half-cooked. Add Toppings: Spread tomato sauce over the cooked side, then add cheese, oregano, and olives. Finish Grilling: Grill until the cheese is melted and bubbly. Serve: Slice and serve hot. Pro Tips:. Tenderize the matambre by scoring it lightly on both sides. This helps it cook more evenly and absorb the flavors. Precook the matambre on the grill before adding the toppings to ensure it's fully cooked without burning the cheese.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'easy' (0.55, 7 steps, 7 ingredients, 50 min)

### mdb-53141
**Carbonada Criolla** · Beef · area: Argentina
- ingredients: 500g Beef, 1 chopped Onion, 2 chopped Carrot, 2 chopped Potato, 1 small Pumpkin, 100g Dried Apricot, 2 Litres Beef Stock, To taste Salt, To taste Black Pepper
- method (7 steps): Brown the Beef: In a large pot, brown the beef cubes. Remove and set aside. Sauté Vegetables: In the same pot, cook the onion until translucent. Add carrots, potatoes, and pumpkin, cooking for a few minutes. Simmer: Return the beef to the pot. Add broth and dried apricots. Season with salt and pepper. Simmer for 1-2 hours, until the beef is tender. Serve: Enjoy hot, with a crusty piece of bread. Pro Tips:. Brown the beef in batches to ensure it gets a good sear, which adds depth to the stew's flavor. Adding the fruits towards the end of cooking preserves their texture and adds a subtle sweetne…
- `textures` rule: ['brothy', 'saucy', 'tender'] (0.50, keywords: brothy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'light'] (0.50, keywords/category: comfort, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 9 ingredients, 80 min)

### mdb-53142
**Spiced tortilla** · Vegetarian · area: Spanish
- ingredients: 1 tbsp Vegetable Oil, 1 Onion, 1 Red Chilli, 2 teaspoon Curry Powder, 300g Cherry Tomato, 500g Potato, Bunch Coriander, 8 Egg
- method (2 steps): Heat the oil in a large frying pan. Fry the onion and half the chilli for 5 mins until softened. Tip in the spices, fry for 1 min more, then add the cherry tomatoes, potatoes and coriander stalks to the pan. Season the eggs well, pour over the top of the veg and leave to cook gently for 8-10 mins until almost set. Heat the grill and flash the tortilla underneath for 1-2 mins until the top is set. Scatter the coriander leaves and remaining chilli over the top, slice into wedges and serve with a green salad.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 35 min)

### mdb-53143
**Easy Spanish chicken** · Chicken · area: Spanish
- ingredients: 2 tbsp Olive Oil, 1 Onion, 150g Chorizo, 1 Red Pepper, 1 Yellow Pepper, 1 teaspoon Smoked Paprika, 4 cloves Garlic, 400g Chopped Tomatoes, 150g Green Olive, 400g Butter Bean, 8 Chicken Thigh, 1 Handfull Parsley
- method (3 steps): Heat the oven to 200C/180C fan/gas. Heat the olive oil in a large ovenproof frying pan over a medium heat and fry the onion, chorizo and peppers along with a pinch of salt and pepper for 15 mins until the veg has softened and the chorizo has released its oils. Add the paprika and garlic, and cook for another few minutes until fragrant. Tip in the chopped tomatoes, olives and butter beans, stir to combine and season. Nestle in the chicken thighs and season well. Transfer to the oven and bake for 40 mins until the chicken skin is crisp and the meat cooked through and tender. Scatter with the par…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 80 min, technique: proof)

### mdb-53144
**Gambas al ajillo** · Seafood · area: Spanish
- ingredients: 12 Prawn, 3 Garlic, 100 ml Olive Oil, 3 Cayenne Pepper, 1 tablespoon chopped Parsley
- method (3 steps): Peel the prawns, leaving the tails intact, and, using a cocktail stick, remove the digestive tracts. Or, if you are using a frying pan rather than a terracotta pot, you can cook the prawns in their shells. Season with a little sea salt. Put the garlic, olive oil and chillies in a flameproof terracotta pot or frying pan and set over a high heat. When the garlic starts to turn golden, add the prawns and cook for 1-2 mins on each side until just pink. Sprinkle over the chopped parsley and some freshly cracked black pepper, and serve immediately. If using a terracotta pot, you can take that straig…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 5 ingredients, 20 min, technique: proof)

### mdb-53145
**Jamon & wild garlic croquetas** · Pork · area: Spanish
- ingredients: 150g Wild Garlic Leaf, 350g Milk, 45g Olive Oil, 65g Plain Flour, 35g Manchego, 80g Jamon Iberico, 1 Egg, 75g Breadcrumb, 1 L Vegetable Oil
- method (7 steps): Wash the wild garlic leaves well in a colander, then pour over boiling water from the kettle until just wilted. Immediately rinse under cold running water, then squeeze out the excess water and finely chop. Warm the milk in a pan over a low heat until just steaming. Heat the oil or butter in a second pan and, once warm or melted, stir in the flour for a couple of minutes until it starts to brown a little. Gradually add the warm milk, a little at a time, until you have a thick, silky sauce. Bubble for a minute or two, stirring to make sure all the flour has cooked out. Season. Add the manchego,…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 9 ingredients, 1560 min, technique: piping)

### mdb-53146
**Locro** · Miscellaneous · area: Argentina
- ingredients: 500g Dried White Corn, 200g Dried White Bean, 300g Pumpkin, 200g Potato, 300g Beef, 200g Pork, 1 Chorizo, 1 chopped Onion, 1 teaspoon Paprika, To taste Salt, To taste Black Pepper
- method (7 steps): Soak: Soak corn and beans overnight in water. Cook Meats: In a large pot, brown the beef and pork. Add onions and spices, cooking until translucent. Simmer the Stew: Add soaked corn and beans, pumpkin, potato, and enough water to cover. Simmer for 2-3 hours, until thick. Serve: Enjoy hot, with bread on the side. Pro Tips:. Toasting the corn slightly before adding it to the stew enhances its flavor. Add a spoonful of paprika or a dash of cumin for an extra layer of warmth and complexity.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 11 ingredients, 620 min)

### mdb-53147
**Arroz con gambas y calamar** · Seafood · area: Spanish
- ingredients: 24 Prawn, 2 tbsp Olive Oil, 1 small Onion, 1 Bay Leaf, 1 pinch Saffron, 450g Paella Rice, 2 teaspoons Tomato Puree, 200ml White Wine, 650ml Seafood Stock, 3 Medium Squid
- method (3 steps): Peel and devein most of the prawns (a fishmonger should be able to do this for you), keeping a few whole for decoration, if you like. Heat the olive oil in a large frying pan or shallow flameproof casserole over a medium-low heat and fry the onion for 5 mins until softened. Add the bay leaf, saffron, rice and tomato purée, and cook for 1-2 mins more, stirring. Pour in the wine and bubble for 1-2 mins, then pour in the seafood stock and 150ml water. Cook for 5 mins, then add the squid, season well and stir to combine. Bring to the boil, then cover and reduce the heat to a gentle simmer. Cook fo…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 55 min, technique: proof)
