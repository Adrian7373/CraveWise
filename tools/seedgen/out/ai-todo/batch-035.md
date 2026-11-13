# AI tagging batch 035

Write `tools/seedgen/tags/ai/batch-035.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53480
**Creamy Aji green sauce** · Vegetarian · area: none
- ingredients: Bunch Coriander, 2 Jalapeno, 2 Spring Onion, 1 clove Garlic, 1 tablespoon White Wine Vinegar, Juice of 1 Lime, Pinch Ground Cumin, 4 tablespoons Mayonnaise
- method (1 steps): Put all the ingredients in a blender or food processor and mix into a sauce. Add seasoning, then pour into a serving bowl.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy'] (0.50, keywords: creamy, saucy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 8 ingredients, 45 min)

### mdb-53481
**Bahia-style Moqueca prawn stew** · Seafood · area: none
- ingredients: 450g Prawn, 75 ml Lime Juice, 3 cloves Chopped Garlic, 3 tablespoons Coconut Oil, 4 Chopped Spring Onion, 1 Onion, 1 chopped Red Pepper, 1 tsp Chilli Flakes, 2 tsp Paprika, 3 chopped Tomato, 400ml Coconut Milk, 2 tbs chopped Coriander, To serve Rice
- method (3 steps): Place the prawns in a bowl with 2 tbsp of the lime juice, 1 tsp of salt and 1 tbsp of the chopped garlic. Chill for 1 hr. Heat the coconut oil in a large saucepan. Add the spring onion and onion and fry for 5 mins, then add the red pepper, chilli flakes, paprika and remaining garlic. Pour in the tomatoes, coconut milk and a little salt. Bring to a simmer and let reduce for 10 mins. Add the prawns, all the marinade and remaining lime juice. Gently simmer until the prawns turn white, about 3 mins. Serve with the fresh coriander and rice.
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 13 ingredients, 105 min)

### mdb-53482
**Black bean & meat stew - feijoada** · Beef · area: none
- ingredients: 250g Black Bean, 100g Bacon, 500g Pork Back Rib, 3 Chorizo, 500g Pork Shoulder, 3 chopped Onion, 4 Cloves Chopped Garlic, Pinch Chilli Flakes, Drizzle Vegetable Oil, 2 Bay Leaf
- method (6 steps): Heat a large heavy-based saucepan with a fitted lid, add the bacon and fry until crisp. Remove and keep the oil in the pan. In batches sear the ribs, sausages and pork shoulder. Season each batch with salt and pepper. Remove the meat and set aside. Add the onion, garlic and chilli to the pan. Pour in a little olive oil if it needs more. Season with salt and pepper and fry for 8 mins or until soft. Add the meat, bay leaves, white wine vinegar and drained beans. Cover with just enough water to cover, about 650ml. Bring to a boil and reduce the heat to a low simmer. Cover and cook for 2 hrs, or u…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'tender'] (0.50, keywords: crispy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 570 min)

### mdb-53483
**Acaraje black-eyed pea fritters with shrimp filling** · Seafood · area: none
- ingredients: 800g Black Eyed Pea, 1 clove Garlic, 1 Green Chilli, 1 small finely diced Red Onion, 2 tablespoons Plain Flour, 1 tsp Salt, 1 tsp Chilli Powder, 1 tsp Baking Powder, For frying Vegetable Oil, 1 sliced Red Onion, 1 tablespoon chopped Ginger, 2 cloves Garlic, 1 chopped Red Chilli, 150g Prawn, 1 tablespoon Vegetable Oil, 2 Tomato, 1 tablespoon chopped Coriander, Juice of 1 Lime
- method (4 steps): Make the filling by placing the onion, ginger, garlic, chilli, and some salt into food processor. Purée until smooth. Heat the oil in a frying pan and pour the purée into it. Fry for 5 mins or until cooked through. Add the prawns, tomatoes and chopped coriander. Squeeze in the lime and add salt to taste. Cook for 3 mins, or until the prawns have cooked through. Remove from the heat. Drain and rinse the black-eyed peas. Pour into a food processor with the garlic and chili. Purée until smooth. Scrape into a bowl and add the onion, flour, salt, chilli powder and baking powder. Mix and roll into 1…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 18 ingredients, 50 min)

### mdb-53484
**Simple heart of palm & tomato salad** · Starter · area: none
- ingredients: 400g Palm Heart, 250g Cherry Tomato, 2 sliced Spring Onion, 1 tablespoon Sherry Vinegar, 3 tablespoons Olive Oil, Handful Parsley
- method (1 steps): Mix together the hearts of palm, tomatoes and spring onions. Whisk together the sherry vinegar and olive oil. Drizzle over the salad. Sprinkle with the parsley, toss everything together and serve.
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Starter guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 6 ingredients, 30 min)

### mdb-53485
**Brazilian carrot cake** · Dessert · area: none
- ingredients: 250ml Vegetable Oil, 260g Plain Flour, 400g Sugar, 1 tsp Baking Powder, 2 medium Carrot, 2 Egg, 250ml Milk, 30g Cocoa Powder, 60g Sugar
- method (5 steps): Heat the oven to 180C/160C fan/ gas. Oil and line the base of a 20cm springform cake tin. Mix the flour, sugar and baking powder together in a large bowl and set aside. Tip the oil, carrots and eggs in a blender and blitz until smooth. Pour the wet ingredients into the dry, stirring until smooth. Pour the batter into the cake tin and give it a shake to get rid of air bubbles. Bake for 45 mins to 1 hr, until a clean knife or skewer inserted into the middle comes out clean. If the middle is sticky, put back in the oven for a further 5 mins. Remove from the oven and leave to cool in the tin. For …
- `cuisine` rule: 'Brazilian' (0.60, title mentions 'Brazilian')
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'smooth'] (0.50, keywords: crispy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 90 min)

### mdb-53486
**Easy White Bean Soup** · Vegetarian · area: none
- ingredients: 1 lb Cannellini Bean, 2 medium Onion, 2 tablespoons Vegetable Oil, 2 medium Red Pepper, 1/3 cup Tomato Puree, 2 medium Carrot, 6 cups Water, 1 tsp Dried Mint, 1/2 tsp Thyme, 1 tsp Summer Savoury, 1 tsp Black Pepper, 1 tsp Salt, Garnish Parsley
- method (5 steps): Place beans in a large pot and cover with cold water. Soak for at least 4 hours or overnight. Drain and rinse, before you use in the soup. Chop one of the onions and leave the other one whole. Chop carrots. Heat oil on a large pot over medium heat. Add the onion and carrots. Cook for 2 minutes. Add beans, water, peppers, head of onion, salt, pepper, summer savory, mint, thyme, Vegeta and tomato puree. Stir, bring to a boil, then reduce to a simmer and cook for 2 hours, or until the beans are tender. Remove the peppers and whole onion. Mash the onion. Peel peppers and chop. Return to the pot. A…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 13 ingredients, 400 min)

### mdb-53487
**Oyster Mushroom Soup** · Starter · area: none
- ingredients: 1 lb Oyster Mushroom, 4 tablespoons Butter, 1 tsp Salt, 1 cup Water, 2 tablespoons Plain Flour, 1 cup Milk, 3 cloves Garlic, 1/3 cup Red Wine Vinegar, Garnish Chilli Flakes
- method (7 steps): Clean mushrooms – I usually wash them under cold water, dry them and remove the stems. Cut mushrooms into thin strips. Melt butter in a small pot. Add the mushrooms and cook for 10 minutes, until the mushrooms release liquid. Combine the flour and water, whisk to remove any lumps and add to the pot. Add the salt and milk. Cook for 10 more minutes. In a small bowl or jar combine the garlic and vinegar. Serve the soup with 1-2 tablespoons (or more) of the garlic and vinegar mixture and hot red pepper.
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 9 ingredients, 30 min)

### mdb-53488
**Cabbage with Ground Beef** · Beef · area: none
- ingredients: 2 tablespoons Olive Oil, 1 lb Beef Mince, 1 small Onion, 2 medium Carrot, 1 medium Red Pepper, 1 tablespoon Tomato Puree, 2 cloves Garlic, 1/2 tbs Salt, 1/2 tbs Black Pepper, 1 tsp Smoked Paprika, 1/4 tsp Ground Cumin, 1/2 Cabbage, 1 tsp Cider Vinegar, 1 cup Water, 2 tbs chopped Parsley
- method (12 steps): Heat a large skillet or braiser over medium heat on the stovetop. Add the olive oil. A braiser with cooked ground beef Cook the Meat:. Add the ground meat to the pan. Use a potato masher or wooden spoon to break it into small pieces. Cook for 3–4 minutes until browned. Add Vegetables and Seasoning:. Stir in the onion, carrots, red pepper, garlic, and tomato paste. Season with salt, black pepper, smoked paprika, ground cumin, and Italian seasoning (if using). Cook for 2–3 minutes, stirring frequently. A braiser with cooked ground beef, carrots, onions, peppers, garlic and seasoning. Add Cabbage…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 15 ingredients, 70 min)

### mdb-53489
**Potato Moussaka Recipe** · Beef · area: none
- ingredients: 1 tablespoon Vegetable Oil, 1 lb Beef Mince, 1/3 cup Onion, 1 clove peeled crushed Garlic, 1/4 cup Tomato Sauce, 2 tablespoons Tomato Puree, 1 tsp Salt, 1/4 tsp Black Pepper, 1 tsp Summer Savoury, 2 cups Water, 2 Lbs Potato, 1/4 cup Carrot, 2 cups Milk, 1/2 tsp Dried Mint, 6 tablespoons Butter, 1/2 cup Plain Flour, 1/2 tsp Salt, 3 Egg Yolk, 1/2 cup Feta, 1/4 tsp Ground Nutmeg
- method (14 steps): Preheat oven to 350 F. Heat oil in a skillet. Add the ground meat and cook, breaking it down with a wooden spoon for 6-7 minutes, until browned. Add onion and garlic. Add carrots (optional).Add salt, black pepper, dried mint, summer savory, thyme (optional), tomato sauce and tomato paste. Cook for 2-3 minutes, stirring frequently. Grease a 9×9 or 9×13 baking dish with oil. Add in the drained potatoes and meat mixture. Stir to evenly distribute the meat into the potatoes. Add cold water to the baking dish, so it just covers the top of the potatoes. Bake for 40-50 minutes, until the water is abs…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 14 steps, 20 ingredients, 120 min, technique: temper)

### mdb-53490
**Cottage Cheese And Feta Stuffed Peppers** · Vegetarian · area: none
- ingredients: 4 Red Pepper, 100g Feta, 200g Cottage Cheese, 1 tablespoon chopped Chive, 1 tablespoon chopped Parsley, 1/4 tsp Salt, 1 tablespoon Lemon Juice
- method (4 steps): Cut the peppers lengthwise and remove the seeds. In a bowl combine 3.5 oz (100 grams) Feta cheese, 7 oz (200 grams) cottage cheese, 1 tbsp chopped chives (optional), 1 tbsp chopped parsley (optional), 1/4 tsp salt (more or less to taste) and 1 tbsp lemon juice. Fill the peppers with the mixture. Top with chopped chives and parsley. Serve.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 50 min)

### mdb-53491
**Shopska Salad** · Vegetarian · area: none
- ingredients: 1 sliced Cucumber, 3 Cups Tomato, 1/4 Red Onion, 1 chopped Green Pepper, 1 tsp Salt, 1/4 cup Olive Oil, 1/3 cup Feta, 2 tbs chopped Parsley
- method (1 steps): Combine vegetables in a bowl and sprinkle salt on top. Let it stand for 5 minutes. Add the oil. Top with feta and parsley. Serve.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 8 ingredients, 50 min)

### mdb-53492
**Bulgarian Green Salad** · Side · area: none
- ingredients: 1/2 Lettuce, 7 Radish, 1 sliced Cucumber, 4 Chopped Spring Onion, To taste Salt, 2 tablespoons Cider Vinegar, 1/8 cup Olive Oil, Garnish Dill, Garnish Parsley
- method (5 steps): Place sliced lettuce in a large bowl. Add radishes, cucumber, and scallions. Drizzle with vinegar and olive oil. Season with salt and gently toss to combine. Top with sliced hard-boiled eggs, olives, dill and (or) parsley if using and serve immediately.
- `cuisine` rule: 'Bulgarian' (0.60, title mentions 'Bulgarian')
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 40 min)

### mdb-53493
**Bulgarian Honey Cookies** · Dessert · area: none
- ingredients: 2 large Egg, 1 cup Icing Sugar, 1/4 cup Honey, 1 tsp Vanilla Extract, 3 Cups Vegetable Oil, 4 cups Plain Flour, 1/4 tsp Salt, 1 tsp Cinnamon, 1 tsp Baking Powder, 2 cups Chocolate Chip, 2 tsp Vegetable Oil
- method (7 steps): Preheat oven to 350 F. Line 2-3 baking sheets with parchment paper. In a bowl, combine flour, salt, cinnamon and baking soda. In the bowl of a stand mixer, fitted with the paddle attachment, beat together eggs and powdered sugar for3 minutes. Add vanilla extract and honey. Mix to combine, then add oil. Add the flour mixture in two increments and beat to incorporate. Let the dough rest for 5-10 minutes. Shape 2 tbsp balls, place on baking sheets and press flat. Bake for 12-15 minutes, until golden. Let the cookies cool down completely. Melt white and semi-sweet chocolate separately with 1 tbsp …
- `cuisine` rule: 'Bulgarian' (0.60, title mentions 'Bulgarian')
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 11 ingredients, 40 min, technique: temper)

### mdb-53494
**Keto Banitsa** · Side · area: none
- ingredients: 4 Egg, 80g Butter, 120g Mozzarella, 30g Cream Cheese, 1 tsp Baking Powder, 60g Feta, Topping Sesame Seed
- method (8 steps): Preheat oven to 360 F (180 C) Beat eggs in a bowl, using a whisk ( no mixer needed). Slowly add the melted butter, whisking to incorporate. Add the cheeses (mozzarella, feta and cream cheese), stir to combine. Then add the baking powder and whisk. Grease a 8×8 -inch square baking dish with butter and pour the mixture inside. Top with sesame seeds (optional). Bake for 20 minutes, until golden. Let it cool for 5-10 minutes inside the pan, then cut into pieces and serve. Keep in the fridge for up to 3 days.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 7 ingredients, 40 min)

### mdb-53495
**Amok Trey – Cambodian Fish Curry** · Seafood · area: none
- ingredients: 1 lb White Fish, 1 Can Coconut Milk, 2 tablespoons Red Curry Paste, 1 tablespoon Fish Sauce, 1 tsp Brown Sugar, 1 cup Chicken Stock, 1 Egg, 2 Makrut Lime Leaf, 1 tablespoon Vegetable Oil, Handful Banana Leaf, Garnish Coriander, Garnish Lime
- method (10 steps): In a medium bowl, combine the coconut milk, red curry paste, fish sauce, palm sugar, and broth, whisking until smooth—this ensures no lumps in the sauce. Heat the vegetable oil in a large skillet over medium heat (about 350°F) for 30 seconds until shimmering. Pour the coconut milk mixture into the skillet and bring it to a gentle simmer, stirring occasionally, which should take about 3-4 minutes. Add the fish cubes and kaffir lime leaves to the skillet, submerging them fully in the sauce. Reduce the heat to low, cover the skillet, and let it cook for 10 minutes until the fish is opaque and fla…
- `cuisine` rule: 'Cambodian' (0.60, title mentions 'Cambodian')
- `textures` rule: ['brothy', 'creamy', 'crunchy'] (0.50, keywords: brothy, creamy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'light'] (0.50, keywords/category: comfort, fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 12 ingredients, 50 min, technique: steamer basket)

### mdb-53496
**Bai Sach Chrouk – Grilled Pork with Rice** · Pork · area: none
- ingredients: 650g Pork Shoulder, 1/4 cup Coconut Milk, 3 tablespoons Soy Sauce, 2 tablespoons Oyster Sauce, 2 tablespoons Honey, 4 cloves Garlic, 1 tsp Black Pepper, 2 cups Jasmine Rice, 4 cups Water, 1 tablespoon Vegetable Oil, 1 sliced Cucumber, Garnish Coriander
- method (12 steps): In a large bowl, combine the coconut milk, soy sauce, oyster sauce, honey, minced garlic, and black pepper to make the marinade. Add the thinly sliced pork shoulder to the marinade, ensuring each piece is fully coated, then cover and refrigerate for at least 30 minutes to allow the flavors to penetrate. While the pork marinates, rinse the jasmine rice under cold water until the water runs clear to remove excess starch, which helps prevent clumping. In a medium pot, combine the rinsed rice and 4 cups of water, bring to a boil over high heat, then reduce to a simmer, cover, and cook for 15 minut…
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 12 ingredients, 90 min, technique: temper)

### mdb-53497
**Nom Banh Chok – Cambodian Noodle Soup** · Chicken · area: none
- ingredients: 8 cups Water, 1lb Chicken Thigh, 4 Cloves Crushed Garlic, 2 tablespoons Vegetable Oil, 1 tablespoon Fish Sauce, 1 tsp Salt, 1 tsp Sugar, 8 oz Rice Noodle, 2 cups Bean Sprout, 1 cup Mint, 1 Lime, 1 Red Chilli
- method (10 steps): Heat the vegetable oil in a large pot over medium heat until it shimmers, about 2 minutes. Add the minced garlic and sauté until fragrant and lightly golden, about 1 minute, stirring constantly to prevent burning. Add the chicken pieces and cook until they turn opaque on all sides, about 5 minutes, stirring occasionally. Pour in the 8 cups of water and bring to a boil over high heat, which should take about 8 minutes. Reduce the heat to low, stir in the fish sauce, salt, and sugar, and simmer uncovered for 20 minutes to develop the flavors. While the broth simmers, cook the rice noodles accord…
- `cuisine` rule: 'Cambodian' (0.60, title mentions 'Cambodian')
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 12 ingredients, 70 min)

### mdb-53498
**Samlar Kari – Khmer Red Curry** · Chicken · area: none
- ingredients: 1 tablespoon Vegetable Oil, 1 lb Chicken Thigh, 1 medium chopped Onion, 3 Cloves Crushed Garlic, 1 tablespoon Ginger, 2 tablespoons Red Curry Paste, 1 can Coconut Milk, 1 cup Chicken Stock, 1 tablespoon Fish Sauce, 1 tablespoon Brown Sugar, 1 cup Bamboo Shoot, 1 sliced Red Pepper, Pinch Basil, To serve Lime
- method (12 steps): Heat 1 tbsp vegetable oil in a large pot or Dutch oven over medium-high heat until it shimmers, about 2 minutes. Add 1 lb chicken pieces to the pot and cook until browned on all sides, approximately 5–7 minutes, stirring occasionally to prevent sticking. Remove the chicken from the pot and set it aside on a plate, leaving any oil and juices in the pot. Reduce the heat to medium and add 1 sliced onion to the pot, cooking until softened and translucent, about 4 minutes. Stir in 3 cloves minced garlic and 1 tbsp grated ginger, cooking for 1 minute until fragrant to avoid burning. Add 2 tbsp red c…
- `cuisine` rule: none
- `textures` rule: ['brothy', 'creamy', 'crispy'] (0.50, keywords: brothy, creamy, crispy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 14 ingredients, 70 min)

### mdb-53499
**Prahok Ktis – Pork and Coconut Dip** · Pork · area: none
- ingredients: 1 lb Pork Mince, 1 cup Coconut Milk, 3 tablespoons Prahok, 2 tablespoons Vegetable Oil, 4 Cloves Crushed Garlic, 2 chopped Shallot, 2 Red Chilli, 1 tablespoon Brown Sugar, 2 tablespoons Fish Sauce, Juice of 1 Lime, Garnish Coriander
- method (12 steps): Heat 2 tbsp vegetable oil in a large skillet over medium-high heat until shimmering, about 1 minute. Add 4 cloves minced garlic and 2 finely chopped shallots to the skillet, stirring constantly until fragrant and lightly golden, 2-3 minutes. Tip: Keep the heat medium to prevent burning—garlic can turn bitter if overcooked. Add 1 lb ground pork to the skillet, breaking it up with a spoon, and cook until no pink remains, 5-7 minutes. Stir in 3 tbsp prahok and cook for 1 minute to blend the flavors, mashing it slightly into the pork. Pour in 1 cup coconut milk, stirring to combine, then reduce he…
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 12 steps, 11 ingredients, 60 min)
