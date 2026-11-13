# AI tagging batch 021

Write `tools/seedgen/tags/ai/batch-021.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53189
**Zemiakové Placky** · Side · area: Slovakia
- ingredients: 1 kg Potato, 1 medium chopped Onion, 2 cloves minced Garlic, 4 large Egg, 4 tablespoons Plain Flour, 1 teaspoon Marjoram, To taste Salt, To taste Black Pepper, For frying Vegetable Oil
- method (5 steps): Prepare the Potatoes Start by peeling and finely grating the potatoes. To ensure extra crispiness, use a clean kitchen towel to squeeze out as much moisture as possible. Mix the Ingredients In a large mixing bowl, combine the grated potatoes, chopped onion, minced garlic, eggs, flour, marjoram, salt, and black pepper. Stir well until the mixture forms a thick, consistent batter. Heat the Oil In a large frying pan, heat a generous amount of oil over medium heat. The oil should be hot but not smoking. Fry the Pancakes Spoon portions of the batter into the pan, flattening each into a thin pancake…
- `flavor.salty` rule: 1 (0.55, weak signals only)
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `flavor.umami` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crispy', 'fluffy'] (0.50, keywords: creamy, crispy, fluffy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 20 (0.30, no durations in the method; Side guess)
- `difficulty` rule: 'easy' (0.55, 5 steps, 9 ingredients, 45 min)

### mdb-53190
**Bryndzové Halušky** · Pork · area: Slovakia
- ingredients: 500g Potato, 200g Plain Flour, 1 Egg, 1 teaspoon Salt, 250g Bryndza Cheese, 200g Bacon, Garnish Chive
- method (5 steps): Prepare the Dough Grate the potatoes finely using a hand grater or food processor. Place the grated potatoes in a bowl and mix them with flour, egg, and salt until a sticky dough forms. The consistency should be thick but pliable. Cook the Dumplings Bring a large pot of salted water to a boil. Using a halušky maker (similar to a spaetzle maker), press the dough directly into the boiling water. If you don’t have one, use a tilted cutting board and a knife to scrape small pieces of dough into the water. Let the dumplings cook until they float to the surface, usually within 2-3 minutes. Scoop the…
- `textures` rule: ['creamy', 'crispy', 'crunchy'] (0.50, keywords: creamy, crispy, crunchy)
- `moods` rule: ['comfort', 'hearty', 'indulgent'] (0.50, keywords/category: comfort, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 7 ingredients, 30 min)

### mdb-53192
**Panang chicken curry (kaeng panang gai)** · Chicken · area: Thai
- ingredients: 400ml Coconut Milk, 1-2tbsp Panang Curry Paste, 200g Chicken Breast, 100g Green Bean, 2-3 tbsp Fish Sauce, 1-2tbsp Brown Sugar, 2 Makrut Lime Leaf, Handful Basil, Boiled Jasmine Rice, 6 Red Chilli, 4 Dried Red Chilli, 1 teaspoon Shrimp Paste, 4 Cloves Chopped Garlic, 1 tblsp Galangal, 1 tblsp Lemongrass, Zest of 2 Lime, 1 teaspoon Ground Nutmeg, 1 tsp Ground Coriander, 1 teaspoon Ground Cumin, 2 tblsp Peanut
- method (7 steps): First, make the curry paste. Use a pestle and mortar to pound together the dried and fresh chillies, shrimp paste, garlic, galangal, lemongrass, lime zest, white pepper, coriander, cumin, nutmeg and peanuts, plus 1 tsp salt. You should have a rough paste. Alternatively, add all the ingredients to a food processor along with 2-3 tbsp of coconut milk and pulse until you have a paste. Store in a lidded jar in the fridge. Will keep for up to two weeks. Add 2-3 tbsp of the thick part of the coconut milk into a saucepan over a medium-high heat. When the coconut milk starts bubbling, add 1-2 tbsp of …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 7 steps, 20 ingredients, 50 min)

### mdb-53193
**Drunken noodles (pad kee mao)** · Beef · area: Thai
- ingredients: 200g Rice Noodle, 2 tblsp Vegetable Oil, 3 cloves Chopped Garlic, 3 chopped Birds Eye Chilli, 225g Sirloin Steak, 100g Broccoli, Handful Basil, 4 tbsp Soy Sauce, 4 tbsp Oyster Sauce, 1 teaspoon Fish Sauce, 1 tblsp Sugar
- method (3 steps): Prepare the noodles following pack instructions, then drain and set aside. Combine all the ingredients for the sauce in a small bowl or jug, and set aside. Heat the oil in a large wok or frying pan over a high heat and stir-fry the garlic and chilli for 20 seconds until just starting to turn golden. Add the steak and stir-fry for 1 minute until seared and starting to brown. Add the broccoli and stir-fry for another minute, then tip in the noodles and add the sauce. Stir-fry for another 1-2 mins until well combined and piping hot. Stir through the basil and turn off the heat. Serve immediately …
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['chewy', 'saucy'] (0.50, keywords: chewy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 11 ingredients, 25 min, technique: piping)

### mdb-53195
**Thai curry noodle soup** · Seafood · area: Thai
- ingredients: 1 teaspoon Vegetable Oil, 1 tbsp Thai Green Curry Paste, 220g Stir Fry Vegetable, 150g Prawn, 150ml Coconut Milk, 225ml Vegetable Stock, 250g Udon Noodle, 10g Coriander, 10g Basil, 1 sliced Red Chilli, 1 sliced Spring Onion
- method (2 steps): Heat the oil in a saucepan over a medium heat and cook the curry paste for 1 min before adding the stir-fry veg and prawns. Cook for 3 mins until the prawns are mostly pink, then add the coconut milk, veg stock and noodles. Bring to the boil, then reduce the heat to a simmer and cook for 5 mins until the noodles are cooked through and the veg is tender but still has a bite. Divide between two bowls and sprinkle over the herbs, chilli and spring onion.
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 11 ingredients, 30 min)

### mdb-53196
**Tom yum (hot & sour) soup with prawns** · Seafood · area: Thai
- ingredients: 700ml Chicken Stock, 1 Lemongrass, 5 Slices Galangal, 6 Coriander, 3 Makrut Lime Leaf, 6 Prawn, 3 tablespoons Fish Sauce, 6 small Green Chilli, 4 tablespoons Lime Juice
- method (2 steps): Bring the stock to a boil in a medium-sized saucepan. Add the lemongrass, galangal, coriander roots and lime leaves, then simmer for 2 mins. Add the prawns, fish sauce, chillies and lime juice, then return to the boil. Taste and adjust the seasoning with either more lime juice or fish sauce, then garnish with coriander leaves and serve.
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 9 ingredients, 25 min)

### mdb-53197
**Thai pork & peanut curry** · Pork · area: Thai
- ingredients: 1 tablespoon Vegetable Oil, Bunch Spring Onion, Bunch Coriander, 400g Pork Tenderloin, 4 tablespoons Red Curry Paste, 4 tablespoons Peanut Butter, 1 tablespoon Brown Sugar, 1 tbsp Soy Sauce, 400ml Coconut Milk, 175g Sweetcorn, Juice of 1 Lime, Steamed Jasmine Rice
- method (3 steps): Heat the oil in a large saucepan or flameproof casserole. Add the spring onions and coriander stalks and cook for 1 min. Add the pork slices and cook for 5 mins until starting to brown. Stir in the curry paste and peanut butter. After 30 secs, add the sugar, soy and coconut milk, plus ½ can of water. Mix well, put a lid on and leave to simmer for 15 mins, stirring occasionally. Remove the lid, add the baby corn and increase the heat. Bubble for 3 mins until the corn is cooked and the sauce has thickened a little. Stir in the lime juice and check the seasoning. Can now be frozen for up to 2 mon…
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 12 ingredients, 50 min)

### mdb-53198
**Thai fried rice with prawns & peas** · Seafood · area: Thai
- ingredients: 2 tbsp Vegetable Oil, 1 sliced Red Onion, 2 sliced Garlic, 1 sliced Red Chilli, 250g Prawn, 140g Brown Rice, 75g Pea, 1 tablespoon Soy Sauce, 1 tablespoon Fish Sauce, Bunch Coriander, 4 large Egg, To serve Hot Sauce
- method (2 steps): Heat 1 tbsp of the oil in a wok, add the onion, garlic and chilli, and cook for 2-3 mins until golden. Add the prawns and cook for 1 min. Tip in the rice and peas, and keep tossing until very hot. Add the soy and fish sauce, then stir through the chopped coriander. Keep warm while you fry the eggs. Heat the remaining oil in a frying pan and fry the eggs with some seasoning. Divide the fried rice mix between 4 bowls and top each with a fried egg. Serve scattered with coriander, with chilli sauce, if you like.
- `flavor.sweet` rule: 1 (0.55, weak signals only)
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 12 ingredients, 30 min)

### mdb-53200
**Prawn stir-fry** · Seafood · area: Thai
- ingredients: 200g Prawn, 1 chopped Green Chilli, 3 Cloves Crushed Garlic, 1 bunch Coriander, 1 tblsp Sugar, Juice of 1 Lime, 3 tbsp Fish Sauce, 2 tablespoons Groundnut Oil, 3cm piece Ginger, 8 slices Spring Onion, 1 sliced Red Pepper, 85g Water Chestnut, 100g Bean Sprout, 1 tablespoon Soy Sauce, To serve Rice Noodle, To serve Lime
- method (3 steps): Put the prawns in a bowl. Put the chilli, garlic, coriander stalks (snip these up using scissors first) and caster sugar in a spice grinder or small food processor and whizz together. Add half of the lime juice and the fish sauce, then pour this over the prawns. Heat 1 tbsp oil in a wok, add the ginger and spring onions and fry for 1 min. Add the red pepper and fry for 1 min, until the pepper starts to soften. Add the water chestnuts and bean sprouts, and toss together until the bean sprouts start to wilt. Add the soy sauce and a really good grind of black pepper, then tip the lot into a servi…
- `textures` rule: ['chewy', 'crunchy', 'saucy'] (0.50, keywords: chewy, crunchy, saucy)
- `moods` rule: ['fresh', 'hearty', 'indulgent'] (0.50, keywords/category: fresh, hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 16 ingredients, 35 min)

### mdb-53201
**Stir-fried chicken with chillies & basil** · Chicken · area: Thai
- ingredients: 2 tablespoons Vegetable Oil, 450g Chicken, 3 tblsp chopped Garlic, 3 tblsp chopped Shallot, 3 Red Chilli, 2 tablespoons Fish Sauce, 2 tsp Soy Sauce, 2 tsp Sugar, Handful Basil
- method (3 steps): Heat a wok or large frying pan until it is very hot, then add 1 tbsp of the oil. When it is very hot, add the chicken and stir-fry over a high heat for 8-10 minutes, until browned all over. Using a slotted spoon, take the chicken from the pan and set aside. Reheat the wok and add the remaining oil. Toss in the garlic and shallots and stir fry for 3 minutes, until golden brown. Return the chicken to the wok and add the chillies, fish sauce, dark soy sauce and sugar. Stir fry over a high heat for a further 8-10 minutes or until the chicken is cooked through. Stir in the basil leaves and serve at…
- `textures` rule: ['crispy', 'saucy'] (0.50, keywords: crispy, saucy)
- `moods` rule: ['hearty', 'indulgent'] (0.50, keywords/category: hearty, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 9 ingredients, 40 min)

### mdb-53202
**Thai-style steamed fish** · Seafood · area: Thai
- ingredients: 2 Trout, Knob Ginger, 1 small finely diced Garlic, 1 small finely diced Red Chilli, Juice/zest of one Lime, 3 Pak Choi, 2 tblsp Soy Sauce
- method (2 steps): Nestle the fish fillets side by side on a large square of foil and scatter the ginger, garlic, chilli and lime zest over them. Drizzle the lime juice on top and then scatter the pieces of pak choi around and on top of the fish. Pour the soy sauce over the pak choi and loosely seal the foil to make a package, making sure you leave space at the top for the steam to circulate as the fish cooks. Steam for 15 minutes. (If you haven’t got a steamer, put the parcel on a heatproof plate over a pan of gently simmering water, cover with a lid and steam.)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 7 ingredients, 35 min)

### mdb-53203
**Thai rice noodle salad** · Vegetarian · area: Thai
- ingredients: 1/2 bag Rice Noodle, 200g Bean Sprout, Zest and juice of 2 Lime, 2-3 tbsp Fish Sauce, 1 tsp Muscovado Sugar, 1 sliced Red Onion, 2 small Lettuce, 500g Pork Mince, Knob Ginger, Pinch Cayenne Pepper, 1 tsp Vegetable Oil, 2 tblsp Sesame Seed, 1 tsp Vegetable Oil, 4 Sirloin Steak, 1 sliced Red Chilli
- method (4 steps): Place the noodles and beansprouts in a heatproof bowl and cover with boiling water. Leave for 4 mins, or until the noodles are tender. Drain, then cool under cold running water and drain again. Return to the bowl. Stir together the lime zest and juice, fish or soy sauce and sugar. Stir into the noodles with the red onion and lettuce. To make with mince, heat a little oil in a non-stick frying pan and stir-fry 500g minced pork, a small knob of grated ginger and pinch cayenne pepper or chilli powder for 10 mins, until the mince is browned and cooked through. Mix into the noodles, divide between …
- `textures` rule: ['chewy', 'saucy'] (0.50, keywords: chewy, saucy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 4 steps, 15 ingredients, 70 min)

### mdb-53204
**Red curry chicken kebabs** · Chicken · area: Thai
- ingredients: 2 Chicken Breast, 2 tblsp Red Curry Paste, 2 tblsp Coconut Milk, 1 chopped Red Pepper, 1 chopped Courgette, 1 cut thin wedges Red Onion, To serve Lime
- method (1 steps): Fire up the barbecue or heat a griddle pan to high. Tip chicken, curry paste and coconut milk into a bowl, then mix well until the chicken is evenly coated. Thread vegetables and chicken onto skewers. Cook the skewers on the barbecue or griddle for 5-8 mins, turning every so often, until the chicken is cooked through and charred. Serve with herby rice, salad and a lime half to squeeze over.
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'light'] (0.50, keywords/category: comfort, fresh, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 1 steps, 7 ingredients, 20 min)

### mdb-53205
**Thai prawn curry** · Seafood · area: Thai
- ingredients: 1 tbls Vegetable Oil, 1 chopped Onion, 1 tsp Ginger, 2 tsp Red Curry Paste, 400g Chopped Tomatoes, 50g Coconut Cream, 400g Prawn, Chopped Coriander
- method (2 steps): Heat the oil in a medium saucepan. Tip in the onion and ginger, then cook for a few mins until softened. Stir in the curry paste, then cook for 1 min more. Pour over the chopped tomatoes and coconut cream. Bring to the boil, then leave to simmer for 5 mins, adding a little boiling water if the mixture gets too thick. Tip in the prawns, then cook for 5-10 mins more, depending on how large they are. Serve alongside some plain rice and sprinkle with a little chopped coriander, if you like.
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['comfort', 'fresh', 'indulgent'] (0.50, keywords/category: comfort, fresh, indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 8 ingredients, 35 min)

### mdb-53206
**Thai chicken cakes with sweet chilli sauce** · Chicken · area: Thai
- ingredients: 2 large Chicken Breast, 1 clove Garlic, 1 small Ginger, 1 chopped Onion, 4 tbs Coriander, 1 chopped Green Chilli, 2 tblsp Olive Oil, To serve Sweet Chilli Sauce, To serve Lime, Chopped Spring Onion, Chopped Red Chilli
- method (2 steps): Toss the chicken, garlic, ginger, onion, coriander and chilli into a food processor and season well. Blitz until the chicken is finely ground and everything is well mixed. Use your hands to shape six small cakes. Heat the oil in a frying pan, then fry the cakes over a medium heat for about 6-8 mins, turning once. Serve hot, with sweet chilli sauce, lime wedges, coriander, shredded spring onion and red chilli.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `textures` rule: ['saucy'] (0.50, keywords: saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 11 ingredients, 35 min)

### mdb-53207
**Tom kha gai** · Chicken · area: Thai
- ingredients: 800ml Chicken Stock, 800g Coconut Milk, 2 tablespoons Galangal Paste, 2 Lemongrass, 8 Makrut Lime Leaf, 500g Chicken Thigh, 300g Oyster Mushroom, 6 Birds Eye Chilli, 1 tablespoon Sugar, 5 tablespoons Fish Sauce, Juice of 3 Lime, To serve Coriander, To serve Rice
- method (3 steps): Pour the chicken stock and coconut milk into a large saucepan set over a medium heat. Tip in the galangal, lemongrass and lime leaves, and bring to a gentle simmer, around 6-8 mins. Keeping at a gentle simmer, add the chicken. Cook for 8-10 mins until tender and cooked through. Stir in the mushrooms and chillies, and simmer for a further 3-5 mins until everything is cooked through. Sprinkle in the sugar and 3 tbsp each of the fish sauce and lime juice. Taste and add the remaining if required. Remove the galangal, lemongrass and lime leaves before serving using a slotted spoon. Ladle into bowls…
- `textures` rule: ['creamy', 'crunchy', 'saucy'] (0.50, keywords: creamy, crunchy, saucy)
- `moods` rule: ['fresh', 'hearty', 'light'] (0.50, keywords/category: fresh, hearty, light)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 3 steps, 13 ingredients, 45 min)

### mdb-53208
**Thai coconut & veg broth** · Vegetarian · area: Thai
- ingredients: 1 ½ tbsp Red Curry Paste, 1 tsp Vegetable Oil, 1 L Vegetable Stock, 400ml Coconut Milk, 2 tsp Brown Sugar, 175g Egg Noodle, 2 Carrot, 1/2 Chinese Cabbage, 150g Bean Sprout, 6 Cherry Tomato, Juice of 1 Lime, 3 sliced thinly Spring Onion, Handful Coriander
- method (2 steps): Place the curry paste in a large saucepan or wok with the oil. Fry for 1 min until fragrant. Tip in the vegetable stock, coconut milk and brown sugar. Simmer for 3 mins. Add the noodles, carrots and Chinese leaf and simmer for 4-6 mins, until all are tender. Mix in beansprouts and tomatoes. Add lime juice to taste and some extra seasoning, if you like. Spoon into bowls and sprinkle with spring onions and coriander.
- `flavor.bitter` rule: 1 (0.55, weak signals only)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 13 ingredients, 35 min)

### mdb-53209
**Spicy Thai prawn noodles** · Seafood · area: Thai
- ingredients: 200g Rice Noodle, 1 tablespoon Sesame Oil, 2 Beaten Egg, 1 chopped Red Chilli, 3cm piece Ginger, 450g Prawn, 1 tablespoon Soy Sauce, Bunch Coriander, 1/2 handful Mint, Zest and juice of 1 Lime, Handful Peanut
- method (2 steps): Cook the noodles following the pack instructions, drain and set aside for later. Heat the oil in a large frying pan and pour in the beaten egg. Swirl around the pan to make a thin omelette, cook for 1-2 mins, then flip over and cook the other side for 1 min. Tip out and slice into thin strips. Add the chilli and ginger to the pan, fry for 1-2 mins then tip in the noodles, prawns and egg. Splash in the soy sauce and stir-fry for 1 min more. Throw in the chopped herbs and pour over the lime juice and zest, then sprinkle over the chopped peanuts and serve.
- `textures` rule: ['chewy', 'crunchy', 'saucy'] (0.50, keywords: chewy, crunchy, saucy)
- `moods` rule: ['fresh', 'hearty'] (0.50, keywords/category: fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 2 steps, 11 ingredients, 35 min)

### mdb-53210
**Thai pumpkin soup** · Vegetarian · area: Thai
- ingredients: 1.5kg Pumpkin, 4 tsp Vegetable Oil, 1 sliced Onion, 1 tbsp grated Ginger, 1 Lemongrass, 4 tablespoons Red Curry Paste, 400ml Coconut Milk, 800ml Vegetable Stock, To taste Lime Juice, To taste Sugar, To serve Red Chilli
- method (5 steps): Heat oven to 200C/180C fan/gas. Toss the pumpkin or squash in a roasting tin with half the oil and seasoning, then roast for 30 mins until golden and tender. Meanwhile, put the remaining oil in a pan with the onion, ginger and lemongrass. Gently cook for 8-10 mins until softened. Stir in the curry paste for 1 min, followed by the roasted pumpkin, all but 3 tbsp of the coconut milk and the stock. Bring to a simmer, cook for 5 mins, then fish out the lemongrass. Cool for a few mins, then whizz until smooth with a hand blender, or in a large blender in batches. Return to the pan to heat through, …
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'easy' (0.55, 5 steps, 11 ingredients, 65 min)

### mdb-53211
**Lemongrass beef stew with noodles** · Beef · area: Thai
- ingredients: 1 tablespoon chopped Ginger, 2 chopped Garlic, 3 Lemongrass, 2 tblsp Coriander, 2 sliced Red Chilli, 2 tblsp Vegetable Oil, 250g Beef, 2 tblsp Soy Sauce, 1 tsp Five Spice Powder, 1 tsp Brown Sugar, 400ml Beef Stock, 100g Rice Noodle, To serve Lime
- method (2 steps): Put the ginger, garlic, lemongrass, coriander and 1 chilli in a food processor, then pulse until puréed. Heat the oil in a pan over a low heat. Add the purée and cook for 5 mins. Stir in the beef, soy, five-spice, sugar and stock. Put on a lid and bring to the boil, then lower heat and simmer for 1 hr 15 mins. Remove the lid and cook for a further 15 mins until the beef is tender. Just before serving, prepare noodles following pack instructions. Drain well, then divide between 2 bowls and spoon over the beef stew. Serve sprinkled with the remaining chilli and coriander leaves, with lime wedges…
- `textures` rule: ['chewy', 'saucy', 'smooth'] (0.50, keywords: chewy, saucy, smooth)
- `moods` rule: ['comfort', 'fresh', 'hearty'] (0.50, keywords/category: comfort, fresh, hearty)
- `servings` rule: 4 (0.30, not stated; default 4)
- `difficulty` rule: 'medium' (0.55, 2 steps, 13 ingredients, 120 min)
