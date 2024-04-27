package com.example.chefisa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.chefisa.databinding.FragmentAuthBinding

class LoginFragment(fragmentName: FragmentNames=FragmentNames.SIGN_IN):BaseAuthFragment(fragmentName){
    override val btnSubmitListener: View.OnClickListener
        get() = object:View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(requireContext(),"Qaqa login!",Toast.LENGTH_LONG).show()
            }

        }
//    override val btnSubmitListener: View.OnClickListener
//        get() = TODO("Not yet implemented")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = super.onCreateView(inflater, container, savedInstanceState)
        return result
    }
}