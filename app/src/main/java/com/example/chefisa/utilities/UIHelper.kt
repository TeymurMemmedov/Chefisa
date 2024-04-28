package com.example.chefisa.utilities

import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.widget.EditText

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

    }

}