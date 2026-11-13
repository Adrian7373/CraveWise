# AI tagging batch 009

Write `tools/seedgen/tags/ai/batch-009.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52916
**Pear Tarte Tatin** · Dessert · area: France
- ingredients: 8 Pear, 100g Sugar, 100g Butter, 2 Star Anise, 3 Pods Cardamom, 1 large Cinnamon, 2 tbs Brandy, 500g Puff Pastry
- method (8 steps): Core the pears, then peel as neatly as possible and halve. If you like, they can be prepared up to a day ahead and kept in the fridge, uncovered, so that they dry out. Tip the sugar, butter, star anise, cardamom and cinnamon into an ovenproof frying pan, about 20cm wide, and place over a high heat until bubbling. Shake the pan and stir the buttery sauce until it separates and the sugar caramelises to a toffee colour. Lay the pears in the pan, then cook in the sauce for 10-12 mins, tossing occasionally, until completely caramelised. Don’t worry about them burning – they won’t – but you want to …
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky', 'saucy'] (0.50, keywords: flaky, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 8 ingredients, 75 min, technique: caramelis, flamb, proof)

### mdb-52917
**White chocolate creme brulee** · Dessert · area: France
- ingredients: 568ml Double Cream, 100g White Chocolate Chip, Pod of Vanilla Extract, 6 Egg Yolk, 2 tbs Sugar, Top Sugar
- method (3 steps): Heat the cream, chocolate and vanilla pod in a pan until the chocolate has melted. Take off the heat and allow to infuse for 10 mins, scraping the pod seeds into the cream. If using the vanilla extract, add straight away. Heat oven to 160C/fan 140C/gas 3. Beat yolks and sugar until pale. stir in the chocolate cream. Strain into a jug and pour into ramekins. Place in a deep roasting tray and pour boiling water halfway up the sides. Bake for 15-20 mins until just set with a wobbly centre. Chill in the fridge for at least 4 hrs. To serve, sprinkle some sugar on top of the brûlées and caramelise w…
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 6 ingredients, 280 min, technique: caramelis)

### mdb-52918
**Fish Stew with Rouille** · Seafood · area: France
- ingredients: 6 large Prawn, 3 tbs Olive Oil, 150ml White Wine, 200ml Fish Stock, 1 small finely diced Fennel, 1 small finely diced Onion, 3 cloves Chopped Garlic, 1 large Potato, 1 Orange, 1 Star Anise, 1 Bay Leaf, 1 1/2 tsp Harissa Spice, 2 tbs Tomato Puree, 400g Chopped Tomatoes, Handful Mussel, 200g White Fish, 2 Thyme, to serve Bread
- method (7 steps): Twist the heads from the prawns, then peel away the legs and shells, but leave the tails intact. Devein each prawn. Fry the shells in 1 tbsp oil for 5 mins, until dark pink and golden in patches. Add the wine, boil down by two thirds, then pour in the stock. Strain into a jug, discarding the shells. Heat the rest of the oil in a deep frying pan or casserole. Add the fennel, onion and garlic, season, then cover and gently cook for 10 mins until softened. Meanwhile, peel the potato and cut into 2cm-ish chunks. Put into a pan of cold water, bring to the boil and cook for 5 mins until almost tende…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 18 ingredients, 85 min, technique: deep fr)

### mdb-52919
**Fennel Dauphinoise** · Side · area: France
- ingredients: 225g Potato, 1 small Fennel, 1 clove finely chopped Garlic, 75 ml Milk, 100ml Double Cream, For Greasing Butter, to serve Parmesan
- method (3 steps): Heat oven to 180C/160C fan/gas. Put potatoes, fennel, and garlic in a medium non-stick pan. Pour in milk and double cream, season well and simmer gently, covered, for 10 mins, stirring halfway through, until potatoes are just tender. Divide the mixture between 2 small (about 150ml) buttered ramekins and scatter with Parmesan. Bake for 40 mins until the potatoes are golden and tender when pierced with a knife. Snip the reserved fennel fronds over before serving.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 65 min)

### mdb-52920
**Chicken Marengo** · Chicken · area: France
- ingredients: 1 tbs Olive Oil, 300g Mushroom, 4 Chicken Leg, 500g Passata, 1 Chicken Stock, 100g Black Olive, Chopped Parsley
- method (2 steps): Heat the oil in a large flameproof casserole dish and stir-fry the mushrooms until they start to soften. Add the chicken legs and cook briefly on each side to colour them a little. Pour in the passata, crumble in the stock cube and stir in the olives. Season with black pepper – you shouldn’t need salt. Cover and simmer for 40 mins until the chicken is tender. Sprinkle with parsley and serve with pasta and a salad, or mash and green veg, if you like.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 60 min, technique: proof)

### mdb-52921
**Provençal Omelette Cake** · Vegetarian · area: France
- ingredients: 10 Egg, 1 tbs Olive Oil, 2 finely chopped Courgette, 3 finely chopped Spring Onion, 4 Red Pepper, 1 clove peeled crushed Garlic, 1 Red Chilli, 300g Cream Cheese, 6 tblsp Milk, 4 tbs Chive, 2 tbs Basil, to serve Rocket, to serve Parmesan
- method (8 steps): Break the eggs into two bowls, five in each. Whisk lightly and season with salt and pepper. Heat the oil in a pan, add the courgettes and spring onions, then fry gently for about 10 mins until softened. Cool, then stir into one bowl of eggs with a little salt and pepper. Add the roasted peppers to the other bowl of eggs with the garlic, chilli, salt and pepper. Heat a little oil in a 20-23cm frying pan, preferably non-stick. Pour the eggs with courgette into a measuring jug, then pourabout one-third of the mixture into the pan, swirling it to cover the base of the pan. Cook until the egg is se…
- `flavor.sweet` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 13 ingredients, 1475 min)

### mdb-52922
**Prawn & Fennel Bisque** · Side · area: France
- ingredients: 450g Prawn, 4 tbs Olive Oil, 1 large Onion, 1 large Fennel, 2 chopped Carrot, 150ml White Wine, 1 tbs Brandy, 400g Chopped Tomatoes, 1L Fish Stock, 2 pinches Paprika, 150ml Double Cream, 8 Prawn
- method (3 steps): Shell the prawns, then fry the shells in the oil in a large pan for about 5 mins. Add the onion, fennel and carrots and cook for about 10 mins until the veg start to soften. Pour in the wine and brandy, bubble hard for about 1 min to drive off the alcohol, then add the tomatoes, stock and paprika. Cover and simmer for 30 mins. Meanwhile, chop the prawns. Blitz the soup as finely as you can with a stick blender or food processor, then press through a sieve into a bowl. Spend a bit of time really working the mixture through the sieve as this will give the soup its velvety texture. Tip back into …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy', 'smooth'] (0.50, keywords: brothy, creamy, smooth)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 85 min)

### mdb-52923
**Canadian Butter Tarts** · Dessert · area: Canadian
- ingredients: 375g Shortcrust Pastry, 2 large Egg, 175g Muscovado Sugar, 100g Raisin, 1 tsp Vanilla Extract, 50g Butter, 4 tsp Single Cream, 50g Walnut
- method (5 steps): Preheat the oven to fan 170C/ conventional 190C/gas. Roll out the pastry on a lightly floured surface so it’s slightly thinner than straight from the pack. Then cut out 18-20 rounds with a 7.5cm fluted cutter, re-rolling the trimmings. Use the rounds to line two deep 12-hole tart tins (not muffin tins). If you only have a regular-sized, 12-hole tart tin you will be able to make a few more slightly shallower tarts. Beat the eggs in a large bowl and combine with the rest of the ingredients except the walnuts. Tip this mixture into a pan and stir continuously for 3-4 minutes until the butter melt…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'flaky'] (0.50, keywords: creamy, crunchy, flaky)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 8 ingredients, 40 min, technique: roll out the pastry)

### mdb-52924
**Nanaimo Bars** · Dessert · area: Canadian
- ingredients: 125g Custard, 50g Sugar, 5 tbs Cocoa Powder, 1 beaten Egg, 200g shredded Digestive Biscuit, 100g Desiccated Coconut, 50g Almond, 100g Butter, 4 tbs Double Cream, 3 tbs Custard Powder, 250g Icing Sugar, 150g Dark Chocolate, 50g Butter
- method (3 steps): Start by making the biscuit base. In a bowl, over a pan of simmering water, melt the butter with the sugar and cocoa powder, stirring occasionally until smooth. Whisk in the egg for 2 to 3 mins until the mixture has thickened. Remove from heat and mix in the biscuit crumbs, coconut and almonds if using, then press into the base of a lined 20cm square tin. Chill for 10 mins. For the middle layer, make the custard icing; whisk together the butter, cream and custard powder until light and fluffy, then gradually add the icing sugar until fully incorporated. Spread over the bottom layer and chill i…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'fluffy'] (0.50, keywords: creamy, crunchy, fluffy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 13 ingredients, 170 min)

### mdb-52925
**Split Pea Soup** · Side · area: Canadian
- ingredients: 1kg Ham, 200g (soaked overnight) Pea, 2 chopped Onion, 2 chopped Carrot, 2 Bay Leaf, 1 chopped Celery, 300g Pea, to serve Bread
- method (5 steps): Put the gammon in a very large pan with 2 litres water and bring to the boil. Remove from the heat and drain off the water – this helps to get rid of some of the saltiness. Recover with 2 litres cold water and bring to the boil again. Put everything but the frozen peas into the pan and bring to the boil. Reduce to a simmer and cook for 1½-2½ hrs, topping up the water as and when you need to, to a similar level it started at. As the ham cooks and softens, you can halve it if you want, so it is all submerged under the liquid. When the ham is tender enough to pull into shreds, it is ready. Lift o…
- `flavor.sweet` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 8 ingredients, 120 min)

### mdb-52926
**Tourtiere** · Pork · area: Canadian
- ingredients: 1 medium Potato, 1 tsp Vegetable Oil, 500g Pork Mince, 1 finely chopped Onion, 1 finely chopped Garlic, ¼ tsp Cinnamon, ¼ tsp Ground Allspice, ¼ tsp Ground Nutmeg, 100ml Vegetable Stock, 400g Shortcrust Pastry, To Glaze Egg
- method (4 steps): Heat oven to 200C/180C fan/gas. Boil the potato until tender, drain and mash, then leave to cool. Heat the oil in a non-stick pan, add the mince and onion and quickly fry until browned. Add the garlic, spices, stock, plenty of pepper and a little salt and mix well. Remove from the heat, stir into the potato and leave to cool. Roll out half the pastry and line the base of a 20-23cm pie plate or flan tin. Fill with the pork mixture and brush the edges of the pastry with water. Roll out the remaining dough and cover the pie. Press the edges of the pastry to seal, trimming off the excess. Prick th…
- `textures` rule: ['creamy', 'crispy', 'flaky'] (0.50, keywords: creamy, crispy, flaky)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 60 min)

### mdb-52927
**Montreal Smoked Meat** · Beef · area: Canadian
- ingredients: 1 Beef Brisket, 3 tbs Salt, 3 tbs Black Pepper, 1 tbs Coriander, 1 tbs Sugar, 1 tsp Bay Leaf, 1 tsp Clove, 3 tbs Black Pepper, 1 tbs Coriander, 1 tbs Paprika, 1 tbs Garlic, 1 tbs Onion, 1 tbs Dill, 1 tsp English Mustard, 1 tbs Celery Salt, 1 tsp Chilli Flakes
- method (6 steps): To make the cure, in a small bowl mix together salt, pink salt, black pepper, coriander, sugar, bay leaf, and cloves. Coat entire brisket with the cure and place in an extra-large resealable plastic bag. Place in the coldest part of the refrigerator and cure for 4 days, flipping brisket twice a day. Remove brisket from bag and wash as much cure off as possible under cold running water. Place brisket in a large container and fill with water and let soak for 2 hours, replacing water every 30 minutes. Remove from water and pat dry with paper towels. To make the rub, mix together black pepper, cor…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['tender'] (0.50, keywords: tender)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 6 steps, 16 ingredients, 575 min, technique: cure, temper)

### mdb-52928
**BeaverTails** · Dessert · area: Canadian
- ingredients: 1/2 cup Water, 2 parts Yeast, 1/2 cup Sugar, 1/2 cup Milk, 6 tblsp Butter, 2 Egg, 1 ½ tsp Salt, 2-1/2 cups Plain Flour, for frying Vegetable Oil, garnish Lemon, garnish Sugar, garnish Cinnamon
- method (7 steps): In the bowl of a stand mixer, add warm water, a big pinch of sugar and yeast. Allow to sit until frothy. Into the same bowl, add 1/2 cup sugar, warm milk, melted butter, eggs and salt, and whisk until combined. Place a dough hook on the mixer, add the flour with the machine on, until a smooth but slightly sticky dough forms. Place dough in a bowl, cover with plastic wrap, and allow to proof for 1 1/2 hours. Cut dough into 12 pieces, and roll out into long oval-like shapes about 1/4 inch thick that resemble a beaver’s tail. In a large, deep pot, heat oil to 350 degrees. Gently place beavertail …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 12 ingredients, 150 min, technique: proof)

### mdb-52929
**Timbits** · Dessert · area: Canadian
- ingredients: 2 cups Plain Flour, 1/3 cup Sugar, 3 tsp Baking Powder, ½ tsp Salt, 1 beaten Egg, ¾ cup Milk, 3 tbs Vegetable Oil, for frying Vegetable Oil, garnish Icing Sugar
- method (5 steps): Sift together dry ingredients. Mix together wet ingredients and incorporate into dry. Stir until smooth. Drop by teaspoonfuls(no bigger) into hot oil (365 degrees, no hotter), turning after a few moments until golden brown on all sides. Remove and drain. Roll in cinnamon sugar while still warm and serve.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 50 min)

### mdb-52930
**Pate Chinois** · Beef · area: Canadian
- ingredients: 4 cups Potato, 60ml Butter, ½ cup Milk, 450g Beef Mince, 1 finely chopped Onion, 500ml Creamed Corn, to taste Paprika, to taste Parsley, Dash Salt, Dash Black Pepper
- method (6 steps): In a large pot of salted water, cook the potatoes until they are very tender. Drain. With a masher, coarsely crush the potatoes with at least 30 ml (2 tablespoons) of butter. With an electric mixer, purée with the milk. Season with salt and pepper. Set aside. With the rack in the middle position, preheat the oven to 190 °C (375 °F). In a large skillet, brown the onion in the remaining butter. Add the meat and cook until golden brown. Season with salt and pepper. Remove from the heat. Lightly press the meat at the bottom of a 20-cm (8-inch) square baking dish. Cover with the corn and the mashed…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 60 min)

### mdb-52931
**Sugar Pie** · Dessert · area: Canadian
- ingredients: 2 cups Brown Sugar, ¼ cup Butter, 2 Egg, 1 tsp Vanilla Extract, 1 tsp Salt, ½ cup Plain Flour, 1 1/2 cups Milk
- method (3 steps): Preheat oven to 350 degrees F (175 degrees C). Grease a 9-inch pie dish. Place the brown sugar and butter in a mixing bowl, and beat them together with an electric mixer until creamy and very well combined, without lumps. Beat in eggs, one at a time, incorporating the first egg before adding the next one. Add the vanilla extract and salt; beat the flour in, a little at a time, and then the milk, making a creamy batter. Pour the batter into the prepared pie dish. Bake in the preheated oven for 35 minutes; remove pie, and cover the rim with aluminum foil to prevent burning. Return to oven, and b…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy'] (0.50, keywords: creamy, crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 7 ingredients, 110 min, technique: temper)

### mdb-52932
**Pouding chomeur** · Dessert · area: Canadian
- ingredients: ½ cup Butter, 1 cup Sugar, 2 Egg, 1 tsp Vanilla Extract, 2 cups Plain Flour, 1 tsp Baking Powder, 1 1/4 cup Milk, 1 1/2 cup Maple Syrup, 1 1/2 cup Brown Sugar, 1 1/2 cup Single Cream, 1/3 cup Butter
- method (10 steps): In a large bowl, with an electric mixer, mix the butter and sugar till the mix is light. Add eggs and vanilla and mix. In another bowl, mix flour and baking powder. Alternate flour mix and milk to the butter mix. Pour into a 13 inch by 9 inch greased pan. MAPLE SAUCE. In a large casserole, bring to boil the syrup, brown sugar, cream and butter and constantly stir. Reduce heat and and gently cook 2 minutes or till sauce has reduced a little bit. Pour sauce gently over cake. Bake at 325°f (160°c) about 35 minutes or till cake is light brown and when toothpick inserted comes out clean.
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 11 ingredients, 60 min)

### mdb-52933
**Rappie Pie** · Chicken · area: Canadian
- ingredients: 2 tbs Butter, 2 chopped Onion, 4 qt Chicken Stock, 1.5kg Chicken Breast, 4kg Potato, 2 tbs Salt, 1tbsp Black Pepper
- method (6 steps): Preheat oven to 400 degrees F (200 degrees C). Grease a 10x14x2-inch baking pan. Heat margarine in a skillet over medium heat; stir in onion. Cook and stir until onion has softened and turned translucent, about 5 minutes. Reduce heat to low and continue to cook and stir until onion is very tender and dark brown, about 40 minutes more. Bring chicken broth to a boil in a large pot; stir in chicken breasts, reduce heat, and simmer until chicken is no longer pink at the center, about 20 minutes. Remove from heat. Remove chicken breasts to a plate using a slotted spoon; reserve broth. Juice potatoe…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy'] (0.50, keywords: brothy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 7 ingredients, 140 min, technique: caramelize)

### mdb-52934
**Chicken Basquaise** · Chicken · area: France
- ingredients: 1.5kg Chicken, 25g Butter, 6 tblsp Olive Oil, 2 sliced Red Onion, 3 Large Red Pepper, 130g Chorizo, 8 Sun Dried Tomato, 6 cloves sliced Garlic, 300g Basmati Rice, drizzle Tomato Puree, ½ tsp Paprika, 4 Bay Leaf, Handful Thyme, 350ml Chicken Stock, 180g White Wine, 2 Lemon, 100g Black Olive, to serve Salt, to serve Black Pepper
- method (6 steps): Preheat the oven to 180°C/Gas mark. Have the chicken joints ready to cook. Heat the butter and 3 tbsp olive oil in a flameproof casserole or large frying pan. Brown the chicken pieces in batches on both sides, seasoning them with salt and pepper as you go. Don't crowd the pan - fry the chicken in small batches, removing the pieces to kitchen paper as they are done. Add a little more olive oil to the casserole and fry the onions over a medium heat for 10 minutes, stirring frequently, until softened but not browned. Add the rest of the oil, then the peppers and cook for another 5 minutes. Add th…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 19 ingredients, 110 min, technique: proof)

### mdb-52935
**Steak Diane** · Beef · area: France
- ingredients: 2 tbs Vegetable Oil, 4 Beef Fillet, 1 1/2 cup Beef Stock, 2 tbs Butter, 2 cloves minced Garlic, 1 medium finely diced Shallot, 4 oz Mushroom, ¼ cup Brandy, ¼ cup Double Cream, 1 tbs Dijon Mustard, 1 tbs Worcestershire Sauce, Dash Hot Sauce, 1 tbs minced Parsley, 1 tbs minced Chive, to taste Salt, to taste Black Pepper
- method (5 steps): Heat oil in a 12" skillet over medium-high heat. Season steaks with salt and pepper, and add to skillet; cook, turning once, until browned on both sides and cooked to desired doneness, about 4 to 5 minutes for medium-rare. Transfer steaks to a plate, and set aside. Return skillet to high heat, and add stock; cook until reduced until to 1⁄2 cup, about 10 minutes. Pour into a bowl, and set aside. Return skillet to heat, and add butter; add garlic and shallots, and cook, stirring, until soft, about 2 minutes. Add mushrooms, and cook, stirring, until they release any liquid and it evaporates and m…
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 16 ingredients, 55 min, technique: flamb)
