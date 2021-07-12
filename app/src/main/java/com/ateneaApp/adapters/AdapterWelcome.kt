package com.ateneaApp.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ateneaApp.R
import com.ateneaApp.fragments.WelcomeFragment

class AdapterWelcome(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    companion object{
        private const val ARG_IMAGE = "image"
        private const val ARG_VISIBLE = "visible"
        }

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = WelcomeFragment()
        fragment.arguments = Bundle().apply {
           when(position){
               0 ->{
                    putInt(ARG_IMAGE, R.mipmap.walkthrough1)
                    putBoolean(ARG_VISIBLE,false)
               }
               1 ->{
                    putInt(ARG_IMAGE, R.mipmap.walkthrough2)
                   putBoolean(ARG_VISIBLE,false)
               }
               2 ->{
                   putInt(ARG_IMAGE, R.mipmap.walkthrough3)
                   putBoolean(ARG_VISIBLE,true)
               }
           }
        }
        return fragment
    }
}