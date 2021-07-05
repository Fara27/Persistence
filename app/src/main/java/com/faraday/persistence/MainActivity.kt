package com.faraday.persistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.button.setOnClickListener {
            val category : String = binding.categoryText.text.toString()
            val description : String = binding.descriptionText.text.toString()

            val shoppingItem = ShoppingModel(category, description)
            myShoppingList.add(shoppingItem)
            //This update your recyclerView
            myShoppingAdapter.notifyDataSetChanged()
        }
    }
}