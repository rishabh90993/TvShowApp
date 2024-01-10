package com.example.tvshowfinder.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowfinder.Data.UiState
import com.example.tvshowfinder.Data.api.ApiHelperImpl
import com.example.tvshowfinder.Data.api.RetrofitBuilder
import com.example.tvshowfinder.Data.models.ContentResponse
import com.example.tvshowfinder.Data.models.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class TvShowListingViewModel() : ViewModel() {

    var apiHelper = ApiHelperImpl(RetrofitBuilder.apiService)
    private val _uiState = MutableStateFlow<UiState<ContentResponse>>(UiState.Loading)

    val uiState: StateFlow<UiState<ContentResponse>> = _uiState

    init {
        fetchAllTvShows()
    }

    private fun fetchAllTvShows() {
        viewModelScope.launch(Dispatchers.Main) {
            _uiState.value = UiState.Loading
            apiHelper.getTrendingShowsList()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}