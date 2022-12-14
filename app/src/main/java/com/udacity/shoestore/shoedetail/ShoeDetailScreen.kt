package com.udacity.shoestore.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.udacity.shoestore.MyViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailScreenBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailScreen : Fragment() {
    lateinit var  viewModel:MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeDetailScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail_screen,container,false
        )
        viewModel = ViewModelProvider(activity as ViewModelStoreOwner)[MyViewModel::class.java]
        binding.viewModel =  viewModel
        binding.shoe = Shoe(name = "", size = "", company = "", description = "")
        val shoe = binding.shoe
        binding.save.setOnClickListener{ view->
            viewModel.addListItem(view,shoe!!)
        }
        return binding.root
    }

}

