package com.example.chefisa.models

import com.example.loginregister.UserManager
import java.io.Serializable

class User(
    val email:String,
    val username:String,
    val password:String,
    var remainingAttempChangeCount:Int = UserManager.defaultAttemptChanceCount
):Serializable {

}