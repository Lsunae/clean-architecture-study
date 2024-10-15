package com.example.domain.usecase

import com.example.domain.model.Book
import com.example.domain.repository.BookRepository

class GetSearchBookUseCase(private val repository: BookRepository) {
    suspend fun getSearchBookResult(query: String, display: Int): MutableList<Book>? {
        return repository.searchBook(query, display)
    }
}