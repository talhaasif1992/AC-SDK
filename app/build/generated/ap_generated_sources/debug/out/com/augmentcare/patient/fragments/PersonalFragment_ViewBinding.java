// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.SwitchCompat;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalFragment_ViewBinding implements Unbinder {
  private PersonalFragment target;

  @UiThread
  public PersonalFragment_ViewBinding(PersonalFragment target, View source) {
    this.target = target;

    target.mUserNameTextView = Utils.findRequiredViewAsType(source, R.id.et_user_name, "field 'mUserNameTextView'", EditText.class);
    target.txtEmail = Utils.findRequiredViewAsType(source, R.id.et_user_email, "field 'txtEmail'", EditText.class);
    target.txtAddress = Utils.findRequiredViewAsType(source, R.id.relationSpinner, "field 'txtAddress'", EditText.class);
    target.txtPhone = Utils.findRequiredViewAsType(source, R.id.et_user_mobile, "field 'txtPhone'", PhoneEditTextNew.class);
    target.changePhoneSwitch = Utils.findRequiredViewAsType(source, R.id.changePhoneSwitch, "field 'changePhoneSwitch'", SwitchCompat.class);
    target.ivProfileImage = Utils.findRequiredViewAsType(source, R.id.ivProfileImageNew, "field 'ivProfileImage'", ImageView.class);
    target.mUploadPictureLayout = Utils.findRequiredViewAsType(source, R.id.upload_picture_layoutNew, "field 'mUploadPictureLayout'", RelativeLayout.class);
    target.mUploadPictureLayouts = Utils.findRequiredViewAsType(source, R.id.upload_picture_layoutsNew, "field 'mUploadPictureLayouts'", RelativeLayout.class);
    target.editButton = Utils.findRequiredViewAsType(source, R.id.btn_update_profile, "field 'editButton'", Button.class);
    target.btnUploadPicture = Utils.findRequiredViewAsType(source, R.id.btn_upload_picture, "field 'btnUploadPicture'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PersonalFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserNameTextView = null;
    target.txtEmail = null;
    target.txtAddress = null;
    target.txtPhone = null;
    target.changePhoneSwitch = null;
    target.ivProfileImage = null;
    target.mUploadPictureLayout = null;
    target.mUploadPictureLayouts = null;
    target.editButton = null;
    target.btnUploadPicture = null;
  }
}
