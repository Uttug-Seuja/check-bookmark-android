package com.o2.check_bookmark_android.ui.books

sealed class BooksNavigationAction {
    class NavigateToBookmarks(val bookId: Int) : BooksNavigationAction()
    class NavigateToBookMoreBottomDialog(val bookId: Int) : BooksNavigationAction()
    class NavigateToBookCreate(val isCreated: Boolean) : BooksNavigationAction()

}