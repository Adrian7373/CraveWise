package com.example.cravewise.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.cravewise.data.local.CatalogDao
import com.example.cravewise.data.local.CraveDatabase
import com.example.cravewise.data.local.FavoritesDao
import com.example.cravewise.data.local.PantryDao
import com.example.cravewise.data.local.ProfileDao
import com.example.cravewise.data.repository.FavoritesRepository
import com.example.cravewise.data.repository.OfflineFavoritesRepository
import com.example.cravewise.data.repository.OfflinePantryRepository
import com.example.cravewise.data.repository.OfflineProfileRepository
import com.example.cravewise.data.repository.OfflineRecipeRepository
import com.example.cravewise.data.repository.PantryRepository
import com.example.cravewise.data.repository.ProfileRepository
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.data.seed.AssetSeedFileReader
import com.example.cravewise.data.seed.SeedFileReader
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CraveDatabase =
        Room.databaseBuilder(context, CraveDatabase::class.java, CraveDatabase.NAME).build()

    @Provides
    fun provideCatalogDao(db: CraveDatabase): CatalogDao = db.catalogDao()

    @Provides
    fun provideFavoritesDao(db: CraveDatabase): FavoritesDao = db.favoritesDao()

    @Provides
    fun providePantryDao(db: CraveDatabase): PantryDao = db.pantryDao()

    @Provides
    fun provideProfileDao(db: CraveDatabase): ProfileDao = db.profileDao()

    /** Small user settings. Lists and anything joined against the catalog live in Room. */
    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create { context.preferencesDataStoreFile("user_prefs") }

    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSeedFileReader(impl: AssetSeedFileReader): SeedFileReader

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(impl: OfflineRecipeRepository): RecipeRepository

    @Binds
    @Singleton
    abstract fun bindFavoritesRepository(impl: OfflineFavoritesRepository): FavoritesRepository

    @Binds
    @Singleton
    abstract fun bindPantryRepository(impl: OfflinePantryRepository): PantryRepository

    @Binds
    @Singleton
    abstract fun bindProfileRepository(impl: OfflineProfileRepository): ProfileRepository
}
