package com.ateneaApp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.ateneaApp.R
import com.ateneaApp.fragments.HomeFragment


class HomeActivity : AppCompatActivity() {
    private val mainFragment: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView(){
        val ft: FragmentTransaction
        

    }
}