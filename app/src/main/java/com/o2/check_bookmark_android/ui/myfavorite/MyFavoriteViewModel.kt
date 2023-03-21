package com.o2.check_bookmark_android.ui.myfavorite

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyFavoriteViewModel @Inject constructor(
) : BaseViewModel(), MyFavoriteActionHandler {

    private val TAG = "MyFavoriteViewModel"

    private val _navigationEvent: MutableSharedFlow<MyFavoriteNavigationAction> =
        MutableSharedFlow<MyFavoriteNavigationAction>()
    val navigationEvent: SharedFlow<MyFavoriteNavigationAction> = _navigationEvent.asSharedFlow()

    private val _myFavoriteEvent: MutableStateFlow<BookClubs> =
        MutableStateFlow(BookClubs(emptyList()))
    val myFavoriteEvent: StateFlow<BookClubs> = _myFavoriteEvent

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

        val testList = BookClubs(listOf(test1, test2, test3, test4, test5))
        baseViewModelScope.launch {
            _myFavoriteEvent.value = testList
        }
    }

    override fun onBookSummaryClicked(bookSummaryId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(MyFavoriteNavigationAction.NavigateToBookSummary(bookSummaryId))
        }
    }
}