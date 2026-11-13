# AI tagging batch 039

Write `tools/seedgen/tags/ai/batch-039.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53560
**Mini butter buns** · Side · area: none
- ingredients: 4-5 pound Strong White Flour, 6 cups Milk, 3 tablespoons Sugar, 1 ½ tbsp Yeast, 2 1/2 Tsp Salt, 10 tblsp Butter, 2 Egg
- method (3 steps): Combine the flour, the sugar, yeast, and salt in a mixing bowl or large bowl Add warm milk and start kneading dough Once the dough is smooth and elastic, add the butter and continue kneading Allow the dough to rise in a covered bowl until it’s doubled in bulk, about 90 minutes. Turn the dough out onto a lightly floured surface, divide dough and round all of the pieces into smooth balls. Lightly grease pans Place dough on pan Cover the pans, and let the loaves rise until they're puffy and soft Using a brush, add egg whites to loaves Towards the end of the rising time, preheat the oven to 375°F …
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 7 ingredients, 140 min, technique: knead)

### mdb-53561
**Codfish deviled eggs** · Seafood · area: none
- ingredients: 12 Egg, 7 tablespoons Mayonnaise, 1 tsp Mustard, To taste Black Pepper, To taste Salt, Pinch Paprika, Garnish Chive, Garnish Black Pepper, Topping Salt Cod
- method (2 steps): Bring eggs to a boil for 15 minutes. Let eggs sit in the water for another. Run under cold water let eggs further cool Rest eggs Peel eggs Cut eggs in half and remove egg yolks, place them in bowl Mash egg yolks in a bowl Combine all ingredients except for chives and peppercorns Put the mixture in a piping bag or plastic bag Fill egg slices with the mixture Add codfish on the wider side of the egg Garnish with crushed peppercorn and chive.
- `cuisine` rule: none
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 40 min, technique: piping)

### mdb-53562
**Breadfruit Tacos** · Side · area: none
- ingredients: 1 Breadfruit, 1 pot Water, As required Salt Cod, As required Lettuce, For frying Vegetable Oil
- method (5 steps): Place a large pot of water to boil, add breadfruit, and let it cook for around 30 minutes Remove breadfruit from pot and let it cool for a few minutes Hold the breadfruit firmly and using a large sharp knife slice into thin rounds Slice as many as you need Then cut off skin and core (You may leave the core on if you like) Gently fold to shape like a taco shell, use two toothpicks to hold it in place. Place on a large plate or tray and repeat this process for all breadfruit slices Heat oil for deep frying, using a pair of tongs submerge breadfruit slices in pan, You can guide slices with tongs …
- `cuisine` rule: none
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 5 ingredients, 55 min, technique: deep fr)

### mdb-53563
**Dominica mastiff bread** · Side · area: none
- ingredients: 3 Lbs Plain Flour, 1 ½ tbsp Brown Sugar, 1 ½ tbsp Salt, 2 tablespoons Yeast, 1/2 cup Shortening, 3 cups Water, Dusting Plain Flour
- method (3 steps): Mix all dry ingredients in a large bowl (sugar, salt and instant yeast) Mix with a large wooden spoon Add shortening or lard and mix Mix thoroughly with your hand Add warm water and mix the dough until stiff Add more flour so that dough doesn't stick You can add dough onto a floured board to make sure that it's properly kneaded Knead for approximately 8-10 minutes Shape dough into a large round shape and cover to rest for 45 minutes Knead dough again on a lightly floured surface (kneading is the most critical part of this recipe process. Shape dough into your desired bread designs and place on…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 3 steps, 7 ingredients, 130 min, technique: knead)

### mdb-53564
**Cassava bread** · Side · area: none
- ingredients: 3 Cups Farine, 3 Cups Water, 1 cup Cassava Flour, Pinch Salt
- method (1 steps): Mix dry ingredients in a bowl Add water and mix well When mixture has achieved a doughy like consistency, roll into little balls Roll balls with the palm of your hands, and flatten slightly like s disk In a plate, cover balls with the rest of the farine to create a very course texture Place on a hot heavy cast iron griddle pressing down to flatten with and roast on both sides until lightly brown Remove and serve or add your special accompaniment.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['hearty'] (0.50, keywords/category: hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 4 ingredients, 30 min)

### mdb-53565
**Chicken Lollipop** · Chicken · area: none
- ingredients: 2 Lbs Chicken Wing, 1 tablespoon Black Pepper, 1 tablespoon Paprika, 1 tablespoon Garlic, 1 tablespoon Salt, 4 tablespoons Cornflour
- method (1 steps): Wash chicken with lemon Drain and season chicken Using shears, cut through the meat at the tip of the drumettes Add all seasoning ingredients to the drumettes Pour oil into a deep fryer, or saucepan to the level of about 5 inches so that the chicken will be submerged Fry until medium brown, add your favorite sauce (I used honey garlic barbecue sauce) to place in the oven Or fry until golden brown if you're not putting it in the oven Using a silicon brush add sauce to chicken and place in the oven.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Chicken guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 6 ingredients, 45 min, technique: deep fr)

### mdb-53566
**plantain rolls** · Side · area: none
- ingredients: 3 Plantain, 1 cup Vegetable Oil, 1/2 lb Salt Cod, 1/4 cup Parsley
- method (3 steps): Peel plantains Slice them in ¼ inch slices (horizontally) Heat oil in the frying and add your plantain slices to the pan fried plantain rolls When they start getting golden brown, turn them over Remove from the frying pan when both sides are brown, and place them on a plater lined with paper towel to absorb the oil Place codfish bulljaw on the end of your plantain slice and roll it Secure the roll with the toothpick or skewer (I like using knotted bamboo) Garnish and enjoy!
- `cuisine` rule: none
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 4 ingredients, 40 min)

### mdb-53567
**Dominican Bakes** · Starter · area: none
- ingredients: 4 cups Plain Flour, 1 tablespoon Baking Powder, 1 tablespoon Salt, 1/2 tbs Sugar, 2 cups Milk, 1 ½ tbsp Butter, 2 cups Vegetable Oil
- method (9 steps): Combine dry ingredients and mix (flour, salt, and baking powder) Add lightly melted butter mix. Gradually add lukewarm milk. Gently knead the dough with hands. The dough should not be firm but with a sticky consistency. Separate into small portions in the shapes of balls based on the desired size. Let the balls rest for 15 – 20 minutes covered with a towel or saran wrap. Flatten dough using hands, using your thumb to press dough in Deep fry in a saucepan (I use a saucepan because the frying pan is too wide, and I'll need to use too much oil to deep fry). Use medium heat. Turn over on the other…
- `cuisine` rule: 'Dominican' (0.60, title mentions 'Dominican')
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Starter guess)
- `difficulty` rule: 'medium' (0.55, 9 steps, 7 ingredients, 45 min, technique: deep fr, knead)

### mdb-53568
**Apple pie pops** · Dessert · area: none
- ingredients: 1 tablespoon Sugar, 1 1/2 cups Plain Flour, 1 tsp Salt, 4 oz Butter, 1 tablespoon Shortening, 1/4 cup Water, 1 lb Apple, 1/4 cup Brown Sugar, 1 tsp Cinnamon, 3 tablespoons Butter, 1/2 tsp Ground Nutmeg, 1/2 tsp Salt, 3/4 teaspoon Lemon Juice, Topping Sugar, 1 Egg, 2 tsp Water
- method (16 steps): Need Lollipop sticks. Instructions for crust Combine the flour, sugar, and salt to a food processor bowl. Mix using the pulse setting. Add butter and shortening and pulse about 10 -12 times until the texture is changed to small pebbles. Add ¾ of the ice water and pulse a few more times until the dough takes the shape of a ball. Add more water as needed. Don't overmix. Don't worry if the dough isn't completely blended. You will use your rolling pin to finish creating the crust. Place dough ball onto the counter and flatten into a flat disc. Wrap it in plastic wrap and refrigerate for at least a…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 16 steps, 16 ingredients, 115 min)

### mdb-53569
**Creamy mango smoothie** · Dessert · area: none
- ingredients: 3 Large Mango, 1 tsp Vanilla Extract, 1/2 cup Condensed Milk, Large handful Ice
- method (3 steps): Peel mangoes and slice Cut two of the mangoes into chunks Blend all ingredients until smooth and creamy Pour in a glass Mango rose Cut two of the largest opposite slices Lay them down on a cutting board Using a sharp knife, create small ¼ inch slices. Cut the mango slightly diagonally to get longer pieces. Create a circular bud with one slice, build around it with the other slices, placing them individually the previous row to take on the form of a rose. Repeat this until you've arrived at your desired size.
- `cuisine` rule: none
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 4 ingredients, 55 min)

### mdb-53570
**Layered mango custard** · Dessert · area: none
- ingredients: 1 ½ tbsp Custard, 3 Cups Double Cream, 3 Cups Milk, 1/3 cup Sugar, 6 tablespoons Water, 1 ½ tbsp Vanilla Extract, Garnish Mint, Garnish Mango, Topping Mango, 5 tablespoons Water, To taste Sugar
- method (7 steps): For the pudding custard Combine water and gelatin in a bowl Let it rest for about 7-10 minutes Combine cream, milk and sugar and heat for a few minutes until all the sugar melts. Do not boil. Take it off the stovetop and let it rest for about 5 minutes Add gelatin mixture and stir. Add vanilla essence. Pour mixture into small glasses at an angle. It's really rich so the smaller glasses will help reduce the serving. Transfer to refrigerator to chill for a minimum of 4 hours. ( I kept mine in the refrigerator overnight) Please don't put it in the freezer. For the mango puree When you're ready to…
- `cuisine` rule: none
- `textures` rule: ['creamy', 'smooth'] (0.50, keywords: creamy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 11 ingredients, 400 min)

### mdb-53571
**Dominica’s coconut rough cake** · Dessert · area: none
- ingredients: 4 cups Plain Flour, 1 cup Oats, 1 1/2 cup Brown Sugar, 2 cups Desiccated Coconut, 1 tsp Vanilla Extract, 2 1/2 cups Coconut Milk, 1 tsp Bicarbonate of Soda, 1/2 tsp Baking Powder, 1 ½ tbsp Cinnamon, 1 ½ tsp Ground Nutmeg, Zest of 1 Lime, 1/4 cup Raisin
- method (2 steps): Mix all dry ingredients in bowl Add coconut milk to dry ingredients Grease baking pan with vegetable oil I use an ice cream scoop to form drops. I placed the scooped cake mixture on a baking sheet. I also used a cake mold and gently pressed the mixture in. You can use a baking pan as well. Preheat your over at 350° Bake for 25 to 35 minutes or until brown.
- `cuisine` rule: none
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 12 ingredients, 50 min)

### mdb-53572
**Fried cocoy banana** · Dessert · area: none
- ingredients: 1 tablespoon Cinnamon, 7 Cocoy Banana, 2 Egg, 1 1/2 cup Breadcrumb, 5 Cups Vegetable Oil
- method (1 steps): Peel cocoys Mix eggs and cinnamon in a bowl Dip cocoy in mixture, then coat in the panko breadcrumbs Heat oil at medium heat Place cocoy in hot oil Turn with a tong Remove from pan when golden brown.
- `cuisine` rule: none
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 1 steps, 5 ingredients, 45 min)

### mdb-53573
**Papaya salad** · Vegetarian · area: none
- ingredients: 1/2 Green Papaya, 1 tablespoon Lemon Juice, To taste Salt, 1 Carrot, 1 cup Cherry Tomato, 1/2 cup Spring Onion, 1/4 cup Peanut, 1 tablespoon Garlic
- method (3 steps): Cut, peel and shred papaya. I used a hand julienne shredder. If you don't have a shredder, use a grater. Peel and shred carrots. Cut green onions really small Slice tomatoes down the middle I then combined all ingredients I topped it with the peanuts.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['fresh', 'light'] (0.50, keywords/category: fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 8 ingredients, 65 min)

### mdb-53574
**Quark and Rhubarb Pie** · Dessert · area: none
- ingredients: 100ml Milk, 10g Yeast, 1 tablespoon Sugar, 1 Egg, 25g Butter, 1/2 tsp Salt, 1/2 tsp Cardamom, 300ml Plain Flour, 200g Sweet Quark, 1 cup Rhubarb, Pinch Sugar, Pinch Cinnamon
- method (9 steps): All materials must be in room temperature Dissolve yeast with lukewarm (37C) milk and sugar Add about half of the quantity of flour, mixed with salt Beat the mixture for a short time. Sprinkle with a little flour , cover the bowl with a towel and place in a warm place to rise for ca 1 hour Add additional flour, cardamom add melted butter. Beat egg and leave ca 1 teaspoon for spreading.Add other beaten egg in to the dough Knead the dough properly, until it separates from the bowl. Sprinkle with a little flour , cover the bowl with a towel and place in a warm place to rise for ca 1 hour until do…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 12 ingredients, 165 min, technique: knead)

### mdb-53575
**Apple Pie** · Dessert · area: none
- ingredients: 4 Apple, 2 Egg, 125ml Sugar, 1 1/2 cups Plain Flour, 1/2 tsp Salt, 1 tsp Bicarbonate of Soda, 250ml Sour Milk
- method (2 steps): Peel and clean apples/rhubarb, cut in to a slices beat eggs and sugar together into a light foam Mix together flour, salt and baking powder Add the dry ingredients to the egg mixture and add sour milk gradually while stirring, Add berries. Pour dough in to a butter greased pan. Sprinkle over sugar (and cinnamon). Bake at 180 C for 30 minute.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 50 min)

### mdb-53576
**Carrot and Bean Fritters** · Vegetarian · area: none
- ingredients: 400g Carrot, 200g Canned Bean, 4 cloves Garlic, 1 tablespoon Plain Flour, 1 cup Breadcrumb, Pinch Thyme, Pinch Parsley, Pinch Salt, Pinch Black Pepper, Pinch Thyme, Splash Vegetable Oil
- method (4 steps): Pour the beans into the sieve, remove liquid. Grate carrots and add beans, Mix and mash together. Season with garlic, thyme, salt and pepper. Form the dough into round buns, dip them slightly into the bread crumbs, and press the fritters. Fry fritters in hot oil for a short time until the fritters are browned. Place on the greased or /baking paper-lined oven plate and bake at 200C for 10 minutes.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 11 ingredients, 35 min)

### mdb-53577
**Sauerkraut and Fish Salad** · Seafood · area: none
- ingredients: 200g Sauerkraut, 100g Smoked Haddock, 1 Egg, 2 sliced Rye Bread, 200g Vegetable Oil, Drizzle Honey, Pinch Salt
- method (2 steps): Boil eggs and toast bread slices. mix together salad dressing. NB! you can serve this salad with sour cream dressing. It would be different but still very delicious Mix together sauerkraut, sliced egg, fish and bread pieces. Serve.
- `cuisine` rule: none
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 50 min)

### mdb-53578
**Gingerbread Waffles** · Dessert · area: none
- ingredients: 100ml Plain Flour, 200ml Dark Beer, 50ml/2fl oz Milk, 1 Egg, 3 tablespoons Sugar, Pinch Salt, 1 teaspoon Gingerbread Spice, 1 tablespoon Butter
- method (2 steps): beat egg and sugar into a light foam sift together flour, salt and gingerbread spice. Add the dry ingredients to the wet mixture gradually while stirring Add milk and beer while stirring add melted butter Let set and bake waffles.
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 45 min)

### mdb-53579
**Honey Cookies** · Dessert · area: none
- ingredients: 50g Honey, 300ml Rye Flour, 100ml Water
- method (1 steps): Dissolve honey into water Add flour. Let set a few minutes. Knead the mixture for a short time. Using a teaspoon, form the dough into round buns/cakes and place on the greased or baking paper-lined oven plate Bake at 200 C for 10-15 minutes.
- `cuisine` rule: none
- `textures` rule: ['chewy'] (0.50, keywords: chewy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 3 ingredients, 20 min, technique: knead)
