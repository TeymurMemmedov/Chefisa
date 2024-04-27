package com.example.chefisa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.chefisa.databinding.FragmentAuthBinding

class RegisterFragment(fragmentName: FragmentNames=FragmentNames.SIGN_UP):BaseAuthFragment(fragmentName){
    override val btnSubmitListener: View.OnClickListener
        get() = object:View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(requireContext(),"Qaqa register!", Toast.LENGTH_SHORT).show()
            }

        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = super.onCreateView(inflater, container, savedInstanceState)
        return result
    }
}