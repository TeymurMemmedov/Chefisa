package com.example.chefisa.utilities

enum class AuthResults(val message:String) {
    BLANK("All required fields must be entered!"),
    INCORRECT("Your credentials are incorrect!"),
    CORRECT("Your credentials are correct!"),
    LIMIT_EXCEED("You have exceed the limit!"),
    EMAIL_TAKEN("This email has been taken!"),
    USERNAME_TAKEN("This username has been taken!"),
    NOT_VALID_EMAIL("Please enter valid email!"),
    PASSWORDS_NOT_MATCHING("Please enter same password twice!"),
    SUCCESSFUL_REGISTER("Your have registered successfully!")
}