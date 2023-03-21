package com.o2.check_bookmark_android.ui.editprofile.saveprofile

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.UserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class SaveProfileViewModel @Inject constructor(
//    private val mainRepository: MainRepository,
) : BaseViewModel(), SaveProfileActionHandler {

    private val TAG = "SaveProfileViewModel"

    private val _navigationEvent: MutableSharedFlow<SaveProfileNavigationAction> = MutableSharedFlow<SaveProfileNavigationAction>()
    val navigationEvent: SharedFlow<SaveProfileNavigationAction> = _navigationEvent.asSharedFlow()

    val editPossibleState: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)

    val isGalleryImage: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)

    var beforeProfile: UserProfile? = null
    val profileImg: MutableStateFlow<String> = MutableStateFlow("")
    val profileName: MutableStateFlow<String> = MutableStateFlow("")

    init {
        baseViewModelScope.launch {
//            showLoading()
//            mainRepository.getUserProfile()
//                .onSuccess {
//                    beforeProfile = it
//                    profileImg.emit(it.profile_path)
//                    profileName.emit(it.nickname)
//                }
//            dismissLoading()
        }
    }

    fun setFileToUri(file: MultipartBody.Part) {
        baseViewModelScope.launch {
//            showLoading()
//            mainRepository.postFileToUrl(file = file)
//                .onSuccess {
//                    profileImg.value = it.image_url
//                }
//            dismissLoading()
        }
    }

    override fun onProfileImageClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(SaveProfileNavigationAction.NavigateToEditProfileImg)
        }
    }

    override fun onProfileSaveClicked() {
        baseViewModelScope.launch {
//            showLoading()
//            if(beforeProfile!!.profile_path != profileImg.value) {
//                mainRepository.putUserProfile(nickname = profileName.value, profile_path = profileImg.value)
//                    .onSuccess {
//                        _navigationEvent.emit(SaveProfileNavigationAction.NavigateToSuccess)
//                        dismissLoading()
//                        return@launch
//                    }
//            }
//
//            if(beforeProfile!!.nickname != profileName.value) {
//                mainRepository.putUserNickname(nickname = profileName.value)
//                    .onSuccess {
//                        _navigationEvent.emit(SaveProfileNavigationAction.NavigateToSuccess)
//                        dismissLoading()
//                        return@launch
//                    }
//            }
        }
    }
}