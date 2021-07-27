package com.ateneaApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ateneaApp.R
import com.ateneaApp.adapters.HomeMainCategoryAdapter
import com.ateneaApp.adapters.NewAriiavalAdapter
import com.ateneaApp.adapters.ShopAdapter
import com.ateneaApp.adapters.TrendingAdapter
import com.ateneaApp.util.Utils
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter

class FeedHomeFragment : BaseFragment(), HomeMainCategoryAdapter.OnItemClickListener {

    private lateinit var rvMainCategory: RecyclerView
    private lateinit var rvTrending: RecyclerView
    private lateinit var rvNewArriaval: RecyclerView
    private lateinit var discreteScrollView: DiscreteScrollView

    private lateinit var shopAdapter: InfiniteScrollAdapter<ShopAdapter.VHDataShop>
    private lateinit var homeMainCategoryAdapter: HomeMainCategoryAdapter
    private lateinit var trendingAdapter: TrendingAdapter
    private lateinit var newAriiavalAdapter: NewAriiavalAdapter


    private val pagerImgList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initComponents(view: View?) {

        rvMainCategory = view?.findViewById(R.id.fragment_home_rvMainCategory)!!
        rvTrending = view.findViewById(R.id.fragment_home_rvTrending)
        rvNewArriaval = view.findViewById(R.id.fragment_home_rvNewArriaval)
        discreteScrollView = view.findViewById(R.id.product_picker)
        rvMainCategory.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvTrending.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvNewArriaval.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        setUpSliderImages()
        setUpHomeMainCategory()
        setUpTrendingCategory()
        setUpNewArriavalCategory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val layout: View = layoutInflater.inflate(R.layout.fragment_home, container, false)
        initComponents(layout)
        return layout
    }

    private fun setUpSliderImages() {
        pagerImgList.add(R.mipmap.offer_1)
        pagerImgList.add(R.mipmap.offer_2)
        pagerImgList.add(R.mipmap.offer_3)
        pagerImgList.add(R.mipmap.offer_1)
        pagerImgList.add(R.mipmap.offer_2)
        pagerImgList.add(R.mipmap.offer_3)
        discreteScrollView.setOrientation(DSVOrientation.HORIZONTAL)
        shopAdapter = InfiniteScrollAdapter.wrap(ShopAdapter(pagerImgList, requireContext()))
        discreteScrollView.adapter = shopAdapter
    }

    private fun setUpHomeMainCategory() {
        val pagerImgList = mutableListOf<Int>()
        pagerImgList.add(R.mipmap.bg_home_category_11)
        pagerImgList.add(R.mipmap.bg_home_category_22)
        pagerImgList.add(R.mipmap.bg_home_category_33)
        pagerImgList.add(R.mipmap.bg_home_category_44)
        pagerImgList.add(R.mipmap.bg_home_category_55)
        homeMainCategoryAdapter = HomeMainCategoryAdapter(pagerImgList, requireContext())
        homeMainCategoryAdapter.onItemClickListener = this
        rvMainCategory.adapter = homeMainCategoryAdapter
    }

    private fun setUpTrendingCategory() {
        val pagerImgList = mutableListOf<Int>()
        pagerImgList.add(R.mipmap.bg_trending_1)
        pagerImgList.add(R.mipmap.bg_trending_2)
        pagerImgList.add(R.mipmap.bg_trending_3)
        pagerImgList.add(R.mipmap.bg_trending_1)
        pagerImgList.add(R.mipmap.bg_trending_2)
        pagerImgList.add(R.mipmap.bg_trending_3)
        trendingAdapter = TrendingAdapter(pagerImgList, requireContext())
        rvTrending.adapter = trendingAdapter

    }

    private fun setUpNewArriavalCategory() {
        val pagerImgList = mutableListOf<Int>()
        pagerImgList.add(R.mipmap.bg_arriaval_1)
        pagerImgList.add(R.mipmap.bg_arriaval_2)
        pagerImgList.add(R.mipmap.bg_arriaval_3)
        pagerImgList.add(R.mipmap.bg_arriaval_1)
        pagerImgList.add(R.mipmap.bg_arriaval_2)
        pagerImgList.add(R.mipmap.bg_arriaval_3)
        newAriiavalAdapter= NewAriiavalAdapter(pagerImgList, requireContext())
        rvNewArriaval.adapter = newAriiavalAdapter
    }

    override fun onItemClick(view: View?, i: Int) {
        Utils().addNextFragment(requireActivity(), SubCategoryFragment(), this, false);
    }

}