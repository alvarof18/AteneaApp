package com.ateneaApp.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ateneaApp.R
import com.google.android.material.tabs.TabLayout


class HomeFragment : BaseFragment() {
    private val activity: Activity? = null
    private var tlMainCategory: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate: View =
            layoutInflater.inflate(R.layout.fragment_feed_home, container, false)
        initComponents(inflate)
        return inflate
    }

    override fun initComponents(view: View?) {
        tlMainCategory = view?.findViewById(R.id.fragment_home_tlHome) as TabLayout
        setupTabIcons()
        openFragment(FeedHomeFragment())
    }

    private fun setupTabIcons() {
        val stringArray = resources.getStringArray(R.array.category)
        val iArr = intArrayOf(
            R.drawable.menu_feed_selector,
            R.drawable.menu_category_selector,
            R.drawable.menu_bag_selector,
            R.drawable.menu_myacoount_selector
        )
        val newTab = tlMainCategory!!.newTab()
        newTab.text = stringArray[0] as CharSequence
        newTab.setIcon(iArr[0])
        tlMainCategory!!.addTab(newTab)
        val newTab2 = tlMainCategory!!.newTab()
        newTab2.text = stringArray[1] as CharSequence
        newTab2.setIcon(iArr[1])
        tlMainCategory!!.addTab(newTab2)
        val newTab3 = tlMainCategory!!.newTab()
        newTab3.text = stringArray[2] as CharSequence
        newTab3.setIcon(iArr[2])
        tlMainCategory!!.addTab(newTab3)
        val newTab4 = tlMainCategory!!.newTab()
        newTab4.text = stringArray[3] as CharSequence
        newTab4.setIcon(iArr[3])
        tlMainCategory!!.addTab(newTab4)

        tlMainCategory!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        HomeFragment().openFragment(FeedHomeFragment())
                    }
                    1 -> {
                        HomeFragment().openFragment(CategoryListFragment())
                    }
                    2 -> {
                        HomeFragment().openFragment(CartListFragment())
                    }
                    3 -> {
                       HomeFragment().openFragment(MyAccountFragment())
                    }

                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        })
    }
    private fun openFragment(fragment: Fragment) {
        getActivity()?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_home_flHome, fragment)
    }
}



