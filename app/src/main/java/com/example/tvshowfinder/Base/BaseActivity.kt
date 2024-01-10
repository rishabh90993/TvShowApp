package com.example.tvshowfinder.Base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {

    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */

    abstract fun init()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        init()
    }

    fun getBinding(): T {
        return mViewDataBinding
    }

    fun getVM(): V {
        return mViewModel
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
//        mViewDataBinding.setVariable(100, mViewModel)
        mViewDataBinding.executePendingBindings()
    }

}