package com.example.cravewise.domain.cook

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StepTimersTest {

    private fun seconds(text: String) = StepTimers.find(text).map { it.seconds }
    private fun labels(text: String) = StepTimers.find(text).map { it.label }

    @Test fun digitsAndUnits() {
        assertEquals(listOf(20 * 60), seconds("Simmer for 20 minutes, stirring."))
        assertEquals(listOf(5 * 60), seconds("Bake 5 mins."))
        assertEquals(listOf(30), seconds("Blitz for 30 seconds"))
        assertEquals(listOf(2 * 3600), seconds("Roast for 2 hours"))
        assertEquals(listOf(90 * 60), seconds("Cook 1.5 hrs until tender"))
    }

    @Test fun rangesUseTheLowerBound() {
        val found = StepTimers.find("Fry for 10-15 minutes until golden")
        assertEquals(listOf(600), found.map { it.seconds })
        assertEquals(listOf("10–15 min"), found.map { it.label })
        assertEquals(listOf(2 * 3600), seconds("Marinate 2 to 3 hours"))
    }

    @Test fun numberWordsAndFractions() {
        assertEquals(listOf(600), seconds("Leave for ten minutes"))
        assertEquals(listOf(3600), seconds("Chill for an hour"))
        assertEquals(listOf(1800), seconds("Rest for half an hour"))
        assertEquals(listOf(90 * 60), seconds("Braise 1½ hours"))
        assertEquals(listOf(120), seconds("Stir for a couple of minutes"))
    }

    @Test fun compoundDurations() {
        assertEquals(listOf(5400), seconds("Bake for 1 hour 30 minutes"))
        assertEquals(listOf("1 hr 30 min"), labels("Bake for 1 hour and 30 minutes"))
    }

    @Test fun severalPerStepDeduped() {
        assertEquals(
            listOf(300, 1200),
            seconds("Fry onions 5 minutes, add stock and simmer 20 minutes. Taste after 5 minutes."),
        )
    }

    @Test fun ignoresNonDurations() {
        assertTrue(StepTimers.find("Add 2 cups of stock and a few minutes later the rice").isEmpty())
        assertTrue(StepTimers.find("Preheat to 180C, gas mark 4").isEmpty())
        assertTrue(StepTimers.find("Leave for 48 hours").isEmpty()) // over a day
    }

    @Test fun rangeCoversTheMatchedText() {
        val text = "Simmer for 20 minutes."
        val t = StepTimers.find(text).single()
        assertEquals("20 minutes", text.substring(t.range))
    }

    @Test fun formatsDurations() {
        assertEquals("45 sec", StepTimers.formatDuration(45))
        assertEquals("20 min", StepTimers.formatDuration(1200))
        assertEquals("1 hr", StepTimers.formatDuration(3600))
        assertEquals("1 hr 30 min", StepTimers.formatDuration(5400))
    }
}
