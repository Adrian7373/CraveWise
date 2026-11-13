# AI tagging batch 007

Write `tools/seedgen/tags/ai/batch-007.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52867
**Vegetarian Chilli** · Vegetarian · area: British
- ingredients: 400g Roasted Vegetable, 1 can Kidney Bean, 1 can Chopped Tomatoes, 1 Packet Mixed Grain
- method (2 steps): Heat oven to 200C/180C fan/ gas. Cook the vegetables in a casserole dish for 15 mins. Tip in the beans and tomatoes, season, and cook for another 10-15 mins until piping hot. Heat the pouch in the microwave on High for 1 min and serve with the chilli.
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 4 ingredients, 40 min, technique: piping)

### mdb-52868
**Kidney Bean Curry** · Vegetarian · area: India
- ingredients: 1 tbls Vegetable Oil, 1 finely chopped Onion, 2 cloves chopped Garlic, 1 part Ginger, 1 Packet Coriander, 1 tsp Ground Cumin, 1 tsp Paprika, 2 tsp Garam Masala, 400g Chopped Tomatoes, 400g Kidney Bean, to serve Basmati Rice
- method (3 steps): Heat the oil in a large frying pan over a low-medium heat. Add the onion and a pinch of salt and cook slowly, stirring occasionally, until softened and just starting to colour. Add the garlic, ginger and coriander stalks and cook for a further 2 mins, until fragrant. Add the spices to the pan and cook for another 1 min, by which point everything should smell aromatic. Tip in the chopped tomatoes and kidney beans in their water, then bring to the boil. Turn down the heat and simmer for 15 mins until the curry is nice and thick. Season to taste, then serve with the basmati rice and the coriander…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 45 min)

### mdb-52869
**Tahini Lentils** · Vegetarian · area: Moroccan
- ingredients: 50g Tahini, zest and juice of 1 Lemon, 2 tblsp Olive Oil, 1 chopped Red Onion, 1 clove peeled crushed Garlic, 1 thinly sliced Yellow Pepper, 200g Green Bean, 1 sliced Courgette, 100g shredded Kale, 250g pack Lentil
- method (3 steps): In a jug, mix the tahini with the zest and juice of the lemon and 50ml of cold water to make a runny dressing. Season to taste, then set aside. Heat the oil in a wok or large frying pan over a medium-high heat. Add the red onion, along with a pinch of salt, and fry for 2 mins until starting to soften and colour. Add the garlic, pepper, green beans and courgette and fry for 5 min, stirring frequently. Tip in the kale, lentils and the tahini dressing. Keep the pan on the heat for a couple of mins, stirring everything together until the kale is wilted and it’s all coated in the creamy dressing.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 30 min)

### mdb-52870
**Chickpea Fajitas** · Vegetarian · area: Mexican
- ingredients: 400g Chickpea, 1 tblsp Olive Oil, pinch Paprika, 2 small cut chunks Tomato, 1 finely sliced Red Onion, 2 tsp Red Wine Vinegar, 1 Avocado, Juice of 1 Lime, Chopped Lime, 100g Sour Cream, 2 tsp Harissa Spice, 4 Corn Tortilla, to serve Coriander
- method (4 steps): Heat oven to 200C/180C fan/gas 6 and line a baking tray with foil. Drain the chickpeas, pat dry and tip onto the prepared baking tray. Add the oil and paprika, toss to coat, then roast for 20-25 mins until browned and crisp, shaking halfway through cooking. Meanwhile, put the tomatoes and onion in a small bowl with the vinegar and set aside to pickle. Put the avocado in another bowl and mash with a fork, leaving some larger chunks. Stir in the lime juice and season well. Mix the soured cream with the harissa and set aside until ready to serve. Heat a griddle pan until nearly smoking. Add the t…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy'] (0.50, keywords: creamy, crispy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 13 ingredients, 45 min)

### mdb-52871
**Yaki Udon** · Vegetarian · area: Japanese
- ingredients: 250g Udon Noodle, 2 tbs Sesame Oil, 1 sliced Onion, 0.25 Cabbage, 10 Shiitake Mushroom, 4 Spring Onion, 4 tbsp Mirin, 2 tbs Soy Sauce, 1 tblsp Sugar, 1 tblsp Worcestershire Sauce
- method (3 steps): Boil some water in a large saucepan. Add 250ml cold water and the udon noodles. (As they are so thick, adding cold water helps them to cook a little bit slower so the middle cooks through). If using frozen or fresh noodles, cook for 2 mins or until al dente; dried will take longer, about 5-6 mins. Drain and leave in the colander. Heat 1 tbsp of the oil, add the onion and cabbage and sauté for 5 mins until softened. Add the mushrooms and some spring onions, and sauté for 1 more min. Pour in the remaining sesame oil and the noodles. If using cold noodles, let them heat through before adding the …
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'saucy'] (0.50, keywords: chewy, saucy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 10 ingredients, 35 min, technique: piping)

### mdb-52873
**Beef Dumpling Stew** · Beef · area: British
- ingredients: 2 tbs Olive Oil, 25g Butter, 750g Beef, 2 tblsp Plain Flour, 2 cloves minced Garlic, 175g Onion, 150g Celery, 150g Carrot, 2 chopped Leek, 200g Swede, 150ml Red Wine, 500g Beef Stock, 2 Bay Leaf, 3 tbs Thyme, 3 tblsp chopped Parsley, 125g Plain Flour, 1 tsp Baking Powder, 60g Suet, Splash Water
- method (11 steps): Preheat the oven to 180C/350F/Gas 4. For the beef stew, heat the oil and butter in an ovenproof casserole and fry the beef until browned on all sides. Sprinkle over the flour and cook for a further 2-3 minutes. Add the garlic and all the vegetables and fry for 1-2 minutes. Stir in the wine, stock and herbs, then add the Worcestershire sauce and balsamic vinegar, to taste. Season with salt and freshly ground black pepper. Cover with a lid, transfer to the oven and cook for about two hours, or until the meat is tender. For the dumplings, sift the flour, baking powder and salt into a bowl. Add th…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy', 'saucy'] (0.50, keywords: creamy, fluffy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 19 ingredients, 300 min)

### mdb-52874
**Beef and Mustard Pie** · Beef · area: British
- ingredients: 1kg Beef, 2 tbs Plain Flour, 2 tbs Vegetable Oil, 200ml Red Wine, 400ml Beef Stock, 1 finely sliced Onion, 2 chopped Carrot, 3 sprigs Thyme, 2 tbs Mustard, 2 free-range Egg Yolk, 400g Puff Pastry, 300g Green Bean, 25g Butter, pinch Salt, pinch Black Pepper
- method (13 steps): Preheat the oven to 150C/300F/Gas 2. Toss the beef and flour together in a bowl with some salt and black pepper. Heat a large casserole until hot, add half of the rapeseed oil and enough of the beef to just cover the bottom of the casserole. Fry until browned on each side, then remove and set aside. Repeat with the remaining oil and beef. Return the beef to the pan, add the wine and cook until the volume of liquid has reduced by half, then add the stock, onion, carrots, thyme and mustard, and season well with salt and pepper. Cover with a lid and place in the oven for two hours. Remove from th…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky', 'saucy'] (0.50, keywords: flaky, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 13 steps, 15 ingredients, 185 min, technique: crimp)

### mdb-52875
**Chicken Ham and Leek Pie** · Chicken · area: British
- ingredients: 450ml Chicken Stock, 3 Chicken Breast, 75g Butter, 2 sliced Leek, 2 cloves minced Garlic, 50g Plain Flour, 200ml Milk, 3 tbs White Wine, 150ml Double Cream, 150g Ham, spinkling Salt, pinch Black Pepper, 350g Plain Flour, 200g Butter, 1 Egg, 1 tbls Water, 1 Egg
- method (11 steps): Heat the chicken stock in a lidded saucepan. Add the chicken breast and bring to a low simmer. Cover with a lid and cook for 10 minutes. Remove the chicken breasts from the water with tongs and place on a plate. Pour the cooking liquor into a large jug. Melt 25g/1oz of the butter in a large heavy-based saucepan over a low heat. Stir in the leeks and fry gently for two minutes, stirring occasionally until just softened. Add the garlic and cook for a further minute. Add the remaining butter and stir in the flour as soon as the butter has melted. Cook for 30 seconds, stirring constantly. Slowly p…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky', 'saucy'] (0.50, keywords: creamy, flaky, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 17 ingredients, 90 min, technique: piping)

### mdb-52876
**Minced Beef Pie** · Beef · area: British
- ingredients: 2 tbs Vegetable Oil, 500g Beef Mince, 1 chopped Onion, 1 tbls Tomato Puree, 1 ½ tbsp Plain Flour, 75g Mushroom, 250ml Beef Stock, Dash Worcestershire Sauce, 400g Shortcrust Pastry, 1 Egg Yolk
- method (8 steps): Preheat the oven to 200C/400F/Gas 6. Heat the oil in a deep frying pan and fry the beef mince for 4-5 minutes, breaking it up with a wooden spoon as it browns. Add the onion and cook for 2-3 minutes, then stir in the tomato purée and cook for 2-3 more minutes. Stir in the flour and cook for a further minute, then add the chopped mushrooms, the stout or beef stock and a couple of dashes of Worcestershire sauce. Bring to the boil, then reduce the heat, cover the pan with a lid and leave to simmer for 20 minutes. Set aside and leave to cool, then turn the meat mixture into a one litre pie dish. R…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'flaky', 'saucy'] (0.50, keywords: crispy, flaky, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 10 ingredients, 80 min, technique: deep fr, roll out the pastry)

### mdb-52877
**Lamb and Potato pie** · Lamb · area: British
- ingredients: 500g Lamb Shoulder, 1 tbls Plain Flour, Dash Vegetable Oil, 1 sliced Onion, 2 sliced Carrot, 350ml/12fl Vegetable Stock, 500g Potato, 450g Shortcrust Pastry, To Glaze Egg
- method (9 steps): Dust the meat with flour to lightly coat. Heat enough vegetable oil in a large saucepan to fill the base, and fry the onion and meat until lightly browned. Season with salt and pepper. Add the carrots, stock and more seasoning to taste. Bring to the boil, cover and reduce the heat to a simmer. Simmer for at least an hour or until the meat is tender. Take your time cooking the meat, the longer you leave it to cook, the better the flavour will be. Preheat the oven to 180C/350F/Gas 4. Add the drained potato cubes to the lamb. Turn the mixture into a pie dish or casserole and cover with the shortc…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky', 'saucy'] (0.50, keywords: flaky, saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 9 ingredients, 120 min)

### mdb-52878
**Beef and Oyster pie** · Beef · area: British
- ingredients: 900g Beef, 3 tbs Olive Oil, 3 Shallot, 2 cloves minced Garlic, 125g Bacon, 1 tbs chopped Thyme, 2 Bay Leaf, 330ml Stout, 400ml Beef Stock, 2 tbs Cornflour, 8 Oyster, 400g Plain Flour, pinch Salt, 250g Butter, To Glaze Egg
- method (9 steps): Season the beef cubes with salt and black pepper. Heat a tablespoon of oil in the frying pan and fry the meat over a high heat. Do this in three batches so that you don’t overcrowd the pan, transferring the meat to a large flameproof casserole dish once it is browned all over. Add extra oil if the pan seems dry. In the same pan, add another tablespoon of oil and cook the shallots for 4-5 minutes, then add the garlic and fry for 30 seconds. Add the bacon and fry until slightly browned. Transfer the onion and bacon mixture to the casserole dish and add the herbs. Preheat the oven to 180C/350F/Ga…
- `textures` rule: ['flaky', 'saucy'] (0.50, keywords: flaky, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-52879
**Chicken Parmentier** · Chicken · area: France
- ingredients: 1.5kg Potato, 30g Butter, 5 tblsp Double Cream, 2 Egg Yolk, 30g Butter, 7 Shallot, 3 chopped Carrot, 2 sticks Celery, 1 finely chopped Garlic, 4 tbsp White Wine, 1 tbls Tomato Puree, 400g Chopped Tomatoes, 350ml Chicken Stock, 600g Chicken, 16 Black Olive, 2 tbs Parsley, 50g Gruyere
- method (4 steps): For the topping, boil the potatoes in salted water until tender. Drain and push through a potato ricer, or mash thoroughly. Stir in the butter, cream and egg yolks. Season and set aside. For the filling, melt the butter in a large pan. Add the shallots, carrots and celery and gently fry until soft, then add the garlic. Pour in the wine and cook for 1 minute. Stir in the tomato purée, chopped tomatoes and stock and cook for 10–15 minutes, until thickened. Add the shredded chicken, olives and parsley. Season to taste with salt and pepper. Preheat the oven to 180C/160C Fan/Gas 4. Put the filling …
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 17 ingredients, 80 min, technique: piping)

### mdb-52880
**McSinghs Scotch pie** · Lamb · area: British
- ingredients: 2 tsp Ground Cumin, 1 tbs Vegetable Oil, 2 finely chopped Red Onion, 6 Garlic, 3 finely chopped Green Chilli, 1 finely chopped Red Pepper, 1 tsp Ground Nutmeg, 2 tsp Coriander, 1kg Lamb Mince, 1 tsp Black Pepper, 3 tbs Coriander, 340g Plain Flour, ½ tsp Salt, 90 ml Milk, 150g Lard, Beaten Egg Yolk
- method (10 steps): Heat a large frying pan and toast the cumin seeds for a few minutes, then set aside. Heat the oil in the same pan and fry the onion, garlic, chilli, pepper and a good pinch of salt for around eight minutes, until there is no moisture left. Remove from the heat, stir in the toasted cumin seeds, ground mace (or nutmeg) and ground coriander. Leave to cool. In a large bowl mix together the minced lamb, white pepper, fresh coriander, and the cooled spiced onion mixture until combined. Set aside, covered, in the fridge. Preheat the oven to 200C/400F/Gas 6 and generously grease a 20cm/8in diameter lo…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-52881
**Steak and Kidney Pie** · Beef · area: British
- ingredients: 300g Puff Pastry, Beaten Egg White, Beaten Egg Yolk, 2 tbs Vegetable Oil, 70 ml Beef, 200g Lamb Kidney, 2 chopped Onion, 30g Plain Flour, 85 ml Beef Stock, pinch Salt, pinch Black Pepper, Dash Worcestershire Sauce
- method (8 steps): Preheat the oven to 220C/425F/Gas 7 Heat the vegetable oil in a large frying pan, and brown the beef all over. (You may need to do this in batches.) Set aside, then brown the kidneys on both sides in the same pan. Add the onions and cook for 3-4 minutes. Return the beef to the pan, sprinkle flour over and coat the meat and onions Add the stock to the pan, stir well and bring to the boil. Turn the heat down and simmer for 1½ hours without a lid. If the liquid evaporates too much, add more stock. Remove from the heat. Add salt, pepper and Worcestershire sauce and allow to cool completely. Place …
- `textures` rule: ['creamy', 'flaky', 'saucy'] (0.50, keywords: creamy, flaky, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 12 ingredients, 150 min, technique: crimp, roll out the pastry)

### mdb-52882
**Three Fish Pie** · Seafood · area: British
- ingredients: 1kg Potato, Knob Butter, Dash Milk, 50g Gruyere, 75g Butter, 2 sliced Leek, 75g Plain Flour, 150ml White Wine, 568ml Milk, 2 tbs chopped Parsley, 250g Salmon, 250g Haddock, 250g Smoked Haddock, 6 Egg
- method (6 steps): Preheat the oven to 200C/400F/Gas 6 (180C fan). Put the potatoes into a saucepan of cold salted water. Bring up to the boil and simmer until completely tender. Drain well and then mash with the butter and milk. Add pepper and taste to check the seasoning. Add salt and more pepper if necessary. For the fish filling, melt the butter in a saucepan, add the leeks and stir over the heat. Cover with a lid and simmer gently for 10 minutes, or until soft. Measure the flour into a small bowl. Add the wine and whisk together until smooth. Add the milk to the leeks, bring to the boil and then add the win…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 14 ingredients, 70 min)

### mdb-52884
**Lancashire hotpot** · Lamb · area: British
- ingredients: 100g Butter, 900g Lamb, 3 Lamb Kidney, 2 medium Onion, 4 sliced Carrot, 25g Plain Flour, 2 tsp Worcestershire Sauce, 500ml Chicken Stock, 2 Bay Leaf, 900g Potato
- method (5 steps): Heat oven to 160C/fan 140C/gas. Heat some dripping or butter in a large shallow casserole dish, brown the lamb in batches, lift to a plate, then repeat with the kidneys. Fry the onions and carrots in the pan with a little more dripping until golden. Sprinkle over the flour, allow to cook for a couple of mins, shake over the Worcestershire sauce, pour in the stock, then bring to the boil. Stir in the meat and bay leaves, then turn off the heat. Arrange the sliced potatoes on top of the meat, then drizzle with a little more dripping. Cover, then place in the oven for about 1½ hrs until the potat…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 120 min)

### mdb-52886
**Spotted Dick** · Dessert · area: British
- ingredients: 250g Self Raising Flour, pinch Salt, 125g Suet, 175g Currant, 80g Sugar, Zest of 1 Lemon, Zest of 1 Orange, 150ml Milk, to serve Custard
- method (5 steps): Put the flour and salt in a bowl. Add the suet, currants, sugar, lemon and orange zest. Pour in 150ml milk and mix to a firm but moist dough, adding the extra milk if necessary. Shape into a fat roll about 20cm long. Place on a large rectangle of baking parchment. Wrap loosely to allow for the pudding to rise and tie the ends with string like a Christmas cracker. Place a steamer over a large pan of boiling water, add the pudding to the steamer, cover and steam for 1 1/2 hours. Top up the pan with water from time to time. Remove from the steamer and allow to cool slightly before unwrapping. Ser…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 140 min)

### mdb-52887
**Kedgeree** · Seafood · area: British
- ingredients: 300g Smoked Haddock, 2 Bay Leaf, 300ml Milk, 4 Egg, Handful Parsley, Handful Coriander, 2 tbs Vegetable Oil, 1 chopped Onion, 1 tsp Coriander, 2 tsp Curry Powder, 300g Rice
- method (5 steps): For the rice, heat the oil in a large, lidded pan, add the onion, then gently fry for 5 mins until softened but not coloured. Add the spices, season with salt, then continue to fry until the mix start to go brown and fragrant; about 3 mins. Add the rice and stir in well. Add 600ml water, stir, then bring to the boil. Reduce to a simmer, then cover for 10 mins. Take off the heat and leave to stand, covered, for 10-15 mins more. The rice will be perfectly cooked if you do not lift the lid before the end of the cooking. Meanwhile, put the haddock and bay leaves in a frying pan, cover with the mil…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 75 min)

### mdb-52888
**Eccles Cakes** · Dessert · area: British
- ingredients: 250g Butter, 350g Plain Flour, Juice of 1/2 Lemon, 25g Butter, 200g Currant, 50g Mixed Peel, 100g Muscovado Sugar, 1 tsp Cinnamon, 1 tsp Ginger, 1 tsp Ground Allspice, Zest of 1 Lemon, 1 beaten Egg, spinkling Sugar
- method (10 steps): To make the pastry, dice the butter and put it in the freezer to go really hard. Tip flour into the bowl of a food processor with half the butter and pulse to the texture of breadcrumbs. Pour in the lemon juice and 100ml iced water, and pulse to a dough. Tip in the rest of the butter and pulse a few times until the dough is heavily flecked with butter. It is important that you don’t overdo this as the flecks of butter are what makes the pastry flaky. On a floured surface roll the pastry out to a neat rectangle about 20 x 30cm. Fold the two ends of the pastry into the middle (See picture 1), th…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['flaky', 'smooth'] (0.50, keywords: flaky, smooth)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 13 ingredients, 90 min, technique: make the pastry)

### mdb-52889
**Summer Pudding** · Dessert · area: British
- ingredients: 300g Strawberries, 250g Blackberry, 100g Redcurrant, 500g Raspberry, 175g Sugar, 7 Slices Bread
- method (10 steps): Bring out the juices: Wash fruit and gently dry on kitchen paper – keep strawberries separate. Put sugar and 3 tbsp water into a large pan. Gently heat until sugar dissolves – stir a few times. Bring to a boil for 1 min, then tip in the fruit (not strawberries). Cook for 3 mins over a low heat, stirring 2-3 times. The fruit will be softened, mostly intact and surrounded by dark red juice. Put a sieve over a bowl and tip in the fruit and juice. Line the bowl with cling film and prepare the bread: Line the 1.25-litre basin with cling film as this will help you to turn out the pudding. Overlap tw…
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 6 ingredients, 385 min)
