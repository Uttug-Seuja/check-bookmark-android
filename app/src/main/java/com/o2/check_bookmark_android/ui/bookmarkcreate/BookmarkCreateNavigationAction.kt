package com.o2.check_bookmark_android.ui.bookmarkcreate

sealed class BookmarkCreateNavigationAction {
    class NavigateToBookmarkDetail(val bookmarkId: Int): BookmarkCreateNavigationAction()
    object NavigateToBack : BookmarkCreateNavigationAction()
}