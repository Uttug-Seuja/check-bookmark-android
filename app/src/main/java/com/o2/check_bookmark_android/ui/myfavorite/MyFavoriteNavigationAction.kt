package com.o2.check_bookmark_android.ui.myfavorite

sealed class MyFavoriteNavigationAction {
    class NavigateToBookSummary(val bookSummaryId: Int): MyFavoriteNavigationAction()
}