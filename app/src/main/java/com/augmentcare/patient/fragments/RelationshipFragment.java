package com.augmentcare.patient.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.RelationshipsAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.model.DependentType;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.FirebaseEvents;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RelationshipFragment extends BaseFragment {
    private VolleyAPI.FragmentInteractionListener listener;
    public RelationshipFragment() {
    }

    @BindView(R.id.grdRelationships)
    GridView grdRelationships;
    ArrayList<DependentType> dependentTypes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relationship, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void setDependentTypes(ArrayList<DependentType> types) {
        dependentTypes = types;
        grdRelationships.setAdapter(new RelationshipsAdapter(baseActivity, R.layout.item_relationship, R.id.txtRelation, dependentTypes));
        grdRelationships.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                dependentTypes.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("dependent_type", dependentTypes.get(position));
                listener.onFragmentInteraction(6, bundle);
                AnalyticsUtils.logEvent(getContext(), FirebaseEvents.PROFILE_SETUP_FAMILY_REL, dependentTypes.get(position).getTitle());

            }
        });
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
}
