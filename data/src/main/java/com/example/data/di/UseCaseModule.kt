package com.example.data.di

import com.example.domain.repository.BookRepository
import com.example.domain.repository.LikeRepository
import com.example.domain.usecase.like.GetLikeUseCase
import com.example.domain.usecase.like.SetLikeUseCase
import com.example.domain.usecase.search.GetSearchBookUseCase
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
    fun provideGetSearchUseCase(repository: BookRepository): GetSearchBookUseCase {
        return GetSearchBookUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetLikeUseCase(repository: LikeRepository): GetLikeUseCase {
        return GetLikeUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideSetLikeUseCase(repository: LikeRepository): SetLikeUseCase {
        return SetLikeUseCase(repository)
    }
}