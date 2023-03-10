package com.o2.check_bookmark_android.ui.bookmarks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksActionHandler
import com.o2.domain.model.Book

class BookmarksAdapter(
    private val eventListener: BookmarksActionHandler,
) : ListAdapter<Book, BookmarksViewHolder>(RecommendationItemDiffCallback){

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

    internal object RecommendationItemDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Book, newItem: Book) =
            oldItem.equals(newItem)
    }
}