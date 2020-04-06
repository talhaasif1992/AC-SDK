// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.claim;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.DependentsView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConfirmClaimFragment_ViewBinding implements Unbinder {
  private ConfirmClaimFragment target;

  @UiThread
  public ConfirmClaimFragment_ViewBinding(ConfirmClaimFragment target, View source) {
    this.target = target;

    target.spTransactionType = Utils.findRequiredViewAsType(source, R.id.spConsultationFor, "field 'spTransactionType'", Spinner.class);
    target.etDateTime = Utils.findRequiredViewAsType(source, R.id.etDateTime1, "field 'etDateTime'", EditText.class);
    target.etAmount = Utils.findRequiredViewAsType(source, R.id.etAmount, "field 'etAmount'", EditText.class);
    target.etClaimType = Utils.findRequiredViewAsType(source, R.id.etClaimType, "field 'etClaimType'", EditText.class);
    target.etClaimFor = Utils.findRequiredViewAsType(source, R.id.etClaimFor, "field 'etClaimFor'", EditText.class);
    target.etDetails = Utils.findRequiredViewAsType(source, R.id.etDetails, "field 'etDetails'", TextView.class);
    target.llBox1 = Utils.findRequiredViewAsType(source, R.id.llBox1, "field 'llBox1'", RelativeLayout.class);
    target.llBox2 = Utils.findRequiredViewAsType(source, R.id.llBox2, "field 'llBox2'", RelativeLayout.class);
    target.llBox3 = Utils.findRequiredViewAsType(source, R.id.llBox3, "field 'llBox3'", RelativeLayout.class);
    target.llBox4 = Utils.findRequiredViewAsType(source, R.id.llBox4, "field 'llBox4'", RelativeLayout.class);
    target.llBox5 = Utils.findRequiredViewAsType(source, R.id.llBox5, "field 'llBox5'", RelativeLayout.class);
    target.btnFileAClaim = Utils.findRequiredViewAsType(source, R.id.btnFileAClaim, "field 'btnFileAClaim'", RelativeLayout.class);
    target.ivImage1 = Utils.findRequiredViewAsType(source, R.id.ivImage1, "field 'ivImage1'", ImageView.class);
    target.ivImage2 = Utils.findRequiredViewAsType(source, R.id.ivImage2, "field 'ivImage2'", ImageView.class);
    target.ivImage3 = Utils.findRequiredViewAsType(source, R.id.ivImage3, "field 'ivImage3'", ImageView.class);
    target.ivImage4 = Utils.findRequiredViewAsType(source, R.id.ivImage4, "field 'ivImage4'", ImageView.class);
    target.ivImage5 = Utils.findRequiredViewAsType(source, R.id.ivImage5, "field 'ivImage5'", ImageView.class);
    target.mImagesRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerViewImages, "field 'mImagesRecyclerView'", RecyclerView.class);
    target.dep_view = Utils.findRequiredViewAsType(source, R.id.dep_view, "field 'dep_view'", DependentsView.class);
    target.contentFrame = Utils.findRequiredViewAsType(source, R.id.rlContentView, "field 'contentFrame'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConfirmClaimFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spTransactionType = null;
    target.etDateTime = null;
    target.etAmount = null;
    target.etClaimType = null;
    target.etClaimFor = null;
    target.etDetails = null;
    target.llBox1 = null;
    target.llBox2 = null;
    target.llBox3 = null;
    target.llBox4 = null;
    target.llBox5 = null;
    target.btnFileAClaim = null;
    target.ivImage1 = null;
    target.ivImage2 = null;
    target.ivImage3 = null;
    target.ivImage4 = null;
    target.ivImage5 = null;
    target.mImagesRecyclerView = null;
    target.dep_view = null;
    target.contentFrame = null;
  }
}
