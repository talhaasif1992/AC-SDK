// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyClaimsFragment_ViewBinding implements Unbinder {
  private MyClaimsFragment target;

  @UiThread
  public MyClaimsFragment_ViewBinding(MyClaimsFragment target, View source) {
    this.target = target;

    target.tvAvailableAllowance = Utils.findRequiredViewAsType(source, R.id.tvAvailableAllowance, "field 'tvAvailableAllowance'", TextView.class);
    target.contentFrame = Utils.findRequiredView(source, R.id.rlContentView, "field 'contentFrame'");
    target.tvTotalAllowanceLimit = Utils.findRequiredViewAsType(source, R.id.tvTotalAllowanceLimit, "field 'tvTotalAllowanceLimit'", TextView.class);
    target.btnFileAClaim = Utils.findRequiredViewAsType(source, R.id.btnFileAClaim, "field 'btnFileAClaim'", RelativeLayout.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
    target.tvEmptyState = Utils.findRequiredViewAsType(source, R.id.tv_empty_state, "field 'tvEmptyState'", TextView.class);
    target.recylerViewUserClaims = Utils.findRequiredViewAsType(source, R.id.recylerViewUserClaims, "field 'recylerViewUserClaims'", RecyclerView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.ivHome = Utils.findRequiredViewAsType(source, R.id.homeIv, "field 'ivHome'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyClaimsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvAvailableAllowance = null;
    target.contentFrame = null;
    target.tvTotalAllowanceLimit = null;
    target.btnFileAClaim = null;
    target.tabLayout = null;
    target.tvEmptyState = null;
    target.recylerViewUserClaims = null;
    target.toolbar = null;
    target.ivHome = null;
  }
}
