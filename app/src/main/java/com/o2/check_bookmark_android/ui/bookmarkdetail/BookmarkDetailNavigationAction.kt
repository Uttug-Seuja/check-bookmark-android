package com.o2.check_bookmark_android.ui.bookmarkdetail

import com.o2.check_bookmark_android.ui.bookmarks.BookmarksNavigationAction

sealed class BookmarkDetailNavigationAction {
    object NavigateToBookmarkMoreBottomDialog : BookmarkDetailNavigationAction()
    object NavigateToBookmarkCreate: BookmarkDetailNavigationAction()

}