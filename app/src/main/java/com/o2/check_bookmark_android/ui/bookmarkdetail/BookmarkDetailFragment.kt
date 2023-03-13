package com.o2.check_bookmark_android.ui.bookmarkdetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookmarkDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BookmarkDetailFragment : BaseFragment<FragmentBookmarkDetailBinding, BookmarkDetailViewModel>(R.layout.fragment_bookmark_detail) {

    private val TAG = "BookmarkDetailFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_bookmark_detail

    override val viewModel: BookmarkDetailViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        setupEvent()
        initToolbar()
    }

    private fun setupEvent() {
    }

    private fun initToolbar() {
        with(binding.toolbar) {
            // 뒤로가기 버튼
            this.setNavigationIcon(R.drawable.ic_allow_back)
            this.setNavigationOnClickListener { navController.popBackStack() }
        }
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
