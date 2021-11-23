package com.example.photoapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Photo
import com.example.photoapp.databinding.OverviewListItem1Binding
import com.example.photoapp.databinding.OverviewListItem2Binding

class ViewHolder1(private val binding: OverviewListItem1Binding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: com.example.domain.Photo) {
        binding.photo = photo
        binding.executePendingBindings()
    }
}

class ViewHolder2(private val binding: OverviewListItem2Binding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: com.example.domain.Photo) {
        binding.photo = photo
        binding.executePendingBindings()
    }
}

class OverviewAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<com.example.domain.Photo, RecyclerView.ViewHolder>(PhotosDiffCallback()) {

    /***
     * Types of views
     */
    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun getItemViewType(position: Int): Int {
        val photo = getItem(position)
        if (photo.id % 2 == 0) {
            return VIEW_TYPE_TWO
        } else if (photo.id % 2 != 0) {
            return VIEW_TYPE_ONE
        }
        return -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_ONE) {
            val binding = OverviewListItem1Binding.inflate(layoutInflater, parent, false)
            ViewHolder1(binding)
        } else {
            val binding = OverviewListItem2Binding.inflate(layoutInflater, parent, false)
            ViewHolder2(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VIEW_TYPE_ONE) {
            val vh1 = holder as ViewHolder1
            configureViewHolder1(vh1, position)
        } else {
            val vh2 = holder as ViewHolder2
            configureViewHolder2(vh2, position)
        }
    }

    /***
     * Helpers to set the proper viewHolders
     */
    private fun configureViewHolder1(vh1: ViewHolder1, position: Int) {
        val photo = getItem(position)
        vh1.itemView.setOnClickListener {
            onClickListener.onClick(position)
        }
        vh1.bind(photo)
    }

    private fun configureViewHolder2(vh2: ViewHolder2, position: Int) {
        val photo = getItem(position)
        vh2.itemView.setOnClickListener {
            onClickListener.onClick(position)
        }
        vh2.bind(photo)
    }
}

class OnClickListener(val clickListener: (position: Int) -> Unit) {
    fun onClick(position: Int) = clickListener(position)
}

class PhotosDiffCallback : DiffUtil.ItemCallback<com.example.domain.Photo>() {
    override fun areItemsTheSame(oldItem: com.example.domain.Photo, newItem: com.example.domain.Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: com.example.domain.Photo, newItem: com.example.domain.Photo): Boolean {
        return oldItem == newItem
    }
}