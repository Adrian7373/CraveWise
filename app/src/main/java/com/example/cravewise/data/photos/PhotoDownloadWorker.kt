package com.example.cravewise.data.photos

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
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
import java.util.concurrent.atomic.AtomicBoolean
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
        if (!onAllowedNetwork()) return Result.retry()

        val done = AtomicInteger(0)
        val failed = AtomicInteger(0)
        val offWifi = AtomicBoolean(false)
        val gate = Semaphore(PARALLEL)
        coroutineScope {
            todo.map { photo ->
                async(Dispatchers.IO) {
                    gate.withPermit {
                        ensureActive()
                        // Wi-Fi dropped to mobile data mid-run: leave the rest for when it's back.
                        if (offWifi.get() || !onAllowedNetwork()) {
                            offWifi.set(true)
                            return@withPermit
                        }
                        val ok = runCatching { fetch(photoUrl(photo.imageUrl)) { store.save(photo.id, it) } }.isSuccess ||
                            runCatching { fetch(photoUrl(photo.imageUrl)) { store.save(photo.id, it) } }.isSuccess
                        if (!ok) failed.incrementAndGet()
                        setProgress(workDataOf(KEY_DONE to done.incrementAndGet(), KEY_TOTAL to todo.size))
                    }
                }
            }.awaitAll()
        }
        return when {
            failed.get() > 0 -> Result.failure(workDataOf(KEY_FAILED to failed.get()))
            offWifi.get() -> Result.retry()
            else -> Result.success()
        }
    }

    /**
     * The "Wi-Fi only" rule, checked here rather than with an UNMETERED constraint: Wi-Fi or
     * Ethernet always counts even when the system flags it as metered (hotspots, pocket Wi-Fi,
     * networks the user or OEM skin marked metered). Mobile data only counts when the user allowed it.
     */
    private fun onAllowedNetwork(): Boolean {
        if (inputData.getBoolean(KEY_ALLOW_MOBILE_DATA, false)) return true
        val cm = applicationContext.getSystemService(ConnectivityManager::class.java) ?: return true
        if (!cm.isActiveNetworkMetered) return true
        val caps = cm.getNetworkCapabilities(cm.activeNetwork) ?: return false
        return caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
            caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
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
        const val KEY_ALLOW_MOBILE_DATA = "allow_mobile_data"
        private const val PARALLEL = 4
        private const val TIMEOUT_MS = 15_000

        /**
         * TheMealDB serves size variants by suffix. `/medium` (~37 KB) is sharp enough for cards and
         * the detail hero; the original is ~130 KB and `/small` (250 px) looks soft on cards.
         */
        fun photoUrl(thumbUrl: String): String = "${thumbUrl.trimEnd('/')}/medium"
    }
}
