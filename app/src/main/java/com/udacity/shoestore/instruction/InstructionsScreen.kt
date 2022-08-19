package com.udacity.shoestore.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.Navigation
import com.udacity.shoestore.MyViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsScreenBinding
import com.udacity.shoestore.databinding.FragmentShoeScreenBinding

class InstructionsScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding : FragmentInstructionsScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions_screen,container,false
        )

        binding.viewModel = ViewModelProvider(activity as ViewModelStoreOwner)[MyViewModel::class.java]

        return binding.root
    }


}