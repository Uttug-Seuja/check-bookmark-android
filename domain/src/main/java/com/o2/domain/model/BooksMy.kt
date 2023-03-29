package com.o2.domain.model

data class BooksMy(
    val nickname: String,
    val author: String,
    val likeNumber: String,
    val elapsedDay: String,
    val bookMarkDetailDtos: List<BookMarkDetailDto>
)