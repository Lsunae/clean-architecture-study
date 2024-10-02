package com.example.data.di

import com.example.data.remote.api.BookService
import com.example.data.remote.source.BookDataSource
import com.example.data.remote.source.BookDataSourceImpl
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