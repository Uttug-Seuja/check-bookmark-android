package com.o2.check_bookmark_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookmarkStackBinding
import com.o2.check_bookmark_android.ui.books.adapter.BooksViewHolder
import com.o2.check_bookmark_android.ui.home.HomeActionHandler
import com.o2.domain.model.BookmarkStack

class BookmarkStack2Adapter(
    private val eventListener: HomeActionHandler,
) : ListAdapter<BookmarkStack, BookmarkStack2ViewHolder>(BookmarkStack2ItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkStack2ViewHolder {
        return BookmarkStack2ViewHolder(
            HolderBookmarkStackBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookmarkStack2Adapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookmarkStack2ViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    internal object BookmarkStack2ItemDiffCallback : DiffUtil.ItemCallback<BookmarkStack>() {
        override fun areItemsTheSame(oldItem: BookmarkStack, newItem: BookmarkStack) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BookmarkStack, newItem: BookmarkStack) =
            oldItem.equals(newItem)
    }
}