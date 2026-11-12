package com.example.cravewise.data.repository

import com.example.cravewise.data.local.ShoppingDao
import com.example.cravewise.data.local.ShoppingItemEntity
import com.example.cravewise.data.local.ShoppingShareEntity
import com.example.cravewise.data.local.ShoppingSnapshot
import com.example.cravewise.domain.RecipeScaling
import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.ShoppingEntry
import com.example.cravewise.domain.model.ShoppingShare
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/** Handle for undoing a destructive shopping action. Opaque to the UI. */
class ShoppingUndo internal constructor(internal val snapshot: ShoppingSnapshot) {
    val isEmpty: Boolean get() = snapshot.items.isEmpty() && snapshot.shares.isEmpty()

    /** Ingredients newly added to My Kitchen ("Done shopping" only). */
    val pantryCount: Int get() = snapshot.addedToPantry.size
}

interface ShoppingRepository {
    /** Every item with its shares. May include ingredient ids no longer in the catalog. */
    fun observeEntries(): Flow<List<ShoppingEntry>>

    /** Unchecked items, for the tab badge. */
    fun observeToBuyCount(): Flow<Int>

    /** Ingredient ids this recipe has put on the list. */
    fun observeIngredientIdsForRecipe(recipeId: String): Flow<Set<String>>

    /** Recipes with anything on the list. */
    fun observeRecipeIds(): Flow<Set<String>>

    /**
     * Adds this recipe's lines for [ingredientIds], with amounts scaled to [servings] (null = the
     * recipe's own yield). Lines already added from this recipe are skipped, so adding a recipe twice
     * never doubles it (and keeps the amount it was first added with).
     */
    suspend fun addFromRecipe(recipeId: String, ingredientIds: Set<String>, servings: Int? = null)

    /** Takes back one recipe's share of one ingredient. */
    suspend fun removeFromRecipe(recipeId: String, ingredientId: String)

    suspend fun removeRecipe(recipeId: String): ShoppingUndo

    /** Manual add of a catalog ingredient (no amount). Unchecks it if it was in the basket. */
    suspend fun addIngredient(ingredient: Ingredient)

    /** Manual free-text item, filed under [Aisle.Other]. */
    suspend fun addCustom(name: String)

    suspend fun setChecked(key: String, checked: Boolean)

    suspend fun delete(key: String): ShoppingUndo

    /** Clears checked items and adds the catalog ones to My Kitchen. */
    suspend fun finishShopping(): ShoppingUndo

    suspend fun clear(): ShoppingUndo

    suspend fun undo(undo: ShoppingUndo)
}

class OfflineShoppingRepository @Inject constructor(
    private val dao: ShoppingDao,
    private val recipes: RecipeRepository,
) : ShoppingRepository {

    override fun observeEntries(): Flow<List<ShoppingEntry>> =
        combine(dao.observeItems(), dao.observeShares()) { items, shares ->
            val byItem = shares.groupBy { it.itemKey }
            items.map { item -> item.toDomain(byItem[item.itemKey].orEmpty()) }
        }

    override fun observeToBuyCount(): Flow<Int> = dao.observeToBuyCount()

    override fun observeIngredientIdsForRecipe(recipeId: String): Flow<Set<String>> =
        dao.observeKeysForRecipe(recipeId).map { it.toSet() }

    override fun observeRecipeIds(): Flow<Set<String>> = dao.observeRecipeIds().map { it.toSet() }

    override suspend fun addFromRecipe(recipeId: String, ingredientIds: Set<String>, servings: Int?) {
        if (ingredientIds.isEmpty()) return
        val recipe = recipes.observeRecipe(recipeId).first() ?: return
        val factor = servings?.let { RecipeScaling.factor(recipe.servings, it) } ?: 1.0
        val now = System.currentTimeMillis()
        val lines = recipe.ingredients.withIndex().filter { (_, line) -> line.ingredient.id in ingredientIds }
        val items = lines.map { (_, line) -> line.ingredient.toItem(now) }.distinctBy { it.itemKey }
        val shares = lines.map { (position, line) ->
            ShoppingShareEntity(
                itemKey = ShoppingEntry.keyFor(line.ingredient.id),
                recipeId = recipeId,
                position = position,
                amount = line.amount?.times(factor),
                amountMax = line.amountMax?.times(factor),
                unit = line.unit,
                rawMeasure = line.rawMeasure,
                addedAtEpochMs = now,
            )
        }
        dao.add(items, shares)
    }

    override suspend fun removeFromRecipe(recipeId: String, ingredientId: String) =
        dao.removeShare(recipeId, ShoppingEntry.keyFor(ingredientId))

    override suspend fun removeRecipe(recipeId: String) = ShoppingUndo(dao.removeRecipe(recipeId))

    override suspend fun addIngredient(ingredient: Ingredient) {
        val now = System.currentTimeMillis()
        val item = ingredient.toItem(now)
        dao.add(listOf(item), listOf(manualShare(item.itemKey, now)), uncheckAll = true)
    }

    override suspend fun addCustom(name: String) {
        val clean = name.trim().replace(Regex("\\s+"), " ")
        if (clean.isEmpty()) return
        val now = System.currentTimeMillis()
        val item = ShoppingItemEntity(
            itemKey = ShoppingEntry.customKeyFor(clean),
            ingredientId = null,
            name = clean.replaceFirstChar { it.titlecase() },
            aisle = Aisle.Other,
            checked = false,
            addedAtEpochMs = now,
            checkedAtEpochMs = null,
        )
        dao.add(listOf(item), listOf(manualShare(item.itemKey, now)), uncheckAll = true)
    }

    override suspend fun setChecked(key: String, checked: Boolean) =
        dao.setChecked(key, checked, if (checked) System.currentTimeMillis() else null)

    override suspend fun delete(key: String) = ShoppingUndo(dao.deleteItem(key))

    override suspend fun finishShopping() = ShoppingUndo(dao.finishShopping(System.currentTimeMillis()))

    override suspend fun clear() = ShoppingUndo(dao.clearAll())

    override suspend fun undo(undo: ShoppingUndo) = dao.restore(undo.snapshot)

    private fun manualShare(key: String, now: Long) = ShoppingShareEntity(
        itemKey = key, recipeId = ShoppingShareEntity.MANUAL, position = 0,
        amount = null, amountMax = null, unit = null, rawMeasure = "", addedAtEpochMs = now,
    )
}

private fun Ingredient.toItem(now: Long) = ShoppingItemEntity(
    itemKey = ShoppingEntry.keyFor(id),
    ingredientId = id,
    name = name,
    aisle = aisle,
    checked = false,
    addedAtEpochMs = now,
    checkedAtEpochMs = null,
)

private fun ShoppingItemEntity.toDomain(shares: List<ShoppingShareEntity>) = ShoppingEntry(
    key = itemKey,
    ingredientId = ingredientId,
    name = name,
    aisle = aisle,
    checked = checked,
    addedAtEpochMs = addedAtEpochMs,
    checkedAtEpochMs = checkedAtEpochMs,
    shares = shares.map {
        ShoppingShare(
            recipeId = it.recipeId.takeUnless { id -> id == ShoppingShareEntity.MANUAL },
            amount = it.amount,
            amountMax = it.amountMax,
            unit = it.unit,
            rawMeasure = it.rawMeasure,
        )
    },
)
