package com.ateneaApp.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R

open class TrendingAdapter(val listTraning: List<Int>, val context: Context) : RecyclerView.Adapter<TrendingAdapter.VHDataTrendign>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataTrendign {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_trending,parent,false)
        return VHDataTrendign(layout)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: VHDataTrendign, position: Int) {
    holder.bind(listTraning[position])

    }

    override fun getItemCount(): Int = listTraning.size

 inner class VHDataTrendign(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewTrending: ImageView = view.findViewById(R.id.row_trending_ivPro)

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(item: Int) {
            with(imageViewTrending) {

                setImageDrawable(context.resources.getDrawable(item,context.theme))
                setOnClickListener {

                }
            }
        }
    }
}