package com.ateneaApp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ateneaApp.R
import com.ateneaApp.fragments.HomeFragment


class HomeActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView(){
      supportFragmentManager.beginTransaction()
          .replace(R.id.flcontainer,homeFragment)
          .commit()
    }
}