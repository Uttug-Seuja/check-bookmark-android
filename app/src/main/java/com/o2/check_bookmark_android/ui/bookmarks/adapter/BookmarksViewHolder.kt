package com.o2.check_bookmark_android.ui.bookmarks.adapter

import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.domain.model.Book
import com.o2.domain.model.Bookmark

class BookmarksViewHolder(
    private val binding: HolderBookmarkBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Bookmark) {
        binding.apply {
            holder = item
            executePendingBindings()
        }
    }
}