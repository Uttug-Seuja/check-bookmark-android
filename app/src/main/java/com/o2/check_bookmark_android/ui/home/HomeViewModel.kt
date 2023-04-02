package com.o2.check_bookmark_android.ui.home

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.BooksHome
import com.o2.domain.onError
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), HomeActionHandler {

    private val TAG = "HomeViewModel"


    private val _bookmarkStackEvent: MutableStateFlow<BooksHome> =
        MutableStateFlow(BooksHome(emptyList()))
    val bookmarkStackEvent: StateFlow<BooksHome> = _bookmarkStackEvent

    init {
        baseViewModelScope.launch {
            mainRepository.getBooksHome()
                .onSuccess {
                    _bookmarkStackEvent.value = it

            }.onError {

            }
        }
    }
}