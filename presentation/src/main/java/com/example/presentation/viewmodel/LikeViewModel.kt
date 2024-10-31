package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Book
import com.example.domain.usecase.like.AddLikeUseCase
import com.example.domain.usecase.like.DeleteLikeUseCase
import com.example.domain.usecase.like.GetLikeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LikeViewModel @Inject constructor(
    private val getLikeUseCase: GetLikeUseCase,
    private val addLikeUseCase: AddLikeUseCase,
    private val deleteLikeUseCase: DeleteLikeUseCase
) : ViewModel() {
    private val _likeList = MutableLiveData<MutableList<Book>>()
    val likeList: LiveData<MutableList<Book>> get() = _likeList

    fun getLikeList() {
        viewModelScope.launch {
            _likeList.value = getLikeUseCase.getLikeList()
        }
    }

    fun setLike(item: Book, isSelected: Boolean) {
        viewModelScope.launch {
            if (isSelected) addLikeUseCase.addLike(item) else deleteLikeUseCase.deleteLike(item)
        }
    }
}