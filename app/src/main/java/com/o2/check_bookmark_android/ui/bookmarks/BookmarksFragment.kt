package com.o2.check_bookmark_android.ui.bookmarks

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookmarksBinding
import com.o2.check_bookmark_android.ui.bookcreate.BookCreateFragmentArgs
import com.o2.check_bookmark_android.ui.bookcreate.BookCreateNavigationAction
import com.o2.check_bookmark_android.ui.bookmarks.adapter.BookmarksAdapter
import com.o2.check_bookmark_android.ui.books.BooksFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookmarksFragment :
    BaseFragment<FragmentBookmarksBinding, BookmarksViewModel>(R.layout.fragment_bookmarks) {

    private val TAG = "BookmarksFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_bookmarks

    override val viewModel: BookmarksViewModel by viewModels()
    private val navController by lazy { findNavController() }
    private val bookmarkAdapter by lazy { BookmarksAdapter(viewModel) }
    private val args: BookmarksFragmentArgs by navArgs()

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        setupEvent()
        initAdapter()

        viewModel.bookId.value = args.bookId
    }

    private fun setupEvent() {
        lifecycleScope.launchWhenStarted {
            viewModel.navigationEvent.collectLatest {
                when (it) {
                    is BookmarksNavigationAction.NavigateToBookmarkCreate -> navigate(
                        BookmarksFragmentDirections.actionBookmarksFragmentToBookMarkCreateFragment(
                            false, -1
                        )
                    )
                    is BookmarksNavigationAction.NavigateToBookmarkDetail -> navigate(
                        BookmarksFragmentDirections.actionBookmarksFragmentToBookmarkDetailFragment(
                            it.bookmarkId
                        )
                    )
                    is BookmarksNavigationAction.NavigateToBack -> navController.popBackStack()
                    is BookmarksNavigationAction.NavigateToBookmarkSummary -> navigate(
                        BookmarksFragmentDirections.actionBookmarksFragmentToBookSummaryFragment(it.bookId)
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
