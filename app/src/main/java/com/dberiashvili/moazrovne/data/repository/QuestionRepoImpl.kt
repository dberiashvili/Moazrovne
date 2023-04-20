package com.dberiashvili.moazrovne.data.repository

import com.dberiashvili.moazrovne.data.Mapper
import com.dberiashvili.moazrovne.data.db.QuestionsDB
import com.dberiashvili.moazrovne.domain.QuestionsRepo
import com.dberiashvili.moazrovne.ui.model.QuestionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuestionRepoImpl @Inject constructor(
    private val db: QuestionsDB,
    private val mapper: Mapper
) : QuestionsRepo {
    override suspend fun addQuestion(questionModel: QuestionModel) {
        db.questionsDao().addQuestion(mapper.convert(questionModel))
    }

    override suspend fun getQuestions(): Flow<List<QuestionModel>> {
        return db.questionsDao().getFavoriteQuestions().map { questions ->
            questions.map { entity ->
                mapper.convert(entity)
            }
        }
    }
}