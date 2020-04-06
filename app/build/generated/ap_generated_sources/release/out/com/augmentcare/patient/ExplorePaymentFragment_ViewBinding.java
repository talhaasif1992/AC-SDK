// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExplorePaymentFragment_ViewBinding implements Unbinder {
  private ExplorePaymentFragment target;

  @UiThread
  public ExplorePaymentFragment_ViewBinding(ExplorePaymentFragment target, View source) {
    this.target = target;

    target.tabLayoutPayment = Utils.findRequiredViewAsType(source, R.id.tab_layout_payment, "field 'tabLayoutPayment'", TabLayout.class);
    target.tabPayAtLocation = Utils.findOptionalViewAsType(source, R.id.tab_pay_at_location, "field 'tabPayAtLocation'", TabItem.class);
    target.tabPayByCreditCard = Utils.findOptionalViewAsType(source, R.id.tab_pay_by_credit_card, "field 'tabPayByCreditCard'", TabItem.class);
    target.viewPagerPayment = Utils.findRequiredViewAsType(source, R.id.view_pager_payment, "field 'viewPagerPayment'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ExplorePaymentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabLayoutPayment = null;
    target.tabPayAtLocation = null;
    target.tabPayByCreditCard = null;
    target.viewPagerPayment = null;
  }
}
