package com.augmentcare.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.model.doctorDetails.Experience;

import java.util.List;

public class _DoctorPracticeLocationDetailsAdapter extends RecyclerView.Adapter<_DoctorPracticeLocationDetailsAdapter.ViewHolder> {
    private List<Experience> experienceList;
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

    public _DoctorPracticeLocationDetailsAdapter(List<Experience> experienceModelList, Context context) {
        this.experienceList = experienceModelList;
        this.context = context;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
        notifyDataSetChanged();
    }

    @Override
    public _DoctorPracticeLocationDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_doctor_education_details, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_work_exp, parent, false);
        return new _DoctorPracticeLocationDetailsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final _DoctorPracticeLocationDetailsAdapter.ViewHolder holder, final int position) {
        final Experience currentItem = experienceList.get(position);
        String startDate = "";
        if (currentItem.getStart() != null) {
            String[] split = currentItem.getStart().split("-");
            startDate = split[0];
        }


        // #TODO check condition for start and end time of doctor practice.
        String endDate = "";
        if (currentItem.getEnd() != null) {
            String[] split = currentItem.getEnd().split("-");
            endDate = split[0];
        }

//        else if (endDate.isEmpty()) {
////            holder.mSpecalizeTextView.setText(""+currentItem.getName());
//            holder.mSpecalizeTextViewDate.setText(" (" + startDate + " - " + " Present" + ")");
////            holder.mSpecalizeTextView.setText(currentItem.getName() + " - Present");
//        }
        if (startDate.isEmpty() && endDate.isEmpty()) {
//            holder.mSpecalizeTextView.setText(""+currentItem.getName());
            holder.mSpecalizeTextViewDate.setText("(  -  )");
//            holder.mSpecalizeTextView.setText(currentItem.getName() + " - Present");
        } else {
            holder.mSpecalizeTextViewDate.setText(" (" + startDate + " - " + endDate + ")");
        }
        holder.mSpecalizeTextView.setText(""+currentItem.getName());
        holder.mHospitalTextView.setText(currentItem.getInstitution());
    }

    @Override
    public int getItemCount() {
        return experienceList.size();
    }
}