package com.augmentcare.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.model.RatingModel;

import java.util.List;

public class DoctorRatingAdapter extends RecyclerView.Adapter<DoctorRatingAdapter.ViewHolder> {
    private List<RatingModel> ratingModelList;
    private Context context;


    public DoctorRatingAdapter(List<RatingModel> educationList, Context context) {
        this.ratingModelList = educationList;
        this.context = context;
    }

    public void setRatingModelList(List<RatingModel> ratingModelList) {
        this.ratingModelList = ratingModelList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DoctorRatingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_doctor_education, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_review, parent, false);
        return new DoctorRatingAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RatingModel currentItem = ratingModelList.get(position);

        holder.patientName_textview.setText("Altaf Hussain");
        holder.review_textview.setText(currentItem.getRating_comments());
        holder.date_textview.setText("09 Feb 2019");
        holder.rating.setRating(Float.parseFloat(currentItem.getRating()));

    }

    @Override
    public int getItemCount() {
        return ratingModelList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView patientName_textview,review_textview,date_textview;
        RatingBar rating;


        public ViewHolder(View itemView) {
            super(itemView);
            patientName_textview = itemView.findViewById(R.id.patientName_textview);
            review_textview = itemView.findViewById(R.id.review_textview);
            date_textview = itemView.findViewById(R.id.date_textview);
            rating = itemView.findViewById(R.id.rating);
        }
    }

}