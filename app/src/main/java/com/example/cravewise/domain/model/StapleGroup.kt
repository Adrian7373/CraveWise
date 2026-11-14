package com.example.cravewise.domain.model

/**
 * Shelves of pantry staples the user can say they keep, one switch each, instead of a single
 * "I have the basics" that also assumed eggs and milk. Only ingredients flagged `isPantryStaple`
 * belong to a group; [of] maps them by id first, then by aisle, so new staples in the seed land
 * somewhere sensible without an app change.
 */
enum class StapleGroup(val label: String) {
    Essentials("Oil, salt & pepper"),
    Spices("Spice rack"),
    Baking("Baking shelf"),
    Sauces("Sauces & stock"),
    Aromatics("Onion & garlic"),
    Fridge("Eggs, milk & butter"),
    ;

    companion object {
        /**
         * Fridge basics go off quickly, so they're not assumed until the user says so; the rest
         * keep for months. Matches the old single switch for everything else.
         */
        val DEFAULT: Set<StapleGroup> = entries.toSet() - Fridge

        /** Always owned, whatever the switches say. */
        private val ALWAYS = setOf("water")

        private val BY_ID = mapOf(
            "salt" to Essentials,
            "black_pepper" to Essentials,
            "olive_oil" to Essentials,
            "vegetable_oil" to Essentials,
            "tomato_puree" to Sauces,
        )

        fun isAlwaysOwned(ingredient: Ingredient): Boolean = ingredient.id in ALWAYS

        /** The group a staple belongs to, or null for non-staples and always-owned items. */
        fun of(ingredient: Ingredient): StapleGroup? {
            if (!ingredient.isPantryStaple || isAlwaysOwned(ingredient)) return null
            BY_ID[ingredient.id]?.let { return it }
            return when (ingredient.aisle) {
                Aisle.Spices -> Spices
                Aisle.Pantry, Aisle.Bakery -> Baking
                Aisle.Condiments, Aisle.International -> Sauces
                Aisle.Produce -> Aromatics
                Aisle.DairyEggs, Aisle.MeatSeafood, Aisle.Frozen -> Fridge
                Aisle.Beverages, Aisle.Other -> Essentials
            }
        }
    }
}
