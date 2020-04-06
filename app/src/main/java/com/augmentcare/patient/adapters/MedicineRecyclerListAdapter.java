package com.augmentcare.patient.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.model.APrescription;
import com.augmentcare.patient.model.PrescriptionMedicine;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * {@link MedicineRecyclerListAdapter} that can display a {@link PrescriptionMedicine} and makes a call to the
 * specified {@link OnRecyclerItemClickListener}.
 */
public class MedicineRecyclerListAdapter extends RecyclerView.Adapter<MedicineRecyclerListAdapter.ViewHolder> {

    private final List<APrescription> mValues;
    private final OnRecyclerItemClickListener<APrescription> mListener;

    public MedicineRecyclerListAdapter(List<APrescription> items, OnRecyclerItemClickListener<APrescription> listener) {
        mValues = items;
        mListener = listener;
    }

    @NotNull
    @Override
    public MedicineRecyclerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new MedicineRecyclerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.tvName.setText(mValues.get(position).getMedicine().getName());
        holder.txtQty1.setText(mValues.get(position).getMedicine().getUnit_price());
        holder.txtQty2.setText(mValues.get(position).getMedicine().getUnit());

        if (holder.mItem.getDosage() != null) {
            holder.ivIcon.setVisibility(View.VISIBLE);
            if (holder.mItem.getType().contains("Syp")) {
                holder.txtQty1.setText(mValues.get(position).getQuantity() + " Bottles");
                holder.txtQty2.setText(mValues.get(position).getPacks() + " Packs");

            } else if (holder.mItem.getType().contains("Tab")) {

                holder.txtQty1.setText(mValues.get(position).getQuantity() + " Tablets");
                holder.txtQty2.setText(mValues.get(position).getPacks() + " Packs");
                //holder.txtQty1.setText(mValues.get(position).getMedicine().getUnit() +" Tablets");
            } else if (holder.mItem.getType().contains("Cap")) {

                holder.txtQty1.setText(mValues.get(position).getQuantity() + " Capsules");
                holder.txtQty2.setText(mValues.get(position).getPacks() + " Packs");
                //holder.txtQty1.setText(mValues.get(position).getMedicine().getUnit()+" Capsules");
            }
            if (holder.mItem.getType().contains("Inj")) {
                holder.txtQty1.setText(mValues.get(position).getQuantity() + " Items");
                holder.txtQty2.setText(mValues.get(position).getPacks() + " Packs");
            } else {
                holder.ivIcon.setVisibility(View.GONE);
                holder.txtQty1.setText(mValues.get(position).getQuantity() + " Inj");
                holder.txtQty2.setText(mValues.get(position).getPacks() + " Packs");
                // holder.txtQty1.setText(mValues.get(position).getMedicine().getUnit_price()+" Items");
            }

        } else {
            holder.ivIcon.setVisibility(View.GONE);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvName;
        public final TextView txtQty1;
        public final TextView txtQty2;
        public final ImageView ivIcon;
        public APrescription mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvName = view.findViewById(R.id.txtName);
            txtQty2 = view.findViewById(R.id.txtQty2);
            txtQty1 = view.findViewById(R.id.txtQty1);
            ivIcon = view.findViewById(R.id.ivIcon);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.getMedicine().getName() + "'";
        }
    }
}
