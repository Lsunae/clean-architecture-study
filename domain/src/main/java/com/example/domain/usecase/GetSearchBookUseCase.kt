package com.example.domain.usecase

import com.example.domain.repository.BookRepository

class GetSearchBookUseCase(private val repository: BookRepository) {
    suspend fun getSearchBookResult() {
        repository.searchBook()
    }
}