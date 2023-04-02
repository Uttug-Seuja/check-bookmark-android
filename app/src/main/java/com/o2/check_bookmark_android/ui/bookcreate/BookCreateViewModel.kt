package com.o2.check_bookmark_android.ui.bookcreate

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.data.model.error.InvalidAccessTokenException
import com.o2.domain.onError
import com.o2.domain.onSuccess
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
    private val mainRepository: MainRepository
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
                mainRepository.postBooks(
                    bookName = titleEvent.value,
                    author = authorEvent.value,
                    publisher = publisherEvent.value,
                    pageNumber = totalPagesEvent.value,
                ).onSuccess {
                    _navigationEvent.emit(BookCreateNavigationAction.NavigateToBooks(1))
                }.onError {
                    when (it) {
//                        // 이미 예약했다면
//                        is InvalidAccessTokenException -> _navigationEvent.emit(
//                            AlarmCreateNavigationAction.NavigateToNoReservationAlarm
//                        )
                    }
                }
            }
        }
    }

    override fun onBackClicked() {
        baseViewModelScope.launch {
            _navigationEvent.emit(BookCreateNavigationAction.NavigateToBack)
        }
    }
}