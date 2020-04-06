package com.augmentcare.patient.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.DependentsView;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.apimodels.AvailableDoctor;
import com.augmentcare.patient.network.restApi.apimodels.BookedInstantAppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.network.restApi.apimodels.DocterInfo;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.FreeCallModel.FreeCallModel;
import com.augmentcare.patient.network.restApi.apimodels.FreeCallModel.TodayCalls;
import com.augmentcare.patient.network.restApi.apimodels.Specialization;
import com.augmentcare.patient.network.restApi.apimodels.UserInfo;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.augmentcare.patient.utils.ViewUtils;
import com.augmentcare.patient.viewmodels.InstantAppointmentVM;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.appevents.AppEventsConstants;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class InstantAppointmentFragment extends BaseFragment implements View.OnClickListener{

    @BindView(R.id.doctorImageIV_fia)
    de.hdodenhof.circleimageview.CircleImageView ivdocImage;
    @BindView(R.id.doctorNameTV_fia)
    TextView doctorNameTV;
    @BindView(R.id.educationTV_fia)
    TextView doctorEducationTV;
    @BindView(R.id.specializeTV_fia)
    TextView doctorspecializeTV;
    @BindView(R.id.experienceTV_fia)
    TextView doctorExperienceTV;
    @BindView(R.id.doctorRatingRB_fia)
    RatingBar doctorRatingRB;
    @BindView(R.id.ratingTV_fia)
    TextView ratingTV;
    @BindView(R.id.btn_start_video_appointment)
    Button rlContBookAnAppointment;
    @BindView(R.id.btn_book_later)
    Button btnBookAppointmentLater;
    @BindView(R.id.startEndTimeTV_fia)
    TextView startEndTimeTV_fia;
    @BindView(R.id.daysTV_fia)
    TextView daysTV_fia;
    @BindView(R.id.doctorFlagIV_fia)
    ImageView doctorFlagIV_fia;
    @BindView(R.id.tvInstantDoctor_fia)
    TextView tvInstantDoctor_fia;
    @BindView(R.id.btn_instantID)
    TextView btn_ID;
    @BindView(R.id.btnCancelAppointment)
    Button btnCancelAppointment;

    @BindView(R.id.callExpectTV)
    TextView callExpectTV;

    @BindView(R.id.tvDay)
    TextView tvDay;

    @BindView(R.id.tvHrs)
    TextView tvHrs;

    @BindView(R.id.tvMins)
    TextView tvMins;

    @BindView(R.id.tvSecs)
    TextView tvSecs;

    @BindView(R.id.bookLaterCV)
    CardView bookLaterCV;

    @BindView(R.id.tvDepLabel)
    TextView tvDepLabel;

    @BindView(R.id.dependentsDV)
    DependentsView dependentsDV;

    private NavController mainNavController;
    private View rootView;

    private DoctorInfoLimited doctor;

    private int userCompletedCalls, freeCalls, pendingCalls;

    //////////////////// ARGS ///////////////////

    private InstantAppointmentFragmentArgs args;

    ////////////////////////////////////////////

    private AvailableDoctor availableDoctor;
    private String doctorChannelKey;
    private Long userId;
    private Date appointDate;
    private Dependent selectedDependent;
    private InstantAppointmentVM instantAppointmentVM;
    private BookedInstantAppointmentSlot bookedVideoConsulationSlot;

    private boolean APPOINTMENT_APPROVED = false;

    private DoctorDetail doctorDetail;
    private TodayCalls todayCalls;

    public InstantAppointmentFragment(){}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMyself();

    }

    @Override
    public void onDestroyView() {
        if (countDown != null) {
            countDown.cancel();
        }
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_instant_appointment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void checkFreeCallAvailable(){
        getDisposer().add(
                baseActivity.RXAPI.checkFreeCall().subscribe(this::checkFreeCall , LocalUtils::processAPIError)
        );
    }

    private void checkFreeCall(FreeCallModel freeCall){
        if(freeCall.getSuccess()){
            todayCalls = freeCall.getData().getTodayCalls();
            userCompletedCalls = LocalUtils.getOr(freeCall.getData().getCompletedCalls(),0);
            freeCalls = LocalUtils.getOr(freeCall.getData().getFreeCalls(),0);
            pendingCalls = LocalUtils.getOr(freeCall.getData().getPendingCalls(),0);

//            userCompletedCalls = freeCall.getData().getCompletedCalls();
//            freeCalls = freeCall.getData().getFreeCalls();
//            pendingCalls = freeCall.getData().getPendingCalls();
        }
    }

    private void initMyself(){
        loadArguments();
        checkFreeCallAvailable();

        mainNavController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        MyApp.isReloadConsultations = true;
        AppSocket.getInstance(MyApp.get()).getSocket().connect();

        btnBookAppointmentLater.setOnClickListener(this);
        rlContBookAnAppointment.setOnClickListener(this);
        ivdocImage.setOnClickListener(this);

        instantAppointmentVM = ViewModelProviders.of(baseActivity).get(InstantAppointmentVM.class);

        if (StringUtils.isEmpty(args.getDoctorID())) {
            getSingleDoctorSlotFromServer(TextUtils.getDateTimeString(new Date()));
        }

        showStartVideoAppointmentButtons(true);

        GenApiLogger.fireInstantDocAvailable();

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Instant Doctor");
    }

    private void loadArguments() {
        if (getArguments() == null)
            return;
        args = InstantAppointmentFragmentArgs.fromBundle(getArguments());


        if (!StringUtils.isEmpty(args.getDoctorID())) {
            getDoctorDetailApiCall(args.getDoctorID());
        }
    }

    private void showStartVideoAppointmentButtons(boolean show) {
        btnBookAppointmentLater.setVisibility(show ? View.VISIBLE : View.GONE);
        rlContBookAnAppointment.setVisibility(show ? View.VISIBLE : View.GONE);

        btnCancelAppointment.setVisibility(show ? View.GONE : View.VISIBLE);

        dependentsDV.setVisibility(show ? View.VISIBLE : View.GONE);
        tvDepLabel.setVisibility(show ? View.VISIBLE : View.GONE);

    }

    private void getDoctorDetailApiCall(String doctorID) {
        getDisposer().add(
                baseActivity.RXAPI.getDoctorProfile(Integer.valueOf(doctorID))
                        .subscribe(doctorDetail -> {
                            this.doctorDetail = doctorDetail;
                            availableDoctor = new AvailableDoctor()
                                    .withTime(TextUtils.getDateTimeString(new Date()))
                                    .withDoctorDetail(doctorDetail);
                            gotDoctorFromSlot(availableDoctor);
                        }, LocalUtils::processAPIError));
    }

    @OnClick(R.id.cv_doctor_profile)
    protected void openDoctorProfile() {
        if (APPOINTMENT_APPROVED) {
            return;
        }
        if (userId != null) {
            DoctorProfileFragmentArgs args = new DoctorProfileFragmentArgs.Builder(userId + "")
                    .setShowBookAppointmentBtn(false)
                    .build();
            mainNavController.navigate(R.id.action_instantAppointmentFragment_to_doctorProfileFragment2, args.toBundle());
        }
    }

    @Override
    public void onClick(View v) {
        if (APPOINTMENT_APPROVED) {
            return;
        }

        switch (v.getId()) {
            case R.id.bookLaterCV:
            case R.id.btn_book_later:
                if(todayCalls!=null) {
                    if(todayCalls.getTodayCancelledByPatient()<=2) {
                        try {
                            if (PrefsHelper.isOnPlan()) {
                                if (doctorDetail != null) {
                                    doctor = new DoctorInfoLimited();
                                    doctor.setId(doctorDetail.getUser().getId().intValue());
                                    doctor.setInstantDoctor(true);
                                    doctor.setName(doctorDetail.getDocterInfo().getName());
                                    doctor.setPicture(doctorDetail.getUserInfo().getPhoto());
                                    doctor.setRatedCount(doctorDetail.getDocterInfo().getRatedCount());
                                    doctor.setRating(doctorDetail.getDocterInfo().getRating());
                                    for (Specialization specialization : doctorDetail.getSpecializations()) {
                                        doctor.getSpecialization().add(specialization.getName());
                                    }
                                    mainNavController.navigate(
                                            InstantAppointmentFragmentDirections.actionInstantAppointmentFragmentToDoctorProfileFragment2(doctor.getId() + "")
                                                    .setDoctor(doctor)
                                                    .setInstantDoctor("yes")
                                                    .setShowBookAppointmentBtn(true)
                                    );
                                } else {
                                    Toasty.error(Utils.getApp(), "Unable to Get Doctor Details try later...").show();
                                }
                            } else {
                                if (freeCalls - userCompletedCalls > 0) {
                                    if (pendingCalls < freeCalls) {
                                        mainNavController.navigate(
                                                InstantAppointmentFragmentDirections
                                                        .actionInstantAppointmentFragmentToFreeCallCongratsDialogFragment()
                                                        .setCallType("book")
                                        );

                                        MyApp.HANDLER.postDelayed(() -> {
                                            if (doctorDetail != null && doctorDetail.getUser().getId() != null) {
                                                doctor = new DoctorInfoLimited();
                                                doctor.setId(doctorDetail.getUser().getId().intValue());
                                                doctor.setInstantDoctor(true);
                                                doctor.setName(doctorDetail.getDocterInfo().getName());
                                                doctor.setPicture(doctorDetail.getUserInfo().getPhoto());
                                                doctor.setRatedCount(doctorDetail.getDocterInfo().getRatedCount());
                                                doctor.setRating(doctorDetail.getDocterInfo().getRating());
                                                for (Specialization specialization : doctorDetail.getSpecializations()) {
                                                    doctor.getSpecialization().add(specialization.getName());
                                                }

                                                mainNavController.navigate(
                                                        InstantAppointmentFragmentDirections
                                                                .actionInstantAppointmentFragmentToDoctorProfileFragment2(doctor.getId() + "")
                                                                .setDoctor(doctor)
                                                                .setInstantDoctor("yes")
                                                                .setShowBookAppointmentBtn(true)
                                                );
                                            } else {
                                                Toasty.error(Utils.getApp(), "Unable to Get Doctor Details try later...").show();
                                            }
                                        }, 6000);
                                    } else if (pendingCalls >= freeCalls) {
                                        mainNavController.navigate(InstantAppointmentFragmentDirections
                                                .actionInstantAppointmentFragmentToFreeCallCongratsDialogFragment()
                                                .setCallType("sorry")
                                        );
                                    }
                                } else {
                                    firebaseEvent("clicks_book_appontment_open_subscription");
                                    mainNavController.navigate(
                                            InstantAppointmentFragmentDirections.actionInstantAppointmentFragmentToPlanSelectionFragment()
                                    );
                                }
                            }
                        } catch (Exception ignored) {
                        }
                    }
                    else{
                        new AlertDialog.Builder(getContext())
                                .setTitle("Policy Alert!")
                                .setMessage("Hi, "+PrefsHelper.getUserInfo().getFirstName()+".\nYou cancelled "+ todayCalls.getTodayCancelledByPatient() +" appointments in a day which is against our policy. Now you have to wait for the next day to use Instant Doctor services")
                                .setCancelable(false)
                                .setPositiveButton("ok", (dialog, which) -> dialog.dismiss()).show();
                    }
                }
                break;
            case R.id.btn_start_video_appointment:
                if(todayCalls != null) {
                    if(todayCalls.getTodayCancelledByPatient() <= 2){
                        long hour = TextUtils.getDateDifferenceHours(new Date(), appointDate);
                        if (hour < 1) {
                            if (selectedDependent == null || selectedDependent.getId() == null){
                                bookInstantAppointment(null, availableDoctor.getTime());
                            } else {
                                bookInstantAppointment(selectedDependent.getId() + "", availableDoctor.getTime());
                            }
                        } else {
                            LocalUtils.showSimpleDialog(
                                    baseActivity,
                                    "Late Appointment",
                                    "Are you sure you want to book a late appointment ," +
                                            "Doctor will be available after " +
                                            TextUtils.getDateDifferenceString(new Date(), appointDate) +
                                            "You can expect a call " +
                                            TextUtils.formatDateAndTime(appointDate)
                                    , R.mipmap.ic_launcher,
                                    () -> {
                                        if (selectedDependent == null || selectedDependent.getId() == null) {
                                            bookInstantAppointment(null, availableDoctor.getTime());
                                        } else {
                                            bookInstantAppointment(selectedDependent.getId() + "", availableDoctor.getTime());
                                        }
                                    }, null);

                        }
                    }
                    else{
                        new AlertDialog.Builder(getContext())
                                .setTitle("Policy Alert!")
                                .setMessage("Hi, "+PrefsHelper.getUserInfo().getFirstName()+".\nYou cancelled "+ todayCalls.getTodayCancelledByPatient() +" appointments in a day which is against our policy. Now you have to wait for the next day to use Instant Doctor services")
                                .setCancelable(false)
                                .setPositiveButton("ok", (dialog, which) -> dialog.dismiss()).show();
                    }
                }
                break;

            case R.id.btnClose:
                baseActivity.finish();
                break;
        }
    }

    private void getSingleDoctorSlotFromServer(String dateTime) {
        getDisposer().add(
                baseActivity.RXAPI.getInstantAppointmentSlots(dateTime)
                        .subscribe(slot -> {
                            gotDoctorFromSlot(slot.getAvailableDoctor());
                        }, e -> {
                            LogUtils.e(e);
                            ViewUtils.showErrorToast(baseActivity, "No Doctor is available at selected time, Try again");
                            MyApp.HANDLER.postDelayed(() -> mainNavController.popBackStack(), 200);
                        })
        );

    }

    private void gotDoctorFromSlot(AvailableDoctor availableDoctor) {
        baseActivity.showLoader();

        this.availableDoctor = availableDoctor;
        UserInfo userInfo = null;
        DocterInfo docterInfo = null;


        try {
            userInfo = availableDoctor.getDoctorDetail().getUserInfo();
            docterInfo = availableDoctor.getDoctorDetail().getDocterInfo();
        }
        catch(Exception e){ e.printStackTrace(); }

        if (availableDoctor != null) {
            this.doctorDetail = availableDoctor.getDoctorDetail();

            PrefsHelper.get(baseActivity).putString(Constants.INSTANT_PROFILE_DATA, GsonUtils.toJson(availableDoctor));

            if (userInfo != null) {

                if (userInfo.getPhoto() != null)
                    Glide.with(this).load(userInfo.getPhoto()).apply(RequestOptions.circleCropTransform()).into(ivdocImage);
            }

            if (docterInfo != null) {
                long doctorID = availableDoctor.getDoctorDetail().getUser().getId();
                List<Specialization> selectedDoctorSpecializations = availableDoctor.getDoctorDetail().getSpecializations();

                doctorChannelKey = availableDoctor.getDoctorDetail().getUser().getChannelKey();
                userId = availableDoctor.getDoctorDetail().getUser().getId();

                doctorNameTV.setText(docterInfo.getName());
                doctorExperienceTV.setText(MessageFormat.format("{0} yrs", LocalUtils.getOr(docterInfo.getExperience(), 1)));
                doctorEducationTV.setText(docterInfo.getEducation());

                if (!selectedDoctorSpecializations.isEmpty()) {
                    doctorspecializeTV.setText(selectedDoctorSpecializations.get(0).getName());
                }

                ratingTV.setText(LocalUtils.getOr(docterInfo.getRating(), "0"));
                MyApp.get().computeRating(doctorRatingRB, Float.valueOf(LocalUtils.getOr(docterInfo.getRating(), "0")));
                startEndTimeTV_fia.setText("9:00 AM - Midnight");

//                if(doctorDetail.getTimings().size()>0) {
//                    for (int i = 0; i < doctorDetail.getTimings().size(); i++) {
//                        String startTime = getTime(doctorDetail.getTimings().get(i).getStartTime());
//                        String endTime = getTime(doctorDetail.getTimings().get(i).getEndTime());
//                        startEndTimeTV_fia.setText(startTime + " - " + endTime);
//                        break;
//                    }
//                }
//                else
//                {
//                    startEndTimeTV_fia.setText("On Leave");
//                }

                btn_ID.setVisibility(docterInfo.isInstantDoctor() ? View.VISIBLE : View.GONE);
                tvInstantDoctor_fia.setVisibility(docterInfo.isInstantDoctor() ? View.VISIBLE : View.GONE);
            }

            if (availableDoctor.getTime() != null) {
                appointDate = TextUtils.parseTimeWIthoutSSSLastSeconds(availableDoctor.getTime());
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                String currentTimeString = TextUtils.getDateTimeStringWIthoutSSSLastSeconds(calendar.getTime());
                Date currentDate = TextUtils.parseTimeWIthoutSSSLastSeconds(currentTimeString);

                tvDay.setText(MessageFormat.format("{0}", TextUtils.getDateDifferenceDays(currentDate, appointDate)));
                tvHrs.setText(MessageFormat.format("{0}", TextUtils.getDateDifferenceHours(currentDate, appointDate)));
                tvMins.setText(MessageFormat.format("{0}", TextUtils.getDateDifferenceMinutes(currentDate, appointDate)));
                tvSecs.setText(MessageFormat.format("{0}", TextUtils.getDateDifferenceSeconds(currentDate, appointDate)));

                initCountDown(
                        TextUtils.getDateDifferenceDays(currentDate, appointDate),
                        TextUtils.getDateDifferenceHours(currentDate, appointDate),
                        TextUtils.getDateDifferenceMinutes(currentDate, appointDate),
                        TextUtils.getDateDifferenceSeconds(currentDate, appointDate),
                        () -> {
                            Toasty.error(Utils.getApp(), "Slot Timings Expired Open Instant appointment again to book...").show();
                            baseActivity.onBackPressed();
                        }
                );

                callExpectTV.setText(MessageFormat.format("Expect a call: {0}", TextUtils.formatDateWithFormat(appointDate, "hh:mm a dd/MM/yyyy")));


            }
            firebaseEvent("ID_screen");
        }

        baseActivity.stopLoader();
    }

    private void firebaseEvent(String type) {

        GenApiLogger.fireGenericEvent(baseActivity,type);

    }

    private void notifyUser(String userChannel, String doctorRoleId) {
        JSONObject updateNotifications = new JSONObject();
        try {
            updateNotifications.put("key", userChannel);
            updateNotifications.put("user_role_id", doctorRoleId);
            updateNotifications.put("notify_type", "slot_request");
            updateNotifications.put("event_type", "update_notificaions");
            AppSocket.getInstance(MyApp.get()).getSocket().emit("emit_event", updateNotifications);
        } catch (Exception ignored) {
            LogUtils.e(ignored);
        }
    }


    private void afterVideoAppointBook(BookedInstantAppointmentSlot slot) {
        APPOINTMENT_APPROVED = true;
        baseActivity.showLoader();

        this.bookedVideoConsulationSlot = slot;

        if (!slot.isSuccess()) {
            ViewUtils.showOneButtonDialog(baseActivity, "Appointment Alert!", "Unable to book appointment yet try again...", (dialogInterface, i) -> {
            });
            return;
        }

        int doctorRoleId = availableDoctor.getDoctorDetail().getDocterInfo().getUserRoleId();

        if (!doctorChannelKey.isEmpty() && doctorRoleId > 0) {
            AppSocket.getInstance(MyApp.get()).getSocket().connect();
            notifyUser(doctorChannelKey, doctorRoleId + "");
        }

        appointDate = TextUtils.parseTime(slot.getSlot().getBookingTime());
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String currentTimeString = TextUtils.getDateTimeString(calendar.getTime());
        Date currentDate = TextUtils.parseTime(currentTimeString);
        long hour = TextUtils.getDateDifferenceHours(currentDate, appointDate);

        try {
            if (hour >= 1) {
                GenApiLogger.fireHourGreaterEvent();

            } else {
                GenApiLogger.fireLessGreaterEvent();

               }
        } catch (Exception ignored) {
        }

        showStartVideoAppointmentButtons(false);

//        if (hour >= 1) {
//            NavDirections action =
//                    InstantAppointmentFragmentDirections
//                            .actionInstantAppointmentFragmentToInstantAppointmentReachedBF(
//                                    TextUtils.getDateDifferenceString(currentDate, appointDate),
//                                    TextUtils.formatDateAndTime(appointDate)
//                            ).setBookedDoctorSlot(slot.getSlot());
//
//            mainNavController.navigate(action);
//
//        } else {

            calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            currentTimeString = TextUtils.getDateTimeStringWIthoutSSSLastSeconds(calendar.getTime());
            currentDate = TextUtils.parseTimeWIthoutSSSLastSeconds(currentTimeString);

            initCountDown(
                    TextUtils.getDateDifferenceDays(currentDate, appointDate),
                    TextUtils.getDateDifferenceHours(currentDate, appointDate),
                    TextUtils.getDateDifferenceMinutes(currentDate, appointDate),
                    TextUtils.getDateDifferenceSeconds(currentDate, appointDate),
                    () -> {
                        // #TODO just wait for doctor to Respond don't cancel appointment after booking

//                        cancelAppointment(() -> {
//                            Toasty.error(Utils.getApp(), "Doctor didn't responded on time, book another appointment.").show();
//                            baseActivity.onBackPressed();
//                        });
                    }
            );
            callExpectTV.setText(MessageFormat.format("Expect a call: {0}", TextUtils.formatDateWithFormat(appointDate, "hh:mm a dd/MM/yyyy")));
            Toasty.success(baseActivity, "Instant Appointment booked Please wait for call...", Toasty.LENGTH_LONG).show();
//        }

        firebaseEvent("ID_ConfirmAppointment");
//                    spinKit.setVisibility(View.GONE);

        GenApiLogger.fireSegmentAndIntercomInstantAppointmentEvent(appointDate,slot);


        String specialization = "";
        GenApiLogger.fireSchedualAppointmentEvent(baseActivity,specialization,appointDate);
        baseActivity.stopLoader();
    }


    private void bookInstantAppointment(String depID, String timeOfAppointment){
        try{
            if(PrefsHelper.isOnPlan()){
                getDisposer().add(
                        baseActivity.RXAPI.bookInstantAppointment(
                                availableDoctor.getDoctorDetail().getDocterInfo().getId(),
                                StringUtils.isEmpty(args.getOrderID()) ? "" : args.getOrderID() + "",
                                StringUtils.null2Length0(depID),
                                timeOfAppointment
                        ).subscribe(this::afterVideoAppointBook, e -> {
                            LogUtils.e(e);
                            ViewUtils.showOneButtonDialog(baseActivity, "Appointment Alert!", e.getMessage(), (dialogInterface, i) -> {
                            });
                        })
                );
            }
            else{
                if(freeCalls-userCompletedCalls > 0){
                    if(pendingCalls < freeCalls){
                        mainNavController.navigate(InstantAppointmentFragmentDirections
                                        .actionInstantAppointmentFragmentToFreeCallCongratsDialogFragment()
                                .setCallType("call")
                        );
                        MyApp.HANDLER.postDelayed(() -> {
                            getDisposer().add(
                                    baseActivity.RXAPI.bookInstantAppointment(
                                            availableDoctor.getDoctorDetail().getDocterInfo().getId(),
                                            StringUtils.isEmpty(args.getOrderID()) ? "" : args.getOrderID() + "",
                                            StringUtils.null2Length0(depID),
                                            timeOfAppointment
                                    ).subscribe(this::afterVideoAppointBook, e -> {
                                        LogUtils.e(e);
                                        ViewUtils.showOneButtonDialog(baseActivity, "Appointment Alert!", e.getMessage(), (dialogInterface, i) -> {
                                        });
                                    })
                            );
                        }, 3000);
                    }
                    else if(pendingCalls >= freeCalls){
                        mainNavController.navigate(InstantAppointmentFragmentDirections
                                .actionInstantAppointmentFragmentToFreeCallCongratsDialogFragment()
                                .setCallType("sorry")
                        );
                    }
                }
                else{
                    firebaseEvent("clicks_book_appontment_open_subscription");
                    mainNavController.navigate(R.id.action_instantAppointmentFragment_to_planSelectionFragment);
                }
            }
        }
        catch (Exception ignored){}
    }

    private void cancelAppointment(Runnable done) {
        if (bookedVideoConsulationSlot.getSlot() == null) {
            Toasty.normal(baseActivity, "Appointment isn't booked yet so cannot cancel.").show();
            return;
        }

        String id = bookedVideoConsulationSlot.getSlot().getId() + "";
        String doctorID = bookedVideoConsulationSlot.getSlot().getDoctorId() + "";
        String patientID = bookedVideoConsulationSlot.getSlot().getPatientId() + "";

        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(doctorID) || StringUtils.isEmpty(patientID))
            return;

        getDisposer().add(
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
                    mainNavController.popBackStack(R.id.dashboardFragment, false);
                    PrefsHelper.setAppointmentCount(PrefsHelper.getAppointmentCount()-1); done.run();
                }, e -> {
                    LogUtils.e(e);
                    Toasty.error(baseActivity, e.getMessage(), Toast.LENGTH_LONG, false).show();
                })
        );
    }

    private CountDownTimer countDown;

    private void initCountDown(long startingDays, long startingHours, long startingMinutes, long startingSeconds, Runnable onDone) {
        long minutesMilliSeconds = 0;
        long hoursMilliSecond = 0;
        long daysMilliSecond = 0;
        long secondsMilliSecond = 0;
        long totalMilliSeconds;

        if (startingMinutes > 0) {
            minutesMilliSeconds = TimeUnit.MINUTES.toMillis(startingMinutes);
        }
        if (startingHours > 0) {
            hoursMilliSecond = TimeUnit.HOURS.toMillis(startingHours);
        }
        if (startingDays > 0) {
            daysMilliSecond = TimeUnit.DAYS.toMillis(startingDays);
        }
        if (startingSeconds > 0) {
            secondsMilliSecond = TimeUnit.SECONDS.toMillis(startingSeconds);
        }
        totalMilliSeconds = minutesMilliSeconds + hoursMilliSecond + daysMilliSecond + secondsMilliSecond;

        if(countDown != null){
            countDown.cancel();
        }
        if(totalMilliSeconds > 0){
            countDown = new CountDownTimer(totalMilliSeconds, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    try {

                        long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                        millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

                        long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                        millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

                        long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                        millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

                        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

                        tvDay.setText(MessageFormat.format("{0}", days));
                        tvHrs.setText(MessageFormat.format("{0}", hours));
                        tvMins.setText(MessageFormat.format("{0}", minutes));
                        tvSecs.setText(MessageFormat.format("{0}", seconds));

                    }catch(Exception e){}
                }

                @Override
                public void onFinish() {
                    onDone.run();
                }
            };
            countDown.start();
        }
    }

    @OnClick(R.id.btnCancelAppointment)
    protected void clickCancel() {

        APPOINTMENT_APPROVED = false;

        cancelAppointment(() -> {
            mainNavController.popBackStack(R.id.dashboardFragment, false);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        instantAppointmentVM.getDependent().observe(getViewLifecycleOwner(), dependent -> {
            selectedDependent = dependent;
        });
    }
    private String getTime(String startTime) {
        String outputText = "";
        DateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

        try {
            Date date123;
            date123 = inputFormat.parse(startTime);
            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTime(date123); // sets calendar time/selectedDate
            cal.add(Calendar.HOUR_OF_DAY, 5); // adds one hour
            date123 = cal.getTime(); // returns new selectedDate object, one hour in the future
            outputText = outputFormat.format(date123);
        } catch (Exception ignored) {
        }
        return outputText;
    }

}