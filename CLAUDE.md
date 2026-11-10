# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this app is

CraveWise is a single-module Android app (`:app`, package `com.example.cravewise`) that helps people decide what to cook. Planned features:
- **Pantry match:** the user enters the ingredients they have and sees recipes they can cook.
- **Cookbook browsing**, with a shopping list for missing ingredients.
- **"Help me decide" quiz** covering cuisine, allergies, hated ingredients, spice tolerance, proteins, etc.
- **Smart search**, e.g. "something salty".

Current state: Phases 0–4 are done (shell, Room data layer + seed, cookbook, pantry match, profile + quiz). Home, browse/category (`BrowseRoute`), recipe detail, favorites (`FavoritesRoute`), the My Kitchen pantry tab, onboarding, the Profile tab and the "Help me decide" quiz are real; Search and Shopping are still placeholders.

Pantry match: `domain/PantryMatcher` (pure, ID-based, buckets Cook now / Almost there (1–2 missing) / Needs a shop) and `domain/IngredientSearch` (type-ahead over names + synonyms). The pantry list is the `pantry_items` Room table; the "assume basics" (`isPantryStaple`) toggle is in DataStore (`user_prefs`).

Profile (Phase 4): `FoodProfile` = allergens, diets, hated ingredient ids, `maxSpice` (null = never set → Home nudges; 5 = any heat). Allergens/diets/spice/onboarding flag live in DataStore; hated ingredients in the `hated_ingredients` Room table (`ProfileRepository`). **All four are hard filters, hidden everywhere**: every list VM gets a `ProfileGate` from `ProfileGateSource` and applies `gate.recipes(...)`/`gate.filter(...)` as the LAST step (after Cookbook filters, `PantryMatcher.match`, `DecideQuiz.rank`, and later search). When the gate empties a non-empty list, show a "Hidden by your profile" `ViaEmptyState` linking to Profile. Recipe detail stays reachable and shows `ProfileConflictNotice`. Onboarding (`ui/onboarding`) is a skippable first-run flow gated by `AppViewModel` in `CraveWiseAppRoot`; it and the Profile tab share `ProfileViewModel` + the editors in `ui/profile/ProfileSections.kt`. The quiz (`domain/DecideQuiz`) narrows by meal type + time, scores cravings/mood/protein/pantry, and is fresh on every visit.

## Commands (Windows / PowerShell, run from repo root)

```
.\gradlew.bat :app:assembleDebug                      # build debug APK
.\gradlew.bat :app:installDebug                       # install on connected device/emulator
.\gradlew.bat :app:testDebugUnitTest                  # JVM unit tests
.\gradlew.bat :app:testDebugUnitTest --tests "com.example.cravewise.SomeTest"   # single test class
.\gradlew.bat :app:connectedDebugAndroidTest          # instrumented / Compose UI tests
.\gradlew.bat :app:lintDebug                          # Android lint
```

First builds can take several minutes while dependencies download. Configuration cache is enabled (`gradle.properties`).

## Build setup notes

- **AGP 9.5 with built-in Kotlin.** Do NOT apply `org.jetbrains.kotlin.android` in `app/build.gradle.kts`. It is declared `apply false` in the root build file only to pin the KGP version, which must match the `kotlin.plugin.compose` and `kotlin.plugin.serialization` versions (all use `kotlin` in `gradle/libs.versions.toml`).
- **KSP** handles both Hilt and Room. The Room Gradle plugin exports schemas to `app/schemas/`.
- compileSdk/targetSdk 37, minSdk 24, Java 17.
- All dependency versions live in `gradle/libs.versions.toml`.
- Icons come from `material-icons-extended` (pinned 1.7.8, outside the Compose BOM).

## Architecture

MVVM + unidirectional data flow, with Hilt for DI. Planned layers (most don't exist yet):
- `data/`: Room + DataStore, repositories.
- `domain/`: models and use cases such as pantry matching, ranking and query parsing.
- `ui/<feature>/`.

**Navigation (Navigation 3, multiple back stacks)** — the key cross-file piece:
- `navigation/Routes.kt`: every destination is a `@Serializable` `NavKey`. Top-level tab routes are `data object`s; sub-routes (e.g. `RecipeDetailRoute(recipeId)`) get pushed onto the current tab's stack.
- `navigation/NavigationState.kt`: one `NavBackStack` per tab, saved across process death. Uses the "exit through home" pattern (Home's stack is always at the bottom). Each entry is decorated with saveable-state and ViewModel-store decorators, so `hiltViewModel()` inside an entry is scoped to that entry.
- `navigation/Navigator.kt`: the only place that changes nav state. `navigate(route)` switches tabs if `route` is a tab key, otherwise pushes onto the current tab. `navigateInTab(tab, route)` does a cross-tab push.
- `ui/CraveWiseAppRoot.kt`: holds the tab list (`TOP_LEVEL_DESTINATIONS`), the `entryProvider` that maps each route to a screen, and the outer `Scaffold` + `NavigationBar` + `NavDisplay`.
- **To add a screen:** add a route in `Routes.kt`, then add an `entry<...>` in `CraveWiseAppRoot.kt`.

**Insets / edge-to-edge:**
- `MainActivity` calls `enableEdgeToEdge()`.
- The outer Scaffold uses zero content insets and applies `padding(innerPadding).consumeWindowInsets(innerPadding)` to `NavDisplay`.
- Each screen owns its own inner `Scaffold` + `TopAppBar`, which handles the status-bar inset.

**Theme / design system:** "Noodle Pop". Tokens live in `ui/theme/` (fixed brand palette, no dynamic color on purpose); reusable components and the catalog live in `ui/designsystem/`. The mascot is Via the panda. XML themes are window-only (`android:Theme.Material.*.NoActionBar`); all styling happens in Compose. Follow the rules in the design doc below: theme tokens only, `@CravePreviews` on every component, and every new component added to the catalog.

@docs/DESIGN.md

## Product decisions (agreed with the user)

- **Local-only, no accounts.** Recipe data is the app's own curated dataset, maintained as JSON and shipped as a pre-filled Room database. No backend for now. Audience is 10–20 testers; Supabase can come later, at publish time.
- **Data model:** recipes carry structured tags (flavor scores 0–5 for salty/sweet/sour/bitter/umami/spicy, spiceLevel, texture, allergens, diets, proteins, mood, cuisine, meal type, times, difficulty). Ingredients are canonical IDs with synonyms, an aisle, allergens and an `isPantryStaple` flag. Pantry matching compares ingredient IDs, never free text.
- **Safety rule:** allergy, diet and hated-ingredient filters are hard filters applied in code after any search or ranking step. Never rely on AI- or heuristic-derived tags alone for allergens.
- **Smart search order:** keyword lexicon + full-text first, then on-device vector search with a small text-embedding model. An LLM query parser is a later, optional addition.
- **Roadmap:**
  0. Shell (done)
  1. Data layer + seed recipes
  2. Cookbook browse/detail
  3. Pantry match
  4. Profile + quiz
  5. Shopping list
  6. Smart search
  7. Polish (cook mode, timers, servings scaling)
- **Before public release:** TheMealDB-derived content is acceptable for testers but must be replaced or rewritten.

- Never add Claude as co-author in commits or PRs” in CLAUDE.md.
