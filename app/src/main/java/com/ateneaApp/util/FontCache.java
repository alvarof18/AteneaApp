package com.ateneaApp.util;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public class FontCache {
    private static FontCache fontCache = new FontCache();
    private final Hashtable<String, Typeface> mCache = new Hashtable<>();

    private FontCache() {
    }

    public static FontCache getInstance() {
        return fontCache;
    }

    public Typeface getFont(Context context, String str) {
        if (!this.mCache.containsKey(str)) {
            this.mCache.put(str, Typeface.createFromAsset(context.getAssets(), str));
        }
        return this.mCache.get(str);
    }
}
