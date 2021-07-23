package com.ateneaApp.fragments

import AteneaAplication
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.ateneaApp.R
import com.ateneaApp.util.Utils

class MyAccountFragment : BaseFragment() {

    private lateinit var cvMyOrder:CardView
    private lateinit var cvLng: CardView
    private lateinit var cvSetting: CardView
    private lateinit var cvStore: CardView
    private lateinit var cvSupport: CardView
    private lateinit var ivProfile:ImageView

    private lateinit var activity:Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initComponents(view: View?) {
        cvMyOrder = view?.findViewById(R.id.fragment_myaccount_rvOrder)!!
        cvLng = view.findViewById(R.id.fragment_myaccount_rvChangeLanguage)
        cvSetting = view.findViewById(R.id.fragment_myaccount_rvSetting)
        cvStore = view.findViewById(R.id.fragment_myaccount_rvStore)
        cvSupport = view.findViewById(R.id.fragment_myaccount_rvSupport)

        ivProfile = view.findViewById(R.id.fragment_myaccount_ivProfile)
        cvMyOrder.setOnClickListener(this)
        ivProfile.setOnClickListener(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = layoutInflater.inflate(R.layout.fragment_my_account,container,false)
        initComponents(layout)
        return layout
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        when (p0) {
            cvMyOrder -> {Utils().addNextFragment(requireActivity(),OrderListFragment(),this,false)}
            ivProfile -> {Utils().addNextFragment(requireActivity(),MyProfileFragment(),this,false)}
        }

    }

}