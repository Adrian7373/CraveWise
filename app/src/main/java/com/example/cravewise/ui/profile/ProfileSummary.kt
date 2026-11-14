package com.example.cravewise.ui.profile

import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FoodProfile

/**
 * One sentence, in Via's voice, saying what the profile hides. Shown at the top of Profile so the
 * user can check their rules at a glance without reading every section.
 */
fun profileSummary(profile: FoodProfile, hatedCount: Int): String {
    val parts = buildList {
        if (profile.allergens.isNotEmpty()) {
            add("anything with " + naturalJoin(profile.allergens.sortedBy { it.ordinal }.map { it.label.lowercase() }))
        }
        val diets = profile.diets.sortedBy { it.ordinal }
        if (Diet.NoPorkNoAlcohol in diets) add("pork and alcohol")
        val strict = diets - Diet.NoPorkNoAlcohol
        if (strict.isNotEmpty()) add("anything that isn't " + naturalJoin(strict.map { it.label.lowercase() }))
        if (hatedCount > 0) add(if (hatedCount == 1) "1 ingredient you hate" else "$hatedCount ingredients you hate")
        when (val max = profile.maxSpice) {
            null, FoodProfile.MAX_SPICE -> Unit
            0 -> add("anything spicy")
            else -> add("heat above $max/5")
        }
    }
    return if (parts.isEmpty()) {
        "Nothing's hidden yet. Tell me what to keep off your plate and I'll hide it everywhere in the app."
    } else {
        "I'm hiding ${naturalJoin(parts)}, everywhere in the app."
    }
}

/** "a", "a and b", "a, b and c". */
internal fun naturalJoin(items: List<String>): String = when (items.size) {
    0 -> ""
    1 -> items[0]
    else -> items.dropLast(1).joinToString(", ") + " and " + items.last()
}
