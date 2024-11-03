package com.example.data.source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.data.datastore.Like
import com.example.data.datastore.LikeList
import com.example.domain.model.Book
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

val Context.likeDataStore: DataStore<LikeList> by dataStore(
    fileName = "like.pb",
    serializer = LikeSerializer
)

private fun Book.toProto() =
    Like.newBuilder().setTitle(this.title).setImage(this.image).setAuthor(this.author)
        .setLink(this.link).build()

class LikeLocalDataSourceImpl @Inject constructor(@ApplicationContext private val context: Context) :
    LikeLocalDataSource {
    private val dataStore = context.likeDataStore

    override suspend fun getLikeList(): MutableList<Book> {
        val likeList = mutableListOf<Book>()
        context.likeDataStore.data.first().likesList.map {
            likeList.add(Book(it.title, it.link, it.image, it.author))
        }
        return likeList
    }

    override suspend fun addLike(item: Book) {
        dataStore.updateData {
            it.toBuilder().addLikes(item.toProto()).build()
        }
    }

    override suspend fun deleteLike(item: Book) {
        dataStore.updateData { likeProto ->
            val index = likeProto.likesList.indexOfFirst { it == item.toProto() }
            likeProto.toBuilder().removeLikes(index).build()
        }
    }
}