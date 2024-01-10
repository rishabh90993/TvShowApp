package com.example.tvshowfinder.Data.api

import com.example.tvshowfinder.Data.models.ContentResponse
import com.example.tvshowfinder.Data.models.Results
import retrofit2.http.GET

interface ApiService {

    @GET("trending/tv/day")
    suspend fun getTrending(): ContentResponse

    @GET("search/tv")
    suspend fun getSearchResults(): List<Results>

    @GET("error")
    suspend fun getUsersWithError(): List<Results>

}