package com.example.chefisa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chefisa.databinding.ActivityLoginRegisterBinding
import com.google.android.material.tabs.TabLayoutMediator

class LoginRegisterActivity : AppCompatActivity() {
    private val symbolicUserName = "admin"
    private val symbolicPassword = "admin123"

    private lateinit var binding:ActivityLoginRegisterBinding

    @RequiresApi(Build.VERSION_CODES.P)

    fun moveCursorToStartWhenEnterPressed(editText: EditText){
        editText.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                editText.setSelection(0)
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

    }

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.vpAuth.adapter = LoginRegisterTabsStateAdapter(this)

//        binding.vpAuth.isUserInputEnabled = false
        TabLayoutMediator(binding.tabLayout,binding.vpAuth){
                tab,position->tab.text = if(position==0) "Sign In" else "Sign Up"
        }.attach()



//        val editTextEmailOrUsername = findViewById<EditText>(R.id.evEmailOrUsername)
//        val editTextPassword = findViewById<EditText>(R.id.evPassword)
//        val buttonSignIn = findViewById<Button>(R.id.buttonSignIn)
//        val textWarning = findViewById<TextView>(R.id.textWarning)
//
//        moveCursorToStartWhenEnterPressed(editTextEmailOrUsername)
//        moveCursorToStartWhenEnterPressed(editTextPassword)
//
//
//
//        buttonSignIn.setOnClickListener {
//            var isSignInSuccessed:Boolean = false
//            if(
//                (editTextEmailOrUsername.text.toString() == symbolicUserName)
//                and (editTextPassword.text.toString() == symbolicPassword)
//                ) isSignInSuccessed=true
//
//
//            if(isSignInSuccessed) {
//
//                Handler(Looper.getMainLooper()).postDelayed({
//                    editTextEmailOrUsername.text.clear()
//                    editTextPassword.text.clear()
//                    textWarning.text = ""
//                }, 500)
//                Intent(this, MenuActivity::class.java).also { startActivity(it)
//
//                }
//            }
//            else textWarning.text = getText(R.string.wrongCredentials)
//
//
//        }

    }
}