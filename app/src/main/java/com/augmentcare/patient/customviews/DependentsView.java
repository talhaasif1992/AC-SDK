package com.augmentcare.patient.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.DependentsAdapterCV;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;

public class DependentsView extends LinearLayout {

    private Context context;
    private View myRootView;

    @BindView(R.id.addll)
    LinearLayout addll;

    @BindView(R.id.dependentsRV)
    RecyclerView dependentsRV;

    private BaseActivity baseActivity;
    private CompositeDisposable cpp = new CompositeDisposable();
    private LinearLayoutManager linearLayoutManager;
    private DependentsAdapterCV dependentsAdapterCV;
    private boolean clickable;

    private Runnable loaded;
    private NavController mainNav;


    public DependentsView(Context context) {
        super(context);
        this.context = context;
        initMe();
    }

    public DependentsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initMe();
    }

    public DependentsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initMe();
    }

    public DependentsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initMe();
    }

    private void initMe() {
        myRootView = inflate(context, R.layout.dependents_view,this);
        ButterKnife.bind(this,myRootView);

        baseActivity = (BaseActivity) ActivityUtils.getTopActivity();

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        dependentsRV.setLayoutManager(linearLayoutManager);

        setListToAdapterDependents(new ArrayList<>(),false);

        getDependentsList();
    }

    public void onDependentsLoaded(Runnable load){
        this.loaded = load;
    }

    public void setClickable(boolean clickable){
        this.clickable = clickable;
        if(dependentsAdapterCV != null){
            dependentsAdapterCV.disableDepedentClick(!clickable);
        }
    }
    public void selectDependentByName(String depName){
        if(dependentsAdapterCV != null){
            dependentsAdapterCV.selectDependent(depName);
        }
    }
    public void selectDependentByID(long depID){
        if(dependentsAdapterCV != null){
            dependentsAdapterCV.selectDependent(depID);
        }
    }

    public void getSelectedDependent(OnValueGot<Dependent> got){
        if(dependentsAdapterCV != null){
            dependentsAdapterCV.observeSelectedDependent(got);
        }
    }

    private void setListToAdapterDependents(List<Dependent> dependents,boolean addDummy){
       if(addDummy) {
           dependents.add(0,
                   new Dependent()
                           .withId(Integer.valueOf(baseActivity.userData.getId()))
                           .withName(baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName())
                           .withPhoto(baseActivity.userData.getPhoto())
           );
       }
       if(dependentsAdapterCV == null) {
           dependentsAdapterCV = new DependentsAdapterCV(context, dependents);
       }else{
           dependentsAdapterCV.setDependents(dependents);
       }
    }

    private void getDependentsList(){
        cpp.add(
                baseActivity.RXAPI.getAllDependent().subscribe(s -> {
                    setListToAdapterDependents(s,true);
                    dependentsRV.setAdapter(dependentsAdapterCV);
                    if(loaded != null){
                        loaded.run();
                    }
                }, e -> {
                    LocalUtils.processAPIError(e);
                    dependentsRV.setAdapter(dependentsAdapterCV);
                })
        );
    }

    @OnClick(R.id.addll)
    public void onAddDepedentClick(){
        mainNav.navigate(R.id.addDependentMemberFragment);
    }

    @Override
    protected void onDetachedFromWindow() {
        cpp.clear();
        super.onDetachedFromWindow();
    }
}
