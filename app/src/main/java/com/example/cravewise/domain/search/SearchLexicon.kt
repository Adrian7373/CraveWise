package com.example.cravewise.domain.search

import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.Texture

/** What a lexicon phrase means. The parser decides whether it's wanted or negated. */
internal sealed interface Concept {
    data class TasteC(val taste: Taste) : Concept
    data class TextureC(val texture: Texture) : Concept
    data class MoodC(val mood: Mood) : Concept
    data class MealC(val mealType: MealType) : Concept
    data class DietC(val diet: Diet) : Concept
    data class DifficultyC(val difficulty: Difficulty) : Concept
    data class QuickC(val maxMinutes: Int) : Concept
    data object MildC : Concept
    data object PantryC : Concept
    data class CuisineC(val cuisine: String) : Concept

    /** Wanted: any of [proteins]. Negated: also drops recipes with [negAllergens] ("no fish"). */
    data class ProteinC(
        val proteins: Set<Protein>,
        val label: String,
        val negAllergens: Set<Allergen> = emptySet(),
    ) : Concept

    /** Only meaningful negated ("no dairy", "nut-free"); wanted, it's searched as plain text. */
    data class AllergenC(val allergens: Set<Allergen>, val label: String) : Concept

    data class IngredientC(val ingredientIds: Set<String>) : Concept

    /** Concepts that name a food, so "no X or Y" carries the negation on to Y. */
    val isFoodItem: Boolean get() = this is ProteinC || this is AllergenC || this is IngredientC
}

/**
 * The fixed search vocabulary. Keys are normalized phrases (see [SearchText.normalizeWord]):
 * lower-case, singular, space-separated. Catalog cuisines and ingredients are added at runtime by
 * [QueryParser]; these fixed entries win over them for the same phrase.
 */
internal object SearchLexicon {

    private val MEATS = setOf(Protein.Chicken, Protein.Beef, Protein.Pork, Protein.Lamb, Protein.Goat, Protein.Duck, Protein.Turkey)

    val concepts: Map<String, Concept> = buildMap {
        fun put(concept: Concept, vararg phrases: String) = phrases.forEach { put(SearchText.normalizePhrase(it), concept) }

        // Flavors
        put(Concept.TasteC(Taste.Salty), "salty", "briny", "salted")
        put(Concept.TasteC(Taste.Sweet), "sweet", "sugary", "sweet tooth")
        put(Concept.TasteC(Taste.Sour), "sour", "tangy", "tart", "zesty", "zingy", "citrusy", "acidic", "lemony")
        put(Concept.TasteC(Taste.Bitter), "bitter")
        put(Concept.TasteC(Taste.Umami), "umami", "savory", "savoury")
        put(Concept.TasteC(Taste.Spicy), "spicy", "hot", "fiery", "heat", "kick", "peppery", "spice")
        put(Concept.MildC, "mild", "not too spicy", "no heat", "gentle")

        // Textures
        put(Concept.TextureC(Texture.Crispy), "crispy", "crisp", "crispy fried")
        put(Concept.TextureC(Texture.Crunchy), "crunchy", "crunch")
        put(Concept.TextureC(Texture.Creamy), "creamy", "cream sauce")
        put(Concept.TextureC(Texture.Chewy), "chewy")
        put(Concept.TextureC(Texture.Saucy), "saucy", "saucey", "sticky")
        put(Concept.TextureC(Texture.Brothy), "brothy", "soupy")
        put(Concept.TextureC(Texture.Tender), "tender", "melt in your mouth", "fall apart")
        put(Concept.TextureC(Texture.Fluffy), "fluffy")
        put(Concept.TextureC(Texture.Flaky), "flaky")
        put(Concept.TextureC(Texture.Smooth), "smooth", "silky", "velvety")

        // Moods
        put(Concept.MoodC(Mood.Comfort), "comfort", "comforting", "comfort food", "cozy", "cosy", "soul food")
        put(Concept.MoodC(Mood.Light), "light", "healthy", "lean", "clean", "low calorie")
        put(Concept.MoodC(Mood.Hearty), "hearty", "filling", "warming", "stick to your ribs", "rib sticking")
        put(Concept.MoodC(Mood.Fresh), "fresh", "bright", "summery", "refreshing")
        put(Concept.MoodC(Mood.Indulgent), "indulgent", "decadent", "rich", "treat yourself", "cheat day", "naughty")
        put(Concept.MoodC(Mood.Festive), "festive", "party", "holiday", "celebration", "christmas", "special occasion")

        // Meal types
        put(Concept.MealC(MealType.Breakfast), "breakfast", "brunch", "morning")
        put(Concept.MealC(MealType.Main), "main", "main course", "dinner", "lunch", "supper", "entree", "entrée")
        put(Concept.MealC(MealType.Side), "side", "side dish")
        put(Concept.MealC(MealType.Starter), "starter", "appetizer", "appetiser", "app")
        put(Concept.MealC(MealType.Dessert), "dessert", "pudding", "sweet treat", "afters")
        put(Concept.MealC(MealType.Snack), "snack", "nibble", "munchy", "munchies")

        // Diets (rule-derived tags, safe as hard filters). "Halal" is deliberately absent:
        // we can only exclude pork and alcohol, not verify it.
        put(Concept.DietC(Diet.Vegetarian), "vegetarian", "veggie", "meatless", "meat free")
        put(Concept.DietC(Diet.Vegan), "vegan", "plant based")
        put(Concept.DietC(Diet.Pescatarian), "pescatarian", "pescetarian")
        put(Concept.DietC(Diet.GlutenFree), "gluten free", "gf", "coeliac", "celiac")
        put(Concept.DietC(Diet.DairyFree), "dairy free", "lactose free")

        // Effort and time
        put(Concept.DifficultyC(Difficulty.Easy), "easy", "simple", "beginner", "no fuss", "fuss free", "effortless")
        put(Concept.DifficultyC(Difficulty.Medium), "intermediate")
        put(Concept.DifficultyC(Difficulty.Hard), "hard", "challenging", "advanced", "project", "ambitious")
        put(Concept.QuickC(QUICK_MINUTES), "quick", "fast", "speedy", "weeknight", "in a hurry", "rushed", "busy night")

        // "With what I have"
        put(
            Concept.PantryC,
            "with what i have", "what i have", "what ive got", "what i got", "my pantry", "my kitchen",
            "my fridge", "in my fridge", "in the fridge", "what can i make", "what can i cook", "use up",
            "leftover", "from my kitchen", "pantry",
        )

        // Proteins
        put(Concept.ProteinC(setOf(Protein.Chicken), "Chicken"), "chicken")
        put(Concept.ProteinC(setOf(Protein.Beef), "Beef"), "beef", "steak")
        put(Concept.ProteinC(setOf(Protein.Pork), "Pork"), "pork")
        put(Concept.ProteinC(setOf(Protein.Lamb), "Lamb"), "lamb")
        put(Concept.ProteinC(setOf(Protein.Goat), "Goat"), "goat", "mutton")
        put(Concept.ProteinC(setOf(Protein.Duck), "Duck"), "duck")
        put(Concept.ProteinC(setOf(Protein.Turkey), "Turkey"), "turkey")
        put(Concept.ProteinC(setOf(Protein.Fish), "Fish", setOf(Allergen.Fish)), "fish")
        put(
            Concept.ProteinC(setOf(Protein.Shellfish), "Shellfish", setOf(Allergen.Crustaceans, Allergen.Molluscs)),
            "shellfish",
        )
        put(
            Concept.ProteinC(
                setOf(Protein.Fish, Protein.Shellfish),
                "Seafood",
                setOf(Allergen.Fish, Allergen.Crustaceans, Allergen.Molluscs),
            ),
            "seafood",
        )
        put(Concept.ProteinC(setOf(Protein.Egg), "Eggs", setOf(Allergen.Eggs)), "egg", "eggy")
        put(Concept.ProteinC(setOf(Protein.Tofu), "Tofu"), "tofu")
        put(Concept.ProteinC(setOf(Protein.Legumes), "Beans & lentils"), "legume", "bean", "lentil", "pulse")
        put(Concept.ProteinC(setOf(Protein.Cheese), "Cheese"), "cheese", "cheesy")
        put(Concept.ProteinC(MEATS, "Meat"), "meat", "meaty")
        put(Concept.ProteinC(setOf(Protein.Chicken, Protein.Duck, Protein.Turkey), "Poultry"), "poultry")
        put(Concept.ProteinC(setOf(Protein.Beef, Protein.Lamb, Protein.Goat, Protein.Pork), "Red meat"), "red meat")

        // Allergens: negated only ("no dairy", "nut-free")
        put(Concept.AllergenC(setOf(Allergen.Milk), "dairy"), "dairy", "lactose")
        put(Concept.AllergenC(setOf(Allergen.TreeNuts, Allergen.Peanuts), "nuts"), "nut", "nutty")
        put(Concept.AllergenC(setOf(Allergen.Peanuts), "peanuts"), "peanut")
        put(Concept.AllergenC(setOf(Allergen.TreeNuts), "tree nuts"), "tree nut")
        put(Concept.AllergenC(setOf(Allergen.Gluten), "gluten"), "gluten", "wheat")
        put(Concept.AllergenC(setOf(Allergen.Soy), "soy"), "soy", "soya")
        put(Concept.AllergenC(setOf(Allergen.Sesame), "sesame"), "sesame")
        put(Concept.AllergenC(setOf(Allergen.Crustaceans), "crustaceans"), "crustacean")
        put(Concept.AllergenC(setOf(Allergen.Molluscs), "molluscs"), "mollusc", "mollusk")
    }

    /** Words that start a negation for what follows ("no", "without", "hold the"). */
    val negators: Set<String> = setOf(
        "no", "not", "without", "minus", "skip", "except", "avoid", "non", "zero", "hold the",
        "free of", "nothing with", "dont want", "do not want", "no more", "but no", "never", "hate",
        "allergic to", "cant have", "cannot have", "cant eat", "cannot eat", "dont like", "do not like",
    ).mapTo(HashSet(), SearchText::normalizePhrase)

    /** "Very salty", "extra spicy": raises the flavor bar. */
    val intensifiers: Set<String> = setOf("very", "extra", "super", "really", "proper", "seriously", "so")

    /** Joiners that keep a food negation going: "no mushrooms or olives". */
    val connectors: Set<String> = setOf("and", "or", "nor", "&", ",", "plus", "either")

    /** Filler that carries no meaning for search. Matched on the raw lower-case token. */
    val stopWords: Set<String> = setOf(
        "a", "an", "the", "some", "any", "something", "anything", "somethin", "stuff", "thing", "things",
        "i", "im", "i'm", "me", "my", "we", "us", "you", "your", "it", "its", "is", "are", "be", "am",
        "want", "wanna", "need", "would", "like", "love", "feel", "feeling", "fancy", "fancying", "craving",
        "crave", "mood", "for", "of", "to", "with", "in", "on", "at", "by", "from", "up", "that", "this",
        "food", "foods", "dish", "dishes", "meal", "meals", "recipe", "recipes", "idea", "ideas",
        "option", "options", "please", "pls", "make", "cook", "cooking", "eat", "eating", "can", "could",
        "give", "show", "find", "get", "tonight", "today", "now", "kind", "sort", "bit", "little",
        "maybe", "also", "good", "nice", "tasty", "delicious", "yummy", "but", "what", "how", "should",
        "do", "have", "has", "got", "lets", "let's", "try", "something's", "sth", "ish", "type",
        // Leftovers of time phrases that didn't parse ("under 5 ingredients", "ready in...")
        "under", "over", "less", "than", "within", "about", "around", "ready", "ingredient",
        "ingredients", "min", "mins", "minute", "minutes", "hour", "hours", "time",
    )

    /** "Quick" without a number. */
    const val QUICK_MINUTES = 30
}
