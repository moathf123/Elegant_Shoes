package com.example.elegantshoes.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elegantshoes.R

class ShoeViewModel : ViewModel() {

    val list = mutableListOf<Shoe>()
    val editTextName = MutableLiveData<String>()
    val editTextCompany = MutableLiveData<String>()
    val editTextDescription = MutableLiveData<String>()
    val editTextSize = MutableLiveData<String>()

    private val _newItemBeenAdded = MutableLiveData<Boolean>()
    val newItemBeenAdded: LiveData<Boolean>
        get() = _newItemBeenAdded

    private val _itemCanceled = MutableLiveData<Boolean>()
    val itemCanceled: LiveData<Boolean>
        get() = _itemCanceled

    init {
        _newItemBeenAdded.value = false
        _itemCanceled.value = false
    }

    fun onSaveClicked() {
        val shoe = Shoe(
            editTextName.value.toString(),
            editTextSize.value?.toDouble()!!,
            editTextCompany.value.toString(),
            editTextDescription.value.toString(),
            R.drawable.android_shoes
        )
        list.add(shoe)
        _newItemBeenAdded.value = true
    }

    fun newItemCompleted() {
        _newItemBeenAdded.value = false
    }

    fun onCancelClicked() {
        _itemCanceled.value = true
    }
}
