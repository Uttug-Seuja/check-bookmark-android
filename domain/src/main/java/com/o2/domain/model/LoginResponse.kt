package com.o2.domain.model

data class LoginResponse(
    val access_token: String,
    val refresh_token: String
)