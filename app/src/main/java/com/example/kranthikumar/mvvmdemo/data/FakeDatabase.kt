package com.example.kranthikumar.mvvmdemo.data

/**
 * Created by Kranthi Kumar on 12/02/2018
 * This Database holds access to all Database access objects
 */
class FakeDatabase private constructor() {

    var shoppingCartDao = FakeShoppingCartDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}