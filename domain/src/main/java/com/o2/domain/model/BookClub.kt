package com.o2.domain.model

data class BookClub(
    val bookId: Int,
    val bookName: String,
    val author: String,
    val publisher: String,
    val pageNumber: Int,
    val likeNumber: Int,
    val nickname: String,
    val likeStatus: Boolean
)