package com.example.cravewise.data.local

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * v6 → v7 adds nullable nutrition columns. User tables (favorites, pantry, hated, shopping) must
 * come through untouched, and existing catalog rows get nulls until the next re-seed fills them.
 */
@RunWith(AndroidJUnit4::class)
class MigrationTest {

    @get:Rule
    val helper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        CraveDatabase::class.java,
    )

    @Test fun migrate6To7KeepsUserDataAndAddsNullableNutrition() {
        helper.createDatabase(DB, 6).use { db ->
            db.execSQL("INSERT INTO favorites (recipeId, addedAtEpochMs) VALUES ('mdb-52772', 1)")
            db.execSQL("INSERT INTO pantry_items (ingredientId, addedAtEpochMs) VALUES ('rice', 2)")
            db.execSQL("INSERT INTO hated_ingredients (ingredientId, addedAtEpochMs) VALUES ('olive', 3)")
            db.execSQL(
                "INSERT INTO shopping_items (itemKey, ingredientId, name, aisle, checked, addedAtEpochMs, checkedAtEpochMs) " +
                    "VALUES ('egg', 'egg', 'Egg', 'DairyEggs', 0, 4, NULL)",
            )
            db.execSQL(
                "INSERT INTO shopping_shares (itemKey, recipeId, position, amount, amountMax, unit, rawMeasure, addedAtEpochMs) " +
                    "VALUES ('egg', 'mdb-52772', 0, 2.0, NULL, NULL, '2', 4)",
            )
            db.execSQL(
                "INSERT INTO ingredients (id, name, aisle, allergens, contains, protein, isPantryStaple) " +
                    "VALUES ('egg', 'Egg', 'DairyEggs', '[\"eggs\"]', '[]', 'Egg', 0)",
            )
        }

        helper.runMigrationsAndValidate(DB, 7, true).use { db ->
            assertEquals(1, db.count("favorites"))
            assertEquals(1, db.count("pantry_items"))
            assertEquals(1, db.count("hated_ingredients"))
            assertEquals(1, db.count("shopping_items"))
            assertEquals(1, db.count("shopping_shares"))
            db.query("SELECT name, per100g_kcal, per100g_fdcId FROM ingredients WHERE id = 'egg'").use { c ->
                assertTrue(c.moveToFirst())
                assertEquals("Egg", c.getString(0))
                assertTrue(c.isNull(1))
                assertTrue(c.isNull(2))
            }
        }
    }

    private fun SupportSQLiteDatabase.count(table: String): Int =
        query("SELECT COUNT(*) FROM $table").use { it.moveToFirst(); it.getInt(0) }

    private companion object {
        const val DB = "migration-test.db"
    }
}
