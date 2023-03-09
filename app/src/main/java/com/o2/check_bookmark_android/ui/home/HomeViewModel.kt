package com.o2.check_bookmark_android.ui.home

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.BookmarkStack
import com.o2.domain.model.BookmarkStacks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel(), HomeActionHandler {

    private val TAG = "HomeViewModel"


    private val _bookmarkStackEvent: MutableStateFlow<BookmarkStacks> =
        MutableStateFlow(BookmarkStacks(emptyList()))
    val bookmarkStackEvent: StateFlow<BookmarkStacks> = _bookmarkStackEvent

    init {
        getTempList()
    }

    private fun getTempList() {

        val test1 = BookmarkStack(bookmarkId = 0, title = "어린왕자",50,0)
        val test2 = BookmarkStack(bookmarkId = 0, title = "어린왕자",50,0)
        val test3 = BookmarkStack(bookmarkId = 0, title = "어린왕자",50,0)
        val test4 = BookmarkStack(bookmarkId = 0, title = "어린왕자",50,0)
        val test5= BookmarkStack(bookmarkId = 0, title = "어린왕자",50,0)
        val testList = BookmarkStacks(listOf(test1))
        baseViewModelScope.launch {
            _bookmarkStackEvent.value = testList
        }
    }

    override fun onToggleFab() {

    }

    override fun onToggleRunningClicked() {
    }

}