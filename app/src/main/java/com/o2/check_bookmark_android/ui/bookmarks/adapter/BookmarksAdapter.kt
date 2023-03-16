package com.o2.check_bookmark_android.ui.bookmarks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksActionHandler
import com.o2.domain.model.Book
import com.o2.domain.model.Bookmark

class BookmarksAdapter(
    private val eventListener: BookmarksActionHandler,
) : ListAdapter<Bookmark, BookmarksViewHolder>(BookmarkItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksViewHolder {
        return BookmarksViewHolder(
            HolderBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookmarksAdapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookmarksViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    internal object BookmarkItemDiffCallback : DiffUtil.ItemCallback<Bookmark>() {
        override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Bookmark, newItem: Bookmark) =
            oldItem.equals(newItem)
    }
}