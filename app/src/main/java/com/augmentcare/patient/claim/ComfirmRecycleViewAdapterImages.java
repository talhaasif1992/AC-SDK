package com.augmentcare.patient.claim;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ComfirmRecycleViewAdapterImages extends RecyclerView.Adapter<ComfirmRecycleViewAdapterImages.ViewHolder> {

    private Context context;
    private List<String> list;
    private View rootView;

    public ComfirmRecycleViewAdapterImages(Context context, List<String> list) {
        this.list = list;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mClaimImageView, mDeleteImageView;
        FrameLayout llBox2;

        public ViewHolder(View itemView) {
            super(itemView);
            mClaimImageView = itemView.findViewById(R.id.claim_image_view);
            mDeleteImageView = itemView.findViewById(R.id.remove_claim_list_image);
            llBox2 = itemView.findViewById(R.id.llBox2);
        }
    }

    @NotNull
    @Override
    public ComfirmRecycleViewAdapterImages.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_custom_recycler_images, parent, false);
        ViewHolder vh = new ViewHolder(rootView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.mDeleteImageView.setVisibility(View.GONE);
        Log.wtf("list2", list.get(position));

        if (!list.get(position).trim().equalsIgnoreCase("2131231257")) {
            Glide.with(context)
                    .load(list.get(position))
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .apply(RequestOptions.centerInsideTransform())
                    .into(holder.mClaimImageView);
        } else {
            holder.llBox2.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}