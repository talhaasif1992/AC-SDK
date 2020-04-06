package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.RemoteMessage.NotificationObject;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData1;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.analytics.HitBuilders;

import java.net.HttpURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.push.IntercomPushClient;


public class SplashFragment extends BaseFragment {

    private final IntercomPushClient intercomPushClient = new IntercomPushClient();

    @BindView(R.id.iv_logo)
    ImageView ivLogo;

    AppEventsLogger logger;
    private final int SPLASH_DISPLAY_LENGTH = 3500;
    private View rootView;
    private NavController mainNav;

    // restart app after this seconds if unable to get firebase  during this interval
    private int RESTART_APP_AFTER_SECONDS = 30;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Glide.with(this)
                .load(R.drawable.splash_new)
//                .error(R.drawable.ic_ac_logo2)
//                .placeholder(R.drawable.ic_ac_logo2)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(ivLogo);
        initMe();

    }


    private void initMe(){
        setUp_loading();

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        baseActivity.setupUI(rootView.findViewById(R.id.splash_container), true);

    }

    private void APIWorking() {
//        if (getIntent().hasExtra(EXTRA_IS_FROM_NOTIFICATIONS) && getIntent().getBooleanExtra(EXTRA_MISSED_CALL_NOTIFICATIONS, false)) {
//            NotificationHelper.dismissNotification(getApplicationContext(), NOTIFICATION_OPEN_SPLASH_MISSED_CALL);
//        }

        GenApiLogger.fireNotSignIn();


        if (PrefsHelper.isLoggedIn()) {
            registerIntercomToken();
            registerUserOnIntercom();
            refreshTokenAPI();
        }
        else{
            //                navigateToHomeOrLetsGo();
            MyApp.HANDLER.postDelayed(this::AppVersionChecker, SPLASH_DISPLAY_LENGTH);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            APIWorking();
            MyApp.get().getTracker().send(new HitBuilders.ScreenViewBuilder().build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
//        clearApiStack();
        super.onPause();
    }

    private void registerIntercomToken() {
        getDisposer().add(
                LocalUtils.getFirebaseToken()
                        .subscribe(token -> {
                            Log.wtf("refreshToken", token + "");
                            intercomPushClient.sendTokenToIntercom(MyApp.get(), token);
                        }, LogUtils::e)
        );

    }

    private void registerUserOnIntercom() {
        try {
            if (baseActivity.userData != null) {
                GenApiLogger.fireIntercomeRegisterUser(baseActivity);
            }
        } catch (Exception ignored) {
        }
    }

    private void navigateToHomeOrLetsGo() {

//        ActivityUtils.startActivity(TutorialActivity.class);
        getDisposer().add(
                LocalUtils.getFirebaseToken()
                        .subscribe(token -> {
                            if (BuildConfig.VERSION_CODE > PrefsHelper.getVersionCodeBeforeAppUpdate() || !PrefsHelper.isLoggedIn()) {
                                PrefsHelper.setLastVersionCode(BuildConfig.VERSION_CODE);
                                mainNav.navigate(R.id.action_splashFragment_to_tutorialFragment);
                                return;
                            }


                          //  AppVersionChecker();
                            mainNav.navigate(R.id.action_global_dashboardFragment2);
                        }, LogUtils::e)
        );
    }

    private void refreshTokenAPI() {
        getDisposer().add(
                baseActivity.RXAPI.refreshTokenHeaders(false)
                        .subscribe(pair -> {
                            refreshTokenResponse(pair.second, pair.first);
                        }, e -> {
//                            LocalUtils.processAPIError(e);
                            clearApiStack();
                            clearAndNavToLogin();
                        })
        );
    }

    private void refreshTokenResponse(ResponseData1<UserLogin> responseData, int statusCode) {
        if (statusCode == HttpURLConnection.HTTP_OK) {

            if (responseData.isSuccess()) {
                UserLogin userLogin = responseData.getData();

                PrefsHelper.get(MyApp.get()).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
                PrefsHelper.get(MyApp.get()).putString(Constants.KEY_CHANNEL, userLogin.getChannel());

                if (userLogin.getDependents() != null) {
                    PrefsHelper.get(MyApp.get()).putString(Constants.KEY_DEPENDENTS, GsonUtils.toJson(userLogin.getDependents()));
                }

                UserDataLogin userInfo = userLogin.getUserData();

                if (userInfo != null) {
                    PrefsHelper.get(MyApp.get()).putString(Constants.KEY_PART_OF_PROJECT, StringUtils.null2Length0(userInfo.getPartOfProject()));
                }

                if (userLogin.getOrganization() != null) {
                    MyApp.get().setOrganization(userLogin.getOrganization());
                } else {
                    PrefsHelper.get(MyApp.get()).remove(Constants.KEY_ORGANIZATION);
                }

                if (userLogin.getPolicy() != null) {
                    PrefsHelper.get(MyApp.get()).putString(Constants.KEY_POLICY, GsonUtils.toJson(userLogin.getPolicy()));
                } else {
                    PrefsHelper.get(MyApp.get()).remove(Constants.KEY_POLICY);
                }

                PrefsHelper.setOnPlan(userLogin.isIsOnPlan());

                PrefsHelper.get(MyApp.get()).putBoolean(Constants.KEY_IS_LOGIN, true);
                if(baseActivity.userData!=null) {
                    PrefsHelper.setUserInfo(userInfo);
                }
                else{
                    clearAndNavToLogin();
                }

                navigateToHomeOrLetsGo();
            } else {
                clearAndNavToLogin();
            }
        }else if (statusCode == HttpURLConnection.HTTP_INTERNAL_ERROR) {
            clearAndNavToLogin();
        }else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            clearAndNavToLogin();
            AnalyticsUtils.logEvent(
                    MyApp.get(),
                    "auth_failure",
                    PrefsHelper.get(MyApp.get()).getString("headers", "")
            );
        }else{
            clearAndNavToLogin();
        }
    }

    private void clearAndNavToLogin() {
        PrefsHelper.get(baseActivity).clear();
        if(!NavGraphUtils.getMe(mainNav).isLastDest(R.id.loginFragment)) {
            Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
            mainNav.navigate(R.id.action_global_loginFragment);
        }
    }

    private void AppVersionChecker() {
        getDisposer().add(
                baseActivity.RXAPI.getAppVersion().subscribe(this::processAPI, LocalUtils::processAPIError)
        );
    }

    private void processAPI(NotificationObject notificationObject) {
        if (BuildConfig.VERSION_CODE < notificationObject.getVersionCode()) {
            if (!notificationObject.isEnforced()) {
               // mainNav.navigate(R.id.action_global_dashboardFragment2);
                navigateToHomeOrLetsGo();

//                mainNav.navigate(TutorialFragmentDirections.actionTutorialFragmentToLetsGetYouStartedFragment());
            }
            else{

                mainNav.navigate(SplashFragmentDirections.actionSplashFragmentToUpdateFragment(notificationObject.getMessage()));

            }
        }
        else
        {
            navigateToHomeOrLetsGo();

        }
    }

}