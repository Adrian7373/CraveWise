# AI tagging batch 034

Write `tools/seedgen/tags/ai/batch-034.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53460
**Bajan Sweet Bread** · Side · area: none
- ingredients: 2 1/2 cups Desiccated Coconut, 1/2 cup Butter, 4 cups Plain Flour, 1 tablespoon Shortening, 1 tablespoon Baking Powder, 1 tsp Salt, 3/4 cup Sugar, 1 cup Raisin, 1 beaten Egg, 1 1/4 cup Evaporated Milk, 1 tsp Almond Extract
- method (10 steps): Add all the flour, baking powder, and salt to a large mixing bowl. Melt the butter in a saucepan. Mix the coconut and most of the sugar in another bowl – leave some back to cover the loaves later, raisins, egg, milk, almond essence, vanilla essence, and melted butter. Mix well until you have a creamy paste. Add this to the bowl with the flour, baking powder, and salt. Mix until you form a stiff dough. Now divide the mixture between the baking tins. Now boil the water. Mix two tablespoons of sugar with some hot water and brush the top of each loaf. Bake in the center of the oven for 1 hour. Lea…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 11 ingredients, 85 min)

### mdb-53461
**Macaroni Pie** · Pasta · area: none
- ingredients: 250g Macaroni, 1 tablespoon Butter, 375g Cheddar, 1 Egg, 250ml Milk, 2 tsp Ground Onion, 1 tsp Mustard, 1 tsp Black Pepper, 1 tsp Salt, 1/2 tsp Cayenne Pepper, 2 tablespoons Breadcrumb, 2 tsp Butter, 2 tablespoons Cheddar
- method (6 steps): Bring water to a boil and add the broken-up macaroni, elbows, and salt. Cook uncovered until tender but not overcooked (about 8 minutes). Preheat a moderately hot oven to 350F, 180C, or Gas Mark 4. Drain the macaroni thoroughly, put it back into the same hot saucepan cooked in, and mix in the butter. Grate the cheese and mix it with the macaroni while it is still warm. Whisk the egg until fluffy, and add the milk, onion powder, white pepper, salt, pepper sauce, and mustard. Pour in with the macaroni and mix. Place in a greased ovenproof casserole dish. Top with butter, some grated cheese, and …
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['fluffy', 'saucy'] (0.50, keywords: fluffy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 13 ingredients, 70 min)

### mdb-53462
**Cinnamon Roll Cookies** · Dessert · area: none
- ingredients: 250g Plain Flour, 180g Butter, 85g Sugar, 1 medium Egg, Pinch Salt, 2 tsp Cinnamon, 30g Brown Sugar
- method (9 steps): In a large bowl, combine the butter and caster sugar until creamy. Add the egg and a pinch of salt. Stir into a buttery mixture. Add the sifted flour. Whisk well. You should end up with a smooth dough. Cover it with a piece of plastic wrap and put the dough in the fridge for 15 minutes to chill and set. In the meantime combine the cassonade (or brown sugar) and the cinnamon. Transfer the dough onto a floured surface and knead it for a minute. Add extra flour if necessary. Roll the dough out gently into a nice rectangle. It should be about ⅕-inch (5 mm) thick. Sprinkle with the sugary cinnamon …
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'creamy', 'smooth'] (0.50, keywords: chewy, creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 7 ingredients, 85 min, technique: knead)

### mdb-53463
**Belgian Meatballs in Liège Syrup Sauce** · Beef · area: none
- ingredients: 300g Beef Mince, 300g Pork Mince, 1 chopped Onion, 1 clove peeled crushed Garlic, 1 Egg, 4 tablespoons Breadcrumb, 1 tablespoon Mustard, 1 tablespoon Parsley, Pinch Salt, Pinch Black Pepper, Splash Vegetable Oil, 2 sliced Onion, 1 tablespoon Butter, 1 tablespoon Brown Sugar, 2 tablespoons White Wine Vinegar, 2 tablespoons Mustard, 4 tablespoons Sirop de Liege, 1 cup Beef Stock, 1 Bay Leaf, Splash Beer
- method (23 steps): Make the meatballs. Mix the minced meat with the onion, garlic, egg, breadcrumbs, mustard, parsley, salt, and pepper. Shape into meatballs. Traditionally, Liège restaurants serve **one or two very large meatballs**, depending on appetite. For weeknight cooking, I keep mine smaller so they brown faster and cook through quickly. Brown the meatballs. Heat butter or oil in a large pan. Brown the meatballs on all sides until they have a nice crust. Remove them from the pan and set aside. Start the sauce. In the same pan, melt 1 tbsp butter. Add the sliced onions and cook until soft and lightly cara…
- `cuisine` rule: 'Belgian' (0.60, title mentions 'Belgian')
- `textures` rule: ['creamy', 'saucy', 'smooth'] (0.50, keywords: creamy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 23 steps, 20 ingredients, 65 min, technique: caramelis)

### mdb-53464
**Flemish Hutsepot** · Pork · area: none
- ingredients: 600g Potato, 200g Carrot, 200g Turnip, 250g Leek, 4 Sausage, 1 small Onion, 3 cloves Garlic, 2 Bay Leaf, 4 sprigs Thyme, 600ml Chicken Stock, 1 tablespoon Mustard, 1 tablespoon Butter, Pinch Salt, Pinch Black Pepper
- method (6 steps): Peel and chop the onion and garlic. Add both to a large pan with the butter and place it over medium heat. Let the onion and garlic sweat for 5 minutes. Then add the chopped potatoes, bay leaves and thyme and stir well. Cook for another 5 minutes. In the meantime peel and slice the carrots. Peel the turnip. Dice it into bite-size pieces. Slice the leek in half lengthwise. Rinse it well to remove any sand. Add the vegetables to the potatoes and onion. Also add the mustard and chicken stock and season with pepper and salt. Stir all the ingredients well and cover the pan with a lid. Cook the huts…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 14 ingredients, 70 min)

### mdb-53465
**Frog Legs Recipe in Garlic Butter** · Miscellaneous · area: none
- ingredients: 300g Frogs Leg, 3 Cups Milk, 1 tablespoon Olive Oil, 1/2 tbs Garlic, 2 tablespoons Butter, 1 tablespoon Parsley, Pinch Salt, Pinch Black Pepper
- method (6 steps): Let the frog legs soak in the milk in the fridge for an hour (optional). Rinse the legs and pat them dry with kitchen paper. Add the olive oil and half of the garlic butter to a large wok or frying pan. Place it over high heat until the butter starts to foam. Don't let it burn. Add the frog legs to the pan. Pan fry them for about 10 minutes until they are golden brown on both sides. Turn the over regularly. Add the rest of the garlic butter right in the end together with the freshly chopped parsley. Season with a pinch of pepper and salt to taste. Divide the frog legs over plates. Serve with g…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'indulgent', 'light'] (0.50, keywords/category: fresh, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 90 min)

### mdb-53466
**Belgian Waterzooi Chicken** · Chicken · area: none
- ingredients: 1 Chicken Leg, 1 Chicken Breast, 3 Cups Water, 1 small Carrot, 2 Leek, 1 Celery, 100g Potato, 2 cloves Garlic, 1 Sprig Rosemary, 1 1/2 cups Cream, 2 Bay Leaf, 1 tablespoon Butter, 1 Egg Yolk, Pinch Black Pepper, Pinch Salt
- method (8 steps): Put the chicken, water and one garlic clove in a large saucepan. Place it over medium-high heat until boiling. Then turn the heat low, cover the pan and simmer the chicken for 10 minutes. Remove the chicken leg and breast. Keep the fresh chicken stock for later. Let the chicken cool. Then dice the chicken breast up. Pick the meat off the leg. Discard any bones and skin. Slice the leek, celery and carrot finely (julienne). Add the butter, rosemary and bay leaves to a large pan and place it over medium heat until melted. Then add the sliced vegetables. Season with pepper and salt. Stir and cook …
- `cuisine` rule: 'Belgian' (0.60, title mentions 'Belgian')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'tender'] (0.50, keywords: creamy, saucy, tender)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 15 ingredients, 80 min)

### mdb-53467
**Liegeoise Salad** · Vegetarian · area: none
- ingredients: 350g Potato, 200g Green Bean, 2 Egg, 125g Bacon, 2 tbs chopped Onion, 3 tablespoons Olive Oil, 2 tablespoons White Wine Vinegar, 1 tsp Mustard, 2 tablespoons Parsley, Pinch Black Pepper, Pinch Salt
- method (5 steps): Scrub the potatoes well but don't peel them. Cut them into bite-size pieces. Add them to a large pan water and a pinch of salt. Bring it to a good boil. Cook the potatoes until tender and then remove them using a slotted spoon. Keep the potatoes at room temperature. Trim and clean the green beans. Add them to the pan of hot water you boiled the potatoes in. Cook the green beans until nearly tender (keep them crunchy). Strain and refresh them immediately under cold running tap water to stop the cooking process. Add the bacon to a large non-stick pan and place it over medium heat. Cook the bacon…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 35 min)

### mdb-53468
**Belgian Stoemp** · Pork · area: none
- ingredients: 2 Sausage, 450g Potato, 200g Savoy Cabbage, 3 cloves Garlic, 1 Handfull Parsley, 1 small finely diced Onion, 3 tablespoons Butter, 1 cup Beer, 60ml Milk, Pinch Ground Nutmeg, Pinch Black Pepper, Pinch Salt
- method (8 steps): Add the chopped potatoes and garlic to a high pan and fill it with tap water until the potatoes are fully submerged. Add some salt. Then place the pan over high heat and bring the potatoes to a boil. Cook them until tender. In the meantime rinse and drain the savoy cabbage. Slice it up finely. Add a tablespoon of butter to a large non-stick pan. Place it over medium-high heat. Once melted, add the savoy cabbage. Season with a pinch of pepper and salt. Stir fry the cabbage for 15 to 20 minutes or until the cabbage is soft and tender. Then turn the heat off and take the cabbage off the heat. In …
- `cuisine` rule: 'Belgian' (0.60, title mentions 'Belgian')
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 12 ingredients, 60 min)

### mdb-53469
**Beef pumpkin Stew** · Beef · area: none
- ingredients: 3 Lbs Beef, 1/2 cup Plain Flour, 3 tablespoons Butter, 1 cup Onion, 1 clove peeled crushed Garlic, 4 cups Beef Stock, 3 Cups Pumpkin Puree, 1 tablespoon Worcestershire Sauce, 1 tablespoon Salt, 1 teaspoon Black Pepper, 3 Lbs Potato, 1 lb Carrot, 4 sprigs Thyme
- method (4 steps): Cut the beef into 1-inch chunks. Dredge the beef in the flour until all of the beef sides are covered. In a large soup pot, melt the butter over medium high-heat. In small quantities, brown the beef on all sides, removing the browned beef and setting it aside in a large bowl as you go. When the beef is browned, add the onion and the garlic to the pot. Sauté the onion and garlic for one minute, scraping the bottom of the pot as you stir. Return the browned beef to the pot and add the beef stock, pumpkin puree, Worcestershire sauce, salt, and pepper. Stir well and bring to a boil. Once the liqui…
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'saucy', 'smooth'] (0.50, keywords: brothy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 13 ingredients, 240 min)

### mdb-53470
**Seswaa** · Beef · area: none
- ingredients: 1 kg Beef, 1 Onion, 3 Bay Leaf, To taste Salt, Sprinkling Black Pepper, 1 Litre Water
- method (4 steps): Pre heat the oven to 160 degrees Celsius. Cut the meat into large chunks then brown in a dish suitable for slow cooking in the oven such as a cast iron casserole dish. Add the whole peeled onion, salt, cracked black pepper, water and bay leaves. Bring to the boil then cover and place into the oven for 4 hours. After 4 hours, remove from oven and place onto the stove burner in order to cook off most of the remaining liquid. Use a wooden spoon to pound or mash up the meat, the meat should fall apart quite easily. and will appear shredded. You may brown the meat further if desired. Check seasonin…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'saucy', 'tender'] (0.50, keywords: creamy, saucy, tender)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 6 ingredients, 500 min)

### mdb-53471
**Phaphatha Flatbreads** · Side · area: none
- ingredients: 500g Plain Flour, 1 tablespoon Baking Powder, 1 1/2 tsp Salt, 2 tsp Sugar, 1 cup Milk
- method (7 steps): In a stand mixer bowl, combine the dry ingredients: flour, baking powder, salt, and sugar. With the dough hook on low, drizzle in the milk. Continue to knead until a small ball of dough is formed. Remove the dough from the bowl, oil the bowl lightly, and return the ball of dough to the bowl. Cover and set aside to rest for 15-30 minutes. Divide the ball of dough into 12 portions, in roughly even lumps. Heat a small amount of oil in a large, flat skillet. Flatten a ball of dough with your palm and work it into a slightly larger round with the back of your hand, leaving it a thick round about 10…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 5 ingredients, 35 min, technique: knead)

### mdb-53472
**Madombi: Dumplings from Botswana** · Miscellaneous · area: none
- ingredients: 1 1/4 cup Water, 2 tsp Sugar, 2 1/2 Tsp Yeast, 3 Cups Plain Flour, 1 1/2 tsp Salt
- method (8 steps): This recipe requires a stew to steam the dumplings on top of, at abour 180℃ or 350℉, give or take (it doesn't have to be specific, but can't be very high or very love heat). You will add the dumplings in during the last thirty minutes of your stew's cooking time, They need to steam covered, so the stew should be in a lidded pot that is oven-proof. Mix the dumpling dough In a measuring cup, combine the warm water, sugar, and yeast. Leave until foamy, about 5 minutes. To a stand mixer bowl, or a large bowl if mixing by hand, add the flour and salt. Stream in the water-yeast mixture while kneadin…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['fluffy', 'saucy', 'smooth'] (0.50, keywords: fluffy, saucy, smooth)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 8 steps, 5 ingredients, 165 min, technique: knead, proof)

### mdb-53473
**Curried Spinach from Botswana** · Side · area: none
- ingredients: 1 bunch Spinach, 2 medium Tomato, 1 small Onion, 2 tablespoons Vegetable Oil, 2 tsp Curry Powder, To taste Salt, 1/4 cup Water
- method (4 steps): Heat the oil in a skillet over medium heat. When hot, add the diced onion and cook until lightly browned. Add the curry powder and salt to taste and toast for a few seconds. Add the chopped tomatoes and the water, stir well, and cook until the tomatoes begin to break down, 5-7 minutes. Add in the chopped (or baby) spinach and cook for 7-10 minutes more, until soft and wilted.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 35 min)

### mdb-53474
**Magwinya: Doughnut Bites from Botswana** · Dessert · area: none
- ingredients: 300g Plain Flour, 1/4 cup Water, 2 tablespoons Sugar, 1 1/2 tsp Yeast, 1/4 tsp Salt, 1 1/2 tsp Vegetable Oil, 1/2 cup Icing Sugar, 2 cups Vegetable Oil
- method (9 steps): Mix the dough In a stand mixer bowl. add the water, sugar, and yeast. Leave to get foamy, about 5 minutes. Add in the flour, salt, and vegetable oil. Knead with a dough hook until a smooth dough forms, about 5 minutes. Leave the dough to rise Remove the dough from the mixer bowl and form into a ball. Lightly mist the bowl with oil and replace the ball of dough into it. Cover the bowl and let rise in a warm place, 1 to 1½ hours, until doubled. Shape and fry the doughnuts Preheat about 5cm (2") of vegetable oil in a pot to 180℃ / 350℉ – you can use a smaller pot needing less oil to fill but cook…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crispy', 'crunchy'] (0.50, keywords: chewy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 8 ingredients, 95 min, technique: knead)

### mdb-53475
**Brazilian chocolate truffles - brigadeiro** · Dessert · area: none
- ingredients: 3 tablespoons Butter, 400g Condensed Milk, 4 tablespoons Cocoa Powder, 1 tsp Vanilla Extract, 50g Pistachio, 50g Almond, 50g Desiccated Coconut
- method (3 steps): In a medium heavy-based saucepan, heat the butter, condensed milk, a pinch of salt and the cocoa, to boiling, stirring constantly with a wooden spoon. Reduce the heat to medium-low; cook for 10-15 mins, stirring constantly, until the mixture is thick and shiny and starts to pull away from the bottom. Stir in the vanilla and vigorously mix again. Pour the mixture onto a buttered plate. Chill for at least 2 hrs. Butter your hands and pinch off some of the dough to make 2.5cm balls. Place your toppings into small bowls and roll the balls of one of the decorations. Place in mini paper baking cups …
- `cuisine` rule: 'Brazilian' (0.60, title mentions 'Brazilian')
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 7 ingredients, 145 min)

### mdb-53476
**Brazilian cheese bread (pão de queijo)** · Side · area: none
- ingredients: Drizzle Vegetable Oil, 250ml Milk, 125g Butter, 1 tsp Salt, 300g Tapioca, 2 Egg, 100g Parmesan
- method (5 steps): Heat the oven to 220C/200C fan/gas. Oil or butter a baking sheet and set aside. Heat the milk, butter and salt in a medium saucepan and bring to a boil. Remove from the heat and add the tapioca flour. Stir vigorously, then leave to cool a little. Pour the dough into a standing mix to beat the dough until its cool, or use a wooden spoon and beat by hand. Beat the eggs in one at a time, waiting until each is completely incorporated before adding the next. When the dough is glossy and mixed, add the parmesan. Beat again until mixed. Spoon the dough onto the baking sheet in 1 tbsp balls, 5cm apart…
- `cuisine` rule: 'Brazilian' (0.60, title mentions 'Brazilian')
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'crispy'] (0.50, keywords: chewy, crispy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 7 ingredients, 45 min)

### mdb-53477
**Coconut quindim** · Dessert · area: none
- ingredients: 2 tablespoons Butter, 10 Egg Yolk, 100g Sugar, 300ml Coconut Milk, 50g Desiccated Coconut, 1 tsp Vanilla Extract
- method (5 steps): Heat oven to 180C/160C fan/gas. Rub 4 ramekins, about 175ml capacity, or dariole moulds liberally with the soft butter. Sprinkle with the caster sugar to coat. In a medium bowl, press the egg yolks through a wire sieve and mix with the coconut milk, sugar, coconut and vanilla. Pour into ramekins and place in a large roasting tin in the oven. Pour water into the roasting tin to three-quarters up the ramekins so it acts like a bain marie or water bath for the quindim. Bake for 30-35 mins until the tops are golden. Take the ramekins out of the water and leave to cool for 5 mins. Chill for 4 hrs a…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 6 ingredients, 290 min, technique: bain, water bath)

### mdb-53478
**Grilled corn with garlic mayo & grated cheese** · Vegetarian · area: none
- ingredients: 6 Corn On the Cob, 2 cloves minced Garlic, 6 tablespoons Mayonnaise, 4 tablespoons Parmesan, 2 tablespoons Coriander, 1 Lime
- method (2 steps): Boil the corn cobs for 5 mins. Leave in the water until you’re ready to grill them. Mix the garlic and mayonnaise in a small bowl. Just before barbecuing, remove the cobs from the pan, pat dry and rub the mayonnaise into each one. Season the cobs and grill them until marks appear, about 5 mins. Remove and scatter over the Parmesan and coriander. Squeeze lime over to serve.
- `cuisine` rule: none
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 6 ingredients, 25 min)

### mdb-53479
**Smoky tomato pepper salsa** · Side · area: none
- ingredients: 1 small Red Onion, Bunch Coriander, 125g Cherry Tomato, 1/2 Red Pepper, 3 tablespoons Olive Oil, 2 tablespoons Red Wine Vinegar, 1 1/2 tsp Paprika, Pinch Sugar
- method (1 steps): Put all the ingredients in a food processor and pulse until chopped, but not too fine. Pour into a serving bowl and add seasoning and a pinch of sugar.
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 8 ingredients, 40 min)
