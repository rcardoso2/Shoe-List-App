package com.udacity.shoestore.ui.list

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {


    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _onSaved = MutableLiveData<Boolean>()
    val onSaved: LiveData<Boolean>
        get() = _onSaved

    init {
        _onSaved.value = false
    }

    private fun addShoeToList(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }

    fun saveEvent(name: String, company: String, size: String, description: String) {
        if (name.isEmpty() || company.isEmpty() || size.isEmpty()) {
            _onSaved.value = false
        } else {
            addShoeToList(
                Shoe(name, size, company, description)
            )
            _onSaved.value = true
        }
    }

    fun saveCompleted() {
        _onSaved.value = false
    }
}