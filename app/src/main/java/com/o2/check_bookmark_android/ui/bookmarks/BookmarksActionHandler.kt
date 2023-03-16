package com.o2.check_bookmark_android.ui.bookmarks


interface BookmarksActionHandler {
    fun onBookmarkCreateClicked()
    fun onBookmarkDetailClicked(bookmarkId: Int)
}