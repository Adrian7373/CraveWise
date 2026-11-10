package com.example.cravewise.domain.model

/**
 * The user's food profile. Every field is a hard filter (see ProfileFilter): a recipe that breaks
 * any of them is hidden everywhere.
 */
data class FoodProfile(
    /** Recipes containing any of these are hidden. */
    val allergens: Set<Allergen> = emptySet(),
    /** A recipe must carry every one of these (rule-derived) diet tags. */
    val diets: Set<Diet> = emptySet(),
    /** Canonical ingredient ids. Ids dropped from the dataset are ignored. */
    val hatedIngredientIds: Set<String> = emptySet(),
    /**
     * Highest heat level (0–5) the user accepts. Null = never set: no limit, but Home nudges the
     * user to set it. [MAX_SPICE] means "any heat" and counts as set.
     */
    val maxSpice: Int? = null,
) {
    val isSpiceSet: Boolean get() = maxSpice != null

    val hasHardFilters: Boolean
        get() = allergens.isNotEmpty() || diets.isNotEmpty() || hatedIngredientIds.isNotEmpty() ||
            (maxSpice != null && maxSpice < MAX_SPICE)

    companion object {
        const val MAX_SPICE = 5
    }
}
