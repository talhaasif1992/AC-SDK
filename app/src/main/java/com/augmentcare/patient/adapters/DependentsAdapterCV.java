package com.augmentcare.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

/**
 * Created by Zulqurnain Jutt on 6/13/2017.
 */

public class DependentsAdapterCV extends RecyclerView.Adapter<DependentsAdapterCV.DataObjectHolder> {
    private Context context;
    private List<Dependent> dependents;
    private int lastSelectedPosition = 0;
    private OnValueGot<Dependent> gotDependent = null;
    private boolean disableClick;

    private Boolean isSelectByID = null;
    private String selectName;
    private long selectID = -1;

    public DependentsAdapterCV(Context context, List<Dependent> dependents) {
        this.context = context;
        this.dependents = dependents;
    }

    public void disableDepedentClick(boolean disableClick) {
        this.disableClick = disableClick;
    }

    public void selectDependent(String name) {
        isSelectByID = false;
        this.selectName = name;
        notifyDataSetChanged();
    }

    public void selectDependent(long id) {
        isSelectByID = true;
        this.selectID = id;
        notifyDataSetChanged();
    }

    public void observeSelectedDependent(OnValueGot<Dependent> got) {
        gotDependent = got;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
        notifyDataSetChanged();

        isSelectByID = null;
        selectID = -1;
    }

    @NonNull
    @Override
    public DependentsAdapterCV.DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_dependent_appointment, parent, false);
        return new DependentsAdapterCV.DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder viewHolder, int position) {
        final Dependent item = dependents.get(position);

        viewHolder.dependentNameTV.setText(item.getName());
        viewHolder.relationshipTV.setText(StringUtils.null2Length0(item.getRelationWithPrimary()));
        if (item.getName() == null && item.getRelationWithPrimary() == null) {
            viewHolder.dependentNameTV.setText("My Self");
        } else {
            viewHolder.dependentNameTV.setText(StringUtils.null2Length0(item.getName()));
        }
        if (!StringUtils.isEmpty(item.getPhoto())) {
            Glide.with(context)
                    .load(item.getPhoto())
                    .apply(RequestOptions.circleCropTransform())
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .into(viewHolder.imgIV);
        }

        viewHolder.rootCDA.setOnClickListener(v -> {
            if (!disableClick) {
                lastSelectedPosition = position;
                notifyDataSetChanged();
                if (gotDependent != null) {
                    gotDependent.gotIt(dependents.get(position));
                }
            }
        });

        if (isSelectByID != null) {
            if (!isSelectByID) {
                if (StringUtils.equals(selectName, dependents.get(position).getName()) && !StringUtils.isEmpty(selectName)) {
                    lastSelectedPosition = position;
                    if (gotDependent != null) {
                        gotDependent.gotIt(dependents.get(position));
                    }
                }
            } else {
                if (selectID > 0 && dependents.get(position).getId() == selectID) {
                    lastSelectedPosition = position;
                    if (gotDependent != null) {
                        gotDependent.gotIt(dependents.get(position));
                    }
                }
            }
        }

        if (position == lastSelectedPosition) {
            viewHolder.imgIV.setBorderWidth(4f);
            viewHolder.imgIV.setBorderColor(ContextCompat.getColor(context, R.color.colorBlueDark));

            viewHolder.dependentNameTV.setTextColor(ContextCompat.getColor(context, R.color.colorBlueDark));
            viewHolder.relationshipTV.setTextColor(ContextCompat.getColor(context, R.color.colorBlueDark));
        } else {
            viewHolder.imgIV.setBorderWidth(0);

            viewHolder.dependentNameTV.setTextColor(ContextCompat.getColor(context, R.color.pf_grey));
            viewHolder.relationshipTV.setTextColor(ContextCompat.getColor(context, R.color.pf_grey));
        }


    }

    @Override
    public int getItemCount() {
        return dependents.size();
    }

    class DataObjectHolder extends RecyclerView.ViewHolder {
        LinearLayout rootCDA;
        CircularImageView imgIV;
        TextView dependentNameTV;
        TextView relationshipTV;

        DataObjectHolder(View itemView) {
            super(itemView);
            rootCDA = itemView.findViewById(R.id.rootCDA);
            imgIV = itemView.findViewById(R.id.imgIV);
            dependentNameTV = itemView.findViewById(R.id.dependentNameTV);
            relationshipTV = itemView.findViewById(R.id.relationshipTV);
        }
    }
}