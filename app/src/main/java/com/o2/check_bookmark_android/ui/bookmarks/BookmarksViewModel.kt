package com.o2.check_bookmark_android.ui.bookmarks

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.*
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), BookmarksActionHandler {

    private val TAG = "BookmarksViewModel"

    private val _navigationEvent: MutableSharedFlow<BookmarksNavigationAction> =
        MutableSharedFlow<BookmarksNavigationAction>()
    val navigationEvent: SharedFlow<BookmarksNavigationAction> = _navigationEvent.asSharedFlow()

    private val _bookmarksEvent: MutableStateFlow<Bookmarks> =
        MutableStateFlow(Bookmarks("", emptyList()))
    val bookmarksEvent: StateFlow<Bookmarks> = _bookmarksEvent
    var bookId = MutableStateFlow<Int>(0)

    init {
        baseViewModelScope.launch {
            mainRepository.getBookmark(bookId = bookId.value, page = 20)
                .onSuccess {
//                _bookmarksEvent.emit(it)
            }
        }
    }


    override fun onBookmarkCreateClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarksNavigationAction.NavigateToBookmarkCreate)
        }
    }

    override fun onBookmarkSummaryClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarksNavigationAction.NavigateToBookmarkSummary(bookId.value))
        }
    }

    override fun onBookmarkDetailClicked(bookmarkId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarksNavigationAction.NavigateToBookmarkDetail(bookmarkId))
        }
    }

    override fun onBackClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarksNavigationAction.NavigateToBack)
        }
    }
}