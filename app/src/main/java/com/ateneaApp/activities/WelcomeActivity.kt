package com.ateneaApp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ateneaApp.adapters.AdapterWelcome
import com.ateneaApp.databinding.ActivityWelcomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private val adapter by lazy { AdapterWelcome(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = adapter
        val tabLayoutMediator =TabLayoutMediator(binding.tabLayout, binding.viewPager, TabLayoutMediator.TabConfigurationStrategy{
            _, _ ->
            })
        tabLayoutMediator.attach()
    }
}