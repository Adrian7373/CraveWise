# CraveWise Design System: "Noodle Pop"

Bold sticker style: tomato red, saffron yellow, and ink-navy outlines on a peach-cream canvas.
It stays clean because it uses **one border weight (2dp)**, **one solid shadow offset (4dp)**,
and **one mascot (Via the panda)**. Light and dark themes are both first-class.

## File locations

| What | Where |
|---|---|
| Colors (the only place raw hex is allowed) | `app/src/main/java/com/example/cravewise/ui/theme/Color.kt` |
| Type scale | `ui/theme/Type.kt` |
| Theme entry point, shapes, `CraveExtras`, `Flavor` | `ui/theme/Theme.kt` |
| Reusable components + `@CravePreviews` | `ui/designsystem/CraveComponents.kt` |
| Living catalog screen + component previews | `ui/designsystem/DesignSystemCatalogScreen.kt` |
| Via artwork | `app/src/main/res/drawable-nodpi/via.png` (flat backdrop `#F5E2D2`) |

The catalog is reachable in-app via **Profile → "Design system catalog"** (`DesignCatalogRoute`).

## Tokens and how to use them

Two sources of tokens. Never read colors, shapes or sizes from anywhere else.

- **`MaterialTheme.colorScheme` / `.typography` / `.shapes`** hold the standard M3 roles.
- **`CraveTheme.extras`** holds brand tokens M3 doesn't have: `mascot`, `mascotBackdrop`,
  `mascotShape`, `buttonShape` (16dp), `chipShape` (pill), `borderWidth` (2dp), `borderColor`,
  `hardShadowOffset` (4dp), `hardShadowColor`, `cardColor`, `flavor` (6 flavor accents).

### Color roles

| Role | Use for |
|---|---|
| `primary` (tomato) | The single most important action on a screen, match badges |
| `secondaryContainer` (saffron) | Secondary actions, **selected** chips |
| `tertiaryContainer` (periwinkle) | Informational tags, "have it" ingredient pills |
| `errorContainer` | Allergen warnings. Safety info always uses error colors |
| `background` / `extras.cardColor` | Screen canvas / card and input fill |
| `outline` (ink navy; cream in dark) | Borders and sticker shadows. It comes from `extras`, don't pass it yourself |
| `extras.flavor[Flavor.X]` | Flavor dots, bars, spice flames, recipe art tint only. Never text |

### Typography
Headings are Black weight with -0.5sp tracking, titles ExtraBold, labels Bold, body Regular.
- `headlineMedium`: screen hero question. `headlineSmall`: section titles (`SectionHeader`).
- `titleLarge`: card titles. `titleMedium`: in-card headings.
- `bodyLarge/Medium`: copy. `labelLarge`: buttons and chips. `labelMedium`: tags and metadata.
- Platform sans-serif for now. To brand it, change only `HeadingFamily`/`BodyFamily` in `Type.kt`.

### Shape & spacing
- Shapes: `small` 12, `medium` 16, `large` 22 (cards), `extraLarge` 28; buttons 16; chips pill.
- Spacing: screen gutters **20dp**, gaps between stacked items **16dp**, between sections **32dp**,
  card padding **16dp** (feature cards 20dp). Minimum touch target 48dp (buttons are 52dp tall).

## Components (`ui/designsystem`)

| Component | Use it for |
|---|---|
| `CraveSurface` | The base for **every** custom container: outline, sticker shadow, press-in |
| `CraveButton` (`Primary` / `Secondary` / `Outline`) | All buttons except top-bar icons and inline `TextButton` links |
| `CraveChip`, `FlavorChip` | Selectable filters and quiz answers |
| `CraveTag` | Static info (diet, cuisine, allergen). Flat, no shadow |
| `IngredientPill` | Have (filled + check) vs. missing (outlined + add) |
| `SpiceMeter`, `FlavorProfile`, `MatchBadge` | Recipe data display |
| `AllergenNotice` | A recipe's allergen summary (error colors + icon), or a neutral "none listed, check labels" note |
| `RecipeCard` | Any recipe in a list (browse, pantry results, search) |
| `CraveSearchField` | Free-text search input |
| `SectionHeader` | Section titles, with an optional eyebrow and action |
| `ViaMascot`, `ViaSays`, `ViaEmptyState` | Mascot avatar, speech-bubble tips, empty/no-results states |

### Guidelines
- **One `Primary` button per screen.** Use `Secondary` or `Outline` for everything else.
- **Shadows mean "tappable" or "selected".** Static content (tags, swatches, badges) uses
  `hardShadow = false`. Unselected chips have no shadow; selected chips do.
- **Via has a voice:** upbeat, short, food puns welcome ("slurp-worthy"). Use `ViaSays` for
  guidance and `ViaEmptyState` whenever a list or search can be empty. Always include a next action.
  At most one Via per screen.
- **Safety first:** allergen and diet warnings use `errorContainer` plus an icon. Never show them
  with color alone, and never put them in a Via joke.
- Screens own their `Scaffold` and use `containerColor = colorScheme.background` and a
  background-colored `TopAppBar`, so the canvas reads as one sheet of paper.

## Do / Don't

```kotlin
// ✅ Do: build on CraveSurface and read tokens from the theme
CraveSurface(onClick = onOpen, color = MaterialTheme.colorScheme.secondaryContainer) { … }
Box(Modifier.background(CraveTheme.extras.flavor[Flavor.Spicy]))

// ❌ Don't: raw hex, ad-hoc borders/shadows, or a plain Material Card
Card(border = BorderStroke(3.dp, Color(0xFF000000)), elevation = CardDefaults.cardElevation(8.dp)) { … }
Text("Hot!", color = Color(0xFFFF5A3C))
```

```kotlin
// ✅ Do: use the shared button
CraveButton("Add 2 to shopping list", onClick = add, variant = CraveButtonVariant.Secondary)

// ❌ Don't: restyle M3 buttons per screen
Button(onClick = add, shape = RoundedCornerShape(8.dp), colors = ButtonDefaults.buttonColors(Color.Yellow)) { … }
```

| ✅ Do | ❌ Don't |
|---|---|
| Use `MaterialTheme.typography.*` styles | Set `fontSize`/`fontWeight` inline |
| Get depth only from `CraveSurface` (2dp outline + 4dp shadow) | Use `shadowElevation` or Material `elevation` |
| Use flavor colors for dots, bars and art | Use flavor colors for text or button fills |
| Show Via on empty states and tips | Show several Vias per screen, or stretch/recolor the artwork |
| Check light **and** dark | Assume `outline` is dark (it's cream in dark mode) |

## Rule: new components need previews and a catalog entry

Any new reusable composable added to `ui/designsystem/` (or promoted there from a feature) must:

1. Read only theme tokens (`MaterialTheme.*`, `CraveTheme.extras`). No raw hex, and no new
   sizes if an existing token fits.
2. Have a **preview annotated with `@CravePreviews`** (light + dark), wrapped in
   `CravePreviewSurface { … }`, covering its main states (selected/disabled/empty, etc.).
3. Be **added to `DesignSystemCatalogScreen`**: extend an existing section or add a new
   `item("…") { …Section() }` with a numbered `SectionHeader` eyebrow.
4. Get a row in the Components table above.

Feature screens should also use `@CravePreviews`. A PR that adds a component without its preview
and catalog entry is incomplete.

## Changing a token
Edit it in `ui/theme/` only, then open the catalog (or the `Catalog · light/dark` previews) and
check both themes. New brand-level tokens go into `CraveExtras` and must be shown in the catalog.
