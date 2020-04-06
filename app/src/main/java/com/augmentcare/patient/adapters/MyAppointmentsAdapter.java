package com.augmentcare.patient.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.bottomsheets.ConsultationPreviewDialogFragmentArgs;
import com.augmentcare.patient.enums.APPOINTMENT_STATUS;
import com.augmentcare.patient.fragments.MyAppointmentsFragmentDirections;
import com.augmentcare.patient.network.restApi.apimodels.Consultation;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.Specialization;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class MyAppointmentsAdapter extends RecyclerView.Adapter<MyAppointmentsAdapter.ViewHolder> {

    private BaseActivity baseActivity;

    private List<Consultation> consultations;

    private NavController mainNav;

    private View rootView;

    public MyAppointmentsAdapter(BaseActivity baseActivity, List<Consultation> consultations) {
        this.baseActivity = baseActivity;
        this.consultations = consultations;

        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyAppointmentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment_history_preview, parent, false);
        return new MyAppointmentsAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Consultation selected = consultations.get(position);
        holder.bindMe(selected, v -> {

            if (selected.getStatus() != APPOINTMENT_STATUS.COMPLETED) {

                mainNav.navigate(
                        R.id.action_myAppointmentsFragment_to_consultationPreviewDialogFragment,
                        new ConsultationPreviewDialogFragmentArgs.Builder(selected.getSlot().getId().intValue()+"").build().toBundle()
                );
                return;
            }

            // open appointment detail
            mainNav.navigate(
                    MyAppointmentsFragmentDirections.actionMyAppointmentsFragmentToAppointmentDetailsFragment(selected.getSlot().getId().intValue())
            );
        });
    }

    @Override
    public int getItemCount() {
        return consultations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View rootView;

        @BindView(R.id.root_parent)
        View root_parent;

        @BindView(R.id.civDoctorImage)
        CircleImageView doctorIV;

        @BindView(R.id.appointmentStatusTV)
        TextView appointmentStatusTV;

        @BindView(R.id.doctorNameTV)
        TextView doctorNameTV;

        @BindView(R.id.appointmentDateTimeTV)
        TextView educationTV;

        @BindView(R.id.specializationTV)
        TextView specializationTV;

        @BindView(R.id.dependentNameTV)
        TextView dependentNameTV;

        @BindView(R.id.civDependentImage)
        CircleImageView civDependentImage;

        @BindView(R.id.appointmentTimeTV)
        TextView appointmentTimeTV;

        @BindView(R.id.btnCancelAppointment)
        Button btnCancelAppointment;

        @BindView(R.id.btn_reshed_appointment)
        Button btn_reshed_appointment;

        private Consultation consultation = null;
        private View.OnClickListener itemClick = null;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this, rootView);
        }

        public void bindMe(Consultation consultation, View.OnClickListener itemClick) {
            this.consultation = consultation;
            this.itemClick = itemClick;

            Date date = consultation.getSlot().getBookingDateTimeProcessed();
            Date currentDate = new Date();

            int diffBetweenCurrentAndBookedApp = currentDate.compareTo(date);

            if (diffBetweenCurrentAndBookedApp == 0) {
                appointmentTimeTV.setText(
                        StringUtils.null2Length0(
                                "Today at " + TextUtils.formatTime12GMT(date)
                        )
                );
            }
//            else if (diffBetweenCurrentAndBookedApp == -1) {
//                appointmentTimeTV.setText(
//                        StringUtils.null2Length0(
//                                "Yesterday at " + TextUtils.formatTime12GMT(date)
//                        )
//                );
//            }
            else {
                appointmentTimeTV.setText(
                        StringUtils.null2Length0(
                                TextUtils.formatDateRelative(date, "MM/dd/yyyy 'at' hh:mm a")
                        )
                );
            }

            if (consultation.getDependent() == null) {
                UserDataLogin loggedInUser = baseActivity.userData;
                Glide.with(baseActivity)
                        .load(loggedInUser.getPhoto())
                        .placeholder(R.drawable.profile_placeholder)
                        .error(R.drawable.profile_placeholder)
                        .into(civDependentImage);
                dependentNameTV.setText(MessageFormat.format("for {0}", StringUtils.null2Length0(loggedInUser.getFirstName() + loggedInUser.getLastName())));
            } else {
                Glide.with(baseActivity)
                        .load(consultation.getDependent().getPhoto())
                        .placeholder(R.drawable.profile_placeholder)
                        .error(R.drawable.profile_placeholder)
                        .into(civDependentImage);
                dependentNameTV.setText(MessageFormat.format("for {0}", StringUtils.null2Length0(consultation.getDependent().getName())));
            }

            // #TODO Consultation object don't have these , add from backend
            specializationTV.setVisibility(View.GONE);
            educationTV.setVisibility(View.GONE);

            doctorNameTV.setText(StringUtils.null2Length0(consultation.getDoctorInfo().getDrFullName()));

            Glide.with(baseActivity)
                    .load(consultation.getDoctorInfo().getPhoto())
                    .placeholder(R.drawable.profile_placeholder)
                    .error(R.drawable.profile_placeholder)
                    .into(doctorIV);

            rootView.setOnClickListener(itemClick);

            makeAppointmentUpComing(consultation.isUpComingAppointment());

            appointmentStatusTV.setVisibility(consultation.getStatus() == APPOINTMENT_STATUS.UNKNOWN ? View.GONE : View.VISIBLE);
            switch (consultation.getStatus()) {
                case APPOINTMENT_STATUS.CANCELED:
                case APPOINTMENT_STATUS.REJECTED:
                    appointmentStatusTV.setBackgroundColor(ContextCompat.getColor(baseActivity, R.color.colorRedSelected));
                    appointmentStatusTV.setBackgroundColor(ContextCompat.getColor(baseActivity, R.color.colorRedSelected));
                    break;
                case APPOINTMENT_STATUS.PENDING:
                case APPOINTMENT_STATUS.UPCOMMING:
                    appointmentStatusTV.setBackgroundColor(ContextCompat.getColor(baseActivity, R.color.md_yellow_A700));
                    break;
                case APPOINTMENT_STATUS.COMPLETED:
                    appointmentStatusTV.setBackgroundColor(ContextCompat.getColor(baseActivity, R.color.colorGreenDark));
                    break;
                case APPOINTMENT_STATUS.APPROVED:
                    appointmentStatusTV.setBackgroundColor(ContextCompat.getColor(baseActivity, R.color.colorGreenButton));
                    break;
            }

            appointmentStatusTV.setText(StringUtils.null2Length0(APPOINTMENT_STATUS.getString(consultation.getStatus())));
        }

        private void makeAppointmentUpComing(boolean isUpcomming) {
            if (isUpcomming) {
                btnCancelAppointment.setVisibility(View.VISIBLE);
                btn_reshed_appointment.setVisibility(View.VISIBLE);

                // make other icons visible
                // #TODO add icons which are available in this consultation like diagnosis and notes etc

            } else {
                btnCancelAppointment.setVisibility(View.GONE);
                btn_reshed_appointment.setVisibility(View.GONE);

                // make other icons invisible
                // #TODO add icons which are available in this consultation like diagnosis and notes etc

            }
        }

        @OnClick(R.id.btnCancelAppointment)
        void cancelTheAppointment() {
            if (consultation != null) {
                LocalUtils.showSimpleDialog(
                        baseActivity,
                        "Cancel Appointment",
                        "Are you sure you want to cancel this appointment?"
                        , R.mipmap.ic_launcher,
                        () -> {
                            cancelAppointment(() -> {
                                consultation.setStatus(APPOINTMENT_STATUS.CANCELED);

                                bindMe(consultation,itemClick);
                            });
                        },null);
            }
        }

        @OnClick(R.id.btn_reshed_appointment)
        void reschedTheAppointment() {
            if (consultation != null) {
                LocalUtils.showSimpleDialog(
                        baseActivity,
                        "Reschedule Appointment",
                        "Are you sure you want to cancel this appointment and schedule a new one with same doctor?"
                        , R.mipmap.ic_launcher,
                        () -> {
                            cancelAppointment(() -> {
                                consultation.setStatus(APPOINTMENT_STATUS.CANCELED);

                                bindMe(consultation,itemClick);

                                getDoctorDetailApiCall(
                                        consultation.getSlot().getDoctorId() + "",
                                        doctorDetail -> {
                                            if(doctorDetail != null) {
                                                DoctorInfoLimited doctor = new DoctorInfoLimited();
                                                doctor.setId(doctorDetail.getUser().getId().intValue());
                                                doctor.setInstantDoctor(true);
                                                doctor.setName(doctorDetail.getDocterInfo().getName());
                                                doctor.setPicture(baseActivity.userData.getPhoto());
                                                doctor.setRatedCount(doctorDetail.getDocterInfo().getRatedCount());
                                                doctor.setRating(doctorDetail.getDocterInfo().getRating());
                                                for (Specialization specialization : doctorDetail.getSpecializations()) {
                                                    doctor.getSpecialization().add(specialization.getName());
                                                }

                                                mainNav.navigate(
                                                        MyAppointmentsFragmentDirections.actionMyAppointmentsFragmentToBookAppointmentFragment()
                                                                .setInstantDoctor(LocalUtils.getOr(doctorDetail.getDocterInfo().isInstantDoctor(),false) ? "yes" : "no")
                                                                .setMedicalPracticeId(LocalUtils.getOr(consultation.getSlot().getMedicalPracticeId(),0) + "")
                                                                .setDoctorId(LocalUtils.getOr(doctor.getId(),0) + "")
                                                                .setDoctorDetailId(LocalUtils.getOr(doctorDetail.getDocterInfo().getId(),0) + "")
                                                                .setAppointmentType(
                                                                        LocalUtils.getOr(consultation.getSlot().getMedicalPracticeId(),0L) == 0L ? "online" : "offline"
                                                                )
                                                                .setMedicalPracticeName("")
                                                                .setType(LocalUtils.getOr(doctorDetail.getDocterInfo().isInstantDoctor(),false) ? "onlineInstant" : "explore")
                                                                .setDoctor(doctor)
                                                );
                                            }
                                        }
                                );
                            });
                        },null);


            }
        }

        private void cancelAppointment(Runnable done) {
            if (consultation.getSlot() == null) {
                Toasty.normal(rootView.getContext(), "Appointment isn't booked yet so cannot cancel.").show();
                return;
            }

            String id = consultation.getSlot().getId() + "";
            String doctorID = consultation.getSlot().getDoctorId() + "";
            String patientID = consultation.getSlot().getPatientId() + "";

            if (StringUtils.isEmpty(id) || StringUtils.isEmpty(doctorID) || StringUtils.isEmpty(patientID))
                return;

            baseActivity.getDisposer().add(
                    baseActivity.RXAPI.cancelConsultationofDoctor(
                            new CancelDoctorAppointmentRequest()
                                    .withId(Integer.parseInt(id))
                                    .withDoctorId(Integer.parseInt(doctorID))
                                    .withPatientId(Integer.parseInt(patientID))
                                    .withRejected(true)
                                    .withNotifyDoctor(true)
                                    .withRejectedBy("patient")
                    ).subscribe(appointmentSlot -> {
                        Toasty.success(baseActivity, "Appointment cancelled successfully", Toast.LENGTH_LONG, false).show();
                        mainNav.popBackStack(R.id.dashboardFragment, false); done.run();
                        PrefsHelper.setAppointmentCount(PrefsHelper.getAppointmentCount()-1);
                        }, LocalUtils::processAPIError)
            );

        }

        private void getDoctorDetailApiCall(String doctorID, OnValueGot<DoctorDetail> got) {
            baseActivity.getDisposer().add(
                    baseActivity.RXAPI.getDoctorProfile(Integer.valueOf(doctorID))
                            .subscribe(got::gotIt, e -> {
                                got.gotIt(null);
                                LocalUtils.processAPIError(e);
                            }));
        }

    }
}
