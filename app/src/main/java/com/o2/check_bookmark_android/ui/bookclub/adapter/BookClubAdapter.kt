package com.o2.check_bookmark_android.ui.bookclub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookClubBinding
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.check_bookmark_android.ui.bookclub.BookClubActionHandler
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksActionHandler
import com.o2.domain.model.Book
import com.o2.domain.model.BookClub

class BookClubAdapter(
    private val eventListener: BookClubActionHandler,
) : ListAdapter<BookClub, BookClubViewHolder>(BookClubItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookClubViewHolder {
        return BookClubViewHolder(
            HolderBookClubBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookClubAdapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookClubViewHolder, position: Int) {
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