package com.dberiashvili.moazrovne.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dberiashvili.moazrovne.R
import com.dberiashvili.moazrovne.domain.QuestionsRepo
import com.dberiashvili.moazrovne.ui.model.QuestionList
import com.dberiashvili.moazrovne.ui.model.QuestionModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    application: Application,
    private val repo: QuestionsRepo
) : AndroidViewModel(application) {
    private val _questions: MutableStateFlow<List<QuestionModel>> = MutableStateFlow(emptyList())
    val questions = _questions.asStateFlow()

    init {
        viewModelScope.launch {
            val json = Json { ignoreUnknownKeys = true }
            val inputStream: InputStream =
                getApplication<Application>().resources.openRawResource(R.raw.questions)
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val questionList = json.decodeFromString<QuestionList>(jsonString)
            _questions.value = questionList.questions.shuffled()
        }
    }

    fun saveQuestion(questionModel: QuestionModel) {
        viewModelScope.launch {
            repo.addQuestion(questionModel)
        }
    }

    fun getFavoriteQuestions() {
        viewModelScope.launch {
            repo.getQuestions().collect {
                _questions.value = it
            }
        }
    }
}