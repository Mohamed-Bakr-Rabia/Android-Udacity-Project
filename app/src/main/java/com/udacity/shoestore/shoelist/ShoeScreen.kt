package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.MyViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeScreenBinding
import com.udacity.shoestore.databinding.ListItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeScreen : Fragment() {
    private lateinit var viewModel: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_screen,container,false
        )
        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(activity as ViewModelStoreOwner)[MyViewModel::class.java]

        binding.viewModel = viewModel

        viewModel.shoeList.observe(viewLifecycleOwner) { showList ->
            showList.forEachIndexed{ index,shoe ->
                binding.listLayout.addView(createView(shoe),index)
            }
        }
        return binding.root
    }




    private fun createView(shoe: Shoe): View? {
        val view:View = View.inflate(context,R.layout.list_item,null)
        val binding:ListItemBinding? = DataBindingUtil.bind(view)
        binding!!.shoe = shoe
        return view
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

       // val boolean = NavigationUI.onNavDestinationSelected(item, requireView().findNavController())

        return requireView().findNavController().popBackStack(R.id.loginScreen,false)
                || super.onOptionsItemSelected(item)
    }



}