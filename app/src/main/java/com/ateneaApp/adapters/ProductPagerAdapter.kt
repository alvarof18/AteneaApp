package com.ateneaApp.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.PagerAdapter
import com.ateneaApp.R


class ProductPagerAdapter(private val listProductImage: List<Int>, val context:Context) : PagerAdapter(){

    val layoutInflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = listProductImage.size
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun instantiateItem(viewGroup: ViewGroup, position: Int): Any {
        val inflate: View = layoutInflater.inflate(R.layout.row_productdetails_slider,viewGroup,false)
        inflate.findViewById<ImageView>(R.id.ivCode).setImageDrawable(context.resources.getDrawable(listProductImage[position],context.theme))
        viewGroup.addView(inflate)
        return inflate
    }

    override fun getPageWidth(i: Int): Float {
        return 0.9f
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}