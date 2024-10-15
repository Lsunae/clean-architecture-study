package com.example.data.remote.repository

import com.example.data.mapper.BookMapper
import com.example.domain.model.Book
import com.example.data.remote.source.BookDataSource
import com.example.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val dataSource: BookDataSource) :
    BookRepository {
    override suspend fun searchBook(query: String, display: Int): MutableList<Book>? {
        val bookList: MutableList<Book>
        if (dataSource.getSearchBooks(query, display).isSuccessful) {
            return dataSource.getSearchBooks(query, display).body()
                ?.let { BookMapper.mapperToBook(it) }
        } else {
            return null
        }
    }
}