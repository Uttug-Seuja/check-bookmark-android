package com.o2.check_bookmark_android.ui.booksummary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookSummaryBinding
import com.o2.check_bookmark_android.ui.booksummary.BookSummaryActionHandler
import com.o2.domain.model.BookSummary

class BookSummaryAdapter(
    private val eventListener: BookSummaryActionHandler,
) : ListAdapter<BookSummary, BookSummaryViewHolder>(RecommendationItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSummaryViewHolder {
        return BookSummaryViewHolder(
            HolderBookSummaryBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BookSummaryAdapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BookSummaryViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    internal object RecommendationItemDiffCallback : DiffUtil.ItemCallback<BookSummary>() {
        override fun areItemsTheSame(oldItem: BookSummary, newItem: BookSummary) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BookSummary, newItem: BookSummary) =
            oldItem.equals(newItem)
    }
}