package com.algostack.shoppinglist.ui.ShoppingList

import androidx.lifecycle.ViewModel
import com.algostack.shoppinglist.data.db.entities.ShoppingItem
import com.algostack.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
       repository.upsert(item)
    }

    fun delete (item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun gelAllShoppingItem() = repository.getAllShoppingItems()

}