package com.example.data.model

import com.google.gson.annotations.SerializedName

data class BookItem(
    @SerializedName("title")
    val title: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("author")
    val author: String?
)
