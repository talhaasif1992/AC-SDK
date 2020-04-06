package com.augmentcare.patient.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;

import io.reactivex.disposables.CompositeDisposable;

public class BaseDialogFragment extends DialogFragment {

    protected BaseActivity baseActivity;
    public CompositeDisposable COMPOSITE_DISPOSE;
    protected boolean CLEAR_NAV_STACK = true;


    public CompositeDisposable getDisposer() {
        if (COMPOSITE_DISPOSE == null) {
            COMPOSITE_DISPOSE = new CompositeDisposable();
        }
        return COMPOSITE_DISPOSE;
    }

    protected void safeNavigateTo(OnValueGot<NavController> got){
        NavController navController = NavHostFragment.findNavController(this);
        got.gotIt(navController);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        baseActivity = (BaseActivity) getActivity();
        initMe();
    }

    private void initMe() {
        getUserInfo(userData->{
            baseActivity.userData = userData;
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        baseActivity.clearApiStack();
    }

    public void clearApiStack() {
        getDisposer().clear();
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

    @Override
    public void show(@NonNull FragmentManager manager, String tag) {
        if(!isShowing()) {
            try {
                FragmentTransaction ft = manager.beginTransaction();
                ft.add(this, tag);
                ft.commitAllowingStateLoss();
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
    }

    public boolean isShowing() {
        return getDialog() != null
                && getDialog().isShowing()
                && !isRemoving();
    }

    @Override
    public void onDestroyView() {
        clearApiStack();
        super.onDestroyView();
//        if(CLEAR_NAV_STACK)
//            safeNavigateTo(n -> {});
    }

    @Override
    public void onDetach() {
        super.onDetach();

//        try {
//            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
//            childFragmentManager.setAccessible(true);
//            childFragmentManager.set(this, null);
//
//        } catch (NoSuchFieldException e) {
//            LogUtils.e(e);
//        } catch (IllegalAccessException e) {
//            LogUtils.e(e);
//        } catch(Exception e){
//            LogUtils.e(e);
//        }
    }

    public void safelyDismiss(){
        try {
            dismiss();
        } catch (Exception e) {
            LogUtils.e(e);
            dismissAllowingStateLoss();
        }
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

    public void getUserInfo(OnValueGot<UserDataLogin> got) {
        baseActivity.getUserInfo(got);
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