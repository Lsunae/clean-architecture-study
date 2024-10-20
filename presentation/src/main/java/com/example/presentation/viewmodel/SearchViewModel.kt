package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Book
import com.example.domain.usecase.GetSearchBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase: GetSearchBookUseCase) : ViewModel() {
    private val _searchList = MutableLiveData<ArrayList<Book>>()
    val searchList: LiveData<ArrayList<Book>> get() = _searchList

    fun getSearchList(query: String, display: Int) {
        viewModelScope.launch {
            _searchList.value = useCase.getSearchBookResult(query, display)
        }
    }
}