package com.example.photoapp.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.data.database.Photo
import com.example.photoapp.databinding.DetailListItemBinding

class ViewHolder(private val binding: DetailListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: Photo) {
        binding.photo = photo
        binding.executePendingBindings()
    }
}

class DetailAdapter() : ListAdapter<Photo, ViewHolder>(PhotosDiffCallback()) {

    /***
     * Verifies if the adapter is ready
     */
    private val _isReady = MutableLiveData<Boolean?>()
    val isReady: LiveData<Boolean?>
        get() = _isReady

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DetailListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
        _isReady.value = true
    }

    fun setToFalse() {
        _isReady.value = false
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
