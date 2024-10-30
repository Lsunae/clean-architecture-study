package com.example.data.source.local

import androidx.datastore.core.Serializer
import com.example.data.datastore.LikeList
import java.io.InputStream
import java.io.OutputStream

object LikeSerializer : Serializer<LikeList> {
    override val defaultValue: LikeList = LikeList.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): LikeList {
        return LikeList.parseFrom(input)
    }

    override suspend fun writeTo(t: LikeList, output: OutputStream) {
        t.writeTo(output)
    }
}