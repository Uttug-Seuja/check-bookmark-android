package com.o2.data.di

import com.o2.data.BuildConfig
import com.o2.data.api.ApiClient.BASE_URL
import com.o2.data.api.MainAPIService
import com.o2.data.interceptor.EmptyBodyInterceptor
import com.o2.data.interceptor.ErrorResponseInterceptor
import com.o2.data.interceptor.XAccessTokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .addInterceptor(EmptyBodyInterceptor())
//            .addInterceptor(BearerInterceptor()) // Refresh Token
            .addInterceptor(ErrorResponseInterceptor()) // Error Response
            .build()
    } else {
        OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .addInterceptor(EmptyBodyInterceptor())
//            .addInterceptor(BearerInterceptor()) // Refresh Token
            .addInterceptor(ErrorResponseInterceptor()) // Error Response
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor{

                val original = it.request()
                if (original.url.encodedPath.equals("/api/v1/user", true)){
                    val response = it.proceed(original)
                    response.headers["Authorization"]
                    response.headers["RefreshToken"]

                }

                it.proceed(original)
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
//        .addConverterFactory(NullOnEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideMainAPIService(retrofit: Retrofit) : MainAPIService =
        retrofit.create(MainAPIService::class.java)
}