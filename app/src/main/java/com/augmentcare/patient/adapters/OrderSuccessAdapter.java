package com.augmentcare.patient.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.augmentcare.patient.R;

import java.util.List;

import com.augmentcare.patient.model.cartDetailModel.CartDetail;
import com.augmentcare.patient.model.OrderItem;


public class OrderSuccessAdapter extends RecyclerView.Adapter<OrderSuccessAdapter.ViewHolder> {
    private List<CartDetail> mOrderSummaryModelArrayList;
    private Context context;
    OrderItem orderItemModel;
    String orderItem;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameTextView, mLabRemoveTextView, mLabQuantityTextView, mLabAddTextView, mPriceTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.lab_name_textview);
            mLabRemoveTextView = itemView.findViewById(R.id.lab_remove_textview);
            mPriceTextView = itemView.findViewById(R.id.lab_price_textview);
            mLabQuantityTextView = itemView.findViewById(R.id.lab_quantity_textview);
            mLabAddTextView = itemView.findViewById(R.id.lab_add_textview);
            itemView.setTag(itemView);
        }
    }

    public OrderSuccessAdapter(List<CartDetail> mOrderSummaryModelArrayList, Context context) {
        this.mOrderSummaryModelArrayList = mOrderSummaryModelArrayList;
        this.context = context;
    }

    @Override
    public OrderSuccessAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_order_success, parent, false);
        return new OrderSuccessAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CartDetail currentItem = mOrderSummaryModelArrayList.get(position);
        holder.mNameTextView.setText(currentItem.getName());
        holder.mPriceTextView.setText(String.format("Rs.%d", currentItem.getPrice()));
    }

    @Override
    public int getItemCount() {
        return mOrderSummaryModelArrayList.size();
    }
}