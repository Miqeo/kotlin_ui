package com.example.ui_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui_test.databinding.FragmentAddonBinding



class AddonFragment : Fragment() {

    private var _binding: FragmentAddonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddonBinding.inflate(inflater, container, false)
        return binding.root
    }


}