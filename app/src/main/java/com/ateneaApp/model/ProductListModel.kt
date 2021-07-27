package com.ateneaApp.model

data class ProductListModel(
    val color: String = "",
    var isBlur: Boolean = false,
    var isLike: Boolean = false,
    val productImage: Int = 0,
    val productName: String= "",
    val productPrice: String ="",
    var totalQty: Int = 0,
    val unit: String=""
)
