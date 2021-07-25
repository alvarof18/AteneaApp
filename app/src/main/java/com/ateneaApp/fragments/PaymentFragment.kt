package com.ateneaApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.CreditcardAdapter
import com.ateneaApp.data.TempListData
import com.ateneaApp.model.CreditcardModel
import com.ateneaApp.util.Utils


class PaymentFragment : BaseFragment() {

    private lateinit var rvCreditcatd: RecyclerView
    private lateinit var creditcardModelList: List<CreditcardModel>
    private lateinit var creditcardAdapter: CreditcardAdapter

    private lateinit var ivBack: ImageView
    private lateinit var ivDebit: ImageView
    private lateinit var ivNetBanking: ImageView
    private lateinit var ivUpi: ImageView
    private lateinit var ivCod: ImageView

    private lateinit var tvProcess: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initComponents(view: View?) {
        rvCreditcatd = view?.findViewById(R.id.fragment_payment_rvCardList)!!
        ivBack = view.findViewById(R.id.fragment_payment_ivBack)
        ivDebit = view.findViewById(R.id.fragment_payment_ivCreditCard)
        ivNetBanking = view.findViewById(R.id.fragment_payment_ivNetBanking)
        ivUpi = view.findViewById(R.id.fragment_payment_ivUpi)
        ivCod = view.findViewById(R.id.fragment_payment_ivCod)
        tvProcess = view.findViewById(R.id.fragment_payment_tvProcess)

        rvCreditcatd.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        ivBack.setOnClickListener(this)
        ivDebit.setOnClickListener(this)
        ivNetBanking.setOnClickListener(this)
        ivUpi.setOnClickListener(this)
        ivCod.setOnClickListener(this)
        tvProcess.setOnClickListener(this)

        ivDebit.setBackgroundResource(R.mipmap.ic_check_pink)
        ivNetBanking.setBackgroundResource(R.mipmap.ic_uncheck_grey)
        ivUpi.setBackgroundResource(R.mipmap.ic_uncheck_grey)
        ivCod.setBackgroundResource(R.mipmap.ic_uncheck_grey)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = layoutInflater.inflate(R.layout.fragment_payment,container,false)
        initComponents(layout)
        getListData()
        return layout
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)

        when(p0){
            ivBack -> {requireActivity().supportFragmentManager.popBackStack()}
            ivDebit -> {
                ivDebit.setBackgroundResource(R.mipmap.ic_check_pink)
                ivNetBanking.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivUpi.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivCod.setBackgroundResource(R.mipmap.ic_uncheck_grey)
            }
            ivNetBanking -> {
                ivNetBanking.setBackgroundResource(R.mipmap.ic_check_pink)
                ivUpi.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivCod.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivDebit.setBackgroundResource(R.mipmap.ic_uncheck_grey)
            }

            ivUpi -> {
                ivUpi.setBackgroundResource(R.mipmap.ic_check_pink)
                ivDebit.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivCod.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivNetBanking.setBackgroundResource(R.mipmap.ic_uncheck_grey)
            }

            ivCod -> {
                ivCod.setBackgroundResource(R.mipmap.ic_check_pink)
                ivDebit.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivUpi.setBackgroundResource(R.mipmap.ic_uncheck_grey)
                ivNetBanking.setBackgroundResource(R.mipmap.ic_uncheck_grey)
            }

            tvProcess -> {Utils().addNextFragment(requireActivity(),ThankYouFragment(),this,false)}
        }

    }

    private fun getListData(){
        creditcardModelList = TempListData().getCreditcardList(requireActivity())
        creditcardAdapter = CreditcardAdapter(creditcardModelList,requireContext())
        rvCreditcatd.adapter = creditcardAdapter
    }
}