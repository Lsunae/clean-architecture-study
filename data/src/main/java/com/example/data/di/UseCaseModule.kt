package com.example.data.di

import com.example.domain.repository.BookRepository
import com.example.domain.usecase.GetSearchBookUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUseCase(repository: BookRepository): GetSearchBookUseCase {
        return GetSearchBookUseCase(repository)
    }
}