package com.example.cravewise.data.repository

import com.example.cravewise.data.local.FavoriteEntity
import com.example.cravewise.data.local.FavoritesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FavoritesRepository {
    /** Favorite recipe ids, newest first. Callers join against the catalog to drop stale ids. */
    fun observeFavoriteIds(): Flow<List<String>>

    suspend fun setFavorite(recipeId: String, favorite: Boolean)
}

class OfflineFavoritesRepository @Inject constructor(
    private val dao: FavoritesDao,
) : FavoritesRepository {

    override fun observeFavoriteIds(): Flow<List<String>> = dao.observeFavoriteIds()

    override suspend fun setFavorite(recipeId: String, favorite: Boolean) {
        if (favorite) {
            dao.insert(FavoriteEntity(recipeId, System.currentTimeMillis()))
        } else {
            dao.delete(recipeId)
        }
    }
}
