package com.augmentcare.patient.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.DoctorEducationDetailsAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragmentDoctor extends BaseFragment {


    @BindView(R.id.eduaction_RV)
    RecyclerView mEducationRecyclerView;

    private DoctorDetail doctorDetail;

    private RecyclerView.LayoutManager mLayoutManager;
    private DoctorEducationDetailsAdapter mDoctorEducationAdapter;
    private View spinKit;
    private View rootView;

    public EducationFragmentDoctor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_education_doctor, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDoctorEducationAdapter = new DoctorEducationDetailsAdapter(new ArrayList<>(), baseActivity);
        mEducationRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(baseActivity);
        mEducationRecyclerView.setLayoutManager(mLayoutManager);
        mEducationRecyclerView.setAdapter(mDoctorEducationAdapter);



    }

    public void setDoctorDetail(DoctorDetail doctorDetail) {
        this.doctorDetail = doctorDetail;

        MyApp.HANDLER.post(() -> {
            if (doctorDetail != null && doctorDetail.getEducationExperience().size() > 0) {
                mDoctorEducationAdapter.setEducationList(doctorDetail.getEducationExperience());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                baseActivity.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
