package com.augmentcare.patient.fragments;


import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.MyAppointmentsAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.Consultation;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.utils.LocalUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItems;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class MyAppointmentsFragment extends BaseFragment{

    private View rootView;

    @BindView(R.id.stl_appointments)
    SmartTabLayout smartTabs;

    @BindView(R.id.vp_appointments)
    ViewPager vp_appointments;

    @BindView(R.id.tv_empty_state)
    TextView tvEmptyState;

    private MyAppointmentsAdapter myAppointmentsAdapter;

    private List<Consultation> allAppointments = new ArrayList<>();
    private List<Consultation> myComsultations = new ArrayList<>();

    private List<Consultation> familyConsultations = new ArrayList<>();
    private List<Dependent> dependents = new ArrayList<>();
    private ViewPagerItemAdapter viewPageItemAdapter;

    public MyAppointmentsFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my_appointments, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe(){
        ((HomeScreenActivity) baseActivity).setToolbarTitle("My Appointments");
        loadConsultations(value -> {
            allAppointments.clear();
            myComsultations.clear();
            familyConsultations.clear();

            allAppointments.addAll(value);

            loadDependents(v -> {
                for (Consultation consultation : allAppointments){
                    if (consultation.getDependent() == null ||
                            LocalUtils.getOr(consultation.getDependent().getUserId(),0) == baseActivity.userData.getUserId()){
                        myComsultations.add(consultation);
                    } else {
                        familyConsultations.add(consultation);
                    }
                }

                viewPageItemAdapter = initTabs(
                        value1 -> {
                            RecyclerView rv = (RecyclerView) value1.first;
                            rv.setLayoutManager(new LinearLayoutManager(baseActivity, RecyclerView.VERTICAL, false));


                            if (value1.second == 0){
                                if(myComsultations.size()>0){
                                    tvEmptyState.setVisibility(View.GONE);
                                    myAppointmentsAdapter = new MyAppointmentsAdapter(baseActivity, myComsultations);
                                    rv.setAdapter(myAppointmentsAdapter);
                                }
                                else{
                                    tvEmptyState.setVisibility(View.VISIBLE);
                                }

                            }
                            else if (value1.second == 1){
                                if(familyConsultations.size()>0){
                                    tvEmptyState.setVisibility(View.GONE);
                                    myAppointmentsAdapter = new MyAppointmentsAdapter(baseActivity, familyConsultations);
                                    rv.setAdapter(myAppointmentsAdapter);
                                }
                                else{
                                    tvEmptyState.setVisibility(View.VISIBLE);
                                }
                            }

                        }
                        , R.layout.material_drawer_recycler_view, R.layout.material_drawer_recycler_view);
            });
        });
    }

    private ViewPagerItemAdapter initTabs(OnValueGot<Pair<View, Integer>> onTabSelect, @LayoutRes int tab1, @LayoutRes int tab2) {
        ViewPagerItemAdapter adapter = new ViewPagerItemAdapter(ViewPagerItems.with(baseActivity)
                .add("For MySelf", tab1)
                .add("For My Family", tab2)
                .create());

        vp_appointments.setAdapter(adapter);
        vp_appointments.setOffscreenPageLimit(2);


        ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrollStateChanged(int arg0){}

            //declare key
            Boolean first = true;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
                if (first && positionOffset == 0 && positionOffsetPixels == 0){
                    onPageSelected(0);
                    first = false;
                }
            }

            @Override
            public void onPageSelected(int position){
                //.instantiateItem() from until .destroyItem() is called it will be able to get the View of page.
                View page = adapter.getPage(position);
                onTabSelect.gotIt(new Pair<>(page, position));
            }

        };

        vp_appointments.addOnPageChangeListener(pageChangeListener);

        smartTabs.setViewPager(vp_appointments);

        return adapter;
    }

    private void getDependentsApiCall(OnValueGot<List<Dependent>> childs) {
        getDisposer().add(
                baseActivity.RXAPI.getAllDependent().subscribe(
                        childs::gotIt,
                        e -> {
                            LocalUtils.processAPIError(e);
                            childs.gotIt(new ArrayList<>());
                        })
        );
    }

    private void loadDependents(OnValueGot<List<String>> dependentNames) {
        ArrayList<String> dependentsList = new ArrayList<>();
        String name = baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName();
        dependentsList.add(name);

        getDependentsApiCall(dependents -> {
            this.dependents.clear();
            this.dependents.addAll(dependents);

            if (dependents.size() > 0) {
                for (Dependent dependant : dependents) {
                    if (dependant != null && dependant.getName() != null && !dependant.getName().equalsIgnoreCase("")) {
                        dependentsList.add(dependant.getName());
                    }
                }
            }
            dependentNames.gotIt(dependentsList);
        });
    }

    public void loadConsultations(OnValueGot<List<Consultation>> consultations) {
        if (NetworkUtils.isConnected()) {
            getDisposer()
                    .add(
                            baseActivity.RXAPI.getAllConsultations(
                                    "",
                                    1,
                                    500)
                                    .subscribe(list -> {
                                        if(list.getSuccess()){
                                            if (list.getData() != null && list.getData().size() > 0) {
                                                consultations.gotIt(list.getData());
                                            }
                                            else{
                                                consultations.gotIt(new ArrayList<>());
                                            }
                                        }else{
                                            Toasty.error(baseActivity, "No Appointments are there yet").show();
                                        }
                                    }, LocalUtils::processAPIError)
                    );

        } else {
            Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
        }
    }
}