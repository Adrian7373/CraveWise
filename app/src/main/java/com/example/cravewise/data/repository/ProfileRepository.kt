package com.example.cravewise.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.example.cravewise.data.local.HatedIngredientEntity
import com.example.cravewise.data.local.ProfileDao
import com.example.cravewise.data.seed.fromSerialName
import com.example.cravewise.data.seed.serialNameOf
import com.example.cravewise.domain.ProfileGate
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.Diet
import com.example.cravewise.domain.model.FoodProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.serialization.KSerializer
import javax.inject.Inject

interface ProfileRepository {
    fun observeProfile(): Flow<FoodProfile>

    /** Hated ingredient ids, newest first (for display order). May hold stale ids. */
    fun observeHatedIngredientIds(): Flow<List<String>>

    /** False until onboarding is finished or skipped. */
    fun observeOnboardingComplete(): Flow<Boolean>

    suspend fun setAllergen(allergen: Allergen, avoid: Boolean)

    suspend fun setDiet(diet: Diet, follow: Boolean)

    suspend fun addHatedIngredient(ingredientId: String)

    suspend fun removeHatedIngredient(ingredientId: String)

    /** 0..[FoodProfile.MAX_SPICE]; [FoodProfile.MAX_SPICE] = any heat. */
    suspend fun setMaxSpice(level: Int)

    suspend fun setOnboardingComplete()
}

/**
 * Allergens, diets, spice and the onboarding flag are small settings in DataStore (`user_prefs`).
 * Hated ingredients are a list keyed by catalog ids, so they live in Room like the pantry.
 */
class OfflineProfileRepository @Inject constructor(
    private val dao: ProfileDao,
    private val preferences: DataStore<Preferences>,
) : ProfileRepository {

    override fun observeHatedIngredientIds(): Flow<List<String>> = dao.observeHatedIngredientIds()

    override fun observeProfile(): Flow<FoodProfile> = combine(
        preferences.data.map { prefs ->
            Triple(
                prefs[ALLERGENS].orEmpty().decode(Allergen.serializer(), Allergen.entries),
                prefs[DIETS].orEmpty().decode(Diet.serializer(), Diet.entries),
                prefs[MAX_SPICE],
            )
        }.distinctUntilChanged(),
        dao.observeHatedIngredientIds(),
    ) { (allergens, diets, maxSpice), hated ->
        FoodProfile(
            allergens = allergens,
            diets = diets,
            hatedIngredientIds = hated.toSet(),
            maxSpice = maxSpice?.coerceIn(0, FoodProfile.MAX_SPICE),
        )
    }

    override fun observeOnboardingComplete(): Flow<Boolean> =
        preferences.data.map { it[ONBOARDING_COMPLETE] ?: false }.distinctUntilChanged()

    override suspend fun setAllergen(allergen: Allergen, avoid: Boolean) =
        toggle(ALLERGENS, Allergen.serializer().serialNameOf(allergen), avoid)

    override suspend fun setDiet(diet: Diet, follow: Boolean) =
        toggle(DIETS, Diet.serializer().serialNameOf(diet), follow)

    override suspend fun addHatedIngredient(ingredientId: String) =
        dao.insertHated(HatedIngredientEntity(ingredientId, System.currentTimeMillis()))

    override suspend fun removeHatedIngredient(ingredientId: String) = dao.deleteHated(ingredientId)

    override suspend fun setMaxSpice(level: Int) {
        preferences.edit { it[MAX_SPICE] = level.coerceIn(0, FoodProfile.MAX_SPICE) }
    }

    override suspend fun setOnboardingComplete() {
        preferences.edit { it[ONBOARDING_COMPLETE] = true }
    }

    private suspend fun toggle(key: Preferences.Key<Set<String>>, value: String, on: Boolean) {
        preferences.edit { prefs ->
            val current = prefs[key].orEmpty()
            prefs[key] = if (on) current + value else current - value
        }
    }

    private fun <T : Enum<T>> Set<String>.decode(serializer: KSerializer<T>, entries: List<T>): Set<T> =
        mapNotNullTo(mutableSetOf()) { serializer.fromSerialName(it, entries) }

    private companion object {
        val ALLERGENS = stringSetPreferencesKey("profile_allergens")
        val DIETS = stringSetPreferencesKey("profile_diets")
        val MAX_SPICE = intPreferencesKey("profile_max_spice")
        val ONBOARDING_COMPLETE = booleanPreferencesKey("onboarding_complete")
    }
}

/** Combines the profile with recipe → ingredient ids so view models can gate any recipe list. */
class ProfileGateSource @Inject constructor(
    private val recipes: RecipeRepository,
    private val profiles: ProfileRepository,
) {
    fun observe(): Flow<ProfileGate> =
        combine(profiles.observeProfile(), recipes.observeRecipeIngredientIds(), ::ProfileGate)
}
