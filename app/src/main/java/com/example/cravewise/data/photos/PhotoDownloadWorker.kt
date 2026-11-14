package com.example.cravewise.data.photos

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.cravewise.data.local.CatalogDao
import com.example.cravewise.data.seed.SeedImporter
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.atomic.AtomicInteger

/**
 * Downloads the recipe photo pack: every recipe photo not already on disk, a few at a time. It's
 * resumable by design (finished photos are skipped), so a cancel, a lost Wi-Fi connection or a
 * killed process just picks up where it stopped. Ends in failure with [KEY_FAILED] when some photos
 * couldn't be fetched; the UI offers "Try again", which only fetches those.
 */
class PhotoDownloadWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface Deps {
        fun catalogDao(): CatalogDao
        fun photoStore(): PhotoStore
        fun seedImporter(): SeedImporter
    }

    override suspend fun doWork(): Result {
        val deps = EntryPointAccessors.fromApplication(applicationContext, Deps::class.java)
        val store = deps.photoStore()
        deps.seedImporter().ensureSeededSafely()
        val todo = deps.catalogDao().recipePhotoUrls().filterNot { store.has(it.id) }
        if (todo.isEmpty()) return Result.success()

        val done = AtomicInteger(0)
        val failed = AtomicInteger(0)
        val gate = Semaphore(PARALLEL)
        coroutineScope {
            todo.map { photo ->
                async(Dispatchers.IO) {
                    gate.withPermit {
                        ensureActive()
                        val ok = runCatching { fetch(photoUrl(photo.imageUrl)) { store.save(photo.id, it) } }.isSuccess ||
                            runCatching { fetch(photoUrl(photo.imageUrl)) { store.save(photo.id, it) } }.isSuccess
                        if (!ok) failed.incrementAndGet()
                        setProgress(workDataOf(KEY_DONE to done.incrementAndGet(), KEY_TOTAL to todo.size))
                    }
                }
            }.awaitAll()
        }
        return if (failed.get() == 0) Result.success() else Result.failure(workDataOf(KEY_FAILED to failed.get()))
    }

    private suspend fun fetch(url: String, onBody: (java.io.InputStream) -> Unit) = withContext(Dispatchers.IO) {
        val conn = URL(url).openConnection() as HttpURLConnection
        try {
            conn.connectTimeout = TIMEOUT_MS
            conn.readTimeout = TIMEOUT_MS
            if (conn.responseCode != HttpURLConnection.HTTP_OK) throw IOException("HTTP ${conn.responseCode} for $url")
            if (conn.contentType?.startsWith("image/") != true) throw IOException("Not an image: $url")
            conn.inputStream.use(onBody)
        } finally {
            conn.disconnect()
        }
    }

    companion object {
        const val KEY_DONE = "done"
        const val KEY_TOTAL = "total"
        const val KEY_FAILED = "failed"
        private const val PARALLEL = 4
        private const val TIMEOUT_MS = 15_000

        /**
         * TheMealDB serves size variants by suffix. `/medium` (~37 KB) is sharp enough for cards and
         * the detail hero; the original is ~130 KB and `/small` (250 px) looks soft on cards.
         */
        fun photoUrl(thumbUrl: String): String = "${thumbUrl.trimEnd('/')}/medium"
    }
}
