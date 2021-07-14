package com.ateneaApp.fragments

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.activities.HomeActivity
import com.ateneaApp.adapters.ParentAdapter
import com.ateneaApp.data.TempListData
import com.ateneaApp.model.MenuCategoryModel


class CategoryListFragment : BaseFragment(){

    private lateinit var rvProductList: RecyclerView
    private lateinit var menuCategoryModels: List<MenuCategoryModel>

    private lateinit var parentAdapter: ParentAdapter

    private lateinit var activityf:Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityf = requireActivity()
    }

    override fun initComponents(view: View?) {
        rvProductList = view?.findViewById(R.id.fragment_category_home_rvWishlist) as RecyclerView
        rvProductList.layoutManager = GridLayoutManager(activity,1)
        getListData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_category_list, container, false)
        initComponents(inflate)
        setHasOptionsMenu(true)
        return inflate
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val itemMenu: MenuItem = menu.getItem(R.id.menu_left)
        itemMenu.isVisible = false
    }

    private fun getListData(){
        activityf
        menuCategoryModels = TempListData().getHomeCategory(activityf)
        parentAdapter = ParentAdapter(activityf, menuCategoryModels, this)
        rvProductList.adapter = parentAdapter
    }
}