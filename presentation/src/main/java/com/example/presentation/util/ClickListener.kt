package com.example.presentation.util

import com.example.domain.model.Book

interface ClickListener {
    fun onItemClick(item: Book)
    fun onLikeClick(item: Book, isSelected: Boolean, position: Int)
}