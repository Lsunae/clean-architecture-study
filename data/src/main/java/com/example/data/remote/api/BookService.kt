package com.example.data.remote.api

import retrofit2.http.GET

interface BookService {

    companion object {
        const val BASE_URL = "https://openapi.naver.com/v1/search/"
    }

    @GET("/book.json")
    suspend fun searchBook()
}