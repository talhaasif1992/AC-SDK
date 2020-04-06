package com.augmentcare.patient.subcription_model;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;

import com.augmentcare.patient.Interface.ClickInterface;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.APlan;
import com.augmentcare.patient.network.restApi.apimodels.PlanDetails;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.PrefsHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;


public class SubcriptionAdapter extends RecyclerView.Adapter<SubcriptionAdapter.ViewHolder> {
    private ArrayList<APlan> subcriptionModelArrayList;
    private Context context;
    public ArrayList<String> aPlanArrayList = new ArrayList<String>();
    int i = 0;
    private int checkedPosition = -1;
    PlanDetails planDetails;
    UserLogin userLogin;

    SubcriptionDetailAdapter subcriptionDetailAdapter;
    RecyclerView description_RV;
    private RecyclerView.LayoutManager layoutManager;
    private ClickInterface clickInterface;

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout card_view, expendableView, visaView;
        Button chooseBtn;
        TextView index, TV_title, TV_price, codeTV, typeTV, promoTV;

        APlan plan;

        public ViewHolder(View itemView) {
            super(itemView);
            chooseBtn = itemView.findViewById(R.id.chooseBtn);
            index = itemView.findViewById(R.id.tv_index);
            TV_title = itemView.findViewById(R.id.TV_title);
            TV_price = itemView.findViewById(R.id.TV_price);
            codeTV = itemView.findViewById(R.id.codeTV);
            typeTV = itemView.findViewById(R.id.typeTV);
            visaView = itemView.findViewById(R.id.visaView);
            promoTV = itemView.findViewById(R.id.promoTV);
            description_RV = itemView.findViewById(R.id.description_RV);
            card_view = itemView.findViewById(R.id.cl_payment_method_visa);
            expendableView = itemView.findViewById(R.id.expendableView);
            description_RV.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(context);
            description_RV.setLayoutManager(layoutManager);


        }
    }

    public SubcriptionAdapter(ArrayList<APlan> subcriptionModelArrayList, Context context, ClickInterface callback) {
        this.subcriptionModelArrayList = subcriptionModelArrayList;
        this.context = context;
        this.clickInterface = callback;
        userLogin = PrefsHelper.getLoggedInUser();
        planDetails = userLogin.getPlanDetails();


    }

    @NotNull
    @Override
    public SubcriptionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_list_layout, parent, false);
        return new SubcriptionAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            String plan_type = "";
            final APlan currentItem = subcriptionModelArrayList.get(position);
            i++;
            holder.plan = currentItem;
            holder.index.setText("" + i);
            holder.TV_title.setText(currentItem.getName());
            holder.TV_price.setText("" + (int) currentItem.getPrice());
            holder.codeTV.setText(currentItem.getCurrency_code() + "");

            if (currentItem.getPlanType().equalsIgnoreCase("monthly")) {
                plan_type = "mo";
            } else if (currentItem.getPlanType().equalsIgnoreCase("quarterly")) {
                plan_type = "qu";

            } else if (currentItem.getPlanType().equalsIgnoreCase("bi-annually")) {
                plan_type = "bi";

            } else if (currentItem.getPlanType().equalsIgnoreCase("yearly")) {
                plan_type = "yr";

            }
            holder.typeTV.setText(" //" + plan_type);
            applyGradient(holder.TV_price);

            aPlanArrayList.clear();
            aPlanArrayList.addAll(currentItem.getDescriptionList());
            subcriptionDetailAdapter = new SubcriptionDetailAdapter(aPlanArrayList, context);
            description_RV.setAdapter(subcriptionDetailAdapter);

            if (checkedPosition != position) {
                closeDetail(holder);
            } else {
                openDetail(holder);
            }


//            if ((userLogin.isIsOnPlan() && userLogin.isFromOrganization())) {
//
//                int plan_id = 0;
//                if (planDetails != null) {
//                    plan_id = planDetails.getPlanId();
//                } else {
//                    plan_id = Integer.parseInt(PrefsHelper.get(context).getString(Constants.KEY_PLAN_ID, ""));
//                }
//                if ((plan_id == currentItem.getId())) {
//                    openDetail(holder);
//                } else {
//                    closeDetail(holder);
//                }
//
//            } else
                if(userLogin.isFromOrganization()) {
               int play_id = Integer.parseInt(PrefsHelper.get(context).getString(Constants.KEY_PLAN_ID,""));
                if ((play_id == currentItem.getId())) {
                    openDetail(holder);
                } else {
                    closeDetail(holder);
                }
            } else if (userLogin.isIsOnPlan()) {
                    if ((planDetails != null && planDetails.getPlanId() == currentItem.getId())) {
                        openDetail(holder);
                    } else {
                        closeDetail(holder);
                    }
                }
                else {

                holder.visaView.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onClick(View v) {

                        checkedPosition = position;
                        i = 0;
                        notifyDataSetChanged();
                        if (holder.expendableView.getVisibility() == View.GONE) {
                            openDetail(holder);

                        } else {
                            closeDetail(holder);
                        }

                    }
                });

            }

            holder.chooseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!userLogin.isFromOrganization()) {
                        if (holder.chooseBtn.getText().toString().equalsIgnoreCase("Cancel Subscription")) {
                            cancelSubscription();
                        } else {
                            clickInterface.clickItem("" + i, currentItem.getName(), "" + position);
                        }
                    }
//                    else
//                    {
//                        Toasty.error(context,"Its Orginizational account, Plase contact to the administrator",Toasty.LENGTH_LONG).show();
//                    }
                }
            });
            holder.promoTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!PrefsHelper.isOnPlan()) {
                        clickInterface.clickItem("" + i, "Promo", "" + position);
                    }
                }
            });


        } catch (Exception ignored) {
        }
    }

    private void cancelSubscription() {
        if (planDetails != null)
            clickInterface.clickItem("" + planDetails.getId(), "Cancel Subscription", "");
    }

    private void openDetail(ViewHolder holder) {
        TransitionManager.beginDelayedTransition(holder.card_view, new Fade());
        holder.expendableView.setVisibility(View.VISIBLE);
        holder.visaView.setBackgroundResource(R.drawable.btn_green_gradient_background);
        holder.index.setTextColor(ContextCompat.getColor(context, R.color.white));
        holder.TV_title.setTextColor(ContextCompat.getColor(context, R.color.white));
        holder.TV_price.setTextColor(ContextCompat.getColor(context, R.color.white));
        holder.codeTV.setTextColor(ContextCompat.getColor(context, R.color.white));
        holder.typeTV.setTextColor(ContextCompat.getColor(context, R.color.white));
        applyGradientWhite(holder.TV_price);

        if (userLogin.isFromOrganization()) {
            holder.chooseBtn.setText("Current Plan");
            holder.promoTV.setVisibility(View.GONE);
            holder.chooseBtn.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        }else if(PrefsHelper.isOnPlan()){
            // not from organization but on plan
            if(userLogin.getPlanId500()== holder.plan.getId()){
                holder.chooseBtn.setText("Cancel Subscription");
                holder.chooseBtn.setVisibility(View.VISIBLE);
                holder.promoTV.setVisibility(View.VISIBLE);
              }else{
                holder.chooseBtn.setText("Subscribe");
                holder.chooseBtn.setVisibility(View.VISIBLE);
                holder.promoTV.setVisibility(View.VISIBLE);
            }
        }else {
            holder.chooseBtn.setText("Subscribe");
            holder.chooseBtn.setVisibility(View.VISIBLE);
            holder.promoTV.setVisibility(View.VISIBLE);
        }

    }

    private void closeDetail(ViewHolder holder) {

        holder.expendableView.setVisibility(View.GONE);
        TransitionManager.beginDelayedTransition(holder.card_view, new Fade());
        holder.visaView.setBackground(null);
        holder.index.setTextColor(ContextCompat.getColor(context, R.color.colorSecondary));
        holder.TV_title.setTextColor(ContextCompat.getColor(context, R.color.colorSecondary));
        holder.TV_price.setTextColor(ContextCompat.getColor(context, R.color.colorSecondary));
        holder.codeTV.setTextColor(ContextCompat.getColor(context, R.color.colorSecondary));
        holder.typeTV.setTextColor(ContextCompat.getColor(context, R.color.colorSecondary));
        applyGradient(holder.TV_price);

    }

    private void applyGradientWhite(TextView tv_price) {
        TextPaint paint = tv_price.getPaint();
        float width = paint.measureText(tv_price.getText().toString());

        Shader textShader = new LinearGradient(0, 0, width, tv_price.getTextSize(),
                new int[]{
                        Color.parseColor("#ffffff"),
                        Color.parseColor("#ffffff"),
                }, null, Shader.TileMode.CLAMP);
        tv_price.getPaint().setShader(textShader);
    }

    private void applyGradient(TextView tv_price) {

        TextPaint paint = tv_price.getPaint();
        float width = paint.measureText(tv_price.getText().toString());

        Shader textShader = new LinearGradient(0, 0, width, tv_price.getTextSize(),
                new int[]{
                        Color.parseColor("#044c63"),
                        Color.parseColor("#aee21f"),
                }, null, Shader.TileMode.CLAMP);
        tv_price.getPaint().setShader(textShader);
    }


    @Override
    public int getItemCount() {
        return subcriptionModelArrayList.size();
    }


}