package com.example.domain.usecase.like

import com.example.domain.model.Book
import com.example.domain.repository.LikeRepository

class DeleteLikeUseCase(private val repository: LikeRepository) {
    suspend fun deleteLike(item: Book) {
        return repository.deleteLike(item)
    }
}