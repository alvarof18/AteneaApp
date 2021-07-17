package com.ateneaApp.data

import android.app.Activity
import android.content.res.Resources
import androidx.fragment.app.FragmentActivity
import com.ateneaApp.R
import com.ateneaApp.model.CartlistModel
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

   fun getCartList(activity: FragmentActivity): List<CartlistModel> {

       //val color = activity.getString(R.string.color_yello)

        val arrayList = mutableListOf<CartlistModel>()
        // Item 1
        arrayList.add(
            CartlistModel(
                activity.resources.getString(R.string.color_yello),
                R.mipmap.product_bag_1,
                activity.getString(R.string.cart_a),
                10,
                1,
                activity.getString(R.string.slimfit)
            )
        )

        // Item 2
        arrayList.add(
            CartlistModel(
                activity.getString(R.string.color_light_pink),
                R.mipmap.product_bag_2,
                activity.getString(R.string.cart_b),
                50,
                1,
                activity.getString(R.string.slimfit)
            )
        )
        // Item 3
        arrayList.add(
            CartlistModel(
                activity.getString(R.string.color_yello),
                R.mipmap.product_bag_3,
                activity.getString(R.string.cart_c),
                30,
                1,
                activity.getString(R.string.slimfit)
            )
        )
        // Item 4
        arrayList.add(
            CartlistModel(
                activity.getString(R.string.color_pink_white),
                R.mipmap.product_bag_4,
                activity.getString(R.string.cart_d),
                20,
                1,
                activity.getString(R.string.slimfit)
            )
        )
        // Item 5
        arrayList.add(
            CartlistModel(
                activity.getString(R.string.color_yello),
                R.mipmap.product_bag_5,
                activity.getString(R.string.cart_e),
                100,
                1,
                activity.getString(R.string.slimfit)
            )
        )
        // Item 6
        arrayList.add(
            CartlistModel(
                activity.getString(R.string.color_bron),
                R.mipmap.product_bag_7,
                activity.getString(R.string.cart_f),
                15,
                1,
                activity.getString(R.string.slimfit)
            )
        )
        // Item 7
        arrayList.add(
            CartlistModel(
                activity.getString(R.string.color_yello),
                R.mipmap.product_bag_8,
                activity.getString(R.string.cart_f),
                90,
                1,
                activity.getString(R.string.slimfit)
            )
        )

        return arrayList
    }
}