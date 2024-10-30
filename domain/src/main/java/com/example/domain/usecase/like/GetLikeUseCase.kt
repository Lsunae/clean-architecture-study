package com.example.domain.usecase.like

import com.example.domain.model.LikeModel
import com.example.domain.repository.LikeRepository

class GetLikeUseCase(private val repository: LikeRepository) {
    suspend fun getLikeList(): MutableList<LikeModel> {
        return repository.getLikeList()
    }
}