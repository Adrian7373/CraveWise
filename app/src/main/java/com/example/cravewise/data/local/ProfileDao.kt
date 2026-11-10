package com.example.cravewise.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    /** Hated ingredient ids, newest first. May include ids no longer in the catalog. */
    @Query("SELECT ingredientId FROM hated_ingredients ORDER BY addedAtEpochMs DESC, ingredientId")
    fun observeHatedIngredientIds(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHated(item: HatedIngredientEntity)

    @Query("DELETE FROM hated_ingredients WHERE ingredientId = :ingredientId")
    suspend fun deleteHated(ingredientId: String)
}
