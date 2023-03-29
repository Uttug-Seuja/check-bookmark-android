package com.o2.domain.model

data class BooksSummary(
    val bookId: Int,
    val nickname: String,
    val author: Int,
    val likeNumber: Int,
    val elapsedDay: String,
    val timeStamp: String,
    val bookMarkDetailDtos: List<BookMarkDetailDto>
)