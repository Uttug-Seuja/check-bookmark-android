package com.o2.check_bookmark_android.ui.setprofile

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentSetProfileBinding
import com.o2.check_bookmark_android.util.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import java.util.*


@AndroidEntryPoint
class SetProfileFragment : BaseFragment<FragmentSetProfileBinding, SetProfileViewModel>(R.layout.fragment_set_profile) {

    private val TAG = "SetProfileFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_set_profile

    override val viewModel : SetProfileViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun initStartView() {
        binding.apply {
            this.viewmodel = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        initEditText()
        countEditTextMessage()
    }

    override fun initDataBinding() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.navigationHandler.collectLatest {
                when(it) {
                    is SetProfileNavigationAction.NavigateToHome -> navigate(SetProfileFragmentDirections.actionSetProfileFragmentToHomeFragment())
                    is SetProfileNavigationAction.NavigateToEmpty -> toastMessage("닉네임이 비어 있습니다!")
                    else -> {}
                }
            }
        }
    }

    override fun initAfterBinding() {
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun initEditText() {
        //포커싱 시 검정 테두리 필요할 시 주석 해제
        //binding.userNameContents.customOnFocusChangeListener(requireContext())
        binding.profileSetMain.setOnTouchListener { _, _ ->
            requireActivity().hideKeyboard()
            binding.userNameContents.clearFocus()
            false
        }
    }


    private fun countEditTextMessage() {
        lifecycleScope.launchWhenStarted {
            viewModel.editTextMessageCountEvent.collectLatest {
                binding.editTextCount.text = "$it/15"

                if (it != 0) {
                    binding.editTextCount.text =
                        textChangeColor(
                            binding.editTextCount,
                            "#000000",
                            0,
                            it.toString().length
                        )
                }
            }
        }
    }
}