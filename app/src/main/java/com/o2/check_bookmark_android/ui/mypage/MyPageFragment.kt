package com.o2.check_bookmark_android.ui.mypage

import androidx.fragment.app.viewModels
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentHomeBinding
import com.o2.check_bookmark_android.databinding.FragmentMyPageBinding
import com.o2.check_bookmark_android.ui.home.adapter.BookmarkStack2Adapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMyPageBinding, MyPageViewModel>(R.layout.fragment_my_page) {

    private val TAG = "MyPageFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_my_page

    override val viewModel: MyPageViewModel by viewModels()

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        setupEvent()
    }

    private fun setupEvent() {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
