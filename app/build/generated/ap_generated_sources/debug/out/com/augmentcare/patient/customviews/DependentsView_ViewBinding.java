// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.customviews;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DependentsView_ViewBinding implements Unbinder {
  private DependentsView target;

  private View view7f0a00d2;

  @UiThread
  public DependentsView_ViewBinding(DependentsView target) {
    this(target, target);
  }

  @UiThread
  public DependentsView_ViewBinding(final DependentsView target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.addll, "field 'addll' and method 'onAddDepedentClick'");
    target.addll = Utils.castView(view, R.id.addll, "field 'addll'", LinearLayout.class);
    view7f0a00d2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAddDepedentClick();
      }
    });
    target.dependentsRV = Utils.findRequiredViewAsType(source, R.id.dependentsRV, "field 'dependentsRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DependentsView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.addll = null;
    target.dependentsRV = null;

    view7f0a00d2.setOnClickListener(null);
    view7f0a00d2 = null;
  }
}
