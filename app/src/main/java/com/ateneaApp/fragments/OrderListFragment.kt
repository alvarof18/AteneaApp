package com.ateneaApp.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.OrderListAdapter
import com.ateneaApp.data.TempListData
import com.ateneaApp.model.OrderListModel
import com.ateneaApp.util.Utils


class OrderListFragment:BaseFragment() {

    private lateinit var rvProductList: RecyclerView
    private lateinit var ivBack: ImageView

    private lateinit var adapterOrderList: OrderListAdapter

    private var orderListModelList = mutableListOf<OrderListModel>()

    private lateinit var item: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate: View =
            layoutInflater.inflate(R.layout.fragment_order_list, container, false)
        initComponents(inflate)
        return inflate
    }


    override fun initComponents(view: View?) {
        rvProductList = view?.findViewById(R.id.fragment_orderlist_rvOrder)!!
        ivBack = view.findViewById(R.id.fragment_orderlist_ivBack)
        rvProductList.layoutManager = GridLayoutManager(activity,1)
        ivBack.setOnClickListener(this)
        getListData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        item = menu.findItem(R.id.menu_left)
        item.isVisible = false
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        if(p0==ivBack){
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    private fun getListData() {
        orderListModelList = TempListData().getOrderList() as MutableList<OrderListModel>
        adapterOrderList = OrderListAdapter(orderListModelList,requireContext(),this)
        rvProductList.adapter = adapterOrderList
    }

    fun openOrderdetails(orderListModel: OrderListModel?, i: Int) {
        Utils().addNextFragment(requireActivity(),OrderDetailsFragment(),this,false)
    }
}