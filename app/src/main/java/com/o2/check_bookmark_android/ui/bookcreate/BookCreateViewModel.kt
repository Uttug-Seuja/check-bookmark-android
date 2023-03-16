package com.o2.check_bookmark_android.ui.bookcreate

import android.util.Log
import com.ao2.run_eat.base.BaseViewModel
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksNavigationAction
import com.o2.domain.model.BookCoverStacks
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookCreateViewModel @Inject constructor(
) : BaseViewModel(), BookCreateActionHandler {

    private val TAG = "BookCreateViewModel"

    private val _navigationEvent: MutableSharedFlow<BookCreateNavigationAction> =
        MutableSharedFlow<BookCreateNavigationAction>()
    val navigationEvent: SharedFlow<BookCreateNavigationAction> = _navigationEvent.asSharedFlow()

    var isCreated = MutableStateFlow<Boolean>(false)
    val titleEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val authorEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val publisherEvent: MutableStateFlow<String> = MutableStateFlow<String>("")
    val totalPagesEvent: MutableStateFlow<String> = MutableStateFlow<String>("")


    override fun onBookCreateClicked() {
        if (titleEvent.value != "" && authorEvent.value != "" && publisherEvent.value != "" && totalPagesEvent.value != "") {
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
}