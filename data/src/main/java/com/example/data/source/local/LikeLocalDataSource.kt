package com.example.data.source.local


interface LikeLocalDataSource {
    suspend fun getLikeList(): MutableList<Like>
    suspend fun setLike(like: Like)
}