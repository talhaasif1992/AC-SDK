package com.augmentcare.patient.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.ViewClaimImageActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UploadImagesAdapter extends RecyclerView.Adapter<UploadImagesAdapter.ViewHolder> {
    private List<String> mUploadedClaimImagesList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mUploadClaimImageView, mVisibilityImageView;
        public LinearLayout mViewImageLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mUploadClaimImageView = itemView.findViewById(R.id.upload_images);
            mVisibilityImageView = itemView.findViewById(R.id.image_visibility);
            mViewImageLinearLayout = itemView.findViewById(R.id.view_image_layout);
        }
    }

    public UploadImagesAdapter(List<String> mUploadedClaimImagesList, Context context) {
        this.mUploadedClaimImagesList = mUploadedClaimImagesList;
        this.context = context;
    }
    @NotNull
    @Override
    public UploadImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_upload_images, parent, false);
        return new UploadImagesAdapter.ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NotNull final UploadImagesAdapter.ViewHolder holder, final int position) {
        try {
            if (mUploadedClaimImagesList.get(position) != null) {

                Glide.with(context)
                        .load(mUploadedClaimImagesList.get(position))
                        .apply(RequestOptions.fitCenterTransform())
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(holder.mUploadClaimImageView);
            }
            holder.mVisibilityImageView.setVisibility(View.GONE);
            holder.mViewImageLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ViewClaimImageActivity.class);
                    intent.putExtra("url", mUploadedClaimImagesList.get(position));
                    context.startActivity(intent);
                }
            });
        } catch (Exception ignored) {
        }
    }
    @Override
    public int getItemCount() {
        return mUploadedClaimImagesList.size();
    }
}