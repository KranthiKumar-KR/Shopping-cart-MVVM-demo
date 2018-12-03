package com.example.kranthikumar.mvvmdemo.utilities

import com.example.kranthikumar.mvvmdemo.data.FakeDatabase
import com.example.kranthikumar.mvvmdemo.data.ShoppingCartRepository
import com.example.kranthikumar.mvvmdemo.ui.shoppingcart.ShoppingCartViewModelFactory

object InjectorUtils {

    fun provideShoppingCartViewModelFactory(): ShoppingCartViewModelFactory {
        val shoppingCart = ShoppingCartRepository.getInstance(FakeDatabase.getInstance().shoppingCartDao)
        return ShoppingCartViewModelFactory(shoppingCart)
    }
}