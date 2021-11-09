package com.example.photoapp.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photoapp.R
import com.example.photoapp.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {
    lateinit var binding: FragmentOverviewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)
        return binding.root
    }
}