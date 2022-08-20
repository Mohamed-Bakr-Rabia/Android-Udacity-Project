package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.models.Shoe
import java.util.ArrayList

class MyViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()

    val shoeList:LiveData<ArrayList<Shoe>>
    get() = _shoeList

    // Dummy Data
    private val arrayList = ArrayList<Shoe>()

    init {

        _shoeList.postValue(arrayList)

    }


    fun navigate(view: View){
        val navController = view.findNavController()
        when(view.id){
            R.id.sign_in , R.id.create_new_account-> navController.navigate(R.id.action_loginScreen_to_welcomeScreen)
            R.id.explore -> navController.navigate(R.id.action_welcomeScreen_to_instructionsScreen)
            R.id.go_to_list -> navController.navigate(R.id.action_instructionsScreen_to_shoeScreen)
            R.id.floating_button -> navController.navigate(R.id.action_shoeScreen_to_shoeDetailScreen)
            R.id.cancel -> navController.popBackStack()
        }

    }

     fun addListItem(view: View, shoe: Shoe) {
        _shoeList.value?.add(shoe)
        view.findNavController().popBackStack()

    }


}