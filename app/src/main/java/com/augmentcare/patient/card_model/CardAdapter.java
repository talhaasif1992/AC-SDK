package com.augmentcare.patient.card_model;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.PaymentMethodFragment;
import com.augmentcare.patient.fragments.SubscriptionPaymentFragment;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;

import java.util.List;

import com.augmentcare.patient.Interface.ClickItemInterface;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.PrefsHelper;

import org.jetbrains.annotations.NotNull;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private List<CreditCard> CardModelArrayList;
    int type;
    int selectedPosition = -1;
    private Context context;
    private ClickItemInterface mAdapterCallback;
    int ViewType;
    private int checkedPosition = -1;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView cardLogo,cardInnerLogo,iv_delete_icon_visa;
        LinearLayout card_view,expendableView,visaView;
        TextView tv_card_number_visa,tv_expiry_date_visa;

        public ViewHolder(View itemView) {
            super(itemView);


            cardLogo = itemView.findViewById(R.id.iv_card_logo);
            card_view = itemView.findViewById(R.id.cl_payment_method_visa);
            expendableView = itemView.findViewById(R.id.expendableView);
            iv_delete_icon_visa = itemView.findViewById(R.id.iv_delete_icon_visa);
            cardInnerLogo = itemView.findViewById(R.id.cardInnerLogo);
            tv_card_number_visa = itemView.findViewById(R.id.tv_card_number_visa);
            tv_expiry_date_visa = itemView.findViewById(R.id.tv_expiry_date_visa);
            visaView = itemView.findViewById(R.id.visaView);
        }

    }

    public CardAdapter(List<CreditCard> addressModelArrayList, Context context, PaymentMethodFragment fragment, int viewType) {
        this.CardModelArrayList = addressModelArrayList;
        this.context = context;
        this.mAdapterCallback = fragment;
        this.ViewType=viewType;
    }
    public CardAdapter(List<CreditCard> addressModelArrayList, Context context, SubscriptionPaymentFragment fragment, int viewType) {
        this.CardModelArrayList = addressModelArrayList;
        this.context = context;
        this.mAdapterCallback = fragment;
        this.ViewType=viewType;
    }


    @NotNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_layout, parent, false);
        return new CardAdapter.ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {

            final CreditCard currentItem = CardModelArrayList.get(position);


            String number = "000000000000"+currentItem.getLast4();
            String mask = number.replaceAll("\\w(?=\\w{4})", "●");


            if(currentItem.getBrand().equals("Jazz Cash") || type==1)
            {
                holder.cardLogo.setImageResource(R.drawable.ic_easy_paisa);
                holder.cardInnerLogo.setImageResource(R.drawable.ic_easy_paisa);
            }
            else  if(currentItem.getBrand().equals("Visa")|| type==2)
            {
                holder.cardLogo.setImageResource(R.drawable.ic_visa_image);
                holder.cardInnerLogo.setImageResource(R.drawable.ic_visa_image);
                holder.tv_card_number_visa.setText(mask);
                holder.tv_expiry_date_visa.setText("EXP "+currentItem.getExpMonth()+"/"+currentItem.getExpYear());

            }
            else  if(currentItem.getBrand().equals("Master Card")|| type==3)
            {
                holder.cardLogo.setImageResource(R.drawable.ic_mastercard1);
                holder.cardInnerLogo.setImageResource(R.drawable.ic_mastercard1);
                holder.tv_card_number_visa.setText(mask);

            }

            if(ViewType==1)
            {
                holder.iv_delete_icon_visa.setVisibility(View.GONE);
            }
            holder.iv_delete_icon_visa.setOnClickListener(v -> {
                mAdapterCallback.deleteItem(currentItem.getId());
                notifyDataSetChanged();
            });

            if(checkedPosition!=position)
            {
                holder.visaView.setBackground(null);
            }
            else
            {
                holder.visaView.setBackgroundResource(R.drawable.plans_bg_border);

            }

            holder.card_view.setOnClickListener(v -> {
                checkedPosition = position;
                PaymentMethodFragment.position = position;
                mAdapterCallback.addClickItem(currentItem.getId(), currentItem.getLast4(), "credit_card");
                notifyDataSetChanged();
                PrefsHelper.get(context).remove(Constants.CASH_ON_DELIVERY);
            });
        }catch (Exception ignored){}
    }

    @Override
    public int getItemCount() {
        return CardModelArrayList.size();
    }

}