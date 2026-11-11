package com.example.cravewise.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.cravewise.data.local.CatalogDao
import com.example.cravewise.data.seed.SeedImporter
import com.example.cravewise.domain.search.TextHits
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import javax.inject.Inject

interface SearchRepository {
    /** Full-text hits per term (prefix match, stemmed). Terms with nothing searchable map to no hits. */
    suspend fun textHits(terms: Collection<String>): Map<String, TextHits>

    /** Recent queries, newest first, at most [MAX_RECENT]. */
    fun observeRecentSearches(): Flow<List<String>>

    suspend fun addRecentSearch(query: String)

    suspend fun clearRecentSearches()

    companion object {
        const val MAX_RECENT = 6
    }
}

/** Room FTS4 for text, DataStore (`user_prefs`) for recent searches. */
class OfflineSearchRepository @Inject constructor(
    private val dao: CatalogDao,
    private val seeder: SeedImporter,
    private val preferences: DataStore<Preferences>,
) : SearchRepository {

    override suspend fun textHits(terms: Collection<String>): Map<String, TextHits> {
        if (terms.isEmpty()) return emptyMap()
        seeder.ensureSeeded()
        return terms.associateWith { term ->
            val words = ftsWords(term)
            if (words.isEmpty()) return@associateWith TextHits()
            TextHits(
                inTitle = dao.searchRecipeIds(words.joinToString(" ") { "title:$it*" }).toSet(),
                anywhere = dao.searchRecipeIds(words.joinToString(" ") { "$it*" }).toSet(),
            )
        }
    }

    override fun observeRecentSearches(): Flow<List<String>> =
        preferences.data.map { prefs -> prefs[RECENT]?.let(::decode).orEmpty() }.distinctUntilChanged()

    override suspend fun addRecentSearch(query: String) {
        val q = query.trim().replace(WHITESPACE, " ")
        if (q.isEmpty()) return
        preferences.edit { prefs ->
            val current = prefs[RECENT]?.let(::decode).orEmpty()
            val next = (listOf(q) + current.filterNot { it.equals(q, ignoreCase = true) }).take(SearchRepository.MAX_RECENT)
            prefs[RECENT] = json.encodeToString(next)
        }
    }

    override suspend fun clearRecentSearches() {
        preferences.edit { it.remove(RECENT) }
    }

    private fun decode(text: String): List<String> = runCatching { json.decodeFromString<List<String>>(text) }.getOrDefault(emptyList())

    private companion object {
        val RECENT = stringPreferencesKey("search_recent")
        val WHITESPACE = Regex("\\s+")
        val NON_WORD = Regex("[^\\p{L}\\p{N}]+")
        val json = Json

        /**
         * Splits a term into FTS-safe words: letters and digits only, so user text can never
         * inject MATCH operators (quotes, `-`, `OR`, `NEAR`, column filters).
         */
        fun ftsWords(term: String): List<String> =
            term.lowercase().split(NON_WORD).filter { it.isNotEmpty() && it !in FTS_KEYWORDS }

        val FTS_KEYWORDS = setOf("and", "or", "not", "near")
    }
}
