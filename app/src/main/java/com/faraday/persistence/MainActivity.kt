package com.faraday.persistence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.faraday.persistence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
    //Create a mutable list of shopping items. Its a list you can add items to dynamically.
    //The items will be displayed from the database
    private lateinit var myShoppingList: MutableList<ShoppingModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Pass the shopping list
        myShoppingList = mutableListOf()

        myShoppingAdapter = ShoppingAdapter(myShoppingList)
        binding.recyclerView.adapter = myShoppingAdapter


        val db = Room.databaseBuilder(
            applicationContext,
            ShoppingDatabase::class.java, "shopping-database"
        ).allowMainThreadQueries().build()

        val shoppingDAO = db.shoppingDao()

        shoppingDAO.getAllShoppingItems().observe(this, {
            myShoppingAdapter = ShoppingAdapter(it)
            binding.recyclerView.adapter = myShoppingAdapter

            myShoppingAdapter.notifyDataSetChanged()

        })


        binding.button.setOnClickListener {
            val category : String = binding.categoryText.text.toString()
            val description : String = binding.descriptionText.text.toString()

            val shoppingItem = ShoppingModel(category, description)
            shoppingDAO.addShoppingItem(shoppingItem)


            //This update your recyclerView
            myShoppingAdapter.notifyDataSetChanged()
        }


    }
}