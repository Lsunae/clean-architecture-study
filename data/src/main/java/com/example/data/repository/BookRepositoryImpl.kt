package com.example.data.repository

import com.example.data.source.BookDataSource
import com.example.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val dataSource: BookDataSource) :
    BookRepository {
    override suspend fun searchBook() {

    }
}