package com.example.photoapp.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.photoapp.MainActivity
import com.example.photoapp.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    var viewModel: OverviewViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverviewBinding.inflate(inflater)
        viewModel =
            (requireActivity() as MainActivity).appContainer.overviewContainer?.overviewViewModelFactory?.create()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val adapter = OverviewAdapter(OnClickListener {
            viewModel?.displayPhotoDetails(it)
        })
        binding.photosView.adapter = adapter
        viewModel?.photos?.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })

        /***
         * Controls navigation passing the current photo position
         */
        viewModel?.navigateToSelectedPhoto?.observe(viewLifecycleOwner, {
            if (it != null) {
                this.findNavController()
                    .navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel?.displayPhotoDetailsComplete()
            }
        })
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel?.fetchPhotos()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }
}