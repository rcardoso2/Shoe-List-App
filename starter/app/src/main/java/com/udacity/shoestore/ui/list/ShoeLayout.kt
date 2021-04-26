package com.udacity.shoestore.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoeLayout : LinearLayout {
    constructor(context: Context) : super(context)

    private val binding: ShoeItemLayoutBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.shoe_item_layout,
        this,
        false
    )

    fun addShoe(item: Shoe) {
        binding.apply {
            addView(this.root)
            shoeName.text = item.name
            shoeCompany.text = item.company
            shoeSize.text = item.size
            shoeDescription.text = item.description
        }
    }
}