// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.activities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddCardActivity_ViewBinding implements Unbinder {
  private AddCardActivity target;

  @UiThread
  public AddCardActivity_ViewBinding(AddCardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddCardActivity_ViewBinding(AddCardActivity target, View source) {
    this.target = target;

    target.mAddCardButton = Utils.findRequiredViewAsType(source, R.id.add_card_button, "field 'mAddCardButton'", Button.class);
    target.mCardNameEditText = Utils.findRequiredViewAsType(source, R.id.name_card, "field 'mCardNameEditText'", EditText.class);
    target.mCardNumberEditText = Utils.findRequiredViewAsType(source, R.id.card_number, "field 'mCardNumberEditText'", EditText.class);
    target.mExpiryDateEditText = Utils.findRequiredViewAsType(source, R.id.et_expiry_date, "field 'mExpiryDateEditText'", EditText.class);
    target.mCvvEditText = Utils.findRequiredViewAsType(source, R.id.et_cvc_number, "field 'mCvvEditText'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddCardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAddCardButton = null;
    target.mCardNameEditText = null;
    target.mCardNumberEditText = null;
    target.mExpiryDateEditText = null;
    target.mCvvEditText = null;
  }
}
