package com.example.loginregister

import com.example.chefisa.models.RegisterViewModel
import com.example.chefisa.models.User
import com.example.chefisa.utilities.AuthResults


class UserManager:UserManagerAbstract() {


        companion object {
            val defaultAttemptChanceCount: Int = 3
            val userList = mutableListOf<User>(
                User("teymur@gmail.com","teymur","123")
            )

        }


    override fun login(emailOrUsername: String, password: String): Triple<Boolean, String,User?> {


        var searchingUser:User?=null
        if(emailOrUsername.contains('@')) searchingUser = findUserByEmail(emailOrUsername)
        else searchingUser = findUserByUsername(emailOrUsername)

        return when {
            searchingUser == null ->
                Triple(false, AuthResults.INCORRECT.message ,null)

            searchingUser.remainingAttempChangeCount <= 0 ->
                Triple(false, AuthResults.LIMIT_EXCEED.message,null)

            !isPasswordCorrect(searchingUser, password) -> {
                searchingUser.remainingAttempChangeCount--
                Triple(false, AuthResults.INCORRECT.message,null)
            }
            else -> {Triple(true, AuthResults.CORRECT.message,searchingUser)}
        }
    }

    override fun register(registerModel: RegisterViewModel): Triple<Boolean, String, User?> {
        val result1 = registerModel.email?.let { findUserByEmail(it) }
        val result2 = registerModel.username?.let { findUserByUsername(it) }
        val isThisEmailTaken = if (result1!=null) true else false
        val isThisUsernameTaken = if (result2!=null) true else false

        return when{
            isThisEmailTaken==true ->
                return Triple(false,AuthResults.EMAIL_TAKEN.message,null)
            isThisUsernameTaken==true ->
                return Triple(false,AuthResults.USERNAME_TAKEN.message,null)
            !registerModel.email!!.contains('@')->
                return Triple(false,AuthResults.NOT_VALID_EMAIL.message,null)
            !registerModel.comparePasswordAndRePassword()->
                return Triple(false,AuthResults.PASSWORDS_NOT_MATCHING.message,null)
            else-> {
                val newUser = User(
                    registerModel.email!!,
                    registerModel.username!!,
                    registerModel.password!!
                )
            userList.add(newUser)

                return Triple(true,AuthResults.SUCCESSFUL_REGISTER.message,newUser)}



        }

    }


    //Ümumiyyətlə user mövcuddur mu deyə baxır
    fun findUserByEmail(email:String):User? {
        for (user in userList) {
            if (user.email == email) {
                return user
            }
        }
        //User tapilmasa null qaytar
        return null
    }

    fun findUserByUsername(username:String):User? {
        for (user in userList) {
            if (user.username == username ) {
                return user
            }
        }
        //User tapilmasa null qaytar
        return null
    }

    //User obyektinin passwordu ilə xaricdən gələn passwordu müqayisə edir
    fun isPasswordCorrect(user:User, password: String) = user.password == password

}