package com.example.cravewise.ui.profile

import com.example.cravewise.domain.ProfileConflict

/** Human-readable reason for a profile conflict. [ingredientName] resolves hated ingredient ids. */
fun ProfileConflict.describe(ingredientName: (String) -> String): String = when (this) {
    is ProfileConflict.ContainsAllergen -> "Contains ${allergen.label}, which you avoid"
    is ProfileConflict.NotDiet -> "Not ${diet.label}"
    is ProfileConflict.HatedIngredient -> "Has ${ingredientName(ingredientId)}, which you don't like"
    is ProfileConflict.TooSpicy -> "Heat $level/5, above your limit of $max"
}

/** Spice tolerance options, 0..5. */
val SPICE_LABELS = listOf("No heat", "Mild", "Gentle", "Medium", "Hot", "Any heat")
