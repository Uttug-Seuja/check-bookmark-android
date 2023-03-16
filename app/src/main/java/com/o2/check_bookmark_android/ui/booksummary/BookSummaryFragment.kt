package com.o2.check_bookmark_android.ui.booksummary

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.AlertDialogModel
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.base.DefaultRedAlertDialog
import com.o2.check_bookmark_android.databinding.FragmentBookSummaryBinding
import com.o2.check_bookmark_android.ui.bookmarkdetail.BookmarkDetailFragmentArgs
import com.o2.check_bookmark_android.ui.booksummary.bottom.BookSummaryMoreType
import com.o2.check_bookmark_android.ui.booksummary.bottom.BottomBookSummaryMore
import com.o2.check_bookmark_android.ui.booksummary.adapter.BookSummaryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookSummaryFragment :
    BaseFragment<FragmentBookSummaryBinding, BookSummaryViewModel>(R.layout.fragment_book_summary) {

    private val TAG = "BookSummaryFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_book_summary

    override val viewModel: BookSummaryViewModel by viewModels()
    private val bookSummaryAdapter by lazy { BookSummaryAdapter(viewModel) }
    private val navController by lazy { findNavController() }
    private val args: BookSummaryFragmentArgs by navArgs()

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        setupEvent()
        initAdapter()
        viewModel.bookSummaryId.value = args.bookSummaryId
    }

    private fun setupEvent() {
        lifecycleScope.launchWhenStarted {
            viewModel.navigationEvent.collectLatest {
                when (it) {
                    is BookSummaryNavigationAction.NavigateToBookSummaryMoreBottomDialog -> bookSummaryMoreBottomDialog(
                        it.bookId
                    )
                    is BookSummaryNavigationAction.NavigateToBack -> navController.popBackStack()
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

    private fun bookSummaryMoreBottomDialog(
        bookId: Int,
    ) {
        val dialog: BottomBookSummaryMore = BottomBookSummaryMore {
            when (it) {
                is BookSummaryMoreType.Boast -> {
                    Log.d("tt", "tt")
                }
                is BookSummaryMoreType.Delete -> bookSummaryDeleteDialog(bookId = bookId)
            }
        }
        Log.d("ttt", "들어옴")
        dialog.show(childFragmentManager, TAG)
    }

    private fun bookSummaryDeleteDialog(bookId: Int) {
        val res = AlertDialogModel(
            title = "이 자랑하기를 삭제할까요?",
            description = "자랑하기를 삭제하면 북클럽에서 더이상 볼 수 없어요",
            positiveContents = "삭제하기",
            negativeContents = "취소"
        )
        val dialog: DefaultRedAlertDialog = DefaultRedAlertDialog(
            alertDialogModel = res,
            clickToPositive = {
                toastMessage("자랑하기를 삭제했습니다.")
                // api
            },
            clickToNegative = {
                toastMessage("아니요")
            }
        )
        dialog.show(childFragmentManager, TAG)
    }
}
