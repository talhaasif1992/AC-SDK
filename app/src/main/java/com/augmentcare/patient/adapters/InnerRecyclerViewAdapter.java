package com.augmentcare.patient.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.augmentcare.patient.R;

import java.util.ArrayList;

import com.augmentcare.patient.activities.LabOrderViewActivity;
import com.augmentcare.patient.model.OrderAdapterModel;

public class InnerRecyclerViewAdapter extends RecyclerView.Adapter<InnerRecyclerViewAdapter.ViewHolder> {
    public ArrayList<OrderAdapterModel> nameList;
    int position1;
    int size;
    Context context;
    View v;

    public InnerRecyclerViewAdapter(Context context, ArrayList<OrderAdapterModel> nameList, int position, int size) {
        this.nameList = nameList;
        this.position1 = position;
        this.size = size;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mNameTextView, mDateTextView, mStatusTextView;
        RelativeLayout mChildItemRelativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.name_textview);
            mDateTextView = itemView.findViewById(R.id.tv_selected_date);
            mStatusTextView = itemView.findViewById(R.id.status_textview);
            mChildItemRelativeLayout = itemView.findViewById(R.id.recycler_item_relative_layout);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_child, parent, false);
        InnerRecyclerViewAdapter.ViewHolder vh = new InnerRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        try {
            for (int i = 0; i < size; i++) {
//                if (nameList.get(position1).getOrderItems().get(position1).getItemName() != null) {
                holder.mChildItemRelativeLayout.setBackground(context.getResources().getDrawable(R.drawable.normalchild));
                holder.mNameTextView.setText(nameList.get(position1).getOrderItems().get(position).getItemName());
                holder.mStatusTextView.setText(nameList.get(position1).getOrder().getStatus());
                String result = nameList.get(position1).getOrderItems().get(position).getCreatedAt().substring(0, nameList.get(position1).getOrderItems().get(position).getCreatedAt().indexOf("T"));
                holder.mDateTextView.setText(result);
                if (nameList.get(position1).getOrder().getStatus().equals("report_available")) {
                    holder.mStatusTextView.setText("Reports AvailableDoctor");
                } else if (nameList.get(position1).getOrder().getStatus().equals("pending")) {
                    holder.mStatusTextView.setText("Pending");
                    holder.mStatusTextView.setTextColor(Color.parseColor("#f8d691"));
                } else {
                    holder.mStatusTextView.setText(nameList.get(position1).getOrderItems().get(position).getStatus());
                }
            }
        } catch (Exception e) {
        }

        holder.mStatusTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (nameList.get(position1).getOrderItems().get(position).getUploadedLink() != null && !nameList.get(position1).getOrder().getStatus().equals("pending")) {
                        Intent webViewIntent = new Intent(context, LabOrderViewActivity.class);
                        webViewIntent.putExtra("url", String.valueOf(nameList.get(position1).getOrderItems().get(position).getUploadedLink()));
                        context.startActivity(webViewIntent);
                    }
                } catch (Exception ignored) {
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }
}