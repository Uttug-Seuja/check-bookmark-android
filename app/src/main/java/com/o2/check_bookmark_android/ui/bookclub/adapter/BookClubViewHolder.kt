package com.o2.check_bookmark_android.ui.bookclub.adapter

import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookClubBinding
import com.o2.domain.model.BookClub

class BookClubViewHolder(
    private val binding: HolderBookClubBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BookClub) {
        binding.apply {
            holder = item
            executePendingBindings()
        }
    }
}