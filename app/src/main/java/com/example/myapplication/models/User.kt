package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class User (
	@SerializedName("in_account") val in_account : Boolean,
	@SerializedName("status") val status : Int,
	@SerializedName("mail") val mail : Boolean,
	@SerializedName("twitter") val twitter : Boolean,
	@SerializedName("profile") val profile : Boolean,
	@SerializedName("favorited") val favorited : Boolean,
	@SerializedName("friends_watched") val friends_watched : List<String>
)