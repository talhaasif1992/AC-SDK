package com.augmentcare.patient.bottomsheets;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseBottomSheetDialogFragment;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class ChangePasswordBottomSheet extends BaseBottomSheetDialogFragment implements  View.OnClickListener {

    private boolean showPassword= true, showConfirmPassword=true;

    @BindView(R.id.save_button)
    Button mSaveButton;
    @BindView(R.id.password)
    EditText mPasswordTextView;
    @BindView(R.id.confirm_password)
    EditText mConfirmPasswordTextView;
    @BindView(R.id.passwordInputMeter)
    PasswordStrengthMeter meter;

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.bottom_sheet_change_pass, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mPasswordTextView.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (mPasswordTextView.getRight() - mPasswordTextView.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showPassword){
                        mPasswordTextView.setTransformationMethod(null);
                        //etxtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                        Drawable img = mPasswordTextView.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        mPasswordTextView.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = false;
                    }
                    else{
                        mPasswordTextView.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = mPasswordTextView.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        mPasswordTextView.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });

        mConfirmPasswordTextView.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (mConfirmPasswordTextView.getRight() - mConfirmPasswordTextView.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showConfirmPassword){
                        mConfirmPasswordTextView.setTransformationMethod(null);
                        Drawable img = mConfirmPasswordTextView.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        mConfirmPasswordTextView.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = false;
                    }
                    else{
                        mConfirmPasswordTextView.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = mConfirmPasswordTextView.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        mConfirmPasswordTextView.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });

        mPasswordTextView.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus){
                meter.setEditText(mPasswordTextView);
                meter.setVisibility(View.VISIBLE);
            }
            else{
                meter.setVisibility(View.INVISIBLE);
            }
        });
        mSaveButton.setOnClickListener(this);
    }

    private void changePasswordApiCall(String password, String confirmPassword){
        if(!StringUtils.isEmpty(password) && password.equals(confirmPassword)){
            getDisposer().add(
                    baseActivity.RXAPI.changePassword(password)
                    .subscribe(res -> {
                        Toasty.success(Utils.getApp(),"Password Updated...").show();
                        dismiss();
                    }, LocalUtils::processAPIError)
            );
        }
        else{
            Toasty.error(Utils.getApp(),"Please enter correct password format...").show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_button:
                try {
                    if (mPasswordTextView.getText().toString().equalsIgnoreCase("")) {
                        ViewUtils.showErrorToast(baseActivity, "Please Enter Password");
                    } else if (mConfirmPasswordTextView.getText().toString().equalsIgnoreCase("")) {
                        ViewUtils.showErrorToast(baseActivity, "Please Enter Confirm Password");
                    } else if (!mConfirmPasswordTextView.getText().toString().equalsIgnoreCase(mPasswordTextView.getText().toString())) {
                        ViewUtils.showErrorToast(baseActivity, "Please Enter Same Password");
                    } else {
                        changePasswordApiCall(mPasswordTextView.getText().toString(), mConfirmPasswordTextView.getText().toString());
                    }
                } catch (Exception ignored){}
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                baseActivity.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}