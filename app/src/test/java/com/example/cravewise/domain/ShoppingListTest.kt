package com.example.cravewise.domain

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MeasureUnit
import com.example.cravewise.domain.model.ShoppingEntry
import com.example.cravewise.domain.model.ShoppingShare
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ShoppingListTest {

    private fun entry(
        id: String,
        aisle: Aisle,
        checked: Boolean = false,
        added: Long = 0,
        checkedAt: Long? = null,
        shares: List<ShoppingShare> = listOf(ShoppingShare(null)),
        custom: Boolean = false,
    ) = ShoppingEntry(
        key = if (custom) ShoppingEntry.customKeyFor(id) else id,
        ingredientId = if (custom) null else id,
        name = id.replaceFirstChar { it.titlecase() },
        aisle = aisle,
        checked = checked,
        addedAtEpochMs = added,
        checkedAtEpochMs = checkedAt,
        shares = shares,
    )

    @Test fun groupsByAisleInStoreWalkOrderAndSortsByName() {
        val view = ShoppingList.organize(
            listOf(
                entry("soy", Aisle.Condiments),
                entry("onion", Aisle.Produce),
                entry("beef", Aisle.MeatSeafood),
                entry("apple", Aisle.Produce),
            ),
            emptyMap(),
        )
        assertEquals(listOf(Aisle.Produce, Aisle.MeatSeafood, Aisle.Condiments), view.sections.map { it.aisle })
        assertEquals(listOf("Apple", "Onion"), view.sections.first().rows.map { it.name })
        assertEquals(4, view.toBuyCount)
    }

    @Test fun checkedItemsGoToBasketNewestFirst() {
        val view = ShoppingList.organize(
            listOf(
                entry("onion", Aisle.Produce, checked = true, checkedAt = 1),
                entry("beef", Aisle.MeatSeafood, checked = true, checkedAt = 5),
                entry("rice", Aisle.Pantry),
            ),
            emptyMap(),
        )
        assertEquals(listOf("Beef", "Onion"), view.basket.map { it.name })
        assertEquals(listOf(Aisle.Pantry), view.sections.map { it.aisle })
    }

    @Test fun catalogNameAndAisleOverrideTheSnapshot() {
        val catalog = mapOf("scallion" to Ingredient("scallion", "Spring onion", Aisle.Produce, emptySet(), false))
        val row = ShoppingList.organize(listOf(entry("scallion", Aisle.Other)), catalog).sections.single().rows.single()
        assertEquals("Spring onion", row.name)
        assertEquals(Aisle.Produce, row.aisle)
    }

    @Test fun detailMergesAmountsAndCountsRecipes() {
        val onion = entry(
            "onion", Aisle.Produce,
            shares = listOf(
                ShoppingShare("a", 200.0, null, MeasureUnit.G),
                ShoppingShare("b", 1.0, null, MeasureUnit.Kg),
                ShoppingShare(null),
            ),
        )
        val row = ShoppingList.organize(listOf(onion), emptyMap()).sections.single().rows.single()
        assertEquals("1.2 kg · for 2 recipes", row.detail)
    }

    @Test fun recipeIdsFollowAddOrderWithoutDuplicates() {
        val view = ShoppingList.organize(
            listOf(
                entry("beef", Aisle.MeatSeafood, added = 2, shares = listOf(ShoppingShare("b"), ShoppingShare("a"))),
                entry("onion", Aisle.Produce, added = 1, shares = listOf(ShoppingShare("a"))),
                entry("towels", Aisle.Other, added = 3, custom = true),
            ),
            emptyMap(),
        )
        assertEquals(listOf("a", "b"), view.recipeIds)
    }

    @Test fun shareTextListsOnlyWhatsLeftToBuy() {
        val view = ShoppingList.organize(
            listOf(
                entry("onion", Aisle.Produce, shares = listOf(ShoppingShare("a", 2.0, null, null))),
                entry("beef", Aisle.MeatSeafood, checked = true, checkedAt = 1),
            ),
            emptyMap(),
        )
        val text = ShoppingList.shareText(view)
        assertEquals("Shopping list\n\nProduce\n• Onion (2)", text)
        assertTrue("Beef" !in text)
    }

    @Test fun customKeysNormalizeWhitespaceAndCase() {
        assertEquals(ShoppingEntry.customKeyFor("Paper  Towels "), ShoppingEntry.customKeyFor("paper towels"))
    }
}
