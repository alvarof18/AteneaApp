package com.ateneaApp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.customviews.CustomTextView
import com.ateneaApp.model.AddressListModel

class ProfileAddressListAdapter(private val listAddress:List<AddressListModel>) : RecyclerView.Adapter<ProfileAddressListAdapter.VHDataProfileAddress>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataProfileAddress {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_address_list,parent,false)
        return VHDataProfileAddress(layout)
       }

    override fun onBindViewHolder(holder: VHDataProfileAddress, position: Int) {
       holder.bind(listAddress[position])
    }

    override fun getItemCount(): Int = listAddress.size

    inner class VHDataProfileAddress(view:View) : RecyclerView.ViewHolder(view){

        private val tvAddress: CustomTextView = view.findViewById(R.id.row_addresslistnew_tvAddress)
        private val tvName: CustomTextView = view.findViewById(R.id.row_addresslistnew_tvName)
        private val ivCheck: ImageView = view.findViewById(R.id.row_addresslistnew_tvCheck)

        fun bind(item:AddressListModel){
            tvAddress.text = item.address
            tvName.text = item.name

            if (!item.isSelected){
                ivCheck.setBackgroundResource(R.mipmap.ic_uncheck_grey)
            }else{
                ivCheck.setBackgroundResource(R.mipmap.ic_check_pink)
            }
        }

    }

}