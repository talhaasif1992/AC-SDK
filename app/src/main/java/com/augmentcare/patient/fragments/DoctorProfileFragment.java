package com.augmentcare.patient.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.DocterInfo;
import com.augmentcare.patient.network.restApi.apimodels.DoctorAvailableSlots;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.FreeCallModel.FreeCallModel;
import com.augmentcare.patient.network.restApi.apimodels.Specialization;
import com.augmentcare.patient.network.restApi.apimodels.UserInfo;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class DoctorProfileFragment extends BaseFragment {

    String doctorId, instantDoctor;
    DoctorInfoLimited doctor;
    Boolean showBookAppointBtn;
    DoctorDetail doctorDetail;
    private DoctorAvailableSlots doctorSlots;

    private List<String> slotTimeList = null;

    @BindView(R.id.doctorImageIV_fia)
    de.hdodenhof.circleimageview.CircleImageView doctorImageIV;
    @BindView(R.id.doctorNameTV_fia)
    TextView doctorNameTV_fia;
    @BindView(R.id.educationTV_fia)
    TextView educationTV_fia;
    @BindView(R.id.specializeTV_fia)
    TextView specializeTV_fia;
    @BindView(R.id.clinicTV_fia)
    TextView clinicTV_fia;
    @BindView(R.id.reviews_fia)
    TextView reviews_fia;
    @BindView(R.id.experienceTV_fia)
    TextView experienceTV_fia;
    @BindView(R.id.ratingTV_fia)
    TextView ratingTV_fia;
    @BindView(R.id.feesTV_fia)
    TextView feesTV_fia;
    @BindView(R.id.startEndTimeTV_fia)
    TextView startEndTimeTV_fia;
    @BindView(R.id.tvInstantDoctor_fia)
    TextView tvInstantDoctor_fia;
    @BindView(R.id.btn_instantID)
    TextView btn_instantID;
    @BindView(R.id.rl_book_apoint)
    RelativeLayout rl_book_apoint;
    @BindView(R.id.doctorRatingRB_fia)
    AppCompatRatingBar doctorRatingRB_fia;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tvRating)
    TextView tvRatingTitle;

    @BindView(R.id.feeTitleTV)
    TextView feeTitleTV;

    private View rootView;
    private LinearLayoutManager mLayoutManager;
    private String doctorChannelKey;
    private Long userId;

    private boolean noSlotFlag = false;

    private NavController mainNavController;
    private DoctorProfileFragmentArgs args;

    private boolean onlineButtonFlag = false;

    private int userCompletedCalls, freeCalls, pendingCalls;

    public DoctorProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_doctor_profile, container, false);
        ButterKnife.bind(this, rootView);

        baseActivity.showLoader();

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }


    private void initMe() {

        mainNavController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        loadArguments();

        getDisposer().add(
                baseActivity.RXAPI.checkFreeCall().subscribe(this::checkFreeCall)
        );

        initTabs();

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Doctor Profile");

        GenApiLogger.fireFindADoctorDetailEvent(baseActivity);


    }

    private void checkFreeCall(FreeCallModel freeCall) {
        if (freeCall.getSuccess()) {
            try {
                userCompletedCalls = freeCall.getData().getCompletedCalls();
                freeCalls = freeCall.getData().getFreeCalls();
                pendingCalls = freeCall.getData().getPendingCalls();
            } catch (Exception e) {
            }
        }
    }

    private void loadArguments() {
        if (getArguments() == null) {
            mainNavController.popBackStack(R.id.dashboardFragment, true);
            return;
        }

        args = DoctorProfileFragmentArgs.fromBundle(getArguments());

        // getting doctor id for sending to the next fragment (Find a doctor flow)
        doctorId = args.getDoctorID();
        doctor = args.getDoctor();
        instantDoctor = args.getInstantDoctor();
        showBookAppointBtn = args.getShowBookAppointmentBtn();



        MyApp.HANDLER.postDelayed(() -> {
            getDoctorDetailApiCall(doctorId);

        }, 1000);

        rl_book_apoint.setVisibility(showBookAppointBtn ? View.VISIBLE : View.GONE);

    }

    private void initTabs() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), tabs.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void getDoctorDetailApiCall(String userId) {
        getDisposer().add(
                baseActivity.RXAPI.getDoctorProfile(Integer.valueOf(userId))
                        .subscribe(doctorDetail -> {
                            this.doctorDetail = doctorDetail;
                            processDoctorDetails(doctorDetail);
                        }));
//        baseActivity.RXAPI.getDoctorProfile(Integer.valueOf(userId))
//                        .subscribe(doctorDetail -> {
//                            this.doctorDetail = doctorDetail;
//                            processDoctorDetails(doctorDetail);
//                        }, LocalUtils::processAPIError));
    }

    private void processDoctorDetails(DoctorDetail doctorDetail) {

        UserInfo userInfo = null;
        DocterInfo docterInfo = null;

        if (doctorDetail != null) {


            userInfo = doctorDetail.getUserInfo();
            docterInfo = doctorDetail.getDocterInfo();

            initTabs();

            if (userInfo != null){

                if (userInfo.getPhoto() != null)
                    Glide.with(this)
                            .load(userInfo.getPhoto())
                            .error(R.drawable.profile_placeholder)
                            .placeholder(R.drawable.profile_placeholder)
                            .apply(RequestOptions.circleCropTransform())
                            .into(doctorImageIV);

            }

            if (docterInfo != null) {
                long doctorID = doctorDetail.getUser().getId();
                List<Specialization> selectedDoctorSpecializations = doctorDetail.getSpecializations();

                doctorChannelKey = doctorDetail.getUser().getChannelKey();
                userId = doctorDetail.getUser().getId();

                doctorNameTV_fia.setText(docterInfo.getName());
                experienceTV_fia.setText(MessageFormat.format("{0} yrs", LocalUtils.getOr(docterInfo.getExperience(), 1)));
                educationTV_fia.setText(docterInfo.getEducation());

                if (!selectedDoctorSpecializations.isEmpty()) {
                    specializeTV_fia.setText(selectedDoctorSpecializations.get(0).getName());
                }

                ratingTV_fia.setText(LocalUtils.getOr(docterInfo.getRating(), "0"));
                MyApp.get().computeRating(doctorRatingRB_fia, Float.valueOf(LocalUtils.getOr(docterInfo.getRating(), "0")));
//                startEndTimeTV_fia.setText("9:00 AM - Midnight");

                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

                Date c = Calendar.getInstance().getTime();

                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = df.format(c);

                if(doctorDetail.getTimings().size()>0){
                    for(int i=0; i < doctorDetail.getTimings().size(); i++){
                        if(!doctorDetail.getTimings().get(i).getOfflineLocation()){
                            onlineButtonFlag = true;
                        }
                    }
                }
                else{
                    noSlotFlag = true;
                }

               // String s =doctorDetail.getTimings().get(c.getDay()-1).getStartTime();
                if(doctorDetail.getTimings().size()>0) {
                    for (int i = 0; i < doctorDetail.getTimings().size(); i++) {
                        String startTime = getTime(doctorDetail.getTimings().get(i).getStartTime());
                        String endTime = getTime(doctorDetail.getTimings().get(i).getEndTime());
                        startEndTimeTV_fia.setText(startTime + " - " + endTime);
                        break;
                    }
                }
                else
                {
                    startEndTimeTV_fia.setText("On Leave");
                }


                if (doctorDetail.getMedicalPractices().size() > 0) {
                    clinicTV_fia.setText(StringUtils.null2Length0(doctorDetail.getMedicalPractices().get(0).getName()));
                } else {
                    clinicTV_fia.setText("");
                }

                if (doctorDetail.getDocterInfo().getRatedCount() == 0) {
                    reviews_fia.setText("No reviews yet");
                } else {
                    reviews_fia.setText(LocalUtils.getOr(doctorDetail.getDocterInfo().getRatedCount(), 0) + " reviews");
                }

                if (PrefsHelper.isOnPlan() && docterInfo.isInstantDoctor()) {
                    feesTV_fia.setText("Free for \n Subscribed User");
                    feeTitleTV.setVisibility(View.GONE);
                } else {

                    feesTV_fia.setText("Rs " + LocalUtils.getOr(doctorDetail.getFee(), 0));
                    feeTitleTV.setVisibility(View.VISIBLE);

                }
                tvInstantDoctor_fia.setVisibility(docterInfo.isInstantDoctor() ? View.VISIBLE : View.GONE);
                btn_instantID.setVisibility(docterInfo.isInstantDoctor() ? View.VISIBLE : View.GONE);
            }
        }
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

    private String getDate(String startTime) {
        String outputText = "";
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
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

    @OnClick(R.id.btnBookAppointment)
    protected void clickAppointmentBtn() {
        try {
            if (NetworkUtils.isConnected()) {
                if (instantDoctor != null && !instantDoctor.isEmpty()) {
                    if(instantDoctor.equals("yes")){
                        if (PrefsHelper.isOnPlan()) {
                            PrefsHelper.get(getContext()).putString(Constants.SLOT_LOCATION, "Online");
                            mainNavController.navigate(DoctorProfileFragmentDirections
                                    .actionDoctorProfileFragmentToBookAppointmentFragment()
                                    .setDoctor(doctor)
                                    .setInstantDoctor(instantDoctor)
                                    .setDoctorId(doctorId)
                                    .setDoctorDetailId(Integer.toString(doctorDetail.getDocterInfo().getId()))
                                    .setType("onlineInstant")
                                    .setMedicalPracticeId("")
                                    .setMedicalPracticeName("")
                                    .setAppointmentType("online")
                            );
                        }
                        else{
                            if (freeCalls - userCompletedCalls > 0){
                                if (pendingCalls < freeCalls) {
                                    mainNavController.navigate(
                                            DoctorProfileFragmentDirections
                                                    .actionDoctorProfileFragmentToFreeCallCongratsDialogFragment()
                                                    .setCallType("book")
                                    );

                                    MyApp.HANDLER.postDelayed(() -> {
                                        PrefsHelper.get(getContext()).putString(Constants.SLOT_LOCATION, "Online");
                                        mainNavController.navigate(DoctorProfileFragmentDirections
                                                .actionDoctorProfileFragmentToBookAppointmentFragment()
                                                .setDoctor(doctor)
                                                .setInstantDoctor(instantDoctor)
                                                .setDoctorId(doctorId)
                                                .setDoctorDetailId(Integer.toString(doctorDetail.getDocterInfo().getId()))
                                                .setType("onlineInstant")
                                                .setMedicalPracticeId("")
                                                .setMedicalPracticeName("")
                                                .setAppointmentType("online")
                                        );
                                    }, 6000);
                                } else if (pendingCalls >= freeCalls) {
                                    //  GenApiLogger.fireBookAppointmentEvent(baseActivity);
                                    mainNavController.navigate(DoctorProfileFragmentDirections
                                            .actionDoctorProfileFragmentToFreeCallCongratsDialogFragment()
                                            .setCallType("sorry")
                                    );

                                    MyApp.HANDLER.postDelayed(()->{
                                        mainNavController.navigate(DoctorProfileFragmentDirections.actionDoctorProfileFragmentToPlanSelectionFragment());
                                    },6000);
                                }
                            }
                        }
                    }
                    else{
                        if(noSlotFlag){
                            Toasty.error(getContext(), "Sorry! "+doctorDetail.getDocterInfo().getName()+" is not available at the time.").show();
                        }
                        else{
                            mainNavController.navigate(DoctorProfileFragmentDirections
                                    .actionDoctorProfileFragmentToAppointmentTypesBottomSheet(
                                            doctor,
                                            doctorId,
                                            instantDoctor,
                                            doctorDetail
                                    ).setOnlineButtonFlag(onlineButtonFlag)
                            );
                        }
                    }
                }
            } else {
                Toasty.error(baseActivity, "Please Check your internet connection").show();
            }
        } catch (Exception ignored) {
        }
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;
        private String[] tabTitles = new String[]{"ABOUT", "WORK EXPERIENCE", "EDUCATION", "REVIEWS"};

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            Fragment fragment = new AboutFragmentDoctor();
            switch (position) {
                case 0:
                    AboutFragmentDoctor aboutFragmentDoctor = new AboutFragmentDoctor();
                    aboutFragmentDoctor.setDoctorDetail(doctorDetail);
                    fragment = aboutFragmentDoctor;
                    return fragment;
                case 1:
                    WorkExpFragmentDoctor workExpFragmentDoctor = new WorkExpFragmentDoctor();
                    workExpFragmentDoctor.setDoctorWorkExpData(doctorDetail);
                    fragment = workExpFragmentDoctor;
                    return fragment;
                case 2:
                    EducationFragmentDoctor educationFragmentDoctor = new EducationFragmentDoctor();
                    educationFragmentDoctor.setDoctorDetail(doctorDetail);
                    fragment = educationFragmentDoctor;
                    return fragment;
                case 3:
                    ReviewDoctorFragment reviewDoctorFragment = new ReviewDoctorFragment();
                    reviewDoctorFragment.setDoctorReviewData(doctorDetail);
                    fragment = reviewDoctorFragment;
                    return fragment;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }


}