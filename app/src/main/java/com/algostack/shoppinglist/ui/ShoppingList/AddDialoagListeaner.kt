package com.algostack.shoppinglist.ui.ShoppingList

import com.algostack.shoppinglist.data.db.entities.ShoppingItem

interface AddDialoagListeaner {
    fun onAddButtonClicked(item: ShoppingItem)
}