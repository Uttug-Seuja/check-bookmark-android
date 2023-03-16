package com.o2.check_bookmark_android.ui.books


interface BooksActionHandler {
    fun onBookClicked(bookId: Int)
    fun onBookMoreClicked(bookId: Int)
}