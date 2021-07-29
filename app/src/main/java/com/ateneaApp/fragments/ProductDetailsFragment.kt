package com.ateneaApp.fragments


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.ateneaApp.R
import com.ateneaApp.adapters.ProductPagerAdapter
import com.ateneaApp.adapters.SimilarProductAdapter
import com.ateneaApp.customviews.LinePageIndicator
import com.ateneaApp.customviews.ViewAnimationUtils
import com.ateneaApp.dialogs.DialogFragmentColor

class ProductDetailsFragment : BaseFragment() {

    private lateinit var ivBack: ImageView
    private lateinit var ivCart: ImageView
    private lateinit var ivMore: ImageView
    private lateinit var ivDetails: ImageView
    private lateinit var ivSallareInfo: ImageView
    private lateinit var ivRattingAndRaviews: ImageView

    private lateinit var llMore: LinearLayout
    private lateinit var llSallarInfo: LinearLayout
    private lateinit var llRatting: LinearLayout
    private lateinit var llReviews: LinearLayout
    private lateinit var llColor: LinearLayout

    private lateinit var tvMainCatName: TextView
    private lateinit var tvDetails: TextView
    private lateinit var tvSallareInfo: TextView
    private lateinit var tvRatting: TextView

    private lateinit var vpSlider: ViewPager
    private lateinit var rvSimilarProduct: RecyclerView

    private lateinit var imagePagerAdapter: ProductPagerAdapter
    private lateinit var similarProductAdapter: SimilarProductAdapter

    private lateinit var indicator: LinePageIndicator

    private  val similarProList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initComponents(view: View?) {
        ivBack = view?.findViewById(R.id.fragment_product_details_ivBack)!!
        ivCart = view.findViewById(R.id.fragment_product_details_ivCart)
        ivMore = view.findViewById(R.id.fragment_product_details_ivMore)
        ivDetails = view.findViewById(R.id.fragment_product_details_ivDetails)
        ivSallareInfo = view.findViewById(R.id.fragment_product_details_ivSallareInfo)
        ivRattingAndRaviews = view.findViewById(R.id.fragment_product_details_ivRattingAndRaviews)

        indicator = view.findViewById(R.id.fragment_product_details_indicator)

        llMore = view.findViewById(R.id.fragment_product_details_llMore)
        llSallarInfo = view.findViewById(R.id.fragment_product_details_llSallarInfo)
        llRatting = view.findViewById(R.id.fragment_product_details_llRatting)
        llReviews = view.findViewById(R.id.fragment_product_details_llReviews)
        llColor = view.findViewById(R.id.fragment_product_details_llColor)

        tvMainCatName = view.findViewById(R.id.fragment_product_details_tvMainCatName)
        tvDetails = view.findViewById(R.id.fragment_product_details_tvDetails)
        tvSallareInfo = view.findViewById(R.id.fragment_product_details_tvSallareInfo)
        tvRatting = view.findViewById(R.id.fragment_product_details_tvRatting)

        vpSlider = view.findViewById(R.id.fragment_product_details_vpSlider)
        rvSimilarProduct = view.findViewById(R.id.fragment_product_details_rvSimilarProduct)
        rvSimilarProduct.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        ivDetails.setBackgroundResource(R.mipmap.ic_expande)
        ivSallareInfo.setBackgroundResource(R.mipmap.ic_expande)
        ivRattingAndRaviews.setBackgroundResource(R.mipmap.ic_expande)

        ivBack.setOnClickListener(this)
        ivMore.setOnClickListener(this)
        ivDetails.setOnClickListener(this)
        ivSallareInfo.setOnClickListener(this)
        ivRattingAndRaviews.setOnClickListener(this)
        llColor.setOnClickListener(this)
        setUpSliderImages()
        Handler(Looper.getMainLooper()).postDelayed({ setUpSimilarProduct()},300)
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        when(p0){
            ivBack -> {activity?.supportFragmentManager?.popBackStack()}
            ivMore -> {
                ViewAnimationUtils.expandView(llMore,activity)
                ivMore.visibility = View.GONE
            }
            ivDetails ->{
                if (tvDetails.visibility == View.VISIBLE) {
                    ViewAnimationUtils.callspanView(tvDetails, activity)
                    ivDetails.setBackgroundResource(R.mipmap.ic_expande)
                    return
                }
                ViewAnimationUtils.expandView(tvDetails, activity)
                ivDetails.setBackgroundResource(R.mipmap.ic_collapse)
            }
            ivSallareInfo -> {
                if(llSallarInfo.visibility == View.VISIBLE){
                    tvSallareInfo.text = activity?.getString(R.string.sellar_details)
                    ViewAnimationUtils.callspanView(llSallarInfo, activity)
                    ivSallareInfo.setBackgroundResource(R.mipmap.ic_expande)
                }else{
                    tvSallareInfo.text = activity?.getString(R.string.sold_by)
                    ViewAnimationUtils.expandView(llSallarInfo, activity)
                    ivSallareInfo.setBackgroundResource(R.mipmap.ic_collapse)
                }

            }

            ivRattingAndRaviews -> {
                if(llRatting.visibility == View.VISIBLE){
                    tvRatting.visibility = View.VISIBLE
                    ViewAnimationUtils.callspanView(llRatting, activity)
                    ViewAnimationUtils.callspanView(llReviews, activity)
                    ivRattingAndRaviews.setBackgroundResource(R.mipmap.ic_expande)
                }else{
                   tvRatting.visibility = View.VISIBLE
                    ViewAnimationUtils.expandView(llRatting, activity);
                    ViewAnimationUtils.expandView(llReviews, activity);
                    ivRattingAndRaviews.setBackgroundResource(R.mipmap.ic_collapse);
                }
            }

            llColor -> {
                DialogFragmentColor().show(requireActivity().supportFragmentManager, "")
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_product_details, container, false)
        initComponents(layout)
        return layout
    }

    private fun setUpSliderImages(){

        val pagerImgList = mutableListOf<Int>()

        vpSlider.clipToPadding = false
        vpSlider.setPadding(40,0,40,0)
        vpSlider.pageMargin = 20
        pagerImgList.add(R.mipmap.bg_product_details_1)
        pagerImgList.add(R.mipmap.bg_product_details_2)
        pagerImgList.add(R.mipmap.bg_product_details_4)

        imagePagerAdapter = ProductPagerAdapter(pagerImgList,requireContext())
        vpSlider.adapter = imagePagerAdapter
        indicator.setViewPager(vpSlider)
    }

    private fun setUpSimilarProduct(){
        similarProList.add(R.mipmap.bg_similar_product_1)
        similarProList.add(R.mipmap.bg_similar_product_2)
        similarProList.add(R.mipmap.bg_similar_product_3)
        similarProList.add(R.mipmap.bg_similar_product_4)
        similarProList.add(R.mipmap.bg_similar_product_1)
        similarProductAdapter = SimilarProductAdapter(similarProList,requireContext())
        rvSimilarProduct.adapter = similarProductAdapter

    }

}