package com.o2.check_bookmark_android.ui.register

import android.util.Log
import com.o2.check_bookmark_android.base.BaseViewModel
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
class RegisterViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), RegisterActionHandler {

    private val TAG = "RegisterViewModel"

    private val _navigationHandler: MutableSharedFlow<RegisterNavigationAction> =
        MutableSharedFlow<RegisterNavigationAction>()
    val navigationHandler: SharedFlow<RegisterNavigationAction> = _navigationHandler.asSharedFlow()
    val notificationAgreed: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val firebaseToken: MutableStateFlow<String> = MutableStateFlow("")

    init {
    }

    fun sendNotification() {
        baseViewModelScope.launch {
            showLoading()
            notificationAgreed.value = true
//            mainRepository.postNotificationExperience(token = firebaseToken.value, content = messageText.value)
            dismissLoading()
        }
    }

    fun oauthLogin(idToken: String) {
        baseViewModelScope.launch {
            showLoading()
            mainRepository.postLogin(idTokenString = idToken)
                .onSuccess {
                    if (it.logInStatus) {
                        _navigationHandler.emit(RegisterNavigationAction.NavigateToLoginAlready)
                    } else {
                        _navigationHandler.emit(RegisterNavigationAction.NavigateToLoginFirst)
                    }
                }
            dismissLoading()
        }
    }

    override fun onSendTestPushAlarmClicked() {
        baseViewModelScope.launch {
            Log.d("ttt", "1")

            if (!notificationAgreed.value) {
                Log.d("ttt", "3")

                _navigationHandler.emit(RegisterNavigationAction.NavigateToPushSetting)
            } else {
                Log.d("ttt", "4")

                _navigationHandler.emit(RegisterNavigationAction.NavigateToNotificationAlarm)
            }
        }
    }

    override fun onGoogleLoginClicked() {
        baseViewModelScope.launch {
            _navigationHandler.emit(RegisterNavigationAction.NavigateToGoogleLogin)
        }
    }
}