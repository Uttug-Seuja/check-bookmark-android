package com.o2.check_bookmark_android.ui.register

sealed class RegisterNavigationAction {
    object NavigateToPushSetting: RegisterNavigationAction()
    object NavigateToNotificationAlarm : RegisterNavigationAction()
    object NavigateToGoogleLogin : RegisterNavigationAction()
    object NavigateToLoginFirst : RegisterNavigationAction()
    object NavigateToLoginAlready : RegisterNavigationAction()
}