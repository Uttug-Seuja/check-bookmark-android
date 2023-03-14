package com.o2.check_bookmark_android.ui.books.adapter

import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.databinding.HolderBookBinding
import com.o2.check_bookmark_android.databinding.HolderBookmarkStackBinding
import com.o2.domain.model.Book
import com.o2.domain.model.BookmarkStack
import com.o2.domain.model.Books

class BooksViewHolder(
    private val binding: HolderBookBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Book) {
        binding.apply {
            holder = item
            executePendingBindings()

            pbBookListPercent.max = 150
            pbBookListPercent.progress = 50
            tvBookListPercent.text = ((50 / 150f * 100).toInt()).toString()

        }
    }
}