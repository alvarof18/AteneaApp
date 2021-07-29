package com.ateneaApp.fragments

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.ProductListAdapter
import com.ateneaApp.data.TempListData
import com.ateneaApp.model.ProductListModel
import com.ateneaApp.util.Utils


class ProductListFragment : BaseFragment(), ProductListAdapter.OnItemClickListener {

    private lateinit var rvProductList: RecyclerView
    private lateinit var productListAdapter: ProductListAdapter

    private var productListModelArrayList: List<ProductListModel> = emptyList()

    private lateinit var factivity: FragmentActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        factivity = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout = inflater.inflate(R.layout.fragment_product_list, container, false)
        initComponents(layout)
        // Inflate the layout for this fragment
        return layout
    }

    override fun initComponents(view: View?) {
        rvProductList = view?.findViewById(R.id.fragment_productlist_rvProductList)!!
        rvProductList.setHasFixedSize(false)
        rvProductList.layoutManager = GridLayoutManager(context,2)

        productListAdapter = ProductListAdapter(productListModelArrayList,requireContext(),this)

        rvProductList.adapter = productListAdapter
        productListAdapter.onItemClickListener = this
        getListDataAsyncTaskRunner().execute(*arrayOf(""))
    }

    fun addToBlur(productListModel: ProductListModel, i: Int, z: Boolean) {
        productListModelArrayList[i].isBlur = z
        productListAdapter.notifyDataSetChanged()
    }

    fun likeUnLike(i: Int) {
        productListModelArrayList[i].isLike = !productListModelArrayList[i].isLike
        productListAdapter.notifyDataSetChanged()
    }

    fun addToCart(z: Boolean, i: Int) {
        if (z) {
            productListModelArrayList[i].totalQty = productListModelArrayList[i].totalQty + 1
        } else {
            val totalQty = productListModelArrayList[i].totalQty
            if (totalQty < 1) {
                productListModelArrayList[i].totalQty = 0
            } else {
                productListModelArrayList[i].totalQty = totalQty - 1
            }
        }
        productListAdapter.notifyDataSetChanged()
    }

     inner  class getListDataAsyncTaskRunner: AsyncTask<String, String, String>() {
        override fun doInBackground(vararg p0: String?): String {
            productListModelArrayList = TempListData().getProductList(factivity)
            return ""
        }

        override fun onPostExecute(result: String?) {
            productListAdapter.addData(productListModelArrayList)
        }
    }

    override fun onItemClick(view: View, productListModel: ProductListModel) {
        val bundle: Bundle
        //bundle.putParcelable(this.activity.getString(C0462R.string.bdl_model), productListModel);
        //productDetailsFragment.setArguments(bundle);
        Utils().addNextFragmentFadeAnim(requireActivity(),ProductDetailsFragment(),this)
    }

}