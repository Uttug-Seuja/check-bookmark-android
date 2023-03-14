package com.o2.check_bookmark_android.ui.bookclub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksActionHandler
import com.o2.domain.model.Book

class BookClubAdapter(
    private val eventListener: BookmarksActionHandler,
) : ListAdapter<Book, BookClubViewHolder>(RecommendationItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookClubViewHolder {
        return BookClubViewHolder(
            HolderBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookClubAdapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookClubViewHolder, position: Int) {
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