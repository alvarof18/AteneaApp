package com.ateneaApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.SimilarProductAdapter

class OrderDetailsFragment : BaseFragment() {

    var orderListAdapter: SimilarProductAdapter? = null
    private lateinit var rvProductList: RecyclerView
    private lateinit var ivBack: ImageView

    private var similarProList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = layoutInflater.inflate(R.layout.fragment_order_details, container, false)
        initComponents(layout)
        setHasOptionsMenu(true)
        return layout
    }

    override fun initComponents(view: View?) {
        rvProductList = view?.findViewById(R.id.fragment_order_details_rvOrder)!!
        ivBack = view.findViewById(R.id.fragment_order_details_ivBack)
        rvProductList.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        ivBack.setOnClickListener(this)
        getListData()
    }

    private fun getListData(){
        similarProList.add(R.mipmap.bg_similar_product_1)
        similarProList.add(R.mipmap.bg_similar_product_2)
        similarProList.add(R.mipmap.bg_similar_product_3)
        similarProList.add(R.mipmap.bg_similar_product_4)
        orderListAdapter = SimilarProductAdapter(similarProList,requireContext())
        rvProductList.adapter = orderListAdapter
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        if(p0 == ivBack){
          activity?.supportFragmentManager?.popBackStack()
        }
    }
}