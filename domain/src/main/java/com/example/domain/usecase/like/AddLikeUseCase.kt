package com.example.domain.usecase.like

import com.example.domain.model.Book
import com.example.domain.repository.LikeRepository

class AddLikeUseCase(private val repository: LikeRepository) {
    suspend fun addLike(item: Book): Boolean = repository.addLike(item)
}