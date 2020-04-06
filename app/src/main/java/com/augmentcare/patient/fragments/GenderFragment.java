package com.augmentcare.patient.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.PrefsHelper;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GenderFragment extends BaseFragment implements View.OnClickListener {

    public GenderFragment() {
    }

    @BindView(R.id.lytMale)
    View lytMale;
    @BindView(R.id.lytFemale)
    View lytFemale;
    @BindView(R.id.txtName)
    TextView txtName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gender, container, false);
        ButterKnife.bind(this, view);
        lytFemale.setOnClickListener(this);
        lytMale.setOnClickListener(this);

        txtName.setText(baseActivity.userData.getFirstName()+" "+ baseActivity.userData.getLastName());
        return view;
    }

    VolleyAPI.FragmentInteractionListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof VolleyAPI.FragmentInteractionListener){
            listener = (VolleyAPI.FragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.lytMale) {
            Bundle bundle = new Bundle();
            bundle.putString("gender", "Male");
            AnalyticsUtils.logEvent(getContext(), FirebaseEvents.PROFILE_SETUP_GENDER,"Male");
            listener.onFragmentInteraction(3, bundle);
        }
        if(view.getId() == R.id.lytFemale){
            Bundle bundle = new Bundle();
            bundle.putString("gender", "Female");
            AnalyticsUtils.logEvent(getContext(), FirebaseEvents.PROFILE_SETUP_GENDER,"Female");
            listener.onFragmentInteraction(3, bundle);
        }
    }
}
