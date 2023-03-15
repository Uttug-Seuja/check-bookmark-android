package com.o2.check_bookmark_android.ui.bookclub

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookClubViewModel @Inject constructor(
) : BaseViewModel(), BookClubActionHandler {

    private val TAG = "BookClubViewModel"

    private val _navigationEvent: MutableSharedFlow<BookClubNavigationAction> =
        MutableSharedFlow<BookClubNavigationAction>()
    val navigationEvent: SharedFlow<BookClubNavigationAction> = _navigationEvent.asSharedFlow()

    private val _bookClubEvent: MutableStateFlow<Books> =
        MutableStateFlow(Books(emptyList()))
    val bookClubEvent: StateFlow<Books> = _bookClubEvent

    init {
        getTempList()
    }

    private fun getTempList() {
        val test1 = Book(
            book_id = 0,
            dDay = 2,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            publisher = "출판사",
            currentPages = 225,
            totalPages = 550,
            percentPages = 50

        )
        val test2 = Book(
            book_id = 0,
            dDay = 2,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            publisher = "출판사",
            currentPages = 225,
            totalPages = 550,
            percentPages = 50

        )
        val test3 = Book(
            book_id = 0,
            dDay = 2,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            publisher = "출판사",
            currentPages = 225,
            totalPages = 550,
            percentPages = 50

        )
        val test4 = Book(
            book_id = 0,
            dDay = 2,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            publisher = "출판사",
            currentPages = 225,
            totalPages = 550,
            percentPages = 50

        )
        val test5 = Book(
            book_id = 0,
            dDay = 2,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            publisher = "출판사",
            currentPages = 225,
            totalPages = 550,
            percentPages = 50
        )

        val testList = Books(listOf(test1, test2, test3, test4, test5))
        baseViewModelScope.launch {
            _bookClubEvent.value = testList
        }
    }

    override fun onBookmarkCreateClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookClubNavigationAction.NavigateToBookmarkCreate)
        }
    }

    override fun onBookmarkDetailClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookClubNavigationAction.NavigateToBookmarkDetail)
        }
    }

    override fun onBookSummaryClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookClubNavigationAction.NavigateToBookSummary)
        }    }

    override fun onToggleFab() {

    }

    override fun onToggleRunningClicked() {
    }

}