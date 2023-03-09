package com.o2.check_bookmark_android.ui.home.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookmarkStackBinding
import com.o2.domain.model.BookmarkStack
import com.o2.domain.model.BookmarkStacks

class BookmarkStack2ViewHolder(
    private val binding: HolderBookmarkStackBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BookmarkStack) {
        binding.apply {
            holder = item
            executePendingBindings()
        }
    }
}