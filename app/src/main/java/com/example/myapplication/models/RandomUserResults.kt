package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class RandomUserResults (
    @SerializedName("movies") val movies : List<Movie>,
    @SerializedName("errors") val errors : List<String>
)