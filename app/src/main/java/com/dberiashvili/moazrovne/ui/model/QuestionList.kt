package com.dberiashvili.moazrovne.ui.model

@kotlinx.serialization.Serializable
data class QuestionList(
    val questions: List<QuestionModel>
)