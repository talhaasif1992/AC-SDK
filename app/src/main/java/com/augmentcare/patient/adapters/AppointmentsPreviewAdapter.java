package com.augmentcare.patient.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.network.restApi.apimodels.Consultation;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class AppointmentsPreviewAdapter extends RecyclerView.Adapter<AppointmentsPreviewAdapter.ViewHolder> {

    private Activity activityContext;
    private List<Consultation> listOfAppointments = new ArrayList<>();
    private OnRecyclerItemClickListener<Consultation> clickListener;
    BaseActivity baseActivity;


    public AppointmentsPreviewAdapter(Activity myActivity) {
        activityContext = myActivity;

        baseActivity = (BaseActivity) ActivityUtils.getTopActivity();
    }

    public void setListOfAppointments(List<Consultation> listOfAppointments) {
        this.listOfAppointments = listOfAppointments;
        notifyDataSetChanged();
    }

    public void setClickListener(OnRecyclerItemClickListener<Consultation> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AppointmentsPreviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_appointment_preview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Consultation consultation = listOfAppointments.get(position);
        holder.bindMe(consultation, position);
    }

    @Override
    public int getItemCount() {
        return listOfAppointments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;

        @BindView(R.id.cv_doctor)
        CardView cv_doctor;

        @BindView(R.id.civDoctorImage)
        CircleImageView civDoctorImage;

        @BindView(R.id.approvedForTV)
        TextView approvedForTV;

        @BindView(R.id.doctorNameTV)
        TextView doctorNameTV;

        @BindView(R.id.appointmentDateTimeTV)
        TextView appointmentTimeTV;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            ButterKnife.bind(this, mView);
        }

        public void bindMe(Consultation consultation, int pos) {

            Glide.with(mView)
                    .load(consultation.getDoctorInfo().getPhoto())
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .into(civDoctorImage);

            String currentUser = baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName();

            if (consultation.getDependent() != null) {
                SpanUtils.with(approvedForTV)
                        .append("Appointment Approved for ")
                        .append(StringUtils.null2Length0(consultation.getDependent().getName()))
                        .setForegroundColor(ContextCompat.getColor(activityContext, R.color.colorBlueButtonSelected))
                        .create();
            } else {
                SpanUtils.with(approvedForTV)
                        .append("Appointment Approved for ")
                        .append(StringUtils.null2Length0(currentUser))
                        .setForegroundColor(ContextCompat.getColor(activityContext, R.color.colorBlueButtonSelected))
                        .create();
            }

            doctorNameTV.setText(
                    StringUtils.null2Length0(consultation.getDoctorInfo().getDrFullName())
            );

            cv_doctor.setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onItemClick(consultation, pos);
                }
            });

//            Date bookingDate = TextUtils.parseTime(consultation.getSlot().getBookingTime());
//
            Date dateTimeOfAppoint = consultation.getSlot().getBookingDateTimeProcessed();

            appointmentTimeTV.setText(
                    TimeUtils.date2String(dateTimeOfAppoint,"hh:mm a , dd MMMM yyyy")
            );
        }

        @OnClick(R.id.nextAppointTV)
        void scrollToNextAppointment() {

        }
    }
}
