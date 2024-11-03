package com.example.presentation.util

import com.example.domain.model.Book

interface ClickListener {
    interface OnLikeClickListener {
        fun onLikeClick(item: Book, isSelected: Boolean)
    }
}