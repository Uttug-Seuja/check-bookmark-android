package com.o2.check_bookmark_android.ui.mypage

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.UserProfile
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), MyPageActionHandler {

    private val TAG = "MyPageViewModel"

    private val _navigationEvent: MutableSharedFlow<MyPageNavigationAction> =
        MutableSharedFlow<MyPageNavigationAction>()
    val navigationEvent: SharedFlow<MyPageNavigationAction> = _navigationEvent.asSharedFlow()
    val userProfile: MutableStateFlow<UserProfile?> = MutableStateFlow(null)

    init {
        baseViewModelScope.launch {
            mainRepository.getUserProfile().onSuccess {
                userProfile.emit(it)
            }
        }
    }

    override fun onEditProfileClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(MyPageNavigationAction.NavigateToEditProfile)
        }
    }

    override fun onMyFavoriteClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(MyPageNavigationAction.NavigateToMyFavorite)
        }    }

    override fun onAlarmSettingClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(MyPageNavigationAction.NavigateToAlarmSetting)
        }
    }
}