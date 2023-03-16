package com.o2.check_bookmark_android.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookCoverStackBinding
import com.o2.domain.model.BookCoverStack

class BookCoverStack2ViewHolder(
    private val binding: HolderBookCoverStackBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BookCoverStack) {
        binding.apply {
            holder = item
            executePendingBindings()
        }
    }
}