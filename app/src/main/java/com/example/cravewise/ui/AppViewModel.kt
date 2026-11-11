package com.example.cravewise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.ProfileRepository
import com.example.cravewise.data.repository.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/** App-level state that decides what the root shows. */
@HiltViewModel
class AppViewModel @Inject constructor(
    profiles: ProfileRepository,
    shopping: ShoppingRepository,
) : ViewModel() {

    /** Null while loading, so the app doesn't flash onboarding for returning users. */
    val onboardingComplete: StateFlow<Boolean?> =
        profiles.observeOnboardingComplete()
            .stateIn(viewModelScope, SharingStarted.Eagerly, null)

    /** Unchecked shopping items, for the Shopping tab badge. */
    val shoppingToBuyCount: StateFlow<Int> =
        shopping.observeToBuyCount()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)
}
