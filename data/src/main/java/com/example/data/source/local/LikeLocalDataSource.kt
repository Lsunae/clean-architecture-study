package com.example.data.source.local

import com.example.domain.model.LikeModel

interface LikeLocalDataSource {
    suspend fun getLikeList(): MutableList<LikeModel>
    suspend fun addLike(like: LikeModel)
    suspend fun deleteLike(like: LikeModel)
}