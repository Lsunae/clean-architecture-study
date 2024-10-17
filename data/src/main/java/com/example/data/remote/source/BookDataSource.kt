package com.example.data.remote.source

import com.example.data.model.SearchResultResponse
import retrofit2.Response

interface BookDataSource {
    suspend fun getSearchBooks(query: String, display: Int): Response<SearchResultResponse>
}