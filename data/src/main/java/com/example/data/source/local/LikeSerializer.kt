package com.example.data.source.local

import androidx.datastore.core.Serializer
import java.io.InputStream
import java.io.OutputStream

object LikeSerializer : Serializer<Like> {
    override val defaultValue: Like = Like.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Like {
        return Like.parseFrom(input)
    }

    override suspend fun writeTo(t: Like, output: OutputStream) {
        t.writeTo(output)
    }
}