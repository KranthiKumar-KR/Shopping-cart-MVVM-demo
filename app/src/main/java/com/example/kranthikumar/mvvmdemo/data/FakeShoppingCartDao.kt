package com.example.kranthikumar.mvvmdemo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by Kranthi Kumar on 12/02/2018
 * This Database access objects maintains the actual data whether from Web API or local SQLite
 * This also pumps the recent data into LiveData observables
 */
class FakeShoppingCartDao {
    private val shoppingItemsList = mutableListOf<ShoppingItem>()
    private val shoppingItems = MutableLiveData<List<ShoppingItem>>()

    init {
        shoppingItems.value = shoppingItemsList
    }

    fun addItemToCart(shoppingItem: ShoppingItem) {
        shoppingItemsList.add(shoppingItem)
        shoppingItems.value = shoppingItemsList
    }

    fun getItemsInCart() = shoppingItems as LiveData<List<ShoppingItem>>
}