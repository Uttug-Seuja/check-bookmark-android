package com.o2.check_bookmark_android.ui.bookmarkcreate

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookCreateBinding
import com.o2.check_bookmark_android.databinding.FragmentBookmarkCreateBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BookmarkCreateFragment : BaseFragment<FragmentBookmarkCreateBinding, BookmarkCreateViewModel>(R.layout.fragment_bookmark_create) {

    private val TAG = "BookmarkCreateFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_bookmark_create

    override val viewModel: BookmarkCreateViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
            this.ivClose.setOnClickListener { navController.popBackStack() }
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
