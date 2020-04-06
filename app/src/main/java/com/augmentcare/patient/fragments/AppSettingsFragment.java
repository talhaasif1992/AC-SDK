package com.augmentcare.patient.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.AboutActivity;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.activities.TermAndConditionActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.RequestFactory;
import com.augmentcare.patient.notifications.NotificationHelper;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppSettingsFragment extends BaseFragment implements View.OnClickListener{


    private TextView btn_change_password;
    private TextView btn_payment_methods;
  //  private TextView btn_payment_methods1;
    private TextView btn_invite_friends;
    private TextView btn_about_augmentcare;
    private TextView btn_faqs;
    private TextView btn_privacy_policy;
    private TextView tv_account;
    private TextView btn_sign_out;

    private View rootView;
    private NavController navController;

    String title = "";


    public AppSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_app_settings, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Settings");

        initi(view);
    }

    private void initi(View view) {

        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        TextView btn_edit_profile = view.findViewById(R.id.btn_edit_profile);
        btn_change_password = view.findViewById(R.id.btn_change_password);
        btn_payment_methods = view.findViewById(R.id.btn_payment_methods);
        btn_invite_friends = view.findViewById(R.id.btn_invite_friends);
        btn_about_augmentcare = view.findViewById(R.id.btn_about_augmentcare);
        TextView btn_help_and_support = view.findViewById(R.id.btn_help_and_support);
        btn_faqs = view.findViewById(R.id.btn_faqs);
        btn_privacy_policy = view.findViewById(R.id.btn_privacy_policy);
        tv_account = view.findViewById(R.id.tv_account);
        btn_sign_out = view.findViewById(R.id.btn_sign_out);


        btn_edit_profile.setOnClickListener(this);
        btn_change_password.setOnClickListener(this);
        btn_payment_methods.setOnClickListener(this);
        btn_invite_friends.setOnClickListener(this);
        btn_about_augmentcare.setOnClickListener(this);
        btn_help_and_support.setOnClickListener(this);
        btn_faqs.setOnClickListener(this);
        btn_privacy_policy.setOnClickListener(this);
        tv_account.setOnClickListener(this);
        btn_sign_out.setOnClickListener(this);


        getUserInfo(userDataLogin -> {
            baseActivity.userData = userDataLogin;
            try {
                if(LocalUtils.getOr(baseActivity.userData.getProvider(),"").contains("google")){
                    btn_change_password.setVisibility(View.GONE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_edit_profile:
                navController.navigate(AppSettingsFragmentDirections.actionAppSettingsFragmentToEditProfileFragment());
                break;
            case R.id.btn_change_password:
                navController.navigate(AppSettingsFragmentDirections.actionAppSettingsFragmentToChangePasswordBottomSheet());
                break;
            case R.id.btn_payment_methods:

//                navController.navigate(AppSettingsFragmentDirections
//                        .actionAppSettingsFragmentToCreditCardFragment()
//                        .setIsFromSettings(true)
//                );

                navController.navigate(R.id.paymentMethodActivity);
                break;
                case R.id.btn_invite_friends:

                shareAppWithFriends(baseActivity);

                break;
            case R.id.btn_about_augmentcare:

                String url = "https://www.augmentcare.com/about-us/";
                title = "About";
                Intent i = new Intent(baseActivity, AboutActivity.class);
                i.putExtra("url", url);
                i.putExtra("title", title);
                startActivity(i);

                break;
            case R.id.btn_help_and_support:

//                url = "http://help.augmentcare.com";
//                title = "Help and Support";
//                i = new Intent(baseActivity, AboutActivity.class);
//                i.putExtra("url", url);
//                i.putExtra("title", title);
//                startActivity(i);
                Intercom.client().displayConversationsList();


                break;
            case R.id.btn_faqs:
                break;

            case R.id.btn_privacy_policy:
                 startActivity(new Intent(getActivity(), TermAndConditionActivity.class));
                break;
            case R.id.btn_sign_out:
                signOutServiceCall();
                break;


        }

    }

    private void signOutServiceCall() {
        getDisposer().add(
                LocalUtils.getFirebaseToken()
                        .flatMap(v -> baseActivity.RXAPI.signOut(v))
                        .subscribe(doctorDetail -> {
                            NotificationHelper.dismissNotificationAll(baseActivity);
                            ((HomeScreenActivity) baseActivity).logout();
                        }, e -> {
                            LogUtils.e(e);
                            if(e != null) {
                                Toasty.error(Utils.getApp(), StringUtils.null2Length0(e.getMessage()), Toast.LENGTH_LONG, false).show();
                            }
                            ((HomeScreenActivity) baseActivity).logout();
                        })
        );
    }

    private void logout() {
        try {
            Intercom.client().logout();
            Intercom.client().registerUnidentifiedUser();
            MyApp.get().nullifyUser();
            PrefsHelper.get(baseActivity).remove(Constants.KEY_USER_INFO);
            PrefsHelper.get(baseActivity).remove(Constants.KEY_USER_DATA);
            PrefsHelper.get(baseActivity).remove("headers");
            PrefsHelper.get(baseActivity).clear();
            RequestFactory.setHeaders(null, null, null, null);
            PrefsHelper.get(baseActivity).putInt(Constants.KEY_CURRENT_VERSION, BuildConfig.VERSION_CODE);
            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, false);

            baseActivity.getIntent().removeExtra("isForcedLogout");
            baseActivity.finish();
//            startActivity(HomeScreenActivity.this.getIntent());
            startActivity(new Intent(baseActivity, LoginFragment.class));
        } catch (Exception ignored) {
        }
    }

    public void shareAppWithFriends(Context context) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hello, I am using AugmentCare to book doctor appointments and order medicines\n Get the app here: https://play.google.com/store/apps/details?id=" + context.getPackageName());
        context.startActivity(Intent.createChooser(sharingIntent, "Share Using"));
    }
}
