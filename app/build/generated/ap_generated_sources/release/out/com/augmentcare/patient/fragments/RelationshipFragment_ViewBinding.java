// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.GridView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RelationshipFragment_ViewBinding implements Unbinder {
  private RelationshipFragment target;

  @UiThread
  public RelationshipFragment_ViewBinding(RelationshipFragment target, View source) {
    this.target = target;

    target.grdRelationships = Utils.findRequiredViewAsType(source, R.id.grdRelationships, "field 'grdRelationships'", GridView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RelationshipFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.grdRelationships = null;
  }
}
