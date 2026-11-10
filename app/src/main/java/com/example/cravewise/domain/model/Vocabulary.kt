package com.example.cravewise.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
 * Controlled vocabularies shared by the seed dataset (tools/dataset.py) and the app.
 * The @SerialName values are the wire format AND what Room stores, so never rename them;
 * add new entries instead (and mirror them in tools/dataset.py).
 */

/** EU 14 allergens. Derived per recipe from canonical ingredients, never hand-tagged. */
@Serializable
enum class Allergen(val label: String) {
    @SerialName("gluten") Gluten("Gluten"),
    @SerialName("crustaceans") Crustaceans("Crustaceans"),
    @SerialName("eggs") Eggs("Eggs"),
    @SerialName("fish") Fish("Fish"),
    @SerialName("peanuts") Peanuts("Peanuts"),
    @SerialName("soy") Soy("Soy"),
    @SerialName("milk") Milk("Milk"),
    @SerialName("tree_nuts") TreeNuts("Tree nuts"),
    @SerialName("celery") Celery("Celery"),
    @SerialName("mustard") Mustard("Mustard"),
    @SerialName("sesame") Sesame("Sesame"),
    @SerialName("sulphites") Sulphites("Sulphites"),
    @SerialName("lupin") Lupin("Lupin"),
    @SerialName("molluscs") Molluscs("Molluscs"),
}

/** What an ingredient contains, for rule-based diet derivation (see DietRules). */
@Serializable
enum class ContainsFlag {
    @SerialName("meat") Meat,
    @SerialName("pork") Pork,
    @SerialName("poultry") Poultry,
    @SerialName("fish") Fish,
    @SerialName("shellfish") Shellfish,
    @SerialName("dairy") Dairy,
    @SerialName("egg") Egg,
    @SerialName("honey") Honey,
    @SerialName("alcohol") Alcohol,
    @SerialName("gelatin") Gelatin,
}

/** Diets derived strictly by rule from ingredient flags/allergens. */
@Serializable
enum class Diet(val label: String) {
    @SerialName("vegetarian") Vegetarian("Vegetarian"),
    @SerialName("vegan") Vegan("Vegan"),
    @SerialName("pescatarian") Pescatarian("Pescatarian"),
    @SerialName("gluten_free") GlutenFree("Gluten-free"),
    @SerialName("dairy_free") DairyFree("Dairy-free"),
    /** Not "halal": we can only exclude pork, alcohol and gelatin, not verify certification. */
    @SerialName("no_pork_no_alcohol") NoPorkNoAlcohol("No pork or alcohol"),
}

@Serializable
enum class Protein(val label: String) {
    @SerialName("chicken") Chicken("Chicken"),
    @SerialName("beef") Beef("Beef"),
    @SerialName("pork") Pork("Pork"),
    @SerialName("lamb") Lamb("Lamb"),
    @SerialName("goat") Goat("Goat"),
    @SerialName("duck") Duck("Duck"),
    @SerialName("turkey") Turkey("Turkey"),
    @SerialName("fish") Fish("Fish"),
    @SerialName("shellfish") Shellfish("Shellfish"),
    @SerialName("egg") Egg("Egg"),
    @SerialName("tofu") Tofu("Tofu"),
    @SerialName("legumes") Legumes("Beans & lentils"),
    @SerialName("cheese") Cheese("Cheese"),
}

@Serializable
enum class Aisle(val label: String) {
    @SerialName("produce") Produce("Produce"),
    @SerialName("meat_seafood") MeatSeafood("Meat & seafood"),
    @SerialName("dairy_eggs") DairyEggs("Dairy & eggs"),
    @SerialName("bakery") Bakery("Bakery"),
    @SerialName("pantry") Pantry("Pantry"),
    @SerialName("spices") Spices("Herbs & spices"),
    @SerialName("condiments") Condiments("Sauces & condiments"),
    @SerialName("frozen") Frozen("Frozen"),
    @SerialName("beverages") Beverages("Drinks"),
    @SerialName("international") International("World foods"),
    @SerialName("other") Other("Other"),
}

@Serializable
enum class MealType(val label: String) {
    @SerialName("breakfast") Breakfast("Breakfast"),
    @SerialName("main") Main("Main"),
    @SerialName("side") Side("Side"),
    @SerialName("starter") Starter("Starter"),
    @SerialName("dessert") Dessert("Dessert"),
    @SerialName("snack") Snack("Snack"),
}

@Serializable
enum class Texture(val label: String) {
    @SerialName("crispy") Crispy("Crispy"),
    @SerialName("crunchy") Crunchy("Crunchy"),
    @SerialName("creamy") Creamy("Creamy"),
    @SerialName("chewy") Chewy("Chewy"),
    @SerialName("saucy") Saucy("Saucy"),
    @SerialName("brothy") Brothy("Brothy"),
    @SerialName("tender") Tender("Tender"),
    @SerialName("fluffy") Fluffy("Fluffy"),
    @SerialName("flaky") Flaky("Flaky"),
    @SerialName("smooth") Smooth("Smooth"),
}

@Serializable
enum class Mood(val label: String) {
    @SerialName("comfort") Comfort("Comfort"),
    @SerialName("light") Light("Light"),
    @SerialName("hearty") Hearty("Hearty"),
    @SerialName("fresh") Fresh("Fresh"),
    @SerialName("indulgent") Indulgent("Indulgent"),
    @SerialName("festive") Festive("Festive"),
}

@Serializable
enum class Difficulty(val label: String) {
    @SerialName("easy") Easy("Easy"),
    @SerialName("medium") Medium("Medium"),
    @SerialName("hard") Hard("Hard"),
}

/** Parsed measure unit. `null` unit on a line means a plain count ("2 eggs"). */
@Serializable
enum class MeasureUnit {
    @SerialName("g") G, @SerialName("kg") Kg, @SerialName("ml") Ml, @SerialName("l") L,
    @SerialName("tsp") Tsp, @SerialName("tbsp") Tbsp, @SerialName("cup") Cup,
    @SerialName("oz") Oz, @SerialName("fl_oz") FlOz, @SerialName("lb") Lb, @SerialName("cm") Cm,
    @SerialName("pinch") Pinch, @SerialName("dash") Dash, @SerialName("splash") Splash,
    @SerialName("clove") Clove, @SerialName("slice") Slice, @SerialName("can") Can,
    @SerialName("bunch") Bunch, @SerialName("sprig") Sprig, @SerialName("handful") Handful,
    @SerialName("stick") Stick, @SerialName("packet") Packet, @SerialName("jar") Jar,
    @SerialName("sheet") Sheet, @SerialName("leaf") Leaf, @SerialName("head") Head,
    @SerialName("stalk") Stalk, @SerialName("piece") Piece, @SerialName("knob") Knob,
    @SerialName("fillet") Fillet, @SerialName("bottle") Bottle,
}
