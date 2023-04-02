package com.o2.check_bookmark_android.ui.myfavorite

import com.o2.check_bookmark_android.base.BaseViewModel
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

    private val _myFavoriteEvent: MutableStateFlow<BooksClub> =
        MutableStateFlow(BooksClub(emptyList()))
    val myFavoriteEvent: StateFlow<BooksClub> = _myFavoriteEvent

    init {
    }

    override fun onBookSummaryClicked(bookSummaryId: Int) {
        baseViewModelScope.launch {
            _navigationEvent.emit(MyFavoriteNavigationAction.NavigateToBookSummary(bookSummaryId))
        }
    }
}