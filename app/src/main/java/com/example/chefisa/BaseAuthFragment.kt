package com.example.chefisa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.chefisa.databinding.FragmentAuthBinding

abstract class BaseAuthFragment(val fragmentName:FragmentNames):BaseFragment<FragmentAuthBinding>
    (FragmentAuthBinding::inflate){

    abstract val btnSubmitListener:View.OnClickListener

    lateinit var baseViews:MutableList<View>

    lateinit var extraViews:MutableList<View>


//        abstract val btnSubmitListener:View.OnClickListener


        fun renderViews(fragmentName:FragmentNames){
            if(fragmentName==FragmentNames.SIGN_UP) {
                baseViews.addAll(extraViews)
            }
            val btnSubmit = baseViews[3] as Button
            btnSubmit.text = fragmentName.printableName
            btnSubmit.setOnClickListener(btnSubmitListener)

            baseViews.forEach { it.visibility = View.VISIBLE }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = super.onCreateView(inflater, container, savedInstanceState)
        baseViews = mutableListOf<View>(
            binding.evEmailOrUsername,
            binding.evPassword,
            binding.textWarning,
            binding.btnSubmit,
        )

        extraViews = mutableListOf<View>(
            binding.evRePassword,
            binding.rePasswordLock
        )

        renderViews(fragmentName)

        return  result
    }






}