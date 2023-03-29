package com.o2.check_bookmark_android.ui.bookclub

import com.o2.check_bookmark_android.base.BaseViewModel
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

    private val _bookClubEvent: MutableStateFlow<BooksClub> =
        MutableStateFlow(BooksClub(emptyList()))
    val bookClubEvent: StateFlow<BooksClub> = _bookClubEvent

    init {
        getTempList()
    }

    private fun getTempList() {
        val test1 = BookClub(
            book_club_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            like_number = 225,
        )
        val test2 = BookClub(
            book_club_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            like_number = 225,
        )
        val test3 = BookClub(
            book_club_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            like_number = 225,
        )
        val test4 = BookClub(
            book_club_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            like_number = 225,
        )
        val test5 = BookClub(
            book_club_id = 0,
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            author = "책 저자",
            like_number = 225,
        )

        val testList = BooksClub(listOf(test1, test2, test3, test4, test5))
        baseViewModelScope.launch {
            _bookClubEvent.value = testList
        }
    }

    override fun onBookSummaryClicked(bookSummaryId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookClubNavigationAction.NavigateToBookSummary(bookSummaryId))
        }
    }
}