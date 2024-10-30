package com.example.domain.usecase.like

import com.example.domain.model.LikeModel
import com.example.domain.repository.LikeRepository

class DeleteLikeUseCase(private val repository: LikeRepository) {
    suspend fun deleteLike(like: LikeModel) {
        return repository.deleteLike(like)
    }
}