# AI tagging batch 030

Write `tools/seedgen/tags/ai/batch-030.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53378
**Sesame Cucumber Salad** · Side · area: Chinese
- ingredients: 2 medium Cucumber, 1/2 tsp Salt, 2 tsp Sesame Oil, 2 tablespoons Rice Vinegar, 6 Basil, 1/2 tsp Chilli Flakes, 2 tsp Sesame Seed
- method (4 steps): Prep the cucumbers:. Peel the cucumbers. Cut them into quarters, lengthwise. (If the seeds are bitter, scrape out the seeds and discard.) Cut the cucumbers again, crosswise, into 1/2-inch thick pieces. Toss the salad:. Place cucumbers into a serving bowl. Sprinkle with salt. Toss with sesame oil, seasoned rice vinegar, basil (if using), and chili flakes. Sprinkle with toasted sesame seeds if using.
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 7 ingredients, 40 min)

### mdb-53379
**Dutch poffertjes (mini pancakes)** · Breakfast · area: Netherlands
- ingredients: 125g Plain Flour, 125g Buckwheat Flour, 2 Egg, 1 knob Butter, 300ml Milk, 10g Yeast, 1tsp Vanilla Sugar, To serve Butter, To serve Icing Sugar
- method (5 steps): Mix the dry yeast with some of the luke warm milk en stir until dissolved. Place buckwheat and the flour together in a bowl and make a small circle in the middle. Add the yeast mixture into it. Add the milk and stir until you have a smooth batter. Add the eggs, salt and vanille sugar and stir through. Leave to stand and rise for about 45 minutes. Heat the poffertjespan and add a bit of butter into each hole. Fill halfway with batter and first bake one side until you can see the top dry out a little. Turn the poffertjes around with a small fork and bake the other side until cooked and golden br…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'fluffy', 'smooth'] (0.50, keywords: crispy, fluffy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 15 (0.30, no durations in the method; Breakfast guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 80 min)

### mdb-53380
**Apple cake** · Dessert · area: Netherlands
- ingredients: 4 Egg, 200g Sugar, 200g Self Raising Flour, 200g Butter, 1 tsp Vanilla Extract, 1 tsp Cinnamon, 3 Apple, Pinch Salt, Sprinkling Icing Sugar
- method (10 steps): Preheat the oven to 180°C. (350˚F) Grease a cake pan and line it with baking paper. In a large bowl, break the four eggs with the sugar and beat until they have tripled in volume and become fluffy. Sift the self-rising baking flour and add it to your egg mixture. Fold this over, preserving as much air as possible. Add the melted (and slightly cooled) butter and mix until combined. Add cinnamon, pinch of salt and vanilla extract. Add the diced apple to the batter and gently fold them into the batter so that the apple pieces are evenly distributed. You can roll the apple pieces through some more…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'crunchy', 'fluffy'] (0.50, keywords: crispy, crunchy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 9 ingredients, 65 min)

### mdb-53381
**Gevulde speculaas** · Dessert · area: Netherlands
- ingredients: 300g Self Raising Flour, 150g Brown Sugar, 10g Speculaas Spice Mix, Pinch Salt, 125g Butter, 10 tblsp Milk, 300g Almond Paste, 1 Egg, For brushing Milk, Garnish Almond
- method (6 steps): Mix the self-rising flour, sugar, speculaas spice mix and salt. Add the butter and milk and knead into a firm ball of dough. Start with 6 tablespoons of milk, if the dough is too stiff you can add more milk. Wrap the dough in plastic wrap and refrigerate overnight. You can process and bake it immediately, but the flavor will be much better if you let it rest. Mix the almond paste with half of the beaten egg and knead well. This makes it easier to work with and gives it a better and tastier texture. Take half of the dough and roll it out to 20 x 20 cm. Place in a baking pan lined with parchment…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 10 ingredients, 545 min, technique: knead)

### mdb-53382
**Dutch stroopwafel** · Dessert · area: Netherlands
- ingredients: 15 ml Milk, 10g Yeast, 250g Plain Flour, 120g Butter, 80g Sugar, 1 Egg, Pinch Salt, 200g Dutch Stroop, 120g Brown Sugar, 80g Butter, 1 tsp Cinnamon
- method (9 steps): Combine milk and yeast in a bowl. Let stand for a moment to allow the yeast to dissolve. In another bowl, combine flour, butter, sugar, egg, and salt. Pour in the yeast mixture and knead until smooth. Cover the bowl and let the dough rise for one hour. When the dough is almost ready, make the stroop filling. Combine all the ingredients in a saucepan and stir until the butter is melted and the sugar is dissolved. Let it simmer for a while. The stroop will continue to thicken as it cools. Shape the dough into balls weighing about 35 grams each. Make a total of. Turn your stroopwafel iron on the …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 11 ingredients, 90 min, technique: knead)

### mdb-53383
**Ramen Noodles with Boiled Egg** · Miscellaneous · area: Chinese
- ingredients: 1 Packet Noodle, 2 cups Water, 1 large Egg, 1 tbsp Soy Sauce, 1/2 tsp Chilli Sauce, 1 tbls Spring Onion, 1/2 tsp Salt, 1/2 tbs Black Pepper
- method (4 steps): Boil: Bring water to a boil, gently add eggs, and cook for exactly 6½ to 7 minutes. Ice Bath: Immediately transfer the eggs to a bowl of ice water for 3–5 minutes to stop cooking. Marinate (Optional but recommended): Peel the eggs and marinate in a mix of 2 tbsp soy sauce, 2 tbsp mirin, 1 tsp sugar, and 4 tbsp water for at least 4 hours (or overnight). Serve: Slice in half, letting the yolk flow into the broth.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `moods` rule: ['hearty', 'light'] (0.50, keywords/category: hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 270 min)

### mdb-53385
**Boterkoek (Dutch Butter Cake)** · Dessert · area: Netherlands
- ingredients: 200g Butter, 200g Sugar, 250g Plain Flour, 1 Salt, 200g Dulce de Leche, 75g Dark Chocolate, 1 beaten Egg
- method (9 steps): Preheat the oven to 180°C/350˚F (conventional oven). Place the softened butter and sugar in the bowl of a stand mixer and whisk until creamy. Add the flour and salt and knead by hand until you have a smooth dough. Divide into two pieces. Line the base of a square or round cake tin with baking parchment (not a springform tin) and place the first half of the pastry on top. Flatten with your fingers and a spoon. Using a teaspoon, sprinkle dollops of dulce de leche over the base. Sprinkle with the chopped chocolate and cover with the second half of the pastry. This is a bit trickier, but if you do…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'flaky', 'smooth'] (0.50, keywords: creamy, flaky, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 7 ingredients, 50 min, technique: knead)

### mdb-53386
**Dutch Apple Pie** · Dessert · area: Netherlands
- ingredients: 175g Butter, 2 Egg Yolk, 300g Plain Flour, 200g Sugar, Pinch Salt, 1 Cinnamon, 100g Raisin, 6 Apple, 1 tablespoon Water
- method (10 steps): Add the flour, 150 gr of the sugar, pinch of salt and 1 egg yolk in the bowl of a food processor. Cut the butter into small cubes and add to the bowl. Turn this into a firm dough. Don't over process, you do not want the dough to turn warm. Check if it sticks by pinching it between your fingers. Turn out onto a piece of plastic wrap. Make a round ball of it by using your hands and roll it into the plastic. Place into the fridge for half an hour to cool. Take a round baking tin of 22 cm diameter and cover this with baking paper. Brush the sides with butter. Preheat the oven to 170˚C (340˚F) Cut …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 9 ingredients, 115 min)

### mdb-53387
**Dutch Spiced Breakfast Cake (Ontbijtkoek)** · Dessert · area: Netherlands
- ingredients: 250g Self Raising Flour, 250g Brown Sugar, 250g Milk, 4 Sugar, 1 tablespoon Ginger, 1/2 tsp Cardamom, 1 tsp Baking Powder, Pinch Salt
- method (4 steps): Preheat the oven to 160˚C (320˚F) Line a cake pan with parchment paper and set aside. Mix all the dry ingredients together in a large bowl. Place the milk in a small saucepan and heat it until it is almost boiling but not quite. Pour the milk slowly into the dry ingredients while whisking. Don't overmix! As soon as it is combined to a smooth batter you pour it into the cake pan. Sprinkle the pearl sugar over the top and bake it in the oven for about 1 hour. Check after about 50 minutes how the cake is progressing. If a cake tester comes out clean the cake it cooked. If not let it cook for a li…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'smooth'] (0.50, keywords: crispy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 125 min)

### mdb-53388
**Runner Bean Mash (Snijbonen Stamppot)** · Side · area: Netherlands
- ingredients: 400g Runner Bean, 1 clove Garlic, 1 chopped Onion, 800g Potato, 25g Butter, 1 tablespoon Mustard, 1 dash Milk, 100g Cheese, 75g Bacon, Pinch Salt
- method (6 steps): Wash and chop the runner beans. Place in a saucepan with salted water and bring to a boil. Cook the beans for about 10 minutes or until al dente. Drain and set aside. Meanwhile, add the potatoes and cook until tender. Heat a small skillet with a little butter and sauté the onion until translucent. Add the garlic and cook briefly. Add the runner beans to the pan and stir-fry for a few minutes. Meanwhile, mash the potatoes with a masher. Add a knob of butter and a splash of milk. Add the bean mixture and grated cheese. Season with salt, pepper and mustard. Fry the bacon and serve with the bean m…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 10 ingredients, 35 min)

### mdb-53389
**Apple Potato Mash (Hete bliksem)** · Side · area: Netherlands
- ingredients: 250g Apple, 250g Potato, 1 Cinnamon Stick, 1 tsp Maple Syrup, Sprinkling Cinnamon, 4 Bacon, 200g Cheese, Pinch Salt, 1 Egg, 50g Sesame Seed
- method (8 steps): Clean and peel the potatoes and cut them into even size chunks. Boil them in salted water for about 10 min and then add the cleaned and chopped apples into the boiling water. Add the cinnamon stick as well. Leave to boil for another 10 minutes or until both apples and potatoes are to your liking. I like mine to be fairly chunky but that is a personal preference In the mean time bake the streaky bacon in a dry frying pan until crispy and set aside to drain on paper towels. Slice a few apple pieces and melt a little butter in a fryin pan. Add the apple slices to it and add a bit of maple syrup i…
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy'] (0.50, keywords: creamy, crispy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 10 ingredients, 50 min)

### mdb-53391
**Traditional Dutch rice tart (rijstevlaai)** · Dessert · area: none
- ingredients: 200g Plain Flour, 75g Coconut Oil, 100g Vegetable Millk, 10g Yeast, 50g Sugar, 150g Dessert Rice, 100g Sugar, 700g Vegetable Millk, 1 tsp Vanilla Extract, 2 Cardamom, 2 Star Anise, 1 Cinnamon Stick, 1/2 tsp Baking Powder, 1/2 tsp Lemon Juice
- method (3 steps): Heat the oven to 180°C. For the dough, mix flour and sugar in a bowl. Heat the 100 grams of milk to lukewarm and dissolve the yeast in it. Let stand for a while until it starts to bubble. Then add to the flour along with the coconut oil and mix into a smooth dough. Let rise for 30 minutes, covered, in a warm place. Meanwhile, make the rice pudding by putting the rice with sugar, milk and vanilla extract in a saucepan. Add the cardamom, star anise and cinnamon. Bring to a boil and cook, stirring constantly. Take out the spices. In a small bowl, mix baking soda with lemon juice/apple vinegar. St…
- `cuisine` rule: 'Dutch' (0.60, title mentions 'Dutch')
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 14 ingredients, 85 min)

### mdb-53392
**Arnhemse meisjes** · Dessert · area: none
- ingredients: 5 Slices Puff Pastry, 100g Vanilla Sugar, 1/2 tsp Cinnamon, 1/2 Cardamom, Zest of 1 Lime
- method (8 steps): Take your puff pastry from the freezer and defrost. Sprinkle some flour on the kitchen counter. Stack the sheets of puff pastry on top of each other and roll them out with a rolling pin. You want those five sheets to end up being as thin as one sheet. Using a round or oval form press into the puff pastry and try to be as economical doing that as possible. You want to have as many cookies as you can. Mix the vanilla sugar with the cinnamon, cardemom and limezest in a little bowl Remove the flour from the counter and sprinkle with a bit of the sugar mix. Brush your puff pastry with a little bit …
- `cuisine` rule: none
- `textures` rule: ['chewy', 'crispy', 'flaky'] (0.50, keywords: chewy, crispy, flaky)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 5 ingredients, 55 min, technique: caramelis)

### mdb-53393
**Dutch doughnuts** · Dessert · area: none
- ingredients: 500g Plain Flour, 500ml Milk, 10g Yeast, 10g Salt, 25g Sugar
- method (7 steps): Place the flour in a large bowl and add the yeast and sugar. If the milk is cold make sure to heat it to lukewarm. Mix your flour mixture bit by bit with the milk until you have a smooth batter. Add the salt and mix with a wooden spoon till the batter is smooth and liquidy. Cover with a clean tea towel and leave in a warm spot for about an hour to rise. Heat your deep fryer or add the oil to a large pot. The oil should be a t 180˚C (350˚F) for best results. Before starting stir your batter through and scoop the batter with two spoons or with an ice cream scoop. Let it drop into the oil careful…
- `cuisine` rule: 'Dutch' (0.60, title mentions 'Dutch')
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 5 ingredients, 70 min, technique: deep fr)

### mdb-53394
**Zeeuwse bolussen** · Dessert · area: none
- ingredients: 10g Yeast, 200ml Milk, 25g Sugar, 400g Plain Flour, 1 medium Egg, 75g Butter, 1 tsp Salt, 1 tablespoon Cinnamon, 1 tablespoon Cardamom, 75g Brown Sugar, 250g Brown Sugar
- method (10 steps): Place the dried yeast, milk and sugar in the bowl of your food processor. Mix and let stand for a few minutes until it begins to foam. Then add the flour, egg, butter, salt, 1 tsp of cinnamon and cardamom and process until smooth. Form the dough into a ball, cover the bowl and let it rise for 1 hour or until it has doubled in size. Mix the caster sugar with 1 tablespoon of cinnamon, pour over the dough and roll it in. Form 10 equal balls (about 75 grams each) and let them “sweat” for a while. The sugar will dissolve a little. When you roll them again later, the rest of the dough will absorb th…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 11 ingredients, 120 min)

### mdb-53395
**Slagroomtaart** · Dessert · area: none
- ingredients: 175g Egg, 100g Sugar, 10g Vanilla Sugar, 75g Plain Flour, 25g Cornflour, 6 tablespoons Jam, 100g Nougatine, 750 ml Double Cream, 6 tablespoons Sugar, 5 Fruit Mix
- method (5 steps): Beat the eggs, sugar and vanilla sugar until light and fluffy. I beat this in a stand mixer on medium-high speed for about 10 minutes. Sift the flour and cornstarch and add to the mixture. Fold this gently into the mixture; you don’t want all the air you whipped in to disappear. Pour the batter into a greased baking pan. Bake the cake base at 180°C/350°F (conventional oven) for 30 minutes. The cake is done when you press lightly on the top and it springs back. Allow the cake to cool in the pan for a few minutes before removing it to a cake rack. Meanwhile, prepare the nougatine and jam accordi…
- `cuisine` rule: none
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'fluffy'] (0.50, keywords: creamy, crispy, fluffy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 60 min)

### mdb-53396
**Baghlaw-e-Khanagi** · Dessert · area: none
- ingredients: 600g Plain Flour, 3 Egg, 450ml Milk, 75 ml Vegetable Oil, 1 tsp Baking Powder, 50g Walnut, 10g Cardamom, 300g Sugar, 1 L Water
- method (9 steps): Place flour in a bowl, and create a hole in the middle of the flour. Whisk eggs, and then pour whisked eggs into the well. Add milk, and combine. Then, stir in the ground walnuts, baking powder and cardamom, and add to the mixture. Fold ingredients into the mixture until it forms an elastic dough consistency. Take dough and with a rolling pin, roll out into a thin rectangle on a clean surface. Then, from the longest side of the rectangle, fold the dough into 3cm-wide lines, until the dough is fully rolled in a long line. Cut folded dough horizontally into 3cm pieces Heat a deep pan of the vege…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 9 steps, 9 ingredients, 50 min)

### mdb-53397
**Haft Mewa Recipe** · Side · area: none
- ingredients: 110g Dried Apricot, 50g Raisin, 110g Raisin, 50g Walnut, 50g Almond, 50g Pistachio, 50g Cherry, Splash Rose Water
- method (4 steps): Wash the apricots and both raisins and place in a bowl - cover with cold water to 5cm above the fruit. Put the walnuts, pistachos and almonds in another bowl or pan and add boiling water. Leave to soak, and then peel off all the skins as they soften. This is a fiddly job and make take some time - but it's definitely worth the effort! Throw away the water. Combine the fruits with the nuts and cherries, including the juice they have been soaking in. Add the rose water, cover the mixture and leave in the fridge to rest for two days. When you leave the mix, the juice will become sweeter and syrupy…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 4 steps, 8 ingredients, 40 min)

### mdb-53398
**Kadu Borani** · Vegetarian · area: none
- ingredients: 1 medium Squash, 5 chopped Onion, To taste Green Chilli, Splash Vegetable Oil, 1 tsp Turmeric, 1 Bulb Garlic, 7 tablespoons Sugar, 1/2 tsp Salt, 2 cups Water, 4 tablespoons Yogurt
- method (5 steps): Peel the squash and cut it into pieces 1cm wide. Deep fry it in oil until golden and set aside. Using the same pan and oil, deep fry the onions until golden. Remove the onions and grind with the garlic (if using garlic paste, mix it into the onions once ground). Add a small amount of oil to a pan on medium heat. Once hot, add the turmeric. Mix the salt into one cup of water and add it to the turmeric. Add a layer of squash, then a layer of onion and garlic. Repeat this step until the squash, onion and garlic have been used up. Add the sugar and one cup of water. Turn the heat down and cook unt…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 50 min, technique: deep fr)

### mdb-53399
**Firni** · Dessert · area: none
- ingredients: 6 cups Milk, 5 tblsp Cornflour, 1 1/2 cups Sugar, 1/2 tsp Cardamom, 1 tsp Rose Water, Handful Almond, Handful Pistachio
- method (5 steps): Pour 1 cup of milk into a small bowl, add the cornstarch and whisk them well until smooth. Pour the rest of the milk into a non-stick saucepan, adding the sugar and cardamom (and rosewater, if desired) whilst cooking over medium heat. Before it starts to boil, slowly add the milk and cornstarch mixture to the pan, whisking constantly to avoid lumps. Keep stirring until the mixture increases in thickness. Take the pan off the heat and pour into a large shallow serving bowl. Let it cool at room temperature, and then put in the refrigerator for about 1 – 2 hours. Finally, sprinkle your Firni with…
- `cuisine` rule: none
- `textures` rule: ['crunchy', 'smooth'] (0.50, keywords: crunchy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 7 ingredients, 110 min)
