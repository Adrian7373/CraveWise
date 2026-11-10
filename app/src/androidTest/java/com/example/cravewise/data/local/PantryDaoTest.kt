package com.example.cravewise.data.local

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PantryDaoTest {

    private lateinit var db: CraveDatabase

    @Before fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, CraveDatabase::class.java).build()
    }

    @After fun tearDown() = db.close()

    @Test fun newestFirstAndReAddKeepsTimestamp() = runBlocking {
        val dao = db.pantryDao()
        dao.insert(PantryItemEntity("rice", addedAtEpochMs = 1))
        dao.insert(PantryItemEntity("egg", addedAtEpochMs = 2))
        dao.insert(PantryItemEntity("rice", addedAtEpochMs = 3))
        assertEquals(listOf("egg", "rice"), dao.observeIngredientIds().first())
    }

    @Test fun removeAndClear() = runBlocking {
        val dao = db.pantryDao()
        dao.insert(PantryItemEntity("rice", addedAtEpochMs = 1))
        dao.insert(PantryItemEntity("egg", addedAtEpochMs = 2))
        dao.delete("egg")
        assertEquals(listOf("rice"), dao.observeIngredientIds().first())
        dao.clear()
        assertTrue(dao.observeIngredientIds().first().isEmpty())
    }

    @Test fun catalogReseedKeepsPantry() = runBlocking {
        db.pantryDao().insert(PantryItemEntity("rice", addedAtEpochMs = 1))
        db.catalogDao().replaceCatalog(
            recipes = emptyList(), ingredients = emptyList(), synonyms = emptyList(),
            lines = emptyList(), tags = emptyList(),
            meta = DatasetMetaEntity(version = 2, importedAtEpochMs = 0),
        )
        assertEquals(listOf("rice"), db.pantryDao().observeIngredientIds().first())
    }
}
