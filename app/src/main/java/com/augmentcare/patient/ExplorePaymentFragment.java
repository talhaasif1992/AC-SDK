package com.augmentcare.patient;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.activities.PaymentMethodFragment;
import com.augmentcare.patient.adapters.PaymentPageAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.fragments.CreditCardFragment;
import com.augmentcare.patient.fragments.PaymentAtLocationFragment;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.EliteDoctorSuccess;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.TimeUtils;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExplorePaymentFragment extends BaseFragment {

    private View rootView;

    DoctorInfoLimited doctor;
    String doctorId, dependentId;
    String cardId="", paymentMethodType="", lastFourDigits="";

    private String startTime=null, endTime=null, selectedDate=null,
            pateintName =  "";

    String appointmentType, doctorDetailsId, medicalPracticeId, medicalPracticeName, type, instantDoctor;
    String bookByUser, pateintId;

    @BindView(R.id.tab_layout_payment)
    TabLayout tabLayoutPayment;

    @Nullable
    @BindView(R.id.tab_pay_at_location)
    TabItem tabPayAtLocation;

    @Nullable
    @BindView(R.id.tab_pay_by_credit_card)
    TabItem tabPayByCreditCard;

    @BindView(R.id.view_pager_payment)
    ViewPager viewPagerPayment;

    private PaymentPageAdapter paymentPageAdapter;

    NavController navController;

    PaymentAtLocationFragment fragPayAtLocation;
    PaymentMethodFragment fragCreditCardFragment;
    List<Fragment> fragmentList;
    private EliteDoctorSuccess exploreDoctorSuccess;

    public ExplorePaymentFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_explore_payment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initMe();
    }

    private void initMe(){
        ((HomeScreenActivity)baseActivity).setToolbarTitle("Payment Method");
        loadingBundle();
        navController = Navigation.findNavController(rootView);

        fragmentList = new ArrayList<>();

        fragPayAtLocation = new PaymentAtLocationFragment();
        fragCreditCardFragment = new PaymentMethodFragment("BookAppointment");
        fragmentList.add(fragPayAtLocation);
        fragmentList.add(fragCreditCardFragment);

        paymentPageAdapter = new PaymentPageAdapter(getChildFragmentManager(),tabLayoutPayment.getTabCount(), fragmentList);
        viewPagerPayment.setAdapter(paymentPageAdapter);

        if(appointmentType.equals("online")){
            viewPagerPayment.setCurrentItem(1);
            tabLayoutPayment.getChildAt(0).setClickable(false);
            tabLayoutPayment.getChildAt(0).setEnabled(false);

        }

        else if(appointmentType.equals("offline")){
            viewPagerPayment.setCurrentItem(0);
            tabLayoutPayment.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
                @Override
                public void onTabSelected(TabLayout.Tab tab){
                    viewPagerPayment.setCurrentItem(tab.getPosition());

                    if(tab.getPosition() == 0){
                        paymentPageAdapter.notifyDataSetChanged();
                    }
                    else if(tab.getPosition() == 1){
                        paymentPageAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab){}
                @Override
                public void onTabReselected(TabLayout.Tab tab){}
            });
        }

        viewPagerPayment.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutPayment));

        fragPayAtLocation.setOnPayAtLocationClick(v -> {
            labPaymentMethodAddEvent("cod");
            fireEvents();
            PrefsHelper.get(baseActivity).putString(Constants.KEY_PAY_AT_LOCATION, "Pay at Location");
            paymentMethodType = "pay_at_location";
            getPatientAppointmentApiCall();
        });

        fragCreditCardFragment.setOnMakePaymentClick(view -> {
            labPaymentMethodAddEvent("cod");
            fireEvents();
            paymentMethodType = PaymentMethodFragment.paymentMethod;
            cardId = PaymentMethodFragment.cardId;
            getPatientAppointmentApiCall();
        });

        pateintName = baseActivity.userData.getFirstName()+" "+baseActivity.userData.getLastName();
    }



    private void labPaymentMethodAddEvent(String type) {
        GenApiLogger.fireLabPaymentMethodAddEvent(type);
    }

    private void loadingBundle(){
        if(getArguments() != null){
            ExplorePaymentFragmentArgs args = ExplorePaymentFragmentArgs.fromBundle(getArguments());

            if(args.getDoctor() != null){
                doctor = args.getDoctor();
                doctorId = args.getDoctor().getId()+"";
            }
            if(args.getCardId() != null){
                cardId = args.getCardId();
            }
            if(args.getDependentId() != null){
                dependentId = args.getDependentId();
            }
            if(args.getPateintName() != null){
                pateintName = args.getPateintName();
            }
            if(args.getSelectedDate() != null){
                selectedDate = args.getSelectedDate();
            }
            if(args.getTimeSlot() != null){
                startTime = args.getTimeSlot();
            }
            if(args.getEndTime() != null){
                endTime = args.getEndTime();
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
            if(args.getType() != null){
                type = args.getType();
            }
            if(args.getInstantDoctor() != null){
                instantDoctor = args.getInstantDoctor();
            }
        }
    }

    private String convertFormat(String date,String currentFormat,String expectedFormat){
        return TimeUtils.date2String(TimeUtils.string2Date(date,currentFormat), expectedFormat);
    }

    private void getPatientAppointmentApiCall(){
        int medicalPracticeId;
        String dependentId;
        String startTime, endTime, selectedDate;

        selectedDate = convertFormat(
                this.selectedDate,
                "EEE MMM dd hh:mm:ss zzz yyyy",
                "yyyy-MM-dd"
        );

        startTime = convertFormat(
                this.startTime,
                "hh:mm a",
                "hh:mm"
        );

        endTime = convertFormat(
                this.endTime,
                "hh:mm a",
                "hh:mm"
        );

        if(PrefsHelper.get(baseActivity).getString(Constants.SLOT_LOCATION, "").equalsIgnoreCase("Online")){
            medicalPracticeId = 0;
        }
        else{
            medicalPracticeId = Integer.parseInt(PrefsHelper.get(baseActivity).getString(Constants.SLOT_LOCATION, ""));
        }

        if (this.dependentId != null && !this.dependentId.isEmpty()){
            dependentId = this.dependentId;
        }
        else { dependentId = ""; }

        pateintId = baseActivity.userData.getUserId()+"";
        bookByUser = baseActivity.userData.getUserId()+"";

        getDisposer().add(
                baseActivity.RXAPI.makePaymentAndBookSlot(medicalPracticeId,doctorId,dependentId ,startTime+"-"+endTime, startTime+"-"+endTime,selectedDate,
                        paymentMethodType,cardId, bookByUser, pateintId)
                        .subscribe(this::onMakePaymentAndBookSlot, LocalUtils::processAPIError)
        );
    }

    private void onMakePaymentAndBookSlot(EliteDoctorSuccess exploreDoctorSuccess) {
        this.exploreDoctorSuccess = exploreDoctorSuccess;

        navController.navigate(ExplorePaymentFragmentDirections
                .actionExplorePaymentFragmentToAppointmentApprovedFragment()
                .setExploreDoctorSuccessResponseObj(exploreDoctorSuccess)
                .setExporeInstantModelResponseObj(null)
                .setDoctor(doctor)
                .setSelectedDate(selectedDate)
                .setType("explore")
                .setDependentId(dependentId)
                .setPateintName(pateintName)
                .setTime(startTime)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setPaymentMethodType(paymentMethodType)
                .setCardId(cardId)
                .setBookByUser(bookByUser)
                .setPateintId(pateintId)
                .setAppointmentType(appointmentType)
                .setDoctorDetailId(doctorDetailsId)
                .setMedicalPracticeId(medicalPracticeId+"")
                .setMedicalPracticeName(medicalPracticeName)
                .setInstantDoctor(instantDoctor)
                .setIsFromExplorePayment(true)
        );
        clearValue();
    }

    private void fireEvents() {
        GenApiLogger.fireFindADoctorSelectPaymentMethod(baseActivity,"select_payment_method","find_a_doctor_select_payment_method");

    }



    private void clearValue(){
        CreditCardFragment.lastFourDigits = "";
        CreditCardFragment.paymentMethod = "";
        CreditCardFragment.cardId = "";
        paymentMethodType = "";
        PrefsHelper.get(baseActivity).remove(Constants.KEY_PAY_AT_LOCATION);
    }
}