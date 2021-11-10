package com.example.photoapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.photoapp.R
import com.example.photoapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application
        binding.lifecycleOwner = this
        val photo = DetailFragmentArgs.fromBundle(requireArguments()).selectedPhoto
        val viewModelFactory = DetailViewModelFactory(photo, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]
        return binding.root
    }
}