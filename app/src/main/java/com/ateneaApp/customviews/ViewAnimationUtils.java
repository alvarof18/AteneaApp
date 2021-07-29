package com.ateneaApp.customviews;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import com.ateneaApp.R;

public class ViewAnimationUtils {

    public static void expand(final View view) {
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(View.VISIBLE);
         Animation r1 = new Animation() {
            public boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = f == 1.0f ? -2 : (int) (((float) measuredHeight) * f);
                view.requestLayout();
            }
        };
        r1.setDuration((long) ((int) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density)));
        view.startAnimation(r1);
    }

    public static void collapse(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation r1 = new Animation() {
            public boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    view.setVisibility(View.GONE);
                    return;
                }
                view.getLayoutParams().height = measuredHeight - ((int) (((float) measuredHeight) * f));
                view.requestLayout();
            }
        };
        r1.setDuration((long) ((int) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density)));
        view.startAnimation(r1);
    }

    public static void callspanView(View view, Activity activity) {
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.callspand);
        view.setVisibility(View.GONE);
        view.startAnimation(loadAnimation);
    }

    public static void expandView(View view, Activity activity) {
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.expand);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(loadAnimation);
    }
}
