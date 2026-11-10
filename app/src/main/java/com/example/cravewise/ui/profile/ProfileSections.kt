package com.example.cravewise.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FoodProfile
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.ui.designsystem.CraveChip
import com.example.cravewise.ui.designsystem.CravePreviews
import com.example.cravewise.ui.designsystem.CraveSearchField
import com.example.cravewise.ui.designsystem.CraveSurface
import com.example.cravewise.ui.designsystem.SpiceMeter
import com.example.cravewise.ui.theme.CraveWiseTheme

/*
 * Profile editors shared by onboarding and the Profile tab. Each one is just the controls;
 * callers add the heading (SectionHeader on Profile, a Via question in onboarding).
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AllergyEditor(selected: Set<Allergen>, onToggle: (Allergen) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Allergen.entries.forEach { allergen ->
                CraveChip(allergen.label, selected = allergen in selected, onClick = { onToggle(allergen) })
            }
        }
        CheckLabelsNote()
    }
}

/** Neutral note, same tone as AllergenNotice's "none listed": derived data, not a guarantee. */
@Composable
private fun CheckLabelsNote() {
    val cs = MaterialTheme.colorScheme
    CraveSurface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = cs.surfaceContainer,
        contentColor = cs.onSurfaceVariant,
        hardShadow = false,
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.Top) {
            Icon(Icons.Outlined.Info, contentDescription = null, modifier = Modifier.size(24.dp))
            Spacer(Modifier.width(12.dp))
            Text(
                "I'll hide recipes with these allergens, based on each recipe's ingredient list. " +
                    "Packaged products can still contain them, so always check labels.",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DietEditor(selected: Set<Diet>, onToggle: (Diet) -> Unit, modifier: Modifier = Modifier) {
    FlowRow(modifier, horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Diet.entries.forEach { diet ->
            CraveChip(diet.label, selected = diet in selected, onClick = { onToggle(diet) })
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HatedIngredientsEditor(
    hated: List<Ingredient>,
    query: String,
    suggestions: List<Ingredient>,
    onQueryChange: (String) -> Unit,
    onSubmit: () -> Unit,
    onAdd: (String) -> Unit,
    onRemove: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        CraveSearchField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = "e.g. coriander",
            onSubmit = onSubmit,
        )
        if (query.isNotBlank()) {
            if (suggestions.isEmpty()) {
                Text(
                    "No ingredient called “${query.trim()}” in the cookbook. Try another name?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            } else {
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    suggestions.forEach { ingredient ->
                        CraveChip(
                            text = ingredient.name,
                            selected = false,
                            onClick = { onAdd(ingredient.id) },
                            leading = { Icon(Icons.Outlined.Add, contentDescription = null, modifier = Modifier.size(16.dp)) },
                            modifier = Modifier.semantics { role = Role.Button },
                        )
                    }
                }
            }
        }
        if (hated.isEmpty()) {
            Text(
                "Nothing yet. I'll hide every recipe that uses an ingredient you add here.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        } else {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                hated.forEach { ingredient ->
                    CraveChip(
                        text = ingredient.name,
                        selected = true,
                        onClick = { onRemove(ingredient.id) },
                        trailingIcon = Icons.Outlined.Close,
                        trailingIconDescription = "Remove ${ingredient.name}",
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SpiceEditor(maxSpice: Int?, onSelect: (Int) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            (0..FoodProfile.MAX_SPICE).forEach { level ->
                CraveChip(SPICE_LABELS[level], selected = maxSpice == level, onClick = { onSelect(level) })
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            SpiceMeter(maxSpice ?: FoodProfile.MAX_SPICE)
            Spacer(Modifier.width(12.dp))
            Text(
                when (maxSpice) {
                    null -> "Not set yet, so nothing is hidden"
                    0 -> "Only recipes with no heat"
                    FoodProfile.MAX_SPICE -> "Bring on the fire"
                    else -> "Hides anything hotter than $maxSpice/5"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

private val previewIngredients = listOf(
    Ingredient("coriander", "Coriander", Aisle.Produce, emptySet(), false),
    Ingredient("olives", "Olives", Aisle.Pantry, emptySet(), false),
)

@CravePreviews
@Composable
private fun ProfileEditorsPreview() = CraveWiseTheme {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(32.dp)) {
            AllergyEditor(setOf(Allergen.Peanuts, Allergen.Milk), {})
            DietEditor(setOf(Diet.Vegetarian), {})
            HatedIngredientsEditor(previewIngredients, query = "", suggestions = emptyList(), {}, {}, {}, {})
            SpiceEditor(2, {})
        }
    }
}
