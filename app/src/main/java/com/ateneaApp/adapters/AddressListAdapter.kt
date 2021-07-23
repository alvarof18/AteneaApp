package com.ateneaApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.customviews.CustomTextView
import com.ateneaApp.fragments.CheckOutFragmnet
import com.ateneaApp.fragments.MyProfileFragment
import com.ateneaApp.model.AddressListModel

class AddressListAdapter(private val listAddress:List<AddressListModel>, val context:Context, val myProfileFragment: MyProfileFragment) : RecyclerView.Adapter<AddressListAdapter.VHDataAddress>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataAddress {
    val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_address_list,parent,false)
        return VHDataAddress(layout)
    }

    override fun onBindViewHolder(holder: VHDataAddress, position: Int) {
        holder.bind(listAddress[position],position)
    }

    override fun getItemCount(): Int = listAddress.size

    inner class VHDataAddress(view: View) : RecyclerView.ViewHolder(view){
        private val tvAddress: CustomTextView = view.findViewById(R.id.row_addresslistnew_tvAddress)
        private val tvName: CustomTextView = view.findViewById(R.id.row_addresslistnew_tvName)
        private val ivCheck: ImageView = view.findViewById(R.id.row_addresslistnew_tvCheck)

        fun bind(item:AddressListModel, position: Int){
            tvAddress.text = item.address
            tvName.text = item.name

            if (!item.isSelected){
                ivCheck.setBackgroundResource(R.mipmap.ic_uncheck_grey)
            }else{
                ivCheck.setBackgroundResource(R.mipmap.ic_check_pink)
            }
        //    itemView.setOnClickListener { checkOutFragmnet.SelectedAddress(position)}
        }

    }

}