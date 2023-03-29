package com.o2.domain.model

data class UserProfile(
    val id: Int,
    val nickname: String,
    val profile_path: String,
    val email: String
)