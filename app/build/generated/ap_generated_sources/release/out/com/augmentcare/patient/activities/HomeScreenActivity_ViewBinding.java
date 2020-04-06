// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeScreenActivity_ViewBinding implements Unbinder {
  private HomeScreenActivity target;

  private View view7f0a0122;

  private View viewSource;

  @UiThread
  public HomeScreenActivity_ViewBinding(HomeScreenActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeScreenActivity_ViewBinding(final HomeScreenActivity target, View source) {
    this.target = target;

    View view;
    target.toolbarWithBack = Utils.findRequiredViewAsType(source, R.id.toolbarInner, "field 'toolbarWithBack'", Toolbar.class);
    target.navBarLayout = Utils.findRequiredView(source, R.id.navBarLayout, "field 'navBarLayout'");
    target.bottomNav = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'bottomNav'", BottomNavigationView.class);
    view = Utils.findRequiredView(source, R.id.btnCenter, "field 'btnCenter' and method 'clickInstantvideoCall'");
    target.btnCenter = Utils.castView(view, R.id.btnCenter, "field 'btnCenter'", FloatingActionButton.class);
    view7f0a0122 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickInstantvideoCall();
      }
    });
    target.ivHome = Utils.findRequiredViewAsType(source, R.id.homeIv, "field 'ivHome'", ImageView.class);
    target.tvInnerHome = Utils.findRequiredViewAsType(source, R.id.tvInnerHome, "field 'tvInnerHome'", TextView.class);
    viewSource = source;
    source.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View p0) {
        return target.longClickInstantvideoCall();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeScreenActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbarWithBack = null;
    target.navBarLayout = null;
    target.bottomNav = null;
    target.btnCenter = null;
    target.ivHome = null;
    target.tvInnerHome = null;

    view7f0a0122.setOnClickListener(null);
    view7f0a0122 = null;
    viewSource.setOnLongClickListener(null);
    viewSource = null;
  }
}
