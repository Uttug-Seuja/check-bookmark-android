package com.o2.domain.model

data class BookmarkDetail(
    val bookId: Int,
    val bookMarkId: Int,
    val bookMarkName: String,
    val moodImageUrl: String,
    val summary: String,
    val checkPageNum: Int,
    val color: String,
    val completedStatus: Boolean
)