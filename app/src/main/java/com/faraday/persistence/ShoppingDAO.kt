package com.faraday.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface ShoppingDAO {
    //Create a function to add items to our database
    @Insert
    fun addShoppingItem(shoppingItem: ShoppingModel)

    //Get all the items in our database
    @Query("SELECT * FROM shoppingmodel")
    fun getAllShoppingItems(): LiveData<List<ShoppingModel>>
    //Delete an item from the database
    @Delete
    fun delete(shoppingItem: ShoppingModel)
}