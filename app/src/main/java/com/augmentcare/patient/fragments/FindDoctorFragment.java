package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.EliteDoctorRvAdapter;
import com.augmentcare.patient.adapters.InstantDoctorRvAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apirequests.DoctorsListRequest;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.viewmodels.FindDoctorVM;
import com.blankj.utilcode.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class FindDoctorFragment extends BaseFragment implements  EliteDoctorRvAdapter.OnItemClickListener, InstantDoctorRvAdapter.OnItemClickListener {

    DoctorInfoLimited doctor;
    String doctorId;

    private View rootView;

    @BindView(R.id.etSearchView)
    AppCompatEditText etSearchView;

    @BindView(R.id.ivFilters)
    AppCompatImageView ivFilters;

    @BindView(R.id.rvInstantDoctor)
    RecyclerView rvInstantDoctor;
    @BindView(R.id.rvElitePanelDoctor)
    RecyclerView rvElitePanelDoctor;

    @BindView(R.id.tv_no_instant_doctor_found)
    TextView tvNoInstantDoctorFound;
    @BindView(R.id.tv_no_elite_doctor_found)
    TextView tvNoEliteDoctorFound;

    private InstantDoctorRvAdapter instantDoctorRvAdapter;
    private EliteDoctorRvAdapter eliteDoctorRvAdapter;

    private List<DoctorInfoLimited> instantDoctorList;
    private List<DoctorInfoLimited> eliteDoctorList;

    private FindDoctorVM findDoctorVM;
    private List<DoctorInfoLimited> doctorInfoLimiteds;

    private int noOfFreeCalls;
    private boolean showBadge = false;

    public FindDoctorFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_find_doctor, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeScreenActivity) baseActivity).showNavBar();
        ((HomeScreenActivity) baseActivity).setToolbarTitle("Find a Doctor");
        loadArguments();
        initMe();
    }

    private void loadArguments(){
        if(getArguments()!= null){
            FindDoctorFragmentArgs args = FindDoctorFragmentArgs.fromBundle(getArguments());
            if(args.getShowBadge()){
                showBadge = args.getShowBadge();
            }
            if(args.getNoOfFreeCalls() != -1){
                noOfFreeCalls = args.getNoOfFreeCalls();
            }
        }
    }

    private void initMe() {
        try{
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty()) {
                GenApiLogger.fireFindADoctorListingDoc(baseActivity);

            }
        }catch (Exception ignored){}

        findDoctorVM = ViewModelProviders.of(baseActivity).get(FindDoctorVM.class);
        DoctorsListRequest gotObj = findDoctorVM.getDoctorsListRequest();

        if(gotObj != null){
            getExploreDoctorApiCall(gotObj);
        }else{
            getExploreDoctorApiCall(
                    "", "", "", "", "", "", "", "",
                    "", "", "", "", "", "", ""
            );
        }
        baseActivity.showLoader();

        etSearchView.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(instantDoctorRvAdapter!=null) {
                    if (instantDoctorRvAdapter.getFilter() != null) {
                        instantDoctorRvAdapter.getFilter().filter(s);
                    }
                    if (eliteDoctorRvAdapter.getFilter() != null) {
                        eliteDoctorRvAdapter.getFilter().filter(s);
                    }
                }

            }
        });

        ivFilters.setOnClickListener(v -> {
            findDoctorVM.resetDoctorsListRequest();
            safeNavigateTo(navController -> {
                navController.navigate(R.id.action_findDoctorFragment_to_refineSearchFragment);
            });
        });

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Find A Doctor");

        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty())
                GenApiLogger.fireFindADoctorListingDoc(baseActivity);
        } catch (Exception ignored) {
        }
    }

    private void getExploreDoctorApiCall(String reviews, String rating, String search, String filter, String name,
                                         String specializationId, String locationId, String hospitalId, String feeMin,
                                         String feeMax, String gender, String experienceMin, String experienceMax,
                                         String distanceMin, String distanceMax) {
        getDisposer().add(
                baseActivity.RXAPI.getDoctorsList(
                        new DoctorsListRequest()
                                .withPage("1")
                                .withPerPage("500")
                                .withReviews(reviews)
                                .withRating(rating)
                                .withSearch(search)
                                .withFilters(filter)
                                .withName(name)
                                .withSpecialization(specializationId)
                                .withCityId(locationId)
                                .withHospitalId(hospitalId)
                                .withFeeMin(feeMin)
                                .withFeeMax(feeMax)
                                .withExperienceMin(experienceMin)
                                .withExperienceMax(experienceMax)
                                .withDistanceMin(distanceMin)
                                .withDistanceMax(distanceMax)
                                .withGender(gender)
                ).subscribe(this::onFilterSearchResponse, LocalUtils::processAPIError)
        );


    }

    private void getExploreDoctorApiCall(DoctorsListRequest request) {
        getDisposer().add(
                baseActivity.RXAPI.getDoctorsList(request).subscribe(this::onFilterSearchResponse, LocalUtils::processAPIError)
        );
    }

    private void onFilterSearchResponse(List<DoctorInfoLimited> doctorInfoLim) {
        baseActivity.showLoader();
        this.doctorInfoLimiteds = doctorInfoLim;

        if (doctorInfoLimiteds.size() > 0) {
            instantDoctorList = new ArrayList<>();
            eliteDoctorList = new ArrayList<>();

            for (int i = 0; i < doctorInfoLimiteds.size(); i++) {
                if(doctorInfoLimiteds.get(i).getInstantDoctor()){
                    instantDoctorList.add(doctorInfoLimiteds.get(i));
                }
                else{
                    eliteDoctorList.add(doctorInfoLimiteds.get(i));
                }
            }

            instantDoctorRvAdapter = new InstantDoctorRvAdapter(instantDoctorList, getContext(),showBadge, noOfFreeCalls);
            rvInstantDoctor.setAdapter(instantDoctorRvAdapter);
            instantDoctorRvAdapter.setOnItemClickListener(FindDoctorFragment.this);

            eliteDoctorRvAdapter = new EliteDoctorRvAdapter(eliteDoctorList, getContext());
            rvElitePanelDoctor.setAdapter(eliteDoctorRvAdapter);
            eliteDoctorRvAdapter.setOnItemClickListener(FindDoctorFragment.this);

            if(instantDoctorList.size() < 1){
                rvInstantDoctor.setVisibility(View.GONE);
                tvNoInstantDoctorFound.setVisibility(View.VISIBLE);
            }
            if(eliteDoctorList.size() < 1){
                rvElitePanelDoctor.setVisibility(View.GONE);
                tvNoEliteDoctorFound.setVisibility(View.VISIBLE);
            }

        }
        else{
            rvInstantDoctor.setVisibility(View.GONE);
            tvNoInstantDoctorFound.setVisibility(View.VISIBLE);
            rvElitePanelDoctor.setVisibility(View.GONE);
            tvNoEliteDoctorFound.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onEliteClick(int position){

        try{
            if(NetworkUtils.isConnected()){
                doctorId = doctorInfoLimiteds.get(position).getId()+"";

                firebaseEvents("find_a_doctor_view_normal_doc_prof");
                facebookEvents("view_normal_doc_prof");
                doctor = eliteDoctorList.get(position);
                safeNavigateTo(navController -> {
                    navController.navigate(FindDoctorFragmentDirections
                            .actionFindDoctorFragmentToDoctorProfileFragment(doctor.getId() + "")
                            .setDoctor(doctor)
                            .setShowBookAppointmentBtn(true)
                            .setInstantDoctor("no")
                    );
                });
            }
            else{
                Toasty.error(baseActivity, "Please Check your internet connection").show();
            }
        } catch(Exception ignored){}
    }

    @Override
    public void onInstantClick(int position){
        try{
            if(NetworkUtils.isConnected()){
                doctorId = doctorInfoLimiteds.get(position).getId()+"";

                facebookEvents("view_instant_doc_prof");
                firebaseEvents("find_a_doctor_view_instant_doc_prof");
                doctor = instantDoctorList.get(position);
                safeNavigateTo(navController -> {
                    navController.navigate(FindDoctorFragmentDirections
                            .actionFindDoctorFragmentToDoctorProfileFragment(doctor.getId() + "")
                            .setDoctor(doctor)
                            .setShowBookAppointmentBtn(true)
                            .setInstantDoctor("yes")
                    );
                });
            }
            else{
                Toasty.error(baseActivity, "Please Check your internet connection").show();
            }
        }catch(Exception ignored){}
    }

    @Override
    public void onDestroyView(){
        if (findDoctorVM != null)
            findDoctorVM.resetDoctorsListRequest();
        super.onDestroyView();
    }

    private void facebookEvents(String type){
        GenApiLogger.firefindADoctor(type);

    }

    private void firebaseEvents(String type){
        GenApiLogger.firefindADoctorDoc(baseActivity,type);

    }
}