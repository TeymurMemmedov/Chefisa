package com.example.chefisa.ui.concreteFragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.chefisa.databinding.FragmentLoginBinding
import com.example.chefisa.models.LoginViewModel
import com.example.chefisa.ui.abstractFragments.BaseFragment
import com.example.chefisa.ui.activities.MenuActivity
import com.example.chefisa.utilities.AuthResults
import com.example.loginregister.UserManager

class LoginFragment(): BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
){

    val userManager = UserManager()


     var login = LoginViewModel()

     lateinit var inputs:List<EditText>

    val btnSubmitListener: View.OnClickListener
        get() = View.OnClickListener {
            val isEmpty = inputs.any { it.text.isNullOrBlank() }

            if (isEmpty) {
                inputs.forEach { it.error = "This field required!" }
                binding.textWarning.text = AuthResults.BLANK.message
            } else {
                val (email, password) = login.emailOrUsername.toString() to login.password.toString()
                val result = userManager.login(email, password)

                binding.textWarning.text = ""
                executeDelayed(500) {
                    binding.textWarning.text = result.second
                }

                result.third?.let { user ->
                    executeDelayed(500) {
                        val intent = Intent(requireContext(), MenuActivity::class.java)
                        intent.putExtra("USER", user)
                        startActivity(intent)
                        inputs.forEach { it.text.clear() }
                        binding.textWarning.text = ""
                    }
                }
            }
        }

    private fun executeDelayed(delayMillis: Long, task: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(task, delayMillis)
    }








    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = super.onCreateView(inflater, container, savedInstanceState)
        binding.login = login
        inputs = listOf(
            binding.evEmailOrUsername,
            binding.evPassword
        )
        binding.btnSubmit.setOnClickListener(btnSubmitListener)
        return result
    }
}