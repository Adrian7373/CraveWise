package com.example.cravewise.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.cravewise.data.local.PantryDao
import com.example.cravewise.data.local.PantryItemEntity
import com.example.cravewise.domain.model.Pantry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface PantryRepository {
    /** Listed ingredient ids (newest first) + the "assume basics" setting. May hold stale ids. */
    fun observePantry(): Flow<Pantry>

    suspend fun add(ingredientId: String)

    suspend fun remove(ingredientId: String)

    suspend fun clear()

    suspend fun setAssumeStaples(assume: Boolean)
}

class OfflinePantryRepository @Inject constructor(
    private val dao: PantryDao,
    private val preferences: DataStore<Preferences>,
) : PantryRepository {

    override fun observePantry(): Flow<Pantry> = combine(
        dao.observeIngredientIds(),
        preferences.data.map { it[ASSUME_STAPLES] ?: true }.distinctUntilChanged(),
    ) { ids, assume -> Pantry(ingredientIds = ids, assumeStaples = assume) }

    override suspend fun add(ingredientId: String) =
        dao.insert(PantryItemEntity(ingredientId, System.currentTimeMillis()))

    override suspend fun remove(ingredientId: String) = dao.delete(ingredientId)

    override suspend fun clear() = dao.clear()

    override suspend fun setAssumeStaples(assume: Boolean) {
        preferences.edit { it[ASSUME_STAPLES] = assume }
    }

    private companion object {
        val ASSUME_STAPLES = booleanPreferencesKey("pantry_assume_staples")
    }
}
