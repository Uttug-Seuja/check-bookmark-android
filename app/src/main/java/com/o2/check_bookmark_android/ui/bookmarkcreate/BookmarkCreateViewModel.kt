package com.o2.check_bookmark_android.ui.bookmarkcreate

import com.ao2.run_eat.base.BaseViewModel
import com.o2.check_bookmark_android.ui.bookcreate.BookCreateNavigationAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkCreateViewModel @Inject constructor(
) : BaseViewModel(), BookmarkCreateActionHandler {

    private val TAG = "BookmarkCreateViewModel"

    private val _navigationEvent: MutableSharedFlow<BookmarkCreateNavigationAction> =
        MutableSharedFlow<BookmarkCreateNavigationAction>()
    val navigationEvent: SharedFlow<BookmarkCreateNavigationAction> =
        _navigationEvent.asSharedFlow()

    var isCreated = MutableStateFlow<Boolean>(false)
    private val initColor = Color.GREEN

    val titleEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val emotionEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val descriptionEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val lastEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    private val _bookmarkColorEvent: MutableStateFlow<Color> = MutableStateFlow<Color>(initColor)
    val bookmarkColorEvent: StateFlow<Color> = _bookmarkColorEvent.asStateFlow()

    fun setColor(color: Color) {
        _bookmarkColorEvent.value = color
    }

    override fun onBookmarkCreateClicked() {
        if (titleEvent.value != "" && emotionEvent.value != "" && descriptionEvent.value != "" && lastEvent.value != "" && bookmarkColorEvent.value != initColor) {
            baseViewModelScope.launch {
//                mainRepository.postNotificationReservation(
//                    group_id = groupId.value,
//                    title = editTextTitleEvent.value,
//                    content = editTextMessageEvent.value,
//                    image_url = messageImgUri.value,
//                    send_at = sendAt,
//                ).onSuccess {
//                    _navigationEvent.emit(AlarmCreateNavigationAction.NavigateToReservationPushAlarm)
//                }.onError {
//                    Log.d("ttt 예약 알림 보내기 실패", it.toString())
//                    when (it) {
//                        // 이미 예약했다면
//                        is InvalidAccessTokenException -> _navigationEvent.emit(
//                            AlarmCreateNavigationAction.NavigateToNoReservationAlarm
//                        )
//                    }
//                }
            }
        }
    }

    override fun onBackClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookmarkCreateNavigationAction.NavigateToBack)
        }
    }
}

enum class Color {
    GREEN,
    BLUE,
    PINK,
}