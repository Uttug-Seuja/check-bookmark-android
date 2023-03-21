package com.o2.check_bookmark_android.ui.myfavorite.adapter

import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookClubBinding
import com.o2.check_bookmark_android.databinding.HolderMyFavoriteBinding
import com.o2.domain.model.BookClub

class MyFavoriteViewHolder(
    private val binding: HolderMyFavoriteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BookClub) {
        binding.apply {
            holder = item
            executePendingBindings()
        }
    }
}