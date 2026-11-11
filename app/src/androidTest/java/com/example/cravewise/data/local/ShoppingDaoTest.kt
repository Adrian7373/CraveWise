package com.example.cravewise.data.local

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cravewise.domain.model.Aisle
import com.example.cravewise.domain.model.MeasureUnit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShoppingDaoTest {

    private lateinit var db: CraveDatabase
    private val dao get() = db.shoppingDao()

    @Before fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, CraveDatabase::class.java).build()
    }

    @After fun tearDown() = db.close()

    private fun item(key: String, checked: Boolean = false) =
        ShoppingItemEntity(key, key, key, Aisle.Produce, checked, addedAtEpochMs = 1, checkedAtEpochMs = null)

    private fun share(key: String, recipe: String, position: Int = 0, amount: Double? = 1.0) =
        ShoppingShareEntity(key, recipe, position, amount, null, MeasureUnit.G, "", addedAtEpochMs = 1)

    @Test fun reAddingARecipeIsIdempotent() = runBlocking {
        dao.add(listOf(item("onion")), listOf(share("onion", "a")))
        dao.add(listOf(item("onion")), listOf(share("onion", "a")))
        assertEquals(1, dao.observeShares().first().size)
    }

    @Test fun removingARecipeKeepsItemsOthersNeed() = runBlocking {
        dao.add(listOf(item("onion"), item("beef")), listOf(share("onion", "a"), share("beef", "a")))
        dao.add(listOf(item("onion")), listOf(share("onion", "b")))
        val undo = dao.removeRecipe("a")
        assertEquals(listOf("onion"), dao.observeItems().first().map { it.itemKey })
        assertEquals(listOf("b"), dao.observeShares().first().map { it.recipeId })

        dao.restore(undo)
        assertEquals(setOf("onion", "beef"), dao.observeItems().first().map { it.itemKey }.toSet())
        assertEquals(3, dao.observeShares().first().size)
    }

    @Test fun newShareUnchecksAnItemButARepeatDoesNot() = runBlocking {
        dao.add(listOf(item("onion")), listOf(share("onion", "a")))
        dao.setChecked("onion", true, 5)
        dao.add(listOf(item("onion")), listOf(share("onion", "a")))
        assertTrue(dao.observeItems().first().single().checked)
        dao.add(listOf(item("onion")), listOf(share("onion", "b")))
        assertFalse(dao.observeItems().first().single().checked)
    }

    @Test fun finishShoppingStocksPantryAndUndoReverts() = runBlocking {
        db.pantryDao().insert(PantryItemEntity("rice", 1))
        dao.add(
            listOf(item("onion"), item("rice"), item("beef")),
            listOf(share("onion", "a"), share("rice", "a"), share("beef", "a")),
        )
        dao.setChecked("onion", true, 2)
        dao.setChecked("rice", true, 3)
        assertEquals(1, dao.observeToBuyCount().first())

        val undo = dao.finishShopping(10)
        assertEquals(listOf("beef"), dao.observeItems().first().map { it.itemKey })
        assertEquals(setOf("onion", "rice"), db.pantryDao().observeIngredientIds().first().toSet())
        assertEquals("only newly added ids are undoable", listOf("onion"), undo.addedToPantry)

        dao.restore(undo)
        assertEquals(3, dao.observeItems().first().size)
        assertEquals(listOf("rice"), db.pantryDao().observeIngredientIds().first())
    }

    @Test fun deleteItemCascadesSharesAndCatalogReseedKeepsList() = runBlocking {
        dao.add(listOf(item("onion"), item("beef")), listOf(share("onion", "a"), share("beef", "a")))
        dao.deleteItem("onion")
        assertEquals(listOf("beef"), dao.observeShares().first().map { it.itemKey })

        db.catalogDao().replaceCatalog(
            recipes = emptyList(), ingredients = emptyList(), synonyms = emptyList(),
            lines = emptyList(), tags = emptyList(),
            meta = DatasetMetaEntity(version = 2, importedAtEpochMs = 0),
        )
        assertEquals(listOf("beef"), dao.observeItems().first().map { it.itemKey })
    }
}
