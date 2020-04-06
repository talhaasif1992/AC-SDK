package com.augmentcare.patient.fragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.City;
import com.augmentcare.patient.network.restApi.apimodels.DoctorFilterOptionResponse;
import com.augmentcare.patient.network.restApi.apimodels.NameAndId;
import com.augmentcare.patient.network.restApi.apirequests.DoctorsListRequest;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.viewmodels.FindDoctorVM;
import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RefineSearchFragment extends BaseFragment implements View.OnClickListener, OnRangeChangedListener {

    private View rootView;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.tvRatings)
    TextView tvRatings;

    @BindView(R.id.btn_male)
    Button btnMale;
    @BindView(R.id.btn_female)
    Button btnFemale;
    @BindView(R.id.btn_apply)
    Button btnApply;
    @BindView(R.id.btn_reset)
    Button btnReset;

    @BindView(R.id.spinner_choose_hospital)
    Spinner spinnerHospital;
    @BindView(R.id.spinner_choose_location)
    Spinner spinnerLocation;
    @BindView(R.id.spinner_choose_specialization)
    Spinner spinnerSpecialization;

    @BindView(R.id.seekBar_distance)
    RangeSeekBar seekbarDistance;
    @BindView(R.id.seekBar_experience)
    RangeSeekBar seekbarExperience;
    @BindView(R.id.seekBar_fees)
    RangeSeekBar seekbarFees;

    private NavController navController;

    private ArrayList<String> sortByArray, specializationArray, locationArray, hospitalArray;

    private List<NameAndId> specializationArrayList;
    private List<City> locationArrayList;
    private List<NameAndId> hospitalArrayList;

    private ArrayAdapter<String> adapterSpecialization, adapterLocation, adapterHospital;


    private String specializationId, hospitalId, locationId, gender="";
    private String minDistance="";
    private String maxDistance="";
    private String minFee="";
    private String maxFee="";
    private String minExperience="";
    private String maxExperience="";
    private String rating="";

    String specialization, location, hospital;

    public RefineSearchFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_refine_search, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, rootView);

        FindDoctorVM model = ViewModelProviders.of(getActivity()).get(FindDoctorVM.class);
        model.resetDoctorsListRequest();

        initMe();
    }

    @SuppressLint("ResourceType")
    private void initMe(){

        ((HomeScreenActivity)baseActivity).setToolbarTitle("Refine Search");

        getExploreDoctorFilterApiCall();

        navController = Navigation.findNavController(rootView);

        ratingBarSettings();

        seekBarSettings();
        buttonSettings();

        btnApply.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    public void ratingBarSettings(){
        ratingBar.setOnRatingBarChangeListener((ratingBar, v, b) -> tvRatings.setText(Float.toString(v)));
    }

    public void arraySettings(){
        sortByArray = new ArrayList<>();
        sortByArray.add("Choose Sorting Criteria");
        sortByArray.add("Ascending Order");
        sortByArray.add("Descending Order");

        specializationArray = new ArrayList<>();
        specializationArray.add("Choose Specialization");

        locationArray = new ArrayList<>();
        locationArray.add("Choose Location");

        hospitalArray = new ArrayList<>();
        hospitalArray.add("Choose Hospital");

        if(specializationArrayList!=null){
            for (int i = 0; i < specializationArrayList.size(); i++) {
                specializationArray.add(specializationArrayList.get(i).getName());
            }
        }
        if(locationArrayList!=null) {
            for (int i = 0; i < locationArrayList.size(); i++) {
                locationArray.add(locationArrayList.get(i).getName());
            }
        }
        if(hospitalArrayList!=null) {
            for (int i = 0; i < hospitalArrayList.size(); i++) {
                hospitalArray.add(hospitalArrayList.get(i).getName());
            }
        }
    }

    public void spinnerSettings(){

        adapterSpecialization = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, specializationArray);
        adapterSpecialization.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSpecialization.setAdapter(adapterSpecialization);

        adapterLocation = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, locationArray);
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(adapterLocation);

        adapterHospital = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, hospitalArray);
        adapterHospital.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHospital.setAdapter(adapterHospital);
    }

    public void seekBarSettings(){
        seekbarExperience.setIndicatorTextDecimalFormat("0"+" Years");
        seekbarFees.setIndicatorTextDecimalFormat("0");
        seekbarDistance.setIndicatorTextDecimalFormat(0+" Km");

        seekbarExperience.setOnRangeChangedListener(this);
        seekbarFees.setOnRangeChangedListener(this);
        seekbarDistance.setOnRangeChangedListener(this);
    }

    public void buttonSettings(){
        btnMale.setOnClickListener(view -> {
            btnFemale.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.btn_blue_border_rectangle));
            btnFemale.setTextColor(Color.parseColor("#044c63"));
            btnMale.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.btn_blue_background));
            btnMale.setTextColor(Color.parseColor("#FFFFFF"));
            gender = "male";
        });

        btnFemale.setOnClickListener(view -> {
            btnMale.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.btn_blue_border_rectangle));
            btnMale.setTextColor(Color.parseColor("#044c63"));
            btnFemale.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.btn_blue_background));
            btnFemale.setTextColor(Color.parseColor("#FFFFFF"));
            gender = "female";
        });
    }

    @Override
    public void onClick(View view){
        if(btnApply.equals(view)){

            // LOGIC TO GET SPECIALIZATION ID
            specialization = spinnerSpecialization.getSelectedItem().toString();
            if(specialization.equals("Choose Specialization"))  specializationId = "";
            else{
                for(int i =0; i < specializationArrayList.size(); i++){
                    if(specializationArrayList.get(i).getName().equals(specialization)) {
                        specializationId = specializationArrayList.get(i).getId().toString();
                    }
                }
            }

            // LOGIC TO GET LOCATION ID
            location = spinnerLocation.getSelectedItem().toString();
            if(location.equals("Choose Location"))  locationId = "";
            else{
                for(int i =0; i< locationArrayList.size(); i++){
                    if (locationArrayList.get(i).getName().equals(location)) {
                        locationId = locationArrayList.get(i).getId().toString();
                    }
                }
            }

            //LOGIC TO GET HOSPITAL ID
            hospital = spinnerHospital.getSelectedItem().toString();
            if(hospital.equals("Choose Hospital"))  hospitalId = "";
            else {
                for (int i = 0; i < hospitalArrayList.size(); i++) {
                    if (hospitalArrayList.get(i).getName().equals(hospital)) {
                        hospitalId = hospitalArrayList.get(i).getId().toString();
                    }
                }
            }

            //  LOGIC TO GET RATING
            if(rating.equals("") || rating.equals("0.0"))   rating = "";
            else rating = Float.toString(ratingBar.getRating());

            // LOGIC TO GET MIN FEE
            if(minFee.equals("") || minFee.equals("0"))   minFee="";

            // LOGIC TO GET MIN FEE
            if(maxFee.equals("") || maxFee.equals("0"))   maxFee="";

            getExploreDoctorApiCall("", rating, "", "true", "", specializationId, locationId, hospitalId, minFee, maxFee
                    , gender, "", "", "", "");
        }
        else if(btnReset.equals(view)){
            clearValue();
        }
    }

    private void getExploreDoctorFilterApiCall(){
        getDisposer().add(
                baseActivity.RXAPI.getDoctorsFilterOptionsList()
                        .subscribe(this::onFilterSearchResponse, LocalUtils::processAPIError)
        );
    }

    private void onFilterSearchResponse(DoctorFilterOptionResponse doctorFilterOptionResponse){

        specializationArrayList = new ArrayList<>();
        locationArrayList = new ArrayList<>();
        hospitalArrayList = new ArrayList<>();

        specializationArrayList.addAll(doctorFilterOptionResponse.getSpecializations());

        locationArrayList.addAll(doctorFilterOptionResponse.getCities());

        hospitalArrayList.addAll(doctorFilterOptionResponse.getMedicalPractices());

        arraySettings();
        spinnerSettings();

    }

    private void getExploreDoctorApiCall(String reviews,String rating, String search, String filter, String name,
                                         String specializationId, String locationId, String hospitalId, String feeMin,
                                         String feeMax, String gender, String experienceMin, String experienceMax,
                                         String distanceMin, String distanceMax){
        DoctorsListRequest doctorsListRequest =
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
                .withGender(gender);

        FindDoctorVM findDoctorVM = ViewModelProviders.of(baseActivity).get(FindDoctorVM.class);
        findDoctorVM.setDoctorsListRequest(doctorsListRequest);

        navController.popBackStack();
    }

    private void clearValue(){
//        spinnerSortingCriteria.setSelection(0);
        spinnerSpecialization.setSelection(0);
        spinnerLocation.setSelection(0);
        spinnerHospital.setSelection(0);
        btnMale.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.btn_blue_border_rectangle));
        btnMale.setTextColor(Color.parseColor("#044c63"));
        btnFemale.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.btn_blue_border_rectangle));
        btnFemale.setTextColor(Color.parseColor("#044c63"));
        ratingBar.setRating(0.0f);
        seekbarDistance.setProgress(0,0);
        seekbarFees.setProgress(500,500);
        seekbarExperience.setProgress(1,1);
    }

    @Override
    public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {
        if(view == seekbarExperience){
            minExperience.equals(Float.toString(leftValue));
            maxExperience.equals(Float.toString(rightValue));
        }
        else if(view == seekbarFees){
            minFee.equals(Float.toString(leftValue));
            maxFee.equals(Float.toString(rightValue));
        }
        else if(view == seekbarDistance){
            minDistance.equals(Float.toString(leftValue));
            maxDistance.equals(Float.toString(rightValue));
        }
    }

    @Override
    public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) { }

    @Override
    public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) { }
}