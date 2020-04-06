package com.augmentcare.patient.fragments;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseBottomSheetDialogFragment;
import com.augmentcare.patient.network.restApi.apimodels.Slot;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;


public class instantAppointmentReachedBF extends BaseBottomSheetDialogFragment {


    private View rootView;

    @BindView(R.id.callExpectTV)
    TextView callExpectTV;

    @BindView(R.id.appointConfirmTV)
    TextView appointConfirmTV;

    private Slot bookedDoctorSlot;

    private NavController mainNavController;


    public instantAppointmentReachedBF() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_instant_appoitment_resched_b, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initMe();
    }

    private void initMe() {
        ButterKnife.bind(this, rootView);

        mainNavController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        loadArguments();

        appointConfirmTV.setText("Approved but Can Take More Than An Hour");

    }

    private void loadArguments() {
        if (getArguments() != null) {
            instantAppointmentReachedBFArgs args = instantAppointmentReachedBFArgs.fromBundle(getArguments());

            bookedDoctorSlot = args.getBookedDoctorSlot();

            SpanUtils.with(callExpectTV)
                    .append("Doctor will be available after ")
                    .appendSpace(1)
                    .append(args.getDoctorAvailableTime())
                    .setBoldItalic()
                    .appendSpace(1)
                    .append("You can expect a call ")
                    .appendSpace(1)
                    .append(args.getDoctorAvailableDate())
                    .setBoldItalic().create();
        }
    }

    private void cancelAppointment(Runnable done) {
        if (bookedDoctorSlot == null) {
            Toasty.normal(baseActivity, "Appointment isn't booked yet so cannot cancel.").show();
            return;
        }

        String id = bookedDoctorSlot.getId() + "";
        String doctorID = bookedDoctorSlot.getDoctorId() + "";
        String patientID = bookedDoctorSlot.getPatientId() + "";

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
                    mainNavController.popBackStack(R.id.dashboardFragment, false); done.run();
                    PrefsHelper.setAppointmentCount(PrefsHelper.getAppointmentCount()-1);
                    }, LocalUtils::processAPIError)
        );


    }

    /**
     * @param title
     * @param message
     */
    protected void dialogCancelAppointment(String title, String message) {
        try {
            AlertDialog.Builder simsimInAppDialog = new AlertDialog.Builder(getActivity());
            simsimInAppDialog.setTitle(title);
            simsimInAppDialog.setMessage(message);
            simsimInAppDialog.setIcon(R.mipmap.ic_launcher);
            simsimInAppDialog.setCancelable(false);
            simsimInAppDialog.setPositiveButton("OK",
                    (dialog, which) -> {
                        cancelAppointment(() -> {
                            dialog.cancel();
                            Toasty.error(Utils.getApp(), "Appointment has been Canceled...", Toasty.LENGTH_LONG).show();
                            mainNavController.popBackStack(R.id.dashboardFragment,false);
                        });
                    });
            simsimInAppDialog.setNegativeButton("Cancel",
                    (dialog, which) -> dialog.cancel());
            try {
                if (simsimInAppDialog != null) {
                    simsimInAppDialog.show();
                }
            } catch (Exception ignored) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.cancelAppointmentBtn)
    protected void cancelAppointment() {
        dialogCancelAppointment("Cancel Appointment", "Are you sure you want to cancel appointment?");

    }

    @OnClick(R.id.reschedBtn)
    protected void reschedAppointment() {
        cancelAppointment(() -> {
            Toasty.success(Utils.getApp(), "Appointment is Rescheduled Successfully...", Toasty.LENGTH_LONG).show();
            mainNavController.popBackStack(R.id.dashboardFragment,false);
            MyApp.HANDLER.postDelayed(() -> {
                mainNavController.navigate(R.id.action_dashboardFragment_to_instantAppointmentFragment);
            },500);
        });

    }

//    private void handleUserExit() {
//        mainNavController.popBackStack(R.id.dashboardFragment,false);
//        dismiss();
//    }
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState)
//    {
//        Dialog d = super.onCreateDialog(savedInstanceState);
//        d.setOnShowListener(dialog -> {
//            BottomSheetDialog d1 = (BottomSheetDialog) dialog;
//            FrameLayout bottomSheet = d1.findViewById(R.id.design_bottom_sheet);
//            BottomSheetBehavior behaviour = null;
//            if (bottomSheet != null) {
//                behaviour = BottomSheetBehavior.from(bottomSheet);
//                behaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//                    @Override
//                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                        switch (newState){
//                            case BottomSheetBehavior.STATE_HIDDEN:
//                                // handle user exit or close the dialog
//                                handleUserExit();
//                                dismiss();
//                                break;
//                            case BottomSheetBehavior.STATE_COLLAPSED:
//                                break;
//                            case BottomSheetBehavior.STATE_EXPANDED:
//                                break;
//                        }
//                    }
//
//                    @Override
//                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//                    }
//                });
//            }
//
//        });
//        return d;
//    }
//
//    @Override
//    public void onCancel(@NonNull DialogInterface dialog) {
//        super.onCancel(dialog);
//        handleUserExit();
//    }



}
