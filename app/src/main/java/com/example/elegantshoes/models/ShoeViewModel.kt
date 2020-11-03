package com.example.elegantshoes.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elegantshoes.R

class ShoeViewModel : ViewModel() {

    private val shoeList: MutableList<Shoe> = mutableListOf(
        Shoe(
            "First Shoes", 8.5, "TimberLand",
            "oil resistance", R.drawable.android_shoes
        )
    )

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name


    private val _size = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _size

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    init {

    }

    fun addNewShoes(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description, R.drawable.android_shoes)
        shoeList.add(shoe)
    }
}