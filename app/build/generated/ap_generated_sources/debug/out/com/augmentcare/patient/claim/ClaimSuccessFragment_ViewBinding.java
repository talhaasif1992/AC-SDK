// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.claim;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClaimSuccessFragment_ViewBinding implements Unbinder {
  private ClaimSuccessFragment target;

  @UiThread
  public ClaimSuccessFragment_ViewBinding(ClaimSuccessFragment target, View source) {
    this.target = target;

    target.mAmountTextView = Utils.findRequiredViewAsType(source, R.id.claim_amount_textview, "field 'mAmountTextView'", TextView.class);
    target.mClaimTypeTextView = Utils.findRequiredViewAsType(source, R.id.claim_type_textview, "field 'mClaimTypeTextView'", TextView.class);
    target.mClaimForTextView = Utils.findRequiredViewAsType(source, R.id.claim_for_textview, "field 'mClaimForTextView'", TextView.class);
    target.mClaimDetailsTextView = Utils.findRequiredViewAsType(source, R.id.claim_details_textview, "field 'mClaimDetailsTextView'", TextView.class);
    target.mHomeLinearLayout = Utils.findRequiredViewAsType(source, R.id.home_relative_layout, "field 'mHomeLinearLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ClaimSuccessFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAmountTextView = null;
    target.mClaimTypeTextView = null;
    target.mClaimForTextView = null;
    target.mClaimDetailsTextView = null;
    target.mHomeLinearLayout = null;
  }
}
