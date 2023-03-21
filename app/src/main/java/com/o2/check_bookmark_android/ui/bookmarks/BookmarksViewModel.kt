package com.o2.check_bookmark_android.ui.bookmarks

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(
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
        getTempList()
    }

    private fun getTempList() {
        val test1 = Bookmark(
            bookmark_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            last = 225,
            date = "225",
            bookmark_color = "red",
        )
        val test2 = Bookmark(
            bookmark_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            last = 225,
            date = "225",
            bookmark_color = "red",
        )
        val test3 = Bookmark(
            bookmark_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            last = 225,
            date = "225",
            bookmark_color = "red",
        )
        val test4 = Bookmark(
            bookmark_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            last = 225,
            date = "225",
            bookmark_color = "red",
        )
        val test5 = Bookmark(
            bookmark_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            last = 225,
            date = "225",
            bookmark_color = "red",
        )

        val testList = Bookmarks("어린왕자", listOf(test1, test2, test3, test4, test5))
        baseViewModelScope.launch {
            _bookmarksEvent.value = testList
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