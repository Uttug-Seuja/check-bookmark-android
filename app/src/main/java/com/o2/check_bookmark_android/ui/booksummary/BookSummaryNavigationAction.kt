package com.o2.check_bookmark_android.ui.booksummary


sealed class BookSummaryNavigationAction {
    class NavigateToBookSummaryMoreBottomDialog(val bookId: Int) : BookSummaryNavigationAction()
    object NavigateToBack : BookSummaryNavigationAction()
}