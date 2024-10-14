package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName("total")
    val total: String?,
    @SerializedName("item")
    val rss: MutableList<BookItem>?
)
