package com.augmentcare.patient.adapters;

import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.model.AOrderItem;
import com.augmentcare.patient.model.PrescriptionMedicine;

import java.util.List;

/**
 * {@link LabsOrderItmeResultsRecyclerListAdapter} that can display a {@link PrescriptionMedicine} and makes a call to the
 * specified {@link OnRecyclerItemClickListener}.
 */
public class LabsOrderItmeResultsRecyclerListAdapter extends RecyclerView.Adapter<LabsOrderItmeResultsRecyclerListAdapter.ViewHolder> {

    private final List<AOrderItem> mValues;
    private final OnRecyclerItemClickListener<AOrderItem> mListener;
    private OnRecyclerItemClickListener<AOrderItem> mDownloadListener;
    private  OnRecyclerItemClickListener<AOrderItem> mReorderListener;
    private String status ;

    private int resId;

    public LabsOrderItmeResultsRecyclerListAdapter(List<AOrderItem> items, OnRecyclerItemClickListener<AOrderItem> listener) {
        mValues = items;
        mListener = listener;
        resId = R.layout.item_test_result;
    }


    @Override
    public LabsOrderItmeResultsRecyclerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_test_result, parent, false);
        return new LabsOrderItmeResultsRecyclerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.txtName.setText(String.valueOf(holder.mItem.getItemName()));

        if (holder.mItem.getUploaded_link()!=null && !holder.mItem.getUploaded_link().trim().isEmpty()) {
            holder.btnDownload.setText("DOWNLOAD");

            holder.btnDownload.setEnabled(true);
            holder.btnDownload.setTextColor(ResourcesCompat.getColor(holder.txtName.getContext().getResources(),R.color.colorGreenDark,holder.txtName.getContext().getTheme()));
        }else{
            holder.btnDownload.setEnabled(false);
            holder.btnDownload.setTextColor(ResourcesCompat.getColor(holder.txtName.getContext().getResources(),R.color.colorGrayDark,holder.txtName.getContext().getTheme()));
            //holder.btnReorder.setVisibility(View.GONE);
        }


            holder.btnDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mDownloadListener!=null)
                        mDownloadListener.onItemClick(holder.mItem,position);
                }
            });
            holder.btnReorder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mReorderListener!=null){
                        mReorderListener.onItemClick(holder.mItem,position);
                    }
                }
            });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClick(holder.mItem,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OnRecyclerItemClickListener<AOrderItem> getmDownloadListener() {
        return mDownloadListener;
    }

    public void setmDownloadListener(OnRecyclerItemClickListener<AOrderItem> mDownloadListener) {
        this.mDownloadListener = mDownloadListener;
    }

    public OnRecyclerItemClickListener<AOrderItem> getmReorderListener() {
        return mReorderListener;
    }

    public void setmReorderListener(OnRecyclerItemClickListener<AOrderItem> mReorderListener) {
        this.mReorderListener = mReorderListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtName;

        public final Button btnDownload;
        public final Button btnReorder;

        public AOrderItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView   = view;
            txtName  = view.findViewById(R.id.txtName);
            btnDownload = view.findViewById(R.id.btnDownload);
            btnReorder = view.findViewById(R.id.btnReorder);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString()+ "'";
        }
    }
}
