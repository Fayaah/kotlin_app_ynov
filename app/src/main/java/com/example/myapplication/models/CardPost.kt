package com.example.myapplication.models

data class CardPost ( var title: String, var body: String, var image: String, var username: String ) {
    override fun toString(): String {
        return "CardPost(title='$title', image='$image', username='$username')"
    }
}