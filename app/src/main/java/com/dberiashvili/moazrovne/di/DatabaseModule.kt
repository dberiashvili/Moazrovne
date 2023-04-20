package com.dberiashvili.moazrovne.di

import android.content.Context
import androidx.room.Room
import com.dberiashvili.moazrovne.data.db.QuestionsDB
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {
    companion object {
        @Provides
        @Singleton
         fun provideDB(@ApplicationContext context: Context) = Room.databaseBuilder(
            context, QuestionsDB::class.java, "QUESTION_DATABASE")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        @Provides
        @Singleton
         fun provideDao(db: QuestionsDB) = db.questionsDao()
    }
}