package com.o2.check_bookmark_android.ui.mypage

import com.ao2.run_eat.base.BaseViewModel
import com.o2.check_bookmark_android.ui.editprofile.EditProfileNavigationAction
import com.o2.check_bookmark_android.ui.editprofile.SaveProfileNavigationAction
import com.o2.domain.model.UserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
) : BaseViewModel(), MyPageActionHandler {

    private val TAG = "MyPageViewModel"

    private val _navigationEvent: MutableSharedFlow<MyPageNavigationAction> =
        MutableSharedFlow<MyPageNavigationAction>()
    val navigationEvent: SharedFlow<MyPageNavigationAction> = _navigationEvent.asSharedFlow()
    val userProfile: MutableStateFlow<UserProfile?> = MutableStateFlow(null)


    override fun onEditProfileClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(MyPageNavigationAction.NavigateToEditProfile)
        }
    }

    override fun onAlarmSettingClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(MyPageNavigationAction.NavigateToAlarmSetting)
        }
    }
}