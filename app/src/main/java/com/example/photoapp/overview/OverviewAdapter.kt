package com.example.photoapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.photoapp.database.Photo
import com.example.photoapp.databinding.OverviewListItemBinding

class ViewHolder(binding: OverviewListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val photoTitle = binding.photoTitle
}

class OverviewAdapter : ListAdapter<Photo, ViewHolder>(PhotosDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.photoTitle.text = item.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = OverviewListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)

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