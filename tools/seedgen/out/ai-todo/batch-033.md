# AI tagging batch 033

Write `tools/seedgen/tags/ai/batch-033.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53440
**Balchi di Pisca** · Seafood · area: none
- ingredients: 1 Salt Cod, 3 Medium Potato, 1 Tomato, 1/2 Green Pepper, 1 medium Onion, 1 clove peeled sliced Garlic, 1/2 tsp Hot Sauce, Dash Ground Nutmeg, To taste Salt, To taste Black Pepper, 1 Egg
- method (8 steps): These delectable fish balls can also be made with salmon or fish fillets. Substitute one large can of salmon or one pound of any white fish for the cod. Soak for twenty-four hours:. 1 salted cod, or bakijow Discard the water. Place cod in saucepan with fresh water to cover. Simmer gently until the fish flakes easily when tested with the tines of a fork. Strain, reserving a bit of the broth. De bone the cod and set it aside for later use. In a saucepan, bring to boil in water to cover: 3 medium potatoes, peeled and diced When the potatoes are tender, drain them well. Add the cod and mash the tw…
- `cuisine` rule: none
- `textures` rule: ['brothy', 'creamy', 'saucy'] (0.50, keywords: brothy, creamy, saucy)
- `moods` rule: ['comfort', 'hearty', 'light'] (0.50, keywords/category: comfort, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Seafood guess)
- `difficulty` rule: 'easy' (0.55, 8 steps, 11 ingredients, 1270 min)

### mdb-53441
**Banana den Forno** · Dessert · area: none
- ingredients: 4 Banana, 2 tablespoons Cinnamon, 3 tablespoons Vanilla Extract, 1 cup Sugar, 4 cups Water
- method (1 steps): Peal the bananas and boil them together with the cinnamon, vanilla extract, sugar and water for about 20 minutes. Bake the bananas in the oven at 275°F for 10 minutes. Serve with favorite ice cream.
- `cuisine` rule: none
- `textures` rule: ['creamy'] (0.50, keywords: creamy)
- `moods` rule: ['comfort', 'indulgent'] (0.50, keywords/category: comfort, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 5 ingredients, 40 min)

### mdb-53442
**Cheese Sticks** · Side · area: none
- ingredients: 1 cup Plain Flour, 1/2 cup Milk, Knob Butter, 1 Egg, 1 kg Mozzarella, 1 tsp Sugar, 1 tsp Salt, 1 tsp Olive Oil, For frying Vegetable Oil
- method (3 steps): Cut the cheese and long strips and place in your fridge to prevent it becoming soft. Mix flour, butter and egg in a bowl, and add sugar, salt and olive oil to taste into the mix. Then gradually add milk and knead well for a suitable consistency. Stretch out the dough with a rolling pin and cut into long strips (2 to 3 cm) and then roll the strips of dough around the cheese strips forming a spiral. Make sure the dough covers the cheese fully so that it doesn't melt out while frying. Roll the cheese & dough strips through flour to prevent them from sticking while frying. Heat oil in a frying pan…
- `cuisine` rule: none
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 40 min, technique: knead)

### mdb-53443
**Satee** · Beef · area: none
- ingredients: 1 chopped Onion, 2 cloves Garlic, Juice of 2 Lemon, 2 tablespoons Sugar, 1 cup Soy Sauce, 1 tsp Salt, 1 tsp Ground Coriander, 1 cup Vegetable Oil, 4-5 pound Beef, 1 cup Vegetable Oil, 2 tablespoons Soy Sauce
- method (8 steps): To make the marinade for the satee put in the container of an electric blender:. 1 large onion, coarsely chopped 2 cloves of garlic Juice of 2 lemons 2Tbs. of sugar 1 cup of soy sauce 1 tsp. salt 1 tsp. ground coriander for beef (or chicken) or 1 tsp. ground ginger for pork 1 cup of oil Blend thoroughly and pour over:. 5 lbs. of beef or pork tenderloin, cubed DO NOT marinate overnight, but only for a few hours. Place the meat on: 36 skewers. Blend well:. 1 cup of oil 2 Tbs. Soy sauce Pour into a large shallow dish. To keep meat from becoming dry, roll each skewer in seasoned oil before frying.…
- `cuisine` rule: none
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh'] (0.50, keywords/category: fresh)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'easy' (0.55, 8 steps, 11 ingredients, 535 min)

### mdb-53444
**Tirolean Dumplings** · Pork · area: none
- ingredients: 200g Bread, 200ml Milk, 100g Ham, 3 Egg, 2 Shallot, Knob Butter, 2 tablespoons Parsley, 2 tablespoons Plain Flour, To taste Salt, To taste Black Pepper, Pinch Ground Nutmeg, Garnish Butter, Garnish Parsley
- method (5 steps): Finely chop the shallots, and dice the smoked ham or sausage into small cubes. Heat some butter or clarified butter in a pan and sweat the onions in it until translucent. Add the meat and the parsley and fry together briefly before removing from the heat. Place the bread in a bowl. Beat the milk with the eggs and season well with salt, pepper and nutmeg. Pour over the bread. Stir in the sausage and onion paste and mix in the flour. Mix together to form a relatively firm paste (adding more bread or flour if necessary) and season again according to taste. Smooth the surface of the dough out and …
- `cuisine` rule: none
- `textures` rule: ['fluffy', 'smooth'] (0.50, keywords: fluffy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 13 ingredients, 70 min, technique: clarif)

### mdb-53445
**Kaspressknödel - Cheese Dumplings** · Vegetarian · area: none
- ingredients: 250g Bread, 250g Cheese, 2 Egg, Pinch Salt, Pinch Parsley, 3 Potato, 100g Plain Flour, 250ml Milk, 1 small Onion, For frying Butter
- method (5 steps): Mix the cubed white bread with the milk, season with salt, and let the mixture rest for a while. Now add the shredded potatoes, the grated cheese, eggs, and parsley. Melt the butter and fry the cubed onions until golden brown in colour and put into the mixture. Add the flour and gently knead the dough. Shape it into round dumplings, gently press them flat and fry them on both sides in butter until golden brown. Serve in clear broth.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'fluffy'] (0.50, keywords: brothy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Vegetarian guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 10 ingredients, 60 min, technique: knead)

### mdb-53446
**Clear Soup with Semolina Dumplings** · Miscellaneous · area: none
- ingredients: 120g Semolina, 60g Butter, 1 Egg, Pinch Salt, Pinch Ground Nutmeg, Splash Vegetable Oil, 1 L Beef Stock, Chopped Parsley
- method (6 steps): Allow butter to come to room temperature before beating in a bowl until creamed. Season with salt and a small, delicate pinch of nutmeg. Add in the egg, stirring vigorously. Sprinkle the semolina over this, and mix it in well until the surface is smooth. Cover with saran wrap and leave to rest for 15 – 20 minutes. Use two spoons, dipped regularly into hot water throughout, to press or shape dumplings from the paste. You can also place these on a lightly oiled board or plate and again leave them to stand for a short while (this allows the dumplings to rise even more). Heat a generous quantity o…
- `cuisine` rule: none
- `moods` rule: ['comfort', 'indulgent', 'light'] (0.50, keywords/category: comfort, indulgent, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 6 steps, 8 ingredients, 40 min)

### mdb-53447
**Tafelspitz** · Beef · area: none
- ingredients: 1.5kg Beef Brisket, 1 bunch Carrot, 1 Celeriac, 2 Parsnip, Sprigs of fresh Parsley, 1/2 Leek, 1 large Onion, 2 Bay Leaf, 5 Peppercorn, Pinch Salt
- method (7 steps): Slice the unpeeled onion in half widthways and fry off the cut surfaces without fat until fairly well browned. Put around 3 litres of water into a large saucepan. Add the root vegetables, leek, halves of onion, bay leaves, and peppercorns and bring to a boil. Add the washed meat and bones and, depending on the type of meat, allow to cook until softened in gently simmering water, which will take around 2 1⁄2 – 3 hours. Add more water as required and skim off any foam from the surface. Season well with salt, but only after a good 2 hours. Once the meat has softened, remove it from the pan and ke…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['brothy', 'creamy', 'fluffy'] (0.50, keywords: brothy, creamy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 10 ingredients, 270 min)

### mdb-53448
**Tendir Choreyi (Tandoori Bread)** · Side · area: none
- ingredients: 2 1/2 Tsp Yeast, 1 1/2 cups Water, 1 tsp Salt, 3 Cups Plain Flour, For brushing Egg Yolk, 1 tsp Poppy Seed
- method (16 steps): First a quick note about tandoori bread (or tandoori anything, really). The name comes from the clay oven, or "tandoor" that it is traditionally cooked in, and you will never be able to duplicate the flavor of any tandoori recipe without one of those ovens, no matter how hard you try. Now, a tandoor oven is actually a part of my dream kitchen (I love naan bread and tandoori chicken) but I don't have one in my current kitchen, so this bread just goes in a plain oven, which makes it not very authentic. However, this is how an Azerbaijani stranded in the US would make a tandoori bread, so I guess…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)

### mdb-53449
**Kelem dolmasi** · Lamb · area: none
- ingredients: 500g Lamb Mince, 1 large Cabbage, 8 oz Onion, Pinch Salt, Pinch Black Pepper, 1/2 tsp Turmeric, 1/2 tsp Cinnamon, 2 tablespoons Coriander, 2 tablespoons Dill, 2 oz Rice, 2 oz Chickpea, 3 oz Lamb Fat, 1 tablespoon Tomato Puree, 3 tablespoons Water
- method (27 steps): First boil the rice for eight minutes. Meanwhile, peel and finely chop the onion. Then chop the herbs. The recipe didn't really say what to do with the chickpeas (also known of course as garbanzo beans), beyond soaking them overnight and rinsing them. I used canned chickpeas, since I've never actually seen them dried. I decided to chop/mash them slightly so they would better incorporate into the filling. Chickpeas (or garbanzo beans) roughly chopped. Now mince the lamb (I used my mini food processor). Here's where I ran into another problem: what to do with the lamb fat this recipe calls for? …
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'saucy'] (0.50, keywords: creamy, crispy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'hard' (0.55, 27 steps, 14 ingredients, 590 min)

### mdb-53450
**Grits** · Breakfast · area: none
- ingredients: 1/4 cup Grits, 1 tsp Salt, 1 cup Water
- method (1 steps): Bring water with salt to a boil then add grits; reduce heat and cover. occasionally stirring. Cook approximately 15 minutes or until grits have desired consistency. Cool then serve.
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: [] (0.50, keywords: none)
- `moods` rule: [] (0.50, keywords/category: none)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 3 ingredients, 25 min)

### mdb-53451
**Bangladeshi fish curry with daikon** · Seafood · area: none
- ingredients: 450g White Fish, 450g Daikon Radish, 4 tablespoons Vegetable Oil, 4 cloves Garlic, 1 medium Onion, 2 tsp Salt, 1 tsp Turmeric, 2 tsp Ground Coriander, 2 tsp Chilli Powder, 2 Green Chilli, Handful Coriander, 1 Lime
- method (8 steps): If you are using rohu fish it will usually be frozen. Soak it in cold water for 30-45 minutes to defrost and while still a little firm, descale and cut each steak into quarters and wash in cold saltwater a few times. Drain and set aside. If using an alternative such as cod, cut into 2 ½ inch chunks then rinse, drain and set aside 2 Top and tail the daikon and peel using a potato peeler. Cut in half widthways then cut each half down the middle, lengthways. Now slice into 2cm-thick half-moon pieces. Rinse and set aside 3 Place a large, shallow saucepan over a medium heat and add the oil. When th…
- `cuisine` rule: 'Bangladeshi' (0.60, title mentions 'Bangladeshi')
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 12 ingredients, 125 min)

### mdb-53452
**Handesh – Bangladeshi rice flour and date molasses cakes** · Dessert · area: none
- ingredients: 250g Date Molasses, 400ml Water, 250g Rice Flour, 150g Plain Flour, 1/4 tsp Cinnamon, 1/4 tsp Cardamom
- method (12 steps): Add the molasses to a large mixing bowl and begin by pouring 300ml of water to start with and whisk together. The texture of Bangladeshi molasses varies from a thick syrup to slightly set. I use brands such as Zilani or Akza. If the set is very syrupy (like golden syrup) you will only require 300–325ml of water 2 Pour in the flours and spices (if using) and whisk for 3–5 minutes, until you have a smooth batter. You need to check carefully for lumps, as they prevent the handesh from rising and will cause them to split. Cover the batter and rest for 2 hours 3 After 2 hours, thoroughly whisk the …
- `cuisine` rule: 'Bangladeshi' (0.60, title mentions 'Bangladeshi')
- `textures` rule: ['crispy', 'fluffy', 'smooth'] (0.50, keywords: crispy, fluffy, smooth)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 12 steps, 6 ingredients, 620 min, technique: deep-fr)

### mdb-53453
**Bengali Chicken Curry with Potatoes** · Chicken · area: none
- ingredients: 2 tablespoons Olive Oil, 2 diced Onion, 1 tablespoon Ginger Garlic Paste, 2 diced Tomato, 1 tsp Cayenne Pepper, 1 tsp Curry Powder, 1 tsp Garam Masala, 1 tsp Turmeric, 1 tsp Ground Cumin, 4 Chicken Breast, 2 large Potato, 1/2 cup Coriander
- method (3 steps): Heat the olive oil in a large skillet over medium-high heat. Cook and stir the onions in the hot oil until translucent, about 5 minutes. Add the ginger-garlic paste and continue cooking another 5 minutes. Reduce heat to medium; stir the tomatoes into the mixture and cook until the tomatoes are pulpy, 5 to 10 minutes. Season with the cayenne pepper, curry powder, garam masala, turmeric, and cumin; cook and stir another 5 minutes. Add the chicken and potatoes to the mixture in the skillet; simmer, stirring occasionally, until the potatoes are tender and the chicken is no longer pink in the cente…
- `cuisine` rule: none
- `flavor.bitter` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'hearty'] (0.50, keywords/category: comfort, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 75 min)

### mdb-53454
**Breadfruit in Butter Sauce Recipe** · Dessert · area: none
- ingredients: 1/2 Breadfruit, 1/2 Onion, 1 tablespoon Olive Oil, 125g Butter, 3 Onion, 1 tablespoon Garlic, 500ml Chopped Tomatoes, 3 tablespoons Parsley, 1 tablespoon Lime Juice, To taste Salt, To taste Black Pepper, 250ml Water, To taste Red Pepper Paste, Garnish Parsley
- method (12 steps): Captain William Bligh was chosen to lead an expedition to the South Seas to bring the breadfruit to the Caribbean. His devotion to the breadfruit saplings and neglect of his crew’s water needs lead to the famous “Mutiny on the Bounty” on his first attempt. Cast overboard; Captain Bligh made his way hundreds of miles to safety in an open boat. On his second attempt in 1793, he sailed into Jamaica’s Port Royal Harbour with a ship so crowded with beautiful leafy breadfruit saplings that the Jamaicans rowed out toward “the ship that has bush.”. Today large, lush breadfruit trees grow throughout th…
- `cuisine` rule: none
- `flavor.sweet` rule: 4 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `difficulty` rule: 'medium' (0.55, 12 steps, 14 ingredients, 50 min)

### mdb-53455
**Chicken Liver Pate Recipe** · Chicken · area: none
- ingredients: 1lb Chicken Liver, 1/2 lb Bacon, 1 clove Garlic, 1 large Onion, 2 tsp Mustard Powder, To taste Salt, To taste Black Pepper, Splash Milk, 1 tablespoon Sherry
- method (8 steps): Clean livers of sinews and gall. Put into a fireproof casserole with all other ingredients roughly chopped. Season and cover with milk. Put the lid on the casserole and cook in a slow oven (300ºF) for 2 hours. Liquidize in a blender. Adjust seasoning. Add sherry or brandy. Put in a dish and cover with melted butte.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.sour` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'smooth'] (0.50, keywords: saucy, smooth)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 8 steps, 9 ingredients, 140 min)

### mdb-53456
**Bajan Salt Bread Recipe** · Side · area: none
- ingredients: 2 tubs Yeast, 2 tsp Sugar, 1 tsp Salt, 2 tablespoons Vegetable Oil, 6 cups Plain Flour, 2 1/2 cups Water
- method (5 steps): Sift half the flour, mix with salt and yeast in a large mixing bowl, and slowly add warm water until the mixture forms a stiff dough. Add more sifted flour until you have a stiff enough dough to knead. Lightly flour the work surface, knead the dough for 10 minutes until it is smooth and elastic, and then place it in a greased bowl. Now place the bowl warmly for 40-50 minutes until it has doubled. You know the dough is ready when you poke a finger, and the indentation remains. Preheat oven to 425 degrees F or 220 degrees C. Now divide the dough into 12 equal portions, roll each into a fist size…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `textures` rule: ['smooth'] (0.50, keywords: smooth)
- `moods` rule: ['comfort'] (0.50, keywords/category: comfort)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 5 steps, 6 ingredients, 135 min, technique: knead)

### mdb-53457
**Barbados Pepperpot** · Beef · area: none
- ingredients: 2 Pigs Trotter, 2 Lbs Oxtail, Splash Lime Juice, 3 cloves Garlic, 2 Scotch Bonnet, 1 large Onion, 1 Cinnamon Stick, 2 Clove, Pinch Sugar, Pinch Salt, Sprinkling Basil, Sprinkling Thyme, 2 Lbs Beef
- method (11 steps): Wash the stewing steak and place it in the mixing bowl with the lemon or lime juice. Set that to one side; while you slice the garlic into tiny slices, slice the onion. Chop the basil and thyme. Now you need to be very careful when you slice the scotch bonnet peppers; you want these in fine pieces, which you can either do with a long knife trying not to touch the pepper, or you can wear rubber gloves to cut it up. Wash your hands straight afterward and do not touch your eyes; these peppers really burn your hands and eyes if they make contact with the skin! Now rinse the lime or lemon juice off…
- `cuisine` rule: none
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy', 'tender'] (0.50, keywords: saucy, tender)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Beef guess)
- `difficulty` rule: 'medium' (0.55, 11 steps, 13 ingredients, 70 min)

### mdb-53458
**Breadfruit in Butter Sauce** · Side · area: none
- ingredients: 1/2 Breadfruit, 1/2 Onion, 1 tablespoon Olive Oil, 125g Butter, 3 Medium Onion, 1 tablespoon chopped Garlic, 500ml Chopped Tomatoes, 3 tablespoons Parsley, 1 tablespoon Lime Juice, To taste Salt, To taste Black Pepper, 250ml Water, To taste Red Pepper Sauce, Garnish Parsley
- method (5 steps): Cut the breadfruit, remove the seeds in the core, and peel. Boil in salted water with a little onion and oil, over high heat until tender and drain. Meanwhile, melt the butter in a frying pan and lightly brown the onion rings. Add the garlic, tomatoes, parsley, lime juice, salt, and pepper. Continue to sauté for a couple of minutes. Add the water, bring to the boil and simmer for 5-10 minutes. Slice the cooled breadfruit and place it in a serving dish. Pour the butter sauce over the breadfruit. Garnish with chopped fresh parsley. Serves 4.
- `cuisine` rule: none
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 2 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'indulgent'] (0.50, keywords/category: fresh, indulgent)
- `difficulty` rule: 'easy' (0.55, 5 steps, 14 ingredients, 45 min)

### mdb-53459
**Chicken and Potato Roti** · Chicken · area: none
- ingredients: 1 lb Plain Flour, 3 tablespoons Shortening, Pinch Salt, Splash Water, 6 Chicken Breast, Pinch Parsley, Pinch Thyme, Pinch Jerk, Pinch Salt, Pinch Sugar, Pinch Black Pepper, 2 large Onion, 4 cloves Garlic, 1 Scotch Bonnet, 1/2 lb Potato
- method (16 steps): Add a pint of chicken stock to the simmer and put three tablespoons of sugar into a large saucepan on high; cook until the sugar caramelizes, then add the cubed chicken breasts and stir until the chicken browns. Add chopped onions, garlic, parsley, thyme, jerk seasoning, salt, and the whole scotch bonnet pepper – do not cut up the pepper! Reduce the heat to low and let this simmer for 25 minutes. In a large mixing bowl, sift the flour, and add a pinch of salt to taste. Now add the first tablespoon of shortening, and with your fingers, rub the flour into the shortening until it forms a breadcru…
- `cuisine` rule: none
- `flavor.salty` rule: 2 (0.55, weak signals only)
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'flaky'] (0.50, keywords: crispy, flaky)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
