package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetSearchBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase: GetSearchBookUseCase) : ViewModel() {

}