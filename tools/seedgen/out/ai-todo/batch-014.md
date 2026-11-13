# AI tagging batch 014

Write `tools/seedgen/tags/ai/batch-014.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53033
**Japanese gohan rice** · Side · area: Japanese
- ingredients: 300g Sushi Rice, 1 tbs Mirin, Garnish Pickle Juice, Garnish Spring Onion
- method (2 steps): Rinsing and soaking your rice is key to achieving the perfect texture. Measure the rice into a bowl, cover with cold water, then use your fingers to massage the grains of rice – the water will become cloudy. Drain and rinse again with fresh water. Repeat five more times until the water stays clear. Tip the rinsed rice into a saucepan with 400ml water, or 200ml dashi and 200ml water, bring to the boil, then turn down the heat to a low simmer, cover with a tight-fitting lid with a steam hole and cook for 15 mins. Remove from the heat and leave to sit for another 15 mins, then stir through the mi…
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 4 ingredients, 40 min)

### mdb-53034
**Japanese Katsudon** · Pork · area: Japanese
- ingredients: 1 tbs Vegetable Oil, 1 large Onion, 1 chopped Pork, 150ml Vegetable Stock, 1 tbs Soy Sauce, 1 tsp Mirin, 1 tsp Sugar, 2 Beaten Egg, 200g Sushi Rice, Chopped Chive
- method (2 steps): Heat the oil in a pan, fry the sliced onion until golden brown, then add the tonkatsu (see recipe here), placing it in the middle of the pan. Mix the dashi, soy, mirin and sugar together and tip three-quarters of the mixture around the tonkatsu. Sizzle for a couple of mins so the sauce thickens a little and the tonkatsu reheats. Tip the beaten eggs around the tonkatsu and cook for 2-3 mins until the egg is cooked through but still a little runny. Divide the rice between two bowls, then top each with half the egg and tonkatsu mix, sprinkle over the chives and serve immediately, drizzling with a…
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 30 min)

### mdb-53035
**Ham hock colcannon** · Pork · area: Irish
- ingredients: 800g Potato, 50g Butter, 3 chopped Garlic, 1 chopped Cabbage, 8 Spring Onion, 100ml Double Cream, 2 tbs Mustard, 180g Ham, 4 Egg
- method (4 steps): Peel and cut the potatoes into even, medium-sized chunks. Put in a large pan filled with cold salted water, bring to the boil and cook for 10-15 mins until a knife can be inserted into the potatoes easily. Meanwhile, melt the butter in a large sauté pan over a medium heat. Add the garlic, cabbage, spring onions and some seasoning. Stir occasionally until the cabbage is wilted but still retains a little bite, then set aside. Drain the potatoes, leave to steam-dry for a couple of mins, then mash with the cream, mustard and seasoning in the same saucepan. Stir in the cabbage and ham hock. Keep wa…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy'] (0.50, keywords: creamy, crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 35 min)

### mdb-53036
**Boxty Breakfast** · Pork · area: Irish
- ingredients: 4 large Potato, 1 bunch Spring Onion, 100g Plain Flour, 1 Egg White, 150ml Milk, 1 tsp Bicarbonate of Soda, 3 tbs Butter, 2 tbs Vegetable Oil, 6 Cherry Tomato, 12 Bacon, 6 Egg
- method (6 steps): Before you start, put your oven on its lowest setting, ready to keep things warm. Peel the potatoes, grate 2 of them, then set aside. Cut the other 2 into large chunks, then boil for 10-15 mins or until tender. Meanwhile, squeeze as much of the liquid from the grated potatoes as you can using a clean tea towel. Mash the boiled potatoes, then mix with the grated potato, spring onions and flour. Whisk the egg white in a large bowl until it holds soft peaks. Fold in the buttermilk, then add the bicarbonate of soda. Fold into the potato mix. Heat a large non-stick frying pan over a medium heat, th…
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 11 ingredients, 70 min)

### mdb-53037
**Coddled pork with cider** · Pork · area: Irish
- ingredients: Knob Butter, 2 Pork Chop, 4 Bacon, 2 Potato, 1 Carrot, 1/2 Swede, 1/2 Cabbage, 1 Bay Leaf, 100ml Cider, 100g Chicken Stock
- method (3 steps): Heat the butter in a casserole dish until sizzling, then fry the pork for 2-3 mins on each side until browned. Remove from the pan. Tip the bacon, carrot, potatoes and swede into the pan, then gently fry until slightly coloured. Stir in the cabbage, sit the chops back on top, add the bay leaf, then pour over the cider and stock. Cover the pan, then leave everything to gently simmer for 20 mins until the pork is cooked through and the vegetables are tender. Serve at the table spooned straight from the dish.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 45 min)

### mdb-53038
**Mustard champ** · Side · area: Irish
- ingredients: 1kg Potato, 200ml Milk, 50g Butter, 2 tbs Mustard, Bunch Spring Onion, Bunch Spring Onion
- method (3 steps): Boil the potatoes for 15 mins or until tender. Drain, then mash. Heat the milk and half the butter in the corner of the pan, then beat into the mash, along with the wholegrain mustard. Gently fry the spring onions in the remaining butter for 2 mins until just soft but still a perky green. Fold into the mash and serve. Great with gammon or to top a fish pie.
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 6 ingredients, 35 min)

### mdb-53039
**Piri-piri chicken and slaw** · Chicken · area: Portuguese
- ingredients: 1.5kg Chicken, 3 chopped Red Chilli, 2 cloves Garlic, 1 tsp Ginger, 1 tsp Dried Oregano, 1 tsp Coriander, 1 tsp Paprika, 2 tbs Red Wine Vinegar, 2 tbs Vegetable Oil, 1 sliced Red Onion, 2 Carrot, 1 Beetroot, 4 leaves Cabbage, 2 tbs Mayonnaise, 2 tbs Greek Yogurt, 2 tbs Red Wine Vinegar, 1 tsp Cumin Seed
- method (3 steps): Whizz together all of the marinade ingredients in a small food processor. Rub the marinade onto the chicken and leave for 1 hour at room temperature. Heat the oven to 190C/fan 170C/gas. Put the chicken in a roasting tray and cook for 1 hour 20 minutes. Rest under loose foil for 20 minutes. While the chicken is resting, mix together the slaw ingredients and season. Serve the chicken with slaw, fries and condiments.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 17 ingredients, 190 min, technique: temper)

### mdb-53040
**Spring onion and prawn empanadas** · Seafood · area: Portuguese
- ingredients: 1 bunch Spring Onion, Dash Olive Oil, 1 finely sliced Red Chilli, 1 clove Garlic, 350g Prawn, 75g Feta, 15g Butter, 250g Plain Flour, 1 Seperated Egg, 1/2 tsp White Wine Vinegar
- method (7 steps): To make the dough, rub the butter into the flour and then add the egg white and half the yolk (keep the rest), vinegar, a pinch of salt and enough cold water to make a soft dough. Knead on a floured surface until smooth and then wrap and rest for 30 minutes. Heat the oven to 180c/fan 160c/gas. Trim the green ends of the spring onions and then finely slice the rest. Heat a little oil in a pan and fry them gently until soft but not browned. Add the chilli and garlic, stir and then add the prawns and cook until they are opaque. Season well. Scoop out the prawns and bubble the juices until they th…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'smooth'] (0.50, keywords: crispy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 10 ingredients, 90 min, technique: crimp, knead)

### mdb-53041
**Grilled Portuguese sardines** · Seafood · area: Portuguese
- ingredients: 8 Sardine, 2 tbs Olive Oil, 3 cloves Garlic, 1 tbs Paprika, 1/2 Lemon, 4 sprigs Rosemary, 1 Red Chilli
- method (2 steps): Put all of the ingredients, except the sardines, into a bowl and mix together with some seasoning. Pour into a baking dish, add the sardines and toss really well. Cover and chill for a few hours. Heat a BBQ or griddle pan until hot. Cook the sardines for 4-5 minutes on each side or until really caramelised and charred. Put onto a serving plate, drizzle with oil, sprinkle with a little more paprika and squeeze over the lemon wedges.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 20 min, technique: caramelis)

### mdb-53042
**Portuguese prego with green piri-piri** · Beef · area: Portuguese
- ingredients: 1 clove Garlic, 2 small Beef Fillet, 2 tbs Olive Oil, 1 tbs White Vinegar, Leaves Parsley, 2 Ciabatta, 2 handfulls Rocket, Small bunch Basil, Small bunch Parsley, 1 Jalapeno, 1 tbs White Vinegar, 2 chopped Spring Onion, 1/2 Garlic, 1/2 tsp Sugar
- method (4 steps): Rub the garlic over the steaks then put in a sandwich bag and tip in the olive oil, sherry vinegar and parsley stalks. Smoosh everything together, then use a rolling pin to bash the steaks a few times. Leave for 1-2 hours. To make the sauce, put all the ingredients into a blender with 1 tbsp water and whizz until as smooth as possible. This will make more than you’ll need for the recipe but will keep for a week in an airtight jar. Heat a griddle or frying pan to high. Brush away the garlic and parsley stalks from the steaks and season well. Sear the steaks for 2 minutes on each side then rest …
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 14 ingredients, 95 min)

### mdb-53043
**Fish fofos** · Seafood · area: Portuguese
- ingredients: 600g Haddock, 300g Potato, 1 chopped Green Chilli, 3 tbs Coriander, 1 tsp Cumin Seed, 1/2 tsp Black Pepper, 3 cloves Garlic, 2 pieces Ginger, 2 tbs Plain Flour, 3 Egg, 75g Breadcrumb, For frying Vegetable Oil
- method (5 steps): Put the fish into a lidded pan and pour over enough water to cover. Bring to a simmer and gently poach for 10 minutes over a low heat with the lid on. Drain and flake the fish. Put the fish, potato, green chilli, coriander, cumin, black pepper, garlic and ginger in a large bowl. Season, add the rice flour, mix well and break in 1 egg. Stir the mixture and divide into 15, then form into small logs. Break the remaining eggs into a bowl and whisk lightly. Put the breadcrumbs into another bowl. Dip each fofo in the beaten egg followed by the breadcrumb mixture. Chill for 20 minutes. Heat 1cm of oi…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 60 min)

### mdb-53044
**Portuguese barbecued pork (Febras assadas)** · Pork · area: Portuguese
- ingredients: 2 Pork, 200ml White Wine, 1/2 tsp Paprika, 2 Lemon, 1/2 Lemon Juice, Dash Olive Oil, To serve Mayonnaise, 1 kg Potato, For frying Vegetable Oil
- method (8 steps): Cut the tenderloins into 5 equal-size pieces leaving the tail ends a little longer. Take a clear plastic bag and slip one of the pieces in. Bash it into an escalope the size of a side-plate with a rolling pin and repeat with the remaining pieces. Put the wine, paprika, some salt and pepper and the juice of ½ a lemon in a bowl and add the pork. Leave to marinate for 20-30 minutes, while you get your barbecue to the stage where the coals are glowing but there are no flames. To make the chips, fill a basin with cool water and cut the potatoes into 3cm-thick chips. Soak them in the water for 5 min…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 9 ingredients, 60 min, technique: deep fr)

### mdb-53045
**Portuguese fish stew (Caldeirada de peixe)** · Seafood · area: Portuguese
- ingredients: 2 finely chopped Onion, 1 Diced Red Pepper, Small bunch Coriander, 1 small Red Chilli, 3 cloves Garlic, 400ml White Wine, Pinch Saffron, 1 Bay Leaf, 300g Potato, 400g Tomato, 600g Cod, 300g Squid, 8 Prawn, 500g Clam, 500g Mussel, 1 sliced Baguette
- method (4 steps): Heat a drizzle of oil in a large, deep-sided frying pan, and fry the onion and pepper on a medium heat until softened but not browned. Finely chop the coriander stalks (keep the leaves for later), and add to the pan with the chilli and chopped garlic. Fry for another few minutes. Add the wine, saffron and bay leaf and let it simmer until reduced by half. Add the potatoes, tomatoes, and 300ml water and bring to a gentle boil. Break up the tomatoes with a spoon on the side of the pan and simmer for 20-25 minutes until the potatoes are just tender, and the tomatoes have broken down. Season well, …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky', 'saucy', 'tender'] (0.50, keywords: flaky, saucy, tender)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 16 ingredients, 65 min)

### mdb-53047
**Moroccan Carrot Soup** · Vegetarian · area: Moroccan
- ingredients: 6 chopped Carrot, 1 sliced Onion, 4 Garlic, 1 tsp Ground Cumin, 1/2 tsp Coriander, 1 tbs Olive Oil, 1/4 tsp Garam Masala, 1 tsp Lemon Juice
- method (7 steps): Preheat oven to 180° C. Combine carrots, onion, garlic, cumin seeds, coriander seeds, salt and olive oil in a bowl and mix well. Transfer on a baking tray. Put the baking tray in preheated oven and roast for 10-12 minutes or till carrots soften. Remove from heat and cool. Grind the baked carrot mixture along with some water to make a smooth paste and strain in a bowl. Heat the carrot mixture in a non-stick pan. Add two cups of water and bring to a boil. Add garam masala powder and mix. Add salt and mix well. Remove from heat, add lemon juice and mix well. Serve hot.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 8 ingredients, 25 min)

### mdb-53048
**Mee goreng mamak** · Seafood · area: Malaysian
- ingredients: 50g Peanut, 15g Red Chilli, 10g Prawn, 5 tbs Vegetable Oil, 750 ml Water, 1/2 tbs Tamarind Paste, 250g Potato, 2 Red Onion, 4 Garlic, 30g Cabbage, 30g Chinese Broccoli, 1 Tofu, 1 tbs Soy Sauce, 4 Noodle, 1 Egg
- method (7 steps): Heat oil in a pan at medium heat. Then, add peanuts, dried chilies, dried shrimps and dhal. Fry the aromatics until fragrant. Remove from pan and leave aside. Blend fried ingredients with tamarind paste and water until fine. Then, sauté the blended ingredients in oil heated over low heat. Continue cooking until the oil separates from the paste and turns a darker shade. Skin and cut potatoes into small chunks and boil them in a pot of water until knife-tender. Once ready, remove them from the pot and leave aside. Discard water. Slice onion and fried tofu, mince garlic, cut some cabbage and Chin…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crispy', 'crunchy'] (0.50, keywords: chewy, crispy, crunchy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 15 ingredients, 40 min)

### mdb-53049
**Apam balik** · Dessert · area: Malaysian
- ingredients: 200ml Milk, 60ml Vegetable Oil, 2 Egg, 1600g Plain Flour, 3 tsp Baking Powder, 1/2 tsp Salt, 25g Butter, 45g Sugar, 3 tbs Peanut Butter
- method (4 steps): Mix milk, oil and egg together. Sift flour, baking powder and salt into the mixture. Stir well until all ingredients are combined evenly. Spread some batter onto the pan. Spread a thin layer of batter to the side of the pan. Cover the pan for 30-60 seconds until small air bubbles appear. Add butter, cream corn, crushed peanuts and sugar onto the pancake. Fold the pancake into half once the bottom surface is browned. Cut into wedges and best eaten when it is warm.
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 25 min)

### mdb-53050
**Ayam Percik** · Chicken · area: Malaysian
- ingredients: 6 Chicken Thigh, 16 Shallot, 1 1/2 Ginger, 6 Garlic, 8 Cayenne Pepper, 2 tbs Turmeric, 1 1/2 Ground Cumin, 1 1/2 Coriander, 1 1/2 Fennel, 2 tbs Tamarind Paste, 1 can Coconut Milk, 1 tsp Sugar, 1 cup Water
- method (7 steps): In a blender, add the ingredients for the spice paste and blend until smooth. Over medium heat, pour the spice paste in a skillet or pan and fry for 10 minutes until fragrant. Add water or oil 1 tablespoon at a time if the paste becomes too dry. Don't burn the paste. Lower the fire slightly if needed. Add the cloves, cardamom, tamarind pulp, coconut milk, water, sugar and salt. Turn the heat up and bring the mixture to boil. Turn the heat to medium low and simmer for 10 minutes. Stir occasionally. It will reduce slightly. This is the marinade/sauce, so taste and adjust seasoning if necessary. …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['hearty', 'light'] (0.50, keywords/category: hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 13 ingredients, 565 min)

### mdb-53051
**Nasi lemak** · Seafood · area: Malaysian
- ingredients: 2 cups Coconut Milk, 2 cups Water, 1/4 tsp Ginger Paste, 1 Ginger, 1 Bay Leaf, 2 cups Rice, 4 Egg, 1 Cucumber, 1 cup Peanut, 4 oz Anchovy Fillet, 2 tbs Vegetable Oil, 1 Onion, 3 cloves Garlic, 3 Shallot, 2 tsp Chilli Powder, 4 oz Anchovy Fillet, 3 tbs Sugar, 1/3 cup Tamarind Paste
- method (6 steps): In a medium saucepan over medium heat, stir together coconut milk, water, ground ginger, ginger root, salt, bay leaf, and rice. Cover, and bring to a boil. Reduce heat, and simmer for 20 to 30 minutes, or until done. Place eggs in a saucepan, and cover with cold water. Bring water to a boil, and immediately remove from heat. Cover, and let eggs stand in hot water for 10 to 12 minutes. Remove eggs from hot water, cool, peel and slice in half. Slice cucumber. Meanwhile, in a large skillet or wok, heat 1 cup vegetable oil over medium-high heat. Stir in peanuts and cook briefly, until lightly brow…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 18 ingredients, 95 min)

### mdb-53052
**Roti john** · Beef · area: Malaysian
- ingredients: 1/4 lb Beef Mince, 1 Onion, 3 Egg, 1 tbs Red Chilli, 1/2 Baguette, To taste Salt, To taste Black Pepper, Top Mayonnaise
- method (7 steps): Mix all the ingredients in a bowl. Heat a pan or griddle with a little vegetable oil. Pour the mixture onto the pan and place a piece of open-faced baguette on top. Press on the bread with a spatula and grill for 2 minutes. Turn the bread over to make it a little crispy. Remove from pan and cut the bread into small portions. Add mayonnaise and/or Sambal before cutting the sandwich (optional).
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 8 ingredients, 20 min)

### mdb-53054
**Seri muka kuih** · Dessert · area: Malaysian
- ingredients: 400g Rice, 150ml Coconut Milk, 100ml Water, 1 tsp Salt, 5 tbs Cornflour, 3 tbs Plain Flour, 3 Egg, 200ml Coconut Cream, 140g Sugar
- method (12 steps): Soak glutinous rice with water for at least 1 ½ hours prior to using. Drain. Prepare a 9-inch round or square cake pan and spray with cooking spray or line with plastic wrap. Mix coconut milk, water, salt and the rice. Pour it into cake pan, topped with the pandan knots. Steam for 30 minutes. After 30 minutes, fluff up the rice and remove pandan knots. Then, using a greased spatula, flatten the steamed rice. Make sure there are no holes/air bubbles and gaps in the rice, especially the sides. Steam for another 10 minutes. Combine pandan juice, coconut milk, all purpose flour, cornflour, and sug…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'crunchy'] (0.50, keywords: chewy, creamy, crunchy)
- `moods` rule: ['indulgent', 'light'] (0.50, keywords/category: indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 9 ingredients, 225 min, technique: bain)
