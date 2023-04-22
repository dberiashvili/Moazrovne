package com.dberiashvili.moazrovne.domain

import com.dberiashvili.moazrovne.ui.model.QuestionModel
import kotlinx.coroutines.flow.Flow

interface QuestionsRepo {
    suspend fun addQuestion(questionModel: QuestionModel)
    suspend fun  deleteQuestion(questionModel: QuestionModel)
    suspend fun  getQuestions(): Flow<List<QuestionModel>>

    suspend fun  isFavorite(id: String): Flow<QuestionModel?>
}