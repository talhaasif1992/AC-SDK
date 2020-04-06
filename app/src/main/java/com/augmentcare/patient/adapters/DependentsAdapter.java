package com.augmentcare.patient.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.OnDeleteDependentCall;
import com.augmentcare.patient.R;
import com.augmentcare.patient.fragments.DependentFragment;
import com.augmentcare.patient.fragments.DependentFragmentDirections;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DependentsAdapter extends RecyclerView.Adapter<DependentsAdapter.ViewHolder> {
    private List<Dependent> dependentArrayList;
    private Context context;
    private NavController navController;
    private OnDeleteDependentCall deleteDependentCall;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatImageView ivPic;
        public ImageView ivEdit, ivDeleteIconVisa;
        public TextView tvName, tvRelation;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txtName);
            ivPic = itemView.findViewById(R.id.ivThumb);
            ivEdit = itemView.findViewById(R.id.iv_edit);
            ivDeleteIconVisa = itemView.findViewById(R.id.iv_delete_icon_visa);
            tvRelation = itemView.findViewById(R.id.txtRelation);
        }
    }

    public DependentsAdapter(List<Dependent> dependentArrayList, Context context, DependentFragment fr) {
        this.dependentArrayList = dependentArrayList;
        this.context = context;
        this.deleteDependentCall = fr;
        navController = Navigation.findNavController((Activity) context, R.id.nav_host_fragment);
    }

    public void setDependents(List<Dependent> dependentArrayList){
        this.dependentArrayList = dependentArrayList;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public DependentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_dependent_members, parent, false);
        return new DependentsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DependentsAdapter.ViewHolder holder, final int position) {
        final Dependent dependant = dependentArrayList.get(position);

        holder.tvName.setText(dependant.getName());

        holder.tvRelation.setText(StringUtils.null2Length0(dependant.getRelationWithPrimary()));

        if (!StringUtils.isEmpty(dependant.getPhone())) {

            Glide.with(context)
                    .load(dependant.getPhoto())
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.ivPic);
        }else{
            Glide.with(context)
                    .load(R.drawable.profile_placeholder)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.ivPic);
        }

        holder.ivDeleteIconVisa.setOnClickListener(view -> {
            dependentArrayList.remove(position);
            if(deleteDependentCall != null)
                deleteDependentCall.deleteItem(dependant.getId());
            notifyDataSetChanged();
        });

        holder.ivEdit.setOnClickListener(view -> {
            navController.navigate(
                    DependentFragmentDirections.actionDependentFragmentToUpdateDependentMemberFragment()
                            .setDependent(dependant)
            );
        });
    }

    @Override
    public int getItemCount() {
        return dependentArrayList.size();
    }
}