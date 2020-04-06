package com.augmentcare.patient.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.AppointmentsPreviewAdapter;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.fragments.DashboardFragmentDirections;
import com.augmentcare.patient.network.restApi.apimodels.Consultation;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.network.restApi.apimodels.FreeCallModel.FreeCallModel;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.NetworkUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.disposables.CompositeDisposable;

public class AppointmentsHistoryView extends LinearLayout{

    private Context myContext;
    private View rootView;
    private BaseActivity baseActivity;

    @BindView(R.id.root_view)
    ConstraintLayout lytRootView;

    @BindView(R.id.tv_empty_state)
    TextView tvEmptyState;

    @BindView(R.id.rv_list)
    RecyclerView appointmentsRV;

    @BindView(R.id.previousIV)
    ImageView previousIV;

    @BindView(R.id.nextIV)
    ImageView nextIV;

    @BindView(R.id.numRangTV)
    TextView numbRangTitle;

    private boolean freeCallNotification = false;
    private int noOfFreeCalls, noOfCompletedCalls;

    public List<Consultation> getAllAppointments() {
        return appointmentArrayList;
    }

    public List<Consultation> getUpcomingAppointments() {
        return upcomingAppointments;
    }


    private List<Consultation> appointmentArrayList = new ArrayList<>();
    private AppointmentsPreviewAdapter adapter;
    private List<Dependent> dependents;
    private LinearLayoutManager linearLayoutManager;
    private List<Consultation> upcomingAppointments = new ArrayList<>();

    private NavController mainNavController;
//    private CompositeDisposable COMPOSITE_DISPOSE;

    public AppointmentsHistoryView(Context context){
        super(context);
        myContext = context;
        initMe();
    }

    public AppointmentsHistoryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myContext = context;
        initMe();
    }

    public AppointmentsHistoryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        myContext = context;
        initMe();
    }

    public AppointmentsHistoryView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        myContext = context;
        initMe();
    }

    private void initMe() {
        baseActivity = (BaseActivity) ActivityUtils.getTopActivity();

        rootView = inflate(baseActivity, R.layout.view_appointments_history, this);
        ButterKnife.bind(this, rootView);

        mainNavController = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        linearLayoutManager = new LinearLayoutManager(baseActivity, LinearLayoutManager.HORIZONTAL, false);
        appointmentsRV.setHasFixedSize(true);
        adapter = new AppointmentsPreviewAdapter(baseActivity);
        appointmentsRV.setLayoutManager(linearLayoutManager);
        appointmentsRV.setAdapter(adapter);


        nextIV.setOnClickListener(v -> {
            int lastPos = linearLayoutManager.findFirstVisibleItemPosition() + 1;
            if (lastPos < adapter.getItemCount()) {
                appointmentsRV.smoothScrollToPosition(lastPos);
                setCustomLabelRange(lastPos + 1, adapter.getItemCount());
            }
        });
        previousIV.setOnClickListener(v -> {
            int lastPos = linearLayoutManager.findFirstVisibleItemPosition() + 1;
            if (lastPos > 1) {
                appointmentsRV.smoothScrollToPosition(lastPos - 2);
                setCustomLabelRange(lastPos - 1, adapter.getItemCount());
            }
        });

        getDisposer().add(
                baseActivity.RXAPI.checkFreeCall().subscribe(s ->{
                    if(!PrefsHelper.isOnPlan()) {
                        checkFreeCall(s);
                    }
                    loadConsultations();
                }, LocalUtils::processAPIError)
        );
    }

    private void checkFreeCall(FreeCallModel freeCall){
        if(freeCall.getSuccess()){
            noOfFreeCalls = freeCall.getData().getFreeCalls();
            noOfCompletedCalls = freeCall.getData().getCompletedCalls();
            if(noOfFreeCalls - noOfCompletedCalls > 0 ){
                tvEmptyState.setText("Hi "+ PrefsHelper.getUserInfo().getFirstName()+ " " + PrefsHelper.getUserInfo().getLastName() + ", You still have " + noOfFreeCalls +" free call available, feel free to speak with an Instant Doctor if you’re unwell.");
            }
            else{
                tvEmptyState.setText("Get started by downloading the app today! Immediate appointments available with PMDC certified, experienced doctors");
            }
        }
    }



    private void loadAppointments(List<Consultation> appointments) {
        adapter.setListOfAppointments(appointments);
        PrefsHelper.setAppointmentCount(appointments.size());

        adapter.setClickListener((type, position) -> {
            mainNavController.navigate(
                    DashboardFragmentDirections
                            .actionDashboardFragmentToConsultationPreviewFragment(
                                    type.getSlot().getId()+""
                            )
            );
        });
    }

    public CompositeDisposable getDisposer() {
//        if (COMPOSITE_DISPOSE == null){
//            COMPOSITE_DISPOSE = new CompositeDisposable();
//        }
//        return COMPOSITE_DISPOSE;
        return baseActivity.getDisposer();
    }

    public void loadConsultations() {
        if (NetworkUtils.isConnected()) {

            getDisposer()
                    .add(
                            baseActivity.RXAPI.getAllConsultations(
                                    "",
                                    1,
                                    500)
                                    .subscribe(list -> {
                                        if (list.getSuccess()) {
                                            appointmentArrayList = list.getData();
                                            if (appointmentArrayList != null && appointmentArrayList.size() > 0) {

                                                Collections.reverse(appointmentArrayList);

                                                upcomingAppointments.clear();

                                                for (Consultation appointment : appointmentArrayList) {
                                                    if (appointment.isUpComingAppointment()) {
                                                        upcomingAppointments.add(appointment);
                                                    }
                                                }

                                                loadAppointments(upcomingAppointments);

                                                //root_view.setVisibility(upcomingAppointments.size() > 0 ? VISIBLE : GONE);

                                                if(upcomingAppointments.size()>0){
                                                    lytRootView.setVisibility(VISIBLE);
                                                    tvEmptyState.setVisibility(GONE);
                                                }
                                                else{
                                                    lytRootView.setVisibility(GONE);
                                                    tvEmptyState.setVisibility(VISIBLE);
                                                }

                                                setLabelRange(upcomingAppointments);

                                            } else {
                                                lytRootView.setVisibility(GONE);
                                                tvEmptyState.setVisibility(VISIBLE);
                                            }


                                        } else {
                                            Toasty.error(myContext, "No Appointments are there yet").show();
                                        }
                                    }, LocalUtils::processAPIError)
                    );

        }
        else{
            Toasty.warning(myContext, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
        }
    }

    private void loadDependents(OnValueGot<List<String>> dependentNames) {
        ArrayList<String> dependentsList = new ArrayList<>();
        String name = baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName();
        dependentsList.add(name);

        getDependentsApiCall(dependents -> {
            this.dependents.clear();
            this.dependents.addAll(dependents);

            if (dependents.size() > 0) {
                for (Dependent dependant : dependents) {
                    if (dependant != null && dependant.getName() != null && !dependant.getName().equalsIgnoreCase("")) {
                        dependentsList.add(dependant.getName());
                    }
                }
            }
            dependentNames.gotIt(dependentsList);
        });
    }

    private void getDependentsApiCall(OnValueGot<List<Dependent>> childs) {
        getDisposer().add(
                baseActivity.RXAPI.getAllDependent().subscribe(
                        childs::gotIt,
                        e -> {
                            LocalUtils.processAPIError(e);
                            childs.gotIt(new ArrayList<>());
                        })
        );
    }

    private void firebaseEvent(String type) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty())
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
        }
        catch(Exception ignored){}
    }

    public void setLabelRange(List<Consultation> consultations) {
        int startPos = consultations.size() > 0 ? 1 : 0;
        int endPos = consultations.size();
        numbRangTitle.setText(MessageFormat.format("{0} of {1}", startPos, endPos));
    }

    public void setCustomLabelRange(int s, int e) {
        int startPos = s > 0 ? s : 0;
        int endPos = e > 0 ? e : 0;
        numbRangTitle.setText(MessageFormat.format("{0} of {1}", startPos, endPos));
    }

    public void clearMe(){
        getDisposer().clear();
    }

    public int getFreeCallCount(){
        return noOfFreeCalls;
    }

    public int getNoOfCompletedCalls(){
        return noOfCompletedCalls;
    }
}
