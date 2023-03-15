package com.o2.check_bookmark_android.ui.booksummary

sealed class BookSummaryNavigationAction {
    object NavigateToBookmarkCreate: BookSummaryNavigationAction()
    object NavigateToBookmarkDetail: BookSummaryNavigationAction()
    object NavigateToBookmark: BookSummaryNavigationAction()
}