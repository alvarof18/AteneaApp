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
import com.squareup.picasso.Picasso

class SimilarProductAdapter(private val listSimilarProducts: List<Int>, val context: Context) : RecyclerView.Adapter<SimilarProductAdapter.VHDataSimilarProducts>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataSimilarProducts {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_similar_product,parent,false)
        return VHDataSimilarProducts(layout)
    }


    override fun onBindViewHolder(holder: VHDataSimilarProducts, position: Int) {
        holder.bind(listSimilarProducts[position])
    }

    override fun getItemCount(): Int = listSimilarProducts.size

    inner class VHDataSimilarProducts(view:View) : RecyclerView.ViewHolder(view){
        private val image: ImageView = view.findViewById(R.id.row_similar_ivPro)


        fun bind(item:Int){
            Picasso.get().load(item).into(image)
        }
    }
}