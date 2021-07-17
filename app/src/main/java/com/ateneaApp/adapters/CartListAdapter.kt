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
import com.ateneaApp.fragments.CartListFragment
import com.ateneaApp.model.CartlistModel

class CartListAdapter(val context: Context, val listProductCar: List<CartlistModel>, val cartListFragment: CartListFragment) : RecyclerView.Adapter<CartListAdapter.VHDataCartList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataCartList {
       val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_cart_list,parent,false)
        return VHDataCartList(layout)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: VHDataCartList, position: Int) {
     holder.bind(listProductCar[position], position)
    }

    override fun getItemCount(): Int  = listProductCar.size

    inner class VHDataCartList(view: View) : RecyclerView.ViewHolder(view){

        private val ivDelete: CustomTextView = view.findViewById(R.id.row_cartlist_tvName)
        private val ivMinus: ImageView = view.findViewById(R.id.row_cartlist_ivMins)
        private val ivPlus: ImageView = view.findViewById(R.id.row_cartlist_ivPlus)
        private val ivProImg: ImageView = view.findViewById(R.id.row_cartlist_ivProImg)

        private val tvProductName: CustomTextView = view.findViewById(R.id.row_cartlist_tvName)
        private val tvProductPrice: CustomTextView = view.findViewById(R.id.row_cartlist_tvPrice)
        private val tvSize: CustomTextView = view.findViewById(R.id.row_cartlist_tvSize)
        private val tvTotalQty: CustomTextView = view.findViewById(R.id.row_cartlist_tvQty)
        private val tvUnit: CustomTextView = view.findViewById(R.id.row_cartlist_tvUnit)

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(item: CartlistModel, position: Int) {
            tvProductName.text = item.productName
            tvProductPrice.text = item.productPrice.toString()
            tvSize.text = "Color: ${item.color}"
            tvTotalQty.text = item.productQuanity.toString()
            tvUnit.text = item.unit
            itemView.tag = item

            ivProImg.setImageDrawable(context.resources.getDrawable(item.productImages,context.theme))
            ivPlus.setOnClickListener {
                cartListFragment.addToCart(true, position)
            }
            ivMinus.setOnClickListener {
                cartListFragment.addToCart(false, position)
            }

            ivDelete.setOnClickListener {
                cartListFragment.deleteItem(position)
            }

        }
    }
}