package com.example.data.source

interface BookDataSource {
    suspend fun getSearchBooks()
}