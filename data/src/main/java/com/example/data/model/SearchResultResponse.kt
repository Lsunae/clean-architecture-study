package com.example.data.model

import com.google.gson.annotations.SerializedName

data class SearchResultResponse(
    @SerializedName("total")
    val total: String?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("display")
    val display: String?,
    @SerializedName("items")
    val items: ArrayList<BookItem>?
)