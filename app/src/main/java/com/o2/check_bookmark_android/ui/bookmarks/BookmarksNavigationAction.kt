package com.o2.check_bookmark_android.ui.bookmarks

sealed class BookmarksNavigationAction {
    object NavigateToBookmarkCreate: BookmarksNavigationAction()
    class NavigateToBookmarkSummary(val bookId: Int): BookmarksNavigationAction()
    class NavigateToBookmarkDetail(val bookmarkId: Int): BookmarksNavigationAction()
    object NavigateToBack : BookmarksNavigationAction()
}