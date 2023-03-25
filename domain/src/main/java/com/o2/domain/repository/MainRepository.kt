package com.o2.domain.repository

import com.o2.domain.NetworkResult
import com.o2.domain.model.ImageUrl
import com.o2.domain.model.LoginResponse
import okhttp3.MultipartBody

interface MainRepository {

    // 토큰 리프래쉬
    suspend fun postRefreshToken(refresh_token: String): NetworkResult<LoginResponse>

    // 파일 URL로 바꾸기
    suspend fun postFileToUrl(
        file : MultipartBody.Part
    ): NetworkResult<ImageUrl>
}