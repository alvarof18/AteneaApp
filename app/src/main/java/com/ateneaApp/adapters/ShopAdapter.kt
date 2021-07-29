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

class ShopAdapter(private val listShop:List<Int>, val context: Context): RecyclerView.Adapter<ShopAdapter.VHDataShop>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataShop {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_shop,parent,false)
        return VHDataShop(layout)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: VHDataShop, position: Int) {
        holder.bind(listShop[position])
    }

    override fun getItemCount(): Int = listShop.size

    inner class VHDataShop(val view: View) : RecyclerView.ViewHolder(view){
       private val imageViewShop: ImageView = view.findViewById(R.id.ivCode)
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        public fun bind(item:Int){
            imageViewShop.setImageDrawable(context.resources.getDrawable(item,context.theme))
        }

    }
}