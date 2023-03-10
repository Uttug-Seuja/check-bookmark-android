package com.o2.check_bookmark_android.ui.books

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.BookmarkStacks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
) : BaseViewModel(), BooksActionHandler {

    private val TAG = "BooksViewModel"

    private val _navigationEvent: MutableSharedFlow<BooksNavigationAction> =
        MutableSharedFlow<BooksNavigationAction>()
    val navigationEvent: SharedFlow<BooksNavigationAction> = _navigationEvent.asSharedFlow()

    private val _bookmarkStackEvent: MutableStateFlow<BookmarkStacks> =
        MutableStateFlow(BookmarkStacks(emptyList()))


    fun onBookCreateClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BooksNavigationAction.NavigateToBookCreate)
        }
    }

    override fun onToggleFab() {

    }

    override fun onToggleRunningClicked() {
    }

}