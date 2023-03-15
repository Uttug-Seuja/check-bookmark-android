package com.o2.check_bookmark_android.ui.mypage

import com.ao2.run_eat.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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