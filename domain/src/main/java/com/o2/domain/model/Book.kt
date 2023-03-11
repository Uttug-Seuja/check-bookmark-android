package com.o2.domain.model

data class Book(
    val book_id: Int,
    val dDay: Int,
    val title: String,
    val author: String,
    val publisher: String,
    val currentPages: Int,
    val totalPages: Int,
    val percentPages: Int
    )
