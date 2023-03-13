package com.o2.check_bookmark_android.ui.mypage

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.Bookmark
import com.o2.domain.model.BookmarkStack
import com.o2.domain.model.BookmarkStacks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
) : BaseViewModel(), MyPageActionHandler {

    private val TAG = "MyPageViewModel"

    override fun onToggleFab() {

    }

    override fun onToggleRunningClicked() {
    }

}