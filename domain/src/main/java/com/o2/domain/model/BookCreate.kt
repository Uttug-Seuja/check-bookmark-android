package com.o2.domain.model

data class BookCreate(
    val title: String,
    val author: String,
    val publisher: String,
    val totalPages: Int,
)
