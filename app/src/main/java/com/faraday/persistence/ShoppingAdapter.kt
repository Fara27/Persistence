package com.faraday.persistence

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faraday.persistence.databinding.ActivityMainBinding
import com.faraday.persistence.databinding.ShoppingItemBinding

class ShoppingAdapter(
    private val shoppingItems: List<ShoppingModel>
    ) : RecyclerView.Adapter<ShoppingAdapter.ViewHolder> (){


    inner class  ViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(shoppingItem : ShoppingModel){
            binding.category.text = shoppingItem.category
            binding.description.text = shoppingItem.description

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: ShoppingItemBinding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(shoppingItems.get(position))
    }

    override fun getItemCount() = shoppingItems.size
}