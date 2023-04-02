package com.o2.check_bookmark_android.ui.setprofile

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.data.DataApplication.Companion.sSharedPreferences
import com.o2.domain.model.ImageUrl
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.*

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

    override fun onSelectionDoneClicked() {
        baseViewModelScope.launch {
            showLoading()
            val idToken = sSharedPreferences.getString("id_token", null)
            val provider = sSharedPreferences.getString("provider", null)
            if (inputContent.value == "") {
                _navigationHandler.emit(SetProfileNavigationAction.NavigateToEmpty)
            } else {
                if (idToken != null && provider != null) {
                    mainRepository.postSignUp(
                        idToken = idToken,
                        profile_path = profileImg.value!!.image_url,
                        nickname = inputContent.value
                    ).onSuccess {
                        _navigationHandler.emit(SetProfileNavigationAction.NavigateToHome)
                    }
                }
            }
            dismissLoading()
        }
    }
}