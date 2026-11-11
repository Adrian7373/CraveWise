package com.example.cravewise.data.local

import androidx.room.AutoMigration
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
        FavoriteEntity::class,
        PantryItemEntity::class,
        HatedIngredientEntity::class,
        ShoppingItemEntity::class,
        ShoppingShareEntity::class,
        RecipeFtsEntity::class,
    ],
    version = 6,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2), // + favorites
        AutoMigration(from = 2, to = 3), // + pantry_items
        AutoMigration(from = 3, to = 4), // + hated_ingredients
        AutoMigration(from = 4, to = 5), // + shopping_items, shopping_shares
        AutoMigration(from = 5, to = 6), // + recipe_fts (filled by SeedImporter)
    ],
)
@TypeConverters(Converters::class)
abstract class CraveDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
    abstract fun favoritesDao(): FavoritesDao
    abstract fun pantryDao(): PantryDao
    abstract fun profileDao(): ProfileDao
    abstract fun shoppingDao(): ShoppingDao

    companion object {
        const val NAME = "cravewise.db"
    }
}
