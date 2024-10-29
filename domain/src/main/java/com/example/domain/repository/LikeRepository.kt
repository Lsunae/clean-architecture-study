package com.example.domain.repository

interface LikeRepository {
    suspend fun setLike(like: Like)
    suspend fun getLikeList(): MutableList<Like>
}