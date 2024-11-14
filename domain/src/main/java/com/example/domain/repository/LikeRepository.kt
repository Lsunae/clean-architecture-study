package com.example.domain.repository

import com.example.domain.model.Book

interface LikeRepository {
    suspend fun getLikeList(): MutableList<Book>
    suspend fun addLike(item: Book): Boolean
    suspend fun deleteLike(item: Book): Boolean
}