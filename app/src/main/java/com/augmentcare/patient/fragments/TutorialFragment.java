package com.augmentcare.patient.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.RemoteMessage.NotificationObject;
import com.augmentcare.patient.adapters.CustomViewPager;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class TutorialFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.vpTutorial)
    CustomViewPager vpTutorial;

    @BindView(R.id.btnNext)
    View btnNext;

    @BindView(R.id.btnSkip)
    View btnSkip;

    @BindView(R.id.btnNextStep)
    View btnNextStep;

    @BindView(R.id.progressContent)
    View progressContent;

    @BindView(R.id.contentFrame)
    View contentFrame;

    @BindView(R.id.btnStart)
    View btnStart;

    @BindView(R.id.arrowBack)
    ImageView back;
    private View rootView;
    private TutorialFragmentArgs args;
    private NavController mainNav;

    private FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();

    String[] PERMISSIONS_OVERALL = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.DISABLE_KEYGUARD,
            Manifest.permission.VIBRATE,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tutorial, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);
        initMe();


    }

    private void initMe() {
        loadArgs();

        handleBackPress();


        // TODO set full screen

        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        if (args.getIsEnd()) {
            vpTutorial.setCurrentItem(NUM_PAGES);
        }

        vpTutorial.setAdapter(new ScreenSlidePagerAdapter(baseActivity.getSupportFragmentManager()));
        firebaseEvent("tutorial_screen");

        vpTutorial.setPagingEnabled(false);
        vpTutorial.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AnalyticsUtils.tutorialPage(baseActivity, "Screen_" + position);
                if (position == NUM_PAGES - 2) {
                    back.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // TabLayout tabLayout = findViewById(R.id.tlDots);
        // tabLayout.setupWithViewPager(vpTutorial, true);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int pos = vpTutorial.getCurrentItem() + 1;
                //vpTutorial.setCurrentItem(pos);
                btnStart.callOnClick();
            }
        });
        btnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = vpTutorial.getCurrentItem() + 1;
                vpTutorial.setCurrentItem(pos);
                if (pos == 3) {
                    btnStart.callOnClick();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = vpTutorial.getCurrentItem() - 1;
                vpTutorial.setCurrentItem(pos);
                if (pos == 0) {
                    back.setVisibility(View.GONE);
                }
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.callOnClick();
            }
        });

        btnStart.setOnClickListener(view -> {
            if (EasyPermissions.hasPermissions(baseActivity, PERMISSIONS_OVERALL)) {

                AppVersionChecker();
                // mainNav.navigate(TutorialFragmentDirections.actionTutorialFragmentToLetsGetYouStartedFragment());



            } else {
                EasyPermissions.requestPermissions(
                        TutorialFragment.this,
                        "Please provide all permission for app to work properly",
                        100,
                        PERMISSIONS_OVERALL
                );





            }
        });

        // performing click so tutorial won't show
        // btnSkip.performClick();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        try {
            if (mainNav != null)
                mainNav.navigate(TutorialFragmentDirections.actionTutorialFragmentToLetsGetYouStartedFragment());
        }catch(Exception e){}
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setTitle(getString(R.string.title_settings_dialog))
                    .setRationale(getString(R.string.rationale_ask_again))
                    .setPositiveButton("OK")
                    .setNegativeButton("CANCEL")
                    .setRequestCode(100)
                    .build()
                    .show();
        }
    }

    private void handleBackPress() {
        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                ActivityUtils.finishAllActivities();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = TutorialFragmentArgs.fromBundle(getArguments());
        }

    }

    private static final int NUM_PAGES = 3;

//    @Override
//    public void onWebResponseListner(int tag, int statusCode, JsonObject response) {
//        if (statusCode == HttpURLConnection.HTTP_OK) {
//            if (tag == VolleyAPI.TYPE_VERSION_CHECK) {
//
//                try {
//                    PrefsHelper.get(MyApp.get()).putBoolean(Constants.KEY_FORCE_UPDATE, response.get("enforced").getAsBoolean());
//                    PrefsHelper.get(MyApp.get()).putInt(Constants.KEY_VERSION, response.get("versionCode").getAsInt());
//                    PrefsHelper.get(MyApp.get()).putString(Constants.KEY_MESSAGE, response.get("message").getAsString());
//                    if (BuildConfig.VERSION_CODE < response.get("versionCode").getAsInt()) {
//                        mainNav.navigate(
//                                TutorialFragmentDirections.actionTutorialFragmentToUpdateFragment(
//                                        response.get("message").getAsString()
//                                ).setEnforced(response.get("enforced").getAsBoolean())
//                        );
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    @Override
//    public void onFragmentInteraction(int what) {
//
//    }
//
//    @Override
//    public void onFragmentInteraction(int what, Bundle bundle) {
//
//    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        @SuppressLint("WrongConstant")
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public static class ScreenSlidePageFragment extends Fragment {
        public static ScreenSlidePageFragment newInstance(int index) {
            Bundle args = new Bundle();
            args.putInt("index", index);
            ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
            fragment.setArguments(args);
            return fragment;
        }

        private TextView tvContentToBe;
        private TextView txtBody;
        private TextView txtHeading;
        private ImageView ivBackground;
        private Button mSubscribeButton;
        private LinearLayout mButtonLinearLayout, mImageLayout, mTextLinearLayout;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_tutorial_new, container, false);
            txtHeading = view.findViewById(R.id.txtHeading);
            txtBody = view.findViewById(R.id.tv);
            ivBackground = view.findViewById(R.id.image);
            tvContentToBe = view.findViewById(R.id.tv_to_be);
            mTextLinearLayout = view.findViewById(R.id.text_linearlayout);
            mButtonLinearLayout = view.findViewById(R.id.button_linearlayout);
            mImageLayout = view.findViewById(R.id.view_image_layout);
            mSubscribeButton = view.findViewById(R.id.subscribe_button);
            int index = getArguments().getInt("index");
            switch (index) {
                case 0:
                    try {
                        mTextLinearLayout.setVisibility(View.GONE);
                        mButtonLinearLayout.setVisibility(View.GONE);
                        txtHeading.setVisibility(View.GONE);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1.85f);
                        mImageLayout.setLayoutParams(params);
                        tvContentToBe.setText(" Immediate Medical Aid Now in the Palm of your Hand. Secure a video call with a doctor and get advice for your medical needs instantly");
                        txtBody.setText("Talk to our Instant Doctors \n within minutes");
                        ivBackground.setBackgroundResource(R.drawable.ic_1);
                    } catch (Exception ignored) {
                    }
                    break;
                case 1:
                    try {
                        mTextLinearLayout.setVisibility(View.GONE);
                        mButtonLinearLayout.setVisibility(View.GONE);
                        txtHeading.setVisibility(View.GONE);
                        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1.85f);
                        mImageLayout.setLayoutParams(params1);
                        tvContentToBe.setText("Skip the waiting line and get access to the urgent care you need from PMDC certified doctors without any delay. Talk to qualified doctors in your preferred language (Urdu, English) and get continued care wherever and whenever you want");
                        txtBody.setText("Unlimited Video Calls");
                        ivBackground.setBackgroundResource(R.drawable.ic_artboard_1);
                    } catch (Exception ignored) {
                    }
                    break;
                case 2:
                    try {
                        mTextLinearLayout.setVisibility(View.GONE);
                        txtHeading.setVisibility(View.GONE);
                        mButtonLinearLayout.setVisibility(View.VISIBLE);
//                    btnStart.setVisibility(View.GONE);
                        tvContentToBe.setText("Choose from two different packages to suit your and your family needs");
                        txtBody.setText("Subscribe to \n Exciting Packages");
                        ivBackground.setBackgroundResource(R.drawable.ic_3);
                    } catch (Exception ignored) {
                    }
                    break;
            }
            mSubscribeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //      startActivity(new Intent(getActivity(), PlanSelectionActivity.class));
                }
            });
            return view;
        }
    }

    /**
     * @param type
     */
    private void firebaseEvent(String type) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty())
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
        } catch (Exception ignored) {
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
                mainNav.navigate(TutorialFragmentDirections.actionTutorialFragmentToLetsGetYouStartedFragment());
            } else {

                mainNav.navigate(TutorialFragmentDirections.actionTutorialFragmentToUpdateFragment(notificationObject.getMessage()));
            }
        }
        else
        {
            mainNav.navigate(TutorialFragmentDirections.actionTutorialFragmentToLetsGetYouStartedFragment());

        }
    }
}