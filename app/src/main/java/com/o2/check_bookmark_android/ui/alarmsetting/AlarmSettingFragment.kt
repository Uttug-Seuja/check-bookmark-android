package com.o2.check_bookmark_android.ui.alarmsetting

import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentAlarmSettingBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlarmSettingFragment : BaseFragment<FragmentAlarmSettingBinding, AlarmSettingViewModel>(R.layout.fragment_alarm_setting) {

    private val TAG = "AlarmSettingFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_alarm_setting

    override val viewModel : AlarmSettingViewModel by viewModels()

    private val navController: NavController by lazy { findNavController() }

    override fun initStartView() {
        binding.apply {
            this.viewmodel = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        initToolbar()
        viewModel.getOptions()
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

    private fun initToolbar() {
        with(binding.toolbar) {
            this.title = "알림 설정"

            // 뒤로가기 버튼
            this.setNavigationIcon(R.drawable.ic_allow_back_black)
            this.setNavigationOnClickListener { navController.popBackStack() }
        }
    }
}
