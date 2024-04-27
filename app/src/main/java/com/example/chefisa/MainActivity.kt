package com.example.chefisa


import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginStart
import com.example.chefisa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var btnLetsStart:Button
    private lateinit var imgSpoon:ImageView

    private fun slidingAnimationBuilder(slidingAmount:Float):ObjectAnimator{
        val spoonAnimator = ObjectAnimator.ofFloat(
            imgSpoon,
            "translationX",
            slidingAmount
        ).apply {
            duration = 500 // Adjust the duration as needed (milliseconds)
            interpolator = AccelerateDecelerateInterpolator()
        }
        return  spoonAnimator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnLetsStart = binding.btnLetsStart
        imgSpoon  = binding.imgSpoon

            btnLetsStart.setOnClickListener {
                val widthOfLetsStart = btnLetsStart.width
                val widthOfSpoon = imgSpoon.width
                btnLetsStart.text = ""
                val slidingAmount = widthOfLetsStart.toFloat() - (widthOfSpoon*1.5f)
                slidingAnimationBuilder(slidingAmount).start()

                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@MainActivity, LoginRegisterActivity::class.java))
                    finish()
                }, 500)
            }
        }
    }

