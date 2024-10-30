package com.example.data.repository

import com.example.data.source.local.LikeLocalDataSource
import com.example.domain.model.LikeModel
import com.example.domain.repository.LikeRepository
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(private val dataSource: LikeLocalDataSource) :
    LikeRepository {
    override suspend fun getLikeList(): MutableList<LikeModel> {
        TODO("Not yet implemented")
    }

    override suspend fun addLike(like: LikeModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLike(like: LikeModel) {
        TODO("Not yet implemented")
    }
}