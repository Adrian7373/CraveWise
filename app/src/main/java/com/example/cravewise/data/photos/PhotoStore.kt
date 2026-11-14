package com.example.cravewise.data.photos

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.File
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Downloaded recipe photos: one JPEG per recipe in app-private storage (`files/recipe_photos`).
 * Not cache: the user asked for these and expects them to stay, offline. [downloaded] is the set
 * of recipe ids with a photo on disk; the UI shows a photo only for those, else the placeholder art.
 */
@Singleton
class PhotoStore @Inject constructor(@ApplicationContext context: Context) {

    private val dir = File(context.filesDir, DIR)

    private val _downloaded = MutableStateFlow(scan())
    val downloaded: StateFlow<Set<String>> = _downloaded.asStateFlow()

    fun fileFor(recipeId: String): File = File(dir, "${safeName(recipeId)}.jpg")

    fun has(recipeId: String): Boolean = recipeId in _downloaded.value

    /** Writes via a temp file and renames, so a half-written photo never shows. */
    fun save(recipeId: String, data: InputStream) {
        dir.mkdirs()
        val target = fileFor(recipeId)
        val tmp = File(dir, "${target.name}.part")
        tmp.outputStream().use { data.copyTo(it) }
        if (!tmp.renameTo(target)) {
            tmp.delete()
            error("Couldn't save the photo for $recipeId")
        }
        _downloaded.update { it + recipeId }
    }

    /** Deletes every photo ("Remove photos"). */
    fun clear() {
        dir.deleteRecursively()
        _downloaded.value = emptySet()
    }

    /** Bytes on disk, for the "N MB" label. */
    fun sizeBytes(): Long = dir.listFiles()?.sumOf { it.length() } ?: 0L

    private fun scan(): Set<String> =
        dir.listFiles { f -> f.name.endsWith(".jpg") }
            ?.mapTo(HashSet()) { it.name.removeSuffix(".jpg") }
            .orEmpty()

    private companion object {
        const val DIR = "recipe_photos"

        /** Recipe ids are like `mdb-52772`; anything else is replaced so it can't leave [dir]. */
        fun safeName(id: String) = id.replace(Regex("[^A-Za-z0-9_-]"), "_")
    }
}
