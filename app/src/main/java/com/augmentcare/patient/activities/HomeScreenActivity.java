package com.augmentcare.patient.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import com.amplitude.api.Amplitude;
import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.fragments.TutorialFragmentDirections;
import com.augmentcare.patient.RemoteMessage.NotificationObject;
import com.augmentcare.patient.network.restApi.apimodels.UserInfo;
import com.augmentcare.patient.network.volleyApi.RequestFactory;
import com.augmentcare.patient.utils.Constants;;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;

public class HomeScreenActivity extends BaseActivity {
    @BindView(R.id.toolbarInner)
    Toolbar toolbarWithBack;


    @BindView(R.id.navBarLayout)
    View navBarLayout;

    @BindView(R.id.navigation)
    BottomNavigationView bottomNav;

    @BindView(R.id.btnCenter)
    FloatingActionButton btnCenter;

    @BindView(R.id.homeIv)
    ImageView ivHome;

    @BindView(R.id.tvInnerHome)
    TextView tvInnerHome;

    UserInfo userInfo;

    Trace myTrace;
    String partOfProject;
    private View rootView;

    //String user_role_id = "1718";
    Bundle bundle;
    private NavController navController;
    public NavGraphUtils navUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
        init_me();

        //  TestCampaign();

    }

    private void TestCampaign() {
        // Get tracker.
        Tracker t = MyApp.get().getTracker();

// Set screen name.
        t.setScreenName("HomeScreen");

        String campaignData = "https://play.google.com/store/apps/details?id=com.augmentcare.patient&referrer=utm_source%3Dgoogle%26utm_medium%3Dcpc%26utm_term%3Dpatient%252Bdoctor%26utm_content%3DhealthCare%26utm_campaign%3Dproduct%26anid%3Dadmob";

// Campaign data sent with this hit.
        t.send(new HitBuilders.ScreenViewBuilder()
                .setCampaignParamsFromUrl(campaignData)
                .build()
        );


        t.send(new HitBuilders.EventBuilder()
                .setCategory("Referre_Install")
                .setAction("Install")
                .setLabel("google play Install (Testing)")
                .setValue(1)
                .build());
    }

    @OnLongClick
    public boolean longClickInstantvideoCall() {
        if (PrefsHelper.isOnPlan()) {
            Toasty.error(Utils.getApp(), "Your Temporary Plan is deactivated", Toasty.LENGTH_LONG).show();
        } else {
            Toasty.success(Utils.getApp(), "You are Temporarily On Unlimited Plan Now", Toasty.LENGTH_LONG).show();
        }
        PrefsHelper.setOnPlan(!PrefsHelper.isOnPlan());
        return true;
    }

    @OnClick(R.id.btnCenter)
    public void clickInstantvideoCall() {
        navController.navigate(R.id.instantAppointmentFragment);
    }

    private void navigateToSpecific(Intent intent) {
        if (intent != null) {
            boolean success = navController.handleDeepLink(intent);
        }
    }

    private void init_me() {
        ActivityUtils.finishOtherActivities(HomeScreenActivity.class);

        // #TODO temporary remove after testing
//        PrefsHelper.setOnPlan(true);

        setupNav();

        navUtils = NavGraphUtils.getMe(navController);

        ivHome.setOnClickListener(view -> navController.navigate(R.id.dashboardFragment));

        processDeeplinkingIntent();

    }

    private void processDeeplinkingIntent() {
        navController.handleDeepLink(getIntent());
    }


    private void setupNav() {
        if (navController == null) {
//            if (toolbarHomeWithPic.getNavigationIcon() != null){
//                toolbarHomeWithPic.getNavigationIcon()
//                        .setColorFilter(
//                                getResources().getColor(R.color.white),
//                                PorterDuff.Mode.SRC_ATOP
//                        );
//            }
            toolbarWithBack.setNavigationOnClickListener(v -> {
                onBackPressed();
            });

//            navigationView.setNavigationItemSelectedListener(menuItem -> true);
//
            navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            bundle = new Bundle();
            // navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//            bundle = new Bundle();
//            navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//            NavigationUI.setupActionBarWithNavController(this, navController, drawer);
//            NavigationUI.setupWithNavController(navigationView, navController);

            navController.addOnDestinationChangedListener(this::handleDestinations);

        }

        navigateToSpecific(getIntent());
    }

    private void handleDestinations(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
        //        MyApp.HANDLER.postDelayed(() -> {
        switch (destination.getId()) {
            case R.id.findDoctorFragment:
                showHideBackToolbar(true);
                setToolbarTitle("Find a Doctor");
                showNavBar();
                break;
            case R.id.updateDependentMemberFragment:
                showHideBackToolbar(true);
                setToolbarTitle("Update Dependent");
                break;
            case R.id.consultationPreviewDialogFragment:
            case R.id.refineSearchFragment:
            case R.id.bookAppointmentFragment:
            case R.id.appointmentApprovedFragment:
            case R.id.doctorProfileFragment:
            case R.id.appointmentTypesBottomSheet:
            case R.id.changePasswordBottomSheet:
            case R.id.explorePaymentFragment:
            case R.id.dependentFragment:
            case R.id.appSettingsFragment:
            case R.id.paymentMethodActivity:
            case R.id.instantAppointmentFragment:
            case R.id.appointmentDetailsFragment:
            case R.id.editProfileFragment:
            case R.id.NotificationsFragment:
            case R.id.myAppointmentsFragment:
            case R.id.fileAClaimFragment:
            case R.id.uploadClaimsImages:
            case R.id.confirmClaimFragment:
                showHideBackToolbar(true);
                hideNavBar();
                break;

            case R.id.dashboardFragment:
                showHideBackToolbar(false);
                showNavBar();
                break;

            case R.id.planSelectionFragment:
                showHideBackToolbar(true);
                showNavBar();
                break;
            case R.id.addDependentMemberFragment:
                showHideBackToolbar(true);
                hideNavBar();
                setToolbarTitle("Add Dependent");
                break;

            case R.id.splashFragment:
            case R.id.loginFragment:
            case R.id.signInSignUpActivity:
            case R.id.signUpFragment:
            case R.id.medicinesInfoFragment:
            case R.id.cardSelectionDialogue:
                // sign in sign up flow
            case R.id.signupEmailFragment:
            case R.id.signupEmailFragment2:
            case R.id.signupNamesFragment:
            case R.id.signupPasswordFragment:
            case R.id.myClaimsFragment:
            default:
                showHideBackToolbar(false);
                hideNavBar();
                break;
        }
//        }, 200);
    }


    public void initOld() {

        try {
            Amplitude.getInstance().initialize(this, BuildConfig.AMPLITUDE_KEY).enableForegroundTracking(getApplication());

            GenApiLogger.fireHomeScreenEvent();

            if (userData != null) {
                GenApiLogger.fireRegisterUserOnIntercom(userData);
            }

//            // #TODO planOn should be false
//            PrefsHelper.setOnPlan(false);

            if (myTrace == null) {
                myTrace = FirebasePerformance.getInstance().newTrace("test_trace");
                myTrace.start();
            }
        } catch (Exception ignored) {
        }

//        Type listType = new TypeToken<ArrayList<LabTest>>() {
//        }.getType();
//        MyApp.get().cartItems = GsonUtils.getGson().fromJson(PrefsHelper.get(this).
//                getString(Constants.KEY_CART_TESTS, ""), listType);
//
//        if (MyApp.get().cartItems == null) {
//            MyApp.get().cartItems = new ArrayList<>();
//        }

//        if (PrefsHelper.get(this).contains("otpEmail")) {
//            Intent singupIntent = new Intent(this, SignupFlowActivity.class);
//            singupIntent.putExtra("isSignedUp", true);
//            startActivityForResult(singupIntent, Constants.REQUEST_SIGNUP);
//        }

//        if (BuildConfig.VERSION_CODE > PrefsHelper.get(this).getInt(Constants.KEY_CURRENT_VERSION, 0)
//                || !(PrefsHelper.get(this).getBoolean(Constants.KEY_IS_LOGIN, false))) {
//            PrefsHelper.get(this).putInt(Constants.KEY_CURRENT_VERSION, BuildConfig.VERSION_CODE);
//            Intent intent = new Intent(this, LetsGetYouStartedActivity.class);
//            startActivity(intent);
//          }
    }


    ////////////////////////// Bottom Nav Section ///////////////////////

//    public void initBottomNav(){
//        bottomNav.setOnNavigationItemReselectedListener(menuItem -> {
//
//        });
//    }

    public void onClickHome(MenuItem item) {
        navController.popBackStack(R.id.dashboardFragment, false);
    }

    public void onClickMedicines(MenuItem item) {
        if (!navUtils.isLastDest(R.id.medicinesInfoFragment)) {
            navController.navigate(R.id.medicinesInfoFragment, bundle);
        }
    }

    public void onClickHistory(MenuItem item) {
        if (!navUtils.isLastDest(R.id.myAppointmentsFragment)) {
            navController.navigate(R.id.myAppointmentsFragment, bundle);
        }
    }

    public void onClickSubscription(MenuItem item) {
        if (!navUtils.isLastDest(R.id.planSelectionFragment)) {
            navController.navigate(R.id.planSelectionFragment, bundle);
        }
    }

    //////////////////////////////////////////////////////////////////////


    public void showHideBackToolbar(boolean show) {
        MyApp.HANDLER.postDelayed(() -> {
            toolbarWithBack.setVisibility(show ? View.VISIBLE : View.GONE);
        }, 200);
    }

    public void hideNavBar() {
        navBarLayout.setVisibility(View.GONE);
    }

    public void showNavBar() {
        navBarLayout.setVisibility(View.VISIBLE);
    }


    public void setToolbarTitle(String title) {
        tvInnerHome.setText(title);
    }


    public void logout() {
        try {
            Intercom.client().logout();
            Intercom.client().registerUnidentifiedUser();
            MyApp.get().nullifyUser();
            RequestFactory.setHeaders(null, null, null, null);
        } catch (Exception ignored) {
        }
        PrefsHelper.get(HomeScreenActivity.this).clear();
        PrefsHelper.get(HomeScreenActivity.this).putInt(Constants.KEY_CURRENT_VERSION, BuildConfig.VERSION_CODE);
        PrefsHelper.get(HomeScreenActivity.this).putBoolean(Constants.KEY_IS_LOGIN, false);
        navController.navigate(R.id.action_global_loginFragment);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        if (!PrefsHelper.isRememberMe()) {
            logout();
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        permissionCheckForOverlay();

    }
    private void permissionCheckForOverlay() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (!Settings.canDrawOverlays(getApplicationContext())) {
                Toasty.info(getApplicationContext(),"Please allow display over other apps to access smooth video call experience",Toasty.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getApplicationContext().getPackageName()));
                startActivityForResult(intent, 0);
            }
        }
    }

}