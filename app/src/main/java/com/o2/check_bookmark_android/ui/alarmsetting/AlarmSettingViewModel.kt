package com.o2.check_bookmark_android.ui.alarmsetting

import com.o2.check_bookmark_android.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmSettingViewModel @Inject constructor(
//    private val mainRepository: MainRepository
) : BaseViewModel(), AlarmSettingsActionHandler {

    private val TAG = "AlarmSettingViewModel"

    private val _alarmPushPermitted: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val alarmPushPermitted: StateFlow<Boolean> = _alarmPushPermitted

    fun getOptions() {
        baseViewModelScope.launch {
//            mainRepository.getOptions()
//                .onSuccess { options ->
//                    _alarmPushPermitted.value = options.new_option
//                }
        }
    }

    override fun onPushAlarmToggled(checked: Boolean) {
        baseViewModelScope.launch {
//            if(checked) mainRepository.postOptionNew()
//            else mainRepository.deleteOptionNew()
        }
    }
}