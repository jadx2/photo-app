package com.example.photoapp.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.photoapp.databinding.FragmentOverviewBinding

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
        val adapter = OverviewAdapter(OnClickListener {
            viewModel.displayPhotoDetails(it)
        })
        binding.photosGrid.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })
        viewModel.navigateToSelectedPhoto.observe(viewLifecycleOwner, {
            if (it != null) {
                this.findNavController()
                    .navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel.displayPhotoDetailsComplete()
            }
        })
        binding.swipeRefreshLayout.setOnRefreshListener {
            Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }
}