package com.o2.data.repository


import com.o2.data.api.MainAPIService
import com.o2.data.api.handleApi
import com.o2.data.model.request.*
import com.o2.domain.NetworkResult
import com.o2.domain.model.ImageUrl
import com.o2.domain.model.LoginResponse
import com.o2.domain.repository.MainRepository
import okhttp3.MultipartBody
import javax.inject.Inject
import javax.inject.Named

class MainRepositoryImpl @Inject constructor(
    @Named("Main") private val mainAPIService: MainAPIService
) : MainRepository {

    override suspend fun postFileToUrl(file: MultipartBody.Part): NetworkResult<ImageUrl> {
        return handleApi { mainAPIService.postFileToUrl(file = file).data }
    }

    override suspend fun postRefreshToken(refresh_token: String): NetworkResult<LoginResponse> {
        val body = PostRefreshTokenRequest(refresh_token = refresh_token)
        return handleApi { mainAPIService.postRefreshToken(body = body).data }
    }
}