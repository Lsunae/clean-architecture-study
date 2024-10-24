package com.example.data.source.remote

import com.example.data.api.BookService
import com.example.data.model.SearchResultResponse
import retrofit2.Response
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(private val bookService: BookService) :
    BookRemoteDataSource {
    override suspend fun getSearchBooks(
        query: String,
        display: Int
    ): Response<SearchResultResponse> {
        return bookService.searchBook(query, display)
    }
}