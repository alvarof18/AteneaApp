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
import com.ateneaApp.customviews.CustomTextView
import com.ateneaApp.fragments.OrderListFragment
import com.ateneaApp.model.OrderListModel

class OrderListAdapter(val listOrders:List<OrderListModel>, val context: Context, val orderListFragment:OrderListFragment) : RecyclerView.Adapter<OrderListAdapter.VHDataOrderList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataOrderList {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_orderlist,parent,false)
        return VHDataOrderList(layout)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: VHDataOrderList, position: Int) {
        holder.bind(listOrders[position],position)
    }

    override fun getItemCount(): Int = listOrders.size

    inner class VHDataOrderList(view: View) : RecyclerView.ViewHolder(view){

        private val ivProImg: ImageView = view.findViewById(R.id.row_orderlist_ivProImg)
        private val tvItems:CustomTextView = view.findViewById(R.id.row_orderlist_tvItems)
        private val tvLableItems:CustomTextView = view.findViewById(R.id.row_orderlist_tvLableItems)
        private val tvLableOrderID:CustomTextView = view.findViewById(R.id.row_orderlist_tvLableOrderID)
        private val tvLablePrice:CustomTextView = view.findViewById(R.id.row_orderlist_tvLablePrice)
        private val tvOrderDate:CustomTextView = view.findViewById(R.id.row_orderlist_tvDate)
        private val tvOrderId:CustomTextView = view.findViewById(R.id.row_orderlist_tvOrderID)
        private val tvOrderStatus:CustomTextView = view.findViewById(R.id.row_orderlist_tvOrderStatus)
        private val tvPrice:CustomTextView = view.findViewById(R.id.row_orderlist_tvPrice)


        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(item:OrderListModel, position:Int){
            tvOrderDate.text = item.orderDate
            tvOrderId.text = item.orderId.toString()
            tvPrice.text = item.price
            ivProImg.setImageDrawable(context.resources.getDrawable(item.productImages,context.theme))

            when (item.status) {

                context.getString(R.string.lbl_pending) -> {
                    tvOrderStatus.text = context.getString(R.string.lbl_pending)
                    tvOrderStatus.setTextColor(context.resources.getColor(R.color.order_status_progress_color, context.theme))
                }

                context.getString(R.string.lbl_delivery) ->{
                    tvOrderStatus.text = context.getString(R.string.lbl_delivery)
                    tvOrderStatus.setTextColor(context.resources.getColor(R.color.order_status_deliver_color, context.theme))

                }

                context.getString(R.string.lbl_return) ->{
                    tvOrderStatus.text = context.getString(R.string.lbl_return)
                    tvOrderStatus.setTextColor(context.resources.getColor(R.color.order_status_return_color, context.theme))
                }

                context.getString(R.string.lbl_cancel) ->{
                    tvOrderStatus.text = context.getString(R.string.lbl_cancel)
                    tvOrderStatus.setTextColor(context.resources.getColor(R.color.order_status_cancel_color, context.theme))
                }


            }
            itemView.setOnClickListener { orderListFragment.openOrderdetails(item, position) }
        }

    }
}