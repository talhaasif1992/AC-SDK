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

import java.text.MessageFormat;
import java.util.List;

public class DoctorEducationDetailsAdapter extends RecyclerView.Adapter<DoctorEducationDetailsAdapter.ViewHolder> {
    private List<EducationExperience> educationList;
    private Context context;



    public DoctorEducationDetailsAdapter(List<EducationExperience> educationList, Context context) {
        this.educationList = educationList;
        this.context = context;
    }

    public void setEducationList(List<EducationExperience> educationList) {
        this.educationList = educationList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DoctorEducationDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_doctor_education, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_work_exp, parent, false);
        return new DoctorEducationDetailsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final DoctorEducationDetailsAdapter.ViewHolder holder, final int position) {
        final EducationExperience currentItem = educationList.get(position);
        String startDate = "";
        if (currentItem.getStart() != null) {
            String[] split = currentItem.getStart().split("-");
            startDate = split[0];
        }
        String endDate = "";
        if (currentItem.getEnd() != null) {
            String[] split = currentItem.getEnd().split("-");
            endDate = split[0];
        }
        if (endDate.isEmpty()) {
            // holder.mSpecalizeTextView.setText(""+currentItem.getName());
            holder.mSpecalizeTextViewDate.setText(MessageFormat.format(" ({0} -  Present)", startDate));
//            holder.mSpecalizeTextView.setText(currentItem.getName() + " - Present");
        } else {
            holder.mSpecalizeTextViewDate.setText(MessageFormat.format(" ({0} - {1})", startDate, endDate));
        }
        holder.mSpecalizeTextView.setText(MessageFormat.format("{0}", currentItem.getName()));
        holder.mHospitalTextView.setText(currentItem.getInstitution());
    }

    @Override
    public int getItemCount() {
        return educationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mSpecalizeTextView,mSpecalizeTextViewDate, mHospitalTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mSpecalizeTextView = itemView.findViewById(R.id.speacialize_textview);
            mSpecalizeTextViewDate = itemView.findViewById(R.id.speacialize_date);
            mHospitalTextView = itemView.findViewById(R.id.hospital_textview);
        }
    }
}