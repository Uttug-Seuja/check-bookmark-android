package com.o2.check_bookmark_android.ui.bookmarkdetail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.AlertDialogModel
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.base.DefaultRedAlertDialog
import com.o2.check_bookmark_android.databinding.FragmentBookmarkDetailBinding
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksFragmentDirections
import com.o2.check_bookmark_android.ui.books.bottom.AlarmMoreType
import com.o2.check_bookmark_android.ui.books.bottom.BottomBookMore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookmarkDetailFragment :
    BaseFragment<FragmentBookmarkDetailBinding, BookmarkDetailViewModel>(R.layout.fragment_bookmark_detail) {

    private val TAG = "BookmarkDetailFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_bookmark_detail

    override val viewModel: BookmarkDetailViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        exception = viewModel.errorEvent
        setupEvent()
        initToolbar()
    }

    private fun setupEvent() {
        lifecycleScope.launchWhenStarted {
            viewModel.navigationEvent.collectLatest {
                when (it) {
                    is BookmarkDetailNavigationAction.NavigateToBookmarkMoreBottomDialog -> bookMoreBottomDialog(
                        0
                    )
                    is BookmarkDetailNavigationAction.NavigateToBookmarkCreate -> navigate(
                        BookmarkDetailFragmentDirections.actionBookmarkDetailFragmentToBookmarkCreateFragment(
                            true
                        )
                    )
                }
            }
        }
    }

    private fun initToolbar() {
        with(binding.toolbar) {
            // 뒤로가기 버튼
            this.setNavigationIcon(R.drawable.ic_allow_back)
            this.setNavigationOnClickListener { navController.popBackStack() }
        }
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
                    viewModel.onBookmarkCreateClicked()
                }
                is AlarmMoreType.Save -> bookDeleteDialog(bookId = bookId)
            }
        }
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
