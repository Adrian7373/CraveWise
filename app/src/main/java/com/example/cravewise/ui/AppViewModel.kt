package com.example.cravewise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.ProfileRepository
import com.example.cravewise.data.repository.ShoppingRepository
import com.example.cravewise.data.seed.CatalogStatus
import com.example.cravewise.data.seed.SeedImporter
import com.example.cravewise.data.photos.PhotoStore
import com.example.cravewise.ui.recipe.RecipePhotoLookup
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/** App-level state that decides what the root shows. */
@HiltViewModel
class AppViewModel @Inject constructor(
    profiles: ProfileRepository,
    shopping: ShoppingRepository,
    private val seeder: SeedImporter,
    photoStore: PhotoStore,
) : ViewModel() {

    /** Downloaded recipe photos, provided to every screen through `LocalRecipePhotos`. */
    val recipePhotos: StateFlow<RecipePhotoLookup> =
        photoStore.downloaded
            .map { ids -> RecipePhotoLookup(ids, photoStore::fileFor) }
            .stateIn(viewModelScope, SharingStarted.Eagerly, RecipePhotoLookup(photoStore.downloaded.value, photoStore::fileFor))

    init {
        // Start the (usually no-op) catalog check right away so a failure shows up even before
        // any screen asks for recipes.
        viewModelScope.launch { seeder.ensureSeededSafely() }
    }

    /** Null while loading, so the app doesn't flash onboarding for returning users. */
    val onboardingComplete: StateFlow<Boolean?> =
        profiles.observeOnboardingComplete()
            .stateIn(viewModelScope, SharingStarted.Eagerly, null)

    /** Unchecked shopping items, for the Shopping tab badge. */
    val shoppingToBuyCount: StateFlow<Int> =
        shopping.observeToBuyCount()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    /** A failed import replaces the whole app with a retry screen (nothing works without recipes). */
    val catalogStatus: StateFlow<CatalogStatus> = seeder.status

    fun retryCatalog() {
        viewModelScope.launch { seeder.retry() }
    }
}
