package com.o2.check_bookmark_android.ui.editprofile.saveprofile

sealed class SaveProfileNavigationAction {
    object NavigateToSuccess: SaveProfileNavigationAction()
    object NavigateToEditProfileImg: SaveProfileNavigationAction()
}