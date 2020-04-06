package com.augmentcare.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.EducationExperience;
import com.augmentcare.patient.network.restApi.apimodels.MedicalPractice;
import com.augmentcare.patient.network.restApi.apimodels.Specialization;

import java.util.List;

public class DoctorPracticeLocationDetailsAdapter extends RecyclerView.Adapter<DoctorPracticeLocationDetailsAdapter.ViewHolder> {
    private List<EducationExperience> experienceList;
    private List<Specialization> specializationList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mSpecalizeTextView,mSpecalizeTextViewDate, mHospitalTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mSpecalizeTextView = itemView.findViewById(R.id.speacialize_textview);
            mSpecalizeTextViewDate = itemView.findViewById(R.id.speacialize_date);
            mHospitalTextView = itemView.findViewById(R.id.hospital_textview);
        }
    }

    public DoctorPracticeLocationDetailsAdapter(List<EducationExperience> experienceModelList, List<Specialization> specializationList, Context context) {
        this.experienceList = experienceModelList;
        this.specializationList = specializationList;
        this.context = context;
    }

    public void setExpAndSpec(List<EducationExperience> experienceList, List<Specialization> specializationList) {
        this.experienceList = experienceList;
        this.specializationList = specializationList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DoctorPracticeLocationDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_doctor_education_details, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_work_exp, parent, false);
        return new DoctorPracticeLocationDetailsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final DoctorPracticeLocationDetailsAdapter.ViewHolder holder, final int position) {
        EducationExperience currentItem = null;
        Specialization currentItemSpecialization = null;
        if (position <= experienceList.size() - 1) {
            currentItem = experienceList.get(position);
        }
        if (position <= specializationList.size() - 1) {
            currentItemSpecialization = specializationList.get(position);
        }
        String startDate = "";
        if (currentItem != null && currentItem.getStart() != null) {
            String[] split = currentItem.getStart().split("-");
            startDate = split[0];
        }
        String endDate = "";
        if (currentItem != null && currentItem.getEnd() != null) {
            String[] split = currentItem.getEnd().split("-");
            endDate = split[0];
        }
        if (endDate.isEmpty()) {
//            holder.mSpecalizeTextView.setText(""+currentItem.getName());
//            holder.mSpecalizeTextViewDate.setText(" (" + startDate + " - " + " Present" + ")");
            holder.mSpecalizeTextViewDate.setText(" (" + " " + " - " + " " + ")");
//            holder.mSpecalizeTextView.setText(currentItem.getName() + " - Present");
        } else {
            holder.mSpecalizeTextViewDate.setText(" (" + startDate + " - " + endDate + ")");
        }
        if (currentItemSpecialization != null) {
            holder.mSpecalizeTextView.setText("" + currentItemSpecialization.getName());
        }
        if (currentItem != null) {
            holder.mHospitalTextView.setText(currentItem.getName());
        }
    }

    @Override
    public int getItemCount() {
        return experienceList.size();
    }
}