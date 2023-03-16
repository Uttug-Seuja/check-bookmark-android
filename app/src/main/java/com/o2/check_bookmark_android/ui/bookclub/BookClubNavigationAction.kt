package com.o2.check_bookmark_android.ui.bookclub

sealed class BookClubNavigationAction {
    class NavigateToBookSummary(val bookSummaryId: Int): BookClubNavigationAction()
}