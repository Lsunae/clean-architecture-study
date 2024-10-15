package com.example.data.mapper

import com.example.data.model.SearchResultResponse
import com.example.domain.model.Book

object BookMapper {
    fun mapperToBook(searchResultResponse: SearchResultResponse): MutableList<Book> {
        val bookList = mutableListOf<Book>()
        searchResultResponse.rss?.channel?.item?.forEach {
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