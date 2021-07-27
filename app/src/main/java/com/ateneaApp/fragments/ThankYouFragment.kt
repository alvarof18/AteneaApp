package com.ateneaApp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.ateneaApp.R
import com.ateneaApp.activities.HomeActivity

class ThankYouFragment : BaseFragment() {

    private lateinit var ivBack: ImageView
    private lateinit var rlHome: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initComponents(view: View?) {

        ivBack = view?.findViewById(R.id.fragment_thankyou_ivBack)!!
        rlHome = view.findViewById((R.id.fragment_thankyou_rlHome))

        ivBack.setOnClickListener(this)
        rlHome.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout = layoutInflater.inflate(R.layout.fragment_thank_you, container,false)
        initComponents(layout)
        // Inflate the layout for this fragment
        return layout
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)

        when (p0){
            ivBack -> {openFragment()}
            rlHome -> {openFragment()}
        }
    }

    private fun openFragment(){
        val intent = Intent(context,HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}