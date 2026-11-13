# AI tagging batch 015

Write `tools/seedgen/tags/ai/batch-015.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53055
**Cevapi Sausages** · Beef · area: Croatian
- ingredients: 500g Beef Mince, 250g Pork Mince, 1 Onion, 4 cloves Garlic, 3 tblsp chopped Parsley, 1 tbs Paprika, 3/4 teaspoon Baking Powder, 2 tbs Breadcrumb, 3 tbs Water, 1 Vegetable Stock, 1 tsp Salt, 1 tsp Black Pepper
- method (5 steps): Place the ground meat in a bowl. Chop the onion very finely and grate the garlic cloves. Add to the bowl. Add the chopped parsley, all sorts of paprika, baking soda, dried breadcrumbs, water, Vegeta, salt, and pepper. Mix well with the hand mixer fitted with the dough hooks. Cover the bowl with cling film/ plastic foil and leave to rest for 1 or 2 hours in the refrigerator. Take portions of the meat mixture, about 50-55 g/ 1.7-1.9 oz/ ¼ cup portions, and form the cevapi. The rolls should be about as thick as your thumb and about 7-10 cm/ 3-4 inches long. I had 18 sausages. The recipe can be ea…
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 115 min)

### mdb-53056
**Croatian lamb peka** · Beef · area: Croatian
- ingredients: 600g Potato, 1 chopped Courgette, 1 chopped Carrot, 1 chopped Green Pepper, 1 small Aubergine, 1 Large Chopped Onion, 800g Lamb Shoulder, 1 tbs Garlic Sauce, 1 tbs Tomato Puree, 80 ml Olive Oil, Sprinking Thyme, 250ml White Wine, Pinch Black Pepper
- method (10 steps): Preheat oven to 200°C fan / 220°C / 425°F / Gas mark 7 If you have not bought diced lamb, cut your lamb shoulder or leg into large chunks and place to one side. Chunks of chopped lamb of a red chopping board Make oil marinade - Mix 80ml of olive oil in a bowl with garlic puree, sundried tomato puree ,black pepper and salt. olive oil, gia sundried tomato puree and gia garlic puree and black pepper mixed together in a silver bowl to make Croatian peka Add potatoes and vegetables into a large lidded casserole dish. Chopped up vegetables which consist of chopped up red onion, courgette, potatoes r…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 13 ingredients, 150 min)

### mdb-53057
**Traditional Croatian Goulash** · Beef · area: Croatian
- ingredients: 500g Beef, 2 chopped Onion, 2 chopped Carrot, 2 cloves Garlic, 2 Bay Leaf, 200ml Red Wine, 2 Litres Water, 3 tbs Mustard, 1tbsp Salt, 1/2 tsp Black Pepper, 1/2 tsp Paprika, 2 tbs Vegetable Oil
- method (6 steps): Clean the meat from the veins if there are some and cut it into smaller pieces, 3 × 3 cm. Marinate the meat in the mustard and spices and let it sit in the refrigerator for one hour Heat one tablespoon of pork fat or vegetable oil in a pot and fry the meat on all sides until it gets browned. Once the meat is cooked, transfer it to a plate and add another tablespoon of fat to the pot Cut the onions very fine, peel the carrots and shred it using a grater. Cook the onions and carrots over low heat for 15 minutes. You can salt the vegetables a little to make them soften faster Once the vegetables …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 12 ingredients, 210 min)

### mdb-53058
**Croatian Bean Stew** · Beef · area: Croatian
- ingredients: 2 cans Cannellini Bean, 3 tbs Vegetable Oil, 2 cups Tomato, 5 Shallot, 2 cloves Garlic, Pinch Parsley, 1/2 kg chopped Chorizo
- method (1 steps): Heat the oil in a pan. Add the chopped vegetables and sauté until tender. Take a pot, empty the beans together with the vegetables into it, put the sausages inside and cook for further 20 minutes on a low heat. Or, put it in an oven and bake it at a temperature of 180ºC/350ºF for 30 minutes. This dish is even better reheated the next day.
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 7 ingredients, 70 min)

### mdb-53059
**Mushroom soup with buckwheat** · Side · area: Croatian
- ingredients: 150g Mushroom, 50g Buckwheat, 4 tbs Vegetable Oil, 40g Onion, 2 cloves Garlic, 1 Bay Leaf, 1tbsp Vegetable Stock, 50 ml Sour Cream, Dash White Wine Vinegar, Top Parsley
- method (1 steps): Chop the onion and garlic, slice the mushrooms and wash the buckwheat. Heat the oil and lightly sauté the onion. Add the mushrooms and the garlic and continue to sauté. Add the salt, vegetable seasoning, buckwheat and the bay leaf and cover with water. Simmer gently and just before it is completely cooked, add pepper, sour cream mixed with flour, the chopped parsley and vinegar to taste.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 10 ingredients, 45 min)

### mdb-53060
**Burek** · Side · area: Croatian
- ingredients: 1 Packet Filo Pastry, 150g Beef Mince, 150g Onion, 40g Vegetable Oil, Dash Salt, Dash Black Pepper
- method (2 steps): Fry the finely chopped onions and minced meat in oil. Add the salt and pepper. Grease a round baking tray and put a layer of pastry in it. Cover with a thin layer of filling and cover this with another layer of filo pastry which must be well coated in oil. Put another layer of filling and cover with pastry. When you have five or six layers, cover with filo pastry, bake at 200ºC/392ºF for half an hour and cut in quarters and serve.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 50 min)

### mdb-53061
**Fresh sardines** · Side · area: Croatian
- ingredients: 500g Sardine, Dash Vegetable Oil, To Glaze Plain Flour, Dash Salt
- method (1 steps): Wash the fish under the cold tap. Roll in the flour and deep fry in oil until crispy. Lay on kitchen towel to get rid of the excess oil and serve hot or cold with a slice of lemon.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 4 ingredients, 35 min, technique: deep fr)

### mdb-53062
**Walnut Roll Gužvara** · Dessert · area: Croatian
- ingredients: 450g Plain Flour, 55g Sugar, 2 parts Yeast, 1/2 tsp Salt, 6 oz Milk, 2 Beaten Egg, 30g Butter, 140g Walnut, 85g Butter, 85g Brown Sugar, 1 tsp Cinnamon, To Glaze Milk, To Glaze Icing Sugar
- method (5 steps): Mix all the ingredients for the dough together and knead well. Cover the dough and put to rise until doubled in size which should take about 2 hours. Knock back the dough and knead lightly. Divide the dough into two equal pieces; roll each piece into an oblong about 12 inches by 8 inches. Mix the filling ingredients together and divide between the dough, spreading over each piece. Roll up the oblongs as tightly as possible to give two 12 inch sausages. Place these side by side, touching each other, on a greased baking sheet. Cover and leave to rise for about 40 minutes. Heat oven to 200ºC (425…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 13 ingredients, 220 min, technique: knead)

### mdb-53063
**Chivito uruguayo** · Beef · area: Uruguayan
- ingredients: 2 Beef Brisket, 2 Bread, 1 Lettuce, 1 Tomato, 100g Ham, 100g Mozzarella, 100g Bacon, 1 Egg, 1 Onion, 1 Black Pepper
- method (2 steps): Crush the meat so that it is finite and we put it on a griddle to brown. Put the eggs, bacon and ham to fry. Cut the bread in half, put the beef brisket, the fried eggs, the bacon, the ham, the mozzarella, the tomato and the lettuce. Cover with the other half of the bread and serve.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'tender'] (0.50, keywords: crispy, tender)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 50 min)

### mdb-53067
**Stuffed Bell Peppers with Quinoa and Black Beans** · Vegetarian · area: Mexican
- ingredients: 4 whole Green Pepper, 1 tablespoon Olive Oil, 1 small finely diced Onion, 2 cloves minced Garlic, 1 cups Quinoa, 1 can Black Bean, 1 cup Sweetcorn, 1 can Chopped Tomatoes, 1 teaspoon Ground Cumin, ½ tsp Chilli Powder, ½ tsp Smoked Paprika, To taste Salt, To taste Black Pepper, 1 1/2 cup Shredded Mexican Cheese, Chopped Coriander
- method (7 steps): Preheat your oven to 375°F (190°C). Lightly grease a 9x13-inch baking dish or a similar-sized casserole dish. Place the bell pepper halves in the prepared baking dish, cut side up. Bake for 15-20 minutes, or until slightly softened. While the bell peppers are baking, prepare the filling. In a large skillet, heat the olive oil over medium heat. Add the chopped onion, and cook for 3-4 minutes, until softened. Add the garlic, and cook for another 1 minute, until fragrant. Stir in the cooked quinoa, black beans, corn, diced tomatoes, ground cumin, chili powder, smoked paprika, salt, and pepper. Co…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 7 steps, 15 ingredients, 85 min, technique: stuffed peppers)

### mdb-53068
**Beef Mechado** · Beef · area: Filipino
- ingredients: 3 cloves Garlic, 1 sliced Onion, 2 Lbs Beef, 8 ounces Tomato Puree, 1 cup Water, 3 tbs Olive Oil, 1 Slice Lemon, 1 large Potato, 1/4 cup Soy Sauce, 1/2 tsp Black Pepper, 2 Bay Leaf, To taste Salt
- method (6 steps): Make the beef tenderloin marinade by combining soy sauce, vinegar, ginger, garlic, sesame oil, olive oil, sugar, salt, and ground black pepper in a large bowl. Mix well. Add the cubed beef tenderloin to the bowl with the beef tenderloin marinade. Gently toss to coat the beef. Let it stay for 1 hour. Using a metal or bamboo skewer, assemble the beef kebob by skewering the vegetables and marinated beef tenderloin. Heat-up the grill and start grilling the beef kebobs for 3 minutes per side. This will give you a medium beef that is juicy and tender on the inside. Add more time if you want your bee…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 12 ingredients, 90 min)

### mdb-53070
**Beef Caldereta** · Beef · area: Filipino
- ingredients: 2kg cut cubes Beef, 1 Beef Stock, 1 tbs Soy Sauce, 2 cups Water, 1 sliced Green Pepper, 1 sliced Red Pepper, 1 sliced Potato, 1 sliced Carrot, 8 ounces Tomato Puree, 3 tablespoons Peanut Butter, 5 Chilli Powder, 1 chopped Onion, 5 cloves Garlic, 3 tbs Olive Oil
- method (8 steps): Heat oil in a cooking pot. Saute onion and garlic until onion softens. Add beef. Saute until the outer part turns light brown. Add soy sauce. Pour tomato sauce and water. Let boil. Add Knorr Beef Cube. Cover the pressure cooker. Cook for 30 minutes. Pan-fry carrot and potato until it browns. Set aside. Add chili pepper, liver spread and peanut butter. Stir. Add bell peppers, fried potato and carrot. Cover the pot. Continue cooking for 5 to 7 minutes. Season with salt and ground black pepper. Serve.
- `flavor.sweet` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy', 'saucy'] (0.50, keywords: crispy, crunchy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 14 ingredients, 65 min)

### mdb-53071
**Beef Asado** · Beef · area: Filipino
- ingredients: 1.5kg Beef, 1 Beef Stock, 8 ounces Tomato Puree, 3 cups Water, 6 tablespoons Soy Sauce, 1 tbs White Wine Vinegar, 2 tbs Black Pepper, 4 Bay Leaf, 1/2 Lemon, 2 tbs Tomato Sauce, 3 tbs Butter, 1/2 cup Olive Oil, 1 chopped Onion, 4 cloves Garlic
- method (8 steps): Combine beef, crushed peppercorn, soy sauce, vinegar, dried bay leaves, lemon, and tomato sauce. Mix well. Marinate beef for at least 30 minutes. Put the marinated beef in a cooking pot along with remaining marinade. Add water. Let boil. Add Knorr Beef Cube. Stir. Cover the pot and cook for 40 minutes in low heat. Turn the beef over. Add tomato paste. Continue cooking until beef tenderizes. Set aside. Heat oil in a pan. Fry the potato until it browns. Turn over and continue frying the opposite side. Remove from the pan and place on a clean plate. Do the same with the carrots. Save 3 tablespoon…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'smooth'] (0.50, keywords: crispy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 14 ingredients, 105 min)

### mdb-53072
**Crispy Eggplant** · Vegetarian · area: Filipino
- ingredients: 1 large Aubergine, 1 cup Breadcrumb, 50g Sesame Seed, 2 Egg, To taste Salt, To taste Black Pepper, For frying Vegetable Oil
- method (5 steps): Slice eggplant into 1 cm (0.4-inch) slices. Place them in a bowl and sprinkle them with salt. allow them to sit for 30 minutes to render some of their liquid and bitterness. After 30 minutes wash eggplant slices from salt and pat dry with a kitchen towel. In a large bowl/plate place breadcrumbs and sesame seeds. In another bowl beat 2 eggs with pinch salt and pepper. Heal oil in a large skillet over high heat. Dip eggplant slices in egg, then in crumbs, and place in hot oil. Fry 2 to 3 minutes on each side, or until golden brown. Drain on a paper towel.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 7 ingredients, 90 min)

### mdb-53073
**Eggplant Adobo** · Vegetarian · area: Filipino
- ingredients: 1 lb Aubergine, 2 tbs Sugar, 1 tsp Salt, 1 tsp Black Pepper, 1 whole Garlic, 3 tbs Olive Oil, 4 oz Pork Mince, 3 tbs Rice Vinegar, 2 tbs Soy Sauce, 2 Bay Leaf
- method (9 steps): Slice 1 lb. small Japanese or Italian eggplant (about 3) into quarters lengthwise, then cut crosswise into 2"-wide pieces. Place in a medium bowl. Add 1 Tbsp. sugar, 1 tsp. Diamond Crystal or ½ tsp. Morton kosher salt, and ½ tsp. freshly ground black pepper. Toss to evenly coat eggplant and let sit at room temperature at least 20 minutes and up to 2 hours. Peel and thinly slice 8 garlic cloves. Add 3 Tbsp. vegetable oil and half of garlic to a medium Dutch oven or other heavy pot. Cook over medium-high heat, stirring constantly with a wooden spoon, until light golden and crisp, about 5 minutes…
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy', 'saucy'] (0.50, keywords: crispy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 10 ingredients, 185 min)

### mdb-53074
**Grilled eggplant with coconut milk** · Vegetarian · area: Filipino
- ingredients: 6 Aubergine, 1 can Coconut Milk, 1 tbs Lemon Juice, 1 tsp Salt, To taste Chilli Flakes, 4 Sticks Onion
- method (4 steps): . Prepare the eggplants for grilling by pricking them all over with a fork. This is so it won’t burst during the grilling process as the natural water in it heats up. Grill the eggplants, turning them over frequently to ensure even cooking. Grill until the skins are dark brown, even black and the eggplant is soft when you touch it. Soak the grilled eggplant in a bowl of water to cool it down. Peel the skin off the eggplant. Place the whole eggplants in a shallow dish (my mom actually cuts the eggplant into small, bite-sized pieces). In a small mixing bowl, mix together the coconut milk or crea…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 45 min)

### mdb-53075
**Tortang Talong** · Vegetarian · area: Filipino
- ingredients: 4 Aubergine, 2 Egg, 1 tsp Salt, 4 tsp Olive Oil
- method (8 steps): Grill the eggplant until the color of skin turns almost black. Let the eggplant cool for a while then peel off the skin. Set aside. Crack the eggs and place in a bowl. Add salt and beat. Place the eggplant on a flat surface and flatten using a fork. Dip the flattened eggplant in the beaten egg mixture. Heat the pan and pour the cooking oil. Fry the eggplant (that was dipped in the beaten mixture). Make sure that both sides are cooked. Frying time will take you about 3 to 4 minutes per side on medium heat.
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 4 ingredients, 20 min)

### mdb-53077
**Cabbage Soup (Shchi)** · Vegetarian · area: Russian
- ingredients: 3 tbs Butter, 1 large Onion, 1 medium Cabbage, 1 Carrot, 1 Celery, 1 Bay Leaf, 8 cups Vegetable Stock, 2 large Potato, 2 large Tomato, Garnish Sour Cream, Garnish Dill
- method (7 steps): Add the butter to a large Dutch oven or other heavy-duty pot over medium heat. When the butter has melted, add the onion and sauté until translucent. Add the cabbage, carrot, and celery. Sauté until the vegetables begin to soften, stirring frequently, about 3 minutes. Add the bay leaf and vegetable stock and bring to a boil over high heat. Reduce the heat to low and simmer, covered, until the vegetables are crisp-tender, about 15 minutes. Add the potatoes and bring it back to a boil over high heat. Reduce the heat to low and simmer, covered, until the potatoes are tender, about 10 minutes. Add…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 11 ingredients, 55 min)

### mdb-53079
**Fish Soup (Ukha)** · Seafood · area: Russian
- ingredients: 2 tbs Olive Oil, 1 sliced Onion, 2 medium Carrot, 3 cups Fish Stock, 3 cups Water, 4 large Potato, 3 Bay Leaf, 1 Cod, 1 Salmon
- method (4 steps): In a medium pot, heat the olive oil over medium-high heat. Add the onions and cook, stirring occasionally until the onions start to caramelize. Add the carrots and cook until the carrots start to soften, about 4 more minutes. Add the stock, water, potatoes, bay leaves, and black peppercorns. Season with salt and bring to a boil. Reduce heat, cover and cook for 10 minutes. Add the millet and cook for 15 more minutes until millet and potatoes are cooked. Gently add the fish cubes. Stir and bring the soup to a simmer. The fish will cook through very fast, so make sure to not overcook them. They a…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 30 min, technique: caramelize)

### mdb-53080
**Blini Pancakes** · Side · area: Russian
- ingredients: 1/2 cup Buckwheat, 2/3 Cup Plain Flour, 1/2 tsp Salt, 1 tsp Yeast, 1 cup Milk, 2 tbs Butter, 1 Seperated Egg
- method (11 steps): In a large bowl, whisk together 1/2 cup buckwheat flour, 2/3 cup all-purpose flour, 1/2 teaspoon salt, and 1 teaspoon yeast. Make a well in the center and pour in 1 cup warm milk, whisking until the batter is smooth. Cover the bowl and let the batter rise until doubled, about 1 hour. Enrich and Rest the Batter Stir 2 tablespoons melted butter and 1 egg yolk into the batter. In a separate bowl, whisk 1 egg white until stiff, but not dry. Fold the whisked egg white into the batter. Cover the bowl and let the batter stand 20 minutes. Pan-Fry the Blini Heat butter in a large nonstick skillet over …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy', 'smooth'] (0.50, keywords: crispy, fluffy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 7 ingredients, 105 min)
