package com.example.domain.repository

import com.example.domain.model.Book

interface LikeRepository {
    suspend fun setLikeBook(book: Book)
    suspend fun getLikeBook(): MutableList<Book>
}