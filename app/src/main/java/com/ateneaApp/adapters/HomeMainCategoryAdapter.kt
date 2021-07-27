package com.ateneaApp.adapters

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.databinding.RowHomeTopCategoryBinding
import com.squareup.picasso.Picasso


class HomeMainCategoryAdapter(val list : List<Int>, context2: Context) : RecyclerView.Adapter<HomeMainCategoryAdapter.VHCategory>(){

    interface OnItemClickListener{
        fun onItemClick(view: View?, i: Int)
    }

    public var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHCategory {
        val layout = RowHomeTopCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VHCategory(layout)
    }

    override fun onBindViewHolder(holder: VHCategory, position: Int) {
        holder.bind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    inner class VHCategory(private val itemCategory: RowHomeTopCategoryBinding): RecyclerView.ViewHolder(itemCategory.root){
        fun bind(item: Int, position:Int){
            Picasso.get().load(item).into(itemCategory.rowHomeTopCategory)
            itemCategory.rowHomeTopCategory.setOnClickListener {
                if( onItemClickListener != null ){
                    Handler(Looper.getMainLooper()).postDelayed({
                        onItemClickListener!!.onItemClick(it,position)
                    },200)
                }
            }
        }
    }
}