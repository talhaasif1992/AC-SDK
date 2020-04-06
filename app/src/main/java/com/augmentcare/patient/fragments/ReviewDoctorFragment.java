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
import com.augmentcare.patient.adapters.DoctorRatingAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.model.RatingModel;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewDoctorFragment extends BaseFragment {

//    @BindView(R.id.rated_count_textview)
//    TextView mRatedCountTextView;
    @BindView(R.id.review_RV)
    RecyclerView ratingRecyclerView;
//    @BindView(R.id.ratingBar)
//    RatingBar ratingBar;


    private DoctorDetail doctorDetail;
    private DoctorRatingAdapter doctorRatingAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View spinKit;
    private ArrayList<RatingModel> arrayList;
    private View rootView;


    public ReviewDoctorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_review_doctor, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        doctorRatingAdapter = new DoctorRatingAdapter(new ArrayList<>(), baseActivity);
        ratingRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(baseActivity);
        ratingRecyclerView.setLayoutManager(mLayoutManager);
        ratingRecyclerView.setAdapter(doctorRatingAdapter);
    }

    public void setDoctorReviewData(DoctorDetail doctorDetail) {
        this.doctorDetail = doctorDetail;

        // #TODO djhskdfjsfgksfhgkdsng

        MyApp.HANDLER.post(() -> {
            if (doctorDetail != null) {
                // #TODO review missing in API's
                doctorRatingAdapter.setRatingModelList(new ArrayList<>());
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
