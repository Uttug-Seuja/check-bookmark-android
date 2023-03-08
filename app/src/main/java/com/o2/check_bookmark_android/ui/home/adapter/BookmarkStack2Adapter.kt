package com.o2.check_bookmark_android.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.depromeet.knockknock.ui.alarmcreate.adapter.BookmarkStack2ViewHolder
import com.o2.check_bookmark_android.databinding.HolderBookmarkStackBinding
import com.o2.check_bookmark_android.ui.home.HomeActionHandler
import com.o2.domain.model.BookmarkStacks

class BookmarkStack2Adapter(
    private val eventListener: HomeActionHandler,
) : ListAdapter<BookmarkStacks, BookmarkStack2ViewHolder>(RecommendationItemDiffCallback){

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

    internal object RecommendationItemDiffCallback : DiffUtil.ItemCallback<BookmarkStacks>() {
        override fun areItemsTheSame(oldItem: BookmarkStacks, newItem: BookmarkStacks) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BookmarkStacks, newItem: BookmarkStacks) =
            oldItem.equals(newItem)
    }
}