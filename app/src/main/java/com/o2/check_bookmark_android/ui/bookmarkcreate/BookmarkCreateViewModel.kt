package com.o2.check_bookmark_android.ui.bookmarkcreate

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.BookmarkStacks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class BookmarkCreateViewModel @Inject constructor(
) : BaseViewModel(), BookmarkCreateActionHandler {

    private val TAG = "BookCreateViewModel"


    private val _bookmarkStackEvent: MutableStateFlow<BookmarkStacks> =
        MutableStateFlow(BookmarkStacks(emptyList()))

    override fun onToggleFab() {

    }

    override fun onToggleRunningClicked() {
    }

}