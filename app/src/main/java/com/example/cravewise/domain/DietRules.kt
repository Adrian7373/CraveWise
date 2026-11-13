package com.example.cravewise.domain

import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.ContainsFlag
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.Protein

/** The facts about one canonical ingredient that safety-relevant tags are derived from. */
data class IngredientFacts(
    val allergens: Set<Allergen>,
    val contains: Set<ContainsFlag>,
    val protein: Protein?,
)

data class DerivedTags(
    val allergens: Set<Allergen>,
    val diets: Set<Diet>,
    val proteins: Set<Protein>,
)

/**
 * Authoritative rules for recipe allergens / diets / proteins (safety rule: these come only from
 * canonical ingredient data, never from hand tags or heuristics). Every line counts, including
 * garnishes and "optional" ones, so we err on the side of excluding a recipe.
 *
 * tools/seedgen has a preview copy of these rules for its review sheets; keep them in step.
 */
object DietRules {
    private val animalFlesh = setOf(
        ContainsFlag.Meat, ContainsFlag.Pork, ContainsFlag.Poultry,
        ContainsFlag.Fish, ContainsFlag.Shellfish, ContainsFlag.Gelatin,
    )
    private val animalProducts = setOf(ContainsFlag.Dairy, ContainsFlag.Egg, ContainsFlag.Honey)
    private val landMeat = setOf(ContainsFlag.Meat, ContainsFlag.Pork, ContainsFlag.Poultry, ContainsFlag.Gelatin)
    private val porkOrAlcohol = setOf(ContainsFlag.Pork, ContainsFlag.Alcohol, ContainsFlag.Gelatin)

    fun derive(ingredients: Collection<IngredientFacts>): DerivedTags {
        val allergens = ingredients.flatMapTo(mutableSetOf()) { it.allergens }
        val contains = ingredients.flatMapTo(mutableSetOf()) { it.contains }
        val proteins = ingredients.mapNotNullTo(mutableSetOf()) { it.protein }

        val diets = buildSet {
            if (contains.none { it in animalFlesh }) {
                add(Diet.Vegetarian)
                if (contains.none { it in animalProducts }) add(Diet.Vegan)
            }
            if (contains.none { it in landMeat }) add(Diet.Pescatarian)
            if (Allergen.Gluten !in allergens) add(Diet.GlutenFree)
            if (Allergen.Milk !in allergens && ContainsFlag.Dairy !in contains) add(Diet.DairyFree)
            if (contains.none { it in porkOrAlcohol }) add(Diet.NoPorkNoAlcohol)
        }
        return DerivedTags(allergens, diets, proteins)
    }
}
