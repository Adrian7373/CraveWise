package com.example.cravewise.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.example.cravewise.data.local.PantryDao
import com.example.cravewise.data.local.PantryItemEntity
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.StapleGroup
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface PantryRepository {
    /** Listed ingredient ids (newest first) + the assumed staple groups. May hold stale ids. */
    fun observePantry(): Flow<Pantry>

    suspend fun add(ingredientId: String)

    suspend fun remove(ingredientId: String)

    suspend fun clear()

    /** Turns one staple group ("Spice rack", ...) on or off. */
    suspend fun setStapleGroup(group: StapleGroup, assumed: Boolean)
}

class OfflinePantryRepository @Inject constructor(
    private val dao: PantryDao,
    private val preferences: DataStore<Preferences>,
) : PantryRepository {

    override fun observePantry(): Flow<Pantry> = combine(
        dao.observeIngredientIds(),
        preferences.data.map(::assumedGroups).distinctUntilChanged(),
    ) { ids, groups -> Pantry(ingredientIds = ids, assumedStaples = groups) }

    override suspend fun add(ingredientId: String) =
        dao.insert(PantryItemEntity(ingredientId, System.currentTimeMillis()))

    override suspend fun remove(ingredientId: String) = dao.delete(ingredientId)

    override suspend fun clear() = dao.clear()

    override suspend fun setStapleGroup(group: StapleGroup, assumed: Boolean) {
        preferences.edit { prefs ->
            val current = assumedGroups(prefs)
            prefs[STAPLE_GROUPS] = (if (assumed) current + group else current - group).mapTo(HashSet()) { it.name }
        }
    }

    private companion object {
        /** Pre-groups single switch. Read only to seed [STAPLE_GROUPS] the first time. */
        val LEGACY_ASSUME_STAPLES = booleanPreferencesKey("pantry_assume_staples")
        val STAPLE_GROUPS = stringSetPreferencesKey("pantry_staple_groups")

        /** Saved groups; else none if the old switch was off; else [StapleGroup.DEFAULT]. */
        fun assumedGroups(prefs: Preferences): Set<StapleGroup> {
            prefs[STAPLE_GROUPS]?.let { names -> return StapleGroup.entries.filterTo(HashSet()) { it.name in names } }
            return if (prefs[LEGACY_ASSUME_STAPLES] == false) emptySet() else StapleGroup.DEFAULT
        }
    }
}
