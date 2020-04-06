package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.Sicknotes;
import com.blankj.utilcode.util.TimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SickNotesFragment extends BaseFragment{
    @BindView(R.id.bed_rest_relative_layout)
    RelativeLayout mBedRestRelativeLayout;
    @BindView(R.id.sick_notes_description_relativelayout)
    RelativeLayout mSickNotesRelativeLayout;
    @BindView(R.id.bed_rest_textview)
    TextView mBedRestTextView;
    @BindView(R.id.bed_rest_date)
    TextView mBedRestDateTextView;
    @BindView(R.id.sick_notes_description_textview)
    TextView mSicktNotesDescriptionTextView;
    @BindView(R.id.tvSickNoteEmptyState)
    TextView tvEmptyState;
    String sickNotesDescription, sickNotesStartDate, sickNotesBedRest, sickNotesEndDate;
    private View rootView;
    Sicknotes sicknotes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sick_notes, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt() {
        loadArgs();

        ((HomeScreenActivity)baseActivity).setToolbarTitle("Sick Notes");

        try {
            sickNotesDescription = null;
            if(sicknotes != null){
                tvEmptyState.setVisibility(View.GONE);
                sickNotesDescription = sicknotes.getNote();
                sickNotesStartDate = convertFormat(sicknotes.getLeaveStartDate(),"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'","dd-MMM-yyyy");
                sickNotesEndDate = convertFormat(sicknotes.getLeaveEndDate(),"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "dd-MMM-yyyy");
                sickNotesBedRest = sicknotes.getAllowBedRest().toString();
            }
            else{
                tvEmptyState.setVisibility(View.VISIBLE);
            }
            if (!sickNotesBedRest.isEmpty() && sickNotesBedRest.equalsIgnoreCase("true")) {
                mBedRestTextView.setText(R.string.bed_rest_allowed_from);
            }
            if (!sickNotesStartDate.isEmpty() && !sickNotesEndDate.isEmpty()) {

                mBedRestDateTextView.setText(sickNotesStartDate + " - " + sickNotesEndDate);
            }
            if (!sickNotesDescription.isEmpty()){
                mSicktNotesDescriptionTextView.setText(sickNotesDescription);
            }
        } catch (Exception ignored) {
        }
    }

    private void loadArgs() {
        if(getArguments() != null){
            SickNotesFragmentArgs args = SickNotesFragmentArgs.fromBundle(getArguments());
            if(args!=null && args.getSickNotes()!=null){
                sicknotes = args.getSickNotes();
            }
        }
    }

    private String convertFormat(String date,String currentFormat,String expectedFormat){
        return TimeUtils.date2String(
                TimeUtils.string2Date(date,currentFormat),
                expectedFormat
        );
    }
}