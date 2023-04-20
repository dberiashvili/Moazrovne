package com.dberiashvili.moazrovne.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuestionEntity::class], version = 1, exportSchema = false)
abstract class QuestionsDB : RoomDatabase() {
    abstract fun questionsDao(): QuestionDao
}