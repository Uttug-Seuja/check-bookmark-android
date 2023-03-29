package com.o2.data.api

import com.o2.data.model.request.*
import com.o2.data.model.response.BaseResponse
import com.o2.domain.model.*
import okhttp3.MultipartBody
import retrofit2.http.*

interface MainAPIService {

    // 토큰 리프래쉬
    @POST("/api/v1/credentials/refresh")
    suspend fun postRefreshToken(@Body body: PostRefreshTokenRequest): BaseResponse<LoginResponse>

    // 로그인(회원인지 판단)
    @POST("api/v1/user/signIn")
    suspend fun postLogin(
        @Query("idTokenString") idTokenString: String
    ): Unit

    // 회원가입
    @POST("/api/v1/user/signUp")
    suspend fun postSignUp(
        @Body body: PostSignUpRequest
    ): Unit

    // 로그아웃
    @POST("/api/v1/user/logOut")
    suspend fun postLogOut(): Unit

    // 유저 프로필
    @GET("/api/v1/user/profile")
    suspend fun getUserProfile(): BaseResponse<UserProfile>

    // 유저 프로필 변경
    @POST("/api/v1/user/change")
    suspend fun postUserProfile(
        @Body body: PostUserProfileRequest
    ): Unit

    // 파일 URL로 바꾸기
    @Multipart
    @POST("/api/v1/images/upload")
    suspend fun postFileToUrl(@Part file: MultipartBody.Part): BaseResponse<ImageUrl>

    // 랜덤 기본 프로필 이미지 가져오기
    @GET("/api/v1/asset/profile/random")
    suspend fun getRandomProfileImage(): BaseResponse<ImageUrl>

    // 기분 이미지 가져오기
    @GET("/api/v1/asset/mood/image")
    suspend fun getMoodImage(): BaseResponse<MoodImageUrl>

    // 책 생성
    @POST("/api/v1/books/create")
    suspend fun postBooks(
        @Body body: PostBooksRequest
    ): BaseResponse<Books>

    // 책 삭제
    @DELETE("/api/v1/books/delete/{bookId}")
    suspend fun deleteBooks(
        @Path("bookId") bookId: Int
    ): Unit

    // 책 수정
    @POST("/api/v1/books/update/{bookId}")
    suspend fun updateBooks(
        @Body body: PostBooksRequest
    ): BaseResponse<Books>

    // 내가 읽은 책 List 보여주기
    @GET("/api/v1/books/my")
    suspend fun getBooksMy(): BaseResponse<BooksMy>

    // 나의 홈화면 책 리스트
    @GET("/api/v1/books/home")
    suspend fun getBooksHome(): BaseResponse<BooksHome>

    // 나만의 책 요약
    @GET("/api/v1/books/summary/{bookId}")
    suspend fun getBooksSummary(
        @Path("bookId") bookId: Int
    ): BaseResponse<BooksSummary>

    // 북클럽 리스트
    @GET("/api/v1/books/club")
    suspend fun getBooksClub(
        @Body body: Int
    ): BaseResponse<BooksClub>

    // 북클럽 책 요약
    @GET("/api/v1/books/club/summary/{bookId}")
    suspend fun getBooksClubSummary(
        @Path("bookId") bookId: Int
    ): BaseResponse<BooksSummary>

    // 책 자랑하기 등록
    @POST("/api/v1/books/resister/{bookId}")
    suspend fun postBooksResister(
        @Path("bookId") bookId: Int
    ): Unit

    // 책 자랑하기 등록 취소
    @POST("/api/v1/books/resister/cancel/{bookId}")
    suspend fun postBooksResisterCancel(
        @Path("bookId") bookId: Int
    ): Unit

    // 책 좋아요
    @POST("/api/v1/books/likes/{bookId}")
    suspend fun postBooksLike(
        @Path("bookId") bookId: Int
    ): Unit

    // 북마크 생성
    @POST("/api/v1/bookmark/create/{bookId}")
    suspend fun postBookmark(
        @Path("bookId") bookId: Int,
        @Body body: PostBookmarkRequest
    ): BaseResponse<Bookmark>

    // 북마크 삭제
    @DELETE("/api/v1/bookmark/delete/{bookMarkId}")
    suspend fun deleteBookmark(
        @Path("bookMarkId") bookMarkId: Int,
    ): Unit

    // 북마크 업데이트
    @POST("/api/v1/bookmark/update/{bookMarkId}")
    suspend fun updateBookmark(
        @Path("bookMarkId") bookMarkId: Int,
        @Body body: PostBookmarkRequest
    ): BaseResponse<Bookmark>

    // 북마크 리스트 페이징
    @GET("/api/v1/bookmark/list/{bookId}")
    suspend fun getBookmark(
        @Path("bookId") bookId: Int,
        @Query("page") page: Int
    ): BaseResponse<PagingBookmarkList>

    // 북마크 세부 정보
    @GET("/api/v1/bookmark/detail/{bookMarkId}")
    suspend fun getBookmarkDetail(
        @Path("bookMarkId") bookMarkId: Int,
    ): BaseResponse<BookmarkDetail>

}