package com.example.cravewise.domain.search

import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Difficulty
import com.example.cravewise.domain.model.FlavorScores
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.Texture

/** The six flavor axes, for search (the quiz's [com.example.cravewise.domain.Craving] skips bitter). */
enum class Taste(val label: String) {
    Salty("Salty"), Sweet("Sweet"), Sour("Sour"), Bitter("Bitter"), Umami("Umami"), Spicy("Spicy");

    fun scoreOf(flavor: FlavorScores): Int = when (this) {
        Salty -> flavor.salty
        Sweet -> flavor.sweet
        Sour -> flavor.sour
        Bitter -> flavor.bitter
        Umami -> flavor.umami
        Spicy -> flavor.spicy
    }
}

/**
 * Something the user wants more of. These are soft: a result must match at least one want (when
 * there are any), and matching more of them ranks higher.
 */
sealed interface Want {
    val label: String

    /** Flavor score of at least [min] (0–5). */
    data class Flavor(val taste: Taste, val min: Int) : Want {
        override val label: String get() = if (min > SearchQuery.TASTE_MIN) "Very ${taste.label.lowercase()}" else taste.label
    }

    data class TextureIs(val texture: Texture) : Want {
        override val label: String get() = texture.label
    }

    data class MoodIs(val mood: Mood) : Want {
        override val label: String get() = mood.label
    }

    /** Any of [proteins] (e.g. "seafood" = fish or shellfish). */
    data class ProteinIs(val proteins: Set<Protein>, override val label: String) : Want

    /**
     * Uses any of [ingredientIds] (a canonical id plus its "family", e.g. "mushroom" covers
     * shiitake mushrooms), or [term] appears in the title.
     */
    data class Uses(val ingredientIds: Set<String>, val term: String, override val label: String) : Want

    /** A word the lexicon doesn't know, matched by full-text search over titles and ingredients. */
    data class Text(val term: String) : Want {
        override val label: String get() = "“$term”"
    }
}

/** Something the user asked to leave out ("no mushrooms", "nut-free"). Always a hard filter. */
sealed interface Exclusion {
    val label: String

    data class Ingredients(val ingredientIds: Set<String>, val name: String) : Exclusion {
        override val label: String get() = "No $name"
    }

    /** Drops recipes with any of [proteins], and with any of [allergens] ("no fish" also drops fish sauce). */
    data class Proteins(
        val proteins: Set<Protein>,
        val name: String,
        val allergens: Set<Allergen> = emptySet(),
    ) : Exclusion {
        override val label: String get() = "No $name"
    }

    /** Uses rule-derived allergen tags (DietRules), so it is safe to filter on. */
    data class Allergens(val allergens: Set<Allergen>, val name: String) : Exclusion {
        override val label: String get() = "No $name"
    }

    data class MealTypeIs(val mealType: MealType) : Exclusion {
        override val label: String get() = "No ${mealType.label.lowercase()}s"
    }

    data class CuisineIs(val cuisine: String) : Exclusion {
        override val label: String get() = "Not $cuisine"
    }

    data class TextureIs(val texture: Texture) : Exclusion {
        override val label: String get() = "Not ${texture.label.lowercase()}"
    }

    data class MoodIs(val mood: Mood) : Exclusion {
        override val label: String get() = "Not ${mood.label.lowercase()}"
    }

    data class DifficultyIs(val difficulty: Difficulty) : Exclusion {
        override val label: String get() = "Not ${difficulty.label.lowercase()}"
    }

    /** Flavor score above [max] is out ("not sweet", "mild"). */
    data class TasteAbove(val taste: Taste, val max: Int, override val label: String) : Exclusion

    /** Unknown word to avoid, matched by full-text search. */
    data class Text(val term: String) : Exclusion {
        override val label: String get() = "No “$term”"
    }
}

/** How a query was understood, in the order the user typed it, for the "Looking for" row. */
data class QueryChip(val label: String, val kind: Kind) {
    enum class Kind { Want, Filter, Exclude, Pantry }
}

/**
 * A parsed search. [wants] are scored; everything else is a hard filter. Category fields are OR
 * within themselves ("Thai or Indian") and AND with each other. Profile hard filters are NOT part
 * of this: callers apply ProfileGate to the ranked results, last.
 */
data class SearchQuery(
    val raw: String = "",
    val wants: List<Want> = emptyList(),
    val mealTypes: Set<MealType> = emptySet(),
    val cuisines: Set<String> = emptySet(),
    val diets: Set<Diet> = emptySet(),
    val maxMinutes: Int? = null,
    val difficulty: Difficulty? = null,
    val exclusions: List<Exclusion> = emptyList(),
    /** "With what I have": only recipes that use something from the pantry, fewest missing first. */
    val usePantry: Boolean = false,
    val chips: List<QueryChip> = emptyList(),
) {
    /** Nothing understood, so there's nothing to search for. */
    val isEmpty: Boolean
        get() = wants.isEmpty() && mealTypes.isEmpty() && cuisines.isEmpty() && diets.isEmpty() &&
            maxMinutes == null && difficulty == null && exclusions.isEmpty() && !usePantry

    /** Terms that need a full-text lookup (title and ingredient text). */
    val textTerms: Set<String>
        get() = buildSet {
            wants.forEach {
                when (it) {
                    is Want.Text -> add(it.term)
                    is Want.Uses -> add(it.term)
                    else -> Unit
                }
            }
            exclusions.filterIsInstance<Exclusion.Text>().forEach { add(it.term) }
        }

    companion object {
        /** A flavor counts as "there" from this score up; "very salty" asks for one more. */
        const val TASTE_MIN = 3
        const val TASTE_STRONG_MIN = 4

        /** "Mild" / "not spicy" means at most this. */
        const val MILD_MAX = 1
    }
}
