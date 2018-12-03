package com.example.kranthikumar.mvvmdemo.data

data class ShoppingItem(val shoppingItem: String,
                        val itemQuantity: String) {
    override fun toString(): String {
        return "$shoppingItem - $itemQuantity"
    }
}