package com.augmentcare.patient.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.AppointmentsHistoryView;
import com.augmentcare.patient.model.appointmentModel.Appointment;
import com.augmentcare.patient.network.restApi.apimodels.FreeCallModel.FreeCallModel;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.viewmodels.FindDoctorVM;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class DashboardFragment extends BaseFragment implements OnRecyclerItemClickListener<Appointment>{

    @BindView(R.id.txtName)
    TextView txtName;

    @BindView(R.id.ivUserPic)
    CircularImageView ivUserPic;

    @BindView(R.id.profilePicIV)
    de.hdodenhof.circleimageview.CircleImageView profilePicIV;

    @BindView(R.id.layout_lytInstantDoctor)
    View lytInstantDoctor;

    @BindView(R.id.layout_lytDoctors)
    View lytDoctors;

    @BindView(R.id.lytLabs)
    View lytLabs;

    @BindView(R.id.lytMedicines)
    View lytMedicines;

    @BindView(R.id.ahv_upcomming)
    AppointmentsHistoryView ahv;

    @BindView(R.id.rootView)
    FrameLayout rootOfXML;

    @BindView(R.id.toolbar_home)
    Toolbar toolbarHomeWithPic;

    @BindView(R.id.tv_home)
    TextView homeToolbarTitle;

    @BindView(R.id.badge_instantAppointment)
    TextView badgeInstant;

    @BindView(R.id.badge_findADoctor)
    TextView badgeFindDoctor;

    @BindView(R.id.chatIcon)
    ImageView chatIcon;

    private NavController navController;

    private FindDoctorVM model;

    private View rootView;
    private NavGraphUtils navUtils;

    private Drawer drawerResult;
    private Bundle bundle;

    int noOfFreeCall, noOfCompletedCalls = 0,pendingCalls=0;
    private boolean showBadge = false;

    public DashboardFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = ViewModelProviders.of(baseActivity).get(FindDoctorVM.class);
        initMe();


    }



    private void initMe(){
        if(!PrefsHelper.isOnPlan()) {
            getDisposer().add(
                    baseActivity.RXAPI.checkFreeCall().subscribe(this::checkFreeCall)
            );
        }

        handleBackPress();

        navController = Navigation.findNavController(rootView);

        ((HomeScreenActivity) baseActivity).initOld();
        init_drawer(baseActivity);

        String partOfProject = PrefsHelper.get(Utils.getApp()).getString(Constants.KEY_PART_OF_PROJECT, "")
                .replaceAll("^\"|\"$", "");


        if (partOfProject.equals("alfalah")) {
            toolbarHomeWithPic.setBackgroundColor(getResources().getColor(R.color.bank_alfalah_text_color));
        }

        navUtils = ((HomeScreenActivity) baseActivity).navUtils;


        chatIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 1/0;
//                Intercom.client().displayConversationsList();

            }
        });

        lytInstantDoctor.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                        R.id.action_dashboardFragment_to_instantAppointmentFragment,
                        null
                )
        );
        lytLabs.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                        DashboardFragmentDirections
                                .actionDashboardFragmentToMedicinesInfoFragment("")
                                .setIsFromLab(true)
                )
        );
        lytMedicines.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                        DashboardFragmentDirections
                                .actionDashboardFragmentToMedicinesInfoFragment("")
                                .setIsFromLab(false)
                )
        );
        lytDoctors.setOnClickListener(v ->
                navController.navigate(DashboardFragmentDirections
                    .actionDashboardFragmentToFindDoctorFragment()
                        .setNoOfFreeCalls(noOfFreeCall)
                        .setShowBadge(showBadge)
        ));
//        lytDoctors.setOnClickListener(
//                Navigation.createNavigateOnClickListener(
//                        R.id.action_dashboardFragment_to_findDoctorFragment,
//                        null
//                )
//        );
        showNameAndPic();


    }


    private void checkFreeCall(FreeCallModel freeCall){
        if(freeCall.getSuccess()){
            noOfFreeCall = LocalUtils.getOr(freeCall.getData().getFreeCalls(),0);
            noOfCompletedCalls = LocalUtils.getOr(freeCall.getData().getCompletedCalls(),0);
            pendingCalls = LocalUtils.getOr(freeCall.getData().getPendingCalls(),0);
            init_drawer(baseActivity);

            if(noOfCompletedCalls==1){
                GenApiLogger.fireUsedFreeCall(baseActivity,"used_free_call");
            }

            if(noOfFreeCall-noOfCompletedCalls > 0){
                if (pendingCalls < noOfFreeCall){
                    if (noOfCompletedCalls <= 0 && noOfFreeCall > 0){
                        badgeFindDoctor.setText(noOfFreeCall + "");
                        badgeFindDoctor.setVisibility(View.VISIBLE);
                        badgeInstant.setText(noOfFreeCall + "");
                        badgeInstant.setVisibility(View.VISIBLE);
                        showBadge = true;
                    }
                    else{
                        badgeInstant.setVisibility(View.INVISIBLE);
                        badgeFindDoctor.setVisibility(View.INVISIBLE);
                        showBadge = false;
                    }
                }
                else{
                    showBadge = false;
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        ahv.clearMe();
        super.onDestroyView();
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

    @Override
    public void onItemClick(Appointment type, int position) {
    }

    @SuppressLint("CheckResult")
    public void showNameAndPic() {

        if (MyApp.get() != null && baseActivity.userData != null) {
            String photoURL = baseActivity.userData.getPhoto();

            Glide.with(this)
                    .load(photoURL)
                    .apply(RequestOptions.circleCropTransform())
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .into(ivUserPic);

            setToolbarProfilePic(photoURL, v -> {
                navController.navigate(R.id.editProfileFragment);
            });
            txtName.setText(String.format("Welcome %s %s", baseActivity.userData.getFirstName(), baseActivity.userData.getLastName()));
        }
    }

    public void setToolbarProfilePic(String picURL, View.OnClickListener profilePicClick) {
        Glide.with(this)
                .load(picURL)
                .error(R.drawable.profile_placeholder)
                .placeholder(R.drawable.profile_placeholder)
                .into(profilePicIV);
        ClickUtils.applySingleDebouncing(profilePicIV, profilePicClick);
        //profilePicIV.setOnClickListener(profilePicClick);
    }

    public void init_drawer(Activity context) {
        //new DrawerBuilder().withActivity(this).build();
        //
        // Create the AccountHeader

        setUpDrawer();

//        AccountHeader headerResult = new AccountHeaderBuilder().withActivity(HomeScreenActivity.this).withSelectionListEnabledForSingleProfile(false)
//               .addProfiles(new ProfileDrawerItem().withName("").withTextColor(Color.parseColor("#044c63"))
//                       .withIcon(""))
//                .build();

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(baseActivity)
                .withSelectionListEnabledForSingleProfile(false)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName(baseActivity.userData.getFirstName()+ " " + baseActivity.userData.getLastName())
                                .withTextColor(Color.parseColor("#044c63"))
                                .withIcon(baseActivity.userData.getPhoto())
                )
                .build();



        BadgeStyle mBadgeStyle = new BadgeStyle()
                .withColor(ContextCompat.getColor(context, R.color.colorRed))
                .withCornersDp(16)
                .withTextColor(ContextCompat.getColor(context, R.color.white));


        //
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem();
        item1.withName("Notifications");
        item1.withIcon(R.drawable.ic_notifications);
        item1.withTextColor(Color.parseColor("#044c63"));
        if (PrefsHelper.getNotificationCount()>0) {
            item1.withBadge("" + PrefsHelper.getNotificationCount());
            item1.withBadgeStyle(mBadgeStyle);
        }

        PrimaryDrawerItem item2 = new PrimaryDrawerItem();
        item2.withName("My Appointments");
        item2.withIcon(R.drawable.ic_my_appointments);
        item2.withTextColor(Color.parseColor("#044c63"));
        if (PrefsHelper.getAppointmentCount()>0) {
            item2.withBadge("" + PrefsHelper.getAppointmentCount());
            item2.withBadgeStyle(mBadgeStyle);
        }

        PrimaryDrawerItem myClaims = new PrimaryDrawerItem();
        myClaims.withName("My Claims");
        myClaims.withIcon(R.drawable.ic_refund);
        myClaims.withTextColor(Color.parseColor("#044c63"));


        PrimaryDrawerItem item3 = new PrimaryDrawerItem();
        item3.withName("My Lab Reports");
        item3.withIcon(R.drawable.ic_order_lab_tests);
        item3.withTextColor(Color.parseColor("#044c63"));

        PrimaryDrawerItem item4 = new PrimaryDrawerItem();
        item4.withName("My Medicine Orders");
        item4.withIcon(R.drawable.ic_shop_for_meds);
        item4.withTextColor(Color.parseColor("#044c63"));

        PrimaryDrawerItem item5 = new PrimaryDrawerItem();
        item5.withName("My Medical Records");
        item5.withIcon(R.drawable.ic_my_medical_records);
        item5.withTextColor(Color.parseColor("#044c63"));

//        PrimaryDrawerItem item6 = new PrimaryDrawerItem();
//        item6.withName("My Doctors");
//        item6.withIcon(R.drawable.ic_my_doctors);
//        item6.withTextColor(Color.parseColor("#044c63"));

//        PrimaryDrawerItem item7 = new PrimaryDrawerItem();
//        item7.withName("Consultations");
//        item7.withIcon(R.drawable.ic_consultations);
//        item7.withTextColor(Color.parseColor("#044c63"));

        PrimaryDrawerItem item8 = new PrimaryDrawerItem();
        item8.withName("My Family");
        item8.withIcon(R.drawable.ic_my_family);
        item8.withTextColor(Color.parseColor("#044c63"));

        PrimaryDrawerItem item9 = new PrimaryDrawerItem();
        item9.withName("My Subscriptions");
        item9.withIcon(R.drawable.ic_subscription);
        item9.withTextColor(Color.parseColor("#044c63"));

        PrimaryDrawerItem item10 = new PrimaryDrawerItem();
        item10.withName("Settings");
        item10.withIcon(R.drawable.ic_settings);
        item10.withTextColor(Color.parseColor("#044c63"));

        PrimaryDrawerItem item11 = new PrimaryDrawerItem();
        item11.withName("Logout");
        item11.withIcon(R.drawable.ic_logout);
        item11.withTextColor(Color.parseColor("#044c63"));

        PrimaryDrawerItem item12 = new PrimaryDrawerItem();
        item12.withName("\t\tApp Version " + BuildConfig.VERSION_NAME + (BuildConfig.DEBUG ? "-debug" : "-live"));
        item12.withTextColor(Color.parseColor("#808080"));

        ArrayList<IDrawerItem> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);
        if (PrefsHelper.getPolicies().size() > 0 && PrefsHelper.isOnPlan()) {
            items.add(myClaims);
        }
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item8);
        items.add(item9);
        items.add(new DividerDrawerItem());
        items.add(item10);
        items.add(item11);
        items.add(item12);

        IDrawerItem[] arraysItems = items.toArray(new IDrawerItem[0]);


        //create the drawer and remember the `Drawer` result object
        drawerResult = new DrawerBuilder()
                .withActivity(context)
                .withToolbar(toolbarHomeWithPic)
                .withAccountHeader(headerResult)
                .addDrawerItems(arraysItems)
                .withHasStableIds(true)
                .withDisplayBelowStatusBar(false)
                .withCloseOnClick(true)
                .withActionBarDrawerToggleAnimated(true)
//                .withTranslucentStatusBar(true)
//                .withFullscreen(true)
                .withSelectedItem(-1)
//                .withSavedInstance(saveInsBundle)
                .withTranslucentNavigationBar(true)
                .withRootView(rootOfXML) // this is working but status bar overlap
                .withActionBarDrawerToggle(true)
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        ((HomeScreenActivity) baseActivity).hideNavBar();
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        ((HomeScreenActivity) baseActivity).showNavBar();
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        ((HomeScreenActivity) baseActivity).hideNavBar();
                    }
                })
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    // do something with the clicked item :D
                    clearApiStack();


                    if (arraysItems[position - 1].equals(myClaims)) {
                        navController.navigate(R.id.myClaimsFragment);
                    } else if (arraysItems[position - 1].equals(item1)) {
                        navController.navigate(R.id.NotificationsFragment);
                    } else if (arraysItems[position - 1].equals(item2)) {
                        navController.navigate(R.id.myAppointmentsFragment);
                    } else if (arraysItems[position - 1].equals(item3)) {
                        navController.navigate(
                                DashboardFragmentDirections
                                        .actionDashboardFragmentToMedicinesInfoFragment("My Lab Reports")
                        );
                    } else if (arraysItems[position - 1].equals(item4)) {
                        navController.navigate(
                                DashboardFragmentDirections
                                        .actionDashboardFragmentToMedicinesInfoFragment("My Medicines Orders")
                        );
                    } else if (arraysItems[position - 1].equals(item5)) {
                        navController.navigate(
                                DashboardFragmentDirections
                                        .actionDashboardFragmentToMedicinesInfoFragment("My medical Records")
                        );
                    } else if (arraysItems[position - 1].equals(item8)) {
                        navController.navigate(R.id.dependentFragment);

                    } else if (arraysItems[position - 1].equals(item9)) {
                        navController.navigate(R.id.planSelectionFragment);

                    } else if (arraysItems[position - 1].equals(item10)) {
                        navController.navigate(R.id.appSettingsFragment);

                    } else if (arraysItems[position - 1].equals(item11)) {
                        signOutServiceCall();
                    }
                    return false;
                }).buildForFragment();


        drawerResult.getDrawerLayout().setFitsSystemWindows(true);
        drawerResult.getSlider().setFitsSystemWindows(true);


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void setUpDrawer() {

        //initialize and create the image loader logic
        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                Glide.with(baseActivity)
                        .load(uri)
                        .placeholder(placeholder)
                        .into(imageView);
//                ImageLoader.getInstance().displayImage(uri.getPath(),imageView);
            }

            @Override
            public void cancel(ImageView imageView) {
                Glide.with(baseActivity).clear(imageView);
//                imageView.setImageResource(0);
            }

            @Override
            public Drawable placeholder(Context ctx, String tag) {
                //define different placeholders for different imageView targets
                //default tags are accessible via the DrawerImageLoader.Tags
                //custom ones can be checked via string. see the CustomUrlBasePrimaryDrawerItem LINE 111
                if (DrawerImageLoader.Tags.PROFILE.name().equals(tag)) {
                    return DrawerUIUtils.getPlaceHolder(ctx);
                } else if (DrawerImageLoader.Tags.ACCOUNT_HEADER.name().equals(tag)) {
                    return ContextCompat.getDrawable(Utils.getApp(), R.drawable.profile_placeholder);
                } else if ("customUrlItem".equals(tag)) {
                    return ContextCompat.getDrawable(Utils.getApp(), R.drawable.profile_placeholder);
                }

                //we use the default one for
                //DrawerImageLoader.Tags.PROFILE_DRAWER_ITEM.name()

                return super.placeholder(ctx);
            }
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            if(!drawer.isDrawerOpen(GravityCompat.END)) {
//                drawer.openDrawer(GravityCompat.END, true);
//            }else{
//                drawer.openDrawer(GravityCompat.START, true);
//            }
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void signOutServiceCall() {
        getDisposer().add(
                LocalUtils.getFirebaseToken()
                        .flatMap(v -> baseActivity.RXAPI.signOut(v))
                        .subscribe(doctorDetail -> {
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


    public void showHideHomeToolbar(boolean show) {
        homeToolbarTitle.setText("Home");
        toolbarHomeWithPic.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setToolbarTitle(String title) {
        homeToolbarTitle.setText(title);
    }

    @Override
    public void onPause() {
        if (drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        }
        super.onPause();
    }

//    @Override
//    public void onResume() {
//        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
//        super.onResume();
//    }
}