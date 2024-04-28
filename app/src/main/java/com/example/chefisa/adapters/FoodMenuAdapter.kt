package com.example.chefisa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chefisa.models.FoodItem
import com.example.chefisa.R

class FoodMenuAdapter(private val context: Context, private val foodList: List<FoodItem>) : RecyclerView.Adapter<FoodMenuAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewFood: ImageView = itemView.findViewById(R.id.imgFood)
        val textViewFoodName: TextView = itemView.findViewById(R.id.tvFoodName)
        val textViewPrice: TextView = itemView.findViewById(R.id.tvFoodPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodList[position]
        holder.imageViewFood.setImageResource(foodItem.imageResource)
        holder.textViewFoodName.text = foodItem.name
        holder.textViewPrice.text = "$${foodItem.price}"
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}
