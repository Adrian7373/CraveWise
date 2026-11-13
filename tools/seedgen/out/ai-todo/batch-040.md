# AI tagging batch 040

Write `tools/seedgen/tags/ai/batch-040.json`. For each recipe, give EVERY listed field a
`{"value": ..., "reason": "one short line"}` using only the vocabulary below.

- cuisine: an allowed cuisine (TheMealDB area adjective) or "International"
- flavor.*: int 0-5 · servings: 1-24 · prepMinutes/cookMinutes: int minutes (passive marinating/chilling goes in prep)
- difficulty: easy | medium | hard
- textures (0-3): crispy crunchy creamy chewy saucy brothy tender fluffy flaky smooth
- moods (1-3): comfort light hearty fresh indulgent festive

### mdb-53580
**Biss Jaggery Modak** · Dessert · area: none
- ingredients: 2 cups Desiccated Coconut, 1 cups Brown Sugar, Dried Fruit
- method (7 steps): Jaggery Modak. Take the grated coconut in a bowl. Add jaggery to the grated coconut. Mix the coconut and jaggery thoroughly until they are evenly combined. Take small portions of the mixture and shape them into modaks using your hands or a modak mould. Repeat until all the mixture has been used. Serve the freshly prepared jaggery coconut modaks.
- `cuisine` rule: none
- `textures` rule: ['crunchy'] (0.50, keywords: crunchy)
- `moods` rule: ['indulgent'] (0.50, keywords/category: indulgent)
- `servings` rule: 4 (0.30, not stated; default 4)
- `cookMinutes` rule: 30 (0.30, no durations in the method; Dessert guess)
- `difficulty` rule: 'easy' (0.55, 7 steps, 3 ingredients, 45 min)
