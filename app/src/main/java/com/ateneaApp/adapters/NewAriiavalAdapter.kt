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

open class NewAriiavalAdapter(val listNewArrival: List<Int>, val context: Context) : RecyclerView.Adapter<NewAriiavalAdapter.VHDataNewArrival>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataNewArrival {
       val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_new_arriaval,parent,false)
        return VHDataNewArrival(layout)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: VHDataNewArrival, position: Int) {
      holder.bind(listNewArrival[position])
    }

    override fun getItemCount(): Int = listNewArrival.size

    inner class VHDataNewArrival(view: View) : RecyclerView.ViewHolder(view) {
        val imagenViewArrival: ImageView = view.findViewById(R.id.row_arriaval_ivPro)
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(item: Int){
            with(imagenViewArrival){
                setImageDrawable(context.resources.getDrawable(item,context.theme))

            }
        }
    }
}