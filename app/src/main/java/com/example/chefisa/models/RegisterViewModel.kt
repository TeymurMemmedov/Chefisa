package com.example.chefisa.models

class RegisterViewModel(){
    var email:String? = null
    var username:String? = null
    var password:String? = null
    var rePassword:String? = null

    fun setValueToEmail(str:String){
        email = str
    }
    fun setValueToUsername(str:String){
        username = str
    }
    fun setValueToPassword(str:String){
        password = str
    }
    fun setValueToRePassword(str:String){
        rePassword = str
    }

    fun comparePasswordAndRePassword() = password==rePassword


}

