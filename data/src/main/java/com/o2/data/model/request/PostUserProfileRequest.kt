package com.o2.data.model.request

import com.google.gson.annotations.SerializedName


data class PostUserProfileRequest(
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profile_path") val profile_path: String
)