package com.example.cravewise.ui.home

import java.util.Calendar

/**
 * What Via says in the Home hero when there's nothing to ask. Each tip points at a real feature
 * the user may not have found yet. Keep them short (they sit beside a big Via on a phone).
 */
internal val HOME_TIPS = listOf(
    "Tell me what's in your kitchen and I'll show what you can cook right now.",
    "Craving something? Search \"something salty\" or \"quick spicy dinner\" and I'll sniff it out.",
    "Missing one or two things? Send them from Almost there straight to your shopping list.",
    "Feeding a crowd? Change the servings on any recipe and I'll scale every amount.",
    "Cook mode finds the timers in each step. Tap one and I'll ring when it's done.",
    "Can't stand coriander? Add it in Profile and I'll hide every recipe that uses it.",
    "Can't decide? Answer a few quick questions and I'll pick dinner for you.",
)

/** A new tip each day; the user can step through the rest with "Another tip". */
internal fun tipOfTheDay(calendar: Calendar = Calendar.getInstance()): Int =
    calendar.get(Calendar.DAY_OF_YEAR) % HOME_TIPS.size

/** Short, time-aware hero headline. */
internal fun greeting(calendar: Calendar = Calendar.getInstance()): String =
    when (calendar.get(Calendar.HOUR_OF_DAY)) {
        in 5..10 -> "Good morning, chef!"
        in 11..16 -> "Good afternoon, chef!"
        in 17..21 -> "Good evening, chef!"
        else -> "Late-night snack, chef?"
    }
