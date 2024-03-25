package com.example.chefisa


import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginStart

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgViewRectangle: ImageView = findViewById(R.id.imgViewRectanglee)
        val imgViewSpoon: ImageView = findViewById(R.id.imgViewSpoon)
        val txtViewLetsStart: TextView = findViewById(R.id.txtViewLetsStart)

        imgViewRectangle.setOnClickListener {
            txtViewLetsStart.visibility = View.INVISIBLE

            val spoonAnimator = ObjectAnimator.ofFloat(
                imgViewSpoon,
                "translationX",
                imgViewRectangle.width.toFloat() - (imgViewSpoon.width + imgViewSpoon.marginStart + 16)
            ).apply {
                duration = 500 // Adjust the duration as needed (milliseconds)
                interpolator = AccelerateDecelerateInterpolator()
                start()
            }


            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, LoginRegisterActivity::class.java))
                finish()
            }, 500)
        }
    }

}
