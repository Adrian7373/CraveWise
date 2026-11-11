package com.example.cravewise.domain.model

/**
 * One source's share of a shopping item: a recipe line, or the user's own manual add
 * ([recipeId] null). Amounts are the recipe's parsed measure (no servings scaling yet).
 */
data class ShoppingShare(
    val recipeId: String?,
    val amount: Double? = null,
    val amountMax: Double? = null,
    val unit: MeasureUnit? = null,
    /** Original measure text, shown when it can't be parsed ("to taste"). Blank for manual adds. */
    val rawMeasure: String = "",
)

/**
 * A row on the shopping list. Catalog ingredients are keyed by their id and merge across recipes;
 * free-text items ([ingredientId] null) never merge with catalog items and never go to the pantry.
 */
data class ShoppingEntry(
    val key: String,
    val ingredientId: String?,
    /** Snapshot taken when added; prefer the catalog name when the ingredient still exists. */
    val name: String,
    val aisle: Aisle,
    val checked: Boolean,
    val addedAtEpochMs: Long,
    val checkedAtEpochMs: Long?,
    val shares: List<ShoppingShare>,
) {
    val isCustom: Boolean get() = ingredientId == null

    /** Recipes this item is for (manual shares excluded). */
    val recipeIds: Set<String> get() = shares.mapNotNullTo(LinkedHashSet()) { it.recipeId }

    companion object {
        private const val CUSTOM_PREFIX = "custom:"

        fun keyFor(ingredientId: String): String = ingredientId

        /** Free-text items with the same (normalized) name share one row. */
        fun customKeyFor(name: String): String = CUSTOM_PREFIX + name.trim().lowercase().replace(Regex("\\s+"), " ")
    }
}
