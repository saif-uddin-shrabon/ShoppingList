package com.algostack.shoppinglist.ui.ShoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algostack.shoppinglist.R
import com.algostack.shoppinglist.data.db.Shocpping_Database
import com.algostack.shoppinglist.data.db.entities.ShoppingItem
import com.algostack.shoppinglist.data.repositories.ShoppingRepository
import com.algostack.shoppinglist.other.ShoppingItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val floatButton = findViewById<FloatingActionButton>(R.id.feb)

        val database = Shocpping_Database(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        // Set the adapter on the existing RecyclerView from the XML layout
        val rvShoppingItem = findViewById<RecyclerView>(R.id.shoppingItem)
        rvShoppingItem.layoutManager = LinearLayoutManager(this)
        rvShoppingItem.adapter = adapter


        viewModel.gelAllShoppingItem().observe(this, Observer {

            adapter.items = it
            adapter.notifyDataSetChanged()

        })

        floatButton.setOnClickListener {
            AddShoppingItemDialog(this,object : AddDialoagListeaner{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}