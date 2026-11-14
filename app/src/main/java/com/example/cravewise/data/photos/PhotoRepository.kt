package com.example.cravewise.data.photos

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.cravewise.data.local.CatalogDao
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/** What the photo pack download is doing right now. */
enum class PhotoJob { Idle, WaitingForNetwork, Running, Failed }

/** Everything the Home prompt and the Profile section need about recipe photos. */
data class RecipePhotosState(
    /** Recipes that have a photo to download. */
    val total: Int = 0,
    val downloaded: Int = 0,
    val job: PhotoJob = PhotoJob.Idle,
    /** Photos that failed on the last run (only meaningful while [job] is Failed). */
    val failed: Int = 0,
    /** The last run stopped before starting because the phone is out of space (job is Failed). */
    val noSpace: Boolean = false,
    /** Off by default: the pack only downloads on Wi-Fi (unmetered) unless the user allows data. */
    val allowMobileData: Boolean = false,
    /** The one-time Home prompt was answered (either way). */
    val promptDismissed: Boolean = false,
) {
    val isComplete: Boolean get() = total > 0 && downloaded >= total
    val isBusy: Boolean get() = job == PhotoJob.Running || job == PhotoJob.WaitingForNetwork

    /** Ask once on Home: never downloaded, not running, not answered. */
    val shouldPrompt: Boolean get() = !promptDismissed && downloaded == 0 && !isBusy && total > 0

    /** Rough pack size for the copy, from TheMealDB's `/medium` thumbnails (~37 KB each). */
    val estimatedMegabytes: Int get() = ((total * APPROX_PHOTO_KB) / 1024).coerceAtLeast(1)

    companion object {
        const val APPROX_PHOTO_KB = 38
    }
}

/**
 * The opt-in recipe photo pack. Recipes ship without images (the app works fully offline); the user
 * can download all photos once from Home or Profile, after which they're on disk for good.
 * Downloads run in [PhotoDownloadWorker] under WorkManager so they survive leaving the app.
 */
@Singleton
class PhotoRepository @Inject constructor(
    @ApplicationContext context: Context,
    private val store: PhotoStore,
    private val catalog: CatalogDao,
    private val preferences: DataStore<Preferences>,
) {
    private val work = WorkManager.getInstance(context)

    val downloadedIds = store.downloaded

    fun observe(): Flow<RecipePhotosState> = combine(
        catalog.observePhotoCount(),
        store.downloaded,
        work.getWorkInfosForUniqueWorkFlow(WORK_NAME).map { it.lastOrNull() },
        preferences.data,
    ) { total, ids, info, prefs ->
        RecipePhotosState(
            total = total,
            downloaded = ids.size,
            job = info.toJob(),
            failed = info?.takeIf { it.state == WorkInfo.State.FAILED }
                ?.outputData?.getInt(PhotoDownloadWorker.KEY_FAILED, 0) ?: 0,
            noSpace = info?.takeIf { it.state == WorkInfo.State.FAILED }
                ?.outputData?.getBoolean(PhotoDownloadWorker.KEY_NO_SPACE, false) ?: false,
            allowMobileData = prefs[ALLOW_MOBILE_DATA] ?: false,
            promptDismissed = prefs[PROMPT_DISMISSED] ?: false,
        )
    }

    /** Starts (or resumes) the pack download. Answers the Home prompt too. */
    suspend fun download() {
        preferences.edit { it[PROMPT_DISMISSED] = true }
        enqueue(allowMobileData = preferences.data.first()[ALLOW_MOBILE_DATA] ?: false, policy = ExistingWorkPolicy.KEEP)
    }

    fun cancel() {
        work.cancelUniqueWork(WORK_NAME)
    }

    /** Cancels any download and deletes every photo; cards go back to the placeholder art. */
    suspend fun removeAll() {
        work.cancelUniqueWork(WORK_NAME)
        // Forget a finished (e.g. failed) run too, so the status doesn't still say "couldn't download".
        work.pruneWork()
        withContext(Dispatchers.IO) { store.clear() }
    }

    /** Changing the network rule restarts a pending/running download under the new constraint. */
    suspend fun setAllowMobileData(allow: Boolean) {
        preferences.edit { it[ALLOW_MOBILE_DATA] = allow }
        val running = work.getWorkInfosForUniqueWorkFlow(WORK_NAME).first().lastOrNull()?.state
        if (running == WorkInfo.State.ENQUEUED || running == WorkInfo.State.RUNNING || running == WorkInfo.State.BLOCKED) {
            enqueue(allow, ExistingWorkPolicy.REPLACE)
        }
    }

    /**
     * Re-queues a download that is still waiting, so it picks up the current network rule. A job
     * queued by 1.0 (UNMETERED constraint) survives the app update and would otherwise keep
     * waiting forever on metered Wi-Fi.
     */
    suspend fun requeueIfWaiting() {
        val state = work.getWorkInfosForUniqueWorkFlow(WORK_NAME).first().lastOrNull()?.state
        if (state == WorkInfo.State.ENQUEUED || state == WorkInfo.State.BLOCKED) {
            enqueue(preferences.data.first()[ALLOW_MOBILE_DATA] ?: false, ExistingWorkPolicy.REPLACE)
        }
    }

    suspend fun dismissPrompt() {
        preferences.edit { it[PROMPT_DISMISSED] = true }
    }

    /**
     * Always just CONNECTED: the Wi-Fi-only rule is checked by the worker itself (by transport, see
     * [PhotoDownloadWorker.onAllowedNetwork]). An UNMETERED constraint never fires on Wi-Fi the
     * system flags as metered (phone hotspots, pocket Wi-Fi, or a network the user marked metered,
     * which some OEM skins do by default), so the pack sat on "Waiting for Wi-Fi" forever.
     *
     * No STORAGE_NOT_LOW either: OEMs set "low" far above what a ~29 MB pack needs (Realme flags
     * anything under ~10 GB free), which also left the job waiting forever. The worker checks real
     * free space and fails with [PhotoDownloadWorker.KEY_NO_SPACE] instead.
     */
    private fun enqueue(allowMobileData: Boolean, policy: ExistingWorkPolicy) {
        val request = OneTimeWorkRequestBuilder<PhotoDownloadWorker>()
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build(),
            )
            .setInputData(workDataOf(PhotoDownloadWorker.KEY_ALLOW_MOBILE_DATA to allowMobileData))
            .setBackoffCriteria(BackoffPolicy.LINEAR, WIFI_RETRY_SECONDS, TimeUnit.SECONDS)
            .build()
        work.enqueueUniqueWork(WORK_NAME, policy, request)
    }

    private fun WorkInfo?.toJob(): PhotoJob = when (this?.state) {
        WorkInfo.State.RUNNING -> PhotoJob.Running
        WorkInfo.State.ENQUEUED, WorkInfo.State.BLOCKED -> PhotoJob.WaitingForNetwork
        WorkInfo.State.FAILED -> PhotoJob.Failed
        WorkInfo.State.SUCCEEDED, WorkInfo.State.CANCELLED, null -> PhotoJob.Idle
    }

    private companion object {
        const val WORK_NAME = "recipe-photo-pack"
        /** How soon to look again when the worker finds itself on mobile data without permission. */
        const val WIFI_RETRY_SECONDS = 30L
        val ALLOW_MOBILE_DATA = booleanPreferencesKey("photos_allow_mobile_data")
        val PROMPT_DISMISSED = booleanPreferencesKey("photos_prompt_dismissed")
    }
}
