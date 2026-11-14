package com.example.cravewise.domain

import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.StapleGroup
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class StapleGroupTest {

    private fun staple(id: String, aisle: Aisle, staple: Boolean = true) =
        Ingredient(id, id, aisle, emptySet(), isPantryStaple = staple)

    @Test fun idOverridesBeatAisle() {
        assertEquals(StapleGroup.Essentials, StapleGroup.of(staple("salt", Aisle.Spices)))
        assertEquals(StapleGroup.Essentials, StapleGroup.of(staple("olive_oil", Aisle.Pantry)))
        assertEquals(StapleGroup.Sauces, StapleGroup.of(staple("tomato_puree", Aisle.Produce)))
    }

    @Test fun aisleFallbacks() {
        assertEquals(StapleGroup.Spices, StapleGroup.of(staple("paprika", Aisle.Spices)))
        assertEquals(StapleGroup.Baking, StapleGroup.of(staple("sugar", Aisle.Pantry)))
        assertEquals(StapleGroup.Sauces, StapleGroup.of(staple("soy_sauce", Aisle.Condiments)))
        assertEquals(StapleGroup.Aromatics, StapleGroup.of(staple("onion", Aisle.Produce)))
        assertEquals(StapleGroup.Fridge, StapleGroup.of(staple("egg", Aisle.DairyEggs)))
    }

    @Test fun nonStaplesAndWaterHaveNoGroup() {
        assertNull(StapleGroup.of(staple("chicken", Aisle.MeatSeafood, staple = false)))
        assertNull(StapleGroup.of(staple("water", Aisle.Other)))
    }

    @Test fun onlyAssumedGroupsCountAsOwned() {
        val pantry = Pantry(assumedStaples = setOf(StapleGroup.Spices))
        assertTrue(pantry.owns(staple("paprika", Aisle.Spices)))
        assertFalse(pantry.owns(staple("egg", Aisle.DairyEggs)))
        assertFalse(pantry.owns(staple("chicken", Aisle.MeatSeafood, staple = false)))
    }

    @Test fun waterIsAlwaysOwned() {
        assertTrue(Pantry(assumedStaples = emptySet()).owns(staple("water", Aisle.Other)))
    }

    @Test fun defaultSkipsTheFridge() {
        assertFalse(StapleGroup.Fridge in StapleGroup.DEFAULT)
        assertEquals(StapleGroup.entries.size - 1, StapleGroup.DEFAULT.size)
    }
}
