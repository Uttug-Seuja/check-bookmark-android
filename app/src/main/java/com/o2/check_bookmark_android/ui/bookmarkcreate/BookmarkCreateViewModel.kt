package com.o2.check_bookmark_android.ui.bookmarkcreate

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.onError
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkCreateViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), BookmarkCreateActionHandler {

    private val TAG = "BookmarkCreateViewModel"

    private val _navigationEvent: MutableSharedFlow<BookmarkCreateNavigationAction> =
        MutableSharedFlow<BookmarkCreateNavigationAction>()
    val navigationEvent: SharedFlow<BookmarkCreateNavigationAction> =
        _navigationEvent.asSharedFlow()

    var isCreated = MutableStateFlow<Boolean>(false)
    var bookmarkId = MutableStateFlow<Int>(-1)

    private val initColor = Color.GREEN

    val titleEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val emotionEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val descriptionEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val lastEvent: MutableStateFlow<Int> = MutableStateFlow<Int>(0)
    private val _bookmarkColorEvent: MutableStateFlow<Color> = MutableStateFlow<Color>(initColor)
    val bookmarkColorEvent: StateFlow<Color> = _bookmarkColorEvent.asStateFlow()

    fun setColor(color: Color) {
        _bookmarkColorEvent.value = color
    }

    override fun onBookmarkCreateClicked() {
        if (titleEvent.value != "" && emotionEvent.value != "" && descriptionEvent.value != "" && lastEvent.value != 0 && bookmarkColorEvent.value != initColor) {
            baseViewModelScope.launch {
                mainRepository.postBookmark(
                    bookId = 0,
                    bookMarkName = titleEvent.value,
                    moodImageUrl = emotionEvent.value,
                    summary = descriptionEvent.value,
                    checkPageNum = lastEvent.value,
                    color = bookmarkColorEvent.value.name
                ).onSuccess {
//                    _navigationEvent.emit(AlarmCreateNavigationAction.NavigateToReservationPushAlarm)
                }.onError {
//                    when (it) {
//                        // 이미 예약했다면
//                        is InvalidAccessTokenException -> _navigationEvent.emit(
//                            AlarmCreateNavigationAction.NavigateToNoReservationAlarm
//                        )
//                    }
                }
            }
        }
    }

    override fun onBookmarkUpdateClicked() {
        if (titleEvent.value != "" && emotionEvent.value != "" && descriptionEvent.value != "" && lastEvent.value != 0 && bookmarkColorEvent.value != initColor) {
            baseViewModelScope.launch {
                mainRepository.updateBookmark(
                    bookMarkId = bookmarkId.value,
                    bookMarkName = titleEvent.value,
                    moodImageUrl = emotionEvent.value,
                    summary = descriptionEvent.value,
                    checkPageNum = lastEvent.value,
                    color = bookmarkColorEvent.value.name
                ).onSuccess {
//                    _navigationEvent.emit(AlarmCreateNavigationAction.NavigateToReservationPushAlarm)
                }.onError {
//                    when (it) {
//                        // 이미 예약했다면
//                        is InvalidAccessTokenException -> _navigationEvent.emit(
//                            AlarmCreateNavigationAction.NavigateToNoReservationAlarm
//                        )
//                    }
                }
            }
        }
    }

    override fun onBackClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarkCreateNavigationAction.NavigateToBack)
        }
    }

    override fun onEmotionClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarkCreateNavigationAction.NavigateToEmotionBottomSheet)
        }
    }
}

enum class Color {
    GREEN,
    BLUE,
    PINK,
}