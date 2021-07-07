package com.faraday.persistence

import androidx.room.Database
import androidx.room.RoomDatabase

//The first condition is to make the class abstract and extends the RoomDatabase()
@Database(entities = arrayOf(ShoppingModel::class), version = 1)

abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDAO
}