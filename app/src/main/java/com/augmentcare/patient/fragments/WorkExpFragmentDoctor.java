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
import com.augmentcare.patient.adapters.DoctorPracticeLocationDetailsAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkExpFragmentDoctor extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.work_exp_RV)
    RecyclerView mPracticeLocationRecyclerView;

    private DoctorDetail doctorDetail;
    private DoctorPracticeLocationDetailsAdapter mDoctorPracticeAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View rootView;

    public WorkExpFragmentDoctor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_work_exp_doctor, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setDoctorWorkExpData(DoctorDetail doctorDetail) {
        this.doctorDetail = doctorDetail;

        MyApp.HANDLER.post(() -> {
            if (mDoctorPracticeAdapter == null) {
                mDoctorPracticeAdapter = new DoctorPracticeLocationDetailsAdapter(new ArrayList<>(), new ArrayList<>(), baseActivity);
                mPracticeLocationRecyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(baseActivity);
                mPracticeLocationRecyclerView.setLayoutManager(mLayoutManager);
                mPracticeLocationRecyclerView.setAdapter(mDoctorPracticeAdapter);
            }

            if (doctorDetail != null && doctorDetail.getExperience().size() > 0) {
                mDoctorPracticeAdapter.setExpAndSpec(doctorDetail.getExperience(), doctorDetail.getSpecializations());
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

    @Override
    public void onClick(View v) {

    }
}
