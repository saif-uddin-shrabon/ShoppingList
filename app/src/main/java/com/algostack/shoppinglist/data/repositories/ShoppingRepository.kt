package com.algostack.shoppinglist.data.repositories

import com.algostack.shoppinglist.data.db.Shocpping_Database
import com.algostack.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: Shocpping_Database
) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItem()
}