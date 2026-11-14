package com.example.cravewise.data.photos

import com.example.cravewise.ui.photos.statusText
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RecipePhotosStateTest {

    @Test fun promptsOnlyWhenNothingDownloadedAndNotAnswered() {
        assertTrue(RecipePhotosState(total = 789).shouldPrompt)
        assertFalse(RecipePhotosState(total = 789, promptDismissed = true).shouldPrompt)
        assertFalse(RecipePhotosState(total = 789, downloaded = 1).shouldPrompt)
        assertFalse(RecipePhotosState(total = 789, job = PhotoJob.WaitingForNetwork).shouldPrompt)
        assertFalse(RecipePhotosState(total = 0).shouldPrompt)
    }

    @Test fun completeOnlyWhenEveryPhotoIsOnDisk() {
        assertTrue(RecipePhotosState(total = 3, downloaded = 3).isComplete)
        assertFalse(RecipePhotosState(total = 3, downloaded = 2).isComplete)
        assertFalse(RecipePhotosState(total = 0, downloaded = 0).isComplete)
    }

    @Test fun estimateIsAboutThirtyMegabytesForTheCatalog() {
        assertEquals(29, RecipePhotosState(total = 789).estimatedMegabytes)
        assertEquals(1, RecipePhotosState(total = 1).estimatedMegabytes)
    }

    @Test fun statusSaysWhatToDoNext() {
        assertEquals(
            "Waiting for Wi-Fi. Photos download as soon as you're connected.",
            statusText(RecipePhotosState(total = 789, job = PhotoJob.WaitingForNetwork)),
        )
        assertEquals(
            "1 photo couldn't download. Check your connection and try again.",
            statusText(RecipePhotosState(total = 789, downloaded = 788, job = PhotoJob.Failed, failed = 1)),
        )
        assertEquals("All 789 photos are on this phone and work offline.", statusText(RecipePhotosState(total = 789, downloaded = 789)))
    }

    @Test fun removeDialogSizeNeverReadsZero() {
        assertEquals(29, com.example.cravewise.ui.photos.removedMegabytes(789))
        assertEquals(1, com.example.cravewise.ui.photos.removedMegabytes(3))
    }

    @Test fun downloadsTheMediumVariant() {
        assertEquals("https://x/meals/a.jpg/medium", PhotoDownloadWorker.photoUrl("https://x/meals/a.jpg"))
        assertEquals("https://x/meals/a.jpg/medium", PhotoDownloadWorker.photoUrl("https://x/meals/a.jpg/"))
    }
}
