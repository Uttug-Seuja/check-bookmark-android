package com.o2.check_bookmark_android.ui.myfavorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookClubBinding
import com.o2.check_bookmark_android.databinding.HolderMyFavoriteBinding
import com.o2.check_bookmark_android.ui.bookclub.BookClubActionHandler
import com.o2.check_bookmark_android.ui.myfavorite.MyFavoriteActionHandler
import com.o2.domain.model.BookClub

class MyFavoriteAdapter(
    private val eventListener: MyFavoriteActionHandler,
) : ListAdapter<BookClub, MyFavoriteViewHolder>(BookClubItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFavoriteViewHolder {
        return MyFavoriteViewHolder(
            HolderMyFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@MyFavoriteAdapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: MyFavoriteViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    internal object BookClubItemDiffCallback : DiffUtil.ItemCallback<BookClub>() {
        override fun areItemsTheSame(oldItem: BookClub, newItem: BookClub) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BookClub, newItem: BookClub) =
            oldItem.equals(newItem)
    }
}