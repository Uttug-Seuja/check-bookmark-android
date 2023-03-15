package com.o2.check_bookmark_android.ui.books.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookBinding
import com.o2.check_bookmark_android.ui.books.BooksActionHandler
import com.o2.domain.model.Book

class BooksAdapter(
    private val eventListener: BooksActionHandler,
) : ListAdapter<Book, BooksViewHolder>(RecommendationItemDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(
            HolderBookBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                eventListener = this@BooksAdapter.eventListener
            }
        )
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
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