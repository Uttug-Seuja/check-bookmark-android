package com.o2.check_bookmark_android.util.defaultemotion

import com.o2.check_bookmark_android.base.BaseViewModel
import com.o2.domain.model.Emotion
import com.o2.domain.model.MoodImageUrl
import com.o2.domain.onSuccess
import com.o2.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DefaultEmotionViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), DefaultEmotionActionHandler {

    private val TAG = "DefaultEmotionViewModel"

    private val _clickImageUrl: MutableStateFlow<Int?> = MutableStateFlow(null)
    val clickImageUrl: StateFlow<Int?> = _clickImageUrl.asStateFlow()

    private val _imageList: MutableStateFlow<List<MoodImageUrl>> = MutableStateFlow(emptyList())
    val imageList: StateFlow<List<MoodImageUrl>> = _imageList.asStateFlow()

    init {
        baseViewModelScope.launch {
            mainRepository.getMoodImage()
                .onSuccess { _imageList.value = it.moodImageUrl }
        }
    }

    override fun onDefaultEmotionClicked(emotion_id: Int) {
        baseViewModelScope.launch {
            _clickImageUrl.emit(emotion_id)
        }
    }
}