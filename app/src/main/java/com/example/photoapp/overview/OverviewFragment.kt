package com.example.photoapp.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.photoapp.R
import com.example.photoapp.databinding.FragmentOverviewBinding
import com.example.photoapp.databinding.OverviewListItemBinding

class OverviewFragment : Fragment() {

    lateinit var viewModel: OverviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application
        val viewModelFactory = OverviewViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[OverviewViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val adapter = OverviewAdapter()
        binding.photosGrid.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })
        return binding.root
    }
}