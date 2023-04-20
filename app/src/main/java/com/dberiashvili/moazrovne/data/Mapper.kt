package com.dberiashvili.moazrovne.data

import com.dberiashvili.moazrovne.data.db.QuestionEntity
import com.dberiashvili.moazrovne.ui.model.QuestionModel

class Mapper {
    fun convert(questionModel: QuestionModel): QuestionEntity {
       return QuestionEntity(
            questionModel.questionId,
            questionModel.author,
            questionModel.questionImg,
            questionModel.answer,
            questionModel.questionText,
            questionModel.comment,
            questionModel.league
        )
    }

    fun convert(questionModel: QuestionEntity): QuestionModel {
        return QuestionModel(
            questionModel.questionId,
            questionModel.author,
            questionModel.questionImg,
            questionModel.answer,
            questionModel.questionText,
            questionModel.comment,
            questionModel.league
        )
    }
}