package com.augmentcare.patient.fragments;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.TextUtils;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;


public class DOBFragment extends BaseFragment implements View.OnClickListener {

    private Date dateOfBirth;

    public DOBFragment() {
    }

    @BindView(R.id.lytDob)
    View lytDob;
    @BindView(R.id.btnNext)
    View btnNext;
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtDay)
    TextView txtDay;
    @BindView(R.id.txtMonth)
    TextView txtMonth;
    @BindView(R.id.txtYear)
    TextView txtYear;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dob, container, false);
        ButterKnife.bind(this, view);
        lytDob.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        AnalyticsUtils.logEvent(getContext(), FirebaseEvents.PROFILE_SETUP_DOB, null);
        //dateOfBirth = Calendar.get().getTime();
        return view;
    }

    public void setName(String name) {
        txtName.setText(name);
        txtName.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                if(dateOfBirth!=null){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dob", dateOfBirth);
                    //bundle.putSerializable("dobObject", dateOfBirth);
                    listener.onFragmentInteraction(2, bundle);
                }else{
                    Toasty.info(getContext(),"Please set a valid Date of Birth", Toast.LENGTH_LONG, false).show();
                }
                break;
            case R.id.lytDob:

                Date gotDate = Calendar.getInstance().getTime();
                if (dateOfBirth != null) {

                    gotDate = dateOfBirth;
                }
                DatePickerFragment fragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month, day);
                        if(cal.getTime().before(Calendar.getInstance().getTime())){
                            String dobString = TextUtils.formatDOB(cal.getTime());

                            txtDay.setText(TextUtils.formatNumber2X(getContext(), day));
                            txtMonth.setText(TextUtils.formatNumber2X(getContext(), month+1));
                            txtYear.setText(String.valueOf(year));
                            dateOfBirth = cal.getTime();
                        }else{
                            Toasty.info(getContext(),"Please set a valid Date of Birth", Toast.LENGTH_LONG, false).show();
                        }
                    }
                }, gotDate);
                fragment.show(getChildFragmentManager(), "datePicker");
                break;
        }
    }


    public void clear(){
        txtDay.setText("DD");
        txtMonth.setText("MM");
        txtYear.setText("YYYY");
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
