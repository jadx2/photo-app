package com.example.photoapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.photoapp.database.Photo
import com.example.photoapp.databinding.OverviewListItemBinding

class ViewHolder(private val binding: OverviewListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: Photo) {
        binding.photo = photo
        binding.executePendingBindings()
    }
}

class OverviewAdapter(private val onClickListener: OnClickListener) : ListAdapter<Photo, ViewHolder>(PhotosDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(photo)
        }
        holder.bind(photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = OverviewListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    class OnClickListener(val clickListener: (photo: Photo) -> Unit) {
        fun onClick(photo: Photo) = clickListener(photo)
    }
}

class PhotosDiffCallback : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}