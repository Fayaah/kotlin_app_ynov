package com.example.myapplication.models

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Movie (
	@SerializedName("id") @Nullable val id : Int,
	@SerializedName("title") @Nullable val title : String,
	@SerializedName("original_title") @Nullable val originalTitle : String,
	@SerializedName("tmdb_id") @Nullable val tmdbId : Int,
	@SerializedName("imdb_id") @Nullable val imdbId : String,
	@SerializedName("url") @Nullable val url : String,
	@SerializedName("poster") @Nullable val poster : String,
	@SerializedName("backdrop") @Nullable val backdrop : String,
	@SerializedName("production_year") @Nullable val productionYear : Int,
	@SerializedName("release_date") @Nullable val releaseDate : String,
	@SerializedName("original_release_date") @Nullable val originalReleaseDate : String,
	@SerializedName("sale_date") @Nullable val saleDate : String,
	@SerializedName("director") @Nullable val director : String,
	@SerializedName("length") @Nullable val length : Int,
	@SerializedName("genres") @Nullable val genres : List<String>,
	@SerializedName("synopsis") @Nullable val synopsis : String,
	@SerializedName("tagline") @Nullable val tagline : String,
	@SerializedName("language") @Nullable val language : String,
	@SerializedName("notes") @Nullable val notes : Notes,
	@SerializedName("followers") @Nullable val followers : Int,
	@SerializedName("comments") @Nullable val comments : Int,
	@SerializedName("similars") @Nullable val similars : Int,
	@SerializedName("characters") @Nullable val characters : Int,
	@SerializedName("user") @Nullable val user : User,
	@SerializedName("trailer") @Nullable val trailer : String,
	@SerializedName("resource_url") @Nullable val resourceUrl : String,
	@SerializedName("platform_links") @Nullable val platformLinks : List<String>,
	@SerializedName("other_title") @Nullable val otherTitle : String
)