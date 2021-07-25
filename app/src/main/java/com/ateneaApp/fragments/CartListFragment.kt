package com.ateneaApp.fragments

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.CartListAdapter
import com.ateneaApp.data.TempListData
import com.ateneaApp.model.CartlistModel
import com.ateneaApp.util.Utils

class CartListFragment : BaseFragment() {

    private lateinit var cartListAdapter: CartListAdapter
    private var productListModelArrayList = mutableListOf<CartlistModel>()

    private lateinit var  rvProductList: RecyclerView
    private lateinit var  tvTotalPrice: TextView
    private lateinit var  rlEmpty: RelativeLayout
    private lateinit var  tvCheckOut: TextView
    private lateinit var  ivMore: ImageView
    private lateinit var rlMore: LinearLayout

    val activity:Activity = Activity()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
           val layout = layoutInflater.inflate(R.layout.fragment_cart_list, container, false)
           initComponents(layout)
           return layout
    }

    override fun initComponents(view: View?) {

        val tvCartCount: TextView = view?.findViewById(R.id.fragment_cartlist_tvCartCount)!!
        val tvSubTotal: TextView = view.findViewById(R.id.fragment_cartlist_tvSubTotal)
        val tvTaxTotal: TextView = view.findViewById(R.id.fragment_cartlist_tvTax)


        rlMore = view.findViewById(R.id.fragment_cartlist_rlMore)
        tvCheckOut = view.findViewById(R.id.fragment_cartlist_tvCheckout)
        rvProductList = view.findViewById(R.id.fragment_cartlist_rvProductList) !!
        rlEmpty= view.findViewById(R.id.fragment_cartlist_rlEmpty)
        tvTotalPrice = view.findViewById(R.id.fragment_cartlist_tvTotalPrice)
        ivMore = view.findViewById(R.id.fragment_cartlist_ivMote)

        ivMore.setOnClickListener(this)
        tvCheckOut.setOnClickListener(this)
        getListData()
        tvTotalPrice.text = getString(R.string.dolar) + getTotalPrice().toString()
        rvProductList.layoutManager = LinearLayoutManager(context)
        rlMore.visibility = View.GONE

        ivMore.setBackgroundResource(R.mipmap.ic_checkout_up)
    }

    override fun onClick(view: View?) {

        if (view == tvCheckOut) {
            Utils().addNextFragment(requireActivity(),CheckOutFragmnet(),this,true)
        } else if (view != ivMore) {
        } else {
            if (rlMore.visibility == View.VISIBLE) {
                rlMore.visibility = View.GONE
                ivMore.setBackgroundResource(R.mipmap.ic_checkout_up)
            } else {
                rlMore.visibility = View.VISIBLE
                ivMore.setBackgroundResource(R.mipmap.ic_checkout_down)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val itemMenu: MenuItem = menu.findItem(R.id.menu_left)
        itemMenu.isVisible = false
    }

    private fun getTotalPrice(): Int {
        var total = 0

        for (product in productListModelArrayList) {
            total += product.productQuanity * product.productPrice
        }
        return total
    }

    private fun getListData() {
        val activity = requireActivity()
        productListModelArrayList = TempListData().getCartList(activity) as MutableList<CartlistModel>
        cartListAdapter = CartListAdapter(requireContext(),productListModelArrayList,this)
        rvProductList.adapter = cartListAdapter
    }

    fun addToCart(z: Boolean, i: Int) {
        if (z) {
            productListModelArrayList[i].productQuanity += 1
        } else {
            if (productListModelArrayList[i].productQuanity > 1){
                productListModelArrayList[i].productQuanity -+ 1
            }
        }
        cartListAdapter.notifyDataSetChanged()
        tvTotalPrice.text = getString(R.string.dolar) + getTotalPrice().toString()
    }

    fun deleteItem(position:Int){
        productListModelArrayList.removeAt(position)
        cartListAdapter.notifyDataSetChanged()
        tvTotalPrice.text = getString(R.string.dolar) + getTotalPrice().toString()

        if(productListModelArrayList.size == 0){
            rlEmpty.visibility = View.VISIBLE
            rvProductList.visibility = View.GONE
        }

    }
}