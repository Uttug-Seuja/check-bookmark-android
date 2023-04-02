package com.o2.check_bookmark_android.ui.bookmarkdetail

import com.o2.check_bookmark_android.ui.bookmarkcreate.BookmarkCreateNavigationAction
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksNavigationAction

sealed class BookmarkDetailNavigationAction {
    class NavigateToBookmarkMoreBottomDialog(val bookmarkId: Int): BookmarkDetailNavigationAction()
    object NavigateToBookmarkCreate: BookmarkDetailNavigationAction()
    object NavigateToBookmark: BookmarkDetailNavigationAction()

}