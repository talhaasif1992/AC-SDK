package com.augmentcare.patient.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentMethodFragment extends BaseFragment {


    public PaymentMethodFragment() {
    }

    @BindView(R.id.lytPaymentOptions)
    LinearLayout lytPaymentOptions;

    private ArrayList<String> options ;

    VolleyAPI.FragmentInteractionListener interactionListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_payment_method, container, false);
        ButterKnife.bind(this, view);
        options = new ArrayList<>();
        options.add("Credit Card");
        options.add("Cash On Delivery");

        showOptions(options, lytPaymentOptions);
        return view;
    }
    private void showOptions(ArrayList<String> locs, ViewGroup lytLocs){

        if (locs!=null && locs.size()>0) {
            LayoutInflater inflater =  LayoutInflater.from(baseActivity);
            for(String option : locs){
                //TODO null is replaced by lytLocs to avoid exception
                View view = inflater.inflate(R.layout.item_location_medical, lytLocs);
                TextView txtName = view.findViewById(R.id.txtName);
                txtName.setText(option);
                view.setTag(option);
                view.setOnClickListener(listener);
                lytLocs.addView(view);
            }
        }

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String option = (String) v.getTag();
            if (option.contains("Credit")) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.KEY_TYPE, "credit");
                interactionListener.onFragmentInteraction(2,bundle );

            }
            if (option.contains("Cash")) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.KEY_TYPE, "cash");
                interactionListener.onFragmentInteraction(2,bundle );
            }
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof VolleyAPI.FragmentInteractionListener){
            interactionListener = (VolleyAPI.FragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionListener = null;
    }
}
