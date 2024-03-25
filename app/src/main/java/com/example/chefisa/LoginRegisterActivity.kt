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

class LoginRegisterActivity : AppCompatActivity() {
    private val symbolicUserName = "admin"
    private val symbolicPassword = "admin123"

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
        setContentView(R.layout.activity_login_register)

        val editTextEmailOrUsername = findViewById<EditText>(R.id.editTextEmailOrUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTestPassword)
        val buttonSignIn = findViewById<Button>(R.id.buttonSignIn)
        val textWarning = findViewById<TextView>(R.id.textWarning)

        moveCursorToStartWhenEnterPressed(editTextEmailOrUsername)
        moveCursorToStartWhenEnterPressed(editTextPassword)



        buttonSignIn.setOnClickListener {
            var isSignInSuccessed:Boolean = false
            if(
                (editTextEmailOrUsername.text.toString() == symbolicUserName)
                and (editTextPassword.text.toString() == symbolicPassword)
                ) isSignInSuccessed=true


            if(isSignInSuccessed) {

                Handler(Looper.getMainLooper()).postDelayed({
                    editTextEmailOrUsername.text.clear()
                    editTextPassword.text.clear()
                    textWarning.text = ""
                }, 500)
                Intent(this, MenuActivity::class.java).also { startActivity(it)

                }
            }
            else textWarning.text = getText(R.string.wrongCredentials)


        }

    }
}