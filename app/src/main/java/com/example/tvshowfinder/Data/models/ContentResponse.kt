package com.example.tvshowfinder.Data.models

import com.google.gson.annotations.SerializedName
import java.util.*


data class ContentResponse (

  @SerializedName("page"          ) var page         : Int?               = null,
  @SerializedName("results"       ) var results      : ArrayList<Results> = ArrayList(),
  @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
  @SerializedName("total_results" ) var totalResults : Int?               = null

)