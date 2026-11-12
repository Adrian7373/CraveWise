package com.example.cravewise.domain.cook

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CookTimerTest {

    private val start = CookTimer.start(id = 1, label = "Step 1 · 1 min", stepIndex = 0, durationMs = 60_000, now = 1_000)

    @Test fun countsDownOnTheClock() {
        assertTrue(start.isRunning)
        assertEquals(60_000, start.remainingMs(1_000))
        assertEquals(30_000, start.remainingMs(31_000))
        assertFalse(start.isDone(60_999))
        assertTrue(start.isDone(61_000))
        assertEquals(0, start.remainingMs(99_000))
    }

    @Test fun pauseFreezesAndResumeContinues() {
        val paused = start.pause(now = 21_000)
        assertFalse(paused.isRunning)
        assertEquals(40_000, paused.remainingMs(500_000))
        assertFalse(paused.isDone(500_000))
        val resumed = paused.resume(now = 100_000)
        assertEquals(40_000, resumed.remainingMs(100_000))
        assertTrue(resumed.isDone(140_000))
    }

    @Test fun pausingAFinishedTimerDoesNothing() {
        assertEquals(start, start.pause(now = 70_000))
    }

    @Test fun plusExtendsOrRestarts() {
        assertEquals(90_000, start.plus(60_000, now = 31_000).remainingMs(31_000))
        // Finished long ago: "+1 min" counts from now, not from when it ended.
        val snoozed = start.plus(60_000, now = 500_000)
        assertFalse(snoozed.isDone(500_000))
        assertEquals(60_000, snoozed.remainingMs(500_000))
        assertEquals(80_000, start.pause(21_000).plus(40_000, now = 30_000).remainingMs(30_000))
    }

    @Test fun clockRoundsUp() {
        assertEquals("1:00", CookTimer.clock(60_000))
        assertEquals("0:01", CookTimer.clock(1))
        assertEquals("0:00", CookTimer.clock(0))
        assertEquals("1:02:03", CookTimer.clock(3_723_000))
    }

    @Test fun survivesJsonRoundTrip() {
        val json = Json.encodeToString(listOf(start, start.pause(10_000)))
        assertEquals(listOf(start, start.pause(10_000)), Json.decodeFromString<List<CookTimer>>(json))
    }
}
