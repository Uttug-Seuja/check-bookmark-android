package com.o2.data.repository


import com.o2.data.api.MainAPIService
import com.o2.data.api.handleApi
import com.o2.data.model.request.*
import com.o2.domain.NetworkResult
import com.o2.domain.model.*
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

    override suspend fun postLogin(idTokenString: String): NetworkResult<Unit> {
        return handleApi { mainAPIService.postLogin(idTokenString = idTokenString) }
    }

    override suspend fun postSignUp(
        idToken: String,
        nickname: String,
        profile_path: String
    ): NetworkResult<Unit> {
        val body = PostSignUpRequest(nickname, profile_path)
        return handleApi { mainAPIService.postSignUp(body = body) }
    }

    override suspend fun postLogOut(): NetworkResult<Unit> {
        return handleApi { mainAPIService.postLogOut() }
    }

    override suspend fun getUserProfile(): NetworkResult<UserProfile> {
        return handleApi { mainAPIService.getUserProfile().data }
    }

    override suspend fun postUserProfile(
        nickname: String,
        profile_path: String
    ): NetworkResult<Unit> {
        val body = PostUserProfileRequest(nickname, profile_path)
        return handleApi { mainAPIService.postUserProfile(body = body) }
    }

    override suspend fun getRandomProfileImage(): NetworkResult<ImageUrl> {
        return handleApi { mainAPIService.getRandomProfileImage().data }
    }

    override suspend fun getMoodImage(): NetworkResult<MoodImageUrl> {
        return handleApi { mainAPIService.getMoodImage().data }
    }

    override suspend fun postBooks(
        bookName: String,
        author: String,
        publisher: String,
        pageNumber: String
    ): NetworkResult<Books> {
        val body = PostBooksRequest(bookName, author, publisher, pageNumber)
        return handleApi { mainAPIService.postBooks(body = body).data }
    }

    override suspend fun deleteBooks(bookId: Int): NetworkResult<Unit> {
        return handleApi { mainAPIService.deleteBooks(bookId = bookId) }
    }

    override suspend fun updateBooks(
        bookName: String,
        author: String,
        publisher: String,
        pageNumber: String
    ): NetworkResult<Books> {
        val body = PostBooksRequest(bookName, author, publisher, pageNumber)
        return handleApi { mainAPIService.updateBooks(body = body).data }
    }

    override suspend fun getBooksMy(): NetworkResult<BooksMy> {
        return handleApi { mainAPIService.getBooksMy().data }
    }

    override suspend fun getBooksHome(): NetworkResult<BooksHome> {
        return handleApi { mainAPIService.getBooksHome().data }
    }

    override suspend fun getBooksSummary(bookId: Int): NetworkResult<BooksSummary> {
        return handleApi { mainAPIService.getBooksSummary(bookId = bookId).data }
    }

    override suspend fun getBooksClub(body: Int): NetworkResult<BooksClub> {
        return handleApi { mainAPIService.getBooksClub(body = body).data }
    }

    override suspend fun getBooksClubSummary(bookId: Int): NetworkResult<BooksSummary> {
        return handleApi { mainAPIService.getBooksClubSummary(bookId = bookId).data }
    }

    override suspend fun postBooksResister(bookId: Int): NetworkResult<Unit> {
        return handleApi { mainAPIService.postBooksResister(bookId = bookId) }
    }

    override suspend fun postBooksResisterCancel(bookId: Int): NetworkResult<Unit> {
        return handleApi { mainAPIService.postBooksResisterCancel(bookId = bookId) }
    }

    override suspend fun postBooksLike(bookId: Int): NetworkResult<Unit> {
        return handleApi { mainAPIService.postBooksLike(bookId = bookId) }
    }

    override suspend fun postBookmark(
        bookId: Int,
        bookMarkName: String,
        moodImageUrl: String,
        summary: String,
        checkPageNum: Int,
        color: String
    ): NetworkResult<Bookmark> {
        val body = PostBookmarkRequest(bookMarkName, moodImageUrl, summary, checkPageNum, color)
        return handleApi { mainAPIService.postBookmark(bookId = bookId, body = body).data }
    }

    override suspend fun deleteBookmark(bookMarkId: Int): NetworkResult<Unit> {
        return handleApi { mainAPIService.deleteBookmark(bookMarkId = bookMarkId) }
    }

    override suspend fun updateBookmark(
        bookMarkId: Int,
        bookMarkName: String,
        moodImageUrl: String,
        summary: String,
        checkPageNum: Int,
        color: String
    ): NetworkResult<Bookmark> {
        val body = PostBookmarkRequest(bookMarkName, moodImageUrl, summary, checkPageNum, color)
        return handleApi {
            mainAPIService.updateBookmark(
                bookMarkId = bookMarkId,
                body = body
            ).data
        }
    }

    override suspend fun getBookmark(bookId: Int, page: Int): NetworkResult<PagingBookmarkList> {
        return handleApi { mainAPIService.getBookmark(bookId = bookId, page = page).data }
    }

    override suspend fun getBookmarkDetail(bookMarkId: Int): NetworkResult<BookmarkDetail> {
        return handleApi { mainAPIService.getBookmarkDetail(bookMarkId = bookMarkId).data }
    }

    override suspend fun postRefreshToken(refresh_token: String): NetworkResult<LoginResponse> {
        val body = PostRefreshTokenRequest(refresh_token = refresh_token)
        return handleApi { mainAPIService.postRefreshToken(body = body).data }
    }
}