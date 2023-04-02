package com.o2.check_bookmark_android.ui.bookmarkdetail

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.BookmarkDetail
import com.o2.domain.model.ImageUrl
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkDetailViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), BookmarkDetailActionHandler {

    private val TAG = "BookmarkDetailViewModel"


    private val _navigationEvent: MutableSharedFlow<BookmarkDetailNavigationAction> =
        MutableSharedFlow<BookmarkDetailNavigationAction>()
    val navigationEvent: SharedFlow<BookmarkDetailNavigationAction> =
        _navigationEvent.asSharedFlow()

    var bookmarkId = MutableStateFlow<Int>(0)
    var bookmarkDetail: MutableStateFlow<BookmarkDetail?> = MutableStateFlow(null)


    init {
        baseViewModelScope.launch {
            mainRepository.getBookmarkDetail(bookMarkId = bookmarkId.value)
                .onSuccess {
                    bookmarkDetail.emit(it)
            }
        }
    }

    override fun onBookmarkMoreClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(
                BookmarkDetailNavigationAction.NavigateToBookmarkMoreBottomDialog(
                    bookmarkId.value
                )
            )
        }
    }

    override fun onBookmarkCreateClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarkDetailNavigationAction.NavigateToBookmarkCreate)
        }
    }

    fun onBookmarkDeleteClicked(bookmarkId : Int) {
        baseViewModelScope.launch {
            mainRepository.deleteBookmark(bookMarkId = bookmarkId).onSuccess {
                _navigationEvent.emit(BookmarkDetailNavigationAction.NavigateToBookmark)
            }
        }
    }

}