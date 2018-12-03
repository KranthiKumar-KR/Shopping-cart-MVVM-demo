package com.example.kranthikumar.mvvmdemo.ui.shoppingcart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kranthikumar.mvvmdemo.data.ShoppingCartRepository

class ShoppingCartViewModelFactory(private val shoppingCartRepository: ShoppingCartRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingCartViewModel(shoppingCartRepository) as T
    }
}