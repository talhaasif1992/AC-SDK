package com.augmentcare.patient.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.model.DependentType;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PatientProfileFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtDOB)
    TextView txtDOB;
    @BindView(R.id.txtAge)
    TextView txtAge;
    @BindView(R.id.ivGenderType)
    ImageView ivGenderType;
    @BindView(R.id.txtGender)
    TextView txtGender;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtPhoneNumber)
    TextView txtPhoneNumber;
    @BindView(R.id.btnAddProfile)
    View btnAddProfile;
    @BindView(R.id.txtEditProfile)
    View txtEditProfile;
    @BindView(R.id.ivArrow)
    View ivArrow;
    @BindView(R.id.cardBookAppointment)
    View cardBookAppointment;
    @BindView(R.id.txtAgeType)
    TextView txtAgeType;
    public PatientProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_patient_profile, container, false);
        ButterKnife.bind(this,view);
        btnAddProfile.setOnClickListener(this);
        txtEditProfile.setOnClickListener(this);
        cardBookAppointment.setOnClickListener(this);
        return view;
    }

    public void setData(Bundle bundle) {
        if(bundle!=null){
            if(bundle.getString("type").equalsIgnoreCase("me")){
                txtGender.setText(bundle.getString("gender"));
                txtName.setText(baseActivity.userData.getFirstName()+" "+ baseActivity.userData.getLastName());
                if(bundle.containsKey("dob")){
                    Date date = (Date) bundle.getSerializable("dob");
                    txtDOB.setText(TextUtils.formatDOB(date));
                }

                txtAge.setText(bundle.getString("age"));
                txtAgeType.setText(bundle.getString("ageType"));
                txtEmail.setText(baseActivity.userData.getEmail());
                if(baseActivity.userData.getPhone()!=null && !baseActivity.userData.getPhone().isEmpty())
                    txtPhoneNumber.setText(baseActivity.userData.getPhone());
                if (bundle.getString("gender").equalsIgnoreCase("male")) {
                    txtGender.setText("Male");
                    Glide.with(Utils.getApp())
                            .load(R.drawable.ic_male_gray)
                            .error(R.drawable.profile_placeholder)
                            .placeholder(R.drawable.profile_placeholder)
                            .into(ivGenderType);
                } else {
                    txtGender.setText("Female");
                    Glide.with(Utils.getApp())
                            .load(R.drawable.ic_female_gray)
                            .error(R.drawable.profile_placeholder)
                            .placeholder(R.drawable.profile_placeholder)
                            .into(ivGenderType);
                }
                btnAddProfile.setVisibility(View.GONE);
                txtEditProfile.setVisibility(View.VISIBLE);
                ivArrow.setVisibility(View.VISIBLE);

            }else{
                txtGender.setText(bundle.getString("relationship").toUpperCase());
                DependentType depenType = bundle.getParcelable("dependent");
                txtName.setText(bundle.getString("name"));
                if (bundle.containsKey("dob")){
                    Date date = (Date) bundle.getSerializable("dob");
                    txtDOB.setText(TextUtils.formatDOBProfile(date));
                }
                txtAge.setText(bundle.getString("age"));
                txtAgeType.setText(bundle.getString("ageType"));

                ivGenderType.setImageResource(R.drawable.ic_male_gray);
                txtEmail.setText(baseActivity.userData.getEmail());
                if(baseActivity.userData.getPhone()!=null && !baseActivity.userData.getPhone().isEmpty())
                    txtPhoneNumber.setText(baseActivity.userData.getPhone());
                btnAddProfile.setVisibility(View.VISIBLE);
                txtEditProfile.setVisibility(View.GONE);
                ivArrow.setVisibility(View.GONE);
                switch (depenType.getId().replace(".0","")){
                    case "0":
                        Glide.with(Utils.getApp())
                                .load(R.drawable.ic_mother)
                                .error(R.drawable.profile_placeholder)
                                .placeholder(R.drawable.profile_placeholder)
                                .into(ivGenderType);
                        break;
                    case "1":
                        Glide.with(Utils.getApp())
                                .load(R.drawable.ic_father)
                                .error(R.drawable.profile_placeholder)
                                .placeholder(R.drawable.profile_placeholder)
                                .into(ivGenderType);
                        break;
                    case "2":
                        Glide.with(Utils.getApp())
                                .load(R.drawable.ic_wife)
                                .error(R.drawable.profile_placeholder)
                                .placeholder(R.drawable.profile_placeholder)
                                .into(ivGenderType);
                        break;
                    case "3":
                        Glide.with(Utils.getApp())
                                .load(R.drawable.ic_husband)
                                .error(R.drawable.profile_placeholder)
                                .placeholder(R.drawable.profile_placeholder)
                                .into(ivGenderType);
                        break;
                    case "4":
                        Glide.with(Utils.getApp())
                                .load(R.drawable.ic_son)
                                .error(R.drawable.profile_placeholder)
                                .placeholder(R.drawable.profile_placeholder)
                                .into(ivGenderType);
                        break;
                    case "5":
                        Glide.with(Utils.getApp())
                                .load(R.drawable.ic_daughter)
                                .error(R.drawable.profile_placeholder)
                                .placeholder(R.drawable.profile_placeholder)
                                .into(ivGenderType);
                        break;
                    case "6":
                        Glide.with(Utils.getApp())
                                .load(R.drawable.ic_sibling)
                                .error(R.drawable.profile_placeholder)
                                .placeholder(R.drawable.profile_placeholder)
                                .into(ivGenderType);
                        break;
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAddProfile) {
            listener.onFragmentInteraction(7, new Bundle());
        }
        if (view.getId() == R.id.txtEditProfile) {
            listener.onFragmentInteraction(8, new Bundle());
        }
        if (view.getId() == R.id.cardBookAppointment) {
            MyApp.screenIndex = 1;
            baseActivity.setResult(Activity.RESULT_OK);
            baseActivity.finish();
        }
    }
    VolleyAPI.FragmentInteractionListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof VolleyAPI.FragmentInteractionListener) {
            listener = (VolleyAPI.FragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}