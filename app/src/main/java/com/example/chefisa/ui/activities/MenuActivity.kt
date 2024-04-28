package com.example.chefisa.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chefisa.R
import com.example.chefisa.adapters.FoodMenuAdapter
import com.example.chefisa.models.FoodItem

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val recyclerViewMenu = findViewById<RecyclerView>(R.id.rvFoods)
        val foodList = listOf(
            FoodItem("Pizza", R.drawable.pizzaphoto, "3.50"),
            FoodItem("Burger", R.drawable.burgerphoto, "2.50"),
            FoodItem("Nuggets", R.drawable.nuggetphoto, "3.00"),
            FoodItem("Tacos", R.drawable.tacophoto, "1.50"),
            FoodItem("Drinks", R.drawable.drinkphoto, "1.50"),
            FoodItem("Pizza", R.drawable.pizzaphoto, "3.50"),
            FoodItem("Burger", R.drawable.burgerphoto, "2.50"),
            FoodItem("Nuggets", R.drawable.nuggetphoto, "3.00"),
            FoodItem("Tacos", R.drawable.tacophoto, "1.50"),
            FoodItem("Drinks", R.drawable.drinkphoto, "1.50"),
            FoodItem("Pizza", R.drawable.pizzaphoto, "3.50"),
            FoodItem("Burger", R.drawable.burgerphoto, "2.50"),
            FoodItem("Nuggets", R.drawable.nuggetphoto, "3.00"),
            FoodItem("Tacos", R.drawable.tacophoto, "1.50"),
            FoodItem("Drinks", R.drawable.drinkphoto, "1.50"),


            // Add more food items as needed
        )

        val layoutManager = GridLayoutManager(this,3)
        val adapter = FoodMenuAdapter(this, foodList)

        recyclerViewMenu.layoutManager = layoutManager
        recyclerViewMenu.adapter = adapter
    }
}