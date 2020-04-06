// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.customviews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppointmentsHistoryView_ViewBinding implements Unbinder {
  private AppointmentsHistoryView target;

  @UiThread
  public AppointmentsHistoryView_ViewBinding(AppointmentsHistoryView target) {
    this(target, target);
  }

  @UiThread
  public AppointmentsHistoryView_ViewBinding(AppointmentsHistoryView target, View source) {
    this.target = target;

    target.lytRootView = Utils.findRequiredViewAsType(source, R.id.root_view, "field 'lytRootView'", ConstraintLayout.class);
    target.tvEmptyState = Utils.findRequiredViewAsType(source, R.id.tv_empty_state, "field 'tvEmptyState'", TextView.class);
    target.appointmentsRV = Utils.findRequiredViewAsType(source, R.id.rv_list, "field 'appointmentsRV'", RecyclerView.class);
    target.previousIV = Utils.findRequiredViewAsType(source, R.id.previousIV, "field 'previousIV'", ImageView.class);
    target.nextIV = Utils.findRequiredViewAsType(source, R.id.nextIV, "field 'nextIV'", ImageView.class);
    target.numbRangTitle = Utils.findRequiredViewAsType(source, R.id.numRangTV, "field 'numbRangTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AppointmentsHistoryView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lytRootView = null;
    target.tvEmptyState = null;
    target.appointmentsRV = null;
    target.previousIV = null;
    target.nextIV = null;
    target.numbRangTitle = null;
  }
}
