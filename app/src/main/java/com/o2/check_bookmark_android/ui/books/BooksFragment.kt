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
import com.o2.check_bookmark_android.ui.books.bottom.BookMoreType
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
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.navigationEvent.collectLatest {
                when (it) {
                    is BooksNavigationAction.NavigateToBookCreate -> navigate(
                        BooksFragmentDirections.actionBooksFragmentToBookCreateFragment(it.isCreated)
                    )
                    is BooksNavigationAction.NavigateToBookmarks -> navigate(
                        BooksFragmentDirections.actionBooksFragmentToBookmarksFragment(it.bookId)
                    )
                    is BooksNavigationAction.NavigateToBookMoreBottomDialog -> bookMoreBottomDialog(it.bookId)
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
                is BookMoreType.Update -> {
                    viewModel.onBookCreateClicked(isCreated = true)
                }
                is BookMoreType.Delete -> bookDeleteDialog(bookId = bookId)
            }
        }
        Log.d("ttt", "들어옴")
        dialog.show(childFragmentManager, TAG)
    }

    private fun bookDeleteDialog(bookId: Int) {
        val res = AlertDialogModel(
            title = "이 책을 삭제할까요?",
            description = "책을 삭제하면 더이상 볼 수 없어요",
            positiveContents = "삭제하기",
            negativeContents = "취소"
        )
        val dialog: DefaultRedAlertDialog = DefaultRedAlertDialog(
            alertDialogModel = res,
            clickToPositive = {
                toastMessage("책을 삭제했습니다.")
                // api
                viewModel.onBookDeleteClicked(bookId)
            },
            clickToNegative = {
                toastMessage("아니요")
            }
        )
        dialog.show(childFragmentManager, TAG)
    }
}
