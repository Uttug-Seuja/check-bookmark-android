package com.o2.data.model.request

import com.google.gson.annotations.SerializedName


data class PostRefreshTokenRequest(
    @SerializedName("refresh_token") val refresh_token: String
)