package com.o2.check_bookmark_android.ui.books

sealed class BooksNavigationAction {
    object NavigateToBookmarks: BooksNavigationAction()
    object NavigateToBookMoreBottomDialog: BooksNavigationAction()
    class NavigateToBookCreate(val isCreated: Boolean) : BooksNavigationAction()

}