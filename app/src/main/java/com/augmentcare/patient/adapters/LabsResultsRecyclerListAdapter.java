package com.augmentcare.patient.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.model.LabResult;

import java.util.List;

/**
 * {@link LabsResultsRecyclerListAdapter} that can display a {@link LabResult} and makes a call to the
 * specified {@link OnRecyclerItemClickListener}.
 */
public class LabsResultsRecyclerListAdapter extends RecyclerView.Adapter<LabsResultsRecyclerListAdapter.ViewHolder> {

    private final List<LabResult> mValues;
    private final OnRecyclerItemClickListener<LabResult> mListener;
    private OnRecyclerItemClickListener<LabResult> mDownloadButtonListener;
    private OnRecyclerItemClickListener<LabResult> mReorderButtonListener;

    private int resId;

    public LabsResultsRecyclerListAdapter(List<LabResult> items, OnRecyclerItemClickListener<LabResult> listener) {
        mValues = items;
        mListener = listener;
        resId = R.layout.item_lab_result;
    }

    public LabsResultsRecyclerListAdapter(List<LabResult> items, OnRecyclerItemClickListener<LabResult> listener, int resId) {
        mValues = items;
        mListener = listener;
        this.resId = resId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lab_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.txtOrderNumber.setText("Lab Order " + holder.mItem.getOrder().getId());
        holder.txtOrderStatus.setText(holder.mItem.getOrder().getStatus().toUpperCase());
        holder.txtDate.setText("27 Jan 2018");
        if (holder.mItem.getOrderItems().size() >= 2) {
            holder.txtLabTest1.setText(holder.mItem.getOrderItems().get(0).getItemName());
            holder.txtLabTest2.setText(holder.mItem.getOrderItems().get(1).getItemName());
            holder.txtLabTest1.setVisibility(View.VISIBLE);
            holder.txtLabTest2.setVisibility(View.VISIBLE);
            if (holder.mItem.getOrderItems().size() - 2 > 0) {

                holder.txtLabTest3.setVisibility(View.VISIBLE);
                holder.txtLabTest3.setText((holder.mItem.getOrderItems().size() - 2) + " More");
            } else {
                holder.txtLabTest3.setVisibility(View.GONE);
            }
            //holder.txtLabtests.setText(holder.mItem.getOrderItems().get(0).getItemName() +"\n"+ holder.mItem.getOrderItems().get(1).getItemName());

        } else {
            if (holder.mItem.getOrderItems().size() == 1) {
                holder.txtLabTest1.setText(holder.mItem.getOrderItems().get(0).getItemName());
                holder.txtLabTest2.setVisibility(View.GONE);
                holder.txtLabTest3.setVisibility(View.GONE);
            } else {
                holder.txtLabTest1.setVisibility(View.GONE);
                holder.txtLabTest2.setVisibility(View.GONE);
                holder.txtLabTest3.setVisibility(View.GONE);
            }
        }
        if (holder.mItem.getOrder().getStatus() != null) {
            if (holder.mItem.getOrder().getStatus().toLowerCase().contains("report_available")) {
                holder.txtOrderStatus.setText("REPORTS AVAILABLE");
            }
            if (holder.mItem.getOrder().getStatus().toLowerCase().contains("blood_sample_collected")) {
                holder.txtOrderStatus.setText("SAMPLE COLLECTED");
            }
            if (holder.mItem.getOrder().getStatus().toLowerCase().contains("pending")) {
                holder.txtOrderStatus.setText("PENDING");
            }

        }


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClick(holder.mItem, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public OnRecyclerItemClickListener<LabResult> getmDownloadButtonListener() {
        return mDownloadButtonListener;
    }

    public void setmDownloadButtonListener(OnRecyclerItemClickListener<LabResult> mDownloadButtonListener) {
        this.mDownloadButtonListener = mDownloadButtonListener;
    }

    public OnRecyclerItemClickListener<LabResult> getmReorderButtonListener() {
        return mReorderButtonListener;
    }

    public void setmReorderButtonListener(OnRecyclerItemClickListener<LabResult> mReorderButtonListener) {
        this.mReorderButtonListener = mReorderButtonListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtOrderNumber;
        public final TextView txtOrderStatus;
        public final TextView txtDate;
        public final View lytReportsButtons;
        public final View btnReorder;
        public final View btnDownload;
        public final TextView txtLabTest1;
        public final TextView txtLabTest2;
        public final TextView txtLabTest3;
        public LabResult mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtOrderNumber = view.findViewById(R.id.txtOrderNumber);

            txtOrderStatus = view.findViewById(R.id.txtOrderStatus);
            txtDate = view.findViewById(R.id.txtDate);
            lytReportsButtons = view.findViewById(R.id.lytReportsButtons);
            btnReorder = view.findViewById(R.id.btnReorder);
            btnDownload = view.findViewById(R.id.btnDownload);
            txtLabTest1 = view.findViewById(R.id.txtLabTest1);
            txtLabTest2 = view.findViewById(R.id.txtLabTest2);
            txtLabTest3 = view.findViewById(R.id.txtLabTest3);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }
}
