package com.ateneaApp.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ateneaApp.R
import com.ateneaApp.util.FontCache


class CustomTextView(context: Context, attributeSet: AttributeSet?) :
    AppCompatTextView(context, attributeSet) {
    private val fontType: Typeface? = null

    init {
        if (!isInEditMode) {
            val obtainStyledAttributes =
                context.obtainStyledAttributes(attributeSet, R.styleable.CustomTextView)
            val string = obtainStyledAttributes.getString(0)
            if (string != null) {
                val instance: FontCache = FontCache().getInstance()
                setTypeface(instance.getFont(context, "fonts/$string"))
            }
            obtainStyledAttributes.recycle()
        }
    }
}
