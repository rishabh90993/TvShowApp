package com.example.tvshowfinder.Data.api

import com.example.tvshowfinder.Data.models.ContentResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override fun getTrendingShowsList(): Flow<ContentResponse>  = flow { emit(apiService.getTrending()) }

    override fun getSearchShowList() = flow { emit(apiService.getSearchResults()) }

    override fun getUsersWithError() = flow { emit(apiService.getUsersWithError()) }

}