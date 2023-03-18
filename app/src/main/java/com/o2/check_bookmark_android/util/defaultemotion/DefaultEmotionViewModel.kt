package com.o2.check_bookmark_android.util.defaultemotion

import com.ao2.run_eat.base.BaseViewModel
import com.o2.domain.model.Emotion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DefaultEmotionViewModel @Inject constructor(
//    private val mainRepository: MainRepository
) : BaseViewModel(), DefaultEmotionActionHandler {

    private val TAG = "DefaultEmotionViewModel"

    private val _clickImageUrl: MutableStateFlow<Int?> = MutableStateFlow(null)
    val clickImageUrl: StateFlow<Int?> = _clickImageUrl.asStateFlow()

    private val _imageList: MutableStateFlow<List<Emotion>> = MutableStateFlow(emptyList())
    val imageList: StateFlow<List<Emotion>> = _imageList.asStateFlow()

    init {
        baseViewModelScope.launch {
//            mainRepository.getReactions()
//                .onSuccess { _imageList.value = it.reactions }
            _imageList.value = listOf(
                Emotion(
                    id = 0,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/grinning-face_1f600.png"
                ),
                Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/grinning-squinting-face_1f606.png"
                ),
                Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/face-with-rolling-eyes_1f644.png"
                ),
                Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/face-screaming-in-fear_1f631.png"
                ),
                Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/face-with-symbols-on-mouth_1f92c.png"
                ), Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/smiling-face-with-heart-eyes_1f60d.png"
                ), Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/expressionless-face_1f611.png"
                ), Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/face-exhaling_1f62e-200d-1f4a8.png"
                ), Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/sleeping-face_1f634.png"
                ), Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/face-vomiting_1f92e.png"
                ), Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/face-with-spiral-eyes_1f635-200d-1f4ab.png"
                ),
                Emotion(
                    id = -1,
                    title = "dd",
                    url = "https://em-content.zobj.net/thumbs/240/apple/325/smiling-face-with-sunglasses_1f60e.png"
                )
            )
        }
    }

    override fun onDefaultEmotionClicked(emotion_id: Int) {
        baseViewModelScope.launch {
            _clickImageUrl.emit(emotion_id)
        }
    }
}