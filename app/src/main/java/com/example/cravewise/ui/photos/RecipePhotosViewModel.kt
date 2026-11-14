package com.example.cravewise.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.photos.PhotoRepository
import com.example.cravewise.data.photos.RecipePhotosState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Drives the photo pack prompt (Home) and the "Recipe photos" section (Profile). */
@HiltViewModel
class RecipePhotosViewModel @Inject constructor(
    private val photos: PhotoRepository,
) : ViewModel() {

    val state: StateFlow<RecipePhotosState> =
        photos.observe().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), RecipePhotosState(promptDismissed = true))

    fun download() {
        viewModelScope.launch { photos.download() }
    }

    fun cancel() = photos.cancel()

    fun removeAll() {
        viewModelScope.launch { photos.removeAll() }
    }

    fun setAllowMobileData(allow: Boolean) {
        viewModelScope.launch { photos.setAllowMobileData(allow) }
    }

    fun dismissPrompt() {
        viewModelScope.launch { photos.dismissPrompt() }
    }
}
