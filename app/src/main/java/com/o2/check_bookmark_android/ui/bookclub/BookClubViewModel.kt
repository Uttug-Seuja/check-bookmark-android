package com.o2.check_bookmark_android.ui.bookclub

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.*
import com.o2.domain.onError
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookClubViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), BookClubActionHandler {

    private val TAG = "BookClubViewModel"

    private val _navigationEvent: MutableSharedFlow<BookClubNavigationAction> =
        MutableSharedFlow<BookClubNavigationAction>()
    val navigationEvent: SharedFlow<BookClubNavigationAction> = _navigationEvent.asSharedFlow()

    private val _bookClubEvent: MutableStateFlow<BooksClub> =
        MutableStateFlow(BooksClub(emptyList()))
    val bookClubEvent: StateFlow<BooksClub> = _bookClubEvent

    init {
        baseViewModelScope.launch {
            mainRepository.getBooksClub(0)
                .onSuccess {
                    _bookClubEvent.value = it

                }.onError {

                }
        }
    }

    override fun onBookSummaryClicked(bookSummaryId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookClubNavigationAction.NavigateToBookSummary(bookSummaryId))
        }
    }
}