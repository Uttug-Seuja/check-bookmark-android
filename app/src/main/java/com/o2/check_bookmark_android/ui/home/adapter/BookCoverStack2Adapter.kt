package com.o2.check_bookmark_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookCoverStackBinding
import com.o2.check_bookmark_android.ui.home.HomeActionHandler
import com.o2.domain.model.BookHome

class BookCoverStack2Adapter(
    private val eventListener: HomeActionHandler,
) : ListAdapter<BookHome, BookCoverStack2ViewHolder>(BookmarkStack2ItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookCoverStack2ViewHolder {
        return BookCoverStack2ViewHolder(
            HolderBookCoverStackBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookCoverStack2Adapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookCoverStack2ViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    internal object BookmarkStack2ItemDiffCallback : DiffUtil.ItemCallback<BookHome>() {
        override fun areItemsTheSame(oldItem: BookHome, newItem: BookHome) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BookHome, newItem: BookHome) =
            oldItem.equals(newItem)
    }
}