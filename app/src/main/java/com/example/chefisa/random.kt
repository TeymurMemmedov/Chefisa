//package com.example.chefisa
//
//import android.animation.ObjectAnimator
//import android.os.Bundle
//import android.view.animation.AccelerateDecelerateInterpolator
//import android.widget.ImageView
//import android.widget.TextView
//import kotlinx.coroutines.NonCancellable.start
//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
//
//    val imgViewRectangle: ImageView = findViewById(R.id.imgViewRectanglee)
//    val imgViewSpoon: ImageView = findViewById(R.id.imgViewSpoon)
//    val txtViewLetsStart: TextView = findViewById(R.id.txtViewLetsStart)
//
//    imgViewRectangle.setOnClickListener {
//        // Animate spoon icon sliding to the right
//        val spoonAnimator = ObjectAnimator.ofFloat(
//            imgViewSpoon, "translationX", imgViewRectangle.width.toFloat() + 24
//        ).apply {
//            duration = 1000 // Adjust the duration as needed (milliseconds)
//            interpolator = AccelerateDecelerateInterpolator()
//            start()
//        }
//
//        // Animate text view moving based on spoon icon's position
//        val textViewAnimator = ObjectAnimator.ofFloat(
//            txtViewLetsStart, "translationX", imgViewRectangle.width.toFloat() + imgViewSpoon.width + 144
//        ).apply {
//            duration = 1000 // Adjust the duration as needed (milliseconds)
//            interpolator = AccelerateDecelerateInterpolator()
//            start()
//        }
//    }
//}