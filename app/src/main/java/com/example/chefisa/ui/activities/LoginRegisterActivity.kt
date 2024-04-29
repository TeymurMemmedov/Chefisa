package com.example.chefisa.ui.activities

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.chefisa.databinding.ActivityLoginRegisterBinding
import com.example.chefisa.adapters.LoginRegisterTabsStateAdapter
import com.example.chefisa.models.User
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
        val user  = intent.getSerializableExtra("USER") as? User
        if(user!=null){
            binding.vpAuth.adapter = LoginRegisterTabsStateAdapter(this,user)
        }
        else{
            binding.vpAuth.adapter = LoginRegisterTabsStateAdapter(this,null)
        }



//        binding.vpAuth.isUserInputEnabled = false
        TabLayoutMediator(binding.tabLayout,binding.vpAuth){
                tab,position->tab.text = if(position==0) "Sign In" else "Sign Up"
        }.attach()





    }
}