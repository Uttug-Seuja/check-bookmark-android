package com.o2.check_bookmark_android.ui.home

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.BookHomeItem
import com.o2.domain.model.BookHome
import com.o2.domain.model.BooksHome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel(), HomeActionHandler {

    private val TAG = "HomeViewModel"


    private val _bookmarkStackEvent: MutableStateFlow<BooksHome> =
        MutableStateFlow(BooksHome(emptyList()))
    val bookmarkStackEvent: StateFlow<BooksHome> = _bookmarkStackEvent

    init {
        getTempList()
    }

    private fun getTempList() {
        val test1 = BookHome(
            listOf(
                BookHomeItem("어린왕자(생택취페리 탄생 120주년 블라블라)", 1),
                BookHomeItem("붕대 감기(윤이형 소설)", 1),
                BookHomeItem("초록빛 힐링의 섬 아일랜드에 멈추다 하하하하", 1),
                BookHomeItem("호모데우스(미래의 역사)", 1)
            )
        )
        val test2 = BookHome(
            listOf(
                BookHomeItem("어린왕자(생택취페리 탄생 120주년 블라블라)", 1),
                BookHomeItem("붕대 감기(윤이형 소설)", 1),
                BookHomeItem("초록빛 힐링의 섬 아일랜드에 멈추다 하하하하", 1),
                BookHomeItem("호모데우스(미래의 역사)", 1)
            )
        )
        val test3 = BookHome(
            listOf(
                BookHomeItem("어린왕자(생택취페리 탄생 120주년 블라블라)", 1),
                BookHomeItem("붕대 감기(윤이형 소설)", 1),
                BookHomeItem("초록빛 힐링의 섬 아일랜드에 멈추다 하하하하", 1),
                BookHomeItem("호모데우스(미래의 역사)", 1)
            )
        )
        val test4 = BookHome(
            listOf(
                BookHomeItem("어린왕자(생택취페리 탄생 120주년 블라블라)", 1),
                BookHomeItem("붕대 감기(윤이형 소설)", 1),
                BookHomeItem("초록빛 힐링의 섬 아일랜드에 멈추다 하하하하", 1),
                BookHomeItem("호모데우스(미래의 역사)", 1)
            )
        )
        val test5 = BookHome(
            listOf(
                BookHomeItem("어린왕자(생택취페리 탄생 120주년 블라블라)", 1),
                BookHomeItem("붕대 감기(윤이형 소설)", 1),
                BookHomeItem("초록빛 힐링의 섬 아일랜드에 멈추다 하하하하", 1),
                BookHomeItem("호모데우스(미래의 역사)", 1)
            )
        )
        val testList = BooksHome(listOf(test1, test2, test3, test4, test5))
        baseViewModelScope.launch {
            _bookmarkStackEvent.value = testList
        }
    }
}