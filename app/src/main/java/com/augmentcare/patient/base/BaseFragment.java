package com.augmentcare.patient.base;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.fragments.SplashFragment;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;

import io.reactivex.disposables.CompositeDisposable;


public class BaseFragment extends Fragment {
    protected BaseActivity baseActivity;
    public CompositeDisposable COMPOSITE_DISPOSE;
//    public final VolleyAPI VOLLEYAPI = new VolleyAPI();


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        baseActivity.clearApiStack();
    }

    public void clearApiStack() {
        getDisposer().clear();
    }

    public CompositeDisposable getDisposer() {
        if (COMPOSITE_DISPOSE == null) {
            COMPOSITE_DISPOSE = new CompositeDisposable();
        }
        return COMPOSITE_DISPOSE;
    }

    public void getUserInfo(OnValueGot<UserDataLogin> got) {
        baseActivity.getUserInfo(got);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        baseActivity = (BaseActivity) getActivity();
        init_me();
    }

    private void init_me(){
        if(!(this instanceof SplashFragment)){
            getUserInfo(userData->{
                baseActivity.userData = userData;
            });
        }
    }

    public void setUp_loading(){

        baseActivity.RXAPI.setApiStatusChange(state -> {
            try {
                switch (state) {
                    case LOADING:
                        baseActivity.showLoader();
                        break;
                    case COMPLETE:
                    case ERROR:
                    case IDLE:
                        baseActivity.stopLoader();
                        break;
                }
            } catch (Exception e) {
                LogUtils.e(e);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        if (baseActivity instanceof BaseActivity) {
            try {
                baseActivity.setupUI(getView(),false);
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
        super.onStart();
    }

//    /**
//     * Could handle back press.
//     * @return true if back press was handled
//     */
//    public boolean onBackPressed() {
//        return false;
//    }

    @Override
    public void onDestroyView() {
        try {
            clearApiStack();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroyView();
    }

    protected void safeNavigateTo(OnValueGot<NavController> got){
        NavController navController = NavHostFragment.findNavController(this);
        got.gotIt(navController);
    }
    @Override
    public void onDetach() {
        super.onDetach();
//        try {
//            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
//            childFragmentManager.setAccessible(true);
//            childFragmentManager.set(this, null);
//        }catch(Exception e){
//            e.printStackTrace();
//        }

    }

    public void setBackPress(boolean showDialog) {
        // This callback will only be called when MyFragment is at least Started.

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                if (showDialog) {
                    ViewUtils.showConfirmDialog(baseActivity, "Exit?", "Are you sure you want to exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            if (which == AlertDialog.BUTTON_POSITIVE) {
                                ActivityUtils.finishAllActivities();
                            }
                        }
                    });
                } else {
                    ActivityUtils.finishAllActivities();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        // The callback can be enabled or disabled here or in handleOnBackPressed()
    }

    public void setBackPress(boolean showDialog,Runnable onBackPress) {
        // This callback will only be called when MyFragment is at least Started.

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                if (showDialog) {
                    ViewUtils.showConfirmDialog(baseActivity, "Exit?", "Are you sure you want to exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            if (which == AlertDialog.BUTTON_POSITIVE) {
                                onBackPress.run();
                            }
                        }
                    });
                } else {
                    onBackPress.run();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        // The callback can be enabled or disabled here or in handleOnBackPressed()
    }

    /*public void setFont(View view) {
        //((BaseActivity)baseActivity).setFont(view);
	}*/


}