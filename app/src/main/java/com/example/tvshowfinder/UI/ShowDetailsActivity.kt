package com.example.tvshowfinder.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.tvshowfinder.Base.BaseActivity
import com.example.tvshowfinder.R
import com.example.tvshowfinder.databinding.ActivityMainBinding

class ShowDetailsActivity : BaseActivity<ActivityMainBinding, ViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_show_details

    override fun init() {

    }
}