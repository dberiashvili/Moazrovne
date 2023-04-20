package com.dberiashvili.moazrovne.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuestion(questionEntity: QuestionEntity)

    @Update
    fun updateQuestion(questionEntity: QuestionEntity)

    @Delete
    fun deleteQuestion(questionEntity: QuestionEntity)

    @Query("SELECT * FROM  Questions_Table ORDER BY questionId DESC")
    fun getFavoriteQuestions() :  Flow<List<QuestionEntity>>

    @Query("SELECT * FROM Questions_Table WHERE questionId LIKE :id")
    fun getQuestion(id : String) : QuestionEntity
}