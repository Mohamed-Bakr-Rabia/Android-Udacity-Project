package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.MyViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding


class LoginScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding:FragmentLoginScreenBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login_screen,container,false)

        binding.viewModel = ViewModelProvider(activity as ViewModelStoreOwner)[MyViewModel::class.java]

        return binding.root

    }


}