package com.ateneaApp.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.ateneaApp.R;
import com.ateneaApp.util.FontCache;

import androidx.appcompat.widget.AppCompatEditText;

public class CustomEdittext extends AppCompatEditText {
    private Typeface fontType;

    public CustomEdittext(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomEditText);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                FontCache instance = FontCache.getInstance();
                setTypeface(instance.getFont(context, "font/" + string));
            }
            obtainStyledAttributes.recycle();
        }
    }
}