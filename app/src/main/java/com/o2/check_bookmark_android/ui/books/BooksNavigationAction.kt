package com.o2.check_bookmark_android.ui.books

sealed class BooksNavigationAction {
    object NavigateToBookCreate: BooksNavigationAction()
    object NavigateToBookmarks: BooksNavigationAction()

}