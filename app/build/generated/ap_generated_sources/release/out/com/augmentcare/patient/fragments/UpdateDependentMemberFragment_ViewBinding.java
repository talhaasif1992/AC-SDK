// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SwitchCompat;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mikhaellopez.circularimageview.CircularImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateDependentMemberFragment_ViewBinding implements Unbinder {
  private UpdateDependentMemberFragment target;

  @UiThread
  public UpdateDependentMemberFragment_ViewBinding(UpdateDependentMemberFragment target,
      View source) {
    this.target = target;

    target.btnSave = Utils.findRequiredViewAsType(source, R.id.btn_save_information, "field 'btnSave'", Button.class);
    target.membersName = Utils.findRequiredViewAsType(source, R.id.et_user_name, "field 'membersName'", EditText.class);
    target.relationSpinner = Utils.findRequiredViewAsType(source, R.id.relationSpinner, "field 'relationSpinner'", AppCompatSpinner.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.et_user_email, "field 'email'", EditText.class);
    target.phone = Utils.findRequiredViewAsType(source, R.id.et_user_mobile, "field 'phone'", PhoneEditTextNew.class);
    target.mPictureSetRelativeLayout = Utils.findRequiredViewAsType(source, R.id.upload_picture_layoutsNew, "field 'mPictureSetRelativeLayout'", RelativeLayout.class);
    target.btn_upload_picture = Utils.findRequiredViewAsType(source, R.id.btn_upload_picture, "field 'btn_upload_picture'", FloatingActionButton.class);
    target.ivdocImage = Utils.findRequiredViewAsType(source, R.id.ivProfileImageNew, "field 'ivdocImage'", CircularImageView.class);
    target.tv_email = Utils.findRequiredViewAsType(source, R.id.tv_email, "field 'tv_email'", TextView.class);
    target.tv_phone_number = Utils.findRequiredViewAsType(source, R.id.tv_phone_number, "field 'tv_phone_number'", TextView.class);
    target.daySpinner = Utils.findRequiredViewAsType(source, R.id.daySpinner, "field 'daySpinner'", Spinner.class);
    target.monthSpinner = Utils.findRequiredViewAsType(source, R.id.monthSpinner, "field 'monthSpinner'", Spinner.class);
    target.yearSpinner = Utils.findRequiredViewAsType(source, R.id.yearSpinner, "field 'yearSpinner'", Spinner.class);
    target.canLoginSwitch = Utils.findRequiredViewAsType(source, R.id.canLoginSwitch, "field 'canLoginSwitch'", SwitchCompat.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateDependentMemberFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnSave = null;
    target.membersName = null;
    target.relationSpinner = null;
    target.email = null;
    target.phone = null;
    target.mPictureSetRelativeLayout = null;
    target.btn_upload_picture = null;
    target.ivdocImage = null;
    target.tv_email = null;
    target.tv_phone_number = null;
    target.daySpinner = null;
    target.monthSpinner = null;
    target.yearSpinner = null;
    target.canLoginSwitch = null;
  }
}
