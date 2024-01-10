package com.example.tvshowfinder.Data.models
import com.google.gson.annotations.SerializedName
import java.util.*


data class Results (

  @SerializedName("adult"             ) var adult            : Boolean?       = null,
  @SerializedName("backdrop_path"     ) var backdropPath     : String?        = null,
  @SerializedName("id"                ) var id               : Int?           = null,
  @SerializedName("name"             ) var title            : String?        = null,
  @SerializedName("original_language" ) var originalLanguage : String?        = null,
  @SerializedName("original_title"    ) var originalTitle    : String?        = null,
  @SerializedName("overview"          ) var overview         : String?        = null,
  @SerializedName("poster_path"       ) var posterPath       : String?        = null,
  @SerializedName("media_type"        ) var mediaType        : String?        = null,
  @SerializedName("genre_ids"         ) var genreIds         : ArrayList<Int> = ArrayList(),
  @SerializedName("popularity"        ) var popularity       : Double?        = null,
  @SerializedName("release_date"      ) var releaseDate      : String?        = null,
  @SerializedName("video"             ) var video            : Boolean?       = null,
  @SerializedName("vote_average"      ) var voteAverage      : Double?        = null,
  @SerializedName("vote_count"        ) var voteCount        : Int?           = null
){
  fun getImageUrl():String = "https://image.tmdb.org/t/p/w500/$posterPath"
}