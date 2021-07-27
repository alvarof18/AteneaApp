package com.ateneaApp.data

import android.app.Activity
import android.content.res.Resources
import androidx.fragment.app.FragmentActivity
import com.ateneaApp.R
import com.ateneaApp.model.*

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

    fun getOrderList(): List<OrderListModel> {

        val arrayList = mutableListOf<OrderListModel>()
        arrayList.add(OrderListModel(1321321,"Test1",R.mipmap.product_bag_1,"$10","10","12 January","28-26-2021","pending"))
        arrayList.add(OrderListModel(1321322,"Test2",R.mipmap.product_bag_2,"$11","10","12 January","28-26-2021","cancel"))
        arrayList.add(OrderListModel(1321323,"Test3",R.mipmap.product_bag_3,"$12","10","12 January","28-26-2021","delivery"))
        arrayList.add(OrderListModel(1321324,"Test4",R.mipmap.product_bag_4,"$13","10","12 January","28-26-2021","return"))
        arrayList.add(OrderListModel(1321325,"Test5",R.mipmap.product_bag_5,"$14","10","12 January","28-26-2021","delivery"))
        arrayList.add(OrderListModel(1321326,"Test6",R.mipmap.product_bag_6,"$1","10","12 January","28-26-2021","pending"))
        return arrayList
    }

    fun getCheckoutAddress(factivity: FragmentActivity): List<AddressListModel>{
        val arrayList = mutableListOf<AddressListModel>()
        arrayList.add(AddressListModel(factivity.resources.getString(R.string.add_a),"home",false))
        arrayList.add(AddressListModel(factivity.resources.getString(R.string.add_b),"Office",false))
        return arrayList
    }

    fun getOrderListNewList(factivity: FragmentActivity) : List<CheckoutListModel>{
        val arrayList = mutableListOf<CheckoutListModel>()
        arrayList.add(CheckoutListModel(factivity.resources.getString(R.string.cart_a),"100","1"))
        arrayList.add(CheckoutListModel(factivity.resources.getString(R.string.cart_b),"10","3"))
        arrayList.add(CheckoutListModel(factivity.resources.getString(R.string.cart_c),"50","2"))
        arrayList.add(CheckoutListModel(factivity.resources.getString(R.string.cart_d),"5","1"))
        arrayList.add(CheckoutListModel(factivity.resources.getString(R.string.cart_e),"55","1"))
        arrayList.add(CheckoutListModel(factivity.resources.getString(R.string.cart_f),"50","2"))
        return arrayList
    }

    fun getCreditcardList(factivity: FragmentActivity) : List<CreditcardModel>{
        val arrayList = mutableListOf<CreditcardModel>()
        arrayList.add(CreditcardModel("Alvaro Figueroa","Alvaro Figueroa","1234 5678 9012 4568","Gold","12/22"))
        arrayList.add(CreditcardModel("Albanys Cuauro","Albanys Cuauro","1234 5678 9012 4568","Black","12/22"))
        return arrayList
    }

    fun getProductList(factivity:FragmentActivity) : List<ProductListModel>{
        val arrayList = mutableListOf<ProductListModel>()
        arrayList.add(ProductListModel(productName=factivity.getString(R.string.product_a),productPrice="$10",productImage=R.mipmap.bg_featured_1))
        arrayList.add(ProductListModel(productName=factivity.getString(R.string.product_b),productPrice="$8",productImage=R.mipmap.bg_featured_2))
        arrayList.add(ProductListModel(productName=factivity.getString(R.string.product_c),productPrice="$15",productImage=R.mipmap.bg_featured_3))
        arrayList.add(ProductListModel(productName=factivity.getString(R.string.product_d),productPrice="$12",productImage=R.mipmap.bg_featured_4))
        arrayList.add(ProductListModel(productName=factivity.getString(R.string.product_f),productPrice="$5",productImage=R.mipmap.bg_featured_5))
        arrayList.add(ProductListModel(productName=factivity.getString(R.string.product_g),productPrice="$15",productImage=R.mipmap.bg_featured_6))
        arrayList.add(ProductListModel(productName=factivity.getString(R.string.product_h),productPrice="$20",productImage=R.mipmap.bg_featured_1))
        return arrayList
    }

}