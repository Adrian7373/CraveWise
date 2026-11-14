package com.example.cravewise.ui.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Eco
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.RamenDining
import androidx.compose.material.icons.outlined.SoupKitchen
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cravewise.ui.theme.CraveTheme
import com.example.cravewise.ui.theme.CraveWiseTheme
import com.example.cravewise.ui.theme.Flavor
import com.example.cravewise.ui.theme.cookStep

/**
 * Living catalog of the CraveWise design system. Every reusable component must have a section
 * here (see docs/DESIGN.md). Opened from Profile → "Design system catalog".
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignSystemCatalogScreen(
    onBack: (() -> Unit)? = null,
    initialDark: Boolean? = null,
) {
    val systemDark = isSystemInDarkTheme()
    var dark by rememberSaveable { mutableStateOf(initialDark ?: systemDark) }

    CraveWiseTheme(darkTheme = dark) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                TopAppBar(
                    title = { Text("Design system") },
                    navigationIcon = {
                        if (onBack != null) {
                            IconButton(onClick = onBack) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                            }
                        }
                    },
                    actions = {
                        IconButton(onClick = { dark = !dark }) {
                            Icon(
                                if (dark) Icons.Outlined.LightMode else Icons.Outlined.DarkMode,
                                contentDescription = if (dark) "Switch to light theme" else "Switch to dark theme",
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                )
            },
        ) { padding ->
            LazyColumn(
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = padding.calculateTopPadding() + 4.dp,
                    bottom = padding.calculateBottomPadding() + 32.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier.fillMaxSize(),
            ) {
                // Add a section for every new design-system component.
                item("hero") { HeroSection() }
                item("color") { ColorSection() }
                item("type") { TypeSection() }
                item("shape") { ShapeSection() }
                item("buttons") { ButtonSection() }
                item("chips") { ChipSection() }
                item("inputs") { InputSection() }
                item("cards") { CardSection() }
                item("via") { ViaSection() }
                item("safety") { SafetySection() }
                item("cooking") { CookingSection() }
        item("nutrition") { NutritionSection() }
            }
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Sections
// ---------------------------------------------------------------------------------------------

@Composable
private fun HeroSection() {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ViaFigure(ViaPose.Hello, height = 200.dp)
        Text("Noodle Pop", style = MaterialTheme.typography.displaySmall, textAlign = TextAlign.Center)
        Text(
            "Bold sticker energy: playful, loud, and fun to tap",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(4.dp))
        ViaSays("Hungry?! I'm Via. Toss me your ingredients and I'll find something slurp-worthy!")
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ColorSection() {
    val cs = MaterialTheme.colorScheme
    val extras = CraveTheme.extras
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Color", eyebrow = "01 · Palette")
        FlowRow(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Swatch("Primary", cs.primary, cs.onPrimary)
            Swatch("Primary ctr", cs.primaryContainer, cs.onPrimaryContainer)
            Swatch("Secondary", cs.secondaryContainer, cs.onSecondaryContainer)
            Swatch("Tertiary", cs.tertiary, cs.onTertiary)
            Swatch("Tertiary ctr", cs.tertiaryContainer, cs.onTertiaryContainer)
            Swatch("Error ctr", cs.errorContainer, cs.onErrorContainer)
            Swatch("Background", cs.background, cs.onBackground)
            Swatch("Card", extras.cardColor, cs.onSurface)
            Swatch("Outline", cs.outline, cs.surface)
        }
        Text("Flavor accents", style = MaterialTheme.typography.labelLarge)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Flavor.entries.forEach { flavor ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(14.dp).clip(CircleShape).background(extras.flavor[flavor]))
                    Spacer(Modifier.width(6.dp))
                    Text(flavor.label, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
private fun Swatch(name: String, color: Color, onColor: Color) {
    CraveSurface(
        modifier = Modifier.width(100.dp),
        shape = MaterialTheme.shapes.medium,
        color = color,
        contentColor = onColor,
        hardShadow = false,
    ) {
        Column(Modifier.padding(10.dp).height(56.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Text(name, style = MaterialTheme.typography.labelMedium, maxLines = 1)
            Text("#" + Integer.toHexString(color.toArgb()).uppercase().takeLast(6), style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
private fun TypeSection() {
    val t = MaterialTheme.typography
    val samples: List<Pair<String, TextStyle>> = listOf(
        "Display S" to t.displaySmall,
        "Headline M" to t.headlineMedium,
        "Title L" to t.titleLarge,
        "Title M" to t.titleMedium,
        "Body L" to t.bodyLarge,
        "Body M" to t.bodyMedium,
        "Label L" to t.labelLarge,
        "Cook step" to t.cookStep,
    )
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        SectionHeader("Typography", eyebrow = "02 · Type")
        samples.forEach { (name, style) ->
            Column {
                Text(name, style = t.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("Crispy garlic noodles", style = style)
            }
        }
    }
}

@Composable
private fun ShapeSection() {
    val s = MaterialTheme.shapes
    val items: List<Pair<String, Shape>> = listOf(
        "Small" to s.small,
        "Medium" to s.medium,
        "Large" to s.large,
        "Button" to CraveTheme.extras.buttonShape,
    )
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Shape & depth", eyebrow = "03 · Form")
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            items.forEach { (name, shape) ->
                Column(
                    Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    CraveSurface(
                        modifier = Modifier.fillMaxWidth().height(64.dp),
                        shape = shape,
                        color = MaterialTheme.colorScheme.primaryContainer,
                    ) {}
                    Text(name, style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Composable
private fun ButtonSection() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        SectionHeader("Buttons", eyebrow = "04 · Actions")
        CraveButton("Cook with what I have", onClick = {}, icon = Icons.Outlined.Kitchen, modifier = Modifier.fillMaxWidth())
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CraveButton(
                "Help me decide",
                onClick = {},
                variant = CraveButtonVariant.Secondary,
                icon = Icons.Outlined.Quiz,
                modifier = Modifier.weight(1f),
            )
            CraveButton("Browse", onClick = {}, variant = CraveButtonVariant.Outline, modifier = Modifier.weight(0.7f))
        }
        CraveButton("Disabled", onClick = {}, enabled = false)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ChipSection() {
    var selected by remember { mutableStateOf(setOf(Flavor.Umami, Flavor.Spicy)) }
    val cs = MaterialTheme.colorScheme
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Chips & tags", eyebrow = "05 · Filters")
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Flavor.entries.forEach { flavor ->
                FlavorChip(
                    flavor = flavor,
                    selected = flavor in selected,
                    onClick = { selected = if (flavor in selected) selected - flavor else selected + flavor },
                )
            }
        }
        Text("Removable (pantry items)", style = MaterialTheme.typography.labelLarge)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            var pantry by remember { mutableStateOf(listOf("Garlic", "Soy sauce", "Egg")) }
            pantry.forEach { item ->
                CraveChip(
                    text = item,
                    selected = true,
                    onClick = { pantry = pantry - item },
                    trailingIcon = Icons.Outlined.Close,
                    trailingIconDescription = "Remove $item",
                )
            }
            CraveChip(
                text = "Scallion",
                selected = false,
                onClick = { if ("Scallion" !in pantry) pantry = pantry + "Scallion" },
                leading = { Icon(Icons.Outlined.Add, contentDescription = null, modifier = Modifier.size(16.dp)) },
            )
        }
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CraveTag("Vegetarian", icon = Icons.Outlined.Eco)
            CraveTag("Gluten-free")
            CraveTag(
                "Contains peanuts",
                icon = Icons.Outlined.WarningAmber,
                color = cs.errorContainer,
                contentColor = cs.onErrorContainer,
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Spice level", style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.width(12.dp))
            SpiceMeter(level = 3)
        }
    }
}

@Composable
private fun InputSection() {
    var query by remember { mutableStateOf("") }
    var filled by remember { mutableStateOf("creamy and quick") }
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Inputs", eyebrow = "06 · Search")
        CraveSearchField(value = query, onValueChange = { query = it })
        // With onClear: a × appears while there's text (Search tab).
        CraveSearchField(value = filled, onValueChange = { filled = it }, onClear = { filled = "" })
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CardSection() {
    val flavor = CraveTheme.extras.flavor
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Cards", eyebrow = "07 · Recipes", actionLabel = "See all")
        RecipeArtRow()
        RecipeCard(
            title = "Spicy Garlic Ramen",
            cuisine = "Japanese",
            minutes = 25,
            difficulty = "Easy",
            spiceLevel = 3,
            art = Icons.Outlined.RamenDining,
            accent = flavor.spicy,
            matchPercent = 71,
            onClick = {},
            footer = {
                Text("You have 5 of 7. Missing:", style = MaterialTheme.typography.labelLarge)
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    IngredientPill("Chili oil", have = false)
                    IngredientPill("Bok choy", have = false)
                }
            },
        )
        RecipeCard(
            title = "Chicken Adobo",
            cuisine = "Filipino",
            minutes = 45,
            difficulty = "Medium",
            spiceLevel = 1,
            art = Icons.Outlined.SoupKitchen,
            accent = flavor.umami,
            onClick = {},
        )
        CraveSurface(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Flavor profile", style = MaterialTheme.typography.titleMedium)
                FlavorProfile(
                    mapOf(
                        Flavor.Salty to 4, Flavor.Sweet to 1, Flavor.Sour to 2,
                        Flavor.Bitter to 0, Flavor.Umami to 5, Flavor.Spicy to 3,
                    ),
                )
            }
        }
        CraveSurface(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("You have 5 of 7 ingredients", style = MaterialTheme.typography.titleMedium)
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("Ramen noodles", "Garlic", "Soy sauce", "Egg", "Scallion").forEach { IngredientPill(it, have = true) }
                    listOf("Chili oil", "Bok choy").forEach { IngredientPill(it, have = false) }
                }
                CraveButton(
                    "Add 2 to shopping list",
                    onClick = {},
                    variant = CraveButtonVariant.Secondary,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
private fun ViaSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Via moments", eyebrow = "08 · Mascot")
        // One look everywhere: the avatar, or one of the full-body poses.
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.Bottom) {
            ViaMascot(56.dp)
            ViaPose.entries.forEach { ViaFigure(it, height = 80.dp) }
        }
        ViaHero(
            headline = "Good evening, chef!",
            minHeight = 240.dp,
            actions = { CraveButton("Set spice level", onClick = {}, variant = CraveButtonVariant.Outline) },
        ) {
            Text("How brave is your tongue? Tell me your heat limit.", style = MaterialTheme.typography.bodyMedium)
        }
        ViaSays("Not sure what you're craving? Answer 5 quick questions and I'll pick for you.")
        ViaSpeechBubble(BubbleTail.End) { Text("A bubble can point either way.", style = MaterialTheme.typography.bodyMedium) }
        CraveSurface(Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.surfaceContainerLow) {
            ViaEmptyState(
                title = "No matches yet",
                body = "Add a few more ingredients and I'll sniff out something tasty.",
                actionLabel = "Add ingredients",
                onAction = {},
            )
        }
    }
}

@Composable
private fun SafetySection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Safety notices", eyebrow = "09 · Allergens")
        AllergenNotice(listOf("Gluten", "Milk", "Eggs"))
        AllergenNotice(emptyList())
        ProfileConflictNotice(listOf("Contains Peanuts, which you avoid", "Not Vegetarian", "Heat 4/5, above your limit of 2"))
    }
}

@Composable
private fun CookingSection() {
    var servings by remember { mutableStateOf(4) }
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Cooking", eyebrow = "10 · Cook mode")
        ServingsStepper(value = servings, onValueChange = { servings = it })
        StepProgress(current = 2, total = 6)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CookTimerCard("Step 2 · 20 min", "17:42", CookTimerState.Running, {}, {}, {})
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CookTimerCard("Step 4 · 45 sec", "0:00", CookTimerState.Done, {}, {}, {})
        }
    }
}

@Composable
private fun NutritionSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader("Nutrition", eyebrow = "11 · Per serving")
        NutritionPanel(PreviewNutrition, coveredLines = 9, totalLines = 11, servings = 6, totalKcal = 3072.0)
        NutritionPanel(perServing = null, coveredLines = 5, totalLines = 11)
    }
}

// ---------------------------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------------------------

@Preview(name = "Catalog · light", widthDp = 400, heightDp = 3000)
@Composable
private fun CatalogLightPreview() = DesignSystemCatalogScreen(initialDark = false)

@Preview(name = "Catalog · dark", widthDp = 400, heightDp = 3000)
@Composable
private fun CatalogDarkPreview() = DesignSystemCatalogScreen(initialDark = true)

/** Themed background for component previews. Use with [CravePreviews]. */
@Composable
internal fun CravePreviewSurface(content: @Composable () -> Unit) {
    CraveWiseTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Box(Modifier.padding(16.dp)) { content() }
        }
    }
}

@CravePreviews
@Composable
private fun ButtonsPreview() = CravePreviewSurface { ButtonSection() }

@CravePreviews
@Composable
private fun ChipsPreview() = CravePreviewSurface { ChipSection() }

@CravePreviews
@Composable
private fun SearchFieldPreview() = CravePreviewSurface { InputSection() }

@CravePreviews
@Composable
private fun RecipeCardPreview() = CravePreviewSurface {
    RecipeCard(
        title = "Spicy Garlic Ramen",
        cuisine = "Japanese",
        minutes = 25,
        difficulty = "Easy",
        spiceLevel = 3,
        art = Icons.Outlined.RamenDining,
        accent = CraveTheme.extras.flavor.spicy,
        matchPercent = 92,
        onClick = {},
    )
}

/** One [RecipeArt] per pattern (seeds 0, 1, 2), each with a different flavor accent. */
@Composable
private fun RecipeArtRow() {
    val flavor = CraveTheme.extras.flavor
    val samples = listOf(
        Icons.Outlined.SoupKitchen to flavor.umami,
        Icons.Outlined.RamenDining to flavor.spicy,
        Icons.Outlined.Cake to flavor.sweet,
    )
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        samples.forEachIndexed { seed, (icon, accent) ->
            CraveSurface(Modifier.weight(1f), hardShadow = false) {
                RecipeArt(icon, accent, Modifier.fillMaxWidth().height(96.dp), seed = seed, plateSize = 48.dp)
            }
        }
    }
}

@CravePreviews
@Composable
private fun RecipeArtPreview() = CravePreviewSurface { RecipeArtRow() }

@CravePreviews
@Composable
private fun ViaPreview() = CravePreviewSurface { ViaSection() }

@CravePreviews
@Composable
private fun AllergenNoticePreview() = CravePreviewSurface { SafetySection() }

@CravePreviews
@Composable
private fun CookingPreview() = CravePreviewSurface { CookingSection() }
