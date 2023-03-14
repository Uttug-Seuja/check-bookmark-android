package com.o2.check_bookmark_android.ui.bookmarkcreate

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookCreateBinding
import com.o2.check_bookmark_android.databinding.FragmentBookmarkCreateBinding
import com.o2.check_bookmark_android.ui.bookcreate.BookCreateFragmentArgs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BookmarkCreateFragment : BaseFragment<FragmentBookmarkCreateBinding, BookmarkCreateViewModel>(R.layout.fragment_bookmark_create) {

    private val TAG = "BookmarkCreateFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_bookmark_create

    override val viewModel: BookmarkCreateViewModel by viewModels()
    private val navController by lazy { findNavController() }
    private val args: BookmarkCreateFragmentArgs by navArgs()

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
            this.ivClose.setOnClickListener { navController.popBackStack() }
        }
        exception = viewModel.errorEvent
        setupEvent()

        viewModel.isCreated.value = args.isCreated
    }

    private fun setupEvent() {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
