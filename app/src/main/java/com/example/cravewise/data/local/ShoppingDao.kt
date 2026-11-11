package com.example.cravewise.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

/** Rows removed by a destructive action, kept so it can be undone. */
data class ShoppingSnapshot(
    val items: List<ShoppingItemEntity> = emptyList(),
    val shares: List<ShoppingShareEntity> = emptyList(),
    /** Ingredient ids "Done shopping" newly put in the pantry (not ones already there). */
    val addedToPantry: List<String> = emptyList(),
)

@Dao
abstract class ShoppingDao {

    @Query("SELECT * FROM shopping_items")
    abstract fun observeItems(): Flow<List<ShoppingItemEntity>>

    @Query("SELECT * FROM shopping_shares ORDER BY addedAtEpochMs, recipeId, position")
    abstract fun observeShares(): Flow<List<ShoppingShareEntity>>

    @Query("SELECT COUNT(*) FROM shopping_items WHERE checked = 0")
    abstract fun observeToBuyCount(): Flow<Int>

    /** Ingredient ids (item keys) a recipe has put on the list. */
    @Query("SELECT DISTINCT itemKey FROM shopping_shares WHERE recipeId = :recipeId")
    abstract fun observeKeysForRecipe(recipeId: String): Flow<List<String>>

    @Query("SELECT DISTINCT recipeId FROM shopping_shares WHERE recipeId != ''")
    abstract fun observeRecipeIds(): Flow<List<String>>

    // --- building blocks --------------------------------------------------------------------

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract suspend fun insertItemsIfAbsent(items: List<ShoppingItemEntity>)

    /** Row ids; -1 where the share already existed. */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract suspend fun insertSharesIfAbsent(shares: List<ShoppingShareEntity>): List<Long>

    // Upsert (not REPLACE): REPLACE deletes the old row first, which would cascade to its shares.
    @Upsert
    protected abstract suspend fun upsertItems(items: List<ShoppingItemEntity>)

    @Upsert
    protected abstract suspend fun upsertShares(shares: List<ShoppingShareEntity>)

    @Query("UPDATE shopping_items SET checked = 0, checkedAtEpochMs = NULL WHERE itemKey IN (:keys)")
    protected abstract suspend fun uncheck(keys: List<String>)

    @Query("UPDATE shopping_items SET checked = :checked, checkedAtEpochMs = :atEpochMs WHERE itemKey = :key")
    abstract suspend fun setChecked(key: String, checked: Boolean, atEpochMs: Long?)

    @Query("SELECT * FROM shopping_items WHERE itemKey IN (:keys)")
    protected abstract suspend fun items(keys: List<String>): List<ShoppingItemEntity>

    @Query("SELECT * FROM shopping_items")
    protected abstract suspend fun allItems(): List<ShoppingItemEntity>

    @Query("SELECT * FROM shopping_items WHERE checked = 1")
    protected abstract suspend fun checkedItems(): List<ShoppingItemEntity>

    @Query("SELECT * FROM shopping_shares WHERE itemKey IN (:keys)")
    protected abstract suspend fun sharesOf(keys: List<String>): List<ShoppingShareEntity>

    @Query("SELECT * FROM shopping_shares WHERE recipeId = :recipeId")
    protected abstract suspend fun sharesForRecipe(recipeId: String): List<ShoppingShareEntity>

    @Query("SELECT * FROM shopping_shares")
    protected abstract suspend fun allShares(): List<ShoppingShareEntity>

    @Query("DELETE FROM shopping_shares WHERE recipeId = :recipeId")
    protected abstract suspend fun deleteSharesForRecipe(recipeId: String)

    @Query("DELETE FROM shopping_shares WHERE recipeId = :recipeId AND itemKey = :key")
    protected abstract suspend fun deleteShare(recipeId: String, key: String)

    /** Items left without any share (their last recipe was removed). */
    @Query("DELETE FROM shopping_items WHERE itemKey NOT IN (SELECT itemKey FROM shopping_shares)")
    protected abstract suspend fun deleteOrphanItems()

    @Query("DELETE FROM shopping_items WHERE itemKey IN (:keys)")
    protected abstract suspend fun deleteItems(keys: List<String>)

    @Query("DELETE FROM shopping_items")
    protected abstract suspend fun deleteAllItems()

    /** Row ids; -1 where the ingredient was already in the pantry. */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract suspend fun insertPantryItems(items: List<PantryItemEntity>): List<Long>

    @Query("DELETE FROM pantry_items WHERE ingredientId IN (:ids)")
    protected abstract suspend fun deletePantryItems(ids: List<String>)

    // --- operations -------------------------------------------------------------------------

    /**
     * Adds shares, creating their items if needed. Items that gain a new share are unchecked so
     * the extra amount shows up; with [uncheckAll] every touched item is (a deliberate manual add).
     */
    @Transaction
    open suspend fun add(items: List<ShoppingItemEntity>, shares: List<ShoppingShareEntity>, uncheckAll: Boolean = false) {
        if (shares.isEmpty()) return
        insertItemsIfAbsent(items)
        val ids = insertSharesIfAbsent(shares)
        val touched = if (uncheckAll) {
            shares.map { it.itemKey }
        } else {
            shares.filterIndexed { i, _ -> ids[i] != -1L }.map { it.itemKey }
        }.distinct()
        if (touched.isNotEmpty()) uncheck(touched)
    }

    /** Removes one recipe's share of one item; drops the item if nothing else needs it. */
    @Transaction
    open suspend fun removeShare(recipeId: String, key: String) {
        deleteShare(recipeId, key)
        deleteOrphanItems()
    }

    /** Removes everything a recipe added. Items other recipes (or you) still need stay. */
    @Transaction
    open suspend fun removeRecipe(recipeId: String): ShoppingSnapshot {
        val shares = sharesForRecipe(recipeId)
        val items = items(shares.map { it.itemKey }.distinct())
        deleteSharesForRecipe(recipeId)
        deleteOrphanItems()
        return ShoppingSnapshot(items, shares)
    }

    @Transaction
    open suspend fun deleteItem(key: String): ShoppingSnapshot {
        val snapshot = ShoppingSnapshot(items(listOf(key)), sharesOf(listOf(key)))
        deleteItems(listOf(key))
        return snapshot
    }

    /** Clears checked items; catalog ones go into the pantry. */
    @Transaction
    open suspend fun finishShopping(nowEpochMs: Long): ShoppingSnapshot {
        val checked = checkedItems()
        if (checked.isEmpty()) return ShoppingSnapshot()
        val keys = checked.map { it.itemKey }
        val shares = sharesOf(keys)
        val ingredientIds = checked.mapNotNull { it.ingredientId }.distinct()
        val rowIds = insertPantryItems(ingredientIds.map { PantryItemEntity(it, nowEpochMs) })
        val added = ingredientIds.filterIndexed { i, _ -> rowIds[i] != -1L }
        deleteItems(keys)
        return ShoppingSnapshot(checked, shares, added)
    }

    @Transaction
    open suspend fun clearAll(): ShoppingSnapshot {
        val snapshot = ShoppingSnapshot(allItems(), allShares())
        deleteAllItems()
        return snapshot
    }

    /** Puts back what a [ShoppingSnapshot] removed, including its pantry additions. */
    @Transaction
    open suspend fun restore(snapshot: ShoppingSnapshot) {
        upsertItems(snapshot.items)
        upsertShares(snapshot.shares)
        if (snapshot.addedToPantry.isNotEmpty()) deletePantryItems(snapshot.addedToPantry)
    }
}
