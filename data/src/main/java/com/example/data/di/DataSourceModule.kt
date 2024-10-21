package com.example.data.di

import com.example.data.api.BookService
import com.example.data.source.remote.BookDataSource
import com.example.data.source.remote.BookDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideMainDataSource(
        bookService: BookService
    ): BookDataSource {
        return BookDataSourceImpl(bookService)
    }
}