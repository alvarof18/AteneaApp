package com.ateneaApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.AddressListAdapter
import com.ateneaApp.adapters.OrderSummaryListAdapter
import com.ateneaApp.customviews.CustomTextView
import com.ateneaApp.data.TempListData
import com.ateneaApp.model.AddressListModel
import com.ateneaApp.model.CheckoutListModel
import com.ateneaApp.util.Utils


class CheckOutFragmnet : BaseFragment() {

    private var addressListAdapterNew: AddressListAdapter? = null
    private var addressListModelNewList: List<AddressListModel>? = null

    private lateinit var orderListAdapter:OrderSummaryListAdapter
    private lateinit var orderListModelNewList: List<CheckoutListModel>

    private var rvAddressList: RecyclerView? = null
    private var rvOrderList: RecyclerView? = null

    private lateinit var ivFastDelivery:ImageView
    private lateinit var ivStandarDelivery:ImageView
    private lateinit var ivBack: ImageView
    private lateinit var tvConfirmOreder: CustomTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       }

    override fun initComponents(view: View?) {
        rvAddressList = view?.findViewById(R.id.fragment_checkout_rvAddressList)!!
        rvAddressList!!.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        rvOrderList = view.findViewById(R.id.fragment_checkout_rvOrderList)
        rvOrderList!!.layoutManager = LinearLayoutManager(context)

        ivStandarDelivery = view.findViewById(R.id.ivStandardDelivery)
        ivFastDelivery = view.findViewById(R.id.ivFastDelivery)

        ivBack = view.findViewById(R.id.fragment_checkout_ivBack)

        tvConfirmOreder = view.findViewById(R.id.fragment_checkout_tvCheckout)

        ivStandarDelivery.setBackgroundResource(R.mipmap.ic_check_pink)
        ivFastDelivery.setBackgroundResource(R.mipmap.ic_uncheck_grey)

        ivStandarDelivery.setOnClickListener(this)
        ivFastDelivery.setOnClickListener(this)
        ivBack.setOnClickListener(this)
        tvConfirmOreder.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = layoutInflater.inflate(R.layout.fragment_check_out_fragmnet,container,false)
        initComponents(layout)
        setAddress()
        setOrderList()
        return layout
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        when(p0){
            ivStandarDelivery ->{
                ivStandarDelivery.setBackgroundResource(R.mipmap.ic_check_pink)
                ivFastDelivery.setBackgroundResource(R.mipmap.ic_uncheck_grey)
            }

            ivFastDelivery ->{
                ivStandarDelivery.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivFastDelivery.setBackgroundResource(R.mipmap.ic_check_pink)
            }
            ivBack ->{ requireActivity().supportFragmentManager.popBackStack()}
            tvConfirmOreder -> {Utils().addNextFragment(requireActivity(), PaymentFragment(),this,false) }
        }
    }


    private fun setAddress(){
        addressListModelNewList = TempListData().getCheckoutAddress(requireActivity())
        addressListAdapterNew = AddressListAdapter(addressListModelNewList!!,requireContext(),this)
        rvAddressList?.adapter = addressListAdapterNew
    }

    private fun setOrderList(){
        orderListModelNewList = TempListData().getOrderListNewList(requireActivity())
        orderListAdapter = OrderSummaryListAdapter(orderListModelNewList)
        rvOrderList?.adapter = orderListAdapter
    }

    fun SelectedAddress(position:Int){
        for(i in addressListModelNewList!!.indices){
            addressListModelNewList!![i].isSelected = i == position
            addressListAdapterNew?.addData(addressListModelNewList!!)
        }
    }
 }