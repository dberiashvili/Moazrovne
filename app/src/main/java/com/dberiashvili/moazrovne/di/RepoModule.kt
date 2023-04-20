package com.dberiashvili.moazrovne.di

import com.dberiashvili.moazrovne.data.Mapper
import com.dberiashvili.moazrovne.data.repository.QuestionRepoImpl
import com.dberiashvili.moazrovne.domain.QuestionsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun provideQuestionRepo(questionRepoImpl: QuestionRepoImpl): QuestionsRepo

    companion object {
        @Provides
        fun  provideMapper(): Mapper = Mapper()
    }
}