// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class claimDetailsFragment_ViewBinding implements Unbinder {
  private claimDetailsFragment target;

  @UiThread
  public claimDetailsFragment_ViewBinding(claimDetailsFragment target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.ivHome = Utils.findRequiredViewAsType(source, R.id.homeIv, "field 'ivHome'", ImageView.class);
    target.tvAvailableAllowance = Utils.findRequiredViewAsType(source, R.id.tvAvailableAllowance, "field 'tvAvailableAllowance'", TextView.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tvStatus, "field 'tvStatus'", TextView.class);
    target.lytAcceptedAmount = Utils.findRequiredViewAsType(source, R.id.lytAcceptedAmount, "field 'lytAcceptedAmount'", LinearLayout.class);
    target.tvClaimFor = Utils.findRequiredViewAsType(source, R.id.tvClaimFor, "field 'tvClaimFor'", TextView.class);
    target.mAcceptAmountTitleTextView = Utils.findRequiredViewAsType(source, R.id.accept_amount_title_textview, "field 'mAcceptAmountTitleTextView'", TextView.class);
    target.mAcceptAmountTextView = Utils.findRequiredViewAsType(source, R.id.tvAcceptAmount, "field 'mAcceptAmountTextView'", TextView.class);
    target.tvTransactiontype = Utils.findRequiredViewAsType(source, R.id.tvTransactiontype, "field 'tvTransactiontype'", TextView.class);
    target.tvDateAndTime = Utils.findRequiredViewAsType(source, R.id.tvDateAndTime, "field 'tvDateAndTime'", TextView.class);
    target.mUploadFileButton = Utils.findRequiredViewAsType(source, R.id.uploaded_files_button, "field 'mUploadFileButton'", RelativeLayout.class);
    target.contentFrame = Utils.findRequiredView(source, R.id.rlContentView, "field 'contentFrame'");
    target.recylerViewUserClaims = Utils.findRequiredViewAsType(source, R.id.recylerViewUserClaims, "field 'recylerViewUserClaims'", RecyclerView.class);
    target.llSendMessage = Utils.findRequiredViewAsType(source, R.id.llSendMessage, "field 'llSendMessage'", LinearLayout.class);
    target.etMessage = Utils.findRequiredViewAsType(source, R.id.etMessage, "field 'etMessage'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    claimDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.ivHome = null;
    target.tvAvailableAllowance = null;
    target.tvStatus = null;
    target.lytAcceptedAmount = null;
    target.tvClaimFor = null;
    target.mAcceptAmountTitleTextView = null;
    target.mAcceptAmountTextView = null;
    target.tvTransactiontype = null;
    target.tvDateAndTime = null;
    target.mUploadFileButton = null;
    target.contentFrame = null;
    target.recylerViewUserClaims = null;
    target.llSendMessage = null;
    target.etMessage = null;
  }
}
