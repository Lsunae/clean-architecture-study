package com.example.data.remote.source

interface BookDataSource {
    suspend fun getSearchBooks()
}