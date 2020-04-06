package com.augmentcare.patient.bottomsheets;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.VideoConsultationActivity;
import com.augmentcare.patient.base.BaseDialogFragment;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationDetails;
import com.augmentcare.patient.network.restApi.apimodels.TokBoxObj;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.network.restApi.apirequests.TokBoxSessionRequest;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class ConsultationPreviewDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public static final String TAG = "ConsultationPreviewDialogFragment";
    private View rootView;
    private ConsultationPreviewDialogFragmentArgs args;

    public ConsultationPreviewDialogFragment() {
    }

    @BindView(R.id.goBackLL)
    LinearLayout goBackLL;

    @BindView(R.id.ivThumb)
    CircularImageView ivThumb;

    @BindView(R.id.txtName)
    TextView txtName;

    @BindView(R.id.txtTimeAndDate)
    TextView txtTimeAndDate;

    @BindView(R.id.callExpectTV)
    TextView callExpectTV;

//    @BindView(R.id.txtConsultType)
//    TextView txtConsultType;

//    @BindView(R.id.txtConsultStatus)
//    TextView txtConsultStatus;

    @BindView(R.id.btnReject)
    Button btnReject;

    @BindView(R.id.btnGoHome)
    Button btnGoHome;

    @BindView(R.id.txtConnectingTimer)
    TextView txtConnectingTimer;

    @BindView(R.id.tv_connecting_in_label)
    TextView tvConnectingInLabel;

    private TokBoxObj tokBoxObject;
    private ConsultationDetails consultationDetail;
    private String slotId = "";
    private String userId;
    private CountDownTimer timer;
    private Date startTime;

    private NavController mainNavController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_fragment_consultation_preview, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt() {
        loadArgs();

        mainNavController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        AnalyticsUtils.appointmentDetails(getContext(), "" + args.getSlotID());
        slotId = args.getSlotID();
        AnalyticsUtils.appointmentDetails(getContext(), "" + slotId);

        loadDetail();

        ivThumb.setOnClickListener(this);
        txtName.setOnClickListener(this);
        btnGoHome.setOnClickListener(this);
    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = ConsultationPreviewDialogFragmentArgs.fromBundle(getArguments());
        }
    }

    private void loadDetail() {
        if (Integer.valueOf(slotId) > 0) {

            getConsultationDetails(
                    Integer.valueOf(slotId),
                    this::initViewsUsingConsultation
            );
        } else {
            Toasty.error(Utils.getApp(), "Invalid Slot for Consultation...").show();
            baseActivity.onBackPressed();
        }
    }

    private void initViewsUsingConsultation(ConsultationDetails consultationDetails) {
        consultationDetail = consultationDetails;

        if (consultationDetail == null) {
            Toasty.error(baseActivity, R.string.error_message_failed_to_fetch, Toast.LENGTH_LONG, false).show();
            return;
        }
        tokBoxTokenAPI();

        userId = baseActivity.userData.getUserId() + "";
        bindViews();

    }

    private void getConsultationDetails(int slotID, OnValueGot<ConsultationDetails> gotConsultDetails) {
        getDisposer().add(
                baseActivity.RXAPI.getConsultationDetails(false, slotID)
                        .subscribe(gotConsultDetails::gotIt, e -> {
                            LocalUtils.processAPIError(e);
                            gotConsultDetails.gotIt(null);
                        })
        );
    }

    private void tokBoxTokenAPI() {
        getDisposer().add(
                baseActivity.RXAPI.getTokBoxVideoSession(
                        new TokBoxSessionRequest()
                                .withDoctorRoleId(consultationDetail.getUserRoleId())
                                .withPatientRoleId(MyApp.get().getRole().getId())
                                .withSlotId(consultationDetail.getSlot().getId().intValue())
                                .withUid(baseActivity.userData.getUid())
                ).subscribe(tokBoxObj -> {
                    tokBoxObject = tokBoxObj;
                    Intent intent = new Intent(baseActivity, VideoConsultationActivity.class);
                    intent.putExtra(Constants.KEY_TOK_BOX_OBJECT, tokBoxObject);
                    //startActivity(intent);
                    //btnStartConsultation.setVisibility(View.VISIBLE);
                }, e -> {
                    LocalUtils.processAPIError(e);
                })
        );


        if (consultationDetail != null && (consultationDetail.getReportsList() != null && consultationDetail.getReportsList().size() == 0)) {
            getDisposer().add(
                    baseActivity.RXAPI.getAllLabTestsList()
                            .subscribe(labTests -> {
                                consultationDetail.setReportsList(labTests);
                            }, e -> {
                                LocalUtils.processAPIError(e);
                            })
            );

        }
    }


    private void bindViews() {
        String name;
        if (consultationDetail != null) {
            name = consultationDetail.getDoctorFullname();
            txtName.setText(name);

            Date dateObject = TextUtils.parseTime(consultationDetail.getSlot().getBookingTime());
            String dateAndTime = TextUtils.formatDateAndTime(dateObject);
            txtTimeAndDate.setText(dateAndTime);

            if (consultationDetail.getSlot().getSlotStatus() != null &&
                    consultationDetail.getSlot().getSlotStatus().equalsIgnoreCase(LocalUtils.CONSULT_STATUS_APPROVED) ||
                    consultationDetail.getSlot().getSlotStatus().equalsIgnoreCase(LocalUtils.CONSULT_STATUS_PENDING)
            ){
                btnReject.setVisibility(View.VISIBLE);
                tvConnectingInLabel.setVisibility(View.VISIBLE);
                goBackLL.setVisibility(View.GONE);

                startTime = TextUtils.parseTime(
                        consultationDetail
                                .getSlot()
                                .getStartTime()
                                .replace(
                                        consultationDetail
                                                .getSlot()
                                                .getStartTime()
                                                .split("T")[0], consultationDetail.getSlot().getDay()
                                )
                );

                long diff = startTime.getTime() - Calendar.getInstance().getTimeInMillis();

                if (diff > 0 && timer == null) {
                    timer = new CountDownTimer(diff, 1000){
                        @Override
                        public void onTick(long millisUntilFinished) {
                            long seconds = millisUntilFinished / 1000;
                            long minutes = seconds / 60;
                            long hours = minutes / 60;
                            long days = hours / 24;

                            String timeToConnect = "";

                            if (days > 0) {
                                timeToConnect = timeToConnect + days + " Days ";
                            }

                            if (hours > 0) {
                                timeToConnect = timeToConnect + (hours % 24) + " hours ";
                            }

                            if (minutes > 0) {
                                timeToConnect = timeToConnect + (minutes % 60) + " minutes ";
                            }

                            if (seconds > 0) {
                                timeToConnect = timeToConnect + (seconds % 60) + " seconds ";
                            }

                            txtConnectingTimer.setVisibility(View.VISIBLE);
                            tvConnectingInLabel.setVisibility(View.VISIBLE);
                            txtConnectingTimer.setText(timeToConnect);
                        }

                        @Override
                        public void onFinish() {
                            baseActivity.onBackPressed();
                        }
                    };

                    timer.start();
                } else {
                    txtConnectingTimer.setVisibility(View.GONE);
                    tvConnectingInLabel.setVisibility(View.GONE);
                }
            }else{
                btnReject.setVisibility(View.GONE);
                tvConnectingInLabel.setVisibility(View.GONE);
                goBackLL.setVisibility(View.VISIBLE);

                callExpectTV.setText("Your Call was Expected On:");
            }

            if (consultationDetail.getSlot() != null) {
                LocalUtils.setConsultationStatus(consultationDetail.getSlot());
            }

            if (!StringUtils.isEmpty(consultationDetail.getPic())) {
                Glide.with(baseActivity)
                        .load(consultationDetail.getPic())
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .apply(RequestOptions.circleCropTransform())
                        .into(ivThumb);
            } else {
                Glide.with(baseActivity)
                        .load(R.drawable.profile_placeholder)
                        .apply(RequestOptions.circleCropTransform())
                        .into(ivThumb);
            }

            btnReject.setOnClickListener(this);
        }

//        if (consultationDetail.getSlot() != null && consultationDetail.getSlot().getSlot_status() != null)
//            txtConsultStatus.setText(consultationDetail.getSlot().getSlot_status().replaceAll("_", " ").toUpperCase());


    }

//    @Override
//    public void onDestroyView() {
//        if (args.getIsFromNotificationFragment() && getParentFragment() instanceof NotificationsFragment) {
//            mainNavController.popBackStack(R.id.NotificationsFragment, false);
//        } else if (getParentFragment() instanceof MyAppointmentsFragment) {
//            mainNavController.popBackStack(R.id.myAppointmentsFragment, false);
//        } else {
//            mainNavController.popBackStack(R.id.dashboardFragment, false);
//        }
//        super.onDestroyView();
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnReject:
                ViewUtils.showDialogWithButtons(baseActivity,
                        "Alert", "Are you sure you want to cancel this appointment?",
                        "No", "Yes", (dialogInterface, i) -> {
                            if (i == DialogInterface.BUTTON_POSITIVE) {
                                cancelAppointment(consultationDetail, this::dismiss);
                            }
                        });
                break;

            case R.id.txtName:
                break;
            case R.id.btnGoHome:
                baseActivity.onBackPressed();
                break;
            case R.id.ivThumb:
                if (userId != null && !userId.isEmpty()) {
                    mainNavController.navigate(
                            ConsultationPreviewDialogFragmentDirections.actionConsultationPreviewFragmentToDoctorProfileFragment(userId)
                    );
                }
                GenApiLogger.fireSegmentAndIntercomEvent(baseActivity);
                 break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case Constants.REQUEST_AGE:
                    break;
            }
        }
    }

    private void cancelAppointment(ConsultationDetails consultation, Runnable done) {
        if (consultation.getSlot() == null) {
            Toasty.normal(rootView.getContext(), "Appointment isn't booked yet so cannot cancel.").show();
            return;
        }

        String id = consultation.getSlot().getId() + "";
        String doctorID = consultation.getSlot().getDoctorId() + "";
        String patientID = consultation.getSlot().getPatientId() + "";

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
                    mainNavController.popBackStack(R.id.dashboardFragment, false);done.run();
                    PrefsHelper.setAppointmentCount(PrefsHelper.getAppointmentCount()-1);
                }, LocalUtils::processAPIError)
        );

    }

}