package com.augmentcare.patient.subcription_model;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.APlan;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class SubcriptionDetailAdapter extends RecyclerView.Adapter<SubcriptionDetailAdapter.ViewHolder> {
    private Context context;
    public  ArrayList<String>  aPlanArrayList= new ArrayList<String>();



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description_TV;


        public ViewHolder(View itemView) {
            super(itemView);
            description_TV = itemView.findViewById(R.id.description_TV);



        }
    }

    public SubcriptionDetailAdapter(ArrayList<String> subcriptionModelArrayList, Context context) {
        this.aPlanArrayList = subcriptionModelArrayList;
        this.context = context;
    }

    @NotNull
    @Override
    public SubcriptionDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcription_detail_list_layout, parent, false);
        return new SubcriptionDetailAdapter.ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            final String currentItem = aPlanArrayList.get(position);
            holder.description_TV.setText(""+currentItem);
        } catch (Exception ignored) {
        }
    }

    @Override
    public int getItemCount() {
        return aPlanArrayList.size();
    }
}