package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Rss(
    @SerializedName("channel")
    val rss: Channel?
)
