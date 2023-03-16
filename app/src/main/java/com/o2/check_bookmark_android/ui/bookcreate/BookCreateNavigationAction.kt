package com.o2.check_bookmark_android.ui.bookcreate


sealed class BookCreateNavigationAction {
    class NavigateToBooks(val bookId: Int) : BookCreateNavigationAction()
    object NavigateToBack : BookCreateNavigationAction()
}