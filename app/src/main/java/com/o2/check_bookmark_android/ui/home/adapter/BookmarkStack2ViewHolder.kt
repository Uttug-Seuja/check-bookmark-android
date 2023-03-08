package com.depromeet.knockknock.ui.alarmcreate.adapter

import androidx.recyclerview.widget.RecyclerView
import com.depromeet.domain.model.RecommendMessage
import com.depromeet.knockknock.databinding.ItemRecyclerRecommendationMessageBinding

class BookmarkStack2ViewHolder(
    private val binding: ItemRecyclerRecommendationMessageBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RecommendMessage) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}