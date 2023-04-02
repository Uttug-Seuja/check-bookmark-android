package com.o2.check_bookmark_android.ui.books

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.*
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), BooksActionHandler {

    private val TAG = "BooksViewModel"

    private val _navigationEvent: MutableSharedFlow<BooksNavigationAction> =
        MutableSharedFlow<BooksNavigationAction>()
    val navigationEvent: SharedFlow<BooksNavigationAction> = _navigationEvent.asSharedFlow()

    private val _booksEvent: MutableStateFlow<BooksMyList?> =
        MutableStateFlow(null)
    val booksEvent: StateFlow<BooksMyList?> = _booksEvent

    init {
        baseViewModelScope.launch {
            mainRepository.getBooksMy().onSuccess {
                _booksEvent.emit(it)
            }
        }

    }


    fun onBookCreateClicked(isCreated: Boolean, bookId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(BooksNavigationAction.NavigateToBookCreate(isCreated, bookId))
        }
    }

    override fun onBookClicked(bookId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(BooksNavigationAction.NavigateToBookmarks(bookId))
        }
    }

    override fun onBookMoreClicked(bookId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(BooksNavigationAction.NavigateToBookMoreBottomDialog(bookId))
        }
    }

    fun onBookDeleteClicked(bookId: Int) {
        baseViewModelScope.launch {
            mainRepository.deleteBooks(bookId).onSuccess {
                baseViewModelScope.launch {
                    mainRepository.getBooksMy().onSuccess {
                        _booksEvent.emit(it)
                    }
                }
            }
        }
    }

}