package com.o2.domain.model

data class BookmarkCreate(
    val title: String,
    val emotion: String,
    val description: String,
    val last: Int,
    val bookmark_color: String
)
