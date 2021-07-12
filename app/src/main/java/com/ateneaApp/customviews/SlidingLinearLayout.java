package com.ateneaApp.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

public class SlidingLinearLayout extends LinearLayout {
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnPreDrawListener preDrawListener = null;
    /* access modifiers changed from: private */
    public float xFraction = 0.0f;
    /* access modifiers changed from: private */
    public float yFraction = 0.0f;

    public SlidingLinearLayout(Context context) {
        super(context);
    }

    public SlidingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SlidingLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setYFraction(float f) {
        this.yFraction = f;
        if (getHeight() != 0) {
            setTranslationY(((float) getHeight()) * f);
        } else if (this.preDrawListener == null) {
            this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    SlidingLinearLayout.this.getViewTreeObserver().removeOnPreDrawListener(SlidingLinearLayout.this.preDrawListener);
                    SlidingLinearLayout.this.setYFraction(SlidingLinearLayout.this.yFraction);
                    return true;
                }
            };
            getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        }
    }

    public void setXFraction(float f) {
        this.xFraction = f;
        if (getWidth() != 0) {
            setTranslationX(((float) getWidth()) * f);
        } else if (this.preDrawListener == null) {
            this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    SlidingLinearLayout.this.getViewTreeObserver().removeOnPreDrawListener(SlidingLinearLayout.this.preDrawListener);
                    SlidingLinearLayout.this.setXFraction(SlidingLinearLayout.this.xFraction);
                    return true;
                }
            };
            getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        }
    }

    public void setGlide(float f) {
        setTranslationX(((float) getWidth()) * f);
        setRotationY(90.0f * f);
        setPivotX(0.0f);
    }

    public void setGlideBack(float f) {
        setTranslationX(((float) getWidth()) * f);
        setRotationY(90.0f * f);
        setPivotX(0.0f);
        setPivotY((float) (getHeight() / 2));
    }

    public void setCube(float f) {
        setTranslationX(((float) getWidth()) * f);
        setRotationY(90.0f * f);
        setPivotX(0.0f);
        setPivotY((float) (getHeight() / 2));
    }

    public void setCubeBack(float f) {
        setTranslationX(((float) getWidth()) * f);
        setRotationY(90.0f * f);
        setPivotY((float) (getHeight() / 2));
        setPivotX((float) getWidth());
    }

    public void setRotateDown(float f) {
        setTranslationX(((float) getWidth()) * f);
        setRotation(20.0f * f);
        setPivotY((float) getHeight());
        setPivotX((float) (getWidth() / 2));
    }

    public void setRotateUp(float f) {
        setTranslationX(((float) getWidth()) * f);
        setRotation(-20.0f * f);
        setPivotY(0.0f);
        setPivotX((float) (getWidth() / 2));
    }

    public void setAccordionPivotZero(float f) {
        setScaleX(f);
        setPivotX(0.0f);
    }

    public void setAccordionPivotWidth(float f) {
        setScaleX(f);
        setPivotX((float) getWidth());
    }

    public void setTableHorizontalPivotZero(float f) {
        setRotationY(90.0f * f);
        setPivotX(0.0f);
        setPivotY((float) (getHeight() / 2));
    }

    public void setTableHorizontalPivotWidth(float f) {
        setRotationY(-90.0f * f);
        setPivotX((float) getWidth());
        setPivotY((float) (getHeight() / 2));
    }

    public void setTableVerticalPivotZero(float f) {
        setRotationX(-90.0f * f);
        setPivotX((float) (getWidth() / 2));
        setPivotY(0.0f);
    }

    public void setTableVerticalPivotHeight(float f) {
        setRotationX(90.0f * f);
        setPivotX((float) (getWidth() / 2));
        setPivotY((float) getHeight());
    }

    public void setZoomFromCornerPivotHG(float f) {
        setScaleX(f);
        setScaleY(f);
        setPivotX((float) getWidth());
        setPivotY((float) getHeight());
    }

    public void setZoomFromCornerPivotZero(float f) {
        setScaleX(f);
        setScaleY(f);
        setPivotX(0.0f);
        setPivotY(0.0f);
    }

    public void setZoomFromCornerPivotWidth(float f) {
        setScaleX(f);
        setScaleY(f);
        setPivotX((float) getWidth());
        setPivotY(0.0f);
    }

    public void setZoomFromCornerPivotHeight(float f) {
        setScaleX(f);
        setScaleY(f);
        setPivotX(0.0f);
        setPivotY((float) getHeight());
    }

    public void setZoomSlideHorizontal(float f) {
        setTranslationX(((float) getWidth()) * f);
        setPivotX((float) (getWidth() / 2));
        setPivotY((float) (getHeight() / 2));
    }

    public void setZoomSlideVertical(float f) {
        setTranslationY(((float) getHeight()) * f);
        setPivotX((float) (getWidth() / 2));
        setPivotY((float) (getHeight() / 2));
    }
}