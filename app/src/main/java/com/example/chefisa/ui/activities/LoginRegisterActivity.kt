package com.example.chefisa.ui.activities

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.chefisa.databinding.ActivityLoginRegisterBinding
import com.example.chefisa.adapters.LoginRegisterTabsStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
@RequiresApi(Build.VERSION_CODES.P)
@SuppressLint("NewApi")
class LoginRegisterActivity : AppCompatActivity() {
    private val symbolicUserName = "admin"
    private val symbolicPassword = "admin123"

    private lateinit var binding:ActivityLoginRegisterBinding





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