package com.example.loginregister

import com.example.chefisa.models.RegisterViewModel
import com.example.chefisa.models.User


abstract class UserManagerAbstract {

    abstract fun login(emailOrUsername:String,password:String):Triple<Boolean,String,User?>
    abstract fun register(registerModel:RegisterViewModel):Triple<Boolean, String,User?>



}