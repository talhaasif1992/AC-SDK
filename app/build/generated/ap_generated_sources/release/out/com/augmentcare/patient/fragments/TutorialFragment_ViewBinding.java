// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.CustomViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TutorialFragment_ViewBinding implements Unbinder {
  private TutorialFragment target;

  @UiThread
  public TutorialFragment_ViewBinding(TutorialFragment target, View source) {
    this.target = target;

    target.vpTutorial = Utils.findRequiredViewAsType(source, R.id.vpTutorial, "field 'vpTutorial'", CustomViewPager.class);
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
    target.btnSkip = Utils.findRequiredView(source, R.id.btnSkip, "field 'btnSkip'");
    target.btnNextStep = Utils.findRequiredView(source, R.id.btnNextStep, "field 'btnNextStep'");
    target.progressContent = Utils.findRequiredView(source, R.id.progressContent, "field 'progressContent'");
    target.contentFrame = Utils.findRequiredView(source, R.id.contentFrame, "field 'contentFrame'");
    target.btnStart = Utils.findRequiredView(source, R.id.btnStart, "field 'btnStart'");
    target.back = Utils.findRequiredViewAsType(source, R.id.arrowBack, "field 'back'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TutorialFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vpTutorial = null;
    target.btnNext = null;
    target.btnSkip = null;
    target.btnNextStep = null;
    target.progressContent = null;
    target.contentFrame = null;
    target.btnStart = null;
    target.back = null;
  }
}
