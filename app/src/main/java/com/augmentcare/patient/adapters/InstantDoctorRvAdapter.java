package com.augmentcare.patient.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InstantDoctorRvAdapter extends RecyclerView.Adapter<InstantDoctorRvAdapter.ViewHolder> implements Filterable {
    private List<DoctorInfoLimited> mDoctorArrayList;
    private List<DoctorInfoLimited> mDoctorArrayListToBeFiltered;
    private Context context;
    private boolean showBadge = false;
    private int noOfFreeCalls;
    private OnItemClickListener mlistener;

    public interface OnItemClickListener {
        void onInstantClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mlistener = listener;
    }

    @Override
    public Filter getFilter() {
        return filterDoctors;
    }

    private Filter filterDoctors = new Filter(){
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<DoctorInfoLimited> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() < 1 || charSequence.toString().isEmpty()){
                filteredList.addAll(mDoctorArrayListToBeFiltered);
            }
            else{
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(DoctorInfoLimited doctor : mDoctorArrayListToBeFiltered) {
                    if(doctor.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(doctor);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mDoctorArrayList.clear();
            mDoctorArrayList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView instantDoctorProfilePic;
        TextView instantDoctorName, instantDoctorSpeciality, instantDoctorReviews;
        RatingBar instantDoctorRatingBar;
        TextView badge;

        public ViewHolder(View itemView) {
            super(itemView);
            instantDoctorProfilePic = itemView.findViewById(R.id.civInstantDoctorProfilePic);
            instantDoctorName = itemView.findViewById(R.id.tvInstantDoctorName);
            instantDoctorSpeciality = itemView.findViewById(R.id.tvInstantDoctorSpeciality);
            instantDoctorRatingBar = itemView.findViewById(R.id.rbInstantDoctor);
            instantDoctorReviews = itemView.findViewById(R.id.tvInstantDoctorReviews);
            badge = itemView.findViewById(R.id.badge_freeCall);

            itemView.setOnClickListener(v -> {
                if (mlistener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mlistener.onInstantClick(position);
                    }
                }
            });
        }
    }

    public InstantDoctorRvAdapter(List<DoctorInfoLimited> mDoctorArrayList, Context context, Boolean showBadge, int noOfFreeCalls) {
        this.mDoctorArrayList = mDoctorArrayList;
        this.mDoctorArrayListToBeFiltered = new ArrayList<>(mDoctorArrayList);
        this.context = context;
        this.showBadge = showBadge;
        this.noOfFreeCalls = noOfFreeCalls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_rv_instant_doctor, parent, false);
        return new InstantDoctorRvAdapter.ViewHolder(v);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NotNull InstantDoctorRvAdapter.ViewHolder viewHolder, int position) {

        if (showBadge) {
            viewHolder.badge.setText(Integer.toString(noOfFreeCalls));
            viewHolder.badge.setVisibility(View.VISIBLE);
        } else {
            viewHolder.badge.setVisibility(View.INVISIBLE);
        }

        try {
            final DoctorInfoLimited currentItem = mDoctorArrayList.get(position);

            viewHolder.instantDoctorName.setText(currentItem.getName());

            MyApp.get().computeRating(viewHolder.instantDoctorRatingBar, Float.parseFloat(currentItem.getRating()));
            viewHolder.instantDoctorRatingBar.setRating(Float.parseFloat(currentItem.getRating()));

            if (currentItem.getRatedCount() == 0) {
                viewHolder.instantDoctorReviews.setText("No reviews yet");
            } else {
                viewHolder.instantDoctorReviews.setText(MessageFormat.format("{0} Reviews", currentItem.getRatedCount()));
            }

            viewHolder.instantDoctorSpeciality.setText(currentItem.getSpecialization().get(0));

            Glide.with(context).load(currentItem.getPicture()).apply(RequestOptions.circleCropTransform()).into(viewHolder.instantDoctorProfilePic);

        } catch (Exception ignored) {
        }
    }

    @Override
    public int getItemCount() {
        return mDoctorArrayList.size();
    }
}