package com.augmentcare.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.ClickItemInterface;
import com.augmentcare.patient.R;
import com.augmentcare.patient.fragments.CreditCardFragment;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.PrefsHelper;

import java.util.List;


public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.ViewHolder> {
    private List<CreditCard> creditCardModelArrayList;
    private Context context;
    int selectedPosition = -1;
    private ClickItemInterface mAdapterCallback;
    int positionSelect = -1;
    String type;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mExpireDateTextView, mLastFourDigitTextView, mNameTextView;
        public ImageView selectImageview, deleteCardImageView;
        public LinearLayout creditCardLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.name_textview);
            mLastFourDigitTextView = itemView.findViewById(R.id.last_four_digit_textview);
            mExpireDateTextView = itemView.findViewById(R.id.expire_date_textview);
            creditCardLinearLayout = itemView.findViewById(R.id.creditCardLinearLayout);
            selectImageview = itemView.findViewById(R.id.select_tick_image_view);
            deleteCardImageView = itemView.findViewById(R.id.delete_card_imageview);
        }
    }

    public CreditCardAdapter(List<CreditCard> addressModelArrayList, Context context, CreditCardFragment fragment, int position, String type) {
        this.creditCardModelArrayList = addressModelArrayList;
        this.context = context;
        this.mAdapterCallback = fragment;
        this.positionSelect = position;
        this.type = type;
    }

    @Override
    public CreditCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_credit_card, parent, false);
        return new CreditCardAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CreditCardAdapter.ViewHolder holder, final int position) {
        try {
            final CreditCard currentItem = creditCardModelArrayList.get(position);
            if (currentItem.getName() != null) {
                holder.mNameTextView.setText(currentItem.getName() + "");
            } else {
                holder.mNameTextView.setVisibility(View.GONE);
            }
            holder.mLastFourDigitTextView.setText(currentItem.getLast4() + "");
            holder.mExpireDateTextView.setText(currentItem.getExpMonth() + "/" + currentItem.getExpYear());
            if (selectedPosition == position) {
                if (type != null && !type.equalsIgnoreCase("home")) {
                    holder.selectImageview.setVisibility(View.VISIBLE);
                } else {
                    holder.selectImageview.setVisibility(View.GONE);
                }
            } else if (positionSelect != -1 && positionSelect == position && selectedPosition == -1) {
                if (type != null && !type.equalsIgnoreCase("home")) {
                    holder.selectImageview.setVisibility(View.VISIBLE);
                } else {
                    holder.selectImageview.setVisibility(View.GONE);
                }
            } else if (position == 0 && selectedPosition == -1 && positionSelect == -1) {
                if (type != null && !type.equalsIgnoreCase("home")) {
                    holder.selectImageview.setVisibility(View.VISIBLE);
                } else {
                    holder.selectImageview.setVisibility(View.GONE);
                }
            } else {
                holder.selectImageview.setVisibility(View.GONE);
            }
            holder.creditCardLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedPosition = position;
                    CreditCardFragment.position = position;
                    mAdapterCallback.addClickItem(currentItem.getId(), currentItem.getLast4(), "credit_card");
                    notifyDataSetChanged();
                    PrefsHelper.get(context).remove(Constants.CASH_ON_DELIVERY);
                }
            });
            holder.deleteCardImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapterCallback.deleteItem(currentItem.getId());
                    notifyDataSetChanged();
                }
            });
        } catch (Exception ignored) {
        }
    }

    @Override
    public int getItemCount() {
        return creditCardModelArrayList.size();
    }
}