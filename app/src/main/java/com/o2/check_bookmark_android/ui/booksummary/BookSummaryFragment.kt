package com.o2.check_bookmark_android.ui.booksummary

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookClubBinding
import com.o2.check_bookmark_android.databinding.FragmentBookSummaryBinding
import com.o2.check_bookmark_android.ui.booksummary.adapter.BookSummaryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookSummaryFragment : BaseFragment<FragmentBookSummaryBinding, BookSummaryViewModel>(R.layout.fragment_book_summary) {

    private val TAG = "BookSummaryFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_book_summary

    override val viewModel: BookSummaryViewModel by viewModels()
    private val bookSummaryAdapter by lazy { BookSummaryAdapter(viewModel) }

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
        binding.rvBookSummary.adapter = bookSummaryAdapter
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
