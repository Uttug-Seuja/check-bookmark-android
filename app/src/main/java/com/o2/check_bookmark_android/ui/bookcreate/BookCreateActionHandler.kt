package com.o2.check_bookmark_android.ui.bookcreate


interface BookCreateActionHandler {
    fun onBookCreateClicked()
    fun onBackClicked()
    fun onBookUpdateClicked(bookId: Int)
}