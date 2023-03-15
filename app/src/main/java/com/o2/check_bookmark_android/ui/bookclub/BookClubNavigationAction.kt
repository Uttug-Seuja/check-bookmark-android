package com.o2.check_bookmark_android.ui.bookclub

sealed class BookClubNavigationAction {
    object NavigateToBookmarkCreate: BookClubNavigationAction()
    object NavigateToBookmarkDetail: BookClubNavigationAction()
    object NavigateToBookmark: BookClubNavigationAction()
    object NavigateToBookSummary: BookClubNavigationAction()
}