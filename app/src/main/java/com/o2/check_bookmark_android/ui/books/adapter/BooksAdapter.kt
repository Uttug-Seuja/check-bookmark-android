package com.o2.check_bookmark_android.ui.books.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.o2.check_bookmark_android.databinding.HolderBookBinding
import com.o2.check_bookmark_android.ui.books.BooksActionHandler
import com.o2.domain.model.Book
import com.o2.domain.model.BooksMy

class BooksAdapter(
    private val eventListener: BooksActionHandler,
) : ListAdapter<BooksMy, BooksViewHolder>(BooksItemDiffCallback){

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

    internal object BooksItemDiffCallback : DiffUtil.ItemCallback<BooksMy>() {
        override fun areItemsTheSame(oldItem: BooksMy, newItem: BooksMy) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BooksMy, newItem: BooksMy) =
            oldItem.equals(newItem)
    }
}