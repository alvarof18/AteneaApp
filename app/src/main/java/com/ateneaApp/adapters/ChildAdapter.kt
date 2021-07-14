package com.ateneaApp.adapters

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.fragments.CategoryListFragment
import com.ateneaApp.model.MenuCategoryModel
import com.ateneaApp.model.MenuSubCategoryModel

class ChildAdapter(val listMenusub:List<MenuSubCategoryModel>,val menuCategoryModel2:MenuCategoryModel, val categoryListFragment2: CategoryListFragment) : RecyclerView.Adapter<ChildAdapter.ViewHolderData>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
     val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_menu_child,parent,false)
     return ViewHolderData(layout)
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
    holder.bindData(listMenusub[position], position)
    }

    override fun getItemCount(): Int = listMenusub.size

    class ViewHolderData(val view: View) : RecyclerView.ViewHolder(view){
        private val tvName: TextView = view.findViewById(R.id.row_child_subctaegoryname)



        fun bindData(menuSubCategoryModel: MenuSubCategoryModel, i: Int) {
            tvName.text = menuSubCategoryModel.sub_categoryname
            itemView.tag = menuSubCategoryModel
            itemView.setOnClickListener {
                // Logica
            }
        }

    }
}