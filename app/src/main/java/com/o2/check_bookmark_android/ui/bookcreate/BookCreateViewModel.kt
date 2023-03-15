package com.o2.check_bookmark_android.ui.bookcreate

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.BookCoverStacks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class BookCreateViewModel @Inject constructor(
) : BaseViewModel(), BookCreateActionHandler {

    private val TAG = "BookCreateViewModel"
    var isCreated = MutableStateFlow<Boolean>(false)


    private val _bookmarkStackEvent: MutableStateFlow<BookCoverStacks> =
        MutableStateFlow(BookCoverStacks(emptyList()))

    override fun onToggleFab() {

    }

    override fun onToggleRunningClicked() {
    }

}