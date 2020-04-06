package com.augmentcare.patient.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.model.ConsultationItem;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ConsultationsRecyclerListAdapter extends RecyclerView.Adapter<ConsultationsRecyclerListAdapter.ViewHolder>
{
    BaseActivity baseActivity;
    String slotsDay;

    private final List<ConsultationItem> mValues;
    private final OnRecyclerItemClickListener<ConsultationItem> mListener;
    private Context context;

    public ConsultationsRecyclerListAdapter(List<ConsultationItem> items, OnRecyclerItemClickListener<ConsultationItem> listener, Context context)
    {
        mValues = items;
        mListener = listener;
        this.context = context;
        baseActivity = baseActivity = (BaseActivity) ActivityUtils.getTopActivity();
    }

    @Override
    public ConsultationsRecyclerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        int layoutID = 0;
        if (mValues.size() == 1) {
            layoutID = R.layout.item_consultation_new_for_one_item;
        } else {
            layoutID = R.layout.item_consultation_new_for_one_item;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutID, parent, false);
        return new ConsultationsRecyclerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {

        Date dateFormated = null;
        try
        {
            holder.mItem = mValues.get(position);
            holder.tvName.setText(mValues.get(position).getDocter_name());

            if (mValues.get(position).getSlot().getBookingTime() != null && !mValues.get(position).getSlot().getBookingTime().isEmpty())
            {
                dateFormated = new SimpleDateFormat("dd-MM-yyyy").parse(mValues.get(position).getSlot().getBookingTime());
                Calendar c = Calendar.getInstance();
                c.setTime(dateFormated);
                c.add(Calendar.DATE, 1);
                slotsDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(c.getTime());
            }

            if (mValues.get(position).getDependentSlots() != null)
            {
                holder.tvDependentFor.setText("Appointment for " + mValues.get(position).getDependentSlots().getName());
                holder.tvDependentFor.setTextColor(Color.parseColor("#3DC592"));
            }
            else
            {
                holder.tvDependentFor.setText("Appointment for " + baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName());
                holder.tvDependentFor.setTextColor(Color.parseColor("#3DC592"));
            }

            String dayOfWeek = "";
            if (mValues.get(position).getSlot() != null && mValues.get(position).getSlot().getStartTime() != null)
                dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(TextUtils.parseDate(mValues.get(position).getSlot().getDay()));

            holder.tvTimeAndDate.setText(dayOfWeek + ", " + TextUtils.formatDate(TextUtils.parseDate(mValues.get(position).getSlot().getDay())) + " " + TextUtils.formatTime(TextUtils.parseTime(mValues.get(position).getSlot().getStartTime())));

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        mListener.onItemClick(holder.mItem, position);
                    }
                }
            });

            if (mValues.get(position).getDocter_pic() != null && !mValues.get(position).getDocter_pic().isEmpty()) {
                Glide.with(context).load(mValues.get(position).getDocter_pic()).apply(RequestOptions.circleCropTransform()).into(holder.ivThumb);
            }
            else
            {
                holder.ivThumb.setBackgroundResource(R.drawable.ic_user);
            }

            if (mValues.get(position).getSlot() != null)
            {
                if (mValues.get(position).getSlot() != null && mValues.get(position).getSlot().getSlot_status() != null &&
                        mValues.get(position).getSlot().getSlot_status().contains("prescription_submitted"))
                {
                    holder.tvStatus.setVisibility(View.VISIBLE);
                    holder.tvStatus.setText("Completed");
                } else if (mValues.get(position).getSlot() != null && mValues.get(position).getSlot().getSlot_status() != null && mValues.get(position).getSlot().getSlot_status().contains("cancelled_by_patient")) {
                    holder.tvStatus.setVisibility(View.VISIBLE);
                    holder.arrowImage.setVisibility(View.GONE);
                    holder.tvStatus.setText("Cancelled");
                } else if (mValues.get(position).getSlot() != null && mValues.get(position).getSlot().getSlot_status() != null && mValues.get(position).getSlot().getSlot_status().contains("cancelled_by_doctor")) {
                    holder.tvStatus.setVisibility(View.VISIBLE);
                    holder.arrowImage.setVisibility(View.GONE);
                    holder.tvStatus.setText("Rejected");
                } else {
                    holder.tvStatus.setText("");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (mValues != null && mValues.size() > 0) {
            return mValues.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final View mView;
        public final TextView tvName;
        public final TextView tvStatus;
        public final TextView tvTimeAndDate;
        public final TextView tvDependentFor;
        public final ImageView arrowImage;
        //        public final TextView tvSpecialization;
        public final ImageView ivThumb;
        public ConsultationItem mItem;

        public ViewHolder(View view)
        {
            super(view);
            mView = view;
            tvName = view.findViewById(R.id.tvName);
            tvStatus = view.findViewById(R.id.tv_Status);
            tvTimeAndDate = view.findViewById(R.id.tvDateAndTime);
            tvDependentFor = view.findViewById(R.id.tvDependentFor);
            arrowImage = view.findViewById(R.id.imgArrow);
//            tvSpecialization = view.findViewById(R.id.tvSpecialization);
            ivThumb = view.findViewById(R.id.ivThumb);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.getDocter_name() + "'";
        }
    }
}
