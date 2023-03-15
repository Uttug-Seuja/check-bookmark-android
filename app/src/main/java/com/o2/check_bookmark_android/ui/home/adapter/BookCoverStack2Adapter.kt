package com.o2.check_bookmark_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookmarkStackBinding
import com.o2.check_bookmark_android.ui.home.HomeActionHandler
import com.o2.domain.model.BookCoverStack

class BookCoverStack2Adapter(
    private val eventListener: HomeActionHandler,
) : ListAdapter<BookCoverStack, BookCoverStack2ViewHolder>(BookmarkStack2ItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookCoverStack2ViewHolder {
        return BookCoverStack2ViewHolder(
            HolderBookmarkStackBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookCoverStack2Adapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookCoverStack2ViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    internal object BookmarkStack2ItemDiffCallback : DiffUtil.ItemCallback<BookCoverStack>() {
        override fun areItemsTheSame(oldItem: BookCoverStack, newItem: BookCoverStack) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BookCoverStack, newItem: BookCoverStack) =
            oldItem.equals(newItem)
    }
}