package com.example.cravewise.ui.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cravewise.data.repository.PantryRepository
import com.example.cravewise.data.repository.ProfileGateSource
import com.example.cravewise.data.repository.RecipeRepository
import com.example.cravewise.domain.Craving
import com.example.cravewise.domain.DecideQuiz
import com.example.cravewise.domain.PantryMatcher
import com.example.cravewise.domain.ProfileGate
import com.example.cravewise.domain.QuizAnswers
import com.example.cravewise.domain.QuizShowcase
import com.example.cravewise.domain.TimeBudget
import com.example.cravewise.domain.model.Ingredient
import com.example.cravewise.domain.model.MealType
import com.example.cravewise.domain.model.Mood
import com.example.cravewise.domain.model.Pantry
import com.example.cravewise.domain.model.Protein
import com.example.cravewise.domain.model.RecipeSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

enum class QuizQuestion { Meal, Time, Mood, Craving, Protein, Pantry }

/** Where the user is in the quiz. Lives only as long as this screen (fresh on every visit). */
data class QuizProgress(
    val step: Int = 0,
    val answers: QuizAnswers = QuizAnswers(),
    val showResults: Boolean = false,
    val shuffle: Int = 0,
)

data class DecideQuizUiState(
    val isLoading: Boolean = true,
    /** Questions in order. The pantry question only appears when the pantry has something in it. */
    val questions: List<QuizQuestion> = emptyList(),
    val step: Int = 0,
    val answers: QuizAnswers = QuizAnswers(),
    /** Options limited to what the profile allows, so no answer leads straight to nothing. */
    val mealTypes: List<MealType> = emptyList(),
    val moods: List<Mood> = emptyList(),
    val proteins: List<Protein> = emptyList(),
    val showResults: Boolean = false,
    val showcase: QuizShowcase? = null,
    /** The quiz matched recipes but the profile hid all of them. */
    val hiddenByProfile: Boolean = false,
) {
    val question: QuizQuestion? get() = questions.getOrNull(step)
    val isLastQuestion: Boolean get() = step == questions.lastIndex
}

@HiltViewModel
class DecideQuizViewModel @Inject constructor(
    recipes: RecipeRepository,
    pantry: PantryRepository,
    gateSource: ProfileGateSource,
) : ViewModel() {

    private val progress = MutableStateFlow(QuizProgress())

    private val inputs = combine(
        recipes.observeRecipeSummaries(),
        recipes.observeIngredients(),
        pantry.observePantry(),
        gateSource.observe(),
    ) { all, ingredients, pantryState, gate -> QuizInputs(all, ingredients.associateBy { it.id }, pantryState, gate) }

    val uiState: StateFlow<DecideQuizUiState> = combine(inputs, progress) { inp, p ->
        val allowed = inp.gate.recipes(inp.recipes)
        val questions = QuizQuestion.entries.filter { it != QuizQuestion.Pantry || !inp.pantry.isEmpty }
        var state = DecideQuizUiState(
            isLoading = false,
            questions = questions,
            step = p.step.coerceIn(0, questions.lastIndex),
            answers = p.answers,
            mealTypes = MealType.entries.filter { t -> allowed.any { t in it.mealTypes } },
            moods = Mood.entries.filter { m -> allowed.any { m in it.moods } },
            proteins = Protein.entries.filter { pr -> allowed.any { pr in it.proteins } },
            showResults = p.showResults,
        )
        if (p.showResults) {
            val usePantry = p.answers.usePantry && !inp.pantry.isEmpty
            val answers = p.answers.copy(usePantry = usePantry)
            val pantryPercent = if (usePantry) {
                inp.recipes.associate { r ->
                    val ids = inp.gate.recipeIngredients[r.id].orEmpty()
                    r.id to PantryMatcher.matchRecipe(r, ids, inp.ingredients, inp.pantry).matchPercent
                }
            } else {
                emptyMap()
            }
            val ranked = DecideQuiz.rank(inp.recipes, answers, pantryPercent)
            val safe = inp.gate.filter(ranked) { it.recipe } // profile hard filters after ranking
            state = state.copy(
                showcase = DecideQuiz.showcase(safe, p.shuffle),
                hiddenByProfile = safe.isEmpty() && ranked.isNotEmpty(),
            )
        }
        state
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), DecideQuizUiState())

    fun setMealType(type: MealType?) = answer { it.copy(mealType = type) }

    fun setTime(time: TimeBudget?) = answer { it.copy(time = time) }

    fun setMood(mood: Mood?) = answer { it.copy(mood = mood) }

    fun toggleCraving(craving: Craving) = answer {
        it.copy(cravings = if (craving in it.cravings) it.cravings - craving else it.cravings + craving)
    }

    fun clearCravings() = answer { it.copy(cravings = emptySet()) }

    fun setProtein(protein: Protein?) = answer { it.copy(protein = protein) }

    fun setUsePantry(use: Boolean) = answer { it.copy(usePantry = use) }

    fun next() {
        val last = uiState.value.questions.lastIndex
        progress.update { if (it.step >= last) it.copy(showResults = true, shuffle = 0) else it.copy(step = it.step + 1) }
    }

    /** Returns false when already on the first question (the screen should navigate back). */
    fun back(): Boolean {
        val p = progress.value
        return when {
            p.showResults -> { progress.update { it.copy(showResults = false) }; true }
            p.step > 0 -> { progress.update { it.copy(step = it.step - 1) }; true }
            else -> false
        }
    }

    fun shuffle() = progress.update { it.copy(shuffle = it.shuffle + 1) }

    fun startOver() = progress.update { QuizProgress() }

    private fun answer(change: (QuizAnswers) -> QuizAnswers) = progress.update { it.copy(answers = change(it.answers)) }
}

private data class QuizInputs(
    val recipes: List<RecipeSummary>,
    val ingredients: Map<String, Ingredient>,
    val pantry: Pantry,
    val gate: ProfileGate,
)
