package com.o2.check_bookmark_android.ui.booksummary

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookSummaryViewModel @Inject constructor(
) : BaseViewModel(), BookSummaryActionHandler {

    private val TAG = "BookSummaryViewModel"

    private val _navigationEvent: MutableSharedFlow<BookSummaryNavigationAction> =
        MutableSharedFlow<BookSummaryNavigationAction>()
    val navigationEvent: SharedFlow<BookSummaryNavigationAction> = _navigationEvent.asSharedFlow()

    private val _bookSummaryEvent: MutableStateFlow<BooksSummary> =
        MutableStateFlow(BooksSummary("", emptyList()))
    val bookSummaryEvent: StateFlow<BooksSummary> = _bookSummaryEvent
    var bookSummaryId = MutableStateFlow<Int>(0)

    init {
        getTempList()
    }

    private fun getTempList() {
        val test1 = BookSummary(
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            description = "책 저자"
        )
        val test2 = BookSummary(
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            description = "책 저자"
        )
        val test3 = BookSummary(
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            description = "책 저자"
        )
        val test4 = BookSummary(
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            description = "책 저자"
        )
        val test5 = BookSummary(
            title = "어린왕자(생택취페리 탄생 120주년 블라블라)",
            description = "책 저자"
        )

        val testList = BooksSummary("d", listOf(test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1, test2, test3, test4, test5))
        baseViewModelScope.launch {
            _bookSummaryEvent.value = testList
        }
    }

    override fun onBookSummaryMoreClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(
                BookSummaryNavigationAction.NavigateToBookSummaryMoreBottomDialog(
                    bookSummaryId.value
                )
            )
        }
    }

    override fun onBackClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(
                BookSummaryNavigationAction.NavigateToBack
            )
        }
    }
}