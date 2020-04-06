package com.augmentcare.patient.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.FirebaseEvents;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProileTypeFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.btnMe)
    Button btnMe;
    @BindView(R.id.btnFamily)
    Button btnFamily;
    public ProileTypeFragment() {
    }

    VolleyAPI.FragmentInteractionListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_proile_type, container, false);
        ButterKnife.bind(this, view);
        btnMe.setOnClickListener(this);
        btnFamily.setOnClickListener(this);

        return view;
    }


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
        if (view.getId() == R.id.btnMe) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "me");
            listener.onFragmentInteraction(1, bundle);
            AnalyticsUtils.logEvent(getContext(), FirebaseEvents.PROFILE_SETUP_ME, null);
        }

        if (view.getId() == R.id.btnFamily) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "family");
            listener.onFragmentInteraction(1, bundle);
            AnalyticsUtils.logEvent(getContext(), FirebaseEvents.PROFILE_SETUP_FAMILY, null);
        }
    }
}
