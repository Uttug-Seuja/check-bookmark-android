package com.o2.check_bookmark_android.ui.books

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBooksBinding
import com.o2.check_bookmark_android.ui.books.adapter.BooksAdapter
import com.o2.check_bookmark_android.ui.home.adapter.BookmarkStack2Adapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BooksFragment : BaseFragment<FragmentBooksBinding, BooksViewModel>(R.layout.fragment_books) {

    private val TAG = "BooksFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_books

    override val viewModel: BooksViewModel by viewModels()
    private val booksAdapter by lazy { BooksAdapter(viewModel) }

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
        lifecycleScope.launchWhenStarted {
            viewModel.navigationEvent.collectLatest {
                when (it) {
                    is BooksNavigationAction.NavigateToBookCreate -> navigate(
                        BooksFragmentDirections.actionBooksFragmentToBookCreateFragment()
                    )
                    is BooksNavigationAction.NavigateToBookmarks -> navigate(
                        BooksFragmentDirections.actionBooksFragmentToBookmarksFragment()
                    )
                }
            }
        }

    }

    private fun initAdapter() {
        binding.booksRecycler.adapter = booksAdapter
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
