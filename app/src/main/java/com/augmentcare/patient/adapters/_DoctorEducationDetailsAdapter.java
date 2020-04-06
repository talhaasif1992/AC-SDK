package com.augmentcare.patient.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import com.augmentcare.patient.R;
import com.augmentcare.patient.model.doctorDetails.Education;

public class _DoctorEducationDetailsAdapter extends RecyclerView.Adapter<_DoctorEducationDetailsAdapter.ViewHolder> {
    private List<Education> educationList;
    private Context context;



    public _DoctorEducationDetailsAdapter(List<Education> educationList, Context context) {
        this.educationList = educationList;
        this.context = context;
    }

    @Override
    public _DoctorEducationDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_doctor_education, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_work_exp, parent, false);
        _DoctorEducationDetailsAdapter.ViewHolder evh = new _DoctorEducationDetailsAdapter.ViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(final _DoctorEducationDetailsAdapter.ViewHolder holder, final int position) {
        final Education currentItem = educationList.get(position);
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
           // holder.mSpecalizeTextViewDate.setText(" (" + startDate + " - " + " Present" + ")");
            holder.mSpecalizeTextViewDate.setText(" (" +" "  + " - " + " " + ")");
//            holder.mSpecalizeTextView.setText(currentItem.getName() + " - Present");
        } else {
            holder.mSpecalizeTextViewDate.setText(" (" + startDate + " - " + endDate + ")");
        }
        holder.mSpecalizeTextView.setText(""+currentItem.getName());
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