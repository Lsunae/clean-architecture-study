package com.example.data.repository

import com.example.data.source.local.LikeLocalDataSource
import com.example.domain.model.Book
import com.example.domain.repository.LikeRepository
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(private val dataSource: LikeLocalDataSource) :
    LikeRepository {
    override suspend fun getLikeList(): MutableList<Book> = dataSource.getLikeList()

    override suspend fun addLike(item: Book) {
        dataSource.addLike(item)
    }

    override suspend fun deleteLike(item: Book) {
        dataSource.deleteLike(item)
    }
}