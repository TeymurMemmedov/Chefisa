package com.example.chefisa.models

class LoginViewModel(){
     var  emailOrUsername:String?=null
     var  password:String? = null

    fun setValueEmailOrUsername(str:String){
        emailOrUsername=str.trim()
    }

    fun setValuePassword(str:String){
        password=str.trim()
    }

}