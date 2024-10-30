package com.example.domain.usecase.like

import com.example.domain.model.LikeModel
import com.example.domain.repository.LikeRepository

class AddLikeUseCase(private val repository: LikeRepository) {
    suspend fun addLike(like: LikeModel) {
        return repository.addLike(like)
    }
}