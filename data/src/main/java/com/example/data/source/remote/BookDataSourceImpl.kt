package com.example.data.source.remote

import com.example.data.model.SearchResultResponse
import com.example.data.api.BookService
import retrofit2.Response
import javax.inject.Inject

class BookDataSourceImpl @Inject constructor(private val bookService: BookService) :
    BookDataSource {
    override suspend fun getSearchBooks(
        query: String,
        display: Int
    ): Response<SearchResultResponse> {
        return bookService.searchBook(query, display)
    }
}