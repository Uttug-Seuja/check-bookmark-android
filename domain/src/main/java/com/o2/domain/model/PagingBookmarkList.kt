package com.o2.domain.model

data class PagingBookmarkList(
    val content: List<PagingBookmark>,
    val first: Boolean,
    val last: Boolean,
    val numberOfDocuments: Int,
    val empty: Boolean
)