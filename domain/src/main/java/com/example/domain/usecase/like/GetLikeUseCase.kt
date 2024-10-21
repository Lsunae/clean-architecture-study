package com.example.domain.usecase.like

import com.example.domain.model.Book
import com.example.domain.repository.BookRepository

class GetLikeUseCase(private val repository: BookRepository) {
    suspend fun getSearchBookResult(query: String, display: Int): ArrayList<Book>? {
        return repository.searchBook(query, display)
    }
}