package com.ateneaApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ateneaApp.R

class ProfileEditFragment : BaseFragment() {

    private lateinit var iv_close:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initComponents(view: View?) {
        iv_close = view?.findViewById(R.id.fragment_editprofile_ivBack)!!
        iv_close.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        if(p0 == iv_close){
                activity?.supportFragmentManager?.popBackStack()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = layoutInflater.inflate(R.layout.fragment_profile_edit,container,false)
        initComponents(layout)
        return layout
    }


}