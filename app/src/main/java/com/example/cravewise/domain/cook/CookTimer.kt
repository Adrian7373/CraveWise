package com.example.cravewise.domain.cook

import kotlinx.serialization.Serializable
import java.util.Locale
import kotlin.math.max

/**
 * One kitchen timer. Times are on a monotonic clock (`SystemClock.elapsedRealtime` in the app), so
 * a running timer keeps counting while the app is in the background and across process recreation.
 * Immutable: every action returns a new timer.
 */
@Serializable
data class CookTimer(
    val id: Long,
    val label: String,
    /** Step the timer came from (0-based), or -1 for none. */
    val stepIndex: Int,
    val durationMs: Long,
    /** When it hits zero; null while paused. */
    val endsAtMs: Long?,
    /** Time left when paused. Ignored while running. */
    val pausedRemainingMs: Long,
) {
    val isRunning: Boolean get() = endsAtMs != null

    fun remainingMs(now: Long): Long = endsAtMs?.let { max(0L, it - now) } ?: pausedRemainingMs

    /** Rang out: finished while running. A paused timer is never "done". */
    fun isDone(now: Long): Boolean = isRunning && remainingMs(now) == 0L

    fun pause(now: Long): CookTimer =
        if (!isRunning || isDone(now)) this else copy(endsAtMs = null, pausedRemainingMs = remainingMs(now))

    fun resume(now: Long): CookTimer = if (isRunning) this else copy(endsAtMs = now + pausedRemainingMs)

    /** Adds time; on a finished timer this restarts it ("1 more minute"). */
    fun plus(ms: Long, now: Long): CookTimer = when {
        endsAtMs != null -> copy(endsAtMs = max(endsAtMs, now) + ms, durationMs = durationMs + ms)
        else -> copy(pausedRemainingMs = pausedRemainingMs + ms, durationMs = durationMs + ms)
    }

    companion object {
        fun start(id: Long, label: String, stepIndex: Int, durationMs: Long, now: Long) = CookTimer(
            id = id, label = label, stepIndex = stepIndex, durationMs = durationMs,
            endsAtMs = now + durationMs, pausedRemainingMs = durationMs,
        )

        /** "4:05", "1:02:03". Rounds up, so it reads 0:01 until it's really done. */
        fun clock(remainingMs: Long): String {
            val totalSeconds = (remainingMs + 999) / 1000
            val h = totalSeconds / 3600
            val m = (totalSeconds % 3600) / 60
            val s = totalSeconds % 60
            return if (h > 0) {
                String.format(Locale.ROOT, "%d:%02d:%02d", h, m, s)
            } else {
                String.format(Locale.ROOT, "%d:%02d", m, s)
            }
        }
    }
}
