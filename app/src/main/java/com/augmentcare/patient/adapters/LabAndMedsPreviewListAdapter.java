package com.augmentcare.patient.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.OrderResults;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LabAndMedsPreviewListAdapter extends RecyclerView.Adapter<LabAndMedsPreviewListAdapter.ViewHolder> {

    private List<OrderResults> orderResults = new ArrayList<>();

    public void setOrderResults(List<OrderResults> orderResults) {
        this.orderResults.clear();
        this.orderResults.addAll(orderResults);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_lab, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindMe(orderResults.get(position));
    }

    @Override
    public int getItemCount() {
        return orderResults.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View rootView;

        @BindView(R.id.txtName)
        TextView txtMedicine;
        @BindView(R.id.txtQty1)
        TextView txtPrice;
        @BindView(R.id.instruction_title)
        TextView mInstructionTitleTextView;
        @BindView(R.id.instructions_textview)
        TextView mInstructionTextView;
        @BindView(R.id.ivIcon)
        View ivIcon;

        private OrderResults results;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this, rootView);
        }

        public void bindMe(OrderResults results) {
            this.results = results;

            txtMedicine.setText(
                    StringUtils.null2Length0(
                            results.getMedicine().getName()
                    )
            );

            txtPrice.setText(
                    String.format(
                            Utils.getApp().getString(R.string.prescription_details),
                            results.getDosage().getVal() + "",
                            StringUtils.null2Length0(results.getDosage().getUnit()),
                            StringUtils.null2Length0(results.getFrequency()),
                            StringUtils.null2Length0(results.getMeal()),
                            results.getDuration().getVal(),
                            StringUtils.null2Length0(results.getDuration().getUnit())
                    )
            );

            if (results.getNotes() != null && !results.getNotes().isEmpty()) {
                mInstructionTitleTextView.setVisibility(View.VISIBLE);
                mInstructionTextView.setText(results.getNotes());
            } else {
                mInstructionTitleTextView.setVisibility(View.GONE);
            }

            ivIcon.setVisibility(View.GONE);
        }
    }
}
