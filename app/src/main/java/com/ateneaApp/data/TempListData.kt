package com.ateneaApp.data

import android.app.Activity
import com.ateneaApp.R
import com.ateneaApp.model.MenuCategoryModel
import com.ateneaApp.model.MenuSubCategoryModel

class TempListData {

        fun getHomeCategory(activity: Activity): List<MenuCategoryModel> {
        val arrayList = mutableListOf<MenuCategoryModel>()
        arrayList.add(MenuCategoryModel("1",activity.getString(R.string.cat_a),getHomeSubCategory(activity)))
        arrayList.add(MenuCategoryModel("2",activity.getString(R.string.cat_b),getHomeSubCategory(activity)))
        arrayList.add(MenuCategoryModel("3",activity.getString(R.string.cat_c),getHomeSubCategory(activity)))
        arrayList.add(MenuCategoryModel("4",activity.getString(R.string.cat_d),getHomeSubCategory(activity)))
        arrayList.add(MenuCategoryModel("5",activity.getString(R.string.cat_e),getHomeSubCategory(activity)))
        return arrayList
    }

       private fun getHomeSubCategory(activity: Activity): List<MenuSubCategoryModel> {

        val arrayList = mutableListOf<MenuSubCategoryModel>()
        arrayList.add(MenuSubCategoryModel("11",activity.getString(R.string.sub_a)))
        arrayList.add(MenuSubCategoryModel("12",activity.getString(R.string.sub_b)))
        arrayList.add(MenuSubCategoryModel("13",activity.getString(R.string.sub_c)))
        return arrayList
    }
}