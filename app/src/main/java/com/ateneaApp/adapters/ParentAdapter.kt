package com.ateneaApp.adapters

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.fragments.CategoryListFragment
import com.ateneaApp.model.MenuCategoryModel

class ParentAdapter(var activity: Activity, val listMenu:List<MenuCategoryModel>, val categoryListFragment2: CategoryListFragment ) : RecyclerView.Adapter<ParentAdapter.ViewHolderData>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_menu_parent,parent,false)
        return ViewHolderData(layout)
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        holder.bindData(listMenu[position])
    }

    override fun getItemCount(): Int = listMenu.size

   inner class ViewHolderData(val view: View) : RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById(R.id.tvName)
        val rvChild: RecyclerView = view.findViewById(R.id.rvChild)
        val ivMenu: ImageView = view.findViewById(R.id.ivMenu)
        val rlParent: RelativeLayout = view.findViewById(R.id.rlParent)
        val cvCard: CardView = view.findViewById(R.id.cvCard)

        init {
            rvChild.layoutManager = LinearLayoutManager(activity)
            ivMenu.setBackgroundResource(R.mipmap.ic_expand_category)
            cvCard.setCardBackgroundColor(-1)
            rlParent.setOnClickListener {
                if (rvChild.visibility == View.VISIBLE) {
                    rvChild.visibility = View.GONE
                    ivMenu.setBackgroundResource(R.mipmap.ic_expand_category)
                    cvCard.setCardBackgroundColor(-1)
                } else {
                    rvChild.visibility = View.VISIBLE
                    ivMenu.setBackgroundResource(R.mipmap.ic_collapse_category)
                    cvCard.setCardBackgroundColor(Color.parseColor("#D7ECEC"))
                }
            }
        }
        fun bindData(menuCategoryModel: MenuCategoryModel){
            tvName.text = menuCategoryModel.name
            itemView.tag = menuCategoryModel
            val childApadter = ChildAdapter(menuCategoryModel.menuSubCategoryModelArrayList,menuCategoryModel,categoryListFragment2,)
            rvChild.adapter = childApadter
        }

    }
}