package com.example.domain.usecase.like

import com.example.domain.model.Book
import com.example.domain.repository.LikeRepository

class SetLikeUseCase(private val repository: LikeRepository) {
    suspend fun setLikeBook(book: Book) {
        return repository.setLikeBook(book)
    }
}