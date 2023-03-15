package com.o2.check_bookmark_android.ui.books

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.AlertDialogModel
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.base.DefaultRedAlertDialog
import com.o2.check_bookmark_android.databinding.FragmentBooksBinding
import com.o2.check_bookmark_android.ui.books.adapter.BooksAdapter
import com.o2.check_bookmark_android.ui.books.bottom.AlarmMoreType
import com.o2.check_bookmark_android.ui.books.bottom.BottomBookMore
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
                        BooksFragmentDirections.actionBooksFragmentToBookCreateFragment(it.isCreated)
                    )
                    is BooksNavigationAction.NavigateToBookmarks -> navigate(
                        BooksFragmentDirections.actionBooksFragmentToBookmarksFragment()
                    )
                    is BooksNavigationAction.NavigateToBookMoreBottomDialog -> bookMoreBottomDialog(
                        0
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

    private fun bookMoreBottomDialog(
        bookId: Int,
    ) {
        val dialog: BottomBookMore = BottomBookMore {
            when (it) {
                is AlarmMoreType.Copy -> {
                    viewModel.onBookCreateClicked(isCreated = true)
                }
                is AlarmMoreType.Save -> bookDeleteDialog(bookId = bookId)
            }
        }
        Log.d("ttt", "들어옴")
        dialog.show(childFragmentManager, TAG)
    }

    private fun bookDeleteDialog(bookId: Int) {
        val res = AlertDialogModel(
            title = "이 알림을 삭제할까요?",
            description = "내 알림방에서만 볼 수 없어요",
            positiveContents = "삭제하기",
            negativeContents = "취소"
        )
        val dialog: DefaultRedAlertDialog = DefaultRedAlertDialog(
            alertDialogModel = res,
            clickToPositive = {
                toastMessage("알림을 삭제했습니다.")
                // api
            },
            clickToNegative = {
                toastMessage("아니요")
            }
        )
        dialog.show(childFragmentManager, TAG)
    }
}
