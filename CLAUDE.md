# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this app is

CraveWise is a single-module Android app (`:app`, package `com.example.cravewise`) that helps people decide what to cook. Planned features:
- **Pantry match:** the user enters the ingredients they have and sees recipes they can cook.
- **Cookbook browsing**, with a shopping list for missing ingredients.
- **"Help me decide" quiz** covering cuisine, allergies, hated ingredients, spice tolerance, proteins, etc.
- **Smart search**, e.g. "something salty".

Current state: Phases 0–5, 6a and 7 are done (shell, Room data layer + seed, cookbook, pantry match, profile + quiz, shopping list, lexicon + full-text smart search, polish: cook mode + timers, servings scaling, offline/error states, tablet layout). Every tab and screen is real. Phase 6b (on-device vector search) and optional LLM query parsing are still open.

Pantry match: `domain/PantryMatcher` (pure, ID-based, buckets Cook now / Almost there (1–2 missing) / Needs a shop) and `domain/IngredientSearch` (type-ahead over names + synonyms). The pantry list is the `pantry_items` Room table. Staples (`isPantryStaple`) are assumed per `domain/model/StapleGroup` (oil/salt/pepper, spice rack, baking, sauces & stock, onion & garlic, eggs/milk/butter; mapped by id, then aisle; water is always owned). The assumed groups are a string set in DataStore (`pantry_staple_groups`; the old `pantry_assume_staples` boolean only seeds it). The default is every group except the fridge one. The Kitchen tab shows them in a collapsible "Basics I keep" panel.

Profile (Phase 4): `FoodProfile` = allergens, diets, hated ingredient ids, `maxSpice` (null = never set → Home nudges; 5 = any heat). Allergens/diets/spice/onboarding flag live in DataStore; hated ingredients in the `hated_ingredients` Room table (`ProfileRepository`). **All four are hard filters, hidden everywhere**: every list VM gets a `ProfileGate` from `ProfileGateSource` and applies `gate.recipes(...)`/`gate.filter(...)` as the LAST step (after Cookbook filters, `PantryMatcher.match`, `DecideQuiz.rank`, and later search). When the gate empties a non-empty list, show a "Hidden by your profile" `ViaEmptyState` linking to Profile. Recipe detail stays reachable and shows `ProfileConflictNotice`. Onboarding (`ui/onboarding`) is a skippable first-run flow gated by `AppViewModel` in `CraveWiseAppRoot`; it and the Profile tab share `ProfileViewModel` + the editors in `ui/profile/ProfileSections.kt`. The quiz (`domain/DecideQuiz`) narrows by meal type + time, scores cravings/mood/protein/pantry, and is fresh on every visit.

Shopping (Phase 5): Room tables `shopping_items` (one row per ingredient id, or `custom:<name>` for free text; name/aisle snapshot) and `shopping_shares` (one row per source: recipe id + line position, or `""` for manual adds; cascades only to items). `ShoppingDao` holds the transactional ops (idempotent add, remove a recipe's share + orphan cleanup, Done shopping → pantry, clear) and each returns a `ShoppingSnapshot` for undo. `domain/ShoppingQuantities` merges amounts (mass and volume convert; other units sum only with themselves; unparsed text is appended), and `domain/ShoppingList` groups rows by aisle in `STORE_WALK` order with a checked "basket" plus share text. You can add from recipe detail ("Add N missing", using the same `Pantry.owns` rule so staples are skipped, plus a per-ingredient toggle), from Pantry "Almost there" cards, or by hand on the Shopping tab. The tab badge (`AppViewModel.shoppingToBuyCount`) counts unchecked items. The "For these recipes" strip goes through `ProfileGate`; items themselves are never hidden. No servings scaling yet (Phase 7).

Smart search (Phase 6a), in `domain/search/`: `QueryParser` (built once per catalog) turns text into a `SearchQuery` using the fixed `SearchLexicon` (flavors, textures, moods, meal types, diets, proteins, allergens, time, difficulty, "with what I have", negators like "no"/"without"/"-free") plus catalog cuisines and an ingredient index. Phrases match longest-first, and fixed entries beat cuisines, which beat ingredients. Ingredient words cover their head-noun family ("mushroom" → shiitake mushrooms, but "rice" ≠ rice vinegar). Unknown words become full-text terms. `SmartSearch.search` treats meal type, cuisine, diet, time, difficulty, exclusions and pantry as hard filters, and scores wants: a result must match at least one want, and results split into best (all wants) and close matches. Full text is the Room FTS4 table `recipe_fts` (Porter, prefix queries; title, cuisine, ingredient names + raw wording). It's derived data: `CatalogDao.rebuildSearchIndex()` runs inside `replaceCatalog`, and `SeedImporter` rebuilds it when its count drifts from `recipes`. `SearchRepository` sanitizes FTS input and keeps recent searches in DataStore. `SearchViewModel` applies `ProfileGate` last. Vectors (6b) must stay on-device (local-only), not pgvector.

Polish (Phase 7):
- **Servings scaling:** `domain/RecipeScaling` multiplies parsed amounts, keeps the recipe's own wording (it swaps only the leading number and re-pluralizes known unit words), and leaves unparsed lines ("To taste") alone. Recipe detail has a `ServingsStepper`; the choice lives in `RecipeDetailViewModel`'s `SavedStateHandle`. Adding to the shopping list passes `servings`, so shares store scaled amounts. Re-adding stays idempotent and keeps the first amount.
- **Cook mode** (`ui/cook`, `CookModeRoute(recipeId, servings)`): full-screen pager, one step per page plus a "done" page. `domain/cook/StepTimers` finds durations in the step text (digits, ½, number words, ranges use the lower bound, "1 hour 30 minutes"). `domain/cook/CookTimer` is immutable and runs on `elapsedRealtime`; it is saved as JSON in `SavedStateHandle`. `CookModeViewModel` ticks every 250ms only while a timer runs, rings each timer once through `TimerAlarm` (looping alarm sound + vibration, stops after 60s, on dismiss/+1 min, or on exit), keeps the screen on, and confirms before you leave with timers running. Timers live only as long as cook mode does; there's no notification or foreground service yet. The ingredient checklist is a bottom sheet on phones and a side panel at ≥720dp.
- **Recipe photos (opt-in):** the seed ships TheMealDB thumbnail URLs (`imageUrl`, dataset v3), but nothing is fetched unless the user asks. `data/photos/`: `PhotoRepository` enqueues `PhotoDownloadWorker` (WorkManager, unique work `recipe-photo-pack`, UNMETERED unless "Use mobile data" is on). The worker downloads every missing `<url>/medium` (~37 KB, ~29 MB total) into `files/recipe_photos/<id>.jpg` through `PhotoStore` (temp file + rename, resumable, 4 at a time). Failures end the run as FAILED with a count, and "Try again" fetches only the missing ones. The photos are excluded from cloud backup. The UI has a one-time Via prompt on Home (only when the spice prompt isn't showing) and a "Recipe photos" section in Profile (download / cancel / remove, mobile-data switch). Cards and the detail hero read `LocalRecipePhotos` (provided at the root from `AppViewModel`) and draw `RecipePhotoOrArt`, so recipes without a photo keep the `RecipeArt` doodle.
- **Offline / errors:** INTERNET is used only for the photo pack; everything else is bundled. `SeedImporter.status` (`CatalogStatus`) records import failures, and repositories call `ensureSeededSafely()` (which never throws). `CraveWiseAppRoot` swaps in a full-screen "Try again" error when it fails. "View original" ignores a missing browser.
- **Cookbook browse:** with no filter, `BrowseScreen` shows shelves (a quick shelf + one per meal type, 10 picks rotated daily) instead of the whole catalog A–Z. "See all" filters in place, and Back returns to the shelves. Filtered grids have a sticky count bar (Filters jumps back to the chips) and an end-of-list note.
- **Placeholder art:** `RecipeArt` (design system) + `RecipeSummary.artIcon` (title keywords → dish icon, then meal type), seeded by recipe id.
- **Tablet:** `NavigationSuiteScaffold` gives a bottom bar on phones and a rail on wider windows, and hides itself while cook mode is on top. `ListDetailSceneStrategy` (`adaptive-navigation3`) puts Pantry/Search/Browse/Favorites (list) beside RecipeDetail (detail), with a placeholder pane; at that width the detail screen drops its back arrow (`showBackButton`). Browse and Favorites use `GridCells.Adaptive(CraveLayout.CardMinWidth)`. Recipe detail and cook mode split into two columns at `CraveLayout.TwoColumnWidth`. Single-column screens use `Modifier.readableWidth()`.

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

## Release APK

- `.\gradlew.bat :app:assembleRelease` gives `app/build/outputs/apk/release/app-release.apk` (R8 on, about 4 MB). Distribution is APK only for now (no AAB/Play).
- Signing reads `keystore.properties` in the repo root (gitignored, along with `*.jks`). It points at the upload key outside the repo (`%USERPROFILE%\.android-keys\cravewise-upload.jks`, alias `cravewise`). Without the file, release builds come out unsigned. Losing the key means installed apps can't be updated, so it must be backed up.
- Debug and release builds use different keys, so switching between them on a device needs an uninstall (which wipes app data).
- `buildConfig = true`: `BuildConfig.DEBUG` hides the design-system catalog entry in release, and `VERSION_NAME` shows in Profile > About. Bump `versionCode`/`versionName` for every APK you hand out.
- Launcher icon and Android 12+ splash are Via on saffron (`mipmap-*/ic_launcher_*.webp`, adaptive with a monochrome layer). The window background matches the Compose canvas (`values*/colors.xml`), so launch doesn't flash white.

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
- **To add a screen:** add a route in `Routes.kt`, then add an `entry<...>` in `CraveWiseAppRoot.kt`. A new recipe list should get `metadata = listPane` so it pairs with the detail pane on tablets.
- The outer container is `NavigationSuiteScaffold`, not `Scaffold`. Full-screen routes hide it through `navSuiteState` (see `isNavVisible`).

**Insets / edge-to-edge:**
- `MainActivity` calls `enableEdgeToEdge()`.
- `NavigationSuiteScaffold` consumes the bar/rail insets for `NavDisplay`.
- Each screen owns its own inner `Scaffold` + `TopAppBar`, which handles the status-bar inset.

**Theme / design system:** "Noodle Pop". Tokens live in `ui/theme/` (fixed brand palette, no dynamic color on purpose); reusable components and the catalog live in `ui/designsystem/`. The mascot is Via the panda. XML themes are window-only (`android:Theme.Material.*.NoActionBar`, plus window background and v31 splash); all styling happens in Compose. Via is one flat-sticker character everywhere: the avatar (`via_avatar`) or a `ViaPose` (hello/thinking/shopping/celebrate), all in `ui/designsystem/ViaComponents.kt`. Home opens with `ViaHero` (about 30% of the window; Via's bubble shows the spice nudge, the one-time photo ask, or a daily tip from `home/HomeTips.kt`). Follow the rules in the design doc below: theme tokens only, `@CravePreviews` on every component, and every new component added to the catalog.

@docs/DESIGN.md

## Seed pipeline (`tools/seedgen/`)

Offline Python 3.10+ (stdlib only) tool that builds the catalog from TheMealDB + USDA FDC and writes `app/src/main/assets/seed/dataset.json` + `manifest.json`. The app never fetches anything.

```
python tools/seedgen/build.py                    # full build: fetch (cached) → normalize → rules → AI + overrides → nutrition → validate → assets
python tools/seedgen/build.py --allow-unreviewed # LOCAL TEST ONLY: ships unreviewed ingredients, flags the manifest (SeedAssetTest fails on it)
python tools/seedgen/build.py ingredients        # propose entries for new raw ingredient strings + curation/ingredients.review.md
python tools/seedgen/build.py tags               # rules + AI + overrides; queues out/ai-todo/batch-NNN.md for gaps
python tools/seedgen/build.py review             # out/review-top50.md, out/audit.md, out/provenance.json
python tools/seedgen/build.py nutrition          # FDC matching → curation/nutrition.json + nutrition.review.md
python tools/seedgen/build.py fdc "query"        # search FDC descriptions (for hand pins)
python tools/seedgen/build.py show 52772         # a meal as the pipeline sees it
python -m unittest discover -s tools/seedgen/tests
```

Layout:
- `raw/mealdb/`: cached API responses (committed; `fetch --refresh` re-downloads).
- `raw/fdc/`: the SR Legacy CSV zip and `sr_index.json` (gitignored; download URL in `seedgen/nutrition.py`).
- `curation/`: **hand-edited inputs**:
  - `ingredients.json`: canonical ids, synonyms, aisle, allergens, contains, protein, staple, `reviewed`.
  - `overrides.json`: per-recipe tag fixes, `remapLines`, `extraIngredients`.
  - `nutrition_pins.json` and `portions.json`.
  - `cuisines.json`, `exclude.json`, `top50.json`.
  - `nutrition.json` and the `*.review.md` files are generated.
- `tags/ai/batch-NNN.json`: cached AI tag answers (Claude Code answers the `out/ai-todo` batches; committed, never redone).
- `out/`: generated reports and `provenance.json`. Provenance holds each field's source and the TheMealDB thumbnail URLs. None of it goes into the app.
- `seedgen/`: one module per phase. `pipeline.tag_all` is the shared loader, `pipeline.nutrition_for` computes grams/nutrition, and `dataset.py` handles assembly, the schema mirror of `SeedModels.kt`, the validator and the manifest.

Rules:
- **Tag precedence, per field:** override > confident rule (≥0.7) > AI > weak rule. Vocabulary comes from `Vocabulary.kt` (parsed by `seedgen/vocab.py`), so the two can't drift.
- **Safety:** allergens, diets and proteins are never tagged. The app derives them on import from the ingredient table (`DietRules`), and `diet.py` is only a preview copy for review sheets.
- **`remapLines`** (`[{rawName, rawMeasure, ingredientId}]`) points one source line at a different ingredient when the shared synonym is wrong for that recipe (e.g. "Pepper" meaning bell pepper). It must match exactly one line. **`extraIngredients`** (`[{ingredientId, rawMeasure}]`) adds a line TheMealDB forgot. It counts for allergens like any other line. Bad entries fail the build.
- **Allergen gate:** a new ingredient is proposed with `reviewed: false`. Check its aisle, allergens and contains in `ingredients.json`, then set `reviewed: true`. The build refuses any used ingredient that isn't reviewed. (The `reviewed` flags in `overrides.json` only track the top-50 tag review and are not a gate.)
- **Review workflow:** `ingredients` → review ingredients → `tags` → answer AI batches → `review` → fix tags in `overrides.json` → `nutrition` → pin doubtful matches → `build`.
- **Validation fails the build** and lists every problem: unknown/unmapped ingredient ids, vocabulary violations, flavor outside 0–5, missing or negative times, duplicate ids, synonym clashes, unreviewed ingredients, `tag_all` errors, and output that doesn't match `SeedModels`. If anything fails, nothing is written.
- **Output is deterministic:** sorted keys, ids, sets and synonyms, and no timestamps. A rerun with no input changes gives the same bytes. `.gitattributes` keeps the seed JSON free of CRLF conversion because the manifest stores its sha256.
- **Shipping a change:** installed apps only re-seed when the version changes. Bump `DATASET_VERSION` in `seedgen/dataset.py`; the build prints a note when the content changed at the same version. Recipes ship their TheMealDB thumbnail URL as `imageUrl`; the app only downloads it if the user opts into the photo pack.

## Product decisions (agreed with the user)

- **Local-only, no accounts.** Recipe data is the app's own curated dataset, maintained as JSON and shipped as a pre-filled Room database. No backend for now. The one network use is the opt-in recipe photo pack (user-triggered, Wi-Fi only by default); the app works fully without it. Audience is 10–20 testers; Supabase can come later, at publish time.
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
  6. Smart search (6a lexicon + FTS done; 6b on-device vectors; optional LLM parsing)
  7. Polish (done: cook mode, timers, servings scaling, offline/error states, tablet layout)
- **Before public release:** TheMealDB-derived content (recipes **and** photos) is acceptable for testers but must be replaced or rewritten.

- Never add Claude as co-author in commits or PRs” in CLAUDE.md.
