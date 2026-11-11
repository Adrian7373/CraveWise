package com.example.cravewise.data.seed

import android.content.Context
import com.example.cravewise.data.local.CatalogDao
import com.example.cravewise.data.local.DatasetMetaEntity
import com.example.cravewise.data.local.IngredientEntity
import com.example.cravewise.data.local.IngredientSynonymEntity
import com.example.cravewise.data.local.RecipeEntity
import com.example.cravewise.data.local.RecipeIngredientEntity
import com.example.cravewise.data.local.RecipeTagEntity
import com.example.cravewise.data.local.TagType
import com.example.cravewise.di.IoDispatcher
import com.example.cravewise.domain.DietRules
import com.example.cravewise.domain.IngredientFacts
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.Texture
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

/** Reads bundled seed files. Abstracted so tests can feed JSON without assets. */
fun interface SeedFileReader {
    fun read(name: String): String
}

class AssetSeedFileReader @Inject constructor(
    @param:ApplicationContext private val context: Context,
) : SeedFileReader {
    override fun read(name: String): String =
        context.assets.open("$SEED_DIR/$name").bufferedReader().use { it.readText() }

    private companion object {
        const val SEED_DIR = "seed"
    }
}

/**
 * Keeps the Room catalog in step with the dataset bundled in the APK ("sync" for a local-only app).
 * On each launch it reads the tiny manifest; only when its version differs from what's stored does
 * it parse the full dataset and swap the catalog in one transaction. User data lives in other
 * tables and is untouched.
 */
@Singleton
class SeedImporter @Inject constructor(
    private val dao: CatalogDao,
    private val reader: SeedFileReader,
    @param:IoDispatcher private val io: CoroutineDispatcher,
) {
    private val mutex = Mutex()
    @Volatile private var upToDate = false

    /** Idempotent and cheap after the first call in a process. Returns true if it (re)seeded. */
    suspend fun ensureSeeded(): Boolean {
        if (upToDate) return false
        return mutex.withLock {
            if (upToDate) return@withLock false
            withContext(io) {
                val manifest = json.decodeFromString<SeedManifest>(reader.read(MANIFEST))
                val stored = dao.datasetMeta()?.version
                val needsSeed = stored != manifest.version || dao.recipeCount() == 0
                if (needsSeed) {
                    val dataset = json.decodeFromString<SeedDataset>(reader.read(manifest.file))
                    check(dataset.version == manifest.version) {
                        "manifest says v${manifest.version} but ${manifest.file} is v${dataset.version}"
                    }
                    import(dataset) // also rebuilds the search index
                } else if (dao.searchIndexCount() != dao.recipeCount()) {
                    // Search index is derived data: fill it after the v6 migration, or if it drifted.
                    dao.rebuildSearchIndex()
                }
                upToDate = true
                needsSeed
            }
        }
    }

    private suspend fun import(dataset: SeedDataset) {
        val catalog = SeedMapper.map(dataset)
        dao.replaceCatalog(
            recipes = catalog.recipes,
            ingredients = catalog.ingredients,
            synonyms = catalog.synonyms,
            lines = catalog.lines,
            tags = catalog.tags,
            meta = DatasetMetaEntity(version = dataset.version, importedAtEpochMs = System.currentTimeMillis()),
        )
    }

    private companion object {
        const val MANIFEST = "manifest.json"
        val json = Json { ignoreUnknownKeys = true }
    }
}

/** Entities for one dataset, ready to insert. */
data class CatalogRows(
    val recipes: List<RecipeEntity>,
    val ingredients: List<IngredientEntity>,
    val synonyms: List<IngredientSynonymEntity>,
    val lines: List<RecipeIngredientEntity>,
    val tags: List<RecipeTagEntity>,
)

/** Pure seed → entity mapping, including the safety-tag derivation. JVM-testable. */
object SeedMapper {

    fun normalize(name: String): String = name.trim().lowercase().replace(Regex("\\s+"), " ")

    fun map(dataset: SeedDataset): CatalogRows {
        val byId = dataset.ingredients.associateBy { it.id }
        require(byId.size == dataset.ingredients.size) { "duplicate ingredient ids in dataset" }

        val synonyms = dataset.ingredients.flatMap { ing ->
            (listOf(ing.name) + ing.synonyms).map(::normalize).distinct()
                .map { IngredientSynonymEntity(synonym = it, ingredientId = ing.id) }
        }
        synonyms.groupBy { it.synonym }.filterValues { it.size > 1 }.let { clashes ->
            require(clashes.isEmpty()) { "synonyms shared by several ingredients: ${clashes.keys}" }
        }

        val recipes = mutableListOf<RecipeEntity>()
        val lines = mutableListOf<RecipeIngredientEntity>()
        val tags = mutableListOf<RecipeTagEntity>()
        for (r in dataset.recipes) {
            val used = r.ingredients.map { line ->
                requireNotNull(byId[line.ingredientId]) { "${r.id}: unknown ingredient ${line.ingredientId}" }
            }
            val derived = DietRules.derive(used.map { IngredientFacts(it.allergens, it.contains, it.protein) })

            recipes += RecipeEntity(
                id = r.id, title = r.title, cuisine = r.cuisine, servings = r.servings,
                prepMinutes = r.prepMinutes, cookMinutes = r.cookMinutes, difficulty = r.difficulty,
                salty = r.flavor.salty, sweet = r.flavor.sweet, sour = r.flavor.sour,
                bitter = r.flavor.bitter, umami = r.flavor.umami, spicy = r.flavor.spicy,
                steps = r.steps, imageUrl = r.imageUrl, sourceName = r.source.name, sourceUrl = r.source.url,
            )
            r.ingredients.forEachIndexed { position, l ->
                lines += RecipeIngredientEntity(
                    recipeId = r.id, position = position, ingredientId = l.ingredientId,
                    rawName = l.rawName, rawMeasure = l.rawMeasure, amount = l.amount,
                    amountMax = l.amountMax, unit = l.unit, note = l.note,
                )
            }
            fun <T : Enum<T>> add(type: TagType, values: Set<T>, name: (T) -> String) =
                values.forEach { tags += RecipeTagEntity(r.id, type, name(it)) }
            add(TagType.MealType, r.mealTypes) { MealType.serializer().serialNameOf(it) }
            add(TagType.Texture, r.textures) { Texture.serializer().serialNameOf(it) }
            add(TagType.Mood, r.moods) { Mood.serializer().serialNameOf(it) }
            add(TagType.Allergen, derived.allergens) { Allergen.serializer().serialNameOf(it) }
            add(TagType.Diet, derived.diets) { Diet.serializer().serialNameOf(it) }
            add(TagType.Protein, derived.proteins) { Protein.serializer().serialNameOf(it) }
        }

        val ingredients = dataset.ingredients.map {
            IngredientEntity(
                id = it.id, name = it.name, aisle = it.aisle, allergens = it.allergens,
                contains = it.contains, protein = it.protein, isPantryStaple = it.isPantryStaple,
            )
        }
        return CatalogRows(recipes, ingredients, synonyms, lines, tags)
    }
}
