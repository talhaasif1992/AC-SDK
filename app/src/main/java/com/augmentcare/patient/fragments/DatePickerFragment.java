package com.augmentcare.patient.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import com.augmentcare.patient.base.BaseDialogFragment;
import com.augmentcare.patient.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by qamar on 15/12/2017.
 */

public class DatePickerFragment extends BaseDialogFragment {

    private Date date;
    DatePickerDialog.OnDateSetListener mListener;

    public DatePickerFragment(){

    }


    public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listner, Date dob) {

        Bundle args = new Bundle();
        args.putSerializable(Constants.KEY_DATA,dob);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        fragment.setListener(listner);
        return fragment;
    }
    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current daySpinner as the default daySpinner in the picker
        final Calendar c = Calendar.getInstance();
        date = (Date) getArguments().getSerializable(Constants.KEY_DATA);
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(baseActivity, mListener, year, month, day);
    }
    public void setListener(DatePickerDialog.OnDateSetListener listner){
        mListener = listner;
    }


}