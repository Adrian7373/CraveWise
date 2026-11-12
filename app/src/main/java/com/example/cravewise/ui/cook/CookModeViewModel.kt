package com.example.cravewise.ui.cook

import android.os.SystemClock
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.RecipeScaling
import com.example.cravewise.domain.cook.CookTimer
import com.example.cravewise.domain.cook.StepTimer
import com.example.cravewise.domain.cook.StepTimers
import com.example.cravewise.domain.model.Recipe
import com.example.cravewise.navigation.CookModeRoute
import com.example.cravewise.ui.designsystem.CookTimerState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

data class CookTimerUi(
    val id: Long,
    val label: String,
    val stepIndex: Int,
    val clock: String,
    val state: CookTimerState,
)

data class CookModeUiState(
    val isLoading: Boolean = true,
    /** Null once loaded = the recipe left the catalog. */
    val recipe: Recipe? = null,
    val servings: Int = 0,
    /** Durations found in each step, same order as `recipe.steps`. */
    val stepTimers: List<List<StepTimer>> = emptyList(),
    val timers: List<CookTimerUi> = emptyList(),
    /** Ingredient line positions ticked off (mise en place). */
    val checkedIngredients: Set<Int> = emptySet(),
) {
    val scale: Double get() = recipe?.let { RecipeScaling.factor(it.servings, servings) } ?: 1.0

    val hasActiveTimers: Boolean get() = timers.isNotEmpty()

    /** The running timer started from this step's [timer], if any. */
    fun timerFor(stepIndex: Int, timer: StepTimer): CookTimerUi? =
        timers.firstOrNull { it.stepIndex == stepIndex && it.label == CookModeViewModel.labelFor(stepIndex, timer) }
}

@HiltViewModel(assistedFactory = CookModeViewModel.Factory::class)
class CookModeViewModel @AssistedInject constructor(
    @Assisted private val route: CookModeRoute,
    private val savedState: SavedStateHandle,
    recipes: RecipeRepository,
    private val alarm: TimerAlarm,
) : ViewModel() {

    private val timers = MutableStateFlow(restoreTimers())
    private val now = MutableStateFlow(clock())
    private val checked = savedState.getStateFlow(KEY_CHECKED, IntArray(0))

    /** Timers that already rang, so each rings once. */
    private val rang = mutableSetOf<Long>()
    private var alarmTimeout: Job? = null

    val uiState: StateFlow<CookModeUiState> = combine(
        recipes.observeRecipe(route.recipeId).map { r -> r to r?.steps?.map(StepTimers::find).orEmpty() },
        timers,
        now,
        checked,
    ) { (recipe, stepTimers), timerList, t, checkedLines ->
        CookModeUiState(
            isLoading = false,
            recipe = recipe,
            servings = route.servings,
            stepTimers = stepTimers,
            timers = timerList.map { it.toUi(t) },
            checkedIngredients = checkedLines.toSet(),
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), CookModeUiState(servings = route.servings))

    init {
        viewModelScope.launch { tick() }
    }

    fun startTimer(stepIndex: Int, timer: StepTimer) {
        val t = clock()
        update { list ->
            val id = (list.maxOfOrNull { it.id } ?: 0L) + 1
            list + CookTimer.start(id, labelFor(stepIndex, timer), stepIndex, timer.seconds * 1000L, t)
        }
    }

    fun pauseOrResume(id: Long) {
        val t = clock()
        update { list -> list.map { if (it.id != id) it else if (it.isRunning) it.pause(t) else it.resume(t) } }
    }

    fun addMinute(id: Long) {
        val t = clock()
        rang -= id
        update { list -> list.map { if (it.id == id) it.plus(ONE_MINUTE_MS, t) else it } }
        silenceIfNothingDone()
    }

    fun dismiss(id: Long) {
        rang -= id
        update { list -> list.filterNot { it.id == id } }
        silenceIfNothingDone()
    }

    fun toggleIngredient(position: Int) {
        val current = checked.value.toMutableSet()
        if (!current.remove(position)) current += position
        savedState[KEY_CHECKED] = current.toIntArray()
    }

    override fun onCleared() {
        alarm.stop()
    }

    // -----------------------------------------------------------------------------------------

    /** Keeps the clocks fresh while anything runs, and rings each timer once when it finishes. */
    private suspend fun tick() {
        while (viewModelScope.isActive) {
            val t = clock()
            now.value = t
            val finished = timers.value.filter { it.isDone(t) && it.id !in rang }
            if (finished.isNotEmpty()) {
                rang += finished.map { it.id }
                ring()
            }
            if (timers.value.none { it.isRunning && !it.isDone(t) }) {
                // Idle: sleep until a timer starts (or resumes) instead of polling.
                timers.first { list -> list.any { it.isRunning && !it.isDone(clock()) } }
            } else {
                delay(TICK_MS)
            }
        }
    }

    private fun ring() {
        alarm.start()
        alarmTimeout?.cancel()
        alarmTimeout = viewModelScope.launch {
            delay(ALARM_MAX_MS)
            alarm.stop()
        }
    }

    private fun silenceIfNothingDone() {
        val t = clock()
        if (timers.value.none { it.isDone(t) }) {
            alarmTimeout?.cancel()
            alarm.stop()
        }
        now.value = t
    }

    private fun update(transform: (List<CookTimer>) -> List<CookTimer>) {
        timers.update(transform)
        savedState[KEY_TIMERS] = json.encodeToString(timers.value)
    }

    private fun restoreTimers(): List<CookTimer> =
        savedState.get<String>(KEY_TIMERS)
            ?.let { runCatching { json.decodeFromString<List<CookTimer>>(it) }.getOrNull() }
            .orEmpty()

    private fun CookTimer.toUi(t: Long) = CookTimerUi(
        id = id,
        label = label,
        stepIndex = stepIndex,
        clock = CookTimer.clock(remainingMs(t)),
        state = when {
            isDone(t) -> CookTimerState.Done
            isRunning -> CookTimerState.Running
            else -> CookTimerState.Paused
        },
    )

    @AssistedFactory
    interface Factory {
        fun create(route: CookModeRoute): CookModeViewModel
    }

    companion object {
        private const val KEY_TIMERS = "timers"
        private const val KEY_CHECKED = "checked"
        private const val TICK_MS = 250L
        private const val ONE_MINUTE_MS = 60_000L
        /** Stop ringing on its own after a minute; the card stays red until dismissed. */
        private const val ALARM_MAX_MS = 60_000L
        private val json = Json

        /** Monotonic: keeps counting in the background and survives process recreation. */
        private fun clock(): Long = SystemClock.elapsedRealtime()

        fun labelFor(stepIndex: Int, timer: StepTimer): String = "Step ${stepIndex + 1} · ${timer.label}"
    }
}
