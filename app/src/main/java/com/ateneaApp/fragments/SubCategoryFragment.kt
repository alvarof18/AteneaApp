package com.ateneaApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.ateneaApp.R
import com.ateneaApp.adapters.ShopAdapter
import com.google.android.material.tabs.TabLayout
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter

class SubCategoryFragment : BaseFragment() {

    private lateinit var tlCategory: TabLayout
    private lateinit var discreteScrollView:DiscreteScrollView

    private lateinit var ivBack: ImageView

    private  var pagerImgList = mutableListOf<Int>()
    private lateinit var shopAdapter: InfiniteScrollAdapter<ShopAdapter.VHDataShop>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initComponents(view: View?) {
        tlCategory = view?.findViewById(R.id.fragment_category_tlCategory)!!
        discreteScrollView = view.findViewById(R.id.product_picker)
        ivBack = view.findViewById(R.id.fragment_category_ivBack)


        ivBack.setOnClickListener(this)

        setUpTablayou()
        setUpSliderImages()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout = inflater.inflate(R.layout.fragment_sub_category, container, false)
        initComponents(layout)
        // Inflate the layout for this fragment
        return layout
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)

        when(p0){
            ivBack -> {activity?.supportFragmentManager?.popBackStack()}
        }
    }

    private fun setUpTablayou(){
        val stringArray = resources.getStringArray(R.array.sub_category)
        val newTab = tlCategory.newTab()
        val newTab2 = tlCategory.newTab()
        val newTab3 = tlCategory.newTab()
        val newTab4 = tlCategory.newTab()

        newTab.text = stringArray[0].toString()
        newTab2.text = stringArray[1]
        newTab3.text = stringArray[2]
        newTab4.text = stringArray[3]

        tlCategory.addTab(newTab)
        tlCategory.addTab(newTab2)
        tlCategory.addTab(newTab3)
        tlCategory.addTab(newTab4)

        tlCategory.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
             when(tab?.position){
                 0 -> {openFragment(ProductListFragment())}
                 1 -> {openFragment(ProductListFragment())}
                 2 -> {openFragment(ProductListFragment())}
                 3 -> {openFragment(ProductListFragment())}
             }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        openFragment(ProductListFragment())
    }

    private fun setUpSliderImages(){

        pagerImgList.add(R.mipmap.offer_1)
        pagerImgList.add(R.mipmap.offer_2)
        pagerImgList.add(R.mipmap.offer_3)
        pagerImgList.add(R.mipmap.offer_1)
        pagerImgList.add(R.mipmap.offer_2)
        pagerImgList.add(R.mipmap.offer_3)

        discreteScrollView.setOrientation(DSVOrientation.HORIZONTAL)
        shopAdapter = InfiniteScrollAdapter.wrap(ShopAdapter(pagerImgList,requireContext()))
        discreteScrollView.adapter = shopAdapter
    }

    fun openFragment(fragment:Fragment){
        val framgmentManger = activity?.supportFragmentManager?.beginTransaction()!!
        framgmentManger.replace(R.id.fragment_category_flProductContainer,fragment,fragment.javaClass.simpleName)
        framgmentManger.commit()
    }


}