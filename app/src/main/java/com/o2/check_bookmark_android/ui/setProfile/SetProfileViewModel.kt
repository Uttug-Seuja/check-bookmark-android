package com.o2.check_bookmark_android.ui.setprofile

import android.util.Log
import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.ImageUrl
import com.o2.domain.model.Profile
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.*
import okhttp3.MultipartBody

@HiltViewModel
class SetProfileViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), SetProfileActionHandler {

    private val TAG = "SetProfileViewModel"

    private val _navigationHandler: MutableSharedFlow<SetProfileNavigationAction> =
        MutableSharedFlow<SetProfileNavigationAction>()
    val navigationHandler: SharedFlow<SetProfileNavigationAction> =
        _navigationHandler.asSharedFlow()

    var inputContent = MutableStateFlow<String>("")
    var editTextMessageCountEvent = MutableStateFlow<Int>(0)

    var nicknameInputContent = MutableStateFlow<String>("")
    var nicknameEditTextCountEvent = MutableStateFlow<Int>(0)

    var ageInputContent = MutableStateFlow<String>("")
    var ageEditTextCountEvent = MutableStateFlow<Int>(0)

    var isManEvent = MutableStateFlow<Boolean?>(null)

    val profileImg: MutableStateFlow<ImageUrl?> = MutableStateFlow(null)

    init {
        baseViewModelScope.launch {
            showLoading()
            mainRepository.getRandomProfileImage()
                .onSuccess { profile ->
                    profileImg.emit(profile)
                }
            dismissLoading()
        }

        baseViewModelScope.launch {
            nicknameInputContent.debounce(0).collectLatest {
                onEditTextCount(it.length)
            }
        }

        baseViewModelScope.launch {
            ageInputContent.debounce(0).collectLatest {
                onAgeEditTextCount(it.length)
            }
        }
        baseViewModelScope.launch {
            showLoading()
//            mainRepository.getUserProfile()
//                .onSuccess {
//                    beforeProfile = it
//                    profileImg.emit(it.profile_path)
//                    profileName.emit(it.nickname)
//                }
            dismissLoading()
        }
    }


    private fun onEditTextCount(count: Int) {
        baseViewModelScope.launch {
            nicknameEditTextCountEvent.value = count
        }
    }

    private fun onAgeEditTextCount(count: Int) {
        baseViewModelScope.launch {
            ageEditTextCountEvent.value = count
        }
    }

    override fun onGenderManClicked() {
        baseViewModelScope.launch {
            isManEvent.value = true
        }

    }

    override fun onGenderWomanClicked() {
        baseViewModelScope.launch {
            Log.d("ttt", "누름")
            isManEvent.value = false
        }
    }

    override fun onAgeSetClicked() {
        baseViewModelScope.launch {
            _navigationHandler.emit(SetProfileNavigationAction.NavigateToAgeNumberPicker)
        }

    }


    override fun onProfileImageSetClicked() {
        baseViewModelScope.launch {
            _navigationHandler.emit(SetProfileNavigationAction.NavigateToSetProfileImage)
        }
    }

    fun setFileToUri(file: MultipartBody.Part) {
        baseViewModelScope.launch {
            showLoading()
//            mainRepository.postFileToUrl(file = file)
//                .onSuccess {
//                    profileImg.value = it.image_url
//                }
            dismissLoading()
        }
    }

    override fun onSelectionDoneClicked() {
        baseViewModelScope.launch {
            showLoading()
//            val idToken = sSharedPreferences.getString("id_token", null)
//            val provider = sSharedPreferences.getString("provider", null)
//            if(inputContent.value == "") {
//                _navigationHandler.emit(SetProfileNavigationAction.NavigateToEmpty)
//            } else {
//                if(idToken != null && provider != null) {
//                    mainRepository.postRegister(
//                        idToken = idToken,
//                        provider = provider,
//                        profile_path = profileImg.value!!.url,
//                        nickname = inputContent.value
//                    ).onSuccess {
//                        editor.putString("access_token", it.access_token)
//                        editor.putString("refresh_token", it.refresh_token)
//                        editor.commit()
//                        val deviceId = sSharedPreferences.getString("device_id", null)
//                        val fcmToken = sSharedPreferences.getString("fcm_token", null)
//                        mainRepository.postNotificationToken(device_id = deviceId!!, token = fcmToken!!)
//                            .onSuccess {
            _navigationHandler.emit(SetProfileNavigationAction.NavigateToHome)
//                            }
//                    }
//                }
//            }
            dismissLoading()
        }
    }

}