package com.o2.domain.repository

import com.google.gson.annotations.SerializedName
import com.o2.domain.NetworkResult
import com.o2.domain.model.*
import okhttp3.MultipartBody
import retrofit2.http.*

interface MainRepository {

    // 토큰 리프래쉬
    suspend fun postRefreshToken(refresh_token: String): NetworkResult<LoginResponse>

    // 파일 URL로 바꾸기
    suspend fun postFileToUrl(
        file: MultipartBody.Part
    ): NetworkResult<ImageUrl>

    // 로그인(회원인지 판단)
    suspend fun postLogin(
        idTokenString: String
    ): NetworkResult<Unit>

    // 회원가입
    suspend fun postSignUp(
        idToken: String,
        nickname: String,
        profile_path: String
    ): NetworkResult<Unit>

    // 로그아웃
    suspend fun postLogOut(): NetworkResult<Unit>

    // 유저 프로필
    suspend fun getUserProfile(): NetworkResult<UserProfile>

    // 유저 프로필 변경
    suspend fun postUserProfile(
        nickname: String,
        profile_path: String
    ): NetworkResult<Unit>

    // 랜덤 기본 프로필 이미지 가져오기
    suspend fun getRandomProfileImage(): NetworkResult<ImageUrl>

    // 기분 이미지 가져오기
    suspend fun getMoodImage(): NetworkResult<MoodImageUrlList>

    // 책 생성
    suspend fun postBooks(
        bookName: String,
        author: String,
        publisher: String,
        pageNumber: String
    ): NetworkResult<Books>

    // 책 삭제
    suspend fun deleteBooks(
        bookId: Int
    ): NetworkResult<Unit>

    // 책 수정
    suspend fun updateBooks(
        bookName: String,
        author: String,
        publisher: String,
        pageNumber: String
    ): NetworkResult<Books>

    // 내가 읽은 책 List 보여주기
    suspend fun getBooksMy(): NetworkResult<BooksMyList>

    // 나의 홈화면 책 리스트
    suspend fun getBooksHome(): NetworkResult<BooksHome>

    // 나만의 책 요약
    suspend fun getBooksSummary(
        bookId: Int
    ): NetworkResult<BooksSummary>

    // 북클럽 리스트
    suspend fun getBooksClub(
        body: Int
    ): NetworkResult<BooksClub>

    // 북클럽 책 요약
    suspend fun getBooksClubSummary(
        bookId: Int
    ): NetworkResult<BooksSummary>

    // 책 자랑하기 등록
    suspend fun postBooksResister(
        bookId: Int
    ): NetworkResult<Unit>

    // 책 자랑하기 등록 취소
    suspend fun postBooksResisterCancel(
        bookId: Int
    ): NetworkResult<Unit>

    // 책 좋아요
    suspend fun postBooksLike(
        bookId: Int
    ): NetworkResult<Unit>

    // 북마크 생성
    suspend fun postBookmark(
        bookId: Int,
        bookMarkName: String,
        moodImageUrl: String,
        summary: String,
        checkPageNum: Int,
        color: String
    ): NetworkResult<Bookmark>

    // 북마크 삭제
    suspend fun deleteBookmark(
        bookMarkId: Int,
    ): NetworkResult<Unit>

    // 북마크 업데이트
    suspend fun updateBookmark(
        bookMarkId: Int,
        bookMarkName: String,
        moodImageUrl: String,
        summary: String,
        checkPageNum: Int,
        color: String
    ): NetworkResult<Bookmark>

    // 북마크 리스트 페이징
    suspend fun getBookmark(
        bookId: Int,
        page: Int
    ): NetworkResult<PagingBookmarkList>

    // 북마크 세부 정보
    suspend fun getBookmarkDetail(
        bookMarkId: Int,
    ): NetworkResult<BookmarkDetail>

}