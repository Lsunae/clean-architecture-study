package com.example.domain.repository

import com.example.domain.model.Book

interface BookRepository {
    suspend fun searchBook(query: String, display: Int): ArrayList<Book>?
}