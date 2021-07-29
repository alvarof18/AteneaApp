package com.ateneaApp.adapters

import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.customviews.CustomTextView
import com.ateneaApp.fragments.ProductListFragment
import com.ateneaApp.model.ProductListModel


class ProductListAdapter(var listProduct:List<ProductListModel>, val context:Context, val fragmentProducts: ProductListFragment) : RecyclerView.Adapter<ProductListAdapter.VHDataProduct>(), View.OnClickListener  {

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(view: View, productListModel: ProductListModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataProduct {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_product_list,parent,false)
        return VHDataProduct(layout)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: VHDataProduct, position: Int) {
        holder.bind(listProduct[position],position)
    }

    override fun getItemCount(): Int = listProduct.size

    override fun onClick(p0: View) {
        Handler(Looper.getMainLooper()).postDelayed({onItemClickListener?.onItemClick(p0,p0.tag as ProductListModel)},200)
    }

    fun addData(list: List<ProductListModel>) {
        listProduct = list
        notifyDataSetChanged()
    }

    inner class VHDataProduct(view:View): RecyclerView.ViewHolder(view){
        private val tvProductName: CustomTextView = view.findViewById(R.id.row_productlist_tvName)
        private val tvProductPrice: CustomTextView = view.findViewById(R.id.row_productlist_tvPrice)
        private val tvQty: CustomTextView = view.findViewById(R.id.row_productlist_tvQty)
        private val tvAddedQty:CustomTextView = view.findViewById(R.id.row_productlist_tvAdded)
        private val ivLikeUnLike: ImageView = view.findViewById(R.id.row_productlist_ivLikeUnLike)
        private val ivProImg: ImageView = view.findViewById(R.id.row_productlist_ivProImg)
        private val ivPlus: ImageView = view.findViewById(R.id.row_productlist_ivPlus)
        private val ivMins: ImageView = view.findViewById(R.id.row_productlist_ivMins)
        private val rlTotalCartItem: RelativeLayout = view.findViewById(R.id.row_produclist_rlTotalCart)
        private val ivAdd: ImageView = view.findViewById(R.id.row_productlist_ivAdd)
        private val rlAdded: RelativeLayout = view.findViewById(R.id.row_productlist_rlAdded)
        private val llBlur: LinearLayout = view.findViewById(R.id.row_produclist_llBlur)
        private val tvAddToWishlist: CustomTextView = view.findViewById(R.id.row_produclist_tvAddToWishlist)
        private val rlWishlistAdded: RelativeLayout = view.findViewById(R.id.row_produclist_rlAddToWishlistAdded)
        private val tvAddToBag: CustomTextView = view.findViewById(R.id.row_produclist_tvAddToBag)
        private val rlBagAdded: RelativeLayout = view.findViewById(R.id.row_produclist_rlBagAdded)
        private val ivBlurCLose: ImageView = view.findViewById(R.id.row_produclist_ivBlurCLose)

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(item:ProductListModel, position:Int){

            tvProductName.text = item.productName
            tvProductPrice.text = item.productPrice
            tvQty.text = item.totalQty.toString()
            tvAddedQty.text = item.totalQty.toString()

            ivProImg.setImageDrawable(context.resources.getDrawable(item.productImage,context.theme))

            rlTotalCartItem.visibility = if(item.totalQty == 0) {8} else {0}
            ivAdd.visibility = if(item.totalQty == 0) {0} else {8}
            rlAdded.visibility = if(item.totalQty == 0) {8} else {0}

            if(!item.isBlur){
                llBlur.visibility = View.GONE
            }else{
                llBlur.visibility = View.VISIBLE
            }

            tvAddToWishlist.visibility = if(item.isLike) {8} else {0}
            rlWishlistAdded.visibility = if(item.isLike) {View.VISIBLE} else {8}
            ivLikeUnLike.visibility = if (item.isLike){0} else {8}
            tvAddToBag.visibility = if(item.totalQty == 0) {View.VISIBLE} else {8}
            rlBagAdded.visibility = if (item.totalQty == 0){ View.GONE}else{View.VISIBLE}
            itemView.tag = item

            ivAdd.setOnClickListener { fragmentProducts.addToBlur(item,position,true) }
            tvAddToWishlist.setOnClickListener{ fragmentProducts.likeUnLike(position)}
            ivBlurCLose.setOnClickListener { fragmentProducts.addToBlur(item,position,false) }
            tvAddToBag.setOnClickListener { fragmentProducts.addToCart(true,position)}
            ivPlus.setOnClickListener{fragmentProducts.addToCart(true,position)}
            ivMins.setOnClickListener{fragmentProducts.addToCart(false,position)}
            rlAdded.setOnClickListener{fragmentProducts.addToBlur(item,position,true)}

            itemView.setOnClickListener {
                Handler(Looper.getMainLooper()).postDelayed({ onItemClickListener?.onItemClick(it,item) },200)
            }

        }

    }


}