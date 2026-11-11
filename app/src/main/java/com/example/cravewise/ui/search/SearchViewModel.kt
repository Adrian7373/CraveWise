package com.example.cravewise.ui.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.PantryRepository
import com.example.cravewise.data.repository.ProfileGateSource
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.data.repository.SearchRepository
import com.example.cravewise.domain.Cookbook
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.RecipeSummary
import com.example.cravewise.domain.search.QueryChip
import com.example.cravewise.domain.search.QueryParser
import com.example.cravewise.domain.search.SearchQuery
import com.example.cravewise.domain.search.SearchResult
import com.example.cravewise.domain.search.SearchResults
import com.example.cravewise.domain.search.SmartSearch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SearchUiState(
    val isLoading: Boolean = true,
    /** What's in the box right now (results may lag it by the debounce). */
    val query: String = "",
    /** How the last searched query was understood, for the "Looking for" row. */
    val chips: List<QueryChip> = emptyList(),
    val best: List<SearchResult> = emptyList(),
    val close: List<SearchResult> = emptyList(),
    /** The query has several wants, so results split into "Best" and "Close" matches. */
    val split: Boolean = false,
    val unmatchedTerms: List<String> = emptyList(),
    /** "With what I have" while the kitchen is empty. */
    val pantryEmpty: Boolean = false,
    /** Search found recipes but the profile hid all of them. */
    val hiddenByProfile: Boolean = false,
    val recent: List<String> = emptyList(),
) {
    val hasQuery: Boolean get() = query.isNotBlank()
    val hasResults: Boolean get() = best.isNotEmpty() || close.isNotEmpty()
}

/** Catalog inputs to search; changes only on a re-seed. */
private class SearchCatalog(
    val recipes: List<RecipeSummary>,
    val recipeIngredients: Map<String, List<String>>,
    ingredients: List<Ingredient>,
) {
    val ingredientsById: Map<String, Ingredient> = ingredients.associateBy { it.id }
    val parser = QueryParser(ingredients, Cookbook.cuisines(recipes).map { it.value })
}

private data class Ranked(val query: SearchQuery, val results: SearchResults)

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    recipes: RecipeRepository,
    pantry: PantryRepository,
    gateSource: ProfileGateSource,
    private val search: SearchRepository,
    private val savedState: SavedStateHandle,
) : ViewModel() {

    private val query = savedState.getStateFlow(KEY_QUERY, "")

    private val catalog: Flow<SearchCatalog> = combine(
        recipes.observeRecipeSummaries(),
        recipes.observeRecipeIngredientIds(),
        recipes.observeIngredients(),
        ::SearchCatalog,
    ).flowOn(Dispatchers.Default)

    /** Parse → full-text lookup → rank. Typing is debounced; clearing the box is instant. */
    private val ranked: Flow<Ranked> = combine(
        catalog,
        query.debounce { if (it.isBlank()) 0L else DEBOUNCE_MS }.distinctUntilChanged(),
        pantry.observePantry(),
        ::Triple,
    ).mapLatest { (c, q, p) ->
        val parsed = c.parser.parse(q)
        val hits = search.textHits(parsed.textTerms)
        Ranked(parsed, SmartSearch.search(parsed, c.recipes, c.recipeIngredients, c.ingredientsById, p, hits))
    }

    val uiState: StateFlow<SearchUiState> = combine(
        ranked,
        gateSource.observe(),
        query,
        search.observeRecentSearches(),
    ) { (parsed, results), gate, q, recent ->
        // Profile hard filters last, after ranking (safety rule).
        val best = gate.filter(results.best) { it.recipe }
        val close = gate.filter(results.close) { it.recipe }
        SearchUiState(
            isLoading = false,
            query = q,
            chips = parsed.chips,
            best = best,
            close = close,
            split = parsed.wants.size > 1,
            unmatchedTerms = results.unmatchedTerms,
            pantryEmpty = results.pantryEmpty,
            hiddenByProfile = best.isEmpty() && close.isEmpty() && !results.isEmpty,
            recent = recent,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), SearchUiState(query = query.value))

    fun onQueryChange(text: String) {
        savedState[KEY_QUERY] = text
    }

    /** Keyboard search key: remember the query. */
    fun submit() = saveRecent(query.value)

    /** Suggestion or recent chip: search it now and remember it. */
    fun searchFor(text: String) {
        savedState[KEY_QUERY] = text
        saveRecent(text)
    }

    /** Opening a result is a good sign the query was worth keeping. */
    fun onResultOpened() = saveRecent(query.value)

    fun clearQuery() {
        savedState[KEY_QUERY] = ""
    }

    fun clearRecent() {
        viewModelScope.launch { search.clearRecentSearches() }
    }

    private fun saveRecent(text: String) {
        if (text.isBlank()) return
        viewModelScope.launch { search.addRecentSearch(text) }
    }

    companion object {
        private const val KEY_QUERY = "query"
        private const val DEBOUNCE_MS = 150L

        /** Tappable examples on the empty screen; each one exercises a different part of the parser. */
        val SUGGESTIONS = listOf(
            "Something salty",
            "Creamy and quick",
            "Comfort food",
            "Spicy chicken",
            "Vegetarian dinner",
            "Sweet, no nuts",
            "What can I make with what I have?",
            "Fresh and light, under 20 min",
        )
    }
}
