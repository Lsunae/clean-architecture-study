package com.example.domain.usecase.like

import com.example.domain.model.Book
import com.example.domain.repository.LikeRepository

class GetLikeUseCase(private val repository: LikeRepository) {
    suspend fun getLikeList(): MutableList<Book> {
        return repository.getLikeList()
    }
}