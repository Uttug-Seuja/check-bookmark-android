package com.o2.check_bookmark_android.util.defaultemotion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.databinding.HolderDefaultEmotionBinding
import com.o2.domain.model.Emotion

var checkedId = 0

class DefaultEmotionAdapter(
    val isCheckedImage: Int,
    private val eventListener: DefaultEmotionActionHandler
) : ListAdapter<Emotion, DefaultEmotionAdapter.ViewHolder>(DefaultEmotionItemDiffCallback){

    init { setHasStableIds(true) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewDataBinding: HolderDefaultEmotionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.holder_default_emotion,
            parent,
            false
        )
        checkedId = isCheckedImage

        viewDataBinding.eventListener = eventListener
        return ViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: HolderDefaultEmotionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Emotion) {
            binding.holder = item
            if(item.id == checkedId) {
                binding.isChecked.visibility = View.VISIBLE
            }
        }
    }

    internal object DefaultEmotionItemDiffCallback : DiffUtil.ItemCallback<Emotion>() {
        override fun areItemsTheSame(oldItem: Emotion, newItem: Emotion) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Emotion, newItem: Emotion) =
            oldItem == newItem
    }
}