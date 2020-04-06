package com.augmentcare.patient.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileNamesFragment extends BaseFragment {

    @BindView(R.id.etxtFirstName)
    AppCompatEditText etxtFirstName;
    @BindView(R.id.layoutFirstName)
    TextInputLayout layoutFirstName;
    @BindView(R.id.etxtLastName)
    AppCompatEditText etxtLastName;
    @BindView(R.id.layoutLastName)
    TextInputLayout layoutLastName;
    @BindView(R.id.btnNext)
    View btnNext;

    public ProfileNamesFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_names, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initMe();
    }

    private void initMe(){

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fName", etxtFirstName.getText().toString());
                    bundle.putString("lName", etxtLastName.getText().toString());
                    listener.onFragmentInteraction(4, bundle);
                    AnalyticsUtils.logEvent(getContext(), FirebaseEvents.PROFILE_SETUP_FAMILY_NAME,etxtFirstName.getText().toString());
                }
            }
        });
    }

    private boolean validateForm() {
        int errorCount = 0;
        if (etxtFirstName.getText().toString().trim().isEmpty()) {
            layoutFirstName.setError(getString(R.string.error_enter_valid_name));

            errorCount++;
        } else {
            layoutFirstName.setError(null);


        }
        if (etxtLastName.getText().toString().trim().isEmpty()) {
            layoutLastName.setError(getString(R.string.error_enter_valid_name));

            errorCount++;
        } else {
            layoutLastName.setError(null);

        }
        return errorCount == 0;
    }

    VolleyAPI.FragmentInteractionListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof VolleyAPI.FragmentInteractionListener) {
            listener = (VolleyAPI.FragmentInteractionListener) context;
        }
    }
    public void clear(){
        etxtFirstName.setText("");
        etxtLastName.setText("");
    }
}
