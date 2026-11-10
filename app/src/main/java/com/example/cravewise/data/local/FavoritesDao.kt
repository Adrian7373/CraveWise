package com.example.cravewise.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    /** Favorite recipe ids, newest first. May include ids no longer in the catalog. */
    @Query("SELECT recipeId FROM favorites ORDER BY addedAtEpochMs DESC")
    fun observeFavoriteIds(): Flow<List<String>>

    /** Keeps the original timestamp if the recipe is already a favorite. */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favorite: FavoriteEntity)

    @Query("DELETE FROM favorites WHERE recipeId = :recipeId")
    suspend fun delete(recipeId: String)
}
