package com.example.data.source.local

import com.example.domain.model.Book

interface LikeLocalDataSource {
    suspend fun getLikeList(): MutableList<Book>
    suspend fun addLike(item: Book): Boolean
    suspend fun deleteLike(item: Book): Boolean
}