package com.augmentcare.patient.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseDialogFragment;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationRating;
import com.augmentcare.patient.network.restApi.apimodels.RatingModelRequest;
import com.augmentcare.patient.utils.LocalUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;

import org.apache.commons.lang3.math.NumberUtils;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class DoctorRatingDialogFrag extends BaseDialogFragment {

    private View rootView;


    @BindView(R.id.rateConsultTitleTV)
    TextView rateConsultTitleTV;

    @BindView(R.id.civDoctorPic)
    CircleImageView civDoctorPic;

    @BindView(R.id.drNameTV)
    TextView drNameTV;

    @BindView(R.id.mrbDoctorRate)
    MaterialRatingBar mrbDoctorRate;

    @BindView(R.id.edtRatingComments)
    AppCompatEditText edtRatingComments;

    @BindView(R.id.appointDescTV)
    TextView appointDescTV;

    private String APPOINTMENT_DATE_TIME;
    private String DOCTOR_NAME;
    private String DOCTOR_PIC;
    private String SLOT_ID;

    private NavController mainNavController;

    public DoctorRatingDialogFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_doctor_rating_dialog, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {
        loadArgs();

        mainNavController = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        appointDescTV.setText(
                MessageFormat.format(
                        "Kindly Rate your consultation On :{0}",
                        LocalUtils.getOr(APPOINTMENT_DATE_TIME, TimeUtils.getNowString())
                )
        );
        drNameTV.setText(StringUtils.null2Length0(DOCTOR_NAME));
        Glide.with(this)
                .load(DOCTOR_PIC)
                .placeholder(R.drawable.profile_placeholder)
                .error(R.drawable.profile_placeholder)
                .into(civDoctorPic);

    }


    private void loadArgs() {
        if(getArguments() != null){
            DoctorRatingDialogFragArgs args = DoctorRatingDialogFragArgs.fromBundle(getArguments());
            APPOINTMENT_DATE_TIME = args.getAppointmentDateTime();
            DOCTOR_NAME = args.getDoctorName();
            DOCTOR_PIC = args.getDoctorPic();
            SLOT_ID = args.getSlotID();
        }
    }

    @OnClick(R.id.submitFeedbackBtn)
    public void submitRating(){
        if(edtRatingComments.getText() == null)return;

        float rating = mrbDoctorRate.getRating();
        if(rating <= 0){
            Toasty.error(Utils.getApp(),"please give me some rating...").show();
            return;
        }

        rateConsultation(
                NumberUtils.toInt(SLOT_ID, -1),
                rating,
                StringUtils.null2Length0(edtRatingComments.getText().toString()),
                apiRated -> {
                    // #TODO do application rating too and then close the dialog
                    dismiss();
                }
        );
    }

    public void rateConsultation(
            Integer slotID,
            float rating,
            String ratingComments,
            OnValueGot<Boolean> ratingDone
    ){
        getDisposer().add(
                baseActivity.RXAPI.updateConsultationRating(
                        new RatingModelRequest()
                        .withConsultationRating(
                                new ConsultationRating()
                                .withRating(rating+"")
                                .withRatingComments(ratingComments)
                                .withSlotId(slotID+"")
                        )
                ).subscribe(s -> {
                    Toasty.success(Utils.getApp(),"Thank You for the Rating...").show();
                    ratingDone.gotIt(true);
                },e -> {
                    LocalUtils.processAPIError(e);
                    ratingDone.gotIt(false);
                })
        );
    }

}
