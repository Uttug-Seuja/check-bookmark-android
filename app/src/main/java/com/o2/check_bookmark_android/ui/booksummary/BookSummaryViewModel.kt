package com.o2.check_bookmark_android.ui.booksummary

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookSummaryViewModel @Inject constructor(
) : BaseViewModel(), BookSmmaryActionHandler {

    private val TAG = "BookSummaryViewModel"

    private val _navigationEvent: MutableSharedFlow<BookSummaryNavigationAction> =
        MutableSharedFlow<BookSummaryNavigationAction>()
    val navigationEvent: SharedFlow<BookSummaryNavigationAction> = _navigationEvent.asSharedFlow()

    private val _booksEvent: MutableStateFlow<Books> =
        MutableStateFlow(Books(emptyList()))
    val booksEvent: StateFlow<Books> = _booksEvent

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
            _booksEvent.value = testList
        }
    }

    override fun onBookmarkCreateClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookSummaryNavigationAction.NavigateToBookmarkCreate)
        }
    }

    override fun onBookmarkDetailClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookSummaryNavigationAction.NavigateToBookmarkDetail)
        }
    }

    override fun onToggleFab() {

    }

    override fun onToggleRunningClicked() {
    }

}