package com.example.tvshowfinder.UI

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tvshowfinder.Base.BaseActivity
import com.example.tvshowfinder.UI.Adapter.AdapterTvShowItem
import com.example.tvshowfinder.Data.UiState
import com.example.tvshowfinder.ViewModels.TvShowListingViewModel
import com.example.tvshowfinder.databinding.ActivityMainBinding
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tvshowfinder.Data.models.Results
import com.example.tvshowfinder.R
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding,ViewModel>() {

    private lateinit var mViewModel : TvShowListingViewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    private val adapter by lazy {
        AdapterTvShowItem(
            this@MainActivity,
            onItemClick = { item ->

            },
        )
    }

    override fun init() {
        mViewModel = ViewModelProvider(this)[TvShowListingViewModel::class.java]
        initRecuclerView()
        setupObserver()
    }

    private fun initRecuclerView() {
        val layoutManager = GridLayoutManager(this@MainActivity,2)
        layoutManager.isAutoMeasureEnabled = true

        getBinding().rvTvShow.layoutManager = layoutManager
        getBinding().rvTvShow.adapter = adapter
        getBinding().rvTvShow.isNestedScrollingEnabled = false
        getBinding().rvTvShow.setHasFixedSize(false)
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mViewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            getBinding().progressBar.root.visibility = View.GONE
                            getBinding().rvTvShow.visibility = View.VISIBLE
                            renderList(it.data.results)
                        }
                        is UiState.Loading -> {
                            getBinding().progressBar.root.visibility = View.GONE
                            getBinding().rvTvShow.visibility = View.GONE
                        }
                        is UiState.Error -> {
                            //Handle Error
                            getBinding().progressBar.root.visibility = View.GONE
                            getBinding().rvTvShow.visibility = View.GONE
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }

    private fun renderList(data: List<Results>) {
        adapter.clearAndAddItems(data)
    }

}