package com.example.kranthikumar.mvvmdemo.ui.shoppingcart

import androidx.lifecycle.ViewModel
import com.example.kranthikumar.mvvmdemo.data.ShoppingItem
import com.example.kranthikumar.mvvmdemo.data.ShoppingCartRepository

/**
 * Created by Kranthi Kumar on 12/02/2018
 * This ViewModel fetches most recent data from Repository or Model and updates the UI.
 * This follows View's life cycle, ViewModel will be destroyed when activity or fragment is destroyed.
 * but it is independent of configuration change (like Orientation etc)
 */
class ShoppingCartViewModel(private val shoppingCartRepository: ShoppingCartRepository) : ViewModel() {
    fun getShoppingItems() = shoppingCartRepository.getShoppingItems()

    fun addShoppingItems(shoppingItem: ShoppingItem) = shoppingCartRepository.addShoppingItem(shoppingItem)
}