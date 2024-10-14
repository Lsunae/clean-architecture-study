package com.example.data.model

import com.google.gson.annotations.SerializedName

data class SearchResultResponse(
    @SerializedName("rss")
    val rss: Rss?
)