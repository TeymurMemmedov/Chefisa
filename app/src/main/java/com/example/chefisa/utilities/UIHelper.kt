package com.example.chefisa.utilities

import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.chefisa.R

class UIHelper {

    companion object{
        fun moveCursorToStartWhenEnterPressed(editText: EditText){
            editText.setOnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                    editText.setSelection(0)
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }

        }

         fun executeDelayed(delayMillis: Long, task: () -> Unit) {
            Handler(Looper.getMainLooper()).postDelayed(task, delayMillis)
        }

        fun hideShowPassword(ev:EditText,btn: ImageButton){
            val currentType = ev.inputType
            val typ = ev.typeface

            val newType = when (currentType) {
                InputType.TYPE_CLASS_TEXT or  InputType.TYPE_TEXT_VARIATION_PASSWORD -> {
                    btn.setImageResource(R.drawable.visibility_off)
                    InputType.TYPE_CLASS_TEXT
                }
                InputType.TYPE_CLASS_TEXT ->  {
                    btn.setImageResource(R.drawable.visibility)
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
                else -> currentType
            }

            ev.inputType = newType

            //Normal text input->monospace
            //Password text input->Sans Serif

            //Cevrilmeler zamani ölçü dəyişir deyə bu əməliyyat edilir.

            val typef = ev.typeface

            val font = if (newType == InputType.TYPE_CLASS_TEXT) {
                // Use a fixed-width font for normal text input
                android.graphics.Typeface.DEFAULT
            } else {
                // Use the default font for password input
                android.graphics.Typeface.DEFAULT
            }
            ev.typeface = android.graphics.Typeface.create(font, android.graphics.Typeface.NORMAL)


        }

    }

}