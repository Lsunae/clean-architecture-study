package com.example.clean_architecture_study.di

import android.content.Context
import com.example.data.api.BookService
import com.example.data.source.local.LikeLocalDataSource
import com.example.data.source.local.LikeLocalDataSourceImpl
import com.example.data.source.remote.BookRemoteDataSource
import com.example.data.source.remote.BookRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideMainDataSource(
        bookService: BookService
    ): BookRemoteDataSource {
        return BookRemoteDataSourceImpl(bookService)
    }
    @Provides
    @Singleton
    fun provideLikeDataSource(
        @ApplicationContext context: Context
    ): LikeLocalDataSource {
        return LikeLocalDataSourceImpl(context)
    }
}