package com.ateneaApp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.customviews.CustomTextView
import com.ateneaApp.model.CheckoutListModel

class OrderSummaryListAdapter(val listOrder:List<CheckoutListModel>) : RecyclerView.Adapter<OrderSummaryListAdapter.VHDataOrder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataOrder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_order_summary_list,parent,false)
        return VHDataOrder(layout)
    }

    override fun onBindViewHolder(holder: VHDataOrder, position: Int) {
       holder.bind(listOrder[position])
    }

    override fun getItemCount(): Int = listOrder.size

    inner class VHDataOrder(view: View) : RecyclerView.ViewHolder(view){

        private val tvOrederName: CustomTextView = view.findViewById(R.id.row_orderlist_new_tvOrederName)
        private val tvOrderQuntity: CustomTextView = view.findViewById(R.id.row_orderlist_new_tvQuntity)
        private val tvOrderPrice: CustomTextView = view.findViewById(R.id.row_orderlist_new_tvPrice)

        fun bind(item:CheckoutListModel){
            tvOrederName.text = item.orderName
            tvOrderPrice.text = item.price
            tvOrderQuntity.text = item.quantity
        }

    }
}