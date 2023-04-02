package com.o2.check_bookmark_android.ui.editprofile

sealed class EditProfileNavigationAction {
    object NavigateToLogout: EditProfileNavigationAction()
    object NavigateToUserDelete: EditProfileNavigationAction()
    object NavigateToEditProfile: EditProfileNavigationAction()
    object NavigateToSplash: EditProfileNavigationAction()

}