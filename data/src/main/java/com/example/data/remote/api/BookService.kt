package com.example.data.remote.api

import com.example.data.model.SearchResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    companion object {
        const val BASE_URL = "https://openapi.naver.com/v1/search/"
    }

    @GET("book.json")
    suspend fun searchBook(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Response<SearchResultResponse>
}