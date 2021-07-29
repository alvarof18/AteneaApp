package com.ateneaApp.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.ateneaApp.R;

import androidx.fragment.app.DialogFragment;

public class DialogFragmentColor extends DialogFragment implements View.OnClickListener {
    private Activity activity;
    private RelativeLayout rlBlack;
    private RelativeLayout rlLightPink;
    private RelativeLayout rlPinkWhite;
    private RelativeLayout rlYello;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.activity = getActivity();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(this.activity);
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimationTultip;
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setSoftInputMode(3);
        dialog.getWindow().requestFeature(1);
       // dialog.getWindow().setBackgroundDrawableResource(17170445);
        dialog.getWindow().setGravity(17);
        dialog.setContentView(R.layout.dialog_color);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        dialog.getWindow().setAttributes(attributes);
        initializeComponent(dialog);
        return dialog;
    }

    /* access modifiers changed from: protected */
    public void initializeComponent(Dialog dialog) {
        this.rlBlack = dialog.findViewById(R.id.dailog_color_rlBlack);
        this.rlLightPink =  dialog.findViewById(R.id.dailog_color_rlLightpink);
        this.rlPinkWhite =  dialog.findViewById(R.id.dailog_color_rlPinkWhite);
        this.rlYello = dialog.findViewById(R.id.dailog_color_rlYello);
        this.rlBlack.setOnClickListener(this);
        this.rlLightPink.setOnClickListener(this);
        this.rlPinkWhite.setOnClickListener(this);
        this.rlYello.setOnClickListener(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    public void onClick(View view) {
        if (view == this.rlYello) {
            dismiss();
        } else if (view == this.rlBlack) {
            dismiss();
        } else if (view == this.rlLightPink) {
            dismiss();
        } else if (view == this.rlPinkWhite) {
            dismiss();
        }
    }
}
