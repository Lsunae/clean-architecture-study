package com.example.data.remote.source

import com.example.data.remote.api.BookService
import javax.inject.Inject

class BookDataSourceImpl @Inject constructor(private val bookService: BookService) :
    BookDataSource {
    override suspend fun getSearchBooks() {
        return bookService.searchBook()
    }
}