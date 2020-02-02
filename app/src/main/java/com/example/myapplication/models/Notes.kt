package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class Notes (
	@SerializedName("mean") val mean : Int,
	@SerializedName("total") val total : Int,
	@SerializedName("user") val user : Int
)