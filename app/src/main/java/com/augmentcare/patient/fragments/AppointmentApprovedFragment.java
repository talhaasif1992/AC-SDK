package com.augmentcare.patient.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.BookedInstantAppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.EliteDoctorSuccess;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class AppointmentApprovedFragment extends BaseFragment{

    NavController navController;

    private View rootView;

    @BindView(R.id.tvDoctorName)
    TextView tvDoctorName;
    @BindView(R.id.doctorDeegreeTV)
    TextView tvDoctorDegree;
    @BindView(R.id.doctorSpecTV)
    TextView tvDoctorSpeciality;
    @BindView(R.id.civ_doctor_profile_pic)
    CircleImageView ciDoctorPicture;

    @BindView(R.id.tv_patient_name)
    TextView tvPateintName;
    @BindView(R.id.bookingDateTV)
    TextView tvDate;
    @BindView(R.id.bookingStartEndTimeTV)
    TextView tvTime;

    DoctorInfoLimited doctor;
    String selectedDate;
    String dependentId=null, slotId = null, doctorId=null;
    BookedInstantAppointmentSlot exploreInstantModel;
    EliteDoctorSuccess exploreDoctorSuccess;
    String instantDoctor, medicalPracticeName, medicalPracticeId, pateintName, type, appointmentType, doctorDetailsId, time;

    String startTime, endTime, paymentMethodType, cardId, bookByUser, pateintId;
    Boolean isFromPayment;

    public AppointmentApprovedFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_appointment_approved, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);
        ((HomeScreenActivity)baseActivity).setToolbarTitle("Book Appointment");
        gettingDataFromBundle();

        GenApiLogger.fireAppointmentApproveEvent(baseActivity);



    }

    public void gettingDataFromBundle(){
        if(getArguments() != null)
        {
            AppointmentApprovedFragmentArgs args = AppointmentApprovedFragmentArgs.fromBundle(getArguments());

            if(args.getSelectedDate() != null){
                selectedDate = args.getSelectedDate();
                tvDate.setText(convertDate(args.getSelectedDate()));
            }
            if(args.getPateintName() != null){
                pateintName = args.getPateintName();
                tvPateintName.setText(args.getPateintName());
            }
            if(args.getTime() != null){
                time = args.getTime();
                tvTime.setText(args.getTime());
            }

            if(args.getExploreDoctorSuccessResponseObj() != null){
                exploreDoctorSuccess = args.getExploreDoctorSuccessResponseObj();
                slotId = Long.toString(exploreDoctorSuccess.getSlot().getId());
                dependentId = Long.toString(exploreDoctorSuccess.getSlot().getPatientId());
            }
            if(args.getDoctor() != null) {
                doctor = args.getDoctor();
                doctorId = args.getDoctor().getId()+"";
                tvDoctorName.setText(doctor.getName());
                tvDoctorDegree.setText("");
                tvDoctorSpeciality.setText(doctor.getSpecialization().get(0));
                Glide.with(baseActivity)
                        .load(doctor.getPicture())
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ciDoctorPicture);
            }

            //TODO here is error slotid is null
            if(args.getExporeInstantModelResponseObj() != null){
                exploreInstantModel = args.getExporeInstantModelResponseObj();
                slotId = Long.toString(exploreInstantModel.getSlot().getId());
                dependentId = Long.toString(exploreInstantModel.getSlot().getPatientId());
            }
            if(args.getType() != null){
                type = args.getType();
            }
            if(args.getAppointmentType() != null){
                appointmentType = args.getAppointmentType();
            }
            if(args.getDoctorDetailId() != null){
                doctorDetailsId = args.getDoctorDetailId();
            }
            if(args.getMedicalPracticeId() != null){
                medicalPracticeId = args.getMedicalPracticeId();
            }
            if(args.getMedicalPracticeName() != null){
                medicalPracticeName = args.getMedicalPracticeName();
            }
            if(args.getInstantDoctor() != null){
                instantDoctor = args.getInstantDoctor();
            }
            if(args.getStartTime() != null){
                startTime = args.getStartTime();
            }
            if(args.getEndTime() != null){
                endTime = args.getEndTime();
            }
            if(args.getPaymentMethodType() != null){
                paymentMethodType = args.getPaymentMethodType();
            }
            if(args.getCardId() != null){
                cardId = args.getCardId();
            }
            if(args.getBookByUser() != null){
                bookByUser = args.getBookByUser();
            }
            if(args.getPateintId() != null){
                pateintId = args.getPateintId();
            }

            isFromPayment  = args.getIsFromExplorePayment();
        }


    }

    @OnClick(R.id.btn_cancel_appointment)
    protected void cancelAppointment(){
        navController.navigate(AppointmentApprovedFragmentDirections
                .actionAppointmentApprovedFragmentToCancelAppointmentDialogFragment()
                .setDoctorId(doctorId)
                .setPateintId(dependentId)
                .setSlotId(slotId)
                .setBtnPressed("Cancel Appointment")
        );
    }

    @OnClick(R.id.btn_reshedule)
    protected void rescheduleAppointment(){
        cancelAppointment(() -> {
            navController.navigate(AppointmentApprovedFragmentDirections
                    .actionAppointmentApprovedFragmentToBookAppointmentFragment()
                    .setDoctor(doctor)
                    .setCardId(cardId)
                    .setDependentId(dependentId)
                    .setStartTime(startTime)
                    .setEndTime(endTime)
                    .setPaymentMethodType(paymentMethodType)
                    .setBookByUser(bookByUser)
                    .setPateintId(pateintId)
                    .setInstantDoctor(instantDoctor)
                    .setMedicalPracticeId(medicalPracticeId)
                    .setDoctorId(doctorId)
                    .setDoctorDetailId(doctorDetailsId)
                    .setAppointmentType(appointmentType)
                    .setMedicalPracticeName(medicalPracticeName)
                    .setType(type)
                    .setDoctor(doctor)
                    .setDependentId(dependentId)
                    .setExploreDoctorSuccessResponseObj(exploreDoctorSuccess)
                    .setExploreInstantModelResponseObj(exploreInstantModel)
                    .setPateintName(pateintName)
                    .setSelectedDate(selectedDate)
                    .setTime(time)
                    .setIsFromReschedule(true)
            );
        });
    }

    public String convertDate(String selectedDate){
        String date = convertFormat(
                selectedDate,
                "EEE MMM dd hh:mm:ss zzz yyyy",
                "dd MMM yyyy"
        );

        return date;
    }

    private String convertFormat(String date,String currentFormat,String expectedFormat){
        return TimeUtils.date2String(
                TimeUtils.string2Date(date,currentFormat),
                expectedFormat
        );
    }

    private void cancelAppointment(Runnable done){
        if (slotId == null) {
            Toasty.normal(baseActivity, "Appointment isn't booked yet so cannot cancel.").show();
            return;
        }

        if (StringUtils.isEmpty(slotId) || StringUtils.isEmpty(doctorId) || StringUtils.isEmpty(dependentId))
            return;

        getDisposer().add(
                baseActivity.RXAPI.cancelConsultationofDoctor(
                        new CancelDoctorAppointmentRequest()
                                .withId(Integer.parseInt(slotId))
                                .withDoctorId(Integer.parseInt(doctorId))
                                .withPatientId(Integer.parseInt(dependentId))
                                .withRejected(true)
                                .withNotifyDoctor(true)
                                .withRejectedBy("patient")
                ).subscribe(appointmentSlot -> {
                    done.run();
                }, LocalUtils::processAPIError)
        );
    }
}