package com.o2.check_bookmark_android.ui.booksummary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookmarkBinding
import com.o2.check_bookmark_android.ui.bookmarks.BookmarksActionHandler
import com.o2.domain.model.Book

class BookSummaryAdapter(
    private val eventListener: BookmarksActionHandler,
) : ListAdapter<Book, BookSummaryViewHolder>(RecommendationItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSummaryViewHolder {
        return BookSummaryViewHolder(
            HolderBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookSummaryAdapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookSummaryViewHolder, position: Int) {
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