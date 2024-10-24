package com.example.data.repository

import com.example.data.source.local.LikeLocalDataSource
import com.example.domain.model.Book
import com.example.domain.repository.LikeRepository
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(private val dataSource: LikeLocalDataSource) :
    LikeRepository {
    override suspend fun setLike(like: Like) {
        TODO("Not yet implemented")
    }

    override suspend fun getLikeList(): MutableList<Like> {
        TODO("Not yet implemented")
    }
}