package com.o2.check_bookmark_android.ui.bookclub

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookClubBinding
import com.o2.check_bookmark_android.databinding.FragmentBookmarksBinding
import com.o2.check_bookmark_android.ui.bookmarks.adapter.BookmarksAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookClubFragment : BaseFragment<FragmentBookClubBinding, BookClubViewModel>(R.layout.fragment_book_club) {

    private val TAG = "BookClubFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_book_club

    override val viewModel: BookClubViewModel by viewModels()
//    private val bookmarkAdapter by lazy { BookmarksAdapter(viewModel) }

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
//                    is BookClubNavigationAction.NavigateToBookmarkCreate -> navigate(
//                        BookmarksFragmentDirections.actionBookmarksFragmentToBookMarkCreateFragment(false)
//                    )
//                    is BookClubNavigationAction.NavigateToBookmarkDetail -> navigate(
//                        BookmarksFragmentDirections.actionBookmarksFragmentToBookmarkDetailFragment()
//                    )
                    else -> {}
                }
            }
        }

    }

    private fun initAdapter() {
//        binding.booksRecycler.adapter = bookmarkAdapter
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
