package com.example.tvshowfinder.Data.api

import com.example.tvshowfinder.Data.models.ContentResponse
import com.example.tvshowfinder.Data.models.Results
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    fun getTrendingShowsList(): Flow<ContentResponse>

    fun getSearchShowList(): Flow<List<Results>>

    fun getUsersWithError(): Flow<List<Results>>

}