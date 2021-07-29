package com.ateneaApp.util

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import com.ateneaApp.R

 class Utils {

    fun  addNextFragment(factivity: FragmentActivity, fragment: Fragment, fragment2: Fragment, z: Boolean){
        val transaction = factivity.supportFragmentManager.beginTransaction()
        if (z){
            transaction.setCustomAnimations(
                R.animator.slide_fragment_vertical_right_in,
                R.animator.slide_fragment_vertical_left_out,
                R.animator.slide_fragment_vertical_left_in,
                R.animator.slide_fragment_vertical_right_out
            )
        }
        else{
            transaction.setCustomAnimations(
                R.animator.slide_fragment_horizontal_right_in,
                R.animator.slide_fragment_horizontal_left_out,
                R.animator.slide_fragment_horizontal_left_in,
                R.animator.slide_fragment_horizontal_right_out
            )
        }
        transaction.add(R.id.flcontainer,fragment,fragment::class.java.simpleName)
        transaction.hide(fragment2);
        transaction.addToBackStack(fragment::class.java.simpleName);
        transaction.commit();
    }

     fun addNextFragmentFadeAnim(factivity: FragmentActivity, fragment: Fragment, fragment2: Fragment){
         val transaction = factivity.supportFragmentManager.beginTransaction()
         transaction.setCustomAnimations(
             R.animator.enter,
             R.animator.exit,
             R.animator.pop_enter,
             R.animator.pop_exit
         )

         transaction.add(R.id.flcontainer,fragment,fragment::class.java.simpleName)
         transaction.hide(fragment2);
         transaction.addToBackStack(fragment::class.java.simpleName);
         transaction.commit();

     }
 }