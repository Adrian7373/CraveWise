package com.example.cravewise.ui.cook

import android.content.Context
import android.media.AudioAttributes
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Rings when a cook-mode timer finishes: the default alarm sound (looping where supported) plus a
 * vibration pattern. Callers stop it on dismiss, on "+1 min", when leaving cook mode, or after a
 * time-out. Plays while the app is in the background as long as the process is alive.
 */
@Singleton
class TimerAlarm @Inject constructor(
    @param:ApplicationContext private val context: Context,
) {
    private var ringtone: Ringtone? = null

    fun start() {
        stop()
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            ?: RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        ringtone = uri?.let { RingtoneManager.getRingtone(context, it) }?.apply {
            audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ALARM)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) isLooping = true
            runCatching { play() }
        }
        vibrate()
    }

    fun stop() {
        ringtone?.let { runCatching { it.stop() } }
        ringtone = null
        vibrator()?.cancel()
    }

    private fun vibrate() {
        val vibrator = vibrator()?.takeIf { it.hasVibrator() } ?: return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createWaveform(PATTERN, -1))
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(PATTERN, -1)
        }
    }

    private fun vibrator(): Vibrator? = ContextCompat.getSystemService(context, Vibrator::class.java)

    private companion object {
        val PATTERN = longArrayOf(0, 400, 200, 400, 200, 400)
    }
}
