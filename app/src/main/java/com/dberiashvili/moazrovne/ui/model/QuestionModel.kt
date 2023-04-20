package com.dberiashvili.moazrovne.ui.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class QuestionModel(
    @SerialName("question_id")
    val questionId: String,
    val author: String? = null,
    @SerialName("question_img")
    val questionImg: String? = null,
    val answer: String,
    @SerialName("question_text")
    val questionText: String,
    val comment: String? = null,
    val league: String? = null
)
