package com.example.cravewise.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.MeasureUnit

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

/** An ingredient the user says they have. Ids dropped from the dataset are ignored by matching. */
@Entity(tableName = "pantry_items")
data class PantryItemEntity(
    @PrimaryKey val ingredientId: String,
    val addedAtEpochMs: Long,
)

/** An ingredient the user never wants to see (profile hard filter). */
@Entity(tableName = "hated_ingredients")
data class HatedIngredientEntity(
    @PrimaryKey val ingredientId: String,
    val addedAtEpochMs: Long,
)

/**
 * A shopping list row. [itemKey] is the ingredient id for catalog items (so recipes merge into one
 * row) or `custom:<name>` for free text. [name]/[aisle] are snapshots, so the row survives an
 * ingredient being dropped from the dataset.
 */
@Entity(tableName = "shopping_items")
data class ShoppingItemEntity(
    @PrimaryKey val itemKey: String,
    val ingredientId: String?,
    val name: String,
    val aisle: Aisle,
    val checked: Boolean,
    val addedAtEpochMs: Long,
    val checkedAtEpochMs: Long?,
)

/**
 * One source's share of a shopping item: a recipe line ([recipeId] + its [position]) or a manual
 * add ([recipeId] = [MANUAL], position 0). Re-adding the same recipe line is a no-op, and removing
 * a recipe deletes only its own shares. Cascades only within the user-owned shopping tables.
 */
@Entity(
    tableName = "shopping_shares",
    primaryKeys = ["itemKey", "recipeId", "position"],
    foreignKeys = [
        ForeignKey(ShoppingItemEntity::class, ["itemKey"], ["itemKey"], onDelete = ForeignKey.CASCADE),
    ],
    indices = [Index("recipeId")],
)
data class ShoppingShareEntity(
    val itemKey: String,
    val recipeId: String,
    val position: Int,
    val amount: Double?,
    val amountMax: Double?,
    val unit: MeasureUnit?,
    val rawMeasure: String,
    val addedAtEpochMs: Long,
) {
    companion object {
        const val MANUAL = ""
    }
}
