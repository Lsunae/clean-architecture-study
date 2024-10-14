package com.example.domain.repository

interface BookRepository {
    suspend fun searchBook(query: String, display: Int)
}