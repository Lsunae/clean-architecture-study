package com.example.clean_architecture_study.di

import com.example.data.repository.BookRepositoryImpl
import com.example.data.repository.LikeRepositoryImpl
import com.example.data.source.local.LikeLocalDataSource
import com.example.data.source.remote.BookRemoteDataSource
import com.example.domain.repository.BookRepository
import com.example.domain.repository.LikeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideBookRepository(
        bookRemoteDataSource: BookRemoteDataSource
    ): BookRepository {
        return BookRepositoryImpl(bookRemoteDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideLikeRepository(
        likeRemoteDataSource: LikeLocalDataSource
    ): LikeRepository {
        return LikeRepositoryImpl(likeRemoteDataSource)
    }
}