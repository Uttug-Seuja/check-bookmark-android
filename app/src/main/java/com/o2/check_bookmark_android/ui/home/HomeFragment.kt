package com.o2.check_bookmark_android.ui.home

import androidx.fragment.app.viewModels
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentHomeBinding
import com.o2.check_bookmark_android.ui.books.adapter.BooksAdapter
import com.o2.check_bookmark_android.ui.home.adapter.BookmarkStack2Adapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    private val TAG = "HomeFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_home

    override val viewModel: HomeViewModel by viewModels()
    private val bookmarkStack2Adapter by lazy { BookmarkStack2Adapter(viewModel) }

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        setupEvent()
        initAdapter()
    }

    private fun setupEvent() {
    }

    private fun initAdapter() {
        binding.bookmarkRecycler.adapter = bookmarkStack2Adapter
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
