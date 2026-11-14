package com.example.cravewise.ui.profile

import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FoodProfile
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ProfileSummaryTest {

    @Test fun emptyProfileInvitesTheUser() {
        assertTrue(profileSummary(FoodProfile(), hatedCount = 0).startsWith("Nothing's hidden yet"))
    }

    @Test fun anyHeatOnItsOwnHidesNothing() {
        assertTrue(profileSummary(FoodProfile(maxSpice = FoodProfile.MAX_SPICE), 0).startsWith("Nothing's hidden yet"))
    }

    @Test fun listsEveryRuleInOneSentence() {
        val profile = FoodProfile(
            allergens = setOf(Allergen.Milk, Allergen.Peanuts),
            diets = setOf(Diet.Vegetarian, Diet.NoPorkNoAlcohol),
            maxSpice = 2,
        )
        assertEquals(
            "I'm hiding anything with peanuts and milk, pork and alcohol, anything that isn't vegetarian, " +
                "2 ingredients you hate and heat above 2/5, everywhere in the app.",
            profileSummary(profile, hatedCount = 2),
        )
    }

    @Test fun noHeatReadsAsSpicy() {
        assertEquals("I'm hiding anything spicy, everywhere in the app.", profileSummary(FoodProfile(maxSpice = 0), 0))
    }

    @Test fun naturalJoinUsesCommasThenAnd() {
        assertEquals("a", naturalJoin(listOf("a")))
        assertEquals("a and b", naturalJoin(listOf("a", "b")))
        assertEquals("a, b and c", naturalJoin(listOf("a", "b", "c")))
    }
}
