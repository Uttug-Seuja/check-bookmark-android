package com.o2.check_bookmark_android.ui.bookmarks

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookmarksBinding
import com.o2.check_bookmark_android.ui.bookmarks.adapter.BookmarksAdapter
import com.o2.check_bookmark_android.ui.books.BooksFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookmarksFragment : BaseFragment<FragmentBookmarksBinding, BookmarksViewModel>(R.layout.fragment_bookmarks) {

    private val TAG = "BookmarksFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_bookmarks

    override val viewModel: BookmarksViewModel by viewModels()
    private val bookmarkAdapter by lazy { BookmarksAdapter(viewModel) }

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
                    is BookmarksNavigationAction.NavigateToBookmarkCreate -> navigate(
                        BookmarksFragmentDirections.actionBookmarksFragmentToBookMarkCreateFragment(false)
                    )
                    is BookmarksNavigationAction.NavigateToBookmarkDetail -> navigate(
                        BookmarksFragmentDirections.actionBookmarksFragmentToBookmarkDetailFragment(it.bookmarkId)
                    )
                }
            }
        }

    }

    private fun initAdapter() {
        binding.booksRecycler.adapter = bookmarkAdapter
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
