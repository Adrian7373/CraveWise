# AI tagging batch 001

Write `tools/seedgen/tags/ai/batch-001.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52770
**Spaghetti Bolognese** · Beef · area: Italian
- ingredients: 2 Onion, 1tbsp Olive Oil, 1 clove Garlic, 500g Beef Mince, 90g Mushroom, 1tsp Dried Oregano, 400g can Tomato, 300ml Beef Stock, 1tbsp Tomato Puree, 1tbsp Worcestershire Sauce, 350g Spaghetti, Topping Parmesan
- method (3 steps): Put the onion and oil in a large pan and fry over a fairly high heat for 3-4 mins. Add the garlic and mince and fry until they both brown. Add the mushrooms and herbs, and cook for another couple of mins. Stir in the tomatoes, beef stock, tomato ketchup or purée, Worcestershire sauce and seasoning. Bring to the boil, then reduce the heat, cover and simmer, stirring occasionally, for 30 mins. Meanwhile, cook the spaghetti in a large pan of boiling, salted water, according to packet instructions. Drain well, run hot water through it, put it back in the pan and add a dash of olive oil, if you lik…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 60 min)

### mdb-52844
**Lasagne** · Pasta · area: Italian
- ingredients: 1 tblsp Olive Oil, 2 Bacon, 1 finely chopped Onion, 1 Stick Celery, 1 medium Carrot, 2 cloves chopped Garlic, 500g Beef Mince, 1 tbls Tomato Puree, 800g Chopped Tomatoes, 1 tblsp Honey, 500g Lasagne Sheet, 400ml Creme Fraiche, 125g Mozzarella, 50g Parmesan, Topping Basil
- method (6 steps): Heat the oil in a large saucepan. Use kitchen scissors to snip the bacon into small pieces, or use a sharp knife to chop it on a chopping board. Add the bacon to the pan and cook for just a few mins until starting to turn golden. Add the onion, celery and carrot, and cook over a medium heat for 5 mins, stirring occasionally, until softened. Add the garlic and cook for 1 min, then tip in the mince and cook, stirring and breaking it up with a wooden spoon, for about 6 mins until browned all over. Stir in the tomato purée and cook for 1 min, mixing in well with the beef and vegetables. Tip in the…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 15 ingredients, 95 min)

### mdb-53014
**Pizza Express Margherita** · Miscellaneous · area: Italian
- ingredients: 150ml Water, 1 tsp Sugar, 15g Yeast, 225g Plain Flour, 1 1/2 tsp Salt, Drizzle Olive Oil, 80g Passata, 70g Mozzarella, Peeled and Sliced Oregano, Leaves Basil, Pinch Black Pepper
- method (12 steps): Preheat the oven to 230°C. Add the sugar and crumble the fresh yeast into warm water. Allow the mixture to stand for 10 – 15 minutes in a warm place (we find a windowsill on a sunny day works best) until froth develops on the surface. Sift the flour and salt into a large mixing bowl, make a well in the middle and pour in the yeast mixture and olive oil. Lightly flour your hands, and slowly mix the ingredients together until they bind. Generously dust your surface with flour. Throw down the dough and begin kneading for 10 minutes until smooth, silky and soft. Place in a lightly oiled, non-stick…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 11 ingredients, 55 min, technique: knead)

### mdb-52803
**Beef Wellington** · Beef · area: British
- ingredients: 400g Mushroom, 1-2tbsp English Mustard, Dash Olive Oil, 750g piece Beef Fillet, 6-8 slices Parma Ham, 500g Puff Pastry, Dusting Plain Flour, 2 Beaten Egg Yolk
- method (8 steps): Put the mushrooms into a food processor with some seasoning and pulse to a rough paste. Scrape the paste into a pan and cook over a high heat for about 10 mins, tossing frequently, to cook out the moisture from the mushrooms. Spread out on a plate to cool. Heat in a frying pan and add a little olive oil. Season the beef and sear in the hot pan for 30 secs only on each side. (You don't want to cook it at this stage, just colour it). Remove the beef from the pan and leave to cool, then brush all over with the mustard. Lay a sheet of cling film on a work surface and arrange the Parma ham slices o…
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['comfort', 'festive'] (0.50, keywords/category: comfort, festive)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 8 ingredients, 115 min)

### mdb-52802
**Fish pie** · Seafood · area: British
- ingredients: 900g Potato, 2 tbsp Olive Oil, 600ml Milk, 800g White Fish, 1 tbsp Plain Flour, Grating Ground Nutmeg, 3 tbsp Double Cream, 200g Jerusalem Artichoke, 1 finely sliced Leek, 200g peeled raw Prawn, Large handful Parsley, Handful Dill, Grated zest of 1 Lemon, 25g grated Gruyere, Juice of 1 Lemon
- method (6 steps): Put the potatoes in a large pan of cold salted water and bring to the boil. Lower the heat, cover, then simmer gently for 15 minutes until tender. Drain, then return to the pan over a low heat for 30 seconds to drive off any excess water. Mash with 1 tbsp olive oil, then season. Meanwhile put the milk in a large sauté pan, add the fish and bring to the boil. Remove from the heat, cover and stand for 3 minutes. Remove the fish (reserving the milk) and pat dry with kitchen paper, then gently flake into an ovenproof dish, discarding the skin and any bones. Heat the remaining oil in a pan, stir in…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 15 ingredients, 90 min)

### mdb-52896
**Full English Breakfast** · Breakfast · area: British
- ingredients: 4 Sausage, 4 Bacon, 4 Mushroom, 3 Tomato, 2 sliced Morcilla, 2 Egg, 1 Slice Bread, 100g Baked Bean
- method (10 steps): Heat the flat grill plate over a low heat, on top of 2 rings/flames if it fits, and brush sparingly with light olive oil. Cook the sausages first. Add the sausages to the hot grill plate/the coolest part if there is one and allow to cook slowly for about 15-20 minutes, turning occasionally, until golden. After the first 10 minutes, increase the heat to medium before beginning to cook the other ingredients. If you are struggling for space, completely cook the sausages and keep hot on a plate in the oven. Snip a few small cuts into the fatty edge of the bacon. Place the bacon straight on to the …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'flaky', 'saucy'] (0.50, keywords: crispy, flaky, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 8 ingredients, 65 min)

### mdb-52883
**Sticky Toffee Pudding** · Dessert · area: British
- ingredients: 100g Butter, 175g Muscovado Sugar, 2 large Egg, 225g Self Raising Flour, 1 tsp Baking Powder, 1 tsp Bicarbonate of Soda, 3 tbs Black Treacle, 275ml Milk, to serve Double Cream, 100g Butter, 125g Muscovado Sugar, 1 tbs Black Treacle, 300ml Double Cream, 1 tsp Vanilla Extract
- method (5 steps): Preheat the oven to 180C/160C Fan/Gas. Butter a wide shallow 1.7-litre/3-pint ovenproof dish. Put the butter, sugar, eggs, flour, baking powder, bicarbonate of soda and treacle into a mixing bowl. Beat using an electric handheld whisk for about 30 seconds or until combined. Pour in the milk gradually and whisk again until smooth. Pour into the prepared dish. Bake for 35–40 minutes or until well risen and springy in the centre. To make the sauce, put all the ingredients into a saucepan and stir over a low heat until the sugar has dissolved and the butter has melted. Bring to the boil, stirring …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 14 ingredients, 65 min)

### mdb-52904
**Beef Bourguignon** · Beef · area: France
- ingredients: 3 tsp Goose Fat, 600g Beef Shin, 100g Bacon, 350g Shallot, 250g Mushroom, 2 sliced Garlic, 1 Bouquet Garni, 1 tbs Tomato Puree, 750 ml Red Wine, 600g Celeriac, 2 tbs Olive Oil, sprigs of fresh Thyme, sprigs of fresh Rosemary, 2 Bay Leaf, 4 Cardamom
- method (10 steps): Heat a large casserole pan and add 1 tbsp goose fat. Season the beef and fry until golden brown, about 3-5 mins, then turn over and fry the other side until the meat is browned all over, adding more fat if necessary. Do this in 2-3 batches, transferring the meat to a colander set over a bowl when browned. In the same pan, fry the bacon, shallots or pearl onions, mushrooms, garlic and bouquet garni until lightly browned. Mix in the tomato purée and cook for a few mins, stirring into the mixture. This enriches the bourguignon and makes a great base for the stew. Then return the beef and any drai…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 10 steps, 15 ingredients, 275 min, technique: caramelis)

### mdb-52832
**Coq au vin** · Chicken · area: France
- ingredients: 1½ tbsp Olive Oil, 3 rashers (100g) chopped dry-cured Bacon, 12 small Shallot, 2 (460g) Chicken Leg, 4 (650g) Chicken Thigh, 2 (280g) Chicken Breast, 3 finely chopped Garlic, 3 tbsp Brandy, 600ml Red Wine, 150ml Chicken Stock, 2 tsp Tomato Puree, 3 sprigs Thyme, 2 sprigs Rosemary, 2 Bay Leaf, garnish Parsley, 250g Mushroom, 2 tbsp Plain Flour, 1 tsp Butter
- method (9 steps): Heat 1 tbsp of the oil in a large, heavy-based saucepan or flameproof dish. Tip in the bacon and fry until crisp. Remove and drain on kitchen paper. Add the shallots to the pan and fry, stirring or shaking the pan often, for 5-8 mins until well browned all over. Remove and set aside with the bacon. Pat the chicken pieces dry with kitchen paper. Pour the remaining oil into the pan, then fry half the chicken pieces, turning regularly, for 5-8 mins until well browned. Remove, then repeat with the remaining chicken. Remove and set aside. Scatter in the garlic and fry briefly, then, with the heat m…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 18 ingredients, 110 min)

### mdb-52908
**Ratatouille** · Vegetarian · area: France
- ingredients: 2 large Aubergine, 4 Courgette, 2 Yellow Pepper, 4 large Tomato, 5 tbs Olive Oil, Bunch Basil, 1 medium Onion, 3 finely chopped Garlic, 1 tsp Red Wine Vinegar, 1 tsp Sugar
- method (4 steps): Cut the aubergines in half lengthways. Place them on the board, cut side down, slice in half lengthways again and then across into 1.5cm chunks. Cut off the courgettes ends, then across into 1.5cm slices. Peel the peppers from stalk to bottom. Hold upright, cut around the stalk, then cut into 3 pieces. Cut away any membrane, then chop into bite-size chunks. Score a small cross on the base of each tomato, then put them into a heatproof bowl. Pour boiling water over the tomatoes, leave for 20 secs, then remove. Pour the water away, replace the tomatoes and cover with cold water. Leave to cool, t…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 10 ingredients, 55 min)

### mdb-52903
**French Onion Soup** · Side · area: France
- ingredients: 50g Butter, 1 tbs Olive Oil, 1 kg Onion, 1 tsp Sugar, 4 sliced Garlic, 2 tbs Plain Flour, 250ml White Wine, 1L Beef Stock, 4 sliced Bread, 140g Gruyere
- method (3 steps): Melt the butter with the oil in a large heavy-based pan. Add the onions and fry with the lid on for 10 mins until soft. Sprinkle in the sugar and cook for 20 mins more, stirring frequently, until caramelised. The onions should be really golden, full of flavour and soft when pinched between your fingers. Take care towards the end to ensure that they don’t burn. Add the garlic for the final few mins of the onions’ cooking time, then sprinkle in the flour and stir well. Increase the heat and keep stirring as you gradually add the wine, followed by the hot stock. Cover and simmer for 15-20 mins. T…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 65 min, technique: caramelis)

### mdb-52909
**Tarte Tatin** · Dessert · area: France
- ingredients: 300g Puff Pastry, Dusting Plain Flour, 6 Apple, 100g Sugar, 85g Butter, to serve Creme Fraiche
- method (6 steps): Roll the pastry to a 3mm-thick round on a lightly floured surface and cut a 24cm circle, using a plate as a guide. Lightly prick all over with a fork, wrap in cling film on a baking sheet and freeze while preparing the apples. Heat oven to 180C/160C fan/gas. Peel, quarter and core the apples. Put the sugar in a flameproof 20cm ceramic Tatin dish or a 20cm ovenproof heavy-based frying pan and place over a medium-high heat. Cook the sugar for 5-7 mins to a dark amber caramel syrup that’s starting to smoke, then turn off the heat and stir in the 60g diced chilled butter. To assemble the Tarte Tat…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'flaky'] (0.50, keywords: creamy, crispy, flaky)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 6 ingredients, 160 min)

### mdb-52905
**Chocolate Souffle** · Dessert · area: France
- ingredients: 142ml Single Cream, 25g Sugar, 100g Dark Chocolate, 25g Butter, drizzle Butter, 50g Sugar, 175g Dark Chocolate, 2 tbs Double Cream, 4 Egg Yolk, 5 Egg White, 2 tbs Double Cream, to serve Icing Sugar
- method (5 steps): Heat oven to 220C/fan 200C/gas 7 and place a baking tray on the top shelf. For the sauce, heat the cream and sugar until boiling. Remove from the heat, stir in the chocolate and butter until melted, then keep warm. Brush 6 x 150ml ramekins with melted butter, sprinkle with the 2 tbsp caster sugar, then tip out any excess. Melt the chocolate and cream in a bowl over a pan of simmering water, cool, then mix in the egg yolks. Whisk the egg whites until they hold their shape, then add the sugar, 1 tbsp at a time, whisking back to the same consistency. Mix a spoonful into the chocolate, then gently…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy', 'saucy'] (0.50, keywords: creamy, fluffy, saucy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 35 min, technique: souffl)

### mdb-52806
**Tandoori chicken** · Chicken · area: India
- ingredients: 2 Juice Lemon, 4 tsp Paprika, 2 finely chopped Red Onion, 16 skinnless Chicken Thigh, For brushing Vegetable Oil, 300ml Greek Yogurt, large piece Ginger, 4 Garlic, ¾ tsp Garam Masala, ¾ tsp Ground Cumin, ½ tsp Chilli Powder, ¼ tsp Turmeric
- method (3 steps): Mix the lemon juice with the paprika and red onions in a large shallow dish. Slash each chicken thigh three times, then turn them in the juice and set aside for 10 mins. Mix all of the marinade ingredients together and pour over the chicken. Give everything a good mix, then cover and chill for at least 1 hr. This can be done up to a day in advance. Heat the grill. Lift the chicken pieces onto a rack over a baking tray. Brush over a little oil and grill for 8 mins on each side or until lightly charred and completely cooked through.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 105 min)

### mdb-52808
**Lamb Rogan josh** · Lamb · area: India
- ingredients: 2 quartered Onion, 4 tbsp Vegetable Oil, 4 cloves Garlic, Thumb sized peeled and very finely grated Ginger, 2 tbsp Madras Paste, 2 tsp Paprika, 1 Cinnamon Stick, 6 bashed to break shells Cardamom, 4 Clove, 2 Bay Leaf, 1 tbsp Tomato Puree, 1kg cubed Lamb, 150ml Greek Yogurt, Garnish chopped Coriander
- method (3 steps): Put the onions in a food processor and whizz until very finely chopped. Heat the oil in a large heavy-based pan, then fry the onion with the lid on, stirring every now and then, until it is really golden and soft. Add the garlic and ginger, then fry for 5 mins more. Tip the curry paste, all the spices and the bay leaves into the pan, with the tomato purée. Stir well over the heat for about 30 secs, then add the meat and 300ml water. Stir to mix, turn down the heat, then add the yogurt. Cover the pan, then gently simmer for 40-60 mins until the meat is tender and the sauce nice and thick. Serve…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 14 ingredients, 80 min)

### mdb-52865
**Matar Paneer** · Vegetarian · area: India
- ingredients: 1 tbls Vegetable Oil, 225g Paneer, 2 Ginger, 1 tsp Ground Cumin, 1 tsp Turmeric, 1 tsp Coriander, 1 Green Chilli, 4 large Tomato, 150g Pea, 1 tsp Garam Masala, Small bunch Coriander, to serve Naan Bread
- method (3 steps): Heat the oil in a frying pan over high heat until it’s shimmering hot. Add the paneer, then turn the heat down a little. Fry until it starts to brown at the edges, then turn it over and brown on each side – the paneer will brown faster than you think, so don’t walk away. Remove the paneer from the pan and drain on kitchen paper. Put the ginger, cumin, turmeric, ground coriander and chilli in the pan, and fry everything for 1 min. Add the tomatoes, mashing them with the back of a spoon and simmer everything for 5 mins until the sauce smells fragrant. Add a splash of water if it’s too thick. Sea…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 35 min)

### mdb-52805
**Lamb Biryani** · Lamb · area: India
- ingredients: 12 Cashew, ½ tbsp Khus Khus, ½ tbsp Cumin Seed, 3 sliced thinly Onion, 2 tsp Ginger Garlic Paste, 4 whole Garlic, Leaves Mint, Leaves Coriander, ½ tsp dissolved in ½ cup warm milk Saffron, 2 tbsp Ghee, 2 Cups Basmati Rice, ½ cup Yogurt, 1 tbsp Cumin Seed, ½ Bay Leaf, 1 thin piece Cinnamon, 3 Clove, 2 Cardamom, 1 lb Lamb, 1 tsp Chilli Powder, 1 tbsp Biryani Masala
- method (15 steps): Grind the cashew, poppy seeds and cumin seeds into a smooth paste, using as little water as possible. Set aside. Deep fry the sliced onions when it is hot. Don’t overcrowd the oil. When the onions turn light brown, remove from oil and drain on paper towel. The fried onion will crisp up as it drains. Also fry the cashewnuts till golden brown. Set aside. Wash the rice and soak in water for twenty minutes. Meanwhile, take a big wide pan, add oil in medium heat, add the sliced onions, add the blended paste, to it add the green chillies, ginger garlic paste and garlic and fry for a minute. Then add…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy', 'saucy'] (0.50, keywords: crispy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-52945
**Kung Pao Chicken** · Chicken · area: Chinese
- ingredients: 2 tbs Sake, 2 tbs Soy Sauce, 2 tbs Sesame Oil, 2 tbs Cornflour, 2 tbs Water, 500g Chicken, 1 tbs Chilli Powder, 1 tsp Rice Vinegar, 1 tbs Brown Sugar, 4 Chopped Spring Onion, 6 cloves Garlic, 220g Water Chestnut, 100g Peanut
- method (4 steps): Combine the sake or rice wine, soy sauce, sesame oil and cornflour dissolved in water. Divide mixture in half. In a glass dish or bowl, combine half of the sake mixture with the chicken pieces and toss to coat. Cover dish and place in refrigerator for about 30 minutes. In a medium frying pan, combine remaining sake mixture, chillies, vinegar and sugar. Mix together and add spring onion, garlic, water chestnuts and peanuts. Heat sauce slowly over medium heat until aromatic. Meanwhile, remove chicken from marinade and sauté in a large frying pan until juices run clear. When sauce is aromatic, ad…
- `textures` rule: ['crunchy', 'saucy'] (0.50, keywords: crunchy, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Chicken guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 13 ingredients, 85 min)

### mdb-52947
**Ma Po Tofu** · Beef · area: Chinese
- ingredients: 450g Tofu, 100g Beef Mince, 1/2 tbs Sesame Oil, 1 1/2 tsp Doubanjiang, 1/2 tsp Fermented Black Bean, 1 tbs Black Pepper, 1/2 tsp Salt, 1/2 tsp Sichuan Pepper, 1 tbs Soy Sauce, 400ml Water, 2 tbs Olive Oil, 2 chopped Spring Onion, 4 Spring Onion, 2 cloves chopped Garlic, 4 sliced Ginger, 2 1/2 tbs Water, 1 tbs Cornflour
- method (9 steps): Add a small pinch of salt and sesame oil to minced beef. Mix well and set aside. Mix 1 tablespoon of cornstarch with 2 and ½ tablespoons of water in a small bowl to make water starch. Cut tofu into square cubes (around 2cms). Bring a large amount of water to a boil and then add a pinch of salt. Slide the tofu in and cook for 1 minute. Move out and drain. Get a wok and heat up around 2 tablespoons of oil, fry the minced meat until crispy. Transfer out beef out and leave the oil in. Fry doubanjiang for 1 minute over slow fire and then add garlic, scallion white, ginger and fermented black beans …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'crispy', 'saucy'] (0.50, keywords: brothy, crispy, saucy)
- `moods` rule: ['hearty', 'light'] (0.50, keywords/category: hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 17 ingredients, 55 min)

### mdb-52948
**Wontons** · Pork · area: Chinese
- ingredients: 1lb Pork, 3 chopped Garlic, 1 tsp Ginger, 1 tbs Soy Sauce, 1 tsp Sesame Oil, 3 finely chopped Carrot, 3 finely chopped Celery, 6 chopped Spring Onion, 1 Packet Wonton Skin, Fry Vegetable Oil, Bottle Water
- method (8 steps): Combine pork, garlic, ginger, soy sauce, sesame oil, and vegetables in a bowl. Separate wonton skins. Place a heaping teaspoon of filling in the center of the wonton. Brush water on 2 borders of the skin, covering 1/4 inch from the edge. Fold skin over to form a triangle, sealing edges. Pinch the two long outside points together. Heat oil to 450 degrees and fry 4 to 5 at a time until golden. Drain and serve with sauce.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Pork guess)
- `difficulty` rule: 'easy' (0.55, 8 steps, 11 ingredients, 50 min)
