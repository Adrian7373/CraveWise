# AI tagging batch 008

Write `tools/seedgen/tags/ai/batch-008.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-52890
**Jam Roly-Poly** · Dessert · area: British
- ingredients: 50g Butter, 250g Self Raising Flour, 1 small Vanilla Extract, 50g Suet, 150ml Milk, 100g Raspberry Jam, to serve Custard
- method (8 steps): Put a deep roasting tin onto the bottom shelf of the oven, and make sure that there’s another shelf directly above it. Pull the roasting tin out on its shelf, fill two-thirds with boiling water from the kettle, then carefully slide it back in. Heat oven to 180C/160C fan/gas. Tear off a large sheet of foil and greaseproof paper (about 30 x 40cm). Sit the greaseproof on top of the foil and butter it. Tip butter, flour and vanilla seeds into a food processor; pulse until the butter has disappeared. Tip into a mixing bowl. Stir through the suet, pour in the milk and work together with a cutlery kn…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'smooth'] (0.50, keywords: creamy, crunchy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 7 ingredients, 85 min, technique: proof)

### mdb-52891
**Blackberry Fool** · Dessert · area: British
- ingredients: 50g Hazelnut, 125g Butter, 150g Sugar, Grated Lemon, 150g Plain Flour, ½ tsp Baking Powder, 600g Blackberry, 75g Sugar, 2 tbs Sugar, 1 tbs Lemon Juice, 300ml Double Cream, 100ml Yogurt, Garnish with Mint
- method (11 steps): For the biscuits, preheat the oven to 200C/180C (fan)/Gas 6 and line two large baking trays with baking parchment. Scatter the nuts over a baking tray and roast in the oven for 6-8 minutes, or until golden-brown. Watch them carefully so that they don’t have a chance to burn. Remove from the oven, tip onto a board and leave to cool. Put the butter and sugar in a large bowl and beat with a wooden spoon until light and creamy. Roughly chop the cooled nuts and add to the creamed butter and sugar, along with the lemon zest, flour and baking powder. Stir well until the mixture comes together and for…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 11 steps, 13 ingredients, 65 min)

### mdb-52892
**Treacle Tart** · Dessert · area: British
- ingredients: 250g Plain Flour, 135g Butter, 400g Golden Syrup, 150g Breadcrumb, Zest of 2 Lemon, 1 beaten Egg
- method (16 steps): First make the short crust pastry: measure the flour into a large bowl and rub in the butter with your fingertips until the mixture resembles fine breadcrumbs (alternatively, this can be done in a food processor). Add about three tablespoons of cold water and mix to a firm dough, wrap in cling film and chill in the fridge for about 20 minutes. Preheat the oven to 200C/400F/Gas 6 and put a heavy baking tray in the oven to heat up. Grease a deep 18cm/7in loose-bottomed fluted flan tin with butter. Remove about 150g/5½oz of pastry from the main ball and set aside for the lattice top. Roll the res…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 16 steps, 6 ingredients, 75 min, technique: rub in, temper)

### mdb-52893
**Apple & Blackberry Crumble** · Dessert · area: British
- ingredients: 120g Plain Flour, 60g Sugar, 60g Butter, 300g Apple, 30g Butter, 30g Demerara Sugar, 120g Blackberry, ¼ teaspoon Cinnamon, to serve Ice Cream
- method (5 steps): Heat oven to 190C/170C fan/gas. Tip the flour and sugar into a large bowl. Add the butter, then rub into the flour using your fingertips to make a light breadcrumb texture. Do not overwork it or the crumble will become heavy. Sprinkle the mixture evenly over a baking sheet and bake for 15 mins or until lightly coloured. Meanwhile, for the compote, peel, core and cut the apples into 2cm dice. Put the butter and sugar in a medium saucepan and melt together over a medium heat. Cook for 3 mins until the mixture turns to a light caramel. Stir in the apples and cook for 3 mins. Add the blackberries …
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy'] (0.50, keywords: creamy, crunchy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 9 ingredients, 60 min, technique: proof, rub in)

### mdb-52894
**Battenberg Cake** · Dessert · area: British
- ingredients: 175g Butter, 175g Sugar, 140g Self Raising Flour, 50g Almond, ½ tsp Baking Powder, 3 Medium Egg, ½ tsp Vanilla Extract, ¼ teaspoon Almond Extract, 175g Butter, 175g Sugar, 140g Self Raising Flour, 50g Almond, ½ tsp Baking Powder, 3 Medium Egg, ½ tsp Vanilla Extract, ¼ teaspoon Almond Extract, ½ tsp Pink Food Colouring, 200g Apricot, 1kg Marzipan, Dusting Icing Sugar
- method (10 steps): Heat oven to 180C/160C fan/gas 4 and line the base and sides of a 20cm square tin with baking parchment (the easiest way is to cross 2 x 20cm-long strips over the base). To make the almond sponge, put the butter, sugar, flour, ground almonds, baking powder, eggs, vanilla and almond extract in a large bowl. Beat with an electric whisk until the mix comes together smoothly. Scrape into the tin, spreading to the corners, and bake for 25-30 mins – when you poke in a skewer, it should come out clean. Cool in the tin for 10 mins, then transfer to a wire rack to finish cooling while you make the seco…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crunchy', 'fluffy', 'smooth'] (0.50, keywords: crunchy, fluffy, smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 10 steps, 20 ingredients, 90 min, technique: crimp)

### mdb-52895
**English Breakfast** · Breakfast · area: British
- ingredients: 2 Sausage, 3 Bacon, 2 Mushroom, 2 Tomato, 1 Slice Morcilla, 2 Egg, 1 Slice Bread
- method (10 steps): Heat the flat grill plate over a low heat, on top of 2 rings/flames if it fits, and brush sparingly with light olive oil. Cook the sausages first. Add the sausages to the hot grill plate/the coolest part if there is one and allow to cook slowly for about 15-20 minutes, turning occasionally, until golden. After the first 10 minutes, increase the heat to medium before beginning to cook the other ingredients. If you are struggling for space, completely cook the sausages and keep hot on a plate in the oven. Snip a few small cuts into the fatty edge of the bacon. Place the bacon straight on to the …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'flaky', 'saucy'] (0.50, keywords: crispy, flaky, saucy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 10 steps, 7 ingredients, 65 min)

### mdb-52897
**Carrot Cake** · Dessert · area: British
- ingredients: 450ml Vegetable Oil, 400g Plain Flour, 2 tsp Bicarbonate of Soda, 550ml Sugar, 5 Egg, ½ tsp Salt, 2 tsp Cinnamon, 500g grated Carrot, 150g Walnut, 200g Cream Cheese, 150g Sugar, 100g Butter
- method (5 steps): For the carrot cake, preheat the oven to 160C/325F/Gas. Grease and line a 26cm/10in springform cake tin. Mix all of the ingredients for the carrot cake, except the carrots and walnuts, together in a bowl until well combined. Stir in the carrots and walnuts. Spoon the mixture into the cake tin and bake for 1 hour 15 minutes, or until a skewer inserted into the middle comes out clean. Remove the cake from the oven and set aside to cool for 10 minutes, then carefully remove the cake from the tin and set aside to cool completely on a cooling rack. Meanwhile, for the icing, beat the cream cheese, c…
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'fluffy'] (0.50, keywords: creamy, crunchy, fluffy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 12 ingredients, 110 min)

### mdb-52898
**Chelsea Buns** · Dessert · area: British
- ingredients: 500g Plain Flour, 1 tsp Salt, 7g Yeast, 300ml Milk, 40g Butter, 1 Egg, Dash Vegetable Oil, 25g Butter, 75g Brown Sugar, 2 tsp Cinnamon, 150g Dried Fruit, 2 tbs Milk, 2 tbs Sugar
- method (12 steps): Sift the flour and salt into a large bowl. Make a well in the middle and add the yeast. Meanwhile, warm the milk and butter in a saucepan until the butter melts and the mixture is lukewarm. Add the milk mixture and egg to the flour mixture and stir until the contents of the bowl come together as a soft dough. (You may need to add a little extra flour.) Tip the dough onto a generously floured work surface. Knead for five minutes, adding more flour if necessary, until the dough is smooth and elastic and no longer feels sticky. Lightly oil a bowl with a little of the vegetable oil. Place the doug…
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 12 steps, 13 ingredients, 150 min, technique: knead)

### mdb-52899
**Dundee cake** · Dessert · area: British
- ingredients: 100g Almond, 180g Butter, 180g Muscovado Sugar, Zest of 1 Orange, 3 tbs Apricot Jam, 225g Plain Flour, 1 tsp Baking Powder, 3 Large Egg, 100g Ground Almond, 2 tbs Milk, 500g Dried Fruit, 100g Glace Cherry, 1 tbs Milk, 2 tsp Sugar
- method (9 steps): Put the almonds into a small bowl and pour over boiling water to just cover. Leave for 5 mins then drain in a sieve and leave to dry. Preheat the oven to 180C/160 C fan/Gas Mark. Line a deep loose-based 20cm cake tin with baking parchment. Put the butter in a large bowl and beat well until soft. Add the sugar and beat until light and fluffy. Stir in the orange zest and apricot jam. Sieve together the flour and baking powder. Add the eggs to the creamed butter and sugar, a little at a time, beating well between each addition. If the mixture starts to curdle, stir in a little flour. Add the rema…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'fluffy'] (0.50, keywords: creamy, crunchy, fluffy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 9 steps, 14 ingredients, 205 min, technique: temper)

### mdb-52900
**Madeira Cake** · Dessert · area: British
- ingredients: 175g Butter, 175g Sugar, 3 Egg, 250g Self Raising Flour, 3 tbs Milk, Zest of 1 Lemon, To Glaze Mixed Peel
- method (7 steps): Pre-heat the oven to 180C/350F/Gas. Grease an 18cm/7in round cake tin, line the base with greaseproof paper and grease the paper. Cream the butter and sugar together in a bowl until pale and fluffy. Beat in the eggs, one at a time, beating the mixture well between each one and adding a tablespoon of the flour with the last egg to prevent the mixture curdling. Sift the flour and gently fold in, with enough milk to give a mixture that falls slowly from the spoon. Fold in the lemon zest. Spoon the mixture into the prepared tin and lightly level the top. Bake on the middle shelf of the oven for 30…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy'] (0.50, keywords: creamy, fluffy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 7 ingredients, 60 min, technique: proof)

### mdb-52901
**Rock Cakes** · Dessert · area: British
- ingredients: 225g Self Raising Flour, 75g Sugar, 1 tsp Baking Powder, 125g Butter, 150g Dried Fruit, 1 Egg, 1 tbs Milk, 2 tsp Vanilla Extract
- method (6 steps): Preheat oven to 180C/350F/Gas 4 and line a baking tray with baking parchment. Mix the flour, sugar and baking powder in a bowl and rub in the cubed butter until the mixture looks like breadcrumbs, then mix in the dried fruit. In a clean bowl, beat the egg and milk together with the vanilla extract. Add the egg mixture to the dry ingredients and stir with a spoon until the mixture just comes together as a thick, lumpy dough. Add a teaspoon more milk if you really need it to make the mixture stick together. Place golfball-sized spoons of the mixture onto the prepared baking tray. Leave space bet…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 35 min, technique: rub in)

### mdb-52902
**Parkin Cake** · Dessert · area: British
- ingredients: 200g Butter, 1 large Egg, 4 tbs Milk, 200g Golden Syrup, 85g Black Treacle, 85g Brown Sugar, 100g Oats, 250g Self Raising Flour, 1 tbs Ground Ginger
- method (4 steps): Heat oven to 160C/140C fan/gas. Grease a deep 22cm/9in square cake tin and line with baking parchment. Beat the egg and milk together with a fork. Gently melt the syrup, treacle, sugar and butter together in a large pan until the sugar has dissolved. Remove from the heat. Mix together the oatmeal, flour and ginger and stir into the syrup mixture, followed by the egg and milk. Pour the mixture into the tin and bake for 50 mins - 1 hr until the cake feels firm and a little crusty on top. Cool in the tin then wrap in more parchment and foil and keep for 3-5 days before eating if you can – it’ll b…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 9 ingredients, 80 min)

### mdb-52906
**Flamiche** · Vegetarian · area: France
- ingredients: 75g Butter, 1kg Leek, ½ tsp Salt, 300ml Creme Fraiche, 1 Egg, 3 Egg Yolk, ¼ teaspoon Ground Nutmeg, 225g Plain Flour, ½ tsp Salt, 60g Butter, 60g Lard, 50g Cheddar, 2 tbs Water
- method (7 steps): For the pastry, sift the flour and salt into the bowl of a food processor, add the butter and lard, then whizz together briefly until the mixture looks like fine breadcrumbs. Tip the mixture into a bowl, then stir in the cheese and enough of the water for the mixture to come together. Tip out onto a lightly floured surface and knead briefly until smooth. Roll out thinly and line a 23cm x 4cm loose-?bottomed fluted flan tin. Prick the base with a fork. Chill for 20 minutes. Melt the 75g butter in a saucepan over a low heat, then add the leeks and the salt. Cover and cook for ?10 minutes until s…
- `textures` rule: ['crispy', 'flaky', 'smooth'] (0.50, keywords: crispy, flaky, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 7 steps, 13 ingredients, 130 min, technique: blind bake, knead, temper)

### mdb-52907
**Duck Confit** · Miscellaneous · area: France
- ingredients: Handful Salt, 4 Bay Leaf, 4 cloves Garlic, Handful Thyme, 4 Duck Leg, 100ml White Wine
- method (9 steps): The day before you want to make the dish, scatter half the salt, half the garlic and half of the herbs over the base of a small shallow dish. Lay the duck legs, skin-side up, on top, then scatter over the remaining salt, garlic and herbs. Cover the duck and refrigerate overnight. This can be done up to 2 days ahead. Pour the wine into a saucepan that will snugly fit the duck legs in a single layer. Brush the salt off the duck legs and place them, skin-side down, in the wine. Cover the pan with a lid and place over a medium heat. As soon as the wine starts to bubble, turn the heat down to the l…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy', 'tender'] (0.50, keywords: crispy, saucy, tender)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 6 ingredients, 765 min, technique: proof)

### mdb-52910
**Chinon Apple Tarts** · Dessert · area: France
- ingredients: 320g Puff Pastry, 4 tbs Brown Sugar, 3 Apple, 4 tbs Red Wine Jelly, 100ml Creme Fraiche, 1 tbs Icing Sugar, 3 Cardamom
- method (6 steps): To make the red wine jelly, put the red wine, jam sugar, star anise, clove, cinnamon stick, allspice, split vanilla pod and seeds in a medium saucepan. Stir together, then heat gently to dissolve the sugar. Turn up the heat and boil for 20 mins until reduced and syrupy. Strain into a small, sterilised jam jar and leave to cool completely. Will keep in the fridge for up to 1 month. Take the pastry out of the fridge and leave at room temperature for 10 mins, then unroll. Heat the grill to high and heat the oven to 180C/160C fan/gas. Cut out 2 x 13cm circles of pastry, using a plate as a guide, a…
- `textures` rule: ['flaky'] (0.50, keywords: flaky)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 6 steps, 7 ingredients, 80 min, technique: caramelis, temper)

### mdb-52911
**Summer Pistou** · Vegetarian · area: France
- ingredients: 1 tbs Vegetable Oil, 2 finely chopped Leek, 1 large Courgette, 1L Vegetable Stock, 400g Cannellini Bean, 200g Green Bean, 3 chopped Tomato, 3 chopped Garlic, Small pack Basil, 40g Parmesan
- method (2 steps): Heat the oil in a large pan and fry the leeks and courgette for 5 mins to soften. Pour in the stock, add three-quarters of the haricot beans with the green beans, half the tomatoes, and simmer for 5-8 mins until the vegetables are tender. Meanwhile, blitz the remaining beans and tomatoes, the garlic and basil in a food processor (or in a bowl with a stick blender) until smooth, then stir in the Parmesan. Stir the sauce into the soup, cook for 1 min, then ladle half into bowls or pour into a flask for a packed lunch. Chill the remainder. Will keep for a couple of days.
- `textures` rule: ['brothy', 'saucy', 'smooth'] (0.50, keywords: brothy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 10 ingredients, 35 min)

### mdb-52912
**Three-cheese souffles** · Miscellaneous · area: France
- ingredients: 50g Butter, 25g Parmesan, 300ml Milk, 2 Bay Leaf, 5 tbs Plain Flour, ½ tsp English Mustard, Pod of Cayenne Pepper, 140g Gruyere, 3 Egg, 8 slices Goats Cheese, 150ml Double Cream, to serve Spinach
- method (9 steps): Heat oven to 200C/180C fan/ gas 6 and butter 4 small (about 200ml) ramekins. Sprinkle the Parmesan into the ramekins, turning until all sides are covered. Place the milk and bay leaves in a large saucepan over a gentle heat and bring to the boil. Turn off the heat and leave to infuse for 15 mins. Discard the bay leaves, add the butter and flour, and return to a low heat. Very gently simmer, stirring continuously with a balloon whisk, for about 6 mins until you get a smooth, thick white sauce. Make sure that you get right into the corners of the pan to stop the sauce from catching or becoming l…
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'fluffy', 'saucy'] (0.50, keywords: creamy, fluffy, saucy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 9 steps, 12 ingredients, 75 min, technique: souffl)

### mdb-52913
**Brie wrapped in prosciutto & brioche** · Side · area: France
- ingredients: 375g Plain Flour, 50g Sugar, 7g Yeast, 75g Milk, 3 Large Egg, To Glaze Egg, 180g Butter, 250g Brie, 8 slices Prosciutto
- method (4 steps): Mix the flour, 1 tsp salt, caster sugar, yeast, milk and eggs together in a mixer using the dough attachment for 5 mins until the dough is smooth. Add the butter and mix for a further 4 mins on medium speed. Scrape the dough bowl and mix again for 1 min. Place the dough in a container, cover with cling film and leave in the fridge for at least 6 hrs before using. Wrap the Brie in the prosciutto and set aside. Turn out the dough onto a lightly floured surface. Roll into a 25cm circle. Place the wrapped Brie in the middle of the circle and fold the edges in neatly. Put the parcel onto a baking t…
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 4 steps, 9 ingredients, 535 min, technique: temper)

### mdb-52914
**Boulangère Potatoes** · Side · area: France
- ingredients: 2 finely chopped Onion, sprigs of fresh Thyme, 2 tbs Olive Oil, 1.5kg Potato, 425g Vegetable Stock
- method (3 steps): Heat oven to 200C/fan 180C/gas. Fry the onions and thyme sprigs in the oil until softened and lightly coloured (about 5 mins). Spread a layer of potatoes over the base of a 1.5-litre oiled gratin dish. Sprinkle over a few onions (see picture, above) and continue layering, finishing with a layer of potatoes. Pour over the stock and bake for 50-60 mins until the potatoes are cooked and the top is golden and crisp.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['crispy'] (0.50, keywords: crispy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 5 ingredients, 65 min)

### mdb-52915
**French Omelette** · Miscellaneous · area: France
- ingredients: 3 Egg, 2 knobs Butter, 1 tsp Parmesan, 3 chopped Tarragon, 1 tbs chopped Parsley, 1 tbs chopped Chive, 4 tbs Gruyere
- method (7 steps): Get everything ready. Warm a 20cm (measured across the top) non-stick frying pan on a medium heat. Crack the eggs into a bowl and beat them with a fork so they break up and mix, but not as completely as you would for scrambled egg. With the heat on medium-hot, drop one knob of butter into the pan. It should bubble and sizzle, but not brown. Season the eggs with the Parmesan and a little salt and pepper, and pour into the pan. Let the eggs bubble slightly for a couple of seconds, then take a wooden fork or spatula and gently draw the mixture in from the sides of the pan a few times, so it gathe…
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Miscellaneous guess)
- `difficulty` rule: 'easy' (0.55, 7 steps, 7 ingredients, 45 min)
