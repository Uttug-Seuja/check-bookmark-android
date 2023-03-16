package com.o2.check_bookmark_android.ui.bookcreate

import com.o2.check_bookmark_android.ui.bookmarkcreate.BookmarkCreateNavigationAction

sealed class BookCreateNavigationAction {
    class NavigateToBooks(val bookId: Int) : BookCreateNavigationAction()
    object NavigateToBack : BookCreateNavigationAction()
}