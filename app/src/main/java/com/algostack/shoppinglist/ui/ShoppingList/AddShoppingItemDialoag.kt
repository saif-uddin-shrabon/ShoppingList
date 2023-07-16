package com.algostack.shoppinglist.ui.ShoppingList

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import com.algostack.shoppinglist.R
import com.algostack.shoppinglist.data.db.entities.ShoppingItem


class AddShoppingItemDialog(context: Context, private val addDialogListener: AddDialoagListeaner) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_shopping_item) // Replace with your layout XML file

        val tvAdd = findViewById<TextView>(R.id.tvadd)
        val etName = findViewById<EditText>(R.id.etName)
        val tvCancel = findViewById<TextView>(R.id.etCancel)
        val etAmount = findViewById<EditText>(R.id.etAmount)

        tvAdd?.setOnClickListener {
            val name = etName?.text.toString()
            val amount = etAmount?.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel?.setOnClickListener {
            cancel()
        }
    }
}


