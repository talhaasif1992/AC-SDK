package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.SimpleDividerItemDecoration;
import com.augmentcare.patient.adapters.UserClaimsAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.model.ClaimDetail;
import com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel.Policy;
import com.augmentcare.patient.network.restApi.apimodels.GetUserClaimsList;
import com.augmentcare.patient.network.restApi.apimodels.UserClaims;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.tabs.TabLayout;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class MyClaimsFragment extends BaseFragment implements UserClaimsAdapter.OnItemClickListener{

    private View rootView;

    @BindView(R.id.tvAvailableAllowance)
    TextView tvAvailableAllowance;

    @BindView(R.id.rlContentView)
    View contentFrame;

    @BindView(R.id.tvTotalAllowanceLimit)
    TextView tvTotalAllowanceLimit;

    @BindView(R.id.btnFileAClaim)
    RelativeLayout btnFileAClaim;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.tv_empty_state)
    TextView tvEmptyState;

    @BindView(R.id.recylerViewUserClaims)
    RecyclerView recylerViewUserClaims;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.homeIv)
    ImageView ivHome;

    private UserClaimsAdapter userClaimsAdapter;
    private GetUserClaimsList userClaims;
    private List<Policy> policies;
    Double remainingDays;
    private ArrayList<UserClaims.ReimbursementsEntity> manualUserClaimsArrayList = new ArrayList<>();
    private ArrayList<UserClaims.ReimbursementsEntity> digitalUserClaimsArrayList = new ArrayList<>();
    private float availableLimit;

    public MyClaimsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //rootView = inflater.inflate(R.layout.layout_my_claims, container, false);
        rootView = inflater.inflate(R.layout.fragment_claims_dashboard, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recylerViewUserClaims.setLayoutManager(linearLayoutManager);
        //recylerViewUserClaims.addItemDecoration(new SimpleDividerItemDecoration(baseActivity));
        userClaimsAdapter = new UserClaimsAdapter(manualUserClaimsArrayList);
        recylerViewUserClaims.setAdapter(userClaimsAdapter);
        userClaimsAdapter.setOnItemClickListener(MyClaimsFragment.this);
        tabLayout.addTab(tabLayout.newTab().setText("Manual Claims"));
        tabLayout.addTab(tabLayout.newTab().setText("Digital Claims"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        toolbar.setNavigationOnClickListener(v -> {
            baseActivity.onBackPressed();
        });
        ivHome.setOnClickListener(view -> {
            safeNavigateTo(navController->{
                navController.navigate(R.id.dashboardFragment);
            });
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    // Manual Claim
                    if(manualUserClaimsArrayList.size()<=0){
                        recylerViewUserClaims.setVisibility(View.INVISIBLE);
                        tvEmptyState.setVisibility(View.VISIBLE);
                    }
                    else {
                        recylerViewUserClaims.setVisibility(View.VISIBLE);
                        tvEmptyState.setVisibility(View.INVISIBLE);
                        userClaimsAdapter = new UserClaimsAdapter(manualUserClaimsArrayList);
                        recylerViewUserClaims.setAdapter(userClaimsAdapter);
                        userClaimsAdapter.setOnItemClickListener(MyClaimsFragment.this);
                    }
                }else{
                    // Digital Claim
                    if(digitalUserClaimsArrayList.size()<=0){
                        recylerViewUserClaims.setVisibility(View.INVISIBLE);
                        tvEmptyState.setVisibility(View.VISIBLE);
                    }
                    else {
                        recylerViewUserClaims.setVisibility(View.VISIBLE);
                        tvEmptyState.setVisibility(View.INVISIBLE);
                        userClaimsAdapter = new UserClaimsAdapter(digitalUserClaimsArrayList);
                        recylerViewUserClaims.setAdapter(userClaimsAdapter);
                        userClaimsAdapter.setOnItemClickListener(MyClaimsFragment.this);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnFileAClaim.setOnClickListener(v -> {
            if (userClaims!=null && userClaims.getAvailableBalance()!=null && userClaims.getAvailableBalance() > 0) {
                safeNavigateTo(navController -> {
                    navController.navigate(
                            MyClaimsFragmentDirections.actionMyClaimsFragmentToFileAClaimFragment(availableLimit)
                    );
                });
            } else {
                Toasty.error(Utils.getApp(), R.string.claim_insufficient_balance, Toast.LENGTH_LONG, false).show();
            }

            try {
                if (baseActivity.userData.getId() != null && baseActivity.userData.getId().isEmpty())
                    FirebaseLogger.viewFirebaseLogEvent("file_a_claim", baseActivity.userData.getId());
            } catch (Exception ignored) {
            }
        });

        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty())
                FirebaseLogger.viewFirebaseLogEvent("previous_claim", baseActivity.userData.getId());
        } catch (Exception ignored) {
        }

        getUserClaimsApiCall();
    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public long printDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);

        return elapsedDays;
    }

    public void getUserClaimsApiCall() {
        getDisposer().add(

                baseActivity.RXAPI.getClaimByUser(baseActivity.userData.getUserId())
                        .subscribe(jutt -> {
                            userClaims = jutt;
                            processData(jutt);
                        }, e -> {
                            LogUtils.e(e);
                            Toasty.error(Utils.getApp(), e.getMessage(), Toast.LENGTH_LONG, false).show();
                        }));
    }


    private void processData(GetUserClaimsList userClaims) {
        if (userClaims != null) {
            try {
                digitalUserClaimsArrayList.clear();
                manualUserClaimsArrayList.clear();


                if (userClaims.getUserPolicy().get(0).getPolicyAvailableAllowance() > 0) {
                    float tempLimit = (float)userClaims.getUserPolicy().get(0).getPolicyAvailableAllowance();

                    int finalPrice = 0;
                    for (int i = 0; i < userClaims.getReimbursements().size(); i++) {
                        if (userClaims.getReimbursements().get(i).getStatus().equals("accepted") ||
                                userClaims.getReimbursements().get(i).getStatus().equals("partial")) {
                            finalPrice += userClaims.getReimbursements().get(i).getFinalAmount();
                        }

                    }

                    float finalPrice1 = tempLimit - finalPrice;

                    tvAvailableAllowance.setText(MessageFormat.format("Rs. {0}", round((finalPrice1), 2)));
                    tvTotalAllowanceLimit.setText(MessageFormat.format("Rs. {0}", round(tempLimit, 2)));
                    manualUserClaimsArrayList.addAll(userClaims.getReimbursements());
                    digitalUserClaimsArrayList.addAll(userClaims.getDigitalClaims());
                    userClaimsAdapter = new UserClaimsAdapter(manualUserClaimsArrayList);
                    recylerViewUserClaims.setAdapter(userClaimsAdapter);
                    userClaimsAdapter.setOnItemClickListener(MyClaimsFragment.this);
                    userClaimsAdapter.notifyDataSetChanged();
                    availableLimit = finalPrice1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClaimClick(int position, UserClaims.ReimbursementsEntity claim){
        Bundle b = new Bundle();
        b.putSerializable("data", claim);

        safeNavigateTo(navController -> {
            navController.navigate(
                    R.id.claimDetailsFragment,b
            );
        });
    }
}
