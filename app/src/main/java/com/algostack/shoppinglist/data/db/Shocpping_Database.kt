package com.algostack.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.algostack.shoppinglist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract  class Shocpping_Database: RoomDatabase() {

    abstract fun getShoppingDao() : Shopping_Dao


    companion object{

        @Volatile
        private var instance: Shocpping_Database? = null
        private val Lock = Any()

        operator fun invoke(contex: Context) = instance ?: synchronized(Lock){
            instance ?: createDatabase(contex).also { instance = it }
        }

        private fun createDatabase(contex: Context) =
            Room.databaseBuilder(contex.applicationContext,
            Shocpping_Database::class.java, "ShoppingDB.db").build()

    }

}