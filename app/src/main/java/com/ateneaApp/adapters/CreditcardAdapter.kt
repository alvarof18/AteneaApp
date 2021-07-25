package com.ateneaApp.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.customviews.CustomTextView
import com.ateneaApp.model.CreditcardModel

class CreditcardAdapter(val listCard:List<CreditcardModel>, val context: Context) : RecyclerView.Adapter<CreditcardAdapter.VHDataCreditCard>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataCreditCard {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_creditcardlist,parent,false)
        return VHDataCreditCard(layout)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: VHDataCreditCard, position: Int) {
        holder.bind(listCard[position], position)
    }

    override fun getItemCount(): Int = listCard.size

    inner class VHDataCreditCard(view: View) : RecyclerView.ViewHolder(view){

        private val tvName: CustomTextView = view.findViewById(R.id.row_crediview_tvCardOwnerName)
        private val tvCardName: CustomTextView = view.findViewById(R.id.row_crediview_tvCardName)
        private val tvExpiredate: CustomTextView = view.findViewById(R.id.row_crediview_cvExpiredate)
        private val tvCardNumber: CustomTextView = view.findViewById(R.id.row_crediview_tvCardNumber)
        private val tvSignature: CustomTextView = view.findViewById(R.id.row_crediview_tvSignature)
        private val llContainer: LinearLayout = view.findViewById(R.id.row_crediview_cvContainer)

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(item:CreditcardModel, position: Int){

            tvName.text = item.name
            tvCardName.text = item.cardname
            tvCardNumber.text = item.cardnumber
            tvExpiredate.text = item.Expiredate
            tvSignature.text = item.Signature
            itemView.tag = item

            when (position){
                0 -> {llContainer.background = context.resources.getDrawable(R.drawable.drawable_credicard_blue,context.theme) }
                1 -> {llContainer.background = context.resources.getDrawable(R.drawable.drawable_credicard_yello,context.theme)}
                else -> {llContainer.background = context.resources.getDrawable(R.drawable.drawable_credicard_blue,context.theme)}
            }

        }
    }

}