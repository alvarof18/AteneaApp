package com.ateneaApp.util

import android.content.Context
import android.graphics.Typeface
import java.util.*

class FontCache {

    private val mCache: Hashtable<String, Typeface> = Hashtable()
    private val fontCache = FontCache()

    fun getInstance(): FontCache {
        return fontCache
    }

    fun getFont(context: Context, str: String?): Typeface? {
        if (!mCache.containsKey(str)) {
            mCache[str] = Typeface.createFromAsset(context.assets, str)
        }
        return mCache[str]
    }
}

