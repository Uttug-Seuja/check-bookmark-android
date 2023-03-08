package com.o2.check_bookmark_android.ui.setProfile



sealed class SetProfileNavigationAction {
//    class NavigateToSetProfileImage(val profile: Profile): SetProfileNavigationAction()
    object NavigateToSetProfileImage: SetProfileNavigationAction()
    object NavigateToHome: SetProfileNavigationAction()
    object NavigateToEmpty: SetProfileNavigationAction()
    object NavigateToAgeNumberPicker: SetProfileNavigationAction()

}