package com.example.domain.repository

import com.example.domain.model.LikeModel

interface LikeRepository {
    suspend fun getLikeList(): MutableList<LikeModel>
    suspend fun addLike(like: LikeModel)
    suspend fun deleteLike(like: LikeModel)
}