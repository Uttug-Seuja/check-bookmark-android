package com.o2.check_bookmark_android.ui.splash

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.data.DataApplication.Companion.sSharedPreferences
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    private val TAG = "SplashViewModel"

    private val _navigationEvent: MutableStateFlow<Int> = MutableStateFlow(0)
    val navigationEvent: StateFlow<Int> = _navigationEvent.asStateFlow()

    fun getUserToken() {
        baseViewModelScope.launch {
            val accessToken = sSharedPreferences.getString("access_token", null)
            val refreshToken = sSharedPreferences.getString("refresh_token", null)
            if (accessToken == null) {
                _navigationEvent.value = 1
            } else {
                _navigationEvent.value = 2
            }
        }
    }
}