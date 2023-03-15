package com.o2.check_bookmark_android.ui.booksummary.adapter

import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookSummaryBinding
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.domain.model.Book

class BookSummaryViewHolder(
    private val binding: HolderBookSummaryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Book) {
        binding.apply {
            holder = item
            executePendingBindings()
        }
    }
}