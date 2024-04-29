package com.example.chefisa.ui.concreteFragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.chefisa.databinding.FragmentRegisterBinding
import com.example.chefisa.models.RegisterViewModel
import com.example.chefisa.ui.abstractFragments.BaseFragment
import com.example.chefisa.ui.activities.LoginRegisterActivity
import com.example.chefisa.ui.activities.MenuActivity
import com.example.chefisa.utilities.AuthResults
import com.example.chefisa.utilities.UIHelper.Companion.executeDelayed
import com.example.chefisa.utilities.UIHelper.Companion.hideShowPassword
import com.example.loginregister.UserManager

class RegisterFragment:BaseFragment<FragmentRegisterBinding>(
    FragmentRegisterBinding::inflate
){
    val userManager = UserManager()
    val registerModel = RegisterViewModel()

    lateinit var inputs:List<EditText>
    val btnSubmitListener: View.OnClickListener
        @RequiresApi(Build.VERSION_CODES.P)
        get() = View.OnClickListener {
            val isEmpty = inputs.find { it.text.isNullOrBlank() }

            if (isEmpty!=null) {
                isEmpty.error = "This field required!"
                binding.textWarning.text = AuthResults.BLANK.message
            } else {
                val result = userManager.register(registerModel)
                binding.textWarning.text = result.second

                executeDelayed(500) {
                    binding.textWarning.text = result.second
                }

                result.third?.let { user ->
                    executeDelayed(500) {
                        val intent = Intent(requireContext(), MenuActivity::class.java)
                        startActivity(intent)
                        inputs.forEach { it.text.clear() }
                        binding.textWarning.text = ""
                    }
                }
            }
        }




    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = super.onCreateView(inflater, container, savedInstanceState)
        binding.register = registerModel
        inputs = listOf(
            binding.evEmail,
            binding.evUsername,
            binding.evPassword,
            binding.evRePassword
        )
        binding.apply {
            btnsShowHidePassword.setOnClickListener { hideShowPassword(evPassword,binding.btnsShowHidePassword) }
            btnShowHideRepassword.setOnClickListener { hideShowPassword(evRePassword,binding.btnShowHideRepassword) }
        }
        binding.btnSubmit.setOnClickListener(btnSubmitListener)
        return result
    }
}