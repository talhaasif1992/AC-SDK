package com.augmentcare.patient.claim;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.ClaimInterface;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.ViewClaimImageActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class RecycleViewAdapterImages extends RecyclerView.Adapter<RecycleViewAdapterImages.ViewHolder> {

    private final ClaimInterface onImage;
    private Context context;
    private List<String> list;

    public RecycleViewAdapterImages(Context context, List<String> list, ClaimInterface onImage) {
        this.list = list;
        this.context = context;
        this.onImage = onImage;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mClaimImageView, mClaimRemoveImageView;

        public ViewHolder(View itemView){
            super(itemView);
            mClaimImageView = itemView.findViewById(R.id.claim_image_view);
            mClaimRemoveImageView = itemView.findViewById(R.id.remove_claim_list_image);
        }
    }

    @NotNull
    @Override
    public RecycleViewAdapterImages.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_custom_recycler_images, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position){
        try{
            Glide.with(context)
                    .load(list.get(position))
                    .error(R.drawable.ic_file)
                    .placeholder(R.drawable.ic_file)
                    .into(holder.mClaimImageView);

            Glide.with(context)
                    .load(list.get(position))
                    .listener(new RequestListener<Drawable>(){
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false; // important to return false so the error placeholder can be placed
                        }
                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            if(onImage != null)
                                onImage.dismissDialog();
                            return false;
                        }
                    })
                    .error(R.drawable.ic_file)
                    .placeholder(R.drawable.ic_file)
                    .into(holder.mClaimImageView);

            int path = R.drawable.ic_claim_pick_image;
            if (list.get(position).trim().equalsIgnoreCase(String.valueOf(path))) {
                holder.mClaimRemoveImageView.setVisibility(View.GONE);
            }
            holder.mClaimRemoveImageView.setOnClickListener(v -> {
                list.remove(position);
                if(onImage != null)
                    onImage.deleteImage();
                notifyDataSetChanged();
            });
            holder.mClaimImageView.setOnClickListener(view -> {
                Intent intent = new Intent(context, ViewClaimImageActivity.class);
                intent.putExtra("url", list.get(position));
                context.startActivity(intent);
            });
        }
        catch(Exception ignored){}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}