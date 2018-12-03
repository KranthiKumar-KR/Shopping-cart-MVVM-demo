package com.example.kranthikumar.mvvmdemo.data

/**
 * Created by Kranthi Kumar on 12/02/2018
 * This Repository acts as bridge between all the Database Access objects and the View models.
 * It is suggested that we place a Repository between ViewModel and Model(database)
 * Repository can also manage multiple Data Access objects and perform certain operations to provide
 * required data to the view model.
 */
class ShoppingCartRepository private constructor(private val shoppingCartDao: FakeShoppingCartDao) {

    fun addShoppingItem(shoppingItem: ShoppingItem) {
        shoppingCartDao.addItemToCart(shoppingItem)
    }

    fun getShoppingItems() =  shoppingCartDao.getItemsInCart()

    companion object {
        @Volatile
        private var instance: ShoppingCartRepository? = null

        fun getInstance(shoppingCartDao: FakeShoppingCartDao) =
            instance ?: synchronized(this) {
                instance ?: ShoppingCartRepository(shoppingCartDao).also { instance = it }
            }
    }
}