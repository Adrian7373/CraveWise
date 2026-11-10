package com.example.cravewise.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        RecipeEntity::class,
        IngredientEntity::class,
        IngredientSynonymEntity::class,
        RecipeIngredientEntity::class,
        RecipeTagEntity::class,
        DatasetMetaEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class CraveDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao

    companion object {
        const val NAME = "cravewise.db"
    }
}
