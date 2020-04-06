package com.augmentcare.patient.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.LabAndMedsPreviewListAdapter;
import com.augmentcare.patient.adapters.LabReportsPreviewAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.enums.APPOINTMENT_STATUS;
import com.augmentcare.patient.network.restApi.RxApi;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationDetails;
import com.augmentcare.patient.network.restApi.apimodels.OrderResults;
import com.augmentcare.patient.network.restApi.apimodels.RequestedReports;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;


public class AppointmentDetailsFragment extends BaseFragment {

    private View rootView;

    @BindView(R.id.civDoctorPic)
    CircleImageView civDoctorPic;

    @BindView(R.id.tvDoctorName)
    TextView tvDoctorName;

    @BindView(R.id.doctorDeegreeTV)
    TextView doctorDeegreeTV;

    @BindView(R.id.doctorSpecTV)
    TextView doctorSpecTV;

    @BindView(R.id.ratingTV)
    RatingBar ratingTV;

    @BindView(R.id.cvBookingDateTime)
    CardView cvBookingDateTime;

    @BindView(R.id.bookingDateTV)
    TextView bookingDateTV; // 25 August 2019

    @BindView(R.id.bookingStartEndTimeTV)
    TextView bookingStartEndTimeTV; // 08:40 AM - 09:15 AM

    @BindView(R.id.cvComplains)
    CardView cvComplains;

    @BindView(R.id.complainsTV)
    TextView complainsTV;

    @BindView(R.id.cvInstructions)
    CardView cvInstructions;

    @BindView(R.id.instructionsTV)
    TextView instructionsTV;

    @BindView(R.id.cvDiagnosis)
    CardView cvDiagnosis;

    @BindView(R.id.diagnosisTV)
    TextView diagnosisTV;

    @BindView(R.id.cvPrescriptions)
    CardView cvPrescriptions;

    @BindView(R.id.prescriptionsTitleTV)
    TextView prescriptionsTitleTV;

    @BindView(R.id.rvPrescriptionMeds)
    RecyclerView rvPrescriptionMeds;

    @BindView(R.id.cvLabTests)
    CardView cvLabTests;

    @BindView(R.id.rvLabTests)
    RecyclerView rvLabTests;

    @BindView(R.id.cvTotalForMedsAndTest)
    CardView cvTotalForMedsAndTest;

    @BindView(R.id.totalMoneyTitleTV)
    TextView totalMoneyTitleTV;

    @BindView(R.id.totalPriceTV)
    TextView totalPriceTV;

    @BindView(R.id.clBottomOrderBTN)
    ConstraintLayout clBottomOrderBTN;

    @BindView(R.id.btnSickNotes)
    TextView btnSickNotes;

    @BindView(R.id.fbDownload)
    FloatingActionButton fbDownload;

    private int SLOT_ID = -1;


    private LinearLayoutManager rvPrescriptionLinearLayoutManager;
    private LabAndMedsPreviewListAdapter adapterPrescriptionMeds;
    private LabReportsPreviewAdapter adapterLabReports;
    private LinearLayoutManager rvLabTestsLinearLayoutManager;
    private NavController navController;

    public AppointmentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_appointment_details, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {

        loadArgs();

        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        if(SLOT_ID > 0){
            getConsultationDetails(
                    SLOT_ID,
                    consultationDetails -> {
                        if (consultationDetails == null || consultationDetails.getStatus() != APPOINTMENT_STATUS.COMPLETED) {
                            baseActivity.onBackPressed();
                            return;
                        }
                        initViewsUsingConsultation(consultationDetails);
                    }
            );
        }
        else{
            Toasty.error(Utils.getApp(), "Invalid Slot for Consultation...").show();
            baseActivity.onBackPressed();
        }

        GenApiLogger.fireAppointmentSickNotes();
    }

    private void loadArgs() {
        if(getArguments() != null){
            AppointmentDetailsFragmentArgs args = AppointmentDetailsFragmentArgs.fromBundle(getArguments());
            SLOT_ID = args.getSlotID();
        }
    }

    private void initViewsUsingConsultation(ConsultationDetails details) {

        if(details.getUserInfo() != null){
            tvDoctorName.setText(
                    LocalUtils.getOr(
                            details.getUserInfo().getDrFullName(), // dr fullname
                            "Dr " +
                                    StringUtils.null2Length0(details.getUserInfo().getFirstName()) + // firstname
                                    " " +
                                    StringUtils.null2Length0(details.getUserInfo().getLastName()) // lastname
                    )
            );

            Glide.with(this)
                    .load(details.getUserInfo().getPhoto())
                    .placeholder(R.drawable.profile_placeholder)
                    .error(R.drawable.profile_placeholder)
                    .into(civDoctorPic);
        }

        bookingStartEndTimeTV.setText(
                String.format(
                        "%s - %s",
                        TextUtils.formatTime(
                                TextUtils.parseTime(
                                        details.getSlot().getStartTime()
                                )
                        ),
                        TextUtils.formatTime(
                                TextUtils.parseTime(
                                        details.getSlot().getEndTime()
                                )
                        )
                )
        );

        bookingDateTV.setText(
                String.format(
                        "%s",
                        TextUtils.formatDate(
                                TextUtils.parseDate(details.getSlot().getDay())
                        )
                )
        );

        addMedicines(details);
        addReports(details);

        if(details.getConsultationObject() != null){
            if (details.getConsultationObject().getDiagnosisNotes() != null && !details
                    .getConsultationObject().getDiagnosisNotes().trim().isEmpty()) {
                diagnosisTV.setText(
                        StringUtils.null2Length0(
                                details.getConsultationObject().getDiagnosisNotes()
                        )
                );
            }
            else{
                cvDiagnosis.setVisibility(View.GONE);
            }

            Double rating = details.getConsultationObject().getRating();

            if (rating != null &&
                    rating == 0 &&
                    details.getStatus() == APPOINTMENT_STATUS.COMPLETED)
            {
                navController.navigate(
                        AppointmentDetailsFragmentDirections.actionAppointmentDetailsFragmentToDoctorRatingDialogFrag(
                                details.getSlot().getBookingTime(),
                                details.getSlot().getId() + "",
                                StringUtils.null2Length0(details.getDoctorFullname()),
                                StringUtils.null2Length0(details.getUserInfo().getPhoto())
                        )
                );
            }
            else{
                ratingTV.setRating(Float.parseFloat(rating+""));
            }

            if(details.getConsultationObject().getPatientComplaints() != null && !details.getConsultationObject().getPatientComplaints().isEmpty()){
                complainsTV.setText(details.getConsultationObject().getPatientComplaints());
                complainsTV.setTextColor(getResources().getColor(R.color.colorLinkText));
            }
            else{
                complainsTV.setText("No Complaints Available");
                complainsTV.setTextColor(getResources().getColor(R.color.colorTextInactive2));
            }

            if(details.getConsultationObject() != null && !details.getConsultationObject()
                    .getInstructionForPatient().trim().isEmpty()) {
                instructionsTV.setText(details.getConsultationObject().getInstructionForPatient());
                instructionsTV.setTextColor(getResources().getColor(R.color.colorLinkText));
            }
            else{
                instructionsTV.setText(getString(R.string.no_instructions_available));
                instructionsTV.setTextColor(getResources().getColor(R.color.colorTextInactive2));
            }
        }

        // #TODO phase 2
        clBottomOrderBTN.setVisibility(View.GONE);
        totalPriceTV.setVisibility(View.GONE);
        cvTotalForMedsAndTest.setVisibility(View.GONE);

        if(details.getSickNotes() != null && !StringUtils.isEmpty(details.getSickNotes().getNote())) {
            btnSickNotes.setVisibility(View.VISIBLE);
        }
        else {
            btnSickNotes.setVisibility(View.GONE);
        }

        btnSickNotes.setOnClickListener(v -> {
            navController.navigate(AppointmentDetailsFragmentDirections.actionAppointmentDetailsFragmentToSickNotesFragment2(details.getSickNotes()));
        });

        fbDownload.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(/* "http://docs.google.com/viewer?url=" + */BuildConfig.SOCKET_URL + RxApi.DOWNLOAD_PRESCRIPTION + details.getSlot().getId()), "text/html");
            startActivity(intent);
//            try {
//                DownloadManager dm = (DownloadManager) getContext().getSystemService(DOWNLOAD_SERVICE);
//                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(BuildConfig.URL + RxApi.DOWNLOAD_PRESCRIPTION + details.getSlot().getId()));
//                request.setTitle("Downloading prescription");
//                request.setDestinationInExternalFilesDir(getContext(), Environment.DIRECTORY_DOWNLOADS, "Consultations" + "_" + details.getSlot().getId() + "_" + details.getSlot().getDay() + ".pdf");
//                request.allowScanningByMediaScanner();
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                request.setVisibleInDownloadsUi(true);
//                dm.enqueue(request);
//            }
//            catch(Exception e){}
        });
    }

    private void addReports(ConsultationDetails details) {
        setUpReportsList(details.getRequestedReports());

        if (details.getRequestedReports() == null || details.getRequestedReports().size() <= 0) {
            cvLabTests.setVisibility(View.GONE);
        } else {
            cvLabTests.setVisibility(View.VISIBLE);
        }
    }

    private void addMedicines(ConsultationDetails details) {
        setUpPrescriptionsList(details.getPrescription().getPrescriptionsObject());

        if (details.getPrescription().getPrescriptionsObject() == null ||
                details.getPrescription().getPrescriptionsObject().size() <= 0) {
            cvPrescriptions.setVisibility(View.GONE);
        } else {
            cvPrescriptions.setVisibility(View.VISIBLE);
        }
    }

    private void setUpPrescriptionsList(List<OrderResults> orderResults) {
        if (orderResults == null) {
            orderResults = new ArrayList<>();
        }
        if (rvPrescriptionMeds.getAdapter() == null) {
            adapterPrescriptionMeds = new LabAndMedsPreviewListAdapter();
            rvPrescriptionMeds.setHasFixedSize(true);
            rvPrescriptionLinearLayoutManager = new LinearLayoutManager(baseActivity, LinearLayoutManager.VERTICAL, false);
            rvPrescriptionMeds.setLayoutManager(rvPrescriptionLinearLayoutManager);
            rvPrescriptionMeds.setAdapter(adapterPrescriptionMeds);
        }
        adapterPrescriptionMeds.setOrderResults(orderResults);
    }

    private void setUpReportsList(List<RequestedReports> reports) {
        if (reports == null) {
            reports = new ArrayList<>();
        }
        if (rvLabTests.getAdapter() == null) {
            adapterLabReports = new LabReportsPreviewAdapter();
            rvLabTests.setHasFixedSize(true);
            rvLabTestsLinearLayoutManager = new LinearLayoutManager(baseActivity, LinearLayoutManager.VERTICAL, false);
            rvLabTests.setLayoutManager(rvLabTestsLinearLayoutManager);
            rvLabTests.setAdapter(adapterLabReports);
        }
        adapterLabReports.setRequestedReports(reports);
    }

    private void getConsultationDetails(int slotID, OnValueGot<ConsultationDetails> gotConsultDetails) {
        getDisposer()
                .add(
                        baseActivity.RXAPI.getConsultationDetails(false, slotID)
                                .subscribe(gotConsultDetails::gotIt, e -> {
                                    LocalUtils.processAPIError(e);
                                    gotConsultDetails.gotIt(null);
                                })
                );
    }
}
