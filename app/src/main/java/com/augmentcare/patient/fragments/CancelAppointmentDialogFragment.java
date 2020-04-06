package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseDialogFragment;
import com.augmentcare.patient.network.restApi.apirequests.CancelDoctorAppointmentRequest;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class CancelAppointmentDialogFragment extends BaseDialogFragment{
    private View rootView;
    NavController navController;
    String doctorId= null, pateintId=null, slotId=null;

    @BindView(R.id.tv_are_you_sure_you_want_to_cancel)
    TextView tvAreYouSure;

    @BindView(R.id.btn_yes_cancel_it)
    Button btnYes;

    @BindView(R.id.btn_no_i_dont)
    Button btnNo;

    public CancelAppointmentDialogFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_cancel_appointment_dialog, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);
        loadingBundle();
    }

    public void loadingBundle(){
        if(getArguments() != null){
            CancelAppointmentDialogFragmentArgs args = CancelAppointmentDialogFragmentArgs.fromBundle(getArguments());

            if(args.getDoctorId() != null){
                doctorId = args.getDoctorId();
            }
            if(args.getPateintId() != null){
                pateintId = args.getPateintId();
            }
            if(args.getSlotId() != null){
                slotId = args.getSlotId();
            }
        }
    }

    @OnClick(R.id.btn_yes_cancel_it)
    protected void yesCancelIt(){
        cancelAppointment(() -> {
            navController.navigate(R.id.dashboardFragment);
        });
    }

    @OnClick(R.id.btn_no_i_dont)
    protected void dontCancel(){
        navController.popBackStack();
    }

    private void cancelAppointment(Runnable done) {
        if (slotId == null) {
            Toasty.normal(baseActivity, "Appointment isn't booked yet so cannot cancel.").show();
            return;
        }

        if (StringUtils.isEmpty(slotId) || StringUtils.isEmpty(doctorId) || StringUtils.isEmpty(pateintId))
            return;

        getDisposer().add(
                baseActivity.RXAPI.cancelConsultationofDoctor(
                        new CancelDoctorAppointmentRequest()
                                .withId(Integer.parseInt(slotId))
                                .withDoctorId(Integer.parseInt(doctorId))
                                .withPatientId(Integer.parseInt(pateintId))
                                .withRejected(true)
                                .withNotifyDoctor(true)
                                .withRejectedBy("patient")
                ).subscribe(appointmentSlot -> {
                        Toasty.success(baseActivity, "Appointment cancelled successfully", Toast.LENGTH_LONG, false).show();
                    navController.popBackStack(R.id.dashboardFragment, false);
                    PrefsHelper.setAppointmentCount(PrefsHelper.getAppointmentCount()-1);
                    done.run();
                }, LocalUtils::processAPIError)
        );
    }
}