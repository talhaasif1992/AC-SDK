package com.augmentcare.patient.customviews;

import android.content.Context;
import android.util.AttributeSet;

import com.augmentcare.patient.R;
import com.lamudi.phonefield.PhoneEditText;

public class PhoneEditTextNew extends PhoneEditText {

    public PhoneEditTextNew(Context context) {
        super(context);
    }

    public PhoneEditTextNew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhoneEditTextNew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setEditable(boolean enabled) {
        super.getEditText().setClickable(enabled);
        super.getEditText().setFocusable(enabled);
        super.getEditText().setFocusableInTouchMode(enabled);
        super.getEditText().setEnabled(enabled);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.phone_edit_text_new;
    }
}
