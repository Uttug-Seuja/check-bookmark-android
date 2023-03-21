package com.o2.check_bookmark_android.ui.myfavorite

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.base.BaseFragment
import com.o2.check_bookmark_android.databinding.FragmentMyFavoriteBinding
import com.o2.check_bookmark_android.ui.bookclub.adapter.BookClubAdapter
import com.o2.check_bookmark_android.ui.myfavorite.adapter.MyFavoriteAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class MyFavoriteFragment :
    BaseFragment<FragmentMyFavoriteBinding, MyFavoriteViewModel>(R.layout.fragment_my_favorite) {

    private val TAG = "MyFavoriteFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_my_favorite

    override val viewModel: MyFavoriteViewModel by viewModels()
    private val myFavoriteAdapter by lazy { MyFavoriteAdapter(viewModel) }

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
                    is MyFavoriteNavigationAction.NavigateToBookSummary -> navigate(
                        MyFavoriteFragmentDirections.actionMyFavoriteFragmentToBookSummaryFragment(it.bookSummaryId)
                    )
                }
            }
        }
    }

    private fun initAdapter() {
        binding.rvMyFavorite.adapter = myFavoriteAdapter
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}
