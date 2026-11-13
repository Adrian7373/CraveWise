# AI tagging batch 025

Write `tools/seedgen/tags/ai/batch-025.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53276
**Apricot & Turkish delight mess** · Dessert · area: Turkish
- ingredients: 100g Mascarpone, 50g Greek Yogurt, 25g Icing Sugar, 2 tablespoons Orange Blossom Water, 1 Meringue Nests, 3 Apricot, 2 pieces Turkish Delight, 25g Almond, 4 Mint
- method (1 steps): Place the mascarpone, yogurt, sugar and orange flower water into a large bowl and whisk until thickened. Fold the remaining ingredients through, then divide the mix between 2 dessert glasses or bowls and decorate with extra mint, if you like.
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 9 ingredients, 50 min)

### mdb-53277
**Lamb & apricot meatballs** · Lamb · area: Turkish
- ingredients: 2 tablespoons Olive Oil, 2 chopped Red Onion, 4 Cloves Crushed Garlic, 2 tsp Ground Cumin, 2 tsp Ground Coriander, 400g Chopped Tomatoes, 1/2 teaspoon Sugar, 10g Mint, 500g Lamb Mince, 8 Dried Apricot, 50g Breadcrumb, To serve Pita Bread
- method (3 steps): Heat 2 tsp oil in a pan and soften the onions for 5 mins. Add the garlic and spices and cook for a few mins more. Spoon half the onion mixture into a bowl and set aside to cool. Add the tomatoes, sugar and seasoning to the remaining onions in the pan and simmer for about 10 mins until reduced. Meanwhile, add the mint, lamb, apricots and breadcrumbs to the cooled onions, season and mix well with your hands. Shape into little meatballs. Heat the rest of the oil in a non-stick pan and fry the meatballs until golden (in batches if you need to). Stir in the sauce with a splash of water and gently c…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 40 min)

### mdb-53278
**Aubergine & hummus grills** · Vegetarian · area: Turkish
- ingredients: 2 Aubergine, 2 tablespoons Vegetable Oil, 3 sliced thinly Bread, 300g Hummus, 100g Walnut, 40g Parsley, 200g Cherry Tomato, Juice of 1/2 Lemon, Splash Olive Oil
- method (3 steps): Lay the aubergine out in one layer on a large baking sheet. Brush sparingly with vegetable oil, then season generously. Grill for 15 mins, turning twice and brushing with oil until the slices are softened and cooked through. Meanwhile, whizz the bread into crumbs. Add 2 tsp oil and whizz briefly again, to coat. Spread a couple of tsps of hummus on top of each slice of aubergine. Tip the breadcrumbs onto a large plate, then press the hummus side of the aubergines into the crumbs to coat. Grill again, crumb-side up, for about 3 mins until golden. Toss the walnuts, parsley and cherry tomatoes in …
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 45 min)

### mdb-53279
**Baklava with spiced nuts, ricotta & chocolate** · Dessert · area: Turkish
- ingredients: 500g Sugar, To taste Lemon Juice, 300g Walnut, 200g Pecan Nut, 100g Almond, 2 tablespoons Cinnamon, 1 tablespoon Cardamom, 500g Ricotta, Zest of 1 Lemon, Zest of 1 Orange, 1 tablespoon Vanilla Extract, 250g Butter, 500g Filo Pastry, 100g Pistachio
- method (13 steps): First, make the syrup. Tip the sugar into a large saucepan with 650ml water. Stir over a low heat until the sugar has dissolved, then turn up the heat and bring to the boil. Reduce the heat to a simmer and cook for 15 mins, then squeeze in a few drops of lemon juice and simmer for a further 5 mins. Remove from the heat and leave to cool. Meanwhile, for assembling the baklava later, melt the butter in a small pan over a low heat for 5 mins, skimming and discarding any froth that rises to the surface. For the filling, crush all of the nuts in a pestle and mortar, or blitz in a food processor – y…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'flaky'] (0.50, keywords: crunchy, flaky)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 13 steps, 14 ingredients, 75 min)

### mdb-53280
**Poulet Roti a l'Algerienne (Algerian Roast Chicken)** · Chicken · area: Algerian
- ingredients: 1 cup Water, 1 chopped Onion, 5 tablespoons Olive Oil, 2 tablespoons Balsamic Vinegar, 1 tablespoon Dijon Mustard, 3 Cloves Crushed Garlic, 1 tsp Black Pepper, 1 tsp Cayenne Pepper, To taste Salt, 1 Chicken
- method (3 steps): Preheat oven to 350 degrees F (175 degrees C). Mix water, onion, olive oil, balsamic vinegar, Dijon mustard, garlic, black pepper, cayenne pepper, and salt together in a roasting dish. Add chicken; turn until well coated with mixture. Bake in the preheated oven until an instant-read thermometer inserted into the thickest part of the thigh, near the bone, reads 165 degrees F (74 degrees C), about 1 hour 30 minutes.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 110 min)

### mdb-53281
**Algerian Kefta (Meatballs)** · Beef · area: Algerian
- ingredients: 1 lb Beef Mince, 4 Cloves Crushed Garlic, 1/2 cup Onion, To taste Salt, To taste Black Pepper, 3 Tomato, 1 tsp Parsley, 1/2 cup Water
- method (4 steps): Combine ground beef with 1/2 of the minced garlic and 1 tablespoon chopped onion in a large bowl. Mix with your hands until fully incorporated. Shape meat mixture into 1 1/2-inch oblong patties; you should have 12 to 14 meatballs. Heat a large skillet over medium-high heat. Brown patties in batches in the hot skillet until crispy on both sides and no longer pink in the center, about 10 minutes. Set meatballs aside in a rimmed serving dish. Reduce heat to medium and stir remaining chopped onion into drippings in the skillet. Season with salt and pepper. Cook, stirring constantly, until onion ha…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 50 min)

### mdb-53282
**Algerian Carrots** · Side · area: Algerian
- ingredients: 1 1/2 cup Water, 2 Lbs Carrot, 5 tablespoons Olive Oil, 1 tsp Salt, 1/2 teaspoon Black Pepper, 1/2 teaspoon Cinnamon, 1/2 teaspoon Ground Cumin, 3 Cloves Crushed Garlic, 1/2 teaspoon Thyme, 1 Bay Leaf, 1 tsp Lemon Juice
- method (3 steps): Place a steamer insert into a saucepan, and fill with 1 1/2 cups of water, or just below the bottom of the steamer. Cover, and bring the water to a boil over high heat. Add the sliced carrots, reduce the heat to medium, and cover the pan again. Steam until tender but not mushy, 4 to 6 minutes depending on the thickness of the slices. Reserve 1/2 cup of the cooking liquid. Heat the olive oil in a skillet over medium heat. Reduce the heat to low and stir in the salt, pepper, cinnamon, cumin, garlic, and thyme. Cook the spices and garlic, stirring frequently, until fragrant, about 10 minutes. Add…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 65 min)

### mdb-53283
**Chtitha Batata (Algerian Potato Stew)** · Vegetarian · area: Algerian
- ingredients: 4 cloves Garlic, 1 small Red Chilli, 1 tsp Ground Cumin, 1 teaspoon Paprika, 1/2 teaspoon Black Pepper, 1/2 teaspoon Cayenne Pepper, 1/2 teaspoon Salt, 2 tablespoons Olive Oil, 2 Lbs New Potato, 1 tablespoon Tomato Puree, Boiled Water, To taste Salt
- method (3 steps): Combine garlic, chile pepper, cumin, paprika, black pepper, cayenne, and salt in a mortar; grind with a pestle until it forms a paste. Add olive oil and mix dersa well. Heat a large saucepan over medium heat and stir-fry dersa until fragrant, 2 to 4 minutes. Add potato halves and stir to combine with the dersa. Stir in tomato paste. Pour in enough water to just cover the potatoes and bring to a boil. Reduce heat and simmer until potatoes are tender, about 40 minutes. Ladle potatoes into a serving bowl. Spoon any remaining sauce over the potatoes.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth', 'tender'] (0.50, keywords: saucy, smooth, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 70 min)

### mdb-53284
**Algerian Bouzgene Berber Bread with Roasted Pepper Sauce** · Side · area: Algerian
- ingredients: 2 Red Pepper, 4 Tomato, 1 tablespoon Olive Oil, 4 Cloves Chopped Garlic, 1 chopped Jalapeno, To taste Salt, 2 Lbs Semolina, 1 1/2 tsp Salt, 3 Cups Water, 4 tablespoons Olive Oil, 6 tablespoons Olive Oil
- method (5 steps): Preheat your oven's broiler. Place red bell peppers and tomatoes on a baking sheet, and roast under the broiler for about 8 minutes, turning occasionally. This should blacken the skin and help it peel off more easily. Cool, then scrape the skins off of the tomatoes and peppers, and place them in a large bowl. Remove cores and seeds from the bell peppers. Heat 1 tablespoon of olive oil in a skillet over medium heat. Add the jalapenos and garlic, and cook until tender, stirring frequently. Remove from heat, and transfer the garlic and jalapeno to the bowl with the tomatoes and red peppers. Using…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 40 min)

### mdb-53285
**Dziriat (Algerian Almond Tarts)** · Dessert · area: Algerian
- ingredients: 1 cup Sugar, 1 cup Water, 1 tsp Lemon Juice, 2 tablespoons Orange Blossom Water, 2 cups Plain Flour, 2 tablespoons Vegetable Oil, 1 Egg, 1/2 teaspoon Lemon Juice, 1 pinch Salt, 1 tablespoon Orange Blossom Water, 4 cups Almond, 1 cup Sugar, 3 Egg, 1/2 teaspoon Baking Powder, 1 tsp Vanilla Extract, Zest of 1 Lemon, 2 tablespoons Orange Blossom Water, Sprinkling Cornflour, To serve Pine Nut
- method (9 steps): Prepare the almonds the day before. Bring 6 cups of water to a boil. Remove from heat, and add the almonds. Let the almonds soak in water for about 5 minutes, then drain and peel. Spread the almonds on baking sheets, and bake at 200 degrees F(95 degrees C) until completely dry and toasted. This takes several hours, and needs to be prepared ahead. Be careful not to burn the nuts, as this will give a bitter taste to the filling. Combine 1 cup sugar and 1 cup water in a saucepan, and bring to a boil. Add 1 teaspoon lemon juice, reduce heat to low, and let it simmer until syrupy, about 30 to 40 mi…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 19 ingredients, 95 min)

### mdb-53286
**Khobz el Dar (Algerian Semolina Bread)** · Side · area: Algerian
- ingredients: 1/2 cup Semolina, 2 tablespoons Semolina, 3 tablespoons Sesame Seed, 1 tablespoon Sugar, 1 tsp Yeast, 3/4 teaspoon Salt, 1/4 cup Vegetable Oil, 1 Egg, 1 Egg, 1 cup Milk, 3 Cups Plain Flour, 2 tablespoons Plain Flour, 1 tsp Water
- method (8 steps): Mix 1/2 cup plus 2 tablespoons semolina, 2 tablespoons sesame seeds, sugar, yeast, and salt together in a large bowl. Whisk in oil, egg, and egg white. Stir in warm milk slowly until a liquid dough forms. Cover the bowl with a plate or plastic wrap; let stand at room temperature until frothy, about 1 hour. Stir in 2 3/4 cups flour with a wooden spoon until a sticky dough forms. Cover again and allow to rest for 30 minutes. Line a baking sheet with parchment paper or a baking mat. Sprinkle 1 tablespoon flour over the dough and your hands. Mix dough, adding flour as needed, 1 tablespoon at a tim…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 13 ingredients, 195 min)

### mdb-53287
**Tajine de Poulet aux Carottes et Patates Douces (Chicken and Sweet Potato Tagine)** · Chicken · area: Algerian
- ingredients: 2 sliced Onion, 2 sliced Celery, 1/2 bag Coriander, 1/2 bag Parsley, 1/2 tsp Turmeric, 1/2 tsp Ground Cumin, 1/2 teaspoon Paprika, 1/4 tsp Ground Ginger, 1/4 tsp Cayenne Pepper, To taste Salt, To taste Black Pepper, 4 Chicken Thigh, Drizzle Olive Oil, 1/4 cup Raisin, 1 cup Chicken Stock, 1 large Sweet Potato, 3 sliced thinly Carrot, 1/4 cup Prune
- method (5 steps): Combine onions, celery, cilantro, and parsley in a large pot. Stir in turmeric, cumin, paprika, ginger, cayenne pepper, salt, and pepper. Place chicken thighs on top. Drizzle olive oil over chicken. Cover and simmer over low heat until chicken is tender, about 40 minutes. Place raisins in a small bowl and cover with hot water; let soak for 10 minutes. Drain. Preheat oven to 400 degrees F (200 degrees C). Transfer chicken mixture into an oven-safe tagine or casserole dish. Add sweet potato and carrots. Cover with lid or aluminum foil. Bake in the preheated oven until sweet potato is soft, about…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 18 ingredients, 130 min)

### mdb-53288
**Algerian Flafla (Bell Pepper Salad)** · Vegetarian · area: Algerian
- ingredients: 3 Green Pepper, 1 tablespoon Olive Oil, 1 tablespoon chopped Red Onion, 1 clove peeled crushed Garlic, To taste Salt, To taste Black Pepper, 1 Diced Tomato
- method (3 steps): Preheat an oven to 450 degrees F (230 degrees C). Place the whole peppers on aluminum foil. Bake until the skin is spotted black and the peppers are soft, 30 to 45 minutes, turning the peppers once if necessary. Remove peppers from the oven and set aside to cool for 10 minutes. Peel off the skin and remove the stem and seeds. Chop the roasted peppers into half-inch pieces. Heat the olive oil in a skillet over medium heat. Stir in the onion and cook, stirring frequently, until the onion has softened and turned translucent, about 5 minutes. Add the garlic, salt, and pepper; stir in the chopped p…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 70 min)

### mdb-53289
**Chorba Hamra bel Frik (Algerian Lamb, Tomato, and Freekeh Soup)** · Lamb · area: Algerian
- ingredients: 1 cup Freekeh, 12 ounces Lamb, 1 finely chopped Onion, 1 tsp Black Pepper, 1 tsp Paprika, 1 tsp Cinnamon, To taste Salt, 3 tablespoons Vegetable Oil, 1 bunch Coriander, 1 bunch Mint, 1 Celery, 14 oz jar Chickpea, 4 cups Water, 1 Diced Courgette, 1 Diced Carrot, 1 tablespoon Tomato Puree, 3 Medium Tomato, 1 Diced Potato
- method (5 steps): Place freekeh in a small bowl and cover with cold water. Set aside. Combine lamb, onion, black pepper, paprika, cinnamon, and salt in a pot. Stir in oil, 1/2 the cilantro, 1/2 the mint, and celery stalk until combined. Simmer over low heat for 15 minutes. Stir in chickpeas; pour in just enough water to cover, and return to a simmer. Stir in zucchini, carrot, and tomato paste. Set a steamer over the pot; add tomatoes. Cover and steam tomatoes until soft, about 5 minutes. Crush tomatoes using a wooden spoon, so pulp drips into soup. Remove the steamer and discard leftover tomato peels. Add potat…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 18 ingredients, 80 min)

### mdb-53290
**Cheese Borek** · Side · area: Algerian
- ingredients: 1 beaten Egg, 1 bunch Parsley, 2 cloves minced Garlic, 3/4 teaspoon Red Pepper, 6 oz Gouda Cheese, 6 oz Emmentaler Cheese, 12 Filo Pastry, 1 1/2 cups Butter
- method (4 steps): In a medium bowl, whisk together egg, parsley, garlic and crushed red pepper. Mix in Gouda and Emmentaler. One sheet at a time, place phyllo dough on a flat surface and brush with about 1 tablespoon butter. Cut lengthwise into 4 strips. Place a rounded teaspoon of the egg mixture at one end of each strip. Fold corner of strip over the filling, forming a triangular fold. Continue folding the length of the strip in triangular folds to form a small stuffed triangle. Repeat with remaining phyllo dough. Preheat oven to 350 degrees F (175 degrees C). Lightly butter a large baking sheet. Arrange stuf…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 50 min)

### mdb-53291
**Cornes de Gazelle (Gazelle Horns)** · Dessert · area: Algerian
- ingredients: 2 cups Almond, 3/4 cup Sugar, 1 tablespoon Sugar, 1/4 tsp Cinnamon, 1 Egg, 1 tablespoon Orange Blossom Water, 2 cups Plain Flour, 1/2 cup Butter, 1 pinch Salt, 1 beaten Egg, 3 tablespoons Vegetable Oil, 1 ½ tbsp Orange Blossom Water, 3 tablespoons Pistachio
- method (10 steps): Preheat oven to 300 degrees F (150 degrees C). Line a baking sheet with parchment paper. Spread almonds over the baking sheet. Bake in the preheated oven until almonds are fragrant and roasted, 20 to 25 minutes. Prepare pastry dough while almonds are roasting. Combine flour, 1/2 cup plus 1 tablespoon butter, and salt in a bowl and rub together until the mixture resembles breadcrumbs. Add egg, oil, and 1 1/2 tablespoons orange blossom water; knead everything into a smooth pastry dough. Add a little water, 1 teaspoon at a time, if dough is too dry. Shape pastry dough into a ball, wrap in plastic…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'flaky', 'smooth'] (0.50, keywords: crunchy, flaky, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 10 steps, 13 ingredients, 110 min, technique: knead)

### mdb-53292
**Piernik (Polish gingerbread)** · Dessert · area: Polish
- ingredients: 140g Butter, 300g Honey, 100g Brown Sugar, 375g Self Raising Flour, 3 tsp Ground Ginger, 1 tsp Cinnamon, 1/2 teaspoon Clove, 1/4 tsp Ground Nutmeg, 1/4 tsp Black Pepper, 3 Large Egg, 200g Plum Jam, 225ml Double Cream, 140g Dark Chocolate, 3 tablespoons Honey
- method (8 steps): Heat oven to 160C/140C fan/gas. Grease and line the base and sides of a deep 20cm cake tin with baking parchment. Put the honey, sugar and butter in a medium saucepan and cook over a medium heat until fully melted. Remove from the heat and allow to cool. Put the flour and spices in a large bowl and mix everything together. Once the liquid ingredients have cooled, whisk in the eggs. Pour over the dry ingredients, whisking them together to form a smooth batter – be careful not to overmix as this can lead to a dry cake. Pour into the prepared tin and bake for 50-55 mins or until risen and a skewe…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'smooth'] (0.50, keywords: creamy, crispy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 14 ingredients, 100 min)

### mdb-53293
**Pistachio cake** · Dessert · area: Polish
- ingredients: 250g Butter, 200g Pistachio, 80g Plain Flour, 1 tsp Baking Powder, 225g Sugar, 4 Egg, 1 tsp Vanilla Extract, 100g Icing Sugar, 250g Mascarpone, 200ml Double Cream, 100g Pistachio Paste, 400g Raspberry, 1 Lime
- method (8 steps): Heat the oven to 180C/160C fan/gas. Butter and line a 23cm springform cake tin. Tip 150g of the pistachios into a food processor and blitz until finely ground. Tip into a bowl and mix in the flour, baking powder and pinch of salt. Beat the butter and sugar in a separate bowl until fluffy and pale, around 5 mins. Crack in the eggs one at a time, beating well for 1 min after each addition, until they have all been added. Beat in the vanilla, then fold in the flour mixture gently. Carefully spoon into the prepared tin and bake for 35-40 mins until a skewer inserted into the middle comes out clean…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy'] (0.50, keywords: creamy, fluffy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 13 ingredients, 90 min, technique: fold in the flour)

### mdb-53294
**Zapiekanki** · Pork · area: Polish
- ingredients: 2 Baguette, 1 tablespoon Butter, 2 tsp Vegetable Oil, 1 chopped Onion, 300g Mushroom, 1 clove Garlic, 1 tablespoon Mayonnaise, 50g Cheddar, 75g Ham, 75g Polish Kabano, 50g Mozzarella, 2 Dill, 1 tablespoon Chive, Drizzle Tomato Ketchup
- method (5 steps): Heat the oven to 200C/180C fan/gas. Bake the baguettes on a baking tray for 8-10 mins, then leave to cool. Heat 2 tsp of the butter and 1 tsp of the oil in a pan over a low heat and cook the chopped onion for 5 mins until soft. Stir in the mushrooms, turn the heat to medium and cook for 5-10 mins more until the veg is soft and the mushroom liquid has evaporated. Stir in the garlic and cook for 1-2 mins until soft. Season, then stir in the mayonnaise and remove from the heat. Halve the baguettes lengthways, then return to the baking tray, cut-side up and spread over the mushroom mixture, then s…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 14 ingredients, 65 min, technique: caramelis)

### mdb-53295
**Polish chocolate & walnut cake** · Dessert · area: Polish
- ingredients: 150g Plain Flour, 50g Coco Sugar, 8 Egg, 200g Sugar, 5 Egg White, 200g Sugar, 250g Walnut, 1 tablespoon Plain Flour, 1 tablespoon Potato Starch, 100g Double Cream, 100g Chocolate Chip
- method (6 steps): Heat the oven to 170C/150C fan/gas 3½. Line a 30 x 22cm shallow baking tin with baking parchment. Sift the flour and mix it with cocoa, then set aside. Beat the egg whites until stiff, then add the sugar to them in small batches. Add the egg yolks, one by one, whisking constantly. Tip in the flour mixture and gently fold everything together with a spatula. Pour the prepared batter into the lined tin and bake for 35 mins. Cool for 5 mins, remove from the tin and re-line the tin with baking parchment. To make the meringue, whisk the whites until stiff, then gradually whisk in the sugar, one tabl…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 11 ingredients, 165 min)
