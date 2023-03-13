package com.o2.check_bookmark_android.ui.bookmarks

sealed class BookmarksNavigationAction {
    object NavigateToBookmarkCreate: BookmarksNavigationAction()
    object NavigateToBookmarkDetail: BookmarksNavigationAction()
    object NavigateToBookmark: BookmarksNavigationAction()
}