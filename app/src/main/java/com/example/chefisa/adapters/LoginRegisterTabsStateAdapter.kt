package com.example.chefisa.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chefisa.ui.concreteFragments.LoginFragment
import com.example.chefisa.ui.concreteFragments.RegisterFragment


class LoginRegisterTabsStateAdapter(activity:FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> LoginFragment()
            else-> RegisterFragment()
        }
    }
}