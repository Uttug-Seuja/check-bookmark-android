package com.o2.check_bookmark_android.ui.bookclub.adapter

import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.domain.model.Book

class BookClubViewHolder(
    private val binding: HolderBookmarkBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Book) {
        binding.apply {
            holder = item
            executePendingBindings()
        }
    }
}