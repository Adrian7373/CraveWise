package com.example.cravewise.data.local

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cravewise.data.repository.OfflineFavoritesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoritesDaoTest {

    private lateinit var db: CraveDatabase

    @Before fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, CraveDatabase::class.java).build()
    }

    @After fun tearDown() = db.close()

    @Test fun newestFirstAndRemovable() = runBlocking {
        val dao = db.favoritesDao()
        dao.insert(FavoriteEntity("a", addedAtEpochMs = 1))
        dao.insert(FavoriteEntity("b", addedAtEpochMs = 2))
        assertEquals(listOf("b", "a"), dao.observeFavoriteIds().first())

        OfflineFavoritesRepository(dao).setFavorite("b", favorite = false)
        assertEquals(listOf("a"), dao.observeFavoriteIds().first())
    }

    @Test fun reFavoritingKeepsOriginalTimestamp() = runBlocking {
        val dao = db.favoritesDao()
        dao.insert(FavoriteEntity("a", addedAtEpochMs = 1))
        dao.insert(FavoriteEntity("b", addedAtEpochMs = 2))
        dao.insert(FavoriteEntity("a", addedAtEpochMs = 3))
        assertEquals(listOf("b", "a"), dao.observeFavoriteIds().first())
    }

    @Test fun catalogReseedKeepsFavorites() = runBlocking {
        db.favoritesDao().insert(FavoriteEntity("r1", addedAtEpochMs = 1))
        db.catalogDao().replaceCatalog(
            recipes = emptyList(), ingredients = emptyList(), synonyms = emptyList(),
            lines = emptyList(), tags = emptyList(),
            meta = DatasetMetaEntity(version = 2, importedAtEpochMs = 0),
        )
        assertEquals(listOf("r1"), db.favoritesDao().observeFavoriteIds().first())
    }
}
