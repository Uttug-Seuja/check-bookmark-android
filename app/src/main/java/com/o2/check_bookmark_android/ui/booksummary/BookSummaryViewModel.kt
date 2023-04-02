package com.o2.check_bookmark_android.ui.booksummary

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.*
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookSummaryViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), BookSummaryActionHandler {

    private val TAG = "BookSummaryViewModel"

    private val _navigationEvent: MutableSharedFlow<BookSummaryNavigationAction> =
        MutableSharedFlow<BookSummaryNavigationAction>()
    val navigationEvent: SharedFlow<BookSummaryNavigationAction> = _navigationEvent.asSharedFlow()

    private val _bookSummaryEvent: MutableStateFlow<BooksSummary?> =
        MutableStateFlow(null)
    val bookSummaryEvent: StateFlow<BooksSummary?> = _bookSummaryEvent
    var bookSummaryId = MutableStateFlow<Int>(0)

    init {
        baseViewModelScope.launch {
            mainRepository.getBooksSummary(bookSummaryId.value).onSuccess {
                _bookSummaryEvent.emit(it)

            }
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