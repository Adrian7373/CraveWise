package com.example.cravewise.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
 * User-owned tables. They reference catalog rows by stable string id only: no foreign keys and no
 * cascades into catalog tables, so a dataset re-seed (SeedImporter) never deletes user data. Rows
 * whose recipe disappears from the dataset are simply hidden by joins.
 */

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey val recipeId: String,
    val addedAtEpochMs: Long,
)
