package com.example.photoapp.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.photoapp.R
import com.example.photoapp.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {
    lateinit var binding: FragmentOverviewBinding
    lateinit var viewModel: OverviewViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)
        val application = requireNotNull(this.activity).application
        val viewModelFactory = OverviewViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[OverviewViewModel::class.java]
        binding.lifecycleOwner = this
        binding.overviewViewModel = viewModel
        val adapter = OverviewAdapter()
        binding.photosList.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}