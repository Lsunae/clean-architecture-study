package com.example.data.mapper

import android.util.Log
import com.example.data.model.SearchResultResponse
import com.example.domain.model.Book

object BookMapper {
    fun mapperToBook(response: SearchResultResponse): ArrayList<Book> {
        val bookList = arrayListOf<Book>()
        response.items?.forEach {
            bookList.add(
                Book(
                    title = it.title,
                    link = it.link,
                    image = it.image,
                    author = it.author
                )
            )
        }
        return bookList
    }
}