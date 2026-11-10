package com.example.cravewise.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PantryDao {

    /** Pantry ingredient ids, newest first. May include ids no longer in the catalog. */
    @Query("SELECT ingredientId FROM pantry_items ORDER BY addedAtEpochMs DESC, ingredientId")
    fun observeIngredientIds(): Flow<List<String>>

    /** Keeps the original timestamp if the ingredient is already in the pantry. */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: PantryItemEntity)

    @Query("DELETE FROM pantry_items WHERE ingredientId = :ingredientId")
    suspend fun delete(ingredientId: String)

    @Query("DELETE FROM pantry_items")
    suspend fun clear()
}
