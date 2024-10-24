package com.example.data.source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

val Context.likeDataStore: DataStore<LikeList> by dataStore(
    fileName = "like.pb",
    serializer = LikeSerializer
)

class LikeLocalDataSourceImpl @Inject constructor(context: Context) {
    private val dataStore = context.likeDataStore

    // 단일 LikeStatus 저장
    suspend fun setLike(like: Like) {
        // 현재 저장된 리스트를 가져옵니다.
        val currentList = getLikeList().toMutableList()

        // 리스트에 단일 LikeStatus 추가 (기존 객체는 업데이트)
        val index = currentList.indexOfFirst { it.id == like.id }
        if (index != -1) {
            currentList[index] = like // 기존 객체 업데이트
        } else {
            currentList.add(like) // 새 객체 추가
        }

        // 업데이트된 리스트를 DataStore에 저장
        val updatedList = LikeList.newBuilder()
            .addAllLikeStatuses(currentList)
            .build()

        dataStore.updateData { updatedList }
    }

    // LikeStatus 리스트 불러오기
    suspend fun getLikeList(): MutableList<Like> {
        return dataStore.data.first().likeStatusesList
    }
}