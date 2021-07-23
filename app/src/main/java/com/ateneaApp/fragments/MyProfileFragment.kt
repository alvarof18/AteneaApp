package com.ateneaApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.AddressListAdapter
import com.ateneaApp.data.TempListData
import com.ateneaApp.model.AddressListModel
import com.ateneaApp.util.Utils


class MyProfileFragment : BaseFragment() {

    private lateinit var addressListAdapterNew: AddressListAdapter
    private var addressListModelNewList = mutableListOf<AddressListModel>()
    private lateinit var rvAddress: RecyclerView

    private lateinit var ivBack: ImageView
    private lateinit var llEdit: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initComponents(view: View?) {
        rvAddress = view?.findViewById(R.id.fragment_myprofile_rvAddress)!!
        ivBack = view.findViewById(R.id.fragment_profile_ivBack)
        llEdit = view.findViewById(R.id.fragment_profile_llEdit)

        rvAddress.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        ivBack.setOnClickListener(this)
        llEdit.setOnClickListener(this)
        setAddress()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = layoutInflater.inflate(R.layout.fragment_my_profile,container, false)
        // Inflate the layout for this fragment
        initComponents(layout)
        return layout
    }

    private fun setAddress(){
        addressListModelNewList = TempListData().getCheckoutAddress(requireActivity()) as MutableList<AddressListModel>
        addressListAdapterNew = AddressListAdapter(addressListModelNewList,requireContext(),this)
        rvAddress.adapter = addressListAdapterNew
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        when (p0){
            ivBack -> {activity?.supportFragmentManager?.popBackStack()}
            llEdit -> {Utils().addNextFragment(requireActivity(),ProfileEditFragment(),this,true)}


        }

    }

}