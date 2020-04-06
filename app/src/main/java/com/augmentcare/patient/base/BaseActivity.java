package com.augmentcare.patient.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.adjust.sdk.Adjust;
import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.RxApi;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData1;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.network.volleyApi.RequestFactory;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.SnackbarUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.snackbar.Snackbar;
import com.novoda.merlin.Endpoint;
import com.novoda.merlin.Merlin;

import java.net.HttpURLConnection;

import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;
import io.reactivex.disposables.CompositeDisposable;

import static com.augmentcare.patient.MyApp.SHOW_INTERCOM;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    Snackbar snackbar;
    View childActivityView;
    InputMethodManager inputMethodManager;
    private Merlin merlin;
    private CompositeDisposable COMPOSITE_DISPOSE;
    public RxApi RXAPI;

    public final VolleyAPI VOLLEYAPI = new VolleyAPI();


    private CountDownTimer intercomCountDown;
    private boolean allowActivityExit = true;
    public UserDataLogin userData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        RXAPI = new RxApi(null);
        // #TODO if loading doesn't work uncomment below
//        RXAPI = new RxApi(state -> {
//            try {
//                switch (state) {
//                    case LOADING:
//                        DialogsHelper.Me().showLoader();
//                        break;
//                    case COMPLETE:
//                    case ERROR:
//                    case IDLE:
//                        if(RXAPI.API_COUNT <= 1)
//                            baseActivity.stopLoader();
//                        break;
//                }
//            } catch (Exception e) {
//                LogUtils.e(e);
//            }
//        });

        super.onCreate(savedInstanceState);

        merlin = new Merlin.Builder()
                .withEndpoint(Endpoint.from(BuildConfig.SOCKET_URL))
                .withResponseCodeValidator(responseCode -> responseCode == 200 || responseCode == 302)
                .withAllCallbacks()
                .build(this);

        merlin.registerConnectable(() -> {
            LogUtils.d("Connected");
            MyApp.SET_IS_CONNECTED(true);
            SnackbarUtils.dismiss();
        });

        merlin.registerDisconnectable(() -> {
            LogUtils.d("DisConnected");
            MyApp.SET_IS_CONNECTED(false);
            String msg = "";
            if (!NetworkUtils.isConnected()) {
                msg = getString(R.string.error_no_internet);
            } else {
                msg = getString(R.string.error_check_internet);
            }
            showSnackError(msg, true);
        });

        initMe();
    }

    private void initMe() {
        getUserInfo(userData -> {
            this.userData = userData;
        });
    }

    public CompositeDisposable getDisposer() {
        if (COMPOSITE_DISPOSE == null) {
            COMPOSITE_DISPOSE = new CompositeDisposable();
        }
        return COMPOSITE_DISPOSE;
    }

    @Override
    protected void onPause() {


        try {
            ///////////// Intercom Part ///////////
            AppSocket.getInstance(Utils.getApp()).onPause();
            intercomCountDown = new CountDownTimer(2000, 1000) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {

                    AppSocket.getInstance(Utils.getApp()).onStop();
                }
            };
            intercomCountDown.start();
            ///////////////////////////////////////

            Adjust.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();

        try {
            Adjust.onResume();

            //////////// InterCom Part //////////

            if (SHOW_INTERCOM) {
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE);
            } else {
                Intercom.client().setLauncherVisibility(Intercom.GONE);
            }

            AppSocket.getInstance(Utils.getApp()).onResume();

        /*if (!AppSocket.get(MyApp.this).isConnected()) {
                AppSocket.get(MyApp.this).getSocket().connect();
            }*/

            if (intercomCountDown != null) {
                intercomCountDown.cancel();
            }


            try {
                merlin.bind();
            } catch (Exception e) {
                LogUtils.e(e);
            }
            inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        //////////////////////////////////////

        ////////////////////////////////////
    }

    @Override
    protected void onStop() {
        try {
            merlin.unbind();
        } catch (Exception e) {
//            LogUtils.e(e);
        }

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        clearApiStack();
        super.onDestroy();
    }

//    @Override
//    public void onBackPressed() {
//        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
//
//        boolean handled = false;
//        for (Fragment f : fragmentList) {
//            if (f instanceof BaseFragment) {
//                handled = ((BaseFragment) f).onBackPressed();
//
//                if (handled) {
//                    break;
//                }
//            }
//        }
//
//        if (!handled) {
//            if (getSupportFragmentManager().getBackStackEntryCount() <= 0) {
//                if (allowActivityExit)
//                    finish();
//            } else {
//                super.onBackPressed();
//            }
//
//        }
//    }


    protected void showSnackError(@NonNull String msg, @NonNull String action1Name, @NonNull View.OnClickListener action1Click) {
        try {
            if (childActivityView != null) {
                SnackbarUtils.with(childActivityView)
                        .setMessage(msg)
                        .setDuration(SnackbarUtils.LENGTH_INDEFINITE)
                        .setAction(action1Name, v -> {
                            action1Click.onClick(v);
                            SnackbarUtils.dismiss();
                        }).showError();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void showSnackError(String msg, boolean setCloseButton) {
        try {
            if (childActivityView != null) {
                SnackbarUtils snack =
                        SnackbarUtils.with(childActivityView)
                                .setMessage(msg)
                                .setDuration(SnackbarUtils.LENGTH_INDEFINITE);

                if (setCloseButton) {
                    String closeBtn = getString(R.string.intercom_close);
                    snack.setAction(closeBtn, v -> SnackbarUtils.dismiss());
                }
                snack.showError();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * show SnackBar
     *
     * @param msg            mesg to show
     * @param setCloseButton close button show , if show then snackbar will not auto close
     * @param snackType      1 - SUCESS , 2 - WARNING , any other number - ERROR
     */
    public void showSnack(String msg, boolean setCloseButton, int snackType) {
        try {
            if (childActivityView != null) {
                SnackbarUtils snack =
                        SnackbarUtils.with(childActivityView)
                                .setMessage(msg)
                                .setDuration(setCloseButton ? SnackbarUtils.LENGTH_INDEFINITE : SnackbarUtils.LENGTH_SHORT);

                if (setCloseButton) {
                    String closeBtn = getString(R.string.intercom_close);
                    snack.setAction(closeBtn, v -> SnackbarUtils.dismiss());
                }
                if (snackType == 1) {
                    snack.showSuccess();
                } else if (snackType == 2) {
                    snack.showWarning();
                } else {
                    snack.showError();
                }
                snack.showError();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setupUI(View view, boolean IsChildActivityView) {
        if (IsChildActivityView) {
            childActivityView = view;
        }
        //setFont(view);

        //Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView, IsChildActivityView);
            }
        }
    }

    public void showLoader(){
        View view = findViewById(R.id.loadingRL);
        if(view != null){
            view.setVisibility(View.VISIBLE);
        }
        MyApp.HANDLER.postDelayed(this::stopLoader,40 * 1000);
    }

    public void stopLoader(){
        if(RXAPI.API_COUNT > 0){
            MyApp.HANDLER.postDelayed(this::stopLoader,5 * 1000);
            return;
        }

        View view = findViewById(R.id.loadingRL);
        if(view != null){
            view.setVisibility(View.GONE);
        }
    }


    //////////////// APP dependent //////////////////

    public void refreshTokenAPIRequest(OnValueGot<Boolean> done) {
        getDisposer().add(
                RXAPI.refreshTokenHeaders(false)
                        .subscribe(pair -> {
                            refreshTokenResponse(pair.second, pair.first);
                            done.gotIt(true);
                        }, e -> {
                            LocalUtils.processAPIError(e);
                            done.gotIt(false);
                        })
        );
    }
    public void refreshTokenAPIRequest() {
        getDisposer().add(
                RXAPI.refreshTokenHeaders(false)
                        .subscribe(pair -> {
                            refreshTokenResponse(pair.second, pair.first);
                        }, LocalUtils::processAPIError)
        );
    }

    private void refreshTokenResponse(ResponseData1<UserLogin> responseData, int statusCode) {
        if (statusCode == HttpURLConnection.HTTP_OK) {

            if (responseData.isSuccess()) {
                UserLogin userLogin = responseData.getData();

                PrefsHelper.get(this).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
                PrefsHelper.get(this).putString(Constants.KEY_CHANNEL, userLogin.getChannel());

                if (userLogin.getDependents() != null) {
                    PrefsHelper.get(this).putString(Constants.KEY_DEPENDENTS, GsonUtils.toJson(userLogin.getDependents()));
                }

                UserDataLogin userInfo = userLogin.getUserData();

                if (userInfo != null) {
                    PrefsHelper.get(this).putString(Constants.KEY_PART_OF_PROJECT, StringUtils.null2Length0(userInfo.getPartOfProject()));
                }

                if (userLogin.getOrganization() != null) {
                    MyApp.get().setOrganization(userLogin.getOrganization());
                } else {
                    PrefsHelper.get(this).remove(Constants.KEY_ORGANIZATION);
                }

                if (userLogin.getPolicy() != null) {
                    PrefsHelper.get(this).putString(Constants.KEY_POLICY, GsonUtils.toJson(userLogin.getPolicy()));
                } else {
                    PrefsHelper.get(this).remove(Constants.KEY_POLICY);
                }

                PrefsHelper.setOnPlan(userLogin.isIsOnPlan());

              //  PrefsHelper.setOnPlan(userLogin.isFromOrganization());


                PrefsHelper.get(this).putBoolean(Constants.KEY_IS_LOGIN, true);
                if(userData!=null) {
                    PrefsHelper.setUserInfo(userInfo);
                }
                else{
                    PrefsHelper.get(this).clear();
                    Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                }
            } else {
                PrefsHelper.get(this).clear();
            }
        }
//        if (statusCode == HttpURLConnection.HTTP_INTERNAL_ERROR) {
//        }
//        if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
        else{
            AnalyticsUtils.logEvent(
                    this,
                    "auth_failure",
                    PrefsHelper.get(this).getString("headers", "")
            );

            try {
                Intercom.client().logout();
                Intercom.client().registerUnidentifiedUser();
                MyApp.get().nullifyUser();
                RequestFactory.setHeaders(null, null, null, null);
            } catch (Exception ignored) {
            }
            PrefsHelper.get(this).clear();
            PrefsHelper.get(this).putInt(Constants.KEY_CURRENT_VERSION, BuildConfig.VERSION_CODE);
            PrefsHelper.get(this).putBoolean(Constants.KEY_IS_LOGIN, false);
            try {
                Navigation.findNavController(this,R.id.main_navigation).navigate(R.id.action_global_loginFragment);
            } catch (Exception e) {
            }

        }
    }

    public void getUserInfo(OnValueGot<UserDataLogin> got) {
        String uInfo = PrefsHelper.get(MyApp.get()).getString(Constants.KEY_USER_DATA, "");
        UserDataLogin userDataLogin = GsonUtils.getGson().fromJson(uInfo, UserDataLogin.class);

        if(userDataLogin != null && got != null){
            got.gotIt(userDataLogin);
        }else{
            refreshTokenAPIRequest(validated -> {
                if (!validated && userData == null) {
                    PrefsHelper.get(this).clear();
                    NavController navController = null;
                    try {
                        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
                    } catch (Exception e) {
                    }
                    if(navController != null) {
                        if(!NavGraphUtils.getMe(navController).isLastDest(R.id.loginFragment)) {
                            Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                            navController.navigate(R.id.action_global_loginFragment);
                        }
                    }else{
                        finish();
                    }
                }else{
                    if(got != null)
                        got.gotIt(userDataLogin);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void clearApiStack() {
        getDisposer().clear();
        stopLoader();
    }
}