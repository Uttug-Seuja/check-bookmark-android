package com.o2.check_bookmark_android.ui.bookcreate

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentBookCreateBinding
import com.o2.check_bookmark_android.databinding.FragmentBooksBinding
import com.o2.check_bookmark_android.ui.books.BooksFragmentDirections
import com.o2.check_bookmark_android.ui.books.BooksNavigationAction
import com.o2.domain.model.BookCreate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class BookCreateFragment :
    BaseFragment<FragmentBookCreateBinding, BookCreateViewModel>(R.layout.fragment_book_create) {

    private val TAG = "BookCreateFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_book_create

    override val viewModel: BookCreateViewModel by viewModels()
    private val navController by lazy { findNavController() }
    private val args: BookCreateFragmentArgs by navArgs()

    override fun initStartView() {
        binding.apply {
            this.vm = viewModel
            this.lifecycleOwner = viewLifecycleOwner
            this.ivClose.setOnClickListener { navController.popBackStack() }
        }
        exception = viewModel.errorEvent
        setupEvent()
        viewModel.isCreated.value = args.isCreated
        viewModel.bookId.value = args.bookId

    }

    private fun setupEvent() {
        lifecycleScope.launchWhenStarted {
            viewModel.navigationEvent.collectLatest {
                when (it) {
                    is BookCreateNavigationAction.NavigateToBooks -> navigate(
                        BookCreateFragmentDirections.actionBookCreateFragmentToBookmarksFragment(it.bookId)
                    )
                    is BookCreateNavigationAction.NavigateToBack -> navController.popBackStack()
                }
            }
        }
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
