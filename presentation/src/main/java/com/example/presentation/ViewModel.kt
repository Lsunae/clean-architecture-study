package com.example.presentation

import androidx.lifecycle.ViewModel
import com.example.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: BookRepository) : ViewModel() {

}