package com.example.photoapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.photoapp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        var photoPosition: Int? = DetailFragmentArgs.fromBundle(requireArguments()).photoPosition
        val adapter = DetailAdapter()
        binding.detailView.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })

        /***
         * Snap helper
         */
        val layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.detailView.layoutManager = layoutManager
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.detailView)

        /***
        Checks if the adapter is ready to scroll to the desire position
         *
         */
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