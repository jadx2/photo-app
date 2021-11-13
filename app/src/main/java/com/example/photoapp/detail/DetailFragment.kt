package com.example.photoapp.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import com.example.photoapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    lateinit var viewModel: DetailViewModel
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application

        binding.lifecycleOwner = this

        var photoPosition: Int? = DetailFragmentArgs.fromBundle(requireArguments()).photoPosition

        val viewModelFactory = DetailViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]

        val adapter = DetailAdapter()
        binding.detailView.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })

        val layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.detailView.layoutManager = layoutManager
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.detailView)

        adapter.isReady.observe(viewLifecycleOwner, {
            if (it == true) {
                photoPosition?.let {
                    binding.detailView.smoothScrollToPosition(photoPosition!!)
                }
                photoPosition = null
            }
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchPhotos()
            binding.swipeRefreshLayout.isRefreshing = false
        }
        return binding.root
    }
}