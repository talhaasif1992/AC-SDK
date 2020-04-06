package com.augmentcare.patient.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EliteDoctorRvAdapter extends RecyclerView.Adapter<EliteDoctorRvAdapter.ViewHolder> implements Filterable {
    private List<DoctorInfoLimited> mDoctorArrayList;
    private List<DoctorInfoLimited> mDoctorArrayListToBeFiltered;
    private Context context;
    private OnItemClickListener mlistener;

    public interface OnItemClickListener{ void onEliteClick(int position); }

    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener = listener;
    }

    @Override
    public Filter getFilter() {
        return filterDoctors;
    }

    private Filter filterDoctors = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<DoctorInfoLimited> filteredList = new ArrayList<>();

            if(charSequence==null || charSequence.length() < 1 || charSequence.toString().isEmpty()){
                filteredList.addAll(mDoctorArrayListToBeFiltered);
            }
            else{
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(DoctorInfoLimited doctor : mDoctorArrayListToBeFiltered){
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView eliteDoctorProfilePic;
        public TextView eliteDoctorName, eliteDoctorDegree, eliteDoctorSpeciality, eliteDoctorRating, eliteDoctorReviews;

        public ViewHolder(View itemView){
            super(itemView);
            eliteDoctorProfilePic = itemView.findViewById(R.id.civEliteDoctorProfilePic);
            eliteDoctorName = itemView.findViewById(R.id.tvEliteDoctorName);
            eliteDoctorDegree = itemView.findViewById(R.id.tvEliteDogtorDegree);
            eliteDoctorSpeciality = itemView.findViewById(R.id.tvEliteDoctorSpeciality);
            eliteDoctorRating = itemView.findViewById(R.id.tvItemRating);
            eliteDoctorReviews = itemView.findViewById(R.id.tvReviews);

            itemView.setOnClickListener(view -> {
                if(mlistener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        mlistener.onEliteClick(position);
                    }
                }
            });
        }
    }

    public EliteDoctorRvAdapter(List<DoctorInfoLimited> mDoctorArrayList, Context context){
        this.mDoctorArrayList = mDoctorArrayList;
        this.mDoctorArrayListToBeFiltered = new ArrayList<>(mDoctorArrayList);
        this.context = context;
    }

    @NonNull
    @Override
    public EliteDoctorRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_rv_our_elite_panel, parent, false);
        return new EliteDoctorRvAdapter.ViewHolder(v);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull EliteDoctorRvAdapter.ViewHolder holder, final int position) {
        //final EliteDoctorRvModel  listItem= listItems.get(position);

        try {
            final DoctorInfoLimited currentItem = mDoctorArrayList.get(position);
            holder.eliteDoctorName.setText(currentItem.getName());

            holder.eliteDoctorDegree.setText("");

            holder.eliteDoctorSpeciality.setText(currentItem.getSpecialization().get(0));

            Glide.with(context).load(currentItem.getPicture()).apply(RequestOptions.circleCropTransform()).into(holder.eliteDoctorProfilePic);

            if(currentItem.getRatedCount() == 0){
                holder.eliteDoctorReviews.setText("No reviews yet");
            }
            else {
                holder.eliteDoctorReviews.setText(currentItem.getRatedCount() + " Reviews");
            }

            if(currentItem.getRating().equals("0.0") || currentItem.getRating().equals("0")){
                holder.eliteDoctorRating.setText("No ratings yet");
            }
            else{
                holder.eliteDoctorRating.setText(currentItem.getRating());
            }
        }
        catch (Exception ignored) { }
    }

    @Override
    public int getItemCount() {
        return mDoctorArrayList.size();
    }
}