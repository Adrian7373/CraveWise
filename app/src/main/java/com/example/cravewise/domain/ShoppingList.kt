package com.example.cravewise.domain

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.ShoppingEntry

/** A display-ready shopping row. */
data class ShoppingRow(
    val key: String,
    val ingredientId: String?,
    val name: String,
    val aisle: Aisle,
    val checked: Boolean,
    /** Merged amounts ("1.2 kg", "2 cloves + 1 tbsp"), or null when there's nothing to show. */
    val quantity: String?,
    /** How many recipes need this (manual adds don't count). */
    val recipeCount: Int,
) {
    /** "1.2 kg · for 2 recipes", or null. */
    val detail: String?
        get() = listOfNotNull(
            quantity,
            when (recipeCount) {
                0 -> null
                1 -> "for 1 recipe"
                else -> "for $recipeCount recipes"
            },
        ).takeIf { it.isNotEmpty() }?.joinToString(" · ")
}

data class AisleSection(val aisle: Aisle, val rows: List<ShoppingRow>)

data class ShoppingListView(
    /** Still to buy, grouped by aisle in store-walk order. */
    val sections: List<AisleSection> = emptyList(),
    /** Checked off, most recently checked first. */
    val basket: List<ShoppingRow> = emptyList(),
    /** Recipes with at least one share on the list, in the order they were first added. */
    val recipeIds: List<String> = emptyList(),
) {
    val toBuyCount: Int get() = sections.sumOf { it.rows.size }
    val isEmpty: Boolean get() = sections.isEmpty() && basket.isEmpty()
}

object ShoppingList {

    /** Roughly the order you walk a supermarket: fresh first, then shelves, then drinks. */
    val STORE_WALK: List<Aisle> = listOf(
        Aisle.Produce,
        Aisle.Bakery,
        Aisle.MeatSeafood,
        Aisle.DairyEggs,
        Aisle.Frozen,
        Aisle.Pantry,
        Aisle.International,
        Aisle.Spices,
        Aisle.Condiments,
        Aisle.Beverages,
        Aisle.Other,
    )

    /**
     * Builds the view. Catalog [ingredients] override the stored name/aisle snapshot, so a renamed
     * ingredient shows its new name; ingredients dropped from the catalog keep their snapshot.
     */
    fun organize(entries: List<ShoppingEntry>, ingredients: Map<String, Ingredient>): ShoppingListView {
        val rows = entries.map { entry ->
            val catalog = entry.ingredientId?.let(ingredients::get)
            entry to ShoppingRow(
                key = entry.key,
                ingredientId = entry.ingredientId,
                name = catalog?.name ?: entry.name,
                aisle = catalog?.aisle ?: entry.aisle,
                checked = entry.checked,
                quantity = ShoppingQuantities.format(entry.shares),
                recipeCount = entry.recipeIds.size,
            )
        }
        val order = STORE_WALK.withIndex().associate { (i, aisle) -> aisle to i }
        val sections = rows
            .filter { (_, row) -> !row.checked }
            .map { it.second }
            .groupBy { it.aisle }
            .toSortedMap(compareBy { order[it] ?: Int.MAX_VALUE })
            .map { (aisle, list) -> AisleSection(aisle, list.sortedBy { it.name.lowercase() }) }
        val basket = rows
            .filter { (_, row) -> row.checked }
            .sortedWith(compareByDescending<Pair<ShoppingEntry, ShoppingRow>> { it.first.checkedAtEpochMs ?: 0L }.thenBy { it.second.name.lowercase() })
            .map { it.second }
        val recipeIds = entries
            .sortedBy { it.addedAtEpochMs }
            .flatMap { it.recipeIds }
            .distinct()
        return ShoppingListView(sections, basket, recipeIds)
    }

    /** Plain text for the share sheet: what's still to buy, by aisle. */
    fun shareText(view: ShoppingListView): String = buildString {
        append("Shopping list")
        view.sections.forEach { section ->
            append("\n\n").append(section.aisle.label)
            section.rows.forEach { row ->
                append("\n• ").append(row.name)
                row.quantity?.let { append(" (").append(it).append(')') }
            }
        }
    }
}
