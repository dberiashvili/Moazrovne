package com.dberiashvili.moazrovne.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Questions_Table")
data class QuestionEntity(
    @PrimaryKey val questionId: String,
    val author: String? ,
    val questionImg: String?,
    val answer: String,
    val questionText: String,
    val comment: String? ,
    val league: String?,
    var isFavorite: Boolean = false
)
