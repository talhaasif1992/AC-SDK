package com.augmentcare.patient.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.UserClaims;
import com.blankj.utilcode.util.Utils;

import java.util.ArrayList;

public class UserClaimsAdapter extends RecyclerView.Adapter<UserClaimsAdapter.ViewHolder> {
    private ArrayList<UserClaims.ReimbursementsEntity> data;
    private OnItemClickListener mlistener;

    public interface OnItemClickListener{ void onClaimClick(int position , UserClaims.ReimbursementsEntity claim); }
    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener = listener;
    }

    public UserClaimsAdapter(ArrayList<UserClaims.ReimbursementsEntity> data){
        this.data = data;
    }

    @NonNull
    @Override
    public UserClaimsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_claims, viewGroup, false);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.claim_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserClaimsAdapter.ViewHolder viewHolder, final int position) {
        final UserClaims.ReimbursementsEntity claim = data.get(position);

        String claimAmount = "Rs " + claim.getAmount();
        viewHolder.tvClaimAmount.setText(claimAmount);
        String dateCreated = "Date Created: " + claim.getDate();
        viewHolder.tvClaimDateTime.setText(dateCreated);
        String claimId = "Claim ID: " + String.valueOf(claim.getId());
        viewHolder.tvClaimId.setText(claimId);

        if (claim.getStatus() != null && !claim.getStatus().trim().isEmpty()) {
            String status = claim.getStatus();

            if (status.contains("_")) {
                status = status.replace("_", " ");
            }
            viewHolder.tvStatus.setText(status.toUpperCase());

            if (claim.getStatus().equalsIgnoreCase("pending")) {
                viewHolder.tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_pending));
                viewHolder.ivStatusIcon.setBackgroundResource(R.drawable.ic_pending);
            }
            else if (claim.getStatus().equalsIgnoreCase("partial")) {
                viewHolder.tvClaimLableAmount.setText(R.string.claim_accepted_amount);
                claimAmount = "Rs " + claim.getFinalAmount();
                viewHolder.tvClaimAmount.setText(claimAmount);
                viewHolder.tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_approved));
                viewHolder.ivStatusIcon.setBackgroundResource(R.drawable.ic_partial);
            }
            else if (claim.getStatus().equalsIgnoreCase("accepted")) {
                viewHolder.tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_approved));
                viewHolder.ivStatusIcon.setBackgroundResource(R.drawable.ic_accept);
            }
            else if (claim.getStatus().equalsIgnoreCase("rejected")) {
                viewHolder.tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_rejected));
                viewHolder.ivStatusIcon.setBackgroundResource(R.drawable.ic_reject);
            }
            else {
                viewHolder.tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_rejected));
                viewHolder.ivStatusIcon.setBackgroundResource(R.drawable.ic_pending);
            }

            if (claim.getMessageRead()) {
                viewHolder.ivMessageIcon.setBackgroundResource(R.drawable.ic_claim_chat_message_icon);
            } else {
                viewHolder.ivMessageIcon.setBackgroundResource(R.drawable.ic_claim_chat_message_icon_selected);
            }
        }

        viewHolder.root.setOnClickListener(v -> {
            if(mlistener != null){
                if(position != RecyclerView.NO_POSITION){
                    mlistener.onClaimClick(position,claim);
                }
            }
        });

        // open claim summery
//            viewHolder.root.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v)
//                {
//                    Intent intent = new Intent(MyClaimActivity.this, ClaimSummaryActivity.class);
//                    intent.putExtra("DATA", claim);
//                    startActivity(intent);
//                }
//            });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvClaimDateTime, tvClaimLableAmount, tvClaimAmount, tvStatus, tvClaimId;
        ImageView ivMessageIcon, ivStatusIcon;
        //RelativeLayout root;
        CardView root;

        public ViewHolder(View v) {
            super(v);
            tvClaimDateTime = v.findViewById(R.id.tvClaimDateTime);
            tvClaimId = v.findViewById(R.id.tv_claim_id);
            tvClaimLableAmount = v.findViewById(R.id.tvClaimLableAmount);
            tvClaimAmount = v.findViewById(R.id.tvClaimAmount);
            tvStatus = v.findViewById(R.id.tvStatus);
            ivStatusIcon = v.findViewById(R.id.ivStatusIcon);
            ivMessageIcon = v.findViewById(R.id.ivMessageIcon);
            root = v.findViewById(R.id.root);
        }
    }
}