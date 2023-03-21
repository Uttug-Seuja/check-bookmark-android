package com.o2.check_bookmark_android.ui.mypage

sealed class MyPageNavigationAction {
    object NavigateToEditProfile: MyPageNavigationAction()
    object NavigateToMyFavorite: MyPageNavigationAction()

    object NavigateToAlarmSetting: MyPageNavigationAction()

}