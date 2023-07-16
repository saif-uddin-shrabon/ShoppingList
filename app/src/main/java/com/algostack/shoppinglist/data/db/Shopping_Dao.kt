package com.algostack.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.algostack.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface Shopping_Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("Select * From shopping_item")
    fun getAllShoppingItem() : LiveData<List<ShoppingItem>>

}