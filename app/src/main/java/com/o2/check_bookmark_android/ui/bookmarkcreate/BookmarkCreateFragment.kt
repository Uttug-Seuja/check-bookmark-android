package com.o2.check_bookmark_android.ui.bookmarkcreate

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookCreateBinding
import com.o2.check_bookmark_android.databinding.FragmentBookmarkCreateBinding
import com.o2.check_bookmark_android.ui.bookcreate.BookCreateFragmentArgs
import com.o2.check_bookmark_android.ui.bookcreate.BookCreateFragmentDirections
import com.o2.check_bookmark_android.ui.bookcreate.BookCreateNavigationAction
import com.o2.check_bookmark_android.util.defaultemotion.DefaultEmotionDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookmarkCreateFragment :
    BaseFragment<FragmentBookmarkCreateBinding, BookmarkCreateViewModel>(R.layout.fragment_bookmark_create) {

    private val TAG = "BookmarkCreateFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_bookmark_create

    override val viewModel: BookmarkCreateViewModel by viewModels()
    private val navController by lazy { findNavController() }
    private val args: BookmarkCreateFragmentArgs by navArgs()

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
            this.ivClose.setOnClickListener { navController.popBackStack() }
        }
        exception = viewModel.errorEvent
        setupEvent()

        viewModel.isCreated.value = args.isCreated
        viewModel.bookmarkId.value = args.bookmarkId


        binding.groupColor.setOnCheckedChangeListener { _, id ->
            viewModel.setColor(
                when (id) {
                    R.id.rb_green -> Color.GREEN
                    R.id.rb_blue -> Color.BLUE
                    R.id.rb_pink -> Color.PINK
                    else -> Color.GREEN
                }
            )
        }
    }

    private fun setupEvent() {
        lifecycleScope.launchWhenStarted {
            viewModel.navigationEvent.collectLatest {
                when (it) {
                    is BookmarkCreateNavigationAction.NavigateToBookmarkDetail -> navigate(
                        BookmarkCreateFragmentDirections.actionBookmarkCreateFragmentToBookmarkDetailFragment(
                            it.bookmarkId
                        )
                    )
                    is BookmarkCreateNavigationAction.NavigateToBack -> navController.popBackStack()
                    is BookmarkCreateNavigationAction.NavigateToEmotionBottomSheet -> emotionBottomSheet(0)
                }
            }
        }
    }

    private fun emotionBottomSheet(
        reaction_id: Int,
    ) {
        val bottomSheet = DefaultEmotionDialog(reaction_id) {
            when (reaction_id) {
                0 -> {
                }
                it -> {
                }
                else -> {

                }
            }

        }
        bottomSheet.show(requireActivity().supportFragmentManager, TAG)
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
