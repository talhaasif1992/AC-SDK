package com.augmentcare.patient.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.ClickInterface;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.APlan;
import com.augmentcare.patient.network.restApi.apimodels.GenericResponse;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.subcription_model.SubcriptionAdapter;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;

public class PlanSelectionFragment extends BaseFragment implements ClickInterface {

    NavController navController;
    String redirectTo;
    View rootView;
    RecyclerView subcription_list_rv;
    public ArrayList<APlan> aPlanArrayList = new ArrayList<APlan>();
    SubcriptionAdapter subcriptionAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.activity_plan_selection, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Plan Selection");


        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        setBackPress(false, () -> {
            navController.popBackStack(R.id.dashboardFragment,false);
        });

        subcription_list_rv = rootView.findViewById(R.id.subscribe_RV);
        subcription_list_rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(baseActivity);
        subcription_list_rv.setLayoutManager(layoutManager);


        if (PrefsHelper.isFromOrganization()) {
            getUserCurrentPlan();
        } else {
            getPlans();
        }


        if (baseActivity.getIntent() != null && baseActivity.getIntent().hasExtra("redirectTo")) {
            redirectTo = baseActivity.getIntent().getStringExtra("redirectTo");
        }


        if (baseActivity.getIntent().hasExtra("alertdialogShowFlag") && baseActivity.getIntent().getStringExtra("alertdialogShowFlag").equals("notShow"))
            return;

        if (!PrefsHelper.isOnPlan() && !PrefsHelper.isFromOrganization()) {
            ViewUtils.showConfirmDialog(baseActivity, "You need to buy a plan",
                    "In order to access instant doctors and book appointments instantly, please subscribe to one of our well crafted plans."
                    , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
        }

        try {
            if (!String.valueOf(baseActivity.userData.getUserId()).equalsIgnoreCase("")) {
                GenApiLogger.fireIntercomPlanSelection(baseActivity);
            }

            GenApiLogger.fireSubscriptionScreen(baseActivity,"subscription_screen");

            //firebaseEvent("subscription_screen");
        } catch (Exception ignored) {
        }
    }

    private void getPlans() {
        getDisposer().add(
                baseActivity.RXAPI.subcriptionPlan().subscribe(this::showPlans, LocalUtils::processAPIError)
        );

    }

    private void getUserCurrentPlan() {
        getDisposer().add(
                baseActivity.RXAPI.getUserCurrentPlan().subscribe(this::showCurrentPlans, LocalUtils::processAPIError)

        );

    }

    private void showCurrentPlans(GenericResponse plan) {
        if(plan.getUser_plans() != null) {
            showPlans(plan.getUser_plans().getPlan());
        }else{
            getPlans();
        }
    }


    private void showPlans(List<APlan> aPlans) {

        aPlanArrayList.clear();

        for (int i = 0; i < aPlans.size(); i++) {
            aPlanArrayList.add(
                    new APlan(aPlans.get(i).getId(),
                            StringUtils.null2Length0(aPlans.get(i).getName()),
                            LocalUtils.getOr(aPlans.get(i).getPrice(), 0.0),
                            LocalUtils.getOr(aPlans.get(i).getDuration(), 0),
                            LocalUtils.getOr(aPlans.get(i).isStatus(), false),
                            LocalUtils.getOr(aPlans.get(i).getDescriptionList(), new ArrayList<>()),
                            StringUtils.null2Length0(aPlans.get(i).getPlanType()),
                            StringUtils.null2Length0(aPlans.get(i).getDescription()),
                            StringUtils.null2Length0(aPlans.get(i).getCurrency_code())));
        }
        subcriptionAdapter = new SubcriptionAdapter(aPlanArrayList, baseActivity, this);
        subcription_list_rv.setAdapter(subcriptionAdapter);

    }

    private void showPlans(APlan aPlans) {

        aPlanArrayList.clear();


        aPlanArrayList.add(
                new APlan(aPlans.getId(),
                        StringUtils.null2Length0(aPlans.getName()),
                        LocalUtils.getOr(aPlans.getPrice(), 0.0),
                        LocalUtils.getOr(aPlans.getDuration(), 0),
                        LocalUtils.getOr(aPlans.isStatus(), false),
                        LocalUtils.getOr(aPlans.getDescriptionList(), new ArrayList<>()),
                        StringUtils.null2Length0(aPlans.getPlanType()),
                        StringUtils.null2Length0(aPlans.getDescription()),
                        StringUtils.null2Length0(aPlans.getCurrency_code())));
        subcriptionAdapter = new SubcriptionAdapter(aPlanArrayList, baseActivity, this);
        subcription_list_rv.setAdapter(subcriptionAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        //   baseActivity.VOLLEYAPI.addRequest(baseActivity, VolleyAPI.TYPE_SUBSCRIPTION_PLANS, new JsonObject(), this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // onBackPressed();
        }

        if (item.getItemId() == R.id.action_help) {
            try {
                if (PrefsHelper.get(baseActivity).getBoolean(Constants.KEY_IS_LOGIN, false)) {
                    GenApiLogger.firePlanSelectionEvent(baseActivity);

                } else {
//                    Intent intentSignin = new Intent(baseActivity, LoginWithCodeActivity.class);
//                    startActivityForResult(intentSignin, Constants.REQUEST_SIGNIN);

                    navController.navigate(R.id.action_global_loginFragment);
                }
            } catch (Exception ignored) {
            }
            Intercom.client().displayConversationsList();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void clickItem(String id1, String name, String position) {


        if (name.equalsIgnoreCase("Cancel Subscription")) {
            cancelSubscription(Integer.parseInt(id1));

        } else if (name.equalsIgnoreCase("Promo")) {
            navController.navigate(
                    PlanSelectionFragmentDirections
                            .actionPlanSelectionFragmentToAddCardFragment()
                            .setAddCardFlagToggle(false)
            );

        } else {

            Bundle b = new Bundle();

            b.putString("name", aPlanArrayList.get(Integer.parseInt(position)).getName());
            b.putDouble("price", aPlanArrayList.get(Integer.parseInt(position)).getPrice());
            b.putString("currency", aPlanArrayList.get(Integer.parseInt(position)).getCurrency_code());
            b.putString("plan_id", String.valueOf(aPlanArrayList.get(Integer.parseInt(position)).getId()));
            navController.navigate(R.id.subscriptionPaymentFragment, b);
        }
    }


    private void cancelSubscription(int id) {
        getDisposer().add(
                baseActivity.RXAPI.cancelPlan(id)
                        .subscribe(sent -> {
                            AnalyticsUtils.logEvent(baseActivity, FirebaseEvents.PLAN_CANCELLED, null);
                            Toasty.info(baseActivity, "" + sent.getMessage(), Toasty.LENGTH_LONG).show();
                            PlanSelectionFragment.this.updateUser(() -> {
                                navController.popBackStack(R.id.dashboardFragment, false);
                            });
                        }, e -> {
                            try {
                                Toasty.error(baseActivity, e.getMessage().replace("\"", ""), 5000, false).show();
                            } catch (Exception ignored) {
                                Toasty.error(baseActivity, "Error! Please try again later. If issue persists contact administrator.", Toast.LENGTH_LONG, false).show();
                            }
                        })
        );


    }

    private void updateUser(Runnable done) {

        getDisposer().add(
                baseActivity.RXAPI.updateUserProfile(
                        new UserInfoUpdateRequest()
                                .withHistory(true)
                                .withId(NumberUtils.toInt(baseActivity.userData.getId()))
                                .withUserType("patient")
                ).subscribe(userInfo -> {
                    //attemptLogin();
//                    Toast.makeText(baseActivity,"API Called",Toast.LENGTH_LONG).show();
                    done.run();
                }, e -> {
                    LogUtils.e(e);
                    if (NetworkUtils.isConnected()) {
                        Toasty.error(baseActivity, R.string.error_message_failed_to_login, Toast.LENGTH_LONG, false).show();
                    } else {
                        Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
                    }
                })
        );
    }


}